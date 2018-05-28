package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Composite;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.AccountHeadMappingFlows;

// TODO: Auto-generated Javadoc
/**
 * This class provides the step definitions for steps mentioned in the Account
 * Head Mapping story file
 */
@Component
public class AccountHeadMappingSteps extends AccountHeadMappingFlows {

	final Logger logger = LoggerFactory
			.getLogger(AccountHeadMappingSteps.class);

	/**
	 * Step Definition for navigating to the Account Head Mapping page from Home
	 * page
	 * <p>
	 * StoryFile usage : When user navigates to Account Head Mapping screen
	 * <p>
	 */
	@When("user navigates to Account Head Mapping screen")
	public void user_navigates_to_Account_Head_Mapping_screen() {
		logger.info("Navigating to the Account Head Mapping page");
		navigateAccountHeadMappingPage();
	}

	/**
	 * Step Definition for adding a new Account Head Mapping into the system
	 * <p>
	 * StoryFile usage : When user adds an Account Head Mapping
	 * <p>
	 * Add the required test data into the excel sheet for adding a new entry
	 * into the system
	 */
	@When("user adds an Account Head Mapping")
	public void user_adds_an_Account_Head_Mapping() {
		logger.info("Adding a new Account Head Mapping");
		addAccountHeadMappingFlows();
	}

	/**
	 * Step Definition for verifying if the newly added entity is successfully
	 * added into the system
	 * <p>
	 * StoryFile usage : Then user should be able to add an account head mapping
	 * <p>
	 */
	@Then("user should be able to add an account head mapping")
	public void user_should_be_able_to_add_an_account_head_mapping() {
		logger.info("Verify the Account Head Mapping is successfully saved.");
		getFinder().getWebDriver().switchTo().defaultContent();
		Assert.assertTrue(checkSavedAccountHeadMapping());
		sessionExpiryloginInAgain();
	}

	/**
	 * Step Definition for verifying the "Reason Code" drop-down is enabled only
	 * for a Card Fees Transaction
	 * <p>
	 * StoryFile usage : Then verify that the user is allowed to attach 'Reason
	 * Code' of respective 'Card Fees Transaction' during mapping
	 * <p>
	 */
	@Then("verify that the user is allowed to attach 'Reason Code' of respective 'Card Fees Transaction' during mapping")
	public void user_is_allowed_to_attach_Reason_Code_of_respective_Card_Fees_Transaction() {
		logger.info("Verify the Reason Code drop down is enabled only fot the Card Fee transactions");
		Assert.assertTrue(checkDropDownEnabledFlows());
		sessionExpiryloginInAgain();
	}

	/**
	 * Step Definition for verifying the Account Head Mapping search
	 * functionality is working as expected
	 * <p>
	 * StoryFile usage : Then verify that the search functionality is working as
	 * expected
	 * <p>
	 */
	@Then("verify that the search functionality is working as expected")
	public void verify_the_search_functionality() {
		logger.info("Verify that the search functionality for Account Head Mapping is working as expected");
		Assert.assertTrue(checkSearchFunctionalityFlows());
		sessionExpiryloginInAgain();
	}

	/**
	 * Step Definition for verifying the Account Head Mapping search
	 * functionality is working as expected
	 * <p>
	 * StoryFile usage : Then verify that the search functionality is working as
	 * expected
	 * <p>
	 */
	@When("user downloads the mapping in excel format")
	public void user_downloads_the_mapping_in_excel_format() {
		logger.info("The user clicks on the Download CSV file icon");
		downloadMappingExcelSheet();
	}

	/**
	 * Step Definition for verifying the Account Head Mapping search
	 * functionality is working as expected
	 * <p>
	 * StoryFile usage : Then verify that the search functionality is working as
	 * expected
	 * <p>
	 */
	@Then("verify that the excel file contains all the transaction & respective Host account mapping")
	public void verify_the_contents_of_CSV() {
		logger.info("Verify that the search functionality for Account Head Mapping is working as expected");
		Assert.assertTrue(verifyContentsOfCSV());
		sessionExpiryloginInAgain();
	}

	/**
	 * Step Definition for adding a duplicate account head into the system
	 * <p>
	 * StoryFile usage : When user adds a duplicate account head into the system
	 * <p>
	 */
	@When("user adds a duplicate account head mapping into the system")
	public void user_adds_a_duplicate_account_head_mapping_into_the_system() {
		logger.info("Adding a duplicate Account Head Mapping into the system");
		addDuplicateAccountHeadMappingFlows();
	}

	/**
	 * Step Definition for validating the error message shown on adding a
	 * duplicate account
	 * <p>
	 * StoryFile usage : Then verify that a proper validation message is shown
	 * if the user tries to enter duplicate account head mapping
	 * <p>
	 */
	@Then("verify that a proper validation message is shown if the user tries to enter duplicate account head mapping")
	public void verify_error_message() {
		logger.info("Verify that a proper validation message is shown if the user tries to enter duplicate account head mapping");
		Assert.assertTrue(verifyErrorMessage1());
		sessionExpiryloginInAgain();
	}

	/**
	 * Step Definition for verifying that a Note is shown for 'Card Fees
	 * Transaction'
	 * <p>
	 * StoryFile usage : Then verify that system shows a 'Note' while mapping
	 * any 'Card Fees Transaction'
	 * <p>
	 */
	@Then("verify that system shows a 'Note' while mapping any 'Card Fees Transaction'")
	public void verify_note_for_card_fees_transaction() {
		logger.info("Verify that a proper validation message is shown if the user tries to enter duplicate account head mapping");
		Assert.assertTrue(verifyNoteCardFeeTransaction());
		sessionExpiryloginInAgain();
	}

	/**
	 * Step Definition for verifying that the deactivated account head is not
	 * available for mapping
	 * <p>
	 * StoryFile usage : Then verify that the system should not allow the user
	 * to map 'Transaction' with 'De-activated' account head
	 * <p>
	 */
	@Then("verify that the system should not allow the user to map 'Transaction' with 'De-activated' account head")
	public void verify_deactivated_account_head_not_seen_for_transaction_mapping() {
		logger.info("Verify that the system should not allow the user to map 'Transaction' with 'De-activated' account head");
		Assert.assertTrue(verifyAvailabilityOfDeactivatedAccountHead());
		sessionExpiryloginInAgain();
	}

	/**
	 * Step Definition for saving the Account Head of the recently deactivated
	 * Account Head
	 * <p>
	 * StoryFile usage : When user saves the deactivated account head
	 * <p>
	 */
	@When("user saves the deactivated account head")
	public void user_saves_the_deactivated_account_head() {
		logger.info("User saves the account head title for further use");
		saveDeactivatedAccountHeadTitle();
	}

	/**
	 * Step Definition for modifying an Account Head present in the system
	 * <p>
	 * StoryFile usage : When user modifies a mapping on the Account Head
	 * Mapping page
	 * <p>
	 */
	@When("user modifies a mapping on the Account Head Mapping page")
	public void user_modifies_a_Account_Head_Mapping() {
		logger.info("Modifying the recently added account head mapping");
		modifyAccountHeadMapping();
	}

	/**
	 * Step Definition for verifying if the Audit functionality is working
	 * modifying an Account Head Mapping
	 * <p>
	 * StoryFile usage : Then verify that the audit functionality records for
	 * modification of record
	 * <p>
	 */
	@Then("verify that the audit functionality records for modification of record")
	public void verify_audit_functionality_records_for_modification_of_record() {
		logger.info("Verify the entry is updated in the table TXN_ACC_HEAD_MAP on modifying a record");
		Assert.assertTrue(verifyAuditFuncForModification());
		sessionExpiryloginInAgain();
	}

	/**
	 * Step Definition for adding an Account Head Mapping for Card Fees
	 * Transactions
	 * <p>
	 * StoryFile usage : When user adds an Account Head Mapping for Card Fee
	 * transactions
	 * <p>
	 */
	@When("user adds an Account Head Mapping for Card Fee transactions")
	public void user_adds_an_Account_Head_Mapping_for_Card_Fee_transactions() {
		logger.info("User adds an Account Head Mapping for card fee transactions");
		addAccountHeadMappingCardFee();
	}

	/**
	 * Step Definition for navigating and adding a new Account Head Mapping
	 * <p>
	 * StoryFile usage : When the user navigates and adds account head mapping
	 * to the system
	 * <p>
	 */
	@When("the user navigates and adds account head mapping to the system")
	@Composite(steps = { "When user navigates to Account Head Mapping screen",
			"When user adds an Account Head Mapping" })
	public void whenUserAddsNewAccountHeadMapping() {

	}

}
