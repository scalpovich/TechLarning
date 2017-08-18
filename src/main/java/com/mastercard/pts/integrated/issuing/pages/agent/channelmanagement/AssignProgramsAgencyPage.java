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

import com.mastercard.pts.integrated.issuing.domain.agent.channelmanagement.AssignPrograms;
import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = ChannelManagementNav.TAB_CHANNEL_MANAGEMENT, treeMenuItems = { ChannelManagementNav.L1_AGENCY, ChannelManagementNav.L2_AGENCY_ENTITY,
		ChannelManagementNav.L3_AGENCY_ASSIGN_PROGRAMS })
public class AssignProgramsAgencyPage extends AbstractModelPage {
	private static final Logger logger = LoggerFactory.getLogger(AssignProgramsAgencyPage.class);

	@Value("${default.wait.timeout_in_sec}")
	private long timeoutInSec;

	// main screen locators
	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Add']")
	private MCWebElement addBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = ".SuccessMessageTxt")
	private MCWebElement programAssignedMessage;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#id")
	private MCWebElement agencyIdDdwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#programCode")
	private MCWebElement programCodeDdwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#deviceType")
	private MCWebElement deviceTypeDdwn;

	public void verifyUiOperationStatus() {
		logger.info("Agency Information");
		verifyButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(agencyIdDdwn));
	}

	// methods
	public String getMasterDetailContentTitleText() {
		logger.info("Corporate User View Edit Master Detail Tilte Text: {}");
		return new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(masterDetailContentTitle)).getText();
	}

	public void selectAgency(String agency) {
		WebElementUtils.selectDropDownByVisibleText(agencyIdDdwn, agency);
	}

	public void selectProgramCode(String programCode) {
		WebElementUtils.selectDropDownByVisibleText(programCodeDdwn, programCode);
	}

	public void selectDeviceType(String deviceType) {
		WebElementUtils.selectDropDownByVisibleText(deviceTypeDdwn, deviceType);
	}

	public void clickAddButton() {
		new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.elementToBeClickable(addBtn)).click();
	}

	public String getAgencyProgramAssignedMessage() {
		return new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(programAssignedMessage)).getText();
	}

	public void assignProgramAgency(AssignPrograms details) {
		logger.info("Assign Program: {}", details.getProgramCode());

		selectAgency(details.getAgency());
		clickSearchButton();
		selectProgramCode(details.getProgramCode());
		selectDeviceType(details.getDeviceType());
		clickAddButton();
		driver().switchTo().alert().accept();
	}
}
