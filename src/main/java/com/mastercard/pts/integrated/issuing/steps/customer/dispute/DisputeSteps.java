package com.mastercard.pts.integrated.issuing.steps.customer.dispute;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.math.BigDecimal;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.BatchProcessWorkflow;
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
	
	
	@When("Get ARN number from database")
	public void whenGetARNNumberFromDatabase(){
		String arn=disputeWorkflow.getArnFromDb(Institution.createWithProvider(provider).getCode());
		assertFalse("no data arn available in database",arn == null);
		context.put(ConstantData.ARN_NUMBER,arn);
	}
	
	@When("a retrival request is created using ARN Number")
	public void whenARetrivalRequestIsCreatedUsingARNNumber(){
		RetrievalRequest rr=RetrievalRequest.createWithProvider(provider);
		rr.setArn(context.get(ConstantData.ARN_NUMBER));
	 	disputeWorkflow.createRetrievalRequest(rr);
	}
	
	@When("Charge back is created for a transaction")
	public void whenChargeBackIsCreatedForATransaction(){
		ChargeBack cb=ChargeBack.createWithProvider(provider);
		cb.setArn(context.get(ConstantData.ARN_NUMBER));
		disputeWorkflow.createChargeBackRequest(cb);
	}
	
	@When("Charge back reversal is created for a transaction")
	public void whenChargeBackReversalIsCreatedForATransaction(){
		ChargeBackReversal cb=ChargeBackReversal.createWithProvider(provider);
		cb.setArn(context.get(ConstantData.ARN_NUMBER));
		disputeWorkflow.createChargeBackReversal(cb);
	}
	
	@When("Downlod the IPM file")
	public void whenDownlodTheIPMFile(){
		ProcessBatches batch=new ProcessBatches();
		batch.setBatchType("DOWNLOAD [D]");
		batch.setBatchName("Generate IPM File [IPM_OUTGOING]");
		batchProcessWorkflow.processDownloadBatch(batch);
	}

	@Then("verify for the status in dispute history")
	public void whenVerifyForTheStatusInDisputeHistory(){
		DisputeHistory dh=DisputeHistory.getDisputeHistory();
		dh.setArn(context.get(ConstantData.ARN_NUMBER));
		assertTrue("dispute process needs to be recorded in dispute history",disputeWorkflow.validateDisputeHistory(dh));
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