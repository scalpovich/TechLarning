package com.mastercard.pts.integrated.issuing.workflows;

import java.util.Collection;

import org.jbehave.core.annotations.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.administration.LoginPage;

@Component
public class LogoutFlows extends AbstractBaseFlows {
	
	
	@Autowired
	public LoginFlows loginflows;
	
	@Autowired
	public LoginPage loginPage;

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
	
	@Then("cardholder logouts from cardholder portal")
	public void clickLogoutCardHolder(){
		loginPage.clickLogoutCardHolder();
		
	}
	
}
