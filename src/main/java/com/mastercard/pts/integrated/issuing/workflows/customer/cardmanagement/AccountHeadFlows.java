package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.MenuSubMenuPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.AccountHeadMappingPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.AccountHeadPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.AccountMasterPage;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

// TODO: Auto-generated Javadoc
/**
 * The Class AccountHeadFlows.
 */
@Component
public class AccountHeadFlows extends MenuFlows {

	final Logger logger = LoggerFactory.getLogger(AccountHeadFlows.class);

	@Autowired
	MenuSubMenuPage menuSubMenuPage;

	@Autowired
	AccountHeadPage accountHeadPage;

	@Autowired
	AccountMasterPage accountMasterPage;

	@Autowired
	AccountMasterFlows accountMasterFlows;

	@Autowired
	AccountHeadMappingFlows accountHeadMappingFlows;

	@Autowired
	AccountHeadMappingPage accountHeadMappingPage;

	private String suspenseAccount;
	private static String status = "Inactive [I]";

	/**
	 * Navigate account head page.
	 */
	public void navigateAccountHeadPage() {
		waitForElementVisible(menuSubMenuPage.getCardManagement());
		clickMenuSubOption(menuSubMenuPage.getInstitutionParameterSetup(),
				menuSubMenuPage.getHostAccounting());
		menuSubMenuPage.getAccountHead().click();
	}

	/**
	 * Adds the new account head.
	 */
	public void addNewAccountHead() {
		accountHeadPage.getAddAccountHead().click();
		accountHeadPage.switchToAddAccountHeadFrame();
		try {
			for (int i = 0; i < 5; i++) {
				accountHeadPage.addRandomAccountHead();
				if (!isElementPresent(accountHeadPage.getErrorMessageText()))
					break;
			}
			getFinder().getWebDriver().switchTo().defaultContent();
		} catch (Exception e) {
			logger.error("The Account head is added in the first attempt");
		}
	}

	/**
	 * Retry adding an account head
	 */
	public void retryAddAccountHead() {
		if (accountHeadPage.getCancelBtn().isVisible())
			accountHeadPage.getCancelBtn().click();
		accountHeadPage.addRandomAccountHead();
	}

	/**
	 * Adds a duplicate account head.
	 */
	public void addingDuplicateAccountHead() {
		accountHeadPage.getAddAccountHead().click();
		accountHeadPage.switchToAddAccountHeadFrame();
		accountHeadPage.addRandomAccountHead();
		String accountCode = MapUtils.fnGetInputDataFromMap("Account Code");
		CustomUtils.ThreadDotSleep(4000);
		accountHeadPage.addAccountHead(accountCode,
				MapUtils.fnGetInputDataFromMap("Account Head"),
				MapUtils.fnGetInputDataFromMap("Status"));
	}

	/**
	 * Search suspense account(Account Code - 00) on account head.
	 */
	public void searchSuspenseAccountOnAccountHead() {
		accountHeadPage.searchAccountHead("00");
		try {
			if (isElementPresent(accountHeadPage.getNoRecordsFound())) {
				accountHeadPage.addSuspenseAccount();
			}
		} catch (Exception e) {
			logger.info("Suspense Account is present in the system");
		}
	}

	/**
	 * Search suspense account on account master flow.
	 */
	public void searchSuspenseAccountOnAccountMasterFlow() {
		searchSuspenseAccountOnAccountHead();
		suspenseAccount = accountHeadPage.getAccountHead();
		accountMasterFlows.navigateAccountMasterPage();
		accountMasterPage.searchAccountHeadOnAccountMaster(suspenseAccount);
	}

	/**
	 * Search suspense account on account head mapping flow.
	 */
	public void searchSuspenseAccountOnAccountHeadMappingFlow() {
		searchSuspenseAccountOnAccountHead();
		suspenseAccount = accountHeadPage.getAccountHead();
		accountHeadMappingFlows.navigateAccountHeadMappingPage();
		accountHeadMappingPage
				.searchAccountHeadOnAccountHeadMapping(suspenseAccount);
	}

	/**
	 * Verify non editable fields suspense account.
	 *
	 * @return true, if successful
	 */
	public boolean verifyNonEditableFieldsSuspenseAccount() {
		return accountMasterPage.checkNonEditableFieldsSuspenseAccount();
	}

	/**
	 * Verify suspense account on account master.
	 *
	 * @return true, if successful
	 */
	public boolean verifySuspenseAccountOnAccountMaster() {
		boolean isAccPresent1 = false;
		boolean isAccPresent2 = false;
		for (String accHead : CustomUtils
				.getAllOptionsOfDropDown(accountMasterPage
						.getAccountHeadSearch())) {
			if (accHead.equals(suspenseAccount))
				isAccPresent1 = true;
		}
		for (String accHead : accountMasterPage.getAccountHeadListFromFrame()) {
			if (!accHead.equals(suspenseAccount))
				isAccPresent2 = true;
		}
		if (isAccPresent1 && isAccPresent2)
			return true;
		return false;
	}

	/**
	 * Verify suspense account on account head mapping.
	 *
	 * @return true, if successful
	 */
	public boolean verifySuspenseAccountOnAccountHeadMapping() {
		boolean isAccPresent1 = false;
		boolean isAccPresent2 = false;
		for (String accHead : CustomUtils
				.getAllOptionsOfDropDown(accountHeadMappingPage
						.getAccountHeadSearch())) {
			if (accHead.equals(suspenseAccount))
				isAccPresent1 = true;
		}
		for (String accHead : accountHeadMappingPage
				.getAccountHeadListFromFrame()) {
			if (!accHead.equals(suspenseAccount))
				isAccPresent2 = true;
		}
		if (isAccPresent1 && isAccPresent2)
			return true;
		return false;
	}

	/**
	 * Verify suspense account not deactivated.
	 *
	 * @return true, if successful
	 */
	public boolean verifySuspenseAccountNotDeactivated() {
		accountHeadPage.deactivateAccountHead(status);
		return verifyErrorMessage1();
	}

	/**
	 * Verify error message.
	 *
	 * @return true, if successful
	 */
	public boolean verifyErrorMessage1() {
		return CustomUtils.checkErrorMessage(
				MapUtils.fnGetInputDataFromMap("ErrorMessage"),
				accountHeadPage.getErrorMessageText());
	}

	/**
	 * Verify account head saved.
	 *
	 * @return true, if successful
	 */
	public boolean verifyAccountHeadSaved() {
		accountHeadPage.searchAccountHead(MapUtils
				.fnGetInputDataFromMap("Account Code"));
		return accountMasterPage.verifyNewlyAddedEntry();
	}

	/**
	 * Verify account head not visible on account master.
	 *
	 * @return true, if successful
	 */
	public boolean verifyAccountHeadNotVisibleOnAccountMaster() {
		accountMasterFlows.navigateAccountMasterPage();
		return accountMasterPage.verifyAccountHeadNotVisible();
	}

	/**
	 * Verify edit suspense account.
	 *
	 * @return true, if successful
	 */
	public boolean verifyEditSuspenseAccount() {
		accountHeadPage.editSuspenseAccountHead();
		getFinder().getWebDriver().switchTo().defaultContent();
		List<String> rowElements = new ArrayList<String>();
		List<WebElement> rowWebElements = getFinder()
				.getWebDriver()
				.findElements(
						By.xpath("//table[@class='dataview']//tbody/tr[@class='even']/td"));
		for (WebElement element : rowWebElements) {
			rowElements.add(element.getText());
		}
		waitForElementVisible(accountHeadPage.getFirstRow());
		if (rowElements.get(1).equals(
				MapUtils.fnGetInputDataFromMap("Account Head")))
			return true;
		return false;
	}

	/**
	 * Deactivate account head flow.
	 */
	public void deactivateAccountHeadFlow() {
		// Search for account head
		getFinder().getWebDriver().switchTo().defaultContent();
		accountHeadPage.searchAccountHead(MapUtils
				.fnGetInputDataFromMap("Account Code"));
		accountHeadPage.deactivateAccountHead("Inactive [I]");
	}

	public void savesAccountHeadFlow() {
		accountHeadMappingFlows.savesAccountHead();
	}

}