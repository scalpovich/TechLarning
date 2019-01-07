package com.mastercard.pts.integrated.issuing.pages.cardholder.virtualcard;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.cardholder.CardholderServices;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = VirtualCardNav.TAB_VIRTUAL_CARD, treeMenuItems = { VirtualCardNav.L1_REQUEST_FOR_LIMITED_VALIDITY_VIRTUAL_CARD })
public class RequestForLimitedValidityVirtualCardPage extends AbstractBasePage {
	private static final Logger logger = LoggerFactory.getLogger(RequestForLimitedValidityVirtualCardPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;
	
	@PageElement(findBy = FindBy.ID, valueToFind="mpts_cardHolderPortal_button_submit")
	private MCWebElement submitVirtualCardReq;	

	@PageElement(findBy = FindBy.X_PATH, valueToFind="//*[@class='sectionHead']/td/../following-sibling::tr[1]/td")
	private MCWebElement responseLbl;
	
	public void verifyUiOperationStatus() {
		logger.info("Request for Limited Validity Virtual Card");
		verifyTitleCardHolderPortal("Limited Validity Virtual Card Request");
		verifyButton("OK");
	}
	
	public String getVirtualCardRequestResponse(){
		return getTextFromPage(responseLbl);
	}
	
	public String submitRequestForVirtualCard(CardholderServices cardholderService){
		clickWhenClickable(submitVirtualCardReq);
		waitForLoaderToDisappear();
		return getTextFromPage(responseLbl);
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle));
	}
}
