package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

public class TransactionLimitPlanDetails {
	
	private static final String TRANSACTION_TYPE = "TRANSACTION_TYPE";
	private static final String TRANSACTION_SOURCE = "TRANSACTION_SOURCE";
	private static final String TRANSACTION_CHANNEL = "TRANSACTION_CHANNEL";
	private static final String TRANSACTION_ORIGIN = "TRANSACTION_ORIGIN";
	private static final String FLOOR_AMOUNT = "FLOOR_AMOUNT";
	private static final String FLOOR_RESPONSE = "FLOOR_RESPONSE";
	private static final String CEILING_AMOUNT = "CEILING_AMOUNT";
	private static final String CEILING_RESPONSE = "CEILING_RESPONSE";
	private static final String STAND_IN_AMOUNT = "STAND_IN_AMOUNT";
	private static final String STAND_IN_RESPONSE = "STAND_IN_RESPONSE";
	private static final String DAILY_AMOUNT = "DAILY_AMOUNT";
	private static final String DAILY_RESPONSE = "DAILY_RESPONSE";
	
	private static final String DAILY_VELOCITY	 = 	"DAILY_VELOCITY";
	private static final String DAILY_VELOCITY_RESPONSE	 = 	"DAILY_VELOCITY_RESPONSE";
	private static final String PERIODIC_AMOUNT	 = 	"PERIODIC_AMOUNT";
	private static final String PERIODIC_AMOUNT_RESPONSE	 = 	"PERIODIC_AMOUNT_RESPONSE";
	private static final String PERIODIC_VELOCITY	 = 	"PERIODIC_VELOCITY";
	private static final String	PERIODIC_VELOCITY_RESPONSE	 = 	"PERIODIC_VELOCITY_RESPONSE";
	private static final String	YEARLY_AMOUNT	 = 	"YEARLY_AMOUNT";
	private static final String	YEARLY_AMOUNT_RESPONSE	 = 	"YEARLY_AMOUNT_RESPONSE";
	private static final String YEARLY_VELOCITY	 = 	"YEARLY_VELOCITY";
	private static final String YEARLY_VELOCITY_RESPONSE	 = 	"YEARLY_VELOCITY_RESPONSE";


	private String iframeTransactionType;
	private String iframeTransactionSource;
	private String iframeTransactionChannel;
	private String iframeTransactionOrigin;
	private String iframeFloorAmount;
	private String iframeFloorResponse;
	private String iframeCeilingAmount;
	private String iframeCeilingResponse;
	private String iframeStandInAmount;
	private String iframeStandInResponse;
	private String iframeDailyAmount;
	private String iframeDailyResponse;
	
	private String limitDailyVelocity;
	private String limitDailyVelocityResponse;
	private String limitPeriodicAmount;
	private String limitPeriodicAmountResponse;
	private String limitPeriodicVelocity;
	private String limitPeriodicVelocityResponse;
	private String limitYearlyAmount;
	private String limitYearlyAmountResponse;
	private String limitYearlyVelocity;
	private String limitYearlyVelocityResponse;
	
	public String getLimitDailyVelocity() {
		return limitDailyVelocity;
	}

	public void setLimitDailyVelocity(String limitDailyVelocity) {
		this.limitDailyVelocity = limitDailyVelocity;
	}

	public String getLimitDailyVelocityResponse() {
		return limitDailyVelocityResponse;
	}

	public void setLimitDailyVelocityResponse(String limitDailyVelocityResponse) {
		this.limitDailyVelocityResponse = limitDailyVelocityResponse;
	}

	public String getLimitPeriodicAmount() {
		return limitPeriodicAmount;
	}

	public void setLimitPeriodicAmount(String limitPeriodicAmount) {
		this.limitPeriodicAmount = limitPeriodicAmount;
	}

	public String getLimitPeriodicAmountResponse() {
		return limitPeriodicAmountResponse;
	}

	public void setLimitPeriodicAmountResponse(String limitPeriodicAmountResponse) {
		this.limitPeriodicAmountResponse = limitPeriodicAmountResponse;
	}

	public String getLimitPeriodicVelocity() {
		return limitPeriodicVelocity;
	}

	public void setLimitPeriodicVelocity(String limitPeriodicVelocity) {
		this.limitPeriodicVelocity = limitPeriodicVelocity;
	}

	public String getLimitPeriodicVelocityResponse() {
		return limitPeriodicVelocityResponse;
	}

	public void setLimitPeriodicVelocityResponse(
			String limitPeriodicVelocityResponse) {
		this.limitPeriodicVelocityResponse = limitPeriodicVelocityResponse;
	}

	public String getLimitYearlyAmount() {
		return limitYearlyAmount;
	}

	public void setLimitYearlyAmount(String limitYearlyAmount) {
		this.limitYearlyAmount = limitYearlyAmount;
	}

	public String getLimitYearlyAmountResponse() {
		return limitYearlyAmountResponse;
	}

	public void setLimitYearlyAmountResponse(String limitYearlyAmountResponse) {
		this.limitYearlyAmountResponse = limitYearlyAmountResponse;
	}

	public String getLimitYearlyVelocity() {
		return limitYearlyVelocity;
	}

	public void setLimitYearlyVelocity(String limitYearlyVelocity) {
		this.limitYearlyVelocity = limitYearlyVelocity;
	}

	public String getLimitYearlyVelocityResponse() {
		return limitYearlyVelocityResponse;
	}

	public void setLimitYearlyVelocityResponse(String limitYearlyVelocityResponse) {
		this.limitYearlyVelocityResponse = limitYearlyVelocityResponse;
	}

	public String getIframeDailyAmount() {
		return iframeDailyAmount;
	}

	public void setIframeDailyAmount(String iframeDailyAmount) {
		this.iframeDailyAmount = iframeDailyAmount;
	}

	public String getIframeDailyResponse() {
		return iframeDailyResponse;
	}

	public void setIframeDailyResponse(String iframeDailyResponse) {
		this.iframeDailyResponse = iframeDailyResponse;
	}

	public String getIframeTransactionType() {
		return iframeTransactionType;
	}
	
	public String getIframeStandInAmount() {
		return iframeStandInAmount;
	}

	public void setIframeStandInAmount(String iframeStandInAmount) {
		this.iframeStandInAmount = iframeStandInAmount;
	}

	public String getIframeStandInResponse() {
		return iframeStandInResponse;
	}

	public void setIframeStandInResponse(String iframeStandInResponse) {
		this.iframeStandInResponse = iframeStandInResponse;
	}

	public void setIframeTransactionType(String iframeTransactionType) {
		this.iframeTransactionType = iframeTransactionType;
	}
	public String getIframeTransactionSource() {
		return iframeTransactionSource;
	}
	public void setIframeTransactionSource(String iframeTransactionSource) {
		this.iframeTransactionSource = iframeTransactionSource;
	}
	public String getIframeTransactionChannel() {
		return iframeTransactionChannel;
	}
	public void setIframeTransactionChannel(String iframeTransactionChannel) {
		this.iframeTransactionChannel = iframeTransactionChannel;
	}
	public String getIframeTransactionOrigin() {
		return iframeTransactionOrigin;
	}
	public void setIframeTransactionOrigin(String iframeTransactionOrigin) {
		this.iframeTransactionOrigin = iframeTransactionOrigin;
	}
	public String getIframeFloorAmount() {
		return iframeFloorAmount;
	}
	public void setIframeFloorAmount(String iframeFloorAmount) {
		this.iframeFloorAmount = iframeFloorAmount;
	}
	public String getIframeFloorResponse() {
		return iframeFloorResponse;
	}
	public void setIframeFloorResponse(String iframeFloorResponse) {
		this.iframeFloorResponse = iframeFloorResponse;
	}
	public String getIframeCeilingAmount() {
		return iframeCeilingAmount;
	}
	public void setIframeCeilingAmount(String iframeCeilingAmount) {
		this.iframeCeilingAmount = iframeCeilingAmount;
	}
	public String getIframeCeilingResponse() {
		return iframeCeilingResponse;
	}
	public void setIframeCeilingResponse(String iframeCeilingResponse) {
		this.iframeCeilingResponse = iframeCeilingResponse;
	}
	
	
	public static TransactionLimitPlanDetails createWithProvider(KeyValueProvider provider) {
		TransactionLimitPlanDetails plan = new TransactionLimitPlanDetails();
		plan.setIframeTransactionType(provider.getString(TRANSACTION_TYPE));
		plan.setIframeTransactionSource(provider.getString(TRANSACTION_SOURCE));
		plan.setIframeTransactionChannel(provider.getString(TRANSACTION_CHANNEL));
		plan.setIframeTransactionOrigin(provider.getString(TRANSACTION_ORIGIN));
		plan.setIframeFloorAmount(provider.getString(FLOOR_AMOUNT));
		plan.setIframeFloorResponse(provider.getString(FLOOR_RESPONSE));
		plan.setIframeCeilingAmount(provider.getString(CEILING_AMOUNT));
		plan.setIframeCeilingResponse(provider.getString(CEILING_RESPONSE));
		plan.setIframeStandInAmount(provider.getString(STAND_IN_AMOUNT));
		plan.setIframeStandInResponse(provider.getString(STAND_IN_RESPONSE));
		plan.setIframeDailyAmount(provider.getString(DAILY_AMOUNT));
		plan.setIframeDailyResponse(provider.getString(DAILY_RESPONSE));
		return plan;
	}
	
	public static TransactionLimitPlanDetails createWithProviderForLimits(KeyValueProvider provider) {
		TransactionLimitPlanDetails plan = new TransactionLimitPlanDetails();
		plan.setIframeDailyAmount(provider.getString(DAILY_AMOUNT));
		plan.setIframeDailyResponse(provider.getString(DAILY_RESPONSE));
		plan.setLimitDailyVelocity(provider.getString(DAILY_VELOCITY));
		plan.setLimitDailyVelocityResponse(provider.getString(DAILY_VELOCITY_RESPONSE));
		plan.setLimitPeriodicAmount(provider.getString(PERIODIC_AMOUNT));
		plan.setLimitPeriodicAmountResponse(provider.getString(PERIODIC_AMOUNT_RESPONSE));
		plan.setLimitPeriodicVelocity(provider.getString(PERIODIC_VELOCITY));
		plan.setLimitPeriodicVelocityResponse(provider.getString(PERIODIC_VELOCITY_RESPONSE));
		plan.setLimitYearlyAmount(provider.getString(YEARLY_AMOUNT));
		plan.setLimitYearlyAmountResponse(provider.getString(YEARLY_AMOUNT_RESPONSE));
		plan.setLimitYearlyVelocity(provider.getString(YEARLY_VELOCITY));
		plan.setLimitYearlyVelocityResponse(provider.getString(YEARLY_VELOCITY_RESPONSE));
		return plan;
	}
	
	@Override
	public String toString() {
		return "TransactionLimitPlanDetails [iframeTransactionType="
				+ iframeTransactionType + ", iframeTransactionSource="
				+ iframeTransactionSource + ", iframeTransactionChannel="
				+ iframeTransactionChannel + ", iframeTransactionOrigin="
				+ iframeTransactionOrigin + ", iframeFloorAmount="
				+ iframeFloorAmount + ", iframeFloorResponse="
				+ iframeFloorResponse + ", iframeCeilingAmount="
				+ iframeCeilingAmount + ", iframeCeilingResponse="
				+ iframeCeilingResponse + ", iframeStandInAmount="
				+ iframeStandInAmount + ", iframeStandInResponse="
				+ iframeStandInResponse + "]";
	}
}
