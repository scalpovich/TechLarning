package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;

public class CurrencyPayoutListPlan {

	private static final String SP_CURRENCY = "Currency_Code";
	private static final String EFFECTIVE_DATE = "Effective_Date";
	private static final String END_DATE = "End_Date";
	private static final String REFUND_TOLERANCE_UNIT = "Refund_Tolerance_Unit";
	
	private String description;
	private String currency;
	private LocalDate effectiveDate;
	private LocalDate endDate;
	private String refundToleranceUnit;
	private String planCode;

	public static CurrencyPayoutListPlan getCurrencyPayoutListPlanData(KeyValueProvider provider) {
		CurrencyPayoutListPlan plan = new CurrencyPayoutListPlan();
		plan.setCurrencyPayoutListplanCode(CustomUtils.randomAlphaNumeric(5).toUpperCase());
		plan.setDescription(ConstantData.GENERIC_DESCRIPTION);
		plan.setCurrency(provider.getString(SP_CURRENCY));
		plan.setEffectiveDate(LocalDate.parse(provider.getString(EFFECTIVE_DATE),DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		plan.setEndDate(LocalDate.parse(provider.getString(END_DATE),DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		plan.setRefundToleranceUnit(provider.getString(REFUND_TOLERANCE_UNIT));
		
		return plan;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
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
	
	public String getRefundToleranceUnit() {
		return refundToleranceUnit;
	}

	public void setRefundToleranceUnit(String refundToleranceUnit) {
		this.refundToleranceUnit = refundToleranceUnit;
	}

	public String getCurrencyPayoutListPlanCode() {
		return planCode;
	}

	public void setCurrencyPayoutListplanCode(String planCode) {
		this.planCode = planCode;
	}

}
