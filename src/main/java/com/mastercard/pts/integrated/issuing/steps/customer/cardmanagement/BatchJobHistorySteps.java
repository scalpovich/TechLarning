package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.jbehave.core.annotations.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.BatchJobHistoryWorkflow;

@Component
public class BatchJobHistorySteps {

	@Autowired
	BatchJobHistoryWorkflow batchJobHistoryWorkflow;

	@Then("Statement download batch is available on Batch Job History Page")
	public void statementDownloadBatchIsAvailableOnBatchJobHistoryPage() {
		String[] result = batchJobHistoryWorkflow.verifyTodaysRecordInBatchJobHistory();
		assertThat("Statement Not Downloaded Today!", result[0] , is(DateUtils.getLocalDateInYYYYMMDD()));
		assertThat("Statement (Type) Not Downloaded", result[1], is("Statement Download [STATEMENT_DOWNLOAD]"));
	}
}
