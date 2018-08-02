package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

public class DeviceUsage {

	private static final String DAILY_CREDIT_AMOUNT = "EXP_DAILY_CREDIT_AMOUNT";
	private static final String DAILY_CREDIT_VELOCITY = "EXP_DAILY_CREDIT_VELOCITY";
	private static final String DAILY_DEBIT_AMOUNT = "EXP_DAILY_DEBIT_AMOUNT";
	private static final String DAILY_DEBIT_VELOCITY = "EXP_DAILY_DEBIT_VELOCITY";
	private static final String PERIODIC_CREDIT_AMOUNT = "EXP_PERIOD_CREDIT_AMOUNT";
	private static final String PERIODIC_CREDIT_VELOCITY = "EXP_PERIOD_CREDIT_VELOCITY";
	private static final String PERIODIC_DEBIT_AMOUNT = "EXP_PERIOD_DEBIT_AMOUNT";
	private static final String PERIODIC_DEBIT_VELOCITY = "EXP_PERIOD_DEBIT_VELOCITY";
	private static final String YEARLY_CREDIT_AMOUNT = "EXP_YEARLY_CREDIT_AMOUNT";
	private static final String YEARLY_CREDIT_VELOCITY = "EXP_YEARLY_CREDIT_VELOCITY";
	private static final String YEARLY_DEBIT_AMOUNT = "EXP_YEARLY_DEBIT_AMOUNT";
	private static final String YEARLY_DEBIT_VELOCITY = "EXP_YEARLY_DEBIT_VELOCITY";
	private static final String NEXT_TRANSACTION_AMOUNT = "NEXT_TRANSACTION_AMOUNT";

	private String dailyDebitVelocity;
	private String dailyCreditVelocity;
	private String dailyDebitAmount;
	private String dailyCreditAmount;

	private String periodicDebitVelocity;
	private String periodicCreditVelocity;
	private String periodicDebitAmount;
	private String periodicCreditAmount;

	private String yearlyDebitVelocity;
	private String yearlyCreditVelocity;
	private String yearlyDebitAmount;
	private String yearlyCreditAmount;

	private String nextTransactionAmount;
	private String walletMCGCode;
	private static int velocity;
	private String deviceNumber;

	public String getDailyDebitVelocity() {
		return dailyDebitVelocity;
	}

	public void setDailyDebitVelocity(String dailyDebitVelocity) {
		this.dailyDebitVelocity = dailyDebitVelocity;
	}

	public String getDailyCreditVelocity() {
		return dailyCreditVelocity;
	}

	public void setDailyCreditVelocity(String dailyCreditVelocity) {
		this.dailyCreditVelocity = dailyCreditVelocity;
	}

	public String getDailyDebitAmount() {
		return dailyDebitAmount;
	}

	public void setDailyDebitAmount(String dailyDebitAmount) {
		this.dailyDebitAmount = dailyDebitAmount;
	}

	public String getDailyCreditAmount() {
		return dailyCreditAmount;
	}

	public void setDailyCreditAmount(String dailyCreditAmount) {
		this.dailyCreditAmount = dailyCreditAmount;
	}

	public String getPeriodicDebitVelocity() {
		return periodicDebitVelocity;
	}

	public void setPeriodicDebitVelocity(String periodicDebitVelocity) {
		this.periodicDebitVelocity = periodicDebitVelocity;
	}

	public String getPeriodicCreditVelocity() {
		return periodicCreditVelocity;
	}

	public void setPeriodicCreditVelocity(String periodicCreditVelocity) {
		this.periodicCreditVelocity = periodicCreditVelocity;
	}

	public String getPeriodicDebitAmount() {
		return periodicDebitAmount;
	}

	public void setPeriodicDebitAmount(String periodicDebitAmount) {
		this.periodicDebitAmount = periodicDebitAmount;
	}

	public String getPeriodicCreditAmount() {
		return periodicCreditAmount;
	}

	public void setPeriodicCreditAmount(String periodicCreditAmount) {
		this.periodicCreditAmount = periodicCreditAmount;
	}

	public String getYearlyDebitVelocity() {
		return yearlyDebitVelocity;
	}

	public void setYearlyDebitVelocity(String yearlyDebitVelocity) {
		this.yearlyDebitVelocity = yearlyDebitVelocity;
	}

	public String getYearlyCreditVelocity() {
		return yearlyCreditVelocity;
	}

	public void setYearlyCreditVelocity(String yearlyCreditVelocity) {
		this.yearlyCreditVelocity = yearlyCreditVelocity;
	}

	public String getYearlyDebitAmount() {
		return yearlyDebitAmount;
	}

	public void setYearlyDebitAmount(String yearlyDebitAmount) {
		this.yearlyDebitAmount = yearlyDebitAmount;
	}

	public String getYearlyCreditAmount() {
		return yearlyCreditAmount;
	}

	public void setYearlyCreditAmount(String yearlyCreditAmount) {
		this.yearlyCreditAmount = yearlyCreditAmount;
	}

	public static DeviceUsage createWithProvider(KeyValueProvider provider) {
		DeviceUsage deviceUsage = new DeviceUsage();
		deviceUsage.setDailyCreditAmount(provider.getString(DAILY_CREDIT_AMOUNT));
		deviceUsage.setDailyCreditVelocity(provider.getString(DAILY_CREDIT_VELOCITY));
		deviceUsage.setDailyDebitAmount(provider.getString(DAILY_DEBIT_AMOUNT));
		deviceUsage.setDailyDebitVelocity(provider.getString(DAILY_DEBIT_VELOCITY));
		deviceUsage.setPeriodicCreditAmount(provider.getString(PERIODIC_CREDIT_AMOUNT));
		deviceUsage.setPeriodicCreditVelocity(provider.getString(PERIODIC_CREDIT_VELOCITY));
		deviceUsage.setPeriodicDebitAmount(provider.getString(PERIODIC_DEBIT_AMOUNT));
		deviceUsage.setPeriodicDebitVelocity(provider.getString(PERIODIC_DEBIT_VELOCITY));
		deviceUsage.setYearlyCreditAmount(provider.getString(YEARLY_CREDIT_AMOUNT));
		deviceUsage.setYearlyCreditVelocity(provider.getString(YEARLY_CREDIT_VELOCITY));
		deviceUsage.setYearlyDebitAmount(provider.getString(YEARLY_DEBIT_AMOUNT));
		deviceUsage.setYearlyDebitVelocity(provider.getString(YEARLY_DEBIT_VELOCITY));
		return deviceUsage;
	}

	public static DeviceUsage getDeviceUsageDetails(KeyValueProvider provider) {
		DeviceUsage plan = new DeviceUsage();
		plan.setTransactionAmount(provider.getString(NEXT_TRANSACTION_AMOUNT));
		velocity = 1;
		return plan;
	}

	public String getNextTransactionAmount() {
		return nextTransactionAmount;
	}

	public void setTransactionAmount(String nextTransactionAmount) {
		this.nextTransactionAmount = nextTransactionAmount;
	}

	public String getWalletMCGCode() {
		return walletMCGCode;
	}

	public void setWalletMCGCode(String walletMCGCode) {
		this.walletMCGCode = walletMCGCode;
	}

	public String getVelocity() {
		return String.valueOf(velocity);
	}

	public static void setVelocity() {
		++velocity;
	}

	public String getDeviceNumber() {
		return deviceNumber;
	}

	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}
}