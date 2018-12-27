package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePromotionPlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP,
		CardManagementNav.L2_DEVICE_CONFIGURATION,
		CardManagementNav.L3_DEVICE_PROMOTION_PLAN
		})

public class DevicePromotionPlanPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(DevicePromotionPlanPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=devicePromoPlanCode]")
	private MCWebElement txtDevicePromoPlanCodeSearch;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=description]")
	private MCWebElement txtDescriptionSearch;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement productTypeSearchDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "devicePromoPlanCode:input:inputTextField")
	private MCWebElement txtDevicePromoPlan;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "productType:input:dropdowncomponent")
	private MCWebElement productTypeDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "description:input:inputTextField")
	private MCWebElement txtDescription;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='devicePromoEffectiveDate']/..")
	private MCWebElement effectiveDateTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='devicePromoEndDate']/..")
	private MCWebElement endDateTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "txnLimitPlanCode:input:dropdowncomponent")
	private MCWebElement transactionLimitPlanDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "deviceEvtFeePlanCodePrim:input:dropdowncomponent")
	private MCWebElement eventBasedFeePlanDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "deviceMntFeePlanCodePrim:input:dropdowncomponent")
	private MCWebElement deviceJoiningMemFeePlanDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "txnFeePlanCode:input:dropdowncomponent")
	private MCWebElement transactionFeePlanDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "txnFeeWaiverPlanCode:input:dropdowncomponent")
	private MCWebElement transactionWaiverPlanDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "lytPlanCode:input:dropdowncomponent")
	private MCWebElement loyaltyPlanDdwn;
	
	public void pickEffectiveDate(LocalDate startDate) {
		WebElementUtils.pickDate(effectiveDateTxt, startDate);
	}

	public void pickEndDate(LocalDate endDate) {
		WebElementUtils.pickDate(endDateTxt, endDate);
	}
	
	public void selectProductType(String productType) {
		WebElementUtils.selectDropDownByVisibleText(productTypeDDwn,
				productType);
	}
	
	public void enterDevicePromoPlanCode(String devicePromoPlanCode) {
		WebElementUtils.enterText(txtDevicePromoPlan, devicePromoPlanCode);
	}
	
	public void enterDescription(String description) {
		WebElementUtils.enterText(txtDescription, description);
	}
	
	public void selectEventBasedFeePlan(String plan){
		WebElementUtils.selectDropDownByVisibleText(eventBasedFeePlanDDwn,
				plan);
	}
	
	public void selectDeviceJoiningMemFeePlan(String plan){
		WebElementUtils.selectDropDownByVisibleText(deviceJoiningMemFeePlanDDwn,
				plan);
	}
	
	public void selectTransactionFeePlan(String plan){
		WebElementUtils.selectDropDownByVisibleText(transactionFeePlanDDwn,
				plan);
	}
	
	public void selectTransactionLimitPlan(String plan){
		WebElementUtils.selectDropDownByVisibleText(transactionLimitPlanDDwn,
				plan);
	}
	
	public void selectTransactionWaiverPlan(String plan){
		WebElementUtils.selectDropDownByVisibleText(transactionWaiverPlanDDwn,
				plan);
	}
	
	public void selectLoyaltyPlan(String plan){
		WebElementUtils.selectDropDownByVisibleText(loyaltyPlanDdwn,
				plan);
	}
	
	public void createDevicePromotionPlan(DevicePromotionPlan devicePromotionPlan) {
		logger.info("Create Device Promotion Plan: {}", devicePromotionPlan.getDevicePromotionPlanCode());
		searchForExistingPlan(devicePromotionPlan);
		if(isNoRecordsFoundInTable()){
			clickAddNewButton();
			runWithinPopup("Add Device Promotion Plan", () -> {
				enterDevicePromoPlanCode(devicePromotionPlan.getDevicePromotionPlanCode());
				enterDescription(devicePromotionPlan.getPlanDescription());
				selectProductType(devicePromotionPlan.getProductType());
				clickAddDetailsButton();
				addDetails(devicePromotionPlan);
				WebElementUtils.scrollDown(driver(), 0, 250);
				clickSaveButton();
			});
			verifyOperationStatus();
		} else {
			logger.info("The Device Promotion Plan: {} already exists", devicePromotionPlan.getDevicePromotionPlanCode());
		}
	}
	
	public void addDetails(DevicePromotionPlan devicePromotionPlan) {
		clickAddNewButton();
		runWithinPopup("Add Device Promotion Plan Detail", () -> {
			pickEffectiveDate(devicePromotionPlan.getEffectiveDate());
			pickEndDate(devicePromotionPlan.getEndDate());
			selectEventBasedFeePlan(devicePromotionPlan.getEventBasedFeePlan());
			selectDeviceJoiningMemFeePlan(devicePromotionPlan.getDeviceJoiningMemFeePlan());
			selectTransactionFeePlan(devicePromotionPlan.getTransactionFeePlan());
			selectTransactionLimitPlan(devicePromotionPlan.getTransactionLimitPlan());
			selectTransactionWaiverPlan(devicePromotionPlan.getTransactionWaiverPlan());
			selectLoyaltyPlan(devicePromotionPlan.getLoyaltyPlan());
			clickSaveButton();
		});
		verifyRecordMarkedForUpdationStatusSuccess();
	}
	
	public void verifyUiOperationStatus() {
		logger.info("Device Promotion Plan");
		verifyUiOperation("Add Device Promotion Plan");
	}
	
	private void searchForExistingPlan(DevicePromotionPlan devicePromotionPlan){
		WebElementUtils.enterText(txtDevicePromoPlanCodeSearch, devicePromotionPlan.getDevicePromotionPlanCode());
		clickSearchButton();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(txtDevicePromoPlanCodeSearch),
				WebElementUtils.elementToBeClickable(txtDescriptionSearch),
				WebElementUtils.elementToBeClickable(productTypeSearchDDwn)
				);
	}
}