package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.CreditCardPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditCardCreditPlan;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

/**
 * @author e076177
 *
 */
@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP,
		CardManagementNav.L2_CREDIT_CARD_BILLING,
		CardManagementNav.L3_CREDIT_PLAN})
public class CreditPlanPage extends AbstractBasePage {
    @Autowired
    KeyValueProvider provider;
    @Autowired
    CreditCardPlan creditCardPlans;
   
	private static final Logger logger = LoggerFactory.getLogger(CreditPlanPage.class);
    private static final String CREDITPLAN_FRAME="Add Credit Plan";
    
   @PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=profileCode]")
	private MCWebElement profileCode;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=profileWording]")
	private MCWebElement profileWording;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=profileWordAbrv]")
	private MCWebElement profileWordAbrv;
    @PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addCreditPlan;

	@PageElement(findBy = FindBy.NAME, valueToFind = "profileCode:input:inputTextField")
	private MCWebElement creditPlanCodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "profileWording:input:inputTextField")
	private MCWebElement descriptionTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "profileWordAbrv:input:inputTextField")
	private MCWebElement abbreviationTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "basePaymentDate:input:dropdowncomponent")
	private MCWebElement paymentDateDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "nbdayPaymentDate:input:inputTextField")
	private MCWebElement paymentDateDaysTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "unpaidDate:input:dropdowncomponent")
	private MCWebElement unpaidDateDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "nbdayUnpaidDate:input:inputTextField")
	private MCWebElement unpaidDateDaysTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionFeePlan:input:dropdowncomponent")
	private MCWebElement transactionRulePlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "unpaidPerm:input:inputAmountField")
	private MCWebElement minimumDueTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "totalUnpaidPerm:input:inputAmountField")
	private MCWebElement totalDueTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "paymentPriorityPlan:input:dropdowncomponent")
	private MCWebElement paymentPriorityPlanDDwn;
    @PageElement(findBy = FindBy.NAME, valueToFind = "overdrawnPerm:input:inputTextField")
	private MCWebElement allowedPercentageTxt;
	@PageElement(findBy = FindBy.NAME, valueToFind = "currencyCode:input:dropdowncomponent")
	private MCWebElement currencyDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class='feedbackPanelERROR']")
	private MCWebElement errorCodeAlreadyExistsTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Record Added Successfully.']")
	private MCWebElement validateSuccessMsgDisplayTxt;
	
	public boolean successMessageDisplay()
	{
		return validateSuccessMsgDisplayTxt.isVisible();
		
	}
    public void addCreditPlan() {
    	clickWhenClickable(addCreditPlan);
		switchToIframe(CREDITPLAN_FRAME);
		}
    public void addMandatoryLabelsAndFields()
    {
    	clickSaveButton();
		mandatoryLabels();
		mandatoryFields();
    }
    
    public void settingMandatoryValuesWithLabels()
    {
    	creditCardPlans.setMandatoryValuesWithLabels(mandatoryValuesWithLabels(mandatoryFields(),mandatoryLabels()));
		logger.info("MandatoryLabelswithValues: {}", creditCardPlans.getMandatoryValuesWithLabels());
    }
    
    public void saveButtonClick()
    {
          clickSaveButton();
    }
    
    public boolean creditPlanAlreadyExists()
    {
		return errorCodeAlreadyExistsTxt.isVisible();
    	
    }
    public void enterCreditPlanCode(CreditCardCreditPlan creditCardCreditPlan)
    {
       WebElementUtils.enterText(creditPlanCodeTxt, creditCardCreditPlan.getCreditPlanCode());	
    }
    public void enterCreditPlanDescription(CreditCardCreditPlan creditCardCreditPlan)
    {
       WebElementUtils.enterText(descriptionTxt, creditCardCreditPlan.getDescription());	
    }
    public void enterCreditPlanAbbreviation(CreditCardCreditPlan creditCardCreditPlan)
    {
       WebElementUtils.enterText(abbreviationTxt, creditCardCreditPlan.getAbbreviation());	
    }
    public void selectPaymentDate(int index)
    {
    	WebElementUtils.selectDropDownByIndex(paymentDateDDwn,index);
    	waitForElementEnabled(paymentDateDaysTxt);
    }
    public void enterPaymentDateDays(CreditCardCreditPlan creditCardCreditPlan)
    {
    	WebElementUtils.enterText(paymentDateDaysTxt,creditCardCreditPlan.getPaymentDueDateDays());
    }
    public void selectUnpaidDate(int index)
    {
    	WebElementUtils.selectDropDownByIndex(unpaidDateDDwn,index);
		waitForElementEnabled(unpaidDateDaysTxt);
    } 
    public void enterUnpaidDateDays(CreditCardCreditPlan creditCardCreditPlan)
    {
    	WebElementUtils.enterText(unpaidDateDaysTxt,creditCardCreditPlan.getUnpaidDateDays());
    }
    public void selectTransactionRulePlan(int index)
    {
    	WebElementUtils.selectDropDownByIndex(transactionRulePlanDDwn, index);
    } 
    public void selectCurrency(int index)
    {
    	WebElementUtils.selectDropDownByIndex(currencyDDwn, index);
    } 
    public void enterMinimumDue(CreditCardCreditPlan creditCardCreditPlan)
    {
    	WebElementUtils.enterText(minimumDueTxt, creditCardCreditPlan.getMinimumDue());
    }
    public void enterTotalDue(CreditCardCreditPlan creditCardCreditPlan)
    {
    	WebElementUtils.enterText(totalDueTxt, creditCardCreditPlan.getTotalDue());
    }
    public void selectPaymentPriorityPlan(int index)
    {
        WebElementUtils.selectDropDownByIndex(paymentPriorityPlanDDwn, index);
    }
    public void enterAllowedPercentage(CreditCardCreditPlan creditCardCreditPlan)
    {
    	WebElementUtils.enterText(allowedPercentageTxt, creditCardCreditPlan.getAllowedPercentage());
    }
	
	public void verifyUiOperationStatus() {
		logger.info("Credit Plan");
		
		verifyUiOperation("Add Credit Plan");
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(profileCode),
				WebElementUtils.elementToBeClickable(profileWording),
				WebElementUtils.elementToBeClickable(profileWordAbrv)
				
				);
	}
}
