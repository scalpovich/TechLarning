package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MCCOverlimit;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_PROGRAM_SETUP,
		CardManagementNav.L2_WALLET_CONFIGURATION, CardManagementNav.L3_MCC_OVERLIMIT })
public class MCCOverlimitPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(MCCOverlimitPage.class);
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement walletPlanSearchDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "walletPlanCode:input:dropdowncomponent")
	private MCWebElement walletPlanDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "currencyCode:input:dropdowncomponent")
	private MCWebElement currencyDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "fromMccCode:input:inputTextField")
	private MCWebElement mccSearchCriteriaFromTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "toMccCode:input:inputTextField")
	private MCWebElement mccSearchCriteriaToTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='overdrawnFixedAmt']")
	private MCWebElement overlimitFixedAmount;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='overdrawnPerm']")
	private MCWebElement overlimitPercentage;

	public void verifyUiOperationStatus() {
		logger.info("MCC Overlimit");
		verifyUiOperation("Add MCC Overlimit");
	}

	public void addMccOverlimit(MCCOverlimit mccOverlimit) {
		clickAddNewButton();
		runWithinPopup("Add MCC Overlimit", () -> {
			WebElementUtils.selectDDByVisibleText(walletPlanDdwn, mccOverlimit.getWalletPlan());
			WebElementUtils.selectDDByVisibleText(currencyDdwn, mccOverlimit.getCurrency());
			WebElementUtils.enterText(mccSearchCriteriaFromTxt, mccOverlimit.getMerchantCategoryCode());
			WebElementUtils.enterText(mccSearchCriteriaToTxt, mccOverlimit.getMerchantCategoryCode());
			clickSearchButton();
			WebElementUtils.enterText(overlimitFixedAmount, mccOverlimit.getOverlimitFixedAmount());
			WebElementUtils.enterText(overlimitPercentage, mccOverlimit.getOverlimitPercentage());
			clickSaveButton();
		});
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(walletPlanSearchDdwn));
	}
	
	public String getFeedbackMessage() {
		return getSuccessMessage();
	}
}
