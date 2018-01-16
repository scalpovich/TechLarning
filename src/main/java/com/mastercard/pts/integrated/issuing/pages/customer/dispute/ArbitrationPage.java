package com.mastercard.pts.integrated.issuing.pages.customer.dispute;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.dispute.RetrievalRequest;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = DisputeNav.TAB_DISPUTE, treeMenuItems = {
		DisputeNav.L1_DISPUTE_ACTIVITY, DisputeNav.L2_ARBITRATION })

public class ArbitrationPage extends AbstractDisputePage {
	
	@PageElement(findBy = FindBy.NAME, valueToFind="chargebackContainer:reasonCode:input:dropdowncomponent")
	private MCWebElement resoneDropDown;
	
	@PageElement(findBy = FindBy.NAME, valueToFind="chargebackContainer:documentationIndicator:input:dropdowncomponent")
	private MCWebElement documentationOption;
	
	@PageElement(findBy = FindBy.NAME, valueToFind="chargebackContainer:messageText:input:textAreaComponent")
	private MCWebElement textInpt;
	
	public void verifyUiOperationStatus() {
		verifyOperationStatus("Arbitration");
	}
	
	public void createArbitration(RetrievalRequest rr){
		searchByArn(rr.getArn(),"View Search Result");
		selectByVisibleTexts(resoneDropDown, rr.getReasonCode());
		selectByVisibleTexts(documentationOption, rr.getReasonCode());
		WebElementUtils.enterText(textInpt, "Create Arbitration for dispute");		
	}
	
	public void selectArbitrationType(String ArbitrationType){
		if(ArbitrationType != null){
			
		}
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(interDDwn),
				WebElementUtils.elementToBeClickable(transactionDateDpkr),
				WebElementUtils.elementToBeClickable(microfilmRefNumber),
				WebElementUtils.elementToBeClickable(cardNumber)
				);
	}

}