package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Payment;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_ACTIVITY,
		CardManagementNav.L2_TRANSACTION_MANAGEMENT,
		CardManagementNav.L3_TRANSACTION,
		CardManagementNav.L4_PAYMENTS,
		CardManagementNav.L5_CASH
		})
public class CashPage extends AbstractBasePage {
	
	private static final Logger logger = LoggerFactory.getLogger(CashPage.class);
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=remittanceNumber]")
	private MCWebElement txtRemittanceNumber;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#remittanceDate")
	private MCWebElement remittanceDate;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:inputTextField")
	private MCWebElement remittanceSeq;	
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#valueDate")
	private MCWebElement valueDate;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "currencyCode:input:dropdowncomponent")
	private MCWebElement baseCurrencyDD;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Add Details']")
	private MCWebElement addDetailsBtn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "cardNumber:input:inputTextField")
	private MCWebElement deviceNumberTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionAmount:input:inputAmountField")
	private MCWebElement amountTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#transactionDate")
	private MCWebElement transactionDate;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "narration:input:inputTextField")
	private MCWebElement descriptionTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "paymntBranch:input:dropdowncomponent")
	private MCWebElement paymentBranchDD;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "authorizationNumber:input:inputTextField")
	private MCWebElement authNumberTxt;	
	
	
	public void enterRemittanceNumber(String remittanceNumber){
		WebElementUtils.enterText(txtRemittanceNumber, remittanceNumber);		
	}
	
	public void enterRemittanceDate(LocalDate remittanceDat){
		SimulatorUtilities.wait(600);
		WebElementUtils.pickDate(remittanceDate, remittanceDat);		
	}
	
	public void enterValueDate(LocalDate valueDat){
		WebElementUtils.pickDate(valueDate, valueDat);		
	}
	
	public void selectBaseCurrency(String baseCurrency){
		WebElementUtils.selectDropDownByVisibleText(baseCurrencyDD, baseCurrency);
	}
	
	public void enterDeviceNumber(String deviceNumber){
		WebElementUtils.enterText(deviceNumberTxt, deviceNumber);		
	}
	
	public void enterAmount(String amount){
		WebElementUtils.enterText(amountTxt, amount);		
	}
	
	public void enterTransactionDate(LocalDate transactionDate){
		WebElementUtils.pickDate(this.transactionDate, transactionDate);		
	}
	
	public void enterDescription(String description){
		WebElementUtils.enterText(descriptionTxt, description);		
	}
	
	public void enterAuthNumber(String authNumber){
		WebElementUtils.enterText(authNumberTxt, authNumber);		
	}
	
	public void selectPaymentBranch(String paymentBranch){
		WebElementUtils.selectDropDownByVisibleText(paymentBranchDD, paymentBranch);		
	}
	
	public void clickAddDetailsBtn(){
		clickWhenClickableDoNotWaitForWicket(addDetailsBtn);	
	}		
	
	public void performCashPayment(Payment cash) {
		clickAddNewButton();
		runWithinPopup("Add Cash", () -> {
			enterRemittanceNumber(cash.getRemittanceNumber());
			enterValueDate(cash.getValueDate());
			selectBaseCurrency(cash.getBaseCurrency());
			clickAddDetailsBtn();
			clickAddNewButton();
			runWithinPopup("Add Cash Transaction", () -> {
				enterDeviceNumber(cash.getDeviceNumber());
				enterAmount(cash.getAmount());
				enterDescription(cash.getDescription());
				enterAuthNumber(cash.getAuthNumber());
				selectPaymentBranch(cash.getPaymentBranch());
				clickSaveButton();
			});
			clickSaveButton();
		});
		verifyOperationStatus();
	}

	public void verifyUiOperationStatus() {
		logger.info("Cash");
		verifyUiOperationNoEdit("Add Cash");
	}

}