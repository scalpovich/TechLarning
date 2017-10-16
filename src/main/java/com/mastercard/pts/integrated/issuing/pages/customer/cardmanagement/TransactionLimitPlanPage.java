package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Collection;

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
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1PROGRAM_SETUP,
		CardManagementNav.L2TRANSACTION_LIMIT_PLAN })
public class TransactionLimitPlanPage extends AbstractBasePage {
	final Logger logger = LoggerFactory.getLogger(VendorPage.class);

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

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

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return null;
	}

}
