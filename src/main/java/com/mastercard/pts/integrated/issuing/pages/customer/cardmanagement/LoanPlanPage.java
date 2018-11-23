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
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
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
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "defaultInstallmentNo:input:inputAmountField")
	private MCWebElement defaultInstallmentNoTxt ;	
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "minEmiAmt:input:inputAmountField")
	private MCWebElement minEmiAmtTxt ;	
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "minInstallmentNo:input:inputAmountField")
	private MCWebElement minimumNumberOfInstallmentTxt ;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "maxInstallmentNo:input:inputAmountField")
	private MCWebElement maximumNumberOfInstallmentTxt ;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "defaultInterestRate:input:inputAmountField")
	private MCWebElement defaultInterestRateTxt ;
	
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
		
	@PageElement(findBy = FindBy.NAME, valueToFind = "procFeeVariable:input:inputAmountField")
	private MCWebElement procFeePercentTxt ;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "minProcFee:input:inputAmountField")
	private MCWebElement minProcFeeTxt ;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "maxProcFee:input:inputAmountField")
	private MCWebElement maxProcFeeTxt ;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "preclosureFeeFixed:input:inputAmountField")
	private MCWebElement preclosureFeeFixedTxt ;
		
	@PageElement(findBy = FindBy.NAME, valueToFind = "feeApplication:input:dropdowncomponent")
	private MCWebElement preclosureFeeAppliedOnDDwn ;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "preclosureOutstandingAmount:input:inputAmountField")
	private MCWebElement preclosureOutstandingAmountPercentTxt ;		
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "preclosureFeeVariable:input:inputAmountField")
	private MCWebElement preclosureFeePercentTxt ;	
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "minPreclosureFee:input:inputAmountField")
	private MCWebElement minPreclosureFeeTxt ;	
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "maxPreclosureFee:input:inputAmountField")
	private MCWebElement maxPreclosureFeeTxt ;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "cancellationFeeFixed:input:inputAmountField")
	private MCWebElement cancellationFeeFixedTxt ;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "cancellationFeeVariable:input:inputAmountField")
	private MCWebElement cancellationFeePercentTxt ;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "minCancellationFee:input:inputAmountField")
	private MCWebElement minCancellationFeeTxt ;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "maxCancellationFee:input:inputAmountField")
	private MCWebElement maxCancellationFeeTxt ;
	

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
		selectDropDownByIndex(programDDwn, FIRST_RECORD);
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
	
	public void enterDefaultNumberOfInstallment(String numberOfInstallment){
		enterText(defaultInstallmentNoTxt, numberOfInstallment);
	}
	
	public void enterMinEMIAmount(String emiAmount){
		enterText(minEmiAmtTxt, emiAmount);
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
	
	public void enterProcessingFeePercent(String procFeePercent){
		enterText(procFeePercentTxt, procFeePercent);
	}
		
	public void enterMinimumProcessingFee(String processingFee){
		enterText(minProcFeeTxt, processingFee);
	}
	
	public void enterMaximumProcessingFee(String processingFee){
		enterText(maxProcFeeTxt, processingFee);
	}
	
    public void enterPreclosureFixedFeeAmount(String preclosureAmount){
    	enterText(preclosureFeeFixedTxt, preclosureAmount);
	}
    
    public void enterPreclosureFeePercent(String preclosureFeePercent){
    	enterText(preclosureFeePercentTxt, preclosureFeePercent);
	}
    
    public void enterPreclosureOutstandingAmountPercent(String preclosureFeePercent){
    	enterText(preclosureOutstandingAmountPercentTxt, preclosureFeePercent);
	}
    
    public void enterMinPreclosureFee(String preclosureFee){
    	enterText(minPreclosureFeeTxt, preclosureFee);
	}
    
    public void enterMaxPreclosureFee(String preclosureFee){
    	enterText(maxPreclosureFeeTxt, preclosureFee);
	}
    
	public void selectPreClosureFeeAppliedOn(String feeAppliedOn){
		selectByVisibleText(preclosureFeeAppliedOnDDwn, feeAppliedOn);
	}
	
    
    public void enterCancellationFixedFeeAmount(String cancellationAmount){
    	enterText(cancellationFeeFixedTxt, cancellationAmount);
	}
    
    public void enterCancellationFeePercent(String cancellationFeePercent){
    	enterText(cancellationFeePercentTxt, cancellationFeePercent);
	}
    
    public void enterMinCancellationFee(String cancellationFee){
    	enterText(minCancellationFeeTxt, cancellationFee);
	}
    
    public void enterMaxCancellationFee(String cancellationFee){
    	enterText(maxCancellationFeeTxt, String.format("%.2f", Double.valueOf(cancellationFee)*100));
	}
    
    public void selectProgram(String programCode){
		selectByVisibleText(programDDwn, programCode);
	}
    
    public void selectWallet(String walletCode){
		selectByVisibleText(walletPromotionDDwn,walletCode);
	}
    public void enterDefaultInterestRate(String defaultInterestRate){
		enterText(defaultInterestRateTxt, defaultInterestRate);
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
	
	public void addLoanPlan(LoanPlan loanPlan){
		logger.info("Add Loan Plan");
		clickAddNewButton();
		runWithinPopup("Add Loan Plan", () -> {
			SimulatorUtilities util = new SimulatorUtilities();
			
			enterLoanPlanCode(loanPlan.getLoanPlanCode());
			enterLoanPlanDescription(loanPlan.getLoanPlanDescription());
			selectLoanType(loanPlan.getLoanType());
			selectProgramWalletPromotion(loanPlan.getProgramWalletPromotion());
			WebElementUtils.scrollDown(driver(), 0, 250);
			if(loanPlan.getProgramWalletPromotion().contains(Constants.PROGRAM)){
				selectProgram(loanPlan.getProgramCode());
			}else{
				selectWallet(loanPlan.getWalletCode());
			}
			
			enterMaximumEligibleLoanFixedAmount(loanPlan.getMaximumEligibleLoanFixedAmount());
			enterNumberOfConcurrentLoan(loanPlan.getNumberOfConcurrentLoan());
			WebElementUtils.scrollDown(driver(), 0, 250);
			enterMinimumLoanAmount(loanPlan.getMinimumLoanAmount());
			enterMaximumLoanAmount(loanPlan.getMaximumLoanAmount());
			enterDefaultNumberOfInstallment(loanPlan.getDefaultNumberOfInstallment());
			util.pressTab();
			enterMinEMIAmount(loanPlan.getMinimumEMIAmount());
			util.pressTab();
			enterMinimumNumberOfInstallment(loanPlan.getMinimumNumberOfInstallment());
			WebElementUtils.scrollDown(driver(), 0, 250);
			enterMaximumNumberOfInstallment(loanPlan.getMaximumNumberOfInstallment());
			WebElementUtils.scrollDown(driver(), 0, 250);
			enterDefaultInterestRate(loanPlan.getDefaultInterestRate());
			enterMinimumInterestRate(loanPlan.getMinimumInterestRate());
			enterMaximumInterestRate(loanPlan.getMaximumInterestRate());
			enterMaximumMoratoriumPeriod( loanPlan.getMaximumMoratoriumPeriod());
			navigateToFeesTab();
			enterProcessingFixedFeeAmount(loanPlan.getProcessingFixedFeeAmount());			
			enterProcessingFeePercent(loanPlan.getProcessingFeePercentOfLoanAmount());
			util.pressTab();
			enterMinimumProcessingFee(loanPlan.getMinimumProcessingFee());
			enterMaximumProcessingFee(loanPlan.getMaximumProcessingFee());
			
			WebElementUtils.scrollDown(driver(), 0, 250);
			enterPreclosureFixedFeeAmount(loanPlan.getPreclosureFixedFeeAmount());
			selectPreClosureFeeAppliedOn(loanPlan.getPreclosureFeeAppliedOn());
			if(loanPlan.getPreclosureFeeAppliedOn().equalsIgnoreCase(ConstantData.APPLIED_ON_LOAN_AMOUNT))
				enterPreclosureFeePercent(loanPlan.getPreclosureFeePercentOfAmount());
			else
				enterPreclosureOutstandingAmountPercent(loanPlan.getPreclosureFeePercentOfAmount());
			
			util.pressTab();
			enterMinPreclosureFee(loanPlan.getMinimumPreclosureFee());
			enterMaxPreclosureFee(loanPlan.getMaximumPreclosureFee());
			
			WebElementUtils.scrollDown(driver(), 0, 250);
			enterCancellationFixedFeeAmount(loanPlan.getCancellationFixedFeeAmount());	
			enterCancellationFeePercent(loanPlan.getCancellationFeePercentOfLoanAmount());
			util.pressTab();
			enterMinCancellationFee(loanPlan.getMinimumCancellationFee());
			enterMaxCancellationFee(loanPlan.getMaximumCancellationFee());
			WebElementUtils.scrollDown(driver(), 0, 300);
			clickSaveButton();
		});
	}
}