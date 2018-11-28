package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.base.Throwables;
import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ProcessBatches;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionReports;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.ProcessBatchesPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.TransactionReportsPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.PDFUtils;

@Workflow
public class ReconciliationWorkFlow {

	private static final Logger logger = LoggerFactory.getLogger(TransactionReportsPage.class);

	@Autowired
	private Navigator navigator;

	@Autowired
	private TestContext context;

	public void runPreClearingAndPrepaidEodBatch(List<ProcessBatches> batch) {
		while (runPreClearingBatch(batch.get(0)) != null) {
			ProcessBatchesPage processBatch = navigator.navigateToPage(ProcessBatchesPage.class);
			processBatch.processSystemInternalProcessingBatch(batch.get(1));
		}
	}
	
	public void runPreClearingAndLoyaltyCalcBatch(List<ProcessBatches> batch) {
		if (batch.size() != 0) {
			for (int i = 0; i < batch.size(); i++) {
				ProcessBatchesPage processBatch = navigator.navigateToPage(ProcessBatchesPage.class);
				processBatch.processSystemInternalProcessingBatch(batch.get(i));
			}
		}
	}

	public String runPreClearingBatch(ProcessBatches batch) {
		ProcessBatchesPage processBatch = navigator.navigateToPage(ProcessBatchesPage.class);
		return processBatch.processSystemInternalProcessingBatch(batch);
	}
	
	public String runPostMaintenanceBatch(ProcessBatches batch) {
		ProcessBatchesPage processBatch = navigator.navigateToPage(ProcessBatchesPage.class);
		return processBatch.processSystemInternalProcessingBatchPostMaintenance(batch);
	}
	public boolean verifyReportGeneration() {
		TransactionReportsPage page = navigator.navigateToPage(TransactionReportsPage.class);
		int fileCountBeforeReportGeneration = checkDownLoadedFilesCount();
		page.generateTransactionAuthReport();
		int fileCountAfterReportGeneration = waitForReportToDownLoad(fileCountBeforeReportGeneration);
		return (fileCountAfterReportGeneration - fileCountBeforeReportGeneration == 1) ? true : false;
	}

	public List<String> verifyAuthReport(String fileName,TransactionReports transactionReports) {
		TransactionReportsPage page = navigator.navigateToPage(TransactionReportsPage.class);
		int fileCountBeforeReportGeneration = checkDownLoadedFilesCount();
		deleteExistingAuthorizationFilesFromSystem(fileName);
		page.generateTransactionAuthReport();
		int fileCountAfterReportGeneration = waitForReportToDownLoad(fileCountBeforeReportGeneration);
		return getReportContent(fileName,transactionReports);
		//return (fileCountAfterReportGeneration - fileCountBeforeReportGeneration == 1) ? true : false;
	}
		
	public boolean verifyReportGenerationClearing() {
		TransactionReportsPage page = navigator.navigateToPage(TransactionReportsPage.class);
		int fileCountBeforeReportGeneration = checkDownLoadedFilesCount();
		page.generateTransactionClearingReport();
		int fileCountAfterReportGeneration = waitForReportToDownLoad(fileCountBeforeReportGeneration);
		return (fileCountAfterReportGeneration - fileCountBeforeReportGeneration == 1) ? true : false;
	}

	public boolean verifyReportGenerationRecon() {
		TransactionReportsPage page = navigator.navigateToPage(TransactionReportsPage.class);
		int fileCountBeforeReportGeneration = checkDownLoadedFilesCount();
		logger.info("Number of Files Before Report Generation = {} ", fileCountBeforeReportGeneration);
		page.generateProgramWiseBalanceSummaryReport();
		int fileCountAfterReportGeneration = waitForReportToDownLoad(fileCountBeforeReportGeneration);
		return (fileCountAfterReportGeneration - fileCountBeforeReportGeneration == 1) ? true : false;
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
		while (count < 5 && fileCountAfterDownload == fileCountBeforeReportGeneration) {
			try {
				Thread.sleep(1000);
				fileCountAfterDownload = checkDownLoadedFilesCount();
				count++;
			} catch (Exception e) {

				throw Throwables.propagate(e);
			}
		}
		return fileCountAfterDownload;
	}

	public List<String> getReportContent(String fileName,TransactionReports transactionReports) {
		PDFUtils pdfutils=new PDFUtils();
		List<String> records = pdfutils.getContentRow(PDFUtils.getuserDownloadPath() + "\\"+fileName, transactionReports);
		for(int i=0;i<records.size();i++)
		{
			if (records != null)
				logger.info("Authorization data file content {} ", records.get(i));
		}
		return records;
	}
	public void deleteExistingAuthorizationFilesFromSystem(String authFileName)
	{
		for (File file: new File(PDFUtils.getuserDownloadPath()).listFiles()) {
			if (!file.isDirectory()&& file.getName().startsWith(ConstantData.AUTHORIZATION_REPORT_NAME))   	
				file.delete();
		}
	}
	
	public ProcessBatches runCreditBillingBatch(ProcessBatches batch) {
		ProcessBatchesPage processBatch = navigator.navigateToPage(ProcessBatchesPage.class);
		return processBatch.processCreditBillingBatch(batch);
	}
	
	public String processStatementExtractBatch(ProcessBatches batch) {
		ProcessBatchesPage processBatch = navigator.navigateToPage(ProcessBatchesPage.class);
		return processBatch.processStatementExtractBatch(batch);
	}

}