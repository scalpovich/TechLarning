package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.EventsAndAlerts;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.utils.ReadTestDataFromExcel;
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
