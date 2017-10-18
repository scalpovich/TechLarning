package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceBin;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.pages.MenuSubMenuPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceBinPage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class DeviceBINFlows extends MenuFlows {

	@Autowired
	MenuSubMenuPage menusubmenuPage;

	@Autowired
	DeviceBinPage deviceBinPage;

	@Autowired
	Navigator navigator;

	public String addDeviceBIN(DeviceBin deviceBIN, DeviceCreation deviceCreation) {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		DeviceBinPage deviceBINpage = navigator.navigateToPage(DeviceBinPage.class);
		deviceBINpage.clickaddDeviceBin();
		String IssuerBIN = deviceBINpage.addDeviceBinDetails(deviceBIN, deviceCreation);
		waitForPageToLoad(getFinder().getWebDriver());
		waitForLoaderToDisappear();
		deviceBINpage.verifyNewDeviceBinSuccess();
		return IssuerBIN;
	}

	public void editIssuerBIN() {
		menusubmenuPage.waitForElementVisible(menusubmenuPage.getCardManagement());
		menusubmenuPage.clickMenuSubOption(menusubmenuPage.getInstitutionParameterSetup(),
				menusubmenuPage.getDeviceBin());
		deviceBinPage.editDeviceBin(MapUtils.fnGetInputDataFromMap("IssuerBIN"),
				MapUtils.fnGetInputDataFromMap("Remark"), "remarks updated");
	}

	public void deleteIssuerBIN() {
		menusubmenuPage.waitForElementVisible(menusubmenuPage.getCardManagement());
		menusubmenuPage.clickMenuSubOption(menusubmenuPage.getInstitutionParameterSetup(),
				menusubmenuPage.getDeviceBin());
		deviceBinPage.deleteDeviceBin();
	}

	public void issuerBINValidation() {
		menusubmenuPage.waitForElementVisible(menusubmenuPage.getCardManagement());
		menusubmenuPage.clickMenuSubOption(menusubmenuPage.getInstitutionParameterSetup(),
				menusubmenuPage.getDeviceBin());
		deviceBinPage.deviceBinValidation(MapUtils.fnGetInputDataFromMap("InterchangeType"),
				MapUtils.fnGetInputDataFromMap("ProductType"), MapUtils.fnGetInputDataFromMap("BINType"),
				MapUtils.fnGetInputDataFromMap("Remark"));
	}

}
