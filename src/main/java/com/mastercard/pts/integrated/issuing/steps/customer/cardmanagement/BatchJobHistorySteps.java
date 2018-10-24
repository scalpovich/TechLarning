package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BatchJobHistory;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BulkDeviceRequestbatch;
import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.BatchJobHistoryFlows;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.BatchJobHistoryWorkflow;

@Component
public class BatchJobHistorySteps {

	@Autowired
	BatchJobHistoryWorkflow batchJobHistoryWorkflow;

	@Autowired
	BatchJobHistory batchjobhistory;

	@Autowired
	BulkDeviceRequestbatch bulkdevicerequestbatch;

	@Autowired
	BatchJobHistoryFlows batchjobhistoryflows;
	
	@Autowired
	TestContext context;
	
	private static final String BATCH_TYPE_UPLOAD = "UPLOAD [U]";
	private static final String BATCH_TYPE_DOWNLOAD = "DOWNLOAD [D]";

	private static final String CLIENT_PHOTO_FLAT_FILE_DOWNLOAD_BATCH = "Client Photo/Flat File Download Batch [CLIENT_PHOTO_DOWNLOAD]";
	private static final String CARDHOLDER_DUMP_BATCH = "Cardholder Dump [CARDHOLDER_DUMP]";

	@Then("Statement download batch is available on Batch Job History Page")
	public void statementDownloadBatchIsAvailableOnBatchJobHistoryPage() {
		String[] result = batchJobHistoryWorkflow.verifyTodaysRecordInBatchJobHistory();
		assertThat("Statement Not Downloaded Today!", result[0], is(DateUtils.getLocalDateInYYYYMMDD()));
		assertThat("Statement (Type) Not Downloaded", result[1], is("Statement Download [STATEMENT_DOWNLOAD]"));
	}

	@When("user checks for the $productionbatch batch success status for $batchType batch")
	public void checkBatchStatus(@Named("productionbatch") String productionbatch,
			@Named("batchType") String batchType) {
		batchjobhistory.setBatchType(batchType);
		if (productionbatch.equals("Pre-Production")) {
			batchjobhistory.setJobIdBatchJobHistory(bulkdevicerequestbatch.getPreProductionSourceJobid());
		} else {
			batchjobhistory.setJobIdBatchJobHistory(bulkdevicerequestbatch.getJobId());
		}
		batchjobhistoryflows.CheckBatchJobHistory(batchjobhistory);
	}
	
	@When("check status in batch job history for $batchType batch and $batch")
	@Then("check status in batch job history for $batchType batch and $batch")
	public void checkBatchStatusForClientPhotoFlatFile(@Named("batchType") String batchType, @Named("batch") String batch) {		
		if ("download".equalsIgnoreCase(batchType)) {
			batchjobhistory.setBatchType(BATCH_TYPE_DOWNLOAD);
		}else if ("upload".equalsIgnoreCase(batchType)) {
			batchjobhistory.setBatchType(BATCH_TYPE_UPLOAD);
		}		
		
		batchjobhistory.setJobIdBatchJobHistory(context.get(ContextConstants.JOB_ID));
		if("CLIENT_PHOTO_DOWNLOAD".equalsIgnoreCase(batch)){
			batchjobhistory.setBatch(CLIENT_PHOTO_FLAT_FILE_DOWNLOAD_BATCH);
		} else if("CARDHOLDER_DUMP".equalsIgnoreCase(batch)) {
			batchjobhistory.setBatch(CARDHOLDER_DUMP_BATCH);
		}
		Assert.assertTrue( "Batch job status is not diplayed success",batchjobhistoryflows.verifyBatchJobHistoryStatusDisplayed(batchjobhistory) );
	}
}
