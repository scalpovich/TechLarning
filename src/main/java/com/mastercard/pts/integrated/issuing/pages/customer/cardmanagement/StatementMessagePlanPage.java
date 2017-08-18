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
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
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
}