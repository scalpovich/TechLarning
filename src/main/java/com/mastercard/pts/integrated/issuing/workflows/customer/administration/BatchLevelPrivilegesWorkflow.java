package com.mastercard.pts.integrated.issuing.workflows.customer.administration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.configuration.AppEnvironment;
import com.mastercard.pts.integrated.issuing.configuration.Portal;
import com.mastercard.pts.integrated.issuing.pages.customer.administration.BatchLevelPreviledgePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;

@Component
public class BatchLevelPrivilegesWorkflow extends AbstractBaseFlows {

	@Autowired
	private Navigator navigator;
	
	Portal portal = new Portal();
	
	@Autowired
	private AppEnvironment environment;
	
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
	public boolean verifyPhotoFileDownloadBatchPresent() {
		searchBatchLevelAccessesForEntity();
		batch.clickBatchDownloadTab();
		return batch.verifyClientPhotoBatchPresent();
	}
	
	public void provideAccessToDownloadPhotoFileDownloadBatch() {
		searchBatchLevelAccessesForEntity();
		batch.supplyAccessToClientPhotoBatch();
	}
	
	public void searchBatchLevelAccessesForEntity(){
		navigator.navigateToPage(BatchLevelPreviledgePage.class);
		Portal loginPortal = environment.getPortalByType(Portal.TYPE_CUSTOMER);
		batch.selectEntityType(ENTITY_TYPE_USER);
		batch.selectEntityID(loginPortal.getUserName());
		batch.clickSearchBtn();
	}
	
}
