package com.mastercard.pts.integrated.issuing.pages;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.MPTSBasePage;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class VendorPage extends MPTSBasePage {
	final Logger logger = LoggerFactory.getLogger(EmbossingPriorityPassPage.class);

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

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

	@PageElement(findBy = FindBy.NAME, valueToFind = "embossFileTemplate:input:dropdowncomponent")
	private MCWebElement EmbossingFileTemplateDDwn;

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

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement CancelBtn;

	public void addvendor(String vendorCode, String vendorName, String vendorCategory, String embossingFileTempName,
			String addressLine1, String addressLine2, String country, String postalCode, String contactPrsn,
			String phnNumber, String vendorMobileNo1, String vendorMobileNo2, String email) {
		ClickButton(AddVendorBtn);
		switchToIframe(Constants.ADD_VENDOR_MASTER_FRAME);
		enterText(VendorCodeTxt, vendorCode);
		enterText(VendorNameTxt, vendorName);
		SelectDropDownByText(CategoryDDwn, vendorCategory);
		ClickCheckBox(DeviceProductionChkBx, true);
		SelectDropDownByText(EmbossingFileTemplateDDwn, embossingFileTempName);
		enterText(AddressLine1Txt, addressLine1);
		enterText(AddressLine2Txt, addressLine2);
		SelectDropDownByText(CountryDDwn, country);
		enterText(PostalCodeTxt, postalCode);
		enterText(ContactPersonTxt, contactPrsn);
		ClickButton(ContactPersonTxt);
		enterText(PhoneNumberTxt, phnNumber);
		SelectDropDownByText(MobileNo1DDwn, vendorMobileNo1);
		enterText(MobileNo2Txt, vendorMobileNo2);
		enterText(EmailTxt, email);
		ClickButton(SaveBtn);
		try {
			PanelErrorTxt.isVisible();
			logger.info("inside error pannel");
			ClickButton(CancelBtn);

		} catch (Exception e) {
			logger.info("error pannel not present");
			e.printStackTrace();
		}
		// addWicketAjaxListeners(getFinder().getWebDriver());
		SwitchToDefaultFrame();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}
