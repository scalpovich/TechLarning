package com.mastercard.pts.integrated.issuing.steps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.configuration.LinuxBox;
import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePlan;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.utils.FileCreation;
import com.mastercard.pts.integrated.issuing.utils.LinuxUtils;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;

@Component
public class BatchSteps {

	private static final String DEFAULT_TRAILER = "TR\\d{8}";

	private static final String DEFAULT_HEADER = "[\\w ]{32}\\d{6}";
	
	private static final Logger logger = LoggerFactory.getLogger(BatchSteps.class);
	
	@Autowired
	private KeyValueProvider provider;

	@Autowired
	private Path tempDirectory;

	@Autowired
	private LinuxBox linuxBox;

	@Autowired
	private TestContext context;

	@When("embossing file batch was generated in correct format")
	@Then("embossing file batch was generated in correct format")
	public void  embossingFileWasGeneratedSuccessfully() {
		MiscUtils.reportToConsole("******** Embossing File Start ***** " );
		DevicePlan tempdevicePlan = context.get(ContextConstants.DEVICE_PLAN);
		try {
			File batchFile =linuxBox.downloadFileThroughSCPByPartialFileName(tempdevicePlan.getDevicePlanCode(), tempDirectory.toString(), "DEVICE","proc");		
			String[] fileData = LinuxUtils.getCardNumberAndExpiryDate(batchFile);
			MiscUtils.reportToConsole("File Data : " + fileData);
			Device device = context.get(ContextConstants.DEVICE);
			if(device.getDeviceType1().toLowerCase().contains(ConstantData.MSR_CARD))
			{
				device.setDeviceNumber(fileData[0]);
				device.setCvv2Data(fileData[2]);
				device.setCvvData(fileData[3]);
				
				logger.info("******** setDeviceNumber " + " : " +  fileData[0] + " - "  + "   setCvv2Data " + " : " +  fileData[2] + " - "  + " setCvvData  " + " : " +  fileData[3]);
			}
			else
			{
				device.setDeviceNumber(fileData[0]);
				device.setCvv2Data(fileData[2]);
				device.setCvvData(fileData[3]);
				device.setIcvvData(fileData[4]);		
				device.setPvkiData(fileData[5]);				
				logger.info("******** setDeviceNumber " + " : " +  fileData[0] + " - "  + "   setCvv2Data " + " : " +  fileData[2] + " - "  + " setCvvData  " + " : " +  fileData[3] + " - "  + " setIcvvData " + " : " +  fileData[4] + "  ***** ");
			}
			//for format of date to be passed is YYMM
			String tempDate = fileData[1].substring(fileData[1].length()-2) + fileData[1].substring(0, 2);
			device.setExpirationDate(tempDate);
			logger.info("Expiration Data :  {} ", tempDate );
			MiscUtils.reportToConsole("Expiration Data :  " + tempDate );
			MiscUtils.reportToConsole("******** Embossing File Completed ***** " );

		} catch (Exception e) {
			MiscUtils.reportToConsole("embossingFile Exception :  " + e.toString());
			throw MiscUtils.propagate(e);
		}
	}
	
	@When("user sets invalid cvv/ccv2/icvv to device")
	@Then("user sets invalid cvv/ccv2/icvv to device")
	public void  userSetInvaliCVVCVV2ICVV() {
		MiscUtils.reportToConsole("******** setting invalid CVV/CVV2/ICVV ***** " );
		try {
			
			Device device = context.get(ContextConstants.DEVICE);
	
				device.setCvv2Data(ConstantData.INVALID_CVV2);
				device.setCvvData(ConstantData.INVALID_CVV);
				device.setIcvvData(ConstantData.INVALID_ICVV);		
				device.setPvkiData(ConstantData.INVALID_PVKI);				


		} catch (Exception e) {
			MiscUtils.reportToConsole("embossingFile Exception :  " + e.toString());
			throw MiscUtils.propagate(e);
		}
	}
	
	
	@When("Pin Offset file batch was generated successfully")
	@Then("Pin Offset file batch was generated successfully")
	public void getPinFileData() {
		MiscUtils.reportToConsole("******** Pin Offset Start ***** ");
		String[] values = null;
		DevicePlan tempdevice = context.get(ContextConstants.DEVICE_PLAN);
		File batchFile = linuxBox.downloadFileThroughSCPByPartialFileName(tempdevice.getDevicePlanCode(),tempDirectory.toString(), "PIN_PROD","proc");
		Device device = context.get(ContextConstants.DEVICE);
		try (Scanner scanner = new Scanner(batchFile)) {
			while (scanner.hasNext()) {
				values = scanner.nextLine().split(">");
			}

			if (values != null) {
				device.setPinOffset(values[0]);
				logger.info("Pin Offset :  {}", values[0]);
			}
			scanner.close(); 
			context.put("PIN_OFFSET_FILE", batchFile.toString());
			// renaming file name as sometimes the embosing file name is also same
			MiscUtils.renamePinFile(batchFile.toString());
			MiscUtils.reportToConsole("******** Pin Offset Completed ***** ");
		} catch (NullPointerException | FileNotFoundException e) {
			MiscUtils.reportToConsole("getPinFileData Exception :  " + e.toString());
			if (e.getLocalizedMessage().contains("NullPointerException")) {
				device.setPinOffset("pin not retrieved");
				MiscUtils.reportToConsole("Pin Offset :  " + "pin not retrieved");
			}
			throw MiscUtils.propagate(e);
		}
	}
	
	@When("Pin Offset file was updated with $type pin acknowledgement")
	@Then("Pin Offset file was updated with $type pin acknowledgement")
	public void updatePinOffsetFileWithPinAcknowledgement(String acknowledgementType) throws IOException 
	{
	
		String batchFile = context.get("PIN_OFFSET_FILE") + "_PinFile";
		//String batchFile = "C:\\Users\\e084930\\AppData\\Local\\Temp\\20180919_IssuingTests_7158600152725784983\\19092018110088CTA5050PQT7686A2181A22222_PinFile";
		String ackIndicator = "";
		if(acknowledgementType.equalsIgnoreCase("positive"))
			ackIndicator = "Y";
		else
			ackIndicator = "N";
		
		String wholeDataToAppend = "  " + ackIndicator + StringUtils.rightPad(DateUtils.getDateddMMyyyy(), 208, "0");
		FileCreation.appendContentsToFile(batchFile,wholeDataToAppend);
		
		logger.info("Changing Pin Offset File to Original Name");
		MiscUtils.changePinFileToOriginalName(batchFile, context.get("PIN_OFFSET_FILE"));
		logger.info("Pin Offset File Name Successfully Changed");
	}
	
	
	@SuppressWarnings("unused")
	private String getHeaderPattern() {
		return provider.getString("BATCH_HEADER_PATTERN", DEFAULT_HEADER);
	}

	@SuppressWarnings("unused")
	private String getTrailerPattern() {
		return provider.getString(" BATCH_TRAILER_PATTERN", DEFAULT_TRAILER);
	}

}
