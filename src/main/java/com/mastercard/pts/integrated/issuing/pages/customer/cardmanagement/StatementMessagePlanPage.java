package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.StatementMessageDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.StatementMessagePlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
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
		CardManagementNav.L2_STATEMENT_MESSAGE_PLAN })
public class StatementMessagePlanPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory
			.getLogger(StatementMessagePlanPage.class);

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
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=statMsgCode]")
	private MCWebElement planCodeSearchTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=statMsgCode]")
	private MCWebElement planCodeTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=statMsgDescription]")
	private MCWebElement descriptionTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "select[name^=productType]")
	private MCWebElement productTypeDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=msgLabel]")
	private MCWebElement messageLabelTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "textarea[fld_fqn=msgText]")
	private MCWebElement messageTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#effectiveDate")
	private MCWebElement effectiveDateDPkr;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#endDate")
	private MCWebElement endDateDPkr;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#branchCode select")
	private MCWebElement branchDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#unpaidStatus select")
	private MCWebElement unpaidStatusDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#adminStatus select")
	private MCWebElement adminStatusDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#balanceStatus select")
	private MCWebElement balanceStatusDDwn;


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

	public void clickaddStatementMessagePlan() {
		waitForElementVisible(addStatementMessagePlanPage);
		addStatementMessagePlanPage.click();
	}

	public void switchToAddStatementMessagePlanFrame() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_STATEMENT_MESSAGE_PLAN_FRAME);
	}

	public String enterStatementMessagePlanCode() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(StatementMessagePlanCode, CustomUtils.randomNumbers(5));
		return StatementMessagePlanCode.getAttribute("value");
	}

	public String enterStatementDescription() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(Description, "Statement Plan");
		return Description.getAttribute("value");
	}

	public void selectProductType(DeviceCreation deviceCreation) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectByVisibleText(ProductType, deviceCreation.getProduct());
	}

	public void clickSaveButton() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(save);
		SwitchToDefaultFrame();
	}

	public void clickaddStatementMessageDetails() {
		switchToIframe(Constants.ADD_STATEMENT_MESSAGE_PLAN_FRAME);
		waitForElementVisible(addSubDetails);
		addSubDetails.click();
	}

	public void switchToAddStatementMessageDetailsFrame() {
		SwitchToDefaultFrame();
		switchToIframe(Constants.ADD_STATEMENT_MESSAGE_DETAILS_FRAME);
	}

	public void selectDate() {
		waitForElementVisible(EffectiveDate);
		addWicketAjaxListeners(getFinder().getWebDriver());
		EffectiveDate.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(EffectiveDateNxtMonth);
		EffectiveDateNxtMonth.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectEffectiveDate.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(EndDate);
		EndDate.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		EndDateNxtMonth.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectEndDate.click();
	}

	public void enterStatementMessageSubDetailsLabel() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(MessageLabel, "Statement Plan");
	}

	public void enterStatementMessageSubDetailsMessage() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(Message, "Message");
	}

	public void addstatementmessageplan(String productType) {
		addStatementMessagePlanPage.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_STATEMENT_MESSAGE_PLAN_FRAME);
		enterText(StatementMessagePlanCode, CustomUtils.randomNumbers(5));
		enterText(Description, "Statement Plan");
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(ProductType, productType);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(save);
		addWicketAjaxListeners(getFinder().getWebDriver());
		addStatementMsgDetails();
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_STATEMENT_MESSAGE_PLAN_FRAME);
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(save);
		CustomUtils.ThreadDotSleep(1000);
		ClickButton(save);
		waitForElementVisible(addStatementMessagePlanPage);
		SwitchToDefaultFrame();
		// return StatementMessagePlanCode.getText();

	}

	public void addStatementMsgDetails() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(addSubDetails);
		addSubDetails.click();
		SwitchToDefaultFrame();
		switchToIframe(Constants.ADD_STATEMENT_MESSAGE_DETAILS_FRAME);
		waitForElementVisible(EffectiveDate);
		addWicketAjaxListeners(getFinder().getWebDriver());
		EffectiveDate.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(EffectiveDateNxtMonth);
		EffectiveDateNxtMonth.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectEffectiveDate.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(EndDate);
		EndDate.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		EndDateNxtMonth.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectEndDate.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(MessageLabel, "Statement Plan");
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(Message, "Message");
		addWicketAjaxListeners(getFinder().getWebDriver());
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
	public void verifyUiOperationStatus() {
		logger.info("Statement Message Plan");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(planCodeSearchTxt));
	}

	public void createStatementMessagePlan(StatementMessagePlan plan) {
		logger.info("Create Statement Message Plan: {}",
				plan.getStatementMessagePlanCode());
		clickAddNewButton();

		runWithinPopup(
				"Add Statement Message Plan",
				() -> {
					WebElementUtils.enterText(planCodeTxt, plan.getStatementMessagePlanCode());
					WebElementUtils.enterText(descriptionTxt, plan.getDescription());
					WebElementUtils.selectDropDownByVisibleText(productTypeDDwn, plan.getProductType());
					clickAddDetailsButton();

					plan.getStatementMessageDetails().forEach(details -> addDetails(details, plan.getProductType()));

					clickSaveButton();

					verifyNoErrors();
				});

		verifyOperationStatus();
	}

	private void addDetails(StatementMessageDetails details, String productType) {
		clickAddNewButton();

		runWithinPopup("Add Statement Message Details", () -> {
			WebElementUtils.enterText(messageLabelTxt, details.getMessageLabel());
			WebElementUtils.enterText(messageTxt, details.getMessage());
			WebElementUtils.selectDropDownByVisibleText(branchDDwn, details.getBranch());
			WebElementUtils.pickDate(effectiveDateDPkr, details.getEffectiveDate());
			WebElementUtils.pickDate(endDateDPkr, details.getEndDate());

			if (ProductType.CREDIT.equals(productType)) {
				WebElementUtils.selectDropDownByVisibleText(unpaidStatusDDwn, details.getUnpaidStatus());
				WebElementUtils.selectDropDownByVisibleText(adminStatusDDwn, details.getAdminStatus());
				WebElementUtils.selectDropDownByVisibleText(balanceStatusDDwn, details.getBalanceStatus());
			}
			clickSaveButton();

			verifyNoErrors();
		});

		verifyOperationStatus();
	}
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}
