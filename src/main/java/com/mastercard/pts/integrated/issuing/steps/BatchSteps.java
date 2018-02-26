package com.mastercard.pts.integrated.issuing.steps;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Scanner;

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
import com.mastercard.pts.integrated.issuing.utils.LinuxUtils;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

@Component
public class BatchSteps {

	/*private static final String DEFAULT_EMBOSSING_LINE = "(?<deviceNumber> {3}\\d{16}|\\d{19}):(?<expiryDate>\\d{4}):(?<serviceCode>\\d{3})(?<pvki>\\d)(?<pvv>\\d{4}| {4})"
			+"\\?(?<cvv>\\d{3}| {3})(?<icv>\\d{3}| {3}):(?<cvv2>\\d{3}| {3})\\?(?<city>.{50})(?<state>.{50}):(?<country>.{50})(?<addressLine1>.{50})\\|(?<cardPackID>.{24}).*";
*/
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
		DevicePlan tempdevicePlan = context.get(ContextConstants.DEVICE_PLAN);
		try {
			File batchFile = linuxBox.downloadByLookUpForPartialFileName(tempdevicePlan.getDevicePlanCode(), tempDirectory.toString(), "Device");
			String[] fileData = LinuxUtils.getCardNumberAndExpiryDate(batchFile);
			
			
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
	//			device.setPvvData(fileData[3]);
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

		} catch (Exception e) {
			MiscUtils.reportToConsole("embossingFile Exception :  " + e.toString());
			logger.info(ConstantData.EXCEPTION +" {} " +  e.getMessage());
			throw MiscUtils.propagate(e);
		}
	}
 
	
	
	@When("Pin Offset file batch was generated successfully")
	@Then("Pin Offset file batch was generated successfully")
	public void  getPinFileData()
	{
		MiscUtils.reportToConsole("******** Pin Offset Start ***** " );
		String[] values = null;
		DevicePlan tempdevice = context.get(ContextConstants.DEVICE_PLAN);
		File batchFile = linuxBox.downloadByLookUpForPartialFileName(tempdevice.getDevicePlanCode(), tempDirectory.toString(), "Pin");
		Device device = context.get(ContextConstants.DEVICE);
		try(Scanner scanner = new Scanner(batchFile)){
			while(scanner.hasNext()){
				values = scanner.nextLine().split(">");
			}

			device.setPinOffset(values[0]);
			MiscUtils.reportToConsole("Pin Offset :  " + values[0] );
			scanner.close();
			//			reanming file name as sometimes the embosing file name is also same
			MiscUtils.renamePinFile(batchFile.toString());
		}
		catch(NullPointerException | FileNotFoundException e)
		{
			if(e.getLocalizedMessage().contains("NullPointerException"))
			{
				device.setPinOffset("pin not retrieved");
				MiscUtils.reportToConsole("Pin Offset :  " + "pin not retrieved");
			}
			MiscUtils.reportToConsole("getPinFileData Exception :  " + e.toString());
			logger.info(ConstantData.EXCEPTION +" {} " +  e.getMessage());
			throw MiscUtils.propagate(e);
		}
	}

	private String getHeaderPattern() {
		return provider.getString("BATCH_HEADER_PATTERN", DEFAULT_HEADER);
	}

	private String getTrailerPattern() {
		return provider.getString(" BATCH_TRAILER_PATTERN", DEFAULT_TRAILER);
	}

}
