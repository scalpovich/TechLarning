package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
@Component
public class LoanPlan {
	
	private static final String LOAN_PLAN_CODE = "LOAN_PLAN_CODE";
	private static final String LOAN_PLAN_DESCRIPTION = "LOAN_PLAN_DESCRIPTION";
	private static final String MAXIMUM_ELIGIBLE_LOAN_FIXED_AMOUNT ="MAXIMUM_ELIGIBLE_LOAN_FIXED_AMOUNT";
	private static final String NUMBER_OF_CURRENT_LOAN ="NUMBER_OF_CURRENT_LOAN";
	private static final String MAX_NUM_LOAN_AMOUNT ="MAX_NUM_LOAN_AMOUNT";
	private static final String MIN_NUM_LOAN_AMOUNT ="MIN_NUM_LOAN_AMOUNT";
	private static final String MAX_NUMBER_OF_INSTALLMENT ="MAX_NUMBER_OF_INSTALLMENT";
	private static final String MIN_NUMBER_OF_INSTALLMENT ="MIN_NUMBER_OF_INSTALLMENT";
	private static final String MIN_INTEREST_RATE ="MIN_INTEREST_RATE";
	private static final String MAX_INTEREST_RATE ="MAX_INTEREST_RATE";
	private static final String MAX_MORATORIUM_PERIOD ="MAX_MORATORIUM_PERIOD";
	private static final String PROCESSING_FIXED_FEE_AMOUNT ="PROCESSING_FIXED_FEE_AMOUNT";
	private static final String PRE_CLOSURE_FIXED_FEE_AMOUNT ="PRE_CLOSURE_FIXED_FEE_AMOUNT";
	private static final String CANCELLATION_FIXED_FEE_AMOUNT ="CANCELLATION_FIXED_FEE_AMOUNT";
	private static final String PROGRAM_CODE = "PROGRAM_CODE";
	private static final String PROGRAM_WALLET_PROMOTION_CODE ="PROGRAM_WALLET_PROMOTION_CODE";
	private static final String LOAN_DESCRIPTION ="LOAN_DESCRIPTION";
	private static final String LOAN_TYPE ="LOAN_TYPE";
	private static final String WALLET_CODE = "WALLET_CODE";
	
	private String loanPlanCode;
	private String loanPlanDescription;
	private String loanType ;
	private String defaultLoanPlan;
	private String programWalletPromotion  ;
	private String loanPlanProgram  ;
	private String loanPlanWalletPromotion  ;
	private String maximumEligibleLoanFixedAmount  ;
	private String numberOfConcurrentLoan  ;
	private String minimumLoanAmount   ;
	private String maximumLoanAmount  ;
	private String minimumNumberOfInstallment   ;
	private String maximumNumberOfInstallment  ;
	private String minimumInterestRate   ;
	private String maximumInterestRate  ;
	private String maximumMoratoriumPeriod;
	private String processingFixedFeeAmount ;
	private String preclosureFixedFeeAmount;
	private String cancellationFixedFeeAmount;
	private String walletCode;
	private String programCode;
	private String loanDescription;
	
	
	public String getMaximumEligibleLoanFixedAmount() {
		return maximumEligibleLoanFixedAmount;
	}

	public void setMaximumEligibleLoanFixedAmount(
			String maximumEligibleLoanFixedAmount) {
		this.maximumEligibleLoanFixedAmount = maximumEligibleLoanFixedAmount;
	}

	public String getProcessingFixedFeeAmount() {
		return processingFixedFeeAmount;
	}

	public void setProcessingFixedFeeAmount(String processingFixedFeeAmount) {
		this.processingFixedFeeAmount = processingFixedFeeAmount;
	}

	public String getPreclosureFixedFeeAmount() {
		return preclosureFixedFeeAmount;
	}

	public void setPreclosureFixedFeeAmount(String preclosureFixedFeeAmount) {
		this.preclosureFixedFeeAmount = preclosureFixedFeeAmount;
	}

	public String getCancellationFixedFeeAmount() {
		return cancellationFixedFeeAmount;
	}

	public void setCancellationFixedFeeAmount(String cancellationFixedFeeAmount) {
		this.cancellationFixedFeeAmount = cancellationFixedFeeAmount;
	}
	
	public String getLoanPlanCode() {
		return loanPlanCode;
	}

	public void setLoanPlanCode(String loanPlanCode) {
		this.loanPlanCode = loanPlanCode;
	}

	public String getLoanPlanDescription() {
		return loanPlanDescription;
	}

	public void setLoanPlanDescription(String loanPlanDescription) {
		this.loanPlanDescription = loanPlanDescription;
	}
	
	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}	
	
	public String getProgramCode() {
		return programCode;
	}
	
	public String getLoanDescription() {
		return loanDescription;
	}

	public void setLoanDescription(String loanDescription) {
		this.loanDescription = loanDescription;
	}
	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	
	public String getWalletCode() {
		return walletCode;
	}

	public void setWalletCode(String walletCode) {
		this.walletCode = walletCode;
	}
	
	public String getDefaultLoanPlan() {
		return defaultLoanPlan;
	}

	public void setDefaultLoanPlan(String defaultLoanPlan) {
		this.defaultLoanPlan = defaultLoanPlan;
	}

	public String getProgramWalletPromotion() {
		return programWalletPromotion;
	}

	public void setProgramWalletPromotion(String programWalletPromotion) {
		this.programWalletPromotion = programWalletPromotion;
	}

	public String getLoanPlanProgram() {
		return loanPlanProgram;
	}

	public void setLoanPlanProgram(String loanPlanProgram) {
		this.loanPlanProgram = loanPlanProgram;
	}

	public String getLoanPlanWalletPromotion() {
		return loanPlanWalletPromotion;
	}

	public void setLoanPlanWalletPromotion(String loanPlanWalletPromotion) {
		this.loanPlanWalletPromotion = loanPlanWalletPromotion;
	}

	public String getNumberOfConcurrentLoan() {
		return numberOfConcurrentLoan;
	}

	public void setNumberOfConcurrentLoan(String numberOfConcurrentLoan) {
		this.numberOfConcurrentLoan = numberOfConcurrentLoan;
	}

	public String getMinimumLoanAmount() {
		return minimumLoanAmount;
	}

	public void setMinimumLoanAmount(String minimumLoanAmount) {
		this.minimumLoanAmount = minimumLoanAmount;
	}

	public String getMaximumLoanAmount() {
		return maximumLoanAmount;
	}

	public void setMaximumLoanAmount(String maximumLoanAmount) {
		this.maximumLoanAmount = maximumLoanAmount;
	}

	public String getMinimumNumberOfInstallment() {
		return minimumNumberOfInstallment;
	}

	public void setMinimumNumberOfInstallment(String minimumNumberOfInstallment) {
		this.minimumNumberOfInstallment = minimumNumberOfInstallment;
	}

	public String getMaximumNumberOfInstallment() {
		return maximumNumberOfInstallment;
	}

	public void setMaximumNumberOfInstallment(String maximumNumberOfInstallment) {
		this.maximumNumberOfInstallment = maximumNumberOfInstallment;
	}

	public String getMinimumInterestRate() {
		return minimumInterestRate;
	}

	public void setMinimumInterestRate(String minimumInterestRate) {
		this.minimumInterestRate = minimumInterestRate;
	}

	public String getMaximumInterestRate() {
		return maximumInterestRate;
	}

	public void setMaximumInterestRate(String maximumInterestRate) {
		this.maximumInterestRate = maximumInterestRate;
	}

	public String getMaximumMoratoriumPeriod() {
		return maximumMoratoriumPeriod;
	}

	public void setMaximumMoratoriumPeriod(String maximumMoratoriumPeriod) {
		this.maximumMoratoriumPeriod = maximumMoratoriumPeriod;
	}

	public static LoanPlan getLoanPlanData() {
		LoanPlan loanPlan = new LoanPlan();
		loanPlan.setLoanPlanCode(CustomUtils.randomNumbers(5));
		loanPlan.setLoanPlanDescription(CustomUtils.randomString(10).toUpperCase());
		loanPlan.setProgramWalletPromotion(MapUtils.fnGetInputDataFromMap("ProgramWalletPromotion"));
		loanPlan.setMaximumEligibleLoanFixedAmount(CustomUtils.randomNumbers(2));
		loanPlan.setNumberOfConcurrentLoan(CustomUtils.randomNumbers(2));
		loanPlan.setMinimumLoanAmount(CustomUtils.randomNumbers(2));
		loanPlan.setMaximumLoanAmount(CustomUtils.randomNumbers(3));
		loanPlan.setMinimumNumberOfInstallment(CustomUtils.randomNumbers(1));
		loanPlan.setMaximumNumberOfInstallment(CustomUtils.randomNumbers(2));
		loanPlan.setMinimumInterestRate(CustomUtils.randomNumbers(1));
		loanPlan.setMaximumInterestRate(CustomUtils.randomNumbers(2));
		loanPlan.setMaximumMoratoriumPeriod(CustomUtils.randomNumbers(1));
		loanPlan.setProcessingFixedFeeAmount(CustomUtils.randomNumbers(2));
		loanPlan.setPreclosureFixedFeeAmount(CustomUtils.randomNumbers(2));
		loanPlan.setCancellationFixedFeeAmount(CustomUtils.randomNumbers(2));
		return loanPlan;
	}
	
	public static LoanPlan dataProvider(KeyValueProvider keyValueProvider){
		LoanPlan loanPlan = new LoanPlan();
		loanPlan.setLoanPlanCode(CustomUtils.randomString(5).toUpperCase());
		loanPlan.setLoanPlanDescription(keyValueProvider.getString(LOAN_PLAN_DESCRIPTION));
		loanPlan.setProgramCode(keyValueProvider.getString(PROGRAM_CODE));
		loanPlan.setProgramWalletPromotion(keyValueProvider.getString(PROGRAM_WALLET_PROMOTION_CODE));
		loanPlan.setMaximumEligibleLoanFixedAmount(keyValueProvider.getString(MAXIMUM_ELIGIBLE_LOAN_FIXED_AMOUNT));
		loanPlan.setNumberOfConcurrentLoan(keyValueProvider.getString(NUMBER_OF_CURRENT_LOAN));
		loanPlan.setMinimumLoanAmount(keyValueProvider.getString(MIN_NUM_LOAN_AMOUNT));
		loanPlan.setMaximumLoanAmount(keyValueProvider.getString(MAX_NUM_LOAN_AMOUNT));
		loanPlan.setMinimumNumberOfInstallment(keyValueProvider.getString(MIN_NUMBER_OF_INSTALLMENT));
		loanPlan.setMaximumNumberOfInstallment(keyValueProvider.getString(MAX_NUMBER_OF_INSTALLMENT));
		loanPlan.setMinimumInterestRate(keyValueProvider.getString(MIN_INTEREST_RATE));
		loanPlan.setMaximumInterestRate(keyValueProvider.getString(MAX_INTEREST_RATE));
		loanPlan.setMaximumMoratoriumPeriod(keyValueProvider.getString(MAX_MORATORIUM_PERIOD));
		loanPlan.setProcessingFixedFeeAmount(keyValueProvider.getString(PROCESSING_FIXED_FEE_AMOUNT));
		loanPlan.setPreclosureFixedFeeAmount(keyValueProvider.getString(PRE_CLOSURE_FIXED_FEE_AMOUNT));
		loanPlan.setCancellationFixedFeeAmount(keyValueProvider.getString(CANCELLATION_FIXED_FEE_AMOUNT));
		loanPlan.setLoanDescription(keyValueProvider.getString(LOAN_DESCRIPTION));
		loanPlan.setLoanType(keyValueProvider.getString(LOAN_TYPE));
		loanPlan.setWalletCode(keyValueProvider.getString(WALLET_CODE));
		return loanPlan;
	}
	
}
