package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.configuration.LinuxBox;
import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.AdjustmentTransaction;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.AdjustmentTransactionDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ProcessBatches;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.FileCreation;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.LoadFromFileUploadWorkflow;
import com.mastercard.pts.integrated.issuing.workflows.customer.transaction.TransactionWorkflow;

@Component
public class LoadFromFileUploadSteps {

	@Autowired
	private LoadFromFileUploadWorkflow loadFromFileUploadWorkflow;

	@Autowired
	private TestContext context;

	@Autowired
	private KeyValueProvider provider;

	@Autowired
	private TransactionWorkflow transWorkflow;

	@Autowired
	private LinuxBox linuxBox;
	
	private File notFileName;

	private String jobId;
	
	@When("user processes batch for $type")
	public void whenUserProcessesBatchForPrepaid(String type){
		//since data is constant for this transaction, we do not need this data to go into Excel
		ProcessBatches batch =  ProcessBatches.getBatchData();
        //batch.setBatchName("Load IPM Incoming File [IPM_INCOMING]");		
		batch.setProductType(ProductType.fromShortName(type));
		HashMap<String, String> hm = (HashMap<String, String>) loadFromFileUploadWorkflow.processUploadBatch(batch);
		assertEquals("SUCCESS [2]",hm.get("BatchStatus"));	
		jobId =hm.get("JobId");
	}

	@When("user creates and uploads transaction file")
	public void whenUserCreatesAndUploadsTransactionFile(){
		Device device = context.get(ContextConstants.DEVICE);
		String defaultLine  = FileCreation.createTransactionLine(device.getDeviceNumber(),device.getWalletNumber(), provider);
		FileCreation file = FileCreation.createFile(provider);
		file.setTransactionLine(defaultLine);
		loadFromFileUploadWorkflow.createFileForUpload(file);	
		}

	@Given("user performs adjustment transaction")
	@When("user performs adjustment transaction")
	@Then("user performs adjustment transaction")
	public void whenUserPerformsAdjustmentTransaction(){
		Device device = context.get(ContextConstants.DEVICE);
		AdjustmentTransaction transaction = AdjustmentTransaction.createWithProvider(provider);
		AdjustmentTransactionDetails details = AdjustmentTransactionDetails.createTransactionWithDetails();
		details.setDeviceNumber(device.getDeviceNumber());
		details.setWalletNumber(device.getWalletNumber());
		transaction.getAdjustmentTransactionDetails().add(details);
		loadFromFileUploadWorkflow.createAdjustmentTransaction(transaction);
	}

	@When("user performs adjustment transaction for second wallet")
	public void whenUserPerformsAdjustmentTransactionForAllWallets(){
		Device device = context.get(ContextConstants.DEVICE);
		AdjustmentTransaction transaction = AdjustmentTransaction.createWithProvider(provider);
		AdjustmentTransactionDetails details = AdjustmentTransactionDetails.createTransactionWithDetails();
		details.setDeviceNumber(device.getDeviceNumber());
		details.setWalletNumber(device.getWalletNumber2());
		transaction.getAdjustmentTransactionDetails().add(details);
		loadFromFileUploadWorkflow.createAdjustmentTransaction(transaction);
	}
	
	@Then("user get attached wallet details for device")
	public void getWalletDetailsForDevice(){
		Device device = context.get(ContextConstants.DEVICE);
		List<String> wallets = loadFromFileUploadWorkflow.searchWalletDetailsPage(device);		
		device.setWalletNumber(wallets.get(0));
		device.setNewWalletNumber(wallets.get(1));		
	}

	@Given("in batch trace history transaction is successful")
	@Then("in batch trace history transaction is successful")
	@When("in batch trace history transaction is successful")
	public void thenInBatchTraceHistoryTransactionIsSuccessful(){
		assertTrue("Adjustment transaction was successful", loadFromFileUploadWorkflow.searchBatchTraceHistory());			
	}

	@Then("in batch trace history transaction is successful using job id")
	public void thenInBatchTraceHistoryTransactionIsSuccessfulUsingJobId(){
		assertTrue("Load transaction was successful", loadFromFileUploadWorkflow.searchBatchJobHistory(jobId));			
	}

	@Then("transaction is succesful")
	public void thenTransactionIsSuccesful(){
		Device device = context.get(ContextConstants.DEVICE);
		assertTrue("Adjustment transaction is visible under transactions device", loadFromFileUploadWorkflow.verifyTransactionforDevice(device));
	}
		
	@Given("NOT file is successfully generated")
	@Then("NOT file is successfully generated")
	@When("NOT file is successfully generated")
	public void givenNOTFileIsSuccessfullyGenerated() throws IOException{
		String filePath =  "CEEData.txt";
		String fileData = transWorkflow.getFileData(filePath);
		notFileName = loadFromFileUploadWorkflow.getFileNameFromCEEFile(fileData);
		assertNotNull("IPM fileName is not null", notFileName);
	}
	
	@Given("NOT file is successfully generated for iteration")
	@Then("NOT file is successfully generated for iteration")
	@When("NOT file is successfully generated for iteration")
	public void givenNOTFileIsSuccessfullyGeneratedForIteration() throws IOException{
		String filePath =  "CEEData.txt";
		String fileData = transWorkflow.getFileData(filePath);
		fileData.split(" ");
		notFileName = loadFromFileUploadWorkflow.getFileNameFromCEEFile(fileData);
		assertNotNull("IPM fileName is not null", notFileName);
	}
	
	@When("User uploads the NOT file")
	public void thenUserUploadsTheNOTFile(){
		ProcessBatches batch =  ProcessBatches.getBatchData();
		loadFromFileUploadWorkflow.loadIncomingIPM(notFileName);
		batch.setBatchFileName(notFileName.getName());						
	}
	
	@When("user processes upload batch for $type")
	public void whenUserProcessesUploadBatchForPrepaid(String type){
		ProcessBatches batch =  ProcessBatches.getBatchData();
		batch.setProductType(ProductType.fromShortName(type));
		HashMap<String, String> hm = (HashMap<String, String>) loadFromFileUploadWorkflow.processUploadBatch(batch);
		assertEquals("SUCCESS [2]",hm.get("BatchStatus"));	
		jobId =hm.get("JobId");			

	}
	
	@When("user processes transaction upload batch for $type")
	public void whenUserProcessesTransactionUploadBatchForPrepaid(String type){
		ProcessBatches batch =  ProcessBatches.getBatchData();
        batch.setBatchName("Transaction Upload [TRANSACTION_UPLOAD]");		
		batch.setProductType(ProductType.fromShortName(type));
		HashMap<String, String> hm = (HashMap<String, String>) loadFromFileUploadWorkflow.processUploadBatch(batch);
		assertEquals("SUCCESS [2]",hm.get("BatchStatus"));	
		jobId =hm.get("JobId");			

	}
}