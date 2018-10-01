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
		if (batchType.equalsIgnoreCase("download")) {
			batchjobhistory.setBatchType("DOWNLOAD [D]");
		}else if (batchType.equalsIgnoreCase("upload")) {
			batchjobhistory.setBatchType("UPLOAD [U]");
		}		
		
		batchjobhistory.setJobIdBatchJobHistory(context.get(ContextConstants.JOB_ID));
		if(batch.equalsIgnoreCase("CLIENT_PHOTO_DOWNLOAD")){
			batchjobhistory.setBatch("Client Photo/Flat File Download Batch [CLIENT_PHOTO_DOWNLOAD]");
		} else if(batch.equalsIgnoreCase("CARDHOLDER_DUMP")) {
			batchjobhistory.setBatch("Cardholder Dump [CARDHOLDER_DUMP]");
		}
		Assert.assertTrue( "Batch job status is not diplayed success",batchjobhistoryflows.verifyBatchJobHistoryStatusDisplayed(batchjobhistory) );
	}
}
