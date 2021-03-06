package com.mastercard.pts.integrated.issuing.workflows.customer.dispute;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.configuration.LinuxBox;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ProcessBatches;
import com.mastercard.pts.integrated.issuing.domain.customer.dispute.ChargeBack;
import com.mastercard.pts.integrated.issuing.domain.customer.dispute.ChargeBackReversal;
import com.mastercard.pts.integrated.issuing.domain.customer.dispute.DisputeHistory;
import com.mastercard.pts.integrated.issuing.domain.customer.dispute.RetrievalRequest;
import com.mastercard.pts.integrated.issuing.domain.customer.dispute.SecondChargeBack;
import com.mastercard.pts.integrated.issuing.pages.PageObjectFactory;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.ProcessBatchesPage;
import com.mastercard.pts.integrated.issuing.pages.customer.dispute.ChargeBackCancellationPage;
import com.mastercard.pts.integrated.issuing.pages.customer.dispute.ChargeBackNewPage;
import com.mastercard.pts.integrated.issuing.pages.customer.dispute.ChargeBackReversalPage;
import com.mastercard.pts.integrated.issuing.pages.customer.dispute.DisputeHistoryPage;
import com.mastercard.pts.integrated.issuing.pages.customer.dispute.RetrivalRequestPage;
import com.mastercard.pts.integrated.issuing.pages.customer.dispute.RetrivalResponsePage;
import com.mastercard.pts.integrated.issuing.pages.customer.dispute.SecondChargeBackNewPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.DBUtility;
import com.mastercard.pts.integrated.issuing.utils.SQLQueriesConstants;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.pts.integrated.issuing.workflows.customer.transaction.TransactionWorkflow;

@Workflow
public class DisputeWorkflow extends SimulatorUtilities {

	@Autowired
	private Navigator navigator;
	
	@Autowired
	private LinuxBox linuxBox;

	@Autowired
	private DBUtility dbUtils;

	@Autowired
	TransactionWorkflow transactionWorkFlow;

	private static final Logger logger = Logger.getLogger(PageObjectFactory.class);

	public String getArnFromDb(String bankCode) {
		String query = SQLQueriesConstants.FETCH_ARN_QUERY.replaceFirst("BANKCODE", bankCode);
		return dbUtils.getSingleRecordColumnValueFromDB(query, "MICROFILM_REF_NUMBER");
	}

	public String getEventTriggerFromDb(String bankCode) {
		String query = SQLQueriesConstants.FETCH_TRIGGER_QUERY.replaceFirst("BANKCODE", bankCode);
		return dbUtils.getSingleRecordColumnValueFromDB(query, "EVT_JOB_ID");
	}

	public void createRetrievalRequest(RetrievalRequest rr) {
		RetrivalRequestPage page = navigator.navigateToPage(RetrivalRequestPage.class);
		page.searchByArn(rr.getArn());
		page.validateTransactionAndSubmitRetrivalRequest(rr);
	}

	public void createChargeBackRequest(ChargeBack cb) {
		ChargeBackNewPage page = navigator.navigateToPage(ChargeBackNewPage.class);		
		page.searchByArn(cb.getArn());
		page.requestChargeBack(cb);
	}
	
	public void createSecondChargeBack(SecondChargeBack sb)
	{
	   SecondChargeBackNewPage page = navigator.navigateToPage(SecondChargeBackNewPage.class);
	   page.searchByArn(sb.getArn());
	   page.triggerSecondChargeBack(sb);
	}

	public void createChargeBackReversal(ChargeBackReversal cb) {
		ChargeBackReversalPage page = navigator.navigateToPage(ChargeBackReversalPage.class);
		page.searchByArn(cb.getArn());
		page.triggerChargeBackReversal(cb);
	}

	public boolean validateDisputeHistory(DisputeHistory dh) {
		DisputeHistoryPage page = navigator.navigateToPage(DisputeHistoryPage.class);
		page.searchDisputeHistoryRecord(dh);
		String expectedDisputeType = "Retrieval Request";
		String expectedTransactionType = "Retrieval Request";
		boolean retrivalRequestFlag = page.validateHistory(expectedDisputeType);
		boolean chargeBackFlag = page.validateHistory(expectedTransactionType);
		logger.info("Expected Dispute Type Label ==> " + expectedDisputeType);
		logger.info("Expected Transaction Type Label ==> " + expectedTransactionType);
		if (retrivalRequestFlag && chargeBackFlag)
			return true;
		return false;
	}

	public void uploadRetResponse() {
		RetrivalResponsePage page = navigator.navigateToPage(RetrivalResponsePage.class);
		page.updateRetrievalResponse();

	}

	public void downLoadIPMOutgoing() {
		linuxBox.download("/IPM_OUTGOING/PROC", System.getProperty("user.home"));

	}

	public void uploadIpmFile() {
		String filePath = System.getProperty("user.dir") + "src//main/resources/uploadIPM";
		linuxBox.upload(filePath, "/IPM_INCOMING/INPUT");

	}

	public void uploadBatch(ProcessBatches batch) {
		ProcessBatchesPage page = navigator.navigateToPage(ProcessBatchesPage.class);
		page.processUploadBatch(batch);
	}
	
	public void cancelChargeBackRequst(RetrievalRequest cb) {
		ChargeBackCancellationPage page = navigator.navigateToPage(ChargeBackCancellationPage.class);
		page.searchByArn(cb.getArn());
	}
}
