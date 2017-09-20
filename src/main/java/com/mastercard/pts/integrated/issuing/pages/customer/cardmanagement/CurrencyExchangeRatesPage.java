package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CurrencyExchangeRate;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.DatePicker;
import com.mastercard.pts.integrated.issuing.utils.FileCreation;
import com.mastercard.pts.integrated.issuing.utils.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.utils.ReadTestDataFromExcel;
import com.mastercard.pts.integrated.issuing.utils.UploadFile;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

//TODO: Auto-generated Javadoc
/**
 * @author e074127 Page Class for Currency Exchange Rates Screen
 */
@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_CURRENCY_EXCHANGE_RATES
		})
public class CurrencyExchangeRatesPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory
			.getLogger(CurrencyExchangeRatesPage.class);

	@Autowired
	CurrencyExchangeRate currencyExchangeRateDomainPage;

	@Autowired
	DatePicker datePicker;

	@Autowired
	AccountMasterPage accountMasterPage;

	@Autowired
	public UploadFile upload;

	@Autowired
	FileCreation fileCreation;

	KeyValueProvider provider;

	// Search Currency Exchange Rates

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement sourceCurrencySearchDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement destinationCurrencySearchDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement rateOriginSearchDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement programSearchDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:searchButtonPanel:buttonCol:searchButton")
	private MCWebElement searchBtn;

	// Add Currency Exchange Rates
	/** The Add '+' icon for Currency Exchange Rates */
	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addNewCurrencyExRates;

	@PageElement(findBy = FindBy.NAME, valueToFind = "fromCurrencyCode:input:dropdowncomponent")
	private MCWebElement sourceCurrencyDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "toCurrencyCode:input:dropdowncomponent")
	private MCWebElement destinationCurrencyDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "rateOrigin:input:dropdowncomponent")
	private MCWebElement rateOriginDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "buyRate:input:inputAmountField")
	private MCWebElement buyRateTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "midRate:input:inputAmountField")
	private MCWebElement midRateTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "sellRate:input:inputAmountField")
	private MCWebElement sellRateTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "productCode:input:dropdowncomponent")
	private MCWebElement programDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "rateDate:input:dateTimeField:hours")
	private MCWebElement HH24Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "rateDate:input:dateTimeField:minutes")
	private MCWebElement MITxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "toleranceDiscountUnit:input:inputTextField")
	private MCWebElement toleranceLoadUnitTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "toleranceUnitRefund:input:inputTextField")
	private MCWebElement toleranceRefundUnitTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement cancelBtn;

	@Autowired
	ReadTestDataFromExcel dataReader;

	public void addCurrencyExchangeRate() {
		int minutes = 0;
		int hour = 0;
		int offset = 5;
		ClickButton(addNewCurrencyExRates);
		switchToIframe(Constants.ADD_CURRENCY_EXCHANGE_RATE_FRAME);
		waitForElementVisible(sourceCurrencyDdwn);
		selectByVisibleText(sourceCurrencyDdwn,
				currencyExchangeRateDomainPage.getSourceCurrency());
		CustomUtils.ThreadDotSleep(500);
		Select select = new Select(getFinder().getWebDriver().findElement(
				By.name("toCurrencyCode:input:dropdowncomponent")));
		select.selectByVisibleText(currencyExchangeRateDomainPage
				.getDestinationCurrency());
		enterText(buyRateTxt, currencyExchangeRateDomainPage.getBuyRate());
		enterText(sellRateTxt, currencyExchangeRateDomainPage.getSellRate());
		enterText(midRateTxt, currencyExchangeRateDomainPage.getMidRate());

		String rateOrigin = currencyExchangeRateDomainPage.getRateOrigin();
		selectByVisibleText(rateOriginDdwn, rateOrigin);

		if (rateOriginDdwn.getSelect().getFirstSelectedOption().getText()
				.contains("Bank")
				&& currencyExchangeRateDomainPage.getProgram() != null) {
			selectByVisibleText(programDdwn,
					currencyExchangeRateDomainPage.getProgram());
		}

		DateFormat dateFormat = new SimpleDateFormat("MMMMM/dd/yyyy HH:mm:ss");
		Date date = new Date();

		String[] dateArray = dateFormat.format(date).split(" ");
		datePicker.setDate(dateArray[0]);
		String[] timeArray = dateArray[1].split(":");
		minutes = Integer.parseInt(timeArray[1]) + offset;
		hour = Integer.parseInt(timeArray[0]);

		if (minutes >= 60 && hour < 24) {
			if (hour == 23)
				hour = 0;
			else
				hour = hour + 1;
			minutes = minutes - 60;
		}

		enterText(HH24Txt, String.valueOf(hour));
		enterText(MITxt, String.valueOf(minutes));
		MITxt.click();
		ClickButton(saveBtn);

		getFinder().getWebDriver().switchTo().defaultContent();
		CustomUtils.ThreadDotSleep(500);
	}

	public boolean verifyAddedCurrencyExchangeRate() {
		searchCurrencyExchangeRates(
				currencyExchangeRateDomainPage.getSourceCurrency(),
				currencyExchangeRateDomainPage.getDestinationCurrency(),
				currencyExchangeRateDomainPage.getRateOrigin(),
				currencyExchangeRateDomainPage.getProgram());

		return verifyNewlyAddedEntry();
	}

	public boolean verifyCERFileUpload() {
		HashMap<String, HashMap<String, String>> applicationUploadMap;
		int totalCount = 0;
		int trueEntries = 0;
		String filePath = System.getProperty("user.dir")
				+ "/src/main/resources/config/"
				+ System.getProperty("environment") + "/TestData"
				+ "/UploadFile.xlsx";
		applicationUploadMap = dataReader.fnReadEntireTestData(filePath,
				"CERFileUpload", "Records");

		for (int i = 0; i <= applicationUploadMap.size(); i++) {
			if (true == dataReader.iterateUploadDataFromExcelMap("Test Record "
					+ (i + 1))) {
				searchCurrencyExchangeRates(
						FileCreation
								.getUploadFileFromDatamap("Source Currency"),
						FileCreation
								.getUploadFileFromDatamap("Destination Currency"),
						FileCreation.getUploadFileFromDatamap("Rate Origin"),
						FileCreation.getUploadFileFromDatamap("Program"));
				totalCount++;
				if (verifyEntryUpload())
					trueEntries++;
			}

		}
		return totalCount == trueEntries;
	}

	/**
	 * Verify newly added entry. Compares the newly added entry with the data in
	 * the XL file
	 * 
	 * @return true, if successful
	 */
	public boolean verifyNewlyAddedEntry() {
		// read the data from the header and first row and insert into the
		// map
		int count = 0;
		int rowCount = 0;
		List<String> elementsList = new ArrayList<String>();
		List<String> headerElementsList = new ArrayList<String>();
		HashMap<String, String> hashMap = new HashMap<String, String>();
		List<WebElement> elements = getFinder().getWebDriver().findElements(
				By.xpath("//table[@class='dataview']//tbody//tr[1]/td"));

		List<WebElement> headerElements = getFinder()
				.getWebDriver()
				.findElements(By.xpath("//table[@class='dataview']//thead//th"));
		for (WebElement element : headerElements) {
			String elementText = element.getText();
			if ("Edit".equalsIgnoreCase(elementText)
					|| "Delete".equalsIgnoreCase(elementText)) {
				rowCount++;
			} else {
				headerElementsList.add(element.getText());
			}
		}

		for (WebElement w : elements) {
			String elementText = w.getText();
			if (!"".equalsIgnoreCase(elementText))
				elementsList.add(w.getText());
		}

		if (elements.size() == headerElements.size()) {
			for (int i = 0; i < elements.size() - rowCount; i++) {
				if (hashMap.containsKey(headerElementsList.get(i))) {
					hashMap.remove(headerElementsList.get(i));
					hashMap.put(headerElementsList.get(i), elementsList.get(i));
				} else {
					hashMap.put(headerElementsList.get(i), elementsList.get(i));
				}
			}
		} else {
			logger.error("The newly added entry is not saved into the system.");
		}

		// Comparing the elements of the map
		Iterator<String> setItr = hashMap.keySet().iterator();
		while (setItr.hasNext()) {
			String key = setItr.next();
			CustomUtils.ThreadDotSleep(250);
			if (hashMap.get(key).equals(MapUtils.fnGetInputDataFromMap(key))) {
				count++;
			}
		}
		if (count == (hashMap.keySet().size() - 3))
			return true;
		return false;
	}

	public void uploadCurrencyExchangeRateFile(String rateOrigin) {
		if ("bank".equals(rateOrigin)) {
			try {
				fileCreation.createCERUploadFileBank();
			} catch (Exception e) {
				logger.error("There is an error while CER file upload bank", e);
			}
		} else if ("Mastercard".equals(rateOrigin)) {
			try {
				fileCreation.createCERFileMC();
			} catch (Exception e) {
				logger.error(
						"There is an error while CER file upload Mastercard", e);
			}
		}
	}

	public void searchCurrencyExchangeRates(String sCurrency, String dCurrency,
			String rateOrigin, String program) {
		selectByVisibleText(sourceCurrencySearchDdwn, sCurrency);
		CustomUtils.ThreadDotSleep(500);
		Select select = new Select(
				getFinder()
						.getWebDriver()
						.findElement(
								By.name("searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")));
		select.selectByVisibleText(dCurrency);
		selectByVisibleText(rateOriginSearchDdwn, rateOrigin);
		if ("Bank [B]".equals(rateOrigin) && program != null)
			selectByVisibleText(programSearchDdwn, program);
		ClickButton(searchBtn);
	}

	public String getCode(String value) {
		String substring = "";
		if (value.length() > 0)
			substring = value.substring(value.indexOf("[") + 1,
					value.indexOf("]"));
		return substring;
	}

	public boolean verifyEntryUpload() {
		// read the data from the header and first row and insert into the
		// map
		int count = 0;
		int rowCount = 0;
		List<String> elementsList = new ArrayList<String>();
		List<String> headerElementsList = new ArrayList<String>();
		HashMap<String, String> hashMap = new HashMap<String, String>();
		List<WebElement> elements = getFinder().getWebDriver().findElements(
				By.xpath("//table[@class='dataview']//tbody//tr[1]/td"));

		List<WebElement> headerElements = getFinder()
				.getWebDriver()
				.findElements(By.xpath("//table[@class='dataview']//thead//th"));
		for (WebElement element : headerElements) {
			String elementText = element.getText();
			if ("Edit".equalsIgnoreCase(elementText)
					|| "Delete".equalsIgnoreCase(elementText)) {
				rowCount++;
			} else {
				headerElementsList.add(element.getText());
			}
		}

		for (WebElement w : elements) {
			String elementText = w.getText();
			if (!"".equalsIgnoreCase(elementText))
				elementsList.add(w.getText());
		}

		if (elements.size() == headerElements.size()) {
			for (int i = 0; i < elements.size() - rowCount; i++) {
				if (hashMap.containsKey(headerElementsList.get(i))) {
					hashMap.remove(headerElementsList.get(i));
					hashMap.put(headerElementsList.get(i), elementsList.get(i));
				} else {
					hashMap.put(headerElementsList.get(i), elementsList.get(i));
				}
			}
		} else {
			logger.error("The newly added entry is not saved into the system.");
		}

		// Comparing the elements of the map
		Iterator<String> setItr = hashMap.keySet().iterator();
		while (setItr.hasNext()) {
			String key = setItr.next();
			CustomUtils.ThreadDotSleep(250);
			if (hashMap.get(key).equals(
					FileCreation.getUploadFileFromDatamap(key))) {
				count++;
			}
		}
		if (count == (hashMap.keySet().size() - 3))
			return true;
		return false;
	}
	public void verifyUiOperationStatus() {
		logger.info("Currency Exchange Rate");
		verifyUiOperation("Add Currency Exchange Rate");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(sourceCurrency),
				WebElementUtils.elementToBeClickable(destinationCurrency),
				WebElementUtils.elementToBeClickable(rateOrigin)
				);
	}
}
