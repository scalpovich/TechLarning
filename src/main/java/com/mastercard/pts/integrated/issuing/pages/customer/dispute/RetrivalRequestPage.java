package com.mastercard.pts.integrated.issuing.pages.customer.dispute;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.dispute.RetrievalRequest;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = DisputeNav.TAB_DISPUTE, treeMenuItems = {
		DisputeNav.L1_DISPUTE_ACTIVITY,
		DisputeNav.L2_RETRIVAL_REQUEST
		})

public class RetrivalRequestPage extends AbstractDisputePage {

	private static final Logger logger = LoggerFactory
			.getLogger(RetrivalRequestPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchSectionContainer:networkCode:input:dropdowncomponent")
	private MCWebElement interchangeDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=microfilmRefNumber]")
	private MCWebElement microfilmRefNumber;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=cardNumber]")
	private MCWebElement cardNumber;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='microfilmRefNumberReadOnly']/span")
	private MCWebElement readOnlyArnTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='transactionAmount']/span/span")
	private MCWebElement readOnlyTransactionAmount;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='currencyCode']/span/span")
	private MCWebElement readOnlyTransactionCurrency;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='transactionType']/span/span")
	private MCWebElement readOnlyTransactionType;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='requestReasonCode']/span/select")
	private MCWebElement readOnlyRequestReasonCode;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='requestCode']/span/select")
	private MCWebElement readOnlyRequestCode;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='chargeFees']/span/input")
	private MCWebElement readOnlyApplyFee;

	public void searchByArn(String arn) {
		searchByArn(arn, "Search Result");
	}
	
	public boolean validateTransactionAndSubmitRetrivalRequest(RetrievalRequest rr)
	{		
			WebElementUtils.waitForWicket(driver());
			WebElementUtils.selectDropDownByVisibleText(readOnlyRequestReasonCode, rr.getRequestResonCode());
			WebElementUtils.selectDropDownByVisibleText(readOnlyRequestCode, rr.getReasonCode());
			WebElementUtils.checkCheckbox(readOnlyApplyFee, rr.isApplyFee());
			clickSaveButton();
			return true;
	}

	public void verifyUiOperationStatus() {
		logger.info("Retrieval Request");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(interchangeDDwn),
				WebElementUtils.elementToBeClickable(transactionDateDpkr),
				WebElementUtils.elementToBeClickable(microfilmRefNumber),
				WebElementUtils.elementToBeClickable(cardNumber));
	}
}
