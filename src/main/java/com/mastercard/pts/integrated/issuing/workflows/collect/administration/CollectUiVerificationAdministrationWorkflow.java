package com.mastercard.pts.integrated.issuing.workflows.collect.administration;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.collect.administration.AdministrationHomePage;
import com.mastercard.pts.integrated.issuing.pages.collect.administration.AgencyCreationPage;
import com.mastercard.pts.integrated.issuing.pages.collect.administration.AuditPage;
import com.mastercard.pts.integrated.issuing.pages.collect.administration.GroupCreationPage;
import com.mastercard.pts.integrated.issuing.pages.collect.administration.ReportPrivilegesPage;
import com.mastercard.pts.integrated.issuing.pages.collect.administration.AdministrationResetPasswordPage;
import com.mastercard.pts.integrated.issuing.pages.collect.administration.ScreenPrivilegesPage;
import com.mastercard.pts.integrated.issuing.pages.collect.administration.UserCreationPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class CollectUiVerificationAdministrationWorkflow {
	@Autowired
	private Navigator navigator;
	
	public void verifyAdministrationHomePage() {
		  AdministrationHomePage page = navigator.navigateToPage(AdministrationHomePage.class);
		  page.verifyUiOperationStatus();
		}

		public void verifyAgencyCreationPage() {
		  AgencyCreationPage page = navigator.navigateToPage(AgencyCreationPage.class);
		  page.verifyUiOperationStatus();
		}

		public void verifyAuditPage() {
		  AuditPage page = navigator.navigateToPage(AuditPage.class);
		  page.verifyUiOperationStatus();
		}

		public void verifyGroupCreationPage() {
		  GroupCreationPage page = navigator.navigateToPage(GroupCreationPage.class);
		  page.verifyUiOperationStatus();
		}

		public void verifyReportPrivilegesPage() {
		  ReportPrivilegesPage page = navigator.navigateToPage(ReportPrivilegesPage.class);
		  page.verifyUiOperationStatus();
		}

		public void verifyResetPasswordPage() {
		  AdministrationResetPasswordPage page = navigator.navigateToPage(AdministrationResetPasswordPage.class);
		  page.verifyUiOperationStatus();
		}

		public void verifyScreenPrivilegesPage() {
		  ScreenPrivilegesPage page = navigator.navigateToPage(ScreenPrivilegesPage.class);
		  page.verifyUiOperationStatus();
		}

		public void verifyUserCreationPage() {
		  UserCreationPage page = navigator.navigateToPage(UserCreationPage.class);
		  page.verifyUiOperationStatus();
		}


	
}
