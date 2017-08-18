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

import com.mastercard.pts.integrated.issuing.domain.agent.channelmanagement.Agency;
import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.SimulatorUtilities;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = ChannelManagementNav.TAB_CHANNEL_MANAGEMENT, treeMenuItems = { ChannelManagementNav.L1_AGENCY, ChannelManagementNav.L2_AGENCY_ENTITY,
		ChannelManagementNav.L3_AGENCY_ENTITY_CREATE })
public class AgencyEntityCreatePage extends AbstractModelPage {
	private static final Logger logger = LoggerFactory.getLogger(AgencyEntityCreatePage.class);

	@Value("${default.wait.timeout_in_sec}")
	private long timeoutInSec;

	// main screen locators
	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[id='AgencyID']")
	private MCWebElement agencyIdTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[id='AgencyName']")
	private MCWebElement agencyNameTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "select[id='agentType']")
	private MCWebElement agentTypeDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "select[id='agencyClassific']")
	private MCWebElement agencyClassificDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "kycAllowed")
	private MCWebElement kycAllowedChkBox;

	@PageElement(findBy = FindBy.NAME, valueToFind = "deDupeAppAllowed")
	private MCWebElement deDupeAppAllowedChkBox;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[id='address1']")
	private MCWebElement address1Txt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[id='address2']")
	private MCWebElement address2Txt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[id='address3']")
	private MCWebElement address3Txt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[id='address4']")
	private MCWebElement address4Txt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "select[id='country']")
	private MCWebElement countryDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "city")
	private MCWebElement cityTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "state")
	private MCWebElement stateTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "isdCode")
	private MCWebElement isdCodeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "resPhNo")
	private MCWebElement resPhNoTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mobileNo")
	private MCWebElement mobileNoTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "faxNo")
	private MCWebElement faxNoTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "offPhNo")
	private MCWebElement offPhNoTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[id='EmailID']")
	private MCWebElement emailIdTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[id='PINCode']")
	private MCWebElement postalCodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mailCC")
	private MCWebElement mailCCTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mailBCC")
	private MCWebElement mailBCCTxt;

	public void verifyUiOperationStatus() {
		logger.info("Agency Information");
		verifyButton("Save");
		verifyButton("Cancel");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(agencyIdTxt), WebElementUtils.visibilityOf(agencyNameTxt),
				WebElementUtils.visibilityOf(agentTypeDwn), WebElementUtils.visibilityOf(agencyClassificDwn), WebElementUtils.visibilityOf(kycAllowedChkBox),
				WebElementUtils.visibilityOf(deDupeAppAllowedChkBox), WebElementUtils.visibilityOf(address1Txt), WebElementUtils.visibilityOf(address2Txt),
				WebElementUtils.visibilityOf(address3Txt), WebElementUtils.visibilityOf(address4Txt), WebElementUtils.visibilityOf(countryDwn),
				WebElementUtils.visibilityOf(cityTxt), WebElementUtils.visibilityOf(stateTxt), WebElementUtils.visibilityOf(isdCodeDDwn),
				WebElementUtils.visibilityOf(resPhNoTxt), WebElementUtils.visibilityOf(mobileNoTxt), WebElementUtils.visibilityOf(faxNoTxt),
				WebElementUtils.visibilityOf(offPhNoTxt), WebElementUtils.visibilityOf(emailIdTxt), WebElementUtils.visibilityOf(postalCodeTxt),
				WebElementUtils.visibilityOf(mailCCTxt), WebElementUtils.visibilityOf(mailBCCTxt));
	}

	public void createAgency(Agency ac) {
		WebElementUtils.enterText(agencyIdTxt, ac.getAgencyId());
		WebElementUtils.enterText(agencyNameTxt, ac.getAgencyName());
		WebElementUtils.enterText(emailIdTxt, ac.getEmail());
		WebElementUtils.enterText(address1Txt, ac.getAddress1());
		WebElementUtils.selectDropDownByVisibleText(agentTypeDwn, ac.getAgentType());
		WebElementUtils.selectDropDownByVisibleText(agencyClassificDwn, ac.getAgentClassification());
		WebElementUtils.selectDropDownByVisibleText(countryDwn, ac.getCountry());
		postalCodeTxt.click();
		SimulatorUtilities.wait(2000);
		WebElementUtils.enterText(postalCodeTxt, ac.getPostalCode() + Keys.TAB);
		clickSaveButton();
		clickOkButton();
	}

	// methods
	public String getMasterDetailContentTitleText() {
		logger.info("Agency Entity Create Master Detail Tilte Text: {}");
		return new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(masterDetailContentTitle)).getText();
	}
}
