package com.mastercard.pts.integrated.issuing.steps;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.InstitutionSelectionPage;

@Component
public class InstitutionSelectionSteps extends AbstractBasePage {
	
	@Autowired
	InstitutionSelectionPage institut;

	@When("select $institute as institute")
	public void selectInstitute(String institute){
		institut.selectInstitution(institute);
	}
}
