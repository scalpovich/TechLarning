package com.mastercard.pts.integrated.issuing.pages;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.CreditCardPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.admin.UserCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.CustomMCWebElement;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.utils.PDFUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementFinderProvider;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.MCWebElements;
import com.mastercard.testing.mtaf.bindings.exception.ElementNotFoundException;
import com.mastercard.testing.mtaf.bindings.page.AbstractPage;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

public abstract class AbstractBasePage extends AbstractPage {

	@Autowired
	CreditCardPlan creditCardPlans;

	@Autowired
	TestContext context;

	final static int ELEMENT_WAIT_MAX = 6000;

	private static final long TIMEOUT = 100;
	public Set<String> errorFields = new HashSet<String>();

	public String pageValidationCheck = "//ol/li";
	public String ERRORPANEL = "//li[@class='feedbackPanelERROR']";

	private static final By INFO_MESSAGE_LOCATOR = By.cssSelector(":not([style]) > .feedbackPanel span.feedbackPanelINFO");

	private static final String FIRST_ROW_SELECT = ".dataview tbody span";

	private static final String SUCCESS_MESSAGE = "Success message: {}";

	private static final String WALLET_NUMBER = "Wallet number: {}";
	
	public static final String ERROR_MESSAGE = "Error: {}";

	public static final String RESPONSE_MESSAGE	 = "Response message: {}";

	public static final String CONTACT_INFORMATION_EXPECTED = "Contact Information";

	public static final String ACTUAL_RESULT_LABEL = " | Actual Result : ";

	public static final String ENTITY_TYPE_USER = "User [U]";

	public static final String ENTITY_TYPE_ROLE = "Role [R]";

	public static final By ENTITY_ID = By.name("searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent");

	public static final String PRIVILEGES_TABS = "//a[contains(text(),'%s')]";

	private static final Logger logger = LoggerFactory.getLogger(AbstractBasePage.class);

	public static final LocalDate futureDate = LocalDate.now().plusDays(100);

	public static final LocalDate futureEndDate = LocalDate.now().plusDays(150);

	private static final String EXCEPTION_MESSAGE = "Exception Message - {} ";
	
	public static final String INVALID_TRANSACTION_MESSAGE = "Invalid transaction type - ";
    
	public static final String REFUND_SUCCESS = "Refund is successful";
	
    private static final String Device = null;
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
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Yes']")
	private MCWebElement yesBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Add Details']")
	private MCWebElement addDetailsBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Cancel']")
	private MCWebElement cancelBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Reverse']")
	private MCWebElement reverseBtn;
	
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
	
	@PageElement(findBy = FindBy.CSS, valueToFind = ".dataview tbody input[type='checkbox']")
	private MCWebElements firstRowSelectLinksCheckBox;

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
	protected MCWebElement batchStatus;

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

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value=Confirm]")
	private MCWebElement confirmButton;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value=Cancel]")
	private MCWebElement cancelButton;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value=Continue]")
	private MCWebElement continueButton;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[type='reset']")
	private MCWebElement okButton;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[contains(text(),'Contact Information')]")
	private MCWebElement contactInformation;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Card Management']")
	private MCWebElement cardManagement;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@class='dataview-div']/table//tbody/tr[1]/td/span/child::a/span")
	private MCWebElement uniqueAddedCode;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@class='dataview-div']/table//tbody/tr[1]/td/span[string-length( text()) > 2]")
	private MCWebElements otherValuesInFirstRow;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[contains(@class,'mandatoryFlag')]")
	private MCWebElements mandatoryValues;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[contains(@class,'mandatoryFlag')]/parent::span/parent::td/preceding-sibling::td[@class='displayName']/span")
	private MCWebElement mandatoryValuesHeaders;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//tr[@class='headers']/th[@class='wicket_orderNone']/a/span")
	private MCWebElements tableHeaders;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@class='displayName wrap-search']")
	private MCWebElements filterHeaders;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@class='top']//div[@id='searchForm']//table/tbody/tr//td[@class='field']/child::input | //div[@class='top']//div[@id='searchForm']//table/tbody/tr//td[@class='field']/child::select")
	private MCWebElements commonXpathForFilter;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@class='searchButton']//input")
	private MCWebElement searchBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//tbody/tr[1]//img[@alt='Edit Record']")
	private MCWebElements editRecord;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']/tbody/tr")
	private MCWebElements firstRow;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']/tbody/tr/td")
	private MCWebElements firstRowColumnValues;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Description :']/parent::*/following-sibling::td//span/*")
	private MCWebElements descriptionTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@class='w_captionText']")
	private MCWebElements frameSwitch;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@class='displayName']/span[contains(text(),'Description')]/parent::*/following-sibling::*/span/input")
	private MCWebElement innerDescriptionTxt;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[contains(text(),'Description')]/following-sibling::td/following-sibling::td/input")
	private MCWebElement descriptionFilterTxt;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@class='displayName']/following-sibling::td//li[contains(text(),'required')]/../../../.././preceding::td[1]/span")
	private MCWebElements allLabelsMandatoryField;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//tbody/tr[@class!='headers']/td/span/a/img[@alt='Delete Record']")
	private MCWebElement deleteRecord;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//tr[@class='headers']/following-sibling::tr//span")
	private MCWebElement noRecordsFound;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']/tbody")
	private MCWebElement tableRows;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@type='submit' or @name='save']")
	private MCWebElement saveOrDetailsOrSearchBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//tr[@class!='headers' and @class!='navigation'][1]/td[2]/span")
	private MCWebElement deviceNumberFetch;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement entityTypeDdwn;

	@PageElement(findBy = FindBy.ID, valueToFind = "institution_selection")
	private MCWebElement instituteSelectionDrpDwn;

	private String instituteSelectionVal = "//div[@id='institution_selector']//li/a[contains(text(),'%s')]";

	@PageElement(findBy = FindBy.CSS, valueToFind = "table.dataview td:first-child>span>a>span")
	private MCWebElements firstElementOfTable;

	@PageElement(findBy = FindBy.CSS, valueToFind = "table.dataview tr.even a>img[alt='Delete Record'],table.dataview tr.odd a>img[alt='Delete Record']")
	private MCWebElements deleteAddedRecordsIcon;

	private String ERROR_XPATH = ".//div[@class='ketchup-error-container-alt']/ol/li";
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//tr[@class='headers']/th//span")
	private MCWebElements deviceProductionHeaders;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "processAll")
	private MCWebElement processAll;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class='feedbackPanelERROR']")
	private MCWebElement errorMsgPresence;
	
	private static final String DeviceNumber="Device Number";
	
	private static final String REFUND_MESSAGE="//span[contains(text(),'Refund')]";
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//tr[@class!='headers']/td[5]/span")
	private MCWebElement deviceProductionHeaderBatchTxt;
	
	private static final int loopIterationToCheckBatchNumber=21;
	
    @PageElement(findBy = FindBy.CSS, valueToFind = "span.time>label+label")
	protected MCWebElement institutionDateTxt;
    
    @PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value='No']")
	private MCWebElement noBtn;
  
  	@PageElement(findBy = FindBy.X_PATH, valueToFind="//*[@class='sectionHead']/td/../following-sibling::tr[1]/td")
	public MCWebElement responseLbl;
	
    int retryCounter =0;
	
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
	
	protected void clickProcessAllButton() {
		clickWhenClickable(processAll);
	}
	
	protected void clickNoButton(){
		clickWhenClickable(noBtn);
	}

	protected void clickNextButton() {
		WebElementUtils.scrollDown(driver(), 0, 250);
		SimulatorUtilities.wait(500);
		clickWhenClickable(nextBtn);
		SimulatorUtilities.wait(500);
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
	
	public void clickYesButton() {
		clickWhenClickable(yesBtn);
	}

	public void clickSubmitButton() {
		clickWhenClickable(submitButton);
	}

	public void clickConfirmButton() {
		clickWhenClickable(confirmButton);
	}

	public void clickReverseButton(){
		WebElementUtils.scrollDown(driver(), 0, 250);
		clickWhenClickable(reverseBtn);
	}
	
	protected void clickCancelButton() {
		clickWhenClickable(cancelBtn);
	}

	protected void clickCloseButton() {
		WebElementUtils.scrollDown(driver(), 0, 350);
		clickWhenClickable(closeBtn);
	}

	public void clickAddDetailsButton() {
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
	
	protected void selectAllRecords(){
		String count = context.get(CreditConstants.QUANTITY_REQUESTED);
		List<String> devices = new ArrayList<String>();
		
		for(int i = 1; i<=Integer.parseInt(count) ;i++){
			String path = String.format("//table[@class='dataview']/tbody/tr[%d]/td[count(//th/a/span[contains(text(), 'Device Number')]/../../preceding-sibling::th)+1]", i);
			devices.add(Element(path).getText());
		}
		
		for(String dev: devices){
			clickWhenClickable(Element("//*[contains(text(),'"+dev+"')]/..//following-sibling::td/..//input"));
		}
		
		context.put(CreditConstants.DEVICE_NUMBERS,devices);
	}

	protected void clicksearchButtonElement() {
		clickWhenClickable(searchButtonElement);
	}

	public Boolean isNoRecordsFoundInTable() {
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
		String xpath = String.format("//div[@class='tab_container_privileges']//table[@class='dataview']/tbody/tr[%d]/td[count(//th[.//*[text()='%s']]/preceding-sibling::th)+1]", rowNumber,
				columnName);
		return driver().findElement(By.xpath(xpath)).getText().trim();
	}

	public String getCellTextByColumnName(int rowNumber, String columnName) {
		String xpath = String.format("//table[@class='dataview']/tbody/tr[%d]/td[count(//th[.//*[text()='%s']]/preceding-sibling::th)+1]", rowNumber, columnName);
		WebElement element = driver().findElement(By.xpath(xpath));
		waitForElementVisible(element);
		return element.getText().trim();
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
		SimulatorUtilities.wait(3000);
		String xpath = String.format("//h3[contains(text(), '%s')]/ancestor::div//iframe", caption);
		logger.info("runWithinPopup -> xpath: {}", xpath);
		By frameSelector = By.xpath(xpath);
		WebElementUtils.runWithinFrame(driver(), timeoutInSec, frameSelector, action);
	}

	protected void verifyResponseMessage() {
		WebElement responseMessage = new WebDriverWait(driver(), timeoutInSec).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".SuccessMessageTxt")));
		logger.info(RESPONSE_MESSAGE, responseMessage.getText());
	}

	protected void verifyOperationStatus() {
		WebElement successMessageLbl = new WebDriverWait(driver(), timeoutInSec).until(ExpectedConditions.visibilityOfElementLocated(INFO_MESSAGE_LOCATOR));
		logger.info(SUCCESS_MESSAGE, successMessageLbl.getText());
	}

	public boolean verifyRefundMessage() {
		WebElement refundMessage = new WebDriverWait(driver(), timeoutInSec).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(REFUND_MESSAGE)));
		String refundStatus = refundMessage.getText();
		return refundStatus.equalsIgnoreCase(REFUND_SUCCESS);

	}
	
	protected String verifyOperationStatusAndgetJobID() {
		WebElement successMessageLbl = new WebDriverWait(driver(), timeoutInSec).until(ExpectedConditions.visibilityOfElementLocated(INFO_MESSAGE_LOCATOR));
		String successMessage = successMessageLbl.getText();
		int successMessageLength = successMessage.length();
		int jobIdLength = 20;
		context.put("JOB_ID",successMessage.substring(successMessageLength-jobIdLength,successMessageLength));
		logger.info(SUCCESS_MESSAGE, successMessageLbl.getText());
		return successMessage.substring(successMessageLength-jobIdLength,successMessageLength);
	}
	protected boolean waitForRow() {
		try {
			waitForWicket();
			Thread.sleep(30000); // Pre-production batch and device production batch takes little longer hence the wait
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
			return successMessageLbl.getText();
		} catch (NoSuchElementException e) {
			logger.info("No Status is updated");
			logger.debug("Error", e);
			return null;
		}
	}

	protected String getCodeFromInfoMessage(String codeDescription) {
		return driver().findElements(INFO_MESSAGE_LOCATOR).stream().map(WebElement::getText).filter(text -> StringUtils.containsIgnoreCase(text, codeDescription))
				.map(text -> text.replaceAll("\\D+", "")).findFirst().orElseThrow(() -> new ValidationException("Missing code: " + codeDescription));
	}

	protected void verifyErrorMessage() {
		WebElement errorMessageLbl = new WebDriverWait(driver(), timeoutInSec).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.feedbackPanelERROR")));
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
		final String STATUS_NOT_UPDATED = "Status not updated";
		try {
			WebElement errorMessageLbl = new WebDriverWait(driver(), timeoutInSec).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.feedbackPanelERROR")));
			logger.info("Error message : {}", errorMessageLbl.getText());
			return errorMessageLbl.getText();
		} catch (TimeoutException e) {
			logger.warn("Operation Status message {}: ", STATUS_NOT_UPDATED);
			logger.debug("Error message {}: ", e);
			return STATUS_NOT_UPDATED;
		}
	}

	protected void verifyNoErrors() {
		driver().switchTo().defaultContent();
		List<WebElement> messages = driver().findElements(By.cssSelector(".feedbackPanelWARNING, .feedbackPanelERROR, .ketchup-error-container-alt[style*=block]"));
		if (!messages.isEmpty()) {
			String errors = messages.stream().map(WebElement::getText).collect(Collectors.joining("\n"));
			throw new ValidationException(errors);
		}
	}

	/**
	 * Verify already exists and click cancel
	 * @return true if error exists otherwise false
	 */
	protected boolean verifyAlreadyExistsAndClickCancel() {
		String message = getMessageFromFeedbackPanel();
		if (message != null && message.contains("already exist")) {
			clickCancelButton();
			return true;
		}
		return false;
	}
	
	protected boolean verifyAlreadyExists() {
		SimulatorUtilities.wait(3000);
		String message = getMessageFromFeedbackPanel();
		if (message != null && message.contains("already exist")) {
			return true;
		}
		return false;
	}

	protected boolean verifyDuplicateAndClickCancel() {
		String message = getMessageFromFeedbackPanel();
		if (message != null
				&& (message.contains("Effective Date and End Date should not overlap for same Country") || 
						message.contains("Error in Insertion/Save") || 
						message.contains("Effective Date and End Date should not overlap for same MCG") ||
						message.contains("Business Calendar setup already exists for logged in Institution for same Effective Date"))) {
			clickCancelButton();
			return true;
		}
		return false;
	}

	// fetching any message that may appear in the Label Panel
	public String getMessageFromFeedbackPanel() {
		List<WebElement> messages = driver().findElements(By.cssSelector(".feedbackPanel li"));

		if (messages.isEmpty()) {
			return null;
		}
		String generatedMessage = messages.stream().map(WebElement::getText).collect(Collectors.joining("\n"));
		logger.info("Message : {} ", generatedMessage);
		return generatedMessage;
	}

	public String getFeedbackPanelInfoMessage() {
		By by = By.cssSelector(".feedbackPanelINFO");
		String message = new WebDriverWait(driver(), timeoutInSec).until(ExpectedConditions.visibilityOfElementLocated(by)).getText();
		return message;
	}

	protected void clickWhenClickable(MCWebElement element) {
		new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.elementToBeClickable(element)).click();
        logger.info("Button clicked successfully.");
	}
	
	protected void clickWhenClickablewithWicket(MCWebElement element) {
		SimulatorUtilities.wait(4000);
		new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.elementToBeClickable(element)).click();
		waitForWicket();
	}

	protected void clickWhenClickableDoNotWaitForWicket(MCWebElement element) {
		new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.elementToBeClickable(element)).click();
	}

	protected void verifyRecordMarkedForUpdationStatusWarning() {
		WebElement warningMessageLbl = new WebDriverWait(driver(), timeoutInSec).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.feedbackPanelWARNING")));
		logger.info("Warning message: {}", warningMessageLbl.getText());
	}

	protected void verifyRecordMarkedForUpdationStatusSuccess() {
		WebElement successMessageLbl = new WebDriverWait(driver(), timeoutInSec).until(ExpectedConditions.visibilityOfElementLocated(INFO_MESSAGE_LOCATOR));
		logger.info(SUCCESS_MESSAGE, successMessageLbl.getText());
	}

	protected void verifyOnAgentPortal() {
		WebElement userName = new WebDriverWait(driver(), timeoutInSec).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='credentials']//label")));
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
		WebElement successMessageLbl = new WebDriverWait(driver(), timeoutInSec).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.feedbackPanelINFO")));
		String batchNumber = successMessageLbl.getText().replaceAll("\\D+", "");
		logger.info("batch number: {}", batchNumber);
		return batchNumber;
	}

	protected void waitForWicket() {
		WebElementUtils.waitForWicket(driver());
	}

	// created a re-usable method that could be used in
	// waitAndSearchForRecordToExist() below
	// the same code can be used in Authorization Search Page
	public void waitAndSearchForRecordToAppear() {
		clickSearchButton();
		// Pre-production batch and device production batch & Authorization
		// Search page take little long to
		// be completed, and do not appear in search result, hence a for loop
		for (int l = 0; l < loopIterationToCheckBatchNumber; l++) {
			if (!waitForRow())
				clickSearchButton();
			else {
				break;
			}
		}
	}
	
	public void waitAndSearchForApplicationBatchNumberToAppear() {
		clickSearchButton();
		// Pre-production batch and device production batch & Authorization Search page take little long to
				// be completed, and do not appear in search result, hence a for loop
		for (int l = 0; l < 21; l++) {
			if (!waitForbatchNumber())
				clickSearchButton();
			else {
				break;
			}
		}
	}
	
	protected boolean waitForbatchNumber() {
		try {
			waitForWicket();
			SimulatorUtilities.wait(20000); 
			return asWebElement(deviceProductionHeaderBatchTxt).isDisplayed();
		} catch (Exception e) {
			logger.debug("Result not found", e);
			return false;
		}
	}

	protected void waitAndSearchForRecordToExist() {
		waitAndSearchForRecordToAppear();
		context.put(CreditConstants.EXISTING_DEVICE_NUMBER, deviceNumberFetch.getText());
		context.put(CreditConstants.DEVICE_NUMBER, deviceNumberFetch.getText());
		selectFirstRecord();
		clickProcessSelectedButton();		
	}	
	
	protected void waitAndSearchForRecordToExists() {
		waitAndSearchForRecordToAppear();
		String count = context.get(CreditConstants.QUANTITY_REQUESTED);
		if(Integer.parseInt(count) > 1){			
			selectAllRecords();			
		}else{
			context.put(CreditConstants.DEVICE_NUMBER, deviceNumberFetch.getText());
			selectFirstRecord();
		}
		clickProcessSelectedButton();
	}
	
	protected void waitAndSearchForRecordToExistForSupplementary() {
		waitAndSearchForRecordToAppear();
		deviceNumbersForSupplementary();
		clickProcessAllButton();
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
		Assert.assertTrue("Error Message -  Button Label - Expected Result : " + buttonLabel + ACTUAL_RESULT_LABEL + searchButtonElement.getText(), buttonLabel.contains(searchButtonElement.getText()));
		logger.info(RESPONSE_MESSAGE, searchButtonElement.getText());
	}

	protected void verifyPopup(String popupName) {
		new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(popupNameElement));
		Assert.assertTrue("Error Message - Popup Name - Expecting Result : " + popupName + ACTUAL_RESULT_LABEL + popupNameElement.getText(), popupName.contains(popupNameElement.getText()));
		logger.info(RESPONSE_MESSAGE, popupNameElement.getText());
	}

	protected void acceptPopup() {
		Alert alert = driver().switchTo().alert();
		boolean isAlertPresent = alert != null;
		if (isAlertPresent) {
			alert.accept();
		}
	}
	
	public boolean isAlertPresent() {
		try {
			Alert alert = driver().switchTo().alert();
			alert.accept();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	protected void verifyDeleteRecordAlert(String expectedAlertText) {
		Alert alert = driver().switchTo().alert();
		String actualAlertText = null;
		boolean isAlertPresent = alert != null;
		if (isAlertPresent) {
			actualAlertText = alert.getText();
			Assert.assertTrue("Error Message - Delete Alert - Expected Result : " + expectedAlertText + ACTUAL_RESULT_LABEL + actualAlertText, actualAlertText.contains(expectedAlertText));
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
				verifyDeleteRecordAlert(name.replaceAll("Add.*", "Are you sure you want to delete the highlighted record?"));
			}
		}
	}

	protected void verifyHomePageCollectPortal(String text) {

		if ("home".equalsIgnoreCase(text))
			Assert.assertTrue("Error Message - Expected Result : " + text + ACTUAL_RESULT_LABEL + heading.getText(), heading.getText().contains(text));
		else {
			Assert.assertTrue("Error Message - Expected Result : Welcome to " + text + ACTUAL_RESULT_LABEL + paragraph.getText(), paragraph.getText().contains("Welcome to " + text));
			Assert.assertTrue("Error Message - Expected Result : " + text + ACTUAL_RESULT_LABEL + heading.getText(), heading.getText().contains(text));
		}
	}

	protected void verifyDeviceDetails() {
		boolean deviceNumberLength = deviceNumber.getText().trim().length() > 0;
		Assert.assertTrue("Error Message - Device Number Length - Expected Result : Length Greater Than Zero | Actual Result : " + deviceNumber.getText().trim().length(), deviceNumberLength);
	}

	protected void verifyWalletDetails() {
		boolean walletNumberLength = walletNumber.getText().trim().length() > 0;
		Assert.assertTrue("Error Message - Wallet Number Length - Expected Result : Length Greater Than Zero | Actual Result : " + walletNumber.getText().trim().length(), walletNumberLength);
	}

	public String getMasterDetailContentTitle() {
		return new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(masterDetailContentTitle)).getText();
	}

	protected void verifyTitleCardHolderPortal(String text) {
		Assert.assertTrue("Error Message - Title of Cradholder Portal - Expected Result : " + text + ACTUAL_RESULT_LABEL + getMasterDetailContentTitle().trim(), getMasterDetailContentTitle().trim()
				.contains(text));
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
		Assert.assertTrue("Error Message - Contanct Information Not Present - Expected Result : Contact Information | Actual Result : " + contactInformation.getText(),
				CONTACT_INFORMATION_EXPECTED.equals(contactInformation.getText()));
	}

	protected String getDate() {
		return getFirstColumnValueFromTable().substring(0, 8);
	}

	public void enterValueinTextBox(MCWebElement txtBoxElement, String value) {
		waitForElementVisible(txtBoxElement);
		if (txtBoxElement.isEnabled()) {
			if (value != null && !value.isEmpty()) {
				enterText(txtBoxElement, value);
			}
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

	public boolean waitforElement(MCWebElement ele) {
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
			logger.error("Element is visible");
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
			waitForElement.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(Element("//img[contains(@src,'loading')]"))));
			logger.info("Loader is present");
			return true;
		} catch (Exception e) {
			logger.error("Loader is not present ");
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
				logger.info(EXCEPTION_MESSAGE, ser.getMessage());
				unfound = true;
			} catch (NoSuchElementException nse) {
				logger.info(EXCEPTION_MESSAGE, nse.getMessage());
				unfound = true;
			} catch (Exception e) {
				logger.info(EXCEPTION_MESSAGE, e.getMessage());
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

	public void doSelectByVisibleText(MCWebElement ele, String optionName) {
		String optionalVisibleText = "";
		waitUntilSelectOptionsPopulated(ele);
		List<WebElement> selectedOptions = new Select(asWebElement(ele)).getOptions();
		for (WebElement element : selectedOptions) {
			if (element.getText().toUpperCase().contains(optionName.toUpperCase())) {
				optionalVisibleText = element.getText();
				break;
			}
		}
		ele.getSelect().selectByVisibleText(optionalVisibleText);
	}

	public void selectByVisibleText(MCWebElement ele, String optionName) {
		try {
			doSelectByVisibleText(ele, optionName);
		waitForLoaderToDisappear();
		waitForPageToLoad(driver());
		} catch (StaleElementReferenceException e) {
			doSelectByVisibleText(ele, optionName);
	}
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
	
	protected String verifyReportDownloaded(String reportName) {
		StringBuffer path= new StringBuffer();
		WebDriverWait wait = new WebDriverWait(driver(), TIMEOUT);
		wait.until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				Boolean exists = false;
				for (File file: new File(PDFUtils.getuserDownloadPath()).listFiles()) {
				 if(file.isFile()&& file.getName().startsWith(reportName)&&FilenameUtils.getExtension(file.getName()).equalsIgnoreCase("pdf")){
					exists = true;
				    path.append(file.getAbsolutePath());
				    logger.info("File Path:"+path.toString());
					 break;
				 }
			}
				return exists;
			}
		});
		return path.toString();
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
		SimulatorUtilities.wait(900);
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
		By frameSelector = By.xpath(String.format("//h3[contains(text(), '%s')]/ancestor::div//iframe[@class='wicket_modal']", caption));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameSelector));
	}

	// Switch to a frame by specificying the index in WebPage.
	public void switchToIframeByIndex(int frameIndex) {
		WebDriverWait wait = new WebDriverWait(getFinder().getWebDriver(), 80);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}

	public static void addWicketAjaxListeners(WebDriver driver) {
		String javascript = "if (typeof tk  == 'undefined') {" + "tk = {activeAjaxCount: 0, ajaxCallsTried: 0, ajaxCallsCompleted: 0};"
				+ "Wicket.Ajax.registerPreCallHandler(function(){tk.activeAjaxCount++;tk.ajaxCallsTried++;});"
				+ "Wicket.Ajax.registerPostCallHandler(function(){tk.activeAjaxCount--;tk.ajaxCallsCompleted++;});}";
		executeJavascript(driver, javascript);
	}

	public void waitForPageToLoad(WebDriver driver) {
		String pageLoadStatus;
		do {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			pageLoadStatus = (String) js.executeScript("return document.readyState");

		} while (!pageLoadStatus.equals("complete"));

		logger.info("Page Loaded.");
	}

	public static <R> R fluentWait(Supplier<R> condition) {
		return new FluentWait<Object>(new Object()).ignoring(WebDriverException.class).withTimeout(TIMEOUT, TimeUnit.SECONDS).until((com.google.common.base.Function<Object, R>) o -> condition.get());
	}

	public static void retryUntilNoErrors(Runnable action) {
		fluentWait(() -> {
			action.run();
			return true;
		});
	}

	public void switchToDefaultFrame() {
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

	public void selectDropDownByText(MCWebElement element, String value) {
		element.getSelect().selectByVisibleText(value);
		// element.getSelect().selectByValue(value);
		// addWicketAjaxListeners(getFinder().getWebDriver());
	}

	public void selectDropDownByIndex(MCWebElement element, int value) {
		if (element.isEnabled()) {
			element.getSelect().selectByIndex(value);
		} else {

		}
		// addWicketAjaxListeners(getFinder().getWebDriver());
	}

	public void ClickButton(MCWebElement BtnName) {
		WebElementUtils.scrollDown(driver(), 0, 250);
		BtnName.click();
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
			errorFields.add("Error on page" + "::::::" + getChildElement(Elements(ERRORPANEL).get(0), "//span").getText());
		}
		if (iselementPresent(Elements(pageValidationCheck))) {
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

	public void switchToWindowCHP() {
		try {
			Set<String> handles;
			handles = getFinder().getWebDriver().getWindowHandles();
			for (String handle : handles) {
				if (!handle.equals(getFinder().getWebDriver().getWindowHandle()))
					getFinder().getWebDriver().switchTo().window(handle);
			}

			acceptPopup();

		} catch (Exception e) {
			logger.error("Unable to Switch Window --> {} ", e);
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

	public Map<String, String> pageErrorValidator(String ERRORPANEL) {
		Map<String, String> errorFields = new HashMap<String, String>();
		String errorMessage;
		String elementName;
		if (iselementPresent(Elements(pageValidationCheck))) {
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

	public void enterText(WebElement field, String fieldValue) {
		logger.info("Entering text for field: {} ", fieldValue);
		waitForElementVisible(field);
		field.clear();
		field.sendKeys(fieldValue);
	}

	public String buildDescriptionAndCode(String Name, String code) {
		return String.format("%s [%s]", Name, code);
	}

	public List<String> getListOfElements(String ele) {
		List<WebElement> list = driver().findElements(By.xpath(ele));
		List<String> elementTextData = new ArrayList<String>();

		for (WebElement e : list) {
			elementTextData.add(e.getText());
		}
		return elementTextData;
	}

	public void waitForElementEnabled(MCWebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(getFinder().getWebDriver(), 20, ELEMENT_WAIT_MAX);
			wait.until((ExpectedCondition<Boolean>) driver -> element.isEnabled());
		} catch (Exception e) {
			logger.error(e + " : " + "Timed out waiting for element: " + element);
		}
	}

	public void saveOrDetailsOrSearchClick() {
		clickWhenClickable(saveOrDetailsOrSearchBtn);
	}

	public List<String> mandatoryLabels() {

		LinkedList<String> mandatoryFieldsLabels = new LinkedList<>();
		for (int i = 0; i < allLabelsMandatoryField.getElements().size(); i++) {
			mandatoryFieldsLabels.add(allLabelsMandatoryField.getElements().get(i).getText());

		}
		return mandatoryFieldsLabels;
	}

	public List<MCWebElement> mandatoryFields() {

		List<MCWebElement> mandatoryField = new LinkedList<>();
		for (int i = 0; i < mandatoryValues.getElements().size(); i++) {
			mandatoryField.add(mandatoryValues.getElements().get(i));

		}
		return mandatoryField;
	}

	public Map<String, String> mandatoryValuesWithLabels(List<MCWebElement> fields, List<String> labels) {
		Map<String, String> mandatoryLabelsAndValues = new LinkedHashMap<>();
		List<MCWebElement> mandateFields = fields;
		List<String> mandatoryFieldsLabels = labels;
		if (mandateFields.size() == mandatoryFieldsLabels.size()) {
			for (int i = 0; i < mandatoryFieldsLabels.size(); i++) {
				if (mandateFields.get(i).getTagName().equals("input")) {
					String[] field = mandatoryFieldsLabels.get(i).split(":");
					mandatoryLabelsAndValues.put(field[0].trim(), mandateFields.get(i).getAttribute("value"));

				} else if (mandateFields.get(i).getTagName().equals("select")) {
					String[] field = mandatoryFieldsLabels.get(i).split(":");
					mandatoryLabelsAndValues.put(field[0].trim(), mandateFields.get(i).options().getElements().get(1).getText());
				}
			}

		}
		return mandatoryLabelsAndValues;
	}

	public void searchFunctionalityCheck() {
		LinkedList<MCWebElement> linkList = new LinkedList<>();
		LinkedList<MCWebElement> linkListHeaders = new LinkedList<>();
		for (int i = 0; i < commonXpathForFilter.getElements().size(); i++) {
			linkList.add(commonXpathForFilter.getElements().get(i));
		}
		for (int i = 0; i < filterHeaders.getElements().size(); i++) {
			linkListHeaders.add(filterHeaders.getElements().get(i));
		}
		for (Map.Entry<String, String> entry : creditCardPlans.getMandatoryValuesWithLabels().entrySet()) {
			for (int i = 0; i < linkListHeaders.size(); i++) {
				if (linkListHeaders.get(i).getText().equals(entry.getKey())) {
					if (linkList.get(i).getTagName().equals("input")) {
						WebElementUtils.enterText(linkList.get(i), entry.getValue());
						break;
					} else if (linkList.get(i).getTagName().equals("select")) {
						WebElementUtils.selectDropDownByVisibleText(linkList.get(i), entry.getValue());
						break;
					}
				}
			}

		}
		clickWhenClickable(searchBtn);
		logger.info("Row values after search: {}", tableRows.getText());
		Assert.assertEquals("Added Record is displayed based on filter Values", firstRow.getElements().size(), 1);

	}

	public void editFunctionalityCheck() {
		LinkedList<MCWebElement> linkListDescription = new LinkedList<>();
		switchToFirstFrame();
		allDescriptionFieldsInFrame(linkListDescription);
		if (!linkListDescription.get(0).getTagName().equals("span")) {
			String updatedValue = editDescriptionValueInFirstFrame(linkListDescription);
			searchEditedValueOfFirstFrame();
			verifyIfValueIsEditedOfFirstFrame(updatedValue);
		} else {

			String updatedValue = editingInnerFrameValue();
			verifyEditingOfInnerFrame(updatedValue);
			clickSaveButton();
			waitForPageToLoad(getFinder().getWebDriver());

		}

	}

	public void verifyEditingOfInnerFrame(String updatedValue) {
		for (int i = 0; i < tableHeaders.getElements().size(); i++) {
			if (tableHeaders.getElements().get(i).getText().contains("Description")) {
				logger.info("EditedDescription: {}", firstRowColumnValues.getElements().get(i).getText());
				logger.info("Added Record is displayed based on filters in innerframe" + firstRowColumnValues.getElements().get(i).getText(), updatedValue);
				Assert.assertEquals("Added Record is displayed based on filters in innerframe", firstRowColumnValues.getElements().get(i).getText(), updatedValue);
			}
		}
	}

	public String editingInnerFrameValue() {
		clickWhenClickable(editRecord.getElements().get(editSize() - 1));
		switchToDefaultFrame();
		switchToIframe("Plan Detail");
		WebElementUtils.enterText(innerDescriptionTxt, "");
		WebElementUtils.enterText(innerDescriptionTxt, CustomUtils.randomNumbers(5));
		String updatedValue = innerDescriptionTxt.getAttribute("value");
		clickSaveButton();
		switchToIframe(frameSwitch.getElements().get(frames() - 1).getText());
		return updatedValue;
	}

	private void verifyIfValueIsEditedOfFirstFrame(String updatedValue) {
		for (int i = 0; i < tableHeaders.getElements().size(); i++) {
			if (tableHeaders.getElements().get(i).getText().equals("Description")) {
				logger.info("EditedDescription: {}", firstRowColumnValues.getElements().get(i).getText());
				logger.info("Added Record is displayed based on filters" + firstRowColumnValues.getElements().get(i).getText(), updatedValue);
				Assert.assertEquals("Added Record is displayed based on filters", firstRowColumnValues.getElements().get(i).getText(), updatedValue);
			}
		}
	}

	public void searchEditedValueOfFirstFrame() {
		WebElementUtils.enterText(descriptionFilterTxt, "");
		clickSearchButton();
	}

	public String editDescriptionValueInFirstFrame(LinkedList<MCWebElement> linkListDescription) {
		WebElementUtils.enterText(linkListDescription.get(0), "");
		WebElementUtils.enterText(linkListDescription.get(0), CustomUtils.randomAlphaNumeric(5));
		String updatedValue = linkListDescription.get(0).getAttribute("value");
		clickSaveButton();
		return updatedValue;
	}

	public void allDescriptionFieldsInFrame(LinkedList<MCWebElement> linkListDescription) {
		for (int i = 0; i < descriptionTxt.getElements().size(); i++) {
			linkListDescription.add(descriptionTxt.getElements().get(i));
		}
	}

	public void switchToFirstFrame() {
		clickWhenClickable(editRecord.getElements().get(editSize() - 1));
		switchToIframe(frameSwitch.getElements().get(frames() - 1).getText());
	}

	public void deleteFunctionalityCheck() {
		if (isDeleteColumnPresent()) {
			waitForPageToLoad(getFinder().getWebDriver());
			deleteFirstRecord();
			Alert alert = driver().switchTo().alert();
			alert.accept();
			clickWhenClickable(searchBtn);
			logger.info("Row size after deletion: {}", tableRows.getText());
			Assert.assertEquals("Added Record is deleted", tableRows.getText(), "");
		}
	}

	public int editSize() {
		return editRecord.getElements().size();
	}

	public int frames() {
		frameSwitch.getElements();
		return frameSwitch.getElements().size();
	}

	public void clickSaveButtonWithOutWicket() {
		WebElementUtils.scrollDown(driver(), 0, 250);
		clickWhenClickableDoNotWaitForWicket(saveBtn);
	}

	public boolean errorMessagePresence() {
		try {
			if (errorMsgPresence.isVisible()) {
				return true;
			}

		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}

	public void identifyAddedRecordinTableAndDelete(String parameter) {
		for (int i = 0; i < firstElementOfTable.getElements().size(); i++) {
			if (firstElementOfTable.getElements().get(i).getText().equals(parameter)) {
				clickWhenClickable(deleteAddedRecordsIcon.getElements().get(i));
			}
		}
	}
	
	
	private void deviceNumberContextDeviceProduction() {
		context.put(CreditConstants.DEVICE_NUMBER, deviceNumberFetch.getText());		
		Device device  = context.get(CreditConstants.APPLICATION);
		device.setDeviceNumber(context.get(CreditConstants.DEVICE_NUMBER));
	}
	
	public int getDeviceNumberIndex()
	{  
		int index=0;
		for(int i=0;i<deviceProductionHeaders.getElements().size();i++)
		{
			if(deviceProductionHeaders.getElements().get(i).getText().equalsIgnoreCase(DeviceNumber))
			{
				index=i+1;
			}
		}
		return index;
	}
	
	public List<String> deviceNumbersForSupplementary()
	{
		List<String> allDeviceNumbers=new ArrayList<>();
		List<WebElement>deviceNumbers=driver().findElements(By.xpath("//table[@class='dataview']//tr[@class!='headers']/td["+getDeviceNumberIndex()+"]/span"));
		for(int i=0;i<deviceNumbers.size();i++)
		{
			allDeviceNumbers.add(deviceNumbers.get(i).getText());
		}
		context.put(CreditConstants.SUPPLEMENTARY_DEVICE_NUMBER, allDeviceNumbers);
		return allDeviceNumbers;
	}
	
	public void searchEntity(String entityType) {
		UserCreation userCreation = context.get(ContextConstants.USER);
		if ("user".equalsIgnoreCase(entityType))
			selectByVisibleText(entityTypeDdwn, ENTITY_TYPE_USER);
		else if ("role".equalsIgnoreCase(entityType))
			selectByVisibleText(entityTypeDdwn, ENTITY_TYPE_ROLE);
		CustomUtils.ThreadDotSleep(900);
		Select select = new Select(getFinder().getWebDriver().findElement(ENTITY_ID));
		CustomUtils.ThreadDotSleep(500);
		select.selectByVisibleText(userCreation.getUserName() + " [" + userCreation.getUserID() + "]");
		ClickButton(searchBtn);
	}

	public void selectTab(String tabName) {
		getFinder().getWebDriver().findElement(By.xpath(String.format(PRIVILEGES_TABS, tabName))).click();
	}

	/**
	 * Select institute from top drp dwn.
	 *
	 * @param instituteName
	 *            the institute name
	 */
	public void selectInstituteFromDrpDwn(String instituteName) {
		instituteSelectionDrpDwn.click();
		CustomUtils.ThreadDotSleep(500);
		String ins = String.format(instituteSelectionVal, instituteName);
		CustomUtils.ThreadDotSleep(500);
		getFinder().getWebDriver().findElement(By.xpath(ins)).click();
	}

	public void deleteExistingRecord(String parameter) {
		for (int i = 0; i < firstElementOfTable.getElements().size(); i++) {
			if (firstElementOfTable.getElements().get(i).getText().equals(parameter)) {
				deleteAddedRecordsIcon.getElements().get(i).click();
				acceptPopup();
			}
		}
	}

	public List<WebElement> getValidationErrors() {
		return Elements(ERROR_XPATH);
	}
	
	public void moveToElementAndClick(MCWebElement element,int xOffset, int yOffset){
		Actions action = new Actions(driver());		
		action.moveToElement(asWebElement(element), xOffset, yOffset).click().build().perform();
	}
	
	
	public void ifTextAvailableinTableThenDelete(MCWebElement tableHandle, String text) {
		WebElement table = asWebElement(tableHandle);
		List<WebElement> rowstable = table.findElements(By.tagName("tr"));
		int rowscount = rowstable.size();
		outerloop: for (int row = 0; row < rowscount; row++) {
			List<WebElement> columnsrow = rowstable.get(row).findElements(By.tagName("td"));
			int columnscount = columnsrow.size();
			for (int col = 0; col < columnscount; col++) {
				if (columnsrow.get(col).getText().equals(text)) {
					List<WebElement> editAndDeleteIcon = rowstable.get(row).findElements(By.tagName("img"));
					for (int icon = 0; icon < editAndDeleteIcon.size(); icon++) {
						if (editAndDeleteIcon.get(icon).getAttribute("alt").contains("Delete")) {
							editAndDeleteIcon.get(icon).click();
							SimulatorUtilities.wait(2000);
							Alert alert = driver().switchTo().alert();
							alert.accept();
							break outerloop;
						}
					}
				}
			}
		}
	}
	
	public void clickOncheckBoxIfBatchAvailableinTable(MCWebElement tableHandle, String text) {
		WebElement table = asWebElement(tableHandle);
		List<WebElement> rowstable = table.findElements(By.tagName("tr"));
		int rowscount = rowstable.size();
		for (int row = 1; row < rowscount; row++) {
			List<WebElement> columnsrow = rowstable.get(row).findElements(By.tagName("td"));
			int columnscount = columnsrow.size();
			for (int col = 0; col < columnscount; col++) {
				if (columnsrow.get(col).getText().equals(text)) {
					WebElement checkBox = columnsrow.get(columnscount - 1).findElement(By.cssSelector("input[type=checkbox]"));
					if (checkBox.isEnabled() && !checkBox.isSelected()) {
						checkBox.click();
						break;
					}
				}
			}
		}
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		logger.info("Not validaiting any elements, as this is an Abstraction layer to Pages");
		return null;
	}
	
	public void switchToDefaultFrame(String element,int index) {
		driver().switchTo().frame(Elements(element).get(index));
	}
	
	public String getInstitutionDate(){	
		logger.info("Institution date : {}",getTextFromPage(institutionDateTxt));
		return getTextFromPage(institutionDateTxt);
	}
	
	protected void waitForContentToLoad(MCWebElement element){
		waitForWicket();
		SimulatorUtilities.wait(5000);
		while(retryCounter < 4){
			
			if(element.getTagName().contains("input")){
				if(element.getText().equals("-") || element.getText().isEmpty() || element.getText().equals("0")){
					SimulatorUtilities.wait(3000);
					retryCounter++;
					waitForContentToLoad(element);
				}
			}else if(element.getTagName().contains("select")){
				Select options = new Select(asWebElement(element));
				if(options.getOptions().size() < 1){
					retryCounter++;
					waitForContentToLoad(element);	
				}
			}else if(element.getText().equals("-") || element.getText().isEmpty() || element.getText().equals("0")){
				SimulatorUtilities.wait(3000);
				retryCounter++;
				waitForContentToLoad(element);
			}else{
				break;
			}
		}
	}	

	protected void waitForBatchStatus(MCWebElement ele) {
		try {
			WebElementUtils.waitForWicket(driver());
			for (int l = 0; l < 21; l++) {
				while ("PENDING [0]".equalsIgnoreCase(ele.getText())
						|| "IN PROCESS [1]".equalsIgnoreCase(ele.getText())) {
					Thread.sleep(10000); // waiting for page auto refresh
					clickSearchButton();
				}
			}

		} catch (NoSuchElementException | InterruptedException e) {
			logger.info("Failed at batch status: ", e);
		}
	}
	public String getFirstRowColValueFor(int col) {
		return firstRowColumnValues.getElements().get(col).getText();
	}
	
	public void findByLabelAndEnterValueInElement(String label,String value){
		String webElements = "*:not([style='display: none;'])>input:not(.btn_or_sbt), *:not([style='display: none;'])>select,input[type='checkbox'],.labeltextf";
	    
	    String webElementLabel = ".displayName";
	    
		MCWebElements fieldType = getFinder().findMany(FindBy.CSS,webElements);
        List<String> fieldLabel = new ArrayList<>();
        List<MCWebElement> labelElement = getFinder().findMany(FindBy.CSS,webElementLabel).getElements();
        labelElement.forEach(element->fieldLabel.add(element.getText()));
        int index = fieldLabel.indexOf(label);
        if(index!=-1){
        	String tagName =  fieldType.getElements().get(index).getTagName();
        	switch(tagName){
        	case "input" :
        		enterValueinTextBox(fieldType.getElements().get(index),value);
        		break;
        	case "select" :
        		selectByVisibleText(fieldType.getElements().get(index), value);
        		break;
        	default:
        		throw new ElementNotFoundException("Element with tag "+tagName+" not found!");
        	}
        		
        } else {
        	throw new ElementNotFoundException("Element with label " + label + " not found!");
        }       
   }
	
	public String getPlanCode(String descriptionAndCode){
		String planCode = "";
		Pattern pattern = Pattern.compile("\\[(.*?)\\]");
		Matcher match = pattern.matcher(descriptionAndCode);
		while (match.find()) {
	           planCode = match.group(1);
	        }
		return planCode;
	}
}
