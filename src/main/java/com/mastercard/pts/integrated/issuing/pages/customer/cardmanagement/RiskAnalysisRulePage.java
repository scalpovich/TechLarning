package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;

import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP, CardManagementNav.L2_APPLICATION,
		CardManagementNav.L3_CREDIT, CardManagementNav.L4_RISK_ANALYSIS_RULE })
public class RiskAnalysisRulePage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory
			.getLogger(RiskAnalysisRulePage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement program;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=ruleId]")
	private MCWebElement ruleId;

	public void verifyUiOperationStatus() {
		logger.info("Risk Analysis Rule");
		verifyUiOperation("Add Risk Analysis Rule");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(program),
				WebElementUtils.elementToBeClickable(ruleId));
	}
}
