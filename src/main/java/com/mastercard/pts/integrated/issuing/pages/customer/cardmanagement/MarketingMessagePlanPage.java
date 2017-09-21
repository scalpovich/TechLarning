package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MarketingMessageDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MarketingMessagePlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP,
		CardManagementNav.L2_MARKETING_MESSAGE_PLAN })
public class MarketingMessagePlanPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(MarketingMessagePlanPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=mktMsgPlanCode]")
	private MCWebElement planCodeSearchTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=mktMsgPlanCode]")
	private MCWebElement planCodeTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=mktMsgDescription]")
	private MCWebElement descriptionTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "select[name^=productType]")
	private MCWebElement productTypeDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='effectiveDate']/..")
	private MCWebElement effectiveDateDPkr;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='endDate']/..")
	private MCWebElement endDateDPkr;

	@PageElement(findBy = FindBy.NAME, valueToFind = "msgLabel:input:inputTextField")
	private MCWebElement messageLabelTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "msgText:input:textAreaComponent")
	private MCWebElement messageTxt;


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

	public void clickAddMarketingMessagePlan() {
		waitForElementVisible(addMarketingMessagePlan);
		addMarketingMessagePlan.click();
	}

	public void switchToAddMarketingMessagePlanFrame() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_MARKETING_MESSAGE_PLAN_FRAME);
	}

	public String enterMarketingMessagePlanCode() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(MarketingMessagePlanCode, CustomUtils.randomNumbers(5));
		return MarketingMessagePlanCode.getAttribute("value");
	}

	public String enterMarketingMessagePlanDescription() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(Description, "Marketing Message Plan");
		return Description.getAttribute("value");
	}

	public void selectProduct(DeviceCreation deviceCreation) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectByVisibleText(ProductType, deviceCreation.getProduct());
	}

	public void clickSaveButton() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(save2);
		SwitchToDefaultFrame();
	}

	public void clickAddMarketingMessageDetails() {
		switchToIframe(Constants.ADD_MARKETING_MESSAGE_PLAN_FRAME);
		waitForElementVisible(addSubDetails);
		addSubDetails.click();
	}

	public void switchToAddMarketingMessageDetailsFrame() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		SwitchToDefaultFrame();
		switchToIframe(Constants.ADD_MARKETING_MESSAGE_DETAILS_FRAME);
	}

	public void selectDate() {
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
	}

	public void enterMarketingMessagePlanDetailsLabel() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(MessageLabel, "Marketing Message Plan");
	}

	public void enterMarketingMessagePlanDetailsDescription() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(Message, "Message");
	}

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
		waitForElementVisible(save);
		CustomUtils.ThreadDotSleep(1000);
		ClickButton(save);
		SwitchToDefaultFrame();
	}

	public void addmarketingMessagedetails() {
		waitForElementVisible(addSubDetails);
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
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectEndDate.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(MessageLabel, "Marketing Message Plan");
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(Message, "Message");
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(save);
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

	public void verifyUiOperationStatus() {
		logger.info("Marketing Message Plan");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(planCodeSearchTxt));
	}

	public void createMarketingMessagePlan(
			MarketingMessagePlan marketingMessagePlan) {
		logger.info("Create Marketing Message Plan: {}",
				marketingMessagePlan.getMarketingMessagePlanCode());
		clickAddNewButton();

		runWithinPopup(
				"Add Marketing Message Plan",
				() -> {
					WebElementUtils.enterText(planCodeTxt,
							marketingMessagePlan.getMarketingMessagePlanCode());
					WebElementUtils.enterText(descriptionTxt,
							marketingMessagePlan.getDescription());
					WebElementUtils.selectDropDownByVisibleText(
							productTypeDDwn,
							marketingMessagePlan.getProductType());
					clickAddDetailsButton();

					marketingMessagePlan.getMarketingMessageDetails().forEach(
							this::addDetails);

					clickSaveButton();

					verifyNoErrors();
				});

		verifyOperationStatus();
	}

	private void addDetails(MarketingMessageDetails details) {
		clickAddNewButton();

		runWithinPopup(
				"Add Marketing Message Details",
				() -> {
					WebElementUtils.pickDate(effectiveDateDPkr,
							details.getEffectiveDate());
					WebElementUtils.pickDate(endDateDPkr, details.getEndDate());
					WebElementUtils.enterText(messageLabelTxt,
							details.getMesssageLabel());
					WebElementUtils.enterText(messageTxt, details.getMessage());
					clickSaveButton();

					verifyNoErrors();
				});

		verifyOperationStatus();
	}

}
