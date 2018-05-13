package com.mastercard.pts.integrated.issuing.utils;

import java.lang.reflect.Constructor;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumhq.selenium.fluent.FluentWebElement;

import com.google.common.collect.Iterators;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementFinder.ByNativeXPath;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;

public class WebElementUtils {

	private static final long TIMEOUT = 60;

	private WebElementUtils() {
	}

	public static WebElement asWebElement(MCWebElement element) {
		return element.getFluent().getWebElement();
	}

	public static Boolean isElementEnabled(MCWebElement element) {
		return element.isEnabled();
	}

	public static void enterText(MCWebElement element, String text) {
		element.clearField();
		element.sendKeys(text);
	}

	public static void enterText(MCWebElement element, Number text) {
		enterText(element, String.valueOf(text));
	}

	public static void enterTextIfControlIsEnabled(MCWebElement element, String text) {
		if (element.isEnabled())
			enterText(element, text);
	}

	public static void switchToChildWindowByTitleAndCloseParent(WebDriver driver, String title) {
		String currentWindow = driver.getWindowHandle();
		String targetWindow = new FluentWait<WebDriver>(driver).until((com.google.common.base.Function<WebDriver, String>) wd -> wd.getWindowHandles().stream()
				.filter(handle -> wd.switchTo().window(handle).getTitle().equalsIgnoreCase(title)).findFirst().orElse(null));
		driver.switchTo().window(currentWindow).close();
		driver.switchTo().window(targetWindow);
	}

	public static String getParentWindowHandle(WebDriver driver) {
		return driver.getWindowHandle();
	}

	public static void switchToPopUpWindow(WebDriver driver) {
		String subWindowHandler = null;
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler);
	}

	public static void switchToParentWindowByHandle(WebDriver driver, String parentWindowHandler) {
		driver.switchTo().window(parentWindowHandler);
	}

	public static void switchToIframe(WebDriver driver, MCWebElement element) {
		driver.switchTo().frame(asWebElement(element));
	}

	public static void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public static void selectDropDownByValue(MCWebElement element, String value) {
		retryUntilNoErrors(() -> new Select(asWebElement(element)).selectByValue(value));
	}

	public static void selectDropDownByIndex(MCWebElement element, int value) {
		retryUntilNoErrors(() -> new Select(asWebElement(element)).selectByIndex(value));
	}

	@SuppressWarnings("deprecation")
	public static void selectDropDownByVisibleText(MCWebElement element, String visibleText) {
		retryUntilNoErrors(() -> new Select(asWebElement(element)).selectByVisibleText(visibleText));
		SimulatorUtilities.wait(1000);
		//waitForWicket(TestContext.getDriver());
	}

	public static void selectDDByVisibleText(MCWebElement element, String visibleText) {
		retryUntilNoErrors(() -> new Select(asWebElement(element)).selectByVisibleText(visibleText));
	}

	public static void selectDropDownByOptionalVisibleText(MCWebElement element, String visibleText) {
		if (visibleText != null) {
			selectDropDownByVisibleText(element, visibleText);
		}
	}

	public static void selectListBoxByVisibleText(MCWebElement element, Iterable<String> visibleTexts) {
		retryUntilNoErrors(() -> {
			Select listbox = new Select(asWebElement(element));

			if (Iterators.size(visibleTexts.iterator()) == 0) {
				listbox.deselectAll();
			} else {
				visibleTexts.forEach(listbox::selectByVisibleText);
			}
		});
	}

	public static void selectAllOptionsInListBox(MCWebElement element) {
		retryUntilNoErrors(() -> {
			List<String> options = getOptionsTextFromSelect(element);
			selectListBoxByVisibleText(element, options);
		});
	}

	public static List<String> getOptionsTextFromSelect(MCWebElement element) {
		return asWebElement(element).findElements(By.tagName("option")).stream().map(WebElement::getText).collect(Collectors.toList());
	}

	public void moveToClick(MCWebElement element, WebDriver driver) {
		Actions builder = new Actions(driver);
		Actions seriesOfActions = builder.moveToElement(asWebElement(element)).click();
		seriesOfActions.perform();
	}

	public static void runWithinFrame(WebDriver driver, long timeoutInSec, By frameLocator, Runnable action) {
		WebElement currentFrame = executeJavascript(driver, "return self.frameElement;");

		try {
			switchToDefaultContent(driver);
			new WebDriverWait(driver, timeoutInSec).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
			addWicketAjaxListeners(driver);
			action.run();
		} finally {
			if (currentFrame == null) {
				switchToDefaultContent(driver);
			} else {
				switchToDefaultContent(driver);
				driver.switchTo().frame(currentFrame);
			}
		}
	}

	public static boolean acceptAlert(WebDriver driver) {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			return true;
		} catch (NoAlertPresentException e) {
			throw MiscUtils.propagate(e);
		}
	}

	public static void addWicketAjaxListeners(WebDriver driver) {
		String javascript = "if (typeof tk  == 'undefined') {" + "tk = {activeAjaxCount: 0, ajaxCallsTried: 0, ajaxCallsCompleted: 0};"
				+ "Wicket.Ajax.registerPreCallHandler(function(){tk.activeAjaxCount++;tk.ajaxCallsTried++;});"
				+ "Wicket.Ajax.registerPostCallHandler(function(){tk.activeAjaxCount--;tk.ajaxCallsCompleted++;});}";
		executeJavascript(driver, javascript);
	}

	public static void waitForWicket(WebDriver driver) {
		String javascript = "return typeof tk === 'undefined' || tk.activeAjaxCount == 0;";
		fluentWait(() -> (Boolean) executeJavascript(driver, javascript));
	}

	@SuppressWarnings("unchecked")
	public static <T> T executeJavascript(WebDriver driver, String javascript, Object... args) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		SimulatorUtilities.wait(500);
		return (T) executor.executeScript(javascript, args);
	}

	public static void pickDate(MCWebElement datePicker, LocalDate date) {
		WebElement monthYear = fluentWait(() -> asWebElement(datePicker).findElement(By.cssSelector("a.calnav")));

		asWebElement(datePicker).findElement(By.cssSelector("img")).click();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
		YearMonth currentYearMonth = YearMonth.parse(monthYear.getText(), formatter);

		if (date.getYear() != currentYearMonth.getYear() || date.getMonthValue() != currentYearMonth.getMonthValue()) {
			monthYear.click();

			MCWebElement monthDDwn = datePicker.select();
			selectDropDownByValue(monthDDwn, String.valueOf(date.getMonthValue() - 1));

			MCWebElement yearTxt = findElement(datePicker, By.cssSelector("input.yui-cal-nav-yc"));
			enterText(yearTxt, String.valueOf(date.getYear()));

			asWebElement(datePicker).findElement(By.xpath(".//button[text()='Okay']")).click();
		}

		String cellXPath = String.format(".//td/a[text()='%d']", date.getDayOfMonth());
		retryUntilNoErrors(() -> asWebElement(datePicker).findElement(By.xpath(cellXPath)).click());
	}

	public static <R> R fluentWait(Supplier<R> condition) {
		return new FluentWait<Object>(new Object()).ignoring(WebDriverException.class).withTimeout(TIMEOUT, TimeUnit.SECONDS).until((com.google.common.base.Function<Object, R>) o -> condition.get());
	}

	public static void retryUntilNoErrors(Runnable action) {
		fluentWait(() -> {
			action.run();
			return true;
		});
	}

	public static void retryUntil(Runnable action, Supplier<Boolean> condition) {
		final AtomicBoolean firstRun = new AtomicBoolean(true);
		Supplier<Boolean> waitingAction = () -> {
			if (!firstRun.getAndSet(false) && condition.get()) {
				return true;
			}
			action.run();
			return false;
		};

		fluentWait(waitingAction);
	}

	public static void checkCheckbox(MCWebElement checkbox, boolean value) {
		if (checkbox.isSelected() != value) {
			checkbox.click();
		}
	}

	public static boolean hasClass(MCWebElement element, String cssClass) {
		String[] classes = element.getAttribute("class").split(" ");
		return ArrayUtils.contains(classes, cssClass);
	}

	public static MCWebElement findElement(MCWebElement context, By locator) {
		By loc = locator;
		if (loc instanceof By.ByXPath) {
			String xPath = locator.toString().split(":", 2)[1].trim();
			loc = new ByNativeXPath(xPath);
		}

		FluentWebElement fluent = context.getFluent().element(loc);
		try {
			Class<?> mcElementClass = Thread.currentThread().getContextClassLoader().loadClass("com.mastercard.testing.mtaf.bindings.element.MCWebElementImpl");
			Constructor<?> constructor = mcElementClass.getConstructor(FluentWebElement.class, Actions.class);
			constructor.setAccessible(true);

			return (MCWebElement) constructor.newInstance(fluent, context.getActions());
		} catch (Exception e) {
			throw MiscUtils.propagate(e);
		}
	}

	public static ExpectedCondition<WebElement> elementToBeClickable(MCWebElement element) {
		return ExpectedConditions.elementToBeClickable(asWebElement(element));
	}

	public static ExpectedCondition<WebElement> visibilityOf(MCWebElement element) {
		return ExpectedConditions.visibilityOf(asWebElement(element));
	}

	public static void enableAllCheckBoxesInTable(MCWebElement tableHandle) {
		WebElement table = asWebElement(tableHandle);
		// To locate rows of table.
		List<WebElement> rowstable = table.findElements(By.cssSelector("input[type=checkbox]"));
		for (int i = 0; i < rowstable.size(); i++) {
			if (rowstable.get(i).isEnabled() && !rowstable.get(i).isSelected()) {
				rowstable.get(i).click();
			}
		}
	}

	public static boolean isTextAvailableinTable(MCWebElement tableHandle, String text) {
		WebElement table = asWebElement(tableHandle);
		// To locate rows of table.
		List<WebElement> rowstable = table.findElements(By.tagName("tr"));
		// To calculate no of rows In table.
		int rowscount = rowstable.size();
		// Loop will execute till the last row of table.
		for (int row = 1; row < rowscount; row++) {
			// To locate columns(cells) of that specific row.
			List<WebElement> columnsrow = rowstable.get(row).findElements(By.tagName("td"));
			// To calculate no of columns(cells) In that specific row.
			int columnscount = columnsrow.size();
			// Loop will execute till the last cell of that specific row.
			for (int col = 0; col < columnscount; col++) {
				// To retrieve text from that specific cell.
				if (columnsrow.get(col).getText().equals(text)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void scrollDown(WebDriver driver, int xPixels, int yPixels) {
		String script = "window.scrollBy(" + xPixels + "," + yPixels + ")";
		executeJavascript(driver, script);
	}

	public static void scrollToElement(WebDriver driver, MCWebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void scrollToElement(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

	}

	public static void selectRadioBtn(MCWebElement radioButton) {
		if (!radioButton.isSelected())
			radioButton.click();
	}
}