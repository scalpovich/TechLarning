package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DedupePlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP, CardManagementNav.L2_DEDUPE_PLAN })
public class DedupePlanPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(DedupePlanPage.class);

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addDedupePlan;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:1:cols:colspanMarkup:inputField:input:inputTextField")
	private MCWebElement DedupePlanCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:1:cols:nextCol:colspanMarkup:inputField:input:inputTextField")
	private MCWebElement Description;


	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=dedupePlanCode]")
	private MCWebElement dedupePlanCodeSearchTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#dedupePlanCode input")
	private MCWebElement walletPlanCodeTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#description input")
	private MCWebElement descriptionTxt;


	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

	public void clickaddDedupePlan() {
		waitForElementVisible(addDedupePlan);
		addDedupePlan.click();
	}

	public void switchToAddDedupePlanFrame() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_DEDUPE_PLAN_FRAME);
	}

	public String enterDedupeCode() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(DedupePlanCode, CustomUtils.randomNumbers(5));
		return DedupePlanCode.getAttribute("value");
	}

	public String enterDedupeDescription() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(Description, "HDFC dedupe plan all customer");
		return Description.getAttribute("value");
	}

	public void clickSaveButton() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(save);
		SwitchToDefaultFrame();
	}

	public void adddedupeplan() {
		addDedupePlan.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_DEDUPE_PLAN_FRAME);
		enterText(DedupePlanCode, CustomUtils.randomNumbers(5));
		enterText(Description, "HDFC dedupe plan all customer");
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(save);
		SwitchToDefaultFrame();
	}
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
		// TODO Auto-generated method stub
		return null;
	}

}
