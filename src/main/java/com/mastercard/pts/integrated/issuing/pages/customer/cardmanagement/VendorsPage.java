package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Vendor;
import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_VENDORS
})

public class VendorsPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory.getLogger(VendorsPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=vendorCode]")
	private MCWebElement vendorCode;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=vendorName]")
	private MCWebElement vendorName;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement category;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement branch;

	@PageElement(findBy = FindBy.CSS, valueToFind = "select[name='vendorType:input:dropdowncomponent']")
	private MCWebElement categoryDrpDwnPopup;

	@PageElement(findBy = FindBy.CSS, valueToFind = "select[name='embossFileTemplate:input:dropdowncomponent']")
	private MCWebElement embossingFileTemplateDrpDwnPopup;

	@PageElement(findBy = FindBy.NAME, valueToFind ="branchCode:input:dropdowncomponent")
	private MCWebElement branchDrpDwnPopup;


	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=address1]")
	private MCWebElement address1Popup;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=address2]")
	private MCWebElement address2Popup;


	@PageElement(findBy = FindBy.CSS, valueToFind ="select[name='countryCode:input:dropdowncomponent']")
	private MCWebElement countryDrpDwnPopup;


	@PageElement(findBy = FindBy.NAME, valueToFind ="contactName:input:inputTextField")
	private MCWebElement contactPersonPopup;

	@PageElement(findBy = FindBy.CSS, valueToFind ="input[fld_fqn=phoneNumber]")
	private MCWebElement phoneNumberPopup;


	@PageElement(findBy = FindBy.NAME, valueToFind = "mobileCntryCode:input:dropdowncomponent")
	private MCWebElement mobileNoDrpDwnPopup;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=mobileNumber]")
	private MCWebElement mobileNoTxtBxPopup;


	@PageElement(findBy = FindBy.CSS, valueToFind ="input[fld_fqn=emailId]")
	private MCWebElement emailIdPopup;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtnPopup;


	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=zipCode]")
	private MCWebElement zipCodeTxtBx;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=cityCodeTxt]")
	private MCWebElement cityTxtBX;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=deviceProductionSupported]")
	private MCWebElement deviceProductionChk;

	public void verifyUiOperationStatus() {
		logger.info("Vendor Master");
		verifyUiOperation("Add Vendor Master");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(vendorCode),
				WebElementUtils.elementToBeClickable(vendorName),
				WebElementUtils.elementToBeClickable(category),
				WebElementUtils.elementToBeClickable(branch)
				);
	}

	public void addVendorMaster(Vendor vendor)
	{
		performSearchOperationOnMainScreen(vendor);
		if(isNoRecordsFoundInTable())
			{		logger.info("Vendor ");
			clickAddNewButton();
	
			runWithinPopup("Add Vendor", () -> {
				WebElementUtils.enterText(vendorCode, vendor.getVendorCode());
				WebElementUtils.enterText(vendorName, vendor.getVendorName());
				WebElementUtils.selectDropDownByVisibleText(categoryDrpDwnPopup, vendor.getCategory());	
				WebElementUtils.selectDropDownByVisibleText(branchDrpDwnPopup, vendor.getBranch());
				if(vendor.getCategory().contains("Personalization Bureau")){
					WebElementUtils.checkCheckbox(deviceProductionChk, true);
					WebElementUtils.selectDropDownByVisibleText(embossingFileTemplateDrpDwnPopup, vendor.getEmbosingFileTemplate());
					}
				WebElementUtils.enterText(address1Popup, ConstantData.VENDOR_MASTER_ADDRESS);
				WebElementUtils.enterText(address2Popup,ConstantData.VENDOR_MASTER_ADDRESS);
				WebElementUtils.selectDropDownByVisibleText(countryDrpDwnPopup, ConstantData.VENDOR_MASTER_COUNTRY);
				WebElementUtils.enterText(contactPersonPopup, ConstantData.VENDOR_MASTER_CONTACT_PERSON);
				WebElementUtils.enterText(phoneNumberPopup,ConstantData.VENDOR_MASTER_PHONE_NO);
				WebElementUtils.enterText(zipCodeTxtBx,ConstantData.POSTAL_CODE);	
				WebElementUtils.selectDropDownByVisibleText(mobileNoDrpDwnPopup, ConstantData.VENDOR_MASTER_MOBILE_COUNTRY_CODE);
				WebElementUtils.enterText(mobileNoTxtBxPopup, ConstantData.VENDOR_MASTER_MOBILE_NUMBER);
				WebElementUtils.enterText(emailIdPopup,ConstantData.VENDOR_MASTER_EMAIL );
	
				clickSaveButton();
			});
	
			verifyOperationStatus();
			}
	}
	
	private void performSearchOperationOnMainScreen(Vendor vendor)
	{
		WebElementUtils.enterText(vendorCode, vendor.getVendorCode());
		clickSearchButton();
	}

}
