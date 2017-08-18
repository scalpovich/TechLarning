package com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement;

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
@Navigation(tabTitle = ChannelManagementNav.TAB_CHANNEL_MANAGEMENT, treeMenuItems = { ChannelManagementNav.L1_ADMINISTRATOR,
		ChannelManagementNav.L2_ADMINISTRATOR_USER, ChannelManagementNav.L3_ADMINISTRATOR_USER_CREATE })
public class AdministratorUserCreatePage extends AbstractModelPage {
	private static final Logger logger = LoggerFactory.getLogger(AdministratorUserCreatePage.class);

	@Value("${default.wait.timeout_in_sec}")
	private long timeoutInSec;

	// main screen locators
	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.NAME, valueToFind = "roleID")
	private MCWebElement roleIDDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "userID")
	private MCWebElement userIDTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "userName")
	private MCWebElement userNameTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "address1")
	private MCWebElement address1Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "address2")
	private MCWebElement address2Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "address3")
	private MCWebElement address3Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "address4")
	private MCWebElement address4Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "pinCode")
	private MCWebElement pinCodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "city")
	private MCWebElement cityTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "state")
	private MCWebElement stateTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "country")
	private MCWebElement countryTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "emailId")
	private MCWebElement emailIdTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "preferredLanguage")
	private MCWebElement preferredLanguageDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "isdCode")
	private MCWebElement isdCodeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "resPhNo")
	private MCWebElement resPhNoTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mobileNo")
	private MCWebElement mobileNoTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "faxNo")
	private MCWebElement faxNoTxt;

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(roleIDDDwn),
				WebElementUtils.visibilityOf(userIDTxt), WebElementUtils.visibilityOf(userNameTxt), WebElementUtils.visibilityOf(address1Txt),
				WebElementUtils.visibilityOf(address2Txt), WebElementUtils.visibilityOf(address3Txt), WebElementUtils.visibilityOf(address4Txt),
				WebElementUtils.visibilityOf(pinCodeTxt), WebElementUtils.visibilityOf(cityTxt), WebElementUtils.visibilityOf(stateTxt),
				WebElementUtils.visibilityOf(countryTxt), WebElementUtils.visibilityOf(emailIdTxt), WebElementUtils.visibilityOf(preferredLanguageDDwn),
				WebElementUtils.visibilityOf(isdCodeDDwn), WebElementUtils.visibilityOf(resPhNoTxt), WebElementUtils.visibilityOf(mobileNoTxt),
				WebElementUtils.visibilityOf(faxNoTxt));
	}

	public void verifyUiOperationStatus() {
		logger.info("Portal Admin Information");
		verifyButton("Create");
		verifyButton("Cancel");
	}

	// methods
	public String getMasterDetailContentTitleText() {
		logger.info("Administrator User Create Master Detail Tilte Text: {}");
		return new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(masterDetailContentTitle)).getText();
	}
}
