package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.HolidayConfiguration;
import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_HOLIDAY_CONFIGURATION })
public class HolidayConfigurationPage extends AbstractModelPage {
	private static final Logger logger = LoggerFactory
			.getLogger(HolidayConfigurationPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=description]")
	private MCWebElement descriptionTxt;
	
	@PageElement(findBy = FindBy.CSS,valueToFind  = "#calendarDate")
	private MCWebElement calendarDateDPkr;
	
	@PageElement(findBy = FindBy.X_PATH,valueToFind  = "//span[@id='type']/select")
	private MCWebElement typeDwn;
	
	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addHolidayConfiguration;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "/html/body/div[2]/div/div/form/table[1]/tbody/tr[1]/td[2]/span/span/span/img")
	private MCWebElement CalendarDate;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "/html/body/div[2]/div/div/form/table[1]/tbody/tr[1]/td[2]/span/span/span/span/table/tbody/tr[1]/td[3]/a")
	private MCWebElement selectDate;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:2:cols:colspanMarkup:inputField:input:inputTextField")
	private MCWebElement Description;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:3:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement Type;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;
	public void verifyUiOperationStatus() {
		logger.info("Holiday Master");
		verifyUiOperation("Add Holiday Master");
	}

	public void addHolidayConfiguration(HolidayConfiguration hc)
	{
		logger.info("create holiday configuration on : {}",
				hc.getCalendarDate());
		clickAddNewButton();

		runWithinPopup(
				"Add Holiday Master",
				() -> {
						addHoliday(hc);
						verifyNoErrors();
				});

		verifyOperationStatus();
	}
	
	private void addHoliday(HolidayConfiguration hc) {
		WebElementUtils.pickDate(calendarDateDPkr, hc.getCalendarDate());
		WebElementUtils.enterText(descriptionTxt, hc.getDescription());
		WebElementUtils.selectDropDownByVisibleText(typeDwn, hc.getHolidayType());
		clickSaveButton();
	}
		
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(descriptionTxt));
	}

}
