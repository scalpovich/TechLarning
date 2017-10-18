package com.mastercard.pts.integrated.issuing.steps.agent;

import org.jbehave.core.annotations.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.agent.channelmanagement.AgentUiVerificationChannelManagementWorkflow;
import com.mastercard.pts.integrated.issuing.workflows.agent.inventory.AgentUiVerificationInventoryWorkflow;
import com.mastercard.pts.integrated.issuing.workflows.agent.profile.AgentUiVerificationProfileWorkflow;
import com.mastercard.pts.integrated.issuing.workflows.agent.services.AgentUiVerificationServicesWorkflow;
import com.mastercard.pts.integrated.issuing.workflows.agent.settlement.AgentUiVerificationSettlementWorkflow;
import com.mastercard.pts.integrated.issuing.workflows.agent.transactions.AgentUiVerificationTransactionsWorkflow;

@Component
public class AgentUiVerificationSteps {

	@Autowired
	private AgentUiVerificationChannelManagementWorkflow agentUiVerificationChannelManagementWorkflow;

	@Autowired
	private AgentUiVerificationProfileWorkflow agentUiVerificationProfileWorkflow;

	@Autowired
	private AgentUiVerificationInventoryWorkflow agentUiVerificationInventoryWorkflow;

	@Autowired
	private AgentUiVerificationServicesWorkflow agentUiVerificationServicesWorkflow;

	@Autowired
	private AgentUiVerificationSettlementWorkflow agentUiVerificationSettlementWorkflow;

	@Autowired
	private AgentUiVerificationTransactionsWorkflow agentUiVerificationTransactionsWorkflow;

	@Then("AdministratorUserActiveDeactiveUser page of channelmanagement tab is rendered correctly")
	public void thenAdministratorUserActiveDeactiveUserPageOfChannelManagementTabIsRenderedCorrectly() {
		agentUiVerificationChannelManagementWorkflow.verifyAdministratorUserActiveDeactiveUserPage();
	}

	@Then("AdministratorUserCreate page of channelmanagement tab is rendered correctly")
	public void thenAdministratorUserCreatePageOfChannelManagementTabIsRenderedCorrectly() {
		agentUiVerificationChannelManagementWorkflow.verifyAdministratorUserCreatePage();
	}

	@Then("AdministratorUserResetUserPassword page of channelmanagement tab is rendered correctly")
	public void thenAdministratorUserResetUserPasswordPageOfChannelManagementTabIsRenderedCorrectly() {
		agentUiVerificationChannelManagementWorkflow.verifyAdministratorUserResetUserPasswordPage();
	}

	@Then("AdministratorUserViewEdit page of channelmanagement tab is rendered correctly")
	public void thenAdministratorUserViewEditPageOfChannelManagementTabIsRenderedCorrectly() {
		agentUiVerificationChannelManagementWorkflow.verifyAdministratorUserViewEditPage();
	}

	@Then("AgencyEntityActivateSuspendAgency page of channelmanagement tab is rendered correctly")
	public void thenAgencyEntityActivateSuspendAgencyPageOfChannelManagementTabIsRenderedCorrectly() {
		agentUiVerificationChannelManagementWorkflow.verifyAgencyEntityActivateSuspendAgencyPage();
	}

	@Then("AgencyEntityCreate page of channelmanagement tab is rendered correctly")
	public void thenAgencyEntityCreatePageOfChannelManagementTabIsRenderedCorrectly() {
		agentUiVerificationChannelManagementWorkflow.verifyAgencyEntityCreatePage();
	}

	@Then("AgencyEntityViewEdit page of channelmanagement tab is rendered correctly")
	public void thenAgencyEntityViewEditPageOfChannelManagementTabIsRenderedCorrectly() {
		agentUiVerificationChannelManagementWorkflow.verifyAgencyEntityViewEditPage();
	}

	@Then("AgencyUserActiveDeactiveUser page of channelmanagement tab is rendered correctly")
	public void thenAgencyUserActiveDeactiveUserPageOfChannelManagementTabIsRenderedCorrectly() {
		agentUiVerificationChannelManagementWorkflow.verifyAgencyUserActiveDeactiveUserPage();
	}

	@Then("AgencyUserCreate page of channelmanagement tab is rendered correctly")
	public void thenAgencyUserCreatePageOfChannelManagementTabIsRenderedCorrectly() {
		agentUiVerificationChannelManagementWorkflow.verifyAgencyUserCreatePage();
	}

	@Then("AgencyUserResetUserPassword page of channelmanagement tab is rendered correctly")
	public void thenAgencyUserResetUserPasswordPageOfChannelManagementTabIsRenderedCorrectly() {
		agentUiVerificationChannelManagementWorkflow.verifyAgencyUserResetUserPasswordPage();
	}

	@Then("AgencyUserViewEdit page of channelmanagement tab is rendered correctly")
	public void thenAgencyUserViewEditPageOfChannelManagementTabIsRenderedCorrectly() {
		agentUiVerificationChannelManagementWorkflow.verifyAgencyUserViewEditPage();
	}

	@Then("AgentEntityActiveSuspendAgent page of channelmanagement tab is rendered correctly")
	public void thenAgentEntityActiveSuspendAgentPageOfChannelManagementTabIsRenderedCorrectly() {
		agentUiVerificationChannelManagementWorkflow.verifyAgentEntityActiveSuspendAgentPage();
	}

	@Then("AgentEntityCreate page of channelmanagement tab is rendered correctly")
	public void thenAgentEntityCreatePageOfChannelManagementTabIsRenderedCorrectly() {
		agentUiVerificationChannelManagementWorkflow.verifyAgentEntityCreatePage();
	}

	@Then("AgentEntityViewEdit page of channelmanagement tab is rendered correctly")
	public void thenAgentEntityViewEditPageOfChannelManagementTabIsRenderedCorrectly() {
		agentUiVerificationChannelManagementWorkflow.verifyAgentEntityViewEditPage();
	}

	@Then("AgentUserActiveDeactiveUser page of channelmanagement tab is rendered correctly")
	public void thenAgentUserActiveDeactiveUserPageOfChannelManagementTabIsRenderedCorrectly() {
		agentUiVerificationChannelManagementWorkflow.verifyAgentUserActiveDeactiveUserPage();
	}

	@Then("AgentUserCreate page of channelmanagement tab is rendered correctly")
	public void thenAgentUserCreatePageOfChannelManagementTabIsRenderedCorrectly() {
		agentUiVerificationChannelManagementWorkflow.verifyAgentUserCreatePage();
	}

	@Then("AgentUserResetUserPassword page of channelmanagement tab is rendered correctly")
	public void thenAgentUserResetUserPasswordPageOfChannelManagementTabIsRenderedCorrectly() {
		agentUiVerificationChannelManagementWorkflow.verifyAgentUserResetUserPasswordPage();
	}

	@Then("AgentUserViewEdit page of channelmanagement tab is rendered correctly")
	public void thenAgentUserViewEditPageOfChannelManagementTabIsRenderedCorrectly() {
		agentUiVerificationChannelManagementWorkflow.verifyAgentUserViewEditPage();
	}

	@Then("AssignPrivileges page of channelmanagement tab is rendered correctly")
	public void thenAssignPrivilegesPageOfChannelManagementTabIsRenderedCorrectly() {
		agentUiVerificationChannelManagementWorkflow.verifyAssignPrivilegesPage();
	}

	@Then("AssignProgramsAgency page of channelmanagement tab is rendered correctly")
	public void thenAssignProgramsAgencyPageOfChannelManagementTabIsRenderedCorrectly() {
		agentUiVerificationChannelManagementWorkflow.verifyAssignProgramsAgencyPage();
	}

	@Then("AssignProgramsAgent page of channelmanagement tab is rendered correctly")
	public void thenAssignProgramsAgentPageOfChannelManagementTabIsRenderedCorrectly() {
		agentUiVerificationChannelManagementWorkflow.verifyAssignProgramsAgentPage();
	}

	@Then("AssignProgramsBranch page of channelmanagement tab is rendered correctly")
	public void thenAssignProgramsBranchPageOfChannelManagementTabIsRenderedCorrectly() {
		agentUiVerificationChannelManagementWorkflow.verifyAssignProgramsBranchPage();
	}

	@Then("BranchEntityActivateSuspendBranch page of channelmanagement tab is rendered correctly")
	public void thenBranchEntityActivateSuspendBranchPageOfChannelManagementTabIsRenderedCorrectly() {
		agentUiVerificationChannelManagementWorkflow.verifyBranchEntityActivateSuspendBranchPage();
	}

	@Then("BranchEntityCreate page of channelmanagement tab is rendered correctly")
	public void thenBranchEntityCreatePageOfChannelManagementTabIsRenderedCorrectly() {
		agentUiVerificationChannelManagementWorkflow.verifyBranchEntityCreatePage();
	}

	@Then("BranchEntityViewEdit page of channelmanagement tab is rendered correctly")
	public void thenBranchEntityViewEditPageOfChannelManagementTabIsRenderedCorrectly() {
		agentUiVerificationChannelManagementWorkflow.verifyBranchEntityViewEditPage();
	}

	@Then("BranchUserActiveDeactiveUser page of channelmanagement tab is rendered correctly")
	public void thenBranchUserActiveDeactiveUserPageOfChannelManagementTabIsRenderedCorrectly() {
		agentUiVerificationChannelManagementWorkflow.verifyBranchUserActiveDeactiveUserPage();
	}

	@Then("BranchUserCreate page of channelmanagement tab is rendered correctly")
	public void thenBranchUserCreatePageOfChannelManagementTabIsRenderedCorrectly() {
		agentUiVerificationChannelManagementWorkflow.verifyBranchUserCreatePage();
	}

	@Then("BranchUserResetUserPassword page of channelmanagement tab is rendered correctly")
	public void thenBranchUserResetUserPasswordPageOfChannelManagementTabIsRenderedCorrectly() {
		agentUiVerificationChannelManagementWorkflow.verifyBranchUserResetUserPasswordPage();
	}

	@Then("BranchUserViewEdit page of channelmanagement tab is rendered correctly")
	public void thenBranchUserViewEditPageOfChannelManagementTabIsRenderedCorrectly() {
		agentUiVerificationChannelManagementWorkflow.verifyBranchUserViewEditPage();
	}

	@Then("CorporateUserActiveDeactiveUser page of channelmanagement tab is rendered correctly")
	public void thenCorporateUserActiveDeactiveUserPageOfChannelManagementTabIsRenderedCorrectly() {
		agentUiVerificationChannelManagementWorkflow.verifyCorporateUserActiveDeactiveUserPage();
	}

	@Then("CorporateUserCreate page of channelmanagement tab is rendered correctly")
	public void thenCorporateUserCreatePageOfChannelManagementTabIsRenderedCorrectly() {
		agentUiVerificationChannelManagementWorkflow.verifyCorporateUserCreatePage();
	}

	@Then("CorporateUserResetUserPassword page of channelmanagement tab is rendered correctly")
	public void thenCorporateUserResetUserPasswordPageOfChannelManagementTabIsRenderedCorrectly() {
		agentUiVerificationChannelManagementWorkflow.verifyCorporateUserResetUserPasswordPage();
	}

	@Then("CorporateUserViewEdit page of channelmanagement tab is rendered correctly")
	public void thenCorporateUserViewEditPageOfChannelManagementTabIsRenderedCorrectly() {
		agentUiVerificationChannelManagementWorkflow.verifyCorporateUserViewEditPage();
	}

	@Then("CreateRole page of channelmanagement tab is rendered correctly")
	public void thenCreateRolePageOfChannelManagementTabIsRenderedCorrectly() {
		agentUiVerificationChannelManagementWorkflow.verifyCreateRolePage();
	}

	@Then("EventAlerts page of channelmanagement tab is rendered correctly")
	public void thenEventAlertsPageOfChannelManagementTabIsRenderedCorrectly() {
		agentUiVerificationChannelManagementWorkflow.verifyEventAlertsPage();
	}

	@Then("Acceptance page of inventory tab is rendered correctly")
	public void thenAcceptancePageOfInventoryTabIsRenderedCorrectly() {
		agentUiVerificationInventoryWorkflow.verifyAcceptancePage();
	}

	@Then("InventoryStatus page of inventory tab is rendered correctly")
	public void thenInventoryStatusPageOfInventoryTabIsRenderedCorrectly() {
		agentUiVerificationInventoryWorkflow.verifyInventoryStatusPage();
	}

	@Then("OrderCancellation page of inventory tab is rendered correctly")
	public void thenOrderCancellationPageOfInventoryTabIsRenderedCorrectly() {
		agentUiVerificationInventoryWorkflow.verifyOrderCancellationPage();
	}

	@Then("Order page of inventory tab is rendered correctly")
	public void thenOrderPageOfInventoryTabIsRenderedCorrectly() {
		agentUiVerificationInventoryWorkflow.verifyOrderPage();
	}

	@Then("Status page of inventory tab is rendered correctly")
	public void thenStatusPageOfInventoryTabIsRenderedCorrectly() {
		agentUiVerificationInventoryWorkflow.verifyStatusPage();
	}

	@Then("StockReturn page of inventory tab is rendered correctly")
	public void thenStockReturnPageOfInventoryTabIsRenderedCorrectly() {
		agentUiVerificationInventoryWorkflow.verifyStockReturnPage();
	}

	@Then("StockTransferAcceptance page of inventory tab is rendered correctly")
	public void thenStockTransferAcceptancePageOfInventoryTabIsRenderedCorrectly() {
		agentUiVerificationInventoryWorkflow.verifyStockTransferAcceptancePage();
	}

	@Then("StockTransferIntraBranch page of inventory tab is rendered correctly")
	public void thenStockTransferIntraBranchPageOfInventoryTabIsRenderedCorrectly() {
		agentUiVerificationInventoryWorkflow.verifyStockTransferIntraBranchPage();
	}

	@Then("ChangePassword page of profile tab is rendered correctly")
	public void thenChangePasswordPageOfProfileTabIsRenderedCorrectly() {
		agentUiVerificationProfileWorkflow.verifyChangePasswordPage();
	}

	@Then("EntityDetails page of profile tab is rendered correctly")
	public void thenEntityDetailsPageOfProfileTabIsRenderedCorrectly() {
		agentUiVerificationProfileWorkflow.verifyEntityDetailsPage();
	}

	@Then("ViewProfile page of profile tab is rendered correctly")
	public void thenViewProfilePageOfProfileTabIsRenderedCorrectly() {
		agentUiVerificationProfileWorkflow.verifyViewProfilePage();
	}

	@Then("ActivateDeactivateSubAccount page of services tab is rendered correctly")
	public void thenActivateDeactivateSubAccountPageOfServicesTabIsRenderedCorrectly() {
		agentUiVerificationServicesWorkflow.verifyActivateDeactivateSubAccountPage();
	}

	@Then("ApplicationCorrection page of services tab is rendered correctly")
	public void thenApplicationCorrectionPageOfServicesTabIsRenderedCorrectly() {
		agentUiVerificationServicesWorkflow.verifyApplicationCorrectionPage();
	}

	@Then("ChangeCurrencyPriority page of services tab is rendered correctly")
	public void thenChangeCurrencyPriorityPageOfServicesTabIsRenderedCorrectly() {
		agentUiVerificationServicesWorkflow.verifyChangeCurrencyPriorityPage();
	}

	@Then("Checker page of services tab is rendered correctly")
	public void thenCheckerPageOfServicesTabIsRenderedCorrectly() {
		agentUiVerificationServicesWorkflow.verifyCheckerPage();
	}

	@Then("CurrencySetup page of services tab is rendered correctly")
	public void thenCurrencySetupPageOfServicesTabIsRenderedCorrectly() {
		agentUiVerificationServicesWorkflow.verifyCurrencySetupPage();
	}

	@Then("DedupeReverificationApproval page of services tab is rendered correctly")
	public void thenDedupeReverificationApprovalPageOfServicesTabIsRenderedCorrectly() {
		agentUiVerificationServicesWorkflow.verifyDedupeReverificationApprovalPage();
	}

	@Then("DeviceSale page of services tab is rendered correctly")
	public void thenDeviceSalePageOfServicesTabIsRenderedCorrectly() {
		agentUiVerificationServicesWorkflow.verifyDeviceSalePage();
	}

	@Then("InstantDeviceReplacement page of services tab is rendered correctly")
	public void thenInstantDeviceReplacementPageOfServicesTabIsRenderedCorrectly() {
		agentUiVerificationServicesWorkflow.verifyInstantDeviceReplacementPage();
	}

	@Then("KYCUpdate page of services tab is rendered correctly")
	public void thenKYCUpdatePageOfServicesTabIsRenderedCorrectly() {
		agentUiVerificationServicesWorkflow.verifyKYCUpdatePage();
	}

	@Then("LimitedValidityVirtualCardCancellation page of services tab is rendered correctly")
	public void thenLimitedValidityVirtualCardCancellationPageOfServicesTabIsRenderedCorrectly() {
		agentUiVerificationServicesWorkflow.verifyLimitedValidityVirtualCardCancellationPage();
	}

	@Then("AgencySettlement page of settlement tab is rendered correctly")
	public void thenAgencySettlementPageOfSettlementTabIsRenderedCorrectly() {
		agentUiVerificationSettlementWorkflow.verifyAgencySettlementPage();
	}

	@Then("BranchSettlement page of settlement tab is rendered correctly")
	public void thenBranchSettlementPageOfSettlementTabIsRenderedCorrectly() {
		agentUiVerificationSettlementWorkflow.verifyBranchSettlementPage();
	}

	@Then("InitiateSettlement page of settlement tab is rendered correctly")
	public void thenInitiateSettlementPageOfSettlementTabIsRenderedCorrectly() {
		agentUiVerificationSettlementWorkflow.verifyInitiateSettlementPage();
	}

	@Then("TransactionAndSettlement page of settlement tab is rendered correctly")
	public void thenTransactionAndSettlementPageOfSettlementTabIsRenderedCorrectly() {
		agentUiVerificationSettlementWorkflow.verifyTransactionAndSettlementPage();
	}

	@Then("BalanceEnquiry page of transactions tab is rendered correctly")
	public void thenBalanceEnquiryPageOfTransactionsTabIsRenderedCorrectly() {
		agentUiVerificationTransactionsWorkflow.verifyBalanceEnquiryPage();
	}

	@Then("BalanceRefundApprove page of transactions tab is rendered correctly")
	public void thenBalanceRefundApprovePageOfTransactionsTabIsRenderedCorrectly() {
		agentUiVerificationTransactionsWorkflow.verifyBalanceRefundApprovePage();
	}

	@Then("BalanceRefundRequest page of transactions tab is rendered correctly")
	public void thenBalanceRefundRequestPageOfTransactionsTabIsRenderedCorrectly() {
		agentUiVerificationTransactionsWorkflow.verifyBalanceRefundRequestPage();
	}

	@Then("CancelCardToCash page of transactions tab is rendered correctly")
	public void thenCancelCardToCashPageOfTransactionsTabIsRenderedCorrectly() {
		agentUiVerificationTransactionsWorkflow.verifyCancelCardToCashPage();
	}

	@Then("CardToCashLookup page of transactions tab is rendered correctly")
	public void thenCardToCashLookupPageOfTransactionsTabIsRenderedCorrectly() {
		agentUiVerificationTransactionsWorkflow.verifyCardToCashLookupPage();
	}

	@Then("CardToCashTransaction page of transactions tab is rendered correctly")
	public void thenCardToCashTransactionPageOfTransactionsTabIsRenderedCorrectly() {
		agentUiVerificationTransactionsWorkflow.verifyCardToCashTransactionPage();
	}

	@Then("CashRemittancePayout page of transactions tab is rendered correctly")
	public void thenCashRemittancePayoutPageOfTransactionsTabIsRenderedCorrectly() {
		agentUiVerificationTransactionsWorkflow.verifyCashRemittancePayoutPage();
	}

	@Then("LoadBalanceApprove page of transactions tab is rendered correctly")
	
	public void thenLoadBalanceApprovePageOfTransactionsTabIsRenderedCorrectly() {
		agentUiVerificationTransactionsWorkflow.verifyLoadBalanceApprovePage();
	}

	@Then("LoadBalanceRequest page of transactions tab is rendered correctly")
	public void thenLoadBalanceRequestPageOfTransactionsTabIsRenderedCorrectly() {
		agentUiVerificationTransactionsWorkflow.verifyLoadBalanceRequestPage();
	}

	@Then("LoadBalanceViewPendingRequests page of transactions tab is rendered correctly")
	public void thenLoadBalanceViewPendingRequestsPageOfTransactionsTabIsRenderedCorrectly() {
		agentUiVerificationTransactionsWorkflow.verifyLoadBalanceViewPendingRequestsPage();
	}

	@Then("TransactionHistory page of transactions tab is rendered correctly")
	public void thenTransactionHistoryPageOfTransactionsTabIsRenderedCorrectly() {
		agentUiVerificationTransactionsWorkflow.verifyTransactionHistoryPage();
	}

	@Then("TransactionsViewCharges page of transactions tab is rendered correctly")
	public void thenTransactionsViewChargesPageOfTransactionsTabIsRenderedCorrectly() {
		agentUiVerificationTransactionsWorkflow.verifyTransactionsViewChargesPage();
	}

	@Then("TransferFunds page of transactions tab is rendered correctly")
	public void thenTransferFundsPageOfTransactionsTabIsRenderedCorrectly() {
		agentUiVerificationTransactionsWorkflow.verifyTransferFundsPage();
	}

}
