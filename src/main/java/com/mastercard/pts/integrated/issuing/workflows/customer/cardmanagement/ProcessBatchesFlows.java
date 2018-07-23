package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ProcessBatches;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.ProcessBatchesPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.FileCreation;

@Component
public class ProcessBatchesFlows {
	final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProcessBatchesPage processBatchesPage;
	@Autowired
	private Navigator navigator;


	public void runProcessBatchFlows(ProcessBatches processBatchesDomainPage) {
		processBatchesPage.processBatch(FileCreation.filenameStatic,
				processBatchesDomainPage);
	}

	public boolean verifyFileProcessFlows(
			ProcessBatches processBatchesDomainPage) {
		return processBatchesPage.verifyFileProcess(processBatchesDomainPage);
	}
	public boolean verifyFileProcessFlowsUpload(
			ProcessBatches processBatchesDomainPage, String FileName) {
		return processBatchesPage.verifyFileProcessUpload(processBatchesDomainPage, FileName);
	}
	public boolean verifyErrorMessageFlows(String errorType) {
		return processBatchesPage.verifyErrorMessage(errorType);
	}

	public String processUploadBatches(String batchName, String fileName) {
		processBatchesPage = navigator.navigateToPage(ProcessBatchesPage.class);
		processBatchesPage.processUploadBatch(batchName);
		processBatchesPage.checkAndSumbitFile(fileName);
		return processBatchesPage.retrieveJobID(fileName);
	}


}