package com.mastercard.pts.integrated.issuing.steps.customer.dispute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.io.File;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.HashMap;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.configuration.LinuxBox;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ProcessBatches;
import com.mastercard.pts.integrated.issuing.domain.customer.dispute.ChargeBack;
import com.mastercard.pts.integrated.issuing.domain.customer.dispute.ChargeBackReversal;
import com.mastercard.pts.integrated.issuing.domain.customer.dispute.DisputeHistory;
import com.mastercard.pts.integrated.issuing.domain.customer.dispute.RetrievalRequest;
import com.mastercard.pts.integrated.issuing.domain.customer.processingcenter.Institution;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.BatchProcessWorkflow;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.LoadFromFileUploadWorkflow;
import com.mastercard.pts.integrated.issuing.workflows.customer.dispute.DisputeWorkflow;
import com.mastercard.pts.integrated.issuing.workflows.customer.helpdesk.HelpdeskWorkflow;
import com.mastercard.pts.integrated.issuing.workflows.customer.transaction.TransactionWorkflow;

@Component
public class DisputeSteps{
	
	@Autowired
	private TestContext context;

	@Autowired
	private KeyValueProvider keyProvider;
	
	@Autowired
	private DataProvider provider;
	
	@Autowired
	private DisputeWorkflow disputeWorkflow;
	
	@Autowired
	private TransactionWorkflow transactionWorkflow;
	
	@Autowired
	private BatchProcessWorkflow batchProcessWorkflow;
	
	@Autowired
	private HelpdeskWorkflow helpDeskWorkflow;

	@Autowired
	private LoadFromFileUploadWorkflow loadFromFileUploadWorkflow;
	
	@Autowired
	private Path tempDirectory;

	@Autowired
	private LinuxBox linuxBox;

	private String arnNumber;

	private static final Logger logger = LoggerFactory.getLogger(DisputeSteps.class);

	@When("user updates retrieval response")
	public void userUpdatesRetrievalResponse(){
		disputeWorkflow.uploadRetResponse();
	}
		
	@When("Not file is modified")
	public void whenNotFileIsModified() throws AWTException{
		transactionWorkflow.launchWiniumAndSimulator("MCPS");
		transactionWorkflow.loadIpmFile(System.getProperty("user.dir")+"\\src\\main\\resources\\"+"DISPUTES_STORY_NOT_FILE.IPM");
		transactionWorkflow.assignUniqueFileId();
		arnNumber = transactionWorkflow.assignUniqueARN();
		logger.info("ARN number is: "+ arnNumber);
		context.put(ConstantData.ARN_NUMBER, arnNumber);
	}
	
	@When("NOT file is uploaded after modification")
	public void whenItsUploadedAfterModification(){
		File notFile = new File("DISPUTES_STORY_NOT_FILE.IPM");
		loadFromFileUploadWorkflow.loadIncomingIPM(notFile);
		ProcessBatches batch =  ProcessBatches.getBatchData();
		batch.setProductType("Prepaid[P]");
		HashMap<String, String> hm = (HashMap<String, String>) loadFromFileUploadWorkflow.processUploadBatch(batch);
		assertEquals("SUCCESS [2]",hm.get("BatchStatus"));	

	}

	@Then("verify the downloaded IPM file in MCPS")
	public void thenVerifyTheDownloadedIPMFileInMCPS(){
		File batchFile = linuxBox.downloadByLookUpForPartialFileName("121212" + DateUtils.getDate(), tempDirectory.toString(), "IPM_OUTGOING");
		transactionWorkflow.loadDownloadedIpmFileAndProcess(batchFile.toString());
	}

	@When("matching batch is executed")
	public void whenMatchingBatchIsExecuted(){
		ProcessBatches batch =  new ProcessBatches();
		batch.setProductType("Prepaid [P]");
		batch.setBatchName("Matching");
		batchProcessWorkflow.processSystemInternalProcessingMatchingBatch(batch);
	}
	
	@When("Get ARN number from database")
	public void whenGetARNNumberFromDatabase(){
		String arn=disputeWorkflow.getArnFromDb(Institution.createWithProvider(provider).getCode());
		assertFalse("no data arn available in database",arn == null);
		context.put(ConstantData.ARN_NUMBER,arn);
	}
	
	@When("a retrival request is created using ARN Number")
	public void whenARetrivalRequestIsCreatedUsingARNNumber(){
		RetrievalRequest rr = RetrievalRequest.createWithProvider(keyProvider);
		rr.setArn(context.get(ConstantData.ARN_NUMBER));
	 	disputeWorkflow.createRetrievalRequest(rr);
	}
	
	@When("Charge back is created for a transaction")
	public void whenChargeBackIsCreatedForATransaction(){
		ChargeBack cb=ChargeBack.getChargeBack(keyProvider);
		cb.setArn(context.get(ConstantData.ARN_NUMBER));
		disputeWorkflow.createChargeBackRequest(cb);
	}
	
	@When("Charge back reversal is created for a transaction")
	public void whenChargeBackReversalIsCreatedForATransaction(){
		ChargeBackReversal cb=ChargeBackReversal.createWithProvider(provider);
		cb.setArn(context.get(ConstantData.ARN_NUMBER));
		disputeWorkflow.createChargeBackReversal(cb);
	}
	
	@When("Download the IPM file")
	public void whenDownloadTheIPMFile(){
		ProcessBatches batch=new ProcessBatches();
		batch.setBatchType("DOWNLOAD [D]");
		batch.setBatchName("Generate IPM File [IPM_OUTGOING]");
		assertEquals("SUCCESS [2]",batchProcessWorkflow.processIpmDownloadBatch(batch));	

	}

	@Then("verify for the status in dispute history")
	public void whenVerifyForTheStatusInDisputeHistory(){
		DisputeHistory dh=DisputeHistory.getDisputeHistory();
		dh.setArn(context.get(ConstantData.ARN_NUMBER));
		assertTrue("Dispute process status not available in dispute history",disputeWorkflow.validateDisputeHistory(dh));
	}
	
	
	@When("validate the charge back amount credited to the card holder in help desk screen")
	public void givenValidateTheChargeBackAmountCreditedToTheCardHolderInHelpDeskScreen(){
		Device device = new Device();
		device.setDeviceNumber(keyProvider.getString("DEVICE_NUMBER"));
		device.setAppliedForProduct(ProductType.fromShortName("PREPAID"));
		ChargeBack cb=ChargeBack.createWithProvider(provider);
		Assert.assertTrue(helpDeskWorkflow.getWalletBalance(device).subtract(context.get("walletBalanceBeforeChargeback"))== new BigDecimal(cb.getChargeBackAmount()));
	}
	

	@When("Generate outgoing IPM file and check for Message Reversal Indicator,Card Issuer Reference Data")
	public void whenGenerateOutgoingIPMFileAndCheckForMessageReversalIndicatorCardIssuerReferenceData(){
		disputeWorkflow.downLoadIPMOutgoing();
		transactionWorkflow.launchAndConnectToMCPS();
		transactionWorkflow.loadIPMFileIntoMCPS(System.getProperty("user.home")+"\\Downloads\\555777290517144755.ipm");
		transactionWorkflow.verifychargeBackOutgoingMsg();
	}
	
	@When("Upload a representment with the reason code")
	public void whenUploadARepresentmentWithTheReasonCode(){
		
	disputeWorkflow.uploadIpmFile();
	ProcessBatches batch = new ProcessBatches();
	batch.setBatchName("Load IPM Incoming File [IPM_INCOMING]");
	batch.setBatchType("UPLOAD[U]");
	disputeWorkflow.uploadBatch(batch);
	 
	}
	
}