package com.mastercard.pts.integrated.issuing.pages.customer.administration;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.configuration.Portal;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class LoginPage extends AbstractBasePage {
	final Logger llogger = LoggerFactory.getLogger(LoginPage.class);
	public static final String AUTHENTIFICATION_FAILED_COLLECT = "Authentication failed. "
			+ "You have used an invalid user name, password or client certificate.";

	public static final String AUTHENTIFICATION_FAILED_CARDHOLDER = "LOGON FAILED- Invalid User ID";
	public static final String AUTHENTIFICATION_FAILED = "Invalid UserId/Password.";

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[type='text']")
	private MCWebElement userIdInput;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[type='password']")
	private MCWebElement passwordInput;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[type='submit']")
	private MCWebElement loginButton;

	private By messageBoxLocator = By.cssSelector(".feedbackPanelERROR");

	@PageElement(findBy = FindBy.ID, valueToFind = "userid")
	private MCWebElement username;

	@PageElement(findBy = FindBy.ID, valueToFind = "useralias")
	private MCWebElement useralias;

	/*
	 * @PageElement(findBy = FindBy.X_PATH, valueToFind =
	 * "//div[@class = 'error-btn']//a[contains(text(),'Back to login page')]")
	 * private MCWebElement backToLoginPageTxt;
	 */
	@PageElement(findBy = FindBy.TEXT_VALUE_CONTAINS, valueToFind = "Back to login page")
	private MCWebElement backToLoginPageTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@type='password']")
	private MCWebElement password;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[contains(text(),'Sign Out')]")
	private MCWebElement signOut;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[contains(text(), 'Signout' )]")
	private MCWebElement singOutCardHolder;

	@PageElement(findBy = FindBy.ID, valueToFind = "useralias")
	private MCWebElement AgentPortalUsername;

	@PageElement(findBy = FindBy.ID, valueToFind = "userid")
	private MCWebElement CutomerPortalUsername;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@type='submit']")
	private MCWebElement signin;

	@Value("${default.wait.timeout_in_sec}")
	private long timeoutInSec;

	@PageElement(findBy = FindBy.ID, valueToFind = "userAlias")
	private MCWebElement chpSignUpUserAlias;

	@PageElement(findBy = FindBy.ID, valueToFind = "newLoginPassword")
	private MCWebElement chplNewSignUpPassword;

	@PageElement(findBy = FindBy.ID, valueToFind = "confirmLoginPassword")
	private MCWebElement chpSignUpPasswordConfirm;

	@PageElement(findBy = FindBy.ID, valueToFind = "newTxnPassword")
	private MCWebElement chpSignUpTranPass;

	@PageElement(findBy = FindBy.ID, valueToFind = "confirmTxnPassword")
	private MCWebElement chpSignUpTranPassConfirm;

	@PageElement(findBy = FindBy.ID, valueToFind = "question")
	private MCWebElement chpSignUpSeqQuesOne;

	@PageElement(findBy = FindBy.ID, valueToFind = "txtAnswer")
	private MCWebElement chpSignUpSeqQueOneInpt;

	@PageElement(findBy = FindBy.ID, valueToFind = "question2")
	private MCWebElement chpSignUpSeqQueTwo;

	@PageElement(findBy = FindBy.ID, valueToFind = "txtAnswer2")
	private MCWebElement chpSignUpSeqQueTwoAnsInpt;

	@PageElement(findBy = FindBy.ID, valueToFind = "oldTxnPassword")
	private MCWebElement currentPassword;

	@PageElement(findBy = FindBy.ID, valueToFind = "mpts_cardHolderPortal_button_submit")
	private MCWebElement signUpConfirmBtn;

	public void loadPage() {
		getFinder().getWebDriver().get(env.getProperty("application.url"));
		if (!(driver().findElements(By.xpath("//div[@class = 'error-btn']")).isEmpty())) {
			clickWhenClickable(backToLoginPageTxt);
		} else {
			System.out.println("Element is Absent");
		}

	}

	public void loadAppURL() {
		getFinder().getWebDriver().manage().deleteAllCookies();
		getFinder().getWebDriver().get(MapUtils.fnGetInputDataFromMap("AppURL"));
		if (!(driver().findElements(By.xpath("//div[@class = 'error-btn']")).isEmpty())) {
			backToLoginPageTxt.click();
		} else {
			System.out.println("Element is Absent");
		}

	}

	public void login() {

		loadPage();
		enterUserID(env.getProperty("app.user.name")).enterPwd(env.getProperty("app.user.name")).clickSignIn();

	}

	public void login(String uName, String pwd) {
		loadPage();

		if ("AdminUser1".equals(uName) && "AdminPassword1".equals(pwd)) {

			enterUserID(env.getProperty("portal.customer.user.admin.UserName1"))
					.enterPwd(env.getProperty("portal.customer.user.admin.Password1")).clickSignIn();
		}

		else if ("AdminUser2".equals(uName) && "AdminPassword2".equals(pwd)) {

			enterUserID(env.getProperty("portal.customer.user.admin.UserName2"))
					.enterPwd(env.getProperty("portal.customer.user.admin.Password2")).clickSignIn();
		}

		else if ("User1".equals(uName) && "Password1".equals(pwd)) {

			enterUserID(env.getProperty("portal.customer.user.UserName1"))
					.enterPwd(env.getProperty("portal.customer.user.Password1")).clickSignIn();
		}

		else if ("User2".equals(uName) && "Password2".equals(pwd)) {

			enterUserID(env.getProperty("portal.customer.user.UserName2"))
					.enterPwd(env.getProperty("portal.customer.user.Password2")).clickSignIn();
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

	public boolean loginToCardholder(String uName, String pwd) {
		loadAppURL();
		CustomUtils.ThreadDotSleep(3000);
		enterUserIDCardHolder(uName).enterPwd(pwd).clickSignIn();

		return waitforElement(chpSignUpUserAlias);
	}

	public void loginToCardholderAfterSignUp(String uName, String pwd) {
		CustomUtils.ThreadDotSleep(3000);
		enterUserIDCardHolder(uName).enterPwd(pwd).clickSignIn();
	}

	public void signUpCardHolderUser(String loginPass, String trnPass, String firstSequrityQst,
			String firstSequerAnswer, String secondSequrityQst, String secondSequerAnswer) {
		enterText(chplNewSignUpPassword, loginPass);
		enterText(chpSignUpPasswordConfirm, loginPass);
		enterText(chpSignUpTranPass, trnPass);
		enterText(chpSignUpTranPassConfirm, trnPass);
		selectByText(chpSignUpSeqQuesOne, firstSequrityQst);
		enterText(chpSignUpSeqQueOneInpt, firstSequerAnswer);
		selectByText(chpSignUpSeqQueTwo, secondSequrityQst);
		enterText(chpSignUpSeqQueTwoAnsInpt, secondSequerAnswer);
		confirmSignUpCardHolder();
	}

	public void createTransPassword(String currentPass, String newTrnPass) {
		enterText(currentPassword, currentPass);
		enterText(chpSignUpTranPass, newTrnPass);
		enterText(chpSignUpTranPassConfirm, newTrnPass);
		confirmSignUpCardHolder();
	}

	public void acceptSuccessfullCardholderSignUp() {
		driver().switchTo().alert().accept();
	}

	public void confirmSignUpCardHolder() {
		ClickButton(signUpConfirmBtn);
	}

	public LoginPage enterUserID(String uName) {
		if (!isLoggedIn(getFinder().getWebDriver())) {
			username.sendKeys(uName);
		} else {
			System.out.println("Logout Button not found  we are not setting userID");
		}
		return this;
	}

	public LoginPage enterUserIDCardHolder(String userName) {
		if (!isLoggedIn(getFinder().getWebDriver())) {
			useralias.sendKeys(userName);
		} else {
			log.error("User ID field not found on page");
		}
		return this;
	}

	public LoginPage enterPwd(String pwd) {
		if (!isLoggedIn(getFinder().getWebDriver())) {
			password.sendKeys(pwd);
		} else {
			System.out.println("Logout Button not found  we are not setting userID");
		}
		return this;
	}

	private void clickSignIn() {
		if (!isLoggedIn(getFinder().getWebDriver())) {
			signin.click();
		} else {
			System.out.println("Logout Button not found  we are not loading page and miximizing it");
		}
	}

	public void clickLogout() {
		signOut.click();
		getFinder().getWebDriver().manage().deleteAllCookies();

	}

	public void clickLogoutCardHolder() {
		singOutCardHolder.click();
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
			llogger.info("Logout Button not found  we are not setting userID");
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
			llogger.info("Logout Button not found  we are not loading page and miximizing it");
		}
	}

	private void switchWindow() {
		Set<String> handles = getFinder().getWebDriver().getWindowHandles();
		for (String handle : handles) {
			if (!handle.equals(getFinder().getWebDriver().getWindowHandle()))
				getFinder().getWebDriver().switchTo().window(handle);
		}
	}

	@Override
	protected List<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(userIdInput), WebElementUtils.visibilityOf(passwordInput),
				WebElementUtils.elementToBeClickable(loginButton));
	}

	public void inputUserName(String userName) {
		WebElementUtils.enterText(userIdInput, userName);
	}

	public void inputPassword(String password) {
		WebElementUtils.enterText(passwordInput, password);
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	@Override
	public String getErrorMessage() {
		try {
			WebElement errorMessageLbl = new WebDriverWait(driver(), timeoutInSec)
					.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.feedbackPanelERROR")));
			llogger.info("Error message : {}", errorMessageLbl.getText());
			return errorMessageLbl.toString();
		} catch (TimeoutException e) {
			llogger.info("Operation Status message {}: " + "No Status is updated");
			llogger.debug("Error message {}: ", e);
			return null;
		}
	}

	public String getErrorMessageCollect() {
		try {
			WebElement errorMessageLbl = new WebDriverWait(driver(), timeoutInSec).until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//span[@class='feedbackPanelERROR']/span")));
			llogger.info("Error message : {}", errorMessageLbl.getText());
			return errorMessageLbl.getText();
		} catch (TimeoutException e) {
			llogger.info("Operation Status message {}: " + "No Status is updated");
			llogger.debug("Error message {}: ", e);
			return null;
		}
	}
}
