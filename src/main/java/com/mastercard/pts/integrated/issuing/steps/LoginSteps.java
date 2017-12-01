package com.mastercard.pts.integrated.issuing.steps;

import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.configuration.AppEnvironment;
import com.mastercard.pts.integrated.issuing.configuration.Portal;
import com.mastercard.pts.integrated.issuing.domain.cardholder.LoginCardholder;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.utils.ReadTestDataFromExcel;
import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;
import com.mastercard.pts.integrated.issuing.workflows.LoginFlows;
import com.mastercard.pts.integrated.issuing.workflows.LogoutFlows;
import com.mastercard.pts.integrated.issuing.workflows.QMRReportFlows;

@Component
public class LoginSteps extends AbstractBaseFlows {
	final Logger logger = LoggerFactory.getLogger(LoginSteps.class);

	@Autowired
	LoginFlows loginFlows;

	@Autowired
	LogoutFlows logoutFlows;

	@Autowired
	public QMRReportFlows qmrReportFlows;

	@Autowired
	private ReadTestDataFromExcel excelTestData;

	@Autowired
	public AppEnvironment appEnvironment;

	@Autowired
	public LoginFlows loginflows;

	public LoginCardholder loginCardHolderProvider;

	@Given("login to customer portal as newuser")
	public void LoginForNewUser() {
		Portal userPortal = appEnvironment.getPortalByType(Portal.TYPE_CUSTOMER);
		loginflows.LoginWithNewUser(userPortal);

	}

	/**
	 * Implement this Step for Login on customer portal using test data from
	 * excel sheet
	 */
	@Given("login to portal as existing bank as a $user")
	public void reloginforPrepaid(@Named("TCName") String strStoryName, @Named("sheetName") String strSheetName,
			@Named("user") String userType) {
		String f = "TestData";
		logger.info("Reading entire test data");
		excelTestData.fnReadEntireTestData(f, strSheetName, "TCName");
		if (excelTestData == null) {
			Assert.fail("Unable to read entire test data");
		} else {
			excelTestData.fnSetCurrentStoryTestData(strStoryName);
		}
		login(MapUtils.fnGetInputDataFromMap("UserId"), MapUtils.fnGetInputDataFromMap("Password"));
		CustomUtils.ThreadDotSleep(1100);
		selectInstitute();
	}

	/**
	 * 
	 * Login into Card Holder portal with valid login details from excel sheet
	 */
	@Given("login to cardholder portal as existing Cardholder user")
	public void loginToCardholder() {

		/*
		 * String f = "TestData"; logger.info("Reading entire test data");
		 * excelTestData.fnReadEntireTestData(f, strSheetName, "TCName");
		 * 
		 * if (excelTestData == null) {
		 * Assert.fail("Unable to read entire test data"); } else {
		 * 
		 * excelTestData.fnSetCurrentStoryTestData(strStoryName); }
		 */

		loginCardHolderProvider = LoginCardholder.loginCardholderDataProvider();
		loginCardholder(loginCardHolderProvider.getUserName(), loginCardHolderProvider.getPassWord());
		switchToWindowCHP();
		CustomUtils.ThreadDotSleep(1100);
	}

	@BeforeScenario
	@Given("read test data for scenario")
	public void readScenarioDataSheet(@Named("TCName") String strStoryName, @Named("sheetName") String strSheetName) {
		String f = "TestData";

		logger.info("Reading entire test data");

		excelTestData.fnReadEntireTestData(f, strSheetName, "TCName");

		if (excelTestData == null) {
			Assert.fail("Unable to read entire test data");
		} else {
			excelTestData.fnSetCurrentStoryTestData(strStoryName);
		}
	}

	@Given("open card holder application")
	public void openCardHolderApplication() {
		loginFlows.openCardHolderApplication();
	}

	@Given("first time card holder registeration for login")
	public void firstTimeCardRegisteration() {
		loginFlows.signUpCardHolderUser(loginCardHolderProvider.getPassWord(),
				loginCardHolderProvider.getCardHolderTransPassword(), loginCardHolderProvider.getFirstSequrityQst(),
				loginCardHolderProvider.getFirstSequrityAnsw(), loginCardHolderProvider.getSecondSequrityQst(),
				loginCardHolderProvider.getSecondSequrityAnsw());

	}

	@Then("switch to new window")
	public void switchToNewWindow() {
		switchToWindowCHP();
	}

	@Given("login to bank as a $user")
	public void Login(@Named("TCName") String strStoryName, @Named("sheetName") String strSheetName,
			@Named("testDataFileName") String testDataFileName, @Named("user") String userType) {
		Portal userPortal = appEnvironment.getPortalByType(Portal.TYPE_CUSTOMER);
		logger.info("Reading entire test data");
		if (testDataFileName != "") {
			excelTestData.fnReadEntireTestData(testDataFileName, strSheetName, "TCName");
			if (excelTestData == null) {
				Assert.fail("Test Data not found for " + strStoryName + "in File:" + testDataFileName);
			} else {
				excelTestData.fnSetCurrentStoryTestData(strStoryName);
			}
		}
		loginflows.Login(userPortal, userType);

	}

	@Override
	@Given("user login to customer portal with $userName and $password")
	public void login(@Named("userName") String userName, @Named("password") String password) {
		loginFlows.loginAsCorporateUser(userName, password);

	}

	@Given("User login to card holder portal with $userName and $passWord")
	public void loginCardholder(@Named("userName") String userName, @Named("passWord") String passWord) {

		if (loginFlows.loginAsCardholderUser(userName, passWord)) {

			loginFlows.signUpCardHolderUser(loginCardHolderProvider.getPassWord(),
					loginCardHolderProvider.getCardHolderTransPassword(), loginCardHolderProvider.getFirstSequrityQst(),
					loginCardHolderProvider.getFirstSequrityAnsw(), loginCardHolderProvider.getSecondSequrityQst(),
					loginCardHolderProvider.getSecondSequrityAnsw());

			LoginCardholder.loginCardholderDataProvider().setPassWord("aBcd1234*");
			loginFlows.loginAsCardholderUserAfterSignUp(userName, passWord);
		}
	}

	@When("user selects desired $institution")
	public void selectsInstitution(@Named("institution") String customerPortalInstitute) {
		customerPortalHomePage.selectInstitution(customerPortalInstitute);
	}

	@Then("user should be in the home page and validate the institution")
	public void verifyHomepage() {
		customerPortalHomePage.verifyHomePage();
		customerPortalHomePage.verifyInstitution(Constants.variable.get("customerPortalInstitute"));
	}

	@Then("user logouts from customer portal")
	public void logout() {
		logoutFlows.logoutCorporateUser();

	}

	@Then("user logouts from cardholder portal")
	public void logutFromCardholderPortal() {
		logoutFlows.clickLogoutCardHolder();
	}

	@When("user selects the newly created institution")
	public void selectsInstitution() {
		customerPortalHomePage.selectInstitution(MapUtils.fnGetInputDataFromMap("Institution"));
	}

}
