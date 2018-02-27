package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.jbehave.core.model.ExamplesTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.processingcenter.NetworkPage;
import com.mastercard.pts.integrated.issuing.pages.customer.processingcenter.ProcessingCenterPage;
import com.mastercard.pts.integrated.issuing.utils.FileUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;

@Component
public class NetworkFlows extends AbstractBaseFlows {

	@Autowired
	NetworkPage networkpage;

	@Autowired
	ProcessingCenterPage processingcenterpage;

	// @Autowired
	// FileUtils fileutils;

	public void editNetworkCode() {
		waitForElementVisible(processingcenterpage.getProcessingCenter());
		processingcenterpage.clickSubOptionProcessingCenter(
				processingcenterpage.getSetup(),
				processingcenterpage.getMasterParameters());
		processingcenterpage.clickNetworkMenu();
		networkpage.editNetwork("06",
				MapUtils.fnGetInputDataFromMap("NetworkDescription"));
	}

	public void verifyNetworkPresent(String Text) {
		waitForElementVisible(processingcenterpage.getProcessingCenter());
		processingcenterpage.clickSubOptionProcessingCenter(
				processingcenterpage.getSetup(),
				processingcenterpage.getMasterParameters());
		menuSubMenuPage.getNetwork().click();
		//networkpage.getRupayNtkCode().isVisible();
		networkpage.isInterchagePresent(Text);
		
		
		

	}

	public void configureDeviceRange() {
		waitForElementVisible(menuSubMenuPage.getCardManagement());
		menuSubMenuPage.clickMenuSubOption(menuSubMenuPage.getProgramSetup(),
				menuSubMenuPage.getDeviceRange());
		deviceRangePage.configureDeviceranges(MapUtils
				.fnGetInputDataFromMap("ProductType"));
	}

	public void verifyInterchangeTypes(ExamplesTable interchangeTable) {
		deviceRangePage.verifyInterchangeTypes(interchangeTable);
	}

	public void whenAdminDownloadListsOfNetworks() {
		processingCenterPage.clickSubOptionProcessingCenter(
				processingCenterPage.getSetup(),
				processingCenterPage.getMasterParameters());
		waitForElementVisible(processingCenterPage.getNetwork());
		processingCenterPage.getNetwork().click();
		try {
			networkMembershipPage.downloadlists();
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}
	}

	public String currentUser(String command) {
		String user = null;
		try {
			user = FileUtils.execCmd(command);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return user;

	}

}
