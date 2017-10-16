package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class TransactionRulePlanPage extends AbstractBasePage {

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addTransactionRulePlan;

	@PageElement(findBy = FindBy.NAME, valueToFind = "planCode:input:inputTextField")
	private MCWebElement TransactionRulePlanCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "planName:input:inputTextField")
	private MCWebElement Description;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

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
		// TODO Auto-generated method stub
		return null;
	}

}
