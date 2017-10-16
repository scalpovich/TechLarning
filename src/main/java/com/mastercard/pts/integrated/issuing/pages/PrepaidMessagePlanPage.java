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
public class PrepaidMessagePlanPage extends MPTSBasePage {

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addPrepaidStatementPlan;

	@PageElement(findBy = FindBy.NAME, valueToFind = "stmtPlanCode:input:inputTextField")
	private MCWebElement StatementPlanCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "description:input:inputTextField")
	private MCWebElement Description;

	@PageElement(findBy = FindBy.NAME, valueToFind = "stmtPeriod:input:dropdowncomponent")
	private MCWebElement Period;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save2;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addSubDetails;

	@PageElement(findBy = FindBy.NAME, valueToFind = "toLot:input:inputTextField")
	private MCWebElement ToLot;

	@PageElement(findBy = FindBy.NAME, valueToFind = "stmtCutOffDate:input:inputTextField")
	private MCWebElement BillingDay;

	@PageElement(findBy = FindBy.NAME, valueToFind = "printDate:input:inputTextField")
	private MCWebElement PrintDay;

	@PageElement(findBy = FindBy.NAME, valueToFind = "status:input:dropdowncomponent")
	private MCWebElement GenerationStatus;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement savefinal;

	public void addprepaidmessageplan() {
		addPrepaidStatementPlan.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_PREPAID_STATEMENT_FRAME);
		enterText(StatementPlanCode, CustomUtils.randomNumbers(5));
		enterText(Description, "Prepaid statement plan");
		SelectDropDownByIndex(Period, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(save);
		addWicketAjaxListeners(getFinder().getWebDriver());

		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");
		CustomUtils.ThreadDotSleep(2000);
		save.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().defaultContent();

	}

	public void addpreapidMessageDetails() {
		addSubDetails.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		SwitchToDefaultFrame();
		switchToIframe(Constants.ADD_PREPAID_STATEMENT_PLAN_FRAME);
		addWicketAjaxListeners(getFinder().getWebDriver());

		ToLot.sendKeys(env.getProperty("is.dinners.prepaidstatementplan.ToLot"));
		BillingDay.sendKeys(env.getProperty("is.dinners.prepaidstatementplan.BillingDay"));
		PrintDay.sendKeys(env.getProperty("is.dinners.prepaidstatementplan.PrintDay"));
		GenerationStatus.getSelect()
				.selectByVisibleText(env.getProperty("is.dinners.prepaidstatementplan.GenerationStatus"));
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
