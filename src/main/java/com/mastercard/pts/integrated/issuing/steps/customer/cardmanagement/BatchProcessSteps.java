
package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.configuration.LinuxBox;
import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BulkDeviceGenerationBatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BulkDeviceRequest;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ClientDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceProductionBatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.GenericReport;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PinGenerationBatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PreProductionBatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ProcessBatches;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.pages.collect.administration.AdministrationHomePage;
import com.mastercard.pts.integrated.issuing.steps.UserManagementSteps;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.BatchProcessWorkflow;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.LoadFromFileUploadWorkflow;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.ReportVerificationWorkflow;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.ProcessBatchesFlows;

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
	private ProcessBatchesFlows processBatchesFlows;

	@Autowired
	private ReportVerificationWorkflow reportVerificationWorkflow;
	
	@Autowired
	private LinuxBox linuxBox;
	
	@Autowired
	private Path tempDirectory;
	
	private String batchNumber;
	
	private String jobId;

	private static final String INSTITUTION_CODE = "INSTITUTION_CODE";
	
	private static final Logger logger = LoggerFactory.getLogger(BatchProcessSteps.class);
	
	private File batchFile;

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
		ProcessBatches batch =  new ProcessBatches();
		batch.setProductType(ProductType.fromShortName(type));
		batch.setBatchName(batchName);
		assertEquals("SUCCESS [2]", batchProcessWorkflow.processSystemInternalProcessingBatchWithoutDateCheck(batch));			

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
	
	@Then("verify statement file is successfully downloaded")
	@When("verify statement file is successfully downloaded")
	public void verifyStatementFileSuccessfullyGenerated(){
		Device device =  context.get(ContextConstants.DEVICE);
		String institutionCode = System.getProperty(ContextConstants.INST_PROPERTY).substring(System.getProperty(ContextConstants.INST_PROPERTY).indexOf('[')+1, System.getProperty(ContextConstants.INST_PROPERTY).length() - 1);
		String partialFileName = "STMT_" +institutionCode  +"_"+ device.getProgramCode() + "_" + device.getClientCode() +"_"+ context.get(ContextConstants.STATEMENT_TO_DATE) + context.get(ContextConstants.STATEMENT_FROM_DATE) + "_" + device.getDeviceNumber().substring(device.getDeviceNumber().length() - 4); 
		logger.info("File Name :{} ",partialFileName);
	    batchFile = linuxBox.downloadFileThroughSCPByPartialFileName(partialFileName, tempDirectory.toString(), "STATEMENT_DOWNLOAD","proc");
     	assertNotNull("Statement file is successfully donwloaded :  "+batchFile.getAbsolutePath(),batchFile);			
		context.put(ContextConstants.DEVICE,device);	
	}
	
	@When("validate the statement with parameters:$parameterTable")
	@Then("validate the statement with parameters:$parameterTable")
	public void validateStatement(ExamplesTable parameterTable) {
		Device device = context.get(ContextConstants.DEVICE);
		HashMap<String , String> helpdeskValues = context.get(ContextConstants.HELPDESK_VALUES);		
		helpdeskValues.put(ContextConstants.STATEMENT_DATE, context.get(ContextConstants.STATEMENT_DATE));
		GenericReport report = GenericReport.createWithProvider(provider);			
		String dateOfBirth = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH).format(device.getClientDetails().getBirthDate());
		report.setPassword(device.getClientDetails().getFirstName().substring(0,4)+""+dateOfBirth.substring(0, dateOfBirth.length()-5).replaceAll("/", ""));				
		for (int row = 0; row < parameterTable.getRows().size(); row++) {
			String parameter = parameterTable.getRow(row).get(parameterTable.getHeaders().get(0));			
			if(parameter.equals(ContextConstants.CREDIT_CARD_NUMBER_HEADER_IN_STATEMENT))
				report.getFieldToValidate().put(helpdeskValues.get(ContextConstants.CREDIT_CARD_NUMBER_HEADER_IN_STATEMENT),device.getDeviceNumber());	
			else
				report.getFieldToValidate().put(parameter, helpdeskValues.get(parameter));
		}			
		reportVerificationWorkflow.verifyStatement(report);		
	}

	@When("\"$batchType\" download batch is executed for $type")
	public void whenDownloadBatchIsExecutedForPrepaid(String batchType, String type){
		ProcessBatches batch =  ProcessBatches.createWithProvider(provider);
		batch.setBatchName("Statement Download [STATEMENT_DOWNLOAD]");
		batch.setProductType(ProductType.fromShortName(type));
		batchProcessWorkflow.processDownloadBatch(batch);
	}
	
	@When("cardholder dump download batch is processed for $type")
	public void whenDownloadBatchIsProcessedForCredit(String batchType, String type){
		ProcessBatches batch =  ProcessBatches.createWithProvider(provider);
		batch.setBatchName("Cardholder Dump [CARDHOLDER_DUMP]");
		batch.setExtractType("FULL [F]");
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
		File batchFile = linuxBox.downloadFileThroughSCPByPartialFileName(partialFileName, tempDirectory.toString(), ConstantData.VISA_BASEII_LINUX_DIRECTORY,"proc");
		Assert.assertTrue("Transaction Data Does not match ",batchProcessWorkflow.validateVisaOutGoingFile(batchFile));
	}
	
	@When("user checks for the client photo/flat file batch trace for $batchType batch")
	@Then("user checks for the client photo/flat file batch trace for $batchType batch")
	public void checkBatchTraceForClientPhotoFlatFile(@Named("batchType") String batchType) {		
				
		
		batchProcessWorkflow.verifyBatchTraceAvailability(context.get(ContextConstants.JOB_ID));	
		
	}
	
	@When("process batch for $batchType type and Batch name $batchName")
	@Then("process batch for $batchType type and Batch name $batchName")
	public void submitJobforProcessing(String batchType, String batchName) {
		processBatchesFlows.processDownloadBatches(batchType, batchName);
	}

}
