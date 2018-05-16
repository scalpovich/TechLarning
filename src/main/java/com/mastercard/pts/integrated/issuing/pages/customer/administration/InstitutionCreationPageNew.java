package com.mastercard.pts.integrated.issuing.pages.customer.administration;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import junit.framework.Assert;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.admin.InstitutionCreation;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.InstitutionLoadCurrencyPage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.ProcessingCenterNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.MCWebElements;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = ProcessingCenterNav.TAB_Processing_Center, treeMenuItems = {
		ProcessingCenterNav.L1_SETUP, ProcessingCenterNav.L2_MASTER_PARAMETERS,
		ProcessingCenterNav.L3_INSTITUTION })
public class InstitutionCreationPageNew extends AbstractBaseFlows {

	final Logger logg = LoggerFactory
			.getLogger(InstitutionCreationPageNew.class);

	// ------------- Processing Center > Setup > Master Parameters > Institution
	// [CESM01]

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[.='General']")
	private MCWebElement generalTab;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addInstitution;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bankCode:input:inputTextField")
	private MCWebElement institutionCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bankName:input:inputTextField")
	private MCWebElement institutionName;

	@PageElement(findBy = FindBy.NAME, valueToFind = "abrevName:input:inputTextField")
	private MCWebElement abbreviation;

	@PageElement(findBy = FindBy.NAME, valueToFind = "debitProduct:checkBoxComponent")
	private MCWebElement debitChkBX;

	@PageElement(findBy = FindBy.NAME, valueToFind = "creditProduct:checkBoxComponent")
	private MCWebElement creditChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "prepaidProduct:checkBoxComponent")
	private MCWebElement prepaidChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bankCurrencyCode:input:dropdowncomponent")
	private MCWebElement institutionCurrency;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='refCurrencyCode']/select")
	private MCWebElement institutionReferenceCurrency;

	@PageElement(findBy = FindBy.NAME, valueToFind = "agtCheck:checkBoxComponent")
	private MCWebElement agentPortalSupportChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "collectPortalFlag:checkBoxComponent")
	private MCWebElement collectPortalSupportChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "accLenValidate:checkBoxComponent")
	private MCWebElement accLengthValChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "clientLenValidate:checkBoxComponent")
	private MCWebElement clientLengthValChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "rsa:checkBoxComponent")
	private MCWebElement rsaSuportChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "languagePreference:input:dropdowncomponent")
	private MCWebElement defaulLanguageDrpDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "zoneCode:input:dropdowncomponent")
	private MCWebElement timeZoneDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "zipMandatoryFlag:checkBoxComponent")
	private MCWebElement domesticPcodeMandChkBx;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//select[contains(@name,'financialStartMonth')]")
	private MCWebElement financialStartMonth;

	@PageElement(findBy = FindBy.NAME, valueToFind = "accLen:input:inputTextField")
	private MCWebElement accNoLengthTxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "clientLen:input:inputTextField")
	private MCWebElement clientNoLengthTxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "pdispApplicantPhoto")
	private MCWebElement institutionLogo;

	@PageElement(findBy = FindBy.NAME, valueToFind = "pdispApplicantPhotoAgent")
	private MCWebElement agentPortalLogoBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "uploadPhotoAgent")
	private MCWebElement uploadPhotoAgentBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "uploadPhoto")
	private MCWebElement uploadPhotoBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "ofacPlanCode:input:dropdowncomponent")
	private MCWebElement sdnPlanDrpDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "customerCareContactNumbers:input:inputTextField")
	private MCWebElement custCareContactNoTxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "customerCareEmailId:input:inputTextField")
	private MCWebElement generalEmailIdTxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "customerCareFax:input:inputTextField")
	private MCWebElement custCareFaxTxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "customerCareNumberInt:input:inputTextField")
	private MCWebElement custCareIntNoTxtBx;

	@PageElement(findBy = FindBy.CSS, valueToFind = "select[name='customerCareNumberIntCntryCode:input:dropdowncomponent']")
	private MCWebElement custCareIntDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "customerCareNumberVipCntryCode:input:dropdowncomponent")
	private MCWebElement custCareVIPDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "customerCareNumberVip:input:inputTextField")
	private MCWebElement custCareVIPNoTxtBx;

	// ------------- Processing Center > Setup > Master Parameters > Institution
	// > Add Institution > Address

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[.='Address']")
	private MCWebElement addressTab;

	@PageElement(findBy = FindBy.NAME, valueToFind = "contactName:input:inputTextField")
	private MCWebElement contactName;

	@PageElement(findBy = FindBy.NAME, valueToFind = "phoneNumber:input:inputTextField")
	private MCWebElement phoneNoTxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mobileCntryCode:input:dropdowncomponent")
	private MCWebElement mobileNoCountryCodeDrpDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mobileNumber:input:inputTextField")
	private MCWebElement mobileNoTxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "emailId:input:inputTextField")
	private MCWebElement emailIDAddressTxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "address1:input:inputTextField")
	private MCWebElement addressLine1TxtBX;

	@PageElement(findBy = FindBy.NAME, valueToFind = "address2:input:inputTextField")
	private MCWebElement addressLine2TxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "address3:input:inputTextField")
	private MCWebElement addressLine3TxtBX;

	@PageElement(findBy = FindBy.NAME, valueToFind = "address4:input:inputTextField")
	private MCWebElement addressLine4TxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "countryCode:input:dropdowncomponent")
	private MCWebElement countryDrpDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cityCode:input:dropdowncomponent")
	private MCWebElement areaCityDrpDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "zipCode:input:inputTextField")
	private MCWebElement postalCodeTxtBX;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement cancelBtn;

	@PageElement(findBy = FindBy.ID, valueToFind = "institution_selection")
	private MCWebElement instituteSelectionDrpDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@id='institution_selector']//li")
	private MCWebElement instituteSelectionValue;

	@PageElement(findBy = FindBy.ID, valueToFind = "institution")
	private MCWebElement institutionDdwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[.='Institution Name']/following::input[1]")
	private MCWebElement searchInstitutionName;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[.='Institution Code']/following::input[1]")
	private MCWebElement searchInstitutionCodeTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value='Search']")
	private MCWebElement searchBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = ".feedbackPanelINFO>span")
	private MCWebElement instituteUpdateMessage;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//tbody//tr")
	private MCWebElements resultTableRow;
	
	private String tab = "//a[.='%s']";

	private String activeTab = "//li[@class='activetb']/a";

	private String tabWithError = "//ul[@class='tabs']//span[@class='tabError']/..";

	private String institutionLogoImg = "\\src\\main\\resources\\InstitutionLogo\\BankLogo.png";

	private String agentPortalLogoImg = "\\src\\main\\resources\\InstitutionLogo\\AgentPortalLogo.png";

	private String collectPortalLogoImg = "\\src\\main\\resources\\InstitutionLogo\\CreditLogo.png";

	// ------------- Processing Center > Setup > Master Parameters > Institution
	// > Add Institution > Agent portal

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[.='Agent Portal']")
	private MCWebElement agentPortalTab;

	// ------------- Processing Center > Setup > Master Parameters > Institution
	// > Add Institution > Collect portal

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[.='Collect Portal']")
	private MCWebElement collectPortalTab;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cpAdminID:input:inputTextField")
	private MCWebElement collectPortalAdminID;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cpAdminName:input:inputTextField")
	private MCWebElement collectPortalAdminName;

	@PageElement(findBy = FindBy.NAME, valueToFind = "pdispCPAdminPhoto")
	private MCWebElement creditInstitutionLogoBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "uploadCPAdminPhoto")
	private MCWebElement uploadCPAdminPhotoBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cpAdminAddressLine1:input:inputTextField")
	private MCWebElement collectPortaladdressLine1;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cpAdminAddressLine2:input:inputTextField")
	private MCWebElement collectPortaladdressLine2;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cpAdminCountryCode:input:dropdowncomponent")
	private MCWebElement collectPortalCountryDD;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cpAdminZipCode:input:inputTextField")
	private MCWebElement collectPortalPostalCodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cpAdminPhone1:input:inputTextField")
	private MCWebElement collectPortalPhoneTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cpAdminMobileCountryCode:input:dropdowncomponent")
	private MCWebElement collectPortalAdminMobileCodeDD;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cpAdminPhone2:input:inputTextField")
	private MCWebElement collectPortalAdminMobileNumberTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cpAdminMailId:input:inputTextField")
	private MCWebElement collectPortalEmailIDTxt;

	// Adaptive Authentication - RSA
	@PageElement(findBy = FindBy.NAME, valueToFind = "adaptiveEcommFlag:checkBoxComponent")
	private MCWebElement adaptiveEcommChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mpinEnabled:checkBoxComponent")
	private MCWebElement mpinChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "issuerSmsProvider:checkBoxComponent")
	private MCWebElement smsProvider;

	@PageElement(findBy = FindBy.NAME, valueToFind = "agtID:input:inputTextField")
	private MCWebElement agentPortalAdminID;

	@PageElement(findBy = FindBy.NAME, valueToFind = "agtName:input:inputTextField")
	private MCWebElement agentPortalAdminName;

	@PageElement(findBy = FindBy.NAME, valueToFind = "agtAddress1:input:inputTextField")
	private MCWebElement agentAddressline1;

	@PageElement(findBy = FindBy.NAME, valueToFind = "agtAddress2:input:inputTextField")
	private MCWebElement agentAddressline2;

	@PageElement(findBy = FindBy.NAME, valueToFind = "agentCountryCode:input:dropdowncomponent")
	private MCWebElement agentCountryCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "agtZipCode:input:inputTextField")
	private MCWebElement agentZipCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "agtPhone1:input:inputTextField")
	private MCWebElement agentPhone;

	@PageElement(findBy = FindBy.NAME, valueToFind = "agtMobileCntryCode:input:dropdowncomponent")
	private MCWebElement agentMobileCountrycode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "agtPhone2:input:inputTextField")
	private MCWebElement agentMobileNumber;

	@PageElement(findBy = FindBy.NAME, valueToFind = "agtMailId:input:inputTextField")
	private MCWebElement agentEmailTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "adaptiveEcommFlag:input:dropdowncomponent")
	private MCWebElement adaptiveEcommFlagDDwn;
	
	public static final String ATTRIBUTE_VALUE =  "value";

	/**
	 * Click add button and switch to frame
	 */
	public void clickAddBtn() {
		clickWhenClickable(addInstitution);
		switchToIframe(Constants.ADD_ADD_INSTITUTION_FRAME);
	}

	public void enterInstitutionCode(InstitutionCreation institute) {
		enterValueinTextBox(institutionCode, institute.getInstitutionCode());
	}

	public void enterInstitutionAbbreviation(InstitutionCreation institute) {
		enterValueinTextBox(this.abbreviation,
				institute.getInstitutionAbbrevation());
	}

	public void checkDebit() {
		waitforElement(debitChkBX);
		selectCheckBox(debitChkBX, "Debit");
		SimulatorUtilities.wait(2000);
	}

	public void checkCredit() {
		SimulatorUtilities.wait(2000);
		selectCheckBox(creditChkBx, "Credit");
		SimulatorUtilities.wait(2000);
	}

	public void checkPrepaid() {
		WebElementUtils.checkCheckbox(prepaidChkBx, true);
		SimulatorUtilities.wait(2000);
	}

	public void selectInstitutionCurrency(InstitutionCreation institute) {
		selectValueFromDropDown(institutionCurrency,
				institute.getInstitutionCurrency());
		SimulatorUtilities.wait(2000);
	}

	public void selectInstitutionReferenceCurrency(InstitutionCreation institute) {
		SimulatorUtilities.wait(2000);
		selectValueFromDropDown(institutionReferenceCurrency,
				institute.getInstitutionReferenceCurrency());
		SimulatorUtilities.wait(2000);
	}

	public void selectDefaultlanguage(InstitutionCreation institute) {
		selectValueFromDropDown(defaulLanguageDrpDwn,
				institute.getDefaultLanguage());
		SimulatorUtilities.wait(2000);
	}

	public void selectTimeZone(InstitutionCreation institute) {
		waitForElementVisible(timeZoneDdwn);
		selectValueFromDropDown(timeZoneDdwn, institute.getTimeZone());
		SimulatorUtilities.wait(1000);
	}

	public boolean checkAgentPortalSupport() {
		SimulatorUtilities.wait(2000);
		return selectCheckBox(agentPortalSupportChkBx, "Agent Portal Support");
	}

	public boolean checkCollectportalSupport() {
		return selectCheckBox(collectPortalSupportChkBx,
				"Collect Portal Support");
	}

	public boolean checkAccountLenghtValidation() {
		return selectCheckBox(accLengthValChkBx, "Account Length Validation");
	}

	public boolean checkClientLengthCheckValidation() {
		return selectCheckBox(clientLengthValChkBx, "Client Length Validation");
	}

	public boolean checkRSASupport() {
		return selectCheckBox(rsaSuportChkBx, "RSA Support");
	}

	public void enterAccountNumberLength(InstitutionCreation institute) {
		if (checkAccountLenghtValidation()) {
			enterValueinTextBox(accNoLengthTxtBx,
					institute.getAccountNumberLength());
		}
	}

	public void enterClientNumberLength(InstitutionCreation institute) {
		if (checkClientLengthCheckValidation()) {
			Assert.assertTrue(clientNoLengthTxtBx.getAttribute("disabled") == null);
			enterValueinTextBox(clientNoLengthTxtBx,
					institute.getClientNumberLength());
		}
	}

	public void selectFinancialYearStartMonth(InstitutionCreation institute) {
		selectValueFromDropDown(financialStartMonth,
				institute.getFinancialYearStartMonth());

	}

	public void selectSDNPlan(InstitutionCreation institute) {
		selectValueFromDropDown(sdnPlanDrpDwn, institute.getSDNPlan());
	}

	public void enterCustomerContactNumber(InstitutionCreation institute) {
		enterValueinTextBox(custCareContactNoTxtBx,
				institute.getCustomerCareContactNumber());
	}

	public void enterGeneralTabEmailID(InstitutionCreation institute) {
		enterValueinTextBox(generalEmailIdTxtBx, institute.getEmailID());
	}

	public void enterCustomerFax(InstitutionCreation institute) {
		enterValueinTextBox(custCareFaxTxtBx, institute.getCustomerCareFax());
	}

	private void enterCustomerIntl(InstitutionCreation institute) {
		selectValueFromDropDown(custCareIntDdwn,
				institute.getCustomerCareIntlISDCode());
		enterValueinTextBox(custCareIntNoTxtBx,
				institute.getCustomerCareIntlNo());
	}

	public boolean verifyCustCareIntl(InstitutionCreation institute) {
		try{
		waitForElementVisible(custCareIntDdwn);
		return (custCareIntDdwn.getSelect().getFirstSelectedOption().getText()
				.equalsIgnoreCase(institute.getCustomerCareIntlISDCode())
				&& custCareIntNoTxtBx.getAttribute(ATTRIBUTE_VALUE).equalsIgnoreCase(
						institute.getCustomerCareIntlNo()));
			}
		catch(Exception e)
		{
			logg.error("Error in Verifying Customer Care International details",e);
			e.printStackTrace();
			return false;
		}
	}

	public boolean verifyCustCareVIP(InstitutionCreation institute) {
		try{
		return (custCareVIPDdwn.getSelect().getFirstSelectedOption().getText()
				.equalsIgnoreCase(institute.getCustomerCareVIPISDCode())
				&& custCareVIPNoTxtBx.getAttribute(ATTRIBUTE_VALUE).equalsIgnoreCase(
						institute.getCustomerCareVIPNo()));
		}
		catch(Exception e)
		{
			logg.error("Error in Verifying Customer Care VIP details",e);
			e.printStackTrace();
			return false;
		}
	}

	private void enterCustomerVIP(InstitutionCreation institute) {
		selectValueFromDropDown(custCareVIPDdwn,
				institute.getCustomerCareVIPISDCode());
		enterValueinTextBox(custCareVIPNoTxtBx,
				institute.getCustomerCareVIPNo());
	}

	public void navigateToTab(String tabName) {
		Element(tab.replace("%s", tabName)).click();
	}

	public void enterContactName(InstitutionCreation institute) {
		enterValueinTextBox(contactName, institute.getContactName());
	}

	public void enterPhoneNumber(InstitutionCreation institute) {
		enterValueinTextBox(phoneNoTxtBx, institute.getPhoneNumb());
	}

	public void selectMobileNumberCountryCode(InstitutionCreation institute) {
		selectValueFromDropDown(mobileNoCountryCodeDrpDwn,
				institute.getMobileCountryCode());
	}

	public void enterMobileNumberCountryCode(InstitutionCreation institute) {
		enterValueinTextBox(mobileNoTxtBx, institute.getMobilenumber());
	}

	public void enterAddressTabEmailID(InstitutionCreation institute) {
		enterValueinTextBox(emailIDAddressTxtBx, institute.getEmailID());
	}

	public void enterAddressLine1(InstitutionCreation institute) {
		enterValueinTextBox(addressLine1TxtBX, institute.getAddressLine1());

	}

	public void enterAddressLine2(InstitutionCreation institute) {
		enterValueinTextBox(addressLine2TxtBx, institute.getAddressLine2());
	}

	public void enterAddressLine3(InstitutionCreation institute) {
		enterValueinTextBox(addressLine3TxtBX, institute.getAddressLine3());
	}

	public void enterAddressLine4(InstitutionCreation institute) {
		enterValueinTextBox(addressLine4TxtBx, institute.getAddressLine4());
	}

	public void selectCountry(InstitutionCreation institute) {
		selectValueFromDropDown(countryDrpDwn, institute.getCountry());

	}

	public void enterNewInstitutionName(InstitutionCreation institute) {
		enterValueinTextBox(searchInstitutionName,
				institute.getInstitutionName());
	}
	public void enterNewInstitutionCode(InstitutionCreation institute) {
		enterValueinTextBox(searchInstitutionCodeTxt,
				institute.getInstitutionCode());
	}

	public void searchNewInstitution() {
		clickWhenClickable(searchBtn);
	}

	public void enterPostalCode(InstitutionCreation institute) {
		enterText(postalCodeTxtBX, institute.getPostalCode());
		waitForLoaderToDisappear();
	}

	public void enterAgentPortalAdminID(InstitutionCreation institute) {
		enterText(agentPortalAdminID, institute.getAgentPortalAdminID());
	}

	public void enterAgentPortalAdminName(InstitutionCreation institute) {
		enterText(agentPortalAdminName, institute.getAgentPortalAdminName());
	}

	public void enterAgentPortalAddressLine1(InstitutionCreation institute) {
		enterText(agentAddressline1, institute.getAddressLine1());
	}

	public void enterAgentPortalAddressLine2(InstitutionCreation institute) {
		enterText(agentAddressline2, institute.getAddressLine2());
	}

	public void selectAgentPortalCountryCode(InstitutionCreation institute) {
		selectValueFromDropDown(agentCountryCode, institute.getCountry());
	}

	public void clickAgentPortalLogo() {
		clickWhenClickable(agentPortalLogoBtn);
	}

	public void clickUploadPhotoButtonAgentPortal() {
		clickWhenClickable(uploadPhotoAgentBtn);
	}

	public void enterZipCodeAgentPortal(InstitutionCreation institute) {
		enterText(agentZipCode, institute.getPostalCode());
	}

	public void enterPhoneNumberAgentPortal(InstitutionCreation institute) {
		enterText(agentPhone, institute.getPhoneNumb());
	}

	public void selectAgentPortalMobileCountryCode(InstitutionCreation institute) {
		selectValueFromDropDown(agentMobileCountrycode,
				institute.getMobileCountryCode());
	}

	public void enterAgentPortalMobileNumber(InstitutionCreation institute) {
		enterText(agentMobileNumber, institute.getMobilenumber());
	}

	public void enterAgentPortalEmail(InstitutionCreation institute) {
		enterText(agentEmailTxt, institute.getEmailID());
	}

	public void enterCollectPortalAdminID(InstitutionCreation institute) {
		enterText(collectPortalAdminID, institute.getCollectPortalAdminID());
	}

	public void enterCollectPortalAdminName(InstitutionCreation institute) {
		enterText(collectPortalAdminName, institute.getCollectPortalAdminName());
	}

	public void clickCollectPortalLogo() {
		clickWhenClickable(creditInstitutionLogoBtn);
	}

	public void clickCollectPortalUploadPhotoButton() {
		clickWhenClickable(uploadCPAdminPhotoBtn);
	}

	public void enterCollectAddressLine1(InstitutionCreation institute) {
		enterText(collectPortaladdressLine1, institute.getAddressLine1());
	}

	public void enterCollectAddressLine2(InstitutionCreation institute) {
		enterText(collectPortaladdressLine2, institute.getAddressLine2());
	}

	public void selectCollectPortalCountry(InstitutionCreation institute) {
		selectValueFromDropDown(collectPortalCountryDD, institute.getCountry());
	}

	public void enterCollectPostalCode(InstitutionCreation institute) {
		enterText(collectPortalPostalCodeTxt, institute.getPostalCode());
	}

	public void enterCollectPortalPhoneNumber(InstitutionCreation institute) {
		enterText(collectPortalPhoneTxt, institute.getPhoneNumb());
	}

	public void enterCollectPortalMobileNumber(InstitutionCreation institute) {
		enterText(collectPortalAdminMobileNumberTxt,
				institute.getMobilenumber());
	}

	public void selectCollectPortalMobileNumberCode(
			InstitutionCreation institute) {
		selectValueFromDropDown(collectPortalAdminMobileCodeDD,
				institute.getMobileCountryCode());
	}

	public void enterCollectPortalEmailID(InstitutionCreation institute) {
		enterText(collectPortalEmailIDTxt, institute.getEmailID());
	}

	/**
	 * Fill institution details. Code ,Name and abbr
	 * 
	 * @param name
	 * @param code
	 */
	public void provideInstitutionDetails(InstitutionCreation instutionCreation) {
		enterInstitutionCode(instutionCreation);
		enterInstitutionName(instutionCreation);
		enterInstitutionAbbreviation(instutionCreation);
	}

	public void provideGeneralDetails(InstitutionCreation institution) {
		String[] institutionType = new String[2];
		try {
			selectInstitutionCurrency(institution);
			selectDefaultlanguage(institution);
			if (institution.getInstitutionType().contains("-")) {
				institutionType = institution.getInstitutionType().split("-");
			}
			else{
				institutionType[0] = institution.getInstitutionType();
				institutionType[1] = "Any";
			}
			if (institutionType[0].equalsIgnoreCase(Constants.PREPAID)
					|| institutionType[1].equalsIgnoreCase(Constants.PREPAID)) {
				createPrepaidInstitute(institution);
				}

			if (institutionType[0].equalsIgnoreCase(Constants.CREDIT)
					|| institutionType[1].equalsIgnoreCase(Constants.CREDIT)) {
				createCreditInstitute(institution);
				}
			if (institutionType[0].equalsIgnoreCase(Constants.DEBIT)
					|| institutionType[1].equalsIgnoreCase(Constants.DEBIT)) {
				enterAccountNumberLength(institution);
			}
			if (institutionType[0].equalsIgnoreCase(Constants.ALL)
					|| institutionType[1].equalsIgnoreCase(Constants.ALL)) {
				createPrepaidInstitute(institution);
				createCreditInstitute(institution);
				enterAccountNumberLength(institution);
			}
			selectTimeZone(institution);
			enterClientNumberLength(institution);
			clickWhenClickable(institutionLogo);
			uploadInstitutionLogo(institutionLogoImg);
			clickWhenClickable(uploadPhotoBtn);
			checkRSASupport();
			selectFinancialYearStartMonth(institution);
			selectSDNPlan(institution);
		} catch (Exception e) {
			logg.error("Error in providing general details :: " ,e);
			e.printStackTrace();
		}
	}

	public void provideCustomCareDetails(InstitutionCreation instution) {
		try {
			enterCustomerContactNumber(instution);
			enterGeneralTabEmailID(instution);
			enterCustomerFax(instution);
		} catch (Exception e) {
			logg.error("Error in providing Customer Care details" ,e);
		}
	}

	public void provideCustomerCareIntVIPno(InstitutionCreation instution) {
		try {
			enterCustomerIntl(instution);
			enterCustomerVIP(instution);
		} catch (Exception e) {
			logg.error("Error in providing Customer Care International details"
					,e);
		}
	}

	public void providePersonalDetailsAdressTab(InstitutionCreation instution) {
		try {
			enterContactName(instution);
			enterPhoneNumber(instution);
			selectMobileNumberCountryCode(instution);
			enterMobileNumberCountryCode(instution);
			enterAddressTabEmailID(instution);
		} catch (Exception e) {
			logg.error("Error in providing personal details" ,e);
		}
	}

	public void uploadInstitutionLogo(String logoImagePath) throws AWTException {
		String folderpath = System.getProperty("user.dir");
		StringSelection ss = new StringSelection(folderpath + logoImagePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// imitate mouse events like ENTER, CTRL+C, CTRL+V
		Robot robot = new Robot();
		robot.delay(2500);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void provideAddressDetails(InstitutionCreation instution) {
		try {
			enterAddressLine1(instution);
			enterAddressLine3(instution);
			enterAddressLine4(instution);
			selectCountry(instution);
			enterPostalCode(instution);
			enterAddressLine2(instution);
			waitForLoaderToDisappear();
		} catch (Exception e) {
			logg.error("Error in providing address details" ,e);
		}
	}

	public boolean verifyErrorsOnInstitutePage() {
		boolean isAnyError = false;
		if (iselementPresent(Elements(activeTab))) {
			for (WebElement element : Elements(tabWithError)) {
				element.click();
				pageErrorValidator();
			}
			isAnyError = publishErrorOnPage();
		}
		return isAnyError;
	}

	public void verifyNewInstituteCreationSuccess(InstitutionCreation instution) {
		try{
		if (!verifyErrorsOnInstitutePage()) {
			SwitchToDefaultFrame();
			enterNewInstitutionName(instution);
			searchNewInstitution();
			for (int l = 0; l < 21; l++) {
				if (!waitForRow())
					clickSearchButton();
				else {
					break;
				}
			}
			for (MCWebElement element : resultTableRow.getElements()) {
				Assert.assertTrue(element.getText().contains(
						instution.getInstitutionName()));
				Assert.assertTrue(element.getText().contains(
						instution.getInstitutionCode()));
			}
			MapUtils.fnSetInputDataToInputMap("CreatedInstitution",
					instution.getInstitutionName());
			logg.info("Institution has been created successfully : {} "
					+ buildDescriptionAndCode(instution.getInstitutionName(),
							instution.getInstitutionCode()));
		} else {
			logg.error("Error in new intitution creation");
		}
		}catch(Exception e)
		{
			logg.error("Error in new intitution creation"+ e);
			e.printStackTrace();
		}
	}

	public void enterInstitutionName(InstitutionCreation institute) {
		enterValueinTextBox(institutionName, institute.getInstitutionName());
	}

	public void save() {
		clickWhenClickable(saveBtn);
		waitForLoaderToDisappear();
	}
	
	public void cancel() {
		clickWhenClickable(cancelBtn);
		SwitchToDefaultFrame();
	}

	public void provideInstitutionType(InstitutionCreation institution) {
		String[] institutionType = new String[2];
		try {
			if (institution.getInstitutionType().contains("-")) {
				institutionType = institution.getInstitutionType().split("-");
			}
			else{
				institutionType[0] = institution.getInstitutionType();
				institutionType[1] = "Any";
			}

			if (institutionType[0].equalsIgnoreCase(Constants.DEBIT)
					|| institutionType[1].equalsIgnoreCase(Constants.DEBIT)) {
				checkDebit();
			}
			if (institutionType[0].equalsIgnoreCase(Constants.PREPAID)
					|| institutionType[1].equalsIgnoreCase(Constants.PREPAID)) {
				checkPrepaid();
				
			}
			if (institutionType[0].equalsIgnoreCase(Constants.CREDIT)
					|| institutionType[1].equalsIgnoreCase(Constants.CREDIT)) {
				checkCredit();
			}
			if (institutionType[0]
					.equalsIgnoreCase(Constants.ALL)) {
				checkDebit();
				checkPrepaid();
				checkCredit();
			}

		} catch (Exception e) {
			logg.error("Error in selecting intitutionType "
					+ institution.getInstitutionType() + ":::" ,e);
			e.printStackTrace();
		}
	}

	public void createPrepaidInstitute(InstitutionCreation institution)
			throws AWTException {
		selectInstitutionReferenceCurrency(institution);
		if (checkAgentPortalSupport()) {
			clickWhenClickable(agentPortalTab);
			enterAgentPortalAdminID(institution);
			enterAgentPortalAdminName(institution);
			enterAgentPortalAddressLine1(institution);
			enterAgentPortalAddressLine2(institution);
			selectAgentPortalCountryCode(institution);
			clickAgentPortalLogo();
			uploadInstitutionLogo(agentPortalLogoImg);
			clickUploadPhotoButtonAgentPortal();
			enterZipCodeAgentPortal(institution);
			waitForLoaderToDisappear();
			enterPhoneNumberAgentPortal(institution);
			selectAgentPortalMobileCountryCode(institution);
			enterAgentPortalMobileNumber(institution);
			enterAgentPortalEmail(institution);
			clickWhenClickable(generalTab);
		}
	}

	public void createCreditInstitute(InstitutionCreation institution)
			throws AWTException {
		if (checkCollectportalSupport()) {
			clickWhenClickable(collectPortalTab);
			enterCollectPortalAdminID(institution);
			enterCollectPortalAdminName(institution);
			enterCollectAddressLine1(institution);
			enterCollectAddressLine2(institution);
			selectCollectPortalCountry(institution);
			clickCollectPortalLogo();
			uploadInstitutionLogo(collectPortalLogoImg);
			clickCollectPortalUploadPhotoButton();
			enterCollectPostalCode(institution);
			enterCollectPortalPhoneNumber(institution);
			selectCollectPortalMobileNumberCode(institution);
			enterCollectPortalMobileNumber(institution);
			enterCollectPortalEmailID(institution);
			clickWhenClickable(generalTab);
		}
	}

	public void provideAdaptiveAuthentication(InstitutionCreation institution) {
		selectACSVendor(institution);
		selectCheckBox(mpinChkBx, "MPIN Enabled");
		selectCheckBox(smsProvider, "SMS Service Provider");
	}
	
	public void selectACSVendor(InstitutionCreation institution) {
		WebElementUtils.selectDropDownByVisibleText(adaptiveEcommFlagDDwn, institution.getAdaptiveAuthentication());
	}

	public void enterNewInstitution(InstitutionCreation institution) {
		enterNewInstitutionName(institution);
		searchNewInstitution();
		editFirstRecord();
		switchToIframe(Constants.EDIT_INSTITUTION_FRAME);
	}

	public boolean validateCustomerCareIntlVIP(InstitutionCreation institution) {
		return (verifyCustCareIntl(institution) && verifyCustCareVIP(institution));	
	}

	public void updateCustomerCareIntlVIP(InstitutionCreation institution) {
		institution.setCustomerCareIntlNo(CustomUtils.RandomNumbers(6));
		enterCustomerIntl(institution);
		institution.setCustomerCareVIPNo(CustomUtils.RandomNumbers(6));
		enterCustomerVIP(institution);
	}

	public String getInstUpdateMessage() {
		return instituteUpdateMessage.getText();
	}
	public void checkErrorOnPage() {
		if (!publishErrorOnPage()) {
			logg.info("Instituion Added Successfully.");
			SwitchToDefaultFrame();
		} else {
			logg.info("Error in Instituion Creation");
			clickWhenClickable(cancelBtn);
			SwitchToDefaultFrame();
		}

	}
}
