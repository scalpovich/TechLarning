package com.mastercard.pts.integrated.issuing.workflows.agent.channelmanagement;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.*;

import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class AgentUiVerificationChannelManagementWorkflow {
	@Autowired
	private Navigator navigator;

	public void verifyAdministratorUserActiveDeactiveUserPage() {
		AdministratorUserActiveDeactiveUserPage page = navigator.navigateToPage(AdministratorUserActiveDeactiveUserPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyAdministratorUserCreatePage() {
		AdministratorUserCreatePage page = navigator.navigateToPage(AdministratorUserCreatePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyAdministratorUserResetUserPasswordPage() {
		AdministratorUserResetUserPasswordPage page = navigator.navigateToPage(AdministratorUserResetUserPasswordPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyAdministratorUserViewEditPage() {
		AdministratorUserViewEditPage page = navigator.navigateToPage(AdministratorUserViewEditPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyAgencyEntityActivateSuspendAgencyPage() {
		AgencyEntityActivateSuspendAgencyPage page = navigator.navigateToPage(AgencyEntityActivateSuspendAgencyPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyAgencyEntityCreatePage() {
		AgencyEntityCreatePage page = navigator.navigateToPage(AgencyEntityCreatePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyAgencyEntityViewEditPage() {
		AgencyEntityViewEditPage page = navigator.navigateToPage(AgencyEntityViewEditPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyAgencyUserActiveDeactiveUserPage() {
		AgencyUserActiveDeactiveUserPage page = navigator.navigateToPage(AgencyUserActiveDeactiveUserPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyAgencyUserCreatePage() {
		AgencyUserCreatePage page = navigator.navigateToPage(AgencyUserCreatePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyAgencyUserResetUserPasswordPage() {
		AgencyUserResetUserPasswordPage page = navigator.navigateToPage(AgencyUserResetUserPasswordPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyAgencyUserViewEditPage() {
		AgencyUserViewEditPage page = navigator.navigateToPage(AgencyUserViewEditPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyAgentEntityActiveSuspendAgentPage() {
		AgentEntityActiveSuspendAgentPage page = navigator.navigateToPage(AgentEntityActiveSuspendAgentPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyAgentEntityCreatePage() {
		AgentEntityCreatePage page = navigator.navigateToPage(AgentEntityCreatePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyAgentEntityViewEditPage() {
		AgentEntityViewEditPage page = navigator.navigateToPage(AgentEntityViewEditPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyAgentUserActiveDeactiveUserPage() {
		AgentUserActiveDeactiveUserPage page = navigator.navigateToPage(AgentUserActiveDeactiveUserPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyAgentUserCreatePage() {
		AgentUserCreatePage page = navigator.navigateToPage(AgentUserCreatePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyAgentUserResetUserPasswordPage() {
		AgentUserResetUserPasswordPage page = navigator.navigateToPage(AgentUserResetUserPasswordPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyAgentUserViewEditPage() {
		AgentUserViewEditPage page = navigator.navigateToPage(AgentUserViewEditPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyAssignPrivilegesPage() {
		AssignPrivilegesPage page = navigator.navigateToPage(AssignPrivilegesPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyAssignProgramsAgencyPage() {
		AssignProgramsAgencyPage page = navigator.navigateToPage(AssignProgramsAgencyPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyAssignProgramsAgentPage() {
		AssignProgramsAgentPage page = navigator.navigateToPage(AssignProgramsAgentPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyAssignProgramsBranchPage() {
		AssignProgramsBranchPage page = navigator.navigateToPage(AssignProgramsBranchPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyBranchEntityActivateSuspendBranchPage() {
		BranchEntityActivateSuspendBranchPage page = navigator.navigateToPage(BranchEntityActivateSuspendBranchPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyBranchEntityCreatePage() {
		BranchEntityCreatePage page = navigator.navigateToPage(BranchEntityCreatePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyBranchEntityViewEditPage() {
		BranchEntityViewEditPage page = navigator.navigateToPage(BranchEntityViewEditPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyBranchUserActiveDeactiveUserPage() {
		BranchUserActiveDeactiveUserPage page = navigator.navigateToPage(BranchUserActiveDeactiveUserPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyBranchUserCreatePage() {
		BranchUserCreatePage page = navigator.navigateToPage(BranchUserCreatePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyBranchUserResetUserPasswordPage() {
		BranchUserResetUserPasswordPage page = navigator.navigateToPage(BranchUserResetUserPasswordPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyBranchUserViewEditPage() {
		BranchUserViewEditPage page = navigator.navigateToPage(BranchUserViewEditPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyCorporateUserActiveDeactiveUserPage() {
		CorporateUserActiveDeactiveUserPage page = navigator.navigateToPage(CorporateUserActiveDeactiveUserPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyCorporateUserCreatePage() {
		CorporateUserCreatePage page = navigator.navigateToPage(CorporateUserCreatePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyCorporateUserResetUserPasswordPage() {
		CorporateUserResetUserPasswordPage page = navigator.navigateToPage(CorporateUserResetUserPasswordPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyCorporateUserViewEditPage() {
		CorporateUserViewEditPage page = navigator.navigateToPage(CorporateUserViewEditPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyCreateRolePage() {
		CreateRolePage page = navigator.navigateToPage(CreateRolePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyEventAlertsPage() {
		EventAlertsPage page = navigator.navigateToPage(EventAlertsPage.class);
		page.verifyUiOperationStatus();
	}

}