package com.mastercard.pts.integrated.issuing.pages.agent.transactions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.agent.transactions.CardToCash;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = TransactionsNav.TAB_TRANSACTIONS,
	treeMenuItems = { TransactionsNav.L1_CARD_TO_CASH, TransactionsNav.L2_CARD_TO_CASH_LOOKUP})
public class CardToCashLookupPage extends TransactionsAbstractPage {
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#walletNumber")
	private MCWebElement walletNumnberDdwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='View']")
	private MCWebElement viewBtn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//tr[4]//input[@id='fetchFlag']")
	private MCWebElement remittanceRBtn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#RRN")
	private MCWebElement rrnTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Search']")
	private MCWebElement searchBtn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Submit']")
	private MCWebElement submitBtn;
	
	public void clickViewButton() {
		new WebDriverWait(driver(), timeoutInSec).until(
				WebElementUtils.elementToBeClickable(viewBtn)).click();
	}
	
	public void clickRemittanceRadioButton() {
		remittanceRBtn.click();
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
	
	public boolean validateLookupTableTransferAmount(CardToCash details) {
		String msgBuilder = details.getRemittanceCurrency()+" "+details.getRemittanceAmount();
		return msgBuilder.equalsIgnoreCase(getFirstRecordCellTextByColumnName("Transfer Amount")) ? true : false;
	}
	
	public String getMaskedWalletNumberWithCurrencyCode(Device device, CardToCash details) {
		return device.getWalletNumber().substring(0, 4) + "XXXXXXXXXXX" + device.getWalletNumber().substring(15)+" ["+details.getRemittanceCurrency()+"] ";
	}
	
	public void performRemittanceCardToCashLookup(Device device, CardToCash details) {
		WebElementUtils.enterText(deviceNumberTxt, device.getDeviceNumber());
		WebElementUtils.asWebElement(deviceNumberTxt).sendKeys(Keys.TAB);
		WebElementUtils.selectDropDownByVisibleText(walletNumnberDdwn, getMaskedWalletNumberWithCurrencyCode(device, details));
		clickViewButton();
		SimulatorUtilities.wait(5000);//the delay is to wait for page rendering
		clickRemittanceRadioButton();
		WebElementUtils.enterText(rrnTxt, details.getRemittanceNumber());
		clickSubmitButton();
	}
 }