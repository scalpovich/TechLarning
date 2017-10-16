package com.mastercard.pts.integrated.issuing.pages;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class OfficePage extends AbstractBasePage {

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

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
		ZoneCode.sendKeys(env.getProperty("is.dinners.office.zonecode"));
		ZoneName.sendKeys(env.getProperty("is.dinners.office.zonename2"));
		// ControlCode.getSelect().selectByVisibleText(env.getProperty("is.dinners.office.controlcode3"));
		ControlCode.getSelect().selectByVisibleText(env.getProperty("is.dinners.office.controlcode2"));

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

	public void addofficebranch() {
		addOffice.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");

		OfficeType.getSelect().selectByVisibleText(env.getProperty("is.dinners.office.officetype3"));
		CustomUtils.ThreadDotSleep(2000);
		ZoneCode.sendKeys(env.getProperty("is.dinners.office.zonecode3"));
		ZoneName.sendKeys(env.getProperty("is.dinners.office.zonename3"));
		CustomUtils.ThreadDotSleep(2000);
		// ControlCode.getSelect().selectByVisibleText(env.getProperty("is.dinners.office.controlcode4"));
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

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}
