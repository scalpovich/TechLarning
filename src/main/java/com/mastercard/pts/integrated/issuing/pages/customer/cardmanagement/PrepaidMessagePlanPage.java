package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PrepaidStatementPlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1PROGRAM_SETUP,
		CardManagementNav.L2_PREPAID_STATEMENT_PLAN })
public class PrepaidMessagePlanPage extends AbstractBasePage {
	final Logger logger = LoggerFactory.getLogger(EmbossingPriorityPassPage.class);

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addPrepaidStatementPlanBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "stmtPlanCode:input:inputTextField")
	private MCWebElement StatementPlanCodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "description:input:inputTextField")
	private MCWebElement DescriptionTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "stmtPeriod:input:dropdowncomponent")
	private MCWebElement PeriodDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save2Btn;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addSubDetailsBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "toLot:input:inputTextField")
	private MCWebElement ToLotTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "stmtCutOffDate:input:inputTextField")
	private MCWebElement BillingDayTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "printDate:input:inputTextField")
	private MCWebElement PrintDayTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "status:input:dropdowncomponent")
	private MCWebElement GenerationStatusDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement savefinalBtn;

	public void clickaddPrepaidStatementPlan() {
		clickWhenClickable(addPrepaidStatementPlanBtn);
		switchToAddPrepaidStatementFrame();
	}

	public void switchToAddPrepaidStatementFrame() {
		switchToIframe(Constants.ADD_PREPAID_STATEMENT_FRAME);
	}

	public String enterStatementPlanCode() {
		enterValueinTextBox(StatementPlanCodeTxt, CustomUtils.randomNumbers(5));
		return StatementPlanCodeTxt.getAttribute("value");
	}

	public String enterStatementPlanDescription() {
		enterValueinTextBox(DescriptionTxt, "Prepaid statement plan");
		return DescriptionTxt.getAttribute("value");
	}

	public void selectPeriod() {
		SelectDropDownByIndex(PeriodDDwn, 1);
	}

	public String addPrepaidStatementPlanDetails() {
		String prepaidplancode = enterStatementPlanCode();
		String prepaidplandesc = enterStatementPlanDescription();
		selectPeriod();
		return prepaidplandesc + " " + "[" + prepaidplancode + "]";
	}

	public void clickaddPrepaidStatementSubDetails() {
		switchToIframe(Constants.ADD_PREPAID_STATEMENT_FRAME);
		clickWhenClickable(addSubDetailsBtn);
	}

	public void switchToAddPrepaidStatementPlanFrame() {
		switchToIframe(Constants.ADD_PREPAID_STATEMENT_PLAN_FRAME);
	}

	public void enterToLot(PrepaidStatementPlan prepaidstmt) {
		enterValueinTextBox(ToLotTxt, prepaidstmt.getToLot());

	}

	public void enterPrintDay(PrepaidStatementPlan prepaidstmt) {
		enterValueinTextBox(PrintDayTxt, prepaidstmt.getPrintDay());
	}

	public void selectGenerationStatus() {
		waitForElementVisible(GenerationStatusDDwn);
		selectByVisibleText(GenerationStatusDDwn, "Active");
	}

	public void clickSaveButton() {
		clickWhenClickable(saveBtn);
		SwitchToDefaultFrame();
	}

	public void addpreapidMessageDetails(PrepaidStatementPlan prepaidstmt) {
		SwitchToDefaultFrame();
		switchToAddPrepaidStatementPlanFrame();
		enterToLot(prepaidstmt);
		enterPrintDay(prepaidstmt);
		selectGenerationStatus();
		clickSaveButton();
		switchToAddPrepaidStatementFrame();
		Scrolldown(saveBtn);
		ClickButton(saveBtn);
		SwitchToDefaultFrame();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return null;
	}

}
