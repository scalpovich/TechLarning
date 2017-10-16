package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class ApplicationDocumentChecklist implements HasCodeAndDescription {
	
	private static final String DCD_DOCUMENT_NAME	 = 	"DCD_DOCUMENT_NAME";
	private static final String DCD_DOCS_EXPIRY_DATE_REQUIRED	 = 	"DCD_DOCS_EXPIRY_DATE_REQUIRED";
	private static final String	DCD_DOCS_PLACE_OF_ISSURANCE	 = 	"DCD_DOCS_PLACE_OF_ISSURANCE";
	private static final String DCD_DOCUMENTS_MANDATORY	 = 	"DCD_DOCUMENTS_MANDATORY";
	private static final String DCD_NATIONAL_ID	 = 	"DCD_NATIONAL_ID";

	private String documentChecklistPlanCode;
	private String description;
	private String productType;
	private String documentName;
	private String docsExpiryDateRequired;
	private String docsPlaceOfIssurance;
	private String docMandatory;
	private String nationId;
	
	public String getDocsExpiryDateRequired() {
		return docsExpiryDateRequired;
	}

	public void setDocsExpiryDateRequired(String docsExpiryDateRequired) {
		this.docsExpiryDateRequired = docsExpiryDateRequired;
	}

	public String getDocsPlaceOfIssurance() {
		return docsPlaceOfIssurance;
	}

	public void setDocsPlaceOfIssurance(String docsPlaceOfIssurance) {
		this.docsPlaceOfIssurance = docsPlaceOfIssurance;
	}

	public String getDocMandatory() {
		return docMandatory;
	}

	public void setDocMandatory(String docMandatory) {
		this.docMandatory = docMandatory;
	}

	public String getNationId() {
		return nationId;
	}

	public void setNationId(String nationId) {
		this.nationId = nationId;
	}

	public List<ApplicationDocumentChecklist> getDocumentChecklistDetails() {
		return documentChecklistDetails;
	}

	public void setDocumentChecklistDetails(
			List<ApplicationDocumentChecklist> documentChecklistDetails) {
		this.documentChecklistDetails = documentChecklistDetails;
	}

	private List<ApplicationDocumentChecklist> documentChecklistDetails = new ArrayList<>();

	public static ApplicationDocumentChecklist  generateDynamicTestData() {
		ApplicationDocumentChecklist details = new ApplicationDocumentChecklist();
		details.setDescription(ConstantData.GENERIC_DESCRIPTION);
		details.setDocumentChecklistPlanCode(MiscUtils.generate10CharAlphaNumeric());
		return details;
	}

	public static ApplicationDocumentChecklist createWithProvider(KeyValueProvider provider) {
		ApplicationDocumentChecklist plan = new ApplicationDocumentChecklist();
		plan.setDocumentChecklistPlanCode(MiscUtils.generate10CharAlphaNumeric());
		plan.setDescription(ConstantData.GENERIC_DESCRIPTION);
		plan.setDocumentName(provider.getString(DCD_DOCUMENT_NAME));
		plan.setDocMandatory(provider.getString(DCD_DOCUMENTS_MANDATORY));
		plan.setDocsExpiryDateRequired(provider.getString(DCD_DOCS_EXPIRY_DATE_REQUIRED));
		plan.setDocsPlaceOfIssurance(provider.getString(DCD_DOCS_PLACE_OF_ISSURANCE));
		plan.setNationId(provider.getString(DCD_NATIONAL_ID));
		return plan;
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


