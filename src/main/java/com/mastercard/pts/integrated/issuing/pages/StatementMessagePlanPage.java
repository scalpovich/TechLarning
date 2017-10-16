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
public class StatementMessagePlanPage extends MPTSBasePage {

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addStatementMessagePlanPage;

	@PageElement(findBy = FindBy.NAME, valueToFind = "statMsgCode:input:inputTextField")
	private MCWebElement StatementMessagePlanCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "statMsgDescription:input:inputTextField")
	private MCWebElement Description;

	@PageElement(findBy = FindBy.NAME, valueToFind = "productType:input:dropdowncomponent")
	private MCWebElement ProductType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save2;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addSubDetails;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/div/form/table[1]/tbody/tr[3]/td[2]/span/span/span/img")
	private MCWebElement EffectiveDate;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[contains(text(), 'Next Month (')]")
	private MCWebElement EffectiveDateNxtMonth;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='endDate']//a[contains(text(),'Next Month')]")
	private MCWebElement EndDateNxtMonth;

	// *[@id='idcaDpJs']/thead/tr[1]/th/div/a[3]

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/div/form/table[1]/tbody/tr[3]/td[2]/span/span/span/span/table/tbody/tr[5]/td[3]/a")
	private MCWebElement selectEffectiveDate;

	/*
	 * //table/tbody//tr[3]//td[@id =
	 * 'effectiveDate']//span/span/span/table[@class ='yui-calendar
	 * y2018']/tbody/tr[5]/td[5]/a[text() = '31']
	 * 
	 * @PageElement(findBy = FindBy.X_PATH, valueToFind =
	 * "//table/tbody/tr[3]/td[@id = 'effectiveDate']/span/span/span/table[@class ='yui-calendar y2018']/tbody/tr[5]/td[5]/a[text() = '31']"
	 * ) private MCWebElement selectEffectiveDate;
	 */

	@PageElement(findBy = FindBy.CSS, valueToFind = "css=a:contains('34')")
	private MCWebElement selectCSSEffectiveDate;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/div/form/table[1]/tbody/tr[3]/td[4]/span/span/span/img")
	private MCWebElement EndDate;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/div/form/table[1]/tbody/tr[3]/td[4]/span/span/span/span/table/tbody/tr[5]/td[3]/a")
	private MCWebElement selectEndDate;

	@PageElement(findBy = FindBy.NAME, valueToFind = "unpaidStatus:input:dropdowncomponent")
	private MCWebElement UnpaidStatus;

	@PageElement(findBy = FindBy.NAME, valueToFind = "balanceStatus:input:dropdowncomponent")
	private MCWebElement BalanceStatus;

	@PageElement(findBy = FindBy.NAME, valueToFind = "adminStatus:input:dropdowncomponent")
	private MCWebElement AdminStatus;

	@PageElement(findBy = FindBy.NAME, valueToFind = "msgLabel:input:inputTextField")
	private MCWebElement MessageLabel;

	@PageElement(findBy = FindBy.NAME, valueToFind = "msgText:input:textAreaComponent")
	private MCWebElement Message;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

	public String addstatementmessageplan(String productType) {
		addStatementMessagePlanPage.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_STATEMENT_MESSAGE_PLAN_FRAME);
		enterText(StatementMessagePlanCode, CustomUtils.randomNumbers(5));
		enterText(Description, "Statement Plan");
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(save);
		addWicketAjaxListeners(getFinder().getWebDriver());
		addStatementMsgDetails();
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_STATEMENT_MESSAGE_PLAN_FRAME);
		ClickButton(save);
		SwitchToDefaultFrame();
		return StatementMessagePlanCode.getText();

	}

	public void addStatementMsgDetails() {
		addSubDetails.click();
		SwitchToDefaultFrame();
		switchToIframe(Constants.ADD_STATEMENT_MESSAGE_DETAILS_FRAME);
		addWicketAjaxListeners(getFinder().getWebDriver());
		EffectiveDate.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		EffectiveDateNxtMonth.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectEffectiveDate.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		EndDate.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		EndDateNxtMonth.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectEndDate.click();
		enterText(MessageLabel, "Statement Plan");
		enterText(Message, "Message");
		ClickButton(save);
		SwitchToDefaultFrame();
	}

	public void addstatementmessageplanprepaid() {
		addStatementMessagePlanPage.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");

		StatementMessagePlanCode.sendKeys(CustomUtils.randomNumbers(5));
		CustomUtils.ThreadDotSleep(1000);
		Description.sendKeys(env.getProperty("is.dinners.statementmessageplanpr.Description"));
		CustomUtils.ThreadDotSleep(1000);
		ProductType.getSelect().selectByVisibleText(env.getProperty("is.dinners.statementmessageplanpr.ProductType"));
		CustomUtils.ThreadDotSleep(1000);

		save.click();
		CustomUtils.ThreadDotSleep(2000);

		addSubDetails.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().defaultContent();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_16");
		CustomUtils.ThreadDotSleep(2000);

		EffectiveDate.click();
		CustomUtils.ThreadDotSleep(1000);
		EffectiveDateNxtMonth.click();

		CustomUtils.ThreadDotSleep(1000);
		selectEffectiveDate.click();

		save.click();
		// selectCSSEffectiveDate.click();
		// getFinder().getWebDriver().findElement(By.cssSelector("css=a:contains('31')")).click();
		CustomUtils.ThreadDotSleep(1000);
		EndDate.click();
		CustomUtils.ThreadDotSleep(2000);
		EndDateNxtMonth.click();

		CustomUtils.ThreadDotSleep(1000);
		selectEndDate.click();

		CustomUtils.ThreadDotSleep(1000);

		MessageLabel.sendKeys(env.getProperty("is.dinners.statementmessageplanpr.messagelabel"));
		Message.sendKeys(env.getProperty("is.dinners.statementmessageplanpr.message"));

		save.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().defaultContent();

		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");
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
