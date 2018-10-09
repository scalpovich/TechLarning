package com.mastercard.pts.integrated.issuing.steps.devicecreation;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceProductionBatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PinGenerationBatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PreProductionBatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ProcessBatches;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.SearchApplicationDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.processingcenter.Institution;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.FileCreation;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.BatchProcessFlows;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.ProcessBatchesFlows;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.SearchApplicationDetailsFlows;

@Component
public class ApplicationUploadSteps {

	@Autowired
	private FileCreation fileCreation;

	@Autowired
	private ProcessBatches processBatch;

	private String jobId;
	
	@Autowired
	private SearchApplicationDetailsFlows search;

	@Autowired
	private BatchProcessFlows batchProcessingFlows;	
	
	@Autowired
	private ProcessBatchesFlows processBatchesFlows;
	
	@Autowired
	private PreProductionBatch preProductionBatch;
	
	@Autowired
	private BatchProcessFlows batchProcessFlows;
	
	@Autowired
	Program program;
	
	@Autowired
	private Device device;

	@Autowired
	private DataProvider provider;
	
	@Autowired
	TestContext context;
	
	private String ExpectedRejectedTxt = "Reuter reference number is Business mandatory field.";
	
	public SearchApplicationDetails searchDomain;

	@When("user creates $application_upload_file batch file and upload it on server for $customerType for $cardType")
	public void createFileForApplicationUpload(@Named("application_upload_file") String batchName, @Named("customerType") String customerType, @Named("cardType") String cardType) throws Exception {
		String fileName = "";
		if (cardType.equalsIgnoreCase("prepaid")) {
			fileName = fileCreation.createApplicationUploadFile(Institution.createWithProvider(provider).getCode(), customerType, cardType);
		} else if (cardType.equalsIgnoreCase("credit")) {
			fileName = fileCreation.createApplicationUploadFile(Institution.createWithProvider(provider).getCodeCredit(), customerType, cardType);
		} else if (cardType.contains("Static"))
		{
			fileName=fileCreation.createApplicationUploadForFileStaticVirtualCard(program.getInstitute(), customerType);
		}
		processBatch.setJoBID(processBatchesFlows.processUploadBatches(batchName, fileName));
		SimulatorUtilities.wait(5000);
		Assert.assertTrue(processBatchesFlows.verifyFileProcessFlowsUpload(processBatch, fileName));
	}
	
	@When("user creates $application_upload_file batch file with duplicate data and upload it on server for $customerType for $cardType")
	public void createFileForApplicationUploadWithDuplicateData(@Named("application_upload_file") String batchName, @Named("customerType") String customerType, @Named("cardType") String cardType) throws Exception {
		String fileName = "";
		if (ProductType.PREPAID.toUpperCase().contains(cardType.toUpperCase())) {
			fileName = fileCreation.createApplicationUploadFileWithDuplicateData(Institution.createWithProvider(provider).getCode(), customerType, cardType);
		} else if (ProductType.CREDIT.toUpperCase().contains(cardType.toUpperCase())) {
			fileName = fileCreation.createApplicationUploadFileWithDuplicateData(Institution.createWithProvider(provider).getCodeCredit(), customerType, cardType);
		} else if (cardType.contains("Static"))
		{
			fileName=fileCreation.createApplicationUploadForFileStaticVirtualCard(program.getInstitute(), customerType);
		}
		processBatch.setJoBID(processBatchesFlows.processUploadBatches(batchName, fileName));
		SimulatorUtilities.wait(5000);
		Assert.assertTrue(processBatchesFlows.verifyProcessUploadBatch(processBatch, fileName));
		
	}

	@When("Application Upload rejected due to missing Business Mandatory feild")
	public void applicationUploadRejectedDueToMissingBMF(){
		String rejectedDueToMissingMandatory = context.get(ContextConstants.REJECTED_FILE_UPLOAD);
		Assert.assertEquals("Reuter reference number is Business mandatory field.",rejectedDueToMissingMandatory,ExpectedRejectedTxt);
	}
	
	@When("user creates $application_upload_file batch file and uploads it on server for $customerType")
	public void createFileForApplicationUpload(@Named("application_upload_file") String batchName, @Named("customerType") String customerType) throws Exception {
		String fileName = fileCreation.createApplicationUploadForFile(program.getInstitute(), customerType);
		processBatch.setJoBID(processBatchesFlows.processUploadBatches(batchName, fileName));
		CustomUtils.ThreadDotSleep(5000);
		Assert.assertTrue(processBatchesFlows.verifyFileProcessFlowsUpload(processBatch, fileName));
	}

	@Then("The file will process the records successfully if all the all the business mandatory field are configured in file")
	public void verifyApplicationFileUpload() {
		searchDomain = searchDomain.getSearchApplicationData();
		search.verifyApplicationUploadSuccess(searchDomain);
	}

	@When("processes $type pre-production batch")
	public void whenProcessesPreproductionBatchForPrepaid(String type) {
		preProductionBatch.setProductType(ProductType.fromShortName(type));
		preProductionBatch.setJobID(processBatch.getJoBID());
		batchProcessFlows.processPreProductionBatch(preProductionBatch);
	}

	@Then("$type processes pre-production batch using new Device")
	@When("$type processes pre-production batch using new Device")
	public void whenProcessesPreproductionBatchForDevice(String type) {
		preProductionBatch.setProductType(ProductType.fromShortName(type));
		batchProcessFlows.processPreProductionBatchNewDevice(preProductionBatch);
	}

	@Then("$type processes pre-production batch using new Application")
	@When("$type processes pre-production batch using new Application")
	public void whenProcessesPreproductionBatchForDeviceUsingApplication(String type) {
		preProductionBatch.setProductType(ProductType.fromShortName(type));
		batchProcessFlows.processPreProductionBatchNewApplication(preProductionBatch);
	}
	
	@Then("$type processes pre-production batch using new Application for fileUpload in Bulk")
	@When("$type processes pre-production batch using new Application for fileUpload in Bulk")
	public void whenProcessesPreproductionBatchForDeviceUsingApplicationForFileUpload(String type) {
		preProductionBatch.setProductType(ProductType.fromShortName(type));
		batchProcessFlows.processPreProductionBatchNewApplicationFileUpload(preProductionBatch);
	}
	
	@Then("$type processes pre-production batch using new Application for fileUpload in Bulk from jobid")
	@When("$type processes pre-production batch using new Application for fileUpload in Bulk from jobid")
	public void whenProcessesPreproductionBatchForDeviceUsingApplicationForFileUploadForPrepaid(String type) {
		preProductionBatch.setProductType(ProductType.fromShortName(type));
		batchProcessFlows.processPreProductionBatchNewApplicationFileUploadForPrepaid(preProductionBatch);
	}

	@Then("$type processes deviceproduction batch using new Device")
	@When("$type processes deviceproduction batch using new Device")
	public void whenProcessesDeviceproductionBatchForDevice(String type) {
		DeviceProductionBatch batch = new DeviceProductionBatch();
		batch.setProductType(ProductType.fromShortName(type));
		batchProcessFlows.processDeviceProductionBatchNewDevice(batch);
	}
	
	
	@Then("$type processes deviceproduction batch using new Device for Supplementary")
	@When("$type processes deviceproduction batch using new Device for Supplementary")
	public void whenProcessesDeviceproductionBatchForDeviceSupplementary(String type) {
		DeviceProductionBatch batch = new DeviceProductionBatch();
		batch.setProductType(ProductType.fromShortName(type));
		batchProcessFlows.processDeviceProductionBatchNewDeviceSupplementary(batch);
	}

	@Then("$type processes pinProduction batch using new Application")
	@When("$type processes pinProduction batch using new Application")
	public void whenProcessesPinproductionBatchForNewApplication(String type) {
		PinGenerationBatch batch = new PinGenerationBatch();
		batch.setProductType(ProductType.fromShortName(type));
		batchProcessFlows.processPinProductionBatchNewApplication(batch);
	}
	
	@Then("$type processes pingeneration batch using new Device for Supplementary")
	@When("$type processes pingeneration batch using new Device for Supplementary")
	public void whenProcessesPinGenerationBatchUsingNewDeviceForSupplementry(String type) {
		PinGenerationBatch batch = new PinGenerationBatch();
		batch.setProductType(ProductType.fromShortName(type));
		batchProcessFlows.processPinGenerationBatch(batch);
	}

	@Then("$type processes pinProduction batch using new Device")
	@When("$type processes pinProduction batch using new Device")
	public void whenProcessesPinproductionBatchForDevice(String type) {
		PinGenerationBatch batch = new PinGenerationBatch();
		batch.setProductType(ProductType.fromShortName(type));
		batchProcessFlows.processPinProductionBatchNewDevice(batch);
	}
	
	@Then("$type processes pinProduction batch using new Device for Supplementary")
	@When("$type processes pinProduction batch using new Device for Supplementary")
	public void whenProcessesPinproductionBatchForCredit(String type) {
		PinGenerationBatch batch = new PinGenerationBatch();
		batch.setProductType(ProductType.fromShortName(type));
		batchProcessFlows.processPinGenerationBatchForSupplementary(batch);;
	}

	@Then("$type processes deviceproduction batch using new Application")
	@When("$type processes deviceproduction batch using new Application")
	public void whenProcessesDeviceproductionBatchForNewApplication(String type) {
		DeviceProductionBatch batch = new DeviceProductionBatch();
		batch.setProductType(ProductType.fromShortName(type));
		batchProcessFlows.processDeviceProductionBatchNewApplication(batch);
	}

	@Then("processes $type device production batch")
	@When("processes $type device production batch")
	public void whenProcessesDeviceProductionBatch(String type) {
		DeviceProductionBatch batch = new DeviceProductionBatch();
		batch.setProductType(ProductType.fromShortName(type));
		batch.setBatchNumber(preProductionBatch.getBatchNumber());
		MiscUtils.reportToConsole("device production Batch: {}", preProductionBatch.getBatchNumber());
		batchProcessFlows.processDeviceProductionBatch(batch);
	}

	@Then("All processes $type device production batch")
	@When("All processes $type device production batch")
	public void whenProcessesDeviceProductionBatchForAll(String type) {
		DeviceProductionBatch batch = new DeviceProductionBatch();
		batch.setProductType(ProductType.fromShortName(type));
		batch.setBatchNumber(preProductionBatch.getBatchNumber());
		MiscUtils.reportToConsole("device production Batch: {}", preProductionBatch.getBatchNumber());
		batchProcessFlows.processDeviceProductionBatchAll(batch);
	}

	@Then("processes $type pin production batch")
	@When("processes $type pin production batch")
	public void whenProcessesPinProductionBatch(String type) {
		PinGenerationBatch batch = new PinGenerationBatch();
		batch.setProductType(ProductType.fromShortName(type));
		batch.setBatchNumber(preProductionBatch.getBatchNumber());
		MiscUtils.reportToConsole("pin production Batch: {}", preProductionBatch.getBatchNumber());
		batchProcessFlows.processPinGenerationBatch(batch);
	}
	
	@Then("All processes $type device production batch for fileUpload in Bulk")
	@When("All processes $type device production batch for fileUpload in Bulk")
	public void whenProcessesDeviceProductionBatchForAllForFileUpload(String type) {
		DeviceProductionBatch batch = new DeviceProductionBatch();
		batch.setProductType(ProductType.fromShortName(type));
		batchProcessFlows.processDeviceProductionBatchAllForFileUpload(batch);
	}
	
	@Then("All processes $type device production batch for fileUpload in Bulk from jobid")
	@When("All processes $type device production batch for fileUpload in Bulk from jobid")
	public void whenProcessesDeviceProductionBatchForAllForFileUploadForPrepaid(String type) {
		DeviceProductionBatch batch = new DeviceProductionBatch();
		batch.setProductType(ProductType.fromShortName(type));
		batchProcessFlows.processDeviceProductionBatchAllForFileUploadForPrepaid(batch);
	}
	
	@Then("All processes $type pin production batch for fileUpload in Bulk")
	@When("All processes $type pin production batch for fileUpload in Bulk")
	public void whenProcessesPinProductionBatchForAllForFileUpload(String type) {
		PinGenerationBatch batch = new PinGenerationBatch();
		batch.setProductType(ProductType.fromShortName(type));
		batchProcessFlows.processPinProductionBatchAllForFileUpload(batch);
	}
}