package com.mastercard.pts.integrated.issuing.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.AbstractPage;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class HeaderPage extends AbstractPage{
	
    @PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[@title='Sign Out']")
    private MCWebElement signOutCustomerLnk;
    
    @PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[contains(.,'Signout')]")
    private MCWebElement signOutAgentLnk;

	@Override
	protected List<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.visibilityOf(signOutCustomerLnk));
	}

    public void signOutCustomer(){
    	signOutCustomerLnk.click();
    }
    
    public void signOutAgent(){
    	signOutAgentLnk.click();
    }
}
