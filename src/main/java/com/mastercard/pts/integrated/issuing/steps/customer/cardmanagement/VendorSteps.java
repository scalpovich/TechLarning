package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.EmbossingFile;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Vendor;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.VendorFlows;

@Component
public class VendorSteps {

	@Autowired
	VendorFlows vendorflows;

	@Autowired
	EmbossingFile embossingFile;

	@Autowired
	Vendor vendor;

	@When("user creates a Vendor of Category $category with $template template attached")
	public void whenUserCreatesAVendorOfCategoryEmbossingTemplate(@Named("category") String category,
			@Named("template") String template) {
		String VendorName = "";
		vendor.vendorDataProvider();
		vendor.setEmbossingFileTemp(embossingFile.getEmbossingFileTemplateName());
		vendor.setVendorCategory(category);
		if (template.contains("Embossing")) {
			VendorName = vendorflows.createVendorWithEmbossingTemplate(vendor);
		}
		if (template.contains("PINOffset")) {
			VendorName = vendorflows.createVendorWithPINOffsetTemplate(vendor);
		}
		vendor.setNewVendor(VendorName);
	}

}