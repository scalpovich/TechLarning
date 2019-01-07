package com.mastercard.pts.integrated.issuing.pages.cardholder.transactions;

import org.junit.Assert;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.TransactionsNav;
import com.mastercard.pts.integrated.issuing.domain.cardholder.CardHolderTransactions;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = TransactionsNav.TAB_TRANSACTIONS ,treeMenuItems = { TransactionsNav.L1_CARD_TO_CARD})
public class CardToCardTransferPage extends AbstractBasePage{
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//Select[@id='toWalletNumber']")	
	private MCWebElement walletNumDropList;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//input[@id='transactionAmount']")
	private MCWebElement amountToTransfer;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//input[@id='mpts_cardHolderPortal_button_submit']")
	private MCWebElement submitBtn;
	
	@PageElement(findBy = FindBy.X_PATH , valueToFind="//input[@id='Transaction Password']")
	private MCWebElement transactionPassword;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//input[@id='remarks']")
	private MCWebElement transactionRemarks;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//input[@id='mpts_cardHolderPortal_button_confirm']")
	private MCWebElement confirmButton;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//input[@id='selectedTxnCurrency']")
	private MCWebElement transferCurrencyOption;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//td[@class='ResponseTxt']")
	private MCWebElement transactionStatusMessage;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//*[@class='sectionHead']/td/../following-sibling::tr[1]/td")
	private MCWebElement confirmMessage;
	
	public void walletToWalletTransfer(CardHolderTransactions cardhlfTran){
		SelectDropDownByValue(walletNumDropList,cardhlfTran.getWalletFromAmountTransfer());
		WebElementUtils.enterText(amountToTransfer,cardhlfTran.getWalletTransferAmount());
		//selectByVisibleTexts(transferCurrencyOption,cardhlfTran.getWalletTransferCurrency());
		clickWhenClickable(submitBtn);		
		waitForLoaderToDisappear();
		WebElementUtils.enterText(transactionPassword,cardhlfTran.getTransctionPassword());
		WebElementUtils.enterText(transactionRemarks,cardhlfTran.getTransactionRemark());
		clickWhenClickable(confirmButton);
		waitForLoaderToDisappear();
		Assert.assertTrue(confirmMessage.getText().contains("Your transaction is successful"/*cardhlfTran.getWalletToWalletTransSucessMsg()*/));
	}
}
