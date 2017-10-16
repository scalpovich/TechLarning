package com.mastercard.pts.integrated.issuing.workflows;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

@Component
public class LogoutFlows extends AbstractBaseFlows {

	public void logoutAgentUser() {
		loginAgentPage.clickLogout();
	}

	public void logoutCorporateUser() {
		loginPage.clickLogout();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return null;
	}

}
