package com.mastercard.pts.integrated.issuing.pages.customer.administration;

import junit.framework.Assert;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.admin.InstitutionCreation;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.ProcessingCenterNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
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

	final Logger logger = LoggerFactory
			.getLogger(InstitutionCreationPageNew.class);

	// ------------- Processing Center > Setup > Master Parameters > Institution
	// [CESM01]

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
	private MCWebElement timeZoneDrpDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "zipMandatoryFlag:checkBoxComponent")
	private MCWebElement domesticPcodeMandChkBx;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//select[contains(@name,'financialStartMonth')]")
	private MCWebElement financialStartMonth;

	@PageElement(findBy = FindBy.NAME, valueToFind = "accLen:input:inputTextField")
	private MCWebElement accNoLengthTxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "clientLen:input:inputTextField")
	private MCWebElement clientNoLengthTxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "ofacPlanCode:input:dropdowncomponent")
	private MCWebElement sdnPlanDrpDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "customerCareContactNumbers:input:inputTextField")
	private MCWebElement custCareContactNoTxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "customerCareEmailId:input:inputTextField")
	private MCWebElement General_emailIdTxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "customerCareFax:input:inputTextField")
	private MCWebElement custCareFaxTxtBx;

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

	@PageElement(findBy = FindBy.ID, valueToFind = "institution_selection")
	private MCWebElement instituteSelectionDrpDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@id='institution_selector']//li")
	private MCWebElement instituteSelectionValue;

	@PageElement(findBy = FindBy.ID, valueToFind = "institution")
	private MCWebElement institutionDdwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[.='Institution Name']/following::input[1]")
	private MCWebElement searchInstitutionName;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value='Search']")
	private MCWebElement searchBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//tbody//tr")
	private MCWebElements resultTableRow;

	private String TAB = "//a[.='%s']";

	private String activeTab = "//li[@class='activetb']/a";

	private String TabWithError = "//ul[@class='tabs']//span[@class='tabError']/..";

	private String instituteSelectionVal = "//div[@id='institution_selector']//li/a[contains(text(),'%s')]";

	// ------------- Processing Center > Setup > Master Parameters > Institution
	// > Add Institution > Agent portal

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[.='Agent Portal']")
	private MCWebElements agentPortaltab;

	// ------------- Processing Center > Setup > Master Parameters > Institution
	// > Add Institution > Collect portal

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[.='Collect Portal']")
	private MCWebElements collectPortaltab;

	// Adaptive Authentication - RSA
	@PageElement(findBy = FindBy.NAME, valueToFind = "adaptiveEcommFlag:checkBoxComponent")
	private MCWebElement adaptiveEcommChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mpinEnabled:checkBoxComponent")
	private MCWebElement mpinChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "issuerSmsProvider:checkBoxComponent")
	private MCWebElement issuerSmsProviderChkBx;

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
		selectCheckBox(debitChkBX, "Debit");
	}

	public void checkCredit() {
		selectCheckBox(creditChkBx, "Credit");
	}

	public void checkPrepaid() {
		selectCheckBox(prepaidChkBx, "Prepaid");
	}

	public void selectInstitutionCurrency(InstitutionCreation institute) {
		selectValueFromDropDown(this.institutionCurrency,
				institute.getInstitutionCurrency());

	}

	public void selectInstitutionReferenceCurrency(InstitutionCreation institute) {
		selectValueFromDropDown(this.institutionReferenceCurrency,
				institute.getInstitutionReferenceCurrency());
	}

	public void selectDefaultlanguage(InstitutionCreation institute) {
		selectValueFromDropDown(defaulLanguageDrpDwn,
				institute.getDefaultLanguage());

	}

	public void selectTimeZone(InstitutionCreation institute) {
		selectValueFromDropDown(timeZoneDrpDwn, institute.getTimeZone());
	}

	public boolean checkAgentPortalSupport() {
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

	@SuppressWarnings("deprecation")
	public void enterAccountNumberLength(InstitutionCreation institute) {
		if (checkAccountLenghtValidation()) {
			Assert.assertTrue(accNoLengthTxtBx.getAttribute("disabled")
					.isEmpty());
			enterValueinTextBox(accNoLengthTxtBx,
					institute.getAccountNumberLength());
		}
	}

	@SuppressWarnings("deprecation")
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
		enterValueinTextBox(General_emailIdTxtBx, institute.getEmailID());
	}

	public void enterCustomerFax(InstitutionCreation institute) {
		enterValueinTextBox(custCareFaxTxtBx, institute.getCustomerCareFax());
	}

	public void navigateToTab(String TabName) {
		Element(TAB.replace("%s", TabName)).click();
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

	public void searchNewInstitution() {
		clickWhenClickable(searchBtn);
	}

	public void enterPostalCode(InstitutionCreation institute) {
		enterText(postalCodeTxtBX, institute.getPostalCode());
		waitForLoaderToDisappear();
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
		setInstitutionDetails(instutionCreation);
		enterInstitutionAbbreviation(instutionCreation);
	}

	public void provideGeneralDetails(InstitutionCreation institution) {
		try {
			selectInstitutionCurrency(institution);
			selectDefaultlanguage(institution);
			if (institution.getInstitutionType().equalsIgnoreCase(
					Constants.PREPAID)) {
				selectInstitutionReferenceCurrency(institution);
			}
			selectTimeZone(institution);
			if (institution.getInstitutionType().equalsIgnoreCase(
					Constants.PREPAID)) {
				checkAgentPortalSupport();
			}
			if (institution.getInstitutionType().equalsIgnoreCase(
					Constants.CREDIT)) {
				checkCollectportalSupport();
			}
			if (institution.getInstitutionType().equalsIgnoreCase(
					Constants.DEBIT)) {
				enterAccountNumberLength(institution);
			}
			enterClientNumberLength(institution);
			checkRSASupport();
			selectFinancialYearStartMonth(institution);
			selectSDNPlan(institution);
		} catch (Exception e) {
			logger.error("Error in providing general details" + e);
		}
	}

	public void provideCustomCareDetails(InstitutionCreation instution) {
		try {
			enterCustomerContactNumber(instution);
			enterGeneralTabEmailID(instution);
			enterCustomerFax(instution);
		} catch (Exception e) {
			logger.error("Error in providing general details" + e);
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
			logger.error("Error in providing personal details" + e);
		}
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
			logger.error("Error in providing address details" + e);
		}
	}

	public boolean verifyErrorsOnInstitutePage() {
		boolean isAnyError = false;
		if (iselementPresent(Elements(activeTab))) {
			for (WebElement element : Elements(TabWithError)) {
				element.click();
				pageErrorValidator();
			}
			isAnyError = publishErrorOnPage();
		}
		return isAnyError;
	}

	@SuppressWarnings("deprecation")
	public void verifyNewInstituteCreationSuccess(InstitutionCreation instution) {
		if (!verifyErrorsOnInstitutePage()) {
			SwitchToDefaultFrame();
			enterNewInstitutionName(instution);
			searchNewInstitution();
			for (MCWebElement element : resultTableRow.getElements()) {
				System.out.println(instution.getInstitutionName());
				System.out.println(instution.getInstitutionCode());
				System.out.println(element.getText());
				Assert.assertTrue(element.getText().contains(
						instution.getInstitutionName()));
				Assert.assertTrue(element.getText().contains(
						instution.getInstitutionCode()));
			}
		}
	}

	public void setInstitutionDetails(InstitutionCreation instutionCreation) {
		MapUtils.fnSetInputDataToInputMap("InstitutionName",
				MapUtils.fnGetInputDataFromMap("InstitutionName") + " ["
						+ instutionCreation.getInstitutionCode() + "]");
		logger.info("***************************InstitutionName*******************************"
				+ MapUtils.fnGetInputDataFromMap("InstitutionName"));
		MapUtils.fnSetInputDataToInputMap("InstitutionCode",
				instutionCreation.getInstitutionCode());
	}

	public void enterInstitutionName(InstitutionCreation institute) {
		enterValueinTextBox(institutionName, institute.getInstitutionName());
	}

	public void Save() {
		clickWhenClickable(saveBtn);
		waitForLoaderToDisappear();
	}

	@SuppressWarnings("deprecation")
	public boolean agentPortalSupport() {
		boolean getAgentPortal = false;
		if (true == checkAgentPortalSupport()) {
			Assert.assertTrue(isElementPresent(agentPortaltab));
			clickWhenClickable(agentPortaltab.getElements().get(0));
			getAgentPortal = true;
		}
		return getAgentPortal;
	}

	public void provideInstitutionType(InstitutionCreation institution) {
		try {
			if (institution.getInstitutionType().equalsIgnoreCase(
					Constants.DEBIT)) {
				checkDebit();
			}
			if (institution.getInstitutionType().equalsIgnoreCase(
					Constants.PREPAID)) {
				checkPrepaid();
			}

			if (institution.getInstitutionType().equalsIgnoreCase(
					Constants.CREDIT)) {
				checkCredit();
			}
		} catch (Exception e) {
			logger.error("Error in selecting intitutionType "
					+ institution.getInstitutionType() + ":::" + e);
		}
	}

	public void provideAdaptiveAuthentication() {
		selectCheckBox(adaptiveEcommChkBx, "adaptiveEcomm");
		selectCheckBox(mpinChkBx, "mpin");
		selectCheckBox(issuerSmsProviderChkBx, "issuerSmsProvider");
	}

}
