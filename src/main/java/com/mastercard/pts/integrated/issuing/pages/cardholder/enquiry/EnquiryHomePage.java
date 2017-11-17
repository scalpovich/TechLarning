package com.mastercard.pts.integrated.issuing.pages.cardholder.enquiry;

import java.util.Arrays;
import java.util.Collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.EnquiryNav;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;





@Component
@Navigation(tabTitle = EnquiryNav.TAB_ENQUIRY)
public class EnquiryHomePage extends AbstractBasePage {
	
	@Autowired
	private WebDriverProvider driverProvider;
	
	private static final Logger logger = LoggerFactory.getLogger(EnquiryHomePage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;
	
	@PageElement(findBy =FindBy.NAME, valueToFind ="transactionType")
	private MCWebElement transactionTypeDropdown;
	
	@PageElement(findBy = FindBy.NAME, valueToFind ="transactionAmount")
	private MCWebElement transactionAmount;
	
	@PageElement(findBy = FindBy.NAME, valueToFind ="selectedTxnCurrency")
	private MCWebElement transactionCurrency;
	
	@PageElement(findBy = FindBy.NAME, valueToFind ="mpts.cardHolderPortal.button.submit")
	private MCWebElement submitButton;
	
	@PageElement(findBy = FindBy.NAME, valueToFind ="mpts.cardHolderPortal.button.cancel")
	private MCWebElement cancelButton;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind ="//table[@class='modelFormClass']/tbody/tr[3]/td[3]")
	private MCWebElement transactionType;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind= "//table[@class='modelFormClass']/tbody/tr[4]/td[3]")
	private MCWebElement conversationRate;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind= "//table[@class='modelFormClass']/tbody/tr[5]/td[3]")
	private MCWebElement transactionAmountCharged;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind= "mpts.cardHolderPortal.button.ok")
	private MCWebElement okayRestButton;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//input[@id='optionFlag1']")
	private MCWebElement transactionsOptionRdo;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//input[@id='noOfTxns']")
	private MCWebElement noOfTransactionCount;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//input[@id='mpts_cardHolderPortal_button_submit']")
	private MCWebElement trascationSearchSubmitBtn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//li[@id='ViewTransactionHistory']/a")
	private MCWebElement transactionMenuTab;
	
	private String transactionHistoryGrid = "//table[@class='dataview']/tbody/child::tr";
	
	
	public void verifyUiOperationStatus() {
		logger.info("Enquiry");
		verifyTitleCardHolderPortal("Enquiry");
	}
	
	public void clickOnTransactionsTab(){
		transactionMenuTab.click();
	}
	
	public void setNoOfTransactionCount(String tranCount){
		noOfTransactionCount.sendKeys(tranCount);
	}
	public void clickOnTransactionSubmitBtn(){
		trascationSearchSubmitBtn.click();
	}
	public void selectTransactionType(String transactionType){
		CustomUtils.ThreadDotSleep(1000);
		selectByVisibleTexts(transactionTypeDropdown, transactionType);
	}
	
	public void selectTransactionsCount(){
		transactionsOptionRdo.click();
	}
	
	public void enterTransctionAmount(String transactionAmtValue){
		CustomUtils.ThreadDotSleep(1000);
		enterText(transactionAmount, transactionAmtValue);
	}
	
	public void selectTransactionCurrency(String transcationCurrencyOption){
		CustomUtils.ThreadDotSleep(1000);
		selectByVisibleTexts(transactionCurrency, transcationCurrencyOption);
	}
	
	public String getTransactionTypeValue(){		
		
		return getTextFromPage(transactionType);
	}
	
	public String getConversionRate(){
		return getTextFromPage(conversationRate);
	}
	
	public String getTransactionAmount(){
		return getTextFromPage(transactionAmountCharged);
	}
	
	public String getBillingAmount(){
		return null;
	}
	
	public String getMarkUpFee(){
		return null;
	}
	public String getTransactionFee(){
		return null;
	}
	public String getTaxOnTransction(){
		return null;
	}
	public String getTotalDebateAmount(){
		return null;
	}
	public void clickOnSubmitButton(){
		ClickButton(submitButton);
	}
	
	public void clickOnCancelButton(){
		ClickButton(cancelButton);
	}
	
	public void clickOkayRestButton(){
		ClickButton(okayRestButton);
	}
	public String checkTransactionType(){
		return getTextFromPage(transactionType);
	}
	
	public String checkTransactionCharge(){
		return getTextFromPage(conversationRate);
		
	}
	
/*	//Read entire transaction details on Card holder portal
	public List<ArrayList<String>>  getTransactionDetails1(){
		List<ArrayList<String>> transRecord = new ArrayList<ArrayList<String>>();
		
		List<WebElement> gridRecords = Elements(transactionHistoryGrid);		
		
		for(int index=2; index <=gridRecords.size();index++ ){			
			ArrayList<String> sample = new ArrayList<String>();
			
			sample.add(Element("//table[@class='dataview']/tbody/tr["+index+"]/td[5]").getText());
			sample.add(Element("//table[@class='dataview']/tbody/tr["+index+"]/td[6]").getText());
			sample.add(Element("//table[@class='dataview']/tbody/tr["+index+"]/td[7]").getText());
					
			transRecord.add(sample);			
		}
		
		return transRecord;
	}*/
	
	//Read entire transaction details on Card holder portal
	public Map<Integer,ArrayList<String>>  getTransactionDetails(){
		
		Map<Integer,ArrayList<String>> transRecord = new HashMap<Integer,ArrayList<String>>();
		Integer transactionCounter = 1;			
		List<WebElement> gridRecords = Elements(transactionHistoryGrid);		
		ArrayList<String> sample ;
		for(int index=2; index <= gridRecords.size();index++ ){									
			
			sample = new ArrayList<String>();			
			sample.add(Element("//table[@class='dataview']/tbody/tr["+index+"]/td[1]").getText());
			sample.add(Element("//table[@class='dataview']/tbody/tr["+index+"]/td[2]").getText());
			sample.add(Element("//table[@class='dataview']/tbody/tr["+index+"]/td[3]").getText());
			sample.add(Element("//table[@class='dataview']/tbody/tr["+index+"]/td[4]").getText());
			sample.add(Element("//table[@class='dataview']/tbody/tr["+index+"]/td[5]").getText());
			sample.add(Element("//table[@class='dataview']/tbody/tr["+index+"]/td[6]").getText());
			sample.add(Element("//table[@class='dataview']/tbody/tr["+index+"]/td[7]").getText());
			sample.add(Element("//table[@class='dataview']/tbody/tr["+index+"]/td[8]").getText());
					
			transRecord.put(transactionCounter,sample);
			transactionCounter++;
		}
		return transRecord;
	}
	
		@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle));
}