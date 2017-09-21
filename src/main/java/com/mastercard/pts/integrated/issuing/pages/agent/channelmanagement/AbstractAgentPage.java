package com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement;

import java.util.Collection;
import java.util.Collections;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

public class AbstractAgentPage extends AbstractBasePage {
	private static final Logger logger = LoggerFactory.getLogger(AbstractAgentPage.class);

	@Value("${default.wait.timeout_in_sec}")
	protected long timeoutInSec;

	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	protected MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.CSS, valueToFind = "select[id='agencyId']")
	protected MCWebElement agencyIdDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "select[id='branchId']")
	protected MCWebElement branchIdDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[id='Id']")
	protected MCWebElement agentIdTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[id='Name']")
	protected MCWebElement agentNameTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[id='address1']")
	protected MCWebElement address1Txt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[id='address2']")
	protected MCWebElement address2Txt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[id='address3']")
	protected MCWebElement address3Txt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[id='address4']")
	protected MCWebElement address4Txt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "select[id='country']")
	protected MCWebElement countryDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "city")
	protected MCWebElement cityTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "state")
	protected MCWebElement stateTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "isdCode")
	protected MCWebElement isdCodeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "resPhNo")
	protected MCWebElement resPhNoTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mobileNo")
	protected MCWebElement mobileNoTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "faxNo")
	protected MCWebElement faxNoTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "offPhNo")
	protected MCWebElement offPhNoTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[id='EmailID']")
	protected MCWebElement emailIdTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[id='PINCode']")
	protected MCWebElement postalCodeTxt;
	
	public String getMasterDetailContentTitleText() {
		logger.info("Master Detail Tilte Text: {}");
		return new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(masterDetailContentTitle)).getText();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Collections.emptyList();
	}
}
