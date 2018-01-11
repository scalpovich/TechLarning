package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ApplicationBusinessMandatoryFields;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ApplicationDocumentChecklist;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditCardBillingCycle;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditCardCreditPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DedupePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceEventBasedFeePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceEventBasedFeePlanDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceJoiningAndMemberShipFeePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceJoiningAndMemberShipFeePlanDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceRange;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MCCRulePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MarketingMessageDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MarketingMessagePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PrepaidStatementPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.StatementMessageDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.StatementMessagePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionLimitPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionLimitPlanDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WalletFeePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WalletFeePlanDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WalletPlan;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.ProgramSetupWorkflow;

@Component
public class ProgramSetupStepsForRegression {

	@Autowired
	private TestContext context;

	@Autowired
	private ProgramSetupWorkflow programSetupWorkflow;

	@Autowired
	private KeyValueProvider provider;

	@Autowired
	ProgramSetupSteps programSetupSteps;

	private DedupePlan dedupePlan;

	private StatementMessagePlan statementMessagePlan;

	private MarketingMessagePlan marketingMessagePlan;

	private PrepaidStatementPlan prepaidStatementPlan;

	private MCCRulePlan mccRulePlan;

	private DeviceJoiningAndMemberShipFeePlan deviceJoiningAndMemberShipFeePlan;

	private DeviceEventBasedFeePlan deviceEventBasedFeePlan;

	private TransactionPlan transactionPlan;

	private TransactionLimitPlan transactionLimitPlan;

	private WalletPlan walletPlan;

	private CreditCardCreditPlan creditCardCreditPlan;

	private CreditCardBillingCycle creditCardBillingCycle;

	private DevicePlan devicePlan;

	private Program program;

	private ApplicationDocumentChecklist documentCheckListPlan;
	
	private ApplicationBusinessMandatoryFields applicationBusinessMandatoryFields;

	@When("User filled Dedupe Plan")
	public void whenUserFilledDedupePlan() {
		dedupePlan = DedupePlan.createWithProvider(provider);
		programSetupWorkflow.createDedupePlan(dedupePlan);
	}

	@When("User filled Statement Message Plan for $type product")
	public void whenUserFilledStatementMessagePlanForProductType(String type) {
		statementMessagePlan = StatementMessagePlan.generateDynamicTestData();
		statementMessagePlan.setProductType(ProductType.fromShortName(type));

		StatementMessageDetails details = StatementMessageDetails.createWithProvider(provider);
		StatementMessageDetails detailsTemp = StatementMessageDetails.createWithProviderForDates(provider);
		details.setEffectiveDate(detailsTemp.getEffectiveDate());
		details.setEndDate(detailsTemp.getEndDate());
		statementMessagePlan.getStatementMessageDetails().add(details);

		programSetupWorkflow.createStatementMessagePlan(statementMessagePlan);
	}

	@When("User filled Marketing Message Plan for $type product")
	public void whenUserFilledMarketingMessagePlan(String type) {
		marketingMessagePlan = MarketingMessagePlan.generateDynamicTestData();
		marketingMessagePlan.setProductType(ProductType.fromShortName(type));

		MarketingMessageDetails details = MarketingMessageDetails.createWithProvider();
		MarketingMessageDetails detailsTemp = MarketingMessageDetails.createWithProviderForDates(provider);
		details.setEffectiveDate(detailsTemp.getEffectiveDate());
		details.setEndDate(detailsTemp.getEndDate());
		marketingMessagePlan.getMarketingMessageDetails().add(details);

		programSetupWorkflow.createMarketingMessagePlan(marketingMessagePlan);
	}

	@When("User filled MCC Rules for $type product")
	public void whenUserFilledMCCRules(String type) {
		mccRulePlan = MCCRulePlan.createWithProvider(provider);
		mccRulePlan.setProductType(ProductType.fromShortName(type));

		programSetupWorkflow.createMCCRulePlan(mccRulePlan);
	}

	@When("User filled Prepaid Statement Plan")
	public void whenUserFilledPrepaidStatementPlan() {
		programSetupSteps.whenUserFillsPrepaidStatementPlan();
	}

	@When("User filled Transaction Plan for $type product")
	public void whenUserFilledTransactionPlan(String type) {
		programSetupSteps.whenUserFillsTransactionPlan(type);
	}
	
	@When("User filled Transaction Limit Plan for $type product")
	public void whenUserFilledTransactionLimitPlan(String type) {
		transactionLimitPlan = TransactionLimitPlan.createWithProvider(provider);
		transactionLimitPlan.setIframeproductType(ProductType.fromShortName(type));
		TransactionLimitPlanDetails plan = TransactionLimitPlanDetails.createWithProvider(provider);
		TransactionLimitPlanDetails limitDetails = TransactionLimitPlanDetails.createWithProviderForLimits(provider);
		
		plan.setIframeDailyAmount(limitDetails.getIframeDailyAmount());
		plan.setIframeDailyResponse(limitDetails.getIframeDailyResponse());
		plan.setLimitDailyVelocity(limitDetails.getLimitDailyVelocity());
		plan.setLimitDailyVelocityResponse(limitDetails.getLimitDailyVelocityResponse());
		plan.setLimitPeriodicAmount(limitDetails.getLimitPeriodicAmount());
		plan.setLimitPeriodicAmountResponse(limitDetails.getLimitPeriodicAmountResponse());
		plan.setLimitPeriodicVelocity(limitDetails.getLimitPeriodicVelocity());
		plan.setLimitPeriodicVelocityResponse(limitDetails.getLimitPeriodicVelocityResponse());
		plan.setLimitYearlyAmount(limitDetails.getLimitYearlyAmount());
		plan.setLimitYearlyAmountResponse(limitDetails.getLimitYearlyAmountResponse());
		plan.setLimitYearlyVelocity(limitDetails.getLimitYearlyVelocity());
		plan.setLimitYearlyVelocityResponse(limitDetails.getLimitYearlyVelocityResponse());
		
		transactionLimitPlan.getTransactionLimitPlanDetails().add(plan);

		programSetupWorkflow.createTransactionLimitPlan(transactionLimitPlan);
	}

	@When("User filled Document Checklist Screen for $type product")
	public void whenUserFilledDocumentChecklistScreen(String type) {
		documentCheckListPlan = ApplicationDocumentChecklist.createWithProvider(provider);
		documentCheckListPlan.setProductType(ProductType.fromShortName(type));

		programSetupWorkflow.fillDocumentChecklist(documentCheckListPlan);
	}
	
	@When("User filled Device Joining and Membership Fee Plan for $type product")
	public void whenUserFilledDeviceJoiningAndMembershipFeePlan(String type) {
		deviceJoiningAndMemberShipFeePlan = DeviceJoiningAndMemberShipFeePlan.createWithProvider(provider);
		deviceJoiningAndMemberShipFeePlan.setProductType(ProductType.fromShortName(type));
		DeviceJoiningAndMemberShipFeePlanDetails details = DeviceJoiningAndMemberShipFeePlanDetails.createWithProvider(provider);

		deviceJoiningAndMemberShipFeePlan.getDeviceJoiningAndMemberShipFeePlanDetails().add(details);

		programSetupWorkflow.createDeviceJoiningAndMemberShipFeePlan(deviceJoiningAndMemberShipFeePlan);
	}
	
	@When("User filled Device Event Based Fee Plan for $type product")
	public void whenUserFilledDeviceEventBasedFeePlan(String type) {
		deviceEventBasedFeePlan = DeviceEventBasedFeePlan.createWithProvider(provider);
		deviceEventBasedFeePlan.setProductType(ProductType.fromShortName(type));
		DeviceEventBasedFeePlanDetails details = DeviceEventBasedFeePlanDetails.generateDynamicTestData();
		deviceEventBasedFeePlan.getDeviceEventBasedFeePlanDetails().add(details);

		programSetupWorkflow.createDeviceEventBasedFeePlan(deviceEventBasedFeePlan);
	}
	

	@When("User filled Device Plan for $type product")
	public void whenUserFilledDevicePlan(String type) {
		devicePlan = DevicePlan.createWithProviderForRegression(provider);
		devicePlan.setProductType(ProductType.fromShortName(type));
		devicePlan.setBaseDeviceJoiningMemberShipPlan(deviceJoiningAndMemberShipFeePlan.buildDescriptionAndCode());
		devicePlan.setBaseDeviceEventBasedPlan(deviceEventBasedFeePlan.buildDescriptionAndCode());
		/*
		 * Below two line code creates template count in DB, it reaches max
		 * count 999 on continuous script execution, fetching existing values
		 * through excel This can be used when need arises to execute script for
		 * template creation
		 * devicePlan.setCardPackIdGenerationTemplate(cardPackIDTemplate.buildDescriptionAndCode());
		 * devicePlan.setDeviceIdGenerationTemplate(deviceTemplate.buildDescriptionAndCode());
		 */
		devicePlan.setTransactionLimitPlan(transactionLimitPlan.buildDescriptionAndCode());
		devicePlan.setAfterKYC(transactionPlan.buildDescriptionAndCode());
		devicePlan.setBeforeKYC(transactionPlan.buildDescriptionAndCode());

		programSetupWorkflow.createDevicePlan(devicePlan);
		context.put(ContextConstants.DEVICE_PLAN, devicePlan);
	}
	
	@When("User filled Wallet Fee Plan for $type product")
	public void whenUserFilledWalletFeePlan(String type) {

		WalletFeePlan walletFeePlan;
		walletFeePlan = WalletFeePlan.createWithProviderForRegression(provider);
		walletFeePlan.setProductType(ProductType.fromShortName(type));
		WalletFeePlanDetails details = WalletFeePlanDetails.createWithProviderForRegression(provider);
		walletFeePlan.getWalletFeePlanDetails().add(details);

		programSetupWorkflow.createWalletFeePlan(walletFeePlan, ProductType.fromShortName(type));
	}
	
	@When("User filled Wallet Plan for $type product")
	public void whenUserFilledWalletPlan(String type) {
		walletPlan = WalletPlan.createWithProvider(provider);
		walletPlan.setProductType(ProductType.fromShortName(type));
		if (walletPlan.getProductType().equalsIgnoreCase(ProductType.CREDIT)) {
			walletPlan.setCreditPlan(creditCardCreditPlan.buildAbbreviationAndCode());
			walletPlan.setBillingCyleCode(creditCardBillingCycle.buildDescriptionAndCode());
		}
		programSetupWorkflow.createWalletPlan(walletPlan);
	}
	
	@When("User filled Program section for $type product")
	public void whenUserFilledProgramSection(String type) {
		program = Program.createWithProvider(provider);
		program.setProduct(ProductType.fromShortName(type));
		if (!program.getProduct().equalsIgnoreCase(ProductType.DEBIT)) {
			program.setOtherPlanStatementMessagePlan(statementMessagePlan.buildDescriptionAndCode());
			program.setOtherPlanMarketingMessagePlan(marketingMessagePlan.buildDescriptionAndCode());
		}
		program.setFirstWalletPlan(walletPlan.buildDescriptionAndCode());
		program.setDevicePlanPlan1(devicePlan.buildDescriptionAndCode());

		program.setDedupPlan(dedupePlan.buildDescriptionAndCode());
		program.setDocumentChecklistPlan(documentCheckListPlan.buildDescriptionAndCode());
		program.setMccRulePlan(mccRulePlan.buildDescriptionAndCode());

		if (program.getProduct().equalsIgnoreCase(ProductType.PREPAID)) {
			program.setPrepaidStatementPlan(prepaidStatementPlan.buildDescriptionAndCode());
		}

		programSetupWorkflow.createProgram(program, ProductType.fromShortName(type));
		context.put(ContextConstants.PROGRAM, program);
	}

	@When("User filled Business Mandatory Fields Screen for $type product")
	public void whenUserFilledBusinessMandatoryFieldsScreen(String type) {
		applicationBusinessMandatoryFields = ApplicationBusinessMandatoryFields.createWithProvider(provider);
		applicationBusinessMandatoryFields.setProductType(ProductType.fromShortName(type));
		applicationBusinessMandatoryFields.setProgramCode(program.buildDescriptionAndCode());
		
		programSetupWorkflow.fillBusinessMandatoryFields(applicationBusinessMandatoryFields);
	}

	@When("User filled Device Range section for $type product")
	public void whenUserFilledDeviceRangeSection(String type) {
		DeviceRange deviceRange = DeviceRange.createWithProvider(provider, type);
		deviceRange.setProductType(ProductType.fromShortName(type));
		deviceRange.setProgram(program.buildDescriptionAndCode());
		deviceRange.setDevicePlanCode(devicePlan.buildDescriptionAndCode());

		programSetupWorkflow.createDeviceRange(deviceRange);
	}

}
