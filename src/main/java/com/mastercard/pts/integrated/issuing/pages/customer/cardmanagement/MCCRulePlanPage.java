package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MCCRulePlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP, CardManagementNav.L2_MCC_RULES })
public class MCCRulePlanPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(MCCRulePlanPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=mccRulePlanCode]")
	private MCWebElement planCodeSearchTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#mccRulePlanCode input")
	private MCWebElement planCodeTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#description input")
	private MCWebElement descriptionTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#productType select")
	private MCWebElement productTypeDDwn;

	public void verifyUiOperationStatus() {
		logger.info("MCC Rule");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(planCodeSearchTxt));
	}

	public void createMCCRulePlanPage(MCCRulePlan plan) {
		logger.info("Create MCC Rule Plan {}", plan.getMccRulePlanCode());
		clickAddNewButton();

		runWithinPopup("Add MCC Rule Plan", () -> {
			waitForPageToLoad(driver());
			WebElementUtils.enterText(planCodeTxt, plan.getMccRulePlanCode());
			WebElementUtils.elementToBeClickable(descriptionTxt);
			WebElementUtils.enterText(descriptionTxt, plan.getDescription());
			WebElementUtils.selectDropDownByVisibleText(productTypeDDwn, plan.getProductType());
			WebElementUtils.scrollDown(driver(),0,250);
			clickSaveButton();
			verifyNoErrors();
		});

		verifyOperationStatus();
	}

}