package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BatchJobHistory;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.BatchJobHistoryPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class BatchJobHistoryFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	public void checkBatchJobHistory(BatchJobHistory batchjobhist) {
		BatchJobHistoryPage batchJobHistoryPage = navigator.navigateToPage(BatchJobHistoryPage.class);
		batchJobHistoryPage.searchBatchJob(batchjobhist);
		batchJobHistoryPage.clickBatchjob(batchjobhist);
	}
	public boolean verifyBatchJobHistoryStatusDisplayed(BatchJobHistory batchjobhist) {
		BatchJobHistoryPage batchJobHistoryPage = navigator.navigateToPage(BatchJobHistoryPage.class);
		return batchJobHistoryPage.checkBatchStatus(batchjobhist);
	}
}
