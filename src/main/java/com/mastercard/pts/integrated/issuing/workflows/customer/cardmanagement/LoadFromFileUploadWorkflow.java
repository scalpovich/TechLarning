package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.AdjustmentTransaction;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ProcessBatches;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.AdjustmentTransactionPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.BatchJobHistoryPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.BatchTraceHistoryPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.ProcessBatchesPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.ReversalTransactionPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.WalletDetailsPage;
import com.mastercard.pts.integrated.issuing.pages.customer.helpdesk.HelpdeskGeneralPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.FileCreation;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.utils.UploadFile;

@Workflow
public class LoadFromFileUploadWorkflow {
	
	@Autowired
	private Navigator navigator;

	@Autowired
	UploadFile uploadFile;
	
	public Map<String, String> processUploadBatch(ProcessBatches batch){	
		ProcessBatchesPage page = navigator.navigateToPage(ProcessBatchesPage.class);
		return page.processUploadBatch(batch);
	}
	
	public void createFileForUpload(FileCreation file){
		uploadFile.createTransactionUploadFile(file);
	}
	
	public List<String> searchWalletDetailsPage(Device device){
		WalletDetailsPage page = navigator.navigateToPage(WalletDetailsPage.class);
		return page.getWalletDetails(device);
	}
	public void createAdjustmentTransaction(AdjustmentTransaction transaction){
		AdjustmentTransactionPage page = navigator.navigateToPage(AdjustmentTransactionPage.class);
		page.addAdjustmentTransaction(transaction);
	}
	
	public boolean searchBatchTraceHistory(){
		BatchTraceHistoryPage page = navigator.navigateToPage(BatchTraceHistoryPage.class);
		return page.searchJob();
	}

	public boolean searchBatchTraceHistory(String jobId){
		BatchTraceHistoryPage page = navigator.navigateToPage(BatchTraceHistoryPage.class);
		return page.searchJob(jobId);
	}

	public boolean searchBatchJobHistory(String jobId){
		BatchJobHistoryPage page = navigator.navigateToPage(BatchJobHistoryPage.class);
		return page.searchJob(jobId);
	}

	public boolean verifyTransactionforDevice(Device device){
		HelpdeskGeneralPage helpDeskPage = navigator.navigateToPage(HelpdeskGeneralPage.class);
		return helpDeskPage.verifyTransactionOfDevice(device);
	}
	
	public File getFileNameFromCEEFile(String fileData){
		String [] splitString = fileData.split("\\s+");
		Path p = Paths.get(splitString[5]);
		MiscUtils.reportToConsole("******************** NotFileName ******************** " + p.getFileName().toFile());
		return p.getFileName().toFile();
	}
	
	public void loadIncomingIPM(File fileName){
		uploadFile.uploadIpmFile(fileName);		
	}
	
}
