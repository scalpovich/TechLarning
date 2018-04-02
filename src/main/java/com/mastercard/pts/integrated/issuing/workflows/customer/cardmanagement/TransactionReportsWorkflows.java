package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WebAPIReports;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.TransactionReportsPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class TransactionReportsWorkflows extends ReconciliationWorkFlow {

	@Autowired
	private Navigator navigator;

	public int fileCountBeforeReportGeneration;

	public void generateWebAPIDetailReport(WebAPIReports webapireports) {
		TransactionReportsPage page = navigator.navigateToPage(TransactionReportsPage.class);
		fileCountBeforeReportGeneration = checkDownLoadedFilesCount();
		page.generateWebAPIServiceDetailReport(webapireports);
	}

	public boolean verifyWebAPIReportGeneration() {
		int fileCountAfterReportGeneration = waitForReportToDownLoad(fileCountBeforeReportGeneration);
		return (fileCountAfterReportGeneration - fileCountBeforeReportGeneration == 1) ? true : false;
	}

}
