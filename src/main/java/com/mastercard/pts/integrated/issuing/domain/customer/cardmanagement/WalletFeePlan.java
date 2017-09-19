package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.util.ArrayList;
import java.util.List;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

import org.apache.commons.lang3.RandomStringUtils;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
public class WalletFeePlan {
	public String Currency;

	public String FeeAmount;

	public String WaiverPeriod;

	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

	public String getFeeAmount() {
		return FeeAmount;
	}

	public void setFeeAmount(String feeAmount) {
		FeeAmount = feeAmount;
	}

	public String getWaiverPeriod() {
		return WaiverPeriod;
	}

	public void setWaiverPeriod(String waiverPeriod) {
		WaiverPeriod = waiverPeriod;
	}

	public String WalletFeePlanType;

	public String getWalletFeePlanType() {
		return WalletFeePlanType;
	}

	public void setWalletFeePlanType(String walletFeePlanType) {
		WalletFeePlanType = walletFeePlanType;
	}

	public WalletFeePlan walletfeeplanDataProvider() {
		WalletFeePlan walletfeeplan = new WalletFeePlan();
		walletfeeplan.setCurrency(MapUtils.fnGetInputDataFromMap("BaseCurrency"));
		walletfeeplan.setFeeAmount(MapUtils.fnGetInputDataFromMap("Fee"));
		walletfeeplan.setWaiverPeriod(MapUtils.fnGetInputDataFromMap("WaiveCycle"));
		return walletfeeplan;
	}

	private static final String KEY_CURRENCY = "CURRENCY";
	
	private String productType;

	private String walletFeePlanCode;
	
	private String description;
	
	private String currency;

	private List<WalletFeePlanDetails> walletFeePlanDetails = new ArrayList<>();

	public static WalletFeePlan createWithProvider(KeyValueProvider provider) {
		WalletFeePlan plan = new WalletFeePlan();
		plan.setWalletFeePlanCode("WFP" + RandomStringUtils.randomNumeric(4));
		plan.setDescription(ConstantData.GENERIC_DESCRIPTION);
		plan.setCurrency(provider.getString(KEY_CURRENCY));
		return plan;
	}
	
	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
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

	public String getWalletFeePlanCode() {
		return walletFeePlanCode;
	}

	public void setWalletFeePlanCode(String walletFeePlanCode) {
		this.walletFeePlanCode = walletFeePlanCode;
	}

	public List<WalletFeePlanDetails> getWalletFeePlanDetails() {
		return walletFeePlanDetails;
	}

	public void setWalletFeePlanDetails(List<WalletFeePlanDetails> walletFeePlanDetails) {
		this.walletFeePlanDetails = walletFeePlanDetails;
	}


}
