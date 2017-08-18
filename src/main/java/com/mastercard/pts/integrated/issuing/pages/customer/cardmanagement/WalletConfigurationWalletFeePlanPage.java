package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WalletFeePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WalletFeePlanDetails;
import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP,
		CardManagementNav.L2_WALLET_CONFIGURATION,
		CardManagementNav.L3_WALLET_FEE_PLAN })
public class WalletConfigurationWalletFeePlanPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory
			.getLogger(WalletConfigurationWalletFeePlanPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=walletFeePlanCode]")
	private MCWebElement planCodeSearchTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "productType:input:dropdowncomponent")
	private MCWebElement productTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "walletFeePlanCode:input:inputTextField")
	private MCWebElement planCodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "description:input:inputTextField")
	private MCWebElement descriptionTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "currencyCode:input:dropdowncomponent")
	private MCWebElement currencyDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "feeType:input:dropdowncomponent")
	private MCWebElement feeTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "feeAmt:input:inputAmountField")
	private MCWebElement feeTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Add Details']")
	private MCWebElement addDetailsBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='walletFeeEffectiveDate']/..")
	private MCWebElement effectiveDateTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='walletFeeEndDate']/..")
	private MCWebElement endDateTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "membershipPeriod:input:dropdowncomponent")
	private MCWebElement membershipFeePostingDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "waiveNumOfCycle:input:inputTextField")
	private MCWebElement waiveNumberOfCylcesTxt;

	private int fee = MiscUtils.randomNumber(3);

	private int waiveNumberOfCylces = MiscUtils.randomNumber(2);

	public void selectProductType(String productType) {
		WebElementUtils.selectDropDownByVisibleText(productTypeDDwn,
				productType);
	}

	public void inputPlanCode(String planCodeString) {
		WebElementUtils.enterText(planCodeTxt, planCodeString);
	}

	public void inputDescription(String description) {
		WebElementUtils.enterText(descriptionTxt, description);
	}

	public void selectCurrency(String currency) {
		WebElementUtils.selectDropDownByVisibleText(currencyDDwn, currency);
	}

	// Method to fill data in Add Wallet Fee Plan
	public void addWalletFeePlan(WalletFeePlan walletFeePlan, String productType) {

		logger.info("Create Wallet Fee Plan: {}",
				walletFeePlan.getWalletFeePlanCode());
		clickAddNewButton();

		runWithinPopup(
				"Add Wallet Fee Plan",
				() -> {
					selectProductType(walletFeePlan.getProductType());
					inputPlanCode(walletFeePlan.getWalletFeePlanCode());
					inputDescription(walletFeePlan.getDescription());
					selectCurrency(walletFeePlan.getCurrency());

					if (productType.equalsIgnoreCase(ProductType.PREPAID)) {
						addDetailsBtn.click();
						walletFeePlan.getWalletFeePlanDetails().forEach(
								this::addWalletFeePlanDetails);
					}
					clickSaveButton();
				});

		verifyOperationStatus();
	}

	public void selectFeeType(String feeType) {
		WebElementUtils.selectDropDownByVisibleText(feeTypeDDwn, feeType);
	}

	public void pickEffectiveDate(LocalDate startDate) {
		WebElementUtils.pickDate(effectiveDateTxt, startDate);
	}

	public void pickEndDate(LocalDate endDate) {
		WebElementUtils.pickDate(endDateTxt, endDate);
	}

	public void inputFee() {
		WebElementUtils.enterText(feeTxt, String.valueOf(fee));
	}

	public void selectMembershipFeePosting(String postingType) {
		WebElementUtils.selectDropDownByVisibleText(membershipFeePostingDDwn,
				postingType);
	}

	public void inputWaiveNumberOfCylces() {
		WebElementUtils.enterText(waiveNumberOfCylcesTxt,
				String.valueOf(waiveNumberOfCylces));
	}

	// Method to fill data in Add Wallet Fee Plan Details
	public void addWalletFeePlanDetails(
			WalletFeePlanDetails walletFeePlanDetails) {
		clickAddNewButton();

		runWithinPopup("Add Wallet Fee Plan Details",
				() -> {
					selectFeeType(walletFeePlanDetails.getFeeType());
					pickEffectiveDate(walletFeePlanDetails.getEffectiveDate());
					pickEndDate(walletFeePlanDetails.getEndDate());
					inputFee();
					selectMembershipFeePosting(walletFeePlanDetails
							.getMembershipFeePosting());
					inputWaiveNumberOfCylces();
					clickSaveButton();
				});

		verifyOperationStatus();
	}

	public void verifyUiOperationStatus() {
		logger.info("Wallet Configuration Wallet Fee Plan");
		verifySearchButton("Search");
	}

	@Override
	protected List<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(planCodeSearchTxt));
	}

}
