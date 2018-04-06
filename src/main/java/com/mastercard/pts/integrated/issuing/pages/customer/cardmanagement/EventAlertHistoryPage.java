package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.EventsAndAlerts;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

import junit.framework.Assert;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_SEARCH,
		CardManagementNav.L2_EVENT_ALERT_HISTORY })
public class EventAlertHistoryPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(EventAlertHistoryPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=jobId]")
	private MCWebElement jobId;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=evtJobId]")
	private MCWebElement evtJobId;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=batchJobId]")
	private MCWebElement batchJobId;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement alertType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:3:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement eventIdDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:3:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement processingMode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:4:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement alertStatus;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:4:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement executionMode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:5:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement channelDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[contains(text(),'From Date')]/following-sibling::td[@class='field']")
	private MCWebElement loggedFromDateDPkr;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[contains(text(),'To Date')]/following-sibling::td[@class='field']")
	private MCWebElement loggedToDateDPkr;

	public void verifyUiOperationStatus() {
		logger.info("Event/Alert History");
		verifySearchButton("Search");
	}

	public void fillEventAlertHistoryPage() {
		WebElementUtils.selectDropDownByVisibleText(channelDDwn, "Customer Portal [WBO]");
		WebElementUtils.selectDropDownByVisibleText(eventIdDDwn, "Device Sale [APPL0P0005]");
		WebElementUtils.pickDate(loggedFromDateDPkr, LocalDate.now());
		WebElementUtils.pickDate(loggedToDateDPkr, LocalDate.now());
		searchButtonElement.click();
	}

	public String verifyEvent() {
		logger.info("Event & Alert Verification for Event Trigger");
		return getDate();
	}

	public void getEventsAlertsJobId() {

	}

	public void checkEventGeneratedForSMSEmail(String eventAlertJobId, EventsAndAlerts eventsAndalerts) {
		selectByVisibleText(eventIdDDwn, eventsAndalerts.getEventID());
		WebElementUtils.pickDate(loggedFromDateDPkr, LocalDate.now());
		WebElementUtils.pickDate(loggedToDateDPkr, LocalDate.now());
		WebElementUtils.enterText(jobId, eventAlertJobId);
		searchButtonElement.click();
		try {
			WebElement SelectJob = getFinder().getWebDriver()
					.findElement(By.xpath("//td[contains(.,'" + eventAlertJobId + "')]"));
			if (SelectJob.isDisplayed()) {
				logger.info("Event triggered");
			}
		} catch (Exception e) {
			Assert.fail("event not triggered");
		}
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(jobId),
				WebElementUtils.elementToBeClickable(evtJobId), WebElementUtils.elementToBeClickable(batchJobId),
				WebElementUtils.elementToBeClickable(alertType), WebElementUtils.elementToBeClickable(eventIdDDwn),
				WebElementUtils.elementToBeClickable(processingMode), WebElementUtils.elementToBeClickable(alertStatus),
				WebElementUtils.elementToBeClickable(executionMode), WebElementUtils.elementToBeClickable(channelDDwn),
				WebElementUtils.elementToBeClickable(loggedFromDateDPkr),
				WebElementUtils.elementToBeClickable(loggedToDateDPkr));
	}
}