package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.MenuSubMenuPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.AccountHeadMappingPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.AccountHeadPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.AccountMasterPage;
import com.mastercard.pts.integrated.issuing.utils.ConnectionUtils;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.FileUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

// TODO: Auto-generated Javadoc
/**
 * The Class AccountHeadMappingFlows.
 */
@Component
public class AccountHeadMappingFlows extends MenuFlows {

	final Logger logger = LoggerFactory
			.getLogger(AccountHeadMappingFlows.class);

	@Autowired
	public AccountHeadMappingPage accountHeadMappingPage;

	@Autowired
	public MenuSubMenuPage menuSubMenuPage;

	@Autowired
	public AccountMasterPage accountMasterPage;

	@Autowired
	public AccountHeadPage accountHeadPage;

	@Autowired
	ConnectionUtils connectionUtils;

	@Autowired
	NetworkFlows networkFlows;

	@Autowired
	AccountHeadFlows accountHeadFlows;

	private String AccountCode = "";
	private String cardFeeTransactionCode = "21";
	private static String savedAccountHead = "";

	public static String getSavedAccountHead() {
		return savedAccountHead;
	}

	/**
	 * Navigate to account head mapping page.
	 */
	public void navigateAccountHeadMappingPage() {
		waitForElementVisible(menuSubMenuPage.getCardManagement());
		clickMenuSubOption(menuSubMenuPage.getInstitutionParameterSetup(),
				menuSubMenuPage.getHostAccounting());
		menuSubMenuPage.getAccountHeadMapping().click();
	}

	/**
	 * Adds the account head mapping flows.
	 */
	public void addAccountHeadMappingFlows() {
		accountHeadMappingPage.clickAddAccountHeadMapping();
		accountHeadMappingPage.retryAddAccountHeadMapping(savedAccountHead);
	}

	public void savesAccountHead() {
		accountHeadPage.searchAccountHead(MapUtils
				.fnGetInputDataFromMap("Account Code"));
		savedAccountHead = accountHeadPage.getAccountHead();
		MapUtils.fnSetInputDataToInputMap("Account Head", savedAccountHead);
	}

	public void addAccountHeadMappingCardFee() {
		accountHeadMappingPage.clickAddAccountHeadMapping();
		accountHeadMappingPage
				.retryAddAccountHeadMappingCardFees(savedAccountHead);
	}

	public void addDuplicateAccountHeadMappingFlows() {
		addAccountHeadMappingFlows();
		accountHeadMappingPage.addDuplicateAccountHeadMapping();
	}

	/**
	 * Verifies if the Account Head Mapping entry is saved
	 *
	 * @return true, if successful
	 */
	public boolean checkSavedAccountHeadMapping() {
		// getFinder().getWebDriver().switchTo().defaultContent();
		CustomUtils.ThreadDotSleep(2000);
		waitForElementVisible(accountHeadMappingPage.getSearchTransactionCode());
		accountHeadMappingPage.searchAccountHeadMapping();
		return accountMasterPage.verifyNewlyAddedEntry();
	}

	/**
	 * Check drop down enabled flows.
	 *
	 * @return true, if successful
	 */
	public boolean checkDropDownEnabledFlows() {
		accountHeadMappingPage.clickAddAccountHeadMapping();
		accountHeadMappingPage.switchToAddAccountHeadMapping();
		accountHeadMappingPage.selectTransactionAsCardFees();
		return CustomUtils.checkDropDownEnabled(accountHeadMappingPage
				.getFeeReasonCode());
	}

	/**
	 * Check search functionality flows.
	 *
	 * @return true, if successful
	 */
	public boolean checkSearchFunctionalityFlows() {
		getFinder().getWebDriver().switchTo().defaultContent();
		accountHeadMappingPage.searchAccountHeadMapping();
		return accountMasterPage.verifyNewlyAddedEntry();
	}

	/**
	 * Adds the duplicate Account Head Mapping.
	 */
	public void addDuplicateAccount() {
		addAccountHeadMappingFlows();
		getFinder().getWebDriver().switchTo().defaultContent();
		addDuplicateAccountHeadMappingFlows();
	}

	/**
	 * Verify error message.
	 *
	 * @return true, if successful
	 */
	public boolean verifyErrorMessage() {
		return CustomUtils.checkErrorMessage(
				MapUtils.fnGetInputDataFromMap("ErrorMessage"),
				accountHeadMappingPage.getErrorMessageText());
	}

	/**
	 * Verify note card fee transaction.
	 *
	 * @return true, if successful
	 */
	public boolean verifyNoteCardFeeTransaction() {
		accountHeadMappingPage.clickAddAccountHeadMapping();
		accountHeadMappingPage.switchToAddAccountHeadMapping();
		String note = "Note:  \n"
				+ "Fee Reason Codes can be configured only for Card fees transaction.\n"
				+ "Only Active Account Heads are listed.";
		return accountHeadMappingPage.getNoteText().equals(note);
	}

	/**
	 * Verify availability of deactivated account head.
	 *
	 * @return true, if successful
	 */
	public boolean verifyAvailabilityOfDeactivatedAccountHead() {
		boolean isPresent = false;
		accountHeadMappingPage.clickAddAccountHeadMapping();
		accountHeadMappingPage.switchToAddAccountHeadMapping();
		waitForElementVisible(accountHeadMappingPage.getTransactionCode());
		for (String element : CustomUtils
				.getAllOptionsOfDropDown(accountHeadMappingPage
						.getAccountHead())) {
			if (element.equals(AccountCode))
				isPresent = true;
		}
		if (isPresent)
			return false;
		else
			return true;
	}

	/**
	 * Save deactivated account head title.
	 */
	public void saveDeactivatedAccountHeadTitle() {
		getFinder().getWebDriver().switchTo().defaultContent();
		AccountCode = accountHeadPage.getAccountHead();
	}

	/**
	 * Modify account head mapping.
	 */
	public void modifyAccountHeadMapping() {
		getFinder().getWebDriver().switchTo().defaultContent();
		accountHeadMappingPage.editAccountHeadMapping();
		getFinder().getWebDriver().switchTo().defaultContent();
	}

	/**
	 * Verify audit func for modification.
	 *
	 * @return true, if successful
	 */
	public boolean verifyAuditFuncForModification() {
		int count = 0;
		Boolean isPresent = false;
		String query = "";
		ResultSet resultSet;
		String transactionCodeExpected = "";
		String feeReasonCodeExpected = "";
		String accountHeadExpected = "";
		String feeReasonCode = "";

		String transactionCode = accountHeadMappingPage.getCodes(MapUtils
				.fnGetInputDataFromMap("Transaction Code"));
		String accountHead = accountHeadMappingPage.getCodes(MapUtils
				.fnGetInputDataFromMap("Account Head"));
		String bankCode = accountHeadMappingPage.getCodes(MapUtils
				.fnGetInputDataFromMap("InstitutionName"));

		if (transactionCode.equals(cardFeeTransactionCode)) {
			feeReasonCode = accountHeadMappingPage.getCodes(MapUtils
					.fnGetInputDataFromMap("Fee Reason Code"));
			query = "select * from TXN_ACC_HEAD_MAP where Bank_Code='"
					+ bankCode + "' and TRANSACTION_CODE='" + transactionCode
					+ "' and FEE_REASON_CODE='" + feeReasonCode
					+ "' and ACCOUNT_CODE='" + accountHead + "'";
		} else {
			query = "select * from TXN_ACC_HEAD_MAP where Bank_Code='"
					+ bankCode + "' and TRANSACTION_CODE='" + transactionCode
					+ "' and ACCOUNT_CODE='" + accountHead + "'";
		}
		try {
			resultSet = connectionUtils.executeQueryForBIN(query);
			while (resultSet.next()) {
				transactionCodeExpected = resultSet
						.getString("TRANSACTION_CODE");
				accountHeadExpected = resultSet.getString("ACCOUNT_CODE");
				if (transactionCode.equals(cardFeeTransactionCode))
					feeReasonCodeExpected = resultSet
							.getString("FEE_REASON_CODE");
			}

			if (transactionCodeExpected.equals(transactionCode))
				count++;
			if (transactionCode.equals(cardFeeTransactionCode)
					&& feeReasonCodeExpected.equals(feeReasonCode))
				count++;
			if (accountHeadExpected.equals(accountHead))
				count++;
		} catch (SQLException e) {
			logger.error("SQL Exception", e);
		}

		if (transactionCode.equals(cardFeeTransactionCode) && count == 3
				|| !transactionCode.equals(cardFeeTransactionCode)
				&& count == 2)
			isPresent = true;
		return isPresent;
	}

	public void downloadMappingExcelSheet() {
		accountHeadMappingPage.clickOnExportCSV();
	}

	public boolean verifyContentsOfCSV() {
		String entries = accountHeadMappingPage.countTotalEntries();
		int count = 0;
		String filepath = "C:\\Users\\" + networkFlows.currentUser("whoami")
				+ "\\Downloads";
		File file = FileUtils.getTheNewestFile(filepath, "csv");
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			scanner.useDelimiter("\n");
			while (scanner.hasNext()) {
				scanner.next();
				count++;
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			logger.error("Error while searching for the file", e);
		}

		return (Integer.valueOf(entries) == count - 1);
	}

}