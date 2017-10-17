package com.mastercard.pts.integrated.issuing.pages.customer.loyalty;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = LoyaltyNav.TAB_LOYALTY, treeMenuItems = { LoyaltyNav.L1_LOYALTY_SETUP, LoyaltyNav.L2_PROMOTION_PLAN })
public class PromotionPlanPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(PromotionPlanPage.class);
	private static final String ADD_PROMOTION_PLAN = "Add Promotion Plan";
	private static final String TEXT = "TEST";
	private static final int NUMBER = 1;


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
	
	public void verifyUiOperationStatus() {
		logger.info("Promotion Plan");
		addPromotionPlanConfiguration();
		verifyUiOperation("Add Promotion Plan");
	}

	public void addPromotionPlanConfiguration() {
		logger.info(ADD_PROMOTION_PLAN);
		clickAddNewButton();
		runWithinPopup(ADD_PROMOTION_PLAN, () -> {
			addPromotionPlan();
			verifyAlreadyExistsAndClickCancel();
		});
	}

	private void addPromotionPlan() {
		WebElementUtils.enterText(lypPromotionCodeTxt, MiscUtils.generate10CharAlphaNumeric());
		WebElementUtils.enterText(lypDescriptionTxt, TEXT);
		WebElementUtils.selectDropDownByIndex(currencyDDwn, NUMBER);
		WebElementUtils.enterText(lypAmtSpentTxt, NUMBER);
		WebElementUtils.pickDate(startDateDPkr, futureDate);
		WebElementUtils.pickDate(endDateDPkr, futureDate);
		WebElementUtils.enterText(lypPtsEarnedTxt, NUMBER);
		WebElementUtils.enterText(lypPriorrunsTxt, NUMBER);
		WebElementUtils.enterText(lypCumTxnamtTxt, NUMBER);
		WebElementUtils.enterText(lypCumNotxnsTxt, NUMBER);
		clickSaveButton();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(promotionalPlanCodeTxt));
	}
}
