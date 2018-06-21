package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

public class MCCOverlimit {

	private String walletPlan;
	private String currency;
	private String merchantCategoryCode;
	private String overlimitFixedAmount;
	private String overlimitPercentage;

	public String getWalletPlan() {
		return walletPlan;
	}

	public void setWalletPlan(String walletPlan) {
		this.walletPlan = walletPlan;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getMerchantCategoryCode() {
		return merchantCategoryCode;
	}

	public void setMerchantCategoryCode(String merchantCategoryCode) {
		this.merchantCategoryCode = merchantCategoryCode;
	}

	public String getOverlimitFixedAmount() {
		return overlimitFixedAmount;
	}

	public void setOverlimitFixedAmount(String overlimitFixedAmount) {
		this.overlimitFixedAmount = overlimitFixedAmount;
	}

	public String getOverlimitPercentage() {
		return overlimitPercentage;
	}

	public void setOverlimitPercentage(String overlimitPercentage) {
		this.overlimitPercentage = overlimitPercentage;
	}

	// TODO
	public static MCCOverlimit createDataWithProvider(KeyValueProvider provider) {
		MCCOverlimit mccOverlimit = new MCCOverlimit();
		mccOverlimit.setCurrency(provider.getString("Currency"));
		mccOverlimit.setWalletPlan(provider.getString("Wallet Plan"));
		mccOverlimit.setMerchantCategoryCode(provider.getString("Merchant Category Code"));
		mccOverlimit.setOverlimitFixedAmount(provider.getString("Overlimit Fixed Amount"));
		mccOverlimit.setOverlimitPercentage(provider.getString("Overlimit Percentage"));
		return mccOverlimit;
	}

}
