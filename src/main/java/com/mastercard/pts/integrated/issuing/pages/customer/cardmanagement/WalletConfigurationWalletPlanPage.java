package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WalletPlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_PROGRAM_SETUP, CardManagementNav.L2_WALLET_CONFIGURATION, CardManagementNav.L3_WALLET_PLAN })
public class WalletConfigurationWalletPlanPage extends AbstractBasePage {

	@Autowired
	private TestContext context;

	private static final Logger logger = LoggerFactory.getLogger(WalletConfigurationWalletPlanPage.class);

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

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//select[@name='view:whiteListedMcgCode:input:dropdowncomponent']")
	private MCWebElement whiteListedMsg;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value=Finish]")
	private MCWebElement finishBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Next >']")
	private MCWebElement nextBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:creditPlan:input:dropdowncomponent")
	private MCWebElement creditPlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:billingCycleCode:input:dropdowncomponent")
	private MCWebElement billingCyleCodeDDwn;

	private int reservedAmount = 0; // MiscUtils.randomNumber(5);

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
		WebElementUtils.selectDropDownByVisibleText(productTypeDDwn, productType);
	}

	public void selectProgramType(String programType) {
		WebElementUtils.selectDropDownByVisibleText(programTypeDDwn, programType);
	}

	public void selectUsage(String usage) {
		WebElementUtils.selectDropDownByVisibleText(usageDDwn, usage);
	}

	public void selectCreditPlan(String creditPlan) {
		if(context.get(CreditConstants.CREDIT_PLAN_CODE_ERROR_STATUS).equals(true))
		{
			WebElementUtils.selectDropDownByIndex(creditPlanDDwn, 1);
		}
		else
		{
			WebElementUtils.selectDropDownByVisibleText(creditPlanDDwn, creditPlan);
		}
	}

	public void selectBillingCyleCode(String billingCyleCode) {
		if(context.get(CreditConstants.BILLING_CYCLE_CODE_ERROR_STATUS).equals(true))
		{
			WebElementUtils.selectDropDownByIndex(billingCyleCodeDDwn, 1);
		}
		else
		{
			WebElementUtils.selectDropDownByVisibleText(billingCyleCodeDDwn,
					billingCyleCode);
		}
	}

	public void inputReservedAmount() {
		WebElementUtils.enterText(reservedAmountTxt, String.valueOf(reservedAmount));
	}

	public void enterReservedAmount(String reserverAmount) {
		WebElementUtils.enterText(reservedAmountTxt, reserverAmount);
	}

	public void selectWhiteListMSG(String msgCode) {
		WebElementUtils.selectDropDownByVisibleText(whiteListedMsg, msgCode);
	}

	@Override
	public void clickNextButton() {
		SimulatorUtilities.wait(400);
		clickWhenClickable(nextBtn);
	}

	@Override
	public void clickFinishButton() {
		SimulatorUtilities.wait(900);
		clickWhenClickable(finishBtn);
	}

	// Method to fill data in Add Wallet Plan Data
	public void addWalletPlanData(WalletPlan walletPlan) {
		logger.info("Create Wallet Plan: {}", walletPlan.getWalletPlanCode());
		clickAddNewButton();

		runWithinPopup("Add Wallet Plan", () -> {
			String productType = walletPlan.getProductType();
			inputWalletPlanCode(walletPlan.getWalletPlanCode());
			waitForPageToLoad(driver());
			inputDescription(walletPlan.getDescription());
			waitForPageToLoad(driver());
			SimulatorUtilities.wait(2000);
			selectProductType(productType);
			if(walletPlan.getProductType().equalsIgnoreCase(ProductType.CREDIT))
			{
				selectByVisibleText(programTypeDDwn,walletPlan.getProgramType());
			}
			else
			{            
				SimulatorUtilities.wait(2000);
				selectProgramType(walletPlan.getProgramType());
				waitForPageToLoad(driver());
				SimulatorUtilities.wait(2000);
			}
			selectCurrency(walletPlan.getCurrency());
			waitForPageToLoad(driver());
			SimulatorUtilities.wait(2000);
			selectUsage(walletPlan.getUsage());
			SimulatorUtilities.wait(2000);

			fillDetailsBasedOnCardType(walletPlan, productType);

			clickNextButton(); // Click on next button
			clickFinishButton(); // click on finish button
		});
		verifyOperationStatus();
	}

	// Method to fill data in Add Wallet Plan Data
	public void addNewWalletPlanData(WalletPlan walletPlan) {
		logger.info("Create Wallet Plan: {}", walletPlan.getWalletPlanCode());
		clickAddNewButton();

		runWithinPopup("Add Wallet Plan", () -> {
			String productType = walletPlan.getProductType();
			inputWalletPlanCode(walletPlan.getWalletPlanCode());
			inputDescription(walletPlan.getDescription());
			selectProductType(productType);
			waitForPageToLoad(driver());
			selectProgramType(walletPlan.getProgramType());
			SimulatorUtilities.wait(3000);
			selectCurrency(walletPlan.getCurrency());
			waitForPageToLoad(driver());
			selectUsage(walletPlan.getUsage());
			waitForPageToLoad(driver());
			fillDetailsBasedOnCardType(walletPlan, productType);
			clickNextButton(); // Click on next button
			clickFinishButton(); // click on finish button
		});
		verifyOperationStatus();
	}

	private void fillDetailsBasedOnCardType(WalletPlan walletPlan, String productType) {
		if (productType.equalsIgnoreCase(ProductType.CREDIT)) {
			selectCreditPlan(walletPlan.getCreditPlan());
			selectBillingCyleCode(walletPlan.getBillingCyleCode());

		}
		if (productType.equalsIgnoreCase(ProductType.DEBIT)) {
			WebElementUtils.enterText(dummyAccountNumberTxt, walletPlan.getDummyAccountNumber());
		}
		if (productType.equalsIgnoreCase(ProductType.PREPAID)) {
			inputReservedAmount();
		}
	}

	private void fillDetailsBasedOnCarddType(WalletPlan walletPlan, String productType) {
		if (productType.equalsIgnoreCase(ProductType.CREDIT)) {
			selectCreditPlan(walletPlan.getCreditPlan());
			selectBillingCyleCode(walletPlan.getBillingCyleCode());
		}
		if (productType.equalsIgnoreCase(ProductType.DEBIT)) {
			WebElementUtils.enterText(dummyAccountNumberTxt, walletPlan.getDummyAccountNumber());
		}
		if (productType.equalsIgnoreCase(ProductType.PREPAID)) {
			enterReservedAmount(walletPlan.getReservedAmount());
			if (walletPlan.getWhiteMcgCode() != null) {
				logger.info("White listed MCG {}", walletPlan.getWhiteMcgCode());
				selectWhiteListMSG(walletPlan.getWhiteMcgCode());
			}
		}
	}

	public void verifyUiOperationStatus() {
		logger.info("Wallet Configuration Wallet PLan");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(walletPlanCodeSearchTxt));
	}

}
