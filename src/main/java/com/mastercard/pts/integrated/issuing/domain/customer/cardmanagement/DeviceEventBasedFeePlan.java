package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import java.util.ArrayList;
import java.util.List;

import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class DeviceEventBasedFeePlan implements HasCodeAndDescription {
	
	private static final String DEBFP_CURRENCY = "DEBFP_CURRENCY";
	public String EffectiveDate;
	
	public String EndDate;
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
	
	public static DeviceEventBasedFeePlan createWithProvider(KeyValueProvider provider) {
		DeviceEventBasedFeePlan plan = new DeviceEventBasedFeePlan();
		plan.setDeviceCode(MiscUtils.generate8CharAlphaNumeric());
		plan.setDescription(ConstantData.GENERIC_DESCRIPTION);
		plan.setCurrency(provider.getString(DEBFP_CURRENCY));
		return plan;
	}
	
	public String getEffectiveDate() {
		return EffectiveDate;
	}	
	public void setEffectiveDate(String effectiveDate) {
		EffectiveDate = effectiveDate;
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
	public String getEndDate() {
		return EndDate;
	}

	public void setEndDate(String endDate) {
		EndDate = endDate;
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
	
	public String getCurrency() {
		return currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public List<DeviceEventBasedFeePlanDetails> getDeviceEventBasedFeePlanDetails() {
		return deviceEventBasedFeePlanDetails;
	}

	public void setDeviceEventBasedFeePlanDetails(List<DeviceEventBasedFeePlanDetails> deviceEventBasedFeePlanDetails) {
		this.deviceEventBasedFeePlanDetails = deviceEventBasedFeePlanDetails;
	}
	public static DeviceEventBasedFeePlan deviceeventbasedfeeplanDataProvider() {
		DeviceEventBasedFeePlan deviceeventbasedfeeplan = new DeviceEventBasedFeePlan();
		deviceeventbasedfeeplan.setCurrency(MapUtils.fnGetInputDataFromMap("BaseCurrency"));
		deviceeventbasedfeeplan.setEndDate(MapUtils.fnGetInputDataFromMap("EndDate"));
		deviceeventbasedfeeplan.setEffectiveDate(DateUtils.getDateinDDMMYYYY());
		return deviceeventbasedfeeplan;
	}


	@Override
	public String toString() {
		return MiscUtils.toString(this);
	}
}