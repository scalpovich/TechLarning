package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.FileType;
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
		vendor.vendorDataProvider();
		vendor.setEmbossingFileTemp(embossingFile.getEmbossingFileTemplateName());
		vendor.setVendorCategory(category);
		String EmbossingVendor = "";
		if (template.contains(FileType.EMBOSSING_FILE)) {
			EmbossingVendor = vendorflows.createVendorWithEmbossingTemplate(vendor);
		}
		if (template.contains(FileType.PINOFFSET_FILE)) {
			EmbossingVendor = vendorflows.createVendorWithPINOffsetTemplate(vendor);
		}
		Assert.assertNotNull(EmbossingVendor);
		vendor.setNewVendor(EmbossingVendor);

	}

}