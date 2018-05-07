package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.GatewayConfiguration;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_GATEWAY_CONFIGURATION })
public class GatewayConfigurationPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(GatewayConfigurationPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement configurationFor;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement active;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement emailProtocol;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement smsProtocol;

	@PageElement(findBy = FindBy.NAME, valueToFind = "configurationFor:input:dropdowncomponent")
	private MCWebElement addConfigurationForDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "activeFlag:input:dropdowncomponent")
	private MCWebElement addActiveDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "emailProtocol:input:dropdowncomponent")
	private MCWebElement addEmailProtocolDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "siteId:input:inputTextField")
	private MCWebElement siteIDTxtbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "campaignId:input:inputTextField")
	private MCWebElement campaignIDTxtbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "esbRegisteredUsername:input:inputTextField")
	private MCWebElement registrationUserNameTxtbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "replacementIdentifier:input:inputTextField")
	private MCWebElement replacementIdentifierTxtbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "globalOutputCheck:input:dropdowncomponent")
	private MCWebElement globalOutputCheckDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "reporting:input:dropdowncomponent")
	private MCWebElement reportingDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "clientMessageId:input:inputTextField")
	private MCWebElement clientMessageIDTxtbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "functionalErrorEmail:input:inputTextField")
	private MCWebElement functionalErrorEmailTxtbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "copyToSelf:input:dropdowncomponent")
	private MCWebElement copyToSelfDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "contactPersonFirstName:input:inputTextField")
	private MCWebElement contactPersonFirstNameTxtbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "contactPersonLastName:input:inputTextField")
	private MCWebElement contactPersonLastNameTxtbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "contactPersonEmail:input:inputTextField")
	private MCWebElement contactPersonEmailTxtbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "contactPersonMobile:input:inputTextField")
	private MCWebElement contactPersonMobileTxtbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "emailSenderEmailId:input:inputTextField")
	private MCWebElement emailSenderEmailIdTxtbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "emailSenderName:input:inputTextField")
	private MCWebElement emailSenderNameTxtbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "replyToEmail:input:inputTextField")
	private MCWebElement replyToEmailTxtbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "returnToEmail:input:inputTextField")
	private MCWebElement returnToEmailTxtbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "esbEndpointUrlEmail:input:inputTextField")
	private MCWebElement esbEndpointUrlEmailTxtbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "consumerId:input:inputTextField")
	private MCWebElement consumerIdTxtbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "shortCode:input:inputTextField")
	private MCWebElement shortCodeTxtbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "esbTcpPort:input:inputTextField")
	private MCWebElement esbTcpPortTxtbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "esbTcpIp:input:inputTextField")
	private MCWebElement esbTcpIpTxtbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "esbEndpointUrlSms:input:inputTextField")
	private MCWebElement esbEndpointUrlSmsTxtbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "smtpIsCryptoValut:input:dropdowncomponent")
	private MCWebElement smtpIsCryptoValutDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "smtpHost:input:inputTextField")
	private MCWebElement smtpHostTxtbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "smtpPort:input:inputTextField")
	private MCWebElement smtpPortTxtbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "smtpIsDebug:input:dropdowncomponent")
	private MCWebElement smtpIsDebugDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "smtpIsAuth:input:dropdowncomponent")
	private MCWebElement smtpIsAuthDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "smtpUserName:input:inputTextField")
	private MCWebElement smtpUserNameTxtbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "smtpPassword:input:inputTextField")
	private MCWebElement smtpPasswordTxtbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "smtpSslFactory:input:inputTextField")
	private MCWebElement smtpSslFactory;

	@PageElement(findBy = FindBy.NAME, valueToFind = "smtpSslRequired:input:dropdowncomponent")
	private MCWebElement smtpSslRequiredDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "emailSenderEmailIdSmtp:input:inputTextField")
	private MCWebElement emailSenderEmailIdSmtpTxtbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "emailSenderNameSmtp:input:inputTextField")
	private MCWebElement emailSenderNameSmtpTxtbx;
	
	public static final String ADD_GATEWAY_CONFIGURATION_FRAME = "Add Gateway Configuration";

	public void verifyUiOperationStatus() {
		logger.info("Gateway Configuration");
		verifyUiOperation("Add Gateway Configuration");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(configurationFor),
				WebElementUtils.elementToBeClickable(active),
				WebElementUtils.elementToBeClickable(emailProtocol),
				WebElementUtils.elementToBeClickable(smsProtocol));
	}

	public void selectSMTPIsCryptoVault(GatewayConfiguration plan) {
		SelectDropDownByText(smtpIsCryptoValutDdwn, plan.getSMTPIsCryptoVault());
	}

	public String getFeedbackText() {
		SwitchToDefaultFrame();
		return getMessageFromFeedbackPanel();
	}

	public Boolean isNoRecordsFoundInTableView() {
		return isNoRecordsFoundInTable();
	}

	public void selectConfigurationFor(GatewayConfiguration plan) {
		SelectDropDownByText(addConfigurationForDdwn, plan.getConfigurationFor());
	}
	
	public void selectcopyToSelf(GatewayConfiguration plan) {
		SelectDropDownByText(copyToSelfDdwn, plan.getConfigurationFor());
	}
	
	public void selectActive(GatewayConfiguration plan) {
		SelectDropDownByText(addActiveDdwn, plan.getActive());
	}
	
	public void selectEmailProtocol(GatewayConfiguration plan) {
		SelectDropDownByText(addEmailProtocolDdwn, plan.getEmailProtocol());
	}
	
	public void selectGlobalOutputCheck(GatewayConfiguration plan) {
		SelectDropDownByText(globalOutputCheckDdwn, plan.getGlobalOutputCheck());
	}
	
	public void selectReporting(GatewayConfiguration plan) {
		SelectDropDownByText(reportingDdwn, plan.getGlobalOutputCheck());
	}
	
	public void selectsmtpIsDebug(GatewayConfiguration plan) {
		SelectDropDownByText(smtpIsDebugDdwn, plan.getSmtpIsDebug());
	}
	
	public void selectsmtpIsAuthDdwn(GatewayConfiguration plan) {
		SelectDropDownByText(smtpIsAuthDdwn, plan.getSmtpIsAuth());
	}
	
	public void selectSmtpSslRequiredDdwn(GatewayConfiguration plan) {
		SelectDropDownByText(smtpSslRequiredDdwn, plan.getSmtpSslRequired());
	}
	
	public void enterSiteId(GatewayConfiguration plan) {
		enterValueinTextBox(siteIDTxtbx, plan.getSiteId());
	}
	
	public void enterCampaignId(GatewayConfiguration plan) {
		enterValueinTextBox(campaignIDTxtbx, plan.getSiteId());
	}

	public void enterRegistrationUserName(GatewayConfiguration plan) {
		enterValueinTextBox(registrationUserNameTxtbx, plan.getRegistrationUserName());
	}
	
	public void enterRepacementIdentifier(GatewayConfiguration plan) {
		enterValueinTextBox(replacementIdentifierTxtbx, plan.getReplacementIdentifier());
	}
	
	public void enterClientMessageID(GatewayConfiguration plan) {
		enterValueinTextBox(clientMessageIDTxtbx, plan.getClientMessageID());
	}
	
	public void enterFunctionalErrorEmail(GatewayConfiguration plan) {
		enterValueinTextBox(functionalErrorEmailTxtbx, plan.getFunctionalErrorEmail());
	}
	
	public void enterContactPersonFirstName(GatewayConfiguration plan) {
		enterValueinTextBox(contactPersonFirstNameTxtbx, plan.getContactPersonFirstName());
	}
	
	public void enterCcontactPersonLastName(GatewayConfiguration plan) {
		enterValueinTextBox(contactPersonLastNameTxtbx, plan.getContactPersonLastName());
	}
	
	public void enterContactPersonEmail(GatewayConfiguration plan) {
		enterValueinTextBox(contactPersonEmailTxtbx, plan.getContactPersonEmail());
	}
	
	public void enterContactPersonMobile(GatewayConfiguration plan) {
		enterValueinTextBox(contactPersonMobileTxtbx, plan.getContactPersonMobile());
	}
	
	public void enterEmailSenderEmailId(GatewayConfiguration plan) {
		enterValueinTextBox(emailSenderEmailIdTxtbx, plan.getEmailSenderEmailId());
	}
	
	public void enterEmailSenderName(GatewayConfiguration plan) {
		enterValueinTextBox(emailSenderNameTxtbx, plan.getEmailSenderName());
	}
	
	public void enterReplyToEmail(GatewayConfiguration plan) {
		enterValueinTextBox(replyToEmailTxtbx, plan.getReplyToEmail());
	}
	
	public void enterReturnToEmail(GatewayConfiguration plan) {
		enterValueinTextBox(returnToEmailTxtbx, plan.getReplyToEmail());
	}
	
	public void enterEsbEndpointUrlEmail(GatewayConfiguration plan) {
		enterValueinTextBox(esbEndpointUrlEmailTxtbx, plan.getEsbEndpointUrlEmail());
	}
	
	public void enterConsumerId(GatewayConfiguration plan) {
		enterValueinTextBox(consumerIdTxtbx, plan.getConsumerId());
	}
	
	public void enterShortCode(GatewayConfiguration plan) {
		enterValueinTextBox(shortCodeTxtbx, plan.getShortCode());
	}
	
	public void enterEsbTcpPort(GatewayConfiguration plan) {
		enterValueinTextBox(esbTcpPortTxtbx, plan.getEsbTcpPort());
	}
	
	public void enterEsbTcpIp(GatewayConfiguration plan) {
		enterValueinTextBox(esbTcpIpTxtbx, plan.getEsbTcpIp());
	}
	
	public void enterEsbEndpointUrlSms(GatewayConfiguration plan) {
		enterValueinTextBox(esbEndpointUrlSmsTxtbx, plan.getEsbEndpointUrlSms());
	}
	
	public void enterSmtpHost(GatewayConfiguration plan) {
		enterValueinTextBox(smtpHostTxtbx, plan.getSmtpHost());
	}
	
	public void enterSmtpPort(GatewayConfiguration plan) {
		enterValueinTextBox(smtpPortTxtbx, plan.getSmtpPort());
	}
	
	public void enterSmtpUserName(GatewayConfiguration plan) {
		enterValueinTextBox(smtpUserNameTxtbx, plan.getSmtpUserName());
	}
	
	public void enterSmtpPassword(GatewayConfiguration plan) {
		enterValueinTextBox(smtpPasswordTxtbx, plan.getSmtpPassword());
	}
	
	public void enterSmtpSslFactory(GatewayConfiguration plan) {
		enterValueinTextBox(smtpSslFactory, plan.getSmtpSslFactory());
	}
	
	public void enterEmailSenderEmailIdSmtp(GatewayConfiguration plan) {
		enterValueinTextBox(emailSenderEmailIdSmtpTxtbx, plan.getEmailSenderEmailIdSmtp());
	}
	
	public void enterEmailSenderNameSmtp(GatewayConfiguration plan) {
		enterValueinTextBox(emailSenderNameSmtpTxtbx, plan.getEmailSenderNameSmtp());
	}
	
	public void createGatewayConfigurationwithESB(GatewayConfiguration plan) {
		clickAddNewButton();
		runWithinPopup(ADD_GATEWAY_CONFIGURATION_FRAME, () -> {
		selectConfigurationFor(plan);
        selectActive(plan);
        selectEmailProtocol(plan);
        enterSiteId(plan);
        enterCampaignId(plan);
        enterRegistrationUserName(plan);
        enterRepacementIdentifier(plan);
        selectGlobalOutputCheck(plan);
        selectReporting(plan);
        enterClientMessageID(plan);
        enterFunctionalErrorEmail(plan);
        selectcopyToSelf(plan);
        enterContactPersonFirstName(plan);
        enterCcontactPersonLastName(plan);
        enterContactPersonEmail(plan);
        enterContactPersonMobile(plan);
        enterEmailSenderEmailId(plan);
        enterEmailSenderName(plan);
        enterReplyToEmail(plan);
        enterReturnToEmail(plan);
        enterEsbEndpointUrlEmail(plan);
        enterConsumerId(plan);
        enterShortCode(plan);
        enterEsbTcpPort(plan);
        enterEsbTcpIp(plan);
        enterEsbEndpointUrlSms(plan);
        clickSaveButton();
		});
	}

	public void createGatewayConfigurationwithSMTP(GatewayConfiguration plan) {
		clickAddNewButton();
		runWithinPopup(ADD_GATEWAY_CONFIGURATION_FRAME, () -> {
		selectConfigurationFor(plan);
	     selectActive(plan);
	     selectEmailProtocol(plan);
	     selectSMTPIsCryptoVault(plan);
	     enterSmtpHost(plan);
	     enterSmtpPort(plan);
	     selectsmtpIsDebug(plan);
	     selectsmtpIsAuthDdwn(plan);
	     enterSmtpUserName(plan);
	     enterSmtpPassword(plan);
	     enterSmtpSslFactory(plan);
	     selectSmtpSslRequiredDdwn(plan);
	     enterEmailSenderEmailIdSmtp(plan);
	     enterEmailSenderNameSmtp(plan);
	     clickSaveButton();
		});
	}

}