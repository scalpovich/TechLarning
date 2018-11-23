package com.mastercard.pts.integrated.issuing.steps;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.configuration.LinuxBox;
import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.DeviceType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePlan;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.LinuxUtils;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DeviceDetailsFlows;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.ReportVerificationWorkflow;

@Component
public class BatchSteps {

	private static final String DEFAULT_TRAILER = "TR\\d{8}";

	private static final String DEFAULT_HEADER = "[\\w ]{32}\\d{6}";
	
	private static final int PHOTO_REFERENCE_NUMBER_POSITION = 29;
	
	private static final Logger logger = LoggerFactory.getLogger(BatchSteps.class);

	@Autowired
	private KeyValueProvider provider;

	@Autowired
	private Path tempDirectory;
	
	private File batchFile;
	
	@Autowired
	private ReportVerificationWorkflow reportVerificationWorkFlow;

	@Autowired
	DeviceDetailsFlows flow; 
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
			if(device.getDeviceType1().toLowerCase().contains(ConstantData.MSR_CARD)||device.getDeviceType1().toLowerCase().contains(ConstantData.NFC_MSR_CARD))
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

	@Given("User Download and Verify PDF File for LVC Card")
	@Then("User Download and Verify PDF File for LVC Card")
	public void pdfFileGetsDownloadedForLVCCard() {
		MiscUtils.reportToConsole("******** PDF File Download Start ***** ");
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			DateFormat dateFromatNew = new SimpleDateFormat("ddMMyyyy");
			Date date = new Date();
			String localDate = dateFormat.format(date).toString();
			String pdfPassword = dateFromatNew.format(date).toString().substring(0, 4);
			batchFile = linuxBox.downloadFileThroughSCPByPartialFileName(localDate.substring(0, 6), tempDirectory.toString(), "VIRTUAL_DEVICE_PRODUCTION", "proc");
			logger.info("Local Path of Folder: {}"+tempDirectory.toString());
			File[] newPDFfILE = getLastFileName(tempDirectory.toString());
			String absolutePathofPDF = tempDirectory.toString()+"\\"+newPDFfILE[0].getName();
			logger.info("Absolute Path of PDF File: {}"+absolutePathofPDF);
			reportVerificationWorkFlow.verificationOfPDFFileForLVCCard(absolutePathofPDF, pdfPassword);

		} catch (Exception e) {
			MiscUtils.reportToConsole("embossingFile Exception :  " + e.toString());
			throw MiscUtils.propagate(e);
		}
	}

	public static File[] getLastFileName(String filePath) {		
		File f = new File(filePath);
		File[] files = f.listFiles();
		Arrays.sort(files,LastModifiedFileComparator.LASTMODIFIED_REVERSE);
		logger.info("Latest Downloaded File Name " + files[0].getName());
		return files;
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
		
	@SuppressWarnings("unused")
	private String getHeaderPattern() {
		return provider.getString("BATCH_HEADER_PATTERN", DEFAULT_HEADER);
	}

	@SuppressWarnings("unused")
	private String getTrailerPattern() {
		return provider.getString(" BATCH_TRAILER_PATTERN", DEFAULT_TRAILER);
	}

}
