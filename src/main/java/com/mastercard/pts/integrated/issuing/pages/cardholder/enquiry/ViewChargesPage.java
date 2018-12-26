package com.mastercard.pts.integrated.issuing.pages.cardholder.enquiry;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Optional;
import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.cardholder.CardHolderEnquiry;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceBin;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = EnquiryNav.TAB_ENQUIRY, treeMenuItems = { EnquiryNav.L1_VIEW_CHARGES })
public class ViewChargesPage extends AbstractBasePage {
	
	private static final Logger logger = LoggerFactory.getLogger(ViewChargesPage.class);	
	
	@Autowired
	private TestContext context;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[contains(text(), 'Available Balance')]/following-sibling::td[1]")
	private MCWebElement availableBalanceLbl;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionType")
	private MCWebElement transactionTypeDDwn;

	@PageElement(findBy = FindBy.ID, valueToFind = "transactionAmount")
	private MCWebElement transactionAmountTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.ID, valueToFind = "selectedTxnCurrency")
	private MCWebElement selectedTxnCurrencyDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind ="mpts.cardHolderPortal.button.submit")
	private MCWebElement submitButton;
	
	HashMap<String,String> pageDetails = new HashMap<String,String>();
	
	public String conversationRate;
	
	public void verifyUiOperationStatus() {
		logger.info("View Charges");
		verifyTitleCardHolderPortal("View Charges");
		verifyWalletDetails();
		verifyButton("Submit");
		verifyButton("Cancel");
	}
	
	public Map<String,String> recordChargesFromPage(CardHolderEnquiry cardholderEnquiry){		
		String label = "//*[@class='displayName' and @colspan='2']";
		int index = 0;
		List<WebElement> labels = getFinder().getWebDriver().findElements(By.xpath(label));
		List<WebElement> values = getFinder().getWebDriver().findElements(By.xpath(label+"/following-sibling::td[@class='displayNameRight' and text()]"));
		
				for(WebElement element : labels){	
					logger.info("Transaction amount {} and Charges is {}",element.getText(),values.get(index).getText());
					pageDetails.put(element.getText(), values.get(index).getText());
					
						if(cardholderEnquiry.getTransactionChargeType().contains("GST")){
							if(element.getText().contains("GST")){{
								context.put(ContextConstants.CONVERSTION_RATE, values.get(index).getText());
							}
						}if(cardholderEnquiry.getTransactionChargeType().contains("Billing")){
							if(element.getText().contains("Converstion")){
								if(!values.get(index).getText().contains("-")){
									context.put(ContextConstants.CONVERSTION_RATE, values.get(index).getText());
									String conversationValue = String.valueOf(Integer.valueOf(cardholderEnquiry.getTransactionAmount()) * 
											Integer.valueOf(context.get(ContextConstants.CONVERSTION_RATE)));
									context.put(ContextConstants.CONVERSTION_RATE,conversationValue);
								}else{
									context.put(ContextConstants.CONVERSTION_RATE,cardholderEnquiry.getTransactionAmount());
								}
							}				
						}if(cardholderEnquiry.getTransactionChargeType().contains("Transaction")){
							
							if(element.getText().contains("Transaction")){{
								context.put(ContextConstants.CONVERSTION_RATE, values.get(index).getText());
							}
							
						}if(cardholderEnquiry.getTransactionChargeType().contains("Conversion")){							
							if(element.getText().contains("Conversion")){{
								context.put(ContextConstants.CONVERSTION_RATE, values.get(index).getText());
							}
						}
					}		
					
					index ++;
				}
			}
		}	
	    return pageDetails;		
	}
	
	public String checkChargesForTransactionType(CardHolderEnquiry cardholderEnquiry){
		selectByVisibleText(transactionTypeDDwn, cardholderEnquiry.getTransactionType());
		enterText(transactionAmountTxt, cardholderEnquiry.getTransactionAmount());
		if(!cardholderEnquiry.getTransactionType().contains("Intra Client")){
			selectByVisibleText(selectedTxnCurrencyDDwn, cardholderEnquiry.getTransactionCurrency());
		}		
		clickWhenClickable(submitButton);
		waitForLoaderToDisappear();
		waitForPageToLoad(driver());
		String value = recordChargesFromPage(cardholderEnquiry).entrySet().stream().filter(e -> e.getKey().contains(cardholderEnquiry.getTransactionChargeType())).findFirst().get().getValue();
		return value;
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(availableBalanceLbl),
				WebElementUtils.visibilityOf(transactionTypeDDwn), WebElementUtils.visibilityOf(transactionAmountTxt),
				WebElementUtils.visibilityOf(selectedTxnCurrencyDDwn));
	}
}
