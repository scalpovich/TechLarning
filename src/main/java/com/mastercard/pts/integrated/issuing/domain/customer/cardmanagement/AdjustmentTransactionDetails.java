package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.time.LocalDate;

import com.mastercard.pts.integrated.issuing.utils.ConstantData;

public class AdjustmentTransactionDetails{
	
	private String memo;
	
	private String adjustmentAmount;

	private String transactionDateHours;
	
	private String transactionDateMinutes;
	
	private LocalDate transactionDate;

	private String deviceNumber;
	
	private String walletNumber;
	
	public static AdjustmentTransactionDetails createTransactionWithDetails(){
		AdjustmentTransactionDetails transactionDetails = new AdjustmentTransactionDetails();
		transactionDetails.setMemo(ConstantData.GENERIC_DESCRIPTION);
		transactionDetails.setTransactionDate(LocalDate.now());
		transactionDetails.setTransactionDateHours("00");
		transactionDetails.setTransactionDateMinutes("00");
		transactionDetails.setAdjustmentAmount("500");
		return transactionDetails;
	}
	
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getAdjustmentAmount() {
		return adjustmentAmount;
	}

	public void setAdjustmentAmount(String adjustmentAmount) {
		this.adjustmentAmount = adjustmentAmount;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getDeviceNumber() {
		return deviceNumber;
	}

	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}

	public String getWalletNumber() {
		return walletNumber;
	}

	public void setWalletNumber(String walletNumber) {
		this.walletNumber = walletNumber;
	}
	public String getTransactionDateHours() {
		return transactionDateHours;
	}

	public void setTransactionDateHours(String transactionDateHours) {
		this.transactionDateHours = transactionDateHours;
	}

	public String getTransactionDateMinutes() {
		return transactionDateMinutes;
	}

	public void setTransactionDateMinutes(String transactionDateMinutes) {
		this.transactionDateMinutes = transactionDateMinutes;
	}	
}
