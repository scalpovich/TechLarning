package com.mastercard.pts.integrated.issuing.pages.agent.profile;

import java.util.Collection;
import java.util.Collections;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.beans.factory.annotation.Value;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

public class ServicesAbstractPage extends AbstractBasePage {

	@Value("${default.wait.timeout_in_sec}")
	protected long timeoutInSec;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "address1")
	protected MCWebElement address1Txt;
 
	@PageElement(findBy = FindBy.NAME, valueToFind = "address2")
	protected MCWebElement address2Txt;
 
	@PageElement(findBy = FindBy.NAME, valueToFind = "address3")
	protected MCWebElement address3Txt;
 
	@PageElement(findBy = FindBy.NAME, valueToFind = "address4")
	protected MCWebElement address4Txt;
 
	@PageElement(findBy = FindBy.NAME, valueToFind = "pinCode")
	protected MCWebElement pinCodeTxt;
 
	@PageElement(findBy = FindBy.NAME, valueToFind = "cityName")
	protected MCWebElement cityNameTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "emailId")
	protected MCWebElement emailIdTxt;
 
	@PageElement(findBy = FindBy.NAME, valueToFind = "resPhNo")
	protected MCWebElement resPhNoTxt;
 
	@PageElement(findBy = FindBy.NAME, valueToFind = "isdCode")
	protected MCWebElement isdCodeTxt;
 
	@PageElement(findBy = FindBy.NAME, valueToFind = "mobileNo")
	protected MCWebElement mobileNoTxt;
 
	@PageElement(findBy = FindBy.NAME, valueToFind = "faxNo")
	protected MCWebElement faxNoTxt;

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Collections.emptyList();
	}

}
