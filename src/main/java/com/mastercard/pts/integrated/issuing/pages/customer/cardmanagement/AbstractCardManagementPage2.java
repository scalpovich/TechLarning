package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Collection;
import java.util.Collections;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

public class AbstractCardManagementPage2 extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(UnsettledTransactionPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=microfilmRefNumber]")
	protected MCWebElement microfilmRefNumberTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=cardNumber]")
	protected MCWebElement cardNumberTxt	;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	protected MCWebElement branchDDwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=sequenceNumber]")
	protected MCWebElement sequenceNumberTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	protected MCWebElement recordType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:1:componentPanel:input:dropdowncomponent")
	protected MCWebElement fraudType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:3:componentList:0:componentPanel:input:dropdowncomponent")
	protected MCWebElement subFraudType;
	
	private void verifyOperationStatus(String logComment)
	{
		logger.info(logComment);
		verifySearchButton("Search");
	}
	
	public void verifyUiOperationStatus() {
		verifyOperationStatus("Unsettled Transaction");
	}
	
	public void verifyUiOperationStatus(String logComment) {
		verifyOperationStatus(logComment);
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Collections.emptyList();
	}

}