package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.ClientPhotoDownloadBatchPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class ClientPhotoDownloadBatchWorkflow {
	
	@Autowired
	private Navigator navigator;
	
	public boolean[] verifyBatchNameIsPresentInDownloadBatchFlows() {
		ClientPhotoDownloadBatchPage clientPhotoDownloadPage = navigator.navigateToPage(ClientPhotoDownloadBatchPage.class);
		return clientPhotoDownloadPage.verifyBatchNameIsPresentInDownloadBatch();
	}
	
	
}
