package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PrepaidStatementPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PrepaidStatementPlanDetails;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP,
		CardManagementNav.L2_PREPAID_STATEMENT_PLAN })
public class PrepaidStatementPlanPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(PrepaidStatementPlanPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=stmtPlanCode]")
	private MCWebElement planCodeSearchTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#stmtPlanCode input")
	private MCWebElement planCodeTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#description input")
	private MCWebElement descriptionTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#stmtPeriod select")
	private MCWebElement stmtPeriodDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#suppressIfNoActivity input")
	private MCWebElement suppressIfNoActivityChkBx;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=toLot]")
	private MCWebElement toLotTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#stmtCutOffDate input")
	private MCWebElement billingDayTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=printDate]")
	private MCWebElement printDateTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "select[name^=status]")
	private MCWebElement statusDDwn;

	public void verifyUiOperationStatus() {
		logger.info("Prepaid Statement Plan");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(planCodeSearchTxt));
	}

	public void createPrepaidStatementPlan(PrepaidStatementPlan plan) {
		logger.info("Create Prepaid Statement Plan {}",
				plan.getStatementPlanCode());

		clickAddNewButton();

		runWithinPopup(
				"Add Prepaid Statement Plan",
				() -> {
					WebElementUtils.enterText(planCodeTxt,
							plan.getStatementPlanCode());
					WebElementUtils.enterText(descriptionTxt,
							plan.getDescription());
					WebElementUtils.selectDropDownByVisibleText(stmtPeriodDDwn,
							plan.getPeriod());
					WebElementUtils.checkCheckbox(suppressIfNoActivityChkBx,
							plan.isSuppressIfNoActivity());
					clickAddDetailsButton();

					plan.getPrepaidStatementPlanDetails().forEach(
							this::addDetails);

					clickSaveButton();

					verifyNoErrors();
				});

		verifyOperationStatus();
	}

	private void addDetails(PrepaidStatementPlanDetails details) {
		clickAddNewButton();

		runWithinPopup("Add Prepaid Statement Plan Details", () -> {
			WebElementUtils.enterText(toLotTxt, details.getToLot());
			WebElementUtils.enterText(billingDayTxt, details.getBillingDay());
			WebElementUtils.enterText(printDateTxt, details.getPrintDay());
			WebElementUtils.selectDropDownByVisibleText(statusDDwn,
					details.getGenerationStatus());
			clickSaveButton();

			verifyNoErrors();
		});

		verifyOperationStatus();
	}
}
