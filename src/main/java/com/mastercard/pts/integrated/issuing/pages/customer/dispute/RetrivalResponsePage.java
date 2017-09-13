package com.mastercard.pts.integrated.issuing.pages.customer.dispute;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = DisputeNav.TAB_DISPUTE, treeMenuItems = {
		DisputeNav.L1_DISPUTE_ACTIVITY,	DisputeNav.L2_RETRIVAL_RESPONSE})
public class RetrivalResponsePage extends AbstractDisputePage {
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchSectionContainer:networkCode:input:dropdowncomponent")
	protected MCWebElement responseInterchangeDDwn;
	
	private static final Logger logger = LoggerFactory.getLogger(RetrivalResponsePage.class);

	public void searchByArn(String arn)
	{
		searchByArn(arn, "Search Result");
	}
	
	public boolean validateTransactionAndSubmitRetrivalRequest(String amount)
	{
			if(!readOnlyTransactionAmount.getText().equalsIgnoreCase(amount))
			{
				logger.error("Transaction amount from Arn is different ",amount,readOnlyTransactionAmount.getText());
				return false;
			}
			clickSaveButton();
			return true;
	}
	
	public void verifyUiOperationStatus() {
		verifyOperationStatus("Retrieval Response");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(responseInterchangeDDwn),
				WebElementUtils.elementToBeClickable(transactionDateDpkr),
				WebElementUtils.elementToBeClickable(microfilmRefNumber),
				WebElementUtils.elementToBeClickable(cardNumber));
	}

}