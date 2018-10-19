package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
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
		CardManagementNav.L5_LOCAL_CHEQUE
		})

	public class LocalChequePage extends AbstractBasePage {
	
	private static final Logger logger = LoggerFactory.getLogger(LocalChequePage.class);
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=batchNum]")
	private MCWebElement batchNum;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement batchStatus;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=clearingDate]")
	private MCWebElement clearingDate;
	
	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addBtn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#clearingDate")
	private MCWebElement clearingDatePicker;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//textarea[@fld_fqn='memo']")
	private MCWebElement memoTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionCurrency:input:dropdowncomponent")
	private MCWebElement transactionCurrency;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "cardNumber:input:inputTextField")
	private MCWebElement deviceNumber;	
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "chequeNumber:input:inputTextField")
	private MCWebElement chequeNumber;	

	@PageElement(findBy = FindBy.CSS, valueToFind = "#chequeDate")
	private MCWebElement chequeDate;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionCode:input:dropdowncomponent")
	private MCWebElement transactionTypeDD;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "chequeAmount:input:inputAmountField")
	private MCWebElement chequeAmount;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "draweeBank:input:inputTextField")
	private MCWebElement draweeBankTbx;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "draweeBranch:input:inputTextField")
	private MCWebElement draweeBranchTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#valueDate")
	private MCWebElement valueDate;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "referenceNumber:input:inputTextField")
	private MCWebElement referenceNumberTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "micrNumber:input:inputTextField")
	private MCWebElement micrNumberTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "paymntBranch:input:dropdowncomponent")
	private MCWebElement paymentBranchDD;
	
	public void enterClearingDate(LocalDate date){
		WebElementUtils.pickDate(clearingDatePicker,date);
	}
	
	public void enterMemo(String memo){
		WebElementUtils.enterText(memoTxt, memo);
	}
	
	public void selectTransactionCurrency(String currency){
		WebElementUtils.selectDropDownByVisibleText(transactionCurrency, currency);
	}
	
	public void enterDeviceNumber(String device){
		WebElementUtils.enterText(deviceNumber,device);
	}
	
	public void enterChqNumber(String chqNumber){
		WebElementUtils.elementToBeClickable(chequeNumber);
		WebElementUtils.enterText(chequeNumber,chqNumber);
	}
	
	public void enterChequeDate(LocalDate date){
		SimulatorUtilities.wait(5000);
		WebElementUtils.pickDate(chequeDate,date);
	}
	
	public void selectTransactionType(String transactionType){
		WebElementUtils.selectDropDownByVisibleText(transactionTypeDD,transactionType);
	}
	
	public void enterChqAmount(String chqAmount){
		WebElementUtils.enterText(chequeAmount,chqAmount);
	}
	
	public void enterDraweeBank(String draweeBank){
		WebElementUtils.enterText(draweeBankTbx,draweeBank);
	}
	
	public void enterDraweeBranch(String draweeBranch){
		WebElementUtils.enterText(draweeBranchTxt,draweeBranch);
	}
	
	public void enterReferenceNumber(String referenceNumber){
		WebElementUtils.enterText(referenceNumberTxt,referenceNumber);
	}
	
	public void enterMICRNumber(String micrNumber){
		WebElementUtils.enterText(micrNumberTxt,micrNumber);
	}
	
	public void fillValueDate(LocalDate date){
		WebElementUtils.pickDate(valueDate,date);
	}
	
	public void selectPaymentBranch(String paymentBranch){
		WebElementUtils.selectDropDownByVisibleText(paymentBranchDD,paymentBranch);
	}
		
	public void addLocalChequePayment(Payment localChq){
		clickAddNewButton();
		runWithinPopup(
				"Add Local Cheque",
				() -> {
					enterClearingDate(localChq.getClearingDate());
					enterMemo(localChq.getMemo());
					selectTransactionCurrency(localChq.getTransactionCurrency());
					clickSaveButton();
					clickAddDetailsButton(); 
				runWithinPopup(
							"Add Clearing Details",
							() -> {	
					enterDeviceNumber(localChq.getDeviceNumber());
					enterChqNumber(localChq.getChequeNumber());
					enterChequeDate(localChq.getChequeDate());
					selectTransactionType(localChq.getTransactionType());
					enterChqAmount(localChq.getChequeAmount());
					enterDraweeBank(localChq.getDraweeBank());
					enterDraweeBranch(localChq.getDraweeBank());
					enterReferenceNumber(localChq.getReferenceNumber());
					enterMICRNumber(localChq.getMicrNumber());
					//fillValueDate(localChq.getValueDate());
					selectPaymentBranch(localChq.getPaymntBranch());
					clickSaveButton();
															
				});				
				clickCloseButton();
				});

		verifyOperationStatus();
	
	}
	
	public void verifyUiOperationStatus() {
		logger.info("Local Cheque");
		verifyUiOperation("Add Local Cheque");
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(batchNum),
				WebElementUtils.elementToBeClickable(batchStatus),
				WebElementUtils.elementToBeClickable(clearingDate)
				);
	}
}