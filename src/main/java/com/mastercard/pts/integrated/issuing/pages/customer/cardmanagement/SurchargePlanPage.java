package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.SurchargePlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.DatePicker;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP, CardManagementNav.L2_SURCHARGE_PLAN })

public class SurchargePlanPage extends AbstractBasePage {

	private static final Logger LOGGER = LoggerFactory.getLogger(SurchargePlanPage.class);
	private static final String SYSTEM_CALCULATED = "System Calculated";
	private static final String NETWORK_CALCULATED = "Network Calculated";
	public static final String ADD_SURCHARGE_PLAN_FRAME = "Add Surcharge Plan";
	public static final String ADD_SURCHARGE_PLAN_DETAIL_FRAME = "Add Surcharge Plan Detail";
	private static final String EFFECTIVE_DATE_XPATH = "//input[@fld_fqn='effectiveDate']/following::span";
	private static final String END_DATE_XPATH = "//input[@fld_fqn='endDate']/following::span";

	@Autowired
	DatePicker datePicker;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement add;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=surchargeFeePlanCode]")
	private MCWebElement surchargePlanCode;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=description]")
	private MCWebElement description;

	@PageElement(findBy = FindBy.NAME, valueToFind = "currencyCode:input:dropdowncomponent")
	private MCWebElement currency;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id=//label[text()='System Calculated']/@for]")
	private MCWebElement systemCalculatedSurchargeSource;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id=//label[text()='Network Calculated']/@for]")
	private MCWebElement networkCalculatedSurchargeSource;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Add Details']")
	private MCWebElement addDetails;

	@PageElement(findBy = FindBy.NAME, valueToFind = "networkCode:input:dropdowncomponent")
	private MCWebElement interchange;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mcgCode:input:dropdowncomponent")
	private MCWebElement mcg;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[input[@name='effectiveDate:input:dateTextField']]//img")
	private MCWebElement effectiveDate;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[input[@name='endDate:input:dateTextField']]//img")
	private MCWebElement endDate;

	@PageElement(findBy = FindBy.NAME, valueToFind = "detailDesc:input:inputTextField")
	private MCWebElement feeTransactionDescription;

	@PageElement(findBy = FindBy.NAME, valueToFind = "feesRate:input:inputTextField")
	private MCWebElement surchargeRate;

	@PageElement(findBy = FindBy.NAME, valueToFind = "fixedSurchargeAmount:input:inputAmountField")
	private MCWebElement fixedSurchargeAmt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "minSurchargeAmount:input:inputAmountField")
	private MCWebElement minSurchargeAmt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "maxSurchargeAmount:input:inputAmountField")
	private MCWebElement maxSurchargeAmt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "span.feedbackPanelINFO")
	private MCWebElement feedback;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='surchargeFeePlanCode']")
	private MCWebElement planCodeSearchBox;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "td.norecords-td span.norecords")
	private MCWebElement noRecordsCell;

	private String surchargePlanDetailsIframeId = "_wicket_window_3";

	public void verifyUiOperationStatus() {
		LOGGER.info("Surcharge Plan");
		verifyUiOperation("Add Surcharge Plan");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(surchargePlanCode),
				WebElementUtils.elementToBeClickable(description));
	}

	public void addSurchargePlan() {
		ClickButton(add);
		switchToSurchargePlanFrame();
	}
	
	public void switchToSurchargePlanFrame() {
		switchToIframe(ADD_SURCHARGE_PLAN_FRAME);
	}

	public void enterSurchargePlanCode(SurchargePlan plan) {
		enterValueinTextBox(surchargePlanCode, plan.getSurchargePlanCode());
	}

	public void enterDescription(SurchargePlan plan) {
		enterValueinTextBox(description, plan.getDescription());
	}

	public void selectCurrency(SurchargePlan plan) {
		SelectDropDownByText(currency, plan.getCurrency());
	}

	public void selectSurchargeSource(SurchargePlan plan) {
		ClickButton(getSurchargeSourceElement(plan.getSurchargeSource()));
	}

	public MCWebElement getSurchargeSourceElement(String scSource) {
		MCWebElement surchargeSource = null;

		switch (scSource) {
		case SYSTEM_CALCULATED:
			surchargeSource = systemCalculatedSurchargeSource;
			break;

		case NETWORK_CALCULATED:
			surchargeSource = networkCalculatedSurchargeSource;
			break;

		default:
			throw new IllegalArgumentException("Argument not supported!");
		}

		return surchargeSource;
	}

	public void addDetails() {
		ClickButton(addDetails);
	}

	public void addSurchargePlanDetail() {
		switchToFrame(surchargePlanDetailsIframeId);
		ClickButton(add);
	}

	public void switchToSurchargePlanDetailFrame() {
		switchToIframe(ADD_SURCHARGE_PLAN_DETAIL_FRAME);
	}

	public void selectInterchange(SurchargePlan plan) {
		SelectDropDownByText(interchange, plan.getInterchange());
	}

	public void selectMCG(SurchargePlan plan) {
		SelectDropDownByText(mcg, plan.getMcg());
	}

	public void pickEffectiveDate(SurchargePlan plan) {
		datePicker.setDate(plan.getEffectiveDate(), EFFECTIVE_DATE_XPATH);
	}

	public void pickEndDate(SurchargePlan plan) {
		datePicker.setDate(plan.getEndDate(), END_DATE_XPATH);
	}

	public void enterFeeTransactionDescription(SurchargePlan plan) {
		enterValueinTextBox(feeTransactionDescription, plan.getFeeTransactionDesc());
	}

	public void enterSurchargeRate(SurchargePlan plan) {
		enterValueinTextBox(surchargeRate, plan.getSurchargeRate());
	}

	public void enterFixedSurchargeAmount(SurchargePlan plan) {
		enterValueinTextBox(fixedSurchargeAmt, plan.getFixedSurchargeAmt());
	}

	public void enterMinSurchargeAmount(SurchargePlan plan) {
		enterValueinTextBox(minSurchargeAmt, plan.getMinSurchargeAmt());
	}

	public void enterMaxSurchargeAmount(SurchargePlan plan) {
		enterValueinTextBox(maxSurchargeAmt, plan.getMaxSurchargeAmt());
	}

	public void save() {
		ClickButton(save);
	}
		
	public void enterPlanCodeInSearchBox(SurchargePlan plan) {
		enterValueinTextBox(planCodeSearchBox, plan.getSurchargePlanCode());
	}
	
	public void saveMain() {
		SwitchToDefaultFrame();
		switchToSurchargePlanFrame();
		ClickButton(save);
	}
	
	public String getFeedbackText() {
		return feedback.getText();
	}
	
	public Boolean isNoRecordsFoundInTableView() {
		return isNoRecordsFoundInTable();
	}
}
