package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.apache.commons.lang3.RandomStringUtils;

import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class WalletPlan implements HasCodeAndDescription {
	
	private static final String PROGRAM_TYPE = "PROGRAM_TYPE";
	
	private String description;

	private String walletPlanCode;

	private String currency;

	private String productType;

	private String programType;

	private String usage;
	
	private String dummyAccountNumber;
	
	private String billingCyleCode;
	
	private String creditPlan;

	public static WalletPlan createWithProvider(DataProvider provider, KeyValueProvider keyValueProvider) {
		WalletPlan plan = provider.getDataBySimpleClassName(WalletPlan.class);
		plan.setWalletPlanCode(MiscUtils.generate10CharAlphaNumeric());
		plan.setDescription(ConstantData.GENERIC_DESCRIPTION);
		plan.setProgramType(keyValueProvider.getString(PROGRAM_TYPE));
		plan.setDummyAccountNumber(RandomStringUtils.randomNumeric(6));
		return plan;
	}

	@Override
	public String getDescription() {
		return description;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	public String getProgramType() {
		return programType;
	}

	public void setProgramType(String programType) {
		this.programType = programType;
	}
	
	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	@Override
	public String getCode() {
		return getWalletPlanCode();
	}
	
	public String getWalletPlanCode() {
		return walletPlanCode;
	}

	public void setWalletPlanCode(String walletPlanCode) {
		this.walletPlanCode = walletPlanCode;
	}

	public String getDummyAccountNumber() {
		return dummyAccountNumber;
	}

	public void setDummyAccountNumber(String dummyAccountNumber) {
		this.dummyAccountNumber = dummyAccountNumber;
	}

	public String getBillingCyleCode() {
		return billingCyleCode;
	}

	public void setBillingCyleCode(String billingCyleCode) {
		this.billingCyleCode = billingCyleCode;
	}

	public String getCreditPlan() {
		return creditPlan;
	}

	public void setCreditPlan(String creditPlan) {
		this.creditPlan = creditPlan;
	}
	
	@Override
	public String toString() {
		return MiscUtils.toString(this);
	}
}
