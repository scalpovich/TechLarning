package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.serenitybdd.core.annotations.findby.By;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.domain.deviceCreation.NewApplication;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.utils.ReadTestDataFromExcel;
//TODO: Auto-generated Javadoc
/**
 * @author E070234 
 */
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_ACTIVITY, CardManagementNav.L2_ACTIVITY_APPLICATION, 	CardManagementNav.L3_NEW_APPLCIATION
		})
public class NewApplicationPage extends AbstractCardManagementPage {

	private static final Logger logger = LoggerFactory.getLogger(NewApplicationPage.class);

	@Autowired
	Program program;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement AddNewApplicactionbtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:productType:input:dropdowncomponent")
	private MCWebElement AppliedForProductDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:applicationType:input:dropdowncomponent")
	private MCWebElement AppliedTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:applicationSubType:input:dropdowncomponent")
	private MCWebElement ApplicationSubtypeDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name = 'buttons:next'][@value = 'Next >']")
	private MCWebElement NextBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name = 'buttons:finish'][@value = 'Finish']")
	private MCWebElement FinishBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:applicationBatch.displayStatusFlag:input:dropdowncomponent")
	private MCWebElement CreateOpenBatchDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:generateBatch")
	private MCWebElement GenerateBatchBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:customerType:input:dropdowncomponent")
	private MCWebElement CustomerTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:programCode:input:dropdowncomponent")
	private MCWebElement ProgramCodeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:deviceType1:input:dropdowncomponent")
	private MCWebElement DeviceTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:devicePlanCode1:input:dropdowncomponent")
	private MCWebElement DevicePlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:devicePhotoIndicator1:input:dropdowncomponent")
	private MCWebElement photoIndicatorDDwn;

	//// Profile Screen
	@PageElement(findBy = FindBy.NAME, valueToFind = "view:branchCode:input:dropdowncomponent")
	private MCWebElement BranchCodeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:title:input:dropdowncomponent")
	private MCWebElement TitleDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:firstName:input:inputCodeField")
	private MCWebElement FirstnameTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:lastName:input:inputCodeField")
	private MCWebElement LastnameTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:embossedName:input:inputCodeField")
	private MCWebElement EmbossednameTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:gender:input:dropdowncomponent")
	private MCWebElement GenderDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:nationality:input:dropdowncomponent")
	private MCWebElement NationalityDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "/html/body/div[2]/div/form/table/tbody/tr/td[2]/table/tbody/tr[3]/td/div/table[1]/tbody/tr[14]/td[4]/span/span/span/img")
	private MCWebElement BirthDateCalendar;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "calnav")
	private MCWebElement CalendarNav;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "yui-cal-nav-yc")
	private MCWebElement YearTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class ='yui-cal-nav-btn yui-default']/button")
	private MCWebElement OkBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "/html/body/div[2]/div/form/table/tbody/tr/td[2]/table/tbody/tr[3]/td/div/table[1]/tbody/tr[14]/td[4]/span/span/span/span/table/tbody/tr[4]/td[3]/a")
	private MCWebElement BirthDate;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:married:input:dropdowncomponent")
	private MCWebElement MaritalStatusDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:languagePreferences:input:dropdowncomponent")
	private MCWebElement PreferredLangDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:preferredMailingAddress:input:dropdowncomponent")
	private MCWebElement PreferredAddressDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:currentAddressLine1:input:inputTextField")
	private MCWebElement AddressLine1Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:currentCountryCode:input:dropdowncomponent")
	private MCWebElement CountryDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:currentZipCode:input:inputTextField")
	private MCWebElement PostalCodeTxt;

	//// Other fields

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:middleName1:input:inputCodeField")
	private MCWebElement MiddleName1Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:middleName2:input:inputCodeField")
	private MCWebElement MiddleName2Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:maidenName:input:inputCodeField")
	private MCWebElement MaidenNameTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:vipFlag:input:dropdowncomponent")
	private MCWebElement VIPDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:birthCountry:input:dropdowncomponent")
	private MCWebElement BirthcountryDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:birthCity:input:inputTextField")
	private MCWebElement BirthCityDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:education:input:dropdowncomponent")
	private MCWebElement EducationDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:travelPurpose:checkBoxComponent")
	private MCWebElement TravelPurposechkbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:travelType:input:dropdowncomponent")
	private MCWebElement TravelTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:travelCountry:input:dropdowncomponent")
	private MCWebElement TravelCountryDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:travelStartDate:input:dateTextField")
	private MCWebElement TravelStartDate;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:travelEndDate:input:dateTextField")
	private MCWebElement TravelEndDate;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:kycStatus:checkBoxComponent ")
	private MCWebElement KycStatuschkbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:stmtHardCopyReq:input:dropdowncomponent")
	private MCWebElement StmtHardCopyReqDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:languagePreferences:input:dropdowncomponent")
	private MCWebElement LanguagePrefDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:smsAlertList:checkBoxComponent")
	private MCWebElement smsAlertchkbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:emailAlertList:checkBoxComponent")
	private MCWebElement EmailAlertchkbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:isdCode:input:dropdowncomponent")
	private MCWebElement registeredMobileISDDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:registeredMobileNumber:input:inputTextField")
	private MCWebElement registeredMobileNoTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:registeredMailId:input:inputTextField")
	private MCWebElement registeredEmailIDTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:registerForDncr:checkBoxComponent")
	private MCWebElement RegisterForDncrchkbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:corporateClientCode:input:dropdowncomponent")
	private MCWebElement CorporateClientCode;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//li[2]/span[@class='feedbackPanelINFO']")
	private MCWebElement ApplicationNumberTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//li[5]/span[@class='feedbackPanelINFO']")
	private MCWebElement ApplicationDeviceTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//li[1]/span[@class='feedbackPanelINFO']")
	private MCWebElement ApplicationSuccessTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:deliveryMode:input:dropdowncomponent")
	private MCWebElement DeliveryModeDDwn;
	List<String> MandateField = new ArrayList<String>();

	ReadTestDataFromExcel excelTestData;
	@Override
	public void verifyUiOperationStatus() {
		logger.info("Application");
		verifyUiOperation("Add Application");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(applicationNumber),
				WebElementUtils.elementToBeClickable(formNumber),
				WebElementUtils.elementToBeClickable(firstName),
				WebElementUtils.elementToBeClickable(lastName),
				WebElementUtils.elementToBeClickable(fromDate),
				WebElementUtils.elementToBeClickable(toDate));
	}

	public void setNewApplicationParametersValue() {
		setNewApplicationParameter();
	}

	public void selectMandatoryFields(String excelFileName) {
		String FieldToBeAdded = "";
		String filepath = System.getProperty("user.dir") + File.separator + "TempFiles" + File.separator
				+ excelFileName;
		System.out.println("FilePath " + filepath);
		HashMap<String, HashMap<String, String>> map = excelTestData.fnReadEntireTestData(filepath, "Sheet1",
				"SequenceNo.");

		for (int i = 1; i < map.size(); i++) {
			excelTestData.dataProviderIterator(map, String.valueOf(i));
			String Value = MapUtils.getIterativeDataFromDatamap("Value (Y/N)");
			System.out.println(Value);
			if (Value.contains("Y")) {
				FieldToBeAdded = MapUtils.getIterativeDataFromDatamap("Field Name");
				CustomUtils.ThreadDotSleep(2000);
				MandateField.add(FieldToBeAdded);
			}
		}
	}

	public boolean checkIfMandateFieldIsPresent(String fieldName) {
		for (String str : MandateField) {
			if (str.trim().contains(fieldName))
				return true;
		}
		return false;
	}

	public boolean CheckMandateField(MCWebElement webElement) {

		String className = webElement.getAttribute("class");
		if (className.contains("businessMandatoryFlag"))
			return true;
		else
			return false;

	}

	/**
	 * Add Application Screen Start
	 * 
	 */
	public void addNewApplicationBtnClick() {
		CustomUtils.ThreadDotSleep(3000);
		waitForElementVisible(AddNewApplicactionbtn);
		ClickButton(AddNewApplicactionbtn);
	}

	public void SwitchToWindow(String screenName) {
		CustomUtils.ThreadDotSleep(3000);
		switchToIframe(screenName);
	}

	public void selectProductType() {
		waitForElementVisible(AppliedForProductDDwn);
		selectByVisibleText(AppliedForProductDDwn, getProductType());
	}

	public void selectApplicationType() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(AppliedTypeDDwn);
		selectByVisibleText(AppliedTypeDDwn, getApplicationType());
	}

	public void selectSubApplicationType() {
		CustomUtils.ThreadDotSleep(5000);
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(ApplicationSubtypeDDwn);
		waitForElementVisible(ApplicationSubtypeDDwn);

		selectByVisibleText(ApplicationSubtypeDDwn, getSubApplicationType());
	}

	public void clickNextBtn() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(NextBtn);
		ClickButton(NextBtn);

	}

	/**
	 * Batch Screen
	 * 
	 */
	public void selectCreateOpenBatch() {
		waitForElementVisible(CreateOpenBatchDDwn);
		selectByVisibleText(CreateOpenBatchDDwn, getCreateOpenBatch());
	}

	public void clickGenerateBtn() {
		CustomUtils.ThreadDotSleep(3000);
		waitForElementVisible(GenerateBatchBtn);
		ClickButton(GenerateBatchBtn);

	}

	public void getBatchNumber() {

	}

	/**
	 * Application General Information screen
	 * 
	 */

	public void selectCustomerType() {
		waitForElementVisible(CustomerTypeDDwn);
		selectByVisibleText(CustomerTypeDDwn, getCustomerType());
	}

	public void selectProgramCode() {
		CustomUtils.ThreadDotSleep(5000);
		waitForElementVisible(ProgramCodeDDwn);
		waitForElementVisible(ProgramCodeDDwn);
		System.out.println(program.getProgram());
		selectByVisibleText(ProgramCodeDDwn, program.getProgram());
	}

	/**
	 * Device plan screen
	 * 
	 */

	public void selectDeviceType() {
		waitForElementVisible(DeviceTypeDDwn);
		SelectDropDownByIndex(DeviceTypeDDwn, 1);

	}

	public void selectDevicePlan() {
		waitForElementVisible(DevicePlanDDwn);
		CustomUtils.ThreadDotSleep(1000);
		SelectDropDownByIndex(DevicePlanDDwn, 1);
	}

	public void selectDevicePhotoIndicator() {
		waitForElementVisible(photoIndicatorDDwn);
		SelectDropDownByIndex(photoIndicatorDDwn, 1);
	}

	/**
	 * Profile Screen
	 * 
	 */

	public void selectBranchCode() {
		CustomUtils.ThreadDotSleep(5000);
		waitForElementVisible(BranchCodeDDwn);

		selectByVisibleText(BranchCodeDDwn, getBranchcode());
	}

	public void selectCorporateClientCode() {
		if (getCorporateClientCode() != null) {
			waitForElementVisible(CorporateClientCode);
			CustomUtils.ThreadDotSleep(1000);
			selectByVisibleText(CorporateClientCode, getCorporateClientCode());
		}
	}

	public void enterTitle() {
		waitForElementVisible(TitleDDwn);
		selectByVisibleText(TitleDDwn, getNameTitle());
	}

	public void enterFirstName() {
		waitForElementVisible(FirstnameTxt);
		enterText(FirstnameTxt, getFirstName() + CustomUtils.RandomNumbers(3));
	}

	public void enterLastName() {
		waitForElementVisible(LastnameTxt);

		enterText(LastnameTxt, getLastName() + CustomUtils.RandomNumbers(2));
	}

	public void selelctVIPStatus() {

		if (checkIfMandateFieldIsPresent("VIP_FLAG")) {
			if (CheckMandateField(VIPDDwn)) {
				if ((getVIPStatus() != null)) {
					waitForElementVisible(VIPDDwn);
					enterText(VIPDDwn, getVIPStatus());
				} else
					Assert.assertNotNull("VIP Status needs to be provided", false);
			} else
				Assert.assertNotNull("VIP Status should be business Mandatory", false);
		}

		waitForElementVisible(VIPDDwn);
		selectByVisibleText(VIPDDwn, getVIPStatus());
	}

	public void enterGender() {
		waitForElementVisible(GenderDDwn);
		selectByVisibleText(GenderDDwn, getGender());
	}

	public void enterNationality() {
		waitForElementVisible(NationalityDDwn);
		selectByVisibleText(NationalityDDwn, getNationality());
	}

	public void enterDOB() {
		BirthDateCalendar.click();
		List<WebElement> calendar = getFinder().getWebDriver().findElements(By.xpath("//a[@class='calnav']"));
		for (int i = 0; i <= calendar.size(); i++) {
			calendar.get(i).click();
			break;
		}
		waitForElementVisible(YearTxt);
		YearTxt.clearField();
		enterText(YearTxt, getYearBirth());
		CustomUtils.ThreadDotSleep(1000);
		waitForElementVisible(OkBtn);
		ClickButton(OkBtn);
		waitForElementVisible(BirthDate);
		BirthDate.click();
	}

	public void enterMaritialStatus() {
		waitForElementVisible(MaritalStatusDDwn);
		selectByVisibleText(MaritalStatusDDwn, getMaritalStatus());
	}

	public void enetrPreferredLanguage() {
		waitForElementVisible(PreferredLangDDwn);
		selectByVisibleText(PreferredLangDDwn, getPreferredLanguage());
	}

	/**
	 * Address screen
	 * 
	 */
	public void enetrPreferredAddress() {
		waitForElementVisible(PreferredAddressDDwn);
		selectByVisibleText(PreferredAddressDDwn, getPreferredAddress());
	}

	public void enterAddressLine1() {
		waitForElementVisible(AddressLine1Txt);
		enterText(AddressLine1Txt, getAddressLine1() + CustomUtils.RandomNumbers(2));
	}

	public void selectCountry() {
		waitForElementVisible(CountryDDwn);
		selectByVisibleText(CountryDDwn, getCountry());
	}

	public void enterZipCode() {
		waitForElementVisible(PostalCodeTxt);
		enterText(PostalCodeTxt, getPostalCode());
		CustomUtils.ThreadDotSleep(3000);
	}

	public void enterMiddleName1() {
		if (checkIfMandateFieldIsPresent("MIDDLE_NAME1")) {
			if (CheckMandateField(MiddleName1Txt)) {
				if ((getMiddleName1() != null)) {
					waitForElementVisible(MiddleName1Txt);
					enterText(MiddleName1Txt, getMiddleName1() + CustomUtils.RandomNumbers(2));
				} else
					Assert.assertNotNull("Middle name needs to be provided", false);
			} else
				Assert.assertNotNull("Middle name should be business Mandatory", false);
		} else if ((getMiddleName1() != null)) {
			waitForElementVisible(MiddleName1Txt);
			enterText(MiddleName1Txt, getMiddleName1() + CustomUtils.RandomNumbers(2));
		}
	}

	public void enterMiddleName2() {
		if (checkIfMandateFieldIsPresent("MIDDLE_NAME2")) {
			if (CheckMandateField(MiddleName2Txt)) {
				if ((getMiddleName2() != null)) {
					waitForElementVisible(MiddleName2Txt);
					enterText(MiddleName2Txt, getMiddleName2() + CustomUtils.RandomNumbers(2));
				} else
					Assert.assertNotNull("Middle name2 needs to be provided", false);
			} else
				Assert.assertNotNull("Middle name2 should be business Mandatory", false);
		}

		if (getMiddleName2() != null) {
			waitForElementVisible(MiddleName2Txt);
			enterText(MiddleName2Txt, getMiddleName2() + CustomUtils.RandomNumbers(2));
		}
	}

	public void enterMaidenName() {
		if (checkIfMandateFieldIsPresent("MAIDEN_NAME")) {
			if (CheckMandateField(MaidenNameTxt)) {
				if ((getMaidenName() != null)) {
					waitForElementVisible(MaidenNameTxt);
					enterText(MaidenNameTxt, getMaidenName());
				} else
					Assert.assertNotNull("Middle name2 needs to be provided", false);
			} else
				Assert.assertNotNull("Middle name2 should be business Mandatory", false);
		}
		if ((getMaidenName() != null)) {
			waitForElementVisible(MaidenNameTxt);
			enterText(MaidenNameTxt, getMaidenName());
		}
	}

	public void selectBirthcountry() {
		if (checkIfMandateFieldIsPresent("BIRTH_COUNTRY")) {
			if (CheckMandateField(BirthcountryDDwn)) {
				if ((getBirthcountry() != null)) {
					waitForElementVisible(BirthcountryDDwn);
					enterText(BirthcountryDDwn, getBirthcountry());
				} else
					Assert.assertNotNull("Birth Country needs to be provided", false);
			} else
				Assert.assertNotNull("Birth Country should be business Mandatory", false);
		}

		if ((getBirthcountry() != null)) {
			waitForElementVisible(BirthcountryDDwn);
			selectByVisibleText(BirthcountryDDwn, getBirthcountry());
		}
	}

	public void selectBirthCity() {

		if (checkIfMandateFieldIsPresent("BIRTH_CITY")) {
			if (CheckMandateField(BirthCityDDwn)) {
				if ((getBirthCity() != null)) {
					waitForElementVisible(BirthCityDDwn);
					enterText(BirthCityDDwn, getBirthCity());
				} else
					Assert.assertNotNull("Birth city needs to be provided", false);
			} else
				Assert.assertNotNull("Birth city should be business Mandatory", false);
		}

		if ((getBirthCity() != null)) {
			waitForElementVisible(BirthCityDDwn);
			selectByVisibleText(BirthCityDDwn, getBirthCity());
		}
	}

	/**
	 * EducationDDwn
	 * 
	 */
	public void selectEducation() {

		if (checkIfMandateFieldIsPresent("EDUCATION")) {
			if (CheckMandateField(EducationDDwn)) {
				if ((getEducation() != null)) {
					waitForElementVisible(EducationDDwn);
					enterText(EducationDDwn, getEducation());
				} else
					Assert.assertNotNull("Education needs to be provided", false);
			} else
				Assert.assertNotNull("Education should be business Mandatory", false);
		}
		if ((getBirthCity() != null)) {
			waitForElementVisible(EducationDDwn);
			selectByVisibleText(EducationDDwn, getEducation());
		}
	}

	public void selectTravelType() {
		if ((getTravelType() != null)) {
			waitForElementVisible(TravelTypeDDwn);
			selectByVisibleText(TravelTypeDDwn, getTravelType());
		}
	}

	public void selectTravelPurpose() {
		if ((getTravelPurpose() != null)) {
			waitForElementVisible(TravelPurposechkbx);
			selectByVisibleText(TravelPurposechkbx, getTravelPurpose());
		}
	}

	public void selectTravelCountry() {
		if ((getTravelCountry() != null)) {
			waitForElementVisible(TravelCountryDDwn);
			selectByVisibleText(TravelCountryDDwn, getTravelCountry());
		}
	}

	public void selectStmtHardCopyReq() {
		if (checkIfMandateFieldIsPresent("STATEMENT_PREFERENCE")) {
			if (CheckMandateField(StmtHardCopyReqDDwn)) {
				if ((getStmtHardCopyReq() != null)) {
					waitForElementVisible(StmtHardCopyReqDDwn);
					enterText(StmtHardCopyReqDDwn, getStmtHardCopyReq());
				} else
					Assert.assertNotNull("Statement needs to be provided", false);
			} else
				Assert.assertNotNull("Statement should be business Mandatory", false);
		}

		if ((getStmtHardCopyReq() != null)) {
			waitForElementVisible(StmtHardCopyReqDDwn);
			selectByVisibleText(StmtHardCopyReqDDwn, getStmtHardCopyReq());
		}
	}

	public void selectLanguagePref() {
		if ((getLanguagePref() != null)) {
			waitForElementVisible(LanguagePrefDDwn);
			selectByVisibleText(LanguagePrefDDwn, getLanguagePref());
		}
	}

	public void selectDeliveryMode() {
		if ((getDeliveryMode() != null)) {
			waitForElementVisible(DeliveryModeDDwn);
			selectByVisibleText(DeliveryModeDDwn, getDeliveryMode());
		}
	}

	public void selectRegisteredMobileISDDDwn() {
		if ((getRegisteredMobileNo() != null)) {
			waitForElementVisible(registeredMobileISDDDwn);
			selectByVisibleText(registeredMobileISDDDwn, "IND");
		}
	}

	public void enterRegisteredMobileNo() {
		if ((getRegisteredMobileNo() != null)) {
			waitForElementVisible(registeredMobileNoTxt);
			enterText(registeredMobileNoTxt, getRegisteredMobileNo());
		}
	}

	public void enterRegisteredEmailID() {
		if ((getRegisteredEmailID() != null)) {
			waitForElementVisible(registeredEmailIDTxt);
			enterText(registeredEmailIDTxt, getRegisteredEmailID());
		}
	}

	public void CheckKycStatus() {

		if ((getKycStatus() != null) && getKycStatus().equalsIgnoreCase("Y")) {
			waitForElementVisible(KycStatuschkbx);

			KycStatuschkbx.click();
		}
	}

	public void ChecksmsAlert() {

		if ((getSmsAlert() != null) && getSmsAlert().equalsIgnoreCase("Y")) {
			waitForElementVisible(smsAlertchkbx);

			smsAlertchkbx.click();
		}
	}

	public void CheckEmailAlert() {

		if ((getEmailAlert() != null) && getEmailAlert().equalsIgnoreCase("Y")) {
			waitForElementVisible(EmailAlertchkbx);

			EmailAlertchkbx.click();
		}
	}

	public void CheckRegisterForDncr() {

		if ((getRegisterForDncr() != null) && getRegisterForDncr().equalsIgnoreCase("Y")) {
			RegisterForDncrchkbx.click();
			waitForElementVisible(RegisterForDncrchkbx);

		}
	}

	public void addProfileAndGeneralInformation() {
		selectCorporateClientCode();
		selectBranchCode();
		enterTitle();
		enterFirstName();
		enterLastName();
		enterGender();
		enterNationality();
		enterDOB();
		enterMaritialStatus();
		selectEducation();
		enetrPreferredLanguage();
		enterMiddleName1();
		enterMiddleName2();
		enterMaidenName();
		selectBirthcountry();
		selectBirthCity();
		selectTravelType();
		selectTravelPurpose();
		selectTravelCountry();
		selectStmtHardCopyReq();
		selectLanguagePref();
		CheckKycStatus();
		selectDeliveryMode();
		ChecksmsAlert();
		selectRegisteredMobileISDDDwn();
		enterRegisteredMobileNo();
		enterRegisteredEmailID();
		CheckEmailAlert();
		CheckRegisterForDncr();

		clickNextBtn();
	}

	public void submitNewApplicationForm() {
		waitForElementVisible(FinishBtn);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(FinishBtn);
	}

	public String CheckApplicationNumber() {
		String strOutputMessage = ApplicationNumberTxt.getText().split("\\n")[0];
		String strRequestNumber = strOutputMessage.replaceAll("[^\\d]", "").trim();
		return strRequestNumber;

	}

	public String CheckDeviceNumber() {
		String strOutputMessage = ApplicationDeviceTxt.getText().split("\\n")[0];
		String strRequestNumber = strOutputMessage.replaceAll("[^\\d]", "").trim();
		return strRequestNumber;
	}

	public void getApplicationnumber() {

		String Applicationnumber = CheckApplicationNumber();
		System.out.println(Applicationnumber);
		setApplicationNumber(Applicationnumber);

	}

	public void getCreatedDeviceNumber() {
		String Devicennumber = CheckDeviceNumber();
		System.out.println(Devicennumber);
		setDeviceNumber(Devicennumber);
	}

	public void checkSuccessMsg() {
		CustomUtils.ThreadDotSleep(5000);
		String strOutputMessage = ApplicationSuccessTxt.getText().split("\\n")[0];
		boolean strRequestNumber = strOutputMessage.contains("Application Processed Successfully.");
		Assert.assertNotNull("VIP Status needs to be provided", strRequestNumber);
	}
}
