package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;

public class EmbossingFile extends AbstractBasePage {

	public String TemplateType;

	public String EmbossingFileTemplateName;

	public String getTemplateType() {
		return TemplateType;
	}

	public void setTemplateType(String templateType) {
		TemplateType = templateType;
	}

	public String getEmbossingFileTemplateName() {
		return EmbossingFileTemplateName;
	}

	public void setEmbossingFileTemplateName(String embossingFileTemplateName) {
		EmbossingFileTemplateName = embossingFileTemplateName;
	}

}
