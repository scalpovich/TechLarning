package com.mastercard.pts.integrated.issuing.pages.customer.loyalty;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = LoyaltyNav.TAB_LOYALTY, treeMenuItems = { LoyaltyNav.L1_LOYALTY_SETUP, LoyaltyNav.L2_LOYALTY_PLAN })
public class LoyaltyPlanPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory.getLogger(LoyaltyPlanPage.class);
	private static final String TEXT = "TEST";
	private static final int NUMBER = 1;
	private static final String ADD_LOYALTY_PLAN = "Add Loyalty Plan";

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:inputTextField")
	private MCWebElement loyaltyPlanCodeTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=lytPlanCode]")
	private MCWebElement lytPlanCodeTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=lytDescription]")
	private MCWebElement lytDescriptionTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:2:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement currencyDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='lytStartDttm']/..")
	private MCWebElement planStartDateDPkr;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=maxPtsPerCycle]")
	private MCWebElement maxPtsPerCycleTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:3:cols:nextCol:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement periodUnitDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=lytValidityNum]")
	private MCWebElement lytValidityNumTxt;

	@PageElement(findBy = FindBy.ID, valueToFind = "lytCalcMethod")
	private MCWebElement roundedOffChkBox;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=lytMinPts]")
	private MCWebElement lytMinPtsTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=lytGraceDays]")
	private MCWebElement lytGraceDaysTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=lytRedeemPts]")
	private MCWebElement lytRedeemPtsTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=lytRedeemAmt]")
	private MCWebElement lytRedeemAmtTxt;

	public void verifyUiOperationStatus() {
		logger.info(ADD_LOYALTY_PLAN);
		addLoyaltyPlanConfiguration();
		verifyUiOperation(ADD_LOYALTY_PLAN);
	}

	public void addLoyaltyPlanConfiguration() {
		logger.info(ADD_LOYALTY_PLAN);
		clickAddNewButton();
		runWithinPopup(ADD_LOYALTY_PLAN, () -> {
			addLoyaltyPlan();
			verifyAlreadyExistsAndClickCancel();
		});
	}

	private void addLoyaltyPlan() {
		WebElementUtils.enterText(lytPlanCodeTxt, MiscUtils.generate10CharAlphaNumeric());
		WebElementUtils.enterText(lytDescriptionTxt, TEXT);
		WebElementUtils.selectDropDownByIndex(currencyDDwn, NUMBER);
		WebElementUtils.enterText(lytValidityNumTxt, NUMBER);
		WebElementUtils.pickDate(planStartDateDPkr, futureDate);
		WebElementUtils.enterText(maxPtsPerCycleTxt, NUMBER);
		WebElementUtils.selectDropDownByIndex(periodUnitDDwn, NUMBER);
		WebElementUtils.enterText(lytMinPtsTxt, NUMBER);
		WebElementUtils.enterText(lytGraceDaysTxt, NUMBER);
		WebElementUtils.enterText(lytRedeemPtsTxt, NUMBER);
		WebElementUtils.enterText(lytRedeemAmtTxt, NUMBER);
		clickSaveButton();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(loyaltyPlanCodeTxt));
	}
}
