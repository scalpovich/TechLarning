package com.mastercard.pts.integrated.issuing.pages.cardholder.services;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.domain.ServicesNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = ServicesNav.TAB_SERVICES, treeMenuItems = { ServicesNav.L1_REPLACE_DEVICE })
public class ReplaceDevicePage extends ServicesAbstractPage {
	
	@PageElement(findBy = FindBy.ID, valueToFind="reasonCode")
	private MCWebElement replacementResone;
	
	@PageElement(findBy = FindBy.ID, valueToFind="mpts_cardHolderPortal_button_submit")
	private MCWebElement replacemenetRsnSubmitBtn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//td[@class='SuccessMessageTxt']")
	private MCWebElement replacementConfirmationMsg;
	
	public void selectReplaceMentOption(String optionName){
		selectByText(replacementResone, optionName);
	}
	
	public void submitReplacementRequest(){
		clickWhenClickableCHP(replacemenetRsnSubmitBtn);
	}
	
	public String getReplacementRequestConfirmationMsg(){
		return getTextFromPage(replacementConfirmationMsg);
	}
	
	public void verifyUiOperationStatus() {
		verifyUiOperationStatusReusable("Replace Device");
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(reasonCodeDDwn));
	}
}