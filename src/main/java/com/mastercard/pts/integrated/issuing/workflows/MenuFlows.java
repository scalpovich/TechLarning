package com.mastercard.pts.integrated.issuing.workflows;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.pages.MenuSubMenuPage;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;

public class MenuFlows extends AbstractBaseFlows {

	@Autowired
	public MenuSubMenuPage menusubmenuPage;

	public void clickMenuSubOption(MCWebElement option, MCWebElement suboption) {
		CustomUtils.ThreadDotSleep(2000);
		waitForElementVisible(menusubmenuPage.getCardManagement());
		CustomUtils.ThreadDotSleep(2000);
		menusubmenuPage.getCardManagement().click();
		waitForElementVisible(menusubmenuPage.getCardManagement());
		option.click();
		waitForElementVisible(menusubmenuPage.getCardManagement());
		CustomUtils.ThreadDotSleep(2000);
		suboption.click();
		CustomUtils.ThreadDotSleep(2000);
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}