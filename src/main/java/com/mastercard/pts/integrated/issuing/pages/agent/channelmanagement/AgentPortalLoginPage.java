package com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement;

import java.util.Collection;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class AgentPortalLoginPage extends AbstractBasePage {
	final Logger logger = LoggerFactory.getLogger(AgentPortalLoginPage.class);

	@PageElement(findBy = FindBy.ID, valueToFind = "useralias")
	private MCWebElement username;

	@PageElement(findBy = FindBy.ID, valueToFind = "password")
	private MCWebElement password;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@type='submit'][@value='Login']")
	private MCWebElement signin;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[contains(text(),'Signout')]")
	private MCWebElement signOut;

	public void loadPage() {
		getFinder().getWebDriver()
				.get(env.getProperty("agent.application.url"));

	}

	public void loginAsAdmin() {

		loadPage();
		enterUserID(env.getProperty("portal.agent.user.admin.UserName1"))
				.enterPwd(env.getProperty("portal.agent.user.admin.Password1"))
				.clickSignIn();
		switchWindow();

	}

	public void loginAsUser() {

		loadPage();
		enterUserID(env.getProperty("portal.agent.user.UserName1")).enterPwd(
				env.getProperty("portal.agent.user.Password1")).clickSignIn();
		switchWindow();

	}

	public void login(String uName, String pwd) {
		loadPage();

		if ("AdminUser1".equals(uName) && "AdminPassword1".equals(pwd)) {

			enterUserID(env.getProperty("portal.agent.user.admin.UserName1"))
					.enterPwd(
							env.getProperty("portal.agent.user.admin.Password1"))
					.clickSignIn();
		}

		else if ("AdminUser2".equals(uName) && "AdminPassword2".equals(pwd)) {

			enterUserID(env.getProperty("portal.agent.user.admin.UserName2"))
					.enterPwd(
							env.getProperty("portal.agent.user.admin.Password2"))
					.clickSignIn();
		}

		else if ("User1".equals(uName) && "Password1".equals(pwd)) {

			enterUserID(env.getProperty("portal.agent.user.UserName1"))
					.enterPwd(env.getProperty("portal.agent.user.Password1"))
					.clickSignIn();
		}

		else if ("User2".equals(uName) && "Password2".equals(pwd)) {

			enterUserID(env.getProperty("portal.agent.user.UserName2"))
					.enterPwd(env.getProperty("portal.agent.user.Password2"))
					.clickSignIn();
		}

		else {
			enterUserID(uName).enterPwd(pwd).clickSignIn();
		}

		switchWindow();

	}

	public AgentPortalLoginPage enterUserID(String uName) {
		if (!isLoggedIn(getFinder().getWebDriver())) {
			username.sendKeys(uName);
		} else {
			logger.info("User Id text box not found");
		}
		return this;
	}

	public AgentPortalLoginPage enterPwd(String pwd) {
		if (!isLoggedIn(getFinder().getWebDriver())) {
			password.sendKeys(pwd);
		} else {
			logger.info("Password text box not found");
		}
		return this;
	}

	private void clickSignIn() {
		if (!isLoggedIn(getFinder().getWebDriver())) {
			signin.click();
		} else {
			logger.info("Logout Button not found");
		}
	}

	private void switchWindow() {

		try {
			Set<String> handles;

			do {
				handles = getFinder().getWebDriver().getWindowHandles();
				logger.info("Number of windows available: " + handles.size());
			} while (handles.size() < 2);

			for (String handle : handles) {
				if (!handle
						.equals(getFinder().getWebDriver().getWindowHandle()))
					getFinder().getWebDriver().switchTo().window(handle);
			}
		} catch (Exception e) {
			logger.error("Unable to Switch Window" + e);
		}
	}

	public void clickLogout() {

		signOut.click();

		getFinder().getWebDriver().close();

		Set<String> handles = getFinder().getWebDriver().getWindowHandles();
		for (String handle : handles) {

			getFinder().getWebDriver().switchTo().window(handle);
		}

	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return null;
	}

}
