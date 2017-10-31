package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.EmbossingFile;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.EmbossingFileFlows;

@Component
public class EmbossingFileSteps {

	@Autowired
	EmbossingFile embossingfile;

	@Autowired
	EmbossingFileFlows embossingtemplateflows;

	@When("user creates an $file Template")
	public void whenUserCreatesAnEmbossingFileTemplate(@Named("file") String file) {
		embossingfile.setTemplateType(file);
		String EmbossingTemplate = "";
		EmbossingTemplate = embossingtemplateflows.createEmbossingTemplate(embossingfile);
		Assert.assertNotNull(EmbossingTemplate);
		embossingfile.setEmbossingFileTemplateName(EmbossingTemplate);
	}
}