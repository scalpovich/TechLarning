package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

public class BulkDeviceRequest {

	private static final String BRANCH_KEY = "BRANCH";
	
	private static final String CORPORATE_CLIENT_CODE = "CORPORATE_CLIENT_CODE";
	
	private static final String WALLET_PROMOTION_PLAN1 = "BDR_WALLET_PROMOTION_PLAN1";
	
	private static final String DEVICE_PROMOTION_PLAN = "BDR_DEVICE_PROMOTION_PLAN";
	
	private static final String EMBOSSING_NAME = "BDR_EMBOSSING_NAME";
	
	private static final String EMBOSSING_LINE_4 = "BDR_EMBOSSING_LINE_4";
	
	private static final String DUMMY_ACCOUNT_NUMBER = "BDR_DUMMY_ACCOUNT_NUMBER";
	
	private static final String QUANTITY_REQUESTED = "BDR_QUANTITY_REQUESTED";
	
	private String productType;
	
	private String branch;
	
	private String program;

	private String corporateClientCode;
	
	private String walletPromotionPlan1;
	
	private String devicePromotionPlan;
	
	private String devicePlan;
	
	private String quantityRequested;
	
	private String embossingName;
	
	private String embossingLine4;
	
	private String dummyAccountNumber;
	
	public static BulkDeviceRequest createWithProvider(KeyValueProvider provider){
		BulkDeviceRequest request = new BulkDeviceRequest();
		request.setBranch(provider.getString(BRANCH_KEY));
		request.setCorporateClientCode(provider.getString(CORPORATE_CLIENT_CODE));
		request.setWalletPromotionPlan1(provider.getString(WALLET_PROMOTION_PLAN1));
		request.setDevicePromotionPlan(provider.getString(DEVICE_PROMOTION_PLAN));		
		request.setQuantityRequested(provider.getString(QUANTITY_REQUESTED));
		request.setEmbossingName(provider.getString(EMBOSSING_NAME));
		request.setEmbossingLine4(provider.getString(EMBOSSING_LINE_4));
		request.setDummyAccountNumber(provider.getString(DUMMY_ACCOUNT_NUMBER));
		return request;
	}
	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getCorporateClientCode() {
		return corporateClientCode;
	}

	public void setCorporateClientCode(String corporateClientCode) {
		this.corporateClientCode = corporateClientCode;
	}

	public String getDevicePlan() {
		return devicePlan;
	}

	public void setDevicePlan(String devicePlan) {
		this.devicePlan = devicePlan;
	}

	public String getQuantityRequested() {
		return quantityRequested;
	}

	public void setQuantityRequested(String quantityRequested) {
		this.quantityRequested = quantityRequested;
	}
	
	public String getWalletPromotionPlan1() {
		return walletPromotionPlan1;
	}
	
	public String getDevicePromotionPlan() {
		return devicePromotionPlan;
	}
	
	public String getEmbossingName() {
		return embossingName;
	}
	
	public String getEmbossingLine4() {
		return embossingLine4;
	}
	
	public String getDummyAccountNumber() {
		return dummyAccountNumber;
	}
	
	public void setWalletPromotionPlan1(String walletPromotionPlan1) {
		this.walletPromotionPlan1 = walletPromotionPlan1;
	}
	
	public void setDevicePromotionPlan(String devicePromotionPlan) {
		this.devicePromotionPlan = devicePromotionPlan;
	}
	
	public void setEmbossingName(String embossingName) {
		this.embossingName = embossingName;
	}
	
	public void setEmbossingLine4(String embossingLine4) {
		this.embossingLine4 = embossingLine4;
	}
	
	public void setDummyAccountNumber(String dummyAccountNumber) {
		this.dummyAccountNumber = dummyAccountNumber;
	}
		
}
