package com.mastercard.pts.integrated.issuing.steps;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Scanner;

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
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePlan;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.LinuxUtils;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DeviceDetailsFlows;

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
			File batchFile =linuxBox.downloadFileThroughSCPByPartialFileName(tempdevicePlan.getDevicePlanCode(), tempDirectory.toString(), "DEVICE");		
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
	
	@When("photo reference number present at given position in embossing file")
	@Then("photo reference number present at given position in embossing file")
	public void  photoReferenceNumberPresentAtGivenPosition() {
		
		flow.findAndPutDeviceApplicationNumberInContext();
		Device device = context.get(ContextConstants.DEVICE);
		MiscUtils.reportToConsole("******** Embossing File Start ***** " );
		DevicePlan tempdevicePlan = context.get(ContextConstants.DEVICE_PLAN);
		String deviceApplicationNumber = device.getApplicationNumber();
		String photoReferenceNumber = "";
		try {
			File batchFile =linuxBox.downloadFileThroughSCPByPartialFileName(tempdevicePlan.getDevicePlanCode(), tempDirectory.toString(), "DEVICE");		
			photoReferenceNumber = LinuxUtils.getPhotoReferenceNumber(batchFile);
			MiscUtils.reportToConsole("Device Application number :  " + device.getApplicationNumber() );
			MiscUtils.reportToConsole("Photo Reference number :  " + photoReferenceNumber );
			MiscUtils.reportToConsole("Device Application number :  " + device.getApplicationNumber() );			
			MiscUtils.reportToConsole("******** Embossing File Completed ***** " );

		} catch (Exception e) {
			MiscUtils.reportToConsole("embossingFile Exception :  " + e.toString());
			throw MiscUtils.propagate(e);
		}
		Assert.assertTrue(photoReferenceNumber.equals(deviceApplicationNumber));		
	}
	
	@When("photo flat file generated with photo reference number")
	@Then("photo flat file generated with photo reference number")
	public void thenflatFileGeneratedWithPhotoReferenceNumber() {
		
		flow.findAndPutDeviceApplicationNumberInContext();
		Device device = context.get(ContextConstants.DEVICE);
		MiscUtils.reportToConsole("******** Photo Flat File Start ***** " );
		String deviceApplicationNumber = device.getApplicationNumber();
		
		String timestamp = context.get(ContextConstants.CLIENT_PHOTO_BATCH_PROCESS_TIME);
		timestamp = timestamp.substring(0,timestamp.length()-1);
		String partialFileName = "Account_PhotoNonPhoto_"+timestamp;
		
		boolean isPhotoReferencePresentInFlatFile=false;
		try {
			MiscUtils.reportToConsole("Flat file path name :  " + partialFileName);
			
			File batchFile =linuxBox.downloadFileThroughSCPByPartialFileName(partialFileName, tempDirectory.toString(), "CLIENT_PHOTO_BATCH");		
			isPhotoReferencePresentInFlatFile = LinuxUtils.isPhotoReferenceNumberPresentFlatFile(batchFile,deviceApplicationNumber);
			MiscUtils.reportToConsole("Device Application number :  " + deviceApplicationNumber );
			MiscUtils.reportToConsole("******** Photo Flat File Completed ***** " );

		} catch (Exception e) {
			MiscUtils.reportToConsole("embossingFile Exception :  " + e.toString());
			throw MiscUtils.propagate(e);
		}
		Assert.assertTrue(isPhotoReferencePresentInFlatFile);
	}
	
	@When("photo image file generated in JPEG format")
	@Then("photo image file generated in JPEG format")
	public void thenPhotoFileGeneratedInJPEGFormat() {
		flow.findAndPutDeviceApplicationNumberInContext();
		String timestamp = context.get(ContextConstants.CLIENT_PHOTO_BATCH_PROCESS_TIME);
		Device device = context.get(ContextConstants.DEVICE);
		String deviceApplicationNumber = device.getApplicationNumber();
		
		String partialFileName = "Account_PhotoNonPhoto_"+timestamp;
		
		String photoFileName=deviceApplicationNumber+".jpeg";
		File photoJpegFile = null;
		try {
			MiscUtils.reportToConsole("Flat file path name :  " + partialFileName);
			MiscUtils.reportToConsole("Photo file name :  " + photoFileName );		
			photoJpegFile = linuxBox.downloadFileThroughSCPByPartialFileName(photoFileName, tempDirectory.toString(), "CLIENT_PHOTO_BATCH");		
			MiscUtils.reportToConsole("******** Photo Flat File Completed ***** " );

		} catch (Exception e) {
			MiscUtils.reportToConsole("embossingFile Exception :  " + e.toString());
			throw MiscUtils.propagate(e);
		}
		Assert.assertNotNull(photoJpegFile);
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
		File batchFile = linuxBox.downloadFileThroughSCPByPartialFileName(tempdevice.getDevicePlanCode(),
				tempDirectory.toString(), "PIN_PROD");
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
	
	@When("to verify photo reference number is present in card holder dump file")
	@Then("to verify photo reference number is present in card holder dump file")
	public void  cardHolderDumpFileWasGeneratedSuccessfullyForPhotoCard() {
		MiscUtils.reportToConsole("******** Embossing File Start ***** " );
		flow.findAndPutDeviceApplicationNumberInContext();
		try {
			String CSVno = context.get("CSVno");
			File batchFile =linuxBox.downloadFileThroughSCPByPartialFileName(CSVno, tempDirectory.toString(), "CARDHOLDER_DUMP");
			Device device = context.get(ContextConstants.DEVICE);
			boolean flg= LinuxUtils.getPhotoReferenceNumberinDumpFile(batchFile,device.getApplicationNumber());
			Assert.assertTrue("Photo Reference Number is present in Card Holder Dump File",flg);
		}
		catch(Exception e) {}
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
