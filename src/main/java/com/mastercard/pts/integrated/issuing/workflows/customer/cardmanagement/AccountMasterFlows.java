package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.MenuSubMenuPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.AccountMasterPage;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

// TODO: Auto-generated Javadoc
/**
 * The Class AccountMasterFlows.
 */
@Component
public class AccountMasterFlows extends MenuFlows {

	/** The logger. */
	final Logger logger = LoggerFactory.getLogger(AccountMasterFlows.class);

	/** The menu sub menu page. */
	@Autowired
	MenuSubMenuPage menuSubMenuPage;

	/** The account master page. */
	@Autowired
	AccountMasterPage accountMasterPage;

	/** The program flows. */
	@Autowired
	ProgramFlows programFlows;

	/**
	 * Navigate account master page.
	 */
	public void navigateAccountMasterPage() {

		waitForElementVisible(menuSubMenuPage.getCardManagement());
		clickMenuSubOption(menuSubMenuPage.getInstitutionParameterSetup(),
				menuSubMenuPage.getHostAccounting());
		menuSubMenuPage.getAccountMaster().click();
	}

	/**
	 * Creates the account master.
	 */
	public void createAccountMaster() {
		accountMasterPage.clickAddAccountMaster();
		accountMasterPage.switchToAddAccountMasterFrame();
		accountMasterPage.addRandomAccountMaster();
	}

	/**
	 * Creates a duplicate account master.
	 */
	public void duplicateAccountMaster() {
		createAccountMaster();
		CustomUtils.ThreadDotSleep(4000);
		accountMasterPage.clickAddAccountMaster();
		accountMasterPage.switchToAddAccountMasterFrame();
		accountMasterPage.addDuplicateAccountMaster();

	}

	/**
	 * Verify list of debit codes in program code field.
	 *
	 * @return the boolean
	 */
	public Boolean verifyListOfDebitCodesInProgramCodeField() {
		accountMasterPage.getAddAccountMaster().click();
		// Getting codes from Account Master page
		List<String> programCodesList = new ArrayList<String>(
				accountMasterPage.getListOfDebitCodesInProgramCodeField());

		List<String> expectedProgramCodes = new ArrayList<String>();
		for (String programCode : programCodesList) {
			if (programCode.length() > 0)
				expectedProgramCodes.add(programCode.substring(0,
						programCode.indexOf('[') - 1));
		}
		accountMasterPage.getCancel().click();
		getFinder().getWebDriver().switchTo().defaultContent();
		// Navigate to Program page
		programFlows.navigateProgramPage();
		accountMasterPage.searchDebitProgram();
		List<String> actualProgramCodes = new ArrayList<String>(
				programFlows.getListOfProgramCodes());
		actualProgramCodes.removeAll(expectedProgramCodes);
		return actualProgramCodes.isEmpty();
	}

	/**
	 * Verify error message.
	 *
	 * @return true, if successful
	 */
	public boolean verifyErrorMessage1() {
		waitForElementVisible(accountMasterPage.getErrorMessageText());
		return CustomUtils.checkErrorMessage(
				MapUtils.fnGetInputDataFromMap("ErrorMessage"),
				accountMasterPage.getErrorMessageText());
	}

	/**
	 * Check saved account master.
	 *
	 * @return true, if successful
	 */
	public boolean checkSavedAccountMaster() {
		waitForElementVisible(accountMasterPage.getInfoPanel());
		accountMasterPage.searchAccountMaster();
		return accountMasterPage.verifyNewlyAddedEntry();
	}

	/**
	 * verifying the Account Head Label
	 *
	 * @return true, if successful
	 */
	public boolean verifyLabelAccountHeadFlows() {
		return accountMasterPage.verifyLabelAccountHead();

	}

}