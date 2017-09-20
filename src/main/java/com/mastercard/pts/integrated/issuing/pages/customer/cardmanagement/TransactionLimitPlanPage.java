package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.List;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionLimitPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionLimitPlanDetails;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP,
		CardManagementNav.L2_DEVICE_CONFIGURATION,
		CardManagementNav.L2_TRANSACTION_LIMIT_PLAN })
public class TransactionLimitPlanPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory
			.getLogger(TransactionLimitPlanPage.class);

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addTransactionLimitPlan;

	@PageElement(findBy = FindBy.NAME, valueToFind = "txnLimitPlanCode:input:inputTextField")
	private MCWebElement TransactionLimitPlanCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "description:input:inputTextField")
	private MCWebElement Description;

	@PageElement(findBy = FindBy.NAME, valueToFind = "productType:input:dropdowncomponent")
	private MCWebElement ProductType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "planType:input:dropdowncomponent")
	private MCWebElement PlanType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "txnLimitYearStartMonth:input:dropdowncomponent")
	private MCWebElement StartMonthForYearlyLimits;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save2;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addSubDetails;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionCode:input:dropdowncomponent")
	private MCWebElement TransactionType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionSource:input:dropdowncomponent")
	private MCWebElement TransactionSource;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionChannel:input:dropdowncomponent")
	private MCWebElement TransactionChannel;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionOrigin:input:dropdowncomponent")
	private MCWebElement TransactionOrigin;

	@PageElement(findBy = FindBy.NAME, valueToFind = "minAmount:input:inputAmountField")
	private MCWebElement FloorAmount;

	@PageElement(findBy = FindBy.NAME, valueToFind = "perTxnAmt:input:inputAmountField")
	private MCWebElement CeilingAmount;

	@PageElement(findBy = FindBy.NAME, valueToFind = "standInTxnOffAmt:input:inputAmountField")
	private MCWebElement StandInAmount;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#txnLimitPlanCode input")
	private MCWebElement planCodeSearchTxt;

	// iframe Locators
	@PageElement(findBy = FindBy.NAME, valueToFind = "txnLimitPlanCode:input:inputTextField")
	private MCWebElement iframeTransactionLimitPlanCodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "description:input:inputTextField")
	private MCWebElement iframedescriptionTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "productType:input:dropdowncomponent")
	private MCWebElement iframeproductTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "planType:input:dropdowncomponent")
	private MCWebElement iframePlanTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "txnLimitYearStartMonth:input:dropdowncomponent")
	private MCWebElement iframeStartMonthForYearlyLimitsDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionCode:input:dropdowncomponent")
	private MCWebElement iframeTransactionTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionSource:input:dropdowncomponent")
	private MCWebElement iframeTransactionSourceDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionChannel:input:dropdowncomponent")
	private MCWebElement iframeTransactionChannelDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionOrigin:input:dropdowncomponent")
	private MCWebElement iframeTransactionOriginDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "minAmount:input:inputAmountField")
	private MCWebElement iframeFloorAmountTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "minAmountResp:input:dropdowncomponent")
	private MCWebElement iframeFloorResponseDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "perTxnAmt:input:inputAmountField")
	private MCWebElement iframeCeilingAmountTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "perTxnAmtResp:input:dropdowncomponent")
	private MCWebElement iframeCeilingResponseDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "standInTxnOffAmt:input:inputAmountField")
	private MCWebElement iframeStandInAmountTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "standInTxnOffAmtResp:input:dropdowncomponent")
	private MCWebElement iframeStandInResponseDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "dailyAmt:input:inputAmountField")
	private MCWebElement iframeDailyAmountTxt;



	@PageElement(findBy = FindBy.NAME, valueToFind = "dailyAmt:input:inputAmountField")
	private MCWebElement iframeDailyAmountTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "dailyAmtResp:input:dropdowncomponent")
	private MCWebElement iframeDailyResponseDDwn;
	public void clickaddTransactionLimitPlan() {
		waitForElementVisible(addTransactionLimitPlan);
		addTransactionLimitPlan.click();
	}

	public void switchToAddTransactionLimitPlanFrame() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_TRANSACTION_LIMIT_PLAN_FRAME);
	}

	public String enterTransactionCode() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(TransactionLimitPlanCode, CustomUtils.randomNumbers(5));
		return TransactionLimitPlanCode.getAttribute("value");
	}

	public String enterTransactionDescription() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(Description, "transaction limit plan");
		return Description.getAttribute("value");
	}

	public void selectProduct(DeviceCreation deviceCreation) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectByVisibleText(ProductType, deviceCreation.getProduct());
	}

	public void selectStartMonthlyYearlyLimits() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectByVisibleText(StartMonthForYearlyLimits, transactionlimitDataProvider().getStartMonthForYearlyLimits());
	}

	public void selectPlanType(DeviceCreation deviceCreation) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectByVisibleText(PlanType, deviceCreation.getPlanType());
	}

	public void clickSaveButton() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		CustomUtils.ThreadDotSleep(1000);
		ClickButton(save);
		SwitchToDefaultFrame();
	}

	public void clickaddTransactionLimitDetails() {
		switchToIframe(Constants.ADD_TRANSACTION_LIMIT_PLAN_FRAME);
		waitForElementVisible(addSubDetails);
		addSubDetails.click();
	}

	public void switchToAddTransactionLimitdetailFrame() {
		SwitchToDefaultFrame();
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_TRANSACTION_LIMIT_DETAIL_PLAN_FRAME);
	}

	public void selectTransactionType() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectByVisibleText(TransactionType, transactionlimitDataProvider().getTransactionType());
	}

	public void selectTransactionSource() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(TransactionSource, 1);
	}

	public void selectTransactionChannel() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(TransactionChannel, 1);
	}

	public void selectTransactionOrigin() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(TransactionOrigin, 1);
	}

	public void enterFloorAmount() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(FloorAmount, transactionlimitDataProvider().getFloorAmount());
	}

	public void enterCeilingAmount() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(CeilingAmount, transactionlimitDataProvider().getCeilingAmount());
	}

	public void enterStandInAmount() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		if (StandInAmount.isEnabled()) {
			enterText(StandInAmount, transactionlimitDataProvider().getCeilingAmount());
		}
	}

	public void addtransactionlimitplan(String product, String planType, String flooramount, String ceilingamount,
			String startMonthForYearlyLimits) {
		addTransactionLimitPlan.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_TRANSACTION_LIMIT_PLAN_FRAME);
		enterText(TransactionLimitPlanCode, CustomUtils.randomNumbers(5));
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(Description, "transaction limit plan");
		SelectDropDownByText(ProductType, product);
		SelectDropDownByText(StartMonthForYearlyLimits, startMonthForYearlyLimits);

		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(PlanType, 1);
		ClickButton(save);
		addTransactionLimitDetails(flooramount, ceilingamount);
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_TRANSACTION_LIMIT_PLAN_FRAME);
		ClickButton(save);
		// addWicketAjaxListeners(getFinder().getWebDriver());
		SwitchToDefaultFrame();
	}

	public void addTransactionLimitDetails(String flooramount, String ceilingamount) {
		addSubDetails.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		SwitchToDefaultFrame();
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_TRANSACTION_LIMIT_DETAIL_PLAN_FRAME);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(TransactionType, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(TransactionSource, 1);
		SelectDropDownByIndex(TransactionChannel, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(TransactionOrigin, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(FloorAmount, flooramount);
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(CeilingAmount, ceilingamount);
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(StandInAmount, ceilingamount);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(save);
		SwitchToDefaultFrame();
	}

	public void addtransactionlimitplanprepaid() {
		addTransactionLimitPlan.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");

		// TransactionLimitPlanCode.sendKeys(env.getProperty("is.dinners.transactionlimitplan.TransactionLimitPlanCode"));
		TransactionLimitPlanCode.sendKeys(CustomUtils.randomNumbers(5));
		CustomUtils.ThreadDotSleep(1000);
		Description.sendKeys(env.getProperty("is.dinners.transactionlimitplanpr.Description"));
		ProductType.getSelect().selectByVisibleText(env.getProperty("is.dinners.transactionlimitplanpr.ProductType"));
		CustomUtils.ThreadDotSleep(1000);
		PlanType.getSelect().selectByVisibleText(env.getProperty("is.dinners.transactionlimitplanpr.PlanType"));
		CustomUtils.ThreadDotSleep(1000);
		StartMonthForYearlyLimits.getSelect()
				.selectByVisibleText(env.getProperty("is.dinners.transactionlimitplanpr.StartMonthForYearlyLimits"));
		CustomUtils.ThreadDotSleep(1000);

		save2.click();
		CustomUtils.ThreadDotSleep(2000);

		addSubDetails.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().defaultContent();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_16");
		CustomUtils.ThreadDotSleep(2000);

		TransactionType.getSelect()
				.selectByVisibleText(env.getProperty("is.dinners.transactionlimitplanpr.TransactionType"));
		CustomUtils.ThreadDotSleep(1000);
		TransactionSource.getSelect()
				.selectByVisibleText(env.getProperty("is.dinners.transactionlimitplanpr.TransactionSource"));
		CustomUtils.ThreadDotSleep(1000);
		TransactionChannel.getSelect()
				.selectByVisibleText(env.getProperty("is.dinners.transactionlimitplanpr.TransactionChannel"));
		CustomUtils.ThreadDotSleep(1000);
		TransactionOrigin.getSelect()
				.selectByVisibleText(env.getProperty("is.dinners.transactionlimitplanpr.TransactionOrigin"));
		CustomUtils.ThreadDotSleep(1000);
		FloorAmount.sendKeys(env.getProperty("is.dinners.transactionlimitplanpr.FloorAmount"));
		CustomUtils.ThreadDotSleep(1000);
		CeilingAmount.sendKeys(env.getProperty("is.dinners.transactionlimitplanpr.CeilingAmount"));
		CustomUtils.ThreadDotSleep(1000);
		// StandInAmount.sendKeys(env.getProperty("is.dinners.transactionlimitplan.StandInAmount"));

		save.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().defaultContent();

		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");
		CustomUtils.ThreadDotSleep(2000);
		save.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().defaultContent();

	}


	public void enterIframeTransactionLimitPlanCode(String deviceCode) {
		WebElementUtils
				.enterText(iframeTransactionLimitPlanCodeTxt, deviceCode);
	}

	public void enterIframeDescription(String descriptionData) {
		WebElementUtils.enterText(iframedescriptionTxt, descriptionData);
	}

	public void selectIframeProductType(String productType) {
		WebElementUtils.selectDropDownByVisibleText(iframeproductTypeDDwn,
				productType);
	}

	public void selectIframePlanType(String planType) {
		WebElementUtils.selectDropDownByVisibleText(iframePlanTypeDDwn,
				planType);
	}

	public void selectIframeStartMonthForYearlyLimits(String month) {
		WebElementUtils.selectDropDownByVisibleText(
				iframeStartMonthForYearlyLimitsDDwn, month);
	}

	public void selectIframeTransactionType(String transactionType) {
		WebElementUtils.selectDropDownByVisibleText(iframeTransactionTypeDDwn,
				transactionType);
	}

	public void selectIframeTransactionSource(String transactionSource) {
		WebElementUtils.selectDropDownByVisibleText(
				iframeTransactionSourceDDwn, transactionSource);
	}

	public void selectIframeTransactionChannel(String transactionChannel) {
		WebElementUtils.selectDropDownByVisibleText(
				iframeTransactionChannelDDwn, transactionChannel);
	}

	public void selectIframeTransactionOrigin(String transactionOrigin) {
		WebElementUtils.selectDropDownByVisibleText(
				iframeTransactionOriginDDwn, transactionOrigin);
	}

	public void enterIframeFloorAmount(String floorAmount) {
		WebElementUtils.enterText(iframeFloorAmountTxt, floorAmount);
	}

	public void selectIframeFloorResponse(String floorResponse) {
		WebElementUtils.selectDropDownByVisibleText(iframeFloorResponseDDwn,
				floorResponse);
	}

	public void enterIframeCeilingAmount(String ceilingAmount) {
		WebElementUtils.enterText(iframeCeilingAmountTxt, ceilingAmount);
	}

	public void selectIframeCeilingResponse(String ceilingResponse) {
		WebElementUtils.selectDropDownByVisibleText(iframeCeilingResponseDDwn,
				ceilingResponse);
	}

	public void enterIframeStandInAmount(String standInAmount) {
		WebElementUtils.enterText(iframeStandInAmountTxt, standInAmount);
	}

	public void selectIframeStandInResponse(String standInResponse) {
		WebElementUtils.selectDropDownByVisibleText(iframeStandInResponseDdwn,
				standInResponse);
	}

	public void enterIframeDailyAmount(String dailyAmount) {
		WebElementUtils.enterText(iframeDailyAmountTxt, dailyAmount);
	}

	public void selectIframeDailyResponse(String dailyResponse) {
		WebElementUtils.selectDropDownByVisibleText(iframeDailyResponseDDwn,
				dailyResponse);
	}

	public void createTransactionLimitPlan(
			TransactionLimitPlan transactionLimitPlanDataObject) {
		logger.info("Create Transaction Limit Plan: {}",
				transactionLimitPlanDataObject.getTransactionLimitPlanCode());
		clickAddNewButton();

		runWithinPopup(
				"Add Transaction Limit Plan",
				() -> {
					enterIframeTransactionLimitPlanCode(transactionLimitPlanDataObject
							.getTransactionLimitPlanCode());
					enterIframeDescription(transactionLimitPlanDataObject
							.getDescription());
					selectIframeProductType(transactionLimitPlanDataObject
							.getIframeproductType());
					selectIframePlanType(transactionLimitPlanDataObject
							.getIframePlanType());
					selectIframeStartMonthForYearlyLimits(transactionLimitPlanDataObject
							.getIframeStartMonthForYearlyLimits());
					clickAddDetailsButton();
					transactionLimitPlanDataObject
							.getTransactionLimitPlanDetails().forEach(
									details -> addDetails(details,
											transactionLimitPlanDataObject
													.getIframeproductType()));

					clickSaveButton();
				});

		verifyOperationStatus();
	}

	private void addDetails(TransactionLimitPlanDetails details,
			String productType) {
		clickAddNewButton();

		runWithinPopup("Add Transaction Limit Plan Detail",() -> {
					selectIframeTransactionType(details.getIframeTransactionType());
					selectIframeTransactionSource(details.getIframeTransactionSource());
					selectIframeTransactionChannel(details.getIframeTransactionChannel());
					selectIframeTransactionOrigin(details.getIframeTransactionOrigin());
					enterIframeFloorAmount(details.getIframeFloorAmount());
					selectIframeFloorResponse(details.getIframeFloorResponse());
					enterIframeCeilingAmount(details.getIframeCeilingAmount());
					selectIframeCeilingResponse(details.getIframeCeilingResponse());
					if (productType.equalsIgnoreCase(ProductType.DEBIT)) {
						enterIframeStandInAmount(details.getIframeCeilingAmount());
						selectIframeStandInResponse(details.getIframeCeilingResponse());
					}
					enterIframeDailyAmount(details.getIframeDailyAmount());
					selectIframeDailyResponse(details.getIframeDailyResponse());
					clickSaveButton();
				});

		verifyRecordMarkedForUpdationStatusSuccess();
	}

	public void verifyUiOperationStatus() {
		logger.info("Transaction Limit Plan");
		verifySearchButton("Search");
	}

	// Methods
	@Override
	protected List<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(planCodeSearchTxt));
	}

}
