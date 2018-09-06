
package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.nio.file.Path;
import java.time.LocalDate;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.configuration.LinuxBox;
import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BulkDeviceGenerationBatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BulkDeviceRequest;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CutOverProfile;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceProductionBatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PinGenerationBatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PreProductionBatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ProcessBatches;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.BatchProcessWorkflow;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.LoadFromFileUploadWorkflow;

/**
 * @author E071669
 *
 */

@Component
public class BatchProcessSteps {
	
	@Autowired
	private TestContext context;

	@Autowired
	private KeyValueProvider provider;

	@Autowired
	private BatchProcessWorkflow batchProcessWorkflow;

	@Autowired
	private LoadFromFileUploadWorkflow loadFromFileUploadWorkflow;

	@Autowired
	private LinuxBox linuxBox;
	
	@Autowired
	private Path tempDirectory;
	
	private String batchNumber;
	
	private String jobId;

	private static final String INSTITUTION_CODE = "INSTITUTION_CODE";

	@When("user creates a bulk device production request for $type")
	public void whenUserCreatesABulkDeviceProductionRequestForPrepaid(String type){
		BulkDeviceRequest request = BulkDeviceRequest.createWithProvider(provider);
		
		Program program = context.get(ContextConstants.PROGRAM);
		request.setProgram(program.buildDescriptionAndCode());
		request.setProductType(program.getProduct());
		
		DevicePlan devicePlan = context.get(ContextConstants.DEVICE_PLAN);
		request.setDevicePlan(devicePlan.buildDescriptionAndCode());

		batchNumber = batchProcessWorkflow.createBulkDeviceRequest(request);
	}
	
	@When("processes created bulk device generation request for $type")
	public void whenProcessesCreatedBulkDeviceGenerationRequest(String type){
		BulkDeviceGenerationBatch batch = new BulkDeviceGenerationBatch();
		batch.setProductType(ProductType.fromShortName(type));
		batch.setBatchNumber(batchNumber);
		MiscUtils.reportToConsole("bulk device generation Batch: {}", batchNumber);
		batchProcessWorkflow.processBulkDeviceGenerationBatch(batch);
	}
	
	@When("processes pre-production batch for $type")
	public void whenProcessesPreproductionBatchForPrepaid(String type){
		PreProductionBatch batch = new PreProductionBatch();
		batch.setProductType(ProductType.fromShortName(type));
		batch.setBatchNumber(batchNumber);
		MiscUtils.reportToConsole("Pre-Production Batch: {}", batchNumber);
		batchProcessWorkflow.processPreProductionBatch(batch);
	}
	
	@Then("user processes pre-production batch for $type")
	@When("user processes pre-production batch for $type")
	public void whenUserProcessesPreproductionBatchForPrepaid(String type){
		whenProcessesPreproductionBatchForPrepaid(type);
	}
	
	@Then("a new device was created")
	@When("a new device was created")
	@Given("a new device was created")
	public void givenANewDeviceWasCreated() {
		Device device = context.get(ContextConstants.DEVICE);
		batchNumber = device.getBatchNumber();
		assertNotNull("Device Batch Number is not generated", batchNumber);
	}

	@When("processes device production batch for $type")
	public void whenProcessesDeviceProductionBatch(String type){
		DeviceProductionBatch batch = new DeviceProductionBatch();
		batch.setProductType(ProductType.fromShortName(type));
		batch.setBatchNumber(batchNumber);
		MiscUtils.reportToConsole("device production Batch: {}", batchNumber);
		batchProcessWorkflow.processDeviceProductionBatch(batch);
	}
	
	@Then("user processes device production batch for $type")
	@When("user processes device production batch for $type")
	public void whenUserProcessesDeviceProductionBatch(String type){
		whenProcessesDeviceProductionBatch(type);
	}
	
	@When("processes pin generation batch for $type")
	public void whenProcessesPinGenerationBatch(String type){
		PinGenerationBatch batch = new PinGenerationBatch();
		batch.setProductType(ProductType.fromShortName(type));
		batch.setBatchNumber(batchNumber);
		MiscUtils.reportToConsole("pin generation Batch: {}", batchNumber);
		jobId = batchProcessWorkflow.processPinGenerationBatch(batch);
		MiscUtils.reportToConsole("pin generation Job Id: {}", jobId);
	}
	
	@When("new Application processes pin generation batch for $type")
	public void whenProcessesPinGenerationBatchUsingNewApplication(String type){
		PinGenerationBatch batch = new PinGenerationBatch();
		batch.setProductType(ProductType.fromShortName(type));
		String batchNumber=context.get(CreditConstants.NEW_APPLICATION_BATCH);
		batch.setBatchNumber(batchNumber);
		MiscUtils.reportToConsole("pin generation Batch: {}", batchNumber);
		jobId = batchProcessWorkflow.processPinGenerationBatch(batch);
		MiscUtils.reportToConsole("pin generation Job Id: {}", jobId);
	}
	
	@When("user processes pin generation batch for $type")	
	public void whenUserProcessesPinGenerationBatch(String type){
		whenProcessesPinGenerationBatch(type);
	}
	
	@Then("pin offset file is generated sucessfully for prepaid")
	public void thenPinOffsetFileIsGeneratedSucessfullyForPrepaid(){
		assertTrue("Pin generation was successfull", batchProcessWorkflow.searchBatchTraceHistory(jobId));			
	}
	
	@Then("\"$batchName\" batch for $type is successful")
	@When("\"$batchName\" batch for $type is successful")
	public void whenMatchingBatchIsExecuted(String batchName, String type){
		ProcessBatches batch =  new ProcessBatches();;
		batch.setProductType(ProductType.fromShortName(type));
		batch.setBatchName(batchName);
		//batch.setBusinessDate(LocalDate.now().plusDays(1));
		
		assertEquals("SUCCESS [2]", batchProcessWorkflow.processSystemInternalProcessingBatch(batch));			

	}
	
	@Then("file is successfully downloaded is executed for prepaid")
	public void thenFileIsSuccessfullyDownloadedForPrepaid(){
		thenFileIsSuccessfullyDownloaded();
	}

	@Then("file is successfully downloaded")
	public void thenFileIsSuccessfullyDownloaded(){
		String partialFileName = "STMT" + provider.getString(INSTITUTION_CODE) + DateUtils.getDate(); 
		String fileName = "STMT";
		File batchFile = linuxBox.downloadByLookUpForPartialFileName(fileName, tempDirectory.toString(), "STATEMENT_DOWNLOAD");
		assertNotNull(partialFileName + " : Batch file is successfully donwloaded",batchFile);
	}

	@When("\"$batchType\" download batch is executed for $type")
	public void whenDownloadBatchIsExecutedForPrepaid(String batchType, String type){
		ProcessBatches batch =  ProcessBatches.createWithProvider(provider);
		batch.setBatchName("Statement Download [STATEMENT_DOWNLOAD]");
		batch.setProductType(ProductType.fromShortName(type));
		batchProcessWorkflow.processDownloadBatch(batch);
	}
	
	/**
	 * Step Definition for Processing batches
	 * <p>
	 * StoryFile usage : When user runs Process Batches for $batchType for
	 * $batchName file
	 * <p>
	 */
	@When("user process $batchType for $methodToGenerateFile for $batchname file")
	public void runProcessBatches(@Named("batchType") String batchType,@Named("methodToGenerateFile") String methodToGenerateFile,
			@Named("batchname") String batchName) {
		ProcessBatches batch=new ProcessBatches();
		batch.setBatchName(batchName);
		batch.setBatchType(batchType);
		batch.setMethodToGenerateFile(methodToGenerateFile);
		batchProcessWorkflow.processVisaOutgoingBatch(batch);
	}
	/**
	 * Step Definition for Processing batches
	 * <p>
	 * StoryFile usage : When user runs Process Batches for $batchType for
	 * $batchName file
	 * <p>
	 */
	@Then("user validate downloaded DAT file")
	public void validateDownloadedFile() {
		String partialFileName = context.get(ConstantData.VISA_OUT_GOING_FILE_NAME);
		File batchFile = linuxBox.downloadFileThroughSCPByPartialFileName(partialFileName, tempDirectory.toString(), ConstantData.VISA_BASEII_LINUX_DIRECTORY);
		Assert.assertTrue("Transaction Data Does not match ",batchProcessWorkflow.validateVisaOutGoingFile(batchFile));

	}
}
