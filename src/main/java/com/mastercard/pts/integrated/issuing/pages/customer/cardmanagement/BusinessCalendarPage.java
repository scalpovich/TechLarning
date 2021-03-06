package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BusinessCalendar;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_BUSINESS_CALENDAR })
public class BusinessCalendarPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(BusinessCalendarPage.class);

	public static final String ADD_BUSINESS_CALENDAR = "Add Business Calendar";

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[@class='exportCSV']")
	private MCWebElement exportLink;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#effectiveDate")
	private MCWebElement effectiveDateDPkr;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='skipHoliday']")
	private MCWebElement skipHoliday;

	public void verifyUiOperationStatus() {
		logger.info("Business Calendar");
		verifyUiOperation(ADD_BUSINESS_CALENDAR);
	}

	public void addBusinessCalendar(BusinessCalendar bc) {
		logger.info("create Business calendar on effective date : {}", bc.getEffectiveDate());
		if (isNoRecordsFoundInTable()) {
			clickAddNewButton();

			runWithinPopup(ADD_BUSINESS_CALENDAR, () -> {
				addCalenderDate(bc);
				verifyNoErrors();
			});
			verifyOperationStatus();
		}
	}

	public void addBusinessCalendarFutureDate(BusinessCalendar bc) {
		logger.info("create Business calendar on future date : {}", bc.getFutureDate());
		clickAddNewButton();
		runWithinPopup(ADD_BUSINESS_CALENDAR, () -> {
			addFutureCalenderDate(bc);
			verifyDuplicateAndClickCancel();
		});
	}

	private void addCalenderDate(BusinessCalendar bc) {
		WebElementUtils.pickDate(effectiveDateDPkr, bc.getEffectiveDate());
		WebElementUtils.checkCheckbox(skipHoliday, bc.isSkipHoliday());
		clickSaveButton();
	}

	private void addFutureCalenderDate(BusinessCalendar bc) {
		WebElementUtils.pickDate(effectiveDateDPkr, bc.getFutureDate());
		clickSaveButton();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(exportLink));
	}
}
