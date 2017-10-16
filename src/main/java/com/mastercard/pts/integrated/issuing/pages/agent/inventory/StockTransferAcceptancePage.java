package com.mastercard.pts.integrated.issuing.pages.agent.inventory;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = InventoryNav.TAB_INVENTORY, treeMenuItems = { InventoryNav.L1_STOCK_TRANSFER, InventoryNav.L2_STOCK_TRANSFER_ACCEPTANCE })
public class StockTransferAcceptancePage extends InventoryAbstractPage {
	private static final Logger logger = LoggerFactory.getLogger(StockTransferAcceptancePage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "#transferNo")
	private MCWebElement transferNoDDwn;

	@Override
	public void verifyUiOperationStatus() {
		logger.info("Acceptance");
		verifyButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(brancIdDDwn),
				WebElementUtils.visibilityOf(transferNoDDwn));
	}
}