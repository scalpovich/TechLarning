package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP, CardManagementNav.L2_PROGRAM })
public class ProgramPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory
			.getLogger(ProgramPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=programCode]")
	private MCWebElement programSearchTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:programCode:input:inputTextField")
	private MCWebElement programTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:description:input:inputTextField")
	private MCWebElement descriptionTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:networkCode:input:dropdowncomponent")
	private MCWebElement interchangeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:productType:input:dropdowncomponent")
	private MCWebElement productDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:programType:input:dropdowncomponent")
	private MCWebElement programTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:currencyCode:input:dropdowncomponent")
	private MCWebElement baseCurrencyDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:optionalCurrencyConvFlag:input:dropdowncomponent")
	private MCWebElement currencyConversionByDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:calendarMonth:input:dropdowncomponent")
	private MCWebElement calendarStartMonthDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:maxBalanceBefKyc:input:inputAmountField")
	private MCWebElement maximumBalanceWithoutKycTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:noOfLoadBefKyc:input:inputTextField")
	private MCWebElement numberOfLoadsAllowedWithoutKycTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:walletPlanCode1:input:dropdowncomponent")
	private MCWebElement walletPlanPlan1DDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:devicePlanCode1:input:dropdowncomponent")
	private MCWebElement devicePlanPlan1DDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:statMsgCode:input:dropdowncomponent")
	private MCWebElement otherPlanStatementMessagePlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:mktMsgPlanCode:input:dropdowncomponent")
	private MCWebElement otherPlanMarketingMessagePlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:creditLimit:input:inputTextField")
	private MCWebElement creditLimitTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:maxCreditLimit:input:inputTextField")
	private MCWebElement maximumCreditLimitTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cashLimitMethod:input:dropdowncomponent")
	private MCWebElement cashLimitTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cashLimitFixed:input:inputTextField")
	private MCWebElement cashLimitAmountTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cashLimitVariable:input:inputTextField")
	private MCWebElement percentageOfCreditLimitTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cashLimitCycleIndicatior:input:dropdowncomponent")
	private MCWebElement cashLimitResetDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:addOnLimitCycleIndicatior:input:dropdowncomponent")
	private MCWebElement addOnLimitResetDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "view:refundInCurrency:input:dropdowncomponent")
	private MCWebElement refundInCurrencyDDwn;
	

	@PageElement(findBy = FindBy.CSS, valueToFind = "#dedupePlanCode select")
	private MCWebElement dedupePlanCodeDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#documentPlanCode select")
	private MCWebElement documentPlanCodeDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#mccRulePlanCode select")
	private MCWebElement mccRulePlanCodeDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#stmtPlanCode select")
	private MCWebElement stmtPlanCodeDDwn;

	public void addProgram(String programCode) {
		WebElementUtils.enterText(programTxt, programCode);
	}

	public void addDescription(String description) {
		WebElementUtils.enterText(descriptionTxt, description);
	}

	public void selectInterchange(String interchange) {
		WebElementUtils.selectDropDownByVisibleText(interchangeDDwn, interchange);
	}

	public void selectProduct(String product) {
		WebElementUtils.selectDropDownByVisibleText(productDDwn, product);
	}

	public void selectProgramType(String programType) {
		WebElementUtils.selectDropDownByVisibleText(programTypeDDwn, programType);
	}

	public void selectBaseCurrency(String baseCurrency) {
		WebElementUtils.selectDropDownByVisibleText(baseCurrencyDDwn, baseCurrency);
	}

	public void selectCurrencyConversionBy(String currencyConversionBy) {
		if(currencyConversionByDDwn.isEnabled())
			WebElementUtils.selectDropDownByVisibleText(currencyConversionByDDwn, currencyConversionBy);
	}

	public void selectCalendarStartMonth(String calendarStartMonth) {
		WebElementUtils.selectDropDownByVisibleText(calendarStartMonthDDwn, calendarStartMonth);
	}

	public void addMaximumBalanceWithoutKyc(String maximumBalanceWithoutKyc) {
		WebElementUtils.enterText(maximumBalanceWithoutKycTxt, maximumBalanceWithoutKyc);
	}

	public void addnumberOfLoadsAllowedWithoutKyc(
			String numberOfLoadsAllowedWithoutKyc) {
		WebElementUtils.enterText(numberOfLoadsAllowedWithoutKycTxt, numberOfLoadsAllowedWithoutKyc);
	}

	public void selectWalletPlanPlan1(String walletPlanPlan1) {
		WebElementUtils.selectDropDownByVisibleText(walletPlanPlan1DDwn, walletPlanPlan1);
	}
	
	public void selectRefundInCurrency(String refundInCurrency) {
		if(refundInCurrencyDDwn.isEnabled())
		WebElementUtils.selectDropDownByVisibleText(refundInCurrencyDDwn, refundInCurrency);
	}

	public void selectDevicePlanPlan1DDwn(String devicePlanPlan1) {
		WebElementUtils.selectDropDownByVisibleText(devicePlanPlan1DDwn, devicePlanPlan1);
	}

	public void selectOtherPlanStatementMessagePlan(String otherPlanStatementMessagePlan) {
		WebElementUtils.selectDropDownByVisibleText(otherPlanStatementMessagePlanDDwn, otherPlanStatementMessagePlan);
	}

	public void selectOtherPlanMarketingMessagePlan(String otherPlanMarketingMessagePlan) {
		WebElementUtils.selectDropDownByVisibleText(otherPlanMarketingMessagePlanDDwn, otherPlanMarketingMessagePlan);
	}

	public void addProgramData(Program program, String productType) {
		logger.info("Add Program: {}", program.getProgramCode());
		clickAddNewButton();

		runWithinPopup("Add Program", () -> {
			addProgram(program.getProgramCode());
			addDescription(program.getDescription());
			selectInterchange(program.getInterchange());
			selectProduct(program.getProduct());
			selectProgramType(program.getProgramType());
			selectBaseCurrency(program.getBaseCurrency());
			if (!productType.equalsIgnoreCase(ProductType.DEBIT))
				selectCurrencyConversionBy(program.getCurrencyConversionBy());
			selectCalendarStartMonth(program.getCalendarStartMonth());

			fillExtraSections(program, productType);

			clickNextButton();
			clickFinishButton();
		});

		verifyOperationStatus();
	}

	private void fillExtraSections(Program program, String productType) {
		if (productType.equalsIgnoreCase(ProductType.PREPAID)) {
			addMaximumBalanceWithoutKyc(program.getMaximumBalanceWithoutKyc());
			addnumberOfLoadsAllowedWithoutKyc(program.getNumberOfLoadsAllowedWithoutKyc());
			selectRefundInCurrency(program.getRefundInCurrency());
		}
		
		clickNextButton();
		selectWalletPlanPlan1(program.getWalletPlanPlan1());
		selectDevicePlanPlan1DDwn(program.getDevicePlanPlan1());
		if (!productType.equalsIgnoreCase(ProductType.DEBIT)) {
			selectOtherPlanStatementMessagePlan(program.getOtherPlanStatementMessagePlan());
			selectOtherPlanMarketingMessagePlan(program.getOtherPlanMarketingMessagePlan());
		}

		WebElementUtils.selectDropDownByOptionalVisibleText(dedupePlanCodeDDwn,
				program.getDedupPlan());
		WebElementUtils.selectDropDownByOptionalVisibleText(documentPlanCodeDDwn, program.getDocumentChecklistPlan());
		WebElementUtils.selectDropDownByOptionalVisibleText(mccRulePlanCodeDDwn, program.getMmcRulePlan());

		if (productType.equalsIgnoreCase(ProductType.PREPAID)) {
			WebElementUtils.selectDropDownByOptionalVisibleText(stmtPlanCodeDDwn, program.getPrepaidStatementPlan());
		}

		clickNextButton();
		if (productType.equalsIgnoreCase(ProductType.CREDIT)) {
			fillDataForCreditCard(program);
		}
	}

	private void fillDataForCreditCard(Program program) {
		WebElementUtils.enterText(creditLimitTxt, program.getCreditLimit());
		WebElementUtils.enterText(maximumCreditLimitTxt, program.getMaximumCreditLimit());
		WebElementUtils.selectDropDownByVisibleText(cashLimitTypeDDwn, program.getCashLimitType());
		WebElementUtils.enterText(cashLimitAmountTxt, program.getCashLimitAmount());
		WebElementUtils.selectDropDownByVisibleText(cashLimitResetDDwn, program.getCashLimitReset());
		WebElementUtils.selectDropDownByVisibleText(addOnLimitResetDDwn, program.getAddOnLimitReset());
	}

	public void verifyUiOperationStatus() {
		logger.info("Program");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(programSearchTxt));
	}
}
