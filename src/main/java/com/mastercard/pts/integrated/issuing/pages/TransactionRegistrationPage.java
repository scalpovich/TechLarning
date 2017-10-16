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
public class TransactionRegistrationPage extends AbstractBasePage{
	
//	------------- Card Management > Institution Parameter Setup > Cutover Profile [ISSS03]
	
	/*@PageElement(findBy = FindBy.X_PATH, valueToFind = "/html/body/div[2]/div[4]/div[2]/div[2]/form/div[3]/span[1]/input")
	private MCWebElement BusinessDate;*/
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@type = 'checkbox'][@name ='selectAll']")
	private MCWebElement BusinessDate;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "Save")
	private MCWebElement save;
	
	public void addtransactionregistration()
	{
		BusinessDate.click();
		CustomUtils.ThreadDotSleep(3000);
		save.click();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}
