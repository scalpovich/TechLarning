package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Collection;
import java.util.Arrays;
import java.util.List;

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
import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionLimitPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionLimitPlanDetails;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1PROGRAM_SETUP,
		CardManagementNav.L2_DEVICE_CONFIGURATION,
		CardManagementNav.L2_TRANSACTION_LIMIT_PLAN })
public class TransactionLimitPlanPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(TransactionLimitPlanPage.class);

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

	@PageElement(findBy = FindBy.NAME, valueToFind = "txnLimitPlanCode:input:inputTextField")
	private MCWebElement TransactionLimitPlanCodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "description:input:inputTextField")
	private MCWebElement DescriptionTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "productType:input:dropdowncomponent")
	private MCWebElement ProductTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "planType:input:dropdowncomponent")
	private MCWebElement PlanTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "txnLimitYearStartMonth:input:dropdowncomponent")
	private MCWebElement StartMonthForYearlyLimitsDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save2Btn;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addSubDetailsBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionCode:input:dropdowncomponent")
	private MCWebElement TransactionTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionSource:input:dropdowncomponent")
	private MCWebElement TransactionSourceDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionChannel:input:dropdowncomponent")
	private MCWebElement TransactionChannelDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionOrigin:input:dropdowncomponent")
	private MCWebElement TransactionOriginDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "minAmount:input:inputAmountField")
	private MCWebElement FloorAmountTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "perTxnAmt:input:inputAmountField")
	private MCWebElement CeilingAmountTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "standInTxnOffAmt:input:inputAmountField")
	private MCWebElement StandInAmountTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement CancelBtn;

	public void verifyUiOperationStatus() {
		logger.info("Transaction Limit Plan");
		verifySearchButton("Search");
	}

	// Methods
	@Override
	protected List<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(planCodeSearchTxt));
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
					enterIframeTransactionLimitPlanCode(transactionLimitPlanDataObject.getTransactionLimitPlanCode());
					enterIframeDescription(transactionLimitPlanDataObject.getDescription());
					selectIframeProductType(transactionLimitPlanDataObject.getIframeproductType());
					selectIframePlanType(transactionLimitPlanDataObject.getIframePlanType());
					selectIframeStartMonthForYearlyLimits(transactionLimitPlanDataObject.getIframeStartMonthForYearlyLimits());
					clickAddDetailsButton();
					transactionLimitPlanDataObject.getTransactionLimitPlanDetails().forEach(
									details -> addDetails(details, transactionLimitPlanDataObject.getIframeproductType()));
					WebElementUtils.scrollDown(driver(), 0, 250);
					clickSaveButton();
				});

		verifyOperationStatus();
	}

	private void addDetails(TransactionLimitPlanDetails details,
			String productType) {
		clickAddNewButton();

		runWithinPopup("Add Transaction Limit Plan Detail",() -> {
			     /* if (productType.equalsIgnoreCase(ProductType.CREDIT)) {
			       WebElementUtils.selectDropDownByIndex(iframeTransactionTypeDDwn, 1);
			       waitForWicket();
			       selectByVisibleText(iframeTransactionSourceDDwn,ProductType.INTERCHANGE);
			       waitForWicket();
			       WebElementUtils.selectDropDownByIndex(iframeTransactionChannelDDwn,1);
			       waitForWicket();
			       WebElementUtils.selectDropDownByIndex(iframeTransactionOriginDDwn,1);
			      }
			      else
			      {*/
					selectIframeTransactionType(details.getIframeTransactionType());
					 waitForWicket();
					selectIframeTransactionSource(details.getIframeTransactionSource());
					 waitForWicket();
					selectIframeTransactionChannel(details.getIframeTransactionChannel());
					 waitForWicket();
					selectIframeTransactionOrigin(details.getIframeTransactionOrigin());
			     // }
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
	public void clickaddTransactionLimitPlan() {
		clickWhenClickable(addTransactionLimitPlanBtn);
		switchToAddTransactionLimitPlanFrame();
	}

	public void switchToAddTransactionLimitPlanFrame() {
		switchToIframe(Constants.ADD_TRANSACTION_LIMIT_PLAN_FRAME);
	}

	public String enterTransactionCode() {
		enterValueinTextBox(TransactionLimitPlanCodeTxt, CustomUtils.randomNumbers(5));
		return TransactionLimitPlanCodeTxt.getAttribute("value");
	}

	public String enterTransactionDescription() {
		enterValueinTextBox(DescriptionTxt, "transaction limit plan");
		return DescriptionTxt.getAttribute("value");
	}

	public void selectProduct(DeviceCreation deviceCreation) {
		selectByVisibleText(ProductTypeDDwn, deviceCreation.getProduct());
	}

	public void selectStartMonthlyYearlyLimits(TransactionLimitPlan transactionlimitplan) {
		selectByVisibleText(StartMonthForYearlyLimitsDDwn, transactionlimitplan.getStartMonthForYearlyLimits());
	}

	public void selectPlanType(DeviceCreation deviceCreation) {
		selectByVisibleText(PlanTypeDDwn, deviceCreation.getPlanType());
	}

	public void clickSaveButton() {
		clickWhenClickable(saveBtn);
		SwitchToDefaultFrame();
	}

	public void clickaddTransactionLimitDetails() {
		switchToAddTransactionLimitPlanFrame();
		clickWhenClickable(addSubDetailsBtn);
		switchToAddTransactionLimitdetailFrame();
	}

	public void switchToAddTransactionLimitdetailFrame() {
		SwitchToDefaultFrame();
		switchToIframe(Constants.ADD_TRANSACTION_LIMIT_DETAIL_PLAN_FRAME);
	}

	public void selectTransactionType(TransactionLimitPlan transactionlimitplan) {
		selectByVisibleText(TransactionTypeDDwn, transactionlimitplan.getTransactionType());
	}

	public void selectTransactionSource() {
		SelectDropDownByIndex(TransactionSourceDDwn, 1);
	}

	public void selectTransactionChannel() {
		SelectDropDownByIndex(TransactionChannelDDwn, 1);
	}

	public void selectTransactionOrigin() {
		SelectDropDownByIndex(TransactionOriginDDwn, 1);
	}

	public void enterFloorAmount(TransactionLimitPlan transactionlimitplan) {
		enterValueinTextBox(FloorAmountTxt, transactionlimitplan.getFloorAmount());
	}

	public void enterCeilingAmount(TransactionLimitPlan transactionlimitplan) {
		enterValueinTextBox(CeilingAmountTxt, transactionlimitplan.getCeilingAmount());
	}

	public void enterStandInAmount(TransactionLimitPlan transactionlimitplan) {
		if (StandInAmountTxt.isEnabled()) {
			enterValueinTextBox(StandInAmountTxt, transactionlimitplan.getCeilingAmount());
		}
	}

	public boolean verifyErrorsOnTransactionLimitPlanPage() {
		return publishErrorOnPage();
	}

	public void verifyTransactionPlanSuccess() {
		if (!verifyErrorsOnTransactionLimitPlanPage()) {
			logger.info("Transactionlimitplan Added Successfully");
			SwitchToDefaultFrame();
		} else {
			logger.info("Error in Record Addition");
			clickWhenClickable(CancelBtn);
			SwitchToDefaultFrame();
		}
	}

	public String addTransactionLimitPlan(DeviceCreation deviceCreation, TransactionLimitPlan transactionlimitplan) {
		String transactionlimitcode = enterTransactionCode();
		String Description = enterTransactionDescription();
		selectProduct(deviceCreation);
		selectStartMonthlyYearlyLimits(transactionlimitplan);
		selectPlanType(deviceCreation);
		clickSaveButton();
		return Description + " " + "[" + transactionlimitcode + "]";
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

	}

}