package com.mastercard.pts.integrated.issuing.pages.customer.loyalty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.LoyaltyPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.loyalty.NewLoyaltyPlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.DBUtility;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = LoyaltyNav.TAB_LOYALTY, treeMenuItems = { LoyaltyNav.L1_LOYALTY_SETUP,
		LoyaltyNav.L2_LOYALTY_PLAN })
public class LoyaltyPlanPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(LoyaltyPlanPage.class);
	private static final String TEXT = "TEST";
	private static final int NUMBER = 3;
	private static final int NUMBER1 = 1;
	private static final String ADD_LOYALTY_PLAN = "Add Loyalty Plan";
	private static final String EDIT_LOYALTY_PLAN = "Edit Loyalty Plan";
	private static final String currency="INR [356]";
	private String maxPtsPerCycle;


	@Autowired
	private DBUtility dbUtil;
	
	@Autowired
	NewLoyaltyPlan newLoyaltyPlan;
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
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='maxPtsPerCycle']/..")
	private MCWebElement maxPtsPerCycleValue;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:3:cols:nextCol:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement periodUnitDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=lytValidityNum]")
	private MCWebElement lytValidityNumTxt;

	@PageElement(findBy = FindBy.ID, valueToFind = "lytCalcMethod")
	private MCWebElement roundedOffChkBox;
	
	@PageElement(findBy = FindBy.ID, valueToFind = "lytPlanAutoRedeemFlg")
	private MCWebElement autoRedemptionChkBox;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='lytPlanAutoRedemDayMethod']/select")
	private MCWebElement autoredemptionmethodDDWn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='lytPlanAutoRedeemMinPts']/input")
	private MCWebElement autoredemptionMinAmtTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='lytPlanAutoRedeemDay']/input")
	private MCWebElement autoredemptionDayTxt;
	
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "span.time>label+label")
	private MCWebElement institutionDateTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=lytMinPts]")
	private MCWebElement lytMinPtsTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=lytGraceDays]")
	private MCWebElement lytGraceDaysTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=lytRedeemPts]")
	private MCWebElement lytRedeemPtsTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=lytRedeemAmt]")
	private MCWebElement lytRedeemAmtTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "//input[@name='radtables:1:rows:5:cols:colspanMarkup:inputField:radioComponentio' and @value='A']")
	private MCWebElement radioBtnActive;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name='tables:1:rows:5:cols:colspanMarkup:inputField:radioComponent' and @value='I']")
	private MCWebElement radioBtnInactive;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:6:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement blockedMCG;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@alt='Edit Record']")
	private MCWebElement editBtn;

	public void verifyUiOperationStatus(String instCode) {
		logger.info(ADD_LOYALTY_PLAN);
		addLoyaltyPlanConfiguration(instCode);
		verifyUiOperation(ADD_LOYALTY_PLAN);
	}

	public void addLoyaltyPlanConfiguration(String instCode) {
		logger.info(ADD_LOYALTY_PLAN);
		clickAddNewButton();
		runWithinPopup(ADD_LOYALTY_PLAN, () -> {
			addLoyaltyPlan(instCode);
			verifyAlreadyExistsAndClickCancel();
		});
	}
	

		
	public void inputFromDate(String instCode) {
		String currentDateString = dbUtil.getCurrentDateForInstitution(instCode);
		LocalDate date = LocalDate.parse(currentDateString, DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss")).plusDays(1);
		WebElementUtils.pickDate(planStartDateDPkr, date);
	}


	private void addLoyaltyPlan(String instCode) {
		WebElementUtils.enterText(lytPlanCodeTxt, CustomUtils.randomAlphaNumeric(5).toUpperCase());
		WebElementUtils.enterText(lytDescriptionTxt, TEXT);
		WebElementUtils.selectDropDownByVisibleText(currencyDDwn, currency);
		WebElementUtils.enterText(lytValidityNumTxt, NUMBER);
		inputFromDate(instCode);
		WebElementUtils.enterText(maxPtsPerCycleTxt, NUMBER);
		WebElementUtils.selectDropDownByIndex(periodUnitDDwn, NUMBER1);
		WebElementUtils.enterText(lytMinPtsTxt, NUMBER);
		WebElementUtils.enterText(lytGraceDaysTxt, NUMBER);
		WebElementUtils.enterText(lytRedeemPtsTxt, NUMBER);
		WebElementUtils.enterText(lytRedeemAmtTxt, NUMBER);
		ClickCheckBox(roundedOffChkBox, true);
		newLoyaltyPlan.setLoyaltyPlan(lytPlanCodeTxt.getAttribute("value"));
		clickSaveButton();
	}
	
	public void addLoyaltyPlanforAutoRedemption(LoyaltyPlan plan, String instCode) {
		clickAddNewButton();
		runWithinPopup(ADD_LOYALTY_PLAN, () -> {
		WebElementUtils.enterText(lytPlanCodeTxt, plan.getLoyaltyPlanCode());
		WebElementUtils.enterText(lytDescriptionTxt, plan.getDescription());
		WebElementUtils.selectDropDownByVisibleText(currencyDDwn, currency);
		WebElementUtils.enterText(lytValidityNumTxt, NUMBER);
		inputFromDate(instCode);
		WebElementUtils.enterText(maxPtsPerCycleTxt, NUMBER);
		WebElementUtils.selectDropDownByIndex(periodUnitDDwn, NUMBER1);
		WebElementUtils.enterText(lytMinPtsTxt, NUMBER);
		WebElementUtils.enterText(lytGraceDaysTxt, NUMBER);
		WebElementUtils.enterText(lytRedeemPtsTxt, NUMBER);
		WebElementUtils.enterText(lytRedeemAmtTxt, NUMBER);
		ClickCheckBox(roundedOffChkBox, true);
		
		ClickCheckBox(autoRedemptionChkBox, true);
		WebElementUtils.selectDropDownByVisibleText(autoredemptionmethodDDWn, plan.getAutoRedemptionMethod());
		WebElementUtils.enterText(autoredemptionMinAmtTxt, plan.getAutoRedemptionMinAmt());
		WebElementUtils.enterText(autoredemptionDayTxt, plan.getAutoRedemptionDay());
		
		newLoyaltyPlan.setLoyaltyPlan(lytPlanCodeTxt.getAttribute("value"));
		clickSaveButton();
		});
	}

	public void editLoyaltyPlan(LoyaltyPlan loyaltyplan) {
		WebElementUtils.enterText(lytPlanCodeTxt, loyaltyplan.getLoyaltyTransactionPlan());
		clickSearchButton();
		SimulatorUtilities.wait(5000);
		editBtn.click();
		runWithinPopup("Edit Loyalty Plan", () -> {
			if(loyaltyplan.getMaxloyaltypoints()!= null)
			WebElementUtils.enterText(maxPtsPerCycleTxt, loyaltyplan.getMaxloyaltypoints());
			if(loyaltyplan.getAutoRedemptionDay()!= null)
				WebElementUtils.enterText(autoredemptionDayTxt, loyaltyplan.getAutoRedemptionDay());
			clickSaveButton();
		});
	}


	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(loyaltyPlanCodeTxt));
	}
	
	public void searchByPlanCode(String code) {
		WebElementUtils.enterText(lytPlanCodeTxt, code);
		clickSearchButton();
		editFirstRecord();
	}
	
	public String getMaxPtsPerCycle() {
		runWithinPopup(EDIT_LOYALTY_PLAN, () -> {
			maxPtsPerCycle = maxPtsPerCycleValue.getAttribute("value");
			clickCancelButton();
		});
		return maxPtsPerCycle;
	}
	
	public void disableLoyaltyPlan() {
		runWithinPopup(EDIT_LOYALTY_PLAN, () -> {
			WebElementUtils.selectRadioBtn(radioBtnInactive);
			saveOrDetailsOrSearchClick();
		});
	}
	
	public void selectPeriodUnitByIndex(String value) {
		runWithinPopup(EDIT_LOYALTY_PLAN, () -> {
			WebElementUtils.selectDropDownByValue(periodUnitDDwn, value);
			saveOrDetailsOrSearchClick();
		});
	}
	
	public void selectBlockedMCG(String value) {
		runWithinPopup(EDIT_LOYALTY_PLAN, () -> {
			WebElementUtils.selectDropDownByValue(blockedMCG, value);
			saveOrDetailsOrSearchClick();
		});
	}

}
