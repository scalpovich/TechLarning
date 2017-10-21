package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PictureCode;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.PictureCodeFlows;

@Component
public class PictureCodeSteps {
	@Autowired
	PictureCodeFlows picturecodeflows;

	@Autowired
	PictureCode picturecode;

	@When("user creates Picture Code")
	public void whenUserCreatesPictureCode() {
		String PictureCode = picturecodeflows.addPictureCode();
		picturecode.setPictureCodeNumber(PictureCode);
	}
}