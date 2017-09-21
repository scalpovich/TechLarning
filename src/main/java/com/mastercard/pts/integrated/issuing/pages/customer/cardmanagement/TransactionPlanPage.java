package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionPlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP,
		CardManagementNav.L2_TRANSACTION_PLAN })
public class TransactionPlanPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(TransactionPlanPage.class);
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=transactionSetCode]")
	private MCWebElement planCodeSearchTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#transactionSetCode input")
	private MCWebElement planCodeTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#transactionSetDesc input")
	private MCWebElement transactionSetDescTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#productType select")
	private MCWebElement productTypeDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "select[name^=planPalette]")
	private MCWebElement availableTransactionsLstBx;

	@PageElement(findBy = FindBy.CSS, valueToFind = "button.add")
	private MCWebElement addTransactionsBtn;


	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addTransactionPlan;

	@PageElement(findBy = FindBy.NAME, valueToFind = "productType:input:dropdowncomponent")
	private MCWebElement ProductType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionSetCode:input:inputTextField")
	private MCWebElement TransactionPlanCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionSetDesc:input:inputTextField")
	private MCWebElement Description;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "/html/body/div[2]/div/div/form/table[1]/tbody/tr[7]/td/span/table/tbody/tr[2]/td[1]/select/option[1]")
	private MCWebElement TransactionSelected1;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "/html/body/div[2]/div/div/form/table[1]/tbody/tr[7]/td/span/table/tbody/tr[2]/td[1]/select/option[2]")
	private MCWebElement TransactionSelected2;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "/html/body/div[2]/div/div/form/table[1]/tbody/tr[7]/td/span/table/tbody/tr[2]/td[1]/select/option[3]")
	private MCWebElement TransactionSelected3;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "/html/body/div[2]/div/div/form/table[1]/tbody/tr[7]/td/span/table/tbody/tr[2]/td[1]/select/option[4]")
	private MCWebElement TransactionSelected4;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "/html/body/div[2]/div/div/form/table[1]/tbody/tr[7]/td/span/table/tbody/tr[2]/td[1]/select/option[5]")
	private MCWebElement TransactionSelected5;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "button add")
	private MCWebElement moveToRight;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

	public void clickaddTransactionPlan() {
		waitForElementVisible(addTransactionPlan);
		addTransactionPlan.click();
	}

	public void switchToAddTransactionPlanFrame() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_TRANSACTION_PLAN_FRAME);
	}

	public String enterTransactionPlanCode() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(TransactionPlanCode, CustomUtils.randomNumbers(6));
		return TransactionPlanCode.getAttribute("value");
	}

	public String enterTransactionDescription() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(Description, "transaction plan");
		return Description.getAttribute("value");
	}

	public void selectProduct(DeviceCreation deviceCreation) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectByVisibleText(ProductType, deviceCreation.getProduct());

	}

	public void clickTransaction() {
		WebElement transaction = getFinder().getWebDriver().findElement(
				By.xpath("//select[@class='choicesSelect']/option[contains(text(),'" + getTransactionType() + "')]"));
		transaction.click();
		moveToRight.click();
	}

	public void clickSaveButton() {
		waitForElementVisible(save);
		CustomUtils.ThreadDotSleep(1000);
		ClickButton(save);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SwitchToDefaultFrame();
	}

	public void addtransactionplan(String product) {
		addTransactionPlan.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_TRANSACTION_PLAN_FRAME);
		enterText(TransactionPlanCode, CustomUtils.randomNumbers(6));
		enterText(Description, "transaction plan");
		SelectDropDownByText(ProductType, product);
		addWicketAjaxListeners(getFinder().getWebDriver());
		TransactionSelected1.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		moveToRight.click();
		ClickButton(save);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SwitchToDefaultFrame();
	}

	public void addtransactionplanprepaid() {
		addTransactionPlan.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");

		// TransactionPlanCode.sendKeys(env.getProperty("is.dinners.transactionplan.TransactionPlanCode"));
		TransactionPlanCode.sendKeys(CustomUtils.randomNumbers(6));
		CustomUtils.ThreadDotSleep(1000);
		Description.sendKeys(env.getProperty("is.dinners.transactionplanpr.Description"));
		ProductType.getSelect().selectByVisibleText(env.getProperty("is.dinners.transactionplanpr.ProductType"));
		CustomUtils.ThreadDotSleep(1000);

		TransactionSelected1.click();
		CustomUtils.ThreadDotSleep(1000);
		moveToRight.click();
		CustomUtils.ThreadDotSleep(1000);

		save.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().defaultContent();

	}
	public void verifyUiOperationStatus() {
		logger.info("Transaction Plan");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(planCodeSearchTxt));
	}
	public void createTransactionPlan(TransactionPlan plan) {
		logger.info("Create Transaction Plan {}", plan.getTransactionPlanCode());
		clickAddNewButton();

		runWithinPopup(
				"Add Transaction Plan",
				() -> {
					WebElementUtils.enterText(planCodeTxt, plan.getTransactionPlanCode());
					WebElementUtils.enterText(transactionSetDescTxt, plan.getDescription());
					WebElementUtils.selectDropDownByVisibleText( productTypeDDwn, plan.getProductType());

					if (plan.isAllTransactionsAssigned()) {
						WebElementUtils .selectAllOptionsInListBox(availableTransactionsLstBx);
					} else {
						WebElementUtils.selectListBoxByVisibleText( availableTransactionsLstBx, plan.getAssignedTransactions());
					}

					addTransactionsBtn.click();

					clickSaveButton();

					verifyNoErrors();
				});

		verifyOperationStatus();
	}

}
