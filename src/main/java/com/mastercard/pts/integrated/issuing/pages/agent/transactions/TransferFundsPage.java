package com.mastercard.pts.integrated.issuing.pages.agent.transactions;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.agent.transactions.TransferFunds;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = TransactionsNav.TAB_TRANSACTIONS, treeMenuItems = { TransactionsNav.L1_OTHERS, TransactionsNav.L2_OTHERS_TRANSFER_FUNDS })
public class TransferFundsPage extends AbstractBasePage {
	private static final Logger logger = LoggerFactory.getLogger(TransferFundsPage.class);

	@Value("${default.wait.timeout_in_sec}")
	private long timeoutInSec;

	private static final By INFO_MESSAGE_LOCATOR = By.className("SuccessMessageTxt");
	
	private static final String SUCCESS_MESSAGE = "Success message: {}";
	
	// main screen locators
	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value=VisaMoneyTransferHome]")
	private MCWebElement visaMoneyTransferHomeRBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value=WalletToWalletTransferHome]")
	private MCWebElement walletToWalletTransferHomeRBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value=InterBankFundTransferHome]")
	private MCWebElement interBankFundTransferHomeRBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value=MasterCardMoneySendHome]")
	private MCWebElement masterCardMoneySendHomeRBtn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value=Continue]")
	private MCWebElement continueBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "deviceNumber")
	private MCWebElement deviceNumberTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind="//Select[@id='walletNumber']")	
	private MCWebElement walletNumberDropDown;	

	@PageElement(findBy = FindBy.NAME, valueToFind = "toDeviceNumber")
	private MCWebElement toDeviceNumberTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionAmount")
	private MCWebElement transactionAmountTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "selectedWalletCurrencyCode")
	private MCWebElement selectedWalletCurrencyCodeDropDown;

	@PageElement(findBy = FindBy.NAME, valueToFind = "beneficiaryContactNumber")
	private MCWebElement beneficiaryContactNumberTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "beneficiaryName")
	private MCWebElement beneficiaryNameTxt;
	 
	@PageElement(findBy = FindBy.NAME, valueToFind = "memo")
	private MCWebElement memoTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value=Submit]")
	private MCWebElement submitBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value=Confirm]")
	private MCWebElement confirmBtn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "txnPassword")
	private MCWebElement txnPasswordTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[contains(text(),'VISA Money Transfer (Offline)')]/preceding-sibling::input")
	private MCWebElement vmtOfflineRadioBtn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[contains(text(),'VISA Fast Fund (Real Time)')]/preceding-sibling::input")
	private MCWebElement vmtRealTimeRadioBtn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "remarks")
	private MCWebElement remarksTxt;
	
	public void verifyUiOperationStatus() {
		logger.info("Transfer Funds");
		verifyButton("Continue");
		verifyButton("Cancel");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(visaMoneyTransferHomeRBtn),
				WebElementUtils.visibilityOf(walletToWalletTransferHomeRBtn), WebElementUtils.visibilityOf(interBankFundTransferHomeRBtn),
				WebElementUtils.visibilityOf(masterCardMoneySendHomeRBtn));
	}

	// methods
	public String getMasterDetailContentTitleText() {
		logger.info("Transfer Funds Master Detail Tilte Text: {}");
		return new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(masterDetailContentTitle)).getText();
	}
	
	public String transferFund(TransferFunds transferDetails,Device device) {		
		if(transferDetails.getTransaferThrough().equalsIgnoreCase("mms"))
			return masterCardMoneyTransfer(transferDetails, device);
		if(transferDetails.getTransaferThrough().equalsIgnoreCase("vmt") ||  transferDetails.getTransaferThrough().equalsIgnoreCase("vmtr"))
			return visaMoneyTransfer(transferDetails, device);	
		return INVALID_TRANSACTION_MESSAGE+transferDetails.getTransaferThrough();
	}
	
	public String visaMoneyTransfer(TransferFunds transferDetails,Device device)
	{
		ClickButton(visaMoneyTransferHomeRBtn);	
		clickWhenClickable(continueBtn);
		if(transferDetails.getTransaferThrough().equalsIgnoreCase("vmt"))
		{
			ClickButton(vmtOfflineRadioBtn);
		}else if(transferDetails.getTransaferThrough().equalsIgnoreCase("vmtr"))
		{
			ClickButton(vmtRealTimeRadioBtn);		
		}
		
		String transferDetail[]=transferDetails.getTransferDetails().split(":");			
		enterText(deviceNumberTxt, device.getDeviceNumber());	
		clickWhenClickable(walletNumberDropDown);
		SimulatorUtilities.wait(100);			
		logger.info("WalletNumber : - {}",getMaskedWalletNumber(device.getWalletNumber())+" ["+device.getCurrencyofTransfer()+"] ");		
		selectByText(walletNumberDropDown, getMaskedWalletNumber(device.getWalletNumber())+" ["+device.getCurrencyofTransfer()+"] ");
		enterText(toDeviceNumberTxt, device.getExistingDeviceNumber());		
		//Enter transaction amount = transferDetail[0]
		enterText(transactionAmountTxt, transferDetail[0]);		
		//Enter wallet currency amount = transferDetail[1]
		selectByText(selectedWalletCurrencyCodeDropDown, transferDetail[1]);
		clickSubmitButton();
		enterText(txnPasswordTxt, device.getTransactionPassword());
		//Enter memo text/Transaction Remark  = transferDetail[3]
		enterText(remarksTxt, transferDetail[3]);
		clickConfirmButton();
		return getSuccessMessage();				
	}
	
	@Override
	protected String getSuccessMessage() {
		try {
			WebElement successMessageLbl = new WebDriverWait(driver(), timeoutInSec)
					.until(ExpectedConditions.visibilityOfElementLocated(INFO_MESSAGE_LOCATOR));
			logger.info(SUCCESS_MESSAGE, successMessageLbl.getText());

			return successMessageLbl.getText();

		} catch (NoSuchElementException e) {
			logger.info("No Status is updated");
			logger.debug("Error", e);
			return null;
		}
	}
	
	public String masterCardMoneyTransfer(TransferFunds transferDetails,Device device){
		ClickButton(masterCardMoneySendHomeRBtn);
		clickWhenClickable(continueBtn);
		String transferDetail[]=transferDetails.getTransferDetails().split(":");			
		enterText(deviceNumberTxt, device.getDeviceNumber());
		SimulatorUtilities.wait(100);	
		clickWhenClickable(walletNumberDropDown);
		logger.info("WalletNumber : - {}",getMaskedWalletNumber(device.getWalletNumber())+" ["+device.getCurrencyofTransfer()+"] ");		
		selectByText(walletNumberDropDown, getMaskedWalletNumber(device.getWalletNumber())+" ["+device.getCurrencyofTransfer()+"] ");
		enterText(toDeviceNumberTxt, device.getExistingDeviceNumber());		
		//Enter transaction amount = transferDetail[0]
		enterText(transactionAmountTxt, transferDetail[0]);		
		//Enter wallet currency amount = transferDetail[1]
		selectByText(selectedWalletCurrencyCodeDropDown, transferDetail[1]);
		enterText(beneficiaryContactNumberTxt,transferDetails.getContactNumber());
		//Enter beneficiary Name  = transferDetail[2]
		enterText(beneficiaryNameTxt, transferDetail[2]);	
		//Enter memo text/Transaction Remark  = transferDetail[3]
		enterText(memoTxt, transferDetail[3]);
		clickSubmitButton();
		enterText(txnPasswordTxt, device.getTransactionPassword());
		clickConfirmButton();
		return getSuccessMessage();		
		
	}
	
	public String getMaskedWalletNumber(String walletNumber)
	{
		return  walletNumber.substring(0, 4) +"XXXXXXXXXXX" + walletNumber.substring(walletNumber.length()-4, walletNumber.length());
	}
	
}
