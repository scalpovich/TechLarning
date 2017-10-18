package com.mastercard.pts.integrated.issuing.steps.agent.channelmanagement;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.PageObjectFactory;
import com.mastercard.pts.integrated.issuing.workflows.agent.channelmanagement.RolesAndPrivilegesWorkflow;


@Component
public class RolesAndPrivilegesSteps {
	private static final String FAILED_MESSAGE_INFO = "Page Load Failed";
	
	@Autowired
	private PageObjectFactory pageFactory;
	
	@Autowired
	private RolesAndPrivilegesWorkflow rolesAndPrivilegesWorkflow;
	
	@When("user navigates to roles and privileges > create role page")
	public void whenUserNavigatesToCreateRolePage(){
		rolesAndPrivilegesWorkflow.navigateToCreateRolePage();
	}
	
	@Then("create role page is loaded and master detail content title is $expectedTitleText")
	public void thenCreateRolePageLoaded(String expectedTitleText){
		assertThat(FAILED_MESSAGE_INFO, rolesAndPrivilegesWorkflow.getCreateRoleMasterDetailContentTitleText(), containsString(expectedTitleText));
	}
	
	@When("user navigates to roles and privileges > assign privileges page")
	public void whenUserNavigatesToAssignPrivilegesPage(){
		rolesAndPrivilegesWorkflow.navigateToAssignPrivilegesPage();
	}
	
	@Then("assign privileges page is loaded and master detail content title is $expectedTitleText")
	public void thenAssignPrivilegesPageLoaded(String expectedTitleText){
		assertThat(FAILED_MESSAGE_INFO, rolesAndPrivilegesWorkflow.getAssignPrivilegesMasterDetailContentTitleText(), containsString(expectedTitleText));
	}
}