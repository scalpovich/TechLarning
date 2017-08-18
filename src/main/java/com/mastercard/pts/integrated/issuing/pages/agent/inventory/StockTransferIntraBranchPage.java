package com.mastercard.pts.integrated.issuing.pages.agent.inventory;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = InventoryNav.TAB_INVENTORY, treeMenuItems = { InventoryNav.L1_STOCK_TRANSFER, InventoryNav.L2_STOCK_TRANSFER_INTRA_BRANCH })
public class StockTransferIntraBranchPage extends AbstractModelPage {
	private static final Logger logger = LoggerFactory.getLogger(StockTransferIntraBranchPage.class);

	@Value("${default.wait.timeout_in_sec}")
	private long timeoutInSec;

	// main screen locators
	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#brancId")
	private MCWebElement brancIdDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#programCode")
	private MCWebElement programCodeDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#deviceType")
	private MCWebElement deviceTypeDDwn;

	public void verifyUiOperationStatus() {
		logger.info("Intra Branch Details");
		verifyButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(brancIdDDwn),
				WebElementUtils.visibilityOf(programCodeDDwn), WebElementUtils.visibilityOf(deviceTypeDDwn));
	}

	// methods
	public String getMasterDetailContentTitleText() {
		logger.info("Stock Transfer Intra Branch Master Detail Tilte Text: {}");
		return new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(masterDetailContentTitle)).getText();
	}
}
