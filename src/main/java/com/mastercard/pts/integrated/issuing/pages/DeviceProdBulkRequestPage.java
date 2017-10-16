package com.mastercard.pts.integrated.issuing.pages;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class DeviceProdBulkRequestPage extends AbstractBasePage{
	
//	------------- Card Management > Institution Parameter Setup > Institution Currency [ISSS05]
	
	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addDeviceProdBulkRequest;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "productType:input:dropdowncomponent")
	private MCWebElement ProductType;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "branchCode:input:dropdowncomponent")
	private MCWebElement Branch;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "programCode:input:dropdowncomponent")
	private MCWebElement Program;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "devicePlanCode:input:dropdowncomponent")
	private MCWebElement DevicePlan;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "quantity:input:inputTextField")
	private MCWebElement QuantityRequested;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement Save;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelERROR']")
	private MCWebElement PanelError;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement cancel;
	
	public void addDeviceProdBulkRequest()
	{
		addDeviceProdBulkRequest.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");
		
		ProductType.getSelect().selectByVisibleText(env.getProperty("is.dinners.bulkrequest.ProductType"));
		CustomUtils.ThreadDotSleep(1000);
		Branch.getSelect().selectByIndex(1);
		CustomUtils.ThreadDotSleep(1000);
		Program.getSelect().selectByIndex(1);
		CustomUtils.ThreadDotSleep(1000);
		DevicePlan.getSelect().selectByIndex(1);
		CustomUtils.ThreadDotSleep(1000);
		QuantityRequested.sendKeys(env.getProperty("is.dinners.bulkrequest.QuantityRequested"));
		CustomUtils.ThreadDotSleep(1000);
		
		Save.click();
		CustomUtils.ThreadDotSleep(5000);
		try{
			if(PanelError.isVisible()){
				System.out.println("inside error pannel");
				cancel.click();
			} }
			catch(Exception e){
				System.out.println("error pannel not present");
			}
		
		getFinder().getWebDriver().switchTo().defaultContent();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}
