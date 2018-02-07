package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

	@Then("Statement download batch is available on Batch Job History Page")
	public void statementDownloadBatchIsAvailableOnBatchJobHistoryPage() {
		String[] result = batchJobHistoryWorkflow.verifyTodaysRecordInBatchJobHistory();
		assertThat("Statement Not Downloaded Today!", result[0], is(DateUtils.getLocalDateInYYYYMMDD()));
		assertThat("Statement (Type) Not Downloaded", result[1], is("Statement Download [STATEMENT_DOWNLOAD]"));
	}

	@When("user check for the $productionbatch batch success status for $batchType batch")
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
}
