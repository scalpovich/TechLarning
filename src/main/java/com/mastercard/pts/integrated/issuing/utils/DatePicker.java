package com.mastercard.pts.integrated.issuing.utils;

import java.util.Collection;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.MCWebElements;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class DatePicker extends AbstractBasePage {

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class='yui-skin-sam']//img")
	private MCWebElement dateCalendraIcon;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class='yui-skin-sam']//a[@class='calnav']")
	private MCWebElement calendarMonthYearLink;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class='yui-skin-sam']//div[@class='yui-cal-nav-m']/select")
	private MCWebElement calendarMonthDropDown;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class='yui-skin-sam']//div[@class='yui-cal-nav-y']/input")
	private MCWebElement calendarYearInput;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class='yui-skin-sam']//td[contains(@class,'selectable')]//a")
	private MCWebElements avaiableFromDatesCalendar;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class='yui-skin-sam']//div[@class='yui-cal-nav-b']//button[contains(@id,'submit')]")
	private MCWebElement calendarOkayBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class='yui-skin-sam']//div[@class='yui-cal-nav-b']//button[contains(@id,'cancel')]")
	private MCWebElement calendarCancelBtn;

	public void clickDateCalIcon() {				
		clickWhenClickable(dateCalendraIcon);
	}

	public void clickCalendarMonthYearLink() {
		clickWhenClickable(calendarMonthYearLink);
	}

	public void selectDateRangeMonth(String value) {
		selectValueFromDropDown(calendarMonthDropDown,value);
	}

	public void setDateRangeYear(String value) {
		enterText(calendarYearInput, value);		
	}

	public void setCalendarDay(String value) {
		waitForElementVisible(avaiableFromDatesCalendar);
		List<MCWebElement> elements = avaiableFromDatesCalendar.getElements();
		elements.get(Integer.parseInt(value) - 1).click();
	}

	public void clickCalendarMonthYearOkBtn() {
		clickWhenClickable(calendarOkayBtn);
	}

	public void clickCalendarMonthYearCancelBtn() {
		clickWhenClickable(calendarCancelBtn);
	}

	public void setDate(String providedDateFormat) {
		String[] date = providedDateFormat.split("/");
		String month = date[0];
		String day = date[1];
		String year = date[2];
		clickDateCalIcon();
		clickCalendarMonthYearLink();
		selectDateRangeMonth(month);
		setDateRangeYear(year);
		clickCalendarMonthYearOkBtn();
		setCalendarDay(day);
		//waitForLoaderToDisappear();

	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return null;
	}

}
