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

import com.mastercard.pts.integrated.issuing.domain.agent.channelmanagement.AgencyUser;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.SimulatorUtilities;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;

@Component
@Navigation(tabTitle = ChannelManagementNav.TAB_CHANNEL_MANAGEMENT, treeMenuItems = { ChannelManagementNav.L1_AGENCY, ChannelManagementNav.L2_AGENCY_USER,
		ChannelManagementNav.L3_AGENCY_USER_CREATE })
public class AgencyUserCreatePage extends UserPage {
	private static final Logger logger = LoggerFactory.getLogger(AgencyUserCreatePage.class);

	@Value("${default.wait.timeout_in_sec}")
	private long timeoutInSec;



	public void verifyUiOperationStatus() {
		logger.info("Agency Information");
		verifyButton("Create");
		verifyButton("Cancel");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(parentIdDwn),
				WebElementUtils.visibilityOf(roleIdDwn), WebElementUtils.visibilityOf(userIdTxt), WebElementUtils.visibilityOf(userNameTxt),
				WebElementUtils.visibilityOf(address1Txt), WebElementUtils.visibilityOf(address2Txt), WebElementUtils.visibilityOf(address3Txt),
				WebElementUtils.visibilityOf(address4Txt), WebElementUtils.visibilityOf(postalCodeTxt), WebElementUtils.visibilityOf(cityTxt),
				WebElementUtils.visibilityOf(stateTxt), WebElementUtils.visibilityOf(countryDwn), WebElementUtils.visibilityOf(emailIdTxt),
				WebElementUtils.visibilityOf(preferredLanguageDwn), WebElementUtils.visibilityOf(isdCodeDwn), WebElementUtils.visibilityOf(resPhNoTxt),
				WebElementUtils.visibilityOf(mobileNoTxt), WebElementUtils.visibilityOf(faxNoTxt));
	}

	public void createAgencyUser(AgencyUser au) {
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
		logger.info("Agency User Create Master Detail Tilte Text: {}");
		return new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(masterDetailContentTitle)).getText();
	}
}
