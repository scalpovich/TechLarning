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
public class PaymentBounceReasonPage extends AbstractBasePage {

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addPaymentBounceReasone;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:1:cols:colspanMarkup:inputField:input:inputTextField")
	private MCWebElement PaymentBouncePlanCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:2:cols:colspanMarkup:inputField:input:inputTextField")
	private MCWebElement Description;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

	public void addpaymentbouncereason() {
		addPaymentBounceReasone.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");

		// PaymentBouncePlanCode.sendKeys(env.getProperty("is.dinners.paymentbouncereason.PaymentBouncePlanCode"));
		PaymentBouncePlanCode.sendKeys(CustomUtils.randomNumbers(3));
		CustomUtils.ThreadDotSleep(1000);
		Description.sendKeys(env
				.getProperty("is.dinners.paymentbouncereason.Description"));

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
