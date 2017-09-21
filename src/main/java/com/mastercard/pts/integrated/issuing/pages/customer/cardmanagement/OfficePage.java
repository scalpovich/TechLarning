package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Office;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.SimulatorUtilities;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
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

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addOffice;

	@PageElement(findBy = FindBy.NAME, valueToFind = "officeType:input:dropdowncomponent")
	private MCWebElement OfficeType;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelERROR']")
	private MCWebElement PanelError;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "w_close")
	private MCWebElement AddOfficeDialogClose;

	@PageElement(findBy = FindBy.NAME, valueToFind = "branchCode:input:inputTextField")
	private MCWebElement ZoneCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "branchName:input:inputTextField")
	private MCWebElement ZoneName;

	@PageElement(findBy = FindBy.NAME, valueToFind = "controlCode:input:dropdowncomponent")
	private MCWebElement ControlCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "address1:input:inputTextField")
	private MCWebElement AddressLine1;

	@PageElement(findBy = FindBy.NAME, valueToFind = "address2:input:inputTextField")
	private MCWebElement AddressLine2;

	@PageElement(findBy = FindBy.NAME, valueToFind = "countryCode:input:dropdowncomponent")
	private MCWebElement Country;

	@PageElement(findBy = FindBy.NAME, valueToFind = "zipCode:input:inputTextField")
	private MCWebElement PostalCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "contactName:input:inputTextField")
	private MCWebElement PersonName;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement cancel;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelINFO']")
	private MCWebElement PanelInfo;
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

	public void clickAddOffice() {
		waitForElementVisible(addOffice);
		addOffice.click();
	}

	public void switchToAddOfficeFrame() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_OFFICE_FRAME);
	}

	public void selectOfficeType(Office office) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectByVisibleText(OfficeType, office.getOfficeType());
	}

	public void selectControlOffice() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		if (ControlCode.isEnabled()) {
			waitForElementVisible(ControlCode);
			selectByVisibleText(ControlCode, getControlCode());
		}
	}

	public String enterZoneCode() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(ZoneCode, CustomUtils.randomNumbers(3));
		// String zonecode =
		return ZoneCode.getAttribute("value");
	}

	public String enterZoneName(String type) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(ZoneName, "Office" + type + CustomUtils.randomNumbers(1));
		return ZoneName.getAttribute("value");

	}

	public void enterAddressLine1() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(AddressLine1, OfficeDataProvider().getAddressLine1());
	}

	public void enterAddressLine2() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(AddressLine2, OfficeDataProvider().getAddressLine2());
	}

	public void selectCountry() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectByVisibleText(Country, OfficeDataProvider().getCountry());
	}

	public void enterPostalCode() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(PostalCode, OfficeDataProvider().getPostalCode());
	}

	public void clickSaveButton() {
		waitForElementVisible(save);
		ClickButton(save);
		try {
			if (save.isEnabled()) {
				ClickButton(save);
			}
		} catch (Exception e2) {
			try {
				if (PanelInfo.isVisible()) {
					Assert.assertEquals(PanelInfo.getText(), Constants.Record_Added_Successfully);
				}
				logger.error(e2.toString());
			} catch (Exception e) {
				logger.error(e.toString());
				try {
					if (PanelError.isVisible()) {
						logger.info("inside error pannel");
						cancel.click();
					}
				} catch (Exception e1) {
					logger.error(e1.toString());
					logger.info("error pannel not present");
				}
			}
		}
		SwitchToDefaultFrame();
	}

	public void addofficezone() {
		addOffice.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");

		OfficeType.getSelect().selectByVisibleText(env.getProperty("is.dinners.office.officetype"));
		CustomUtils.ThreadDotSleep(2000);
		ZoneCode.sendKeys(env.getProperty("is.dinners.office.zonecode"));
		ZoneName.sendKeys(env.getProperty("is.dinners.office.zonename"));
		AddressLine1.sendKeys(env.getProperty("is.dinners.office.addressline1"));

		Country.getSelect().selectByVisibleText(env.getProperty("is.dinners.office.country"));
		CustomUtils.ThreadDotSleep(2000);

		PersonName.sendKeys(env.getProperty("is.dinners.office.personname"));
		CustomUtils.ThreadDotSleep(2000);
		AddressLine2.sendKeys(env.getProperty("is.dinners.office.addressline2"));
		CustomUtils.ThreadDotSleep(2000);
		PostalCode.sendKeys(env.getProperty("is.dinners.office.postalcode"));
		CustomUtils.ThreadDotSleep(2000);
		AddressLine2.click();
		CustomUtils.ThreadDotSleep(2000);
		save.click();
		CustomUtils.ThreadDotSleep(3000);

		try {
			if (PanelError.isVisible()) {
				System.out.println("inside error pannel");
				cancel.click();
			}
		} catch (Exception e) {
			System.out.println("error pannel not present");
		}
		getFinder().getWebDriver().switchTo().defaultContent();

	}

	public void addofficeregion() {
		addOffice.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");

		OfficeType.getSelect().selectByVisibleText(env.getProperty("is.dinners.office.officetype2"));
		CustomUtils.ThreadDotSleep(2000);
		ZoneCode.sendKeys(env.getProperty("is.dinners.office.zonecode2"));
		ZoneName.sendKeys(env.getProperty("is.dinners.office.zonename2"));
		// ControlCode.getSelect().selectByVisibleText(env.getProperty("is.dinners.office.controlcode3"));
		ControlCode.getSelect().selectByVisibleText(env.getProperty("is.dinners.office.controlcode2"));

		AddressLine1.sendKeys(env.getProperty("is.dinners.office.addressline1"));

		Country.getSelect().selectByVisibleText(env.getProperty("is.dinners.office.country"));

		PostalCode.sendKeys(env.getProperty("is.dinners.office.postalcode2"));
		PersonName.sendKeys(env.getProperty("is.dinners.office.personname"));
		CustomUtils.ThreadDotSleep(2000);
		AddressLine2.sendKeys(env.getProperty("is.dinners.office.addressline2"));
		AddressLine2.click();
		CustomUtils.ThreadDotSleep(2000);

		save.click();
		CustomUtils.ThreadDotSleep(2000);

		try {
			if (PanelError.isVisible()) {
				System.out.println("inside error pannel");
				cancel.click();
			}
		} catch (Exception e) {
			System.out.println("error pannel not present");
		}
		getFinder().getWebDriver().switchTo().defaultContent();

	}

	public void addofficebranch() {
		addOffice.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");

		OfficeType.getSelect().selectByVisibleText(env.getProperty("is.dinners.office.officetype3"));
		CustomUtils.ThreadDotSleep(2000);
		ZoneCode.sendKeys(env.getProperty("is.dinners.office.zonecode3"));
		ZoneName.sendKeys(env.getProperty("is.dinners.office.zonename3"));
		CustomUtils.ThreadDotSleep(2000);
		ControlCode.getSelect().selectByVisibleText(env.getProperty("is.dinners.office.controlcode3"));
		// ControlCode.getSelect().selectByVisibleText("COLOMBO Region [002]");
		AddressLine1.sendKeys(env.getProperty("is.dinners.office.addressline1"));

		Country.getSelect().selectByVisibleText(env.getProperty("is.dinners.office.country"));

		PostalCode.sendKeys(env.getProperty("is.dinners.office.postalcode"));
		PersonName.sendKeys(env.getProperty("is.dinners.office.personname"));
		CustomUtils.ThreadDotSleep(2000);
		AddressLine2.sendKeys(env.getProperty("is.dinners.office.addressline2"));
		AddressLine2.click();
		CustomUtils.ThreadDotSleep(2000);

		save.click();
		CustomUtils.ThreadDotSleep(2000);
		try {
			if (PanelError.isVisible()) {
				System.out.println("inside error pannel");
				cancel.click();
			}
		} catch (Exception e) {
			System.out.println("error pannel not present");
		}
		getFinder().getWebDriver().switchTo().defaultContent();

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
