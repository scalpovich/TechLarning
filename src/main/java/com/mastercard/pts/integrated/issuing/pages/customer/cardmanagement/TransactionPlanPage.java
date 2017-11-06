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
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1PROGRAM_SETUP,
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
	private MCWebElement addTransactionPlanBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "productType:input:dropdowncomponent")
	private MCWebElement ProductTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionSetCode:input:inputTextField")
	private MCWebElement TransactionPlanCodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionSetDesc:input:inputTextField")
	private MCWebElement DescriptionTxt;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "button add")
	private MCWebElement moveToRightBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement CancelBtn;

	public void verifyUiOperationStatus() {
		logger.info("Transaction Plan");
		verifySearchButton("Search");
	}

	public void clickaddTransactionPlan() {
		clickWhenClickable(addTransactionPlanBtn);
		switchToAddTransactionPlanFrame();

	}
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(planCodeSearchTxt));
	}

	public void switchToAddTransactionPlanFrame() {
		switchToIframe(Constants.ADD_TRANSACTION_PLAN_FRAME);
	}

	public String enterTransactionPlanCode() {
		enterValueinTextBox(TransactionPlanCodeTxt, CustomUtils.randomNumbers(6));
		return TransactionPlanCodeTxt.getAttribute("value");
	}

	public String enterTransactionDescription() {
		enterValueinTextBox(DescriptionTxt, "transaction plan");
		return DescriptionTxt.getAttribute("value");
	}

	public void selectProduct(DeviceCreation deviceCreation) {
		selectByVisibleText(ProductTypeDDwn, deviceCreation.getProduct());

	}

	public String addTransactionPlan(DeviceCreation deviceCreation) {
		String TransactionPlanCode;
		String TransactionPlanDesc;
		TransactionPlanCode = enterTransactionPlanCode();
		TransactionPlanDesc = enterTransactionDescription();
		selectProduct(deviceCreation);
		return TransactionPlanDesc + " " + "[" + TransactionPlanCode + "]";
	}

	public void clickTransaction(TransactionPlan transactionplan) {
		WebElement transaction = getFinder().getWebDriver()
				.findElement(By.xpath("//select[@class='choicesSelect']/option[contains(text(),'"
						+ transactionplan.getTransactionType() + "')]"));
		transaction.click();
		moveToRightBtn.click();
	}

	public void clickSaveButton() {
		clickWhenClickable(saveBtn);
	}

	public boolean verifyErrorsOnTransactionPlanPage() {
		return publishErrorOnPage();
	}

	public void verifyTransactionPlanSuccess() {
		if (!verifyErrorsOnTransactionPlanPage()) {
			logger.info("Transactionplan Added Successfully");
			SwitchToDefaultFrame();
		} else {
			logger.info("Error in Record Addition");
			clickWhenClickable(CancelBtn);
			SwitchToDefaultFrame();
		}
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
