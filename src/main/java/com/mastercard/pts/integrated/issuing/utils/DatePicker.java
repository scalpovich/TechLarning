package com.mastercard.pts.integrated.issuing.utils;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
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

	public String dateCalIcon = "//span[@class='yui-skin-sam']//img";
	public String calMonthYearLink = "//span[@class='yui-skin-sam']//a[@class='calnav']";
	public String availableDatesFromCalendar2 = "//span[@class='yui-skin-sam']//td[contains(@class,'selectable')]//a";
	private String calNavCss = "a.calnav";

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class='yui-skin-sam']//img")
	private static MCWebElement dateCalendraIcon;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class='yui-skin-sam']//a[@class='calnav']")
	private static MCWebElement calendarMonthYearLink;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class='yui-skin-sam']//div[@class='yui-cal-nav-m']/select")
	private static MCWebElement calendarMonthDropDown;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class='yui-skin-sam']//div[@class='yui-cal-nav-y']/input")
	private MCWebElement calendarYearInput;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class='yui-skin-sam']//td[contains(@class,'selectable')]//a")
	private MCWebElements avaiableFromDatesCalendar;
	
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@id='ui-datepicker-div']//td/a")
	private MCWebElements avaiableFromDatesCalendar1;
	

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class='yui-skin-sam']//div[@class='yui-cal-nav-b']//button[contains(@id,'submit')]")
	private static MCWebElement calendarOkayBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class='yui-skin-sam']//div[@class='yui-cal-nav-b']//button[contains(@id,'cancel')]")
	private MCWebElement calendarCancelBtn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//input[@name='toDate']/../button")
	private MCWebElement transactionToDate;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//input[@name='fromDate']/../button")
	private MCWebElement transactionFromDate;
	
	@PageElement(findBy =  FindBy.X_PATH, valueToFind ="//input[@id='fromDate']")
	private MCWebElement fromDateInpt;
	
	@PageElement(findBy =  FindBy.X_PATH, valueToFind ="//input[@id='toDate']")
	private MCWebElement toDateInpt;
	
		
	public void openToDate(){
		transactionToDate.click();		
	}
	
	public void openFromDate(){
		transactionFromDate.click();
	}
	
	public void clickDateCal2Icon(String ele) {
		clickWhenWebElementClickable(Element(ele + dateCalIcon));
	}

	public void clickDateCalIcon() {
		clickWhenClickable(dateCalendraIcon);
	}

	public void clickCalendar2MonthYearLink(String ele) {
		clickWhenWebElementClickable(Element(ele + calMonthYearLink));
	}

	public void clickCalendarMonthYearLink() {
		clickWhenClickable(calendarMonthYearLink);
	}

	public void selectDateRangeMonth(String value) {
		selectValueFromDropDown(calendarMonthDropDown, value);
	}

	public void setDateRangeYear(String value) {
		enterText(calendarYearInput, value);
	}

	public void setCalendarDay(String value) {
		int value1 = 0;
		waitForElementVisible(avaiableFromDatesCalendar);
		List<MCWebElement> elements = avaiableFromDatesCalendar.getElements();
		if (value != "31") {
			value1 = Integer.parseInt(value) + 1;
		}
		elements.get(value1 - 1).click();
	}

	public void setCalendarDay2(String ele, String value) {
		waitForElementVisible(getFinder().getWebDriver().findElement(By.xpath(ele + availableDatesFromCalendar2)));
		List<WebElement> elements = getFinder().getWebDriver()
				.findElements(By.xpath(ele + availableDatesFromCalendar2));
		// avaiableFromDatesCalendar.getElements();
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
		CustomUtils.ThreadDotSleep(8000);
		clickDateCalIcon();
		clickCalendarMonthYearLink();
		selectDateRangeMonth(month);
		setDateRangeYear(year);
		clickCalendarMonthYearOkBtn();
		setCalendarDay(day);
		// waitForLoaderToDisappear();

	}

	public void setDateCalendar2(String providedDateFormat, String Calelement) {
		waitForLoaderToDisappear();
		String[] date = providedDateFormat.split("/");
		String month = date[0];
		String day = date[1];
		String year = date[2];
		CustomUtils.ThreadDotSleep(8000);
		clickDateCal2Icon(Calelement);
		clickCalendar2MonthYearLink(Calelement);
		selectDateRangeMonth(month);
		setDateRangeYear(year);
		clickCalendarMonthYearOkBtn();
		setCalendarDay2(Calelement, day);
	}
	
	public void setToDate(String toDate){
		toDateInpt.sendKeys(toDate);
	}
	
	public void setFromDate(String fromDate){
		fromDateInpt.sendKeys(fromDate);
	}
	
	public void clickDateCalIcon(String baseXpath) {
		fluentWait(() -> Element(baseXpath).findElement(By.cssSelector(calNavCss)));
		Element(baseXpath).findElement(By.cssSelector("img")).click();
	}
	
	public void clickCalendarMonthYearLink(String baseXpath) {
		fluentWait(() -> Element(baseXpath).findElement(By.cssSelector(calNavCss)));
		Element(baseXpath).findElement(By.cssSelector(calNavCss)).click();
	}
	
	public void setCalendarDay(String value, String baseXpath) {
		String cellXPath = String.format(".//td/a[text()='%d']", Integer.valueOf(value));
		retryUntilNoErrors(() -> Element(baseXpath).findElement(By.xpath(cellXPath)).click());
	}
	
	public void setDate(String providedDateFormat, String baseXpath) {
		String[] date = providedDateFormat.split("/");
		String month = date[0];
		String day = date[1];
		String year = date[2];
		clickDateCalIcon(baseXpath);
		clickCalendarMonthYearLink(baseXpath);
		selectDateRangeMonth(month);
		setDateRangeYear(year);
		clickCalendarMonthYearOkBtn();
		setCalendarDay(day, baseXpath);
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return null;
	}

}
