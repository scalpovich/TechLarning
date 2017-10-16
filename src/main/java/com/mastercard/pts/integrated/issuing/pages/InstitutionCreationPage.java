package com.mastercard.pts.integrated.issuing.pages;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.MPTSBasePage;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class InstitutionCreationPage extends MPTSBasePage {

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

	@PageElement(findBy = FindBy.NAME, valueToFind = "accLen:input:inputTextField")
	private MCWebElement accNoLengthTxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "clientLen:input:inputTextField")
	private MCWebElement clientNoLengthTxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "ofacPlanCode:input:dropdowncomponent")
	private MCWebElement sdnPlanDrpDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "customerCareContactNumbers:input:inputTextField")
	private MCWebElement custCareContactNoTxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "customerCareEmailId:input:inputTextField")
	private MCWebElement emailIdTxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "customerCareFax:input:inputTextField")
	private MCWebElement custCareFaxTxtBx;

	// ------------- Processing Center > Setup > Master Parameters > Institution
	// > Add Institution > Address

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "/html/body/div[2]/div/div/form/ul/li[2]/a")
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

	@PageElement(findBy = FindBy.NAME, valueToFind = "countryCode:input:dropdowncomponent")
	private MCWebElement countryDrpDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cityCode:input:dropdowncomponent")
	private MCWebElement areaCityDrpDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "zipCode:input:inputTextField")
	private MCWebElement postalCodeTxtBX;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	/**
	 * Creates the institute. Will create institute based on Paramaters provided
	 * in excel sheet
	 *
	 * @param institutioncode
	 *            the institutioncode
	 * @param institutionname
	 *            the institutionname
	 */
	public void createInstitute(String institutioncode, String institutionname) {

		addInstitution.click();
		switchToIframe(Constants.ADD_ADD_INSTITUTION_FRAME);

		institutionCode.sendKeys(institutioncode);
		institutionName.sendKeys(institutionname);
		abbreviation.sendKeys(institutionname);

		selectCheckBx(creditChkBx, "Credit");
		selectCheckBx(prepaidChkBx, "Prepaid");
		selectCheckBx(debitChkBX, "Debit");

		selectDropDown(institutionCurrency, "Institution Currency");
		selectCheckBx(agentPortalSupportChkBx, "Agent Portal Support");
		selectCheckBx(collectPortalSupportChkBx, "Collect Portal Support");
		selectCheckBx(accLengthValChkBx, "Account Length Validation");
		selectCheckBx(clientLengthValChkBx, "Client Length Validation");
		selectCheckBx(rsaSuportChkBx, "RSA Support");

		selectDropDown(defaulLanguageDrpDwn, "Default Language");
		selectDropDown(timeZoneDrpDwn, "Time Zone");
		selectCheckBx(domesticPcodeMandChkBx, "Domestic Postal Code mandatory");
		fillTextBox(accNoLengthTxtBx, "Account Number Length");
		fillTextBox(clientNoLengthTxtBx, "Client Number Length");
		selectDropDown(sdnPlanDrpDwn, "SDN Plan");

		fillTextBox(custCareContactNoTxtBx, "Customer Care Contact Numbers");
		fillTextBox(emailIdTxtBx, "Email Id");
		fillTextBox(custCareFaxTxtBx, "Customer Care Fax");

		// Filling details on the Address Tab

		addressTab.click();
	
		fillTextBox(contactName, "Contact Name");
		fillTextBox(phoneNoTxtBx, "Phone No");
		selectDropDown(mobileNoCountryCodeDrpDwn, "Mobile No Country Code");
		fillTextBox(mobileNoTxtBx, "Mobile No");
		fillTextBox(emailIDAddressTxtBx, "Email ID");
		fillTextBox(addressLine1TxtBX, "Address Line1");
		fillTextBox(addressLine2TxtBx, "Address Line2");
		selectDropDown(countryDrpDwn, "Country");
		waitForElementVisible(areaCityDrpDwn);
		selectDropDown(areaCityDrpDwn, "Area_City");
		fillTextBox(postalCodeTxtBX, "Postal Code");

		saveBtn.click();
		getFinder().getWebDriver().switchTo().defaultContent();

	}

	private void fillTextBox(MCWebElement txtBoxElement, String fieldName) {
		String value = MapUtils.fnGetInputDataFromMap(fieldName);
		if (!value.isEmpty()) {
			txtBoxElement.sendKeys(value);
		}

	}

	private void selectDropDown(MCWebElement dropDownElement, String fieldName) {

		String value = MapUtils.fnGetInputDataFromMap(fieldName);
		if (!value.isEmpty()) {
			dropDownElement.getSelect().selectByVisibleText(value);
		}

	}

	private void selectCheckBx(MCWebElement creditChkBx, String fieldName) {

		String value = MapUtils.fnGetInputDataFromMap(fieldName);

		if (value != null) {
			if ("check".equalsIgnoreCase(value) && !creditChkBx.isSelected()) {
				creditChkBx.click();
			} else if ("uncheck".equalsIgnoreCase(value) && creditChkBx.isSelected())
				creditChkBx.click();
		}

	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		
		return null;
	}

}
