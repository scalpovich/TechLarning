package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.AdjustmentTransaction;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ProcessBatches;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.AdjustmentTransactionPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.BatchTraceHistoryPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.ProcessBatchesPage;
import com.mastercard.pts.integrated.issuing.pages.customer.helpdesk.HelpdeskGeneralPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.FileCreation;
import com.mastercard.pts.integrated.issuing.utils.UploadFile;

@Workflow
public class LoadFromFileUploadWorkflow {
	
	@Autowired
	private Navigator navigator;

	@Autowired
	UploadFile upload;
	
	public String processUploadBatch(ProcessBatches batch){	
		ProcessBatchesPage page = navigator.navigateToPage(ProcessBatchesPage.class);
		return page.processUploadBatch(batch);
	}
	
	public void createFileForUpload(FileCreation file){
		upload.createTransactionUploadFile(file);
	}
	
	public void createAdjustmentTransaction(AdjustmentTransaction transaction){
		AdjustmentTransactionPage page = navigator.navigateToPage(AdjustmentTransactionPage.class);
		page.addAdjustmentTransaction(transaction);
	}
	
	public boolean searchBatchTraceHistory(){
		BatchTraceHistoryPage page = navigator.navigateToPage(BatchTraceHistoryPage.class);
		return page.searchJob();
	}

	public boolean verifyTransactionforDevice(Device device){
		HelpdeskGeneralPage helpDeskPage = navigator.navigateToPage(HelpdeskGeneralPage.class);
		return helpDeskPage.verifyTransactionOfDevice(device);
	}
	
	public File getFileNameFromCEEFile(String fileData){
		String [] splitString = fileData.split("\\s+");
		Path p = Paths.get(splitString[5]);
		return p.getFileName().toFile();
	}
	
	public void loadIncomingIPM(File fileName){
		upload.uploadIpmFile(fileName);
	}
	
}
