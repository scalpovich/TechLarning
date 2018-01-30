package com.mastercard.pts.integrated.issuing.pages.agent.transactions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.agent.transactions.CardToCash;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = TransactionsNav.TAB_TRANSACTIONS, treeMenuItems = { TransactionsNav.L1_CARD_TO_CASH, TransactionsNav.L2_CARD_TO_CASH_TRANSACTION })
public class CardToCashTransactionPage extends TransactionsAbstractPage {
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#walletNumber")
	private MCWebElement walletNumnberDdwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='View']")
	private MCWebElement viewBtn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#beneficiaryNationalId")
	private MCWebElement beneficiaryNationalIdTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#beneficiaryFirstName")
	private MCWebElement beneficiaryFirstNameTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#beneficiaryLastName")
	private MCWebElement beneficiaryLastNameTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#address1")
	private MCWebElement address1Txt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#selectedCity")
	private MCWebElement selectedCityTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#beneficiaryZipCode")
	private MCWebElement zipCodeTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#mobileNumber")
	private MCWebElement mobileNumberTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#txnAmount")
	private MCWebElement txnAmountTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#selectedWalletCurrencyCode")
	private MCWebElement walletCurrencyCodeDdwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Search']")
	private MCWebElement searchBtn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Submit']")
	private MCWebElement submitBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = ".SuccessMessageTxt")
	private MCWebElement applicationSuccessMessage;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#txnPassword")
	private MCWebElement txnPasswordTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#remarks")
	private MCWebElement remarksTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Confirm']")
	private MCWebElement confirmBtn;
	
	public void clickViewButton() {
		new WebDriverWait(driver(), timeoutInSec).until(
				WebElementUtils.elementToBeClickable(viewBtn)).click();
	}
	
	public void clickConfirmButton() {
		new WebDriverWait(driver(), timeoutInSec).until(
				WebElementUtils.elementToBeClickable(confirmBtn)).click();
	}
	
	@Override
	public void clickSearchButton() {
		new WebDriverWait(driver(), timeoutInSec).until(
				WebElementUtils.elementToBeClickable(searchBtn)).click();
	}
	
	public void clickSubmitButton() {
		new WebDriverWait(driver(), timeoutInSec).until(
				WebElementUtils.elementToBeClickable(submitBtn)).click();
	}

	public String getRemittanceSuccessMessage() {
		return new WebDriverWait(driver(), timeoutInSec).until(
				WebElementUtils.visibilityOf(applicationSuccessMessage))
				.getText();
	}
	
	public String getRemittanceReferenceNumber() {
		String message = getRemittanceSuccessMessage();
		String remittanceNumber = message.substring(message.lastIndexOf(' ') + 1);
		return remittanceNumber.substring(0, remittanceNumber.length() - 1);
	}
	
	public String getMaskedWalletNumberWithCurrencyCode(Device device, CardToCash details) {
		return device.getWalletNumber().substring(0, 4) + "XXXXXXXXXXX" + device.getWalletNumber().substring(15)+" ["+details.getRemittanceCurrency()+"] ";
	}
	
	public String performRemittanceCardToCashTransaction(Device device, CardToCash details) {
		WebElementUtils.enterText(deviceNumberTxt, device.getDeviceNumber());
		WebElementUtils.asWebElement(deviceNumberTxt).sendKeys(Keys.TAB);
		WebElementUtils.selectDropDownByVisibleText(walletNumnberDdwn, getMaskedWalletNumberWithCurrencyCode(device, details));
		clickViewButton();
		WebElementUtils.scrollDown(driver(), 0, 350);
		WebElementUtils.enterText(beneficiaryNationalIdTxt, details.getBeneficiaryId());
		WebElementUtils.enterText(beneficiaryFirstNameTxt, details.getBeneficiaryFirstName());
		WebElementUtils.enterText(beneficiaryLastNameTxt, details.getBeneficiaryLastName());
		WebElementUtils.enterText(address1Txt, details.getBeneficiaryAddress1());
		WebElementUtils.enterText(selectedCityTxt, details.getCity());
		WebElementUtils.enterText(zipCodeTxt, details.getZipCode());
		WebElementUtils.enterText(mobileNumberTxt, details.getMobileNumber());
		WebElementUtils.enterText(txnAmountTxt, details.getRemittanceAmount());
		WebElementUtils.selectDropDownByVisibleText(walletCurrencyCodeDdwn, details.getRemittanceCurrency());
		clickSubmitButton();
		WebElementUtils.enterText(txnPasswordTxt, details.getTxnPassword());
		WebElementUtils.enterText(remarksTxt, Constants.GENERIC_DESCRIPTION);
		clickConfirmButton();
		return getRemittanceReferenceNumber();
	}
}