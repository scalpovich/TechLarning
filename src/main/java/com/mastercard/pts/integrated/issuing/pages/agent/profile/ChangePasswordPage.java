package com.mastercard.pts.integrated.issuing.pages.agent.profile;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = ProfileNav.TAB_PROFILE, treeMenuItems = { ProfileNav.L1_CHANGE_PASSWRD })
public class ChangePasswordPage extends AbstractModelPage {
	private static final Logger logger = LoggerFactory.getLogger(ChangePasswordPage.class);

	@Value("${default.wait.timeout_in_sec}")
	private long timeoutInSec;

	// main screen locators
	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.NAME, valueToFind = "oldTxnPassword")
	private MCWebElement oldTxnPasswordTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "newTxnPassword")
	private MCWebElement newTxnPasswordTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "confirmTxnPassword")
	private MCWebElement confirmTxnPasswordTxt;

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(oldTxnPasswordTxt),
				WebElementUtils.visibilityOf(newTxnPasswordTxt), WebElementUtils.visibilityOf(confirmTxnPasswordTxt));
	}
	
	public void verifyUiOperationStatus() {
		logger.info("Change Password");
		verifyButton("Submit");
		verifyButton("Cancel");
	}

	// methods
	public String getMasterDetailContentTitleText() {
		logger.info("Change Password Tilte Text: {}");
		return new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(masterDetailContentTitle)).getText();
	}
}
