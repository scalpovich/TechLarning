package com.mastercard.pts.integrated.issuing.pages.agent;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class AgentHomePage extends AbstractModelPage {
	
	public static final String TITLE = "Integrated Issuing prepaid :: Agent Portal";
	
	@PageElement(findBy = FindBy.ID, valueToFind = "Home")
	private MCWebElement homeTab;
	
	@PageElement(findBy = FindBy.ID, valueToFind = "Profiles")
	private MCWebElement profileTab;
	
	@PageElement(findBy = FindBy.ID, valueToFind = "Admin")
	private MCWebElement channelManagementTab;
	
	@PageElement(findBy = FindBy.ID, valueToFind = "Settlement")
	private MCWebElement settlementTab;
	
	public AgentHomePage switchToWindow() {
		WebElementUtils.switchToChildWindowByTitleAndCloseParent(
				getFinder().getWebDriver(), TITLE);
		return this;
	}
	
	public void onAgentPortal() {
		verifyOnAgentPortal();
	}

	@Override
	protected List<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.visibilityOf(homeTab),
				WebElementUtils.visibilityOf(profileTab),
				WebElementUtils.visibilityOf(channelManagementTab));
	}

}
