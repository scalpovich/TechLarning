package com.mastercard.pts.integrated.issuing.steps.collect;

import org.jbehave.core.annotations.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.collect.activity.CollectUiVerificationActivityWorkflow;
import com.mastercard.pts.integrated.issuing.workflows.collect.administration.CollectUiVerificationAdministrationWorkflow;
import com.mastercard.pts.integrated.issuing.workflows.collect.businesssetup.CollectUiVerificationBussinessSetupWorkflow;
import com.mastercard.pts.integrated.issuing.workflows.collect.report.CollectUiVerificationReportWorkflow;

@Component
public class CollectUiVerificationSteps {

	@Autowired
	private CollectUiVerificationBussinessSetupWorkflow collectUiVerificationBussinessSetupWorkflow;

	@Autowired
	private CollectUiVerificationActivityWorkflow collectUiVerificationActivityWorkflow;

	@Autowired
	private CollectUiVerificationAdministrationWorkflow collectUiVerificationAdministrationWorkflow;

	@Autowired
	private CollectUiVerificationReportWorkflow collectUiVerificationReportWorkflow;

	@Then("Action page of business setup tab is rendered correctly")
	public void thenActionPageOfBusinessSetupTabIsRenderedCorrectly() {
		collectUiVerificationBussinessSetupWorkflow.verifyActionPage();
	}

	@Then("Allocation page of business setup tab is rendered correctly")
	public void thenAllocationPageOfBusinessSetupTabIsRenderedCorrectly() {
		collectUiVerificationBussinessSetupWorkflow.verifyAllocationPage();
	}

	@Then("BusinessSetupClassification page of business setup tab is rendered correctly")
	public void thenBusinessSetupClassificationPageOfBusinessSetupTabIsRenderedCorrectly() {
		collectUiVerificationBussinessSetupWorkflow.verifyBusinessSetupClassificationPage();
	}

	@Then("BusinessSetupEventAlerts page of business setup tab is rendered correctly")
	public void thenBusinessSetupEventAlertsPageOfBusinessSetupTabIsRenderedCorrectly() {
		collectUiVerificationBussinessSetupWorkflow.verifyBusinessSetupEventAlertsPage();
	}

	@Then("BusinessSetupHome page of business setup tab is rendered correctly")
	public void thenBusinessSetupHomePageOfBusinessSetupTabIsRenderedCorrectly() {
		collectUiVerificationBussinessSetupWorkflow.verifyBusinessSetupHomePage();
	}

	@Then("BusinessSetupSystemCodes page of business setup tab is rendered correctly")
	public void thenBusinessSetupSystemCodesPageOfBusinessSetupTabIsRenderedCorrectly() {
		collectUiVerificationBussinessSetupWorkflow.verifyBusinessSetupSystemCodesPage();
	}

	@Then("Class page of business setup tab is rendered correctly")
	public void thenClassPageOfBusinessSetupTabIsRenderedCorrectly() {
		collectUiVerificationBussinessSetupWorkflow.verifyClassPage();
	}

	@Then("CommissionPlan page of business setup tab is rendered correctly")
	public void thenCommissionPlanPageOfBusinessSetupTabIsRenderedCorrectly() {
		collectUiVerificationBussinessSetupWorkflow.verifyCommissionPlanPage();
	}

	@Then("CommissionPlanRates page of business setup tab is rendered correctly")
	public void thenCommissionPlanRatesPageOfBusinessSetupTabIsRenderedCorrectly() {
		collectUiVerificationBussinessSetupWorkflow.verifyCommissionPlanRatesPage();
	}

	@Then("Creation page of business setup tab is rendered correctly")
	public void thenCreationPageOfBusinessSetupTabIsRenderedCorrectly() {
		collectUiVerificationBussinessSetupWorkflow.verifyCreationPage();
	}

	@Then("Dunning page of business setup tab is rendered correctly")
	public void thenDunningPageOfBusinessSetupTabIsRenderedCorrectly() {
		collectUiVerificationBussinessSetupWorkflow.verifyDunningPage();
	}

	@Then("OutstandingGroup page of business setup tab is rendered correctly")
	public void thenOutstandingGroupPageOfBusinessSetupTabIsRenderedCorrectly() {
		collectUiVerificationBussinessSetupWorkflow.verifyOutstandingGroupPage();
	}

	@Then("Result page of business setup tab is rendered correctly")
	public void thenResultPageOfBusinessSetupTabIsRenderedCorrectly() {
		collectUiVerificationBussinessSetupWorkflow.verifyResultPage();
	}

	@Then("RiskGroup page of business setup tab is rendered correctly")
	public void thenRiskGroupPageOfBusinessSetupTabIsRenderedCorrectly() {
		collectUiVerificationBussinessSetupWorkflow.verifyRiskGroupPage();
	}

	@Then("RulesAllocation page of business setup tab is rendered correctly")
	public void thenRulesAllocationPageOfBusinessSetupTabIsRenderedCorrectly() {
		collectUiVerificationBussinessSetupWorkflow.verifyRulesAllocationPage();
	}

	@Then("WaiverAuthority page of business setup tab is rendered correctly")
	public void thenWaiverAuthorityPageOfBusinessSetupTabIsRenderedCorrectly() {
		collectUiVerificationBussinessSetupWorkflow.verifyWaiverAuthorityPage();
	}

	@Then("ActivityHome page of activity tab is rendered correctly")
	public void thenActivityHomePageOfActivityTabIsRenderedCorrectly() {
		collectUiVerificationActivityWorkflow.verifyActivityHomePage();
	}

	@Then("AllocateManual page of activity tab is rendered correctly")
	public void thenAllocateManualPageOfActivityTabIsRenderedCorrectly() {
		collectUiVerificationActivityWorkflow.verifyAllocateManualPage();
	}

	@Then("AllocateToCollector page of activity tab is rendered correctly")
	public void thenAllocateToCollectorPageOfActivityTabIsRenderedCorrectly() {
		collectUiVerificationActivityWorkflow.verifyAllocateToCollectorPage();
	}

	@Then("BookAllocateDeAllocate page of activity tab is rendered correctly")
	public void thenBookAllocateDeAllocatePageOfActivityTabIsRenderedCorrectly() {
		collectUiVerificationActivityWorkflow.verifyBookAllocateDeAllocatePage();
	}

	@Then("BookConfirmationReturn page of activity tab is rendered correctly")
	public void thenBookConfirmationReturnPageOfActivityTabIsRenderedCorrectly() {
		collectUiVerificationActivityWorkflow.verifyBookConfirmationReturnPage();
	}

	@Then("BookRequestToPrint page of activity tab is rendered correctly")
	public void thenBookRequestToPrintPageOfActivityTabIsRenderedCorrectly() {
		collectUiVerificationActivityWorkflow.verifyBookRequestToPrintPage();
	}

	@Then("CMSTrailsDownload page of activity tab is rendered correctly")
	public void thenCMSTrailsDownloadPageOfActivityTabIsRenderedCorrectly() {
		collectUiVerificationActivityWorkflow.verifyCMSTrailsDownloadPage();
	}

	@Then("ContactRecording page of activity tab is rendered correctly")
	public void thenContactRecordingPageOfActivityTabIsRenderedCorrectly() {
		collectUiVerificationActivityWorkflow.verifyContactRecordingPage();
	}

	@Then("DepositScheduler page of activity tab is rendered correctly")
	public void thenDepositSchedulerPageOfActivityTabIsRenderedCorrectly() {
		collectUiVerificationActivityWorkflow.verifyDepositSchedulerPage();
	}

	@Then("ManualClassification page of activity tab is rendered correctly")
	public void thenManualClassificationPageOfActivityTabIsRenderedCorrectly() {
		collectUiVerificationActivityWorkflow.verifyManualClassificationPage();
	}

	@Then("PIHMaintain page of activity tab is rendered correctly")
	public void thenPIHMaintainPageOfActivityTabIsRenderedCorrectly() {
		collectUiVerificationActivityWorkflow.verifyPIHMaintainPage();
	}

	@Then("ReceiptReconciliation page of activity tab is rendered correctly")
	public void thenReceiptReconciliationPageOfActivityTabIsRenderedCorrectly() {
		collectUiVerificationActivityWorkflow.verifyReceiptReconciliationPage();
	}

	@Then("SettlementApproval page of activity tab is rendered correctly")
	public void thenSettlementApprovalPageOfActivityTabIsRenderedCorrectly() {
		collectUiVerificationActivityWorkflow.verifySettlementApprovalPage();
	}

	@Then("SettlementHistory page of activity tab is rendered correctly")
	public void thenSettlementHistoryPageOfActivityTabIsRenderedCorrectly() {
		collectUiVerificationActivityWorkflow.verifySettlementHistoryPage();
	}

	@Then("WorkList page of activity tab is rendered correctly")
	public void thenWorkListPageOfActivityTabIsRenderedCorrectly() {
		collectUiVerificationActivityWorkflow.verifyWorkListPage();
	}

	@Then("AdministrationHome page of administration tab is rendered correctly")
	public void thenAdministrationHomePageOfAdministratorTabIsRenderedCorrectly() {
		collectUiVerificationAdministrationWorkflow.verifyAdministrationHomePage();
	}

	@Then("AgencyCreation page of administration tab is rendered correctly")
	public void thenAgencyCreationPageOfAdministratorTabIsRenderedCorrectly() {
		collectUiVerificationAdministrationWorkflow.verifyAgencyCreationPage();
	}

	@Then("Audit page of administration tab is rendered correctly")
	public void thenAuditPageOfAdministratorTabIsRenderedCorrectly() {
		collectUiVerificationAdministrationWorkflow.verifyAuditPage();
	}

	@Then("GroupCreation page of administration tab is rendered correctly")
	public void thenGroupCreationPageOfAdministratorTabIsRenderedCorrectly() {
		collectUiVerificationAdministrationWorkflow.verifyGroupCreationPage();
	}

	@Then("ReportPrivileges page of administration tab is rendered correctly")
	public void thenReportPrivilegesPageOfAdministratorTabIsRenderedCorrectly() {
		collectUiVerificationAdministrationWorkflow.verifyReportPrivilegesPage();
	}

	@Then("ResetPassword.java page of administration tab is rendered correctly")
	public void thenResetPasswordPageOfAdministratorTabIsRenderedCorrectly() {
		collectUiVerificationAdministrationWorkflow.verifyResetPasswordPage();
	}

	@Then("ScreenPrivileges page of administration tab is rendered correctly")
	public void thenScreenPrivilegesPageOfAdministratorTabIsRenderedCorrectly() {
		collectUiVerificationAdministrationWorkflow.verifyScreenPrivilegesPage();
	}

	@Then("UserCreation page of administration tab is rendered correctly")
	public void thenUserCreationPageOfAdministratorTabIsRenderedCorrectly() {
		collectUiVerificationAdministrationWorkflow.verifyUserCreationPage();
	}

	@Then("StatCard page of report tab is rendered correctly")
	public void thenStatCardPageOfReportTabIsRenderedCorrectly() {
		collectUiVerificationReportWorkflow.verifyStatCardPage();
	}

	@Then("Reports page of report tab is rendered correctly")
	public void thenReportsPageOfReportTabIsRenderedCorrectly() {
		collectUiVerificationReportWorkflow.verifyReportsPage();
	}

}
