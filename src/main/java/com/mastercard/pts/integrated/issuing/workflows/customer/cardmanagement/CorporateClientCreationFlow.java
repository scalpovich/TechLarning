package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ApplicationBusinessMandatoryFields;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ApplicationDocumentChecklist;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CorporateClient;
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
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.CreateCorporatePage;
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
public class CorporateClientCreationFlow {
	
	@Autowired
	private Navigator navigator;
    @Autowired
    private TestContext context;
    private static final Logger logger = LoggerFactory.getLogger(CorporateClientCreationFlow.class);
	
    public void createCorporateClient(CorporateClient corporatepage) {
    	CreateCorporatePage page = navigator.navigateToPage(CreateCorporatePage.class);
		page.createCorporateClient(corporatepage);
	}

}
