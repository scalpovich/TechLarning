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
@Navigation(tabTitle = ProfileNav.TAB_PROFILE, treeMenuItems = { ProfileNav.L1_ENTITY_DETAILS })
public class EntityDetailsPage extends AbstractModelPage {
	private static final Logger logger = LoggerFactory.getLogger(EntityDetailsPage.class);

	@Value("${default.wait.timeout_in_sec}")
	private long timeoutInSec;

	// main screen locators
	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.NAME, valueToFind = "id")
	private MCWebElement idTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "name")
	private MCWebElement nameTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "branchId")
	private MCWebElement branchIdTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "agencyId")
	private MCWebElement agencyIdTxt;

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

	@PageElement(findBy = FindBy.NAME, valueToFind = "cityName")
	private MCWebElement cityNameTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "stateName")
	private MCWebElement stateNameTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "countryName")
	private MCWebElement countryNameTxt;

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

	@PageElement(findBy = FindBy.NAME, valueToFind = "offPhNo")
	private MCWebElement offPhNoTxt;

	public void verifyUiOperationStatus() {
		logger.info("Agent Profile Information");
		verifyContactInformation();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(nameTxt),
				WebElementUtils.visibilityOf(idTxt), WebElementUtils.visibilityOf(address1Txt), WebElementUtils.visibilityOf(address2Txt),
				WebElementUtils.visibilityOf(address3Txt), WebElementUtils.visibilityOf(address4Txt), WebElementUtils.visibilityOf(pinCodeTxt),
				WebElementUtils.visibilityOf(cityNameTxt), WebElementUtils.visibilityOf(stateNameTxt), WebElementUtils.visibilityOf(countryNameTxt),
				WebElementUtils.visibilityOf(emailIdTxt), WebElementUtils.visibilityOf(resPhNoTxt), WebElementUtils.visibilityOf(isdCodeTxt),
				WebElementUtils.visibilityOf(mobileNoTxt), WebElementUtils.visibilityOf(faxNoTxt), WebElementUtils.visibilityOf(offPhNoTxt));
	}

	// methods
	public String getMasterDetailContentTitleText() {
		logger.info("Verify Profile Information Tilte Text: {}");
		return new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(masterDetailContentTitle)).getText();
	}
}
