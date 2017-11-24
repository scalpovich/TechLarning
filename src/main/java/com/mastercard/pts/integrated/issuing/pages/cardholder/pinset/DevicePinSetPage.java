package com.mastercard.pts.integrated.issuing.pages.cardholder.pinset;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.cardholder.enquiry.TransactionsPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;
import com.mastercard.pts.integrated.issuing.domain.cardholder.CardHolderPinSet;

@Component 
@Navigation(tabTitle = CardHolderPinSet.TAB_PINSET, treeMenuItems = {CardHolderPinSet.PIN_SET})
public class DevicePinSetPage extends AbstractBasePage{	
	
	private static final Logger logger = LoggerFactory.getLogger(TransactionsPage.class);
	
	private String deviceGrid = "//form[@id='myForm']/table[2]/tbody/child::tr";
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//form[@id='myForm']/table[2]/tbody/tr")
	private MCWebElement devicesTable;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//div[@class='dataview-div']/table/tbody/tr[2]")
	private MCWebElement deviceTableRow;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//div[@class='dataview-div']/table/tbody/tr[2]")
	private MCWebElement selectDeviceBtn;
	
	public void selectDeviceForPinSet(String cardNumber){
		
		List<WebElement> rowsList = Elements(deviceGrid);
		
		for(int index =2; index <= Elements(deviceGrid).size() ; index++){
			if(rowsList.get(index).findElement((By) deviceTableRow).getAttribute("id").equals("5206797198380018")){
				System.out.println("Testing");
				getDeviceId(rowsList.get(index).findElement((By) deviceTableRow));
			}
		}
	}
	
	public String getDeviceId(WebElement webElement){
//		getFinder().getWebDriver().
		return null;
	}
	
}
