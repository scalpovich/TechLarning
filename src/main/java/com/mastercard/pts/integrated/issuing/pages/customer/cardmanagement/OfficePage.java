package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Collection;

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
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1INSTITUTION_PARAMETER_SETUP, CardManagementNav.L2OFFICE })
public class OfficePage extends AbstractBasePage {
	final Logger logger = LoggerFactory.getLogger(EmbossingPriorityPassPage.class);

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

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
			selectByVisibleText(ControlCodeDDwn, office.getControlCode());
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
		enterValueinTextBox(PostalCodeTxt, office.getPostalCode());
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

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return null;
	}

}
