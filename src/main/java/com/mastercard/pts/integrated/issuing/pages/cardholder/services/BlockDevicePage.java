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
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = ServicesNav.TAB_SERVICES, treeMenuItems = { ServicesNav.L1_BLOCK_DEVICE })
public class BlockDevicePage extends ServicesAbstractPage {
	
	@PageElement(findBy = FindBy.ID, valueToFind="remarks")
	private MCWebElement blackDeviceRemarkInpt;
	
	@PageElement(findBy = FindBy.ID, valueToFind="mpts_cardHolderPortal_button_block")
	private MCWebElement confirmBlockBtn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//table[@class='modelFormClass'][2]/tbody/tr[2]/td")
	public MCWebElement confirmationMsgOnBlockCard;
	
	
	@PageElement(findBy = FindBy.ID, valueToFind="mpts.cardHolderPortal.button.ok")
	private MCWebElement okButtonAfterConfirmaiton;
	
	public void verifyUiOperationStatus() {
		verifyUiOperationStatusReusable("Block Device", "Block");
	}
	public String getCardBlockConfirmMsg(){
		return getTextFromPage(confirmationMsgOnBlockCard);
	}
	
	public void clickOnOkayButton(){
		ClickButton(okButtonAfterConfirmaiton);
	}
	
	public void enterCardBlockRemark(String cardblockRemark){
		enterText(blackDeviceRemarkInpt, cardblockRemark);
	}
	
	public void confirmCardBlockRequest(){
		clickWhenClickableCHP(confirmBlockBtn);
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(remarksTxt));
	}
}
