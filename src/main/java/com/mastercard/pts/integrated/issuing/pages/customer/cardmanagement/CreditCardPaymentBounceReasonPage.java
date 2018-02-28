package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditCardPaymentBounceReason;
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
		CardManagementNav.L3_CREDIT_CARD_PAYMENT_BOUNCE_REASON })
public class CreditCardPaymentBounceReasonPage extends AbstractBasePage{

	private static final Logger logger = LoggerFactory
			.getLogger(CreditCardPaymentBounceReasonPage.class);
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=reasonCode]")
	private MCWebElement paymentBouncePlanCodeTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=description]")
	private MCWebElement descriptionOnMainScreenTxt;

	public void verifyUiOperationStatus() {
	logger.info("Credit Card Payment Bounce Reason");
	verifySearchButton("Search");
}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.visibilityOf(paymentBouncePlanCodeTxt),
				WebElementUtils.visibilityOf(descriptionOnMainScreenTxt));
	}
	
	public boolean addPaymentBounceReason(CreditCardPaymentBounceReason creditCardPaymentBounceReason)
	{
		logger.info("Add Payment Bounce Reason {}", creditCardPaymentBounceReason);
		
		performSearchOperationOnMainScreen(creditCardPaymentBounceReason);
		//if records are found then we just have to change the Billing Plan Code to make it work hence setting 
		if(!isNoRecordsFoundInTable())
		{
			creditCardPaymentBounceReason.setPaymentBouncePlanCode(MiscUtils.generateRandomNumberBetween2Number(100,999));
		}	
		else
		{
		clickAddNewButton();		
		//Fill "Add Payment Bounce Reason" section
		AtomicBoolean canceled = new AtomicBoolean(false);
		runWithinPopup("Add Payment Bounce Reason", () -> {
			WebElementUtils.enterText(paymentBouncePlanCodeTxt, creditCardPaymentBounceReason.getPaymentBouncePlanCode());	
			WebElementUtils.enterText(descriptionOnMainScreenTxt, creditCardPaymentBounceReason.getDescription());
			clickSaveButton();
			errorMessagePresence();
			canceled.set(verifyAlreadyExistsAndClickCancel());
			//verifyNoErrors();
		});	
		if(!canceled.get())
		{
		verifyOperationStatus();
		}
	 }
		return errorMessagePresence();
	}
	
	private void performSearchOperationOnMainScreen(CreditCardPaymentBounceReason creditCardPaymentBounceReason)
	{
		WebElementUtils.enterText(paymentBouncePlanCodeTxt, creditCardPaymentBounceReason.getPaymentBouncePlanCode());
		clickSearchButton();
	}
}
