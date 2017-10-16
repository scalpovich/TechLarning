package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class TransactionFeePlanPage {

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addTransactionFeePlan;

	@PageElement(findBy = FindBy.NAME, valueToFind = "txnFeePlanCode:input:inputTextField")
	private MCWebElement TransactionFeePlanCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "description:input:inputTextField")
	private MCWebElement Description;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save2;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addSubDetails;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionCode:input:dropdowncomponent")
	private MCWebElement TransactionType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "currencyCode:input:dropdowncomponent")
	private MCWebElement WalletCurrency;

	@PageElement(findBy = FindBy.NAME, valueToFind = "networkCode:input:dropdowncomponent")
	private MCWebElement TransactionSource;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionOrigin:input:dropdowncomponent")
	private MCWebElement TransactionOrigin;

	@PageElement(findBy = FindBy.NAME, valueToFind = "txnFeePlanStartDate:input:dateTextField")
	private MCWebElement EffectiveDate;

	@PageElement(findBy = FindBy.NAME, valueToFind = "txnFeePlanEndDate:input:dateTextField")
	private MCWebElement EndDate;

	@PageElement(findBy = FindBy.NAME, valueToFind = "fromTxnAmount:input:inputAmountField")
	private MCWebElement FromAmount;

	@PageElement(findBy = FindBy.NAME, valueToFind = "toTxnAmount:input:inputAmountField")
	private MCWebElement ToAmount;

	@PageElement(findBy = FindBy.NAME, valueToFind = "fixFee:input:inputAmountField")
	private MCWebElement Fix;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

}
