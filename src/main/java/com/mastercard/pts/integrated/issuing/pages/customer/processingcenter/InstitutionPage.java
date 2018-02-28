package com.mastercard.pts.integrated.issuing.pages.customer.processingcenter;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.admin.InstitutionCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.processingcenter.Institution;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = ProcessingCenterNav.TAB_PROCESSING_CENTER, treeMenuItems = { ProcessingCenterNav.L1_SETUP,
		ProcessingCenterNav.L2_MASTER_PARAMETERS, ProcessingCenterNav.L3_INSTITUTION, })
public class InstitutionPage extends AbstractBasePage {

	@Autowired
	private TestContext context;

	boolean ascFlag;

	private static final Logger logger = LoggerFactory.getLogger(InstitutionPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='bankCode']")
	private MCWebElement instituteCode;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='bankName']")
	private MCWebElement instituteName;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td/span/input[@fld_fqn='bankCode']")
	private MCWebElement instituteCodeTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td/span/input[@fld_fqn='bankName']")
	private MCWebElement instituteNameTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td/span/input[@fld_fqn='abrevName']")
	private MCWebElement abbrvNameTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td/span/input[@fld_fqn='debitProduct']")
	private MCWebElement debitCbx;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td/span/input[@fld_fqn='creditProduct']")
	private MCWebElement creditCbx;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td/span/input[@fld_fqn='prepaidProduct']")
	private MCWebElement prepaidCbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bankCurrencyCode:input:dropdowncomponent")
	private MCWebElement institutionCurrencyDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "languagePreference:input:dropdowncomponent")
	private MCWebElement defaultLanguageDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "zoneCode:input:dropdowncomponent")
	private MCWebElement timeZoneDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "agtCheck:checkBoxComponent")
	private MCWebElement agentPortalCbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "collectPortalFlag:checkBoxComponent")
	private MCWebElement collectPortalCbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "customerCareContactNumbers:input:inputTextField")
	private MCWebElement ccNumberTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "customerCareEmailId:input:inputTextField")
	private MCWebElement ccEmailTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[text()='Address']")
	private MCWebElement addressTab;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='contactName']")
	private MCWebElement contactNameTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='phoneNumber']")
	private MCWebElement phoneTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mobileCntryCode:input:dropdowncomponent")
	private MCWebElement mobileCountryCodeDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mobileNumber:input:inputTextField")
	private MCWebElement mobileNumCodeDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='emailId']")
	private MCWebElement emailTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='address1']")
	private MCWebElement address1Txt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='address2']")
	private MCWebElement address2Txt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td/span[@id='countryCode']/select")
	private MCWebElement countryDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td/span[@id='stateCode']/select")
	private MCWebElement stateDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td/span[@id='cityCode']/select")
	private MCWebElement cityDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td/span[@id='zipCode']/input")
	private MCWebElement pincodeTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[text()='Agent Portal']")
	private MCWebElement agentPortalTab;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td/span/input[@fld_fqn='agtID']")
	private MCWebElement agentPortalAdminIdTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td/span/input[@fld_fqn='agtName']")
	private MCWebElement agentPortalAdminNameTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='agtAddress1']")
	private MCWebElement agtAddress1Txt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='agtAddress2']")
	private MCWebElement agtAddress2Txt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td/span[@id='agentCountryCode']/select")
	private MCWebElement agentCountryCodeDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='agtPhone1']")
	private MCWebElement agentPhoneTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "agtMobileCntryCode:input:dropdowncomponent")
	private MCWebElement agentMobileCountryCodeDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "agtPhone2:input:inputTextField")
	private MCWebElement agentMobileNumCodeDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='agtMailId']")
	private MCWebElement agentEmailTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "agtZipCode:input:inputTextField")
	private MCWebElement agentPostalCodeTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[text()='Collect Portal']")
	private MCWebElement collectPortalTab;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td/span/input[@fld_fqn='cpAdminID']")
	private MCWebElement cplAdminIdTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td/span/input[@fld_fqn='cpAdminName']")
	private MCWebElement cpAdminNameTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='cpAdminAddressLine1']")
	private MCWebElement cpAddress1Txt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='cpAdminAddressLine2']")
	private MCWebElement cpAddress2Txt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td/span[@id='cpAdminCountryCode']/select")
	private MCWebElement cpCountryCodeDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='cpAdminPhone1']")
	private MCWebElement cpPhoneTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cpAdminMobileCountryCode:input:dropdowncomponent")
	private MCWebElement cpMobileCountryCodeDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cpAdminPhone2:input:inputTextField")
	private MCWebElement cpMobileNumCodeDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='cpAdminMailId']")
	private MCWebElement cpEmailTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='cpAdminZipCode']")
	private MCWebElement cpZipTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "refCurrencyCode:input:dropdowncomponent")
	private MCWebElement refCurrencyDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "adaptiveEcommFlag:input:dropdowncomponent")
	private MCWebElement adaptiveEcommFlagDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "issuerSmsProvider:checkBoxComponent")
	private MCWebElement issuerSmsProviderCbx;
	@PageElement(findBy = FindBy.NAME, valueToFind = "mpinEnabled:checkBoxComponent")
	private MCWebElement mpinEnabledCbx;

	public void verifyUiOperationStatus() {
		logger.info("Processing Center UI Status");
		verifyUiOperation("Add Institution");
	}

	public void createInstitute(Institution inst) {
		logger.info("create new Institution with name : {}", inst.getName());
		clickAddNewButton();
		runWithinPopup("Add Institution", () -> {
			fillGeneralDetails(inst);
			fillAddressDetails(inst);
			fillAgentPortalDetails(inst);
			fillCollectPortal(inst);
			clickSaveButton();
		});

		verifyOperationStatus();
	}

	public void fillAddressDetails(Institution inst) {
		addressTab.click();
		WebElementUtils.enterText(contactNameTxt, inst.getContactName());
		WebElementUtils.enterText(phoneTxt, inst.getPhone());
		WebElementUtils.selectDropDownByVisibleText(mobileCountryCodeDwn, inst.getMobileCountryCode());
		WebElementUtils.enterText(mobileNumCodeDwn, inst.getMobileNum());
		WebElementUtils.enterText(emailTxt, inst.getEmail());
		WebElementUtils.enterText(address1Txt, inst.getAddress1());
		WebElementUtils.enterText(address2Txt, inst.getAddress2());
		WebElementUtils.selectDropDownByVisibleText(countryDwn, inst.getCountry());
		WebElementUtils.selectDropDownByVisibleText(stateDwn, inst.getState());
		WebElementUtils.selectDropDownByVisibleText(cityDwn, inst.getCity());
		WebElementUtils.enterText(pincodeTxt, inst.getPostalCode().get("customerPortal"));
	}

	public void fillAgentPortalDetails(Institution inst) {
		agentPortalTab.click();
		WebElementUtils.enterText(agentPortalAdminIdTxt, inst.getPortalAdminId());
		WebElementUtils.enterText(agentPortalAdminNameTxt, inst.getPortalAdminId());
		WebElementUtils.enterText(agtAddress1Txt, inst.getAddress1());
		WebElementUtils.enterText(agtAddress2Txt, inst.getAddress2());
		WebElementUtils.selectDropDownByVisibleText(agentCountryCodeDwn, inst.getCountry());
		WebElementUtils.enterText(agentPhoneTxt, inst.getPhone());
		WebElementUtils.enterText(agentEmailTxt, inst.getEmail());
		WebElementUtils.selectDropDownByVisibleText(agentMobileCountryCodeDwn, inst.getMobileCountryCode());
		WebElementUtils.enterText(agentMobileNumCodeDwn, inst.getMobileNum());
		WebElementUtils.enterText(agentPostalCodeTxt, inst.getPostalCode().get("agentPortal"));
	}

	public void fillCollectPortal(Institution inst) {
		collectPortalTab.click();
		WebElementUtils.enterText(cplAdminIdTxt, inst.getPortalAdminId());
		WebElementUtils.enterText(cpAdminNameTxt, inst.getPortalAdminId());
		WebElementUtils.enterText(cpAddress1Txt, inst.getAddress1());
		WebElementUtils.enterText(cpAddress2Txt, inst.getAddress2());
		WebElementUtils.selectDropDownByVisibleText(cpCountryCodeDwn, inst.getCountry());
		WebElementUtils.enterText(cpZipTxt, inst.getPostalCode().get("collectPortal"));
		WebElementUtils.enterText(cpPhoneTxt, inst.getPhone());
		WebElementUtils.enterText(cpEmailTxt, inst.getEmail());
		WebElementUtils.selectDropDownByVisibleText(cpMobileCountryCodeDwn, inst.getMobileCountryCode());
		WebElementUtils.enterText(cpMobileNumCodeDwn, inst.getMobileNum());
	}

	public void fillGeneralDetails(Institution inst) {
		WebElementUtils.enterText(instituteCodeTxt, inst.getCode());
		WebElementUtils.enterText(instituteNameTxt, inst.getName());
		WebElementUtils.enterText(abbrvNameTxt, inst.getAbbreviation());
		WebElementUtils.checkCheckbox(debitCbx, inst.isDebit());
		WebElementUtils.checkCheckbox(creditCbx, inst.isCredit());
		WebElementUtils.checkCheckbox(prepaidCbx, inst.isPrepaid());
		WebElementUtils.selectDropDownByVisibleText(institutionCurrencyDwn, inst.getInstitutionCurrency());
		WebElementUtils.selectDropDownByVisibleText(refCurrencyDwn, inst.getInstitutionCurrency());
		WebElementUtils.selectDropDownByVisibleText(defaultLanguageDwn, inst.getDefaultLanguage());
		WebElementUtils.selectDropDownByVisibleText(timeZoneDwn, inst.getTimeZone());
		WebElementUtils.checkCheckbox(agentPortalCbx, inst.isAgentPortalSupport());
		WebElementUtils.checkCheckbox(collectPortalCbx, inst.isCollectPortalSupport());
		WebElementUtils.enterText(ccEmailTxt, inst.getCcEmail());
		WebElementUtils.enterText(ccNumberTxt, inst.getCcNumber());
	}

	public boolean isInstitutionNotPresent(Institution inst) {
		WebElementUtils.enterText(instituteCode, inst.getCode());
		clickSearchButton();
		return isNoRecordsFoundInTable();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(instituteCode));
	}

	public boolean isAdaptiveAuthenticationEnabled() {
		return adaptiveEcommFlagDwn.isEnabled();
	}

	public boolean userAbleToselectACSVendor() {
		runWithinPopup("Edit Institution", () -> {
			ascFlag = isAdaptiveAuthenticationEnabled();
			selectACSVendor();
			WebElementUtils.scrollDown(driver(), 0, 250);
			context.put("authenticationOptionsFlg", isSMSServiceProviderAndMPINAreEnabled());
			selectMpinAndSmsProvider();
			clickSaveButton();
		});
		return ascFlag;
	}

	public void selectACSVendor() {
		InstitutionCreation institutioncreation = context.get("institutionData");
		WebElementUtils.selectDropDownByVisibleText(adaptiveEcommFlagDwn, institutioncreation.getAscVendor());
	}

	public boolean checkASCVendorEnabledAndSelectASCVendor() {
		boolean recordUpdatedFlg = userAbleToselectACSVendor();
		context.put("SuccessMessage", getSuccessMessage().equalsIgnoreCase(Constants.Record_Updated_Successfully));
		return recordUpdatedFlg;
	}

	public boolean isSMSServiceProviderAndMPINAreEnabled() {
		return issuerSmsProviderCbx.isEnabled() && mpinEnabledCbx.isEnabled();
	}

	public void selectMpinAndSmsProvider() {
		InstitutionCreation institutioncreation = context.get("institutionData");
		String option = institutioncreation.getAuthenticationFlg();
		if (option.equalsIgnoreCase("enable")) {
			selectCheckBox(mpinEnabledCbx, "MPIN");
			selectCheckBox(issuerSmsProviderCbx, "SmsProvider");
		} else {
			ClickCheckBox(mpinEnabledCbx, false);
			ClickCheckBox(issuerSmsProviderCbx, false);
		}
	}

	public void enterInstitutionCode(InstitutionCreation institutioncreation) {
		WebElementUtils.enterText(instituteCode, institutioncreation.getExistingInstitutionCode());
	}

}