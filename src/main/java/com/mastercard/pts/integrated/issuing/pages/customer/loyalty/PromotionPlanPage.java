package com.mastercard.pts.integrated.issuing.pages.customer.loyalty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.loyalty.PromotionPlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.DBUtility;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = LoyaltyNav.TAB_LOYALTY, treeMenuItems = { LoyaltyNav.L1_LOYALTY_SETUP,
		LoyaltyNav.L2_PROMOTION_PLAN })
public class PromotionPlanPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(PromotionPlanPage.class);
	private static final String ADD_PROMOTION_PLAN = "Add Promotion Plan";
	private static final String EDIT_PROMOTION_PLAN = "Edit Promotion Plan";
	private static final String TEXT = "TEST";
	private static final int NUMBER = 3;
	private static final String currency="INR [356]";
	private String pointsEarned;
	
	@Autowired
	public DBUtility dbutil;
	
	@Autowired
	private TestContext context;

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

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='lypMcgCode']/select")
	private MCWebElement mcgRuleDdwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=lypTxnAmt]")
	private MCWebElement floorTxnAmtTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=lypCumTxnamt]")
	private MCWebElement thresholdAmtTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=lypCumNotxns]")
	private MCWebElement NoOfTrnxsTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@fld_fqn='lypCalculationMethod']/input[@value='P']")
	private MCWebElement calculationMethodPerTXn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@fld_fqn='lypCalculationMethod']/input[@value='C']")
	private MCWebElement calculationMethodCumulativeTXn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@fld_fqn='lypPromotionType']/input[@value='I']")
	private MCWebElement promotionTypeissuance;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@fld_fqn='lypPromotionType']/input[@value='T']")
	private MCWebElement promotionTypetransaction;


	public void verifyUiOperationStatus(PromotionPlan plan) {
		logger.info("Promotion Plan");
		addPromotionPlanConfiguration(plan);
		verifyUiOperation("Add Promotion Plan");
	}

	public void verifyUiOperationStatuswithMCG(PromotionPlan plan) {
		logger.info("Promotion Plan");
		addPromotionPlanConfigurationwithMCG(plan);
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

	public void addPromotionPlanConfigurationwithMCG(PromotionPlan plan) {
		logger.info(ADD_PROMOTION_PLAN);
		clickAddNewButton();
		runWithinPopup(ADD_PROMOTION_PLAN, () -> {
			addPromotionPlanwithMCG(plan);
			verifyAlreadyExistsAndClickCancel();
		});
	}
	
	public void inputFromDate() {
		String currentDateString = dbutil.getCurrentDateForInstitution(context.get("USER_INSTITUTION_SELECTED"));
		LocalDate date = LocalDate.parse(currentDateString, DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss")).plusDays(1);
		WebElementUtils.pickDate(startDateDPkr, date);
	}
	
	public void inputToDate(){
		String currentDateString = dbutil.getCurrentDateForInstitution(context.get("USER_INSTITUTION_SELECTED"));
		LocalDate date = LocalDate.parse(currentDateString, DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss")).plusDays(100);
		WebElementUtils.pickDate(endDateDPkr, date);
		
	}

	private void addPromotionPlan(PromotionPlan plan) {
		WebElementUtils.enterText(lypPromotionCodeTxt, plan.getPromotionPlanCode());
		WebElementUtils.enterText(lypDescriptionTxt, plan.getPromotionDescription());
		WebElementUtils.selectDropDownByVisibleText(currencyDDwn, plan.getPromotionCurrency());
		WebElementUtils.enterText(lypAmtSpentTxt, plan.getPromotionamountSpent());
		waitForElementVisible(startDateDPkr);
		inputFromDate();
		waitForElementVisible(endDateDPkr);
		inputToDate();
		WebElementUtils.enterText(lypPtsEarnedTxt, plan.getPromotionpointsEarned());
		WebElementUtils.enterText(lypPriorrunsTxt, NUMBER);
		WebElementUtils.enterText(lypCumTxnamtTxt, NUMBER);
		WebElementUtils.enterText(lypCumNotxnsTxt, NUMBER);
		clickWhenClickable(calculationMethodPerTXn);
		WebElementUtils.enterText(floorTxnAmtTxt, plan.getFloortransactionAmount());
		WebElementUtils.selectDropDownByVisibleText(mccRuleDdwn, plan.getMccCode());
		clickSaveButton();
	}


	private void addPromotionPlanwithMCG(PromotionPlan plan) {
		WebElementUtils.enterText(lypPromotionCodeTxt, plan.getPromotionPlanCode());
		WebElementUtils.enterText(lypDescriptionTxt, plan.getPromotionDescription());
		WebElementUtils.selectDropDownByVisibleText(currencyDDwn, plan.getPromotionCurrency());
		WebElementUtils.enterText(lypAmtSpentTxt, plan.getPromotionamountSpent());
		waitForElementVisible(startDateDPkr);
		inputFromDate();
		waitForElementVisible(endDateDPkr);
		inputToDate();
		WebElementUtils.enterText(lypPtsEarnedTxt, plan.getPromotionpointsEarned());
		WebElementUtils.enterText(lypPriorrunsTxt, NUMBER);
		WebElementUtils.enterText(lypCumTxnamtTxt, NUMBER);
		WebElementUtils.enterText(lypCumNotxnsTxt, NUMBER);
		clickWhenClickable(calculationMethodPerTXn);
		WebElementUtils.enterText(floorTxnAmtTxt, plan.getFloortransactionAmount());
		WebElementUtils.selectDropDownByVisibleText(mcgRuleDdwn, plan.getMcgCode());
		clickSaveButton();
	}

	public void addPromotionPlanwithIssuance(PromotionPlan plan) {
		clickAddNewButton();
		runWithinPopup(ADD_PROMOTION_PLAN, () -> {
			WebElementUtils.enterText(lypPromotionCodeTxt, plan.getPromotionPlanCode());
			WebElementUtils.enterText(lypDescriptionTxt, plan.getPromotionDescription());
			WebElementUtils.selectRadioBtn(promotionTypeissuance);
			WebElementUtils.selectDropDownByVisibleText(currencyDDwn, plan.getPromotionCurrency());
			waitForElementVisible(startDateDPkr);
			inputFromDate();
			waitForElementVisible(endDateDPkr);
			WebElementUtils.pickDate(endDateDPkr, futureEndDate);
			WebElementUtils.enterText(lypPtsEarnedTxt, plan.getPromotionIssuancepointsEarned());
			WebElementUtils.enterText(lypPriorrunsTxt, NUMBER);
			clickSaveButton();
		});
	}

	public void addPromotionPlanwithCumulativeTxn(PromotionPlan plan) {
		clickAddNewButton();
		runWithinPopup(ADD_PROMOTION_PLAN, () -> {
			WebElementUtils.enterText(lypPromotionCodeTxt, plan.getPromotionPlanCode());
			WebElementUtils.enterText(lypDescriptionTxt, plan.getPromotionDescription());
			WebElementUtils.selectDropDownByVisibleText(currencyDDwn, plan.getPromotionCurrency());
			WebElementUtils.enterText(lypAmtSpentTxt, plan.getPromotionamountSpent());
			waitForElementVisible(startDateDPkr);
			inputFromDate();
			waitForElementVisible(endDateDPkr);
			inputToDate();
			WebElementUtils.enterText(lypPtsEarnedTxt, plan.getPromotionpointsEarned());
			WebElementUtils.enterText(lypPriorrunsTxt, NUMBER);
			WebElementUtils.enterText(lypCumTxnamtTxt, NUMBER);
			WebElementUtils.enterText(lypCumNotxnsTxt, NUMBER);
			clickWhenClickable(calculationMethodCumulativeTXn);
			WebElementUtils.enterText(thresholdAmtTxt, plan.getThresholdAmount());
			WebElementUtils.enterText(NoOfTrnxsTxt, plan.getNumberOfTransactions());
			WebElementUtils.selectDropDownByVisibleText(mccRuleDdwn, plan.getMccCode());
			clickSaveButton();
		});
	}

	public void editpromotionPlanStartDate(PromotionPlan plan) {
		WebElementUtils.enterText(lypPromotionCodeTxt, plan.getPromotionPlanCode());
		clickSearchButton();
		SimulatorUtilities.wait(5000);
		editFirstRecord();
		runWithinPopup("Edit Promotion Plan", () -> {
			waitForElementVisible(startDateDPkr);
			WebElementUtils.pickDate(startDateDPkr, LocalDate.now());
			clickSaveButton();
		});
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(promotionalPlanCodeTxt));
	}
	
	public String getPointsEarned() {
		runWithinPopup(EDIT_PROMOTION_PLAN, () -> {
			pointsEarned = lypPtsEarnedTxt.getAttribute("value");
			clickCancelButton();
		});
		return pointsEarned;
	}
	
	public void searchByPlanCode(String code) {
		WebElementUtils.enterText(lypPromotionCodeTxt, code);
		clickSearchButton();
		editFirstRecord();
	}
	
	public String getAmountSpent() {
		runWithinPopup(EDIT_PROMOTION_PLAN, () -> {
			pointsEarned = lypAmtSpentTxt.getAttribute("value");
			clickCancelButton();
		});
		return pointsEarned;
	}

	public void selectPromoRulesMCG(String value) {
		runWithinPopup(EDIT_PROMOTION_PLAN, () -> {
			WebElementUtils.selectDropDownByValue(mcgRuleDdwn, value);
			saveOrDetailsOrSearchClick();
		});
	}
}
