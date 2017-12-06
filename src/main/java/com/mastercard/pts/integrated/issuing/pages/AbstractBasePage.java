package com.mastercard.pts.integrated.issuing.pages;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.CustomMCWebElement;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementFinderProvider;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.MCWebElements;
import com.mastercard.testing.mtaf.bindings.page.AbstractPage;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

public abstract class AbstractBasePage extends AbstractPage {
	final static int ELEMENT_WAIT_MAX = 6000;

	private static final long TIMEOUT = 100;
	public Set<String> errorFields = new HashSet<String>();

	public String pageValidationCheck = "//ol/li";
	public String ERRORPANEL = "//li[@class='feedbackPanelERROR']";
	private static final By INFO_MESSAGE_LOCATOR = By
			.cssSelector(":not([style]) > .feedbackPanel span.feedbackPanelINFO");

	private static final String FIRST_ROW_SELECT = ".dataview tbody span";

	private static final String SUCCESS_MESSAGE = "Success message: {}";

	public static final String ERROR_MESSAGE = "Error: {}";

	public static final String RESPONSE_MESSAGE = "Response message: {}";

	public static final String CONTACT_INFORMATION_EXPECTED = "Contact Information";

	public static final String ACTUAL_RESULT_LABEL = " | Actual Result : ";

	private static final Logger logger = LoggerFactory.getLogger(AbstractBasePage.class);

	public static final LocalDate futureDate = LocalDate.now().plusDays(100);

	@Value("${default.wait.timeout_in_sec}")
	private long timeoutInSec;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@class='credentials']//label")
	private MCWebElement userNameLocator;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Search']")
	private MCWebElement searhBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Close']")
	private MCWebElement closeBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[@class='w_close']")
	private MCWebElement closePopUpBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "a.addR")
	private MCWebElement addNewBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Save']")
	private MCWebElement saveBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Add Details']")
	private MCWebElement addDetailsBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Cancel']")
	private MCWebElement cancelBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Process Selected']")
	private MCWebElement processSelectedBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = ".dataview tbody a span")
	private MCWebElement firstRowViewLink;

	@PageElement(findBy = FindBy.CSS, valueToFind = ".dataview tbody img[alt='Edit Record']")
	private MCWebElement firstRowEditLink;

	@PageElement(findBy = FindBy.CSS, valueToFind = ".dataview tbody img[alt='Delete Record']")
	private MCWebElement firstRowDeleteLink;

	@PageElement(findBy = FindBy.CSS, valueToFind = ".dataview tbody input[type='checkbox']")
	private MCWebElement firstRowSelectLink;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Next >']")
	private MCWebElement nextBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Finish']")
	private MCWebElement finishBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div/h3")
	private MCWebElement popupNameElement;

	@PageElement(findBy = FindBy.CSS, valueToFind = "span[class=btn_or_span]")
	protected MCWebElement searchButtonElement;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//h1")
	private MCWebElement heading;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//p")
	private MCWebElement paragraph;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[.//*[text()='Status :']]/following-sibling::td[1]")
	private MCWebElement batchStatus;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value='Create']")
	private MCWebElement createBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[contains(text(), 'Wallet Number')]/following-sibling::td[1]")
	private MCWebElement walletNumber;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[contains(text(), 'Device Number')]/following-sibling::td[1]")
	private MCWebElement deviceNumber;

	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value=Submit]")
	private MCWebElement submitButton;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value=Cancel]")
	private MCWebElement cancelButton;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value=Continue]")
	private MCWebElement continueButton;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[type='reset']")
	private MCWebElement okButton;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[contains(text(),'Contact Information')]")
	private MCWebElement contactInformation;

	@Autowired
	void initMCElements(ElementFinderProvider finderProvider) {
		MCAnnotationProcessor.initializeSuper(this, finderProvider);
	}

	protected void clickOkButton() {
		clickWhenClickable(okButton);
	}

	protected void clickFinishButton() {
		clickWhenClickable(finishBtn);
	}

	protected void clickProcessSelectedButton() {
		clickWhenClickable(processSelectedBtn);
	}

	protected void clickNextButton() {
		WebElementUtils.scrollDown(driver(), 0, 250);
		clickWhenClickable(nextBtn);
		WebElementUtils.addWicketAjaxListeners(driver());
	}

	protected void clickAddNewButton() {
		clickWhenClickable(addNewBtn);
	}

	// used when there are more than 1 add buttons
	protected void clickAddButtonVariant(MCWebElement element) {
		WebElementUtils.scrollDown(driver(), 0, 250);
		clickWhenClickable(element);
	}

	protected void clickCreateButton() {
		clickWhenClickable(createBtn);
	}

	public void clickSaveButton() {
		WebElementUtils.scrollDown(driver(), 0, 250);
		clickWhenClickable(saveBtn);
	}

	protected void clickCancelButton() {
		clickWhenClickable(cancelBtn);
	}

	protected void clickCloseButton() {
		WebElementUtils.scrollDown(driver(), 0, 350);
		clickWhenClickable(closeBtn);
	}

	protected void clickAddDetailsButton() {
		clickWhenClickable(addDetailsBtn);
	}

	public void clickSearchButton() {
		clickWhenClickable(searhBtn);
	}

	protected void clickX2Close() {
		clickWhenClickable(closePopUpBtn);
	}

	protected void viewFirstRecord() {
		clickWhenClickable(firstRowViewLink);
	}

	protected void editFirstRecord() {
		clickWhenClickable(firstRowEditLink);
	}

	protected void selectFirstRecord() {
		clickWhenClickable(firstRowSelectLink);
	}

	protected void clicksearchButtonElement() {
		clickWhenClickable(searchButtonElement);
	}

	protected Boolean isNoRecordsFoundInTable() {
		try {
			return driver().findElement(By.cssSelector(".norecords")).isDisplayed();
		} catch (NoSuchElementException e) {
			logger.debug(ERROR_MESSAGE, e);
			return false;
		}
	}

	protected Boolean isDeleteColumnPresent() {
		try {
			return driver().findElement(By.xpath("//table//th//span[contains(text(),'Delete')]")).isDisplayed();
		} catch (NoSuchElementException e) {
			logger.debug("Delete not available for page {} " + e);
			return false;
		}
	}

	protected Boolean isEditColumnPresent() {
		try {
			return driver().findElement(By.xpath("//table//th//span[contains(text(),'Edit')]")).isDisplayed();
		} catch (NoSuchElementException e) {
			logger.debug("Edit not available for page {} " + e);
			return false;
		}
	}

	protected Boolean isAddReccordPresent() {
		try {
			return driver().findElement(By.cssSelector("a.addR")).isDisplayed();
		} catch (NoSuchElementException e) {
			logger.debug("Error", e);
			return false;
		}
	}

	public String getFirstColumnValueFromTable() {
		return firstRowViewLink.getText();
	}

	protected void deleteFirstRecord() {

		WebElementUtils.visibilityOf(firstRowDeleteLink);
		waitForWicket();
		clickWhenClickableDoNotWaitForWicket(firstRowDeleteLink);
	}

	/**
	 * Returns trimmed cell text by row number and column name
	 * 
	 * @param rowNumber
	 *            starting with 1
	 * @param columnName
	 *            case sensitive
	 * @return trimmed cell text
	 */
	protected String getCellTextByColumnNameInEmbeddedTab(int rowNumber, String columnName) {
		String xpath = String.format(
				"//div[@class='tab_container_privileges']//table[@class='dataview']/tbody/tr[%d]/td[count(//th[.//*[text()='%s']]/preceding-sibling::th)+1]",
				rowNumber, columnName);
		return driver().findElement(By.xpath(xpath)).getText().trim();
	}

	public String getCellTextByColumnName(int rowNumber, String columnName) {
		String xpath = String.format(
				"//table[@class='dataview']/tbody/tr[%d]/td[count(//th[.//*[text()='%s']]/preceding-sibling::th)+1]",
				rowNumber, columnName);
		return driver().findElement(By.xpath(xpath)).getText().trim();
	}

	public int getRowCountFromTable() {
		List<WebElement> tableRecords = driver().findElements(By.xpath("//table[@class='dataview']/tbody//tr"));
		return tableRecords.size();
	}

	protected String getFirstRecordCellTextByColumnName(String columnName) {
		return getCellTextByColumnName(1, columnName);
	}

	protected String getFirstRecordCellTextByColumnNameInEmbeddedTab(String columnName) {
		return getCellTextByColumnNameInEmbeddedTab(1, columnName);
	}

	protected Boolean verifyAddDetailsButtonIsVisible() {
		// looks like method should be renamed
		return saveBtn.isEnabled();
	}

	protected void runWithinPopup(String caption, Runnable action) {
		By frameSelector = By.xpath(String.format("//h3[contains(text(), '%s')]/ancestor::div//iframe", caption));
		WebElementUtils.runWithinFrame(driver(), timeoutInSec, frameSelector, action);
	}

	protected void verifyResponseMessage() {
		WebElement responseMessage = new WebDriverWait(driver(), timeoutInSec)
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".SuccessMessageTxt")));
		logger.info(RESPONSE_MESSAGE, responseMessage.getText());
	}

	protected void verifyOperationStatus() {
		WebElement successMessageLbl = new WebDriverWait(driver(), timeoutInSec)
				.until(ExpectedConditions.visibilityOfElementLocated(INFO_MESSAGE_LOCATOR));
		logger.info(SUCCESS_MESSAGE, successMessageLbl.getText());
	}

	protected boolean waitForRow() {
		try {
			waitForWicket();
			Thread.sleep(20000); // Pre-production batch and device production
									// batch takes little longer hence the wait
			return driver().findElement(By.cssSelector(FIRST_ROW_SELECT)).isDisplayed();
		} catch (NoSuchElementException | InterruptedException e) {
			logger.debug("Result not found", e);
			return false;
		}
	}

	protected String getSuccessMessage() {
		try {
			WebElement successMessageLbl = new WebDriverWait(driver(), timeoutInSec)
					.until(ExpectedConditions.visibilityOfElementLocated(INFO_MESSAGE_LOCATOR));
			logger.info(SUCCESS_MESSAGE, successMessageLbl.getText());
			return successMessageLbl.toString();
		} catch (NoSuchElementException e) {
			logger.info("No Status is updated");
			logger.debug("Error", e);
			return null;
		}
	}

	protected String getCodeFromInfoMessage(String codeDescription) {
		return driver().findElements(INFO_MESSAGE_LOCATOR).stream().map(WebElement::getText)
				.filter(text -> StringUtils.containsIgnoreCase(text, codeDescription))
				.map(text -> text.replaceAll("\\D+", "")).findFirst()
				.orElseThrow(() -> new ValidationException("Missing code: " + codeDescription));
	}

	protected void verifyErrorMessage() {
		WebElement errorMessageLbl = new WebDriverWait(driver(), timeoutInSec)
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.feedbackPanelERROR")));
		logger.info("Error message : {}", errorMessageLbl.getText());
	}

	protected void pageScrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor) getFinder().getWebDriver();
		jse.executeScript("window.scrollBy(100,150)");
	}

	protected void pageScrollDown(String x, String y) {
		JavascriptExecutor jse = (JavascriptExecutor) getFinder().getWebDriver();
		jse.executeScript("window.scrollBy(" + x + "," + y + ")");
	}

	protected void pageScrollUp() {
		JavascriptExecutor jse = (JavascriptExecutor) getFinder().getWebDriver();
		jse.executeScript("window.scrollBy(150,50)");
	}

	protected String getErrorMessage() {
		try {
			WebElement errorMessageLbl = new WebDriverWait(driver(), timeoutInSec)
					.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.feedbackPanelERROR")));
			logger.info("Error message : {}", errorMessageLbl.getText());
			return errorMessageLbl.toString();
		} catch (TimeoutException e) {
			logger.info("Operation Status message {}: " + "No Status is updated");
			logger.debug("Error message {}: ", e);
			return null;
		}
	}

	protected void verifyNoErrors() {
		List<WebElement> messages = driver().findElements(By
				.cssSelector(".feedbackPanelWARNING, .feedbackPanelERROR, .ketchup-error-container-alt[style*=block]"));
		if (!messages.isEmpty()) {
			String errors = messages.stream().map(WebElement::getText).collect(Collectors.joining("\n"));
			throw new ValidationException(errors);
		}
	}

	/**
	 * Verify already exists and click cancel
	 * 
	 * @return true if error exists otherwise false
	 */
	protected boolean verifyAlreadyExistsAndClickCancel() {
		String message = getMessageFromFeedbackPanel();
		if (message != null && message.contains("already exists")) {
			clickCancelButton();
			return true;
		}
		return false;
	}

	protected boolean verifyDuplicateAndClickCancel() {
		String message = getMessageFromFeedbackPanel();
		if (message != null && (message.contains("Effective Date and End Date should not overlap for same Country")
				|| message.contains("Error in Insertion/Save") || message.contains(
						"Business Calendar setup already exists for logged in Institution for same Effective Date"))) {
			clickCancelButton();
			return true;
		}
		return false;
	}

	// fetching any message that may appear in the Label Panel
	protected String getMessageFromFeedbackPanel() {
		List<WebElement> messages = driver().findElements(By.cssSelector(".feedbackPanel li"));

		if (messages.isEmpty()) {
			return null;
		}
		String generatedMessage = messages.stream().map(WebElement::getText).collect(Collectors.joining("\n"));
		logger.info("Message : {} ", generatedMessage);
		return generatedMessage;
	}

	protected void clickWhenClickable(MCWebElement element) {
		new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.elementToBeClickable(element)).click();
		waitForWicket();
	}

	private void clickWhenClickableDoNotWaitForWicket(MCWebElement element) {
		new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.elementToBeClickable(element)).click();
	}

	protected void verifyRecordMarkedForUpdationStatusWarning() {
		WebElement warningMessageLbl = new WebDriverWait(driver(), timeoutInSec)
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.feedbackPanelWARNING")));
		logger.info("Warning message: {}", warningMessageLbl.getText());
	}

	protected void verifyRecordMarkedForUpdationStatusSuccess() {
		WebElement successMessageLbl = new WebDriverWait(driver(), timeoutInSec)
				.until(ExpectedConditions.visibilityOfElementLocated(INFO_MESSAGE_LOCATOR));
		logger.info(SUCCESS_MESSAGE, successMessageLbl.getText());
	}

	protected void verifyOnAgentPortal() {
		WebElement userName = new WebDriverWait(driver(), timeoutInSec)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='credentials']//label")));
		logger.info("On Agent Portal: {}", userName.getText());
	}

	// Element highlighted code
	protected void highLightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver();
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			logger.error("Fail to create page object: {}", e.getMessage());
			throw MiscUtils.propagate(e);
		}
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);
	}

	protected String getBatchNumberFromFeedbackPanel() {
		WebElement successMessageLbl = new WebDriverWait(driver(), timeoutInSec)
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.feedbackPanelINFO")));
		String batchNumber = successMessageLbl.getText().replaceAll("\\D+", "");
		logger.info("batch number: {}", batchNumber);
		return batchNumber;
	}

	protected void waitForWicket() {
		WebElementUtils.waitForWicket(driver());
	}

	protected void waitAndSearchForRecordToExist() {
		clickSearchButton();
		// Pre-production batch and device production batch take little long to
		// be completed, and do not appear in search result, hence a for loop
		for (int l = 0; l < 21; l++) {
			if (!waitForRow())
				clickSearchButton();
			else {
				break;
			}
		}

		selectFirstRecord();
		clickProcessSelectedButton();
	}

	protected void waitForBatchStatus() {
		try {
			WebElementUtils.waitForWicket(driver());
			for (int l = 0; l < 21; l++) {
				while ("PENDING [0]".equalsIgnoreCase(batchStatus.getText())
						|| "IN PROCESS [1]".equalsIgnoreCase(batchStatus.getText()))
					Thread.sleep(10000); // waiting for page auto refresh
			}
		} catch (NoSuchElementException | InterruptedException e) {
			logger.debug("Result not found", e);
		}
	}

	protected void verifySearchButton(String buttonLabel) {
		new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(searchButtonElement));
		Assert.assertTrue("Error Message -  Button Label - Expected Result : " + buttonLabel + ACTUAL_RESULT_LABEL
				+ searchButtonElement.getText(), buttonLabel.contains(searchButtonElement.getText()));
		logger.info(RESPONSE_MESSAGE, searchButtonElement.getText());
	}

	protected void verifyPopup(String popupName) {
		new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(popupNameElement));
		Assert.assertTrue("Error Message - Popup Name - Expecting Result : " + popupName + ACTUAL_RESULT_LABEL
				+ popupNameElement.getText(), popupName.contains(popupNameElement.getText()));
		logger.info(RESPONSE_MESSAGE, popupNameElement.getText());
	}

	protected void verifyDeleteRecordAlert(String expectedAlertText) {
		Alert alert = driver().switchTo().alert();
		String actualAlertText = null;
		boolean isAlertPresent = alert != null;
		if (isAlertPresent) {
			actualAlertText = alert.getText();
			Assert.assertTrue("Error Message - Delete Alert - Expected Result : " + expectedAlertText
					+ ACTUAL_RESULT_LABEL + actualAlertText, actualAlertText.contains(expectedAlertText));
			alert.dismiss();
		}
		if (!isAlertPresent) {
			Assert.fail("Alert to confirm Deletion is NOT displayed");
		}

		logger.info(RESPONSE_MESSAGE, actualAlertText);
	}

	protected void verifyUiOperation(String name) {
		if (isAddReccordPresent()) {
			clickAddNewButton();
			verifyPopup(name);
			clickX2Close();
		}
		if (!isNoRecordsFoundInTable()) {
			viewFirstRecord();
			verifyPopup(name.replaceFirst("Add", "View"));
			clickX2Close();
			if (isEditColumnPresent()) {
				editFirstRecord();
				verifyPopup(name.replaceFirst("Add", "Edit"));
				clickX2Close();
			}
			if (isDeleteColumnPresent()) {
				deleteFirstRecord();
				verifyDeleteRecordAlert(
						name.replaceAll("Add.*", "Are you sure you want to delete the highlighted record?"));
			}
		}
	}

	protected void verifyUiOperationNoEdit(String name) {
		if (isAddReccordPresent()) {
			clickAddNewButton();
			verifyPopup(name);
			clickX2Close();
		}
		if (!isNoRecordsFoundInTable()) {
			viewFirstRecord();
			verifyPopup(name.replaceFirst("Add", "View"));
			clickX2Close();
			if (isDeleteColumnPresent()) {
				deleteFirstRecord();
				verifyDeleteRecordAlert(
						name.replaceAll("Add.*", "Are you sure you want to delete the highlighted record?"));
			}
		}
	}

	protected void verifyHomePageCollectPortal(String text) {

		if ("home".equalsIgnoreCase(text))
			Assert.assertTrue("Error Message - Expected Result : " + text + ACTUAL_RESULT_LABEL + heading.getText(),
					heading.getText().contains(text));
		else {
			Assert.assertTrue(
					"Error Message - Expected Result : Welcome to " + text + ACTUAL_RESULT_LABEL + paragraph.getText(),
					paragraph.getText().contains("Welcome to " + text));
			Assert.assertTrue("Error Message - Expected Result : " + text + ACTUAL_RESULT_LABEL + heading.getText(),
					heading.getText().contains(text));
		}
	}

	protected void verifyDeviceDetails() {
		boolean deviceNumberLength = deviceNumber.getText().trim().length() > 0;
		Assert.assertTrue(
				"Error Message - Device Number Length - Expected Result : Length Greater Than Zero | Actual Result : "
						+ deviceNumber.getText().trim().length(),
				deviceNumberLength);
	}

	protected void verifyWalletDetails() {
		boolean walletNumberLength = walletNumber.getText().trim().length() > 0;
		Assert.assertTrue(
				"Error Message - Wallet Number Length - Expected Result : Length Greater Than Zero | Actual Result : "
						+ walletNumber.getText().trim().length(),
				walletNumberLength);
	}

	public String getMasterDetailContentTitle() {
		return new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(masterDetailContentTitle))
				.getText();
	}

	protected void verifyTitleCardHolderPortal(String text) {
		Assert.assertTrue("Error Message - Title of Cradholder Portal - Expected Result : " + text + ACTUAL_RESULT_LABEL
				+ getMasterDetailContentTitle().trim(), getMasterDetailContentTitle().trim().contains(text));
	}

	protected void verifyButton(String text) {
		if ("submit".equalsIgnoreCase(text))
			Assert.assertTrue("Error Message - Submit Button is Not Visible", submitButton.isVisible());
		if ("cancel".equalsIgnoreCase(text))
			Assert.assertTrue("Error Message - Cancel Button is Not Visible", cancelButton.isVisible());
		if ("continue".equalsIgnoreCase(text))
			Assert.assertTrue("Error Message - Continue Button is Not Visible", continueButton.isVisible());
	}

	protected void verifyContactInformation() {
		Assert.assertTrue(
				"Error Message - Contanct Information Not Present - Expected Result : Contact Information | Actual Result : "
						+ contactInformation.getText(),
				CONTACT_INFORMATION_EXPECTED.equals(contactInformation.getText()));
	}

	protected String getDate() {
		return getFirstColumnValueFromTable().substring(0, 8);
	}

	public void enterValueinTextBox(MCWebElement txtBoxElement, String value) {
		waitForElementVisible(txtBoxElement);
		if (value != null && !value.isEmpty()) {
			enterText(txtBoxElement, value);
		}
	}

	public void selectValueFromDropDown(MCWebElement dropDownElement, String value) {
		if (value != null && !value.isEmpty()) {
			selectByText(dropDownElement, value);
		}
	}

	public boolean selectCheckBox(MCWebElement chkBx, String fieldName) {
		boolean isChecked = false;
		waitForElementVisible(chkBx);
		String value = MapUtils.fnGetInputDataFromMap(fieldName);
		if (value != null) {
			if ("check".equalsIgnoreCase(value) && !chkBx.isSelected()) {
				isChecked = true;
				chkBx.click();
			} else if ("uncheck".equalsIgnoreCase(value) && chkBx.isSelected()) {
				chkBx.click();
				isChecked = false;
			}
		}
		return isChecked;
	}

	protected boolean isLoggedIn(WebDriver webDriver) {
		boolean flag = false;
		try {
			if (webDriver.findElement(By.xpath("//button[@class=' x-btn-text logout']")) == null)
				flag = false;
			else
				flag = true;
		} catch (NoSuchElementException e) {
			logger.info("user is not logged in" + e);
		}
		return flag;
	}

	public void jsClick(MCWebElement MCWE) {
		logger.info("Using java script to click the web element");
		JavascriptExecutor jse = (JavascriptExecutor) getFinder().getWebDriver();
		boolean breakIt = true;
		while (true) {
			breakIt = true;
			try {
				jse.executeScript("arguments[0].click();", MCWE.getFluent().getWebElement());

			} catch (Exception e) {
				logger.error("Element not found" + e);
				if ("element is not attached".contains(e.getMessage())) {
					breakIt = false;
				}
			}
			if (breakIt) {
				break;
			}
		}
	}

	public void jsClick(WebElement WE) {
		logger.info("Using java script to click the web element");
		JavascriptExecutor jse = (JavascriptExecutor) getFinder().getWebDriver();
		jse.executeScript("arguments[0].click();", WE);
	}

	public boolean waitForElementVisible(MCWebElement mcW) {
		try {
			WebDriverWait waitForAvgVisitsWidget = new WebDriverWait(getFinder().getWebDriver(), 20, ELEMENT_WAIT_MAX);
			Scrolldown(mcW);
			waitForAvgVisitsWidget.until(ExpectedConditions.visibilityOf(mcW.getFluent().getWebElement()));
			logger.info("Element is visible");
			return true;
		} catch (Exception e) {
			logger.error("Element is not visible :" + e.fillInStackTrace());
			return false;
		}
	}

	public boolean isElementPresent(MCWebElement ele) {
		boolean ispresent = false;

		try {
			ele.isVisible();
			ispresent = true;
			logger.info("Element is visible");

		} catch (Exception e) {
			ispresent = false;
			logger.error("Element is not visible :" + e.fillInStackTrace());
		}
		return ispresent;
	}

	public boolean waitforElemenet(MCWebElement ele) {
		try {
			getFinder().waitUntil(ExpectedConditions.visibilityOf((WebElement) ele));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean isElementPresent(MCWebElements ele) {
		boolean ispresent = false;
		try {
			if (ele.getElements().size() > 0) {
				ispresent = true;
			} else {
				ispresent = false;
			}
		} catch (Exception e) {
			ispresent = false;
		}
		return ispresent;
	}

	public boolean iselementPresent(List<WebElement> ele) {
		boolean ispresent = false;
		try {
			if (ele.size() > 0) {
				ispresent = true;
			} else {
				ispresent = false;
			}
		} catch (Exception e) {
			ispresent = false;
		}
		return ispresent;
	}

	public boolean waitForElementInVisible(String locator) {
		try {
			WebDriverWait waitForAvgVisitsWidget = new WebDriverWait(getFinder().getWebDriver(), 5);
			waitForAvgVisitsWidget.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
			logger.info("Element is invisible");
			return true;
		} catch (Exception e) {
			logger.info("Element is visible");
			return false;
		}
	}

	public boolean waitForElementVisible(MCWebElements mcWs) {
		boolean visible = false;
		for (int i = 0; i < mcWs.getElements().size(); i++) {
			visible = waitForElementVisible(mcWs.getElements().get(i));
			if (!visible)
				return false;
		}
		return true;
	}

	public boolean waitForElementVisible(WebElement W) {
		try {
			WebDriverWait waitForElement = new WebDriverWait(getFinder().getWebDriver(), 2000, ELEMENT_WAIT_MAX);
			waitForElement.until(ExpectedConditions.visibilityOf(W));
			logger.info("Element is visible");
			return true;
		} catch (Exception e) {
			logger.error("Element is not visible");
			return false;
		}
	}

	public boolean waitForLoaderToDisappear() {
		try {
			WebDriverWait waitForElement = new WebDriverWait(getFinder().getWebDriver(), 50, ELEMENT_WAIT_MAX);
			waitForElement.until(ExpectedConditions
					.not(ExpectedConditions.visibilityOf(Element("//img[contains(@src,'loading')]"))));
			logger.info("Loader is present");
			return true;
		} catch (Exception e) {
			logger.error("Loader is not present");
			return false;
		}
	}

	public boolean waitForElementsVisible(List<WebElement> Ws) {
		boolean visible = false;
		for (int i = 0; i < Ws.size(); i++) {
			visible = waitForElementVisible(Ws.get(i));
			if (!visible)
				return false;
		}
		return true;
	}

	public String jsGetText(MCWebElement MCWE) {
		JavascriptExecutor jse = (JavascriptExecutor) getFinder().getWebDriver();
		String jsText = (String) jse.executeScript("return arguments[0].textContent", MCWE.getFluent().getWebElement());
		logger.info("Text got using javaScript: " + jsText);
		return jsText;
	}

	public String jsGetText1(MCWebElement MCWE) {
		JavascriptExecutor jse = (JavascriptExecutor) getFinder().getWebDriver();
		String jsText = (String) jse.executeScript("return $(arguments[0]).text();", MCWE.getFluent().getWebElement());
		logger.info("Text got using javaScript: " + jsText);
		return jsText;
	}

	public String jsGetText(WebElement WE) {
		JavascriptExecutor jse = (JavascriptExecutor) getFinder().getWebDriver();
		String jsText = "";
		boolean unfound = true;
		int tries = 0;
		while (unfound && tries < 10) {
			tries += 1;
			try {
				jse.executeScript("arguments[0].scrollIntoView(true);", WE);
				jsText = (String) jse.executeScript("return $(arguments[0]).text();", WE);
				unfound = false; // FOUND IT
			} catch (StaleElementReferenceException ser) {
				unfound = true;
			} catch (NoSuchElementException nse) {
				unfound = true;
			} catch (Exception e) {
				logger.info("Unknown error.");
			}
		}

		logger.info("Text got using javaScript: " + jsText);
		return jsText;
	}

	public void Scrolldown(MCWebElement mcWe) {
		JavascriptExecutor jseScroll = (JavascriptExecutor) getFinder().getWebDriver();
		jseScroll.executeScript("arguments[0].scrollIntoView();", mcWe.getFluent().getWebElement());
	}

	public void Scrolldown(WebElement we) {
		JavascriptExecutor jseScroll = (JavascriptExecutor) getFinder().getWebDriver();
		jseScroll.executeScript("arguments[0].scrollIntoView();", we);
	}

	public void dblClick(MCWebElement mcWe) {
		Actions act = getFinder().getActions();
		act.moveToElement(mcWe.getFluent().getWebElement());
		act.doubleClick(mcWe.getFluent().getWebElement());
	}

	public List<WebElement> getImages(String xPath) {
		return getFinder().getWebDriver().findElements(By.xpath(xPath));
	}

	public void dblClickAtPoint(WebElement we, int x, int y) {
		Actions builder = getFinder().getActions();
		builder.moveToElement(we, x, y).doubleClick().build().perform();
	}

	public void dblClickAtPoint(WebElement we) {
		Actions action = getFinder().getActions();
		action.doubleClick(we).build();
		action.perform();
	}

	public void moveToWebElementAndClickJS(WebElement we) {
		Actions builder = getFinder().getActions();
		builder.moveToElement(we).build().perform();
		boolean breakIt = true;
		logger.info("Please wait while attaching Menu Item to the page.......");
		while (true) {
			breakIt = true;
			try {
				jsClick(we);
				// builder.build().perform();

			} catch (Exception e) {
				if (e.getMessage().contains("element is not attached")) {
					breakIt = false;
					logger.info("Recovering from StaleElementException");
				}
			}
			if (breakIt) {
				break;
			}
		}

	}

	public void moveToWebElementAndClick(WebElement we) {
		Actions builder = getFinder().getActions();
		builder.moveToElement(we).build().perform();
		boolean breakIt = true;
		logger.info("Please wait while attaching Menu Item to the page.......");
		while (true) {
			breakIt = true;
			try {
				we.click();
				builder.build().perform();

			} catch (Exception e) {
				if (e.getMessage().contains("element is not attached")) {
					breakIt = false;
					logger.info("Recovering from StaleElementException");
				}
			}
			if (breakIt) {
				break;
			}
		}
	}

	public void clickInRect(MCWebElement widgetArea) {
		WebDriverWait wait = new WebDriverWait(getFinder().getWebDriver(), 60);
		WebElement we = wait.until(ExpectedConditions.visibilityOf(widgetArea.getFluent().getWebElement()));

		Actions actions = new Actions(getFinder().getWebDriver());
		actions.moveToElement(we, 30, 50).doubleClick(we).build().perform();
	}

	public List<WebElement> getList(String xPath) {
		boolean listVisible = waitForElementsVisible(getFinder().getWebDriver().findElements(By.xpath(xPath)));
		if (listVisible) {
			return getFinder().getWebDriver().findElements(By.xpath(xPath));

		}
		return null;
	}

	public void selectByVisibleText(MCWebElement ele, String optionName) {
		String optionVisbleText = "";
		waitUntilSelectOptionsPopulated(ele);
		List<WebElement> selectedOptions = ele.getSelect().getOptions();
		for (WebElement element : selectedOptions) {
			if (element.getText().toUpperCase().contains(optionName.toUpperCase())) {
				optionVisbleText = element.getText();
				break;
			}
		}
		ele.getSelect().selectByVisibleText(optionVisbleText);

		// waitForWicket(driver());
		waitForLoaderToDisappear();
		waitForPageToLoad(driver());
	}

	private void waitUntilSelectOptionsPopulated(MCWebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver(), 100);
		wait.until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return ele.getSelect().getOptions().size() > 1;
			}
		});
	}

	protected void selectByText(MCWebElement ele, String optionName) {
		waitForElementVisible(ele);
		waitUntilSelectOptionsPopulated(ele);
		ele.getSelect().selectByVisibleText(optionName);
		waitForLoaderToDisappear();
	}

	protected WebDriver driver() {
		return getFinder().getWebDriver();
	}

	public void clickWhenWebElementClickable(WebElement ele) {
		new WebDriverWait(driver(), TIMEOUT).until(ExpectedConditions.elementToBeClickable(ele)).click();
	}

	protected void clickWhenClickableCHP(MCWebElement element) {
		waitForElementVisible(element);
		new WebDriverWait(driver(), TIMEOUT).until(elementToBeClickable(element)).click();
		// waitForWicket(driver());
	}

	protected void clickWhenClickable(WebElement element) {
		waitForElementVisible(element);
		new WebDriverWait(driver(), TIMEOUT).until(ExpectedConditions.elementToBeClickable(element)).click();
		waitForWicket(driver());
	}

	public MCWebElement getMCWebElementFromWebElement(final FindBy findBy, final String valueToFind) {
		return getFinder().findOne(findBy, valueToFind);
	}

	public static ExpectedCondition<WebElement> elementToBeClickable(MCWebElement element) {
		return ExpectedConditions.elementToBeClickable(asWebElement(element));
	}

	public static WebElement asWebElement(MCWebElement element) {
		return element.getFluent().getWebElement();
	}

	public static void waitForWicket(WebDriver driver) {
		String javascript = "return typeof tk === 'undefined' || tk.activeAjaxCount == 0;";
		fluentWait(() -> (Boolean) executeJavascript(driver, javascript));
	}

	@SuppressWarnings("unchecked")
	public static <T> T executeJavascript(WebDriver driver, String javascript, Object... args) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		return (T) executor.executeScript(javascript, args);
	}

	public void switchToFrame(String strFrame) {

		WebDriverWait wait = new WebDriverWait(getFinder().getWebDriver(), 60);
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(strFrame));
			CustomUtils.ThreadDotSleep(2000);
		} catch (Exception ex) {
			logger.info("Unable to switch to frame :" + strFrame);
			throw ex;
			// Assert.fail(ex.getMessage());
		} finally {
			wait = null;
		}
	}

	public MCWebElement getCustomMCWebElement(Object obj, String text) {
		FindBy findBy = null;
		String valueoFind = null;
		String Value = null;
		Class<? extends Object> page = obj.getClass();
		for (Field field : page.getDeclaredFields()) {
			for (Annotation a : field.getAnnotations()) {
				if (a.annotationType() == CustomMCWebElement.class) {
					CustomMCWebElement custom = (CustomMCWebElement) a;
					findBy = custom.findBy();
					valueoFind = custom.valueToFind();
					Value = valueoFind.replace("%s", text);
					getFinder().findOne(findBy, Value);
				}
			}
		}
		return getFinder().findOne(findBy, Value);
	}

	public void fnSwitchFrame(String strFrame) {

		WebDriverWait wait = new WebDriverWait(getFinder().getWebDriver(), 60);
		try {

			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(strFrame));
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
		WebDriverWait wait = new WebDriverWait(getFinder().getWebDriver(), 80);
		By frameSelector = By.xpath(
				String.format("//h3[contains(text(), '%s')]/ancestor::div//iframe[@class='wicket_modal']", caption));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameSelector));
	}

	public static void addWicketAjaxListeners(WebDriver driver) {
		String javascript = "if (typeof tk  == 'undefined') {"
				+ "tk = {activeAjaxCount: 0, ajaxCallsTried: 0, ajaxCallsCompleted: 0};"
				+ "Wicket.Ajax.registerPreCallHandler(function(){tk.activeAjaxCount++;tk.ajaxCallsTried++;});"
				+ "Wicket.Ajax.registerPostCallHandler(function(){tk.activeAjaxCount--;tk.ajaxCallsCompleted++;});}";
		executeJavascript(driver, javascript);
	}

	public void waitForPageToLoad(WebDriver driver) {
		String pageLoadStatus;
		do {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			pageLoadStatus = (String) js.executeScript("return document.readyState");

			addWicketAjaxListeners(driver);

		} while (!pageLoadStatus.equals("complete"));

		logger.info("Page Loaded.");
	}

	public static <R> R fluentWait(Supplier<R> condition) {
		return new FluentWait<Object>(new Object()).ignoring(WebDriverException.class)
				.withTimeout(TIMEOUT, TimeUnit.SECONDS)
				.until((com.google.common.base.Function<Object, R>) o -> condition.get());
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
		waitForElementVisible(field);
		field.sendKeys(fieldValue);
		// addWicketAjaxListeners(getFinder().getWebDriver());
		// CustomUtils.ThreadDotSleep(2000);
	}

	public void SelectDropDownByValue(MCWebElement element, String value) {
		// element.getSelect().selectByVisibleText(value);
		element.getSelect().selectByValue(value);
		// addWicketAjaxListeners(getFinder().getWebDriver());
	}

	public void SelectDropDownByText(MCWebElement element, String value) {
		element.getSelect().selectByVisibleText(value);
		// element.getSelect().selectByValue(value);
		// addWicketAjaxListeners(getFinder().getWebDriver());
	}

	public void SelectDropDownByIndex(MCWebElement element, int value) {
		if (element.isEnabled()) {
			element.getSelect().selectByIndex(value);
		} else {

		}
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

	public static boolean hasClass(WebElement element, String cssClass) {
		String[] classes = element.getAttribute("class").split(" ");
		return ArrayUtils.contains(classes, cssClass);
	}

	public WebElement Element(String loc) {
		return driver().findElement(By.xpath(loc));

	}

	public List<WebElement> Elements(String loc) {
		return driver().findElements(By.xpath(loc));

	}

	public WebElement getChildElement(WebElement element, String Childlocator) {
		return element.findElement(By.xpath(Childlocator));
	}

	public Set<String> pageErrorValidator() {

		String errorMessage;
		String elementName;
		if (iselementPresent(Elements(ERRORPANEL))) {
			errorFields
					.add("Error on page" + "::::::" + getChildElement(Elements(ERRORPANEL).get(0), "//span").getText());
		}
		if (iselementPresent(Elements(pageValidationCheck))) {
			// System.out.println(Elements(pageValidationCheck).size());
			for (WebElement ele : Elements(pageValidationCheck)) {
				if (ele != null) {
					errorMessage = ele.getText();
					elementName = getChildElement(ele, "./preceding::td[1][@class='displayName']").getText();
					errorFields.add(elementName + "::::::" + errorMessage);

				}
			}
		}
		return errorFields;
	}

	public Map<String, String> pageErrorValidator(String ERRORPANEL) {
		Map<String, String> errorFields = new HashMap<String, String>();
		String errorMessage;
		String elementName;
		if (iselementPresent(Elements(ERRORPANEL))) {
			errorFields.put("Error on page" + "::::::",
					getChildElement(Elements(ERRORPANEL).get(0), "//span").getText());
		}
		if (iselementPresent(Elements(pageValidationCheck))) {
			// System.out.println(Elements(pageValidationCheck).size());
			for (WebElement ele : Elements(pageValidationCheck)) {
				if (ele != null) {
					errorMessage = ele.getText();
					elementName = getChildElement(ele, "./preceding::td[1][@class='displayName']").getText();
					errorFields.put(elementName, errorMessage);

				}
			}
		}
		return errorFields;
	}

	public void switchToWindowCHP() {

		try {
			Set<String> handles;

			/*
			 * do { handles = getFinder().getWebDriver().getWindowHandles();
			 * logger.info("Number of windows available: " + handles.size()); } while
			 * (handles.size() < 2);
			 */
			handles = getFinder().getWebDriver().getWindowHandles();
			for (String handle : handles) {
				if (!handle.equals(getFinder().getWebDriver().getWindowHandle()))
					getFinder().getWebDriver().switchTo().window(handle);
			}

		} catch (Exception e) {
			logger.error("Unable to Switch Window" + e);
		}
	}

	public void selectByVisibleTexts(MCWebElement ele, String optionName) {
		waitUntilSelectOptionsPopulated(ele);
		waitForLoaderToDisappear();
		ele.getSelect().selectByVisibleText(optionName);
		waitForLoaderToDisappear();
	}

	public boolean publishErrorOnPage() {
		boolean isAnyErrorPresent = false;
		Iterator<?> iter = pageErrorValidator().iterator();
		while (iter.hasNext()) {
			logger.error(iter.next().toString());
			isAnyErrorPresent = true;
		}
		return isAnyErrorPresent;
	}

	public String getTextFromPage(MCWebElement element) {
		return element.getText();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}
}