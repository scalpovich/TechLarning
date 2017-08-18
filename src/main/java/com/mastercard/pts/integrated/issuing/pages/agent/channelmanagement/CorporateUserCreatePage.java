package com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.agent.channelmanagement.CorporateUser;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.SimulatorUtilities;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = ChannelManagementNav.TAB_CHANNEL_MANAGEMENT, treeMenuItems = { ChannelManagementNav.L1_CORPORATE,
		ChannelManagementNav.L2_CORPORATE_USER, ChannelManagementNav.L3_CORPORATE_USER_CREATE })
public class CorporateUserCreatePage extends UserPage {
	private static final Logger logger = LoggerFactory.getLogger(CorporateUserCreatePage.class);

	@Value("${default.wait.timeout_in_sec}")
	private long timeoutInSec;

	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.NAME, valueToFind = "parentID")
	private MCWebElement parentIdDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "roleID")
	private MCWebElement roleIdDDwn;

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

	public void verifyUiOperationStatus() {
		logger.info("Corporate User Information");
		verifyButton("Create");
		verifyButton("Cancel");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(parentIdDDwn),
				WebElementUtils.visibilityOf(roleIdDDwn), WebElementUtils.visibilityOf(userIDTxt), WebElementUtils.visibilityOf(userNameTxt),
				WebElementUtils.visibilityOf(address1Txt), WebElementUtils.visibilityOf(address2Txt), WebElementUtils.visibilityOf(address3Txt),
				WebElementUtils.visibilityOf(address4Txt), WebElementUtils.visibilityOf(pinCodeTxt), WebElementUtils.visibilityOf(cityTxt),
				WebElementUtils.visibilityOf(stateTxt), WebElementUtils.visibilityOf(countryTxt), WebElementUtils.visibilityOf(emailIdTxt),
				WebElementUtils.visibilityOf(preferredLanguageDDwn), WebElementUtils.visibilityOf(isdCodeDDwn), WebElementUtils.visibilityOf(resPhNoTxt),
				WebElementUtils.visibilityOf(mobileNoTxt), WebElementUtils.visibilityOf(faxNoTxt));
	}

	public void createCorporateUser(CorporateUser au) {
		WebElementUtils.selectDropDownByVisibleText(parentIdDwn, au.getParentId());
		WebElementUtils.selectDropDownByVisibleText(roleIdDwn, au.getRoleId());
		WebElementUtils.enterText(userIdTxt, au.getUserId());
		WebElementUtils.enterText(userNameTxt, au.getUserName());
		WebElementUtils.selectDropDownByValue(preferredLanguageDwn, au.getPreferenceLanguage());
		WebElementUtils.enterText(address1Txt, au.getAddress1());
		WebElementUtils.selectDropDownByVisibleText(countryDwn, au.getCountry());
		postalCodeTxt.click();
		SimulatorUtilities.wait(2000);
		WebElementUtils.enterText(postalCodeTxt, au.getPostalCode() + Keys.TAB);
		WebElementUtils.enterText(address2Txt, au.getAddress1());
		WebElementUtils.enterText(emailIdTxt, au.getEmail());
		WebElementUtils.selectDropDownByVisibleText(isdCodeDwn, au.getIsdCode());
		WebElementUtils.enterText(mobileNoTxt, au.getPhone());

		clickCreateButton();
		clickOkButton();
	}

	// methods
	public String getMasterDetailContentTitleText() {
		logger.info("Corporate User Create Master Detail Tilte Text: {}");
		return new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(masterDetailContentTitle)).getText();
	}
}
