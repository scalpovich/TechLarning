package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ProcessBatches;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.*;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class BatchJobHistoryWorkflow {

	@Autowired
	private Navigator navigator;

	public String[] verifyTodaysRecordInBatchJobHistory() {
		BatchJobHistoryPage page = navigator.navigateToPage(BatchJobHistoryPage.class);
		return page.findRecord();
	}
	
	public ProcessBatches searchRecordByJobIDInBatchJobHistory(ProcessBatches batches) {
		BatchJobHistoryPage page = navigator.navigateToPage(BatchJobHistoryPage.class);
		return page.searchRecord(batches);
	}
}