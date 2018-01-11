package com.mastercard.pts.integrated.issuing.workflows;

import net.thucydides.core.annotations.Step;

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

@Workflow
public class LoginWorkflow {
	final Logger logger = LoggerFactory.getLogger(LoginWorkflow.class);

	@Autowired
	private PageObjectFactory pageFactory;

	@Autowired
	private WebDriverProvider webProvider;

	public void openLoginPageForPortal(Portal portal) {
		webProvider.get().manage().window().maximize();
		webProvider.get().get(portal.getUrl());
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

	public void confirmInstitutionSelection(String institutionSelector) {
		InstitutionSelectionPage page = pageFactory.getPage(InstitutionSelectionPage.class);
		String institution = System.getProperty("institution");
		if (institution != null && !institution.trim().isEmpty())
			institutionSelector = institution;
		page.selectInstitution(institutionSelector);
		page.clickConfirm();
	}

	public void logInInstitution(Portal portal, String institution) {
		openLoginPageForPortal(portal);
		login(portal.getUserName(), portal.getPassword());
		confirmInstitutionSelection(institution);
	}

	public void logInInstitutionAsAdmin(Portal portal, String institution) {
		openLoginPageForPortal(portal);
		login(portal.getAdminUserName(), portal.getAdminPassword());
		confirmInstitutionSelection(institution);
	}

	public void signOutCustomer() {
		HeaderPage page = pageFactory.getPage(HeaderPage.class);
		page.signOutCustomer();
	}

	public void signOutCollect() {
		HeaderPage page = pageFactory.getPage(HeaderPage.class);
		page.signOutCollect();
	}

	public void signOutCardholder() {
		HeaderPage page = pageFactory.getPage(HeaderPage.class);
		page.signOutCardholder();
	}

	public void signOutAgent() {
		HeaderPage page = pageFactory.getPage(HeaderPage.class);
		page.signOutAgent();
	}
}