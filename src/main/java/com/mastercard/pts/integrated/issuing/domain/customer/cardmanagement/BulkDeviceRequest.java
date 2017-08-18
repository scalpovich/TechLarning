package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.apache.commons.lang3.RandomUtils;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

public class BulkDeviceRequest {

	private static final String BRANCH_KEY = "BRANCH";
	
	private static final String CORPORATE_CLIENT_CODE = "CORPORATE_CLIENT_CODE";
	
	private String productType;
	
	private String branch;
	
	private String program;

	private String corporateClientCode;
	
	private String devicePlan;
	
	private String quantityRequested;
	
	public static BulkDeviceRequest createWithProvider(KeyValueProvider provider){
		BulkDeviceRequest request = new BulkDeviceRequest();
		request.setBranch(provider.getString(BRANCH_KEY));
		request.setCorporateClientCode(provider.getString(CORPORATE_CLIENT_CODE));
		request.setQuantityRequested(String.valueOf(RandomUtils.nextInt(2,10)));
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
		
}
