package com.mastercard.pts.integrated.issuing.workflows;

import org.jbehave.web.selenium.WebDriverProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.configuration.Portal;
import com.mastercard.pts.integrated.issuing.pages.HeaderPage;
import com.mastercard.pts.integrated.issuing.pages.PageObjectFactory;
import com.mastercard.pts.integrated.issuing.pages.customer.InstitutionSelectionPage;
import com.mastercard.pts.integrated.issuing.pages.customer.administration.LoginPage;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;

import net.thucydides.core.annotations.Step;

@Workflow
public class LoginWorkflow {
	final Logger logger = LoggerFactory.getLogger(LoginWorkflow.class);

	@Autowired
	private PageObjectFactory pageFactory;

	@Autowired
	private WebDriverProvider webProvider;

	public void openLoginPageForPortal(Portal portal) {    
		webProvider.get().manage().deleteAllCookies();
		webProvider.get().get(portal.getUrl());
		webProvider.get().manage().window().maximize();		
		LoginPage loginPage = pageFactory.getPage(LoginPage.class);
		loginPage.waitUntilIsLoaded();
	}

	@Step("Login as {0}")
	public void login(String userName, String password) {
		LoginPage loginPage = pageFactory.getPage(LoginPage.class);
		loginPage.inputUserName(userName);
		loginPage.inputPassword(password);
		loginPage.clickLoginButton();
	}

	public boolean confirmInstitutionSelection(String institutionSelector) {
		InstitutionSelectionPage page = pageFactory.getPage(InstitutionSelectionPage.class);
		String institution = System.getProperty("institution");
		if (institution != null && !institution.trim().isEmpty())
			institutionSelector=institution;
		SimulatorUtilities.wait(500);
		page.selectInstitution(institutionSelector);
		SimulatorUtilities.wait(500);
		page.clickConfirm();
		return page.checkSessionExpired();
	}

	public void logInInstitution(Portal portal, String institution) {
		openLoginPageForPortal(portal);
		login(portal.getUserName(), portal.getPassword());
		boolean flag = confirmInstitutionSelection(institution);
		if(flag){
			logInInstitution(portal,institution);
		}
	}


	public void logInInstitutionAsAdmin(Portal portal, String institution) {
		openLoginPageForPortal(portal);
		login(portal.getAdminUserName(), portal.getAdminPassword());
		confirmInstitutionSelection(institution);
	}

	public void signOutCustomer(){
		HeaderPage page = pageFactory.getPage(HeaderPage.class);
		page.signOutCustomer();
	}

	public void signOutCollect(){
		HeaderPage page = pageFactory.getPage(HeaderPage.class);
		page.signOutCollect();
	}

	public void signOutCardholder(){
		HeaderPage page = pageFactory.getPage(HeaderPage.class);
		page.signOutCardholder();
	}

	public void signOutAgent(){
		HeaderPage page = pageFactory.getPage(HeaderPage.class);
		page.signOutAgent();
	}
	
	public String getInstitutionDateLogin()
	{
		LoginPage loginPage = pageFactory.getPage(LoginPage.class);
		return loginPage.getInstitutionDateLogin();
	}
}