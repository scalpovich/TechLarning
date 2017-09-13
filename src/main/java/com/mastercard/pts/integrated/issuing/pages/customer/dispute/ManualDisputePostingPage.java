package com.mastercard.pts.integrated.issuing.pages.customer.dispute;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.dispute.ManualDisputePosting;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = DisputeNav.TAB_DISPUTE, treeMenuItems = {
		DisputeNav.L1_DISPUTE_ACTIVITY, DisputeNav.L2_MANUAL_DISPUTE_POSTING })

public class ManualDisputePostingPage extends AbstractDisputePage {
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchContainer:chargebackType:input:dropdowncomponent")
	protected MCWebElement disputeTypeDDwn;

	private static final String POPUP_TITLE = "View Search Results";

	public void searchManualDisputePosting(ManualDisputePosting mdp) {
		WebElementUtils.selectDropDownByVisibleText(disputeTypeDDwn, mdp.getDisputeType());
		searchByArn("", POPUP_TITLE);
	}
	
	public void verifyUiOperationStatus() {
		verifyOperationStatus("Manual Dispute Posting");
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(interDDwn),
				WebElementUtils.elementToBeClickable(transactionDateDpkr),
				WebElementUtils.elementToBeClickable(microfilmRefNumber),
				WebElementUtils.elementToBeClickable(cardNumber),
				WebElementUtils.elementToBeClickable(disputeTypeDDwn)
				);
	}

}