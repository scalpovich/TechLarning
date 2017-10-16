package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Collection;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1PROGRAM_SETUP,
		CardManagementNav.L2PROGRAM })
public class ProgramPage extends AbstractBasePage {
	final Logger logger = LoggerFactory.getLogger(ProgramPage.class);

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

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:walletPlanCode2:input:dropdowncomponent")
	private MCWebElement WalletPlan2DDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:walletPlanCode3:input:dropdowncomponent")
	private MCWebElement WalletPlan3DDwn;

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

	public void clickAddProgram() {
		clickWhenClickable(addProgramBtn);
		switchToAddProgramframe();
	}

	public void switchToAddProgramframe() {
		switchToIframe(Constants.ADD_PROGRAM_FRAME);
	}

	public String enterProgramCode() {
		waitForElementVisible(ProgramTxt);
		if (MapUtils.fnGetInputDataFromMap("ProgramCode") != null) {
			enterValueinTextBox(ProgramTxt, MapUtils.fnGetInputDataFromMap("ProgramCode"));
		} else {
			enterValueinTextBox(ProgramTxt, CustomUtils.randomNumbers(4));
		}
		return ProgramTxt.getAttribute("value");
	}

	public String enterProgramDescription() {
		enterValueinTextBox(DescriptionTxt, "programDescription" + CustomUtils.randomNumbers(2));
		return DescriptionTxt.getAttribute("value");
	}

	public void selectInterchange(Program program) {
		selectByVisibleText(InterchangeDDwn, program.getInterchange());
	}

	public void selectProduct(DeviceCreation deviceCreation) {
		selectByVisibleText(ProductDDwn, deviceCreation.getProduct());
	}

	public void selectRefundinCurrency(Program program) {
		if (RefundinCurrencyDDwn.isEnabled()) {
			selectByVisibleText(RefundinCurrencyDDwn, program.getRefundInCurrency());
		}
	}

	public void selectProgramType(Program program) {
		selectByVisibleText(ProgramTypeDDwn, program.getProgramType());
	}

	public void selectBaseCurrency(Program program) {
		selectByVisibleText(BaseCurrencyDDwn, program.getCurrency());
	}

	public void selectCurrencyConversionBy(Program program) {
		selectByVisibleText(CurrencyConversionByDDwn, program.getCurrencyConversionBy());

	}

	public void enterNoOfCurrencyAllowed() {
		waitForElementVisible(ProductDDwn);
		NoOfCurrencyAllowed.clearField();
		Alert alert = getFinder().getWebDriver().switchTo().alert();
		logger.info(alert.getText());
		alert.accept();
		enterValueinTextBox(NoOfCurrencyAllowed, "3");
	}

	public void selectWalletToWalletTransfer() {
		SelectDropDownByIndex(WalletToWalletTransferType, 1);
	}

	public void selectReferenceCurrency(Program program) {
		if (ReferenceCurrency.isEnabled()) {
			selectByVisibleText(ReferenceCurrency, program.getCurrency());
		}
	}

	public void selectCalendarStartMonth() {
		SelectDropDownByIndex(CalendarStartMonthDDwn, 1);
	}

	public void enterMaximumBalanceWithoutKYC(Program program) {
		enterValueinTextBox(MaxBalWithoutKYCTxt, program.getMaxBalanceWithoutKYC());
	}

	public void enterLoadsWithoutKYC(Program program) {
		enterValueinTextBox(LoadsWithoutKYCTxt, program.getLoadsWithoutKYC());
	}

	public void clickNextButton() {
		ClickButton(NEXTBtn);
	}

	public void selectWalletPlan1() {
		if (MapUtils.fnGetInputDataFromMap("WalletPlan") != null) {
			selectByVisibleText(WalletPlan1DDwn, MapUtils.fnGetInputDataFromMap("WalletPlan"));
		} else {
			SelectDropDownByIndex(WalletPlan1DDwn, 1);
		}
	}

	public void selectWalletPlan2() {
		waitForElementVisible(WalletPlan2DDwn);
		if (MapUtils.fnGetInputDataFromMap("WalletPlan2") != null) {
			selectByVisibleText(WalletPlan2DDwn, MapUtils.fnGetInputDataFromMap("WalletPlan2"));
		} else {
			SelectDropDownByIndex(WalletPlan2DDwn, 2);
		}
	}

	public void selectWalletPlan3() {
		waitForElementVisible(WalletPlan3DDwn);
		if (MapUtils.fnGetInputDataFromMap("WalletPlan3") != null) {
			selectByVisibleText(WalletPlan3DDwn, MapUtils.fnGetInputDataFromMap("WalletPlan3"));
		} else {
			SelectDropDownByIndex(WalletPlan3DDwn, 3);
		}
	}

	public void selectDevicePlan1(Program program) {
		waitForElementVisible(DevicePlan1DDwn);
		if (MapUtils.fnGetInputDataFromMap("DevicePlanForProgram") != null) {
			selectByVisibleText(DevicePlan1DDwn, MapUtils.fnGetInputDataFromMap("DevicePlanForProgram"));
		} else {
			selectByVisibleText(DevicePlan1DDwn, program.getDevicePlanProgram());
		}
	}

	public void selectStatementMessagePlan() {
		waitForElementVisible(StatementMessagePlanDDwn);
		SelectDropDownByIndex(StatementMessagePlanDDwn, 1);
	}

	public void selectMarketingMessagePlan() {
		waitForElementVisible(MarketingMessagePlanDDwn);
		SelectDropDownByIndex(MarketingMessagePlanDDwn, 1);

	}

	public void clickFinishButton() {
		clickWhenClickable(FinishBtn);
		SwitchToDefaultFrame();

	}

	public boolean verifyErrorsOnProgramPage() {
		return publishErrorOnPage();
	}

	public void verifyNewProgramSuccess() {
		if (!verifyErrorsOnProgramPage()) {
			logger.info("Program Added Successfully");
			SwitchToDefaultFrame();
		} else {
			logger.info("Error in Record Addition");
			clickWhenClickable(CancelBtn);
			SwitchToDefaultFrame();
		}
	}

	public String addProgramGeneral(DeviceCreation devicecreation, Program program) {
		String programCode;
		String ProgramDescription;
		programCode = enterProgramCode();
		ProgramDescription = enterProgramDescription();
		selectInterchange(program);
		selectProduct(devicecreation);
		selectProgramType(program);
		selectBaseCurrency(program);
		selectCurrencyConversionBy(program);
		selectCalendarStartMonth();
		return ProgramDescription + " " + "[" + programCode + "]";
	}

	public String addProgramGeneralMultiCurrency(DeviceCreation devicecreation, Program program) {
		String programCode;
		String ProgramDescription;
		programCode = enterProgramCode();
		ProgramDescription = enterProgramDescription();
		selectInterchange(program);
		selectProduct(devicecreation);
		selectProgramType(program);
		selectBaseCurrency(program);
		enterNoOfCurrencyAllowed();
		selectCurrencyConversionBy(program);
		selectCalendarStartMonth();
		selectWalletToWalletTransfer();
		selectReferenceCurrency(program);
		return ProgramDescription + " " + "[" + programCode + "]";
	}

	public void addKYCLimits(Program program) {
		enterMaximumBalanceWithoutKYC(program);
		enterLoadsWithoutKYC(program);
	}

	public void selectLoadAndRefundParameters(Program program) {
		selectRefundinCurrency(program);
	}

	public void selectWalletPLan() {
		selectWalletPlan1();
		selectWalletPlan2();
		selectWalletPlan3();
	}

	public void selectDevicePlan(Program program) {
		selectDevicePlan1(program);
	}

	public void selectOtherPlans() {
		selectStatementMessagePlan();
		selectMarketingMessagePlan();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return null;
	}

}
