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
		CardManagementNav.L1_SEARCH, CardManagementNav.L2_EVENT_ALERT_HISTORY})
public class EventAlertHistoryPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory
			.getLogger(EventAlertHistoryPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=jobId]")
	private MCWebElement jobId;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=evtJobId]")
	private MCWebElement evtJobId;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=batchJobId]")
	private MCWebElement batchJobId;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement alertType;
	
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:3:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement eventId;
	
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:3:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement processingMode;
	
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:4:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement alertStatus;
	
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:4:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement executionMode;
	
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:5:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement channel;
	

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=loggedFromDate]")
	private MCWebElement loggedFromDate;	
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=loggedToDate]")
	private MCWebElement loggedToDate;	
	
	public void verifyUiOperationStatus() {
		logger.info("Event/Alert History");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(jobId),
				WebElementUtils.elementToBeClickable(evtJobId),
				WebElementUtils.elementToBeClickable(batchJobId),
				WebElementUtils.elementToBeClickable(alertType),
				WebElementUtils.elementToBeClickable(eventId),
				WebElementUtils.elementToBeClickable(processingMode),
				WebElementUtils.elementToBeClickable(alertStatus),
				WebElementUtils.elementToBeClickable(executionMode),
				WebElementUtils.elementToBeClickable(channel),
				WebElementUtils.elementToBeClickable(loggedFromDate),
				WebElementUtils.elementToBeClickable(loggedToDate)
				);
	}
}