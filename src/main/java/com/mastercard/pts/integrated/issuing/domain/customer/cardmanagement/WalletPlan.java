package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.apache.commons.lang3.RandomStringUtils;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

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

	public String Currency;

	public String WalletPlanUsage;

	public String WalletType;

	public String ProgramType;
	private String dummyAccountNumber;
	
	private String billingCyleCode;
	
	private String creditPlan;

	public String WalletPlan;

	public String getWalletPlan() {
		return WalletPlan;
	}

	public void setWalletPlan(String walletPlan) {
		WalletPlan = walletPlan;
	}

	public String getWalletType() {
		return WalletType;
	}

	public void setWalletType(String walletType) {
		WalletType = walletType;
	}

	public String getProgramType() {
		return ProgramType;
	}

	public void setProgramType(String programType) {
		ProgramType = programType;
	}

	public String getCurrency() {
		return currency;
	}
	
	public String getWalletPlanCode() {
		return walletPlanCode;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

	public String getWalletPlanUsage() {
		return WalletPlanUsage;
	}

	public void setWalletPlanUsage(String walletPlanUsage) {
		WalletPlanUsage = walletPlanUsage;
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

	@Override
	public String getDescription() {
		return description;
	}
	
	@Override
	public String getCode() {
		return getWalletPlanCode();
	}
	
	public WalletPlan walletplanDataprovider() {
		WalletPlan walletplan = new WalletPlan();
		walletplan.setCurrency(MapUtils.fnGetInputDataFromMap("BaseCurrency"));
		walletplan.setWalletPlanUsage(MapUtils.fnGetInputDataFromMap("WalletplanUsage"));
		return walletplan;
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
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return MiscUtils.toString(this);
	}
	public static WalletPlan createWithProvider(DataProvider provider, KeyValueProvider keyValueProvider) {
		WalletPlan plan = provider.getDataBySimpleClassName(WalletPlan.class);
		plan.setWalletPlanCode(MiscUtils.generate10CharAlphaNumeric());
		plan.setDescription(ConstantData.GENERIC_DESCRIPTION);
		plan.setProgramType(keyValueProvider.getString(PROGRAM_TYPE));
		plan.setDummyAccountNumber(RandomStringUtils.randomNumeric(6));
		return plan;
	}

}
