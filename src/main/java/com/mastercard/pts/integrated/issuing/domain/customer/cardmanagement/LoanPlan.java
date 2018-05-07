package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
@Component
public class LoanPlan {
	
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

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
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
	
}
