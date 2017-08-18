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
		CardManagementNav.L1_SEARCH, CardManagementNav.L2_BATCH_JOB_HISTORY})

public class BatchJobHistoryPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory
			.getLogger(BatchJobHistoryPage.class);


	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement batchTypeDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement batchDDwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=fromJobStartDttm]")
	private MCWebElement fromJobStartDttmDPkr;	
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=toJobStartDttm]")
	private MCWebElement toJobStartDttmDPkr;	
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=jobId]")
	private MCWebElement jobIdTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:3:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement statusDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:4:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement executionModeDDwn;
	
	public void verifyUiOperationStatus() {
		logger.info("Batch Job History");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(batchTypeDDwn),
				WebElementUtils.elementToBeClickable(batchDDwn),
				WebElementUtils.elementToBeClickable(fromJobStartDttmDPkr),
				WebElementUtils.elementToBeClickable(toJobStartDttmDPkr),
				WebElementUtils.elementToBeClickable(jobIdTxt),
				WebElementUtils.elementToBeClickable(statusDDwn),
				WebElementUtils.elementToBeClickable(executionModeDDwn)
				);
	}
}