package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

public class DevicePlan extends AbstractBasePage {

	public String DeviceType;

	public String getDeviceType() {
		return DeviceType;
	}

	public void setDeviceType(String deviceType) {
		DeviceType = deviceType;
	}

	public String getServiceCode() {
		return ServiceCode;
	}

	public void setServiceCode(String serviceCode) {
		ServiceCode = serviceCode;
	}

	public String getCustomCode() {
		return CustomCode;
	}

	public void setCustomCode(String customCode) {
		CustomCode = customCode;
	}

	public String getExpiryFlag() {
		return ExpiryFlag;
	}

	public void setExpiryFlag(String expiryFlag) {
		ExpiryFlag = expiryFlag;
	}

	public String getExpiryDate() {
		return ExpiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		ExpiryDate = expiryDate;
	}

	public String getDeliveryMode() {
		return DeliveryMode;
	}

	public void setDeliveryMode(String deliveryMode) {
		DeliveryMode = deliveryMode;
	}

	public String ServiceCode;
	public String CustomCode;
	public String ExpiryFlag;
	public String ExpiryDate;
	public String DeliveryMode;
	public String TotalTransactionLimit;
	public String PerTransactionLimit;
	public String Validity;
	public String Velocity;

	public String getValidity() {
		return Validity;
	}

	public void setValidity(String validity) {
		Validity = validity;
	}

	public String getVelocity() {
		return Velocity;
	}

	public void setVelocity(String velocity) {
		Velocity = velocity;
	}

	public String getTotalTransactionLimit() {
		return TotalTransactionLimit;
	}

	public void setTotalTransactionLimit(String totalTransactionLimit) {
		TotalTransactionLimit = totalTransactionLimit;
	}

	public String getPerTransactionLimit() {
		return PerTransactionLimit;
	}

	public void setPerTransactionLimit(String perTransactionLimit) {
		PerTransactionLimit = perTransactionLimit;
	}

	public String DevicePlan;

	public String getDevicePlan() {
		return DevicePlan;
	}

	public void setDevicePlan(String devicePlan) {
		DevicePlan = devicePlan;
	}

	public DevicePlan deviceplanDataprovider() {
		DevicePlan deviceplan = new DevicePlan();
		deviceplan.setServiceCode(MapUtils.fnGetInputDataFromMap("ServiceCode"));
		deviceplan.setCustomCode(MapUtils.fnGetInputDataFromMap("CustomCode"));
		deviceplan.setExpiryFlag(MapUtils.fnGetInputDataFromMap("ExpiryFlag"));
		deviceplan.setExpiryDate(MapUtils.fnGetInputDataFromMap("ExpiryDate"));
		deviceplan.setDeliveryMode(MapUtils.fnGetInputDataFromMap("DeliveryMode"));
		deviceplan.setPerTransactionLimit(MapUtils.fnGetInputDataFromMap("PerTransactionLimit"));
		deviceplan.setTotalTransactionLimit(MapUtils.fnGetInputDataFromMap("TotalTransactionLimit"));
		deviceplan.setVelocity(MapUtils.fnGetInputDataFromMap("Velocity"));
		deviceplan.setValidity(MapUtils.fnGetInputDataFromMap("Validity"));
		return deviceplan;
	}

}
