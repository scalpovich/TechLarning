package com.mastercard.pts.integrated.issuing.pages.agent.services;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.agent.services.DeviceSale;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.DBUtility;
import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.utils.SimulatorUtilities;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = ServicesNav.TAB_SERVICES, treeMenuItems = {
		ServicesNav.L1_DEVICE_SALE_ISSUANCE, ServicesNav.L2_DEVICE_SALE })
public class DeviceSalePage extends AbstractBasePage {
	private static final Logger logger = LoggerFactory
			.getLogger(DeviceSalePage.class);
	private static final String QUERY_STRING_DEVICE_NUMBER_PREPAID_EMV = "SELECT * FROM Device d WHERE d.BANK_CODE  = '121212' AND d.PRODUCT_TYPE = 'P' AND d.STATUS_CODE  = '0' AND d.device_plan_code in (select dp.device_plan_code from device_plan dp where device_type = '2' and dp.bank_code = d.bank_code) order by d.ACTIVATION_DATE desc";
	private static final String QUERY_STRING_DEVICE_NUMBER_PREPAID_MAGSTRIPE = "SELECT * FROM Device d WHERE d.BANK_CODE  = '121212' AND d.PRODUCT_TYPE = 'P' AND d.STATUS_CODE  = '0' AND d.device_plan_code in (select dp.device_plan_code from device_plan dp where device_type = '1' and dp.bank_code = d.bank_code) order by d.ACTIVATION_DATE desc";
	private static final String PREPAID = "prepaid";
	private static final String EMV = "emv";
	private static final String MAGSTRIPE = "magnetic stripe";
	private static final String DEVICE_NUMBER_COLUMN_NAME = "DEVICE_NUMBER";

	private String activeDeviceNumber;

	@Autowired
	private DBUtility dbUtility;

	private String applicationCreatedMessage;

	@Value("${default.wait.timeout_in_sec}")
	private long timeoutInSec;

	// main screen locators
	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='WIR']")
	private MCWebElement newCustomerWithRegistrationRbtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='WOR']")
	private MCWebElement newCustomerWithOutRegistrationRbtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='ENP']")
	private MCWebElement existingCustomerNewProgramRbtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='END']")
	private MCWebElement existingCustomerAdditionalDeviceSelfRbtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='ENA']")
	private MCWebElement existingCustomerAdditionalDeviceOthersRbtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='CUR']")
	private MCWebElement existingCustomerRegistrationRbtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#existingDeviceNumber")
	private MCWebElement primaryDeviceNumberTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#programCode")
	private MCWebElement programCodeDdwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#deviceType")
	private MCWebElement deviceTypeDdwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#cardPackID")
	private MCWebElement cardPackIdTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#mobileNumber")
	private MCWebElement mobileNumberTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#submit")
	private MCWebElement processBtn;

	// program details page
	@PageElement(findBy = FindBy.CSS, valueToFind = "#title")
	private MCWebElement titleDdwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#firstName")
	private MCWebElement firstNameTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#lastName")
	private MCWebElement lastNameTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#married")
	private MCWebElement maritalStatusDdwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#gender")
	private MCWebElement genderDdwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#nationality")
	private MCWebElement nationalityDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "birthDate1")
	private MCWebElement birthDatePickerDpkr;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#languagePreferences")
	private MCWebElement languagePreferencesDdwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value = 'Next']")
	private MCWebElement nextBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#preferredMailingAddress")
	private MCWebElement preferredMailingAddressDdwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#currentAddressLine1")
	private MCWebElement currentAddressLine1Txt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#permanentAddressLine1")
	private MCWebElement permanentAddressLine1Txt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#currentCountryCode")
	private MCWebElement countryDdwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#currentZipCode")
	private MCWebElement postalCodeTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#applicantProf")
	private MCWebElement applicantProfessionDdwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#kycStatus")
	private MCWebElement kycStatusChkBx;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#kycRemarks")
	private MCWebElement kycRemarksTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#legalId1Type")
	private MCWebElement document1TypeDdwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#legalId1")
	private MCWebElement legalId1Txt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Submit']")
	private MCWebElement submitBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Ok']")
	private MCWebElement okBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = ".SuccessMessageTxt")
	private MCWebElement applicationSuccessMessage;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#sourceAmount_1")
	private MCWebElement initialLoadAmountTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#sourceCurrency_1")
	private MCWebElement initialCurrencyDdwn;
	
	public void verifyUiOperationStatus() {
		logger.info("Sale");
		verifyButton("Process");
		verifyButton("Cancel");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays
				.asList(WebElementUtils.visibilityOf(masterDetailContentTitle),
						WebElementUtils
								.visibilityOf(newCustomerWithRegistrationRbtn),
						WebElementUtils
								.visibilityOf(newCustomerWithOutRegistrationRbtn),
						WebElementUtils
								.visibilityOf(existingCustomerNewProgramRbtn),
						WebElementUtils
								.visibilityOf(existingCustomerAdditionalDeviceSelfRbtn),
						WebElementUtils
								.visibilityOf(existingCustomerAdditionalDeviceOthersRbtn),
						WebElementUtils
								.visibilityOf(existingCustomerRegistrationRbtn),
						WebElementUtils.visibilityOf(programCodeDdwn),
						WebElementUtils.visibilityOf(deviceTypeDdwn));
	}

	// methods
	public String getMasterDetailContentTitleText() {
		logger.info("Corporate User View Edit Master Detail Tilte Text: {}");
		return new WebDriverWait(driver(), timeoutInSec).until(
				WebElementUtils.visibilityOf(masterDetailContentTitle))
				.getText();
	}

	public void clickNewCustomerWithRegistrationRadioButton() {
		new WebDriverWait(driver(), timeoutInSec).until(
				WebElementUtils
						.elementToBeClickable(newCustomerWithRegistrationRbtn))
				.click();
	}

	public void clickNewCustomerWithOutRegistrationRadioButton() {
		new WebDriverWait(driver(), timeoutInSec)
				.until(WebElementUtils
						.elementToBeClickable(newCustomerWithOutRegistrationRbtn))
				.click();
	}

	public void clickExistingCustomerNewProgamRadioButton() {
		new WebDriverWait(driver(), timeoutInSec).until(
				WebElementUtils
						.elementToBeClickable(existingCustomerNewProgramRbtn))
				.click();
	}

	public void clickExistingCustomerAdditionalDeviceSelfRadioButton() {
		new WebDriverWait(driver(), timeoutInSec)
				.until(WebElementUtils
						.elementToBeClickable(existingCustomerAdditionalDeviceSelfRbtn))
				.click();
	}

	public void clickExistingCustomerAdditionalDeviceOthersRadioButton() {
		new WebDriverWait(driver(), timeoutInSec)
				.until(WebElementUtils
						.elementToBeClickable(existingCustomerAdditionalDeviceOthersRbtn))
				.click();
	}

	public void clickExistingCustomerRegistrationRadioButton() {
		new WebDriverWait(driver(), timeoutInSec)
				.until(WebElementUtils
						.elementToBeClickable(existingCustomerRegistrationRbtn))
				.click();
	}

	public void enterPrimaryDeviceNumber(String primaryDeviceNumber) {
		WebElementUtils.enterText(primaryDeviceNumberTxt, primaryDeviceNumber);
	}

	public void selectProgramCode(String programCode) {
		WebElementUtils.selectDropDownByVisibleText(programCodeDdwn,
				programCode);
	}

	public void selectDeviceType(String deviceType) {
		WebElementUtils.selectDropDownByVisibleText(deviceTypeDdwn, deviceType);
	}

	public void enterCardPackId(String cardPackId) {
		WebElementUtils.enterText(cardPackIdTxt, cardPackId);
	}

	public void enterMobileNumber(String mobileNumber) {
		WebElementUtils.enterText(mobileNumberTxt, mobileNumber);
	}

	public void clickProcessButton() {
		new WebDriverWait(driver(), timeoutInSec).until(
				WebElementUtils.visibilityOf(processBtn)).click();
	}

	public void selectTitle(String title) {
		WebElementUtils.selectDropDownByVisibleText(titleDdwn, title);
	}

	public void enterFirstName(String firstName) {
		WebElementUtils.enterText(firstNameTxt, firstName);
	}

	public void enterLastName(String lastName) {
		WebElementUtils.enterText(lastNameTxt, lastName);
	}

	public void selectMaritalStatus(String maritalStatus) {
		WebElementUtils.selectDropDownByVisibleText(maritalStatusDdwn,
				maritalStatus);
	}

	public void selectGender(String gender) {
		WebElementUtils.selectDropDownByVisibleText(genderDdwn, gender);
	}

	public void selectNationality(String nationality) {
		WebElementUtils.selectDropDownByVisibleText(nationalityDdwn,
				nationality);
	}

	public void selectLanguagePreference(String languagePreference) {
		WebElementUtils.selectDropDownByVisibleText(languagePreferencesDdwn,
				languagePreference);
	}

	@Override
	public void clickNextButton() {
		WebElementUtils.scrollDown(driver(), 0, 250);
		new WebDriverWait(driver(), timeoutInSec).until(
				WebElementUtils.elementToBeClickable(nextBtn)).click();
	}

	public void selectPreferredMailingAddress(String preferredMailingAddress) {
		WebElementUtils.selectDropDownByVisibleText(
				preferredMailingAddressDdwn, preferredMailingAddress);
	}

	public void enterCurrentAddressLine1(String currentAddressLine1) {
		WebElementUtils.enterText(currentAddressLine1Txt, currentAddressLine1);
	}

	public void enterPermanentAddressLine1(String permanentAddressLine1) {
		WebElementUtils.enterText(permanentAddressLine1Txt,
				permanentAddressLine1);
	}

	public void selectCountry(String country) {
		WebElementUtils.selectDropDownByVisibleText(countryDdwn, country);
	}

	public void enterPostalCode(String postalCode) {
		postalCodeTxt.click();
		WebElementUtils.enterText(postalCodeTxt, postalCode);
	}

	public void selectApplicantProfession(String applicantProfession) {
		WebElementUtils.selectDropDownByVisibleText(applicantProfessionDdwn,
				applicantProfession);
	}

	public void clickKYCStatusCheckBox() {
		kycStatusChkBx.click();
	}

	public void enterKycRemarks(String kycRemarks) {
		WebElementUtils.enterText(kycRemarksTxt, kycRemarks);
	}

	public void selectDocument1Type(String passportType) {
		WebElementUtils.selectDropDownByVisibleText(document1TypeDdwn,
				passportType);
	}

	public void enterLegalId1(String legalId1) {
		WebElementUtils.enterText(legalId1Txt, legalId1);
	}

	public void clickSubmitButton() {
		WebElementUtils.scrollDown(driver(), 0, 250);
		new WebDriverWait(driver(), timeoutInSec).until(
				WebElementUtils.elementToBeClickable(submitBtn)).click();
	}

	public void clickOKButton() {
		new WebDriverWait(driver(), timeoutInSec).until(
				WebElementUtils.elementToBeClickable(okBtn)).click();
	}

	public void enterCurrentDateddMMyyyy(String date) {
		WebElementUtils.enterText(birthDatePickerDpkr, date);
	}

	public String getApplicationCreatedMessage() {
		return new WebDriverWait(driver(), timeoutInSec).until(
				WebElementUtils.visibilityOf(applicationSuccessMessage))
				.getText();
	}

	public void verifyApplicationSuccessMessage() {
		new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils
				.visibilityOf(applicationSuccessMessage));
	}

	public void processApplication(DeviceSale details) {
		selectProgramCode(details.getProgram());
		selectDeviceType(details.getDeviceType());
		enterCardPackId(details.getCardPackId());
		clickProcessButton();
	}

	public void processApplicationForExistingCustomer(DeviceSale details) {
		clickExistingCustomerRegistrationRadioButton();
		enterCardPackId(details.getCardPackId());
		clickProcessButton();
	}

	public void fillApplicationDetails1(DeviceSale details) {
		selectTitle(details.getTitle());
		enterFirstName(details.getFirstName());
		enterLastName(details.getLastName());
		selectMaritalStatus(details.getMaritalStatus());
		selectGender(details.getGender());
		selectNationality(details.getNationality());
		enterCurrentDateddMMyyyy(DateUtils.currentDateddMMyyyy());
		selectLanguagePreference(details.getLanguagePreference());
		clickNextButton();
		selectPreferredMailingAddress(details.getPreferredMailingAddress());
		enterCurrentAddressLine1(details.getCurrentAddressLine1());
		selectCountry(details.getCountry());
		enterPostalCode(details.getPostalCode());
		WebElementUtils.asWebElement(postalCodeTxt).sendKeys(Keys.TAB);
		clickNextButton();
		selectApplicantProfession(details.getApplicantProfession());
	}

	public void fillApplicationDetails2AndSubmit(String transactionDetails) {
		clickNextButton();
		enterTransactionDetails(transactionDetails);
		SimulatorUtilities.wait(3000);
		clickSubmitButton();
	}
	
	public void enterTransactionDetails(String transactionDetails) {
		int rowCount = driver().findElements(By.xpath("//*[@class='dataview']/tbody[1]/tr[@class='even' or @class = 'odd']")).size();
		String[] values = transactionDetails.trim().split(",");
			for (int i = 0; i < values.length ; i++)
			{
				for (int j = 1; j <= rowCount; j++)
				{
					String[] data = values[i].trim().split(":");
					String currencyName = data[0].trim();
					String xpathBuild = "//*[@class='dataview']/tbody[1]/tr[@class='even' or @class='odd']["+j+"]";
					if (driver().findElement(By.xpath(xpathBuild+"/td[2]")).getText().trim().equalsIgnoreCase(currencyName))
					{
						String transactionAmountCSS = "#sourceAmount_"+j;
						driver().findElement(By.cssSelector(transactionAmountCSS)).sendKeys(data[1].trim());
						String transactionCurrencyCSS = "#sourceCurrency_"+j;
						WebElementUtils.retryUntilNoErrors(() -> new Select(driver().findElement(By.cssSelector(transactionCurrencyCSS))).selectByVisibleText(data[2].trim()));
						break;
					}
				}
			}
	}

	
	public void deviceSaleWithRegistration(DeviceSale details) {
		logger.info("Device Sale with Registration: {}", details.getProgram());

		processApplication(details);
		fillApplicationDetails1(details);
		selectDocument1Type(details.getDocument1Type());
		enterLegalId1(details.getLegalId());
		fillApplicationDetails2AndSubmit(details.getInitialLoadTxnDetails());
	}

	public void deviceSaleWithoutRegistration(DeviceSale details) {
		logger.info("Device Sale without Registration: {}",
				details.getProgram());

		clickNewCustomerWithOutRegistrationRadioButton();
		processApplication(details);
		verifyApplicationSuccessMessage();
		applicationCreatedMessage = getApplicationCreatedMessage();
		clickOKButton();
	}

	public String getApplicationCreatedSuccessMessage() {
		return applicationCreatedMessage;
	}

	public void deviceSaleThroughCustomerRegistration(DeviceSale details) {
		logger.info(
				"Device Sale without Registration and through Customer Registration: {}",
				details.getProgram());

		processApplicationForExistingCustomer(details);
		fillApplicationDetails1(details);
		selectDocument1Type(details.getDocument1Type());
		enterLegalId1(details.getLegalId());
		fillApplicationDetails2AndSubmit(details.getInitialLoadTxnDetails());
	}

	public void deviceSaleThroughNewProgram(DeviceSale details) {
		logger.info("Device Sale through Customer New Program: {}",
				details.getProgram());
		clickExistingCustomerNewProgamRadioButton();
		enterPrimaryDeviceNumber(details.getPrimaryDeviceNumber());
		WebElementUtils.asWebElement(primaryDeviceNumberTxt).sendKeys(Keys.TAB);
		processApplication(details);
		clickNextButton();
		clickNextButton();
		clickNextButton();
		//if to enter mandatory field
		if (driver().findElements(By.cssSelector(".feedbackPanelERROR")).size() > 0) {
			selectApplicantProfession(details.getApplicantProfession());
			clickNextButton();
		}
		enterTransactionDetails(details.getInitialLoadTxnDetails());
		clickSubmitButton();
	}

	public String getActiveDeviceNumberFromDb(String productType,
			String deviceType) {

		if (PREPAID.equalsIgnoreCase(productType)
				&& EMV.equalsIgnoreCase(deviceType)) {
			activeDeviceNumber = dbUtility.getSingleRecordColumnValueFromDB(
					QUERY_STRING_DEVICE_NUMBER_PREPAID_EMV,
					DEVICE_NUMBER_COLUMN_NAME);
		}
		if (PREPAID.equalsIgnoreCase(productType)
				&& MAGSTRIPE.equalsIgnoreCase(deviceType)) {
			activeDeviceNumber = dbUtility.getSingleRecordColumnValueFromDB(
					QUERY_STRING_DEVICE_NUMBER_PREPAID_MAGSTRIPE,
					DEVICE_NUMBER_COLUMN_NAME);
		}
		return activeDeviceNumber;
	}
}