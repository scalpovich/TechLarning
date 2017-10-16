package com.mastercard.pts.integrated.issuing.pages;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.MPTSBasePage;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class ProgramPage extends MPTSBasePage {
	final Logger logger = LoggerFactory.getLogger(EmbossingPriorityPassPage.class);

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

	public void addprogram(String programCode, String programDesc, String interchangeType, String productType,
			String programType, String baseCurrency, String currencyConversion, String calendarStartMon,
			String MaxBalanceWithoutKYC, String loadBalwithoutkYC, String devicePlanForProgram) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(addProgramBtn);
		switchToIframe(Constants.ADD_PROGRAM_FRAME);
		enterText(ProgramTxt, programCode);
		enterText(DescriptionTxt, programDesc);
		SelectDropDownByText(InterchangeDDwn, interchangeType);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(ProductDDwn, productType);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(ProgramTypeDDwn, programType);
		SelectDropDownByText(BaseCurrencyDDwn, baseCurrency);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(CurrencyConversionByDDwn, currencyConversion);
		SelectDropDownByText(CalendarStartMonthDDwn, calendarStartMon);
		// enterText(MaxBalWithoutKYCTxt, MaxBalanceWithoutKYC);
		// enterText(LoadsWithoutKYCTxt, loadBalwithoutkYC);
		ClickButton(NEXTBtn);
		SelectDropDownByIndex(WalletPlan1DDwn, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(DevicePlan1DDwn, devicePlanForProgram);
		addWicketAjaxListeners(getFinder().getWebDriver());
		// SelectDropDownByIndex(StatementMessagePlanDDwn, 1);
		// addWicketAjaxListeners(getFinder().getWebDriver());
		// SelectDropDownByIndex(MarketingMessagePlanDDwn, 1);
		ClickButton(NEXTBtn);
		ClickButton(NEXTBtn);
		ClickButton(FinishBtn);
		try {
			PanelErrorTxt.isVisible();
			logger.info("inside error pannel");
			ClickButton(CancelBtn);

		} catch (Exception e) {
			logger.info("error pannel not present");
			e.printStackTrace();
		}
		addWicketAjaxListeners(getFinder().getWebDriver());
		SwitchToDefaultFrame();
	}

	public void addprogramprepaid(String programCode, String programDesc, String interchangeType, String productType,
			String programType, String baseCurrency, String currencyConversion, String calendarStartMon,
			String MaxBalanceWithoutKYC, String loadBalwithoutkYC, String devicePlanForProgram) {
		// retryUntilNoErrors(() -> menuSubMenuPage.getDevicePlan().click());

		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(addProgramBtn);
		switchToIframe(Constants.ADD_PROGRAM_FRAME);
		enterText(ProgramTxt, programCode);
		enterText(DescriptionTxt, programDesc);
		SelectDropDownByText(InterchangeDDwn, interchangeType);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(ProductDDwn, productType);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(ProgramTypeDDwn, programType);
		SelectDropDownByText(BaseCurrencyDDwn, baseCurrency);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(CurrencyConversionByDDwn, currencyConversion);
		SelectDropDownByText(CalendarStartMonthDDwn, calendarStartMon);
		enterText(MaxBalWithoutKYCTxt, MaxBalanceWithoutKYC);
		enterText(LoadsWithoutKYCTxt, loadBalwithoutkYC);
		ClickButton(NEXTBtn);
		SelectDropDownByIndex(WalletPlan1DDwn, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(DevicePlan1DDwn, devicePlanForProgram);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(StatementMessagePlanDDwn, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(MarketingMessagePlanDDwn, 1);
		ClickButton(NEXTBtn);
		ClickButton(NEXTBtn);
		ClickButton(FinishBtn);
		try {
			PanelErrorTxt.isVisible();
			logger.info("inside error pannel");
			ClickButton(CancelBtn);

		} catch (Exception e) {
			logger.info("error pannel not present");
			e.printStackTrace();
		}
		addWicketAjaxListeners(getFinder().getWebDriver());
		SwitchToDefaultFrame();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}
