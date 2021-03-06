package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_OPERATION, CardManagementNav.L2_OPERATION_APPLICATION, CardManagementNav.L3_OPERATION_APPLICATION_CREDIT, CardManagementNav.L4_APPLICATION_SCORING })
public class ApplicationScoringPage extends AbstractBasePage {
	  @Autowired
	  TestContext context;
	  
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[contains(text(),'Batch No')]")
	private MCWebElement batchNoColumn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value='Process All']")
	private MCWebElement btnProcessAll;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[text()='Application Scoring']")
	private MCWebElement btnApplicationScoring;

	@PageElement(findBy = FindBy.CSS, valueToFind = "table.dataview")
	private MCWebElement searchTable;

	private int retryLimit = 20;
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(batchNoColumn));
	}

	public void processAllApplicationScoring() {
		if (!WebElementUtils.isTextAvailableinTable(searchTable, context.get(CreditConstants.PRIMARY_BATCH_NUMBER))&& --retryLimit > 0) {
			clickWhenClickable(btnApplicationScoring);
			processAllApplicationScoring();
		}
		SimulatorUtilities.wait(4000);
	}
	
	public void clickProcessALL() {
		clickOncheckBoxIfBatchAvailableinTable(searchTable, context.get(CreditConstants.PRIMARY_BATCH_NUMBER));
		clickProcessSelectedButton();
		verifyOperationStatus();
	}
}