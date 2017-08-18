package com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement;

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
@Navigation(tabTitle = ChannelManagementNav.TAB_CHANNEL_MANAGEMENT, treeMenuItems = { ChannelManagementNav.L1_ROLES_AND_PRIVILEGES,
		ChannelManagementNav.L2_ROLES_AND_PRIVILEGES_ASSIGN_PRIVILEGES })
public class AssignPrivilegesPage extends AbstractModelPage {
	private static final Logger logger = LoggerFactory.getLogger(AssignPrivilegesPage.class);

	@Value("${default.wait.timeout_in_sec}")
	private long timeoutInSec;

	// main screen locators
	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.NAME, valueToFind = "roleId")
	private MCWebElement roleIdTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "usrType")
	private MCWebElement usrTypeDDwn;

	public void verifyUiOperationStatus() {
		logger.info("Role Information");
		verifyButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(roleIdTxt),
				WebElementUtils.visibilityOf(usrTypeDDwn));
	}

	// methods
	public String getMasterDetailContentTitleText() {
		logger.info("Role Information Tilte Text: {}");
		return new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(masterDetailContentTitle)).getText();
	}
}
