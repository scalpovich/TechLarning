package com.mastercard.pts.integrated.issuing.steps.customer;

import org.hamcrest.CoreMatchers;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.customer.QuickJumpFlows;

@Component
public class QuickJumpSteps {
	
	@Autowired
	QuickJumpFlows quickJumpFlows;
	
	@When("user tries quick jump for page <code>")
	public void quickJumpUsingPageCode(@Named("code") String code) {
		quickJumpFlows.quickJumpToPage(code);
	}
	
	@Then("respective page <name> should be present") 
	public void verifyPageName(@Named("name") String name) {
		String actualText = quickJumpFlows.getPageName();
		Assert.assertThat("Page name text is not matching: " + actualText, actualText, CoreMatchers.containsString(name));
	}
	

}
