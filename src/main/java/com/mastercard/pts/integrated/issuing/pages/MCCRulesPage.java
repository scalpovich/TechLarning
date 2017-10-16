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
public class MCCRulesPage extends AbstractBasePage{
	
	
//	------------- Card Management > Institution Parameter Setup > Institution Currency [ISSS05]
	
	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addMCCRules;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:1:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement MCC;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:2:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement Response;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;
	
	public void addmccrules()
	{
		addMCCRules.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");
		
		MCC.getSelect().selectByVisibleText(env.getProperty("is.dinners.mccrules.MCC"));
		CustomUtils.ThreadDotSleep(1000);
		Response.getSelect().selectByVisibleText(env.getProperty("is.dinners.mccrules.Response"));
		CustomUtils.ThreadDotSleep(1000);
		
		save.click();
		CustomUtils.ThreadDotSleep(2000);		
		getFinder().getWebDriver().switchTo().defaultContent();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}
