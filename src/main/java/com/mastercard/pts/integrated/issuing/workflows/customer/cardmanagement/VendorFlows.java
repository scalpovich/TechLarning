package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Vendor;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.VendorPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class VendorFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	public String newVendor;

	public String createVendor(Vendor vendor) {
		VendorPage vendorpage = navigator.navigateToPage(VendorPage.class);
		vendorpage.clickaddVenor();
		newVendor = vendorpage.addVendorDetails(vendor);
		vendorpage.vendorWithAllCapablity(vendor);
		vendorpage.addressDetails(vendor);
		vendorpage.contactDetails(vendor);
		vendorpage.Save();
		waitForPageToLoad(getFinder().getWebDriver());
		vendorpage.verifyNewVendorSuccess();
		return newVendor;
	}

	public String createVendorWithEmbossingTemplate(Vendor vendor) {
		VendorPage vendorpage = navigator.navigateToPage(VendorPage.class);
		vendorpage.clickaddVenor();
		newVendor = vendorpage.addVendorDetails(vendor);
		vendorpage.vendorWithEmbossingTemplateFileName(vendor);
		vendorpage.addressDetails(vendor);
		vendorpage.contactDetails(vendor);
		vendorpage.Save();
		waitForWicket(driver());
		vendorpage.verifyNewVendorSuccess();
		return newVendor;
	}

	public String createVendorWithPINOffsetTemplate(Vendor vendor) {
		VendorPage vendorpage = navigator.navigateToPage(VendorPage.class);
		vendorpage.clickaddVenor();
		newVendor = vendorpage.addVendorDetails(vendor);
		vendorpage.VendorWithPINOffsetTemplate(vendor);
		vendorpage.addressDetails(vendor);
		vendorpage.contactDetails(vendor);
		vendorpage.Save();
		vendorpage.verifyNewVendorSuccess();
		return newVendor;
	}
	
	public String createVendorWithEmbossingTemplateFileUpload(Vendor vendor) {
		VendorPage vendorpage = navigator.navigateToPage(VendorPage.class);
		vendorpage.clickaddVenor();
		newVendor = vendorpage.addVendorDetails(vendor);
		vendorpage.vendorWithEmbossingTemplateFileName(vendor);
		vendorpage.selectDeviceProductionCheckBox();
		vendorpage.selectEmbossingFileTemplate();
		//vendorpage.selectPinProductionCheckBox();
		//vendorpage.selectPinFileTemplate();
		vendorpage.addressDetails(vendor);
		vendorpage.contactDetails(vendor);
		vendorpage.Save();
		waitForWicket(driver());
		vendorpage.verifyNewVendorSuccess();
		return newVendor;
	}

}
