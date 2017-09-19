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

import com.mastercard.pts.integrated.issuing.domain.agent.channelmanagement.AgencyUser;
import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.utils.SimulatorUtilities;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

public class AbstractChannelMamagementPage  extends AbstractModelPage {
	private static final Logger logger = LoggerFactory.getLogger(AbstractChannelMamagementPage.class);
	
	@Value("${default.wait.timeout_in_sec}")
	protected long timeoutInSec;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "parentID")
	protected MCWebElement parentIdDDwn;

	@PageElement(findBy = FindBy.ID, valueToFind = "roleID")
	protected MCWebElement roleIdDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	protected MCWebElement masterDetailContentTitle;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "userID")
	protected MCWebElement userIDTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "userName")
	protected MCWebElement userNameTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "address1")
	protected MCWebElement address1Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "address2")
	protected MCWebElement address2Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "address3")
	protected MCWebElement address3Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "address4")
	protected MCWebElement address4Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "pinCode")
	protected MCWebElement postalCodeTxt;
	
	@PageElement(findBy = FindBy.ID, valueToFind = "PINCode")
	protected MCWebElement pinCodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "city")
	protected MCWebElement cityTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "state")
	protected MCWebElement stateTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "country")
	protected MCWebElement countryTxt;
	
	@PageElement(findBy = FindBy.ID, valueToFind = "country")
	protected MCWebElement countryDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "emailId")
	protected MCWebElement emailIdTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "preferredLanguage")
	protected MCWebElement preferredLanguageDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "isdCode")
	protected MCWebElement isdCodeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "resPhNo")
	protected MCWebElement resPhNoTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mobileNo")
	protected MCWebElement mobileNoTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "faxNo")
	protected MCWebElement faxNoTxt;

	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle));
	}
	
	public void verifyUiOperationStatus() {
		logger.info("User Information");
		verifyButton("Search");
	}

	public String getMasterDetailContentTitleText() {
		logger.info("User Create Master Detail Tilte Text: {}");
		return new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(masterDetailContentTitle)).getText();
	}
	
	public void create(AgencyUser au) {
		WebElementUtils.selectDropDownByVisibleText(parentIdDDwn, au.getParentId());
		WebElementUtils.selectDropDownByVisibleText(roleIdDDwn, au.getRoleId());
		WebElementUtils.enterText(userIDTxt, au.getUserId());
		WebElementUtils.enterText(userNameTxt, au.getUserName());
		WebElementUtils.selectDropDownByValue(preferredLanguageDDwn, au.getPreferenceLanguage());
		WebElementUtils.enterText(address1Txt, au.getAddress1());
		WebElementUtils.selectDropDownByVisibleText(countryDwn, au.getCountry());
		postalCodeTxt.click();
		SimulatorUtilities.wait(2000);
		WebElementUtils.enterText(postalCodeTxt, au.getPostalCode() + Keys.TAB);
		WebElementUtils.enterText(address2Txt, au.getAddress1());
		WebElementUtils.enterText(emailIdTxt, au.getEmail());
		WebElementUtils.selectDropDownByVisibleText(isdCodeDDwn, au.getIsdCode());
		WebElementUtils.enterText(mobileNoTxt, au.getPhone());

		clickCreateButton();
		clickOkButton();
	}
	
}