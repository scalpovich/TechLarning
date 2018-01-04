package com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.agent.channelmanagement.BranchUser;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;

@Component
@Navigation(tabTitle = ChannelManagementNav.TAB_CHANNEL_MANAGEMENT, treeMenuItems = { ChannelManagementNav.L1_BRANCH, ChannelManagementNav.L2_BRANCH_USER,
		ChannelManagementNav.L3_BRANCH_USER_CREATE })
public class BranchUserCreatePage extends AbstractChannelMamagementPage {
	private static final Logger logger = LoggerFactory.getLogger(BranchUserCreatePage.class);

	@Override
	public void verifyUiOperationStatus() {
		logger.info("Branch Information");
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

	public void createBranchUser(BranchUser au) {
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