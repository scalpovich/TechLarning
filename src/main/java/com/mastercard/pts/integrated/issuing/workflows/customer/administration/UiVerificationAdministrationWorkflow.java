package com.mastercard.pts.integrated.issuing.workflows.customer.administration;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.customer.administration.AssignProductPage;
import com.mastercard.pts.integrated.issuing.pages.customer.administration.AssignServiceCodePage;
import com.mastercard.pts.integrated.issuing.pages.customer.administration.AuditConfigurationPage;
import com.mastercard.pts.integrated.issuing.pages.customer.administration.BatchDefinitionPage;
import com.mastercard.pts.integrated.issuing.pages.customer.administration.BatchLevelPage;
import com.mastercard.pts.integrated.issuing.pages.customer.administration.EnableMakerCheckerPage;
import com.mastercard.pts.integrated.issuing.pages.customer.administration.OperationalInquiryPage;
import com.mastercard.pts.integrated.issuing.pages.customer.administration.ReportLevelPage;
import com.mastercard.pts.integrated.issuing.pages.customer.administration.ResetPasswordPage;
import com.mastercard.pts.integrated.issuing.pages.customer.administration.RolePage;
import com.mastercard.pts.integrated.issuing.pages.customer.administration.ScreenLevelPage;
import com.mastercard.pts.integrated.issuing.pages.customer.administration.UserGroupsPage;
import com.mastercard.pts.integrated.issuing.pages.customer.administration.UserManagementReportPage;
import com.mastercard.pts.integrated.issuing.pages.customer.administration.UserPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class UiVerificationAdministrationWorkflow {

	@Autowired
	private Navigator navigator;

	public void traverseAdministrationRolePage() {
		RolePage page = navigator.navigateToPage(RolePage.class);
		page.verifyUiOperationStatus();
	}

	public void traverseAdministrationUserPage() {
		UserPage page = navigator.navigateToPage(UserPage.class);
		page.verifyUiOperationStatus();
	}

	public void traverseAdministrationBatchDefinitionPage() {
		BatchDefinitionPage page = navigator.navigateToPage(BatchDefinitionPage.class);
		page.verifyUiOperationStatus();
	}

	public void traverseAdministrationAuditConfigurationPage() {
		AuditConfigurationPage page = navigator.navigateToPage(AuditConfigurationPage.class);
		page.verifyUiOperationStatus();
	}

	public void traverseAdministrationEnableMakerCheckerPage() {
		EnableMakerCheckerPage page = navigator.navigateToPage(EnableMakerCheckerPage.class);
		page.verifyUiOperationStatus();
	}

	public void traverseAdministrationResetPasswordPage() {
		ResetPasswordPage page = navigator.navigateToPage(ResetPasswordPage.class);
		page.verifyUiOperationStatus();
	}

	public void traverseAdministrationUserGroupsPage() {
		UserGroupsPage page = navigator.navigateToPage(UserGroupsPage.class);
		page.verifyUiOperationStatus();
	}

	public void traverseAdministrationAssignProductPage() {
		AssignProductPage page = navigator.navigateToPage(AssignProductPage.class);
		page.verifyUiOperationStatus();
	}

	public void traverseAdministrationAssignServiceCodePage() {
		AssignServiceCodePage page = navigator.navigateToPage(AssignServiceCodePage.class);
		page.verifyUiOperationStatus();
	}

	public void traverseAdministrationScreenLevelPage() {
		ScreenLevelPage page = navigator.navigateToPage(ScreenLevelPage.class);
		page.verifyUiOperationStatus();
	}

	public void traverseAdministrationReportLevelPage() {
		ReportLevelPage page = navigator.navigateToPage(ReportLevelPage.class);
		page.verifyUiOperationStatus();
	}

	public void traverseAdministrationBatchLevelPage() {
		BatchLevelPage page = navigator.navigateToPage(BatchLevelPage.class);
		page.verifyUiOperationStatus();
	}

	public void traverseAdministrationOperationalInquiryPage() {
		OperationalInquiryPage page = navigator.navigateToPage(OperationalInquiryPage.class);
		page.verifyUiOperationStatus();
	}

	public void traverseAdministrationUserManagementReportPage() {
		UserManagementReportPage page = navigator.navigateToPage(UserManagementReportPage.class);
		page.verifyUiOperationStatus();
	}

}
