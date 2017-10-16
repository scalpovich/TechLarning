package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

@Component
public class DocumentChecklist {

	public String DocumentName;

	public String getDocumentName() {
		return DocumentName;
	}

	public void setDocumentName(String documentName) {
		DocumentName = documentName;
	}

}
