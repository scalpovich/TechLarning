package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class MCCRulePlan implements HasCodeAndDescription {

	private static final String MCC_APPROVE_DOMESTIC_TRANSACTIONS = "MCC_APPROVE_DOMESTIC_TRANSACTIONS";
	
	private static final String MCC_APPROVE_INTERNATION_TRANSACTIONS = "MCC_APPROVE_INTERNATION_TRANSACTIONS";
	
	private String mccRulePlanCode;
	
	private String description;
	
	private String productType;
	
	private String approveDomesticTransactions;
	
	private String approveInternationalTransactions;
	
	private String fromMccCode;	

	private String toMccCode;
	
	private String origin;
	
	// TODO: Add list of MCC	
	public static MCCRulePlan createGenericTestData() {
		MCCRulePlan plan = new MCCRulePlan();
		plan.setMccRulePlanCode(MiscUtils.generate8CharAlphaNumeric() + MiscUtils.generateRandomNumberAsString(1));
		plan.setDescription(ConstantData.GENERIC_DESCRIPTION);
		return plan;
	}
	
	public static MCCRulePlan  createWithProvider(KeyValueProvider provider) {
		MCCRulePlan plan = new MCCRulePlan();
		plan.setMccRulePlanCode(MiscUtils.generate8CharAlphaNumeric() + MiscUtils.generateRandomNumberAsString(1));
		plan.setDescription(ConstantData.GENERIC_DESCRIPTION);
		plan.setApproveDomesticTransactions(provider.getString(MCC_APPROVE_DOMESTIC_TRANSACTIONS));
		plan.setApproveInternationalTransactions(provider.getString(MCC_APPROVE_INTERNATION_TRANSACTIONS));
		return plan;
	}

	public String getMccRulePlanCode() {
		return mccRulePlanCode;
	}

	public void setMccRulePlanCode(String mccRulePlanCode) {
		this.mccRulePlanCode = mccRulePlanCode;
	}
	
	@Override
	public String getCode() {
		return getMccRulePlanCode();
	}

	@Override
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	@Override
	public String toString() {
		return MiscUtils.toString(this);
	}

	public String getApproveDomesticTransactions() {
		return approveDomesticTransactions;
	}

	public void setApproveDomesticTransactions(
			String approveDomesticTransactions) {
		this.approveDomesticTransactions = approveDomesticTransactions;
	}

	public String getApproveInternationalTransactions() {
		return approveInternationalTransactions;
	}

	public void setApproveInternationalTransactions(
			String approveInternationalTransactions) {
		this.approveInternationalTransactions = approveInternationalTransactions;
	}
	
	public String getFromMccCode() {
		return fromMccCode;
	}

	public void setFromMccCode(String fromMccCode) {
		this.fromMccCode = fromMccCode;
	}

	public String getToMccCode() {
		return toMccCode;
	}

	public void setToMccCode(String toMccCode) {
		this.toMccCode = toMccCode;
	}
	
	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

}