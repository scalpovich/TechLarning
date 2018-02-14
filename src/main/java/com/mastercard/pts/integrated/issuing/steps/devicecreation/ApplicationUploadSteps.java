package com.mastercard.pts.integrated.issuing.steps.devicecreation;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceProductionBatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PinGenerationBatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PreProductionBatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ProcessBatches;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.SearchApplicationDetails;
import com.mastercard.pts.integrated.issuing.utils.FileCreation;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.BatchProcessFlows;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.ProcessBatchesFlows;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.SearchApplicationDetailsFlows;

@Component
public class ApplicationUploadSteps {
	
	@Autowired
	private FileCreation fileCreation;
	
	@Autowired
	private ProcessBatches processBatch;
	
	@Autowired
	private SearchApplicationDetailsFlows search;
	
	@Autowired
	private BatchProcessFlows batchProcessingFlows;
	
	public SearchApplicationDetails searchDomain;
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
	
	@When("user creates $application_upload_file batch file and uploads it on server for $customerType")
	public void createFileForApplicationUpload(@Named("application_upload_file") String batchName,@Named("customerType") String customerType) throws Exception{	
		 String fileName=fileCreation.createApplicationUploadFile(program.getInstitute(),customerType);
		processBatch.setJoBID(processBatchesFlows.processUploadBatches(batchName, fileName));
			//CustomUtils.ThreadDotSleep(8000);
		Assert.assertTrue(processBatchesFlows.verifyFileProcessFlowsUpload(processBatch, fileName));
		}
	
	@Then("The file will process the records successfully if all the all the business mandatory field are configured in file")
	public void verifyApplicationFileUpload(){
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
	
	@Then("$type processes deviceproduction batch using new Device")
	@When("$type processes deviceproduction batch using new Device")
	public void whenProcessesDeviceproductionBatchForDevice(String type) {
		DeviceProductionBatch batch = new DeviceProductionBatch();
		batch.setProductType(ProductType.fromShortName(type));
		batchProcessFlows.processDeviceProductionBatchNewDevice(batch);
	}
	
	@Then("$type processes pinProduction batch using new Application")
	@When("$type processes pinProduction batch using new Application")
	public void whenProcessesPinproductionBatchForNewApplication(String type) {
		PinGenerationBatch batch = new PinGenerationBatch();
		batch.setProductType(ProductType.fromShortName(type));
		batchProcessFlows.processPinProductionBatchNewApplication(batch);
	}
	
	
	@Then("$type processes pinProduction batch using new Device")
	@When("$type processes pinProduction batch using new Device")
	public void whenProcessesPinproductionBatchForDevice(String type) {
		PinGenerationBatch batch = new PinGenerationBatch();
		batch.setProductType(ProductType.fromShortName(type));
		batchProcessFlows.processPinProductionBatchNewDevice(batch);
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
		MiscUtils.reportToConsole("device production Batch: {}",preProductionBatch.getBatchNumber());
		batchProcessFlows.processDeviceProductionBatch(batch);
	}
	
	@Then("All processes $type device production batch")
	@When("All processes $type device production batch")
	public void whenProcessesDeviceProductionBatchForAll(String type) {
		DeviceProductionBatch batch = new DeviceProductionBatch();
		batch.setProductType(ProductType.fromShortName(type));
		batch.setBatchNumber(preProductionBatch.getBatchNumber());
		MiscUtils.reportToConsole("device production Batch: {}",preProductionBatch.getBatchNumber());
		batchProcessFlows.processDeviceProductionBatchAll(batch);
	}
}