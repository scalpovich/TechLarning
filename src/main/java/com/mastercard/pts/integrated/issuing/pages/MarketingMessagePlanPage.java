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
public class MarketingMessagePlanPage extends MPTSBasePage {

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addMarketingMessagePlan;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mktMsgPlanCode:input:inputTextField")
	private MCWebElement MarketingMessagePlanCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mktMsgDescription:input:inputTextField")
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

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[4]//a[contains(text(), 'Next Month')]")
	private MCWebElement EndDateNxtMonth;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/div/form/table[1]/tbody/tr[3]/td[2]/span/span/span/span/table/tbody/tr[5]/td[4]/a")
	private MCWebElement selectEffectiveDate;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/div/form/table[1]/tbody/tr[3]/td[4]/span/span/span/img")
	private MCWebElement EndDate;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "/html/body/div[2]/div/div/form/table[1]/tbody/tr[3]/td[4]/span/span/span/span/table/tbody/tr[5]/td[4]/a")
	private MCWebElement selectEndDate;

	@PageElement(findBy = FindBy.NAME, valueToFind = "msgLabel:input:inputTextField")
	private MCWebElement MessageLabel;

	@PageElement(findBy = FindBy.NAME, valueToFind = "msgText:input:textAreaComponent")
	private MCWebElement Message;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement savefinal;

	public void addmarketingplan(String product) {
		addMarketingMessagePlan.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_MARKETING_MESSAGE_PLAN_FRAME);
		enterText(MarketingMessagePlanCode, CustomUtils.randomNumbers(5));
		enterText(Description, "Marketing Message Plan");
		SelectDropDownByText(ProductType, product);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(save2);
		addWicketAjaxListeners(getFinder().getWebDriver());
		addmarketingMessagedetails();
		switchToIframe(Constants.ADD_MARKETING_MESSAGE_PLAN_FRAME);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(save);
		SwitchToDefaultFrame();
	}

	public void addmarketingMessagedetails() {
		addSubDetails.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		SwitchToDefaultFrame();
		switchToIframe(Constants.ADD_MARKETING_MESSAGE_DETAILS_FRAME);
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
		selectEndDate.click();
		enterText(MessageLabel, "Marketing Message Plan");
		enterText(Message, "Message");
		ClickButton(save);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SwitchToDefaultFrame();
	}

	public void addmarketingplanprepaid() {
		addMarketingMessagePlan.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");

		// MarketingMessagePlanCode.sendKeys(env.getProperty("is.dinners.marketingmessageplan.marketingmessageplancode"));
		MarketingMessagePlanCode.sendKeys(CustomUtils.randomNumbers(5));
		CustomUtils.ThreadDotSleep(1000);
		Description.sendKeys(env.getProperty("is.dinners.marketingmessageplanpr.description"));
		ProductType.getSelect().selectByVisibleText(env.getProperty("is.dinners.marketingmessageplanpr.producttype"));
		CustomUtils.ThreadDotSleep(1000);

		save2.click();
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
		selectEffectiveDate.click();
		CustomUtils.ThreadDotSleep(1000);
		EndDate.click();

		EndDateNxtMonth.click();
		CustomUtils.ThreadDotSleep(1000);
		selectEndDate.click();

		MessageLabel.sendKeys(env.getProperty("is.dinners.marketingmessageplanpr.messagelabel"));
		Message.sendKeys(env.getProperty("is.dinners.marketingmessageplanpr.message"));

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
