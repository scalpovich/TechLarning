package com.mastercard.pts.integrated.issuing.pages.cardholder.services;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.ServicesNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;


@Component
@Navigation(tabTitle = ServicesNav.TAB_SERVICES, treeMenuItems = { ServicesNav.L1_ACTIVATE_DEACTIVATE_WALLET})
public class ActivateDeactivateWalletPage extends ServicesAbstractPage {
	
	
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//td[@class='displayName']")
	private MCWebElement walletStatus;
	
	@PageElement(findBy = FindBy.ID, valueToFind="remarks")
	private MCWebElement activateDeactivateWalletRemarkInpt;
	
	@PageElement(findBy = FindBy.ID, valueToFind="mpts_cardHolderPortal_button_submit")
	private MCWebElement activateDeactivateWalletSubmitBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind="//td[@class='SuccessMessageTxt']")
	private MCWebElement activateDeactivateConfirmationMeg;
	
	public void verifyUiOperationStatus() {
		verifyUiOperationStatusReusable("Activate/ Deactivate Wallet");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(remarksTxt),
				WebElementUtils.visibilityOf(walletStatusLbl));
	}
	public String getWalletStatus(){
		return getTextFromPage(walletStatus);
	}
	
	public void setActivateDeactivaeteWalletRemrk(String walletRemark){
		enterText(activateDeactivateWalletRemarkInpt, walletRemark);
	}
	
	public void clickOnWalletActivateDeactivateSubtButton(){
		clickWhenClickableCHP(activateDeactivateWalletSubmitBtn);
	}
	
	public String getWalletActivateDeactivateConfirmMsg(){
		return getTextFromPage(activateDeactivateConfirmationMeg);
	}
}
