package com.mastercard.pts.integrated.issuing.pages;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;

public class BasePage extends AbstractBasePage {

	final Logger logger = LoggerFactory.getLogger(BasePage.class);

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

	public void fnSwitchToDefaultFrame() {
		getFinder().getWebDriver().switchTo().defaultContent();
		CustomUtils.ThreadDotSleep(2000);
	}

	public void enterDataToField(MCWebElement field, String fieldValue) {
		field.sendKeys(fieldValue);
		CustomUtils.ThreadDotSleep(2000);
	}

	public void fnSelectDropDownValue(MCWebElement element, String value) {
		element.getSelect().selectByVisibleText(value);
		CustomUtils.ThreadDotSleep(3000);
	}

	public void fnClickButton(MCWebElement BtnName) {
		BtnName.click();
		CustomUtils.ThreadDotSleep(3000);
	}

	public void fnClickCheckBox(MCWebElement optionChkBox) {
		optionChkBox.click();
		CustomUtils.ThreadDotSleep(3000);
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}
