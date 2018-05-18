package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.MCWebElements;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

// TODO: Auto-generated Javadoc
/**
 * The Class AccountHeadPage.
 */
@Component
public class AccountHeadPage extends AbstractBasePage {

	/** The logger. */
	final Logger logger = LoggerFactory.getLogger(AccountHeadPage.class);

	/** The account code. */
	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:1:cols:colspanMarkup:inputField:input:inputTextField")
	private MCWebElement accountCode;

	/** The account head. */
	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:2:cols:colspanMarkup:inputField:input:inputTextField")
	private MCWebElement accountHead;

	/** The status. */
	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:3:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement status;

	/** The save button. */
	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	/** The cancel button. */
	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement cancelBtn;

	/** The error message text. */
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class='feedbackPanelERROR']")
	private MCWebElements errorMessageText;

	/** The add account head icon */
	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addAccountHead;

	/** The account head edit button. */
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//img[@alt='Edit Record'][position()=1]")
	private MCWebElement accountHeadEditBtn;

	/** The message shown on saving an entry */
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class='feedbackPanelINFO']")
	private MCWebElements infoSuccess;

	/** The account head edit frame. */
	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:2:cols:colspanMarkup:inputField:input:inputTextField")
	private MCWebElement accountHeadEditFrame;

	/** The account status table cell. */
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//tr[@class='even']/td/span[contains(text(),'ctive')]")
	private MCWebElement accountStatustableCell;

	/** The first row of the table. */
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//tbody/tr[@class='even']/td")
	private MCWebElement firstRow;

	/** The search button. */
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:buttonPanel:buttonCol:searchButton")
	private MCWebElement searchBtn;

	/** The account head search option */
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:inputTextField")
	private MCWebElement accountHeadSearch;

	/** The account code search option */
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:inputTextField")
	private MCWebElement accountCodeSearch;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[contains(text(),'No Records')]")
	private MCWebElements noRecordsFound;

	public static String accountCod = null;
	private String suspenseAccountCode = "00";

	public String errorPanel = "//span[@class='feedbackPanelERROR']";

	/**
	 * Gets the error message text.
	 *
	 * @return the error message text
	 */
	public MCWebElements getErrorMessageText() {
		return errorMessageText;
	}

	public MCWebElements getNoRecordsFound() {
		return noRecordsFound;
	}

	public List<WebElement> getErrorMessageText1() {
		return getFinder().getWebDriver().findElements(By.xpath(errorPanel));

	}

	public MCWebElement getFirstRow() {
		return firstRow;
	}

	public MCWebElements getInfoSuccess() {
		return infoSuccess;
	}

	public MCWebElement getCancelBtn() {
		return cancelBtn;
	}

	public MCWebElement getAddAccountHead() {
		return addAccountHead;
	}

	public void switchToAddAccountHeadFrame() {
		switchToIframe(Constants.ADD_ACCOUNT_HEAD_FRAME);
	}

	/**
	 * Adds the account head.
	 *
	 * @param accountCode
	 *            , accountHead and Status
	 * 
	 */

	public void addRandomAccountHead() {
		String accountCode = CustomUtils.randomAlphaNumeric(2).toUpperCase();
		enterText(this.accountCode, accountCode);
		enterText(this.accountHead,
				MapUtils.fnGetInputDataFromMap("Account Head"));
		selectDropDownByText(this.status,
				MapUtils.fnGetInputDataFromMap("Status"));
		saveBtn.click();
		MapUtils.fnSetInputDataToInputMap("Account Code", accountCode);
	}

	public void addAccountHead(String accountCode, String accountHead,
			String status) {
		getFinder().getWebDriver().switchTo().defaultContent();
		addAccountHead.click();
		switchToAddAccountHeadFrame();
		enterText(this.accountCode, accountCode);
		enterText(this.accountHead, accountHead);
		selectDropDownByText(this.status, status);
		saveBtn.click();

	}

	/**
	 * Searches an account head.
	 *
	 * @param accountHead
	 * 
	 */
	public void searchAccountHead(String accountCode) {
		CustomUtils.ThreadDotSleep(500);
		getFinder().getWebDriver().switchTo().defaultContent();
		CustomUtils.ThreadDotSleep(500);
		waitForElementVisible(accountCodeSearch);
		enterText(accountCodeSearch, accountCode);
		searchBtn.click();
	}

	/**
	 * Edits the suspense account head.
	 */
	public void editSuspenseAccountHead() {
		waitForElementVisible(accountHeadEditBtn);
		accountHeadEditBtn.click();
		switchToIframe(Constants.EDIT_ACCOUNT_HEAD_FRAME);
		waitForElementVisible(this.status);
		enterText(accountHeadEditFrame,
				MapUtils.fnGetInputDataFromMap("Account Head"));
		saveBtn.click();
	}

	public void addSuspenseAccount() {
		getAddAccountHead().click();
		switchToAddAccountHeadFrame();
		enterText(accountCode, suspenseAccountCode);
		enterText(accountHead, MapUtils.fnGetInputDataFromMap("Account Head"));
		selectDropDownByText(status, MapUtils.fnGetInputDataFromMap("Status"));
		saveBtn.click();
		getFinder().getWebDriver().switchTo().defaultContent();
	}

	/**
	 * Returns the account code by combining the Account Head and Account code
	 *
	 * e. g.
	 * 
	 * Account Code = 02; Account Head: INSERTION_MODIFIED
	 * 
	 * Returns: INSERTION_MODIFIED [02]
	 * 
	 * @return the account code
	 */
	public String getAccountHead() {
		waitForElementVisible(accountCodeSearch);
		List<String> rowElements = new ArrayList<String>();
		CustomUtils.ThreadDotSleep(2000);
		List<WebElement> rowWebElements = getFinder()
				.getWebDriver()
				.findElements(
						By.xpath("//table[@class='dataview']//tbody/tr[@class='even']/td"));
		CustomUtils.ThreadDotSleep(2000);
		for (WebElement element : rowWebElements) {
			rowElements.add(element.getText());
		}
		CustomUtils.ThreadDotSleep(2000);
		return rowElements.get(1) + " [" + rowElements.get(0) + "]";
	}

	/**
	 * Sets the status of the Account Head to - Inactive [I]
	 */
	public void deactivateAccountHead(String status) {
		waitForElementVisible(accountStatustableCell);
		if (!status.equals(accountStatustableCell.getText())) {
			waitForElementVisible(accountHeadEditBtn);
			accountHeadEditBtn.click();

			switchToIframe(Constants.EDIT_ACCOUNT_HEAD_FRAME);
			waitForElementVisible(this.status);
			selectDropDownByText(this.status, status);
			waitForElementVisible(saveBtn);
			saveBtn.click();
		} else {
			logger.error("The account is already de-activated.");
		}
	}

}
