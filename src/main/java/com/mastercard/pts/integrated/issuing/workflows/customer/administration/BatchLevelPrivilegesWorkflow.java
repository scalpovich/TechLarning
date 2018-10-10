package com.mastercard.pts.integrated.issuing.workflows.customer.administration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.configuration.Portal;
import com.mastercard.pts.integrated.issuing.pages.customer.administration.BatchLevelPreviledgePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;

@Component
public class BatchLevelPrivilegesWorkflow extends AbstractBaseFlows {

	@Autowired
	private Navigator navigator;

	Portal portal = new Portal();

	public void selectEntityTypeAsUser(String userName) {
		batch.selectEntityType();
		batch.selectEntityID(userName);
		portal.setUserName(userName);
		batch.clickSearchBtn();
	}

	public void selectEntityTypeAsRole() {
		batch.selectEntityType();
		batch.selectEntityID();
		batch.clickSearchBtn();
	}

	public void setAllBatchLevelTabPriviledgesForUsers(String userName) {
		navigator.navigateToPage(BatchLevelPreviledgePage.class);
		selectEntityTypeAsUser(userName);
		batch.supplyAccessToAllBatches();
	}

	public void setAllBatchLevelTabPriviledgesForRole() {
		selectEntityTypeAsRole();
		batch.supplyAccessToAllBatches();
	}

	public void setUploadBatchAccessForUser(String userName) {
		selectEntityTypeAsUser(userName);
		batch.supplyAccessToUploadBatches();
	}

	public void setDownloadBatchAccessForUser(String userName) {
		selectEntityTypeAsUser(userName);
		batch.supplyAccessToDownloadBatches();
	}

	public void setSystemInternalBatchAccessForUser(String userName) {
		selectEntityTypeAsUser(userName);
		batch.supplyAccessToSystemInternalBatches();
	}

	public void setUploadBatchAccessForRole() {
		selectEntityTypeAsRole();
		batch.supplyAccessToUploadBatches();
	}

	public void setDownloadBatchAccessForRole() {
		selectEntityTypeAsRole();
		batch.supplyAccessToDownloadBatches();
	}

	public void setSystemInternalBatchAccessForRole() {
		selectEntityTypeAsRole();
		batch.supplyAccessToSystemInternalBatches();
	}
	
}
