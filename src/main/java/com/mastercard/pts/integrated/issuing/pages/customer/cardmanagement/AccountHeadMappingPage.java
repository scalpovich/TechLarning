package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.utils.ConnectionUtils;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.MCWebElements;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

// TODO: Auto-generated Javadoc
/**
 * The Class AccountHeadMappingPage.
 */
@Component
public class AccountHeadMappingPage extends AbstractBasePage {

	/** The logger. */
	final Logger logger = LoggerFactory.getLogger(AccountHeadMappingPage.class);

	@Autowired
	ConnectionUtils connectionUtils;

	/** The Add '+' icon for Account Head Mapping */
	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addAccountHeadMapping;

	/** The transaction code. */
	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionCode:input:dropdowncomponent")
	private MCWebElement transactionCode;

	/** The fee reason code. */
	@PageElement(findBy = FindBy.NAME, valueToFind = "feeReasonCode:input:dropdowncomponent")
	private MCWebElement feeReasonCode;

	/** The account head. */
	@PageElement(findBy = FindBy.NAME, valueToFind = "accountCode:input:dropdowncomponent")
	private MCWebElement accountHead;

	/** The save button. */
	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	/** The cancel button. */
	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement cancelBtn;

	/** The error message text on the frame */
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class='feedbackPanelERROR']")
	private MCWebElements errorMessageText;

	/** The account head search. */
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement accountHeadSearch;

	/** The search button. */
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:buttonPanel:buttonCol:searchButton")
	private MCWebElement searchBtn;

	/** The save notification message */
	@PageElement(findBy = FindBy.CLASS, valueToFind = "feedbackPanelINFO")
	private MCWebElements saveNotification;

	/** The account head mapping edit button. */
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//tr[@class='even'][1]/td[4]/span")
	private MCWebElement accountHeadMappingEditBtn;

	// Search a Account Head Mapping

	/** The search transaction code. */
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement searchTransactionCode;

	/** The search fee reason code. */
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement searchFeeReasonCode;

	/** The search account head. */
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement searchAccountHead;

	/** The export CSV. */
	// Export CSV
	@PageElement(findBy = FindBy.CLASS, valueToFind = "exportCSV")
	private MCWebElement exportCSV;

	/** The note card fee transaction. */
	// Note for Card Fee transaction
	@PageElement(findBy = FindBy.ID, valueToFind = "note")
	private MCWebElement noteCardFeeTransaction;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "navigatorLabel")
	private MCWebElements totalCountOfEntires;

	public String errorPanel = "//span[@class='feedbackPanelERROR']";

	public final String cardFees = "Card fees [21]";

	public List<WebElement> getErrorMessageText1() {
		return getFinder().getWebDriver().findElements(By.xpath(errorPanel));

	}

	/**
	 * Gets the save notification.
	 *
	 * @return the save notification
	 */
	public MCWebElements getSaveNotification() {
		return saveNotification;
	}

	/**
	 * Gets the fee reason code.
	 *
	 * @return the fee reason code
	 */
	public MCWebElement getFeeReasonCode() {
		return feeReasonCode;
	}

	/**
	 * Gets the account head search.
	 *
	 * @return the account head search
	 */
	public MCWebElement getAccountHeadSearch() {
		return accountHeadSearch;
	}

	/**
	 * Click add account head mapping.
	 */
	public void clickAddAccountHeadMapping() {
		addAccountHeadMapping.click();
	}

	/**
	 * Save account head mapping.
	 */
	public void saveAccountHeadMapping() {
		saveBtn.click();
	}

	/**
	 * Gets the error message text.
	 *
	 * @return the error message text
	 */
	public MCWebElements getErrorMessageText() {
		return errorMessageText;
	}

	/**
	 * Gets the account head.
	 *
	 * @return the account head
	 */
	public MCWebElement getAccountHead() {
		return accountHead;
	}

	public MCWebElement getSearchTransactionCode() {
		return searchTransactionCode;
	}

	public MCWebElement getTransactionCode() {
		return transactionCode;
	}

	/**
	 * Switch to add account head mapping.
	 */
	public void switchToAddAccountHeadMapping() {
		switchToIframe(Constants.ADD_ACCOUNT_HEAD_MAPPING_FRAME);
	}

	/**
	 * Switch to edit account head mapping.
	 */
	public void switchToEditAccountHeadMapping() {
		switchToIframe(Constants.EDIT_ACCOUNT_HEAD_MAPPING_FRAME);
	}

	public void selectTransactionAsCardFees() {
		selectDropDownByText(this.transactionCode, cardFees);
	}

	public void addDuplicateAccountHeadMapping() {
		clickAddAccountHeadMapping();
		switchToAddAccountHeadMapping();
		waitForElementVisible(transactionCode);
		String transactionCodeValue = MapUtils
				.fnGetInputDataFromMap("Transaction Code");
		selectDropDownByText(this.transactionCode, transactionCodeValue);
		if (transactionCodeValue.toLowerCase().contains("card fees [21]")) {
			CustomUtils.ThreadDotSleep(2000);
			selectDropDownByText(this.feeReasonCode,
					MapUtils.fnGetInputDataFromMap("Fee Reason Code"));
		}
		selectDropDownByText(this.accountHead,
				MapUtils.fnGetInputDataFromMap("Account Head"));
		saveBtn.click();
	}

	/**
	 * Searches an account head on account head mapping.
	 *
	 * @param search
	 * 
	 */
	public void searchAccountHeadOnAccountHeadMapping(String search) {
		selectDropDownByText(accountHeadSearch, search);
		searchBtn.click();
	}

	/**
	 * Gets the account head list from frame.
	 *
	 * @return the list of account heads available for selection
	 */
	public List<String> getAccountHeadListFromFrame() {
		addAccountHeadMapping.click();
		switchToIframe(Constants.ADD_ACCOUNT_HEAD_MAPPING_FRAME);
		return CustomUtils.getAllOptionsOfDropDown(accountHead);
	}

	/**
	 * Searches an Account Head Mapping
	 */
	public void searchAccountHeadMapping() {
		waitForElementVisible(searchTransactionCode);
		String transactionCodeValue = MapUtils
				.fnGetInputDataFromMap("Transaction Code");
		Select sel = new Select(
				getFinder()
						.getWebDriver()
						.findElement(
								By.name("searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")));
		sel.selectByVisibleText(transactionCodeValue);
		selectDropDownByText(searchTransactionCode, transactionCodeValue);
		if (transactionCodeValue.toLowerCase().contains("card fees"))
			selectDropDownByText(searchFeeReasonCode,
					MapUtils.fnGetInputDataFromMap("Fee Reason Code"));
		selectDropDownByText(searchAccountHead,
				MapUtils.fnGetInputDataFromMap("Account Head"));
		searchBtn.click();
	}

	/**
	 * Click on export CSV icon.
	 */
	public void clickOnExportCSV() {
		exportCSV.click();
	}

	/**
	 * Gets the note text.
	 *
	 * @return the note text
	 */
	public String getNoteText() {
		return noteCardFeeTransaction.getText();
	}

	/**
	 * Edits the account head mapping.
	 */
	public void editAccountHeadMapping() {
		searchAccountHeadMapping();
		waitForElementVisible(accountHeadMappingEditBtn);
		accountHeadMappingEditBtn.click();
		switchToEditAccountHeadMapping();
		waitForElementVisible(accountHead);

		Select select = new Select(getFinder().getWebDriver().findElement(
				By.name("accountCode:input:dropdowncomponent")));
		String selectedOption = select.getFirstSelectedOption().getText();
		List<WebElement> options = select.getAllSelectedOptions();

		if (!options.isEmpty()) {
			for (int i = 1; i < options.size(); i++) {
				if (!options.get(i).equals(selectedOption)) {
					select.selectByIndex(i);
					MapUtils.fnSetInputDataToInputMap("Account Head", options
							.get(i).getText());
				}
			}
		}
		// SelectDropDownByText(accountHead,
		// MapUtils.fnGetInputDataFromMap("ModifiedAccountHead"));
		saveAccountHeadMapping();
	}

	/**
	 * Returns the codes e. g:
	 * 
	 * @param Card
	 *            fees [21]
	 * 
	 * @return the code: 21
	 */
	public String getCodes(String code) {
		return code.substring(code.indexOf("[") + 1, code.length() - 1);
	}

	// if transaction code is 21
	public void isExactCode21() {
		String query = "";
		ResultSet resultSet;
		int count = 0;

		String transactionCodeExpected = "";
		String accountHeadExpected = "";
		String feeReasonCodeExpected = "";

		String feeReasonCode = "";
		String accountHead = getCodes(MapUtils
				.fnGetInputDataFromMap("ModifiedAccountHead"));
		String bankCode = getCodes(MapUtils
				.fnGetInputDataFromMap("InstitutionName"));

		String transactionCode = getCodes(MapUtils
				.fnGetInputDataFromMap("Transaction Code"));
		if (transactionCode == "21") {
			feeReasonCode = getCodes(MapUtils
					.fnGetInputDataFromMap("Fee Reason Code"));
			query = "select * from TXN_ACC_HEAD_MAP where Bank_Code='"
					+ bankCode + "' and TRANSACTION_CODE='" + transactionCode
					+ "' and FEE_REASON_CODE='" + feeReasonCode
					+ "' and ACCOUNT_CODE='" + accountHead + "'";
		}
		// Check

		try {
			resultSet = connectionUtils.executeQueryForBIN(query);
			while (resultSet.next()) {
				transactionCodeExpected = resultSet
						.getString("TRANSACTION_CODE");
				accountHeadExpected = resultSet.getString("ACCOUNT_CODE");
				if (transactionCode == "21")
					feeReasonCodeExpected = resultSet
							.getString("FEE_REASON_CODE");
			}

			if (transactionCodeExpected.equals(transactionCode))
				count++;
			if (feeReasonCodeExpected.equals(feeReasonCode)
					&& transactionCode == "21")
				count++;
			if (accountHeadExpected.equals(accountHead))
				count++;
		} catch (SQLException e) {
			logger.error("SQL Exception", e);
		}

	}

	public String countTotalEntries() {
		String entries = "";
		if (isElementPresent(totalCountOfEntires)) {
			String entry[] = totalCountOfEntires.getElements().get(0).getText()
					.split(" ");
			entries = entry[entry.length - 1];
		} else {
			List<WebElement> noOfRows = getFinder().getWebDriver()
					.findElements(By.xpath("//*[@class='dataview']//tbody/tr"));
			entries = String.valueOf(noOfRows.size());
		}
		return entries;
	}

	public void retryAddAccountHeadMapping(String accountHead) {
		switchToAddAccountHeadMapping();
		waitForElementVisible(transactionCode);
		MapUtils.fnSetInputDataToInputMap("Account Head", accountHead);
		List<String> transactionCodeElements = CustomUtils
				.getAllOptionsOfDropDown(transactionCode);

		if (transactionCodeElements.contains("Card fees [21]"))
			transactionCodeElements.remove("Card fees [21]");

		if (transactionCodeElements.contains("Select One"))
			transactionCodeElements.remove("Select One");

		try {
			for (String option : transactionCodeElements) {
				Select select = new Select(
						getFinder()
								.getWebDriver()
								.findElement(
										By.name("transactionCode:input:dropdowncomponent")));
				select.selectByVisibleText(option);
				selectDropDownByText(this.accountHead, accountHead);
				saveBtn.click();

				if (!isElementPresent(getErrorMessageText())) {
					MapUtils.fnSetInputDataToInputMap("Transaction Code",
							option);
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		getFinder().getWebDriver().switchTo().defaultContent();
	}

	public void retryAddAccountHeadMappingCardFees(String accountHead) {
		switchToAddAccountHeadMapping();
		selectDropDownByText(this.transactionCode, cardFees);
		MapUtils.fnSetInputDataToInputMap("Transaction Code", cardFees);
		selectDropDownByText(this.accountHead, accountHead);
		MapUtils.fnSetInputDataToInputMap("Account Head", accountHead);
		waitForElementVisible(feeReasonCode);
		if (feeReasonCode.isEnabled()) {
			List<String> feeReasonCodeElements = CustomUtils
					.getAllOptionsOfDropDown(feeReasonCode);

			for (String option : feeReasonCodeElements) {
				Select select = new Select(
						getFinder()
								.getWebDriver()
								.findElement(
										By.name("feeReasonCode:input:dropdowncomponent")));
				select.selectByVisibleText(option);
				saveBtn.click();
				if (!isElementPresent(getErrorMessageText())) {
					MapUtils.fnSetInputDataToInputMap("Fee Reason Code", option);
					break;
				}
			}
		}
		getFinder().getWebDriver().switchTo().defaultContent();
	}

}
