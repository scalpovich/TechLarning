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
public class UserPage extends AbstractBasePage {

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addUser;

	@PageElement(findBy = FindBy.NAME, valueToFind = "usrId:input:inputTextField")
	private MCWebElement UserId;

	@PageElement(findBy = FindBy.NAME, valueToFind = "usrName:input:inputTextField")
	private MCWebElement UserName;

	@PageElement(findBy = FindBy.NAME, valueToFind = "rolId:input:dropdowncomponent")
	private MCWebElement Role;

	@PageElement(findBy = FindBy.NAME, valueToFind = "languagePreference:input:dropdowncomponent")
	private MCWebElement LanguagePreference;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tzName:input:dropdowncomponent")
	private MCWebElement TimeZone;

	@PageElement(findBy = FindBy.NAME, valueToFind = "usrEmailId1:input:inputTextField")
	private MCWebElement EmailAddress;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mobileCntryCode:input:dropdowncomponent")
	private MCWebElement MobileNoCountryCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "usrmobileNo:input:inputTextField")
	private MCWebElement MobileNo;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/div/form/table[1]/tbody/tr[8]/td[2]/span/span/span/img")
	private MCWebElement UserAccountExpiryDate;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/div/form/table[1]/tbody/tr[8]/td[2]/span/span/span/span/table/tbody/tr[5]/td[7]/a")
	private MCWebElement selectUserAccountExpiryDate;

	@PageElement(findBy = FindBy.NAME, valueToFind = "concurrentLoginAllowed:input:dropdowncomponent")
	private MCWebElement ConcurrentLoginAllowed;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/div/form/div[2]/span/div/table/tbody/tr[2]/td[4]/span/input")
	private MCWebElement AssignInstitution;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/div/form/div[2]/span/div/table/tbody/tr[2]/td[5]/span/input")
	private MCWebElement DefaultInstitution;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

	public void createuser() {
		 

		String userName = CustomUtils.randomString(6);

		addUser.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");

		UserId.sendKeys(CustomUtils.randomNumbers(6));
		CustomUtils.ThreadDotSleep(1000);
		UserName.sendKeys(userName);
		Role.getSelect().selectByVisibleText(
				env.getProperty("is.dinners.user.Role"));
		CustomUtils.ThreadDotSleep(1000);
		LanguagePreference.getSelect().selectByVisibleText(
				env.getProperty("is.dinners.user.LanguagePreference"));
		CustomUtils.ThreadDotSleep(1000);
		TimeZone.getSelect().selectByVisibleText(
				env.getProperty("is.dinners.user.TimeZone"));
		CustomUtils.ThreadDotSleep(1000);
		// EmailAddress.sendKeys(env.getProperty("is.dinners.user.EmailAddress"));
		userName = userName + "@gmail.com";
		EmailAddress.sendKeys(userName);

		CustomUtils.ThreadDotSleep(1000);
		MobileNoCountryCode.getSelect().selectByVisibleText(
				env.getProperty("is.dinners.user.MobileNoCountryCode"));
		CustomUtils.ThreadDotSleep(1000);
		MobileNo.sendKeys(CustomUtils.randomNumbers(10));
		UserAccountExpiryDate.click();
		CustomUtils.ThreadDotSleep(1000);
		selectUserAccountExpiryDate.click();
		CustomUtils.ThreadDotSleep(1000);
		ConcurrentLoginAllowed.getSelect().selectByVisibleText(
				env.getProperty("is.dinners.user.ConcurrentLoginAllowed"));
		CustomUtils.ThreadDotSleep(1000);
		AssignInstitution.click();
		CustomUtils.ThreadDotSleep(1000);
		DefaultInstitution.click();
		CustomUtils.ThreadDotSleep(1000);

		save.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().defaultContent();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}
