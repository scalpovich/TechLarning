package com.mastercard.pts.integrated.issuing.pages;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.AbstractPage;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class LoginPage extends AbstractPage implements Validatable {
	
	public static final String AUTHENTIFICATION_FAILED = "Authentication failed. "
			+ "You have used an invalid user name, password or client certificate."; 
	
	public static final String AUTHENTIFICATION_FAILED_AGENT = "Authentication failed. "
			+ "Please enter valid User ID or Password";
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[type='text']")
	private MCWebElement userIdInput;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[type='password']")
	private MCWebElement passwordInput;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[type='submit']")
	private MCWebElement loginButton;
	
	private By messageBoxLocator = By.cssSelector(".feedbackPanelERROR");

	@Override
	protected List<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.visibilityOf(userIdInput),
				WebElementUtils.visibilityOf(passwordInput),
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
	public Optional<String> getErrorMessage() {
		return getFinder().getWebDriver().findElements(messageBoxLocator).stream()
				.map(WebElement::getText)
				.findFirst();
	}
}
