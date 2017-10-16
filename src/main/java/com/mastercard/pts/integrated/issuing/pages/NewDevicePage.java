package com.mastercard.pts.integrated.issuing.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.MPTSBasePage;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

import net.serenitybdd.core.annotations.findby.By;

@Component
public class NewDevicePage extends MPTSBasePage {

	final Logger logger = LoggerFactory.getLogger(EmbossingTemplatePage.class);

	@Autowired
	MenuSubMenuPage menusubMenuPage;

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

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//li[4]/span{@class='feedbackPanelINFO']")
	private MCWebElement DeviceTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "view:currentZipCode:input:inputTextField")
	private MCWebElement PostalCodeTxt;

	public String createNewDevice(String product, String appliedType, String applicationSubtype, String batch,
			String customerType, String programCode, String deviceType, String devicePlan, String title,
			String firstName, String LastName, String gender, String nationality, String yearbirth,
			String maritalStatus, String accountNumber, String accountType, String preferredlang, String addressLine1,
			String addressLine2, String addressLine3, String addressLine4, String country, String postalcode) {
		retryUntilNoErrors(() -> menusubMenuPage.getNewDevice().click());
		ClickButton(AddNewDevice);
		switchToIframe(Constants.ADD_NEW_DEVICE_FRAME);
		SelectDropDownByText(AppliedForProductDDwn, product);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(AppliedTypeDDwn, appliedType);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(ApplicationSubtypeDDwn, applicationSubtype);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(NextBtn);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(CreateOpenBatchDDwn, batch);
		ClickButton(GenerateBatchBtn);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(NextBtn);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(CustomerTypeDDwn, customerType);
		SelectDropDownByText(ProgramCodeDDwn, programCode);
		ClickButton(NextBtn);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(DeviceTypeDDwn, deviceType);
		SelectDropDownByText(DevicePlanDDwn, devicePlan);
		SelectDropDownByIndex(photoIndicatorDDwn, 1);
		ClickButton(NextBtn);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(BranchCodeDDwn, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(TitleDDwn, title);
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(FirstnameTxt, firstName);
		enterText(LastnameTxt, LastName);
		// enterText(EmbossednameTxt, firstName + " " + LastName);
		SelectDropDownByText(GenderDDwn, gender);
		addWicketAjaxListeners(getFinder().getWebDriver());
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(NationalityDDwn, nationality);
		BirthDateCalendar.click();

		List<WebElement> calendar = getFinder().getWebDriver().findElements(By.xpath("//a[@class='calnav']"));
		System.out.println(calendar.size());
		for (int i = 0; i <= calendar.size(); i++) {
			calendar.get(i).click();
			break;
		}

		// CalendarNav.click();
		YearTxt.clearField();
		enterText(YearTxt, yearbirth);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(OkBtn);
		addWicketAjaxListeners(getFinder().getWebDriver());
		BirthDate.click();
		SelectDropDownByText(MaritalStatusDDwn, maritalStatus);
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(AccountNumberTxt, accountNumber);
		SelectDropDownByText(AccountTypeDDwn, accountType);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(PreferredLangDDwn, preferredlang);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(NextBtn);
		enterText(AddressLine1Txt, addressLine1);
		enterText(AddressLine2Txt, addressLine2);
		enterText(AddressLine3Txt, addressLine3);
		enterText(AddressLine4Txt, addressLine4);
		addWicketAjaxListeners(getFinder().getWebDriver());

		SelectDropDownByText(CountryDDwn, country);
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(PostalCodeTxt, postalcode);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(NextBtn);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(NextBtn);
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

	public String getDeviceNumber() {
		String strOutputMessage = DeviceTxt.getText().split("\\n")[0];
		System.out.println("Device Number " + strOutputMessage);
		String strRequestNumber = strOutputMessage.replaceAll("[^\\d]", "").trim();
		// int intIndex = strOutputMessage.indexOf("is");
		// String strRequestNumber = strOutputMessage.substring(43, intIndex +
		// 1);
		System.out.println("Request Number is " + strRequestNumber);
		MapUtils.fnSetInputDataToInputMap("DeviceNumber", strRequestNumber);
		return strRequestNumber;

	}

}