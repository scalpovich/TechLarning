package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.util.ArrayList;
import java.util.List;

import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class TransactionLimitPlan implements HasCodeAndDescription {
	
	private String transactionLimitPlanCode;
	private String description; 
	private String iframeproductType;
	private String iframePlanType;
	private String iframeStartMonthForYearlyLimits;
	
	private List<TransactionLimitPlanDetails> transactionLimitPlanDetails = new ArrayList<>();
	
	public static TransactionLimitPlan createWithProvider(DataProvider provider) {
		TransactionLimitPlan plan = provider.getDataBySimpleClassName(TransactionLimitPlan.class);
		plan.setTransactionLimitPlanCode(MiscUtils.generate10CharAlphaNumeric());
		plan.setDescription(ConstantData.GENERIC_DESCRIPTION);
		return plan;
	}
	
	@Override
	public String getCode() {
		return getTransactionLimitPlanCode();
	}
	
	public String getTransactionLimitPlanCode() {
		return transactionLimitPlanCode;
	}
	
	public void setTransactionLimitPlanCode(
			String transactionLimitPlanCode) {
		this.transactionLimitPlanCode = transactionLimitPlanCode;
	}
	
	@Override
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getIframeproductType() {
		return iframeproductType;
	}
	public void setIframeproductType(String iframeproductType) {
		this.iframeproductType = iframeproductType;
	}
	public String getIframePlanType() {
		return iframePlanType;
	}
	public void setIframePlanType(String iframePlanType) {
		this.iframePlanType = iframePlanType;
	}
	public String getIframeStartMonthForYearlyLimits() {
		return iframeStartMonthForYearlyLimits;
	}
	public void setIframeStartMonthForYearlyLimits(
			String iframeStartMonthForYearlyLimits) {
		this.iframeStartMonthForYearlyLimits = iframeStartMonthForYearlyLimits;
	}
	
	public List<TransactionLimitPlanDetails> getTransactionLimitPlanDetails() {
		return transactionLimitPlanDetails;
	}

	public void setTransactionLimitPlanDetails(List<TransactionLimitPlanDetails> transactionLimitPlanDetails) {
		this.transactionLimitPlanDetails = transactionLimitPlanDetails;
	}
	
	@Override
	public String toString() {
		return MiscUtils.toString(this);
	}
}
