package com.mastercard.pts.integrated.issuing.pages;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class BillingCyclePage extends AbstractBasePage {

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

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

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}
