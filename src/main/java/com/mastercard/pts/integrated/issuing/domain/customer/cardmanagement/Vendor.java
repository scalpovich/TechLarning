package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class Vendor {

	public String AddressLine1;
	public String AddressLine2;
	public String Country;
	public String PINFileTemplateName;
	public String PostalCode;
	public String VendorMobileNo;
	public String Email;
	public String VendorCategory;
	public String BranchCode;
	public String embossingFileTemp;
	public String newVendorDetails;
	public String NewVendor;

	// public static Vendor vendor = new Vendor();

	public String getNewVendorDetails() {
		return newVendorDetails;
	}

	public void setNewVendorDetails(String newVendorDetails) {
		this.newVendorDetails = newVendorDetails;
	}

	public String getEmbossingFileTemp() {
		return embossingFileTemp;
	}

	public void setEmbossingFileTemp(String embossingFileTemp) {
		this.embossingFileTemp = embossingFileTemp;
	}

	public String getBranchCode() {
		return BranchCode;
	}

	public void setBranchCode(String branchCode) {
		BranchCode = branchCode;
	}

	public String getAddressLine1() {
		return AddressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		AddressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return AddressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		AddressLine2 = addressLine2;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getPINFileTemplateName() {
		return PINFileTemplateName;
	}

	public void setPINFileTemplateName(String pINFileTemplateName) {
		PINFileTemplateName = pINFileTemplateName;
	}

	public String getPostalCode() {
		return PostalCode;
	}

	public void setPostalCode(String postalCode) {
		PostalCode = postalCode;
	}

	public String getVendorMobileNo() {
		return VendorMobileNo;
	}

	public void setVendorMobileNo(String vendorMobileNo) {
		VendorMobileNo = vendorMobileNo;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getVendorCategory() {
		return VendorCategory;
	}

	public void setVendorCategory(String vendorCategory) {
		VendorCategory = vendorCategory;
	}

	public String getNewVendor() {
		return NewVendor;
	}

	public void setNewVendor(String newVendor) {
		NewVendor = newVendor;
	}

	public void vendorDataProvider() {
		setAddressLine1(MapUtils.fnGetInputDataFromMap("addressLine1"));
		setAddressLine2(MapUtils.fnGetInputDataFromMap("addressLine2"));
		setCountry(MapUtils.fnGetInputDataFromMap("country"));
		setBranchCode(MapUtils.fnGetInputDataFromMap("BranchCode"));
		setPINFileTemplateName(MapUtils.fnGetInputDataFromMap("PINFileTempName"));
		setPostalCode(MapUtils.fnGetInputDataFromMap("postalCode"));
		setVendorMobileNo(MapUtils.fnGetInputDataFromMap("vendorMobileNo1"));
		setEmail(MapUtils.fnGetInputDataFromMap("email"));

	}

}
