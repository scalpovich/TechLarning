package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_OPERATION, CardManagementNav.L2_PROCESSING_BATCHES,
		CardManagementNav.L3_RESEND_PIN_REQUEST })
public class ResendPINRequestPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory
			.getLogger(ResendPINRequestPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=deviceNumber]")
	private MCWebElement deviceNumber;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=batchNumber]")
	private MCWebElement batchNumber;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement productType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement actionCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:3:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement program;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:3:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement deviceType;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=fileName]")
	private MCWebElement fileName;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=fromDate]")
	private MCWebElement fromDate;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=toDate]")
	private MCWebElement toDate;
	

	public void verifyUiOperationStatus() {
		logger.info("Resend PIN Request");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(deviceNumber),
				WebElementUtils.elementToBeClickable(batchNumber),
				WebElementUtils.elementToBeClickable(productType),
				WebElementUtils.elementToBeClickable(actionCode),
				WebElementUtils.elementToBeClickable(deviceNumber),
				WebElementUtils.elementToBeClickable(program),
				WebElementUtils.elementToBeClickable(fileName),
				WebElementUtils.elementToBeClickable(fromDate),
				WebElementUtils.elementToBeClickable(toDate)
				);
	}
}