package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DedupePlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP, CardManagementNav.L2_DEDUPE_PLAN })
public class DedupePlanPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory
			.getLogger(DedupePlanPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=dedupePlanCode]")
	private MCWebElement dedupePlanCodeSearchTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#dedupePlanCode input")
	private MCWebElement walletPlanCodeTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#description input")
	private MCWebElement descriptionTxt;

	public void inputWalletPlanCode(String walletPlanCodeString) {
		WebElementUtils.enterText(walletPlanCodeTxt, walletPlanCodeString);
	}

	public void inputDescription(String description) {
		WebElementUtils.enterText(descriptionTxt, description);
	}

	public void addDedupePlanData(DedupePlan dedupePlan) {
		logger.info("Create Dedupe Plan: {}", dedupePlan.getWalletPlanCode());
		clickAddNewButton();

		runWithinPopup("Add Dedupe Plan", () -> {
			inputWalletPlanCode(dedupePlan.getWalletPlanCode());
			inputDescription(dedupePlan.getDescription());

			clickSaveButton();
		});

		verifyOperationStatus();

	}

	public void verifyUiOperationStatus() {
		logger.info("Deduce Plan");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils
				.elementToBeClickable(dedupePlanCodeSearchTxt));
	}
}
