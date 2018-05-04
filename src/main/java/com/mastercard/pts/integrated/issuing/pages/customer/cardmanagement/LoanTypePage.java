package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.LoanType;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_LOAN_CONFIGURATION,
		CardManagementNav.L3_LOAN_TYPE
		})

public class LoanTypePage extends AbstractBasePage {
	
	private static final Logger logger = LoggerFactory.getLogger(LoanTypePage.class);
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement loanType;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=description]")
	private MCWebElement description;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "loanProductCode:input:dropdowncomponent")
	private MCWebElement addLoanTypeDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "description:input:inputTextField")
	private MCWebElement addLoanTypeDescriptionTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "draftFlag:checkBoxComponent")
	private MCWebElement draftNeededChkBx;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "creditLimitValidationFlag:checkBoxComponent")
	private MCWebElement creditLimitChkBx;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "cashLimitValidationFlag:checkBoxComponent")
	private MCWebElement cashLimitChkBx;
	
	public void verifyUiOperationStatus() {
		logger.info("Loan Type");
		verifyUiOperation("Add Loan Type");
	}
	
	public void addLoanType(LoanType loanType){
		logger.info("Add Loan Type");
		if (!isNoRecordsFoundInTable()) {
			deleteExistingRecord(loanType.getLoanType());
		}
		clickAddNewButton();
		runWithinPopup("Add Loan Type", () -> {
			selectLoanType(loanType.getLoanType());
			enterLoanTypeDescription(loanType.getDescription());
			selectDraftNeededCheckBox();
			selectCreditLimitCheckBox();
			selectCashLimitCheckBox();
			clickSaveButton();
		});
	}
	
	public void selectLoanType(String loanTypeItem){
		selectByText(addLoanTypeDDwn, loanTypeItem);
	}
	
	public void enterLoanTypeDescription(String loanTypeDescription){
		enterText(addLoanTypeDescriptionTxt, loanTypeDescription);
	}
	public void selectDraftNeededCheckBox(){
		if(draftNeededChkBx.isEnabled())
		selectCheckBox(draftNeededChkBx, "DraftNeeded");
	}
	public void selectCreditLimitCheckBox(){
		if(creditLimitChkBx.isEnabled())
		selectCheckBox(creditLimitChkBx, "LoanTypeCreditLimit");
	}
	public void selectCashLimitCheckBox(){
		if(cashLimitChkBx.isEnabled())
		selectCheckBox(cashLimitChkBx, "LoanTypeCashLimit");
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(loanType),
				WebElementUtils.elementToBeClickable(description)
				);
	}
}