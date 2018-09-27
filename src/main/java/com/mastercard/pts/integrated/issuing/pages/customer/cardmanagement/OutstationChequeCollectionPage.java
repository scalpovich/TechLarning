package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;




import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Payment;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
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
		CardManagementNav.L5_OUTSTATION_CHEQUE_COLLECTION
		})

public class OutstationChequeCollectionPage extends AbstractBasePage {
	@Autowired
	TestContext context;
	private static final Logger logger = LoggerFactory.getLogger(OutstationChequeCollectionPage.class);
	private static final String ADD_OUTSTATION_CHEQUE_COLLECTION="Add Outstation Cheque Collection";

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[name='chequeNumber:input:inputTextField']")
	private MCWebElement chequeNumberTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=chequeDate]")
	private MCWebElement chequeDate;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[name='cardNumber:input:inputTextField']")
	private MCWebElement deviceNumberTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[name='chequeAmount:input:inputAmountField']")
	private MCWebElement chequeAmountTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "select[name='transactionCurrency:input:dropdowncomponent']")
	private MCWebElement ddwnTransactionCurrency;

	@PageElement(findBy = FindBy.CSS, valueToFind = "select[name='draweeBank:input:dropdowncomponent']")
	private MCWebElement draweeInstitutionDdwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "select[name='draweeBank:input:dropdowncomponent']")
	private MCWebElement draweeBranchCityDdwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[name='Generate']")
	private MCWebElement generateButton;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "*//[name='memo:input:textAreaComponent']")
	private MCWebElement memoTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#referenceNum>span>span")
	private MCWebElement referenceNumberTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#referenceNum>span>span")
	private MCWebElement feedBackPanelErrorTxt;
	
	public void verifyUiOperationStatus() {
		logger.info("Outstation Cheque Collection");
		verifyUiOperation("Add Outstation Cheque Collection");
	}
	
	public void performOutStationCollectionPayment(Payment outStationCollection, Device device) {
		clickAddNewButton();
		runWithinPopup(ADD_OUTSTATION_CHEQUE_COLLECTION, () -> {
			enterDeviceNumber(device);
			enterChequeNumber(outStationCollection.getChequeNumber());
			enterChequeDate(outStationCollection.getChequeDate());
			enterChequeAmount(outStationCollection.getChequeAmount());
			enterTransactionCurrency(outStationCollection.getTransactionCurrency());
			generateButtonClick();
			if (!outStandingChequeErrorDisplay()) {
				context.put(CreditConstants.PAYMENT_REFERENCE_NUMBER, referenceNumberFetch());
			} else {
				logger.info("Device Number is not correct-{}", device.getDeviceNumber());
				clickCancelButton();
			}
			enterMemo();
			clickSaveButton();
		});
		verifyOperationStatus();
	}

	public void enterDeviceNumber(Device device) {
		WebElementUtils.enterText(deviceNumberTxt, device.getDeviceNumber());
	}

	public void enterChequeNumber(String chequeNumber) {
		if (chequeNumberTxt.isEnabled()) {
			WebElementUtils.enterText(chequeNumberTxt, chequeNumber);
		}
	}

	public void enterChequeDate(LocalDate date) {
		SimulatorUtilities.wait(5000);
		WebElementUtils.pickDate(chequeDate, date.plusDays(2));
	}
    
	public void enterChequeAmount(String chequeAmount) {
		if (chequeAmountTxt.isEnabled()) {
			WebElementUtils.enterText(chequeAmountTxt, chequeAmount);
		}
	}
    
	public void enterTransactionCurrency(String transactionCurrency) {
		if (ddwnTransactionCurrency.isEnabled()) {
			WebElementUtils.selectDropDownByVisibleText(ddwnTransactionCurrency, transactionCurrency);
		}
	}
    
	public void generateButtonClick() {
		clickWhenClickable(generateButton);
	}
    
	public void enterMemo() {
		WebElementUtils.enterText(memoTxt, ADD_OUTSTATION_CHEQUE_COLLECTION);
	}
	
	public boolean outStandingChequeErrorDisplay(){
		return feedBackPanelErrorTxt.isVisible();
	}
    
	public String referenceNumberFetch() {
		return referenceNumberTxt.getText();

	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(chequeNumberTxt),
				WebElementUtils.elementToBeClickable(ddwnTransactionCurrency)
				);
	}
}