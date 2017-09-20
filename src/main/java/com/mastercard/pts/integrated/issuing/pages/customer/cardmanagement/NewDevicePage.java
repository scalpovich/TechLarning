package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;
import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.NewDevice;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Vendor;
import com.mastercard.pts.integrated.issuing.pages.MenuSubMenuPage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.ColorUtils;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.utils.ReadTestDataFromExcel;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

import net.serenitybdd.core.annotations.findby.By;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_ACTIVITY, CardManagementNav.L2_DEVICE, CardManagementNav.L3_NEW_DEVICE})
public class NewDevicePage extends AbstractCardManagementPage {
	private static final Logger loggerTemp = LoggerFactory.getLogger(NewDevicePage.class);

	final Logger logger = LoggerFactory.getLogger(EmbossingTemplatePage.class);

	@Autowired
	MenuSubMenuPage menusubMenuPage;

	@Autowired
	Program program;

	@Autowired
	DevicePlan deviceplan;

	@Autowired
	Vendor vendor;

	@Autowired
	DeviceCreation deviceCreation;

	@Autowired
	private ReadTestDataFromExcel excelTestData;

	@Autowired
	ColorUtils colorutils;

	// ------------- Card Management > Activity > Device
	// Parameters > New Device [ISAD0N]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement AddNewDevice;

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

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value = 'Copy Address']")
	private MCWebElement CopyAddressBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cardBatch.displayStatusFlag:input:dropdowncomponent")
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

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:branchCode:input:dropdowncomponent")
	private MCWebElement BranchCodeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:corporateClientCode:input:dropdowncomponent")
	private MCWebElement CorporateClientCodeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:title:input:dropdowncomponent")
	private MCWebElement TitleDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:firstName:input:inputCodeField")
	private MCWebElement FirstnameTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:middleName2:input:inputCodeField")
	private MCWebElement MiddleName2Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:middleName1:input:inputCodeField")
	private MCWebElement MiddleName1Txt;

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

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:currentAddressLine1:input:inputTextField")
	private MCWebElement AddressLine1Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:currentAddressLine2:input:inputTextField")
	private MCWebElement AddressLine2Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:currentAddressLine3:input:inputTextField")
	private MCWebElement AddressLine3Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:currentAddressLine4:input:inputTextField")
	private MCWebElement AddressLine4Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:crAccountNbr:input:inputTextField")
	private MCWebElement AccountNumberTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:accountType:input:dropdowncomponent")
	private MCWebElement AccountTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:currentCountryCode:input:dropdowncomponent")
	private MCWebElement CountryDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//li[4]/span[@class='feedbackPanelINFO']")
	private MCWebElement DeviceTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:currentZipCode:input:inputTextField")
	private MCWebElement PostalCodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:legalId1Type:input:dropdowncomponent")
	private MCWebElement LegalTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:legalId1:input:inputTextField")
	private MCWebElement LegalIDTxtDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:registeredMailId:input:inputTextField")
	private MCWebElement RegisteredEmailIDDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:isdCode:input:dropdowncomponent")
	private MCWebElement RegisteredMobileDDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:registeredMobileNumber:input:inputTextField")
	private MCWebElement RegisteredMobileTxt;

	public void clickAddnewDevice() {
		waitForElementVisible(AddNewDevice);
		retryUntilNoErrors(() -> AddNewDevice.click());
		// ClickButton(AddNewDevice);
	}
	@Override
	public void verifyUiOperationStatus() {
	loggerTemp.info("Device");
		verifyUiOperation("Add Device");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(deviceNumber),
				WebElementUtils.elementToBeClickable(applicationNumber),
				WebElementUtils.elementToBeClickable(firstName),
				WebElementUtils.elementToBeClickable(lastName),
				WebElementUtils.elementToBeClickable(fromDate),
				WebElementUtils.elementToBeClickable(toDate)
				);
	}

	public void switchToAddNewDeviceFrame() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_NEW_DEVICE_FRAME);
	}

	public void selectAppliedForProduct() {
		waitForElementVisible(AppliedForProductDDwn);
		CustomUtils.ThreadDotSleep(1000);
		selectByVisibleText(AppliedForProductDDwn, deviceCreation.getProduct());
	}

	public void selectAppliedType() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(AppliedTypeDDwn);
		CustomUtils.ThreadDotSleep(1000);
		selectByVisibleText(AppliedTypeDDwn, newdeviceDataProvider().getApplicationType());
	}

	public void selectApplicationSubType() {
		waitForElementVisible(ApplicationSubtypeDDwn);
		CustomUtils.ThreadDotSleep(1000);
		selectByVisibleText(ApplicationSubtypeDDwn, newdeviceDataProvider().getApplicationSubType());
	}

	public void clickNextButton() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		Scrolldown(NextBtn);
		ClickButton(NextBtn);
		CustomUtils.ThreadDotSleep(5000);
	}

	public void clickFinishButton() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(FinishBtn);
		CustomUtils.ThreadDotSleep(1000);
	}

	public void selectCreateOpenBatch() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(CreateOpenBatchDDwn);
		CustomUtils.ThreadDotSleep(1000);
		selectByVisibleText(CreateOpenBatchDDwn, newdeviceDataProvider().getBatchType());
	}

	public void clickGenerateBatch() {
		waitForElementVisible(GenerateBatchBtn);
		CustomUtils.ThreadDotSleep(3000);
		retryUntilNoErrors(() -> ClickButton(GenerateBatchBtn));
		CustomUtils.ThreadDotSleep(3000);
	}

	public void selectCustomerType() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		CustomUtils.ThreadDotSleep(5000);
		waitForElementVisible(CustomerTypeDDwn);
		selectByVisibleText(CustomerTypeDDwn, getCustomerType());
	}

	public void selectProgramCode() {
		waitForElementVisible(ProgramCodeDDwn);
		addWicketAjaxListeners(getFinder().getWebDriver());
		CustomUtils.ThreadDotSleep(1000);
		selectByVisibleText(ProgramCodeDDwn, program.getProgram());
		// selectByVisibleText(ProgramCodeDDwn, "program [856]");
	}

	public void selectDeviceType() {
		waitForElementVisible(DeviceTypeDDwn);
		selectByVisibleText(DeviceTypeDDwn, getDeviceType());
	}

	public void selectDevicePlan() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(DevicePlanDDwn);
		CustomUtils.ThreadDotSleep(1000);
		selectByVisibleText(DevicePlanDDwn, deviceplan.getDevicePlan());
		// selectByVisibleText(DevicePlanDDwn, "deviceplan [64179]");
	}

	public void selectPhotoIndicator() {
		waitForElementVisible(photoIndicatorDDwn);
		CustomUtils.ThreadDotSleep(1000);
		SelectDropDownByIndex(photoIndicatorDDwn, 1);
	}

	public void selectCorporateClientCode() {
		waitForElementVisible(CorporateClientCodeDDwn);
		addWicketAjaxListeners(getFinder().getWebDriver());
		CustomUtils.ThreadDotSleep(1000);
		if (CorporateClientCodeDDwn.isEnabled())
			SelectDropDownByIndex(CorporateClientCodeDDwn, 1);
	}

	public void selectBranch() {
		waitForElementVisible(BranchCodeDDwn);
		addWicketAjaxListeners(getFinder().getWebDriver());
		CustomUtils.ThreadDotSleep(1000);
		SelectDropDownByIndex(BranchCodeDDwn, 1);
	}

	public void selectTitle() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		CustomUtils.ThreadDotSleep(1000);
		waitForElementVisible(TitleDDwn);
		selectByVisibleText(TitleDDwn, newdeviceDataProvider().getTitle());
	}

	public void enterFirstName() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(FirstnameTxt, newdeviceDataProvider().getFirstName() + CustomUtils.randomNumbers(3));
	}

	public void enterMiddleName1() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		if (newdeviceDataProvider().getFirstName() != null)
			enterText(MiddleName1Txt, newdeviceDataProvider().getMiddleName1());
	}

	public void enterMiddleName2() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		if (newdeviceDataProvider().getFirstName() != null)
			enterText(MiddleName2Txt, newdeviceDataProvider().getMiddleName2() + CustomUtils.randomNumbers(3));
	}

	public void enterLastName() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(LastnameTxt, newdeviceDataProvider().getLastName() + CustomUtils.randomNumbers(3));
	}

	public void selectGender() {
		waitForElementVisible(GenderDDwn);
		selectByVisibleText(GenderDDwn, newdeviceDataProvider().getGender());
	}

	public void selectNationality() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		CustomUtils.ThreadDotSleep(1000);
		selectByVisibleText(NationalityDDwn, newdeviceDataProvider().getNationality());
	}

	public void selectBirthDate() {
		BirthDateCalendar.click();
		List<WebElement> calendar = getFinder().getWebDriver().findElements(By.xpath("//a[@class='calnav']"));
		for (int i = 0; i <= calendar.size(); i++) {
			calendar.get(i).click();
			break;
		}
		YearTxt.clearField();
		enterText(YearTxt, "19" + CustomUtils.randomNumbers(2));
		addWicketAjaxListeners(getFinder().getWebDriver());
		CustomUtils.ThreadDotSleep(3000);
		ClickButton(OkBtn);
		addWicketAjaxListeners(getFinder().getWebDriver());
		BirthDate.click();
		CustomUtils.ThreadDotSleep(1000);
	}

	public void selectMaritalStatus() {
		CustomUtils.ThreadDotSleep(1000);
		selectByVisibleText(MaritalStatusDDwn, newdeviceDataProvider().getMaritalStatus());
	}

	public void enterAccountNumber() {
		if (AccountNumberTxt.isEnabled()) {
			addWicketAjaxListeners(getFinder().getWebDriver());
			enterText(AccountNumberTxt, CustomUtils.randomNumbers(13));
		}
	}

	public void selectAccounType() {
		addWicketAjaxListeners(getFinder().getWebDriver());

		if (AccountTypeDDwn.isEnabled()) {
			selectByVisibleText(AccountTypeDDwn, getAccountType());
		}
	}

	public void selectPreferedLanguage() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		CustomUtils.ThreadDotSleep(1000);
		selectByVisibleText(PreferredLangDDwn, newdeviceDataProvider().getPreferedLanguage());
	}

	public void enterRegisteredEmail() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(RegisteredEmailIDDDwn);
		CustomUtils.ThreadDotSleep(1000);
		enterText(RegisteredEmailIDDDwn, newdeviceDataProvider().getEmail());
	}

	public void enterRegisteredMobile() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		if (RegisteredMobileDDDwn.isEnabled()) {
			waitForElementVisible(RegisteredMobileDDDwn);
			CustomUtils.ThreadDotSleep(1000);
			selectByVisibleText(RegisteredMobileDDDwn, newdeviceDataProvider().getMobileNo());
			enterText(RegisteredMobileTxt, CustomUtils.randomNumbers(10));
		}
	}

	public void enterAddressLine1() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(AddressLine1Txt, newdeviceDataProvider().getAddressLine1());
	}

	public void enterAddressLine2() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(AddressLine2Txt, newdeviceDataProvider().getAddressLine2());
	}

	public void enterAddressLine3() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(AddressLine3Txt, newdeviceDataProvider().getAddressLine3());
	}

	public void enterAddressLine4() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(AddressLine4Txt, newdeviceDataProvider().getAddressLine4());
	}

	public void selectCountry() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(CountryDDwn);
		selectByVisibleText(CountryDDwn, newdeviceDataProvider().getCountry());
	}

	public void enterPostalCode() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(PostalCodeTxt);
		CustomUtils.ThreadDotSleep(1000);
		enterText(PostalCodeTxt, newdeviceDataProvider().getPostalCode());
	}

	public void clickCopyAddress() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(AddressLine4Txt);
		AddressLine4Txt.click();
		CustomUtils.ThreadDotSleep(1000);
		waitForElementVisible(CopyAddressBtn);
		ClickButton(CopyAddressBtn);
	}

	public void selectLegalType() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(LegalTypeDDwn, 1);
	}

	public void enterLegalID() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(LegalIDTxtDDwn, "JKX" + CustomUtils.randomNumbers(6));
	}

	public String createNewDevice() {
		waitForElementVisible(menusubMenuPage.getNewDevice());
		retryUntilNoErrors(() -> menusubMenuPage.getNewDevice().click());
		ClickButton(AddNewDevice);
		switchToIframe(Constants.ADD_NEW_DEVICE_FRAME);
		waitForElementVisible(AppliedForProductDDwn);
		CustomUtils.ThreadDotSleep(1000);
		SelectDropDownByText(AppliedForProductDDwn, MapUtils.fnGetInputDataFromMap("ProductType"));
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(AppliedTypeDDwn);
		CustomUtils.ThreadDotSleep(1000);
		SelectDropDownByText(AppliedTypeDDwn, MapUtils.fnGetInputDataFromMap("ApplicationType"));
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(ApplicationSubtypeDDwn);
		CustomUtils.ThreadDotSleep(1000);
		SelectDropDownByText(ApplicationSubtypeDDwn, MapUtils.fnGetInputDataFromMap("ApplicationSubType"));
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(NextBtn);
		CustomUtils.ThreadDotSleep(1000);
		GenerateBatchFrame();
		GeneralInformationFrame();
		DeviceInformationScreen();
		ProfileScreen();
		AddressScreen();
		OccupationDetailsScreen();
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(NextBtn);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(NextBtn);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(NextBtn);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(NextBtn);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(FinishBtn);
		SwitchToDefaultFrame();
		getDeviceNumber();
		return null;
	}

	public void GenerateBatchFrame() {
		selectCreateOpenBatch();
		CustomUtils.ThreadDotSleep(3000);
		clickGenerateBatch();
		CustomUtils.ThreadDotSleep(5000);
		clickNextButton();
		CustomUtils.ThreadDotSleep(3000);

	}

	public void GeneralInformationFrame() {
		CustomUtils.ThreadDotSleep(1000);
		selectCustomerType();
		selectProgramCode();
		clickNextButton();
		CustomUtils.ThreadDotSleep(1000);

	}

	public void DeviceInformationScreen() {
		selectDeviceType();
		selectDevicePlan();
		selectPhotoIndicator();
		clickNextButton();
		CustomUtils.ThreadDotSleep(1000);

	}

	public void ProfileScreen() {
		VerifyBusinessmandatoryFields("BusinessMandatoryFields.xlsx");
		selectCorporateClientCode();
		selectBranch();
		selectTitle();
		enterFirstName();
		// enterMiddleName1();
		enterMiddleName2();
		enterLastName();
		selectGender();
		selectNationality();
		selectBirthDate();
		selectMaritalStatus();
		enterAccountNumber();
		selectAccounType();
		selectPreferedLanguage();
		enterRegisteredEmail();
		enterRegisteredMobile();
		clickNextButton();
		CustomUtils.ThreadDotSleep(1000);

	}

	public void AddressScreen() {
		VerifyBusinessmandatoryFields("BusinessMandatoryFields.xlsx");
		enterAddressLine1();
		enterAddressLine2();
		enterAddressLine3();
		enterAddressLine4();
		selectCountry();
		enterPostalCode();
		clickCopyAddress();
		clickNextButton();
		CustomUtils.ThreadDotSleep(1000);

	}

	public void OccupationDetailsScreen() {
		selectLegalType();
		enterLegalID();
		clickNextButton();

	}

	public void VerifyBusinessmandatoryFields(String excelFileName) {
		CustomUtils.ThreadDotSleep(3000);
		String FieldToBeAdded = "";
		String filepath = System.getProperty("user.dir") + "/src/main/resources/config/"
				+ System.getProperty("environment") + File.separator + "TestData" + File.separator + excelFileName;
		HashMap<String, HashMap<String, String>> map = excelTestData.fnReadEntireTestData(filepath, "Sheet1",
				"SequenceNo.");
		for (int i = 1; i < map.size(); i++) {
			String Word = "";
			excelTestData.dataProviderIterator(map, String.valueOf(i));
			String Value = MapUtils.getIterativeDataFromDatamap("Value (Y/N)");
			if (Value.contains("Y")) {
				FieldToBeAdded = MapUtils.getIterativeDataFromDatamap("Field Name");
				String[] fields = FieldToBeAdded.split("_");
				for (int j = 0; j < fields.length; j++) {
					String word1 = fields[j].substring(0, 1).toUpperCase() + fields[j].substring(1).toLowerCase();
					Word = Word + word1 + " ";

				}
				String word = Word.trim();
				CustomUtils.ThreadDotSleep(3000);
				try {
					WebElement Field = getFinder().getWebDriver().findElement(
							By.xpath("//td[contains(.,'" + word + "')]/following::td[1]/span/input[@type='text']"));
					String css = Field.getCssValue("border-left-color");
					String s = css.substring(5, 14);
					String[] index = s.split(",");
					if ("RED".equalsIgnoreCase(colorutils.getColorNameFromRgb(Integer.valueOf(index[0]),
							Integer.valueOf(index[1].trim()), Integer.valueOf(index[2].trim())))) {
						logger.info("Business Mandatory fields are appearing mandatory");
					}

				} catch (Exception e) {
					logger.error(e.toString());

				}
			}
		}
	}

	public String CheckDeviceNumber() {
		String strOutputMessage = DeviceTxt.getText().split("\\n")[0];
		String strRequestNumber = strOutputMessage.replaceAll("[^\\d]", "").trim();
		return strRequestNumber;

	}

}