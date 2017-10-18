package com.mastercard.pts.integrated.issuing.steps.agent.channelmanagement;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.PageObjectFactory;
import com.mastercard.pts.integrated.issuing.workflows.agent.channelmanagement.EventAlertsWorkflow;


@Component
public class EventAlertsSteps {
	private static final String FAILED_MESSAGE_INFO = "Page Load Failed";
	
	@Autowired
	private PageObjectFactory pageFactory;
	
	@Autowired
	private EventAlertsWorkflow eventAlertsWorkflow;
	
	@When("user navigates to event alerts page")
	public void whenUserNavigatesToCreateRolePage(){
		eventAlertsWorkflow.navigateToEventAlertsPage();
	}
	
	@Then("event alerts page is loaded and master detail content title is $expectedTitleText")
	public void thenCreateRolePageLoaded(String expectedTitleText){
		assertThat(FAILED_MESSAGE_INFO, eventAlertsWorkflow.getCreateRoleMasterDetailContentTitleText(), containsString(expectedTitleText));
	}

}