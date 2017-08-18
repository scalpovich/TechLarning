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
@Navigation(tabTitle = ProfileNav.TAB_PROFILE, treeMenuItems = { ProfileNav.L1_VIEW_PROFILE })
public class ViewProfilePage extends AbstractModelPage {
	private static final Logger logger = LoggerFactory.getLogger(ViewProfilePage.class);

	@Value("${default.wait.timeout_in_sec}")
	private long timeoutInSec;

	// main screen locators
	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.NAME, valueToFind = "parentID")
	private MCWebElement parentIDTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "roleID")
	private MCWebElement roleIDTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "userID")
	private MCWebElement userIDTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "userName")
	private MCWebElement userNameTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "statusDesc")
	private MCWebElement statusDescTxt;

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

	@PageElement(findBy = FindBy.NAME, valueToFind = "cityDesc")
	private MCWebElement cityDescTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "state")
	private MCWebElement stateTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "country")
	private MCWebElement countryTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "emailId")
	private MCWebElement emailIdTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "resPhNo")
	private MCWebElement resPhNoTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "isdCode")
	private MCWebElement isdCodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mobileNo")
	private MCWebElement mobileNoTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "faxNo")
	private MCWebElement faxNoTxt;

	public void verifyUiOperationStatus() {
		logger.info("Agent Profile Information");
		verifyContactInformation();
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(parentIDTxt),
				WebElementUtils.visibilityOf(roleIDTxt), WebElementUtils.visibilityOf(userIDTxt), WebElementUtils.visibilityOf(userNameTxt),
				WebElementUtils.visibilityOf(statusDescTxt), WebElementUtils.visibilityOf(address1Txt), WebElementUtils.visibilityOf(address2Txt),
				WebElementUtils.visibilityOf(address3Txt), WebElementUtils.visibilityOf(address4Txt), WebElementUtils.visibilityOf(pinCodeTxt),
				WebElementUtils.visibilityOf(cityDescTxt), WebElementUtils.visibilityOf(stateTxt), WebElementUtils.visibilityOf(countryTxt),
				WebElementUtils.visibilityOf(emailIdTxt), WebElementUtils.visibilityOf(resPhNoTxt), WebElementUtils.visibilityOf(isdCodeTxt),
				WebElementUtils.visibilityOf(mobileNoTxt), WebElementUtils.visibilityOf(faxNoTxt));
	}

	// methods
	public String getMasterDetailContentTitleText() {
		logger.info("Verify Profile Information Tilte Text: {}");
		return new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(masterDetailContentTitle)).getText();
	}
}
