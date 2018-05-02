package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Vendor;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.MCWebElements;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP, CardManagementNav.L2_VENDOR })
public class VendorPage extends AbstractBasePage {
	final Logger logger = LoggerFactory.getLogger(VendorPage.class);

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]
	@Autowired
	TestContext context;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement AddVendorBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "vendorCode:input:inputTextField")
	private MCWebElement VendorCodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "vendorName:input:inputTextField")
	private MCWebElement VendorNameTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//select[contains(@name,'branchCode')]")
	private MCWebElement branchDDwn;

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

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//select[contains(@name,'branchCode')]/option[text()!='Select One']")
	private MCWebElements branchDDwnList;

	public void clickaddVenor() {
		clickWhenClickable(AddVendorBtn);
		switchToAddVenorFrame();
	}

	public void switchToAddVenorFrame() {
		switchToIframe(Constants.ADD_VENDOR_MASTER_FRAME);
	}

	public String enterVendorCode(Vendor vendor) {
		if (vendor.getVendorCode().length() != 0) {
			enterValueinTextBox(VendorCodeTxt, vendor.getVendorCode());
		} else {
			enterValueinTextBox(VendorCodeTxt, "V" + CustomUtils.randomNumbers(5));
		}
		return VendorCodeTxt.getAttribute("value");
	}

	public String enterVendorName(Vendor vendor) {
		if (vendor.getVendorName().length() != 0) {
			enterValueinTextBox(VendorNameTxt, vendor.getVendorName());
		} else {
			enterValueinTextBox(VendorNameTxt, "HDFCVendor" + CustomUtils.randomNumbers(1));
		}
		return VendorNameTxt.getAttribute("value");
	}

	public void selectVendorCategory(Vendor vendor) {
		selectByVisibleText(CategoryDDwn, vendor.getVendorCategory());
	}

	public void selectBranchCode(Vendor vendor) {
		branchDDwn.getSelect().selectByIndex(1);
		removeBrackets(branchDDwnList.getElements().get(0).getText());
		vendor.setBranchCode(removeBrackets(branchDDwnList.getElements().get(0).getText().split("\\[")[1]));
	}

	private String removeBrackets(String text) {
		return text.replace("]", "");
	}

	public void selectDeviceProductionCheckBox() {
		ClickCheckBox(DeviceProductionChkBx, true);
	}

	public void selectEmbossingTempFileName(Vendor vendor) {
		if (vendor.getEmbossingFileTemp() != null) {
			selectDeviceProductionCheckBox();
			selectByText(EmbossingFileTemplateDDwn, vendor.getEmbossingFileTemp());
		}
	}

	public void selectPINFileTemplate(Vendor vendor) {
		if (vendor.getPINFileTemplateName() != null) {
			ClickCheckBox(PinProductionChkBx, true);
			selectByText(PINFileTemplateDDwn, vendor.getPINFileTemplateName());
		}
	}

	public void enterAddressLine1(Vendor vendor) {
		enterValueinTextBox(AddressLine1Txt, vendor.getAddressLine1());
	}

	public void enterAddressLine2(Vendor vendor) {
		enterValueinTextBox(AddressLine2Txt, vendor.getAddressLine2());
	}

	public void selectCountry(Vendor vendor) {
		selectByText(CountryDDwn, vendor.getCountry());
	}

	public void enterPostalCode(Vendor vendor) {
		enterValueinTextBox(PostalCodeTxt, vendor.getPostalCode());
		waitForLoaderToDisappear();
	}

	public void enterContactPerson() {
		enterValueinTextBox(ContactPersonTxt, Constants.PERSON_NAME);
		clickWhenClickable(ContactPersonTxt);
	}

	public void enterPhoneNumber() {
		enterValueinTextBox(PhoneNumberTxt, Constants.PHONE_NUMBER);
	}

	public void selectMobileNumber(Vendor vendor) {
		selectByText(MobileNo1DDwn, vendor.getVendorMobileNo());
	}

	public void enterMobileNumber() {
		enterValueinTextBox(MobileNo2Txt, Constants.PHONE_NUMBER);
	}

	public void enterEmail(Vendor vendor) {
		enterValueinTextBox(EmailTxt, vendor.getEmail());
		clickWhenClickable(EmailTxt);
	}

	public void Save() {
		clickWhenClickable(SaveBtn);
	}

	public String addVendorDetails(Vendor vendor) {
		String vendorcode;
		String vendorName;
		vendorcode = enterVendorCode(vendor);
		vendorName = enterVendorName(vendor);
		selectVendorCategory(vendor);
		selectBranchCode(vendor);
		return buildDescriptionAndCode(vendorName, vendorcode);
	}

	public void vendorWithAllCapablity(Vendor vendor) {
		selectEmbossingTempFileName(vendor);
		selectPINFileTemplate(vendor);
	}

	public void vendorWithEmbossingTemplateFileName(Vendor vendor) {
		selectEmbossingTempFileName(vendor);
	}

	public void VendorWithPINOffsetTemplate(Vendor vendor) {
		selectPINFileTemplate(vendor);
	}

	public void addressDetails(Vendor vendor) {
		enterAddressLine1(vendor);
		enterAddressLine2(vendor);
		selectCountry(vendor);
		enterPostalCode(vendor);
	}

	public void contactDetails(Vendor vendor) {
		enterContactPerson();
		enterPhoneNumber();
		selectMobileNumber(vendor);
		enterMobileNumber();
		enterEmail(vendor);
	}

	public boolean verifyErrorsOnVendorPage() {
		return publishErrorOnPage();
	}

	public void verifyNewVendorSuccess() {
		if (!verifyErrorsOnVendorPage()) {
			logger.info("Vendor Added Successfully");
			SwitchToDefaultFrame();
		} else {
			logger.info("Error in Vendor Addition");
			clickWhenClickable(CancelBtn);
			SwitchToDefaultFrame();
		}
	}

}
