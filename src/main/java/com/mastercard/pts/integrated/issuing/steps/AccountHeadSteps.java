package com.mastercard.pts.integrated.issuing.steps;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.AccountHeadFlows;

// TODO: Auto-generated Javadoc
/**
 * This class provides the step definitions for steps mentioned in the Account
 * Head story file
 */
@Component
public class AccountHeadSteps extends AccountHeadFlows {

	final Logger logger = LoggerFactory.getLogger(AccountHeadSteps.class);

	/**
	 * Step Definition for navigating to the Account Head page from Home page
	 * <p>
	 * StoryFile usage : When user navigates to Account Head screen
	 * <p>
	 */
	@When("user navigates to Account Head screen")
	public void navigateToAccountHead() {
		logger.info("Navigating to the Account Head page");
		navigateAccountHeadPage();
	}

	/**
	 * Step Definition for verifying that the recently added Account Head is
	 * saved
	 * <p>
	 * StoryFile usage : Then verify that user is able to configure account head
	 * <p>
	 */
	@Then("verify that user is able to configure account head")
	public void configure_different_account_head() {
		logger.info("Verifying the Account Head is saved successfully in the system");
		getFinder().getWebDriver().switchTo().defaultContent();
		Assert.assertTrue(verifyAccountHeadSaved());
		sessionExpiryloginInAgain();
	}

	/**
	 * Step Definition for adding a new Account Head in the system
	 * <p>
	 * StoryFile usage : When user adds account head in the system
	 * <p>
	 */
	@When("user adds account head in the system")
	public void addAccountHead() {
		logger.info("Adding a new Account Head");
		addNewAccountHead();
	}

	/**
	 * Step Definition for de-activating a recently added Account Head in the
	 * system
	 * <p>
	 * StoryFile usage : When user de-activates the account head
	 * <p>
	 */
	@When("user de-activates the account head")
	public void deActivateAccountHead() {
		logger.info("Deactivating the recently added account");
		deactivateAccountHeadFlow();
	}

	/**
	 * Step Definition for verifying that the recently de-activated account head
	 * is not available for mapping
	 * <p>
	 * StoryFile usage : Then verify de-activated head should not be available
	 * for transaction mapping
	 * <p>
	 */
	@Then("verify de-activated head should not be available for transaction mapping")
	public void verify_deactivated_head_is_not_available_for_transaction_mapping() {
		logger.info("Verify the deactivated account is not seen on the Account Master page");
		getFinder().getWebDriver().switchTo().defaultContent();
		Assert.assertTrue(verifyAccountHeadNotVisibleOnAccountMaster());
		sessionExpiryloginInAgain();
	}

	/**
	 * Step Definition for creating a duplicate Account Head into the system
	 * <p>
	 * StoryFile usage : When user creates a duplicate entry of the Account Head
	 * <p>
	 */
	@When("user creates a duplicate entry of the Account Head")
	public void creatingDuplicateAccountHead() {
		logger.info("Creating a duplicate account head");
		addingDuplicateAccountHead();
	}

	/**
	 * Step Definition for verifying an appropriate error message is shown on
	 * adding an duplicate Account Head
	 * <p>
	 * StoryFile usage : Then verify that an appropriate error message is seen
	 * on the screen
	 * <p>
	 */
	@Then("verify that an appropriate error message is seen on the screen")
	public void verify_error_message_duplicate_account_head() {
		logger.info("Verifying the error message for the duplicate entry of Account Head");
		Assert.assertTrue(verifyErrorMessage());
		sessionExpiryloginInAgain();
	}

	/**
	 * Step Definition for searching the Suspense Account [00] on Account Head
	 * page
	 * <p>
	 * StoryFile usage : When user searches for the Suspense Account on Account
	 * Head screen
	 * <p>
	 */
	@When("user searches for the Suspense Account on Account Head screen")
	public void user_searches_for_Suspense_Account_on_Account_Head_screen() {
		logger.info("Searching for the Suspense account on Account Head page");
		searchSuspenseAccountOnAccountHead();
	}

	/**
	 * Step Definition for editing the recently created Suspense Account [00]
	 * <p>
	 * StoryFile usage : Then system should allow the user to edit Suspense
	 * Account head
	 * <p>
	 */
	@Then("system should allow the user to edit Suspense Account head")
	public void edit_suspense_account() {
		Assert.assertTrue(verifyEditSuspenseAccount());
		sessionExpiryloginInAgain();
	}

	/**
	 * Step Definition for searching the Suspense Account [00] on Account Master
	 * page
	 * <p>
	 * StoryFile usage : When user searches for the Suspense Account on Account
	 * Master screen
	 * <p>
	 */
	@When("user searches for the Suspense Account on Account Master screen")
	public void user_searches_SuspenseAccount_onAccountMaster() {
		logger.info("Searching for the Suspense account on Account Master page");
		searchSuspenseAccountOnAccountMasterFlow();
	}

	/**
	 * Step Definition for verifying that the system does not allow to edit the
	 * 'Program' and 'Interchange' of the Suspense Account [00]
	 * <p>
	 * StoryFile usage : Then system does not allow to edit 'Program' and
	 * 'Interchange' for Suspense Account
	 * <p>
	 */
	@Then("system does not allow to edit 'Program' and 'Interchange' for Suspense Account")
	public void system_does_not_allow_to_edit_Program_and_Interchange_for_Suspense_Account() {
		logger.info("Verify the system does not allow to configure Program and Interchange for Suspense account");
		getFinder().getWebDriver().switchTo().defaultContent();
		Assert.assertTrue(verifyNonEditableFieldsSuspenseAccount());
		sessionExpiryloginInAgain();
	}

	/**
	 * Step Definition for verifying the Suspense Account [00] is available in
	 * the Account Head dropdown on the Account Master page
	 * <p>
	 * StoryFile usage : Then verify that the Suspense account is shown on the
	 * Account Master page
	 * <p>
	 */
	@Then("verify that the Suspense account is shown on the Account Master page")
	public void verify_Suspense_account_is_shown_on_the_Account_Master_page() {
		logger.info("verify that the Suspense account is shown on the Account Master page");
		Assert.assertTrue(verifySuspenseAccountOnAccountMaster());
		sessionExpiryloginInAgain();
	}

	/**
	 * Step Definition for verifying the Suspense Account [00] is not available
	 * in the Account Head dropdown on the Account Head Mapping page
	 * <p>
	 * StoryFile usage : Then verify that the Suspense account is not shown on
	 * the Account Head Mapping page
	 * <p>
	 */
	@Then("verify that the Suspense account is not shown on the Account Head Mapping page")
	public void verify_Suspense_account_is_not_shown_on_Account_Head_Mapping_page() {
		logger.info("verify that the Suspense account is shown on the Account Head Mapping page");
		Assert.assertTrue(verifySuspenseAccountOnAccountHeadMapping());
		sessionExpiryloginInAgain();
	}

	/**
	 * Step Definition for searching the Suspense Account [00] on the Account
	 * Head Mapping page
	 * <p>
	 * StoryFile usage : When user searches for the Suspense Account on Account
	 * Head Mapping screen
	 * <p>
	 */
	@When("user searches for the Suspense Account on Account Head Mapping screen")
	public void user_searches_SuspenseAccount_onAccountHeadMapping() {
		logger.info("Searching for the Suspense account on Account Head Mapping page");
		searchSuspenseAccountOnAccountHeadMappingFlow();
	}

	/**
	 * Step Definition for verifying that the Suspense Account [00] cannot be
	 * deactivated
	 * <p>
	 * StoryFile usage : Then verify that the Suspense account cannot be
	 * deactivated
	 * <p>
	 */
	@Then("verify that the Suspense account cannot be deactivated")
	public void verify_Suspense_account_cannot_be_deactivated() {
		logger.info("verify that the Suspense account cannot be deactivated");
		Assert.assertTrue(verifySuspenseAccountNotDeactivated());
		sessionExpiryloginInAgain();
	}

	/**
	 * Step Definition for saving the Account Head for further use
	 * <p>
	 * StoryFile usage : When the user saves the Account Head for further use
	 * <p>
	 */
	@When("the user saves the Account Head for further use")
	public void the_user_saves_the_Account_Head_for_further_use() {
		logger.info("Saving the Account Head for further use");
		savesAccountHeadFlow();

	}

}
