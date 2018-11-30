package com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = ChannelManagementNav.TAB_CHANNEL_MANAGEMENT, treeMenuItems = { ChannelManagementNav.L1_ADMINISTRATOR,
		ChannelManagementNav.L2_ADMINISTRATOR_USER, ChannelManagementNav.L3_ADMINISTRATOR_USER_CREATE })
public class AdministratorUserCreatePage extends AbstractChannelMamagementPage {
	private static final Logger logger = LoggerFactory.getLogger(AdministratorUserCreatePage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "roleID")
	private MCWebElement roleIDDDwn;

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(roleIDDDwn),
				WebElementUtils.visibilityOf(userIDTxt), WebElementUtils.visibilityOf(userNameTxt), WebElementUtils.visibilityOf(address1Txt),
				WebElementUtils.visibilityOf(address2Txt), WebElementUtils.visibilityOf(address3Txt), WebElementUtils.visibilityOf(address4Txt),
				WebElementUtils.visibilityOf(pinCodeTxt), WebElementUtils.visibilityOf(cityTxt), WebElementUtils.visibilityOf(stateTxt),
				WebElementUtils.visibilityOf(countryTxt), WebElementUtils.visibilityOf(emailIdTxt), WebElementUtils.visibilityOf(preferredLanguageDDwn),
				WebElementUtils.visibilityOf(isdCodeDDwn), WebElementUtils.visibilityOf(resPhNoTxt), WebElementUtils.visibilityOf(mobileNoTxt),
				WebElementUtils.visibilityOf(faxNoTxt));
	}

	@Override
	public void verifyUiOperationStatus() {
		logger.info("Portal Admin Information");
		verifyButton("Create");
		verifyButton("Cancel");
	}
}
