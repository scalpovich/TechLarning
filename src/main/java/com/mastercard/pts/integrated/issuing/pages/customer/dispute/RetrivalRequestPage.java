package com.mastercard.pts.integrated.issuing.pages.customer.dispute;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.dispute.RetrievalRequest;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = DisputeNav.TAB_DISPUTE, treeMenuItems = {
		DisputeNav.L1_DISPUTE_ACTIVITY,
		DisputeNav.L2_RETRIVAL_REQUEST
		})
public class RetrivalRequestPage extends AbstractDisputePage {
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchSectionContainer:networkCode:input:dropdowncomponent")
	protected MCWebElement requestInterchangeDDwn;

	public void searchByArn(String arn) {
		searchByArn(arn, "Search Result");
	}
	
	public boolean validateTransactionAndSubmitRetrivalRequest(RetrievalRequest rr)
	{		
			WebElementUtils.waitForWicket(driver());
			WebElementUtils.selectDropDownByVisibleText(readOnlyRequestReasonCode, rr.getRequestResonCode());
			WebElementUtils.selectDropDownByVisibleText(readOnlyRequestCode, rr.getReasonCode());
			WebElementUtils.checkCheckbox(readOnlyApplyFee, rr.isApplyFee());
			//clickSaveButton();
			return true;
	}

	public void verifyUiOperationStatus() {
		verifyOperationStatus("Retrieval Request");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(requestInterchangeDDwn),
				WebElementUtils.elementToBeClickable(transactionDateDpkr),
				WebElementUtils.elementToBeClickable(microfilmRefNumber),
				WebElementUtils.elementToBeClickable(cardNumber));
	}
}