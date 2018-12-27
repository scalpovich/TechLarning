package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

@Component
public class DevicePromotionPlan implements HasCodeAndDescription{

	private String devicePromoPlanCode;
	private String productType;
	private String planDescription;
	private LocalDate effectiveDate;
	private LocalDate endDate;
	private String transactionLimitPlan;
	private String deviceJoiningMemFeePlan;
	private String transactionFeePlan;
	private String eventBasedFeePlan;
	private String transactionWaiverPlan;
	private String loyaltyPlan;
	
	private static final String EFFECTIVE_DATE = "EFFECTIVE_DATE";
	private static final String END_DATE = "END_DATE";
	private static final String EVENT_BASED_FEE_PLAN = "EVENT_BASED_FEE_PLAN";
	private static final String JOINING_MEM_FEE_PLAN = "JOINING_MEM_FEE_PLAN";
	private static final String TX_FEE_PLAN = "TX_FEE_PLAN";
	private static final String TX_LIMIT_PLAN = "TX_LIMIT_PLAN";
	private static final String PLAN_CODE = "PLAN_CODE";
	private static final String DESCRIPTION = "DESCRIPTION";
	private static final String TX_WAIVER_PLAN = "TX_WAIVER_PLAN"; 
	private static final String LOYALTY_PLAN = "LOYALTY_PLAN";
	
	public String getDevicePromotionPlanCode() {
		return devicePromoPlanCode;
	}

	public void setDevicePromotionPlanCode(String devicePromotionPlanCode) {
		this.devicePromoPlanCode = devicePromotionPlanCode;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getTransactionLimitPlan() {
		return transactionLimitPlan;
	}

	public void setTransactionLimitPlan(String transactionLimitPlan) {
		this.transactionLimitPlan = transactionLimitPlan;
	}

	public String getPlanDescription() {
		return planDescription;
	}

	public void setPlanDescription(String planDescription) {
		this.planDescription = planDescription;
	}

	public String getDeviceJoiningMemFeePlan() {
		return deviceJoiningMemFeePlan;
	}

	public void setDeviceJoiningMemFeePlan(String deviceJoiningMemFeePlan) {
		this.deviceJoiningMemFeePlan = deviceJoiningMemFeePlan;
	}

	public String getTransactionFeePlan() {
		return transactionFeePlan;
	}

	public void setTransactionFeePlan(String transactionFeePlan) {
		this.transactionFeePlan = transactionFeePlan;
	}

	public String getEventBasedFeePlan() {
		return eventBasedFeePlan;
	}

	public void setEventBasedFeePlan(String eventBasedFeePlan) {
		this.eventBasedFeePlan = eventBasedFeePlan;
	}
	
	public String getTransactionWaiverPlan() {
		return transactionWaiverPlan;
	}

	public void setTransactionWaiverPlan(String transactionWaiverPlan) {
		this.transactionWaiverPlan = transactionWaiverPlan;
	}

	public String getLoyaltyPlan() {
		return loyaltyPlan;
	}

	public void setLoyaltyPlan(String loyaltyPlan) {
		this.loyaltyPlan = loyaltyPlan;
	}
	
	public static DevicePromotionPlan createWithProvider(KeyValueProvider provider) {
		DevicePromotionPlan devicePromoPlan = new DevicePromotionPlan();
		devicePromoPlan.setDevicePromotionPlanCode(provider.getString(PLAN_CODE));
		devicePromoPlan.setPlanDescription(provider.getString(DESCRIPTION));
		devicePromoPlan.setEffectiveDate(LocalDate.now().plusDays(provider.getInt(EFFECTIVE_DATE)));
		devicePromoPlan.setEndDate(LocalDate.now().plusDays(provider.getInt(END_DATE)));
		devicePromoPlan.setEventBasedFeePlan(provider.getString(EVENT_BASED_FEE_PLAN));
		devicePromoPlan.setDeviceJoiningMemFeePlan(provider.getString(JOINING_MEM_FEE_PLAN));
		devicePromoPlan.setTransactionFeePlan(provider.getString(TX_FEE_PLAN));
		devicePromoPlan.setTransactionLimitPlan(provider.getString(TX_LIMIT_PLAN));
		devicePromoPlan.setTransactionWaiverPlan(provider.getString(TX_WAIVER_PLAN));
		devicePromoPlan.setLoyaltyPlan(provider.getString(LOYALTY_PLAN));
		return devicePromoPlan;
	}
	
	@Override
	public String getCode() {
		return getDevicePromotionPlanCode();
	}

	@Override
	public String getDescription() {
		return getPlanDescription();
	}

}