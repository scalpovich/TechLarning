package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;





import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;





import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.CreditCardPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditCardPaymentPriority;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP, CardManagementNav.L2_CREDIT_CARD,
		CardManagementNav.L3_CREDIT_CARD_PAYMENT_PRIORITY })
public class CreditCardPaymentPriorityPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(CreditCardPaymentPriorityPage.class);
    @Autowired
    TestContext context;
    
    @Autowired
    CreditCardPlan creditCardPlans;
	@Value("${default.wait.timeout_in_sec}")
	private long timeoutInSec;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=planCode]")
	private MCWebElement paymentPriorityPlanCodeOnMainScreenTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=planName]")
	private MCWebElement descriptionOnMainScreenTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "planCode:input:inputTextField")
	private MCWebElement paymentPriorityPlanCodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "planName:input:inputTextField")
	private MCWebElement descriptionTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "balCash:input:inputTextField")
	private MCWebElement cashTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "balPurchase:input:inputTextField")
	private MCWebElement purchaseTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "balUnique:input:inputTextField")
	private MCWebElement uniqueTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "balTe:input:inputTextField")
	private MCWebElement tEeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "balFees:input:inputTextField")
	private MCWebElement feeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "balTransfer:input:inputTextField")
	private MCWebElement transferTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "balLoanTxn:input:inputTextField")
	private MCWebElement installementTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "balInterests:input:inputTextField")
	private MCWebElement interestTxt;

	private int counter=0;
	public void verifyUiOperationStatus() {
		logger.info("Credit Card Payment Priority");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils
				.visibilityOf(paymentPriorityPlanCodeOnMainScreenTxt),
				WebElementUtils.visibilityOf(descriptionOnMainScreenTxt));
	}

	public boolean addPaymentPriority(
			CreditCardPaymentPriority creditCardPaymentPriority) {
		logger.info("Add Credit Card Payment Priority: {}",
				creditCardPaymentPriority);

		performSearchOperationOnMainScreen(creditCardPaymentPriority);
		// if records are found then we just have to change the Billing Plan
		// Code to make it work hence setting
	    waitForPageToLoad(driver());
	    checkDuplicacyOfPaymentPriorityPlanCode(creditCardPaymentPriority);
		
		clickAddNewButton();
		// Add Document Checklist section
		AtomicBoolean canceled = new AtomicBoolean(false);
		runWithinPopup("Add Payment Priority", () -> {
			WebElementUtils.enterText(paymentPriorityPlanCodeTxt, creditCardPaymentPriority.getPaymentPriorityPlanCode());
			WebElementUtils.enterText(descriptionTxt, creditCardPaymentPriority.getDescription());
			logger.info("creditPaymentPriorityCodeAndDescription : {}",creditCardPaymentPriority.buildDescriptionAndCode());
			context.put(CreditConstants.PAYMENT_PRIORITY, creditCardPaymentPriority.buildDescriptionAndCode());
			WebElementUtils.enterText(cashTxt, creditCardPaymentPriority.getCash());
			WebElementUtils.enterText(purchaseTxt, creditCardPaymentPriority.getPurchase());
			WebElementUtils.enterText(uniqueTxt, creditCardPaymentPriority.getUnique());
			WebElementUtils.enterText(tEeTxt, creditCardPaymentPriority.gettAndE());
			WebElementUtils.enterText(feeTxt, creditCardPaymentPriority.getFee());
			WebElementUtils.enterText(transferTxt, creditCardPaymentPriority.getTransfer());
			WebElementUtils.enterText(installementTxt, creditCardPaymentPriority.getInstallement());
			WebElementUtils.enterText(interestTxt, creditCardPaymentPriority.getInterest());
		
			clickSaveButton();
		 if (verifyAlreadyExists()) {
			    errorMessagePresence();
			 	creditCardPlans.setErrorStatus(errorMessagePresence());
				canceled.set(verifyAlreadyExistsAndClickCancel());
		 }
		 else
		 {
			 creditCardPlans.setErrorStatus(false);
		 }
		});
		if (!canceled.get()) {
			verifyOperationStatus();
		}
		
		return creditCardPlans.getErrorStatus();
	}

	private void checkDuplicacyOfPaymentPriorityPlanCode(CreditCardPaymentPriority creditCardPaymentPriority) {
		if(!isNoRecordsFoundInTable())
		{   
			 counter+=1;
			if(counter<2)
			{
			 creditCardPaymentPriority.setPaymentPriorityPlanCode(MiscUtils.generateRandomNumberBetween2Number(100, 999));
			 logger.info("PaymentPriorityPlanCode: {}",creditCardPaymentPriority.getPaymentPriorityPlanCode());
			 performSearchOperationOnMainScreen(creditCardPaymentPriority);
			 waitForPageToLoad(getFinder().getWebDriver());
			 checkDuplicacyOfPaymentPriorityPlanCode(creditCardPaymentPriority);
			}
		     
		}
	}

	private void performSearchOperationOnMainScreen(CreditCardPaymentPriority creditCardPaymentPriority) {
		WebElementUtils.enterText(paymentPriorityPlanCodeOnMainScreenTxt, creditCardPaymentPriority.getPaymentPriorityPlanCode());
		clickSearchButton();
	}
}
