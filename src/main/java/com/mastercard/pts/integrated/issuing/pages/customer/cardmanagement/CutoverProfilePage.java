package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CutoverProfile;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;


@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_CUTOVER_PROFILE })
public class CutoverProfilePage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(CutoverProfilePage.class);
	@PageElement(findBy = FindBy.X_PATH,valueToFind = "//a[@class='exportCSV']")
	private MCWebElement exportLink;
	
	@PageElement(findBy =FindBy.CSS, valueToFind="#businessDate")
	private MCWebElement businessDateDPkr;

	@PageElement(findBy = FindBy.X_PATH ,valueToFind= "//span[@id='cutoverHrs']/select")
	private MCWebElement cutoverHrsDwn;
	
	@PageElement(findBy = FindBy.X_PATH,valueToFind = "//span[@id='cutoverMi']/select")
	private MCWebElement cutoverMiDwn;

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

	public void ClickAddcutoverprofile() {
		waitForElementVisible(addCutoverProfile);
		ClickButton(addCutoverProfile);
		addWicketAjaxListeners(getFinder().getWebDriver());
	}

	public void switchToCutoverProfileFrame() {
		switchToIframe(Constants.ADD_CUTOVER_PROFILE_FRAME);
		addWicketAjaxListeners(getFinder().getWebDriver());
	}

	public void selectBusinessDate() {
		waitForElementVisible(BusinessDate);
		BusinessDate.click();
		EffectiveDateNxtMonth.click();
		selectEffectiveDate.click();
	}

	public void selectCutoverHours(DeviceCreation deviceCreation) {
		waitForElementVisible(CutoverHours);
		selectByVisibleText(CutOverHrs, deviceCreation.getCutoverHours());
	}

	public void selectCutoverMinutes(DeviceCreation deviceCreation) {
		waitForElementVisible(CutoverHours);
		selectByVisibleText(CutOverMins, deviceCreation.getCutoverMins());
	}

	public void clickSaveBtn() {
		waitForElementVisible(save);
		ClickButton(save);
		try {
			if (PanelError.isVisible()) {
				logger.info("inside error pannel");
				cancel.click();
			}
		} catch (Exception e) {
			logger.error(e.toString());
			logger.info("error pannel not present");
		}
		SwitchToDefaultFrame();
	}

	// public void addcutoverprofileTryDatePicker() throws InterruptedException
	// {
	// addCutoverProfile.click();
	// waitForElementVisible(addCutoverProfile);
	// getFinder().getWebDriver().switchTo().frame("_wicket_window_3");
	// waitForElementVisible(BusinessDate);
	// BusinessDate.click();
	// waitForElementVisible(selectDate);
	// // wait(1);
	// selectDate.click();
	// waitForElementVisible(CutoverHours);
	// //
	// CutoverHours.sendKeys(env.getProperty("is.dinners.cutoverprofile.hours"));
	// CutoverHours.getSelect().selectByVisibleText(env.getProperty("is.dinners.cutoverprofile.hours"));
	// //
	// CutoverMins.sendKeys(env.getProperty("is.dinners.cutoverprofile.mins"));
	// CutoverMins.getSelect().selectByVisibleText(env.getProperty("is.dinners.cutoverprofile.mins"));
	//
	// save.click();
	// // waitForElementVisible(addCutoverProfile);
	// getFinder().getWebDriver().switchTo().defaultContent();
	// }

	public void verifyUiOperationStatus() {
		logger.info("Cutover Profile");
		verifyUiOperation("Add Cutover Profile");
	}

	public void addCutoverProfile(CutoverProfile cp) {
		logger.info("create CutoverProfile on date : {}",
				cp.getBusinessDate());
		if(isNoRecordsFoundInTable())
		{
			clickAddNewButton();
	
			runWithinPopup(
					"Add Cutover Profile",
					() -> {
						addCutoverProfileRecord(cp);
							verifyNoErrors();
					});
	
			verifyOperationStatus();  
		}
	}

	private void addCutoverProfileRecord(CutoverProfile cp) {
		WebElementUtils.pickDate(businessDateDPkr, cp.getBusinessDate());
		WebElementUtils.selectDropDownByVisibleText(cutoverHrsDwn, cp.getCutoverHours());
		WebElementUtils.selectDropDownByVisibleText(cutoverMiDwn, cp.getCutoverMins());
		clickSaveButton();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(exportLink));
	}

}
