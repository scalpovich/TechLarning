package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class Vendor {

	private String vendorCode;
	private String vendorName;
	private String category;
	private String VendorCategory;
	private String branchCode;
	public String PINFileTemplateName;
	private String embosingFileTemplate;
	public String postalCode;
	public String VendorMobileNo;
	public String newVendorDetails;
	public String NewVendor;

	private String addressLine1;
	private String addressLine2;
	private String country;

	private String contactPerson;
	private String mobileNoType;

	private String mobileNumber;
	private String phoneNumber;
	private String email;

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

	public static List<Vendor> createWithProvider(KeyValueProvider provider) {

		List<Vendor> vendorMasterData = new ArrayList<>();

		Vendor autoBranchCourier = new Vendor();
		autoBranchCourier.setVendorName(provider.getString("AUTOMATION_ BRANCH_COURIER_VENDOR_NAME"));
		autoBranchCourier.setCategory(provider.getString("AUTOMATION_BRANCH_COURIER_CATEGORY"));
		autoBranchCourier.setBranchCode(provider.getString("AUTOMATION_BRANCH_COURIER_BRANCH"));
		autoBranchCourier.setVendorCode(provider.getString("AUTOMATION_BRANCH_COURIER_VENDOR_CODE"));
		vendorMasterData.add(autoBranchCourier);

		Vendor autoRedAgent = new Vendor();
		autoRedAgent.setVendorName(provider.getString("AUTOMATION_RED_AGENT_VENDOR_NAME"));
		autoRedAgent.setCategory(provider.getString("AUTOMATION_RED_AGENT_CATEGORY"));
		autoRedAgent.setBranchCode(provider.getString("AUTOMATION_RED_AGENT_BRANCH"));
		autoRedAgent.setVendorCode(provider.getString("AUTOMATION_RED_AGENT_VENDOR_CODE"));
		vendorMasterData.add(autoRedAgent);

		Vendor autoPlasticManuf = new Vendor();
		autoPlasticManuf.setVendorName(provider.getString("AUTOMATION_PLASTIC_MANUF_VENDOR_NAME"));
		autoPlasticManuf.setCategory(provider.getString("AUTOMATION_PLASTIC_MANUF_CATEGORY"));
		autoPlasticManuf.setBranchCode(provider.getString("AUTOMATION_PLASTIC_MANUF_BRANCH"));
		autoPlasticManuf.setVendorCode(provider.getString("AUTOMATION_PLASTIC_MANUF_VENDOR_CODE"));
		vendorMasterData.add(autoPlasticManuf);

		Vendor autoPersBureau = new Vendor();
		autoPersBureau.setVendorName(provider.getString("AUTOMATION_PERS_BUREAU_VENDOR_NAME"));
		autoPersBureau.setCategory(provider.getString("AUTOMATION_PERS_BUREAU_CATEGORY"));
		autoPersBureau.setBranchCode(provider.getString("AUTOMATION_PERS_BUREAU_BRANCH"));
		autoPersBureau.setVendorCode(provider.getString("AUTOMATION_PERS_BUREAU_VENDOR_CODE"));
		autoPersBureau.setEmbosingFileTemplate(provider.getString("AUTOMATION_EMBOSING_FILE_TEMPLATE"));
		vendorMasterData.add(autoPersBureau);

		Vendor autoDirectSaleAgent = new Vendor();
		autoDirectSaleAgent.setVendorName(provider.getString("AUTOMATION_DIRECT_SALE_AGENT_VENDOR_NAME"));
		autoDirectSaleAgent.setCategory(provider.getString("AUTOMATION_DIRECT_SALE_AGENT_CATEGORY"));
		autoDirectSaleAgent.setBranchCode(provider.getString("AUTOMATION_DIRECT_SALE_AGENT_BRANCH"));
		autoDirectSaleAgent.setVendorCode(provider.getString("AUTOMATION_DIRECT_SALE_AGENT_VENDOR_CODE"));
		vendorMasterData.add(autoDirectSaleAgent);

		Vendor autoZoneCourier = new Vendor();
		autoZoneCourier.setVendorName(provider.getString("AUTOMATION_ZONE_COURIER_VENDOR_NAME"));
		autoZoneCourier.setCategory(provider.getString("AUTOMATION_ZONE_COURIER_CATEGORY"));
		autoZoneCourier.setBranchCode(provider.getString("AUTOMATION_ZONE_COURIER_BRANCH"));
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

	public String getNewVendorDetails() {
		return newVendorDetails;
	}

	public void setNewVendorDetails(String newVendorDetails) {
		this.newVendorDetails = newVendorDetails;
	}

	public String getEmbossingFileTemp() {
		return embosingFileTemplate;
	}

	public void setEmbossingFileTemp(String embossingFileTemp) {
		this.embosingFileTemplate = embossingFileTemp;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPINFileTemplateName() {
		return PINFileTemplateName;
	}

	public void setPINFileTemplateName(String pINFileTemplateName) {
		PINFileTemplateName = pINFileTemplateName;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getVendorMobileNo() {
		return VendorMobileNo;
	}

	public void setVendorMobileNo(String vendorMobileNo) {
		VendorMobileNo = vendorMobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		setVendorCode(MapUtils.fnGetInputDataFromMap("VendorCode"));
		setVendorName(MapUtils.fnGetInputDataFromMap("VendorName"));
		setAddressLine1(MapUtils.fnGetInputDataFromMap("AddressLine1"));
		setAddressLine2(MapUtils.fnGetInputDataFromMap("AddressLine2"));
		setCountry(MapUtils.fnGetInputDataFromMap("country"));
		setBranchCode(MapUtils.fnGetInputDataFromMap("BranchCode"));
		setPINFileTemplateName(MapUtils.fnGetInputDataFromMap("PINFileTempName"));
		setPostalCode(MapUtils.fnGetInputDataFromMap("postalCode"));
		setVendorMobileNo(MapUtils.fnGetInputDataFromMap("vendorMobileNo1"));
		setEmail(MapUtils.fnGetInputDataFromMap("email"));

	}

}
