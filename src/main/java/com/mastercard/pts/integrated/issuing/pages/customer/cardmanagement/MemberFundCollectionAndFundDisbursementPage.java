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
		CardManagementNav.L1_ACTIVITY, CardManagementNav.L2_RUPAY,
		CardManagementNav.L3_MEMBER_FUND_COLLECTION_AND_FUND_DISBURSEMENT })
public class MemberFundCollectionAndFundDisbursementPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory
			.getLogger(MemberFundCollectionAndFundDisbursementPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement rupayProduct;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=acquirerReferenceData]")
	private MCWebElement acquirerReferenceData;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement transactionCode;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=primaryAccountNumber]")
	private MCWebElement primaryAccountNumber;
		
	public void verifyUiOperationStatus() {
		logger.info("Member Fund Collection and Fund Disbursement ");
		verifyUiOperation("Add Member Fund Collection and Fund Disbursement ");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(rupayProduct),
				WebElementUtils.elementToBeClickable(acquirerReferenceData),
				WebElementUtils.elementToBeClickable(transactionCode),
				WebElementUtils.elementToBeClickable(primaryAccountNumber)
				);
	}
}