package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BulkDeviceRequest;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_ACTIVITY, CardManagementNav.L2_DEVICE,
		CardManagementNav.L3_DEVICE_PRODUCTION_BULK_DEVICE_REQUEST })
public class DeviceProductionBulkDeviceRequestPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(DeviceProductionBulkDeviceRequestPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:inputTextField")
	private MCWebElement searchBatchNumberTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "productType:input:dropdowncomponent")
	private MCWebElement productTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "branchCode:input:dropdowncomponent")
	private MCWebElement branchDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "programCode:input:dropdowncomponent")
	private MCWebElement programDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "corporateClientCode:input:dropdowncomponent")
	private MCWebElement corporateClientCodeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "walletPromoPlanCode:input:dropdowncomponent")
	private MCWebElement walletPromotionPlan1DDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "walletPromoPlanCode2:input:dropdowncomponent")
	private MCWebElement walletPromotionPlan2DDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "walletPromoPlanCode3:input:dropdowncomponent")
	private MCWebElement walletPromotionPlan3DDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "devicePlanCode:input:dropdowncomponent")
	private MCWebElement devicePlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "devicePromoPlanCode:input:dropdowncomponent")
	private MCWebElement devicePromotionPlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "quantity:input:inputTextField")
	private MCWebElement quantityRequestedTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "line3Emboss:input:inputTextField")
	private MCWebElement embossingNameTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "line4Emboss:input:inputTextField")
	private MCWebElement embossingLine4Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "dummyAccountNumber:input:inputTextField")
	private MCWebElement dummyAccountNumberTxt;

	public void verifyUiOperationStatus() {
		logger.info("Device Production Bulk Device Request");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays
				.asList(WebElementUtils.visibilityOf(searchBatchNumberTxt));
	}

	public String addBulkDeviceRequestdata(BulkDeviceRequest request) {
		logger.info("Bulk Device Generation Request: {}",
				request.getProductType());
		clickAddNewButton();
		runWithinPopup("Add Bulk Device Request", () -> {
			WebElementUtils.selectDropDownByVisibleText(productTypeDDwn, request.getProductType());
			SimulatorUtilities.wait(1100);
			WebElementUtils.selectDropDownByVisibleText(branchDDwn,	request.getBranch());
			SimulatorUtilities.wait(1100);
			WebElementUtils.selectDropDownByVisibleText(programDDwn, request.getProgram());
			if (corporateClientCodeDDwn.isEnabled())
				WebElementUtils.selectDropDownByVisibleText(corporateClientCodeDDwn, request.getCorporateClientCode());				
			if (!request.getWalletPromotionPlan1().isEmpty())
				WebElementUtils.selectDropDownByVisibleText(walletPromotionPlan1DDwn, request.getWalletPromotionPlan1());
			WebElementUtils.selectDropDownByVisibleText(devicePlanDDwn,	request.getDevicePlan());
			if (!request.getDevicePromotionPlan().isEmpty())
				WebElementUtils.selectDropDownByVisibleText(devicePromotionPlanDDwn, request.getDevicePromotionPlan());
			WebElementUtils.enterText(quantityRequestedTxt, request.getQuantityRequested());
			if (!request.getEmbossingName().isEmpty())
				WebElementUtils.enterText(embossingNameTxt, request.getEmbossingName());
			if (!request.getEmbossingLine4().isEmpty())
				WebElementUtils.enterText(embossingLine4Txt, request.getEmbossingLine4());
			if (!request.getDummyAccountNumber().isEmpty() && dummyAccountNumberTxt.isEnabled())
				WebElementUtils.enterText(dummyAccountNumberTxt, request.getDummyAccountNumber());
			clickSaveButton();
		});

		return getBatchNumberFromFeedbackPanel();
	}

}
