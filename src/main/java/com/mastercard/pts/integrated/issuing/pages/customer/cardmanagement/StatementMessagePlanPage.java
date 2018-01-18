package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.StatementMessageDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.StatementMessagePlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.DatePicker;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1PROGRAM_SETUP,
		CardManagementNav.L2_STATEMENT_MESSAGE_PLAN })
public class StatementMessagePlanPage extends AbstractBasePage {

	@Autowired
	DatePicker date;
	private static final Logger logger = LoggerFactory
			.getLogger(StatementMessagePlanPage.class);

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
	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addStatementMessagePlanPage;

	@PageElement(findBy = FindBy.NAME, valueToFind = "statMsgCode:input:inputTextField")
	private MCWebElement StatementMessagePlanCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "statMsgDescription:input:inputTextField")
	private MCWebElement Description;

	@PageElement(findBy = FindBy.NAME, valueToFind = "productType:input:dropdowncomponent")
	private MCWebElement productType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save2;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addSubDetails;

	@PageElement(findBy = FindBy.CSS, valueToFind = "css=a:contains('34')")
	private MCWebElement selectCSSEffectiveDate;

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

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement CancelBtn;

	public String Calelement = "//td[@id = 'endDate']";

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
	public void clickaddStatementMessagePlan() {
		clickWhenClickable(addStatementMessagePlanPage);
		switchToAddStatementMessagePlanFrame();
	}

	public void switchToAddStatementMessagePlanFrame() {
		switchToIframe(Constants.ADD_STATEMENT_MESSAGE_PLAN_FRAME);
	}

	public String enterStatementMessagePlanCode() {
		enterValueinTextBox(StatementMessagePlanCode, CustomUtils.randomNumbers(5));
		return StatementMessagePlanCode.getAttribute("value");
	}

	public String enterStatementDescription() {
		enterValueinTextBox(Description, Constants.STATEMENT_PLAN);
		return Description.getAttribute("value");
	}

	public void selectProductType(DeviceCreation deviceCreation) {
		selectByVisibleText(productType, deviceCreation.getProduct());
	}

	public String statementMessagePlanDetails(DeviceCreation deviceCreation) {
		String StatementPlanCode;
		String StatementPlanDesc;
		StatementPlanCode = enterStatementMessagePlanCode();
		StatementPlanDesc = enterStatementDescription();
		selectProductType(deviceCreation);
		return StatementPlanDesc + " " + "[" + StatementPlanCode + "]";

	}

	public boolean verifyErrorsOnStatementPlanPage() {
		return publishErrorOnPage();
	}

	public void verifyStatementPlanSuccess() {
		if (!verifyErrorsOnStatementPlanPage()) {
			logger.info("Vendor Added Successfully");
			SwitchToDefaultFrame();
		} else {
			logger.info("Error in Vendor Addition");
			clickWhenClickable(CancelBtn);
			SwitchToDefaultFrame();
		}
	}

	public void clickaddStatementMessageDetails() {
		switchToIframe(Constants.ADD_STATEMENT_MESSAGE_PLAN_FRAME);
		clickWhenClickable(addSubDetails);
	}

	public void switchToAddStatementMessageDetailsFrame() {
		SwitchToDefaultFrame();
		switchToIframe(Constants.ADD_STATEMENT_MESSAGE_DETAILS_FRAME);
	}

	public void selectEffectiveDate(StatementMessagePlan stmnt) {
		date.setDate(stmnt.getEffectiveDate());
	}

	public void selectEndDate(StatementMessagePlan stmnt) {
		date.setDateCalendar2(stmnt.getEndDate(), Calelement);
	}

	public void enterStatementMessageSubDetailsLabel() {
		enterValueinTextBox(MessageLabel, Constants.STATEMENT_PLAN);
	}

	public void enterStatementMessageSubDetailsMessage() {
		enterValueinTextBox(Message, Constants.STATEMENT_PLAN);
	}

	public void clickAddSubDetails() {
		clickWhenClickable(addSubDetails);
	}

	public void addStatementMsgDetails(StatementMessagePlan stmnt) {
		SwitchToDefaultFrame();
		switchToIframe(Constants.ADD_STATEMENT_MESSAGE_DETAILS_FRAME);
		selectEffectiveDate(stmnt);
		selectEndDate(stmnt);
		enterStatementMessageSubDetailsLabel();
		enterStatementMessageSubDetailsMessage();
		clickSaveButton();
		SwitchToDefaultFrame();
		switchToAddStatementMessagePlanFrame();
		Scrolldown(save);
		waitForElementVisible(save);
		ClickButton(save);
	}
}