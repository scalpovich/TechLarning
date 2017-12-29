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
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.SimulatorUtilities;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = ChannelManagementNav.TAB_CHANNEL_MANAGEMENT, treeMenuItems = { ChannelManagementNav.L1_AGENT, ChannelManagementNav.L2_AGENT_ENTITY,
		ChannelManagementNav.L3_AGENT_ASSIGN_PROGRAMS })
public class AssignProgramsAgentPage extends AbstractBasePage {
	private static final Logger logger = LoggerFactory.getLogger(AssignProgramsAgentPage.class);

	@Value("${default.wait.timeout_in_sec}")
	private long timeoutInSec;

	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#agencyId")
	private MCWebElement agencyIdDdwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#programCode")
	private MCWebElement programCodeDdwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#branchId")
	private MCWebElement branchIdDdwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#agentId")
	private MCWebElement agentIdDdwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = ".SuccessMessageTxt")
	private MCWebElement programAssignedMessage;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#deviceType")
	private MCWebElement deviceTypeDdwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Add']")
	private MCWebElement addBtn;
	
	public void verifyUiOperationStatus() {
		logger.info("Agent Information");
		verifyButton("Search");
	}

	public String getMasterDetailContentTitleText() {
		logger.info("Corporate User View Edit Master Detail Tilte Text: {}");
		return new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(masterDetailContentTitle)).getText();
	}

	public void selectAgency(String agency) {
		WebElementUtils.selectDropDownByVisibleText(agencyIdDdwn, agency);
	}

	public void selectBranchId(String branchId) {
		WebElementUtils.selectDropDownByVisibleText(branchIdDdwn, branchId);
	}

	public void selectAgentId(String agentId) {
		WebElementUtils.selectDropDownByVisibleText(agentIdDdwn, agentId);
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

	public String getAgentProgramAssignedMessage() {
		return new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(programAssignedMessage)).getText();
	}

	public void assignProgramAgent(AssignPrograms details) {
		logger.info("Assign Program: {}", details.getProgramCode());

		selectAgency(details.getAgency());
		selectBranchId(details.getBranchId());
		selectAgentId(details.getAgentId());
		clickSearchButton();
		SimulatorUtilities.wait(5000);//this to wait for dropDown to load values
		//work around for the defect assigning program - repeating as AgentId dropDown value is not retained after search
		selectAgentId(details.getAgentId());
		clickSearchButton();
		SimulatorUtilities.wait(30000);//this to wait till the table gets loaded
		WebElementUtils.scrollDown(driver(), 0, 999);
		selectProgramCode(details.getProgramCode());
		selectDeviceType(details.getDeviceType());
		clickAddButton();
		driver().switchTo().alert().accept();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(branchIdDdwn), WebElementUtils.visibilityOf(agentIdDdwn), WebElementUtils.visibilityOf(agencyIdDdwn));
	}
}
