package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionLimitPlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionLimitPlanDetails;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1PROGRAM_SETUP, CardManagementNav.L2_TRANSACTION_LIMIT_PLAN })
public class TransactionLimitPlanPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(TransactionLimitPlanPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "dailyVel:input:inputAmountField")
	private MCWebElement dailyVelocityTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "periodicAmt:input:inputAmountField")
	private MCWebElement periodicAmtTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "periodicVel:input:inputAmountField")
	private MCWebElement periodicVelTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "yearlyAmt:input:inputAmountField")
	private MCWebElement yearlyAmtTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "yearlyVel:input:inputAmountField")
	private MCWebElement yearlyVelTxt;

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

	@PageElement(findBy = FindBy.NAME, valueToFind = "dailyAmtResp:input:dropdowncomponent")
	private MCWebElement iframeDailyResponseDDwn;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addTransactionLimitPlanBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=txnLimitPlanCode]")
	private MCWebElement transactionLimitPlanCodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "description:input:inputTextField")
	private MCWebElement descriptionTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "productType:input:dropdowncomponent")
	private MCWebElement productTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "planType:input:dropdowncomponent")
	private MCWebElement planTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "txnLimitYearStartMonth:input:dropdowncomponent")
	private MCWebElement startMonthForYearlyLimitsDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save2Btn;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addSubDetailsBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionCode:input:dropdowncomponent")
	private MCWebElement transactionTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionSource:input:dropdowncomponent")
	private MCWebElement transactionSourceDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionChannel:input:dropdowncomponent")
	private MCWebElement transactionChannelDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionOrigin:input:dropdowncomponent")
	private MCWebElement transactionOriginDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "minAmount:input:inputAmountField")
	private MCWebElement floorAmountTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "perTxnAmt:input:inputAmountField")
	private MCWebElement ceilingAmountTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "standInTxnOffAmt:input:inputAmountField")
	private MCWebElement standInAmountTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement cancelBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "authPeriodCode:input:dropdowncomponent")
	private MCWebElement periodicityDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "periodNumber:input:inputTextField")
	private MCWebElement periodicityNumberTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//form//a[@class='addR']")
	private MCWebElement addNewBtn;

	public void verifyUiOperationStatus() {
		logger.info("Transaction Limit Plan");
		verifySearchButton("Search");
	}

	@Override
	protected List<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(planCodeSearchTxt));
	}

	public void enterIframeTransactionLimitPlanCode(String deviceCode) {
		WebElementUtils.enterText(iframeTransactionLimitPlanCodeTxt, deviceCode);
	}

	public void enterIframeDescription(String descriptionData) {
		WebElementUtils.enterText(iframedescriptionTxt, descriptionData);
	}

	public void selectIframeProductType(String productType) {
		WebElementUtils.selectDropDownByVisibleText(iframeproductTypeDDwn, productType);
	}

	public void selectIframePlanType(String planType) {
		WebElementUtils.selectDropDownByVisibleText(iframePlanTypeDDwn, planType);
	}

	public void selectIframeStartMonthForYearlyLimits(String month) {
		WebElementUtils.selectDropDownByVisibleText(iframeStartMonthForYearlyLimitsDDwn, month);
	}

	public void selectIframeTransactionType(String transactionType) {
		WebElementUtils.selectDropDownByVisibleText(iframeTransactionTypeDDwn, transactionType);
	}

	public void selectIframeTransactionSource(String transactionSource) {
		WebElementUtils.selectDropDownByVisibleText(iframeTransactionSourceDDwn, transactionSource);
	}

	public void selectIframeTransactionChannel(String transactionChannel) {
		WebElementUtils.selectDropDownByVisibleText(iframeTransactionChannelDDwn, transactionChannel);
	}

	public void selectIframeTransactionOrigin(String transactionOrigin) {
		WebElementUtils.selectDropDownByVisibleText(iframeTransactionOriginDDwn, transactionOrigin);
	}

	public void enterIframeFloorAmount(String floorAmount) {
		WebElementUtils.enterText(iframeFloorAmountTxt, floorAmount);
	}

	public void selectIframeFloorResponse(String floorResponse) {
		WebElementUtils.selectDropDownByVisibleText(iframeFloorResponseDDwn, floorResponse);
	}

	public void enterIframeCeilingAmount(String ceilingAmount) {
		WebElementUtils.enterText(iframeCeilingAmountTxt, ceilingAmount);
	}

	public void selectIframeCeilingResponse(String ceilingResponse) {
		WebElementUtils.selectDropDownByVisibleText(iframeCeilingResponseDDwn, ceilingResponse);
	}

	public void enterIframeStandInAmount(String standInAmount) {
		WebElementUtils.enterText(iframeStandInAmountTxt, standInAmount);
	}

	public void selectIframeStandInResponse(String standInResponse) {
		WebElementUtils.selectDropDownByVisibleText(iframeStandInResponseDdwn, standInResponse);
	}

	public void enterIframeDailyAmount(String dailyAmount) {
		WebElementUtils.enterText(iframeDailyAmountTxt, dailyAmount);
	}

	public void selectIframeDailyResponse(String dailyResponse) {
		WebElementUtils.selectDropDownByVisibleText(iframeDailyResponseDDwn, dailyResponse);
	}

	public void createTransactionLimitPlan(TransactionLimitPlan transactionLimitPlanDataObject) {
		logger.info("Create Transaction Limit Plan: {}", transactionLimitPlanDataObject.getTransactionLimitPlanCode());
		clickAddNewButton();

		runWithinPopup("Add Transaction Limit Plan", () -> {
			enterIframeTransactionLimitPlanCode(transactionLimitPlanDataObject.getTransactionLimitPlanCode());
			enterIframeDescription(transactionLimitPlanDataObject.getDescription());
			selectIframeProductType(transactionLimitPlanDataObject.getIframeproductType());
			selectIframePlanType(transactionLimitPlanDataObject.getIframePlanType());
			selectIframeStartMonthForYearlyLimits(transactionLimitPlanDataObject.getIframeStartMonthForYearlyLimits());
			clickAddDetailsButton();
			transactionLimitPlanDataObject.getTransactionLimitPlanDetails().forEach(details -> addDetails(details, transactionLimitPlanDataObject.getIframeproductType()));
			WebElementUtils.scrollDown(driver(), 0, 250);
			clickSaveButton();
		});

		verifyOperationStatus();
	}

	public void createTransactionLimitPlanWithoutDetails(TransactionLimitPlan transactionLimitPlanDataObject) {
		logger.info("Create Transaction Limit Plan: {}", transactionLimitPlanDataObject.getTransactionLimitPlanCode());
		clickAddNewButton();
		runWithinPopup("Add Transaction Limit Plan", () -> {
			enterIframeTransactionLimitPlanCode(transactionLimitPlanDataObject.getTransactionLimitPlanCode());
			enterIframeDescription(transactionLimitPlanDataObject.getDescription());
			selectIframeProductType(transactionLimitPlanDataObject.getIframeproductType());
			WebElementUtils.selectDropDownByIndex(iframePlanTypeDDwn, 1);
			WebElementUtils.selectDropDownByIndex(periodicityDDwn, 2);
			WebElementUtils.enterText(periodicityNumberTxt, "9");
			WebElementUtils.selectDropDownByIndex(iframeStartMonthForYearlyLimitsDDwn, 1);
			clickAddDetailsButton();
		});
	}

	public void addEachDetail(TransactionLimitPlan transactionLimitPlanDataObject) {
		try {
			switchToIframe(Constants.ADD_TRANSACTION_LIMIT_PLAN_FRAME);
		} catch (TimeoutException te) {
			logger.debug(te.getMessage(), te);
		}
		clickWhenClickable(addNewBtn);
		transactionLimitPlanDataObject.getTransactionLimitPlanDetails().forEach(details -> addDetails(details, transactionLimitPlanDataObject.getIframeproductType()));
		WebElementUtils.scrollDown(driver(), 0, 250);
	}

	private void addDetails(TransactionLimitPlanDetails details, String productType) {
		clickAddNewButton();
		runWithinPopup("Add Transaction Limit Plan Detail", () -> {
			selectIframeTransactionType(details.getIframeTransactionType());
			waitForWicket();
			selectIframeTransactionSource(details.getIframeTransactionSource());
			waitForWicket();
			selectIframeTransactionChannel(details.getIframeTransactionChannel());
			waitForWicket();
			selectIframeTransactionOrigin(details.getIframeTransactionOrigin());
			enterIframeFloorAmount(details.getIframeFloorAmount());
			selectIframeFloorResponse(details.getIframeFloorResponse());
			enterIframeCeilingAmount(details.getIframeCeilingAmount());
			selectIframeCeilingResponse(details.getIframeCeilingResponse());
			enterIframeDailyAmount(details.getIframeDailyAmount());
			selectIframeDailyResponse(details.getIframeDailyResponse());
			enterDailyVelocity(details.getLimitDailyVelocity());
			enterPeriodicAmt(details.getLimitPeriodicAmount());
			enterPeriodicVel(details.getLimitPeriodicVelocity());
			enterYearlyData(details);
			clickWhenClickable(saveBtn);
		});
	}

	private void enterYearlyData(TransactionLimitPlanDetails details) {
		enterYearlyAmt(details.getLimitYearlyAmount());
		enterYearlyVel(details.getLimitYearlyVelocity());
	}

	private void enterYearlyVel(String limitYearlyVelocity) {
		WebElementUtils.enterText(yearlyVelTxt, limitYearlyVelocity);
	}

	private void enterYearlyAmt(String limitYearlyAmount) {
		WebElementUtils.enterText(yearlyAmtTxt, limitYearlyAmount);
	}

	private void enterPeriodicVel(String limitPeriodicVelocity) {
		WebElementUtils.enterText(periodicVelTxt, limitPeriodicVelocity);
	}

	private void enterPeriodicAmt(String limitPeriodicAmount) {
		WebElementUtils.enterText(periodicAmtTxt, limitPeriodicAmount);
	}

	private void enterDailyVelocity(String limitDailyVelocity) {
		WebElementUtils.enterText(dailyVelocityTxt, limitDailyVelocity);
	}

	public void clickAddTransactionLimitPlan() {
		clickWhenClickable(addTransactionLimitPlanBtn);
		switchToAddTransactionLimitPlanFrame();
	}

	public void switchToAddTransactionLimitPlanFrame() {
		switchToIframe(Constants.ADD_TRANSACTION_LIMIT_PLAN_FRAME);
	}

	public String enterTransactionCode() {
		enterValueinTextBox(transactionLimitPlanCodeTxt, CustomUtils.randomNumbers(5));
		return transactionLimitPlanCodeTxt.getAttribute("value");
	}

	public String enterTransactionDescription() {
		enterValueinTextBox(descriptionTxt, "transaction limit plan");
		return descriptionTxt.getAttribute("value");
	}

	public void selectProduct(DeviceCreation deviceCreation) {
		selectByVisibleText(productTypeDDwn, deviceCreation.getProduct());
	}

	public void selectStartMonthlyYearlyLimits(TransactionLimitPlan transactionlimitplan) {
		selectByVisibleText(startMonthForYearlyLimitsDDwn, transactionlimitplan.getStartMonthForYearlyLimits());
	}

	public void selectPlanType(DeviceCreation deviceCreation) {
		selectByVisibleText(planTypeDDwn, deviceCreation.getPlanType());
	}

	@Override
	public void clickSaveButton() {
		clickWhenClickable(saveBtn);
		waitForLoaderToDisappear();
		switchToDefaultFrame();
	}

	public void clickaddTransactionLimitDetails() {
		switchToAddTransactionLimitPlanFrame();
		clickWhenClickable(addSubDetailsBtn);
		switchToAddTransactionLimitdetailFrame();
	}

	public void switchToAddTransactionLimitdetailFrame() {
		switchToDefaultFrame();
		switchToIframe(Constants.ADD_TRANSACTION_LIMIT_DETAIL_PLAN_FRAME);
	}

	public void selectTransactionType(TransactionLimitPlan transactionlimitplan) {
		waitForElementVisible(transactionTypeDDwn);
		selectByVisibleText(transactionTypeDDwn, transactionlimitplan.getTransactionType());
		waitForLoaderToDisappear();
	}

	public void selectTransactionSource() {
		waitForElementVisible(transactionSourceDDwn);
		selectDropDownByIndex(transactionSourceDDwn, 1);
		waitForLoaderToDisappear();
	}

	public void selectTransactionChannel() {
		waitForElementVisible(transactionChannelDDwn);
		selectDropDownByIndex(transactionChannelDDwn, 1);
		waitForLoaderToDisappear();
	}

	public void selectTransactionOrigin() {
		waitForElementVisible(transactionOriginDDwn);
		selectDropDownByIndex(transactionOriginDDwn, 1);
		waitForLoaderToDisappear();
	}

	public void enterFloorAmount(TransactionLimitPlan transactionlimitplan) {
		waitForElementVisible(floorAmountTxt);
		enterValueinTextBox(floorAmountTxt, transactionlimitplan.getFloorAmount());
		waitForLoaderToDisappear();
	}

	public void enterCeilingAmount(TransactionLimitPlan transactionlimitplan) {
		waitForElementVisible(ceilingAmountTxt);
		enterValueinTextBox(ceilingAmountTxt, transactionlimitplan.getCeilingAmount());
		waitForLoaderToDisappear();
	}

	public void enterStandInAmount(TransactionLimitPlan transactionlimitplan) {
		waitForElementVisible(standInAmountTxt);
		if (standInAmountTxt.isEnabled()) {
			enterValueinTextBox(standInAmountTxt, transactionlimitplan.getCeilingAmount());
			waitForLoaderToDisappear();
		}
	}

	public boolean verifyErrorsOnTransactionLimitPlanPage() {
		return publishErrorOnPage();
	}

	public void verifyTransactionPlanSuccess() {
		if (!verifyErrorsOnTransactionLimitPlanPage()) {
			logger.info("Transactionlimitplan Added Successfully");
			switchToDefaultFrame();
		} else {
			logger.info("Error in Record Addition");
			clickWhenClickable(cancelBtn);
			switchToDefaultFrame();
		}
	}

	public String addTransactionLimitPlan(DeviceCreation deviceCreation, TransactionLimitPlan transactionlimitplan) {
		String transactionlimitcode = enterTransactionCode();
		String description = enterTransactionDescription();
		selectProduct(deviceCreation);
		selectStartMonthlyYearlyLimits(transactionlimitplan);
		selectPlanType(deviceCreation);
		clickSaveButton();
		return description + " " + "[" + transactionlimitcode + "]";
	}

	public void addTransactionLimitPlanDetails(TransactionLimitPlan transactionlimitplan) {
		selectTransactionType(transactionlimitplan);
		selectTransactionSource();
		selectTransactionChannel();
		selectTransactionOrigin();
		enterFloorAmount(transactionlimitplan);
		enterCeilingAmount(transactionlimitplan);
		enterStandInAmount(transactionlimitplan);
		clickSaveButton();
		waitForLoaderToDisappear();
	}

	public void deletePlan(String name) {
		WebElementUtils.enterText(transactionLimitPlanCodeTxt, name);
		clickSearchButton();
		if (isDeleteColumnPresent()) {
			deleteFirstRecord();
			driver().switchTo().alert().accept();
		}
	}
}