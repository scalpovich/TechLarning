package com.mastercard.pts.integrated.issuing.steps.agent.channelmanagement;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.agent.channelmanagement.ChannelManagementWorkflow;


@Component
public class ChannelManagementSteps {
	private static final String FAILED_MESSAGE_INFO = "Page Load Failed";

	@Autowired
	private ChannelManagementWorkflow channelManagementWorkflow;

	@Autowired
	private KeyValueProvider provider;

	@When("user navigates to administrator > user > active/deactive user page")
	public void whenUserNavigatesToAdministratorUserActiveDeactiveUserPage() {
		channelManagementWorkflow.navigateToAdministratorUserActiveDeactiveUserPage();
	}

	@Then("administrator > user > active/deactive user page is loaded and master detail content title is $expectedTitleText")
	public void thenAdministratorUserActiveDeactiveUserPageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, channelManagementWorkflow.getAdministratorUserActiveDeactiveUserMasterDetailContentTitleText(), containsString(expectedTitleText));
	}

	@When("user navigates to administrator > user > create page")
	public void whenUserNavigatesToAdministratorUserCreatePage() {
		channelManagementWorkflow.navigateToAdministratorUserCreatePage();
	}

	@Then("administrator > user > create page is loaded and master detail content title is $expectedTitleText")
	public void thenAdministratorUserCreatePageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, channelManagementWorkflow.getAdministratorUserCreateMasterDetailContentTitleText(), containsString(expectedTitleText));
	}

	@When("user navigates to administrator > user > reset/user password page")
	public void whenUserNavigatesToAdministratorUserResetUserPasswordPage() {
		channelManagementWorkflow.navigateToAdministratorUserResetUserPasswordPage();
	}

	@Then("administrator > user > reset/user password page is loaded and master detail content title is $expectedTitleText")
	public void thenAdministratorUserResetUserPasswordPageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, channelManagementWorkflow.getAdministratorUserResetUserPasswordDetailContentTitleText(), containsString(expectedTitleText));
	}

	@When("user navigates to administrator > user > view/edit page")
	public void whenUserNavigatesToAdministratorUserViewEditPage() {
		channelManagementWorkflow.navigateToAdministratorUserViewEditPage();
	}

	@Then("administrator > user > view/edit page is loaded and master detail content title is $expectedTitleText")
	public void thenAdministratorUserViewEditPageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, channelManagementWorkflow.getAdministratorUserViewEditDetailContentTitleText(), containsString(expectedTitleText));
	}

	// Agency
	@When("user navigates to agency > entity > active/suspend agency page")
	public void whenUserNavigatesToAgencyEntityActivateSuspendAgencyPage() {
		channelManagementWorkflow.navigateToAgencyEntityActivateSuspendAgencyPage();
	}

	@Then("agency > entity > active/suspend agency page is loaded and master detail content title is $expectedTitleText")
	public void thenAgencyEntityActivateSuspendAgencyPageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, channelManagementWorkflow.getAgencyEntityActivateSuspendAgencyDetailContentTitleText(), containsString(expectedTitleText));
	}

	@When("user navigates to agency > entity > create page")
	public void whenUserNavigatesToAgencyEntityCreatePage() {
		channelManagementWorkflow.navigateToAgencyEntityCreatePage();
	}

	@Then("agency > entity > create page is loaded and master detail content title is $expectedTitleText")
	public void thenAgencyEntityCreatePageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, channelManagementWorkflow.getAgencyEntityCreateDetailContentTitleText(), containsString(expectedTitleText));
	}

	@When("user navigates to agency > entity > view/edit page")
	public void whenUserNavigatesToAgencyEntityViewEditPage() {
		channelManagementWorkflow.navigateToAgencyEntityViewEditPage();
	}

	@Then("agency > entity > view/edit page is loaded and master detail content title is $expectedTitleText")
	public void thenAgencyEntityViewEditPageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, channelManagementWorkflow.getAgencyEntityViewEditDetailContentTitleText(), containsString(expectedTitleText));
	}

	@When("user navigates to agency > user > active/deactive user page")
	public void whenUserNavigatesToAgencyUserActiveDeactiveUserPage() {
		channelManagementWorkflow.navigateToAgencyUserActiveDeactiveUserPage();
	}

	@Then("agency > user > active/deactive user page is loaded and master detail content title is $expectedTitleText")
	public void thenAgencyUserActiveDeactiveUserPageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, channelManagementWorkflow.getAgencyUserActiveDeactiveUserDetailContentTitleText(), containsString(expectedTitleText));
	}

	@When("user navigates to agency > user > create page")
	public void whenUserNavigatesToAgencyUserCreatePage() {
		channelManagementWorkflow.navigateToAgencyUserCreatePage();
	}

	@Then("agency > user > create page is loaded and master detail content title is $expectedTitleText")
	public void thenAgencyUserCreatePageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, channelManagementWorkflow.getAgencyUserCreateDetailContentTitleText(), containsString(expectedTitleText));
	}

	@When("user navigates to agency > user > reset/user password page")
	public void whenUserNavigatesToAgencyUserResetUserPasswordPage() {
		channelManagementWorkflow.navigateToAgencyUserResetUserPasswordPage();
	}

	@Then("agency > user > reset/user password page is loaded and master detail content title is $expectedTitleText")
	public void thenAgencyUserResetUserPasswordPageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, channelManagementWorkflow.getAgencyUserResetUserPasswordDetailContentTitleText(), containsString(expectedTitleText));
	}

	@When("user navigates to agency > user > view/edit page")
	public void whenUserNavigatesToAgencyUserViewEditPage() {
		channelManagementWorkflow.navigateToAgencyUserViewEditPage();
	}

	@Then("agency > user > view/edit page is loaded and master detail content title is $expectedTitleText")
	public void thenAgencyUserViewEditPageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, channelManagementWorkflow.getAgencyUserViewEditDetailContentTitleText(), containsString(expectedTitleText));
	}

	// agent
	@When("user navigates to agent > entity > active/suspend branch page")
	public void whenUserNavigatesToAgentEntityActivateSuspendAgentPage() {
		channelManagementWorkflow.navigateToAgentEntityActiveSuspendAgentPage();
	}

	@Then("agent > entity > active/suspend page is loaded and master detail content title is $expectedTitleText")
	public void thenAgentEntityActivateSuspendAgentPageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, channelManagementWorkflow.getAgentEntityActivateSuspendAgentDetailContentTitleText(), containsString(expectedTitleText));
	}

	@When("user navigates to agent > entity > create page")
	public void whenUserNavigatesToAgentEntityCreatePage() {
		channelManagementWorkflow.navigateToAgentEntityCreatePage();
	}

	@Then("agent > entity > create page is loaded and master detail content title is $expectedTitleText")
	public void thenAgentEntityCreatePageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, channelManagementWorkflow.getAgentEntityCreateDetailContentTitleText(), containsString(expectedTitleText));
	}

	@When("user navigates to agent > entity > view/edit page")
	public void whenUserNavigatesToAgentEntityViewEditPage() {
		channelManagementWorkflow.navigateToAgentEntityViewEditPage();
	}

	@Then("agent > entity > view/edit page is loaded and master detail content title is $expectedTitleText")
	public void thenAgentEntityViewEditPageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, channelManagementWorkflow.getAgentEntityViewEditDetailContentTitleText(), containsString(expectedTitleText));
	}

	@When("user navigates to agent > user > active/deactive user page")
	public void whenUserNavigatesToAgentUserActiveDeactiveUserPage() {
		channelManagementWorkflow.navigateToAgentUserActiveDeactiveUserPage();
	}

	@Then("agent > user > active/deactive user page is loaded and master detail content title is $expectedTitleText")
	public void thenAgentyUserActiveDeactiveUserPageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, channelManagementWorkflow.getAgentUserActiveDeactiveUserDetailContentTitleText(), containsString(expectedTitleText));
	}

	@When("user navigates to agent > user > create page")
	public void whenUserNavigatesToAgentUserCreatePage() {
		channelManagementWorkflow.navigateToAgentUserCreatePage();
	}

	@Then("agent > user > create page is loaded and master detail content title is $expectedTitleText")
	public void thenAgentUserCreatePageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, channelManagementWorkflow.getAgentUserCreateDetailContentTitleText(), containsString(expectedTitleText));
	}

	@When("user navigates to agent > user > reset/user password page")
	public void whenUserNavigatesToAgentUserResetUserPasswordPage() {
		channelManagementWorkflow.navigateToAgentUserResetUserPasswordPage();
	}

	@Then("agent > user > reset/user password page is loaded and master detail content title is $expectedTitleText")
	public void thenAgentUserResetUserPasswordPageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, channelManagementWorkflow.getAgentUserResetUserPasswordDetailContentTitleText(), containsString(expectedTitleText));
	}

	@When("user navigates to agent > user > view/edit page")
	public void whenUserNavigatesToAgentUserViewEditPage() {
		channelManagementWorkflow.navigateToAgentUserViewEditPage();
	}

	@Then("agent > user > view/edit page is loaded and master detail content title is $expectedTitleText")
	public void thenAgentUserViewEditPageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, channelManagementWorkflow.getAgentUserViewEditDetailContentTitleText(), containsString(expectedTitleText));
	}

	// branch
	@When("user navigates to branch > entity > active/suspend branch page")
	public void whenUserNavigatesToBranchEntityActivateSuspendAgentPage() {
		channelManagementWorkflow.navigateToBranchEntityActivateSuspendBranchPage();
	}

	@Then("branch > entity > active/suspend branch page is loaded and master detail content title is $expectedTitleText")
	public void thenBranchEntityActivateSuspendAgentPageLoaded(String expectedTitleText) {
			assertThat(FAILED_MESSAGE_INFO, channelManagementWorkflow.getBranchEntityActivateSuspendBranchDetailContentTitleText(), containsString(expectedTitleText));
	}

	@When("user navigates to branch > entity > create page")
	public void whenUserNavigatesToBranchEntityCreatePage() {
		channelManagementWorkflow.navigateToBranchEntityCreatePage();
	}

	@Then("branch > entity > create page is loaded and master detail content title is $expectedTitleText")
	public void thenBranchEntityCreatePageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, channelManagementWorkflow.getBranchEntityCreateDetailContentTitleText(), containsString(expectedTitleText));
	}

	@When("user navigates to branch > entity > view/edit page")
	public void whenUserNavigatesToBranchEntityViewEditPage() {
		channelManagementWorkflow.navigateToBranchEntityViewEditPage();
	}

	@Then("branch > entity > view/edit page is loaded and master detail content title is $expectedTitleText")
	public void thenBranchEntityViewEditPageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, channelManagementWorkflow.getBranchEntityViewEditDetailContentTitleText(), containsString(expectedTitleText));
	}

	@When("user navigates to branch > user > active/deactive user page")
	public void whenUserNavigatesToBranchUserActiveDeactiveUserPage() {
		channelManagementWorkflow.navigateToBranchUserActiveDeactiveUserPage();
	}

	@Then("branch > user > active/deative user page is loaded and master detail content title is $expectedTitleText")
	public void thenBranchUserActiveDeactiveUserPageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, channelManagementWorkflow.getBranchUserActiveDeactiveUserDetailContentTitleText(), containsString(expectedTitleText));
	}

	@When("user navigates to branch > user > create page")
	public void whenUserNavigatesToBranchUserCreatePage() {
		channelManagementWorkflow.navigateToBranchUserCreatePage();
	}

	@Then("branch > user > create page is loaded and master detail content title is $expectedTitleText")
	public void thenBranchUserCreatePageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, channelManagementWorkflow.getBranchUserCreateDetailContentTitleText(), containsString(expectedTitleText));
	}

	@When("user navigates to branch > user > reset/user password page")
	public void whenUserNavigatesToBranchUserResetUserPasswordPage() {
		channelManagementWorkflow.navigateToBranchUserResetUserPasswordPage();
	}

	@Then("branch > user > reset/user password page is loaded and master detail content title is $expectedTitleText")
	public void thenBranchUserResetUserPasswordPageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, channelManagementWorkflow.getBranchUserResetUserPasswordDetailContentTitleText(), containsString(expectedTitleText));
	}

	@When("user navigates to branch > user > view/Edit page")
	public void whenUserNavigatesToBranchUserViewEditPage() {
		channelManagementWorkflow.navigateToBranchUserViewEditPage();
	}

	@Then("branch > user > view/edit page is loaded and master detail content title is $expectedTitleText")
	public void thenBranchUserViewEditPageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, channelManagementWorkflow.getBranchUserViewEditDetailContentTitleText(), containsString(expectedTitleText));
	}

	// corporate
	@When("user navigates to corporate > user > active/deactive user page")
	public void whenUserNavigatesToCorporateUserActiveDeactiveUserPage() {
		channelManagementWorkflow.navigateToCorporateUserActiveDeactiveUserPage();
	}

	@Then("corporate > user > active/deative user page is loaded and master detail content title is $expectedTitleText")
	public void thenCorporateUserActiveDeactiveUserPageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, channelManagementWorkflow.getCorporateUserActiveDeactiveUserDetailContentTitleText(), containsString(expectedTitleText));
	}

	@When("user navigates to corporate > user > create page")
	public void whenUserNavigatesToCorporateUserCreatePage() {
		channelManagementWorkflow.navigateToCorporateUserCreatePage();
	}

	@Then("corporate > user > create page is loaded and master detail content title is $expectedTitleText")
	public void thenCorporateUserCreatePageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, channelManagementWorkflow.getCorporateUserCreateDetailContentTitleText(), containsString(expectedTitleText));
	}

	@When("user navigates to corporate > user > reset/user password page")
	public void whenUserNavigatesToCorporateUserResetUserPasswordPage() {
		channelManagementWorkflow.navigateToCorporateUserResetUserPasswordPage();
	}

	@Then("corporate > user > reset/user password page is loaded and master detail content title is $expectedTitleText")
	public void thenCorporateUserResetUserPasswordPageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, channelManagementWorkflow.getCorporateUserResetUserPasswordDetailContentTitleText(), containsString(expectedTitleText));
	}

	@When("user navigates to corporate > user > view/edit page")
	public void whenUserNavigatesToCorporateUserViewEditPage() {
		channelManagementWorkflow.navigateToCorporateUserViewEditPage();
	}

	@Then("corporate > user > view/edit page is loaded and master detail content title is $expectedTitleText")
	public void thenCorporateUserViewEditPageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, channelManagementWorkflow.getCorporateUserViewEditDetailContentTitleText(), containsString(expectedTitleText));
	}

	// assign programs
	@When("user navigates to agency > entity > assign programs page")
	public void whenUserNavigatesToAssignProgramsAgencyPage() {
		channelManagementWorkflow.navigateToAssignProgramsAgencyPage();
	}

	@Then("agency > entity > assign programs page is loaded and master detail content title is $expectedTitleText")
	public void thenAssignProgramsAgencyPageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, channelManagementWorkflow.getAssignProgramsAgencyDetailContentTitleText(), containsString(expectedTitleText));
	}

	@When("user navigates to branch > entity > assign programs page")
	public void whenUserNavigatesToAssignProgramsBranchPage() {
		channelManagementWorkflow.navigateToAssignProgramsBranchPage();
	}

	@Then("branch > entity > assign programs page is loaded and master detail content title is $expectedTitleText")
	public void thenAssignProgramsBranchPageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, channelManagementWorkflow.getAssignProgramsBranchDetailContentTitleText(), containsString(expectedTitleText));
	}

	@When("user navigates to agent > entity > assign programs page")
	public void whenUserNavigatesToAssignProgramsAgentPage() {
		channelManagementWorkflow.navigateToAssignProgramsAgentPage();
	}

	@Then("agent > entity > assign programs page is loaded and master detail content title is $expectedTitleText")
	public void thenAssignProgramsAgentPageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, channelManagementWorkflow.getAssignProgramsAgentDetailContentTitleText(), containsString(expectedTitleText));
	}
}