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
	private MCWebElement addBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=surchargeFeePlanCode]")
	private MCWebElement surchargePlanCodeTxtBx;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=description]")
	private MCWebElement descriptionTxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "currencyCode:input:dropdowncomponent")
	private MCWebElement currencyDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id=//label[text()='System Calculated']/@for]")
	private MCWebElement systemCalculatedSurchargeSourceRadioBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id=//label[text()='Network Calculated']/@for]")
	private MCWebElement networkCalculatedSurchargeSourceRadioBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Add Details']")
	private MCWebElement addDetailsBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "networkCode:input:dropdowncomponent")
	private MCWebElement interchangeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mcgCode:input:dropdowncomponent")
	private MCWebElement mcgDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[input[@name='effectiveDate:input:dateTextField']]//img")
	private MCWebElement effectiveDatePicker;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[input[@name='endDate:input:dateTextField']]//img")
	private MCWebElement endDatePicker;

	@PageElement(findBy = FindBy.NAME, valueToFind = "detailDesc:input:inputTextField")
	private MCWebElement feeTransactionDescriptionTxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "feesRate:input:inputTextField")
	private MCWebElement surchargeRateTxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "fixedSurchargeAmount:input:inputAmountField")
	private MCWebElement fixedSurchargeAmtTxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "minSurchargeAmount:input:inputAmountField")
	private MCWebElement minSurchargeAmtTxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "maxSurchargeAmount:input:inputAmountField")
	private MCWebElement maxSurchargeAmtTxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "span.feedbackPanelINFO")
	private MCWebElement feedbackPanel;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='surchargeFeePlanCode']")
	private MCWebElement planCodeSearchTxtBx;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "td.norecords-td span.norecords")
	private MCWebElement noRecordsCell;

	private String surchargePlanDetailsIframeId = "_wicket_window_3";

	public void verifyUiOperationStatus() {
		LOGGER.info("Surcharge Plan");
		verifyUiOperation("Add Surcharge Plan");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(surchargePlanCodeTxtBx),
				WebElementUtils.elementToBeClickable(descriptionTxtBx));
	}

	public void addSurchargePlan() {
		ClickButton(addBtn);
		switchToSurchargePlanFrame();
	}
	
	public void switchToSurchargePlanFrame() {
		switchToIframe(ADD_SURCHARGE_PLAN_FRAME);
	}

	public void enterSurchargePlanCode(SurchargePlan plan) {
		enterValueinTextBox(surchargePlanCodeTxtBx, plan.getSurchargePlanCode());
	}

	public void enterDescription(SurchargePlan plan) {
		enterValueinTextBox(descriptionTxtBx, plan.getDescription());
	}

	public void selectCurrency(SurchargePlan plan) {
		selectDropDownByText(currencyDDwn, plan.getCurrency());
	}

	public void selectSurchargeSource(SurchargePlan plan) {
		ClickButton(getSurchargeSourceElement(plan.getSurchargeSource()));
	}

	public MCWebElement getSurchargeSourceElement(String scSource) {
		MCWebElement surchargeSource = null;

		switch (scSource) {
		case SYSTEM_CALCULATED:
			surchargeSource = systemCalculatedSurchargeSourceRadioBtn;
			break;

		case NETWORK_CALCULATED:
			surchargeSource = networkCalculatedSurchargeSourceRadioBtn;
			break;

		default:
			throw new IllegalArgumentException("Argument not supported!");
		}

		return surchargeSource;
	}

	public void addDetails() {
		ClickButton(addDetailsBtn);
	}

	public void addSurchargePlanDetail() {
		switchToFrame(surchargePlanDetailsIframeId);
		ClickButton(addBtn);
	}

	public void switchToSurchargePlanDetailFrame() {
		switchToIframe(ADD_SURCHARGE_PLAN_DETAIL_FRAME);
	}

	public void selectInterchange(SurchargePlan plan) {
		selectDropDownByText(interchangeDDwn, plan.getInterchange());
	}

	public void selectMCG(SurchargePlan plan) {
		selectDropDownByText(mcgDDwn, plan.getMcg());
	}

	public void pickEffectiveDate(SurchargePlan plan) {
		datePicker.setDate(plan.getEffectiveDate(), EFFECTIVE_DATE_XPATH);
	}

	public void pickEndDate(SurchargePlan plan) {
		datePicker.setDate(plan.getEndDate(), END_DATE_XPATH);
	}

	public void enterFeeTransactionDescription(SurchargePlan plan) {
		enterValueinTextBox(feeTransactionDescriptionTxtBx, plan.getFeeTransactionDesc());
	}

	public void enterSurchargeRate(SurchargePlan plan) {
		enterValueinTextBox(surchargeRateTxtBx, plan.getSurchargeRate());
	}

	public void enterFixedSurchargeAmount(SurchargePlan plan) {
		enterValueinTextBox(fixedSurchargeAmtTxtBx, plan.getFixedSurchargeAmt());
	}

	public void enterMinSurchargeAmount(SurchargePlan plan) {
		enterValueinTextBox(minSurchargeAmtTxtBx, plan.getMinSurchargeAmt());
	}

	public void enterMaxSurchargeAmount(SurchargePlan plan) {
		enterValueinTextBox(maxSurchargeAmtTxtBx, plan.getMaxSurchargeAmt());
	}

	public void save() {
		ClickButton(saveBtn);
	}
		
	public void enterPlanCodeInSearchBox(SurchargePlan plan) {
		enterValueinTextBox(planCodeSearchTxtBx, plan.getSurchargePlanCode());
	}
	
	public void saveMain() {
		SwitchToDefaultFrame();
		switchToSurchargePlanFrame();
		ClickButton(saveBtn);
	}
	
	public String getFeedbackText() {
		return feedbackPanel.getText();
	}
	
	public Boolean isNoRecordsFoundInTableView() {
		return isNoRecordsFoundInTable();
	}
}
