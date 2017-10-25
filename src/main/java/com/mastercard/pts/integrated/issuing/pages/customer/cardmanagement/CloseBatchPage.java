package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_OPERATION,
		CardManagementNav.L2_OPERATION_APPLICATION,
		CardManagementNav.L3_OPERATION_APPLICATION_CREDIT,
		CardManagementNav.L4_CLOSE_BATCH })
public class CloseBatchPage extends AbstractBasePage {

	@PageElement(findBy = FindBy.CSS, valueToFind = ".dataview-div")
	private MCWebElement batchNoColumn;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div[4]/div[2]/div[2]/form[1]/div[2]/div[4]/table/tbody/tr/td[10]/span/input")
	private MCWebElement CloseBatchRecord;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement ProcessSelected;

	public void closebatch() {
		CloseBatchRecord.click();
		CustomUtils.ThreadDotSleep(1000);
		ProcessSelected.click();
		CustomUtils.ThreadDotSleep(1000);
	}


	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(batchNoColumn));
	}
}