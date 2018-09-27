package com.mastercard.pts.integrated.issuing.pages.customer.loyalty;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.loyalty.PromotionPlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = LoyaltyNav.TAB_LOYALTY, treeMenuItems = { LoyaltyNav.L1_LOYALTY_SETUP,
		LoyaltyNav.L2_PROMOTION_PLAN })
public class PromotionPlanPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(PromotionPlanPage.class);
	private static final String ADD_PROMOTION_PLAN = "Add Promotion Plan";
	private static final String TEXT = "TEST";
	private static final int NUMBER = 3;
	private static final String currency = "INR [356]";

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:inputTextField")
	private MCWebElement promotionalPlanCodeTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=lypPromotionCode]")
	private MCWebElement lypPromotionCodeTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=lypDescription]")
	private MCWebElement lypDescriptionTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='lypStartDttm']/..")
	private MCWebElement startDateDPkr;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='lypExpiryDttm']/..")
	private MCWebElement endDateDPkr;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:4:cols:nextCol:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement currencyDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=lypAmtSpent]")
	private MCWebElement lypAmtSpentTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=lypPtsEarned]")
	private MCWebElement lypPtsEarnedTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=lypPriorruns]")
	private MCWebElement lypPriorrunsTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=lypCumTxnamt]")
	private MCWebElement lypCumTxnamtTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=lypCumNotxns]")
	private MCWebElement lypCumNotxnsTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='lypMccCode']/select")
	private MCWebElement mccRuleDdwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=lypTxnAmt]")
	private MCWebElement floorTxnAmtTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@fld_fqn='lypCalculationMethod']/input[@value='P']")
	private MCWebElement calculationMethodPerTXn;

	public void verifyUiOperationStatus(PromotionPlan plan) {
		logger.info("Promotion Plan");
		addPromotionPlanConfiguration(plan);
		verifyUiOperation("Add Promotion Plan");
	}

	public void addPromotionPlanConfiguration(PromotionPlan plan) {
		logger.info(ADD_PROMOTION_PLAN);
		clickAddNewButton();
		runWithinPopup(ADD_PROMOTION_PLAN, () -> {
			addPromotionPlan(plan);
			verifyAlreadyExistsAndClickCancel();
		});
	}

	private void addPromotionPlan(PromotionPlan plan) {
		WebElementUtils.enterText(lypPromotionCodeTxt, plan.getPromotionPlanCode());
		WebElementUtils.enterText(lypDescriptionTxt, plan.getPromotionDescription());
		WebElementUtils.selectDropDownByVisibleText(currencyDDwn, plan.getPromotionCurrency());
		WebElementUtils.enterText(lypAmtSpentTxt, plan.getPromotionamountSpent());
		waitForElementVisible(startDateDPkr);
		WebElementUtils.pickDate(startDateDPkr, futureDate);
		waitForElementVisible(endDateDPkr);
		WebElementUtils.pickDate(endDateDPkr, futureEndDate);
		WebElementUtils.enterText(lypPtsEarnedTxt, plan.getPromotionpointsEarned());
		WebElementUtils.enterText(lypPriorrunsTxt, NUMBER);
		WebElementUtils.enterText(lypCumTxnamtTxt, NUMBER);
		WebElementUtils.enterText(lypCumNotxnsTxt, NUMBER);
		clickWhenClickable(calculationMethodPerTXn);
		WebElementUtils.enterText(floorTxnAmtTxt, plan.getFloortransactionAmount());
		WebElementUtils.selectDropDownByVisibleText(mccRuleDdwn, plan.getMccCode());
		clickSaveButton();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(promotionalPlanCodeTxt));
	}
}
