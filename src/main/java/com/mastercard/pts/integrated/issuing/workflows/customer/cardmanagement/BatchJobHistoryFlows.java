package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import javax.validation.constraints.AssertTrue;

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

	public void CheckBatchJobHistory(BatchJobHistory batchjobhist) {
		BatchJobHistoryPage batchjobhistorypage = navigator.navigateToPage(BatchJobHistoryPage.class);
		batchjobhistorypage.searchBatchJob(batchjobhist);
		batchjobhistorypage.clickBatchjob(batchjobhist);
	}
	
	public void checkBatchStatusInBatchJobHistory(BatchJobHistory batchjobhistory) {
		BatchJobHistoryPage batchJobHistoryPage = navigator.navigateToPage(BatchJobHistoryPage.class);
		boolean flg = batchJobHistoryPage.checkBatchStatus(batchjobhistory);
		System.out.print("Batch Status Success?:");
		System.out.println(flg);
	}
	
	
}
