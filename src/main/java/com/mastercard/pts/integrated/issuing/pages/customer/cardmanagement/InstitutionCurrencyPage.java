package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.InstitutionCurrency;
import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

/**
 * @author E070234
 *
 */
@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_INSTITUTION_CURRENCY })
public class InstitutionCurrencyPage extends AbstractModelPage {
	
	private static final Logger logger = LoggerFactory
			.getLogger(InstitutionCurrencyPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=currencyCodeAlpha]")
	private MCWebElement currencyCodeAlpha;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=description]")
	private MCWebElement description;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "currencyCode:input:dropdowncomponent")
	private MCWebElement currency;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement cancel;

	@PageElement(findBy = FindBy.NAME, valueToFind = "currencyCode:input:dropdowncomponent")
	private MCWebElement currencyToSelect;

	@PageElement(findBy = FindBy.NAME, valueToFind = "status:input:dropdowncomponent")
	private MCWebElement status;
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement status;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='currencyCode']/span/select")
	private MCWebElement currencyCodePopupDwn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind  = "//td[@id='status']/span/select")
	private MCWebElement statusPopupDwn;


	@PageElement(findBy = FindBy.X_PATH, valueToFind = "Information with same Load Currency already exists.")
	private MCWebElement panelErrorMsg;

	@PageElement(findBy = FindBy.CLASS, valueToFind = ".//*[@id='id2f']/ul/li/span")
	private MCWebElement panelMsg;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelERROR']")
	private MCWebElement PanelError;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelINFO']")
	private MCWebElement PanelInfo;

	public void clickAddInstitutionCurrency() {
		waitForElementVisible(addInstitutionCurrency);
		CustomUtils.ThreadDotSleep(2000);
		addInstitutionCurrency.click();
		// WebElement addButton =
		// getFinder().getWebDriver().findElement(By.xpath("//.[@class =
		// 'addR']"));
		waitForElementInVisible("//.[@class = 'addR']");
	}

	public void switchToInstitutionCurrencyFrame() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		CustomUtils.ThreadDotSleep(10000);
		switchToIframe(Constants.ADD_INSTITUTION_CURRENCY_FRAME);
	}

	public void selectInstitutionCurrency() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectByVisibleText(currency, InstitutionCurrencyDataProvider().getSettlementCurrency());
	}

	public void selectStatus() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectByVisibleText(status, getStatus());
	}

	public void clickSaveButton() {
		waitForElementVisible(save);
		ClickButton(save);
		try {
			if (PanelInfo.isVisible()) {
				Assert.assertEquals(PanelInfo.getText(), Constants.Record_Added_Successfully);
			}
		} catch (Exception e) {
			logger.error(e.toString());
			try {
				if (PanelError.isVisible()) {
					logger.info("inside error pannel");
					cancel.click();
				}
			} catch (Exception e1) {
				logger.error(e1.toString());
				logger.info("error pannel not present");
			}
		}
		SwitchToDefaultFrame();
	}

	public void addInstitutionCurrency() {
		addInstitutionCurrency.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");

		currency.getSelect().selectByVisibleText(env.getProperty("is.dinners.institutionCurrency.currency"));
		CustomUtils.ThreadDotSleep(1000);
		status.getSelect().selectByVisibleText(env.getProperty("is.dinners.institutionCurrency.status"));
		CustomUtils.ThreadDotSleep(1000);

		save.click();
		CustomUtils.ThreadDotSleep(2000);

		try {
			if (PanelError.isVisible()) {
				logger.info("inside error pannel");
				cancel.click();
			}
		} catch (Exception e) {
			logger.info("error pannel not present", e);
		}

		getFinder().getWebDriver().switchTo().defaultContent();
	}

	/**
	 * Implement this method to perform addition of "institution load currency "
	 * 
	 * @param currency
	 */
	public void addLoadInstitutionCurrency(String currency) {
		CustomUtils.ThreadDotSleep(2000);
		addInstitutionCurrency.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");
		currencyToSelect.getSelect().selectByVisibleText(currency);
		CustomUtils.ThreadDotSleep(2000);
		save.click();
		CustomUtils.ThreadDotSleep(2000);
		checkPanelErrorMsg();
	}

	/**
	 * Implement this method to perform deletion of a specific "institution load
	 * currency "
	 * 
	 * @param currenyname
	 */
	public void deleteLoadInstitutionCurrency(String currenyname) {
		int rowIndex = 1;
		List<WebElement> elements = getFinder().getWebDriver().findElements(By.xpath("//*[@id='id1c']/tbody/tr"));
		logger.info("No. of Rows in the WebTable: ", elements.size());
		for (WebElement rowElement : elements) {
			if (rowElement.getText().contains(currenyname)) {

				rowElement.findElement(By.xpath(".//td[4]/span")).click();
				CustomUtils.ThreadDotSleep(2000);
				logger.info("Record found");
				break;
			} else if (rowIndex == elements.size()) {
				logger.info("Currency Not listed in application");
			}

			logger.info("Record Not found in iteration ", rowIndex);
			rowIndex++;

		}
		CustomUtils.ThreadDotSleep(2000);
		Alert alert = getFinder().getWebDriver().switchTo().alert();
		logger.info(alert.getText());
		alert.accept();

	}

	/**
	 * Implement this method to perform deletion of all "institution load
	 * currency "
	 * 
	 * @param currenyname
	 */
	public void deleteallLoadInstitutionCurrency() {
		String abc = "//span[.='Delete']/../../../..//tbody//tr[%s]//img";

		List<WebElement> elements = getFinder().getWebDriver().findElements(By.xpath("//*[@id='id1c']/tbody/tr"));

		logger.info("No. of Rows in the WebTable: ", elements.size());
		for (int i = elements.size(); i > 0; i--) {
			getFinder().getWebDriver().findElement(By.xpath(abc.replace("%s", String.valueOf(i)))).click();

			CustomUtils.ThreadDotSleep(2000);
			Alert alert = getFinder().getWebDriver().switchTo().alert();
			logger.info(alert.getText());
			alert.accept();
			CustomUtils.ThreadDotSleep(2000);
		}
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(currencyCodeAlpha),
				WebElementUtils.elementToBeClickable(description),
				WebElementUtils.elementToBeClickable(status)
				);
	}

	/**
	 * Common method to handle window pop for load currency
	 */
	public void checkPanelErrorMsg() {
		try {
			if (panelErrorMsg.isVisible()) {
				logger.info("Errro - Information with same Load Currency already exist");
				cancel.click();

			} else if (panelMsg.isVisible()) {

				logger.info("Currency Succesfully added");
			}

		} catch (Exception e) {
			logger.debug("Error pannel not present", e);
		}
	}
	public void verifyUiOperationStatus() {
		logger.info("Institution Currency");
		verifyUiOperation("Add Institution Currency");
	}

	public void addInstitutionCurrency(InstitutionCurrency currency)
	{
		logger.info("create currency : {}",
				currency.getCurrency());

		performSearchOperationOnMainScreen();
		if(isNoRecordsFoundInTable())
		{
			clickAddNewButton();
	
			runWithinPopup(
					"Add Institution Currency",
					() -> {
							addInstituteCurrency(currency);
							verifyNoErrors();
					});
	
			verifyOperationStatus();
		}
	}
	
	private void addInstituteCurrency(InstitutionCurrency currency) {
		WebElementUtils.selectDropDownByVisibleText(currencyCodePopupDwn,currency.getCurrency());
		WebElementUtils.selectDropDownByVisibleText(statusPopupDwn,currency.getStatus());
		clickSaveButton();
	}	
	
	private void performSearchOperationOnMainScreen()
	{
		WebElementUtils.enterText(currencyCodeAlpha, "INR");
		clickSearchButton();
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(currencyCodeAlpha),
				WebElementUtils.elementToBeClickable(description),
				WebElementUtils.elementToBeClickable(status)
				);
	}
}
