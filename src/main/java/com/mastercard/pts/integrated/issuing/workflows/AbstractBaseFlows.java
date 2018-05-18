package com.mastercard.pts.integrated.issuing.workflows;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.ApproveorRejectPage;
import com.mastercard.pts.integrated.issuing.pages.cardholder.transactions.MastercardMoneySendPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.BillingCyclePage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.CloseBatchPage;
import com.mastercard.pts.integrated.issuing.pages.customer.InstitutionSelectionPage;
import com.mastercard.pts.integrated.issuing.pages.MenuSubMenuPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.PaymentBounceReasonPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.PaymentPriorityPage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.AgentPortalAdminUserCreationPage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.AgentPortalAgencyUserCreationPage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.AgentPortalAgentUserCreationPage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.AgentPortalBranchUserCreationPage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.AgentPortalCorporateUserCreationPage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.AgentPortalHomePage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.AgentPortalLoginPage;
import com.mastercard.pts.integrated.issuing.pages.customer.administration.BatchLevelPreviledgePage;
import com.mastercard.pts.integrated.issuing.pages.customer.administration.CustomerPortalHomePage;
import com.mastercard.pts.integrated.issuing.pages.customer.administration.CustomerPortalUserCreationPage;
import com.mastercard.pts.integrated.issuing.pages.customer.administration.InstitutionCreationPage;
import com.mastercard.pts.integrated.issuing.pages.customer.administration.LoginPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.BatchProcessingPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.BulkDeviceGenerationBatchPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.BulkDeviceRequestPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.BusinessMandatoryFieldsPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.CreditPlanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.CutoverProfilePage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DedupePlanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceBinPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceCardPackTemplatePage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceEventBasedFeePlanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceGenerationPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceJoiningPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DevicePlanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceProdBulkRequestPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceProductionPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceRangePage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceStatusPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DocumentChecklistPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.EmbossingPriorityPassPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.EmbossingTemplatePage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.InstitutionCurrencyPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.MCCRulesPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.MCGPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.MarketingMessagePlanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.NetworkMembershipPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.NewDevicePage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.OfficePage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.PictureCodePage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.PlasticCodePage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.PreProductionBatchPag;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.PreProductionBatchPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.PrepaidMessagePlanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.ProgramPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.StatementMessagePlanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.TransactionLimitPlanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.TransactionPlanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.TransactionRegistrationPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.TransactionRulePlanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.VendorPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.VerifyorRejectPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.WalletFeePlanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.WalletPlanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.processingcenter.ProcessingCenterPage;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.workflows.customer.administration.CardHolderPortalMenuConfigWorkFlow;

public class AbstractBaseFlows extends AbstractBasePage {

	final Logger logger = LoggerFactory.getLogger(AbstractBaseFlows.class);

	@Autowired
	public ProcessingCenterPage processingCenterPage;

	@Autowired
	LoginPage login;

	@Autowired
	public BatchProcessingPage processBatch;

	@Autowired
	InstitutionSelectionPage institutionSelectionPage;

	@Autowired
	public MenuSubMenuPage menuSubMenuPage;

	@Autowired
	LoginPage loginPage;

	@Autowired
	public InstitutionCreationPage institutionCreationPage;

	@Autowired
	public ApproveorRejectPage approveRejectPage;

	@Autowired
	public CutoverProfilePage cutoverProfilePage;

	@Autowired
	public NetworkMembershipPage networkMembershipPage;

	@Autowired
	public TransactionRegistrationPage transactionRegistrationPage;

	@Autowired
	public InstitutionCurrencyPage institutionCurrencyPage;

	@Autowired
	public OfficePage officePage;

	@Autowired
	public PlasticCodePage plasticCodePage;

	@Autowired
	public PictureCodePage pictureCodePage;

	@Autowired
	public DeviceBinPage deviceBinPage;

	@Autowired
	public DeviceStatusPage deviceStatusPage;

	@Autowired
	public MCGPage mCGPage;

	@Autowired
	public VendorPage vendorPage;

	@Autowired
	public DedupePlanPage dedupePlanPage;

	@Autowired
	public StatementMessagePlanPage statementMessagePlanPage;

	@Autowired
	public MarketingMessagePlanPage marketingMessagePlanPage;

	@Autowired
	public PrepaidMessagePlanPage prepaidMessagePlanPage;

	@Autowired
	public TransactionPlanPage transactionPlanPage;

	@Autowired
	public TransactionLimitPlanPage transactionLimitPlanPage;

	@Autowired
	public DocumentChecklistPage documentChecklistPage;

	@Autowired
	public BusinessMandatoryFieldsPage businessMandatoryFieldsPage;

	@Autowired
	public MCCRulesPage mCCRulesPage;

	@Autowired
	public DeviceCardPackTemplatePage deviceCardPackTemplatePage;

	@Autowired
	public DeviceEventBasedFeePlanPage deviceEventBasedFeePlanPage;

	@Autowired
	public DeviceJoiningPage deviceJoiningPage;

	@Autowired
	public DevicePlanPage devicePlanPage;

	@Autowired
	public EmbossingTemplatePage embossingTemplatePage;

	@Autowired
	public WalletFeePlanPage walletFeePlanPage;

	@Autowired
	public WalletPlanPage walletPlanPage;

	@Autowired
	public BillingCyclePage billingCyclePage;

	@Autowired
	public PaymentPriorityPage paymentPriorityPage;

	@Autowired
	public PaymentBounceReasonPage paymentBounceReasonPage;

	@Autowired
	public TransactionRulePlanPage transactionRulePlanPage;

	@Autowired
	public CreditPlanPage creditPlanPage;

	@Autowired
	public ProgramPage programPage;

	@Autowired
	public DeviceRangePage deviceRangePage;

	@Autowired
	public EmbossingPriorityPassPage embossingPriorityPassPage;

	@Autowired
	public NewDevicePage newDevicePage;

	@Autowired
	public VerifyorRejectPage verifyorRejectPage;

	@Autowired
	public ApproveorRejectPage approveorRejectPage;

	@Autowired
	public CloseBatchPage closeBatchPage;

	@Autowired
	public BatchLevelPreviledgePage batch;

	@Autowired
	public DeviceGenerationPage deviceGenerationPage;

	@Autowired
	public PreProductionBatchPage preProductionBatchPage;
	
	@Autowired
	public PreProductionBatchPag preProductionBatch;

	@Autowired
	public DeviceProductionPage deviceProductionPage;

	@Autowired
	public DeviceProdBulkRequestPage deviceProdBulkRequestPage;

	@Autowired
	public BulkDeviceGenerationBatchPage bulkDeviceGenerationBatchPage;

	@Autowired
	public BulkDeviceRequestPage bulkdevReq;

	@Autowired
	public AgentPortalLoginPage loginAgentPage;

	@Autowired
	public AgentPortalAdminUserCreationPage agentPortalAdminUserCreationPage;

	@Autowired
	public AgentPortalAgentUserCreationPage agentPortalAgentUserCreationPage;
	@Autowired
	public AgentPortalAgencyUserCreationPage agentPortalAgencyUserCreationPage;

	@Autowired
	public AgentPortalBranchUserCreationPage agentPortalBranchUserCreationPage;

	@Autowired
	public AgentPortalCorporateUserCreationPage agentPortalCorporateUserCreationPage;

	@Autowired
	public AgentPortalHomePage agentPortalHomePage;

	@Autowired
	public CustomerPortalHomePage customerPortalHomePage;
	
	@Autowired
	public CustomerPortalUserCreationPage customerPortalUserCreationPage;
	
	@Autowired
	public CardHolderPortalMenuConfigWorkFlow chpMenuConfig;
	
	@Autowired
	public MastercardMoneySendPage mastercardMoneySendPage;
	
	
	
	public void selectInstitute() {
		institutionSelectionPage.selectInstitution(MapUtils
				.fnGetInputDataFromMap("InstitutionName"));
		institutionSelectionPage.clickConfirm();
	}

	public void loginAsAdmin() {
		login.login();
	}

	public void login(String uName, String pwd) {
		login.login(uName, pwd);
	}

	public void sessionExpiryloginInAgain() {
		try {
			getFinder().getWebDriver().manage().deleteAllCookies();
			CustomUtils.ThreadDotSleep(4000);
			getFinder().getWebDriver().navigate()
					.to(MapUtils.fnGetInputDataFromMap("AppURL"));
			CustomUtils.ThreadDotSleep(500);
		} catch (Exception e) {
			logger.error("There was an exception during the execution: ", e);
		}
	}

	public void loginToPortal(String uName, String pwd) {
		login.loginTo(uName, pwd);
	}

}