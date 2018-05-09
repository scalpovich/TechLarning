package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.base.Throwables;
import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ProcessBatches;
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
		ProcessBatchesPage processBatch = navigator.navigateToPage(ProcessBatchesPage.class);
		processBatch.processSystemInternalProcessingBatch(batch.get(1));
	}

	public String runPreClearingBatch(ProcessBatches batch) {
		ProcessBatchesPage processBatch = navigator.navigateToPage(ProcessBatchesPage.class);
		return processBatch.processSystemInternalProcessingBatch(batch);
	}

	public boolean verifyReportGeneration() {
		TransactionReportsPage page = navigator.navigateToPage(TransactionReportsPage.class);
		int fileCountBeforeReportGeneration = checkDownLoadedFilesCount();
		page.generateTransactionAuthReport();
		int fileCountAfterReportGeneration = waitForReportToDownLoad(fileCountBeforeReportGeneration);
		return (fileCountAfterReportGeneration - fileCountBeforeReportGeneration == 1) ? true : false;
	}

	public List<String> verifyAuthReport(String fileName,String key) {
		TransactionReportsPage page = navigator.navigateToPage(TransactionReportsPage.class);
		int fileCountBeforeReportGeneration = checkDownLoadedFilesCount();
		deleteExistingAuthorizationFilesFromSystem(fileName);
		page.generateTransactionAuthReport();
		int fileCountAfterReportGeneration = waitForReportToDownLoad(fileCountBeforeReportGeneration);
		return getReportContent(fileName,key);
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

	public String getFileName() {
		String downLoadPath = System.getProperty("user.home") + "\\Downloads";
		File f = new File(downLoadPath);
		File[] files = f.listFiles();
		Arrays.sort(files,LastModifiedFileComparator.LASTMODIFIED_REVERSE);
		logger.info("Latest Downloaded File Name " + files[0].getName());
		return files[0].getName();
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

	public List<String> getReportContent(String fileName,String key) {
		PDFUtils pdfutils=new PDFUtils();
		List<String> records = pdfutils.getContentRow(PDFUtils.getuserDownloadPath() + "\\"+fileName, key);
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

}