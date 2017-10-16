package com.mastercard.pts.integrated.issuing.pages;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class LoginPage extends AbstractBasePage{
	
	
	// ------------- Processing Center > Setup > Master Parameters > Institution
	
	/*
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='userid'][@name = 'UserID']")
	private MCWebElement username;*/
	
	@PageElement(findBy = FindBy.ID, valueToFind = "userid")
	private MCWebElement username;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='passcode'][@name = 'passwd']")
	private MCWebElement password;
	/*
	@PageElement(findBy = FindBy.ID, valueToFind = "password")
	private MCWebElement password;*/
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@type='submit'][@name = 'SignIn']")
	private MCWebElement signin;
	
	/*@PageElement(findBy = FindBy.NAME, valueToFind = "SignIn")
	private MCWebElement signin;*/
	
	
	public void loadPage(){
		getFinder().getWebDriver().get(env.getProperty("application.url"));

	}

	public void login() {
		//getFinder().getWebDriver().manage().deleteAllCookies();
		loadPage();
		enterUserID(env.getProperty("app.user.name")).enterPwd(env.getProperty("app.user.name")).clickSignIn();

	}
	
	public void login(String uName, String pwd) {
		loadPage();
		enterUserID(uName).enterPwd(pwd).clickSignIn();
	}
	
	public LoginPage enterUserID(String uName) {
		if (!isLoggedIn(getFinder().getWebDriver())) {
			username.sendKeys(uName);
		} else {
			System.out.println("Logout Button not found  we are not setting userID");
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

	
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
	
		return null;
	}

}
