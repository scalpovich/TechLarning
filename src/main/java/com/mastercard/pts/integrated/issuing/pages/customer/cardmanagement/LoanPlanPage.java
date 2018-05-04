package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.LoanPlan;
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
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "loanPlanCode:input:inputTextField")
	private MCWebElement loanPlanCodeTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "loanPlanDescription:input:inputTextField")
	private MCWebElement loanPlanDescriptionTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "loanProductCode:input:dropdowncomponent")
	private MCWebElement loanTypeDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "defaultLoanPlanFlag:checkBoxComponent")
	private MCWebElement defaultLoanPlanChckBx;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "loanProductPromotion:input:dropdowncomponent")
	private MCWebElement programWalletPromotionDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "productCode:input:dropdowncomponent")
	private MCWebElement programDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "promoCode:input:dropdowncomponent")
	private MCWebElement walletPromotionDDwn ;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "concurrentEmiNo:input:inputAmountField")
	private MCWebElement numberOfConcurrentLoanTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "minLoanAmt:input:inputAmountField")
	private MCWebElement minimumLoanAmountTxt ;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "maxLoanAmt:input:inputAmountField")
	private MCWebElement maximumLoanAmountTxt ;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "minInstallmentNo:input:inputAmountField")
	private MCWebElement minimumNumberOfInstallmentTxt ;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "maxInstallmentNo:input:inputAmountField")
	private MCWebElement maximumNumberOfInstallmentTxt ;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "minInterestRate:input:inputAmountField")
	private MCWebElement minInterestRateTxt ;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "maxInterestRate:input:inputAmountField")
	private MCWebElement maxInterestRateTxt ;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "maxMoratoriumPeriod:input:inputAmountField")
	private MCWebElement maxMoratoriumPeriodTxt ;
	
	@Autowired
	private TestContext context;
	
	public void verifyUiOperationStatus() {
		logger.info("Loan Plan");
		verifyUiOperation("Add Loan Plan");
	}
	
	public void addLoanPlan(LoanPlan loanPlan){
		logger.info("Add Loan Plan");
		LoanType loanTypedata=context.get("LOAN_TYPE_OBJECT");
		clickAddNewButton();
		runWithinPopup("Add Loan Plan", () -> {
			enterText(loanPlanCodeTxt, loanPlan.getLoanPlanCode());
			enterText(loanPlanDescriptionTxt, loanPlan.getLoanPlanDescription());
			selectByVisibleText(loanTypeDDwn, loanTypedata.getDescription());
			selectCheckBox(defaultLoanPlanChckBx, "DefaultLoanPlan");
			selectByVisibleText(programWalletPromotionDDwn, loanPlan.getProgramWalletPromotion());
			SelectDropDownByIndex(programDDwn, 1);
			enterText(numberOfConcurrentLoanTxt, loanPlan.getNumberOfConcurrentLoan());
			enterText(minimumLoanAmountTxt, loanPlan.getMinimumLoanAmount());
			enterText(maximumLoanAmountTxt, loanPlan.getMaximumLoanAmount());
			enterText(minimumNumberOfInstallmentTxt, loanPlan.getMinimumNumberOfInstallment());
			enterText(maximumNumberOfInstallmentTxt, loanPlan.getMaximumNumberOfInstallment());
			enterText(minInterestRateTxt, loanPlan.getMinimumInterestRate());
			enterText(maxInterestRateTxt, loanPlan.getMaximumInterestRate());
			enterText(maxMoratoriumPeriodTxt, loanPlan.getMaximumMoratoriumPeriod());
			clickSaveButton();
		});
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