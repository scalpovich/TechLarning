package com.mastercard.pts.integrated.issuing.pages;

import java.util.Collection;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

/**
 * @author E070234
 *
 */
@Component
public class InstitutionCurrencyPage extends AbstractBasePage {
	final Logger logger = LoggerFactory
			.getLogger(InstitutionCurrencyPage.class);

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addInstitutionCurrency;

	@PageElement(findBy = FindBy.NAME, valueToFind = "currencyCode:input:dropdowncomponent")
	private MCWebElement currency;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelERROR']")
	private MCWebElement panelError;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement cancel;

	@PageElement(findBy = FindBy.NAME, valueToFind = "currencyCode:input:dropdowncomponent")
	private MCWebElement currencyToSelect;

	@PageElement(findBy = FindBy.NAME, valueToFind = "status:input:dropdowncomponent")
	private MCWebElement status;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "Information with same Load Currency already exists.")
	private MCWebElement panelErrorMsg;

	@PageElement(findBy = FindBy.CLASS, valueToFind = ".//*[@id='id2f']/ul/li/span")
	private MCWebElement panelMsg;

	public void addInstitutionCurrency() {
		addInstitutionCurrency.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");

		currency.getSelect().selectByVisibleText(
				env.getProperty("is.dinners.institutionCurrency.currency"));
		CustomUtils.ThreadDotSleep(1000);
		status.getSelect().selectByVisibleText(
				env.getProperty("is.dinners.institutionCurrency.status"));
		CustomUtils.ThreadDotSleep(1000);

		save.click();
		CustomUtils.ThreadDotSleep(2000);

		try {
			if (panelError.isVisible()) {
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
	 * Implement this method to perform deletion of a specific
	 * "institution load currency "
	 * 
	 * @param currenyname
	 */
	public void deleteLoadInstitutionCurrency(String currenyname) {
		int rowIndex = 1;
		List<WebElement> elements = getFinder().getWebDriver().findElements(
				By.xpath("//*[@id='id1c']/tbody/tr"));
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
	 * Implement this method to perform deletion of all
	 * "institution load currency "
	 * 
	 * @param currenyname
	 */
	public void deleteallLoadInstitutionCurrency() {
		String abc = "//span[.='Delete']/../../../..//tbody//tr[%s]//img";

		List<WebElement> elements = getFinder().getWebDriver().findElements(
				By.xpath("//*[@id='id1c']/tbody/tr"));

		logger.info("No. of Rows in the WebTable: ", elements.size());
		for (int i = elements.size(); i > 0; i--) {
			getFinder()
					.getWebDriver()
					.findElement(By.xpath(abc.replace("%s", String.valueOf(i))))
					.click();

			CustomUtils.ThreadDotSleep(2000);
			Alert alert = getFinder().getWebDriver().switchTo().alert();
			logger.info(alert.getText());
			alert.accept();
			CustomUtils.ThreadDotSleep(2000);
		}
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {

		return null;
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

}
