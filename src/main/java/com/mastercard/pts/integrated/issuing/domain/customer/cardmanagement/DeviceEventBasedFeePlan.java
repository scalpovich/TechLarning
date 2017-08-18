package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.util.ArrayList;
import java.util.List;

import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class DeviceEventBasedFeePlan implements HasCodeAndDescription {
	
	private String deviceCode;
	private String productType;
	private String currency;
	private String description;
	
	private List<DeviceEventBasedFeePlanDetails> deviceEventBasedFeePlanDetails = new ArrayList<>();
	
	public static DeviceEventBasedFeePlan createWithProvider(DataProvider provider) {
		DeviceEventBasedFeePlan plan = provider.getDataBySimpleClassName(DeviceEventBasedFeePlan.class);
		plan.setDeviceCode(MiscUtils.generate8CharAlphaNumeric());
		plan.setDescription(ConstantData.GENERIC_DESCRIPTION);
		return plan;
	}
	
	@Override
	public String getCode() {
		return getDeviceCode();
	}
	
	public String getDeviceCode() {
		return deviceCode;
	}
	
	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}
	
	@Override
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

	public String getProductType() {
		return productType;
	}
	
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	public List<DeviceEventBasedFeePlanDetails> getDeviceEventBasedFeePlanDetails() {
		return deviceEventBasedFeePlanDetails;
	}

	public void setDeviceEventBasedFeePlanDetails(List<DeviceEventBasedFeePlanDetails> deviceEventBasedFeePlanDetails) {
		this.deviceEventBasedFeePlanDetails = deviceEventBasedFeePlanDetails;
	}

	@Override
	public String toString() {
		return MiscUtils.toString(this);
	}
}