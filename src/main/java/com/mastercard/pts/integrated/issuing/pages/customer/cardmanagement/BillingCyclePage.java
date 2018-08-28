package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP,
		CardManagementNav.L2_CREDIT_CARD_BILLING,
		CardManagementNav.L3_BILLING_CYCLE})
public class BillingCyclePage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(BillingCyclePage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=cycleCode]")
	private MCWebElement cycleCode;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=cycleWording]")
	private MCWebElement cycleWording;
	
	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addBillingCycle;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cycleCode:input:inputTextField")
	private MCWebElement BillingPlanCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cycleWording:input:inputTextField")
	private MCWebElement Description;

	@PageElement(findBy = FindBy.NAME, valueToFind = "accClosDay:input:inputTextField")
	private MCWebElement BillingCyclePerDay;

	@PageElement(findBy = FindBy.NAME, valueToFind = "recProcCount:input:inputTextField")
	private MCWebElement RecordsPerBatchForProcessing;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

	public void addbillingcycle() {
		addBillingCycle.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");

		// BillingPlanCode.sendKeys(env.getProperty("is.dinners.billingcycle.BillingPlanCode"));
		BillingPlanCode.sendKeys(CustomUtils.randomNumbers(3));
		CustomUtils.ThreadDotSleep(1000);
		Description.sendKeys(env
				.getProperty("is.dinners.billingcycle.Description"));
		CustomUtils.ThreadDotSleep(1000);
		BillingCyclePerDay.sendKeys(env
				.getProperty("is.dinners.billingcycle.BillingCyclePerDay"));
		CustomUtils.ThreadDotSleep(1000);
		RecordsPerBatchForProcessing
				.sendKeys(env
						.getProperty("is.dinners.billingcycle.RecordsPerBatchForProcessing"));
		CustomUtils.ThreadDotSleep(1000);

		save.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().defaultContent();
	}

	public void verifyUiOperationStatus() {
		logger.info("Billing Cycle");
		verifyUiOperation("Add Billing Cycle");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(cycleCode),
				WebElementUtils.elementToBeClickable(cycleWording)
				);
	}
}