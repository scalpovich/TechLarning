package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
		CardManagementNav.L3_LOAN_PLAN
		})

public class LoanPlanPage extends AbstractBasePage {
	
	private static final Logger logger = LoggerFactory.getLogger(LoanPlanPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=loanPlanCode]")
	private MCWebElement loanPlanCode;	
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=loanPlanDescription]")
	private MCWebElement loanPlanDescription;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement loanType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement program;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:3:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement walletPromotion;
	
	public void verifyUiOperationStatus() {
		logger.info("Loan Plan");
		verifyUiOperation("Add Loan Plan");
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(loanPlanCode),
				WebElementUtils.elementToBeClickable(loanPlanDescription),
				WebElementUtils.elementToBeClickable(loanType),
				WebElementUtils.elementToBeClickable(program),
				WebElementUtils.elementToBeClickable(walletPromotion)
				);
	}
}