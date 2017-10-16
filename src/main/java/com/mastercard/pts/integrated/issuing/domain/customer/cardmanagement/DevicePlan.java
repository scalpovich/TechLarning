package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class DevicePlan {

	public String devicePlanCode;
	public String association;
	public String productType;
	public String DeviceType;
	public String ServiceCode;
	public String CustomCode;
	public String ExpiryFlag;
	public String ExpiryDate;
	public String validateonInitialMonths;
	public String DeliveryMode;
	public String TotalTransactionLimit;
	public String PerTransactionLimit;
	public String Validity;
	public String Velocity;
	public String embossiongVendor;
	public String activationMode;

	public String getActivationMode() {
		return activationMode;
	}

	public void setActivationMode(String activationMode) {
		this.activationMode = activationMode;
	}

	public String getValidateonInitialMonths() {
		return validateonInitialMonths;
	}

	public void setValidateonInitialMonths(String validateonInitialMonths) {
		this.validateonInitialMonths = validateonInitialMonths;
	}

	public String getEmbossiongVendor() {
		return embossiongVendor;
	}

	public void setEmbossiongVendor(String embossiongVendor) {
		this.embossiongVendor = embossiongVendor;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getAssociation() {
		return association;
	}

	public void setAssociation(String association) {
		this.association = association;
	}

	public String getDevicePlanCode() {
		return devicePlanCode;
	}

	public void setDevicePlanCode(String devicePlanCode) {
		this.devicePlanCode = devicePlanCode;
	}

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

	public void devicePlanDataprovider() {
		// DevicePlan deviceplan = new DevicePlan();
		setDevicePlanCode(CustomUtils.randomNumbers(5));
		setValidateonInitialMonths(CustomUtils.randomNumbers(2));
		setServiceCode(MapUtils.fnGetInputDataFromMap("ServiceCode"));
		setCustomCode(MapUtils.fnGetInputDataFromMap("CustomCode"));
		setExpiryFlag(MapUtils.fnGetInputDataFromMap("ExpiryFlag"));
		setExpiryDate(MapUtils.fnGetInputDataFromMap("ExpiryDate"));
		setDeliveryMode(MapUtils.fnGetInputDataFromMap("DeliveryMode"));
		setPerTransactionLimit(MapUtils.fnGetInputDataFromMap("PerTransactionLimit"));
		setTotalTransactionLimit(MapUtils.fnGetInputDataFromMap("TotalTransactionLimit"));
		setVelocity(MapUtils.fnGetInputDataFromMap("Velocity"));
		setValidity(MapUtils.fnGetInputDataFromMap("Validity"));

	}

}
