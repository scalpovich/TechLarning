package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionPlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP,
		CardManagementNav.L2_TRANSACTION_PLAN })
public class TransactionPlanPage extends AbstractModelPage {

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
					WebElementUtils.enterText(planCodeTxt,
							plan.getTransactionPlanCode());
					WebElementUtils.enterText(transactionSetDescTxt,
							plan.getDescription());
					WebElementUtils.selectDropDownByVisibleText(
							productTypeDDwn, plan.getProductType());

					if (plan.isAllTransactionsAssigned()) {
						WebElementUtils
								.selectAllOptionsInListBox(availableTransactionsLstBx);
					} else {
						WebElementUtils.selectListBoxByVisibleText(
								availableTransactionsLstBx,
								plan.getAssignedTransactions());
					}

					addTransactionsBtn.click();

					clickSaveButton();

					verifyNoErrors();
				});

		verifyOperationStatus();
	}

}
