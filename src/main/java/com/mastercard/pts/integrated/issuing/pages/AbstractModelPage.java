package com.mastercard.pts.integrated.issuing.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementFinderProvider;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.AbstractPage;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

/**
 * @author Vitaliy Liubezny
 *
 */
public abstract class AbstractModelPage extends AbstractPage {

	private static final By INFO_MESSAGE_LOCATOR = By.cssSelector(":not([style]) > .feedbackPanel span.feedbackPanelINFO");

	private static final String FIRST_ROW_SELECT = ".dataview tbody span";

	private static final String SUCCESS_MESSAGE = "Success message: {}";

	public static final String ERROR_MESSAGE = "Error: {}";

	public static final String RESPONSE_MESSAGE = "Response message: {}";

	public static final String CONTACT_INFORMATION_EXPECTED = "Contact Information";

	public static final String ACTUAL_RESULT_LABEL = " | Actual Result : ";

	private static final Logger logger = LoggerFactory.getLogger(AbstractModelPage.class);

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
	private MCWebElement searchButtonElement;

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
		clickWhenClickable(nextBtn);
		WebElementUtils.addWicketAjaxListeners(driver());
	}

	protected void clickAddNewButton() {
		clickWhenClickable(addNewBtn);
	}

	// used when there are more than 1 add buttons
	protected void clickAddButtonVariant(MCWebElement element) {
		clickWhenClickable(element);

	}

	protected void clickCreateButton() {
		clickWhenClickable(createBtn);
	}

	protected void clickSaveButton() {
		clickWhenClickable(saveBtn);
	}

	protected void clickCancelButton() {
		clickWhenClickable(cancelBtn);
	}

	protected void clickCloseButton() {
		clickWhenClickable(closeBtn);
	}

	protected void clickAddDetailsButton() {
		clickWhenClickable(addDetailsBtn);
	}

	protected void clickSearchButton() {
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

	protected String getCellTextByColumnName(int rowNumber, String columnName) {
		String xpath = String.format("//table[@class='dataview']/tbody/tr[%d]/td[count(//th[.//*[text()='%s']]/preceding-sibling::th)+1]", rowNumber,
				columnName);
		return driver().findElement(By.xpath(xpath)).getText().trim();
	}

	protected int getRowCountFromTable() {
		List<WebElement> tableRecords = driver().findElements(By.xpath("//table[@class='dataview']/tbody//tr"));
		return tableRecords.size();
	}

	protected String getFirstRecordCellTextByColumnName(String columnName) {
		return getCellTextByColumnName(1, columnName);
	}

	protected String getFirstRecordCellTextByColumnNameInEmbeddedTab(String columnName) {
		return getCellTextByColumnNameInEmbeddedTab(1, columnName);
	}

	protected WebDriver driver() {
		return getFinder().getWebDriver();
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
		WebElement responseMessage = new WebDriverWait(driver(), timeoutInSec).until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(".SuccessMessageTxt")));
		logger.info(RESPONSE_MESSAGE, responseMessage.getText());
	}

	protected void verifyOperationStatus() {
		WebElement successMessageLbl = new WebDriverWait(driver(), timeoutInSec).until(ExpectedConditions.visibilityOfElementLocated(INFO_MESSAGE_LOCATOR));
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
			WebElement successMessageLbl = new WebDriverWait(driver(), timeoutInSec).until(ExpectedConditions.visibilityOfElementLocated(INFO_MESSAGE_LOCATOR));
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
				.filter(text -> StringUtils.containsIgnoreCase(text, codeDescription)).map(text -> text.replaceAll("\\D+", "")).findFirst()
				.orElseThrow(() -> new ValidationException("Missing code: " + codeDescription));
	}

	protected void verifyErrorMessage() {
		WebElement errorMessageLbl = new WebDriverWait(driver(), timeoutInSec).until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector("span.feedbackPanelERROR")));
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
			WebElement errorMessageLbl = new WebDriverWait(driver(), timeoutInSec).until(ExpectedConditions.visibilityOfElementLocated(By
					.cssSelector("span.feedbackPanelERROR")));
			logger.info("Error message : {}", errorMessageLbl.getText());
			return errorMessageLbl.toString();
		} catch (TimeoutException e) {
			logger.info("Operation Status message {}: " + "No Status is updated");
			logger.debug("Error message {}: ", e);
			return null;
		}
	}

	protected void verifyNoErrors() {
		List<WebElement> messages = driver().findElements(
				By.cssSelector(".feedbackPanelWARNING, .feedbackPanelERROR, .ketchup-error-container-alt[style*=block]"));
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

	private void clickWhenClickable(MCWebElement element) {
		new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.elementToBeClickable(element)).click();
		waitForWicket();
	}

	private void clickWhenClickableDoNotWaitForWicket(MCWebElement element) {
		new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.elementToBeClickable(element)).click();
	}

	protected void verifyRecordMarkedForUpdationStatusWarning() {
		WebElement warningMessageLbl = new WebDriverWait(driver(), timeoutInSec).until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector("span.feedbackPanelWARNING")));
		logger.info("Warning message: {}", warningMessageLbl.getText());
	}

	protected void verifyRecordMarkedForUpdationStatusSuccess() {
		WebElement successMessageLbl = new WebDriverWait(driver(), timeoutInSec).until(ExpectedConditions.visibilityOfElementLocated(INFO_MESSAGE_LOCATOR));
		logger.info(SUCCESS_MESSAGE, successMessageLbl.getText());
	}

	protected void verifyOnAgentPortal() {
		WebElement userName = new WebDriverWait(driver(), timeoutInSec).until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//div[@class='credentials']//label")));
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
		WebElement successMessageLbl = new WebDriverWait(driver(), timeoutInSec).until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector("span.feedbackPanelINFO")));
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
				while ("PENDING [0]".equalsIgnoreCase(batchStatus.getText()) || "IN PROCESS [1]".equalsIgnoreCase(batchStatus.getText()))
					Thread.sleep(10000); // waiting for page auto refresh
			}
		} catch (NoSuchElementException | InterruptedException e) {
			logger.debug("Result not found", e);
		}
	}

	protected void verifySearchButton(String buttonLabel) {
		new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(searchButtonElement));
		Assert.assertTrue("Error Message -  Button Label - Expected Result : " + buttonLabel + ACTUAL_RESULT_LABEL + searchButtonElement.getText(),
				buttonLabel.contains(searchButtonElement.getText()));
		logger.info(RESPONSE_MESSAGE, searchButtonElement.getText());
	}

	protected void verifyPopup(String popupName) {
		new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(popupNameElement));
		Assert.assertTrue("Error Message - Popup Name - Expecting Result : " + popupName + ACTUAL_RESULT_LABEL + popupNameElement.getText(),
				popupName.contains(popupNameElement.getText()));
		logger.info(RESPONSE_MESSAGE, popupNameElement.getText());
	}

	protected void verifyDeleteRecordAlert(String expectedAlertText) {
		Alert alert = driver().switchTo().alert();
		String actualAlertText = null;
		boolean isAlertPresent = alert != null;
		if (isAlertPresent) {
			actualAlertText = alert.getText();
			Assert.assertTrue("Error Message - Delete Alert - Expected Result : " + expectedAlertText + ACTUAL_RESULT_LABEL + actualAlertText,
					actualAlertText.contains(expectedAlertText));
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
				verifyDeleteRecordAlert(name.replaceAll("Add.*", "Are you sure you want to delete the highlighted record?"));
			}
		}
	}

	protected void verifyHomePageCollectPortal(String text) {

		if ("home".equalsIgnoreCase(text))
			Assert.assertTrue("Error Message - Expected Result : " + text + ACTUAL_RESULT_LABEL + heading.getText(), heading.getText().contains(text));
		else {
			Assert.assertTrue("Error Message - Expected Result : Welcome to " + text + ACTUAL_RESULT_LABEL + paragraph.getText(),
					paragraph.getText().contains("Welcome to " + text));
			Assert.assertTrue("Error Message - Expected Result : " + text + ACTUAL_RESULT_LABEL + heading.getText(), heading.getText().contains(text));
		}
	}

	protected void verifyDeviceDetails() {
		boolean deviceNumberLength = deviceNumber.getText().trim().length() > 0;
		Assert.assertTrue("Error Message - Device Number Length - Expected Result : Length Greater Than Zero | Actual Result : "
				+ deviceNumber.getText().trim().length(), deviceNumberLength);
	}

	protected void verifyWalletDetails() {
		boolean walletNumberLength = walletNumber.getText().trim().length() > 0;
		Assert.assertTrue("Error Message - Wallet Number Length - Expected Result : Length Greater Than Zero | Actual Result : "
				+ walletNumber.getText().trim().length(), walletNumberLength);
	}

	public String getMasterDetailContentTitle() {
		return new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(masterDetailContentTitle)).getText();
	}

	protected void verifyTitleCardHolderPortal(String text) {
		Assert.assertTrue(
				"Error Message - Title of Cradholder Portal - Expected Result : " + text + ACTUAL_RESULT_LABEL + getMasterDetailContentTitle().trim(),
				getMasterDetailContentTitle().trim().contains(text));
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
				"Error Message - Contanct Information Not Present - Expected Result : Contact Information | Actual Result : " + contactInformation.getText(),
				CONTACT_INFORMATION_EXPECTED.equals(contactInformation.getText()));
	}
}