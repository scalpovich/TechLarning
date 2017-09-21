package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.util.ArrayList;
import java.util.List;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;


public class Vendor {
	private String AddressLine1;
	private String AddressLine2;
	private String PINFileTemplateName;
	private String PostalCode;
	private String VendorMobileNo;
	private String VendorCategory;
	private String vendorCode;
	private String vendorName;
	private String category;
	private String branch;
	private String embosingFileTemplate;
	private String address1;
	private String address2;
	private String country;
	private String contactPerson;
	private String mobileNoType;
	private String mobileNumber;
	private String phoneNumber;
	private String email;

	
	public String getBranch() {
		return branch;
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


	public String getVendorCategory() {
		return VendorCategory;
	}

	public void setVendorCategory(String vendorCategory) {
		VendorCategory = vendorCategory;
	}

	public String Vendor;

	public String getVendor() {
		return Vendor;
	}

	public void setVendor(String vendor) {
		Vendor = vendor;
	}

	public Vendor vendorDataProvider() {
		Vendor vendor = new Vendor();
		vendor.setAddressLine1(MapUtils.fnGetInputDataFromMap("addressLine1"));
		vendor.setAddressLine2(MapUtils.fnGetInputDataFromMap("addressLine2"));
		vendor.setCountry(MapUtils.fnGetInputDataFromMap("country"));
		vendor.setPINFileTemplateName(MapUtils.fnGetInputDataFromMap("PINFileTempName"));
		vendor.setPostalCode(MapUtils.fnGetInputDataFromMap("postalCode"));
		vendor.setVendorMobileNo(MapUtils.fnGetInputDataFromMap("vendorMobileNo1"));
		vendor.setEmail(MapUtils.fnGetInputDataFromMap("email"));
		return vendor;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	
	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getMobileNoType() {
		return mobileNoType;
	}

	public void setMobileNoType(String mobileNoType) {
		this.mobileNoType = mobileNoType;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public static List<Vendor>  createWithProvider(KeyValueProvider provider)
	{
		
		List<Vendor> vendorMasterData = new ArrayList<>();
		
		Vendor autoBranchCourier = new Vendor();
		autoBranchCourier.setVendorName(provider.getString("AUTOMATION_ BRANCH_COURIER_VENDOR_NAME"));
		autoBranchCourier.setCategory(provider.getString("AUTOMATION_BRANCH_COURIER_CATEGORY"));
		autoBranchCourier.setBranch(provider.getString("AUTOMATION_BRANCH_COURIER_BRANCH"));
		autoBranchCourier.setVendorCode(provider.getString("AUTOMATION_BRANCH_COURIER_VENDOR_CODE"));
		vendorMasterData.add(autoBranchCourier);
		
		Vendor autoRedAgent = new Vendor();
		autoRedAgent.setVendorName(provider.getString("AUTOMATION_RED_AGENT_VENDOR_NAME"));
		autoRedAgent.setCategory(provider.getString("AUTOMATION_RED_AGENT_CATEGORY"));
		autoRedAgent.setBranch(provider.getString("AUTOMATION_RED_AGENT_BRANCH"));
		autoRedAgent.setVendorCode(provider.getString("AUTOMATION_RED_AGENT_VENDOR_CODE"));
		vendorMasterData.add(autoRedAgent);
		
		
		Vendor autoPlasticManuf = new Vendor();
		autoPlasticManuf.setVendorName(provider.getString("AUTOMATION_PLASTIC_MANUF_VENDOR_NAME"));
		autoPlasticManuf.setCategory(provider.getString("AUTOMATION_PLASTIC_MANUF_CATEGORY"));
		autoPlasticManuf.setBranch(provider.getString("AUTOMATION_PLASTIC_MANUF_BRANCH"));
		autoPlasticManuf.setVendorCode(provider.getString("AUTOMATION_PLASTIC_MANUF_VENDOR_CODE"));
		vendorMasterData.add(autoPlasticManuf);
		
		Vendor autoPersBureau = new Vendor();
		autoPersBureau.setVendorName(provider.getString("AUTOMATION_PERS_BUREAU_VENDOR_NAME"));
		autoPersBureau.setCategory(provider.getString("AUTOMATION_PERS_BUREAU_CATEGORY"));
		autoPersBureau.setBranch(provider.getString("AUTOMATION_PERS_BUREAU_BRANCH"));
		autoPersBureau.setVendorCode(provider.getString("AUTOMATION_PERS_BUREAU_VENDOR_CODE"));
		autoPersBureau.setEmbosingFileTemplate(provider.getString("AUTOMATION_EMBOSING_FILE_TEMPLATE"));
		vendorMasterData.add(autoPersBureau);
		
		Vendor autoDirectSaleAgent = new Vendor();
		autoDirectSaleAgent.setVendorName(provider.getString("AUTOMATION_DIRECT_SALE_AGENT_VENDOR_NAME"));
		autoDirectSaleAgent.setCategory(provider.getString("AUTOMATION_DIRECT_SALE_AGENT_CATEGORY"));
		autoDirectSaleAgent.setBranch(provider.getString("AUTOMATION_DIRECT_SALE_AGENT_BRANCH"));
		autoDirectSaleAgent.setVendorCode(provider.getString("AUTOMATION_DIRECT_SALE_AGENT_VENDOR_CODE"));
		vendorMasterData.add(autoDirectSaleAgent);
		
		Vendor autoZoneCourier = new Vendor();
		autoZoneCourier.setVendorName(provider.getString("AUTOMATION_ZONE_COURIER_VENDOR_NAME"));
		autoZoneCourier.setCategory(provider.getString("AUTOMATION_ZONE_COURIER_CATEGORY"));
		autoZoneCourier.setBranch(provider.getString("AUTOMATION_ZONE_COURIER_BRANCH"));
		autoZoneCourier.setVendorCode(provider.getString("AUTOMATION_ZONE_COURIER_VENDOR_CODE"));
		vendorMasterData.add(autoZoneCourier);
		
		return vendorMasterData;
		
		
	}

	public String getEmbosingFileTemplate() {
		return embosingFileTemplate;
	}

	public void setEmbosingFileTemplate(String embosingFileTemplate) {
		this.embosingFileTemplate = embosingFileTemplate;
	}
}
