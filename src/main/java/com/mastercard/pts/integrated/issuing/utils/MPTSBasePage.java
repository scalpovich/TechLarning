package com.mastercard.pts.integrated.issuing.utils;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;

public class MPTSBasePage extends AbstractBasePage {

	private static final long TIMEOUT = 0;
	final Logger logger = LoggerFactory.getLogger(MPTSBasePage.class);

	public void fnSwitchFrame(String strFrame) {

		WebDriverWait wait = new WebDriverWait(getFinder().getWebDriver(), 60);
		try {

			wait.until(ExpectedConditions
					.frameToBeAvailableAndSwitchToIt(strFrame));
			CustomUtils.ThreadDotSleep(2000);

		} catch (Exception ex) {
			logger.info("Unable to switch to frame :" + strFrame);
			throw ex;
			// Assert.fail(ex.getMessage());
		} finally {
			wait = null;
		}

	}

	public void switchToIframe(String caption) {
		WebDriverWait wait = new WebDriverWait(getFinder().getWebDriver(), 60);
		By frameSelector = By
				.xpath(String
						.format("//h3[contains(text(), '%s')]/ancestor::div//iframe[@class='wicket_modal']",
								caption));

		wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(frameSelector));
		// getFinder().getWebDriver().switchTo().frame(getFinder().getWebDriver().findElement(frameSelector));

	}

	public static void addWicketAjaxListeners(WebDriver driver) {
		String javascript = "if (typeof tk  == 'undefined') {"
				+ "tk = {activeAjaxCount: 0, ajaxCallsTried: 0, ajaxCallsCompleted: 0};"
				+ "Wicket.Ajax.registerPreCallHandler(function(){tk.activeAjaxCount++;tk.ajaxCallsTried++;});"
				+ "Wicket.Ajax.registerPostCallHandler(function(){tk.activeAjaxCount--;tk.ajaxCallsCompleted++;});}";
		executeJavascript(driver, javascript);
	}

	public static void waitForWicket(WebDriver driver) {
		String javascript = "return typeof tk === 'undefined' || tk.activeAjaxCount == 0;";
		fluentWait(() -> (Boolean) executeJavascript(driver, javascript));
	}

	@SuppressWarnings("unchecked")
	public static <T> T executeJavascript(WebDriver driver, String javascript,
			Object... args) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		return (T) executor.executeScript(javascript, args);
	}

	public static <R> R fluentWait(Supplier<R> condition) {
		return new FluentWait<Object>(new Object())
				.ignoring(WebDriverException.class)
				.withTimeout(TIMEOUT, TimeUnit.SECONDS)
				.until((com.google.common.base.Function<Object, R>) o -> condition
						.get());
	}

	public static void retryUntilNoErrors(Runnable action) {
		fluentWait(() -> {
			action.run();
			return true;
		});
	}

	public void SwitchToDefaultFrame() {
		getFinder().getWebDriver().switchTo().defaultContent();
	}

	public void enterText(MCWebElement field, String fieldValue) {
		field.sendKeys(fieldValue);
		// addWicketAjaxListeners(getFinder().getWebDriver());
		// CustomUtils.ThreadDotSleep(2000);
	}

	public void SelectDropDownByText(MCWebElement element, String value) {
		element.getSelect().selectByVisibleText(value);
		// addWicketAjaxListeners(getFinder().getWebDriver());
	}

	public void SelectDropDownByIndex(MCWebElement element, int value) {
		element.getSelect().selectByIndex(value);
		// addWicketAjaxListeners(getFinder().getWebDriver());
	}

	public void ClickButton(MCWebElement BtnName) {
		BtnName.click();
		// addWicketAjaxListeners(getFinder().getWebDriver());
	}

	public void ClickCheckBox(MCWebElement optionChkBox, boolean value) {
		if (optionChkBox.isSelected() != value) {
			optionChkBox.click();
			addWicketAjaxListeners(getFinder().getWebDriver());
		}
	}

	public List<WebElement> getAllOptionsOfDropdown(MCWebElement element) {
		List<WebElement> dropDownOptions = element.getSelect().getOptions();
		return dropDownOptions;
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}
