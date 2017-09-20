package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Collection;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.EmbossingFile;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Vendor;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1INSTITUTION_PARAMETER_SETUP, CardManagementNav.L2VENDOR })
public class VendorPage extends Vendor {
	final Logger logger = LoggerFactory.getLogger(EmbossingPriorityPassPage.class);

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@Autowired
	EmbossingFile embossingFile;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement AddVendorBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "vendorCode:input:inputTextField")
	private MCWebElement VendorCodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "vendorName:input:inputTextField")
	private MCWebElement VendorNameTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "vendorType:input:dropdowncomponent")
	private MCWebElement CategoryDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "deviceProductionSupported:checkBoxComponent")
	private MCWebElement DeviceProductionChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "pinProductionSupported:checkBoxComponent")
	private MCWebElement PinProductionChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "embossFileTemplate:input:dropdowncomponent")
	private MCWebElement EmbossingFileTemplateDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "pinFileTemplate:input:dropdowncomponent")
	private MCWebElement PINFileTemplateDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "address1:input:inputTextField")
	private MCWebElement AddressLine1Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "address2:input:inputTextField")
	private MCWebElement AddressLine2Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "countryCode:input:dropdowncomponent")
	private MCWebElement CountryDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "zipCode:input:inputTextField")
	private MCWebElement PostalCodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "contactName:input:inputTextField")
	private MCWebElement ContactPersonTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "phoneNumber:input:inputTextField")
	private MCWebElement PhoneNumberTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mobileCntryCode:input:dropdowncomponent")
	private MCWebElement MobileNo1DDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mobileNumber:input:inputTextField")
	private MCWebElement MobileNo2Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "emailId:input:inputTextField")
	private MCWebElement EmailTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement SaveBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelERROR']")
	private MCWebElement PanelErrorTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelINFO']")
	private MCWebElement PanelInfo;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement CancelBtn;

	public void clickaddVenor() {
		waitForElementVisible(AddVendorBtn);
		ClickButton(AddVendorBtn);
	}

	public void switchToAddVenorFrame() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_VENDOR_MASTER_FRAME);
	}

	public String enterVendorCode() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(VendorCodeTxt, "V" + CustomUtils.randomNumbers(5));
		return VendorCodeTxt.getAttribute("value");
	}

	public String enterVendorDescription() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(VendorNameTxt, "HDFCVendor" + CustomUtils.randomNumbers(1));
		return VendorNameTxt.getAttribute("value");
	}

	public void selectVendorCategory() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectByVisibleText(CategoryDDwn, getVendorCategory());
	}

	public void selectDeviceProductionCheckBox() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickCheckBox(DeviceProductionChkBx, true);
	}

	public void selectEmbossingTempFileName() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectByVisibleText(EmbossingFileTemplateDDwn, embossingFile.getEmbossingFileTemplateName());
	}

	public void selectPINFileTemplate() {
		if (vendorDataProvider().getPINFileTemplateName() != null) {
			ClickCheckBox(PinProductionChkBx, true);
			addWicketAjaxListeners(getFinder().getWebDriver());
			selectByVisibleText(PINFileTemplateDDwn, vendorDataProvider().getPINFileTemplateName());
		}
	}

	public void enterAddressLine1() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(AddressLine1Txt, vendorDataProvider().getAddressLine1());
	}

	public void enterAddressLine2() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(AddressLine2Txt, vendorDataProvider().getAddressLine2());
	}

	public void selectCountry() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectByVisibleText(CountryDDwn, vendorDataProvider().getCountry());
	}

	public void enterPostalCode() {
		CustomUtils.ThreadDotSleep(1000);
		enterText(PostalCodeTxt, vendorDataProvider().getPostalCode());
	}

	public void enterContactPerson() {
		enterText(ContactPersonTxt, "AutoTest");
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(ContactPersonTxt);
	}

	public void enterPhoneNumber() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(PhoneNumberTxt, "919191910");
	}

	public void selectMobileNumber() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(MobileNo1DDwn, vendorDataProvider().getVendorMobileNo());
	}

	public void enterMobileNumber() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(MobileNo2Txt, "919191910");
	}

	public void enterEmail() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(EmailTxt, vendorDataProvider().getEmail());
		addWicketAjaxListeners(getFinder().getWebDriver());
		EmailTxt.click();
	}

	public void clickSavebutton() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		retryUntilNoErrors(() -> ClickButton(SaveBtn));
		CustomUtils.ThreadDotSleep(1000);
		try {
			if (SaveBtn.isVisible()) {
				ClickButton(SaveBtn);
			}
		} catch (Exception e1) {
			logger.error(e1.toString());
			try {
				if (PanelInfo.isVisible()) {
					Assert.assertEquals(PanelInfo.getText(), Constants.Record_Added_Successfully);
				}
			} catch (Exception e) {
				logger.error(e.toString());
				try {
					if (PanelErrorTxt.isVisible()) {
						logger.info("inside error pannel");
						CancelBtn.click();
					}
				} catch (Exception e2) {
					logger.error(e2.toString());
					logger.info("error pannel not present");
				}
			}
		}
		SwitchToDefaultFrame();

	}

	public void addvendor(String vendorCode, String vendorName, String vendorCategory, String embossingFileTempName,
			String PinFileTempName, String addressLine1, String addressLine2, String country, String postalCode,
			String contactPrsn, String phnNumber, String vendorMobileNo1, String vendorMobileNo2, String email) {
		ClickButton(AddVendorBtn);
		switchToIframe(Constants.ADD_VENDOR_MASTER_FRAME);
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(VendorCodeTxt, vendorCode);
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(VendorNameTxt, vendorName);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(CategoryDDwn, vendorCategory);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickCheckBox(DeviceProductionChkBx, true);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(EmbossingFileTemplateDDwn, embossingFileTempName);
		addWicketAjaxListeners(getFinder().getWebDriver());
		if (PinFileTempName != null) {
			ClickCheckBox(PinProductionChkBx, true);
			addWicketAjaxListeners(getFinder().getWebDriver());
			SelectDropDownByText(PINFileTemplateDDwn, PinFileTempName);
		}
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(AddressLine1Txt, addressLine1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(AddressLine2Txt, addressLine2);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(CountryDDwn, country);
		addWicketAjaxListeners(getFinder().getWebDriver());
		CustomUtils.ThreadDotSleep(1000);
		enterText(PostalCodeTxt, postalCode);
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(ContactPersonTxt, contactPrsn);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(ContactPersonTxt);
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(PhoneNumberTxt, phnNumber);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(MobileNo1DDwn, vendorMobileNo1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(MobileNo2Txt, vendorMobileNo2);
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(EmailTxt, email);
		addWicketAjaxListeners(getFinder().getWebDriver());
		EmailTxt.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(SaveBtn);
		CustomUtils.ThreadDotSleep(1000);
		try {
			PanelErrorTxt.isVisible();
			logger.info("inside error pannel");
			ClickButton(CancelBtn);

		} catch (Exception e) {
			logger.info("error pannel not present");

		}
		SwitchToDefaultFrame();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}
