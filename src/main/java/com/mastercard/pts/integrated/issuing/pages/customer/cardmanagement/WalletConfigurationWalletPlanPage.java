package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WalletPlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
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
		CardManagementNav.L3_WALLET_PLAN })
public class WalletConfigurationWalletPlanPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(WalletConfigurationWalletPlanPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=walletPlanCode]")
	private MCWebElement walletPlanCodeSearchTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:walletPlanCode:input:inputTextField")
	private MCWebElement walletPlanCodeTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=description]")
	private MCWebElement descriptionTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:currencyCode:input:dropdowncomponent")
	private MCWebElement currencyDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:productType:input:dropdowncomponent")
	private MCWebElement productTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:walletPlanType:input:dropdowncomponent")
	private MCWebElement programTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:walletUsage:input:dropdowncomponent")
	private MCWebElement usageDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:dummyAccountNumber:input:inputTextField")
	private MCWebElement dummyAccountNumberTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=minBalanceForTxn]")
	private MCWebElement reservedAmountTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value=Finish]")
	private MCWebElement finishBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Next >']")
	private MCWebElement nextBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:creditPlan:input:dropdowncomponent")
	private MCWebElement creditPlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:billingCycleCode:input:dropdowncomponent")
	private MCWebElement billingCyleCodeDDwn;

	private int reservedAmount = MiscUtils.randomNumber(5);

	public void inputWalletPlanCode(String walletPlanCodeString) {
		WebElementUtils.enterText(walletPlanCodeTxt, walletPlanCodeString);
	}

	public void inputDescription(String description) {
		WebElementUtils.enterText(descriptionTxt, description);
	}

	public void selectCurrency(String currency) {
		WebElementUtils.selectDropDownByVisibleText(currencyDDwn, currency);
	}

	public void selectProductType(String productType) {
		WebElementUtils.selectDropDownByVisibleText(productTypeDDwn,
				productType);
	}

	public void selectProgramType(String programType) {
		WebElementUtils.selectDropDownByVisibleText(programTypeDDwn,
				programType);
	}

	public void selectUsage(String usage) {
		WebElementUtils.selectDropDownByVisibleText(usageDDwn, usage);
	}

	public void selectCreditPlan(String creditPlan) {
		WebElementUtils.selectDropDownByVisibleText(creditPlanDDwn, creditPlan);
	}

	public void selectBillingCyleCode(String billingCyleCode) {
		WebElementUtils.selectDropDownByVisibleText(billingCyleCodeDDwn,
				billingCyleCode);
	}

	public void inputReservedAmount() {
		WebElementUtils.enterText(reservedAmountTxt,
				String.valueOf(reservedAmount));
	}
	
	public void enterReservedAmount(String reserverAmount){
		WebElementUtils.enterText(reservedAmountTxt,
				reserverAmount);
	}

	@Override
	public void clickNextButton() {
		nextBtn.click();
	}

	@Override
	public void clickFinishButton() {
		finishBtn.click();
	}

	// Method to fill data in Add Wallet Plan Data
	public void addWalletPlanData(WalletPlan walletPlan) {
		logger.info("Create Wallet Plan: {}", walletPlan.getWalletPlanCode());
		clickAddNewButton();

		runWithinPopup("Add Wallet Plan", () -> {
			String productType = walletPlan.getProductType();
			inputWalletPlanCode(walletPlan.getWalletPlanCode());
			inputDescription(walletPlan.getDescription());
			selectCurrency(walletPlan.getCurrency());
			selectProductType(productType);
			selectProgramType(walletPlan.getProgramType());
			selectUsage(walletPlan.getUsage());

			fillDetailsBasedOnCarddType(walletPlan, productType);

			clickNextButton(); // Click on next button
				clickFinishButton(); // click on finish button
			});
		verifyOperationStatus();
	}
	
	// Method to fill data in Add Wallet Plan Data
	public void addWalletPlanData1(WalletPlan walletPlan) {
		logger.info("Create Wallet Plan: {}", walletPlan.getWalletPlanCode());
		clickAddNewButton();

		runWithinPopup("Add Wallet Plan", () -> {
			String productType = walletPlan.getProductType();
			inputWalletPlanCode(walletPlan.getWalletPlanCode());
			inputDescription(walletPlan.getDescription());
			selectCurrency(walletPlan.getCurrency());
			selectProductType(productType);
			selectProgramType(walletPlan.getProgramType());
			selectUsage(walletPlan.getUsage());

			fillDetailsBasedOnCarddType1(walletPlan, productType);

			clickNextButton(); // Click on next button
				clickFinishButton(); // click on finish button
			});
		verifyOperationStatus();
	}

	private void fillDetailsBasedOnCArdType(WalletPlan walletPlan,
			String productType) {
		if (productType.equalsIgnoreCase(ProductType.CREDIT)) {
			selectCreditPlan(walletPlan.getCreditPlan());
			selectBillingCyleCode(walletPlan.getBillingCyleCode());
		}
		if (productType.equalsIgnoreCase(ProductType.DEBIT)) {
			WebElementUtils.enterText(dummyAccountNumberTxt,
					walletPlan.getDummyAccountNumber());
		}
		if (productType.equalsIgnoreCase(ProductType.PREPAID)) {
			inputReservedAmount();
		}
	}
	
	private void fillDetailsBasedOnCarddType(WalletPlan walletPlan,
			String productType) {
		if (productType.equalsIgnoreCase(ProductType.CREDIT)) {
			selectCreditPlan(walletPlan.getCreditPlan());
			selectBillingCyleCode(walletPlan.getBillingCyleCode());
		}
		if (productType.equalsIgnoreCase(ProductType.DEBIT)) {
			WebElementUtils.enterText(dummyAccountNumberTxt,
					walletPlan.getDummyAccountNumber());
		}
		if (productType.equalsIgnoreCase(ProductType.PREPAID)) {
			inputReservedAmount();
		}
	}
	
	private void fillDetailsBasedOnCarddType1(WalletPlan walletPlan,
			String productType) {
		if (productType.equalsIgnoreCase(ProductType.CREDIT)) {
			selectCreditPlan(walletPlan.getCreditPlan());
			selectBillingCyleCode(walletPlan.getBillingCyleCode());
		}
		if (productType.equalsIgnoreCase(ProductType.DEBIT)) {
			WebElementUtils.enterText(dummyAccountNumberTxt,
					walletPlan.getDummyAccountNumber());
		}
		if (productType.equalsIgnoreCase(ProductType.PREPAID)) {
			enterReservedAmount(walletPlan.getReservedAmount());
		}
	}

	public void verifyUiOperationStatus() {
		logger.info("Wallet Configuration Wallet PLan");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils
				.elementToBeClickable(walletPlanCodeSearchTxt));
	}

}
