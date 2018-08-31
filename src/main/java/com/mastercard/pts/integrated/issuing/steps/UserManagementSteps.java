package com.mastercard.pts.integrated.issuing.steps;

import java.util.ArrayList;
import java.util.List;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.configuration.AppEnvironment;
import com.mastercard.pts.integrated.issuing.configuration.Portal;
import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.processingcenter.Institution;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.pages.customer.administration.LoginPage;
import com.mastercard.pts.integrated.issuing.pages.PageObjectFactory;
import com.mastercard.pts.integrated.issuing.pages.agent.AgentHomePage;
import com.mastercard.pts.integrated.issuing.pages.cardholder.CardholderHomePage;
import com.mastercard.pts.integrated.issuing.pages.collect.CollectHomePage;
import com.mastercard.pts.integrated.issuing.pages.customer.InstitutionHomePage;
import com.mastercard.pts.integrated.issuing.pages.customer.InstitutionSelectionPage;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.pts.integrated.issuing.workflows.LoginWorkflow;

import org.apache.commons.lang.RandomStringUtils;

@Component
public class UserManagementSteps {

	public static final String KEY_USER_INSTRITUTIONS = "USER_INSTRITUTIONS";
	
	public static final String USER_INSTITUTION_SELECTED = "USER_INSTITUTION_SELECTED";

	private static final String INCORRECT_PASSCODE = "incorrect";

	private static final String CUSTOMER = "customer";

	@SuppressWarnings("unused")
	private static final String COLLECT = "customer";

	@SuppressWarnings("unused")
	private static final String CARDHOLDER = "cardholder";

	private static final String ADMIN = "admin";

	private static final String AGENCY = "agency";

	private static final String BRANCH = "branch";

	private static final String AGENT = "agent";

	private static final String NON_FUNDED_AGENCY = "nonfundedagency";

	private static final String NON_FUNDED_BRANCH = "nonfundedbranch";

	private static final String NON_FUNDED_AGENT = "nonfundedagent";

	private static final String USER_INSTITUTION_NON_DEFAULT = "USER_INSTITUTION_NON_DEFAULT";
	
	private static final String USERNAME = "USERNAME";

	@Autowired
	private AppEnvironment environment;

	@Autowired
	private PageObjectFactory pageFactory;

	@Autowired
	private LoginWorkflow loginWorkflow;

	@Autowired
	private KeyValueProvider keyValueProvider;

	@Autowired
	private TestContext context;

	@Autowired
	private DataProvider provider;

	private Portal portal;

	private String userDefaultInstitution;

	@When("user {sign|signs} out from $type portal")
	@Given("user {sign|signs} out from $type portal")
	public void givenUserSignOutFromPortal(String type) {
		if (CUSTOMER.equalsIgnoreCase(type))
			loginWorkflow.signOutCustomer();
		if (AGENT.equalsIgnoreCase(type))
			loginWorkflow.signOutAgent();
	}

	@Then("user sign out from $type portal")
	public void thenUserSignOutFromPortal(String type) {
		if (CUSTOMER.equalsIgnoreCase(type))
			loginWorkflow.signOutCustomer();
		if (AGENT.equalsIgnoreCase(type))
			loginWorkflow.signOutAgent();
	}

	@Given("user is on login page of $portalType portal")
	@When("user is on login page of $portalType portal")
	public void givenUserIsOnLoginPageOfportalTypePortal(String portalType) {
		portal = environment.getPortalByType(portalType);
		loginWorkflow.openLoginPageForPortal(portal);
	}

	@Given("user is logged in institution")
	@When("user is logged in institution")
	@Then("user is logged in institution")
	public void givenUserIsLoggedInInstitution() {
		Portal loginPortal = environment.getPortalByType(Portal.TYPE_CUSTOMER);
		userDefaultInstitution = Institution.createWithProvider(provider).buildAbbreviationAndCode();
		Institution institution = Institution.createWithProvider(provider);
		context.put(USER_INSTITUTION_SELECTED, institution.getCode());
		loginWorkflow.logInInstitution(loginPortal, userDefaultInstitution);
		context.put(USERNAME, loginPortal.getUserName());
	}

	@Given("user is logged in non-default institution")
	public void givenUserIsLoggedInNonDefaultInstitution() {
		Portal loginPortal = environment.getPortalByType(Portal.TYPE_CUSTOMER);
		userDefaultInstitution = keyValueProvider.getString(USER_INSTITUTION_NON_DEFAULT);
		MiscUtils.reportToConsole("Another Institution = " + userDefaultInstitution);
		loginWorkflow.logInInstitution(loginPortal, userDefaultInstitution);
	}

	@Given("user is logged in agent portal as $userType user")
	@When("user is logged in agent portal as $userType user")
	public void givenUserIsLoggedInAgentPortal(String userType) {
		Portal agentPortal = environment.getPortalByType(Portal.TYPE_AGENT);
		loginWorkflow.openLoginPageForPortal(agentPortal);
		roleBasedLogin(userType, agentPortal);
		pageFactory.getPage(AgentHomePage.class).switchToWindow().waitUntilIsLoaded();
	}

	@Given("user is logged in customer portal as admin user in processing institution")
	@When("user is logged in customer portal as admin user in processing institution")
	public void givenUserIsLoggedInCustomerPortal() {
		Portal csrPortal = environment.getPortalByType(Portal.TYPE_CUSTOMER);
		userDefaultInstitution = ConstantData.PROCESSING_INSTITUTION;
		loginWorkflow.logInInstitutionAsAdmin(csrPortal, userDefaultInstitution);
	}
    @Given("user logs in with valid credentials")
	@When("user logs in with valid credentials")
	public void whenUserLogsInWithValidCredentials() {
		loginWorkflow.login(portal.getUserName(), portal.getPassword());
	}

	@Given("user logs in with valid login details")
	public void loginWithValidLoginDetails() {
		Device device = context.get(ContextConstants.DEVICE);
		loginWorkflow.login(device.getClientCode(), device.getClientCode());
	}

	@When("user logs in with valid credentials as $userType user")
	public void whenUserLogsInWithValidCredentialsAsUsertTypeUser(String userType) {
		Portal agentPortal = environment.getPortalByType(Portal.TYPE_AGENT);
		loginWorkflow.openLoginPageForPortal(agentPortal);
		roleBasedLogin(userType, agentPortal);
	}

	private void roleBasedLogin(String userType, Portal agentPortal) {
		if (ADMIN.equalsIgnoreCase(userType))
			loginWorkflow.login(agentPortal.getAdminUserName(), agentPortal.getAdminPassword());
		else if (AGENCY.equalsIgnoreCase(userType))
			loginWorkflow.login(agentPortal.getAgencyUserName(), agentPortal.getPassword());
		else if (BRANCH.equalsIgnoreCase(userType))
			loginWorkflow.login(agentPortal.getBranchUserName(), agentPortal.getPassword());
		else if (AGENT.equalsIgnoreCase(userType))
			loginWorkflow.login(agentPortal.getAgentUserName(), agentPortal.getPassword());
		else if (NON_FUNDED_AGENCY.equalsIgnoreCase(userType))
			loginWorkflow.login(agentPortal.getNonfundedAgencyUserName(), agentPortal.getPassword());
		else if (NON_FUNDED_BRANCH.equalsIgnoreCase(userType))
			loginWorkflow.login(agentPortal.getNonfundedBranchUserName(), agentPortal.getPassword());
		else if (NON_FUNDED_AGENT.equalsIgnoreCase(userType))
			loginWorkflow.login(agentPortal.getNonfundedAgentUserName(), agentPortal.getPassword());
	}

	@When("user logs in with incorrect password")
	public void whenUserLogsInWithIncorrectPassword() {
		loginWorkflow.login(portal.getUserName() + RandomStringUtils.randomAlphabetic(2), INCORRECT_PASSCODE);
	}

	@When("user logs in with incorrect password as $userType user")
	public void whenUserLogsInWithIncorrectPasswordAsUserTypeUser(String userType) {
		Portal agentPortal = environment.getPortalByType(Portal.TYPE_AGENT);
		loginWorkflow.openLoginPageForPortal(agentPortal);
		if (ADMIN.equalsIgnoreCase(userType))
			loginWorkflow.login(agentPortal.getAdminUserName() + CustomUtils.randomString(2), INCORRECT_PASSCODE);
		else if (AGENCY.equalsIgnoreCase(userType))
			loginWorkflow.login(agentPortal.getAgencyUserName() + CustomUtils.randomString(2), INCORRECT_PASSCODE);
		else if (BRANCH.equalsIgnoreCase(userType))
			loginWorkflow.login(agentPortal.getBranchUserName() + CustomUtils.randomString(2), INCORRECT_PASSCODE);
		else if (AGENT.equalsIgnoreCase(userType))
			loginWorkflow.login(agentPortal.getAgentUserName() + CustomUtils.randomString(2), INCORRECT_PASSCODE);
	}

	@When("user confirms selection of institution")
	public void whenUserConfirmsSelectionOfInstitution() {
		InstitutionSelectionPage page = pageFactory.getPage(InstitutionSelectionPage.class);
		page.clickConfirm();
	}

	@When("user is at the home tab")
	public void userIsAtTheHomeTab() {
		pageFactory.getPage(InstitutionHomePage.class).waitUntilIsLoaded();
	}

	@Then("user is logged into customer portal successfully")
	public void thenUserIsLoggedIntoCustomerPortalSuccessfully() {
		pageFactory.getPage(InstitutionSelectionPage.class).waitUntilIsLoaded();
	}

	@When("user is logged into cardholder portal successfully")
	@Then("user is logged into cardholder portal successfully")
	public void thenUserIsLoggedIntoCardholderPortalSuccessfully() {
		pageFactory.getPage(CardholderHomePage.class).switchToWindow().waitUntilIsLoaded();
	}

	@Then("user is logged into agent portal successfully")
	public void thenUserIsLoggedIntoAgentPortalSuccessfully() {
		pageFactory.getPage(AgentHomePage.class).switchToWindow().waitUntilIsLoaded();
	}

	@Then("user sees message that user name or password is incorrect on agent portal")
	public void thenUserSeesMessageThatUserNameOrPasswordIsIncorrectOnAgentPortal() {
		LoginPage loginPage = pageFactory.getPage(LoginPage.class);
		String loginErrorMessage = loginPage.getErrorMessage();
		Assert.assertTrue("Incorrect login error message or Login is Successful", !loginErrorMessage.isEmpty());
		Assert.assertEquals("Incorrect login error message", LoginPage.AUTHENTIFICATION_FAILED, loginErrorMessage); // NOSONAR:
																													// isPresent()
																													// is
																													// checked
																													// in
																													// assertTrue
																													// statement
	}

	@When("user is logged into collect portal successfully")
	@Then("user is logged into collect portal successfully")
	public void thenUserIsLoggedIntoCollectPortalSuccessfully() {
		pageFactory.getPage(CollectHomePage.class).waitUntilIsLoaded();
	}

	@Then("user sees message that user name or password is incorrect")
	public void thenUserSeesMessageThatUserNameOrPasswordIsIncorrect() {
		LoginPage loginPage = pageFactory.getPage(LoginPage.class);
		String loginErrorMessage = loginPage.getErrorMessage();
		Assert.assertTrue("Incorrect login error message or Login is Successful", !loginErrorMessage.isEmpty());
		Assert.assertEquals("Incorrect login error message", LoginPage.AUTHENTIFICATION_FAILED, loginErrorMessage); // NOSONAR:
																													// isPresent()
																													// is
																													// checked
																													// in
																													// assertTrue
																													// statement
	}

	@Then("user sees message that user name or password is incorrect for collect portal")
	public void thenUserSeesMessageThatUserNameOrPasswordIsIncorrectForCollectPortal() {
		LoginPage loginPage = pageFactory.getPage(LoginPage.class);
		String loginErrorMessage = loginPage.getErrorMessage();
		Assert.assertTrue("Incorrect login error message or Login is Successful", !loginErrorMessage.isEmpty());
		Assert.assertEquals("Incorrect login error message", LoginPage.AUTHENTIFICATION_FAILED_COLLECT, loginErrorMessage); // NOSONAR:
																															// isPresent()
																															// is
																															// checked
																															// in
																															// assertTrue
																															// statement
	}

	@Then("user sees message that user name or password is incorrect for cardholder portal")
	public void thenUserSeesMessageThatUserNameOrPasswordIsIncorrectForCardholderPortal() {
		LoginPage loginPage = pageFactory.getPage(LoginPage.class);
		String loginErrorMessage = loginPage.getErrorMessageCollect();
		Assert.assertTrue("login error message found", !loginErrorMessage.isEmpty());
		Assert.assertEquals("Incorrect login error message", LoginPage.AUTHENTIFICATION_FAILED_CARDHOLDER, loginErrorMessage);
	}

	@Then("list of available institutions is displayed")
	public void thenListOfAvailableInstitutionsIsDisplayed() {
		InstitutionSelectionPage page = pageFactory.getPage(InstitutionSelectionPage.class);
		List<String> actualInstitutions = page.getAvailableInstitutions();
		List<String> expectedInstitutions = new ArrayList<>(keyValueProvider.getListOfStrings(KEY_USER_INSTRITUTIONS));
		Assert.assertTrue(expectedInstitutions.toString().equals(actualInstitutions.toString()));
	}

	@Then("default institution is selected")
	public void thenDefaultInstitutionIsSelected() {
		InstitutionSelectionPage page = pageFactory.getPage(InstitutionSelectionPage.class);
		String preselectedInstitution = page.getSelectedInstitution();
		userDefaultInstitution = Institution.createWithProvider(provider).buildAbbreviationAndCode();
		Assert.assertEquals("Default institution is not selected", userDefaultInstitution, preselectedInstitution);
	}

	@Then("selected institution page is displayed")
	public void thenSelectedInstitutionPageIsDisplayed() {
		InstitutionHomePage page = pageFactory.getPage(InstitutionHomePage.class);
		page.waitUntilIsLoaded();
		String selectedInstitution = page.getSelectedInstitution();
		userDefaultInstitution = Institution.createWithProvider(provider).buildAbbreviationAndCode();
		String expectedInstitution = userDefaultInstitution.replace('[', '(').replace(']', ')');
		Assert.assertEquals("Default institution is not selected", expectedInstitution, selectedInstitution);
	}
	@When("user wait for one hour to perform transaction")
	public void whenUserWaitForOneHourToPerformTransaction()
	{
		SimulatorUtilities.wait(ConstantData.STATIC_WAIT_FOR_PRESCREENING);
	}
	@When("user wait for one 21 mins to perform transaction")
	public void whenUserWaitToPerformCrossBorderTransaction()
	{
		SimulatorUtilities.wait(1260000);
	}
}
