package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.AccountMasterFlows;

// TODO: Auto-generated Javadoc
/**
 * This class provides the step definitions for steps mentioned in the Account
 * Master story file
 */
@Component
public class AccountMasterSteps extends AbstractBaseFlows {

	final Logger logger = LoggerFactory.getLogger(AccountMasterSteps.class);

	@Autowired
	AccountMasterFlows accountMasterFlows;

	/**
	 * Step Definition for navigating to the Account Master page from Home page
	 * <p>
	 * StoryFile usage : When user navigates to Account Master screen
	 * <p>
	 */
	@When("user navigates to Account Master screen")
	public void navigateToAccountMaster() {
		logger.info("Navigating to the add Account Master page");
		accountMasterFlows.navigateAccountMasterPage();
	}

	/**
	 * Step Definition for verifying that the 'Program' is not mandatory while
	 * adding a new Account Master
	 * <p>
	 * StoryFile usage : Then verify that the program field is non mandatory
	 * field on the Account Master page
	 * <p>
	 */
	@Then("verify that the program field is non mandatory field on the Account Master page")
	public void checkNonMandatoryProgramField() {
		logger.info("verify that the program field is non mandatory field on the Account Master page");
		getFinder().getWebDriver().switchTo().defaultContent();
		Assert.assertTrue(accountMasterFlows.checkSavedAccountMaster());
		sessionExpiryloginInAgain();
	}

	/**
	 * Step Definition for adding a new Account Master with program code
	 * <p>
	 * StoryFile usage : When user creates a new account master with Program
	 * Code
	 * <p>
	 */
	@When("user creates a new account master with Program Code")
	public void creates_a_new_account_master() {
		logger.info("Creating a new account master with Program Code");
		accountMasterFlows.createAccountMaster();
	}

	/**
	 * Step Definition for adding a new Account Master without program code
	 * <p>
	 * StoryFile usage : When user creates a new account master without Program
	 * Code
	 * <p>
	 */
	@When("user creates a new account master without Program Code")
	public void user_creates_a_new_account_master_without_program_code() {
		logger.info("Creating a new account master without Program Code");
		accountMasterFlows.createAccountMaster();
	}

	/**
	 * Step Definition for verifying that the Program Codes are available on the
	 * Account Master screen
	 * <p>
	 * StoryFile usage : Then verify that the already existing Debit Program
	 * Codes are available under Program drop-down on Account Master screen
	 * <p>
	 */
	@Then("verify that the already existing Debit Program Codes are available under Program drop-down on Account Master screen")
	public void checkingDebitProgramCodesInProgramField() {
		logger.info("verify that the already existing Debit Program Codes are available under Program drop-down on Account Master screen");
		Assert.assertTrue(accountMasterFlows
				.verifyListOfDebitCodesInProgramCodeField());
		sessionExpiryloginInAgain();
	}

	/**
	 * Step Definition for verifying that the recently added Account Master is
	 * saved successfully
	 * <p>
	 * StoryFile usage : Then the system should save the Account Master
	 * <p>
	 */
	@Then("the system should save the Account Master")
	public void system_should_save_the_Account_Master() {
		logger.info("Verify that the system saves the Account Master");
		getFinder().getWebDriver().switchTo().defaultContent();
		Assert.assertTrue(accountMasterFlows.checkSavedAccountMaster());
		sessionExpiryloginInAgain();
	}

	/**
	 * Step Definition for creating a duplicate Account Master
	 * <p>
	 * StoryFile usage : When user creates the same account master again
	 * <p>
	 */
	@When("user creates the same account master again")
	public void user_creates_the_same_account_master_again() {
		logger.info("Creating a duplicate Account Master");
		getFinder().getWebDriver().switchTo().defaultContent();
		accountMasterFlows.duplicateAccountMaster();
	}

	/**
	 * Step Definition for verifying that an appropriate error message is shown
	 * on creating a duplicate Account Master
	 * <p>
	 * StoryFile usage : Then verify that the system throws an appropriate error
	 * message on adding a duplicate account master
	 * <p>
	 */
	@Then("verify that the system throws an appropriate error message on adding a duplicate account master")
	public void system_throws_an_appropriate_error_message_for_duplicate_account() {
		logger.info("Verifying the error message is displayed.");
		Assert.assertTrue(accountMasterFlows.verifyErrorMessage());
		sessionExpiryloginInAgain();
	}

	/**
	 * Step Definition for verifying the change in the label: Transaction Type >
	 * Account Head
	 * <p>
	 * StoryFile usage : Then verify that the label Transaction Type should be
	 * changed to Account Head
	 * <p>
	 */
	@Then("verify that the label Transaction Type should be changed to Account Head")
	public void verifyLabelAccounthead() {
		logger.info("Verifying that the label Transaction Type should be changed to Account Head");
		Assert.assertTrue(accountMasterFlows.verifyLabelAccountHeadFlows());
		sessionExpiryloginInAgain();
	}

	// there is a Account Head available in the system
	@Given("there is a Account Head available in the system")
	public void account_head_available() {
		logger.info("Adding a new Account Head as a pre-requisite");

	}

}
