package com.mastercard.pts.integrated.issuing.pages.cardholder.services;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.ServicesNav;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;

@Component
@Navigation(tabTitle = ServicesNav.TAB_SERVICES, treeMenuItems = { ServicesNav.L1_UNBLOCK_DEVICE })
public class UnblockDevicePage extends ServicesAbstractPage {
	
	@PageElement(findBy = FindBy.ID, valueToFind="remarks")
	private MCWebElement unblockDeviceRemarksInpt;
	
	@PageElement(findBy = FindBy.ID, valueToFind="mpts_cardHolderPortal_button_unblock")
	private MCWebElement unblockDeviceBtn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//table[@class='modelFormClass'][3]/tbody/tr[2]/td")
	private MCWebElement unblockCardConfirMsg;
	
	@PageElement(findBy = FindBy.NAME, valueToFind="mpts.cardHolderPortal.button.ok")
	private MCWebElement clickOkayButtonAfterConfirmation;
	
	public void clickOnOkayBtn(){
		ClickButton(clickOkayButtonAfterConfirmation);
	}
	
	public void enterCardUnblockRemerk(String unblockCardRemark){
		enterText(unblockDeviceRemarksInpt, unblockCardRemark);
	}
	
	public void confirmUnblockCardRequestBtn(){
		clickWhenClickableCHP(unblockDeviceBtn);
	}
	
	public String getUnblockCardRequestResponse(){
		return getTextFromPage(unblockCardConfirMsg);
	}
	
	public void verifyUiOperationStatus() {
		verifyUiOperationStatusReusable("Unblock Device", "Unblock");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(remarksTxt));
	}
}