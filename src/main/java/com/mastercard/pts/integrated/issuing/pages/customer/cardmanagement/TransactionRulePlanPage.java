package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP,
		CardManagementNav.L2_CREDIT_CARD_BILLING,
		CardManagementNav.L3_TRANSACTION_RULE_PLAN})
public class TransactionRulePlanPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(TransactionRulePlanPage.class);

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addTransactionRulePlan;
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=planCode]")
	private MCWebElement planCode;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=planName]")
	private MCWebElement planName;
	@PageElement(findBy = FindBy.NAME, valueToFind = "planCode:input:inputTextField")
	private MCWebElement TransactionRulePlanCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "planName:input:inputTextField")
	private MCWebElement Description;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;	
	public void verifyUiOperationStatus() {
		logger.info("Transaction Rules Plan");
		verifyUiOperation("Add Transaction Rules Plan");
	}
	public void addtransactionruleplan() {
		addTransactionRulePlan.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");

		// TransactionRulePlanCode.sendKeys(env.getProperty("is.dinners.transactionruleplan.TransactionRulePlanCode"));
		TransactionRulePlanCode.sendKeys(CustomUtils.randomNumbers(3));
		CustomUtils.ThreadDotSleep(2000);
		Description.sendKeys(env.getProperty("is.dinners.transactionruleplan.Description"));
		CustomUtils.ThreadDotSleep(2000);

		save.click();
		CustomUtils.ThreadDotSleep(2000);
		save.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().defaultContent();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(planCode),
				WebElementUtils.elementToBeClickable(planName)
				);
	}
}
