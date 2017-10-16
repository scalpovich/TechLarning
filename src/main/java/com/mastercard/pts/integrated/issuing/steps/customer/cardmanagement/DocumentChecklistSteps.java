package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DocumentChecklist;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DocumentChecklistFlows;

@Component
public class DocumentChecklistSteps {

	@Autowired
	DeviceCreation devicecreation;

	@Autowired
	DocumentChecklist documentchecklist;

	@Autowired
	DocumentChecklistFlows docChecklistflows;

	@When("user creates Document checklist for $product for document type $document")
	public void whenUserCreatesDocumentChecklistForPrepaidForDocumentTypeDocument(@Named("product") String product,
			@Named("document") String document) {
		devicecreation.setProduct(product);
		documentchecklist.setDocumentName(document);
		docChecklistflows.CreateDocumentChecklist(devicecreation);

	}
}