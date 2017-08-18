package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.base.Throwables;
import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ProcessBatches;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.ProcessBatchesPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.TransactionReportsPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class ReconciliationWorkFlow {

	@Autowired
	private Navigator navigator;

	@Autowired
	private TestContext context;

	public void runPreClearingAndPrepaidEodBatch(List<ProcessBatches> batch) {
		while (runPreClearingBatch(batch.get(0))!=null) {
			ProcessBatchesPage processBatch = navigator
					.navigateToPage(ProcessBatchesPage.class);
			processBatch.processSystemInternalProcessingBatch(batch.get(1));
		}
	}

	public String runPreClearingBatch(ProcessBatches batch)
	{
		ProcessBatchesPage processBatch = navigator
				.navigateToPage(ProcessBatchesPage.class);
		return processBatch
				.processSystemInternalProcessingBatch(batch);
	}
	
	public boolean verifyReportGeneration() {
		TransactionReportsPage page = navigator
				.navigateToPage(TransactionReportsPage.class);
		int fileCountBeforeReportGeneration = checkDownLoadedFilesCount();
		page.generateProgramWiseBalanceSummaryReport();
		int fileCountAfterReportGeneration = waitForReportToDownLoad(fileCountBeforeReportGeneration);
		return (fileCountAfterReportGeneration
				- fileCountBeforeReportGeneration == 1) ? true : false;
	}

	public int checkDownLoadedFilesCount() {
		int fileCount = 0;
		String downLoadPath = System.getProperty("user.home") + "\\Downloads";
		File f = new File(downLoadPath);
		File[] files = f.listFiles();

		if (files != null)
			for (int i = 0; i < files.length; i++) {
				fileCount++;
			}
		return fileCount;
	}

	public int waitForReportToDownLoad(int fileCountBeforeReportGeneration) {
		int fileCountAfterDownload = checkDownLoadedFilesCount();
		int count = 0;
		while (count < 5
				&& fileCountAfterDownload == fileCountBeforeReportGeneration) {
			try {
				Thread.sleep(1000);
				fileCountAfterDownload=checkDownLoadedFilesCount();
				count++;
			} catch (Exception e) {

				throw Throwables.propagate(e);
			}
		}
		 return fileCountAfterDownload;
	} 
       
}