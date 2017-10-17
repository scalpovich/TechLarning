package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_RUPAY_SETTLEMENT_BIN
		})

public class RupaySettlementBINPage extends AbstractBasePage {
	
	private static final Logger logger = LoggerFactory.getLogger(RupaySettlementBINPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement deviceBin;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement rupayProductCode;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=settlementBin]")
	private MCWebElement settlementBin;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=participantId]")
	private MCWebElement participantId;
	
	public void verifyUiOperationStatus() {
		logger.info("RuPay Settlement BIN");
		verifyUiOperation("Add RuPay Settlement BIN");
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(deviceBin),
				WebElementUtils.elementToBeClickable(rupayProductCode),
				WebElementUtils.elementToBeClickable(settlementBin),
				WebElementUtils.elementToBeClickable(participantId)
				);
	}
}