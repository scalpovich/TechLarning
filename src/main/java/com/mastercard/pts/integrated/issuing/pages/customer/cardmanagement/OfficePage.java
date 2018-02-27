package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Office;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_OFFICE })
public class OfficePage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(OfficePage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=branchCode]")
	private MCWebElement branchCode;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=branchName]")
	private MCWebElement branchName;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='branchName']")
	private MCWebElement branchNamePopupTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='branchCode']")
	private MCWebElement branchCodePopupTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='address1']")
	private MCWebElement address1PopupTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='address2']")
	private MCWebElement address2PopupTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='address3']")
	private MCWebElement address3PopupTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='zipCode']")
	private MCWebElement zipPopupTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='officeType']/span/select")
	private MCWebElement ofcTypeDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='controlCode']/span/select")
	private MCWebElement controlCodeDwn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='countryCode']/select")
	private MCWebElement countryCodeDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='cityCodeTxt']")
	private MCWebElement cityCodePopupTxt;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addOfficeBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "officeType:input:dropdowncomponent")
	private MCWebElement OfficeTypeDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelERROR']")
	private MCWebElement PanelError;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "w_close")
	private MCWebElement AddOfficeDialogClose;

	@PageElement(findBy = FindBy.NAME, valueToFind = "branchCode:input:inputTextField")
	private MCWebElement ZoneCodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "branchName:input:inputTextField")
	private MCWebElement ZoneNameTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "controlCode:input:dropdowncomponent")
	private MCWebElement ControlCodeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "address1:input:inputTextField")
	private MCWebElement AddressLine1Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "address2:input:inputTextField")
	private MCWebElement AddressLine2Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "countryCode:input:dropdowncomponent")
	private MCWebElement CountryDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "zipCode:input:inputTextField")
	private MCWebElement PostalCodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "contactName:input:inputTextField")
	private MCWebElement PersonNameTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement cancelBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelINFO']")
	private MCWebElement PanelInfo;

	public void clickAddOffice() {
		clickWhenClickable(addOfficeBtn);
		switchToAddOfficeFrame();
	}

	public void switchToAddOfficeFrame() {
		switchToIframe(Constants.ADD_OFFICE_FRAME);
	}

	public void selectOfficeType(Office office) { 
		selectByVisibleText(OfficeTypeDDwn, office.getOfficeType());
	}

	public void selectControlOffice(Office office) {
		if (ControlCodeDDwn.isEnabled()) {
			WebElementUtils.selectDropDownByVisibleText(ControlCodeDDwn, office.getOfficeCode());
			//selectByVisibleText(ControlCodeDDwn, office.getOfficeCode());
		}
	}

	public String enterZoneCode() {
		enterValueinTextBox(ZoneCodeTxt, CustomUtils.randomNumbers(3));
		return ZoneCodeTxt.getAttribute("value");
	}

	public String enterZoneName(String type) {
		enterValueinTextBox(ZoneNameTxt, "Office" + type + CustomUtils.randomNumbers(1));
		return ZoneNameTxt.getAttribute("value");

	}

	public void enterAddressLine1(Office office) {
		enterValueinTextBox(AddressLine1Txt, office.getAddressLine1());
	}

	public void enterAddressLine2(Office office) {
		enterValueinTextBox(AddressLine2Txt, office.getAddressLine2());
	}

	public void selectCountry(Office office) {
		selectByVisibleText(CountryDDwn, office.getCountry());
	}

	public void enterPostalCode(Office office) {
		enterValueinTextBox(PostalCodeTxt, office.getZip());
	}

	public void clickSaveBtn() {
		clickWhenClickable(saveBtn);
	}

	public boolean verifyErrorsOnOfficePage() {
		waitForPageToLoad(getFinder().getWebDriver());
		return publishErrorOnPage();
	}

	public void verifyNewOfficeSuccess() {
		if (!verifyErrorsOnOfficePage()) {
			logger.info("Office Added Successfully");
			SwitchToDefaultFrame();
		} else {
			logger.info("Error in record Addition");
			waitForPageToLoad(getFinder().getWebDriver());
			clickWhenClickable(cancelBtn);
			SwitchToDefaultFrame();

		}
	}

	public String addOfficeDetails(String type, Office office) {
		String ControlCode;
		String ZoneName;
		selectOfficeType(office); 
		ControlCode = enterZoneCode();		
		ZoneName = enterZoneName(type);
		selectControlOffice(office);
		enterAddressLine1(office);
		enterAddressLine2(office);
		selectCountry(office);
		enterPostalCode(office);
		waitForLoaderToDisappear();
		clickWhenClickable(AddressLine1Txt);
		waitForPageToLoad(getFinder().getWebDriver());
		clickSaveBtn();
		return ZoneName + " " + "[" + ControlCode + "]";

	}
	public void verifyUiOperationStatus() {
		logger.info("Office");
		verifyUiOperation("Add Office");
	}
	
	
	public void addOffice(List<Office> officeList)
	{
		officeList.forEach(ofc->{
			performSearchOperationOnMainScreen(ofc);
			if(isNoRecordsFoundInTable())
			{
				logger.info("create office : {}",ofc.toString());
				clickAddNewButton();
				runWithinPopup(
						"Add Office",
						() -> {
								addOffice(ofc);
								verifyNoErrors();
						});
		
				verifyOperationStatus(); 
			}      
		});
	}
	
	private void addOffice(Office ofc)
	{					
			WebElementUtils.selectDropDownByVisibleText(ofcTypeDwn, ofc.getOfficeType());
			if(!ofc.getOfficeType().toUpperCase().contains("ZONAL"))
			{
				WebElementUtils.selectDropDownByVisibleText(controlCodeDwn, ofc.getControlOffice());
			}
			WebElementUtils.selectDropDownByVisibleText(countryCodeDwn, ofc.getCountry());
			WebElementUtils.enterText(branchCodePopupTxt, ofc.getOfficeCode());
			WebElementUtils.enterText(branchNamePopupTxt, ofc.getOfficeName());
			WebElementUtils.enterText(address1PopupTxt, ofc.getAddressLine1());
			WebElementUtils.enterText(address2PopupTxt, ofc.getAddressLine2());
			WebElementUtils.enterText(zipPopupTxt, ofc.getZip());
			SimulatorUtilities.wait(5000);
			WebElementUtils.enterText(address3PopupTxt, ofc.getAddressLine2());
			SimulatorUtilities.wait(5000);
			clickSaveButton();
	}

	private void performSearchOperationOnMainScreen(Office ofc)
	{
		WebElementUtils.enterText(branchName, ofc.getOfficeName());
		clickSearchButton();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(branchCode),
				WebElementUtils.elementToBeClickable(branchName));
	}
}
