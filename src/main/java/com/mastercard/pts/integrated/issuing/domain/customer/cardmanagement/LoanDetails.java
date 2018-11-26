package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class LoanDetails {

	private String loanAmount;
	private String loanEMI;
	private String processingFee;
	private String principalAmount;
	private String interestAmount;
	private String moratoriumLoan;
	private String transactionAmount;
	private LocalDate processingDate;
	
	public LocalDate getProcessingDate() {
		return processingDate;
	}
	public void setProcessingDate(LocalDate processingDate) {
		this.processingDate = processingDate;
	}
	public String getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}
	public String getLoanEMI() {
		return loanEMI;
	}
	public void setLoanEMI(String loanEMI) {
		this.loanEMI = loanEMI;
	}
	public String getProcessingFee() {
		return processingFee;
	}
	public void setProcessingFee(String processingFee) {
		this.processingFee = processingFee;
	}
	public String getPrincipleAmout() {
		return principalAmount;
	}
	public void setPrincipleAmout(String principleAmout) {
		this.principalAmount = principleAmout;
	}
	public String getInterestAmount() {
		return interestAmount;
	}
	public void setInterestAmount(String interestAmount) {
		this.interestAmount = interestAmount;
	}
	public String getMoratoriumLoan() {
		return moratoriumLoan;
	}
	public void setMoratoriumLoan(String moratoriumLoan) {
		this.moratoriumLoan = moratoriumLoan;
	}

}
