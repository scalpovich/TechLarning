package com.mastercard.pts.integrated.issuing.pages.customer.administration;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.configuration.Portal;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class LoginPage extends AbstractBasePage {
	final Logger logger = LoggerFactory.getLogger(LoginPage.class);
	@PageElement(findBy = FindBy.ID, valueToFind = "userid")
	private MCWebElement username;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@type='password']")
	private MCWebElement password;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[contains(text(),'Sign Out')]")
	private MCWebElement signOut;

	@PageElement(findBy = FindBy.ID, valueToFind = "useralias")
	private MCWebElement AgentPortalUsername;

	@PageElement(findBy = FindBy.ID, valueToFind = "userid")
	private MCWebElement CutomerPortalUsername;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@type='submit']")
	private MCWebElement signin;

	public void loadPage() {
		CustomUtils.ThreadDotSleep(4000);
		getFinder().getWebDriver().get(env.getProperty("application.url"));
		CustomUtils.ThreadDotSleep(4000);
	}

	public void loadAppURL() {
		getFinder().getWebDriver().manage().deleteAllCookies();
		getFinder().getWebDriver()
				.get(MapUtils.fnGetInputDataFromMap("AppURL"));
	}

	public void login() {

		loadPage();
		enterUserID(env.getProperty("app.user.name")).enterPwd(
				env.getProperty("app.user.name")).clickSignIn();

	}

	public void login(String uName, String pwd) {
		loadPage();

		if ("AdminUser1".equals(uName) && "AdminPassword1".equals(pwd)) {

			enterUserID(env.getProperty("portal.customer.user.admin.UserName1"))
					.enterPwd(
							env.getProperty("portal.customer.user.admin.Password1"))
					.clickSignIn();
		}

		else if ("AdminUser2".equals(uName) && "AdminPassword2".equals(pwd)) {

			enterUserID(env.getProperty("portal.customer.user.admin.UserName2"))
					.enterPwd(
							env.getProperty("portal.customer.user.admin.Password2"))
					.clickSignIn();
		}

		else if ("User1".equals(uName) && "Password1".equals(pwd)) {

			enterUserID(env.getProperty("portal.customer.user.UserName1"))
					.enterPwd(env.getProperty("portal.customer.user.Password1"))
					.clickSignIn();
		}

		else if ("User2".equals(uName) && "Password2".equals(pwd)) {

			enterUserID(env.getProperty("portal.customer.user.UserName2"))
					.enterPwd(env.getProperty("portal.customer.user.Password2"))
					.clickSignIn();
		}

		else {
			enterUserID(uName).enterPwd(pwd).clickSignIn();
		}
	}

	public void loginTo(String uName, String pwd) {
		loadAppURL();
		CustomUtils.ThreadDotSleep(3000);
		enterUserID(uName).enterPwd(pwd).clickSignIn();
	}

	public LoginPage enterUserID(String uName) {
		if (!isLoggedIn(getFinder().getWebDriver())) {
			username.sendKeys(uName);
		} else {
			System.out
					.println("Logout Button not found  we are not setting userID");
		}
		return this;
	}

	public LoginPage enterPwd(String pwd) {
		if (!isLoggedIn(getFinder().getWebDriver())) {
			password.sendKeys(pwd);
		} else {
			System.out
					.println("Logout Button not found  we are not setting userID");
		}
		return this;
	}

	private void clickSignIn() {
		if (!isLoggedIn(getFinder().getWebDriver())) {
			signin.click();
		} else {
			System.out
					.println("Logout Button not found  we are not loading page and miximizing it");
		}
	}

	public void clickLogout() {

		signOut.click();

	}

	public void login(String portal, String uName, String pwd) {
		enterUserID(portal, uName).enterPwd(pwd).clickSignIn(portal);
	}

	public LoginPage enterUserID(String portal, String uName) {
		if (!isLoggedIn(getFinder().getWebDriver())) {
			if (portal.equalsIgnoreCase(Portal.TYPE_AGENT)) {
				AgentPortalUsername.sendKeys(uName);
			} else if (portal.equalsIgnoreCase(Portal.TYPE_CUSTOMER)) {
				CutomerPortalUsername.sendKeys(uName);
			}
		} else {
			logger.info("Logout Button not found  we are not setting userID");
		}
		return this;
	}

	private void clickSignIn(String portal) {
		if (!isLoggedIn(getFinder().getWebDriver())) {
			if (portal.equalsIgnoreCase(Portal.TYPE_AGENT)) {
				signin.click();
				switchWindow();
			} else if (portal.equalsIgnoreCase(Portal.TYPE_CUSTOMER)) {
				signin.click();
			}

		} else {
			logger.info("Logout Button not found  we are not loading page and miximizing it");
		}
	}

	private void switchWindow() {
		Set<String> handles = getFinder().getWebDriver().getWindowHandles();
		for (String handle : handles) {
			if (!handle.equals(getFinder().getWebDriver().getWindowHandle()))
				getFinder().getWebDriver().switchTo().window(handle);
		}
	}
}
