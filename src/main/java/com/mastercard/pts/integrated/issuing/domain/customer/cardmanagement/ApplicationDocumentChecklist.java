package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class ApplicationDocumentChecklist implements HasCodeAndDescription {

	private String documentChecklistPlanCode;
	private String description;
	private String productType;
	private String documentName;

	private List<ApplicationDocumentChecklist> documentChecklistDetails = new ArrayList<>();

	public static ApplicationDocumentChecklist  generateDynamicTestData() {
		ApplicationDocumentChecklist details = new ApplicationDocumentChecklist();
		details.setDescription(ConstantData.GENERIC_DESCRIPTION);
		details.setDocumentChecklistPlanCode(MiscUtils.generate10CharAlphaNumeric());
		return details;
	}

	public List<ApplicationDocumentChecklist> getStatementMessageDetails() {
		return documentChecklistDetails;
	}

	public String getDocumentChecklistPlanCode() {
		return documentChecklistPlanCode;
	}
	
	public void setDocumentChecklistPlanCode(String documentChecklistPlanCode) {
		this.documentChecklistPlanCode = documentChecklistPlanCode;
	}
	
	@Override
	public String getCode() {
		return getDocumentChecklistPlanCode();
	}
	
	@Override
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getProductType() {
		return productType;
	}
	
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	public String getDocumentName() {
		return documentName;
	}
	
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}	

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}


