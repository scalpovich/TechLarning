package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

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
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_ACTIVITY,
		CardManagementNav.L2_TRANSACTION_MANAGEMENT,
		CardManagementNav.L3_TRANSACTION, CardManagementNav.L4_PAYMENTS,
		CardManagementNav.L5_OUTSTATION_CHEQUE_PROCESSING })
public class OutstationChequeProcessingPage extends AbstractBasePage {

	@Autowired
	TestContext context;
	
	private static final Logger logger = LoggerFactory
			.getLogger(OutstationChequeProcessingPage.class);
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[name='cardNumber:input:inputTextField']")
	private MCWebElement deviceNumberTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[name='chequeAmount:input:inputAmountField']")
	private MCWebElement chequeNumberTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[name='chequeAmount:input:inputAmountField']")
	private MCWebElement chequeAmountTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "select[name='draweeBank:input:dropdowncomponent']")
	private MCWebElement draweeInstitutionDdwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "select[name='transactionCurrency:input:dropdowncomponent']")
	private MCWebElement transactionCurrencyDdwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "select[name='draweeBranchCity:input:dropdowncomponent']")
	private MCWebElement draweeBranchCityDdwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "input[name='draweeBranch:input:inputTextField']")
	private MCWebElement draweeBranchTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='chequeDate']/.")
	private MCWebElement chequeDate;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='collectionDate']/.")
	private MCWebElement collectionDate;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='valueDate']/.")
	private MCWebElement valueDate;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[name='memo:input:textAreaComponent']")
	private MCWebElement memoTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[name='memo:input:textAreaComponent']")
	private MCWebElement referenceNumberTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = ".dataview")
	private MCWebElement outStationProcessingTable;

	public boolean isTextAvailableinTable(){
		return WebElementUtils.isTextAvailableinTable(outStationProcessingTable, context.get(CreditConstants.PAYMENT_REFERENCE_NUMBER));
	}
	public void verifyUiOperationStatus() {
		logger.info("Outstation Cheque Processing");
		verifySearchButton("Search");
	}

}