package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class CreditCardBillingCycle implements HasCodeAndDescription {

	private String description;
	private String billingPlanCode;
	private String billingCycleDay;
	private String recordsPerBatchForProcessing;	
	
	public static CreditCardBillingCycle generateDynamicTestData() {
		CreditCardBillingCycle testdata = new CreditCardBillingCycle();
		testdata.setBillingPlanCode(MiscUtils.generateRandomNumberBetween2Number(100,999));
		testdata.setBillingCycleDay(MiscUtils.generateRandomNumberBetween2Number(1,31));
		testdata.setDescription(ConstantData.GENERIC_DESCRIPTION);
		testdata.setRecordsPerBatchForProcessing(MiscUtils.generateRandomNumberBetween2Number(1,999));
		return testdata;
	}
	
	@Override
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String getCode() {
		return getBillingPlanCode();
	}
	
	public String getBillingPlanCode() {
		return billingPlanCode;
	}
	
	public void setBillingPlanCode(String billingPlanCode) {
		this.billingPlanCode = billingPlanCode;
	}
	
	public String getBillingCycleDay() {
		return billingCycleDay;
	}
	
	public void setBillingCycleDay(String billingCycleDay) {
		this.billingCycleDay = billingCycleDay;
	}
	
	public String getRecordsPerBatchForProcessing() {
		return recordsPerBatchForProcessing;
	}
	
	public void setRecordsPerBatchForProcessing(String recordsPerBatchForProcessing) {
		this.recordsPerBatchForProcessing = recordsPerBatchForProcessing;
	}
	
	@Override
	public String toString() {
		return "ApplicationDocumentChecklist [billingPlanCode=" + billingPlanCode + ", description="
				+ description + ", billingCycleDay=" + billingCycleDay + ", recordsPerBatchForProcessing=" + recordsPerBatchForProcessing + "]";
	}
}
