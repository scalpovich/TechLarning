package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class EmbossingFile {

	public String embossTemplateType;

	public String embossingFileTemplateName;

	public String embossingTempCode;

	public String embossingTempDescription;

	public String getEmbossTemplateType() {
		return embossTemplateType;
	}

	public void setEmbossTemplateType(String embossTemplateType) {
		this.embossTemplateType = embossTemplateType;
	}

	public String getEmbossingTempCode() {
		return embossingTempCode;
	}

	public void setEmbossingTempCode(String embossingTempCode) {
		this.embossingTempCode = embossingTempCode;
	}

	public String getEmbossingTempDescription() {
		return embossingTempDescription;
	}

	public void setEmbossingTempDescription(String embossingTempDescription) {
		this.embossingTempDescription = embossingTempDescription;
	}

	public String getEmbossingFileTemplateName() {
		return embossingFileTemplateName;
	}

	public void setEmbossingFileTemplateName(String embossingFileTemplateName) {
		this.embossingFileTemplateName = embossingFileTemplateName;
	}

	public void embossingFileDataprovider() {
		// DevicePlan deviceplan = new DevicePlan();
		setEmbossingTempDescription(MapUtils.fnGetInputDataFromMap("EmbossDesc"));
		setEmbossingTempCode(MapUtils.fnGetInputDataFromMap("Embosscode"));
	}
}
