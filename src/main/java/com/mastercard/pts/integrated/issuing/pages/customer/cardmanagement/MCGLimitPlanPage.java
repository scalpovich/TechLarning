package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MCGLimitPlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP,
		CardManagementNav.L2_WALLET_CONFIGURATION,
		CardManagementNav.L3_MCG_LIMIT_PLAN })
public class MCGLimitPlanPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(MCGLimitPlanPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=mcgLimitPlanCode]")
	private MCWebElement mcgLimitPlanCodeTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=description]")
	private MCWebElement descriptionTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement productTypeDdwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "mcgLimitPlanCode:input:inputTextField")
	private MCWebElement addMcgLimitPlanCodeTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "description:input:inputTextField")
	private MCWebElement addDescriptionTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "productType:input:dropdowncomponent")
	private MCWebElement addProductTypeDdwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "effectiveDate:input:dateTextField")
	private MCWebElement effectiveDatePkr;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "endDate:input:dateTextField")
	private MCWebElement endDatePkr;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "mcgAuthPeriod:input:dropdowncomponent")
	private MCWebElement periodDdwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "periodNumber:input:inputTextField")
	private MCWebElement periodNumberTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mcgCode:input:dropdowncomponent")
	private MCWebElement mcgCodeDdwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "fromMonthOnBook:input:inputTextField")
	private MCWebElement fromMonthOnBookTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "toMonthOnBook:input:inputTextField")
	private MCWebElement toMonthOnBookTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "perTxnAmtDom:input:inputAmountField")
	private MCWebElement perTransactionAmountTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "perTxnAmtDomResp:input:dropdowncomponent")
	private MCWebElement perTransactionResponseDdwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "dailyVelDom:input:inputTextField")
	private MCWebElement dailyVelocityTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "dailyVelDomResp:input:dropdowncomponent")
	private MCWebElement dailyVelocityResponseDdwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "perTxnPercentage:input:inputTextField")
	private MCWebElement perTransactionPercentageOfCreditLimitTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "dailyAmtDom:input:inputAmountField")
	private MCWebElement dailyAmountTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "dailyAmtDomResp:input:dropdowncomponent")
	private MCWebElement dailyAmountResponseDdwn;
		
	@PageElement(findBy = FindBy.NAME, valueToFind = "dailyPercentageDom:input:inputTextField")
	private MCWebElement dailyPercentageOfCreditLimitTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "periodicAmtDom:input:inputAmountField")
	private MCWebElement periodicAmountTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "periodicAmtDomResp:input:dropdowncomponent")
	private MCWebElement periodicAmountResponseDdwn;
		
	@PageElement(findBy = FindBy.NAME, valueToFind = "periodicPercentageDom:input:inputTextField")
	private MCWebElement periodicPercentageOfCreditLimitTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "periodicVelDom:input:inputTextField")
	private MCWebElement periodicVelocityTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "periodicVelDomResp:input:dropdowncomponent")
	private MCWebElement periodicVelocityResponseDdwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "perTxnAmtInt:input:inputAmountField")
	private MCWebElement perTransactionInternationalAmountTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "perTxnAmtIntResp:input:dropdowncomponent")
	private MCWebElement perTransactionInternationalResponseDdwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "dailyVelInt:input:inputTextField")
	private MCWebElement dailyVelocityInternationalTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "dailyVelIntResp:input:dropdowncomponent")
	private MCWebElement dailyVelocityInternationalResponseDdwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "perTxnPercentageInt:input:inputTextField")
	private MCWebElement perTransactionInternationalPercentageOfCreditLimitTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "dailyAmtInt:input:inputAmountField")
	private MCWebElement dailyAmountInternationalTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "dailyAmtIntResp:input:dropdowncomponent")
	private MCWebElement dailyAmountInternationalResponseDdwn;
		
	@PageElement(findBy = FindBy.NAME, valueToFind = "dailyPercentageInt:input:inputTextField")
	private MCWebElement dailyPercentageOfCreditLimitInternationalTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "periodicAmtInt:input:inputAmountField")
	private MCWebElement periodicAmountInternationalTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "periodicAmtIntResp:input:dropdowncomponent")
	private MCWebElement periodicAmountInternationalResponseDdwn;
		
	@PageElement(findBy = FindBy.NAME, valueToFind = "periodicPercentageDom:input:inputTextField")
	private MCWebElement periodicPercentageOfCreditLimitInternationalTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "periodicVelInt:input:inputTextField")
	private MCWebElement periodicVelocityInternationalTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "periodicVelIntResp:input:dropdowncomponent")
	private MCWebElement periodicVelocityInternationalResponseDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:inputTextField")
	private MCWebElement planCodeSearchTxt;		
	
	private static final String FRAME_ADD_MCG_LIMIT_PLAN = "Add MCG Limit Plan";
	private static final String FRAME_ADD_MCG_LIMIT_PLAN_DETAILS = "Add MCG Limit Plan Details";
	
	public void verifyUiOperationStatus() {
		logger.info("MCG Limit Plan");
		verifyUiOperation("Add MCG Limit Plan");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(mcgLimitPlanCodeTxt),
				WebElementUtils.elementToBeClickable(descriptionTxt),
				WebElementUtils.elementToBeClickable(productTypeDdwn)
				);
	}
	
	public void enterMcgLimitPlanCode(MCGLimitPlan plan){
		enterValueinTextBox(addMcgLimitPlanCodeTxt, plan.getMcgLimitPlanCode());
	}
	
	public void enterDescription(MCGLimitPlan plan){
		enterValueinTextBox(addDescriptionTxt, plan.getDescription());
	}
	
	public void addProductType(MCGLimitPlan plan){
		enterValueinTextBox(addProductTypeDdwn, plan.getProductType());
	}
	
	public void selectEffectiveDate(MCGLimitPlan plan){
		WebElementUtils.pickDate(effectiveDatePkr, plan.getEffectiveDate());
	}
	
	public void selectEndDate(MCGLimitPlan plan){
		WebElementUtils.pickDate(endDatePkr, plan.getEndDate());
	}	
	
	public void selectPeriod(MCGLimitPlan plan){
		selectByVisibleText(periodDdwn, plan.getPeriod());
	}
	
	public void enterPeriodNumber(MCGLimitPlan plan){
		enterValueinTextBox(periodNumberTxt, plan.getPeriodNumber());
	}
	
	public void selectMcgCode(MCGLimitPlan plan){
		selectByVisibleText(mcgCodeDdwn,plan.getMcgCode());
	}
	
	public void enterFromMomthOnBook(MCGLimitPlan plan){
		enterValueinTextBox(fromMonthOnBookTxt, plan.getFromMonthOnBook());
	}
	
	public void enterToMomthOnBook(MCGLimitPlan plan){
		enterValueinTextBox(toMonthOnBookTxt, plan.getToMonthOnBook());
	}
	
	public void enterPerTransactionAmount(MCGLimitPlan plan){
		enterValueinTextBox(perTransactionAmountTxt, plan.getPerTransactionAmount());
	}
	
	public void selectPerTransactionResponse(MCGLimitPlan plan){
		selectByVisibleText(perTransactionResponseDdwn, plan.getPerTransactionResponse());
	}
	
	public void enterperTransactionPercentageOFCreditLimit(MCGLimitPlan plan){
		enterValueinTextBox(perTransactionPercentageOfCreditLimitTxt, plan.getPerTransactionPercentageOfCreditLimit());
	}
	
	public void enterDailyAmount(MCGLimitPlan plan){
		enterValueinTextBox(dailyAmountTxt, plan.getDailyAmount());
	}
	
	public void selectDailyResponse(MCGLimitPlan plan){
		selectByVisibleText(dailyAmountResponseDdwn, plan.getDailyResponse());
	}
	
	public void enterDailyVelocity(MCGLimitPlan plan){
		enterValueinTextBox(dailyVelocityTxt, plan.getDailyVelocity());
	}
	
	public void selectDailyVelocityResponse(MCGLimitPlan plan){
		selectByVisibleText(dailyVelocityResponseDdwn, plan.getDailyVelocityResponse());
	}
	
	public void enterDailyPercentageOfCreditLimit(MCGLimitPlan plan){
		enterValueinTextBox(dailyPercentageOfCreditLimitTxt, plan.getDailyPercentageOfCreditLimit());
	}
	
	public void enterPeriodicAmount(MCGLimitPlan plan){
		enterValueinTextBox(periodicAmountTxt, plan.getPeriodicAmount());
	}
	
	public void selectPeriodicResponse(MCGLimitPlan plan){
		selectByVisibleText(periodicAmountResponseDdwn, plan.getPeriodicResponse());
	}
	
	public void enterPeriodicVelocity(MCGLimitPlan plan){
		enterValueinTextBox(periodicVelocityTxt, plan.getPeriodicVelocity());
	}
	
	public void enterPeriodicVelocityResponse(MCGLimitPlan plan){
		selectByVisibleText(periodicVelocityResponseDdwn, plan.getPeriodicVelocityResponse());
	}
	
	public void enterPeriodicPercentageOfCreditLimit(MCGLimitPlan plan){
		enterValueinTextBox(periodicPercentageOfCreditLimitTxt, plan.getPeriodicPercentageOfCreditLimit());
	}
	
	public void enterPerTransactionInternationalAmount(MCGLimitPlan plan){
		enterValueinTextBox(perTransactionInternationalAmountTxt, plan.getPerTransactionInternationalAmount());
	}
	
	public void selectPerTransactionInternationalResponse(MCGLimitPlan plan){
		selectByVisibleText(perTransactionInternationalResponseDdwn, plan.getPerTransactionInternationalResponse());
	}
	
	public void enterperTransactionInternationalPercentageOFCreditLimit(MCGLimitPlan plan){
		enterValueinTextBox(perTransactionInternationalPercentageOfCreditLimitTxt, plan.getPerTransactionPercentageOfCreditLimitInternational());
	}
	
	public void enterDailyAmountInternational(MCGLimitPlan plan){
		enterValueinTextBox(dailyAmountInternationalTxt, plan.getDailyAmountInternational());
	}
	
	public void selectDailyInternationalResponse(MCGLimitPlan plan){
		selectByVisibleText(dailyAmountInternationalResponseDdwn, plan.getDailyResponseInternational());
	}
	
	public void enterDailyVelocityInternational(MCGLimitPlan plan){
		enterValueinTextBox(dailyVelocityInternationalTxt, plan.getDailyVelocityInternational());
	}
	
	public void enterDailyVelocityInternationalResponse(MCGLimitPlan plan){
		selectByVisibleText(dailyVelocityInternationalResponseDdwn, plan.getDailyVelocityResponseInternational());
	}
	
	public void enterDailyPercentageOfCreditLimitInternational(MCGLimitPlan plan){
		enterValueinTextBox(dailyPercentageOfCreditLimitInternationalTxt, plan.getDailyPercentageOfCreditLimitInternational());
	}
	
	public void enterPeriodicAmountInternational(MCGLimitPlan plan){
		enterValueinTextBox(periodicAmountInternationalTxt, plan.getPeriodicAmountInternational());
	}
	
	public void selectPeriodicInternationalResponse(MCGLimitPlan plan){
		selectByVisibleText(periodicAmountInternationalResponseDdwn, plan.getPeriodicResponseInternational());
	}
	
	public void enterPeriodicVelocityInternational(MCGLimitPlan plan){
		enterValueinTextBox(periodicVelocityInternationalTxt, plan.getPeriodicVelocityInternational());
	}
	
	public void enterPeriodicVelocityInternationalResponse(MCGLimitPlan plan){
		selectByVisibleText(periodicVelocityInternationalResponseDdwn, plan.getPeriodicVelocityResponseInternational());
	}
	
	public void enterPeriodicPercentageOfCreditLimitInternational(MCGLimitPlan plan){
		enterValueinTextBox(periodicPercentageOfCreditLimitInternationalTxt, plan.getPeriodicPercentageOfCreditLimitInternational());
	}

	public MCGLimitPlan createMCGLimitPlanWithDetails(MCGLimitPlan plan){
		clickAddNewButton();
		runWithinPopup(FRAME_ADD_MCG_LIMIT_PLAN, () -> {
			enterMcgLimitPlanCode(plan);
			enterDescription(plan);
			addProductType(plan);
            clickAddDetailsButton();
            if(publishErrorOnPage()){
            	plan.setMcgLimitPlanCode(CustomUtils.randomAlphaNumeric(5).toUpperCase());
            	enterMcgLimitPlanCode(plan);
            	clickAddDetailsButton();
            }
            clickAddNewButton();
		});
		runWithinPopup(FRAME_ADD_MCG_LIMIT_PLAN_DETAILS, () -> {
			selectEffectiveDate(plan);
			selectEndDate(plan);
			selectMcgCode(plan);
			enterFromMomthOnBook(plan);
			enterToMomthOnBook(plan);
			enterDailyAmount(plan);
			selectDailyResponse(plan);
			enterDailyVelocity(plan);
			selectDailyVelocityResponse(plan);
		});
		return plan;
	}
	
	public void enterPlanCodeInSearchBox(MCGLimitPlan plan) {
		enterValueinTextBox(planCodeSearchTxt,
				plan.getMcgLimitPlanCode());
	}
	
	

}
