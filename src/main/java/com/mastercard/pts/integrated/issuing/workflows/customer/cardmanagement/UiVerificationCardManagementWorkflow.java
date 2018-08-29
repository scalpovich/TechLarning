package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.*;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;


@Workflow
public class UiVerificationCardManagementWorkflow {

	@Autowired
	private Navigator navigator;

	public void verifyAccountFilePage() {
		AccountFilePage page = navigator.navigateToPage(AccountFilePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyAccountRangeRoutingPage() {
		AccountRangeRoutingPage page = navigator.navigateToPage(AccountRangeRoutingPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyAccountTypePage() {
		AccountTypePage page = navigator.navigateToPage(AccountTypePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyAddMpePage() {
		AddMpePage page = navigator.navigateToPage(AddMpePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyAdjustmentTransactionPage() {
		AdjustmentTransactionPage page = navigator.navigateToPage(AdjustmentTransactionPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyAdministartivePage() {
		AdministartivePage page = navigator.navigateToPage(AdministartivePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyApplicationBatchDetailsPage() {
		ApplicationBatchDetailsPage page = navigator.navigateToPage(ApplicationBatchDetailsPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyApplicationBusinessMandatoryFieldsPage() {
		ApplicationBusinessMandatoryFieldsPage page = navigator.navigateToPage(ApplicationBusinessMandatoryFieldsPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyApplicationDetailsPage() {
		ApplicationDetailsPage page = navigator.navigateToPage(ApplicationDetailsPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyApplicationDocumentChecklistPage() {
		ApplicationDocumentChecklistPage page = navigator.navigateToPage(ApplicationDocumentChecklistPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyApplicationPage() {
		ApplicationPage page = navigator.navigateToPage(ApplicationPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyApplicationScoringPage() {
		navigator.navigateToPage(ApplicationScoringPage.class);
	}

	public void verifyApprovalScorePage() {
		ApprovalScorePage page = navigator.navigateToPage(ApprovalScorePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyApproveRejectPage() {
		ApproveRejectPage page = navigator.navigateToPage(ApproveRejectPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyAuthorizationRequestPage() {
		AuthorizationRequestPage page = navigator.navigateToPage(AuthorizationRequestPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyAuthorizationSearchPage() {
		AuthorizationSearchPage page = navigator.navigateToPage(AuthorizationSearchPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyAutoDebitPage() {
		AutoDebitPage page = navigator.navigateToPage(AutoDebitPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyBalancePage() {
		BalancePage page = navigator.navigateToPage(BalancePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyBatchJobHistoryPage() {
		BatchJobHistoryPage page = navigator.navigateToPage(BatchJobHistoryPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyBatchProcessingPage() {
		BatchProcessingPage page = navigator.navigateToPage(BatchProcessingPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyBatchTraceHistoryPage() {
		BatchTraceHistoryPage page = navigator.navigateToPage(BatchTraceHistoryPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyBillingCyclePage() {
		BillingCyclePage page = navigator.navigateToPage(BillingCyclePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyBillingReportsPage() {
		BillingReportsPage page = navigator.navigateToPage(BillingReportsPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyBulkDeviceGenerationBatchPage() {
		BulkDeviceGenerationBatchPage page = navigator.navigateToPage(BulkDeviceGenerationBatchPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyBusinessCalendarPage() {
		BusinessCalendarPage page = navigator.navigateToPage(BusinessCalendarPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyBusinessMandatoryFieldsPage() {
		BusinessMandatoryFieldsPage page = navigator.navigateToPage(BusinessMandatoryFieldsPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyCardFeesPage() {
		CardFeesPage page = navigator.navigateToPage(CardFeesPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyCarrierAcknowledgementPage() {
		CarrierAcknowledgementPage page = navigator.navigateToPage(CarrierAcknowledgementPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyCashPage() {
		CashPage page = navigator.navigateToPage(CashPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyClassificationPage() {
		ClassificationPage page = navigator.navigateToPage(ClassificationPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyClientDetailsPage() {
		ClientDetailsPage page = navigator.navigateToPage(ClientDetailsPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyClientPortfolioPage() {
		ClientPortfolioPage page = navigator.navigateToPage(ClientPortfolioPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyCloseBatchPage() {
		navigator.navigateToPage(CloseBatchPage.class);
	}

	public void verifyCollectionBatchProcessPage() {
		navigator.navigateToPage(CollectionBatchProcessPage.class);
	}

	public void verifyComplianceReportsPage() {
		ComplianceReportsPage page = navigator.navigateToPage(ComplianceReportsPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyCorporateReportsPage() {
		CorporateReportsPage page = navigator.navigateToPage(CorporateReportsPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyCountryWhiteListBlackListPlanPage() {
		CountryWhiteListBlackListPlanPage page = navigator.navigateToPage(CountryWhiteListBlackListPlanPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyCreateCorporatePage() {
		CreateCorporatePage page = navigator.navigateToPage(CreateCorporatePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyCreditBureauVerificationPage() {
		navigator.navigateToPage(CreditBureauVerificationPage.class);
	}

	public void verifyCreditCardBillingCyclePage() {
		CreditCardBillingCyclePage page = navigator.navigateToPage(CreditCardBillingCyclePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyCreditCardCreditPlanPage() {
		CreditCardCreditPlanPage page = navigator.navigateToPage(CreditCardCreditPlanPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyCreditCardPaymentBounceReasonPage() {
		CreditCardPaymentBounceReasonPage page = navigator.navigateToPage(CreditCardPaymentBounceReasonPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyCreditCardPaymentPriorityPage() {
		CreditCardPaymentPriorityPage page = navigator.navigateToPage(CreditCardPaymentPriorityPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyCreditCardTransactionRulePlanPage() {
		CreditCardTransactionRulePlanPage page = navigator.navigateToPage(CreditCardTransactionRulePlanPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyCreditLimitRulePage() {
		CreditLimitRulePage page = navigator.navigateToPage(CreditLimitRulePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyCreditPlanPage() {
		CreditPlanPage page = navigator.navigateToPage(CreditPlanPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyCurrencyBlackListPlanPage() {
		CurrencyBlackListPlanPage page = navigator.navigateToPage(CurrencyBlackListPlanPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyCurrencyExchangeRatesMappingPage() {
		CurrencyExchangeRatesMappingPage page = navigator.navigateToPage(CurrencyExchangeRatesMappingPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyCurrencyExchangeRatesPage() {
		CurrencyExchangeRatesPage page = navigator.navigateToPage(CurrencyExchangeRatesPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyCutoverProfilePage() {
		CutoverProfilePage page = navigator.navigateToPage(CutoverProfilePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyDedupePlanPage() {
		DedupePlanPage page = navigator.navigateToPage(DedupePlanPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyDeDupeSDNVerificationPage() {
		DeDupeSDNVerificationPage page = navigator.navigateToPage(DeDupeSDNVerificationPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyDeviceActivityPage() {
		DeviceActivityPage page = navigator.navigateToPage(DeviceActivityPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyDeviceBinPage() {
		DeviceBinPage page = navigator.navigateToPage(DeviceBinPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyDeviceCreateDevicePage() {
		DeviceCreateDevicePage page = navigator.navigateToPage(DeviceCreateDevicePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyDeviceDeDupeSDNVerificationPage() {
		DeviceDeDupeSDNVerificationPage page = navigator.navigateToPage(DeviceDeDupeSDNVerificationPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyDeviceDetailsPage() {
		DeviceDetailsPage page = navigator.navigateToPage(DeviceDetailsPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyDeviceEventBasedFeePlanPage() {
		DeviceEventBasedFeePlanPage page = navigator.navigateToPage(DeviceEventBasedFeePlanPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyDeviceGenerationPage() {
		navigator.navigateToPage(DeviceGenerationPage.class);
	}

	public void verifyDeviceJoiningAndMembershipFeePlanPage() {
		DeviceJoiningAndMembershipFeePlanPage page = navigator.navigateToPage(DeviceJoiningAndMembershipFeePlanPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyDeviceKeysPage() {
		DeviceKeysPage page = navigator.navigateToPage(DeviceKeysPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyDevicePlanPage() {
		DevicePlanPage page = navigator.navigateToPage(DevicePlanPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyDevicePriorityPassIDAndCardPackIDTemplatePage() {
		DevicePriorityPassIDAndCardPackIDTemplatePage page = navigator.navigateToPage(DevicePriorityPassIDAndCardPackIDTemplatePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyDeviceProductionBatchPage() {
		DeviceProductionBatchPage page = navigator.navigateToPage(DeviceProductionBatchPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyDeviceProductionBulkDeviceRequestPage() {
		DeviceProductionBulkDeviceRequestPage page = navigator.navigateToPage(DeviceProductionBulkDeviceRequestPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyDeviceProductionCancellationPage() {
		DeviceProductionCancellationPage page = navigator.navigateToPage(DeviceProductionCancellationPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyDevicePromotionPlanPage() {
		DevicePromotionPlanPage page = navigator.navigateToPage(DevicePromotionPlanPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyDeviceRangePage() {
		DeviceRangePage page = navigator.navigateToPage(DeviceRangePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyDeviceTrackingPage() {
		DeviceTrackingPage page = navigator.navigateToPage(DeviceTrackingPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyDeviceUsagePage() {
		DeviceUsagePage page = navigator.navigateToPage(DeviceUsagePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyDocumentChecklistPage() {
		DocumentChecklistPage page = navigator.navigateToPage(DocumentChecklistPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyEasyPayPlanRulePage() {
		EasyPayPlanRulePage page = navigator.navigateToPage(EasyPayPlanRulePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyEasyPayPlanVerificationBatchPage() {
		EasyPayPlanVerificationBatchPage page = navigator.navigateToPage(EasyPayPlanVerificationBatchPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyEmbossingPINAndPriorityPassFileNameParameterPage() {
		EmbossingPINAndPriorityPassFileNameParameterPage page = navigator.navigateToPage(EmbossingPINAndPriorityPassFileNameParameterPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyEmbossingPINAndPriorityPassFileTemplatePage() {
		EmbossingPINAndPriorityPassFileTemplatePage page = navigator.navigateToPage(EmbossingPINAndPriorityPassFileTemplatePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyEMIReportsPage() {
		EMIReportsPage page = navigator.navigateToPage(EMIReportsPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyEventAlertHistoryPage() {
		EventAlertHistoryPage page = navigator.navigateToPage(EventAlertHistoryPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyEventAndAlertPage() {
		EventAndAlertPage page = navigator.navigateToPage(EventAndAlertPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyEventsAndAlertsPage() {
		EventsAndAlertsPage page = navigator.navigateToPage(EventsAndAlertsPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyExceptionFileMessagePage() {
		ExceptionFileMessagePage page = navigator.navigateToPage(ExceptionFileMessagePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyFeeCollectionPage() {
		FeeCollectionPage page = navigator.navigateToPage(FeeCollectionPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyFeeReasonPage() {
		FeeReasonPage page = navigator.navigateToPage(FeeReasonPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyFinancialReportsPage() {
		FinancialReportsPage page = navigator.navigateToPage(FinancialReportsPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyFixedScorePage() {
		FixedScorePage page = navigator.navigateToPage(FixedScorePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyFraudNotificationTC40Page() {
		FraudNotificationTC40Page page = navigator.navigateToPage(FraudNotificationTC40Page.class);
		page.verifyUiOperationStatus();
	}

	public void verifyFraudWriteOffPage() {
		FraudWriteOffPage page = navigator.navigateToPage(FraudWriteOffPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyGatewayConfigurationPage() {
		GatewayConfigurationPage page = navigator.navigateToPage(GatewayConfigurationPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyGenerateReversalPage() {
		GenerateReversalPage page = navigator.navigateToPage(GenerateReversalPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyGLAccountHeadPage() {
		GLAccountHeadPage page = navigator.navigateToPage(GLAccountHeadPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyHighRiskCountryPage() {
		HighRiskCountryPage page = navigator.navigateToPage(HighRiskCountryPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyHighRiskMCCPage() {
		HighRiskMCCPage page = navigator.navigateToPage(HighRiskMCCPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyHighRiskMCGPage() {
		HighRiskMCGPage page = navigator.navigateToPage(HighRiskMCGPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyHighRiskMerchantLocationPage() {
		HighRiskMerchantLocationPage page = navigator.navigateToPage(HighRiskMerchantLocationPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyHolidayConfigurationPage() {
		HolidayConfigurationPage page = navigator.navigateToPage(HolidayConfigurationPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyIncompleteApplicationPage() {
		IncompleteApplicationPage page = navigator.navigateToPage(IncompleteApplicationPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyInitiateVisaMoneyTransferPage() {
		InitiateVisaMoneyTransferPage page = navigator.navigateToPage(InitiateVisaMoneyTransferPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyInstitutionCurrencyPage() {
		InstitutionCurrencyPage page = navigator.navigateToPage(InstitutionCurrencyPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyInstitutionLoadCurrencyPage() {
		InstitutionLoadCurrencyPage page = navigator.navigateToPage(InstitutionLoadCurrencyPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyInterestRatePlanPage() {
		InterestRatePlanPage page = navigator.navigateToPage(InterestRatePlanPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyInternalRatingPage() {
		InternalRatingPage page = navigator.navigateToPage(InternalRatingPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyInvalidChequeReasonPage() {
		InvalidChequeReasonPage page = navigator.navigateToPage(InvalidChequeReasonPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyIssuerPublicKeyIPKCertificateInformationPage() {
		IssuerPublicKeyIPKCertificateInformationPage page = navigator.navigateToPage(IssuerPublicKeyIPKCertificateInformationPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyLatePaymentFeePlanPage() {
		LatePaymentFeePlanPage page = navigator.navigateToPage(LatePaymentFeePlanPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyLinkingAPIToInstitutionPage() {
		LinkingAPIToInstitutionPage page = navigator.navigateToPage(LinkingAPIToInstitutionPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyLoanAccountDetailsPage() {
		LoanAccountDetailsPage page = navigator.navigateToPage(LoanAccountDetailsPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyLoanApprovalRetailTransactionToLoanPage() {
		LoanApprovalRetailTransactionToLoanPage page = navigator.navigateToPage(LoanApprovalRetailTransactionToLoanPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyLoanCancellationPage() {
		LoanCancellationPage page = navigator.navigateToPage(LoanCancellationPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyLoanPlanPage() {
		LoanPlanPage page = navigator.navigateToPage(LoanPlanPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyLoanPreClosurePage() {
		LoanPreClosurePage page = navigator.navigateToPage(LoanPreClosurePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyLoanTypePage() {
		LoanTypePage page = navigator.navigateToPage(LoanTypePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyLocalChequePage() {
		LocalChequePage page = navigator.navigateToPage(LocalChequePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyManualAlertsPage() {
		ManualAlertsPage page = navigator.navigateToPage(ManualAlertsPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyMarketingMessagePlanPage() {
		MarketingMessagePlanPage page = navigator.navigateToPage(MarketingMessagePlanPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyMarkupFeePlanPage() {
		MarkupFeePlanPage page = navigator.navigateToPage(MarkupFeePlanPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyMasterDerivationKeysPage() {
		MasterDerivationKeysPage page = navigator.navigateToPage(MasterDerivationKeysPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyMCCOverlimitPage() {
		MCCOverlimitPage page = navigator.navigateToPage(MCCOverlimitPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyMCCRulePlanPage() {
		MCCRulePlanPage page = navigator.navigateToPage(MCCRulePlanPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyMCGAdditionalHoldPlanPage() {
		MCGAdditionalHoldPlanPage page = navigator.navigateToPage(MCGAdditionalHoldPlanPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyMCGLimitPlanPage() {
		MCGLimitPlanPage page = navigator.navigateToPage(MCGLimitPlanPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyMemberFundCollectionAndFundDisbursementPage() {
		MemberFundCollectionAndFundDisbursementPage page = navigator.navigateToPage(MemberFundCollectionAndFundDisbursementPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyMerchantCategoryGroupMCGPage() {
		MerchantCategoryGroupMCGPage page = navigator.navigateToPage(MerchantCategoryGroupMCGPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyMiscellaneousFeePage() {
		MiscellaneousFeePage page = navigator.navigateToPage(MiscellaneousFeePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyMoneySendPage() {
		MoneySendPage page = navigator.navigateToPage(MoneySendPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyNetworkKeysPage() {
		NetworkKeysPage page = navigator.navigateToPage(NetworkKeysPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyNetworkMembershipPage() {
		NetworkMembershipPage page = navigator.navigateToPage(NetworkMembershipPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyNewApplicationPage() {
		NewApplicationPage page = navigator.navigateToPage(NewApplicationPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyNewDevicePage() {
		NewDevicePage page = navigator.navigateToPage(NewDevicePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyOfficePage() {
		OfficePage page = navigator.navigateToPage(OfficePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyOtherTransactionsPage() {
		OtherTransactionsPage page = navigator.navigateToPage(OtherTransactionsPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyOutstationChequeCollectionPage() {
		OutstationChequeCollectionPage page = navigator.navigateToPage(OutstationChequeCollectionPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyOutstationChequeProcessingPage() {
		OutstationChequeProcessingPage page = navigator.navigateToPage(OutstationChequeProcessingPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyOverridePage() {
		OverridePage page = navigator.navigateToPage(OverridePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyPaymentBounceReasonPage() {
		PaymentBounceReasonPage page = navigator.navigateToPage(PaymentBounceReasonPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyPaymentPriorityPage() {
		PaymentPriorityPage page = navigator.navigateToPage(PaymentPriorityPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyPictureCodePage() {
		PictureCodePage page = navigator.navigateToPage(PictureCodePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyPinGenerationBatchPage() {
		PinGenerationBatchPage page = navigator.navigateToPage(PinGenerationBatchPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyPinRePrintPage() {
		PinRePrintPage page = navigator.navigateToPage(PinRePrintPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyPlasticCodePage() {
		PlasticCodePage page = navigator.navigateToPage(PlasticCodePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyPrepaidStatementPlanPage() {
		PrepaidStatementPlanPage page = navigator.navigateToPage(PrepaidStatementPlanPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyPreProductionBatchPage() {
		PreProductionBatchPage page = navigator.navigateToPage(PreProductionBatchPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyProcessBatchesPage() {
		navigator.navigateToPage(ProcessBatchesPage.class);
	}

	public void verifyProgramChangeRulePage() {
		ProgramChangeRulePage page = navigator.navigateToPage(ProgramChangeRulePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyProgramChangeSchemePage() {
		ProgramChangeSchemePage page = navigator.navigateToPage(ProgramChangeSchemePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyProgramPage() {
		ProgramPage page = navigator.navigateToPage(ProgramPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyRAMPReportPage() {
		RAMPReportPage page = navigator.navigateToPage(RAMPReportPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyReceiveFromPersonalisationVendorPage() {
		ReceiveFromPersonalisationVendorPage page = navigator.navigateToPage(ReceiveFromPersonalisationVendorPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyReferPage() {
		ReferPage page = navigator.navigateToPage(ReferPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyReplaceUpgradeDevicePage() {
		navigator.navigateToPage(ReplaceUpgradeDevicePage.class);

	}

	public void verifyResendPINRequestPage() {
		ResendPINRequestPage page = navigator.navigateToPage(ResendPINRequestPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyReSendToPersonalizationVendorPage() {
		ReSendToPersonalizationVendorPage page = navigator.navigateToPage(ReSendToPersonalizationVendorPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyReversalTransactionPage() {
		ReversalTransactionPage page = navigator.navigateToPage(ReversalTransactionPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyRiskAnalysisPage() {
		navigator.navigateToPage(RiskAnalysisPage.class);
	}

	public void verifyRiskAnalysisRulePage() {
		RiskAnalysisRulePage page = navigator.navigateToPage(RiskAnalysisRulePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyRuPayBINRangePage() {
		RuPayBINRangePage page = navigator.navigateToPage(RuPayBINRangePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyRupaySettlementBINPage() {
		RupaySettlementBINPage page = navigator.navigateToPage(RupaySettlementBINPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifySafeUpdatePage() {
		SafeUpdatePage page = navigator.navigateToPage(SafeUpdatePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifySendToCarrierPage() {
		SendToCarrierPage page = navigator.navigateToPage(SendToCarrierPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifySettledTransactionPage() {
		SettledTransactionPage page = navigator.navigateToPage(SettledTransactionPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyStatementMessagePlanPage() {
		StatementMessagePlanPage page = navigator.navigateToPage(StatementMessagePlanPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyStopDeviceRenewalPage() {
		StopDeviceRenewalPage page = navigator.navigateToPage(StopDeviceRenewalPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyStopDeviceReplacePage() {
		StopDeviceReplacePage page = navigator.navigateToPage(StopDeviceReplacePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyStopListBinPage() {
		StopListBinPage page = navigator.navigateToPage(StopListBinPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyStopListCountryPage() {
		StopListCountryPage page = navigator.navigateToPage(StopListCountryPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyStopListDevicePage() {
		StopListDevicePage page = navigator.navigateToPage(StopListDevicePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyStopListDeviceRangePage() {
		StopListDeviceRangePage page = navigator.navigateToPage(StopListDeviceRangePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyStopListPage() {
		StopListPage page = navigator.navigateToPage(StopListPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyStoplistReasonPage() {
		StoplistReasonPage page = navigator.navigateToPage(StoplistReasonPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifySurchargePlanPage() {
		SurchargePlanPage page = navigator.navigateToPage(SurchargePlanPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifySurchargeWailverPlanPage() {
		SurchargeWaiverPlanPage page = navigator.navigateToPage(SurchargeWaiverPlanPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifySystemCodesPage() {
		SystemCodesPage page = navigator.navigateToPage(SystemCodesPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyTaxOnIncomePage() {
		TaxOnIncomePage page = navigator.navigateToPage(TaxOnIncomePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyTermPage() {
		TermPage page = navigator.navigateToPage(TermPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyThreeDECommerceSecurityParametersPage() {
		ThreeDECommerceSecurityParametersPage page = navigator.navigateToPage(ThreeDECommerceSecurityParametersPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyTransactionFeePlanPage() {
		TransactionFeePlanPage page = navigator.navigateToPage(TransactionFeePlanPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyTransactionFeeWaiverPlanPage() {
		TransactionFeeWaiverPlanPage page = navigator.navigateToPage(TransactionFeeWaiverPlanPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyTransactionLimitPlanPage() {
		TransactionLimitPlanPage page = navigator.navigateToPage(TransactionLimitPlanPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyTransactionPlanPage() {
		TransactionPlanPage page = navigator.navigateToPage(TransactionPlanPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyTransactionRegistrationPage() {
		TransactionRegistrationPage page = navigator.navigateToPage(TransactionRegistrationPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyTransactionReportsPage() {
		TransactionReportsPage page = navigator.navigateToPage(TransactionReportsPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyTransactionRoutingPage() {
		TransactionRoutingPage page = navigator.navigateToPage(TransactionRoutingPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyTransactionRulePlanPage() {
		TransactionRulePlanPage page = navigator.navigateToPage(TransactionRulePlanPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyTransactionSearchPage() {
		TransactionSearchPage page = navigator.navigateToPage(TransactionSearchPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyUnpaidPage() {
		UnpaidPage page = navigator.navigateToPage(UnpaidPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyUnsettledTransactionPage() {
		UnsettledTransactionPage page = navigator.navigateToPage(UnsettledTransactionPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyUpdateClientDetailsPage() {
		UpdateClientDetailsPage page = navigator.navigateToPage(UpdateClientDetailsPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyUpdateClientEventsPage() {
		UpdateClientEventsPage page = navigator.navigateToPage(UpdateClientEventsPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyUpdateDeviceDetailsPage() {
		UpdateDeviceDetailsPage page = navigator.navigateToPage(UpdateDeviceDetailsPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyUpdateWalletDetailsPage() {
		UpdateWalletDetailsPage page = navigator.navigateToPage(UpdateWalletDetailsPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyVariableScorePage() {
		VariableScorePage page = navigator.navigateToPage(VariableScorePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyVendorsPage() {
		VendorsPage page = navigator.navigateToPage(VendorsPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyVerifyPage() {
		VerifyCreditPage page = navigator.navigateToPage(VerifyCreditPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyVISABinRangePage() {
		VISABinRangePage page = navigator.navigateToPage(VISABinRangePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyVisaFeeCollectionPage() {
		VisaFeeCollectionPage page = navigator.navigateToPage(VisaFeeCollectionPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyVisaFraudNotificationPage() {
		VisaFraudNotificationPage page = navigator.navigateToPage(VisaFraudNotificationPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyWalletConfigurationWalletFeePlanPage() {
		WalletConfigurationWalletFeePlanPage page = navigator.navigateToPage(WalletConfigurationWalletFeePlanPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyWalletConfigurationWalletPlanPage() {
		WalletConfigurationWalletPlanPage page = navigator.navigateToPage(WalletConfigurationWalletPlanPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyWalletDetailsPage() {
		WalletDetailsPage page = navigator.navigateToPage(WalletDetailsPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyWalletFeePlanPage() {
		WalletFeePlanPage page = navigator.navigateToPage(WalletFeePlanPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyWalletPromotionPlanPage() {
		WalletPromotionPlanPage page = navigator.navigateToPage(WalletPromotionPlanPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyWhiteListedMerchantPlanPage() {
		WhiteListedMerchantPlanPage page = navigator.navigateToPage(WhiteListedMerchantPlanPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyWithdrawBinPage() {
		WithdrawBinPage page = navigator.navigateToPage(WithdrawBinPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyWithdrawCountryPage() {
		WithdrawCountryPage page = navigator.navigateToPage(WithdrawCountryPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyWithdrawDevicePage() {
		WithdrawDevicePage page = navigator.navigateToPage(WithdrawDevicePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyWithdrawDeviceRangePage() {
		WithdrawDeviceRangePage page = navigator.navigateToPage(WithdrawDeviceRangePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyWorkflowRulePage() {
		WorkflowRulePage page = navigator.navigateToPage(WorkflowRulePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyDeviceStatusPage() {
		DeviceStatusPage page = navigator.navigateToPage(DeviceStatusPage.class);
		page.verifyUiOperationStatus();
	}
	
	}