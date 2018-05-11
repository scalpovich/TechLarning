package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.MCWebElements;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

// TODO: Auto-generated Javadoc
/**
 * The Class AccountMasterPage.
 */
@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2HOST_ACCOUNTING, CardManagementNav.L3ACCOUNT_MASTER })
public class AccountMasterPage extends AbstractBasePage {
	// Card Management > Institution Parameter Setup > Host Accounting > Account
	// Master [ISSHA2]

	/** The logger. */
	final Logger logger = LoggerFactory.getLogger(AccountMasterPage.class);

	/** The interchange. */
	@PageElement(findBy = FindBy.NAME, valueToFind = "networkCode:input:dropdowncomponent")
	private MCWebElement interchange;

	/** The program code. */
	@PageElement(findBy = FindBy.NAME, valueToFind = "programCode:input:dropdowncomponent")
	private MCWebElement programCode;

	/** The account head. */
	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionCode:input:dropdowncomponent")
	private MCWebElement accountHead;

	/** The branch. */
	@PageElement(findBy = FindBy.NAME, valueToFind = "branchCode:input:dropdowncomponent")
	private MCWebElement branch;

	/** The host account number. */
	@PageElement(findBy = FindBy.NAME, valueToFind = "hostAccountNumber:input:inputTextField")
	private MCWebElement hostAccountNumber;

	/** The report code. */
	@PageElement(findBy = FindBy.NAME, valueToFind = "reportCode:input:inputTextField")
	private MCWebElement reportCode;

	/** The description. */
	@PageElement(findBy = FindBy.NAME, valueToFind = "description:input:inputTextField")
	private MCWebElement description;

	/** The save button */
	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

	/** The cancel button. */
	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement cancel;

	/** The add account master button. */
	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addAccountMasterBtn;

	/** The error message text. */
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class='feedbackPanelERROR']")
	private MCWebElements errorMessageText;

	/** The account head label. */
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[text()='Account Head'][@class='displayName wrap-search']")
	private MCWebElement accountHeadLabel;

	/** The info panel. */
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[contains(text(),'Successfully')]")
	private MCWebElement infoPanel;

	/** The account head search. */
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement accountHeadSearch;

	/** The search button. */
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:searchButtonPanel:buttonCol:searchButton")
	private MCWebElement searchBtn;

	/** The first row edit button. */
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[.='Edit']/../../../following::tbody//img")
	private MCWebElement firstRowEditBtn;

	/** The interchange edit. */
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='networkCode']/span")
	private MCWebElement interchangeEdit;

	/** The program code edit. */
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@class='displayName']/span[contains(text(),'Program')]//following::td/span/span[text()='-']")
	private MCWebElement programCodeEdit;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement searchInterchange;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement searchAccountHead;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement searchProductDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:buttonPanel:buttonCol:searchButton")
	private MCWebElement searchProgramBtn;

	/**
	 * Gets the adds the account master.
	 *
	 * @return the adds the account master
	 */
	public MCWebElement getAddAccountMaster() {
		return addAccountMasterBtn;
	}

	/**
	 * Gets the cancel.
	 *
	 * @return the cancel
	 */
	public MCWebElement getCancel() {
		return cancel;
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
	 * Gets the error message text.
	 *
	 * @return the error message text
	 */
	public MCWebElements getErrorMessageText() {
		return errorMessageText;
	}

	/**
	 * Gets the info panel.
	 *
	 * @return the info panel
	 */
	public MCWebElement getInfoPanel() {
		return infoPanel;
	}

	public void addRandomAccountMaster() {
		SelectDropDownByText(this.interchange,
				MapUtils.fnGetInputDataFromMap("Interchange"));
		SimulatorUtilities.wait(500);
		if (!MapUtils.fnGetInputDataFromMap("Program").equalsIgnoreCase("-")) {
			waitForElementVisible(this.programCode);
			List<String> programCodeList = CustomUtils
					.getAllOptionsOfDropDown(this.programCode);
			CustomUtils.ThreadDotSleep(2000);
			waitForElementVisible(programCode);
			if (programCodeList.size() > 0) {
				SelectDropDownByText(this.programCode, programCodeList.get(1));
				MapUtils.fnSetInputDataToInputMap("Program",
						programCodeList.get(1));
			} else {
				logger.error("The chosen interchange does not have any Programs attached. Please chose another Interchange");
			}
		}
		SelectDropDownByText(this.accountHead,
				MapUtils.fnGetInputDataFromMap("Account Head"));
		enterText(this.description,
				MapUtils.fnGetInputDataFromMap("Description"));
		enterText(this.hostAccountNumber,
				MapUtils.fnGetInputDataFromMap("AccountNumber"));
		enterText(this.reportCode, MapUtils.fnGetInputDataFromMap("ReportCode"));
		saveAccountMaster();
		getFinder().getWebDriver().switchTo().defaultContent();
	}

	public void addDuplicateAccountMaster() {
		SelectDropDownByText(this.interchange,
				MapUtils.fnGetInputDataFromMap("Interchange"));
		if (!MapUtils.fnGetInputDataFromMap("Program").equals("-"))
			SelectDropDownByText(this.programCode,
					MapUtils.fnGetInputDataFromMap("Program"));
		SelectDropDownByText(this.accountHead,
				MapUtils.fnGetInputDataFromMap("Account Head"));
		enterText(this.description,
				MapUtils.fnGetInputDataFromMap("Description"));
		enterText(this.hostAccountNumber,
				MapUtils.fnGetInputDataFromMap("AccountNumber"));
		enterText(this.reportCode, MapUtils.fnGetInputDataFromMap("ReportCode"));
		saveAccountMaster();
	}

	/**
	 * Click add account master.
	 */
	public void clickAddAccountMaster() {
		waitForElementVisible(addAccountMasterBtn);
		addAccountMasterBtn.click();
	}

	/**
	 * Switch to add account master frame.
	 */
	public void switchToAddAccountMasterFrame() {
		switchToIframe(Constants.ADD_ACCOUNT_MASTER_FRAME);
	}

	/**
	 * Adds the program code to account master.
	 *
	 * @param programCode
	 *            the program code
	 */
	public void addProgramCodeToAccountMaster(String programCode) {
		int programC = Integer.parseInt(programCode);
		SelectDropDownByIndex(this.programCode, programC);
	}

	/**
	 * Save account master.
	 */
	public void saveAccountMaster() {
		save.click();
	}

	/**
	 * Gets the list of debit codes in program code field.
	 *
	 * @return the list of debit codes in program code field
	 */
	// Returns the program codes available in the Program Code dropdown
	public List<String> getListOfDebitCodesInProgramCodeField() {
		List<String> programCodes = new ArrayList<String>();

		// Read the Program Code
		switchToIframe(Constants.ADD_ACCOUNT_MASTER_FRAME);
		waitForElementVisible(this.interchange);

		for (String networkCode : CustomUtils
				.getAllOptionsOfDropDown(this.interchange)) {
			waitForElementVisible(this.interchange);
			CustomUtils.ThreadDotSleep(300);
			SelectDropDownByText(this.interchange, networkCode);
			waitForElementVisible(this.programCode);
			List<String> dropdownList = CustomUtils
					.getAllOptionsOfDropDown(this.programCode);
			if (!dropdownList.isEmpty()) {
				for (int i = 1; i < dropdownList.size(); i++) {
					programCodes.add(dropdownList.get(i));
				}
			}
		}
		return programCodes;
	}

	/**
	 * Verify label: Account Head.
	 *
	 * @return true, if successful
	 */
	public boolean verifyLabelAccountHead() {
		addAccountMasterBtn.click();
		return accountHeadLabel.getText().equals("Account Head");
	}

	/**
	 * Search account head on account master page.
	 *
	 * @param Account
	 *            Head to be searched
	 * 
	 */
	public void searchAccountHeadOnAccountMaster(String search) {
		SelectDropDownByText(accountHeadSearch, search);
		searchBtn.click();
	}

	/**
	 * Check non editable fields suspense account.
	 *
	 * @return true, if successful
	 */
	public boolean checkNonEditableFieldsSuspenseAccount() {
		waitForElementVisible(firstRowEditBtn);
		firstRowEditBtn.click();
		switchToIframe(Constants.EDIT_ACCOUNT_MASTER_FRAME);
		if (!"Select".equals(interchangeEdit.getTagName())
				&& !"Select".equals(programCodeEdit.getTagName()))
			return true;
		return false;
	}

	/**
	 * Gets the account head list from frame.
	 *
	 * @return the account head list from frame
	 */
	public List<String> getAccountHeadListFromFrame() {
		addAccountMasterBtn.click();
		switchToIframe(Constants.ADD_ACCOUNT_MASTER_FRAME);
		List<String> accountHeadList = CustomUtils
				.getAllOptionsOfDropDown(accountHead);
		return accountHeadList;
	}

	/**
	 * Verify newly added entry. Compares the newly added entry with the data in
	 * the XL file
	 * 
	 * @return true, if successful
	 */
	public boolean verifyNewlyAddedEntry() {
		// read the data from the header and first row and insert into the
		// map
		int count = 0;
		List<String> elementsList = new ArrayList<String>();
		List<String> headerElementsList = new ArrayList<String>();
		List<WebElement> elements = getFinder().getWebDriver().findElements(
				By.xpath("//table[@class='dataview']//tbody//tr[1]/td"));
		for (WebElement w : elements) {
			elementsList.add(w.getText());
		}

		List<WebElement> headerElements = getFinder()
				.getWebDriver()
				.findElements(By.xpath("//table[@class='dataview']//thead//th"));
		for (WebElement w : headerElements) {
			headerElementsList.add(w.getText());
		}

		HashMap<String, String> hashMap = new HashMap<String, String>();

		if (elements.size() == headerElements.size()) {
			for (int i = 0; i < elements.size() - 1; i++) {
				if (hashMap.containsKey(headerElementsList.get(i))) {
					hashMap.remove(headerElementsList.get(i));
					hashMap.put(headerElementsList.get(i), elementsList.get(i));
				} else {
					hashMap.put(headerElementsList.get(i), elementsList.get(i));
				}
			}
		} else {
			logger.error("The newly added entry is not saved into the system.");
		}

		// Comparing the elements of the map
		Iterator<String> setItr = hashMap.keySet().iterator();
		while (setItr.hasNext()) {
			String key = setItr.next();
			CustomUtils.ThreadDotSleep(250);
			if (hashMap.get(key).equals(MapUtils.fnGetInputDataFromMap(key))) {
				count++;
			}
		}
		if (count == hashMap.keySet().size())
			return true;
		return false;
	}

	/**
	 * Verify account head not visible.
	 *
	 * @return true, if successful
	 */
	public boolean verifyAccountHeadNotVisible() {
		// verify the account head is not seen on Account Master page
		waitForElementVisible(getAccountHeadSearch());
		List<String> accountHeadSearch = CustomUtils
				.getAllOptionsOfDropDown(getAccountHeadSearch());

		List<String> rowElements = new ArrayList<String>();
		List<WebElement> rowWebElements = getFinder()
				.getWebDriver()
				.findElements(
						By.xpath("//table[@class='dataview']//tbody/tr[@class='even']/td"));
		for (WebElement element : rowWebElements) {
			rowElements.add(element.getText());
		}
		for (String s : accountHeadSearch) {
			if (!s.equals(rowElements.get(1)))
				return true;
		}
		return false;
	}

	public void searchAccountMaster() {
		SelectDropDownByText(searchInterchange,
				MapUtils.fnGetInputDataFromMap("Interchange"));
		SelectDropDownByText(searchAccountHead,
				MapUtils.fnGetInputDataFromMap("Account Head"));
		searchBtn.click();
	}

	public void searchDebitProgram() {
		SelectDropDownByText(searchProductDdwn, "Debit [D]");
		searchProgramBtn.click();
	}

}
