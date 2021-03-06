package com.mastercard.pts.integrated.issuing.pages.cardholder.transactions;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.cardholder.CardHolderTransactions;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;
import com.mastercard.pts.integrated.issuing.pages.cardholder.transactions.TransactionsNav;

@Component
@Navigation(tabTitle = TransactionsNav.TAB_TRANSACTIONS, treeMenuItems = { TransactionsNav.L1_CANCEL_REMITTANCE_BOOKING })
public class CancelRemittanceBookingPage extends AbstractBasePage {
	private static final Logger logger = LoggerFactory.getLogger(CancelRemittanceBookingPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;

	@PageElement(findBy  =FindBy.X_PATH, valueToFind="//td[@class='ResponseTxt']")
	private MCWebElement cancelRemittanceErrorMsg;
	
	@PageElement(findBy  =FindBy.ID, valueToFind="mpts_cardHolderPortal_button_ok")
	private MCWebElement cancelRemittanceOkBtn;
	
	@PageElement(findBy = FindBy.X_PATH,valueToFind="//td[@class='ResponseTxt']")
	private MCWebElement noDataFoundMsg;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="")
	private MCWebElement confirmCashRemittanceBookingMsg;
	
	@PageElement(findBy = FindBy.ID, valueToFind="mpts_cardHolderPortal_button_submit")
	private MCWebElement cashRemittanceSubmitBtn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind="txnPassword")
	private MCWebElement transactionPassTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind="remarks")
	private MCWebElement transactionRemarkTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//*[@class='sectionHead']/td/../following-sibling::tr[1]/td")
	private MCWebElement responseLbl;
	
	public void clickOnOkBtn(){
		ClickButton(cancelRemittanceOkBtn);
	}
	
	public void verifyUiOperationStatus() {
		logger.info("Cancel Remittance Booking");
		verifyTitleCardHolderPortal("Cancel Remittance Booking");
	
	}
	
	public String checkCancelRemittanceMsg(){
		return getTextFromPage(cancelRemittanceErrorMsg);
	}
	
	public String checkMasterDetailedContentTitle(){
		return getTextFromPage(masterDetailContentTitle);
	}
	
	public String cancelRemittanceRequst(CardHolderTransactions cardhlTran){
		String element = String.format("//tr[@id='%s']", cardhlTran.getRemittanceRefNumber());
		Element(element).click();
		ClickButton(cashRemittanceSubmitBtn);
		waitForPageToLoad(driver());
		enterText(transactionPassTxt, cardhlTran.getTransctionPassword());
		enterText(transactionRemarkTxt,cardhlTran.getTransactionRemark());
		ClickButton(cashRemittanceSubmitBtn);
		waitForLoaderToDisappear();
		return getTextFromPage(responseLbl);
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle));
	}
}
