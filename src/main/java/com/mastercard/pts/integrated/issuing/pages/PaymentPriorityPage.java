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
public class PaymentPriorityPage extends AbstractBasePage {

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addPaymentPriority;

	@PageElement(findBy = FindBy.NAME, valueToFind = "planCode:input:inputTextField")
	private MCWebElement PaymentPriorityPlanCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "planName:input:inputTextField")
	private MCWebElement Description;

	@PageElement(findBy = FindBy.NAME, valueToFind = "balCash:input:inputTextField")
	private MCWebElement Cash;

	@PageElement(findBy = FindBy.NAME, valueToFind = "balPurchase:input:inputTextField")
	private MCWebElement Purchase;

	@PageElement(findBy = FindBy.NAME, valueToFind = "balUnique:input:inputTextField")
	private MCWebElement Unique;

	@PageElement(findBy = FindBy.NAME, valueToFind = "balTe:input:inputTextField")
	private MCWebElement TnE;

	@PageElement(findBy = FindBy.NAME, valueToFind = "balFees:input:inputTextField")
	private MCWebElement Fee;

	@PageElement(findBy = FindBy.NAME, valueToFind = "balTransfer:input:inputTextField")
	private MCWebElement Transfer;

	@PageElement(findBy = FindBy.NAME, valueToFind = "balLoanTxn:input:inputTextField")
	private MCWebElement Installment;

	@PageElement(findBy = FindBy.NAME, valueToFind = "balInterests:input:inputTextField")
	private MCWebElement Interest;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

	public void addpaymentpriority() {
		addPaymentPriority.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");

		// PaymentPriorityPlanCode.sendKeys(env.getProperty("is.dinners.paymentpriority.PaymentPriorityPlanCode"));
		PaymentPriorityPlanCode.sendKeys(CustomUtils.randomNumbers(3));
		Description.sendKeys(env
				.getProperty("is.dinners.paymentpriority.Description"));
		CustomUtils.ThreadDotSleep(1000);
		Cash.sendKeys(env.getProperty("is.dinners.paymentpriority.Cash"));
		Purchase.sendKeys(env
				.getProperty("is.dinners.paymentpriority.Purchase"));
		CustomUtils.ThreadDotSleep(1000);
		Unique.sendKeys(env.getProperty("is.dinners.paymentpriority.Unique"));
		TnE.sendKeys(env.getProperty("is.dinners.paymentpriority.TnE"));
		CustomUtils.ThreadDotSleep(1000);
		Fee.sendKeys(env.getProperty("is.dinners.paymentpriority.Fee"));
		Transfer.sendKeys(env
				.getProperty("is.dinners.paymentpriority.Transfer"));
		CustomUtils.ThreadDotSleep(1000);
		Installment.sendKeys(env
				.getProperty("is.dinners.paymentpriority.Installment"));
		Interest.sendKeys(env
				.getProperty("is.dinners.paymentpriority.Interest"));
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
