package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PrepaidStatementPlan;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1PROGRAM_SETUP,
		CardManagementNav.L2PREPAID_STATEMENT_PLAN })
public class PrepaidMessagePlanPage extends PrepaidStatementPlan {
	final Logger logger = LoggerFactory.getLogger(EmbossingPriorityPassPage.class);

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

	public void clickaddPrepaidStatementPlan() {
		waitForElementVisible(addPrepaidStatementPlan);
		addPrepaidStatementPlan.click();
	}

	public void switchToAddPrepaidStatementFrame() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_PREPAID_STATEMENT_FRAME);
	}

	public String enterStatementPlanCode() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(StatementPlanCode, CustomUtils.randomNumbers(5));
		return StatementPlanCode.getAttribute("value");
	}

	public String enterStatementPlanDescription() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(Description, "Prepaid statement plan");
		return Description.getAttribute("value");
	}

	public void selectPeriod() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(Period, 1);
	}

	public void clickaddPrepaidStatementSubDetails() {
		switchToIframe(Constants.ADD_PREPAID_STATEMENT_FRAME);
		waitForElementVisible(addSubDetails);
		addSubDetails.click();
	}

	public void switchToAddPrepaidStatementPlanFrame() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		SwitchToDefaultFrame();
		switchToIframe(Constants.ADD_PREPAID_STATEMENT_PLAN_FRAME);
	}

	public void enterToLot() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		ToLot.sendKeys("1");
	}

	public void enterPrintDay() {
		waitForElementVisible(PrintDay);
		addWicketAjaxListeners(getFinder().getWebDriver());
		PrintDay.sendKeys("12");
	}

	public void selectGenerationStatus() {
		waitForElementVisible(GenerationStatus);
		selectByVisibleText(GenerationStatus, "Active");
	}

	public void clickSaveButton() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		save.click();
		SwitchToDefaultFrame();
	}

	public void addprepaidmessageplan() {
		addPrepaidStatementPlan.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_PREPAID_STATEMENT_FRAME);
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(StatementPlanCode, CustomUtils.randomNumbers(5));
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(Description, "Prepaid statement plan");
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(Period, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(save);
		addWicketAjaxListeners(getFinder().getWebDriver());
		addpreapidMessageDetails();

		// switchToIframe("Add Prepaid Statement Plan Details");
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_PREPAID_STATEMENT_FRAME);
		waitForElementVisible(save);
		CustomUtils.ThreadDotSleep(2000);
		save.click();
		waitForElementVisible(addPrepaidStatementPlan);
		SwitchToDefaultFrame();
	}

	public void addpreapidMessageDetails() {
		waitForElementVisible(addSubDetails);
		addSubDetails.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		SwitchToDefaultFrame();
		switchToIframe(Constants.ADD_PREPAID_STATEMENT_PLAN_FRAME);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ToLot.sendKeys(env.getProperty("is.dinners.prepaidstatementplan.ToLot"));
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(PrintDay);
		PrintDay.sendKeys(env.getProperty("is.dinners.prepaidstatementplan.PrintDay"));
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(GenerationStatus);
		GenerationStatus.getSelect()
				.selectByVisibleText(env.getProperty("is.dinners.prepaidstatementplan.GenerationStatus"));
		addWicketAjaxListeners(getFinder().getWebDriver());
		save.click();
		getFinder().getWebDriver().switchTo().defaultContent();

	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}
