package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ApplicationBusinessMandatoryFields;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ApplicationDocumentChecklist;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditCardBillingCycle;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditCardCreditPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditCardPaymentBounceReason;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditCardPaymentPriority;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditCardTransactionRulePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DedupePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceEventBasedFeePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceJoiningAndMemberShipFeePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePriorityPassIDAndCardPackIDTemplate;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceRange;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MCCRulePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MarketingMessagePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PrepaidStatementPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.StatementMessagePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionFeePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionLimitPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WalletFeePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WalletPlan;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.ApplicationBusinessMandatoryFieldsPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.ApplicationDocumentChecklistPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.CreditCardBillingCyclePage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.CreditCardCreditPlanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.CreditCardPaymentBounceReasonPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.CreditCardPaymentPriorityPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.CreditCardTransactionRulePlanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DedupePlanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceEventBasedFeePlanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceJoiningAndMembershipFeePlanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DevicePlanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DevicePriorityPassIDAndCardPackIDTemplatePage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceRangePage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.MCCRulePlanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.MarketingMessagePlanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.PrepaidStatementPlanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.ProgramPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.StatementMessagePlanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.TransactionFeePlanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.TransactionLimitPlanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.TransactionPlanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.WalletConfigurationWalletFeePlanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.WalletConfigurationWalletPlanPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class ProgramSetupWorkflow {
	
	@Autowired
	private Navigator navigator;
    @Autowired
    private TestContext context;
    private static final Logger logger = LoggerFactory.getLogger(ProgramSetupWorkflow.class);
	public void createStatementMessagePlan(StatementMessagePlan statementMessagePlan) {
		StatementMessagePlanPage page = navigator.navigateToPage(StatementMessagePlanPage.class);
		page.createStatementMessagePlan(statementMessagePlan);
	}

	public void createMarketingMessagePlan(MarketingMessagePlan marketingMessagePlan) {
		MarketingMessagePlanPage page = navigator.navigateToPage(MarketingMessagePlanPage.class);
		page.createMarketingMessagePlan(marketingMessagePlan);
	}

	//Transaction Limit Plan
	public void createTransactionLimitPlan(TransactionLimitPlan transactionLimitPlan) {
		TransactionLimitPlanPage page = navigator.navigateToPage(TransactionLimitPlanPage.class);
		page.createTransactionLimitPlan(transactionLimitPlan);
	}
	//Transaction Limit Plan ends
	
	//Device configuration
	public void createDeviceJoiningAndMemberShipFeePlan(DeviceJoiningAndMemberShipFeePlan deviceJoiningAndMemberShipFeePlan) {
		DeviceJoiningAndMembershipFeePlanPage page = navigator.navigateToPage(DeviceJoiningAndMembershipFeePlanPage.class);
		page.createDeviceJoiningOrMembershipFeePlan(deviceJoiningAndMemberShipFeePlan);
	}
	
	public void createDeviceEventBasedFeePlan(DeviceEventBasedFeePlan deviceEventBasedFeePlan) {
		DeviceEventBasedFeePlanPage page = navigator.navigateToPage(DeviceEventBasedFeePlanPage.class);
		page.createDeviceEventBasedFeePlan(deviceEventBasedFeePlan);
	}
	
	public String createCardPackIDTemplate(DevicePriorityPassIDAndCardPackIDTemplate template) {
		DevicePriorityPassIDAndCardPackIDTemplatePage page = navigator.navigateToPage(DevicePriorityPassIDAndCardPackIDTemplatePage.class);
		String code = page.createCardPackIDTemplate(template);
		template.setCode(code);
		return code;
	}
	
	public String createDeviceTemplate(DevicePriorityPassIDAndCardPackIDTemplate template) {
		DevicePriorityPassIDAndCardPackIDTemplatePage page = navigator.navigateToPage(DevicePriorityPassIDAndCardPackIDTemplatePage.class);
		String code = page.createDeviceTemplate(template);
		template.setCode(code);
		return code;
	}
	
	public String createPriorityPassID(DevicePriorityPassIDAndCardPackIDTemplate template) {
		DevicePriorityPassIDAndCardPackIDTemplatePage page = navigator.navigateToPage(DevicePriorityPassIDAndCardPackIDTemplatePage.class);
		String code = page.createPriorityPassID(template);
		template.setCode(code);
		return code;
	}
	
	public void createDevicePlan(DevicePlan devicePlan) {
		DevicePlanPage page = navigator.navigateToPage(DevicePlanPage.class);
		page.createDevicePlan(devicePlan);
	}
	// Device configuration ends
	
	public void uncheckCVCCVVDevicePlan(DevicePlan devicePlan) {
		DevicePlanPage page = navigator.navigateToPage(DevicePlanPage.class);
		page.updateCVCCVVDevicePlan(devicePlan);
	}
	// Device configuration ends
	
	public void fillDocumentChecklist(ApplicationDocumentChecklist  applicationDocumentChecklist) {
		ApplicationDocumentChecklistPage page = navigator.navigateToPage(ApplicationDocumentChecklistPage.class);
		page.addDocumentsInDocumentsChecklist(applicationDocumentChecklist);
	}
	
	public void fillBusinessMandatoryFields(ApplicationBusinessMandatoryFields  applicationBusinessMandatoryFields) {
		ApplicationBusinessMandatoryFieldsPage page = navigator.navigateToPage(ApplicationBusinessMandatoryFieldsPage.class);
		page.addBusinessMandatoryFields(applicationBusinessMandatoryFields);
	}
	
	public void fillCreditCardBillingCycle(CreditCardBillingCycle creditCardBillingCycle)
	{
		CreditCardBillingCyclePage page = navigator.navigateToPage(CreditCardBillingCyclePage.class);
		Boolean billingCycleStatus=page.addBillingCycle(creditCardBillingCycle);
		logger.info("billingCycleStatus : {} ", billingCycleStatus);
		context.put(CreditConstants.BILLING_CYCLE_CODE_ERROR_STATUS,billingCycleStatus);
	}
	
	public void fillCreditCardPaymentPriority(CreditCardPaymentPriority creditCardPaymentPriority)
	{
		CreditCardPaymentPriorityPage page = navigator.navigateToPage(CreditCardPaymentPriorityPage.class);
		Boolean paymentPriorityStatus=page.addPaymentPriority(creditCardPaymentPriority);
		logger.info("paymentPriorityStatus : {} ", paymentPriorityStatus);
		context.put(CreditConstants.PAYMENT_PRIORITY_STATUS,paymentPriorityStatus);
	}
	
	public void fillCreditCardPaymentBounceReason(CreditCardPaymentBounceReason creditCardPaymentBounceReason)
	{
		CreditCardPaymentBounceReasonPage page = navigator.navigateToPage(CreditCardPaymentBounceReasonPage.class);
		Boolean paymentBounceStatus=page.addPaymentBounceReason(creditCardPaymentBounceReason);
		logger.info("paymentBounceStatus : {} ", paymentBounceStatus);
		context.put(CreditConstants.PAYMENT_BOUNCE_STATUS,paymentBounceStatus);
	}

	public void fillCreditCardTransactionRulePlancode(CreditCardTransactionRulePlan creditCardTransactionRulePlancode)
	{
		CreditCardTransactionRulePlanPage page = navigator.navigateToPage(CreditCardTransactionRulePlanPage.class);
		Boolean transactionPlanStatus=page.addTransactionRulePlan(creditCardTransactionRulePlancode);
		logger.info("transactionPlanStatus : {} ", transactionPlanStatus);
		context.put(CreditConstants.TRANSACTION_PLAN_ERROR_STATUS, transactionPlanStatus);
	}
	
	public void fillCreditCardCreditPlan(CreditCardCreditPlan creditCardCreditPlan)
	{
		CreditCardCreditPlanPage page = navigator.navigateToPage(CreditCardCreditPlanPage.class);
		Boolean creditPlanStatus=page.addCreditPlan(creditCardCreditPlan);
		logger.info("creditPlanStatus : {} ", creditPlanStatus);
		context.put(CreditConstants.CREDIT_PLAN_CODE_ERROR_STATUS, creditPlanStatus);
	}
	
	public void createDedupePlan(DedupePlan dedupePlan){
		DedupePlanPage page = navigator.navigateToPage(DedupePlanPage.class);
		page.addDedupePlanData(dedupePlan);
	}
	
	public void createWalletFeePlan(WalletFeePlan walletFeePlan, String productType) {
		WalletConfigurationWalletFeePlanPage page = navigator.navigateToPage(WalletConfigurationWalletFeePlanPage.class);
		page.addWalletFeePlan(walletFeePlan, productType);
	}

	public void createWalletPlan(WalletPlan walletPlan) {
		WalletConfigurationWalletPlanPage page = navigator.navigateToPage(WalletConfigurationWalletPlanPage.class);
		page.addWalletPlanData(walletPlan);
	}
	
	public void createNewWalletPlan(WalletPlan walletPlan) {
		WalletConfigurationWalletPlanPage page = navigator.navigateToPage(WalletConfigurationWalletPlanPage.class);
		page.addNewWalletPlanData(walletPlan);		
	}

	public void createProgram(Program program, String productType ) {
		ProgramPage page = navigator.navigateToPage(ProgramPage.class);
		page.addProgramData(program, productType);
	}
	
	public void createNewProgram(Program program, String productType ) {
		ProgramPage page = navigator.navigateToPage(ProgramPage.class);
		page.addProgramForMultiWallet(program, productType);
	}
	
	public void createAddProgram(Program program, String productType ) {
		ProgramPage page = navigator.navigateToPage(ProgramPage.class);
		page.addsProgramData(program, productType);
	}
	
	public void createDeviceRange(DeviceRange deviceRange) {
		DeviceRangePage page = navigator.navigateToPage(DeviceRangePage.class);
		page.addDeviceRangeData(deviceRange);
	}
	
	public void createPrepaidStatementPlan(PrepaidStatementPlan plan) {
		PrepaidStatementPlanPage page = navigator.navigateToPage(PrepaidStatementPlanPage.class);
		page.createPrepaidStatementPlan(plan);
	}

	public void createTransactionPlan(TransactionPlan plan) {
		TransactionPlanPage page = navigator.navigateToPage(TransactionPlanPage.class);
		page.createTransactionPlan(plan);
	}

	public void createTransactionFeePlan(TransactionFeePlan plan) {
		TransactionFeePlanPage page = navigator.navigateToPage(TransactionFeePlanPage.class);
		page.addTransactionFeePlanMasterDetail(plan);
	}

	public void createMCCRulePlan(MCCRulePlan plan) {
		MCCRulePlanPage page = navigator.navigateToPage(MCCRulePlanPage.class);
		page.createMCCRulePlanPage(plan);
	}
	
	public void editMCCRulePlan(MCCRulePlan plan) {
		MCCRulePlanPage page = navigator.navigateToPage(MCCRulePlanPage.class);
		page.editMCCRulePlanPage(plan);
	}
}
