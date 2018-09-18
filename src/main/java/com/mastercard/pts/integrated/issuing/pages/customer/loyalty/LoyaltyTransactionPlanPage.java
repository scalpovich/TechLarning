package com.mastercard.pts.integrated.issuing.pages.customer.loyalty;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.LoyaltyPlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = LoyaltyNav.TAB_LOYALTY, treeMenuItems = { LoyaltyNav.L1_LOYALTY_SETUP,
		LoyaltyNav.L2_LOYALTY_TRANSACTION_PLAN })
public class LoyaltyTransactionPlanPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(LoyaltyTransactionPlanPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:inputTextField")
	private MCWebElement transactionPlanCodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:buttonPanel:buttonCol:searchButton")
	private MCWebElement searchBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@alt='Edit Record']")
	private MCWebElement editBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "select[name^=planPalette]")
	private MCWebElement availableTransactionsLstBx;

	@PageElement(findBy = FindBy.CSS, valueToFind = "button.add")
	private MCWebElement addTransactionsBtn;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addTransactionPlanBtn;

	public void searchLoyaltyTransactionPlan(LoyaltyPlan loyaltyplan) {
		WebElementUtils.enterText(transactionPlanCodeTxt, loyaltyplan.getLoyaltyTransactionPlan());
		clickSearchButton();
		SimulatorUtilities.wait(5000);
		editBtn.click();
		runWithinPopup("Edit Loyalty Transaction Plan", () -> {
			WebElementUtils.selectAllOptionsInListBox(availableTransactionsLstBx);
			addTransactionsBtn.click();
			clickSaveButton();
			verifyNoErrors();
		});

	}

	public void verifyUiOperationStatus() {
		logger.info("Event Based Loyalty Points ");
		verifyUiOperation("Add Loyalty Transaction Plan");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(transactionPlanCodeTxt));
	}
}
