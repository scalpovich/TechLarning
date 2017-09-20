package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MarketingMessagePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PrepaidStatementPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.StatementMessagePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Walletplan;
import com.mastercard.pts.integrated.issuing.pages.MenuSubMenuPage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP, CardManagementNav.L2_PROGRAM })
public class ProgramPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory
			.getLogger(ProgramPage.class);
	@Autowired
	Walletplan walletplan;

	@Autowired
	DevicePlan deviceplan;

	@Autowired
	StatementMessagePlan statementmessageplan;

	@Autowired
	MarketingMessagePlan marketingmessageplan;

	@Autowired
	PrepaidStatementPlan prepaidstatementplan;

	@Autowired
	MenuSubMenuPage menuSubMenuPage;
	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addProgramBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:programCode:input:inputTextField")
	private MCWebElement ProgramTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:description:input:inputTextField")
	private MCWebElement DescriptionTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:networkCode:input:dropdowncomponent")
	private MCWebElement InterchangeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:productType:input:dropdowncomponent")
	private MCWebElement ProductDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:programType:input:dropdowncomponent")
	private MCWebElement ProgramTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:currencyCode:input:dropdowncomponent")
	private MCWebElement BaseCurrencyDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:optionalCurrencyConvFlag:input:dropdowncomponent")
	private MCWebElement CurrencyConversionByDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:calendarMonth:input:dropdowncomponent")
	private MCWebElement CalendarStartMonthDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/form/table/tbody/tr/td[2]/table/tbody/tr[4]/td/span/table/tbody/tr/td/span[2]/input")
	private MCWebElement NEXTBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:maxBalanceBefKyc:input:inputAmountField")
	private MCWebElement MaxBalWithoutKYCTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:noOfLoadBefKyc:input:inputTextField")
	private MCWebElement LoadsWithoutKYCTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:walletPlanCode1:input:dropdowncomponent")
	private MCWebElement WalletPlan1DDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:devicePlanCode1:input:dropdowncomponent")
	private MCWebElement DevicePlan1DDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:statMsgCode:input:dropdowncomponent")
	private MCWebElement StatementMessagePlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:mktMsgPlanCode:input:dropdowncomponent")
	private MCWebElement MarketingMessagePlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:creditLimit:input:inputTextField")
	private MCWebElement CreditLimitTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:maxCreditLimit:input:inputTextField")
	private MCWebElement MaxCreditLimitTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cashLimitMethod:input:dropdowncomponent")
	private MCWebElement CashLimitTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cashLimitFixed:input:inputTextField")
	private MCWebElement CashLimitAmountTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:refundInCurrency:input:dropdowncomponent")
	private MCWebElement RefundinCurrencyDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelINFO']")
	private MCWebElement PanelInfo;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:noOfCurrencyAllowed:input:inputTextField")
	private MCWebElement NoOfCurrencyAllowed;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:transferType:input:dropdowncomponent")
	private MCWebElement WalletToWalletTransferType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:referenceCurrency:input:dropdowncomponent")
	private MCWebElement ReferenceCurrency;

	/*
	 * @PageElement(findBy = FindBy.NAME, valueToFind =
	 * "view:cashLimitVariable:input:inputTextField") private MCWebElement
	 * PercentageofCreditLimit;
	 */

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cashLimitCycleIndicatior:input:dropdowncomponent")
	private MCWebElement CashLimitResetDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:addOnLimitCycleIndicatior:input:dropdowncomponent")
	private MCWebElement AddOnLimitResetDDwn;

	/*
	 * @PageElement(findBy = FindBy.NAME, valueToFind = "Textbox_NAME") private
	 * MCWebElement NEXT2;
	 */
	@PageElement(findBy = FindBy.NAME, valueToFind = "buttons:finish")
	private MCWebElement FinishBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelERROR']")
	private MCWebElement PanelErrorTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "buttons:cancel")
	private MCWebElement CancelBtn;

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

	public void clickAddProgram() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(addProgramBtn);
	}

	public void switchToAddProgramframe() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_PROGRAM_FRAME);
	}

	public String enterProgramCode() {
		waitForElementVisible(ProgramTxt);
		enterText(ProgramTxt, CustomUtils.randomNumbers(4));
		return ProgramTxt.getAttribute("value");
	}

	public String enterProgramDescription() {
		waitForElementVisible(ProgramTxt);
		enterText(DescriptionTxt, "program");
		return DescriptionTxt.getAttribute("value");
	}

	public void selectInterchange(DeviceCreation deviceCreation) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectByVisibleText(InterchangeDDwn, deviceCreation.getInterchange());
	}

	public void selectProduct(DeviceCreation deviceCreation) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(ProductDDwn);
		CustomUtils.ThreadDotSleep(1000);
		selectByVisibleText(ProductDDwn, deviceCreation.getProduct());
	}

	public void selectRefundinCurrency() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		if (RefundinCurrencyDDwn.isEnabled()) {
			CustomUtils.ThreadDotSleep(1000);
			selectByVisibleText(RefundinCurrencyDDwn, ProgramDataProvider().getRefundInCurrency());
		}
	}

	public void selectProgramType() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(ProgramTypeDDwn);
		CustomUtils.ThreadDotSleep(1000);
		System.out.println(getProgramType());
		selectByVisibleText(ProgramTypeDDwn, getProgramType());
	}

	public void selectBaseCurrency() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectByVisibleText(BaseCurrencyDDwn, ProgramDataProvider().getCurrency());
	}

	public void selectCurrencyConversionBy() {
		CustomUtils.ThreadDotSleep(1000);
		selectByVisibleText(CurrencyConversionByDDwn, ProgramDataProvider().getCurrencyConversionBy());
		addWicketAjaxListeners(getFinder().getWebDriver());
	}

	public void enterNoOfCurrencyAllowed() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(ProductDDwn);
		NoOfCurrencyAllowed.clearField();
		Alert alert = getFinder().getWebDriver().switchTo().alert();
		logger.info(alert.getText());
		alert.accept();
		enterText(NoOfCurrencyAllowed, "3");
	}

	public void selectWalletToWalletTransfer() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(WalletToWalletTransferType, 1);
	}

	public void selectReferenceCurrency() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		if (ReferenceCurrency.isEnabled()) {
			selectByVisibleText(ReferenceCurrency, ProgramDataProvider().getCurrency());
		}
	}

	public void selectCalendarStartMonth() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(CalendarStartMonthDDwn, 1);
	}

	public void enterMaximumBalanceWithoutKYC() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(MaxBalWithoutKYCTxt, ProgramDataProvider().getMaxBalanceWithoutKYC());
	}

	public void enterLoadsWithoutKYC() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(LoadsWithoutKYCTxt, ProgramDataProvider().getLoadsWithoutKYC());
	}

	public void clickNextButton() {
		CustomUtils.ThreadDotSleep(1000);
		ClickButton(NEXTBtn);
	}

	public void selectWalletPlan() {
		CustomUtils.ThreadDotSleep(1000);
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(WalletPlan1DDwn);
		selectByVisibleText(WalletPlan1DDwn, walletplan.getWalletPlan());
	}

	public void selectDevicePlan() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(DevicePlan1DDwn);
		CustomUtils.ThreadDotSleep(1000);
		selectByVisibleText(DevicePlan1DDwn, deviceplan.getDevicePlan());
	}

	public void selectStatementMessagePlan() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(StatementMessagePlanDDwn);
		CustomUtils.ThreadDotSleep(1000);
		SelectDropDownByIndex(StatementMessagePlanDDwn, 1);
	}

	public void selectMarketingMessagePlan() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(MarketingMessagePlanDDwn);
		CustomUtils.ThreadDotSleep(1000);
		SelectDropDownByIndex(MarketingMessagePlanDDwn, 1);

	}

	public void clickFinishButton() {
		waitForElementVisible(FinishBtn);
		ClickButton(FinishBtn);
		CustomUtils.ThreadDotSleep(2000);
		try {
			if (PanelInfo.isVisible()) {
				Assert.assertEquals(PanelInfo.getText(), Constants.Record_Added_Successfully);
			}
		} catch (Exception e) {
			logger.error(e.toString());
			try {
				if (PanelErrorTxt.isVisible()) {
					logger.info("inside error pannel");
					CancelBtn.click();
				}
			} catch (Exception e1) {
				logger.error(e1.toString());
				logger.info("error pannel not present");
			}
		}
		SwitchToDefaultFrame();

	}

	public void addprogram(String programCode, String programDesc, String interchangeType, String productType,
			String programType, String baseCurrency, String currencyConversion, String calendarStartMon,
			String MaxBalanceWithoutKYC, String loadBalwithoutkYC, String devicePlanForProgram) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(addProgramBtn);
		switchToIframe(Constants.ADD_PROGRAM_FRAME);
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(ProgramTxt);
		enterText(ProgramTxt, programCode);
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(DescriptionTxt, programDesc);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(InterchangeDDwn, interchangeType);
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(ProductDDwn);
		CustomUtils.ThreadDotSleep(1000);
		SelectDropDownByText(ProductDDwn, productType);
		addWicketAjaxListeners(getFinder().getWebDriver());
		if (productType.equals(Constants.Product_Type_Debit)) {
			addWicketAjaxListeners(getFinder().getWebDriver());
			waitForElementVisible(ProgramTypeDDwn);
			SelectDropDownByText(ProgramTypeDDwn, programType);
		} else {
			addWicketAjaxListeners(getFinder().getWebDriver());
			waitForElementVisible(ProgramTypeDDwn);
			CustomUtils.ThreadDotSleep(1000);
			SelectDropDownByText(ProgramTypeDDwn, "Retail General Purpose Card [4]");
		}

		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(BaseCurrencyDDwn, baseCurrency);
		addWicketAjaxListeners(getFinder().getWebDriver());
		CustomUtils.ThreadDotSleep(1000);
		SelectDropDownByText(CurrencyConversionByDDwn, currencyConversion);
		addWicketAjaxListeners(getFinder().getWebDriver());
		CustomUtils.ThreadDotSleep(1000);
		SelectDropDownByText(CalendarStartMonthDDwn, calendarStartMon);
		addWicketAjaxListeners(getFinder().getWebDriver());
		if (productType.equals(Constants.Product_Type_Prepaid)) {
			addWicketAjaxListeners(getFinder().getWebDriver());
			enterText(MaxBalWithoutKYCTxt, MaxBalanceWithoutKYC);
			addWicketAjaxListeners(getFinder().getWebDriver());
			enterText(LoadsWithoutKYCTxt, loadBalwithoutkYC);
		}
		CustomUtils.ThreadDotSleep(1000);
		ClickButton(NEXTBtn);

		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(WalletPlan1DDwn);
		SelectDropDownByIndex(WalletPlan1DDwn, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(DevicePlan1DDwn);
		CustomUtils.ThreadDotSleep(2000);
		SelectDropDownByText(DevicePlan1DDwn, devicePlanForProgram);
		addWicketAjaxListeners(getFinder().getWebDriver());
		if (productType.equals(Constants.Product_Type_Prepaid)) {
			SelectDropDownByIndex(StatementMessagePlanDDwn, 1);
			addWicketAjaxListeners(getFinder().getWebDriver());
			SelectDropDownByIndex(MarketingMessagePlanDDwn, 1);
			addWicketAjaxListeners(getFinder().getWebDriver());
		}
		CustomUtils.ThreadDotSleep(2000);
		ClickButton(NEXTBtn);
		addWicketAjaxListeners(getFinder().getWebDriver());
		CustomUtils.ThreadDotSleep(2000);
		ClickButton(NEXTBtn);
		addWicketAjaxListeners(getFinder().getWebDriver());
		CustomUtils.ThreadDotSleep(2000);
		ClickButton(FinishBtn);
		CustomUtils.ThreadDotSleep(2000);
		try {
			PanelErrorTxt.isVisible();
			logger.info("inside error pannel");
			ClickButton(CancelBtn);

		} catch (Exception e) {
			logger.info("error pannel not present");
			e.printStackTrace();
		}
		SwitchToDefaultFrame();
	}

	public void addprogramprepaid(String programCode, String programDesc, String interchangeType, String productType,
			String programType, String baseCurrency, String currencyConversion, String calendarStartMon,
			String MaxBalanceWithoutKYC, String loadBalwithoutkYC) {
		// retryUntilNoErrors(() -> menuSubMenuPage.getDevicePlan().click());

		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(addProgramBtn);
		switchToIframe(Constants.ADD_PROGRAM_FRAME);
		enterText(ProgramTxt, programCode);
		enterText(DescriptionTxt, programDesc);
		SelectDropDownByText(InterchangeDDwn, interchangeType);
		waitForElementVisible(ProductDDwn);
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(ProductDDwn);
		SelectDropDownByText(ProductDDwn, productType);
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(ProgramTypeDDwn);
		SelectDropDownByText(ProgramTypeDDwn, programType);
		waitForElementVisible(BaseCurrencyDDwn);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(BaseCurrencyDDwn, baseCurrency);
		waitForElementVisible(CurrencyConversionByDDwn);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(CurrencyConversionByDDwn, currencyConversion);
		waitForElementVisible(CurrencyConversionByDDwn);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(CalendarStartMonthDDwn, calendarStartMon);
		enterText(MaxBalWithoutKYCTxt, MaxBalanceWithoutKYC);
		enterText(LoadsWithoutKYCTxt, loadBalwithoutkYC);
		ClickButton(NEXTBtn);
		SelectDropDownByIndex(WalletPlan1DDwn, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(DevicePlan1DDwn, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(StatementMessagePlanDDwn, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(MarketingMessagePlanDDwn, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(NEXTBtn);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(NEXTBtn);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(FinishBtn);
		try {
			PanelErrorTxt.isVisible();
			logger.info("inside error pannel");
			ClickButton(CancelBtn);

		} catch (Exception e) {
			logger.info("error pannel not present");
			e.printStackTrace();
		}

		SwitchToDefaultFrame();
	}
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
