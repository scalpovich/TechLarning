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

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP, CardManagementNav.L2_APPLICATION,
		CardManagementNav.L3_CREDIT, CardManagementNav.L4_VARIABLE_SCORE })
public class VariableScorePage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(VariableScorePage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "#prodCode select")
	private MCWebElement programDdwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#columnCode select")
	private MCWebElement fieldNameDdwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "rangedStartValue:input:inputTextField")
	private MCWebElement rangeStartValueTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "rangedEndValue:input:inputTextField")
	private MCWebElement rangeEndValueTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "score:input:inputTextField")
	private MCWebElement scoreTxt;

	public void verifyUiOperationStatus() {
		logger.info("Variable Score");
		verifyUiOperation("Add Variable Score");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(programDdwn));
	}
}
