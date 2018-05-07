package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CurrencyPayoutListPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.SurchargePlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP,
		CardManagementNav.L2_CURRENCY_PAYOUT_LIST_PLAN })
public class CurrencyPayoutListPlanPage extends AbstractBasePage {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CurrencyPayoutListPlanPage.class);
	public static final String ADD_CURRENCY_PAYOUT_PLAN_FRAME = "Add Currency Payout Plan";
	public static final int ADD_CURRENCY_PLAN_DETAIL_FRAME = 1;

	@PageElement(findBy = FindBy.NAME, valueToFind = "description:input:inputTextField")
	private MCWebElement descriptionTxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "currencyCode:input:dropdowncomponent")
	private MCWebElement currencyDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Add Details']")
	private MCWebElement addDetailsBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "detailDesc:input:inputTextField")
	private MCWebElement feeTransactionDescriptionTxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "fixedSurchargeAmount:input:inputAmountField")
	private MCWebElement fixedSurchargeAmtTxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "toleranceRefundUnit:input:inputTextField")
	private MCWebElement refundTolerancUnitTxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "currencyPayoutListPlanCode:input:inputTextField")
	private MCWebElement planCodeTxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "span.feedbackPanelINFO")
	private MCWebElement feedbackPanel;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='currencyPayoutListPlanCode']")
	private MCWebElement planCodeSearchTxtBx;

	@PageElement(findBy = FindBy.CSS, valueToFind = "td.norecords-td span.norecords")
	private MCWebElement noRecordsCell;

	@PageElement(findBy = FindBy.NAME, valueToFind = "currencyCode:input:dropdowncomponent")
	private MCWebElement currencyCodeDdwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#effectiveDate")
	private MCWebElement effectiveDateDPkr;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#endDate")
	private MCWebElement endDateDPkr;

	public void verifyUiOperationStatus() {
		LOGGER.info("Currency Payout List Plan");
	}

	public void enterDescription(CurrencyPayoutListPlan plan) {
		enterValueinTextBox(descriptionTxtBx, plan.getDescription());
	}

	public void selectCurrency(SurchargePlan plan) {
		SelectDropDownByText(currencyDDwn, plan.getCurrency());
	}

	public void addDetails() {
		ClickButton(addDetailsBtn);
	}

	public void pickEffectiveDate(CurrencyPayoutListPlan plan) {
		WebElementUtils.pickDate(effectiveDateDPkr, plan.getEffectiveDate());
	}

	public void pickEndDate(CurrencyPayoutListPlan plan) {
		WebElementUtils.pickDate(endDateDPkr, plan.getEndDate());
	}

	public void selectCurrencyCode(CurrencyPayoutListPlan plan) {
		SelectDropDownByText(currencyCodeDdwn, plan.getCurrency());
	}

	public void enterRefundToleranceUnit(CurrencyPayoutListPlan plan) {
		enterValueinTextBox(refundTolerancUnitTxtBx,
				plan.getRefundToleranceUnit());
	}

	public void enterPlanCode(CurrencyPayoutListPlan plan) {
		enterValueinTextBox(planCodeTxtBx, plan.getCurrencyPayoutListPlanCode());
	}

	public void save() {
		ClickButton(saveBtn);
	}

	public void enterPlanCodeInSearchBox(CurrencyPayoutListPlan plan) {
		enterValueinTextBox(planCodeSearchTxtBx,
				plan.getCurrencyPayoutListPlanCode());
	}

	public void saveMain() {
		SwitchToDefaultFrame();
		switchToIframe(ADD_CURRENCY_PAYOUT_PLAN_FRAME);
		ClickButton(saveBtn);
	}

	public String getFeedbackText() {
		return feedbackPanel.getText();
	}

	public Boolean isNoRecordsFoundInTableView() {
		return isNoRecordsFoundInTable();
	}

	public void createCurrencyPayoutListPlanWithDetails(
			CurrencyPayoutListPlan plan) {
		clickAddNewButton();
		runWithinPopup(ADD_CURRENCY_PAYOUT_PLAN_FRAME, () -> {
			enterPlanCode(plan);
			enterDescription(plan);
			addDetails();
			clickAddNewButton();
		});
		switchToIframeByIndex(ADD_CURRENCY_PLAN_DETAIL_FRAME);;
		selectCurrencyCode(plan);
		enterRefundToleranceUnit(plan);
		pickEffectiveDate(plan);
		pickEndDate(plan);
		clickSaveButton();
		saveMain();
	}

}
