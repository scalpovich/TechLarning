package com.mastercard.pts.integrated.issuing.steps.agent.profile;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.PageObjectFactory;
import com.mastercard.pts.integrated.issuing.workflows.agent.profile.ProfileWorkflow;


@Component
public class ProfileSteps {
	private static final String FAILED_MESSAGE_INFO = "Page Load Failed";
	
	@Autowired
	private PageObjectFactory pageFactory;
	
	@Autowired
	private ProfileWorkflow profileWorkflow;
	
	@When("user navigates to view profile page")
	public void whenUserNavigatesToViewProfilePage(){
		profileWorkflow.navigateToViewProfilePage();
	}
	
	@Then("view profile page is loaded and master detail content title is $expectedTitleText")
	public void thenViewProfilePageLoaded(String expectedTitleText){
		assertThat(FAILED_MESSAGE_INFO, profileWorkflow.getViewProfileMasterDetailContentTitleText(), containsString(expectedTitleText));
	}
	
	@When("user navigates to entity details page")
	public void whenUserNavigatesToEntityDetailsPage(){
		profileWorkflow.navigateToEntityDetailsPage();
	}
	
	@Then("entity detials page is loaded and master detail content title is $expectedTitleText")
	public void thenEntityDetailsPageLoaded(String expectedTitleText){
		assertThat(FAILED_MESSAGE_INFO, profileWorkflow.getEntityDetailsMasterDetailContentTitleText(), containsString(expectedTitleText));
	}
	
	@When("user navigates to change password page")
	public void whenUserNavigatesToChangePasswordPage(){
		profileWorkflow.navigateToChangePasswordPage();
	}
	
	@Then("change password page is loaded and master detail content title is $expectedTitleText")
	public void thenChangePasswordPageLoaded(String expectedTitleText){
		assertThat(FAILED_MESSAGE_INFO, profileWorkflow.getChangePasswordMasterDetailContentTitleText(), containsString(expectedTitleText));
	}
}
