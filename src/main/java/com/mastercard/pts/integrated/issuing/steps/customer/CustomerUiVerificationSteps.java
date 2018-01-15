package com.mastercard.pts.integrated.issuing.steps.customer;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.LoginWorkflow;
import com.mastercard.pts.integrated.issuing.workflows.customer.administration.UiVerificationAdministrationWorkflow;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.UiVerificationCardManagementWorkflow;
import com.mastercard.pts.integrated.issuing.workflows.customer.dispute.UiVerifcationDisputeWorkflow;
import com.mastercard.pts.integrated.issuing.workflows.customer.distribution.UiVerificationDistributionWorkflow;
import com.mastercard.pts.integrated.issuing.workflows.customer.helpdesk.UiVerificationHelpdeskWorkflow;
import com.mastercard.pts.integrated.issuing.workflows.customer.loyalty.UiVerificationLoyaltyWorkflow;

@Component
public class CustomerUiVerificationSteps {

	@Autowired
	private UiVerificationLoyaltyWorkflow uiVerificationLoyaltyWorkflow;

	@Autowired
	private UiVerificationCardManagementWorkflow uiVerificationCardManagementWorkflow;

	@Autowired
	private UiVerificationHelpdeskWorkflow uiVerificationHelpdeskWorkflow;

	@Autowired
	private UiVerificationAdministrationWorkflow uiVerificationAdministrationWorkflow;

	@Autowired
	private UiVerificationDistributionWorkflow uiVerificationDistributionWorkflow;

	@Autowired
	private UiVerifcationDisputeWorkflow uiVerificationDisputeWorkflow;

	@Autowired
	private LoginWorkflow loginWorkflow;
	
	@Then("AccountFile page of card management tab is rendered correctly")
	public void thenAccountFilePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyAccountFilePage();
	}

	@Then("AccountRangeRouting page of card management tab is rendered correctly")
	public void thenAccountRangeRoutingPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyAccountRangeRoutingPage();
	}

	@Then("AccountType page of card management tab is rendered correctly")
	public void thenAccountTypePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyAccountTypePage();
	}

	@Then("AddMpe page of card management tab is rendered correctly")
	public void thenAddMpePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyAddMpePage();
	}

	@Then("AdjustmentTransaction page of card management tab is rendered correctly")
	public void thenAdjustmentTransactionPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyAdjustmentTransactionPage();
	}

	@Then("Administartive page of card management tab is rendered correctly")
	public void thenAdministartivePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyAdministartivePage();
	}

	@Then("ApplicationBatchDetails page of card management tab is rendered correctly")
	public void thenApplicationBatchDetailsPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyApplicationBatchDetailsPage();
	}

	@Then("ApplicationBusinessMandatoryFields page of card management tab is rendered correctly")
	public void thenApplicationBusinessMandatoryFieldsPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyApplicationBusinessMandatoryFieldsPage();
	}

	@Then("ApplicationDetails page of card management tab is rendered correctly")
	public void thenApplicationDetailsPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyApplicationDetailsPage();
	}

	@Then("ApplicationDocumentChecklist page of card management tab is rendered correctly")
	public void thenApplicationDocumentChecklistPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyApplicationDocumentChecklistPage();
	}

	@Then("Application page of card management tab is rendered correctly")
	public void thenApplicationPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyApplicationPage();
	}

	@Then("ApplicationScoring page of card management tab is rendered correctly")
	public void thenApplicationScoringPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyApplicationScoringPage();
	}

	@Then("ApprovalScore page of card management tab is rendered correctly")
	public void thenApprovalScorePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyApprovalScorePage();
	}

	@Then("ApproveReject page of card management tab is rendered correctly")
	public void thenApproveRejectPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyApproveRejectPage();
	}

	@Then("AuthorizationRequest page of card management tab is rendered correctly")
	public void thenAuthorizationRequestPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyAuthorizationRequestPage();
	}

	@Then("AuthorizationSearch page of card management tab is rendered correctly")
	public void thenAuthorizationSearchPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyAuthorizationSearchPage();
	}

	@Then("AutoDebit page of card management tab is rendered correctly")
	public void thenAutoDebitPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyAutoDebitPage();
	}

	@Then("Balance page of card management tab is rendered correctly")
	public void thenBalancePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyBalancePage();
	}
	
	@When("BatchJobHistory page of card management tab is rendered correctly")
	@Then("BatchJobHistory page of card management tab is rendered correctly")
	public void thenBatchJobHistoryPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyBatchJobHistoryPage();
	}

	@Then("BatchProcessing page of card management tab is rendered correctly")
	public void thenBatchProcessingPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyBatchProcessingPage();
	}

	@Then("BatchTraceHistory page of card management tab is rendered correctly")
	public void thenBatchTraceHistoryPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyBatchTraceHistoryPage();
	}

	@Then("BillingCycle page of card management tab is rendered correctly")
	public void thenBillingCyclePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyBillingCyclePage();
	}

	@Then("BillingReports page of card management tab is rendered correctly")
	public void thenBillingReportsPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyBillingReportsPage();
	}

	@Then("BulkDeviceGenerationBatch page of card management tab is rendered correctly")
	public void thenBulkDeviceGenerationBatchPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyBulkDeviceGenerationBatchPage();
	}

	@Then("BusinessCalendar page of card management tab is rendered correctly")
	public void thenBusinessCalendarPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyBusinessCalendarPage();
	}

	@Then("BusinessMandatoryFields page of card management tab is rendered correctly")
	public void thenBusinessMandatoryFieldsPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyBusinessMandatoryFieldsPage();
	}

	@Then("CardFees page of card management tab is rendered correctly")
	public void thenCardFeesPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyCardFeesPage();
	}

	@Then("CarrierAcknowledgement page of card management tab is rendered correctly")
	public void thenCarrierAcknowledgementPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyCarrierAcknowledgementPage();
	}

	@Then("Cash page of card management tab is rendered correctly")
	public void thenCashPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyCashPage();
	}

	@Then("Classification page of card management tab is rendered correctly")
	public void thenClassificationPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyClassificationPage();
	}

	@Then("ClientDetails page of card management tab is rendered correctly")
	public void thenClientDetailsPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyClientDetailsPage();
	}

	@Then("ClientPortfolio page of card management tab is rendered correctly")
	public void thenClientPortfolioPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyClientPortfolioPage();
	}

	@Then("CloseBatch page of card management tab is rendered correctly")
	public void thenCloseBatchPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyCloseBatchPage();
	}

	@Then("CollectionBatchProcess page of card management tab is rendered correctly")
	public void thenCollectionBatchProcessPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyCollectionBatchProcessPage();
	}

	@Then("ComplianceReports page of card management tab is rendered correctly")
	public void thenComplianceReportsPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyComplianceReportsPage();
	}

	@Then("CorporateReports page of card management tab is rendered correctly")
	public void thenCorporateReportsPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyCorporateReportsPage();
	}

	@Then("CountryWhiteListBlackListPlan page of card management tab is rendered correctly")
	public void thenCountryWhiteListBlackListPlanPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyCountryWhiteListBlackListPlanPage();
	}

	@Then("CreateCorporate page of card management tab is rendered correctly")
	public void thenCreateCorporatePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyCreateCorporatePage();
	}

	@Then("CreditBureauVerification page of card management tab is rendered correctly")
	public void thenCreditBureauVerificationPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyCreditBureauVerificationPage();
	}

	@Then("CreditCardBillingCycle page of card management tab is rendered correctly")
	public void thenCreditCardBillingCyclePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyCreditCardBillingCyclePage();
	}

	@Then("CreditCardCreditPlan page of card management tab is rendered correctly")
	public void thenCreditCardCreditPlanPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyCreditCardCreditPlanPage();
	}

	@Then("CreditCardPaymentBounceReason page of card management tab is rendered correctly")
	public void thenCreditCardPaymentBounceReasonPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyCreditCardPaymentBounceReasonPage();
	}

	@Then("CreditCardPaymentPriority page of card management tab is rendered correctly")
	public void thenCreditCardPaymentPriorityPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyCreditCardPaymentPriorityPage();
	}

	@Then("CreditCardTransactionRulePlan page of card management tab is rendered correctly")
	public void thenCreditCardTransactionRulePlanPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyCreditCardTransactionRulePlanPage();
	}

	@Then("CreditLimitRule page of card management tab is rendered correctly")
	public void thenCreditLimitRulePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyCreditLimitRulePage();
	}

	@Then("CreditPlan page of card management tab is rendered correctly")
	public void thenCreditPlanPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyCreditPlanPage();
	}

	@Then("CurrencyBlackListPlan page of card management tab is rendered correctly")
	public void thenCurrencyBlackListPlanPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyCurrencyBlackListPlanPage();
	}

	@Then("CurrencyExchangeRatesMapping page of card management tab is rendered correctly")
	public void thenCurrencyExchangeRatesMappingPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyCurrencyExchangeRatesMappingPage();
	}

	@Then("CurrencyExchangeRates page of card management tab is rendered correctly")
	public void thenCurrencyExchangeRatesPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyCurrencyExchangeRatesPage();
	}

	@Then("CutoverProfile page of card management tab is rendered correctly")
	public void thenCutoverProfilePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyCutoverProfilePage();
	}

	@Then("DedupePlan page of card management tab is rendered correctly")
	public void thenDedupePlanPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyDedupePlanPage();
	}

	@Then("DeDupeSDNVerification page of card management tab is rendered correctly")
	public void thenDeDupeSDNVerificationPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyDeDupeSDNVerificationPage();
	}

	@Then("DeviceActivity page of card management tab is rendered correctly")
	public void thenDeviceActivityPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyDeviceActivityPage();
	}

	@Then("DeviceBin page of card management tab is rendered correctly")
	public void thenDeviceBinPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyDeviceBinPage();
	}

	@Then("DeviceCreateDevice page of card management tab is rendered correctly")
	public void thenDeviceCreateDevicePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyDeviceCreateDevicePage();
	}

	@Then("DeviceDeDupeSDNVerification page of card management tab is rendered correctly")
	public void thenDeviceDeDupeSDNVerificationPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyDeviceDeDupeSDNVerificationPage();
	}

	@Then("DeviceDetails page of card management tab is rendered correctly")
	public void thenDeviceDetailsPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyDeviceDetailsPage();
	}

	@Then("DeviceEventBasedFeePlan page of card management tab is rendered correctly")
	public void thenDeviceEventBasedFeePlanPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyDeviceEventBasedFeePlanPage();
	}

	@Then("DeviceGeneration page of card management tab is rendered correctly")
	public void thenDeviceGenerationPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyDeviceGenerationPage();
	}

	@Then("DeviceJoiningAndMembershipFeePlan page of card management tab is rendered correctly")
	public void thenDeviceJoiningAndMembershipFeePlanPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyDeviceJoiningAndMembershipFeePlanPage();
	}

	@Then("DeviceKeys page of card management tab is rendered correctly")
	public void thenDeviceKeysPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyDeviceKeysPage();
	}

	@Then("DevicePlan page of card management tab is rendered correctly")
	public void thenDevicePlanPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyDevicePlanPage();
	}

	@Then("DevicePriorityPassIDAndCardPackIDTemplate page of card management tab is rendered correctly")
	public void thenDevicePriorityPassIDAndCardPackIDTemplatePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyDevicePriorityPassIDAndCardPackIDTemplatePage();
	}

	@Then("DeviceProductionBatch page of card management tab is rendered correctly")
	public void thenDeviceProductionBatchPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyDeviceProductionBatchPage();
	}

	@Then("DeviceProductionBulkDeviceRequest page of card management tab is rendered correctly")
	public void thenDeviceProductionBulkDeviceRequestPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyDeviceProductionBulkDeviceRequestPage();
	}

	@Then("DeviceProductionCancellation page of card management tab is rendered correctly")
	public void thenDeviceProductionCancellationPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyDeviceProductionCancellationPage();
	}

	@Then("DevicePromotionPlan page of card management tab is rendered correctly")
	public void thenDevicePromotionPlanPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyDevicePromotionPlanPage();
	}

	@Then("DeviceRange page of card management tab is rendered correctly")
	public void thenDeviceRangePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyDeviceRangePage();
	}

	@Then("DeviceTracking page of card management tab is rendered correctly")
	public void thenDeviceTrackingPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyDeviceTrackingPage();
	}

	@Then("DeviceUsageClass.java page of card management tab is rendered correctly")
	public void thenDeviceUsagePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyDeviceUsagePage();
	}

	@Then("DocumentChecklist page of card management tab is rendered correctly")
	public void thenDocumentChecklistPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyDocumentChecklistPage();
	}

	@Then("EasyPayPlanRule page of card management tab is rendered correctly")
	public void thenEasyPayPlanRulePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyEasyPayPlanRulePage();
	}

	@Then("EasyPayPlanVerificationBatch page of card management tab is rendered correctly")
	public void thenEasyPayPlanVerificationBatchPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyEasyPayPlanVerificationBatchPage();
	}

	@Then("EmbossingPINAndPriorityPassFileNameParameter page of card management tab is rendered correctly")
	public void thenEmbossingPINAndPriorityPassFileNameParameterPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyEmbossingPINAndPriorityPassFileNameParameterPage();
	}

	@Then("EmbossingPINAndPriorityPassFileTemplate page of card management tab is rendered correctly")
	public void thenEmbossingPINAndPriorityPassFileTemplatePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyEmbossingPINAndPriorityPassFileTemplatePage();
	}

	@Then("EMIReports page of card management tab is rendered correctly")
	public void thenEMIReportsPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyEMIReportsPage();
	}

	@Then("EventAlertHistory page of card management tab is rendered correctly")
	public void thenEventAlertHistoryPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyEventAlertHistoryPage();
	}

	@Then("EventAndAlert page of card management tab is rendered correctly")
	public void thenEventAndAlertPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyEventAndAlertPage();
	}

	@Then("EventsAndAlerts page of card management tab is rendered correctly")
	public void thenEventsAndAlertsPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyEventsAndAlertsPage();
	}

	@Then("ExceptionFileMessage page of card management tab is rendered correctly")
	public void thenExceptionFileMessagePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyExceptionFileMessagePage();
	}

	@Then("FeeCollection page of card management tab is rendered correctly")
	public void thenFeeCollectionPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyFeeCollectionPage();
	}

	@Then("FeeReason page of card management tab is rendered correctly")
	public void thenFeeReasonPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyFeeReasonPage();
	}

	@Then("FinancialReports page of card management tab is rendered correctly")
	public void thenFinancialReportsPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyFinancialReportsPage();
	}

	@Then("FixedScore page of card management tab is rendered correctly")
	public void thenFixedScorePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyFixedScorePage();
	}

	@Then("FraudNotificationTC40 page of card management tab is rendered correctly")
	public void thenFraudNotificationTC40PageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyFraudNotificationTC40Page();
	}

	@Then("FraudWriteOff page of card management tab is rendered correctly")
	public void thenFraudWriteOffPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyFraudWriteOffPage();
	}

	@Then("GatewayConfiguration page of card management tab is rendered correctly")
	public void thenGatewayConfigurationPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyGatewayConfigurationPage();
	}

	@Then("GenerateReversal page of card management tab is rendered correctly")
	public void thenGenerateReversalPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyGenerateReversalPage();
	}

	@Then("GLAccountHead page of card management tab is rendered correctly")
	public void thenGLAccountHeadPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyGLAccountHeadPage();
	}

	@Then("HighRiskCountry page of card management tab is rendered correctly")
	public void thenHighRiskCountryPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyHighRiskCountryPage();
	}

	@Then("HighRiskMCC page of card management tab is rendered correctly")
	public void thenHighRiskMCCPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyHighRiskMCCPage();
	}

	@Then("HighRiskMCG page of card management tab is rendered correctly")
	public void thenHighRiskMCGPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyHighRiskMCGPage();
	}

	@Then("HighRiskMerchantLocation page of card management tab is rendered correctly")
	public void thenHighRiskMerchantLocationPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyHighRiskMerchantLocationPage();
	}

	@Then("HolidayConfiguration page of card management tab is rendered correctly")
	public void thenHolidayConfigurationPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyHolidayConfigurationPage();
	}

	@Then("IncompleteApplication page of card management tab is rendered correctly")
	public void thenIncompleteApplicationPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyIncompleteApplicationPage();
	}

	@Then("InitiateVisaMoneyTransfer page of card management tab is rendered correctly")
	public void thenInitiateVisaMoneyTransferPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyInitiateVisaMoneyTransferPage();
	}

	@Then("InstitutionCurrency page of card management tab is rendered correctly")
	public void thenInstitutionCurrencyPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyInstitutionCurrencyPage();
	}

	@Then("InstitutionLoadCurrency page of card management tab is rendered correctly")
	public void thenInstitutionLoadCurrencyPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyInstitutionLoadCurrencyPage();
	}

	@Then("InterestRatePlan page of card management tab is rendered correctly")
	public void thenInterestRatePlanPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyInterestRatePlanPage();
	}

	@Then("InternalRating page of card management tab is rendered correctly")
	public void thenInternalRatingPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyInternalRatingPage();
	}

	@Then("InvalidChequeReason page of card management tab is rendered correctly")
	public void thenInvalidChequeReasonPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyInvalidChequeReasonPage();
	}

	@Then("IssuerPublicKeyIPKCertificateInformation page of card management tab is rendered correctly")
	public void thenIssuerPublicKeyIPKCertificateInformationPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyIssuerPublicKeyIPKCertificateInformationPage();
	}

	@Then("LatePaymentFeePlan page of card management tab is rendered correctly")
	public void thenLatePaymentFeePlanPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyLatePaymentFeePlanPage();
	}

	@Then("LinkingAPIToInstitution page of card management tab is rendered correctly")
	public void thenLinkingAPIToInstitutionPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyLinkingAPIToInstitutionPage();
	}

	@Then("LoanAccountDetails page of card management tab is rendered correctly")
	public void thenLoanAccountDetailsPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyLoanAccountDetailsPage();
	}

	@Then("LoanApprovalRetailTransactionToLoan page of card management tab is rendered correctly")
	public void thenLoanApprovalRetailTransactionToLoanPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyLoanApprovalRetailTransactionToLoanPage();
	}

	@Then("LoanCancellation page of card management tab is rendered correctly")
	public void thenLoanCancellationPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyLoanCancellationPage();
	}

	@Then("LoanPlan page of card management tab is rendered correctly")
	public void thenLoanPlanPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyLoanPlanPage();
	}

	@Then("LoanPreClosure page of card management tab is rendered correctly")
	public void thenLoanPreClosurePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyLoanPreClosurePage();
	}

	@Then("LoanType page of card management tab is rendered correctly")
	public void thenLoanTypePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyLoanTypePage();
	}

	@Then("LocalCheque page of card management tab is rendered correctly")
	public void thenLocalChequePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyLocalChequePage();
	}

	@Then("ManualAlerts page of card management tab is rendered correctly")
	public void thenManualAlertsPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyManualAlertsPage();
	}

	@Then("MarketingMessagePlan page of card management tab is rendered correctly")
	public void thenMarketingMessagePlanPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyMarketingMessagePlanPage();
	}

	@Then("MarkupFeePlan page of card management tab is rendered correctly")
	public void thenMarkupFeePlanPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyMarkupFeePlanPage();
	}

	@Then("MasterDerivationKeys page of card management tab is rendered correctly")
	public void thenMasterDerivationKeysPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyMasterDerivationKeysPage();
	}

	@Then("MCCOverlimit page of card management tab is rendered correctly")
	public void thenMCCOverlimitPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyMCCOverlimitPage();
	}

	@Then("MCCRulePlan page of card management tab is rendered correctly")
	public void thenMCCRulePlanPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyMCCRulePlanPage();
	}

	@Then("MCGAdditionalHoldPlan page of card management tab is rendered correctly")
	public void thenMCGAdditionalHoldPlanPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyMCGAdditionalHoldPlanPage();
	}

	@Then("MCGLimitPlan page of card management tab is rendered correctly")
	public void thenMCGLimitPlanPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyMCGLimitPlanPage();
	}

	@Then("MemberFundCollectionAndFundDisbursement page of card management tab is rendered correctly")
	public void thenMemberFundCollectionAndFundDisbursementPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyMemberFundCollectionAndFundDisbursementPage();
	}

	@Then("MerchantCategoryGroupMCG page of card management tab is rendered correctly")
	public void thenMerchantCategoryGroupMCGPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyMerchantCategoryGroupMCGPage();
	}

	@Then("MiscellaneousFee page of card management tab is rendered correctly")
	public void thenMiscellaneousFeePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyMiscellaneousFeePage();
	}

	@Then("MoneySend page of card management tab is rendered correctly")
	public void thenMoneySendPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyMoneySendPage();
	}

	@Then("NetworkKeys page of card management tab is rendered correctly")
	public void thenNetworkKeysPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyNetworkKeysPage();
	}

	@Then("NetworkMembership page of card management tab is rendered correctly")
	public void thenNetworkMembershipPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyNetworkMembershipPage();
	}

	@Then("NewApplication page of card management tab is rendered correctly")
	public void thenNewApplicationPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyNewApplicationPage();
	}

	@Then("NewDevice page of card management tab is rendered correctly")
	public void thenNewDevicePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyNewDevicePage();
	}

	@Then("Office page of card management tab is rendered correctly")
	public void thenOfficePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyOfficePage();
	}

	@Then("OtherTransactions page of card management tab is rendered correctly")
	public void thenOtherTransactionsPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyOtherTransactionsPage();
	}

	@Then("OutstationChequeCollection page of card management tab is rendered correctly")
	public void thenOutstationChequeCollectionPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyOutstationChequeCollectionPage();
	}

	@Then("OutstationChequeProcessing page of card management tab is rendered correctly")
	public void thenOutstationChequeProcessingPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyOutstationChequeProcessingPage();
	}

	@Then("Override page of card management tab is rendered correctly")
	public void thenOverridePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyOverridePage();
	}

	@Then("PaymentBounceReason page of card management tab is rendered correctly")
	public void thenPaymentBounceReasonPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyPaymentBounceReasonPage();
	}

	@Then("PaymentPriority page of card management tab is rendered correctly")
	public void thenPaymentPriorityPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyPaymentPriorityPage();
	}

	@Then("PictureCode page of card management tab is rendered correctly")
	public void thenPictureCodePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyPictureCodePage();
	}

	@Then("PinGenerationBatch page of card management tab is rendered correctly")
	public void thenPinGenerationBatchPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyPinGenerationBatchPage();
	}

	@Then("PinRePrint page of card management tab is rendered correctly")
	public void thenPinRePrintPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyPinRePrintPage();
	}

	@Then("PlasticCode page of card management tab is rendered correctly")
	public void thenPlasticCodePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyPlasticCodePage();
	}

	@Then("PrepaidStatementPlan page of card management tab is rendered correctly")
	public void thenPrepaidStatementPlanPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyPrepaidStatementPlanPage();
	}

	@Then("PreProductionBatch page of card management tab is rendered correctly")
	public void thenPreProductionBatchPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyPreProductionBatchPage();
	}

	@Then("ProcessBatches page of card management tab is rendered correctly")
	public void thenProcessBatchesPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyProcessBatchesPage();
	}

	@Then("ProgramChangeRule page of card management tab is rendered correctly")
	public void thenProgramChangeRulePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyProgramChangeRulePage();
	}

	@Then("ProgramChangeScheme page of card management tab is rendered correctly")
	public void thenProgramChangeSchemePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyProgramChangeSchemePage();
	}

	@Then("Program page of card management tab is rendered correctly")
	public void thenProgramPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyProgramPage();
	}

	@Then("RAMPReport page of card management tab is rendered correctly")
	public void thenRAMPReportPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyRAMPReportPage();
	}

	@Then("ReceiveFromPersonalisationVendor page of card management tab is rendered correctly")
	public void thenReceiveFromPersonalisationVendorPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyReceiveFromPersonalisationVendorPage();
	}

	@Then("Refer page of card management tab is rendered correctly")
	public void thenReferPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyReferPage();
	}

	@Then("ReplaceUpgradeDevice page of card management tab is rendered correctly")
	public void thenReplaceUpgradeDevicePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyReplaceUpgradeDevicePage();
	}

	@Then("ResendPINRequest page of card management tab is rendered correctly")
	public void thenResendPINRequestPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyResendPINRequestPage();
	}

	@Then("ReSendToPersonalizationVendor page of card management tab is rendered correctly")
	public void thenReSendToPersonalizationVendorPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyReSendToPersonalizationVendorPage();
	}

	@Then("ReversalTransaction page of card management tab is rendered correctly")
	public void thenReversalTransactionPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyReversalTransactionPage();
	}

	@Then("RiskAnalysis page of card management tab is rendered correctly")
	public void thenRiskAnalysisPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyRiskAnalysisPage();
	}

	@Then("RiskAnalysisRule page of card management tab is rendered correctly")
	public void thenRiskAnalysisRulePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyRiskAnalysisRulePage();
	}

	@Then("RuPayBINRange page of card management tab is rendered correctly")
	public void thenRuPayBINRangePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyRuPayBINRangePage();
	}

	@Then("RupaySettlementBIN page of card management tab is rendered correctly")
	public void thenRupaySettlementBINPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyRupaySettlementBINPage();
	}

	@Then("SafeUpdate page of card management tab is rendered correctly")
	public void thenSafeUpdatePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifySafeUpdatePage();
	}

	@Then("SendToCarrier page of card management tab is rendered correctly")
	public void thenSendToCarrierPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifySendToCarrierPage();
	}

	@Then("SettledTransaction page of card management tab is rendered correctly")
	public void thenSettledTransactionPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifySettledTransactionPage();
	}

	@Then("StatementMessagePlan page of card management tab is rendered correctly")
	public void thenStatementMessagePlanPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyStatementMessagePlanPage();
	}

	@Then("StopDeviceRenewal page of card management tab is rendered correctly")
	public void thenStopDeviceRenewalPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyStopDeviceRenewalPage();
	}

	@Then("StopDeviceReplace page of card management tab is rendered correctly")
	public void thenStopDeviceReplacePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyStopDeviceReplacePage();
	}

	@Then("StopListBin page of card management tab is rendered correctly")
	public void thenStopListBinPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyStopListBinPage();
	}

	@Then("StopListCountry page of card management tab is rendered correctly")
	public void thenStopListCountryPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyStopListCountryPage();
	}

	@Then("StopListDevice page of card management tab is rendered correctly")
	public void thenStopListDevicePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyStopListDevicePage();
	}

	@Then("StopListDeviceRange page of card management tab is rendered correctly")
	public void thenStopListDeviceRangePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyStopListDeviceRangePage();
	}

	@Then("StopList page of card management tab is rendered correctly")
	public void thenStopListPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyStopListPage();
	}

	@Then("StoplistReason page of card management tab is rendered correctly")
	public void thenStoplistReasonPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyStoplistReasonPage();
	}

	@Then("SurchargePlan page of card management tab is rendered correctly")
	public void thenSurchargePlanPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifySurchargePlanPage();
	}

	@Then("SurchargeWailverPlan page of card management tab is rendered correctly")
	public void thenSurchargeWailverPlanPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifySurchargeWailverPlanPage();
	}

	@Then("SystemCodes page of card management tab is rendered correctly")
	public void thenSystemCodesPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifySystemCodesPage();
	}

	@Then("TaxOnIncome page of card management tab is rendered correctly")
	public void thenTaxOnIncomePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyTaxOnIncomePage();
	}

	@Then("Term page of card management tab is rendered correctly")
	public void thenTermPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyTermPage();
	}

	@Then("ThreeDECommerceSecurityParameters page of card management tab is rendered correctly")
	public void thenThreeDECommerceSecurityParametersPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyThreeDECommerceSecurityParametersPage();
	}

	@Then("TransactionFeePlan page of card management tab is rendered correctly")
	public void thenTransactionFeePlanPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyTransactionFeePlanPage();
	}

	@Then("TransactionFeeWaiverPlan page of card management tab is rendered correctly")
	public void thenTransactionFeeWaiverPlanPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyTransactionFeeWaiverPlanPage();
	}

	@Then("TransactionLimitPlan page of card management tab is rendered correctly")
	public void thenTransactionLimitPlanPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyTransactionLimitPlanPage();
	}

	@Then("TransactionPlan page of card management tab is rendered correctly")
	public void thenTransactionPlanPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyTransactionPlanPage();
	}

	@Then("TransactionRegistration page of card management tab is rendered correctly")
	public void thenTransactionRegistrationPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyTransactionRegistrationPage();
	}

	@Then("TransactionReports page of card management tab is rendered correctly")
	public void thenTransactionReportsPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyTransactionReportsPage();
	}

	@Then("TransactionRouting page of card management tab is rendered correctly")
	public void thenTransactionRoutingPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyTransactionRoutingPage();
	}

	@Then("TransactionRulePlan page of card management tab is rendered correctly")
	public void thenTransactionRulePlanPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyTransactionRulePlanPage();
	}

	@Then("TransactionSearch page of card management tab is rendered correctly")
	public void thenTransactionSearchPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyTransactionSearchPage();
	}

	@Then("Unpaid page of card management tab is rendered correctly")
	public void thenUnpaidPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyUnpaidPage();
	}

	@Then("UnsettledTransaction page of card management tab is rendered correctly")
	public void thenUnsettledTransactionPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyUnsettledTransactionPage();
	}

	@Then("UpdateClientDetails page of card management tab is rendered correctly")
	public void thenUpdateClientDetailsPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyUpdateClientDetailsPage();
	}

	@Then("UpdateClientEvents page of card management tab is rendered correctly")
	public void thenUpdateClientEventsPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyUpdateClientEventsPage();
	}

	@Then("UpdateDeviceDetails page of card management tab is rendered correctly")
	public void thenUpdateDeviceDetailsPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyUpdateDeviceDetailsPage();
	}

	@Then("UpdateWalletDetails page of card management tab is rendered correctly")
	public void thenUpdateWalletDetailsPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyUpdateWalletDetailsPage();
	}

	@Then("VariableScore page of card management tab is rendered correctly")
	public void thenVariableScorePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyVariableScorePage();
	}

	@Then("Vendors page of card management tab is rendered correctly")
	public void thenVendorsPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyVendorsPage();
	}

	@Then("Verify page of card management tab is rendered correctly")
	public void thenVerifyPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyVerifyPage();
	}

	@Then("VISABinRange page of card management tab is rendered correctly")
	public void thenVISABinRangePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyVISABinRangePage();
	}

	@Then("VisaFeeCollection page of card management tab is rendered correctly")
	public void thenVisaFeeCollectionPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyVisaFeeCollectionPage();
	}

	@Then("VisaFraudNotification page of card management tab is rendered correctly")
	public void thenVisaFraudNotificationPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyVisaFraudNotificationPage();
	}

	@Then("WalletConfigurationWalletFeePlan page of card management tab is rendered correctly")
	public void thenWalletConfigurationWalletFeePlanPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyWalletConfigurationWalletFeePlanPage();
	}

	@Then("WalletConfigurationWalletPlan page of card management tab is rendered correctly")
	public void thenWalletConfigurationWalletPlanPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyWalletConfigurationWalletPlanPage();
	}

	@Then("WalletDetails page of card management tab is rendered correctly")
	public void thenWalletDetailsPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyWalletDetailsPage();
	}

	@Then("WalletFeePlan page of card management tab is rendered correctly")
	public void thenWalletFeePlanPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyWalletFeePlanPage();
	}

	@Then("WalletPromotionPlan page of card management tab is rendered correctly")
	public void thenWalletPromotionPlanPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyWalletPromotionPlanPage();
	}

	@Then("WhiteListedMerchantPlan page of card management tab is rendered correctly")
	public void thenWhiteListedMerchantPlanPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyWhiteListedMerchantPlanPage();
	}

	@Then("WithdrawBin page of card management tab is rendered correctly")
	public void thenWithdrawBinPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyWithdrawBinPage();
	}

	@Then("WithdrawCountry page of card management tab is rendered correctly")
	public void thenWithdrawCountryPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyWithdrawCountryPage();
	}

	@Then("WithdrawDevice page of card management tab is rendered correctly")
	public void thenWithdrawDevicePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyWithdrawDevicePage();
	}

	@Then("WithdrawDeviceRange page of card management tab is rendered correctly")
	public void thenWithdrawDeviceRangePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyWithdrawDeviceRangePage();
	}

	@Then("WorkflowRule page of card management tab is rendered correctly")
	public void thenWorkflowRulePageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyWorkflowRulePage();
	}

	@Then("AcceptanceOfReturnedInventory page of distribution tab is rendered correctly")
	public void thenAcceptanceOfReturnedInventoryPageOfDistributionTabIsRenderedCorrectly() {
		uiVerificationDistributionWorkflow.verifyAcceptanceOfReturnedInventoryPage();
	}

	@Then("ActivityReports page of distribution tab is rendered correctly")
	public void thenActivityReportsPageOfDistributionTabIsRenderedCorrectly() {
		uiVerificationDistributionWorkflow.verifyActivityReportsPage();
	}

	@Then("CourierMaster page of distribution tab is rendered correctly")
	public void thenCourierMasterPageOfDistributionTabIsRenderedCorrectly() {
		uiVerificationDistributionWorkflow.verifyCourierMasterPage();
	}

	@Then("Dispatch page of distribution tab is rendered correctly")
	public void thenDispatchPageOfDistributionTabIsRenderedCorrectly() {
		uiVerificationDistributionWorkflow.verifyDispatchPage();
	}

	@Then("DistributionOrderCancellation page of distribution tab is rendered correctly")
	public void thenDistributionOrderCancellationPageOfDistributionTabIsRenderedCorrectly() {
		uiVerificationDistributionWorkflow.verifyDistributionOrderCancellationPage();
	}

	@Then("InterestMaster page of distribution tab is rendered correctly")
	public void thenInterestMasterPageOfDistributionTabIsRenderedCorrectly() {
		uiVerificationDistributionWorkflow.verifyInterestMasterPage();
	}

	@Then("SettlementConfirmation page of distribution tab is rendered correctly")
	public void thenSettlementConfirmationPageOfDistributionTabIsRenderedCorrectly() {
		uiVerificationDistributionWorkflow.verifySettlementConfirmationPage();
	}

	@Then("Arbitration page of dispute tab is rendered correctly")
	public void thenArbitrationPageOfDisputeTabIsRenderedCorrectly() {
		uiVerificationDisputeWorkflow.verifyArbitrationPage();
	}

	@Then("ArbitrationType page of dispute tab is rendered correctly")
	public void thenArbitrationTypePageOfDisputeTabIsRenderedCorrectly() {
		uiVerificationDisputeWorkflow.verifyArbitrationTypePage();
	}

	@Then("ChargeBackCancellation page of dispute tab is rendered correctly")
	public void thenChargeBackCancellationPageOfDisputeTabIsRenderedCorrectly() {
		uiVerificationDisputeWorkflow.verifyChargeBackCancellationPage();
	}

	@Then("ChargeBackModify page of dispute tab is rendered correctly")
	public void thenChargeBackModifyPageOfDisputeTabIsRenderedCorrectly() {
		uiVerificationDisputeWorkflow.verifyChargeBackModifyPage();
	}

	@Then("ChargeBackNew page of dispute tab is rendered correctly")
	public void thenChargeBackNewPageOfDisputeTabIsRenderedCorrectly() {
		uiVerificationDisputeWorkflow.verifyChargeBackNewPage();
	}

	@Then("ChargebackReasonCode page of dispute tab is rendered correctly")
	public void thenChargebackReasonCodePageOfDisputeTabIsRenderedCorrectly() {
		uiVerificationDisputeWorkflow.verifyChargebackReasonCodePage();
	}

	@Then("ChargeBackReversal page of dispute tab is rendered correctly")
	public void thenChargeBackReversalPageOfDisputeTabIsRenderedCorrectly() {
		uiVerificationDisputeWorkflow.verifyChargeBackReversalPage();
	}

	@Then("DisputeHistory page of dispute tab is rendered correctly")
	public void thenDisputeHistoryPageOfDisputeTabIsRenderedCorrectly() {
		uiVerificationDisputeWorkflow.verifyDisputeHistoryPage();
	}

	@Then("ManualDisputePosting page of dispute tab is rendered correctly")
	public void thenManualDisputePostingPageOfDisputeTabIsRenderedCorrectly() {
		uiVerificationDisputeWorkflow.verifyManualDisputePostingPage();
	}

	@Then("RePresentmentReasonCode page of dispute tab is rendered correctly")
	public void thenRePresentmentReasonCodePageOfDisputeTabIsRenderedCorrectly() {
		uiVerificationDisputeWorkflow.verifyRePresentmentReasonCodePage();
	}

	@Then("RetrievalRequestReasonCode page of dispute tab is rendered correctly")
	public void thenRetrievalRequestReasonCodePageOfDisputeTabIsRenderedCorrectly() {
		uiVerificationDisputeWorkflow.verifyRetrievalRequestReasonCodePage();
	}

	@Then("RetrivalRequest page of dispute tab is rendered correctly")
	public void thenRetrivalRequestPageOfDisputeTabIsRenderedCorrectly() {
		uiVerificationDisputeWorkflow.verifyRetrivalRequestPage();
	}

	@Then("RetrivalResponse page of dispute tab is rendered correctly")
	public void thenRetrivalResponsePageOfDisputeTabIsRenderedCorrectly() {
		uiVerificationDisputeWorkflow.verifyRetrivalResponsePage();
	}

	@Then("SecondChargeBackCancellation page of dispute tab is rendered correctly")
	public void thenSecondChargeBackCancellationPageOfDisputeTabIsRenderedCorrectly() {
		uiVerificationDisputeWorkflow.verifySecondChargeBackCancellationPage();
	}

	@Then("SecondChargeBackModify page of dispute tab is rendered correctly")
	public void thenSecondChargeBackModifyPageOfDisputeTabIsRenderedCorrectly() {
		uiVerificationDisputeWorkflow.verifySecondChargeBackModifyPage();
	}

	@Then("SecondChargeBackNew page of dispute tab is rendered correctly")
	public void thenSecondChargeBackNewPageOfDisputeTabIsRenderedCorrectly() {
		uiVerificationDisputeWorkflow.verifySecondChargeBackNewPage();
	}

	@Then("SecondChargeBackReversal page of dispute tab is rendered correctly")
	public void thenSecondChargeBackReversalPageOfDisputeTabIsRenderedCorrectly() {
		uiVerificationDisputeWorkflow.verifySecondChargeBackReversalPage();
	}

	@Then("DisputesManagementReport page of dispute tab is rendered correctly")
	public void thenDisputesManagementReportPageOfDisputeTabIsRenderedCorrectly() {
		uiVerificationDisputeWorkflow.verifyDisputesManagementReportPage();
	}

	@Then("EventBasedLoyaltyPoints page of loyalty tab is rendered correctly")
	public void thenEventBasedLoyaltyPointsPageOfLoyaltyTabIsRenderedCorrectly() {
		uiVerificationLoyaltyWorkflow.verifyEventBasedLoyaltyPointsPage();
	}

	@Then("EventBasedLoyaltyPointsPosting page of loyalty tab is rendered correctly")
	public void thenEventBasedLoyaltyPointsPostingPageOfLoyaltyTabIsRenderedCorrectly() {
		uiVerificationLoyaltyWorkflow.verifyEventBasedLoyaltyPointsPostingPage();
	}

	@Then("GiftRewardCatalogue page of loyalty tab is rendered correctly")
	public void thenGiftRewardCataloguePageOfLoyaltyTabIsRenderedCorrectly() {
		uiVerificationLoyaltyWorkflow.verifyGiftRewardCataloguePage();
	}

	@Then("LoyaltyPlan page of loyalty tab is rendered correctly")
	public void thenLoyaltyPlanPageOfLoyaltyTabIsRenderedCorrectly() {
		uiVerificationLoyaltyWorkflow.verifyLoyaltyPlanPage();
	}

	@Then("LoyaltyPlanPromotionMapping page of loyalty tab is rendered correctly")
	public void thenLoyaltyPlanPromotionMappingPageOfLoyaltyTabIsRenderedCorrectly() {
		uiVerificationLoyaltyWorkflow.verifyLoyaltyPlanPromotionMappingPage();
	}

	@Then("LoyaltyPoints page of loyalty tab is rendered correctly")
	public void thenLoyaltyPointsPageOfLoyaltyTabIsRenderedCorrectly() {
		uiVerificationLoyaltyWorkflow.verifyLoyaltyPointsPage();
	}

	@Then("LoyaltyTransactionPlan page of loyalty tab is rendered correctly")
	public void thenLoyaltyTransactionPlanPageOfLoyaltyTabIsRenderedCorrectly() {
		uiVerificationLoyaltyWorkflow.verifyLoyaltyTransactionPlanPage();
	}

	@Then("PromotionPlan page of loyalty tab is rendered correctly")
	public void thenPromotionPlanPageOfLoyaltyTabIsRenderedCorrectly() {
		uiVerificationLoyaltyWorkflow.verifyPromotionPlanPage();
	}

	@Then("Redemption page of loyalty tab is rendered correctly")
	public void thenRedemptionPageOfLoyaltyTabIsRenderedCorrectly() {
		uiVerificationLoyaltyWorkflow.verifyRedemptionPage();
	}

	@Then("RewardRedemption page of loyalty tab is rendered correctly")
	public void thenRewardRedemptionPageOfLoyaltyTabIsRenderedCorrectly() {
		uiVerificationLoyaltyWorkflow.verifyRewardRedemptionPage();
	}

	@Then("CustomerCare page of helpdesk tab is rendered correctly")
	public void thenCustomerCarePageOfHelpdeskTabIsRenderedCorrectly() {
		uiVerificationHelpdeskWorkflow.traverseHelpDeskCustomerCarePage();
	}

	@Then("DynamicQuizzing page of helpdesk tab is rendered correctly")
	public void thenDynamicQuizzingPageOfHelpdeskTabIsRenderedCorrectly() {
		uiVerificationHelpdeskWorkflow.traverseHelpDeskDynamicQuizzingPage();
	}

	@Then("EscalationII page of helpdesk tab is rendered correctly")
	public void thenEscalationIIPageOfHelpdeskTabIsRenderedCorrectly() {
		uiVerificationHelpdeskWorkflow.traverseHelpDeskEscalationIIPage();
	}

	@Then("EscalationI page of helpdesk tab is rendered correctly")
	public void thenEscalationIPageOfHelpdeskTabIsRenderedCorrectly() {
		uiVerificationHelpdeskWorkflow.traverseHelpDeskEscalationIPage();
	}

	@Then("Forwarded page of helpdesk tab is rendered correctly")
	public void thenForwardedPageOfHelpdeskTabIsRenderedCorrectly() {
		uiVerificationHelpdeskWorkflow.traverseHelpDeskForwardedPage();
	}

	@Then("HelpdeskGeneral page of helpdesk tab is rendered correctly")
	public void thenHelpdeskGeneralPageOfHelpdeskTabIsRenderedCorrectly() {
		uiVerificationHelpdeskWorkflow.traverseHelpDeskGeneralPage();
	}

	@Then("HelpDeskReports page of helpdesk tab is rendered correctly")
	public void thenHelpDeskReportsPageOfHelpdeskTabIsRenderedCorrectly() {
		uiVerificationHelpdeskWorkflow.traverseHelpDeskReportsPage();
	}

	@Then("ServiceCode page of helpdesk tab is rendered correctly")
	public void thenServiceCodePageOfHelpdeskTabIsRenderedCorrectly() {
		uiVerificationHelpdeskWorkflow.traverseHelpDeskServiceCodePage();
	}

	@Then("ServiceRequest page of helpdesk tab is rendered correctly")
	public void thenServiceRequestPageOfHelpdeskTabIsRenderedCorrectly() {
		uiVerificationHelpdeskWorkflow.traverseHelpDeskServiceRequestPage();
	}

	@Then("AssignProduct page of administartor tab is rendered correctly")
	public void thenAssignProductPageOfAdministartorTabIsRenderedCorrectly() {
		uiVerificationAdministrationWorkflow.traverseAdministrationAssignProductPage();
	}

	@Then("AssignServiceCode page of administartor tab is rendered correctly")
	public void thenAssignServiceCodePageOfAdministartorTabIsRenderedCorrectly() {
		uiVerificationAdministrationWorkflow.traverseAdministrationAssignServiceCodePage();
	}

	@Then("AuditConfiguration page of administartor tab is rendered correctly")
	public void thenAuditConfigurationPageOfAdministartorTabIsRenderedCorrectly() {
		uiVerificationAdministrationWorkflow.traverseAdministrationAuditConfigurationPage();
	}

	@Then("BatchDefinition page of administartor tab is rendered correctly")
	public void thenBatchDefinitionPageOfAdministartorTabIsRenderedCorrectly() {
		uiVerificationAdministrationWorkflow.traverseAdministrationBatchDefinitionPage();
	}

	@Then("BatchLevel page of administartor tab is rendered correctly")
	public void thenBatchLevelPageOfAdministartorTabIsRenderedCorrectly() {
		uiVerificationAdministrationWorkflow.traverseAdministrationBatchLevelPage();
	}

	@Then("EnableMakerChecker page of administartor tab is rendered correctly")
	public void thenEnableMakerCheckerPageOfAdministartorTabIsRenderedCorrectly() {
		uiVerificationAdministrationWorkflow.traverseAdministrationEnableMakerCheckerPage();
	}

	@Then("OperationalInquiry page of administartor tab is rendered correctly")
	public void thenOperationalInquiryPageOfAdministartorTabIsRenderedCorrectly() {
		uiVerificationAdministrationWorkflow.traverseAdministrationOperationalInquiryPage();
	}

	@Then("ReportLevel page of administartor tab is rendered correctly")
	public void thenReportLevelPageOfAdministartorTabIsRenderedCorrectly() {
		uiVerificationAdministrationWorkflow.traverseAdministrationReportLevelPage();
	}

	@Then("ResetPassword page of administartor tab is rendered correctly")
	public void thenResetPasswordPageOfAdministartorTabIsRenderedCorrectly() {
		uiVerificationAdministrationWorkflow.traverseAdministrationResetPasswordPage();
	}

	@Then("Role page of administartor tab is rendered correctly")
	public void thenRolePageOfAdministartorTabIsRenderedCorrectly() {
		uiVerificationAdministrationWorkflow.traverseAdministrationRolePage();
	}

	@Then("ScreenLevel page of administartor tab is rendered correctly")
	public void thenScreenLevelPageOfAdministartorTabIsRenderedCorrectly() {
		uiVerificationAdministrationWorkflow.traverseAdministrationScreenLevelPage();
	}

	@Then("UserGroups page of administartor tab is rendered correctly")
	public void thenUserGroupsPageOfAdministartorTabIsRenderedCorrectly() {
		uiVerificationAdministrationWorkflow.traverseAdministrationUserGroupsPage();
	}

	@Then("UserManagementReport page of administartor tab is rendered correctly")
	public void thenUserManagementReportPageOfAdministartorTabIsRenderedCorrectly() {
		uiVerificationAdministrationWorkflow.traverseAdministrationUserManagementReportPage();
	}

	@Then("User page of administartor tab is rendered correctly")
	public void thenUserPageOfAdministartorTabIsRenderedCorrectly() {
		uiVerificationAdministrationWorkflow.traverseAdministrationUserPage();
	}

	@Then("DeviceStatus page of card management tab is rendered correctly")
	public void thenDeviceStatusPageOfCardManagementTabIsRenderedCorrectly() {
		uiVerificationCardManagementWorkflow.verifyDeviceStatusPage();
	}

	@Then("user signs out from customer portal")
	public void signOutFromPortal() {
		loginWorkflow.signOutCustomer();
	}	
	
}