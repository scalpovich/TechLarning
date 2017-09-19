package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;

public class DocumentChecklist extends AbstractBasePage {

	public String DocumentName;

	public String getDocumentName() {
		return DocumentName;
	}

	public void setDocumentName(String documentName) {
		DocumentName = documentName;
	}

}
