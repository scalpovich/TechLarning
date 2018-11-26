package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
@Component
public class LoanPlan implements HasCodeAndDescription {
	
	private static final String LOAN_PLAN_CODE = "LOAN_PLAN_CODE";
	private static final String LOAN_PLAN_DESCRIPTION = "LOAN_PLAN_DESCRIPTION";
	private static final String MAXIMUM_ELIGIBLE_LOAN_FIXED_AMOUNT ="MAXIMUM_ELIGIBLE_LOAN_FIXED_AMOUNT";
	private static final String NUMBER_OF_CURRENT_LOAN ="NUMBER_OF_CURRENT_LOAN";
	private static final String MAX_NUM_LOAN_AMOUNT ="MAX_NUM_LOAN_AMOUNT";
	private static final String MIN_NUM_LOAN_AMOUNT ="MIN_NUM_LOAN_AMOUNT";
	private static final String MAX_NUMBER_OF_INSTALLMENT ="MAX_NUMBER_OF_INSTALLMENT";
	private static final String MIN_NUMBER_OF_INSTALLMENT ="MIN_NUMBER_OF_INSTALLMENT";
	private static final String DEFAULT_NUMBER_OF_INSTALLMENT ="DEFAULT_NUMBER_OF_INSTALLMENT";
	private static final String MIN_EMI_AMOUNT ="MIN_EMI_AMOUNT";
	private static final String DEFAULT_INTEREST_RATE ="DEFAULT_INTEREST_RATE";
	private static final String MIN_INTEREST_RATE ="MIN_INTEREST_RATE";
	private static final String MAX_INTEREST_RATE ="MAX_INTEREST_RATE";
	private static final String MAX_MORATORIUM_PERIOD ="MAX_MORATORIUM_PERIOD";
	private static final String PROCESSING_FIXED_FEE_AMOUNT ="PROCESSING_FIXED_FEE_AMOUNT";
	private static final String PROCESSING_FEE_PERCENT_OF_LOAN_AMOUNT ="PROCESSING_FEE_PERCENT_OF_LOAN_AMOUNT";
	private static final String MIN_PROCESSING_FEE ="MIN_PROCESSING_FEE";
	private static final String MAX_PROCESSING_FEE ="MIN_PROCESSING_FEE";
	private static final String CANCELLATION_FIXED_FEE_AMOUNT ="CANCELLATION_FIXED_FEE_AMOUNT";
	private static final String CANCELLATION_FEE_PERCENT_OF_LOAN_AMOUNT ="CANCELLATION_FEE_PERCENT_OF_LOAN_AMOUNT";
	private static final String MIN_CANCELLATION_FEE ="MIN_CANCELLATION_FEE";
	private static final String MAX_CANCELLATION_FEE ="MIN_CANCELLATION_FEE";	
	private static final String PRE_CLOSURE_FIXED_FEE_AMOUNT ="PRE_CLOSURE_FIXED_FEE_AMOUNT";
	private static final String PRECLOSURE_FEE_APPLIED_ON ="PRECLOSURE_FEE_APPLIED_ON";
	private static final String PRECLOSURE_FEE_PERCENT_OF_LOAN_AMOUNT ="PRECLOSURE_FEE_PERCENT_OF_LOAN_AMOUNT";
	private static final String MIN_PRECLOSURE_FEE ="MIN_PRECLOSURE_FEE";
	private static final String MAX_PRECLOSURE_FEE ="MAX_PRECLOSURE_FEE";	
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
	private String defaultNumberOfInstallment  ;
	private String minimumEMIAmount  ;
	private String minimumNumberOfInstallment   ;
	private String maximumNumberOfInstallment  ;
	private String defaultInterestRate   ;
	private String minimumInterestRate   ;
	private String maximumInterestRate  ;
	private String maximumMoratoriumPeriod;
	private String processingFixedFeeAmount ;
	private String preclosureFeeAppliedOn;
	private String processingFeePercentOfLoanAmount ;
	private String minimumProcessingFee ;
	private String maximumProcessingFee ;
	private String cancellationFixedFeeAmount;
	private String cancellationFeePercentOfLoanAmount;
	private String minimumCancellationFee;
	private String maximumCancellationFee;
	private String preclosureFixedFeeAmount;
	private String preclosureFeePercentOfAmount;
	private String minimumPreclosureFee;
	private String maximumPreclosureFee;
	private String walletCode;
	private String programCode;
	private String loanDescription;
	
	public String getDefaultNumberOfInstallment() {
		return defaultNumberOfInstallment;
	}

	public void setDefaultNumberOfInstallment(String defaultNumberOfInstallment) {
		this.defaultNumberOfInstallment = defaultNumberOfInstallment;
	}

	public String getMinimumEMIAmount() {
		return minimumEMIAmount;
	}

	public void setMinimumEMIAmount(String minimumEMIAmount) {
		this.minimumEMIAmount = minimumEMIAmount;
	}
	public String getPreclosureFeeAppliedOn() {
		return preclosureFeeAppliedOn;
	}

	public void setPreclosureFeeAppliedOn(String processingFixedFeeAppliedOn) {
		this.preclosureFeeAppliedOn = processingFixedFeeAppliedOn;
	}
	
	public String getDefaultInterestRate() {
		return defaultInterestRate;
	}

	public void setDefaultInterestRate(String defaultInterestRate) {
		this.defaultInterestRate = defaultInterestRate;
	}

	public String getProcessingFeePercentOfLoanAmount() {
		return processingFeePercentOfLoanAmount;
	}

	public void setProcessingFeePercentOfLoanAmount(String processingFeePercentOfLoanAmount) {
		this.processingFeePercentOfLoanAmount = processingFeePercentOfLoanAmount;
	}

	public String getMinimumProcessingFee() {
		return minimumProcessingFee;
	}

	public void setMinimumProcessingFee(String minimumProcessingFee) {
		this.minimumProcessingFee = minimumProcessingFee;
	}

	public String getMaximumProcessingFee() {
		return maximumProcessingFee;
	}

	public void setMaximumProcessingFee(String maximumProcessingFee) {
		this.maximumProcessingFee = maximumProcessingFee;
	}

	public String getCancellationFeePercentOfLoanAmount() {
		return cancellationFeePercentOfLoanAmount;
	}

	public void setCancellationFeePercentOfLoanAmount(String cancellationFeePercentOfLoanAmount) {
		this.cancellationFeePercentOfLoanAmount = cancellationFeePercentOfLoanAmount;
	}

	public String getMinimumCancellationFee() {
		return minimumCancellationFee;
	}

	public void setMinimumCancellationFee(String minimumCancellationFee) {
		this.minimumCancellationFee = minimumCancellationFee;
	}

	public String getMaximumCancellationFee() {
		return maximumCancellationFee;
	}

	public void setMaximumCancellationFee(String maximumCancellationFee) {
		this.maximumCancellationFee = maximumCancellationFee;
	}

	public String getPreclosureFeePercentOfAmount() {
		return preclosureFeePercentOfAmount;
	}

	public void setPreclosureFeePercentOfAmount(String preclosureFeePercentOfAmount) {
		this.preclosureFeePercentOfAmount = preclosureFeePercentOfAmount;
	}

	public String getMinimumPreclosureFee() {
		return minimumPreclosureFee;
	}

	public void setMinimumPreclosureFee(String minimumPreclosureFee) {
		this.minimumPreclosureFee = minimumPreclosureFee;
	}

	public String getMaximumPreclosureFee() {
		return maximumPreclosureFee;
	}

	public void setMaximumPreclosureFee(String maximumPreclosureFee) {
		this.maximumPreclosureFee = maximumPreclosureFee;
	}
	
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
		
		loanPlan.setDefaultNumberOfInstallment(keyValueProvider.getString(DEFAULT_NUMBER_OF_INSTALLMENT));
		loanPlan.setMinimumEMIAmount(keyValueProvider.getString(MIN_EMI_AMOUNT));
		loanPlan.setMinimumNumberOfInstallment(keyValueProvider.getString(MIN_NUMBER_OF_INSTALLMENT));
		loanPlan.setMaximumNumberOfInstallment(keyValueProvider.getString(MAX_NUMBER_OF_INSTALLMENT));
		
		loanPlan.setMaximumMoratoriumPeriod(keyValueProvider.getString(MAX_MORATORIUM_PERIOD));
		loanPlan.setLoanDescription(keyValueProvider.getString(LOAN_DESCRIPTION));
		loanPlan.setLoanType(keyValueProvider.getString(LOAN_TYPE));
		loanPlan.setWalletCode(keyValueProvider.getString(WALLET_CODE));
		
		loanPlan.setDefaultInterestRate(keyValueProvider.getString(DEFAULT_INTEREST_RATE));
		loanPlan.setMinimumInterestRate(keyValueProvider.getString(MIN_INTEREST_RATE));
		loanPlan.setMaximumInterestRate(keyValueProvider.getString(MAX_INTEREST_RATE));
		
		loanPlan.setProcessingFixedFeeAmount(keyValueProvider.getString(PROCESSING_FIXED_FEE_AMOUNT));
		loanPlan.setProcessingFeePercentOfLoanAmount(keyValueProvider.getString(PROCESSING_FEE_PERCENT_OF_LOAN_AMOUNT));
		loanPlan.setMinimumProcessingFee(keyValueProvider.getString(MIN_PROCESSING_FEE));
		loanPlan.setMaximumProcessingFee(keyValueProvider.getString(MAX_PROCESSING_FEE));
		
		loanPlan.setCancellationFixedFeeAmount(keyValueProvider.getString(CANCELLATION_FIXED_FEE_AMOUNT));
		loanPlan.setCancellationFeePercentOfLoanAmount(keyValueProvider.getString(CANCELLATION_FEE_PERCENT_OF_LOAN_AMOUNT));
		loanPlan.setMinimumCancellationFee(keyValueProvider.getString(MIN_CANCELLATION_FEE));
		loanPlan.setMaximumCancellationFee(keyValueProvider.getString(MAX_CANCELLATION_FEE));
		
		loanPlan.setPreclosureFixedFeeAmount(keyValueProvider.getString(PRE_CLOSURE_FIXED_FEE_AMOUNT));
		loanPlan.setPreclosureFeeAppliedOn(keyValueProvider.getString(PRECLOSURE_FEE_APPLIED_ON));
		loanPlan.setPreclosureFeePercentOfAmount(keyValueProvider.getString(PRECLOSURE_FEE_PERCENT_OF_LOAN_AMOUNT));
		loanPlan.setMinimumPreclosureFee(keyValueProvider.getString(MIN_PRECLOSURE_FEE));
		loanPlan.setMaximumPreclosureFee(keyValueProvider.getString(MAX_PRECLOSURE_FEE));
		
		return loanPlan;
	}

	@Override
	public String getCode() {
		// TODO Auto-generated method stub
		return loanPlanCode;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return loanDescription;
	}
	
}
