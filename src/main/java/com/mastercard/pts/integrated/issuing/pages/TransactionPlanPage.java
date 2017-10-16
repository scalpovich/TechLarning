package com.mastercard.pts.integrated.issuing.pages;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MPTSBasePage;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class TransactionPlanPage extends MPTSBasePage {

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

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

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}
