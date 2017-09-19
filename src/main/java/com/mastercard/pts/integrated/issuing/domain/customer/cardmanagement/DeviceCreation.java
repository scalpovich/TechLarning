package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;

@Component
public class DeviceCreation extends AbstractBasePage {

	public String CutoverHours;

	public String CutoverMins;

	public String Interchange;

	public String Product;

	public String planType;

	public String Currency;

	public String AddressLine3;

	public String ProgramCode;

	public String TemplateType;

	public String getTemplateType() {
		return TemplateType;
	}

	public void setTemplateType(String templateType) {
		TemplateType = templateType;
	}

	public String getExpiryFlag() {
		return expiryFlag;
	}

	public void setExpiryFlag(String expiryFlag) {
		this.expiryFlag = expiryFlag;
	}

	public String expiryFlag;

	public String getProgramCode() {
		return ProgramCode;
	}

	public void setProgramCode(String programCode) {
		ProgramCode = programCode;
	}

	public String getProgramdescription() {
		return programdescription;
	}

	public void setProgramdescription(String programdescription) {
		this.programdescription = programdescription;
	}

	public String programdescription;

	public String getAddressLine3() {
		return AddressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		AddressLine3 = addressLine3;
	}

	public String getAddressLine4() {
		return AddressLine4;
	}

	public void setAddressLine4(String addressLine4) {
		AddressLine4 = addressLine4;
	}

	public String AddressLine4;

	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

	public String Length;

	public String getLength() {
		return Length;
	}

	public void setLength(String length) {
		Length = length;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public String getProduct() {
		return Product;
	}

	public void setProduct(String product) {
		Product = product;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String Description;

	public String getZoneCode() {
		return ZoneCode;
	}

	public void setZoneCode(String zoneCode) {
		ZoneCode = zoneCode;
	}

	public String getZoneName() {
		return ZoneName;
	}

	public void setZoneName(String zoneName) {
		ZoneName = zoneName;
	}

	public String ZoneCode;

	public String ZoneName;

	public String BusinessMandatoryField;

	public String getBusinessMandatoryField() {
		return BusinessMandatoryField;
	}

	public void setBusinessMandatoryField(String businessMandatoryField) {
		BusinessMandatoryField = businessMandatoryField;
	}

	public String getInterchange() {
		return Interchange;
	}

	public void setInterchange(String interchange) {
		Interchange = interchange;
	}

	public String getCutoverHours() {
		return CutoverHours;
	}

	public void setCutoverHours(String cutoverHours) {
		CutoverHours = cutoverHours;
	}

	public String getCutoverMins() {
		return CutoverMins;
	}

	public void setCutoverMins(String cutoverMins) {
		CutoverMins = cutoverMins;
	}

	// public DeviceCreation deviceCreationDatProvider() {
	// DeviceCreation deviceCreation = new DeviceCreation();
	// deviceCreation.setCurrency(MapUtils.fnGetInputDataFromMap("BaseCurrency"));
	// deviceCreation.setCurrencyConversionBy(MapUtils.fnGetInputDataFromMap("CurrencyConversionBy"));
	// deviceCreation.setMaxBalanceWithoutKYC(MapUtils.fnGetInputDataFromMap("MaximumBalancewithoutKYC"));
	// deviceCreation.setLoadsWithoutKYC(MapUtils.fnGetInputDataFromMap("LoadsWithoutKYC"));
	// return deviceCreation;
	// }

}
