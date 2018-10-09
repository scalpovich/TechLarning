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
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_OPERATION, CardManagementNav.L2_OPERATION_APPLICATION, CardManagementNav.L3_OPERATION_APPLICATION_CREDIT, CardManagementNav.L4_CREDIT_BUREAU_VERIFICATION })
public class CreditBureauVerificationPage extends AbstractBasePage {

	@PageElement(findBy = FindBy.CSS, valueToFind = ".dataview")
	private MCWebElement batchNoColumn;

	private static final String CREDIT_BUREAU_VERIFICATION_FRAME = "Edit ";

	@Autowired
	TestContext context;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value='Process All']")
	private MCWebElement processAllBtn;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[text()='Credit Bureau Verification']")
	private MCWebElement creditBureauVerificationLink;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//img[@alt='Edit Record']")
	private MCWebElement manualApprovalLink;

	@PageElement(findBy = FindBy.CSS, valueToFind = "table.dataview")
	private MCWebElement searchTable;

	public void creditBureauVerificationBatchProcess() {
		if (!WebElementUtils.isTextAvailableinTable(searchTable, context.get(CreditConstants.PRIMARY_BATCH_NUMBER))) {
			clickWhenClickable(creditBureauVerificationLink);
			creditBureauVerificationBatchProcess();
		}
		SimulatorUtilities.wait(4000);
		clickWhenClickable(manualApprovalLink);
		switchToIframe(CREDIT_BUREAU_VERIFICATION_FRAME);
		clickOkButton();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(batchNoColumn));
	}
}