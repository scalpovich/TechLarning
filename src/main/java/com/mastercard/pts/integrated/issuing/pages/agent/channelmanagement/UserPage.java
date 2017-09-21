package com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

public class UserPage extends AbstractBasePage {

	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	protected MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.NAME, valueToFind = "parentID")
	protected MCWebElement parentIdDwn;

	@PageElement(findBy = FindBy.ID, valueToFind = "roleID")
	protected MCWebElement roleIdDwn;
	
	@PageElement(findBy = FindBy.ID, valueToFind = "userID")
	protected MCWebElement userIdTxt;

	@PageElement(findBy = FindBy.ID, valueToFind = "preferredLanguage")
	protected MCWebElement preferredLanguageDwn;

	@PageElement(findBy = FindBy.ID, valueToFind = "country")
	protected MCWebElement countryDwn;

	@PageElement(findBy = FindBy.ID, valueToFind = "isdCode")
	protected MCWebElement isdCodeDwn;

	@PageElement(findBy = FindBy.ID, valueToFind = "userName")
	protected MCWebElement userNameTxt;

	@PageElement(findBy = FindBy.ID, valueToFind = "address1")
	protected MCWebElement address1Txt;

	@PageElement(findBy = FindBy.ID, valueToFind = "address2")
	protected MCWebElement address2Txt;

	@PageElement(findBy = FindBy.ID, valueToFind = "emailId")
	protected MCWebElement emailIdTxt;

	@PageElement(findBy = FindBy.ID, valueToFind = "mobileNo")
	protected MCWebElement mobileNoTxt;

	@PageElement(findBy = FindBy.ID, valueToFind = "PINCode")
	protected MCWebElement postalCodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "address3")
	protected MCWebElement address3Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "address4")
	protected MCWebElement address4Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "city")
	protected MCWebElement cityTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "state")
	protected MCWebElement stateTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "resPhNo")
	protected MCWebElement resPhNoTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "faxNo")
	protected MCWebElement faxNoTxt;

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle));
	}
}
