package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.HashMap;
import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.EventsAndAlerts;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.utils.ReadTestDataFromExcel;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_EVENTS,
		CardManagementNav.L3_EVENTS_AND_ALERTS
		})

public class EventsAndAlertsPage extends AbstractBasePage {
	
	private static final Logger logger = LoggerFactory.getLogger(EventsAndAlertsPage.class);

	@Autowired
	private ReadTestDataFromExcel excelTestData;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement product;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=eventCode]")
	private MCWebElement eventCode;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=eventDescription]")
	private MCWebElement eventDescription;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement eventType;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value='Search']")
	private MCWebElement searchBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "eventCode:input:inputTextField")
	private MCWebElement txtEventID;

	@PageElement(findBy = FindBy.NAME, valueToFind = "eventDescription:input:inputTextField")
	private MCWebElement txtEventName;

	@PageElement(findBy = FindBy.NAME, valueToFind = "eventProduct:input:dropdowncomponent")
	private MCWebElement productDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "emailFlag:checkBoxComponent")
	private MCWebElement chkBxEmailAlert;

	@PageElement(findBy = FindBy.NAME, valueToFind = "smsFlag:checkBoxComponent")
	private MCWebElement chkBxSMSAlert;

	@PageElement(findBy = FindBy.NAME, valueToFind = "letterFlag:checkBoxComponent")
	private MCWebElement chkBxLetterAlert;

	@PageElement(findBy = FindBy.NAME, valueToFind = "emailRecipients:multiChoice")
	private MCWebElement mutliEmailRecipients;

	@PageElement(findBy = FindBy.NAME, valueToFind = "smsRecipients:multiChoice")
	private MCWebElement mutliSMSRecipients;

	@PageElement(findBy = FindBy.NAME, valueToFind = "letterRecipients:multiChoice")
	private MCWebElement mutliLetterRecipients;

	@PageElement(findBy = FindBy.NAME, valueToFind = "communicationLanguage:input:dropdowncomponent")
	private MCWebElement languageDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "emailSubjectData:input:textAreaComponent")
	private MCWebElement txtEmailSubject;

	@PageElement(findBy = FindBy.NAME, valueToFind = "emailBodyData:input:textAreaComponent")
	private MCWebElement txtEmailMessageBody;

	@PageElement(findBy = FindBy.NAME, valueToFind = "smsBodyData:input:textAreaComponent")
	private MCWebElement txtSMSMessageBody;

	@PageElement(findBy = FindBy.NAME, valueToFind = "emailTemplateId:input:inputTextField")
	private MCWebElement txtTemplateID;

	public void searchEventForProductType(EventsAndAlerts eventAlerts) {
		SelectDropDownByText(product, eventAlerts.getProductType());
	}

	public void clickSearchBtn() {
		clickWhenClickable(searchBtn);
	}

	public void enterEventType(String event) {
		enterText(eventType, event);
	}

	public void enterEventDescription(String eventDesc) {
		enterText(eventDescription, eventDesc);
	}

	public void enterEventeventID(String eventID) {
		enterText(eventCode, eventID);
	}

	public void mapTemplates1(HashMap<String, HashMap<String, String>> map) {
		String eventID;
		for (int i = 1; i <= map.size(); i++) {
			excelTestData.iterateDataFromExcelMap(String.valueOf(i));
			eventID = MapUtils.getIterativeDataFromDatamap("Event ID");
			enterEventeventID(eventID);
			clickSearchBtn();
		}
	}	
	public void verifyUiOperationStatus() {
		logger.info("Event");
		verifyUiOperation("Add Event");
	}
	
	public void addEventAndAlerts(EventsAndAlerts eventsAndAlerts) {
		clickAddNewButton();
		runWithinPopup(
				"Edit Event",
				() -> {
			enterEventID(eventsAndAlerts.getEventID());
			enterEventName(eventsAndAlerts.getEventName());
			selectProduct(eventsAndAlerts.getProductType());
					clickAddDetailsButton();
			addDetails(eventsAndAlerts);
					WebElementUtils.scrollDown(driver(), 0, 250);
					clickSaveButton();
				});
		
	}

	public void enterEventID(String eventID) {
		enterText(txtEventID, eventID);
	}

	public void enterEventName(String eventName) {
		enterText(txtEventName, eventName);
	}

	public void selectProduct(String product) {
		selectByVisibleText(productDdwn, product);
	}

	public void checkEmailAlert() {
		if (chkBxEmailAlert.isEnabled())
			ClickCheckBox(chkBxEmailAlert, true);

	}

	public void checkSMSAlert() {
		if (chkBxSMSAlert.isEnabled())
			ClickCheckBox(chkBxSMSAlert, true);

	}

	public void checkLetterAlert() {
		if (chkBxLetterAlert.isEnabled())
			ClickCheckBox(chkBxLetterAlert, true);
	}

	public void selectEmailRecipients(String emailRecipient) {
		selectByVisibleText(mutliEmailRecipients, emailRecipient);
	}

	public void selectSMSRecipients(String SMSRecipient) {
		selectByVisibleText(mutliSMSRecipients, SMSRecipient);
	}

	public void selectLetterRecipients(String letterRecipient) {
		selectByVisibleText(mutliLetterRecipients, letterRecipient);
	}

	public void selectLanguage(String language) {
		selectByVisibleText(languageDdwn, language);
	}

	public void enterEmailSubject(String emailSubject) {
		enterText(txtEmailSubject, emailSubject);
	}

	public void enterEmailMessageBody(String messageBody) {
		enterText(txtEmailMessageBody, messageBody);
	}

	public void enterSMSBody(String sMSBody) {
		enterText(txtSMSMessageBody, sMSBody);
	}

	public void enterTemplateID(String templateID) {
		enterText(txtTemplateID, templateID);
	}

	public void addDetails(EventsAndAlerts eventsAndAlerts) {
		clickAddNewButton();
		runWithinPopup("Add Event Rules",
				() -> {
			enterTemplateID(eventsAndAlerts.getTemplateID());
			selectLanguage(eventsAndAlerts.getLanguage());
			enterEmailSubject(eventsAndAlerts.getEmailSubject());
			enterEmailMessageBody(eventsAndAlerts.getEmailMessageBody());
			enterSMSBody(eventsAndAlerts.getsMSMessageBody());
					clickSaveButton();
				});
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(product),
				WebElementUtils.elementToBeClickable(eventCode),
				WebElementUtils.elementToBeClickable(eventDescription),
				WebElementUtils.elementToBeClickable(eventType)
				);
	}
}