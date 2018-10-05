package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MID_TID_Blocking;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_ACTIVITY, CardManagementNav.L2_MID_TID_BLOCKING,
		})
public class MID_TID_BlockingPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(MID_TID_BlockingPage.class);


	@PageElement(findBy = FindBy.NAME, valueToFind = "networkCode:input:dropdowncomponent")
	private MCWebElement DDwnNetwork;

	@PageElement(findBy = FindBy.NAME, valueToFind = "productType:input:dropdowncomponent")
	private MCWebElement DDwnProductType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "terminalId:input:inputTextField")
	private MCWebElement txtbxTerminalID;

	@PageElement(findBy = FindBy.NAME, valueToFind = "merchantId:input:inputTextField")
	private MCWebElement txtbxMerchantID;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mcc:input:inputTextField")
	private MCWebElement txtbxMCC;

	@PageElement(findBy = FindBy.NAME, valueToFind = "acquiringCountryCode:input:inputTextField")
	private MCWebElement txtbxAcquiringCountryCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "acquirerId:input:inputTextField")
	private MCWebElement txtbxAcquirerID;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionCurrency:input:inputTextField")
	private MCWebElement txtbxTransactionCurrency;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cardholderPresenceIndicator:input:dropdowncomponent")
	private MCWebElement DDwnCardholderPresenceIndicator;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cardPresenceIndicator:input:dropdowncomponent")
	private MCWebElement DDwnCardPresenceIndicator;

	@PageElement(findBy = FindBy.NAME, valueToFind = "pOSEntryMode:input:dropdowncomponent")
	private MCWebElement DDwnPOSEntryMode;

	private void selectNetwork(String network){
		WebElementUtils.selectDDByVisibleText(DDwnNetwork, network);
	}

	private void selectProduct(String productType){
		WebElementUtils.selectDDByVisibleText(DDwnProductType, productType);
	}

	private void enterTerminalID(String terminalID){
		WebElementUtils.enterText(txtbxTerminalID, terminalID);
	}

	private void enterMerchantID(String merchantID){
		WebElementUtils.enterText(txtbxMerchantID, merchantID);
	}

	private void enterMCC(String MCC){
		WebElementUtils.enterText(txtbxMCC, MCC);
	}

	private void enterAcquiringCountryCode(String acquiringCountryCode){
		WebElementUtils.enterText(txtbxAcquiringCountryCode, acquiringCountryCode);
	}

	private void enterAcquirerID(String acquirerID){
		WebElementUtils.enterText(txtbxAcquirerID, acquirerID);
	}

	private void enterTransactionCurrency(String transactionCurrency){
		WebElementUtils.enterText(txtbxTransactionCurrency, transactionCurrency);
	}

	private void selectCardholderPresenceIndicator(String cardholderPresenceIndicator){
		WebElementUtils.selectDDByVisibleText(DDwnCardholderPresenceIndicator, cardholderPresenceIndicator);
	}

	private void selectPOSEntryMode(String POSEntryMode){
		WebElementUtils.selectDDByVisibleText(DDwnPOSEntryMode, POSEntryMode);
	}

	private void selectCardPresenceIndicator(String cardPresenceIndicator){
		WebElementUtils.selectDDByVisibleText(DDwnCardPresenceIndicator, cardPresenceIndicator);
	}


	private void selectValidCombinationForBlocking(String caseNumber, MID_TID_Blocking details){
		switch(caseNumber){
		case "1" :
			enterMCC(details.getMcc());
			enterAcquirerID(details.getAcquirerID());
			enterTerminalID(details.getTerminalID());
			break;
		case "2" :
			enterAcquiringCountryCode(details.getAcquiringCountryCode());
			enterMerchantID(details.getMerchantID());
			selectPOSEntryMode(details.getPosEntryMode());
			break;
		case "3" :
			selectPOSEntryMode(details.getPosEntryMode());
			enterMerchantID(details.getMerchantID());
			enterTransactionCurrency(details.getTransactionCurrency());
			break;
		case "4" : 
			enterAcquirerID(details.getAcquirerID());
			enterTerminalID(details.getTerminalID());
			enterMerchantID(details.getMerchantID());
			break;
		case "5" :
			enterMerchantID(details.getMerchantID());
			break;
		case "6" :
			enterMCC(details.getMcc());
			enterAcquirerID(details.getAcquirerID());
			enterTerminalID(details.getTerminalID());
			enterMerchantID(details.getMerchantID());
			break;
		case "7" :
			enterMCC(details.getMcc());
			enterTerminalID(details.getTerminalID());
			enterMerchantID(details.getMerchantID());
			break;
		case "8" :
			enterMCC(details.getMcc());
			enterTransactionCurrency(details.getTransactionCurrency());
			break;
		case "9" :
			enterAcquirerID(details.getAcquirerID());
			enterMerchantID(details.getMerchantID());
			break;
		case "10" :
			enterAcquiringCountryCode(details.getAcquiringCountryCode());
			enterAcquirerID(details.getAcquirerID());
			enterTerminalID(details.getTerminalID());
			break;
		case "11" : 
			enterAcquirerID(details.getAcquirerID());
			enterTerminalID(details.getTerminalID());
			break;
		}
	}

	public void addBlockingMID_TID(String combination, MID_TID_Blocking details){
		logger.info("Create MID TID Blocking combination for case {} " , combination);
		clickAddNewButton();
		runWithinPopup( "Add Blocking MID TID",
				() -> {
					selectNetwork(details.getNetwork());
					selectProduct(details.getProductType());
					selectValidCombinationForBlocking(combination, details);
					clickSaveButton();
				});
		verifyOperationStatus();
	}
	
	public void deleteRecord(){
		deleteFirstRecord();
		acceptPopup();
	}
}