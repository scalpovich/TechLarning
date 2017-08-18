package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.util.ArrayList;
import java.util.List;

import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class DeviceJoiningAndMemberShipFeePlan implements HasCodeAndDescription {
	
	private String deviceCode;
	private String productType;
	private String currency;
	private String description;
	
	private List<DeviceJoiningAndMemberShipFeePlanDetails> deviceJoiningAndMemberShipFeePlanDetails = new ArrayList<>();
	
	public static DeviceJoiningAndMemberShipFeePlan createWithProvider(DataProvider provider) {
		DeviceJoiningAndMemberShipFeePlan plan = provider.getDataBySimpleClassName(DeviceJoiningAndMemberShipFeePlan.class);
		plan.setDeviceCode(MiscUtils.generate8CharAlphaNumeric());
		plan.setDescription(ConstantData.GENERIC_DESCRIPTION);
		return plan;
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
		return getDeviceCode();
	}
	
	public String getDeviceCode() {
		return deviceCode;
	}
	
	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}
	
	public String getProductType() {
		return productType;
	}
	
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public void setCurrency(String currencyType) {
		this.currency = currencyType;
	}
	
	public List<DeviceJoiningAndMemberShipFeePlanDetails> getDeviceJoiningAndMemberShipFeePlanDetails() {
		return deviceJoiningAndMemberShipFeePlanDetails;
	}

	public void setDeviceJoiningAndMemberShipFeePlanDetails(List<DeviceJoiningAndMemberShipFeePlanDetails> deviceJoiningAndMemberShipFeePlanDetails) {
		this.deviceJoiningAndMemberShipFeePlanDetails = deviceJoiningAndMemberShipFeePlanDetails;
	}

	@Override
	public String toString() {
		return MiscUtils.toString(this);
	}
}
