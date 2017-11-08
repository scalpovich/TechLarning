package com.mastercard.pts.integrated.issuing.pages.customer.dispute;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class AbstractDisputePage extends AbstractBasePage{
	private static final Logger logger = LoggerFactory.getLogger(AbstractDisputePage.class);
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='networkCode']/span/select")
	protected MCWebElement interchangeDwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='microfilmRefNumber']")
	protected MCWebElement arnTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn='reasonCode']")
	protected MCWebElement reasonCodeTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#transactionDate")
	protected MCWebElement transactionDateDpkr;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='cardNumber']")
	protected MCWebElement deviceNumberTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//td/span/a[1]")
	protected MCWebElement firstRecordInDataTable;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	protected MCWebElement interchangeDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchContainer:networkCode:input:dropdowncomponent")
	protected MCWebElement interDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=microfilmRefNumber]")
	protected MCWebElement microfilmRefNumber;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=cardNumber]")
	protected MCWebElement cardNumber;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='microfilmRefNumberReadOnly']/span")
	protected MCWebElement readOnlyArnTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='transactionAmount']/span/span")
	protected MCWebElement readOnlyTransactionAmount;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='currencyCode']/span/span")
	protected MCWebElement readOnlyTransactionCurrency;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='transactionType']/span/span")
	protected MCWebElement readOnlyTransactionType;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='requestReasonCode']/span/select")
	protected MCWebElement readOnlyRequestReasonCode;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='requestCode']/span/select")
	protected MCWebElement readOnlyRequestCode;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='chargeFees']/span/input")
	protected MCWebElement readOnlyApplyFee;

	protected void searchByArn(String arn,String popupTitle)
	{
		WebElementUtils.enterText(arnTxt, arn);
		clickSearchButton();

		runWithinPopup(popupTitle, () -> {
			waitForWicket();
			logger.info("Clicking on row ==> {} ",firstRecordInDataTable.getText());
			firstRecordInDataTable.click();
			verifyOperationStatus();
		});
	}

	private void verifyUiOperationStatus(String logComment) {
		logger.info(logComment);
		verifySearchButton("Search");
	}

	@Override
	public void verifyOperationStatus() {
		verifyUiOperationStatus("Chargeback Cancellation");
	}

	public void verifyOperationStatus(String logComment) {
		verifyUiOperationStatus(logComment);
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(interchangeDwn), WebElementUtils.elementToBeClickable(arnTxt));
	}
}