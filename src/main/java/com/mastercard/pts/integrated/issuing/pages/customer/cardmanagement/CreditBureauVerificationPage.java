package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value='OK']")
	private MCWebElement okBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "table.dataview")
	private MCWebElement searchTable;

	public void creditBureauVerificationBatchProcess() {
		if (!WebElementUtils.isTextAvailableinTable(searchTable, context.get(CreditConstants.PRIMARY_BATCH_NUMBER))) {
			clickWhenClickable(creditBureauVerificationLink);
			creditBureauVerificationBatchProcess();
		}
	}
	
	public void switchToManualApprovalLink() {
		clickOnManualApprovalIfBatchAvailableinTable(searchTable, context.get(CreditConstants.PRIMARY_BATCH_NUMBER));
		switchToIframe(CREDIT_BUREAU_VERIFICATION_FRAME);
		clickWhenClickable(okBtn);
		SimulatorUtilities.wait(3000);
		clickOncheckBoxIfBatchAvailableinTable(searchTable, context.get(CreditConstants.PRIMARY_BATCH_NUMBER));
		return;
	}
	
	public void clickOnManualApprovalIfBatchAvailableinTable(MCWebElement tableHandle, String text) {
		WebElement table = asWebElement(tableHandle);
		List<WebElement> rowstable = table.findElements(By.tagName("tr"));
		int rowscount = rowstable.size();
		outerloop:
		for (int row = 1; row < rowscount; row++) {
			List<WebElement> columnsrow = rowstable.get(row).findElements(By.tagName("td"));
			int columnscount = columnsrow.size();
			for (int col = 0; col < columnscount; col++) {
				if (columnsrow.get(col).getText().equals(text)) {
					WebElement checkBox = columnsrow.get(columnscount - 1).findElement(By.xpath("//img[@alt='Edit Record']"));
					if (checkBox.isEnabled() && !checkBox.isSelected()) {
						checkBox.click();
					}

				}
				break outerloop;

			}
		}
	}
}
