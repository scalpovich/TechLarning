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

import com.mastercard.pts.integrated.issuing.domain.agent.channelmanagement.Branch;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.SimulatorUtilities;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = ChannelManagementNav.TAB_CHANNEL_MANAGEMENT, treeMenuItems = { ChannelManagementNav.L1_BRANCH, ChannelManagementNav.L2_BRANCH_ENTITY,
		ChannelManagementNav.L3_BRANCH_ENTITY_CREATE })
public class BranchEntityCreatePage extends AbstractBasePage {
	private static final Logger logger = LoggerFactory.getLogger(BranchEntityCreatePage.class);

	@Value("${default.wait.timeout_in_sec}")
	private long timeoutInSec;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[id='BranchID']")
	private MCWebElement branchIdTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[id='BranchName']")
	private MCWebElement branchNameTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "select[id='agencyId']")
	private MCWebElement agencyIdDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[id='address1']")
	private MCWebElement address1Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "address2")
	private MCWebElement address2Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "address3")
	private MCWebElement address3Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "address4")
	private MCWebElement address4Txt;

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

	@PageElement(findBy = FindBy.CSS, valueToFind = "select[id='country']")
	private MCWebElement countryDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[id='EmailID']")
	private MCWebElement emailIdTxt;

	// main screen locators
	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[id='PINCode']")
	private MCWebElement postalCodeTxt;

	public void verifyUiOperationStatus() {
		logger.info("Branch Information");
		verifyButton("Save");
		verifyButton("Cancel");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(branchIdTxt),
				WebElementUtils.visibilityOf(branchNameTxt), WebElementUtils.visibilityOf(agencyIdDwn), WebElementUtils.visibilityOf(address1Txt),
				WebElementUtils.visibilityOf(address2Txt), WebElementUtils.visibilityOf(address3Txt), WebElementUtils.visibilityOf(address4Txt),
				WebElementUtils.visibilityOf(postalCodeTxt), WebElementUtils.visibilityOf(cityTxt), WebElementUtils.visibilityOf(stateTxt),
				WebElementUtils.visibilityOf(countryDwn), WebElementUtils.visibilityOf(emailIdTxt), WebElementUtils.visibilityOf(isdCodeDDwn),
				WebElementUtils.visibilityOf(resPhNoTxt), WebElementUtils.visibilityOf(mobileNoTxt), WebElementUtils.visibilityOf(faxNoTxt));
	}

	public void createBranch(Branch bch) {
		WebElementUtils.selectDropDownByVisibleText(agencyIdDwn, bch.getAgencyId());
		WebElementUtils.enterText(branchIdTxt, bch.getBranchId());
		WebElementUtils.enterText(branchNameTxt, bch.getBranchName());
		WebElementUtils.enterText(emailIdTxt, bch.getEmail());
		WebElementUtils.enterText(address1Txt, bch.getAddress1());
		WebElementUtils.selectDropDownByVisibleText(countryDwn, bch.getCountry());
		postalCodeTxt.click();
		SimulatorUtilities.wait(2000);
		WebElementUtils.enterText(postalCodeTxt, bch.getPostalCode()+Keys.TAB);
		
		clickSaveButton();
		clickOkButton();
	}

	// methods
	public String getMasterDetailContentTitleText() {
		logger.info("Branch Entity Create Master Detail Tilte Text: {}");
		return new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(masterDetailContentTitle)).getText();
	}
}
