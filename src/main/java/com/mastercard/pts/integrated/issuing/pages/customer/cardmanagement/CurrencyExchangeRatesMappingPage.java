package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

//TODO: Auto-generated Javadoc
/**
 * @author e074127 Page Class for Currency Exchange Rates Mapping Screen
 */
@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_CURRENCY_EXCHANGE_RATES_MAPPING
		})
public class CurrencyExchangeRatesMappingPage extends AbstractBasePage {
	
	private static final Logger logger = LoggerFactory.getLogger(CurrencyExchangeRatesMappingPage.class);

	@Autowired
	CurrencyExchangeRateMapping currencyExRateDomain;

	// Search Currency Exchange Rates Mapping

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement transactionSource;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement rateOrigin;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:searchButtonPanel:buttonCol:searchButton")
	private MCWebElement searchBtn;

	// Add Currency Exchange Rates
	/** The Add '+' icon for Currency Exchange Rates */
	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addNewCurrencyExRates;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionSource:input:dropdowncomponent")
	private MCWebElement transactionSourceDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "rateOrigin:input:dropdowncomponent")
	private MCWebElement rateOriginDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "productCode:input:dropdowncomponent")
	private MCWebElement programDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionCode:input:dropdowncomponent")
	private MCWebElement transactionTypeDdwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name='rateType:radioComponent' and @value='M']")
	private MCWebElement rateTypeMidChkBox;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name='rateType:radioComponent' and @value='B']")
	private MCWebElement rateTypeBuyChkBox;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name='rateType:radioComponent' and @value='S']")
	private MCWebElement rateTypeSellChkBox;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement cancelBtn;

	private By feedbackInfo = By.xpath("//span[@class='feedbackPanelINFO']");

	private By feedbackError = By.xpath("//span[@class='feedbackPanelERROR']");

	private final String successMessage = "Record Added Successfully.";

	private final String errorMessage = "Information of transaction source already exists.";

	public void addNewCurrencyExRatesMapping() {
		ClickButton(addNewCurrencyExRates);
		switchToIframe(Constants.ADD_CURRENCY_EXCHANGE_RATE_MAPPING_FRAME);
		waitForElementVisible(transactionSourceDdwn);
		selectByVisibleText(transactionSourceDdwn,
				currencyExRateDomain.getTransactionSource());
		selectByVisibleText(rateOriginDdwn,
				currencyExRateDomain.getRateOrigin());
		if (currencyExRateDomain.getRateOrigin().equals("Bank [B]")
				&& MapUtils.fnGetInputDataFromMap("Program") != null) {
			selectByVisibleText(programDdwn, currencyExRateDomain.getProgram());
			selectByVisibleText(transactionTypeDdwn,
					currencyExRateDomain.getTransactionType());
		}

		switch (currencyExRateDomain.getRateType()) {
		case "Buy":
			rateTypeBuyChkBox.click();
			break;
		case "Sell":
			rateTypeSellChkBox.click();
			break;
		case "Mid":
			rateTypeMidChkBox.click();
			break;
		}
		ClickButton(saveBtn);
	}

	public boolean verifyNewAddedCERMapping() {
		return isErrorMessagePresent() || isSuccessMessagePresent();
	}

	public boolean isErrorMessagePresent() {
		boolean isMessageSeen = false;
		try {
			if (getFinder().getWebDriver().findElement(feedbackError)
					.isDisplayed()) {
				isMessageSeen = true;
				logger.info("The added CER Mapping is already present into the system");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isMessageSeen;
	}

	public boolean isSuccessMessagePresent() {
		boolean isMessageSeen = false;
		getFinder().getWebDriver().switchTo().defaultContent();
		CustomUtils.ThreadDotSleep(200);
		try {
			if (getFinder().getWebDriver().findElement(feedbackInfo).getText()
					.equals(successMessage)) {
				isMessageSeen = true;
				logger.info("The CER Mapping is successfully added into the system");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isMessageSeen;
	}

	public void verifyUiOperationStatus() {
		logger.info("Currency Exchange Rates Mapping");
		verifyUiOperation("Add Currency Exchange Rates Mapping");
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(transactionSource),
				WebElementUtils.elementToBeClickable(rateOrigin)
				);
	}
}
