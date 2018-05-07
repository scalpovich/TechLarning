package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "loanAmtFixed:input:inputAmountField")
	private MCWebElement loanAmtFixedTxt;
	
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
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//li[@id='loanFees']")
	private MCWebElement feesTab ;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "procFeeFixed:input:inputAmountField")
	private MCWebElement procFeeFixedTxt ;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "preclosureFeeFixed:input:inputAmountField")
	private MCWebElement preclosureFeeFixedTxt ;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "cancellationFeeFixed:input:inputAmountField")
	private MCWebElement cancellationFeeFixedTxt ;
	
	final int FIRST_RECORD=1;
	
	public void verifyUiOperationStatus() {
		logger.info("Loan Plan");
		verifyUiOperation("Add Loan Plan");
	}
	
	public void addLoanPlan(LoanPlan loanPlan,LoanType loanTypedata){
		logger.info("Add Loan Plan");
		clickAddNewButton();
		runWithinPopup("Add Loan Plan", () -> {
			enterLoanPlanCode(loanPlan.getLoanPlanCode());
			enterLoanPlanDescription(loanPlan.getLoanPlanDescription());
			selectLoanType(loanTypedata.getDescription());
			selectDefaultLoanType();
			selectProgramWalletPromotion(loanPlan.getProgramWalletPromotion());
			selectProgram();
			enterMaximumEligibleLoanFixedAmount(loanPlan.getMaximumEligibleLoanFixedAmount());
			enterNumberOfConcurrentLoan(loanPlan.getNumberOfConcurrentLoan());
			enterMinimumLoanAmount(loanPlan.getMinimumLoanAmount());
			enterMaximumLoanAmount(loanPlan.getMaximumLoanAmount());
			enterMinimumNumberOfInstallment(loanPlan.getMinimumNumberOfInstallment());
			enterMaximumNumberOfInstallment(loanPlan.getMaximumNumberOfInstallment());
			enterMinimumInterestRate(loanPlan.getMinimumInterestRate());
			enterMaximumInterestRate(loanPlan.getMaximumInterestRate());
			enterMaximumMoratoriumPeriod( loanPlan.getMaximumMoratoriumPeriod());
			navigateToFeesTab();
			enterProcessingFixedFeeAmount(loanPlan.getProcessingFixedFeeAmount());
			enterPreclosureFixedFeeAmount(loanPlan.getPreclosureFixedFeeAmount());
			enterCancellationFixedFeeAmount(loanPlan.getCancellationFixedFeeAmount());
			clickSaveButton();
		});
	}
	
	public void enterLoanPlanCode(String loadPlanCode){
		enterText(loanPlanCodeTxt, loadPlanCode);
	}
	
	public void enterLoanPlanDescription(String loadPlanDescription){
		enterText(loanPlanDescriptionTxt, loadPlanDescription);
	}
	
	public void selectLoanType(String loanTypeItem){
		selectByVisibleText(loanTypeDDwn, loanTypeItem);
	}
	
	public void selectDefaultLoanType(){
		selectCheckBox(defaultLoanPlanChckBx, "DefaultLoanPlan");
	}
	
	public void selectProgramWalletPromotion(String programWalletPromotionItem){
		selectByVisibleText(programWalletPromotionDDwn, programWalletPromotionItem);
	}
	
	public void selectProgram(){
		SelectDropDownByIndex(programDDwn, FIRST_RECORD);
	}
	
	public void enterMaximumEligibleLoanFixedAmount(String maximumEligibleLoanFixedAmount){
		enterText(loanAmtFixedTxt, maximumEligibleLoanFixedAmount);
	}
	
	public void enterNumberOfConcurrentLoan(String numberOfConcurrentLoan){
		enterText(numberOfConcurrentLoanTxt, numberOfConcurrentLoan);
	}
	
	public void enterMinimumLoanAmount(String minimumLoanAmount){
		enterText(minimumLoanAmountTxt, minimumLoanAmount);
	}
	
	public void enterMaximumLoanAmount(String maximumLoanAmount){
		enterText(maximumLoanAmountTxt, maximumLoanAmount);
	}
	
	public void enterMinimumNumberOfInstallment(String minimumNumberOfInstallment){
		enterText(minimumNumberOfInstallmentTxt, minimumNumberOfInstallment);
	}
	
	public void enterMaximumNumberOfInstallment(String maximumNumberOfInstallment){
		enterText(maximumNumberOfInstallmentTxt, maximumNumberOfInstallment);
	}
	
	public void enterMinimumInterestRate(String minimumInterestRate){
		enterText(minInterestRateTxt, minimumInterestRate);
	}
		
	public void enterMaximumInterestRate(String maximumInterestRate){
		enterText(maxInterestRateTxt, maximumInterestRate);
	}
	
	public void enterMaximumMoratoriumPeriod(String maximumMoratoriumPeriod){
		enterText(maxMoratoriumPeriodTxt, maximumMoratoriumPeriod);
	}
	
	public void navigateToFeesTab(){
		clickWhenClickable(feesTab);
	}
	
	public void enterProcessingFixedFeeAmount(String processingAmount){
		enterText(procFeeFixedTxt, processingAmount);
	}
	
    public void enterPreclosureFixedFeeAmount(String preclosureAmount){
    	enterText(preclosureFeeFixedTxt, preclosureAmount);
	}
    
    public void enterCancellationFixedFeeAmount(String cancellationAmount){
    	enterText(cancellationFeeFixedTxt, cancellationAmount);
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