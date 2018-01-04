package com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.agent.channelmanagement.Agent;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;

@Component
@Navigation(tabTitle = ChannelManagementNav.TAB_CHANNEL_MANAGEMENT, treeMenuItems = { ChannelManagementNav.L1_AGENT, ChannelManagementNav.L2_AGENT_ENTITY,
		ChannelManagementNav.L3_AGENT_ENTITY_CREATE })
public class AgentEntityCreatePage extends AbstractAgentPage {
	private static final Logger logger = LoggerFactory.getLogger(AgentEntityCreatePage.class);

	public void verifyUiOperationStatus() {
		logger.info("Agent Information");
		verifyButton("Save");
		verifyButton("Cancel");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(agencyIdDwn),
				WebElementUtils.visibilityOf(branchIdDwn), WebElementUtils.visibilityOf(agentIdTxt), WebElementUtils.visibilityOf(agentNameTxt),
				WebElementUtils.visibilityOf(address1Txt), WebElementUtils.visibilityOf(address2Txt), WebElementUtils.visibilityOf(address3Txt),
				WebElementUtils.visibilityOf(address4Txt), WebElementUtils.visibilityOf(countryDwn), WebElementUtils.visibilityOf(cityTxt),
				WebElementUtils.visibilityOf(stateTxt), WebElementUtils.visibilityOf(isdCodeDDwn), WebElementUtils.visibilityOf(resPhNoTxt),
				WebElementUtils.visibilityOf(mobileNoTxt), WebElementUtils.visibilityOf(faxNoTxt), WebElementUtils.visibilityOf(offPhNoTxt),
				WebElementUtils.visibilityOf(emailIdTxt), WebElementUtils.visibilityOf(postalCodeTxt));
	}
	
	public void createAgent(Agent agnt){
			WebElementUtils.selectDropDownByVisibleText(agencyIdDwn, agnt.getAgencyId());
			WebElementUtils.selectDropDownByVisibleText(branchIdDwn, agnt.getBranchId());
			WebElementUtils.enterText(agentIdTxt,agnt.getAgentId() );
			WebElementUtils.enterText(agentNameTxt, agnt.getAgentName());
			WebElementUtils.enterText(emailIdTxt, agnt.getEmail());
			WebElementUtils.enterText(address1Txt, agnt.getAddress1());
			WebElementUtils.selectDropDownByVisibleText(countryDwn, agnt.getCountry());
			postalCodeTxt.click();
			SimulatorUtilities.wait(2000);
			WebElementUtils.enterText(postalCodeTxt, agnt.getPostalCode()+Keys.TAB);
			clickSaveButton();
			clickOkButton();
	}

}
