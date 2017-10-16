package com.mastercard.pts.integrated.issuing.pages;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.MPTSBasePage;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class CutoverProfilePage extends MPTSBasePage {

	// ------------- Card Management > Institution Parameter Setup > Cutover
	// Profile [ISSS03]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addCutoverProfile;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/div/form/table[1]/tbody/tr/td[2]/span/span/span/img")
	private MCWebElement BusinessDate;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/div/form/table[1]/tbody/tr/td[2]/span/span/span/span/table/tbody/tr[5]/td[3]/a")
	private MCWebElement selectDate;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:2:rows:2:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement CutoverHours;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:2:rows:2:cols:nextCol:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement CutoverMins;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

	/*
	 * @PageElement(findBy = FindBy.X_PATH, valueToFind =
	 * "//div[2]/div/div/form/table[1]/tbody/tr/td[2]/span/span/span/img")
	 * private MCWebElement EffectiveDate;
	 */

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[contains(text(), 'Next Month (')]")
	private MCWebElement EffectiveDateNxtMonth;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/div/form/table[1]/tbody/tr/td[2]/span/span/span/span/table/tbody/tr[5]/td[5]/a")
	private MCWebElement selectEffectiveDate;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelERROR']")
	private MCWebElement PanelError;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement cancel;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:2:rows:2:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement CutOverHrs;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:2:rows:2:cols:nextCol:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement CutOverMins;

	public void addcutoverprofile() throws InterruptedException {
		addCutoverProfile.click();
		waitForElementVisible(addCutoverProfile);
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_CUTOVER_PROFILE_FRAME);
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(BusinessDate);
		BusinessDate.click();
		EffectiveDateNxtMonth.click();
		selectEffectiveDate.click();
		waitForElementVisible(CutoverHours);
		SelectDropDownByIndex(CutOverHrs, 1);
		SelectDropDownByIndex(CutOverMins, 1);
		ClickButton(save);
		try {
			if (PanelError.isVisible()) {
				System.out.println("inside error pannel");
				cancel.click();
			}
		} catch (Exception e) {
			System.out.println("error pannel not present");
		}
		SwitchToDefaultFrame();
	}

	public void addcutoverprofileTryDatePicker() throws InterruptedException {
		addCutoverProfile.click();
		waitForElementVisible(addCutoverProfile);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");
		waitForElementVisible(BusinessDate);
		BusinessDate.click();
		waitForElementVisible(selectDate);
		// wait(1);
		selectDate.click();
		waitForElementVisible(CutoverHours);
		// CutoverHours.sendKeys(env.getProperty("is.dinners.cutoverprofile.hours"));
		CutoverHours.getSelect().selectByVisibleText(env.getProperty("is.dinners.cutoverprofile.hours"));
		// CutoverMins.sendKeys(env.getProperty("is.dinners.cutoverprofile.mins"));
		CutoverMins.getSelect().selectByVisibleText(env.getProperty("is.dinners.cutoverprofile.mins"));

		save.click();
		// waitForElementVisible(addCutoverProfile);
		getFinder().getWebDriver().switchTo().defaultContent();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}
