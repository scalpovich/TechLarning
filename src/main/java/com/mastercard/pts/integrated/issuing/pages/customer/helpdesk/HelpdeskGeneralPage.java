package com.mastercard.pts.integrated.issuing.pages.customer.helpdesk;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.common.base.CharMatcher;
import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.DeviceStatus;
import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.agent.transactions.CardToCash;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.LoanDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.LoanPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Payment;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionSearchDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.helpdesk.HelpdeskGeneral;
import com.mastercard.pts.integrated.issuing.domain.restapi.DeviceDetails;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.MCWebElements;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = HelpdeskNav.TAB_HELPDESK, treeMenuItems = { HelpdeskNav.L1_ACTIVITY, HelpdeskNav.L2_GENERAL })
public class HelpdeskGeneralPage extends AbstractBasePage {
	private static final String TABLE_XPATH = "//div[@class='TransScrollY']//table[@class='dataview']//tr";
	private static final String OPERATION="//select[@name='udf1:input:dropdowncomponent']";
	private static final String ROWCOUNT_REMITTANCE = "//div[@class='tab_container_privileges']//table[@class='dataview']/tbody/tr";
	private static final String COLUMN_STATUS = "Status";
	private static final String CURRENT_AVAILABLE_BALANCE = "Current Available Balance";
	private static final String WALLET_NUMBER = "Wallet Number";
	private static final String REGISTERED = "registered";
	private static final String NOT_REGISTERED = "notregistered";	
	private static final String NOTE_WALLET_FUND_TRANSFER = "Notes for Wallet to Wallet transfer";
	private static final String SERV_CODE_TRANSACTION_PASSWORD = "250";
	private static final String CHANGE_REGISTERED_EMAIL_ID = "Change Registered Email Id Request";
	private static final String CHANGE_REGISTERED_MOBILE_NO = "Change Registered Mobile Number Request";
	private static final String SERV_CODE_LOGIN_PASSWORD = "459";
	private static final String LABEL_LOGIN_PASSWORD = "459 - Reset Cardholder Login Password";
	private static final String LABEL_TRANSACTION_PASSWORD = "250 - Reset Cardholder Transaction Password";
	private static final String ERROR_MESSAGE_XPATH = "//div[@class='ketchup-error-container-alt']//li";
	private static final String CALL_REFERENCE_NUMBER = "Call Reference Number:";
	private static final String SERVICE_DESCRIPTION = "Service Description:";
	private static final String DEVICE_NUMBER = "Device Number:";
	private static final String REQUEST_DATE = "Request Date:";
	private static final String CLOSURE_DATE = "Closure Date:";
	private static final String LOGGED_BY = "Logged By:";
	private static final String CLOSURE_PERIOD = "Estimated Closure Period(Days:HH:MM):";
	private static final String PRIORITY_REQUEST = "Priority Request:";
	
	private static final String BLOCK_DEVICE_TITLE = "111 - Block Device";
	private static final String DEVICE_CLOSURE_TITLE = "402 - Device Closure";

	private static String ERROR_MESSAGE = "This field is required.";
	private static final String GENERAL_ELEMENT_XPATH = "//h3[@class='w_captionText'][text()='General']";

	private static final Logger logger = LoggerFactory.getLogger(HelpdeskGeneralPage.class);
	private String activeDeviceNumber;
	private String saleDate;
	private String activationDate;
	private String deliveryDate;
	private String firstRow;
	private String status;
	private String[] values;
	private String walletBalanceInformation;
	public boolean serviceStatus = false;
	private Map<String,String> points;

	@Value("${default.wait.timeout_in_sec}")
	private long timeoutInSec;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[text()='Product Type']/following-sibling::td[2]/select")
	private MCWebElement productTypeSearchDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='device.deviceNumber']")
	private MCWebElement deviceNumberSearchTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='device.cardPackId']")
	private MCWebElement cardPackIdTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "helpdeskDetailContainer:serviceCode:input:dropdowncomponent")
	private MCWebElement serviceCodeDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "helpdeskDetailContainer:go")
	private MCWebElement goBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#saleDate")
	private MCWebElement saleDateTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#activationDate")
	private MCWebElement activationDateTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#deliveryDate")
	private MCWebElement deliveryDateTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "memo1:input:textAreaComponent")
	private MCWebElement notesTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value= 'Save']")
	private MCWebElement saveBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name='udf4:input:inputTextField']")
	private MCWebElement timeInHourTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = ".feedbackPanelINFO")
	private MCWebElement activationMessage;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value = 'OK']")
	private MCWebElement okBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value = 'Cancel']")
	private MCWebElement cancelBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = ".dataview tbody img[alt='Edit Record']")
	private MCWebElement firstRowEditLink;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value = 'End Call']")
	private MCWebElement endCallBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = ".dataview tbody a img")
	private MCWebElement editDeviceLink;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value = 'Transactions']")
	private MCWebElement transactionsBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='From Date :']/../following-sibling::td[1]/span/span/span")
	private MCWebElement effectiveDateTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='To Date :']/../following-sibling::td[1]/span/span/span")
	private MCWebElement endDateTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//tr[2]//td[2]//div[@class='radioInput']/input[1]")
	private MCWebElement activateRBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//tr[2]//td[2]//div[@class='radioInput']/input[2]")
	private MCWebElement deactivateRBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//tr[2]//td[4]//div[@class='radioInput']/input[1]")
	private MCWebElement lifeLongActivationRBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//tr[2]//td[4]//div[@class='radioInput']/input[2]")
	private MCWebElement immediateActivationForNHoursRBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//tr[2]//td[4]//div[@class='radioInput']/input[3]")
	private MCWebElement activationInPeriodRBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "udf24:input:inputTextField")
	private MCWebElement timeInHoursTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = ".yui-skin-sam")
	private MCWebElement fromDateDPkr;

	@PageElement(findBy = FindBy.CSS, valueToFind = ".yui-skin-sam")
	private MCWebElement toDateDPkr;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[text()[contains(.,'Wallet Details')]]")
	private MCWebElement walletDetailsLnk;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[text()[contains(.,'Device Details')]]")
	private MCWebElement deviceDetailsLnk;

	@PageElement(findBy = FindBy.NAME, valueToFind = "udf9:input:inputAmountField")
	private MCWebElement debitAmtInpt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "memo1:input:textAreaComponent")
	private MCWebElement transactionNotesInpt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "udf20:input:dropdowncomponent")
	private MCWebElement toDeviceDropDn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class='feedbackPanelINFO']")
	private MCWebElement walletToWalletConfirMsg;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:3:componentList:0:componentPanel:input:inputTextField")
	private MCWebElement clientIDInpt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "udf21:input:inputTextField")
	private MCWebElement emailIDInptTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "udf24:input:inputTextField")
	private MCWebElement mobileInptTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "udf23:input:dropdowncomponent")
	private MCWebElement isdCodeDdwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//ul[@class='feedbackPanel']/.//span")
	private MCWebElement responseMessage;

	@PageElement(findBy = FindBy.CSS, valueToFind = "span#callReferenceNumber>span")
	private MCWebElement callReferenceNumberLbl;

	@PageElement(findBy = FindBy.CSS, valueToFind = "span#serviceCode>span")
	private MCWebElement serviceDescriptionLbl;

	@PageElement(findBy = FindBy.CSS, valueToFind = "span#cardNumberID>span")
	private MCWebElement deviceNumberLbl;

	@PageElement(findBy = FindBy.CSS, valueToFind = "span#requestDate>span>span")
	private MCWebElement requestDateLbl;

	@PageElement(findBy = FindBy.CSS, valueToFind = "span#crAccountNbr>span")
	private MCWebElement walletNumberLbl;

	@PageElement(findBy = FindBy.CSS, valueToFind = "span#userCreate>span")
	private MCWebElement loggedByLbl;

	@PageElement(findBy = FindBy.CSS, valueToFind = "span#actualClosureDate>span>span")
	private MCWebElement closureDateLbl;

	@PageElement(findBy = FindBy.CSS, valueToFind = "span#closedBy>span")
	private MCWebElement closedByLbl;

	@PageElement(findBy = FindBy.CSS, valueToFind = "span#estimatedClosurePeriod>span")
	private MCWebElement closurePeriodLbl;

	@PageElement(findBy = FindBy.CSS, valueToFind = "span#priorityRequest>input")
	private MCWebElement priorityRequestChkBx;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[text()='Current Status and Limits']")
	private MCWebElement currentStatusAndLimitTab;

	@PageElement(findBy = FindBy.X_PATH, valueToFind="//input[@name='udf23:radioComponent' and @value='0']")
	private MCWebElement eccomDeactivate;

	@PageElement(findBy = FindBy.X_PATH, valueToFind="//input[@name='udf23:radioComponent' and @value='1']")
	private MCWebElement eccomActivate;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Avail Card :']/../../following-sibling::td[1]/span/span")
	private MCWebElement availCardCreditLimitLabel;

	private static final By INFO_WALLET_NUMBER = By.xpath("//li[@class='feedbackPanelINFO'][2]/span");

	private final String RESET_PIN_RETRY_COUNTER= "109 - Reset Pin Retry Counter";

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[text()='Balance Details']")
	private MCWebElement balanceDetailsTab;

	@PageElement(findBy = FindBy.X_PATH, valueToFind="//a[.='Current Status and Limits']")
	private MCWebElement currentStatusLimits;

	@PageElement(findBy = FindBy.X_PATH, valueToFind="//div[@id='tab4']//table[1]//td//span[@class='labeltextr']")
	private MCWebElements creditLimitParameter;

	@PageElement(findBy = FindBy.X_PATH, valueToFind="//div[@id='tab4']//table[1]//td//span[@class='labeltextr']/preceding::span[1]")
	private MCWebElements creditLimitParamterLabels;

	@PageElement(findBy = FindBy.X_PATH, valueToFind="//td[contains(.,'Payment :')]/..//span[@class='labeltextr']")
	private MCWebElements paymentComponents;

	@PageElement(findBy = FindBy.X_PATH, valueToFind="//td[contains(.,'Purchase :')]/..//span[@class='labeltextr']")
	private MCWebElements purchaseComponents;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Card :']/../../following-sibling::td[1]/span/span")
	private MCWebElement cardCreditLimitLabel;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Avail Account :']/../../following-sibling::td[1]/span/span")
	private MCWebElement availAccountCreditLimitLabel;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Account :']/../../following-sibling::td[1]/span/span")
	private MCWebElement accountCreditLimitLabel;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Client :']/../../following-sibling::td[1]/span/span")
	private MCWebElement clientCreditLimitLabel;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Avail Client :']/../../following-sibling::td[1]/span/span")
	private MCWebElement availClientCreditLimitLabel;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='PDD :']/../../following-sibling::td[1]/span/span/span")
	private MCWebElement paymentDueDateLabel;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='MAD :']/../../following-sibling::td[1]/span/span")
	private MCWebElement minimumAmountDueLabel;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Total Outstanding :']/../../following-sibling::td[1]/span/span")
	private MCWebElement totalAmountDueLabel;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Closing Balance :']/../../following-sibling::td[1]/span/span")
	private MCWebElement closingBalanceLabel;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Interest :']/../../following-sibling::td[1]/span/span")
	private MCWebElement interestLabel;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Loan :']/../../following-sibling::td[1]/span/span")
	private MCWebElement loanLabel;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Loan Interest :']/../../following-sibling::td[1]/span/span")
	private MCWebElement loanInterestLabel;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Loan Installment :']/../../following-sibling::td[3]/span/span")
	private MCWebElement loanInstallmentOutStandingLabel;
	
    @PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[contains(text(),'Wallet Number')]/../following-sibling::td/span/span")
	private MCWebElement txtWalletNumber;

    @PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Payment :']/../../following-sibling::td[2]/span/span")
	private MCWebElement paymentUnbilledLbl;

    @Autowired
	TestContext context;

	private final String DEFAULT_BALANCE="0.00";

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//th[text()='New Credit Limit']/../following-sibling::tr[1]/td[4]/input")
	private MCWebElement creditClientLimitTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//th[text()='New Credit Limit']/../following-sibling::tr[2]/td[4]/input")
	private MCWebElement creditAccountLimitTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='newCreditLimit']")
	private MCWebElement newCreditLimitTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Type :']/../following-sibling::td[1]/select")
	private MCWebElement selectLimitTypeDdwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Loan Plan :']/../following-sibling::td[1]//span/select")
	private MCWebElement selectLoanPlanDdwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value= 'Book Loan']")
	private MCWebElement bookLoanBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value= 'Calculate EMI']")
	private MCWebElement calculateEMIBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Note :']/../following-sibling::td[1]/span/textarea")
	private MCWebElement noteTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value= 'Sanction']")
	private MCWebElement sanctionBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td/span[text()='EMI :']/../following-sibling::td[1]/span/input")
	private MCWebElement emiLbl;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td/span[text()='Processing Fee :']/../following-sibling::td[1]/span/input")
	private MCWebElement processingFeeLbl;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td/span[text()='Moratorium Loan :']/../following-sibling::td[1]/span/input")
	private MCWebElement moratoriumLoanLbl;

	@PageElement(findBy = FindBy.ID, valueToFind = "callReferenceNumber")
	private MCWebElement callRefNumberLbl;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value='Authorization']")
	private MCWebElement btnAuthorization;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[contains(text(),'Decline Reason')]/../following-sibling::td/span/span")
	private MCWebElement labelDeclineReason;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[contains(text(),'Authorization Date From')]/..//span")
	private MCWebElement txtAuthorizationDateFrom;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[contains(text(),'Authorization Date From')]/..//td[7]//span")
	private MCWebElement txtAuthorizationDateTo;

	public final String AUTHORIZATION = "Authorizations";
	public final String VIEW_AUTHORIZATION = "View Authorizations";


	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Cancel Loan']")
	private MCWebElement cancelLoanBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Cancellation Fee :']/../following-sibling::td/span/input")
	private MCWebElement txtCancellationFee;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Process']")
	private MCWebElement processBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Pre-Closure Fee :']/../following-sibling::td/input")
	private MCWebElement preclosureFeeTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Pre-Close Loan']")
	private MCWebElement preCloseLoanBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Loan Account Number :']/../following-sibling::td[1]//span/select")
	private MCWebElement selectLoanAccountNumberDdwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value = 'Loyalty']")
	private MCWebElement loyaltyBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Points Earned:']/following::span/span")
	private MCWebElement pointsEarned;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Available Loyalty Points:']/following::span/span")
	private MCWebElement availableLoyaltyPoints;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Accumulated Reversed Points:']/following::span/span")
	private MCWebElement accumulatedReversedPoints;

	private final String LOYALTY_DETAILS = "Loyalty Details";

	private String preclosureFee;
	private String cancellationFee;
	private String errorMsgOfloanCancellation;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[contains(.,'Reason')]//following::select[@class = 'mandatoryFlag selectf']")
	private MCWebElement stoplistReasonDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[contains(.,'New Device Number :')]//following::input[@type='checkbox']")
	private MCWebElement chkBxNewDeviceNumber;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[contains(.,'Reason :')]//following::select[@class='mandatoryFlag textf']")
	private MCWebElement replaceDeviceRequestReasonDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[contains(.,'New Pack ID :')]//following::input[@class='mandatoryFlag textf']")
	private MCWebElement txtnewPackID;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[contains(.,'Withdrawal Reason :')]//following::select[@class='mandatoryFlag selectf']")
	private MCWebElement withdrawStoplistReasonDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Apply Fees :']//following::input[@type='checkbox']")
	private MCWebElement chkBxApplyFees;

	protected String getWalletNumber() {
		WebElement walletNumber = new WebDriverWait(driver(), timeoutInSec).until(ExpectedConditions.visibilityOfElementLocated(INFO_WALLET_NUMBER));
		logger.info(WALLET_NUMBER, CharMatcher.DIGIT.retainFrom(walletNumber.getText()));
		return CharMatcher.DIGIT.retainFrom(walletNumber.getText());
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(productTypeSearchDDwn), WebElementUtils.visibilityOf(deviceNumberSearchTxt));
	}

	public void clickFirstRowEditLink() {
		new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.elementToBeClickable(firstRowEditLink)).click();
	}

	public void clickWalletDetailsTab() {
		new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(walletDetailsLnk)).click();
	}

	public void clickDeviceDetailsTab() {
		new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(deviceDetailsLnk)).click();
	}

	public void clickActivateRadioButton() {
		activateRBtn.click();
	}

	public void clickDeActivateRadioButton() {
		deactivateRBtn.click();
	}

	public void clickLifeLongActivationRadioButton() {
		lifeLongActivationRBtn.click();
	}

	public void clickImmediateActivationForNHoursRadioButton() {
		immediateActivationForNHoursRBtn.click();
	}

	public void clickActivationInPeriodRadioButton() {
		activationInPeriodRBtn.click();
	}

	public void enterTimeInHours(String timeInHours) {
		WebElementUtils.enterText(timeInHoursTxt, timeInHours);
	}

	public String getDeviceNumberStatus() {
		return getFirstRecordCellTextByColumnName(COLUMN_STATUS);
	}

	public void selectServiceCode(String serviceCode) {
		selectByVisibleText(serviceCodeDdwn, serviceCode);
	}

	public void storeSaleDate() {
		saleDate = new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(saleDateTxt)).getText();
	}

	public String saleDate() {
		return saleDate;
	}

	public void selectServiceCodeByValue(String serviceCode) {
		WebElementUtils.selectDropDownByValue(serviceCodeDdwn, serviceCode);
	}

	public void selectServiceCodeByText(String serviceText) {
		selectByVisibleText(serviceCodeDdwn, serviceText);
	}

	public void storeActivationDate() {
		activationDate = new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(activationDateTxt)).getText();
	}

	public String activationDate() {
		return activationDate;
	}

	public void storeDeliveryDate() {
		deliveryDate = new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(deliveryDateTxt)).getText();
	}

	public String deliveryDate() {
		return deliveryDate;
	}

	public void clickGoButton() {
		clickWhenClickableDoNotWaitForWicket(goBtn);
	}

	public void clickCustomerCareEditLink() {
		clickFirstRowEditLink();
	}

	public void enterNotes(String notes) {
		WebElementUtils.enterText(notesTxt, notes);
	}

	public void enterNote(String notes) {
		noteTxt.sendKeys(notes);
	}

	public void enterEmailID(HelpdeskGeneral general) {
		enterValueinTextBox(emailIDInptTxt, general.getNewEmailID());
	}

	public void enterMobileNo(HelpdeskGeneral general) {
		SelectDropDownByValue(isdCodeDdwn, general.getNewMobileISD());
		enterValueinTextBox(mobileInptTxt, general.getNewMobileNo());
	}

	public boolean validateMandatoryFields(int mandatoryFields) {
		clickSaveButton();
		clickSaveButton();
		if (errorMessage().size() == mandatoryFields && errorMessage().get(mandatoryFields - 1).equalsIgnoreCase(ERROR_MESSAGE))
			return true;
		else
			return false;
	}

	public String activationMessage() {
		return new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(activationMessage)).getText();
	}

	public void clickOKButtonPopup() {
		SimulatorUtilities.wait(5000);
		new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.elementToBeClickable(okBtn)).click();
	}

	public void clickCancelButtonPopup() {
		SimulatorUtilities.wait(5000);
		new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.elementToBeClickable(cancelBtn)).click();
	}

	public void clickEndCall() {
		WebElementUtils.scrollDown(driver(), 0, 250);
		new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.elementToBeClickable(endCallBtn)).click();
		new WebDriverWait(driver(), timeoutInSec).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(GENERAL_ELEMENT_XPATH)));
	}

	public void enterClientCreditLimit(String clientcreditlimit) {
		WebElementUtils.enterText(creditClientLimitTxt, clientcreditlimit);
	}

	public void enterAccountCreditLimit(String accountcreditlimit) {
		WebElementUtils.enterText(creditAccountLimitTxt, accountcreditlimit);
	}

	public void enterNewCreditLimit(String newcreditlimit) {
		WebElementUtils.enterText(newCreditLimitTxt, newcreditlimit);
	}

	public void selectLimitType(String type) {
		WebElementUtils.selectDropDownByVisibleText(selectLimitTypeDdwn, type);
	}
	
	public void selectLoanPlan(String type) {
		WebElementUtils.selectDropDownByVisibleText(selectLoanPlanDdwn, type);
	}
	
	public void clickCurrentStatusAndLimitsTab(){
		new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(currentStatusAndLimitTab)).click();
	}
	
	public void setActiveDeviceNumberByCardPackId(HelpdeskGeneral helpdeskGeneral, String registeredType) {
		WebElementUtils.selectDropDownByVisibleText(productTypeSearchDDwn, helpdeskGeneral.getProductType());
		WebElementUtils.enterText(cardPackIdTxt, helpdeskGeneral.getCardPackId());
		clickSearchButton();
		SimulatorUtilities.wait(5000);// this to wait till the table gets loaded
		if (REGISTERED.equalsIgnoreCase(registeredType))
			status = DeviceStatus.NORMAL;
		else if (NOT_REGISTERED.equalsIgnoreCase(registeredType))
			status = DeviceStatus.READY_FOR_SALE;
		for (int i = 1; i <= getRowCountFromTable(); i++) {
			if (getCellTextByColumnName(i, COLUMN_STATUS).equalsIgnoreCase(status)) {
				activeDeviceNumber = getCellTextByColumnName(i, "Device Number");
				break;
			}
		}
		logger.info("Active Device Number is: {}", activeDeviceNumber);
		helpdeskGeneral.setDeviceNumber(activeDeviceNumber);
	}

	public String getDeviceStatus(Device device) {
		logger.info("Fetching information for : {}", device.getDeviceNumber());
		WebElementUtils.selectDropDownByVisibleText(productTypeSearchDDwn, device.getProductType());
		WebElementUtils.enterText(deviceNumberSearchTxt, device.getDeviceNumber());
		clickSearchButton();
		SimulatorUtilities.wait(5000);// this to wait till the table gets loaded
		return getFirstRecordCellTextByColumnName(COLUMN_STATUS);
	}

	public boolean verifyTransactionOfDevice(Device device) {
		WebElementUtils.selectDropDownByVisibleText(productTypeSearchDDwn, device.getAppliedForProduct());
		WebElementUtils.enterText(deviceNumberSearchTxt, device.getDeviceNumber());
		clickSearchButton();
		SimulatorUtilities.wait(5000);// this to wait till the table gets loaded
		clickFirstRowEditLink();
		pageScrollDown();
		transactionsBtn.click();
		runWithinPopup("Transaction", () -> {
			WebElementUtils.pickDate(effectiveDateTxt, LocalDate.now());
			WebElementUtils.pickDate(endDateTxt, LocalDate.now());
			clickSearchButton();
			firstRow = getFirstColumnValueFromTable();
			clickCloseButton();
			
		});
		clickEndCall();
		return firstRow.isEmpty();
	}

	public void activateDevice(HelpdeskGeneral helpdeskGeneral) {
		logger.info("activate device: {}", helpdeskGeneral.getCardPackId());
		selectServiceCode(helpdeskGeneral.getServiceCode());
		clickGoButton();
		runWithinPopup("108 - Activate Device ", () -> {
			enterNotes(helpdeskGeneral.getNotes());
			clickSaveButton();
			verifyOperationStatus();
			clickOKButtonPopup();
		});
		// There is a delay in page rendering
		SimulatorUtilities.wait(5000);
		clickEndCall();
	}

	public void setupCurrency(String lst) {
		SimulatorUtilities.wait(1000);
		int rowCount = driver().findElements(By.xpath(TABLE_XPATH)).size();
		values = lst.trim().split(",");
		for (int i = 0; i < values.length; i++) {
			for (int j = 2; j <= rowCount; j++) {
				String[] data = values[i].trim().split(":");
				String currencyName = data[0].trim();
				String priority = data[1].trim();
				if (driver().findElement(By.xpath(TABLE_XPATH + "[" + j + "]/td[1]")).getText().equalsIgnoreCase(currencyName)) {
					WebElement element = driver().findElement(By.xpath(TABLE_XPATH + "[" + j + "]/td[2]//select"));
					WebElementUtils.retryUntilNoErrors(() -> new Select(element).selectByVisibleText(priority));
					break;
				}

			}
		}
	}

	public void setupDeviceCurrency(HelpdeskGeneral helpdeskGeneral) {
		logger.info("Setup Device Currency: {}", helpdeskGeneral.getDeviceNumber());
		selectServiceCode(helpdeskGeneral.getCurrencySetupServiceCode());
		clickGoButton();		
		SimulatorUtilities.wait(5000);
		runWithinPopup("312 - Currency Setup", () -> {
			setupCurrency(helpdeskGeneral.getCurrencyWithPriority());
			enterNotes(helpdeskGeneral.getNotes());
			clickSaveButton();
			verifyOperationStatus();
			helpdeskGeneral.setNewWalletNumber(getWalletNumber());
			clickOKButtonPopup();
		});
		// There is a delay in page rendering
		SimulatorUtilities.wait(5000);
		clickEndCall();
	}

	public void chooseOperationDeactivate(String status) {
		SimulatorUtilities.wait(1000);
		if (status.equalsIgnoreCase(ConstantData.INTERNATIONAL_ALLOW_DISALLOW)) {
			WebElementUtils.retryUntilNoErrors(() -> new Select(driver().findElement(By.xpath(OPERATION))).selectByValue("0"));
		} else {
			eccomDeactivate.click();
		}
	}

	public void chooseOperationActivate(String status) {
		if (status.equalsIgnoreCase(ConstantData.INTERNATIONAL_ALLOW_DISALLOW)) {
			SimulatorUtilities.wait(1000);
			WebElement operation = driver().findElement(
					By.xpath("//select[@name='udf1:input:dropdowncomponent']"));
			WebElement activationType = driver().findElement(
					By.xpath("//select[@name='udf2:input:dropdowncomponent']"));
			WebElementUtils.retryUntilNoErrors(() -> new Select(operation)
					.selectByValue("1"));
			WebElementUtils.retryUntilNoErrors(() -> new Select(activationType)
					.selectByVisibleText(ConstantData.GENERIC_DESCRIPTION));
			WebElementUtils.enterText(timeInHourTxt, "1");
		} else {
			SimulatorUtilities.wait(1000);
			List<WebElement> listEccom = driver().findElements(
					By.xpath("//input[@name='udf23:radioComponent']"));
			boolean rValue;
			if (rValue = listEccom.get(1).isSelected()) {
				listEccom.get(0).click();
			}
			WebElement element = driver().findElement(By.xpath("//input[@name='udf25:radioComponent' and @value='2']"));
			element.click();
			SimulatorUtilities.wait(2000);
			WebElementUtils.enterText(timeInHourTxt, "1");
		}
	}
	
	public void setupInternationalAllowDisallowCheck(String status) {
		selectServiceCode(ConstantData.INTERNATIONAL_ALLOW_DISALLOW);
		clickGoButton();
		runWithinPopup("400 - International Use Allow/Disallow", () -> {
			chooseOperationDeactivate(status);
			SimulatorUtilities.wait(2000);
			enterNotes("Automation");
			clickSaveButton();
			verifyOperationStatus();
			clickOKButtonPopup();			
		});
		//There is a delay in page rendering
		SimulatorUtilities.wait(5000);
		clickEndCall();
	}
	
	public void setupEccomerceDisallowCheck(String status) {
		selectServiceCode(ConstantData.ECCOMERCE_ALLOW_DISALLOW);
		clickGoButton();
		runWithinPopup("304 - E-commerce Activation/Deactivation", () -> {
			chooseOperationDeactivate(status);
			SimulatorUtilities.wait(2000);
			enterNotes("Automation");
			clickSaveButton();
			verifyOperationStatus();
			clickOKButtonPopup();			
		});
		//There is a delay in page rendering
		SimulatorUtilities.wait(5000);
		clickEndCall();
	}
	
	public void allowTransactionForOneHour(String status) {
		if (status.equalsIgnoreCase(ConstantData.INTERNATIONAL_ALLOW_DISALLOW))
		{
		selectServiceCode(ConstantData.INTERNATIONAL_ALLOW_DISALLOW);
		clickGoButton();
		runWithinPopup("400 - International Use Allow/Disallow", () -> {
			chooseOperationActivate(status);
			enterNotes(ConstantData.GENERIC_DESCRIPTION);
			clickSaveButton();
			verifyOperationStatus();
			clickOKButtonPopup();			
		});
		}
		else
		{
			selectServiceCode(ConstantData.ECCOMERCE_ALLOW_DISALLOW);
			clickGoButton();
			runWithinPopup("304 - E-commerce Activation/Deactivation", () -> {
				chooseOperationActivate(status);
				enterNotes(ConstantData.GENERIC_DESCRIPTION);
				clickSaveButton();
				verifyOperationStatus();
				clickOKButtonPopup();			
			});
		}
	
		//There is a delay in page rendering
		SimulatorUtilities.wait(5000);
		clickEndCall();
	}
	

	public boolean verifyCurrencySetupDoneCorrectly(HelpdeskGeneral helpdeskGeneral, Device device) {
		logger.info("verify added currecy for device number: {}", device.getDeviceNumber());
		int count = 0;
		WebElementUtils.selectDropDownByVisibleText(productTypeSearchDDwn, device.getAppliedForProduct());
		WebElementUtils.enterText(deviceNumberSearchTxt, device.getDeviceNumber());
		clickSearchButton();
		SimulatorUtilities.wait(5000);
		editDeviceLink.click();
		clickWalletDetailsTab();
		SimulatorUtilities.wait(5000);
		int rowCount = driver().findElements(By.xpath("//div[@class='tab_container_privileges']//table[@class='dataview']/tbody/tr")).size();
		values = helpdeskGeneral.getCurrencyWithPriority().trim().split(",");
			for (int i = 0; i < values.length ; i++){
				for (int j = 1; j <= rowCount; j++){
					String[] data = values[i].trim().split(":");
					String currencyName = data[0].trim();
					if (getCellTextByColumnNameInEmbeddedTab(j, "Wallet Currency").equalsIgnoreCase(currencyName)){
						device.setWalletNumber2(getCellTextByColumnNameInEmbeddedTab(j, "Wallet Number"));
						count++;
						break;
					}
				}				
			}			
		clickEndCall();
		return (count == values.length) ? true : false;
	}

	public void searchWithDeviceNumber(HelpdeskGeneral helpdeskGeneral) {
		WebElementUtils.selectDropDownByVisibleText(productTypeSearchDDwn, helpdeskGeneral.getProductType());
		WebElementUtils.enterText(deviceNumberSearchTxt, helpdeskGeneral.getDeviceNumber());
		clickSearchButton();
	}

	public void searchByDeviceNumber(Device device) {
		WebElementUtils.selectDropDownByVisibleText(productTypeSearchDDwn, device.getAppliedForProduct());
		WebElementUtils.enterText(deviceNumberSearchTxt, device.getDeviceNumber());
		clickSearchButton();
	}

	public void activateDeviceForEcommerce(HelpdeskGeneral helpdeskGeneral) {
		logger.info("activate device for ecommerce: {}", helpdeskGeneral.getDeviceNumber());
		selectServiceCode(helpdeskGeneral.getServiceCode());
		clickGoButton();
		runWithinPopup("304 - E-commerce Activation/Deactivation", () -> {
			clickActivateRadioButton();
			clickLifeLongActivationRadioButton();
			enterNotes(helpdeskGeneral.getNotes());
			clickSaveButton();
			verifyOperationStatus();
			clickOKButtonPopup();
		});
		clickEndCall();
	}

	public BigDecimal getWalletBalance(Device device) {
		logger.info("Get Wallet Balance for device number: {}", device.getDeviceNumber());
		WebElementUtils.selectDropDownByVisibleText(productTypeSearchDDwn, device.getAppliedForProduct());
		WebElementUtils.enterText(deviceNumberSearchTxt, device.getDeviceNumber());
		clickSearchButton();
		clickFirstRowEditLink();
		clickWalletDetailsTab();
		SimulatorUtilities.wait(5000);// this to wait till the table gets loaded
		BigDecimal balanceAmount = new BigDecimal(getFirstRecordCellTextByColumnNameInEmbeddedTab(CURRENT_AVAILABLE_BALANCE));
		clickEndCall();
		return balanceAmount;
	}

	public void searchByClientID(String clientID, String cardType) {
		WebElementUtils.selectDropDownByVisibleText(productTypeSearchDDwn, cardType);
		WebElementUtils.enterText(clientIDInpt, clientID);
		clickSearchButton();
	}

	public String getWalletNumber(Device device) {
		logger.info("Get Wallet Number for Device: {}", device.getDeviceNumber());
		WebElementUtils.selectDropDownByVisibleText(productTypeSearchDDwn, device.getAppliedForProduct());
		WebElementUtils.enterText(deviceNumberSearchTxt, device.getDeviceNumber());
		clickSearchButton();
		SimulatorUtilities.wait(5000);// this to wait till the table gets loaded
		editDeviceLink.click();
		clickWalletDetailsTab();
		String walletNumber = getFirstRecordCellTextByColumnNameInEmbeddedTab(WALLET_NUMBER);
		clickEndCall();
		return walletNumber;
	}

	public String getWalletBalanceInformation(Device device) {
		logger.info("Get Wallet Balance Information for Device: {}", device.getDeviceNumber());
		WebElementUtils.selectDropDownByVisibleText(productTypeSearchDDwn, device.getAppliedForProduct());
		WebElementUtils.enterText(deviceNumberSearchTxt, device.getDeviceNumber());
		clickSearchButton();
		clickFirstRowEditLink();
		clickWalletDetailsTab();
		SimulatorUtilities.wait(5000);// this to wait till the table gets loaded
		int rowCount = driver().findElements(By.xpath("//div[@class='tab_container_privileges']//table[@class='dataview']/tbody/tr")).size();
		DecimalFormat dec = new DecimalFormat("#0.00");
		for (int j = 1; j <= rowCount; j++) {
			if (j == 1) {
				logger.info("Current Available Balance {} Settled Debit {} ", getCellTextByColumnNameInEmbeddedTab(j, "Current Available Balance"),
						getCellTextByColumnNameInEmbeddedTab(j, "Settled Debit"));
				Double balance = Double.parseDouble(getCellTextByColumnNameInEmbeddedTab(j, "Current Available Balance"))
						+ Double.parseDouble(getCellTextByColumnNameInEmbeddedTab(j, "Settled Debit"));
				logger.info("Current Available Balance + Settled Debit : " + dec.format(balance));
				walletBalanceInformation = getCellTextByColumnNameInEmbeddedTab(j, "Wallet Currency") + ":" + dec.format(balance) + ":" + getCellTextByColumnNameInEmbeddedTab(j, "WALLET_NUMBER");

			} else {
				logger.info("Current Available Balance {} Settled Debit {} ", getCellTextByColumnNameInEmbeddedTab(j, "Current Available Balance"),
						getCellTextByColumnNameInEmbeddedTab(j, "Settled Debit"));
				Double balance = Double.parseDouble(getCellTextByColumnNameInEmbeddedTab(j, "Current Available Balance"))
						+ Double.parseDouble(getCellTextByColumnNameInEmbeddedTab(j, "Settled Debit"));
				logger.info("Current Available Balance + Settled Debit : " + dec.format(balance));
				walletBalanceInformation = walletBalanceInformation + "," + getCellTextByColumnNameInEmbeddedTab(j, "Wallet Currency") + ":" + dec.format(balance) + ":"
						+ getCellTextByColumnNameInEmbeddedTab(j, "WALLET_NUMBER");
			}
		}
		clickEndCall();
		return walletBalanceInformation;
	}

	public String getWalletBalanceInformationAfterLoyaltyRedemption(Device device) {
		logger.info("Get Wallet Balance Information for Device: {}", device.getDeviceNumber());
		WebElementUtils.selectDropDownByVisibleText(productTypeSearchDDwn, device.getAppliedForProduct());
		WebElementUtils.enterText(deviceNumberSearchTxt, device.getDeviceNumber());
		clickSearchButton();
		SimulatorUtilities.wait(5000);// this to wait till the table gets loaded
		editDeviceLink.click();
		clickWalletDetailsTab();
		SimulatorUtilities.wait(5000);// this to wait till the table gets loaded
		int rowCount = driver()
				.findElements(By.xpath("//div[@class='tab_container_privileges']//table[@class='dataview']/tbody/tr"))
				.size();
		DecimalFormat dec = new DecimalFormat("#0.00");
		for (int j = 1; j <= rowCount; j++) {
			logger.info("Current Available Balance {} Unsettled Debit {} ",
					getCellTextByColumnNameInEmbeddedTab(j, "Current Available Balance"));
			Double balance = Double.parseDouble(getCellTextByColumnNameInEmbeddedTab(j, "Current Available Balance"));

			logger.info("Current Available Balance + Settled Credit : " + dec.format(balance));
			walletBalanceInformation = walletBalanceInformation + ","
					+ getCellTextByColumnNameInEmbeddedTab(j, "Wallet Currency") + ":" + dec.format(balance) + ":"
					+ getCellTextByColumnNameInEmbeddedTab(j, "WALLET_NUMBER");
		}
		return walletBalanceInformation;
	}

	public String getWalletBalanceInformationForRemittance(Device device, CardToCash cardToCash) {
		logger.info("Get Wallet Balance Information for Device: {}", device.getDeviceNumber());
		WebElementUtils.selectDropDownByVisibleText(productTypeSearchDDwn, device.getAppliedForProduct());
		WebElementUtils.enterText(deviceNumberSearchTxt, device.getDeviceNumber());
		clickSearchButton();
		SimulatorUtilities.wait(5000);// this to wait till the table gets loaded
		clickFirstRowEditLink();
		clickWalletDetailsTab();
		SimulatorUtilities.wait(5000);// this to wait till the table gets loaded
		int rowCount = driver().findElements(By.xpath("//div[@class='tab_container_privileges']//table[@class='dataview']/tbody/tr")).size();
		DecimalFormat dec = new DecimalFormat("#0.00");
		for (int j = 1; j <= rowCount; j++) {
			if (j == 1) {
				logger.info("Current Available Balance {} Settled Debit {} ", getCellTextByColumnNameInEmbeddedTab(j, "Current Available Balance"),
						getCellTextByColumnNameInEmbeddedTab(j, "Settled Debit"));
				Double balance = Double.parseDouble(getCellTextByColumnNameInEmbeddedTab(j, "Current Available Balance"))
						+ Double.parseDouble(getCellTextByColumnNameInEmbeddedTab(j, "Settled Debit")) - Double.parseDouble(cardToCash.getRemittanceAmount());
				logger.info("Current Available Balance + Settled Debit : " + dec.format(balance));
				walletBalanceInformation = getCellTextByColumnNameInEmbeddedTab(j, "Wallet Currency") + ":" + dec.format(balance) + ":" + getCellTextByColumnNameInEmbeddedTab(j, "WALLET_NUMBER");
			}
		}
		clickEndCall();
		return walletBalanceInformation;

	}

	public boolean verifyBalanceUpdatedCorreclty(String beforeLoadBalanceInformation, String transactionDetailsFromExcel, String afterLoadBalanceInformation) {
		logger.info("Verify Wallet Balance Information for Device is added correctly");

		String[] beforeLoadBalanceData = beforeLoadBalanceInformation.trim().split(",");
		String[] transactionData = transactionDetailsFromExcel.trim().split(",");
		String[] afterLoadBalanceData = afterLoadBalanceInformation.trim().split(",");

		int count = 0;
		for (int i = 0; i < transactionData.length; i++) {
			String[] transactionDataValues = transactionData[i].trim().split(":");
			String currencyName = transactionDataValues[0];
			for (int j = 0; j < afterLoadBalanceData.length; j++) {
				String[] beforeLoadBalanceDataValues = beforeLoadBalanceData[j].trim().split(":");
				String[] afterLoadBalanceDataValues = afterLoadBalanceData[j].trim().split(":");
				if (currencyName.equalsIgnoreCase(beforeLoadBalanceDataValues[0])) {
					BigDecimal calculatedBalance = new BigDecimal(beforeLoadBalanceDataValues[1]).add(new BigDecimal(transactionDataValues[1]));
					if (calculatedBalance.equals(new BigDecimal(afterLoadBalanceDataValues[1]))) {
						count++;
						break;
					}
				}
			}
		}
		return (count == transactionData.length) ? true : false;
	}

	public boolean verifyBalanceDeductedCorreclty(String beforeLoadBalanceInformation, String transactionDetailsFromExcel, String afterLoadBalanceInformation) {
		logger.info("Verify Wallet Balance Information for Device after Transaction Deduction");

		String[] beforeLoadBalanceData = beforeLoadBalanceInformation.trim().split(",");
		String[] transactionData = transactionDetailsFromExcel.trim().split(",");
		String[] afterLoadBalanceData = afterLoadBalanceInformation.trim().split(",");

		int count = 0;
		for (int i = 0; i < transactionData.length; i++) {
			String[] transactionDataValues = transactionData[i].trim().split(":");
			String currencyName = transactionDataValues[0];
			for (int j = 0; j < afterLoadBalanceData.length; j++) {
				String[] beforeLoadBalanceDataValues = beforeLoadBalanceData[j].trim().split(":");
				String[] afterLoadBalanceDataValues = afterLoadBalanceData[j].trim().split(":");
				if (currencyName.equalsIgnoreCase(beforeLoadBalanceDataValues[0])) {
					if (new BigDecimal(afterLoadBalanceDataValues[1]).equals(new BigDecimal(transactionDataValues[1]))) {

						count++;
						break;
					}
				}
			}
		}
		return (count == transactionData.length) ? true : false;
	}

	public boolean verifyBalanceNotChanged(String beforeLoadBalanceInformation, String afterLoadBalanceInformation) {
		logger.info("Verify Wallet Balance Information for Device Not Changed");

		String[] beforeLoadBalanceData = beforeLoadBalanceInformation.trim().split(",");
		String[] afterLoadBalanceData = afterLoadBalanceInformation.trim().split(",");

		int count = 0;
		for (int i = 0; i < beforeLoadBalanceData.length; i++) {
			String[] beforeLoadDataValues = beforeLoadBalanceData[i].trim().split(":");
			String currencyName = beforeLoadDataValues[0];
			for (int j = 0; j < afterLoadBalanceData.length; j++) {
				String[] beforeLoadBalanceDataValues = beforeLoadBalanceData[j].trim().split(":");
				String[] afterLoadBalanceDataValues = afterLoadBalanceData[j].trim().split(":");
				if (currencyName.equalsIgnoreCase(beforeLoadBalanceDataValues[0])) {
					if (new BigDecimal(beforeLoadBalanceDataValues[1]).equals(new BigDecimal(afterLoadBalanceDataValues[1]))) {
						count++;
						break;
					}
				}
			}
		}
		return (count == beforeLoadBalanceData.length) ? true : false;
	}

	public boolean verifyInitialLoadBalanceUpdatedCorreclty(String transactionDetailsFromExcel, String afterLoadBalanceInformation) {
		logger.info("Verify Initial Load Wallet Balance Information for Device");

		String[] transactionData = transactionDetailsFromExcel.trim().split(",");
		String[] afterLoadBalanceData = afterLoadBalanceInformation.trim().split(",");

		int count = 0;
		for (int i = 0; i < transactionData.length; i++) {
			String[] transactionDataValues = transactionData[i].trim().split(":");
			String currencyName = transactionDataValues[0];
			for (int j = 0; j < afterLoadBalanceData.length; j++) {
				String[] afterLoadBalanceDataValues = afterLoadBalanceData[j].trim().split(":");
				if (currencyName.equalsIgnoreCase(afterLoadBalanceDataValues[0])) {
					if (new BigDecimal(transactionDataValues[1]).equals(new BigDecimal(afterLoadBalanceDataValues[1]))) {
						count++;
						break;
					}
				}
			}
		}
		return (count == transactionData.length) ? true : false;
	}

	public void verifyUiOperationStatus() {
		logger.info("General");
		verifySearchButton("Search");
	}

	public void selectWalleFromTransfer(String walletNumber) {
		waitForElementVisible(Element("//td[@id='fromCurrencyDataTable']"));
		waitForWicket();
		clickWhenClickable(Element("//td[@id='fromCurrencyDataTable']//./td/span[text()='" + walletNumber + "']//..//..//td//input"));
	}

	public void selectWalleToTransfer(String walletNumber) {
		waitForElementVisible(Element("//td[@id='toCurrencyDataTable']"));
		waitForWicket();
		clickWhenClickable(Element("//td[@id='toCurrencyDataTable']//./td/span[text()='" + walletNumber + "']//..//..//td//input"));
	}

	public void clickSaveButtonPopup() {
		clickWhenClickable(saveBtn);
	}

	public void selectDeviceToTransferFunds(String deviceToTransfer) {
		WebElementUtils.waitForWicket(driver());
		WebElementUtils.elementToBeClickable(toDeviceDropDn);
		WebElementUtils.selectDropDownByValue(toDeviceDropDn, deviceToTransfer);
	}

	public void enterAmountToTransfer(String amountToTransfer){
		WebElementUtils.enterText(debitAmtInpt, amountToTransfer);
	}

	public void enterNoteForTransaction(String transactionNote) {
		WebElementUtils.enterText(transactionNotesInpt, transactionNote);
	}

	public String verifyTheWalletToWalletTransactionStatus() {
		return getTextFromPage(walletToWalletConfirMsg);
	}

	public void walletToWalletTransfer(Device device) {
		selectServiceCode("Wallet To Wallet Transfer [465]");
		clickGoButton();
		runWithinPopup("465 - Wallet To Wallet Transfer", () -> {
			selectWalleFromTransfer(device.getWalletNumber());
			logger.info("Transfer funds from {} wallet", device.getWalletNumber());
			selectDeviceToTransferFunds(device.getDeviceNumber());			
			WebElementUtils.scrollDown(driver(), 0, 400);
			logger.info("Transfer funds to {} wallet", device.getNewWalletNumber());
			selectWalleToTransfer(device.getNewWalletNumber());
			enterAmountToTransfer(device.getTransactionAmount());			
			enterNoteForTransaction(String.format("fund deposited to wallet {}", device.getNewWalletNumber()));
			clickSaveButtonPopup();
			clickOKButtonPopup();
		});
		clickEndCall();
	}

	public boolean serviceRequestCardholderLoginPassword(String clientID) {
		logger.info("Reset Cardholder Login Password [459] for {}", clientID);
		selectServiceCodeByValue(SERV_CODE_LOGIN_PASSWORD);
		clickGoButton();
		runWithinPopup(LABEL_LOGIN_PASSWORD, () -> {
			enterNotes("Servic_Request for " + clientID);
			clickSaveButton();

			if (verifyServiceRequestStatus().contains(ConstantData.RECORD_PROCESSED_SUCCESSFULLY)) {
				logger.info("Reset Login password service request is completed for {}", clientID);
				clickOKButtonPopup();
				serviceStatus = true;
			} else {
				logger.info("Reset Login password service request is not completed for {}", clientID);
				clickCancelButtonPopup();
			}
		});
		SimulatorUtilities.wait(5000);
		clickEndCall();
		return serviceStatus;
	}

	public boolean serviceRequestCardholderTransactionPassword(String clientID) {
		logger.info("Reset Cardholder Transaction Password [250] for {}", clientID);

		selectServiceCodeByValue(SERV_CODE_TRANSACTION_PASSWORD);
		clickGoButton();
		runWithinPopup(LABEL_TRANSACTION_PASSWORD, () -> {
			enterNotes("Servic_Request for " + clientID);
			clickSaveButton();

			if (verifyServiceRequestStatus().contains(ConstantData.RECORD_PROCESSED_SUCCESSFULLY)) {
				logger.info("Reset Transaction password service request is completed for {}", clientID);
				clickOKButtonPopup();
				serviceStatus = true;
			} else {
				logger.info("Reset Transaction password service request is not completed for {}", clientID);
				clickCancelButtonPopup();
			}
		});
		SimulatorUtilities.wait(5000);
		clickEndCall();
		return serviceStatus;
	}

	public String verifyServiceRequestStatus() {
		return getTextFromPage(responseMessage);
	}

	public List<String> errorMessage() {
		return getListOfElements(ERROR_MESSAGE_XPATH);
	}

	public boolean verifyFieldPresence(String field) {
		try {
			Element(String.format(".//form[@id='id1a4']//table[@class='modelFormClass'][1]//*[text() [contains(.,'%s:')]]", field));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean verifyCallReferenceNo() {
		return verifyFieldPresence(CALL_REFERENCE_NUMBER) && StringUtils.isNumeric(getTextFromPage(callReferenceNumberLbl));

	}

	public boolean verifyServiceDescription(HelpdeskGeneral helpdeskGeneral) {
		return verifyFieldPresence(SERVICE_DESCRIPTION)
				&& getTextFromPage(serviceDescriptionLbl).equalsIgnoreCase(String.format(helpdeskGeneral.getServiceDescription() + " [%s]", helpdeskGeneral.getServiceCode()));
	}

	public boolean verifyDeviceNumber(HelpdeskGeneral helpdeskGeneral) {
		return verifyFieldPresence(DEVICE_NUMBER) && getTextFromPage(deviceNumberLbl).equalsIgnoreCase(helpdeskGeneral.getDeviceNumber());
	}

	public boolean verifyRequestDate() {
		if (verifyFieldPresence(REQUEST_DATE)) {
			try {
				LocalDate.parse(getTextFromPage(requestDateLbl), DateTimeFormatter.ofPattern("dd/MM/uuuu kk:mm:ss"));
				return true;
			} catch (DateTimeParseException e) {
				return false;
			}
		} else
			return false;
	}

	public boolean verifyLoggedBy() {
		return verifyFieldPresence(LOGGED_BY);
	}

	public boolean verifyWalletNumber(HelpdeskGeneral general) {
		return verifyFieldPresence(WALLET_NUMBER) && getTextFromPage(walletNumberLbl).equalsIgnoreCase(general.getDefaultWalletNumber());
	}

	public boolean verifyClosureDate() {
		if (verifyFieldPresence(CLOSURE_DATE)) {
			try {
				LocalDate.parse(getTextFromPage(closureDateLbl), DateTimeFormatter.ofPattern("dd/MM/uuuu kk:mm:ss"));
				return true;
			} catch (DateTimeParseException e) {
				return false;
			}
		} else
			return false;
	}

	public boolean verifyClosedBy() {
		return verifyFieldPresence(LOGGED_BY);
	}

	
	public boolean verifyEstimatedClosurePeriod() {
		return verifyFieldPresence(CLOSURE_PERIOD);
	}

	public boolean verifyPriorityRequest() {
		if (verifyFieldPresence(PRIORITY_REQUEST)) {
			ClickCheckBox(priorityRequestChkBx, true);
			return true;
		} else
			return false;
	}

	public boolean changeRegisteredEmailID(HelpdeskGeneral general) {
		logger.info("change Registered Email ID");

		selectServiceCodeByText(CHANGE_REGISTERED_EMAIL_ID);
		clickGoButton();
		runWithinPopup(CHANGE_REGISTERED_EMAIL_ID, () -> {
			enterEmailID(general);
			enterNotes("Servic_Request for registered email ID");
			clickSaveButton();

			if (verifyServiceRequestStatus().contains(ConstantData.RECORD_PROCESSED_SUCCESSFULLY)) {
				logger.info("Registered Email ID service request processed successfully");
				clickOKButtonPopup();
				serviceStatus = true;
			} else {
				logger.info("Registered Email ID service request rejected");
				clickCancelButtonPopup();
			}
		});
		clickEndCall();
		return serviceStatus;
	}

	public boolean changeRegisteredMobileNo(HelpdeskGeneral general) {
		logger.info("change Registered Mobile No");

		selectServiceCodeByText(CHANGE_REGISTERED_MOBILE_NO);
		clickGoButton();
		runWithinPopup(CHANGE_REGISTERED_MOBILE_NO, () -> {
			enterMobileNo(general);
			enterNotes("Servic_Request for registered Mobile No");
			clickSaveButton();

			if (verifyServiceRequestStatus().contains(ConstantData.RECORD_PROCESSED_SUCCESSFULLY)) {
				logger.info("Registered Mobile No service request processed successfully");
				clickOKButtonPopup();
				serviceStatus = true;
			} else {
				logger.info("Registered Mobile No service request rejected");
				clickCancelButtonPopup();
			}
		});
		clickEndCall();
		return serviceStatus;
	}

	public Map<String,String> checkCreditBalances(Device device){
		Map<String, String> balanceMapBeforePayments;	
		List<String> list;
		logger.info("get Credit balances");
		WebElementUtils.selectDropDownByVisibleText(productTypeSearchDDwn, device.getProductType());
		WebElementUtils.enterText(deviceNumberSearchTxt, device.getDeviceNumber());
		clickSearchButton();
		SimulatorUtilities.wait(5000);//this to wait till the table gets loaded
		editDeviceLink.click();
		clickCurrentStatusLimitTab();
		SimulatorUtilities.wait(5000);//this to wait till the table gets loaded
		balanceMapBeforePayments = getCreditLimitComponents();
			clickBalanceDetailsTab();
			SimulatorUtilities.wait(5000);//this to wait till the table gets loaded	
			list=getCreditCardBalance();
			balanceMapBeforePayments.put("UnbllledPayments", list.get(1));
			balanceMapBeforePayments.put("OutstandingPayments", list.get(2));			
			return balanceMapBeforePayments;
	}
	
	public void clickCurrentStatusLimitTab() {
		new WebDriverWait(driver(), timeoutInSec)
		.until(WebElementUtils.visibilityOf(currentStatusLimits)).click();
	}
	
	public Map<String,String> getCreditLimitComponents(){
		Map<String, String> map= new HashMap<>();
		for(int i=0 ; i<=creditLimitParameter.getElements().size()-2; i +=2){
			map.put(creditLimitParamterLabels.getElements().get(i).getText(), creditLimitParameter.getElements().get(i).getText());
		}
		return map;
	}
	
	public void clickBalanceDetailsTab() {
		new WebDriverWait(driver(), timeoutInSec)
		.until(WebElementUtils.visibilityOf(balanceDetailsTab)).click();
	}
	
	public List<String> getCreditCardBalance(){	
		ArrayList<String> list = new ArrayList<>();		
		clickWhenClickableDoNotWaitForWicket(balanceDetailsTab);
		for (MCWebElement element: purchaseComponents.getElements()){
			logger.info("Elemnent Text-> " + element.getText());
			list.add(element.getText());
		}
		for (MCWebElement element: paymentComponents.getElements()){
			list.add(element.getText());
			logger.info("Elemnent Text-> " + element.getText());
		}		
		return list;		
	}
	
	
	public void checkAndCompareBalancePostPayment(Payment payment){		
		Map<String, String> mapA= context.get("balanceBeforePayment");
		Map<String, String> mapB =context.get("balanceAfterPayment");
		    if (mapA != null && mapB != null && mapA.size() == mapB.size()) {
		        for (Map.Entry m : mapA.entrySet()) {
		            String keyFromFirstMap = (String) m.getKey();		           
		            String valueFromFirstMap = (String) m.getValue();
		            String valueFromSecondMap = mapB.get(keyFromFirstMap);
		            if(keyFromFirstMap.equals("UnbllledPayments")){
		            if (!valueFromSecondMap.equals(Integer.valueOf(valueFromFirstMap + payment.getAmount()))) {
		               Assert.assertEquals("Payment has been done successfully", keyFromFirstMap + "::::" + valueFromSecondMap,  keyFromFirstMap + "::::" + Integer.valueOf(valueFromFirstMap + 500));
		            }
		        } }
		        
		    } 
		    
		}
	
	public boolean validateRequiredFields(HelpdeskGeneral general) {
		logger.info("Validate required fields in change Registered Email ID Screen");

		selectServiceCodeByText(CHANGE_REGISTERED_EMAIL_ID);
		clickGoButton();
		runWithinPopup(CHANGE_REGISTERED_EMAIL_ID, () -> {
			verifyCallReferenceNo();
			verifyServiceDescription(general);
			verifyDeviceNumber(general);
			verifyRequestDate();
			verifyLoggedBy();
			verifyWalletNumber(general);
			verifyClosureDate();
			verifyClosedBy();
			verifyEstimatedClosurePeriod();
			verifyPriorityRequest();
		});
		return true;
	}

	public BigDecimal noteDownAvailableLimit(String type) {
		BigDecimal creditLimit;
		WebElementUtils.elementToBeClickable(currentStatusAndLimitTab);
		clickWhenClickable(currentStatusAndLimitTab);
		creditLimit = new BigDecimal(availAccountCreditLimitLabel.getText());
		logger.info("Credit limit noted down : {} ", creditLimit);
		clickEndCall();
		return creditLimit;
	}
	
	public HashMap<String,BigDecimal> noteDownCreditLimit(String type) {
		HashMap<String,BigDecimal> creditLimit=new HashMap<>();
		WebElementUtils.elementToBeClickable(currentStatusAndLimitTab);
		clickWhenClickable(currentStatusAndLimitTab);	
		logger.info("Credit limit noted down : {} ", creditLimit);		
		creditLimit.put(ConstantData.CLIENT_LIMIT,new BigDecimal(clientCreditLimitLabel.getText()));
		creditLimit.put(ConstantData.AVAIL_CLIENT_LIMIT,new BigDecimal(availClientCreditLimitLabel.getText()));
		
		creditLimit.put(ConstantData.ACCOUNT_LIMIT,new BigDecimal(accountCreditLimitLabel.getText()));
		creditLimit.put(ConstantData.AVAIL_ACCOUNT_LIMIT,new BigDecimal(availAccountCreditLimitLabel.getText()));

		creditLimit.put(ConstantData.CARD_LIMIT,new BigDecimal(cardCreditLimitLabel.getText()));	
		creditLimit.put(ConstantData.AVAIL_CARD_LIMIT,new BigDecimal(availCardCreditLimitLabel.getText()));	
		clickEndCall();		
		return creditLimit;
	}
	
	public void resetPinRetryCounter(HelpdeskGeneral helpdeskGeneral) {
		selectServiceCode(helpdeskGeneral.getServiceCode());
		clickGoButton();
		runWithinPopup(getServiceRequestPopupTitle(helpdeskGeneral.getServiceCode()), () -> {
			enterNotes(helpdeskGeneral.getNotes());
			clickSaveButton();
			verifyOperationStatus();
			clickOKButtonPopup();			
		});
		SimulatorUtilities.wait(3000);
		clickEndCall();
	}
	
	public HashMap<String, String> noteDownRequiredValues(String deviceNumber) {
		HashMap<String, String> helpDeskValues = new HashMap<>();
		helpDeskValues.put(ContextConstants.ACCOUNT_NUMBER, txtWalletNumber.getText());
		WebElementUtils.elementToBeClickable(currentStatusAndLimitTab);
		clickWhenClickable(currentStatusAndLimitTab);
		helpDeskValues.put(ContextConstants.CREDIT_LIMIT, accountCreditLimitLabel.getText());
		helpDeskValues.put(ContextConstants.AVAILABLE_CREDIT_LIMIT, availAccountCreditLimitLabel.getText());
		helpDeskValues.put(ContextConstants.PAYMENT_DUE_DATE, paymentDueDateLabel.getText());
		helpDeskValues.put(ContextConstants.MINIMUM_PAYMENT_DUE, minimumAmountDueLabel.getText());
		context.put(ContextConstants.MINIMUM_PAYMENT_DUE, minimumAmountDueLabel.getText());
		logger.info("MINIMUM_PAYMENT_DUE" + minimumAmountDueLabel.getText());
		helpDeskValues.put(ContextConstants.CLOSING_BALANCE, closingBalanceLabel.getText());
		WebElementUtils.elementToBeClickable(balanceDetailsTab);
		clickWhenClickable(balanceDetailsTab);
		helpDeskValues.put(ContextConstants.TOTAL_PAYMENT_DUE, totalAmountDueLabel.getText());
		context.put(ContextConstants.TOTAL_PAYMENT_DUE, totalAmountDueLabel.getText());
		logger.info("TOTAL_PAYMENT_DUE" + totalAmountDueLabel.getText());
		helpDeskValues.put(ContextConstants.INTEREST, interestLabel.getText());
		helpDeskValues.put(ContextConstants.LOAN, loanLabel.getText());
		helpDeskValues.put(ContextConstants.LOAN_INTEREST, loanInterestLabel.getText());
		helpDeskValues.put(ContextConstants.LOAN_INSTALLMENT_OUTSTANDING, loanInstallmentOutStandingLabel.getText());
		helpDeskValues.put(ContextConstants.PAYMENT_UNBILLED, paymentUnbilledLbl.getText());
		clickEndCall();
		return helpDeskValues;
	}
	
	public String verifyBillingDetails(Device device){
		List<String> lst = new ArrayList<String>();
		SimulatorUtilities.wait(5000);
		editDeviceLink.click();
		SimulatorUtilities.wait(1000);
		clickWhenClickable(balanceDetailsTab);
		SimulatorUtilities.wait(2000);
		lst.add(Element("//span[contains(text(),'"+device.getCategory()+" :')]//ancestor::tr//td["+resolve(device.getAmountType())+"]/span/span").getText());
		clickEndCall();
		return lst.get(0);
	}
	
	private int resolve(String amountType)
	{
		switch(amountType){
		case "Billed" :
			return 2;
		case "Unbilled" :
			return 3;
		case "Outstanding" :
			return 4;
		case "Amount" :
			return 6;
		case "Status" :
			return 2;
		}
		return 0;
	}
	
	
	
	public void checkBalancesDetails(Device device, String payment) {
		WebElementUtils.selectDropDownByVisibleText(productTypeSearchDDwn, device.getProductType());
		WebElementUtils.enterText(deviceNumberSearchTxt, device.getDeviceNumber());
		clickSearchButton();
		SimulatorUtilities.wait(5000);// this to wait till the table gets loaded
		editDeviceLink.click();
		SimulatorUtilities.wait(5000);// this to wait till the table gets loaded
		clickBalanceDetailsTab();
		SimulatorUtilities.wait(5000);// this to wait till the table gets loaded
		List<String> balanceComponent = createBalanceComponentCategory();
		Map<String, String> billedBalancedComponents = createBalancedComponentsDetails("Billed", balanceComponent);
		Map<String, String> unbilledBalancedComponents = createBalancedComponentsDetails("Unbilled", balanceComponent);
		Map<String, String> outstandingBalancedComponents = createBalancedComponentsDetails("Outstanding",
				balanceComponent);
		context.put(payment.replaceAll(" ", "").trim() + "Billed", billedBalancedComponents);
		context.put(payment.replaceAll(" ", "").trim() + "Unbilled", unbilledBalancedComponents);
		context.put(payment.replaceAll(" ", "").trim() + "Outstanding", outstandingBalancedComponents);

	}

	private Map<String, String> createBalancedComponentsDetails(String amountType, List<String> balanceComponent) {
		Map<String, String> billedBalancedComponents = new LinkedHashMap<String, String>();
		for (int index = 0; index < 11; index++) {
			billedBalancedComponents.put(amountType + balanceComponent.get(index),
					Element("//span[contains(text(),'" + balanceComponent.get(index) + " :')]//ancestor::tr//td["
							+ resolve(amountType) + "]/span/span").getText());
			logger.info(amountType + balanceComponent.get(index)+"->"+
					Element("//span[contains(text(),'" + balanceComponent.get(index) + " :')]//ancestor::tr//td["
							+ resolve(amountType) + "]/span/span").getText());
		}
		return billedBalancedComponents;
	}

	private List<String> createBalanceComponentCategory() {
		List<WebElement> elements = driver()
				.findElements(By.xpath("//div[@id='tab5']/table/tbody[1]/tr/td[1]/label/span"));
		List<String> balanceComponent = new ArrayList<String>();
		for (int index = 0; index < 11; index++) {
			balanceComponent.add(elements.get(index).getText().replace(":", "").trim());
		}
		return balanceComponent;
	}

	public void compareBalanceDetailsPostPayments(String payment) {
		double sum = 0.00;
		Map<String, String> afterPaymentBilled = context.get("afterpaymentBilled");
		Map<String, String> afterPaymentUnbilled = context.get("afterpaymentUnbilled");
		Map<String, String> afterPaymentOutstanding = context.get("afterpaymentOutstanding");
		Map<String, String> beforePaymentBilled = context.get("beforepaymentBilled");
		Map<String, String> beforePaymentUnbilled = context.get("beforepaymentUnbilled");
		Map<String, String> beforePaymentOutstanding = context.get("beforepaymentOutstanding");
		if (payment.equalsIgnoreCase("after full payment")) {

			for (Entry<String, String> set : beforePaymentOutstanding.entrySet()) {
				sum = sum + Double.valueOf(set.getValue());
				set.setValue(String.format("%.2f", Double.valueOf(set.getValue()) - Double.valueOf(set.getValue())));
			}
			beforePaymentUnbilled.replace("UnbilledPayment", String.format("%.2f", sum));
			compareMaps(beforePaymentBilled, afterPaymentBilled);
			compareMaps(beforePaymentUnbilled, afterPaymentUnbilled);
			compareMaps(beforePaymentOutstanding, afterPaymentOutstanding);
		}
		if (payment.equalsIgnoreCase("after billing")) {
			Map<String, String> afterBillingBilled = context.get("afterbillingBilled");
			Map<String, String> afterBillingUnbilled = context.get("afterbillingUnbilled");
			Map<String, String> afterBillingOutstanding = context.get("afterbillingOutstanding");
			for (Entry<String, String> set : afterPaymentUnbilled.entrySet()) {
				sum = sum + Double.valueOf(set.getValue());
				set.setValue(String.format("%.2f", Double.valueOf(set.getValue()) - Double.valueOf(set.getValue())));
			}
			afterPaymentBilled.replace("BilledPayment", String.format("%.2f", sum));
			compareMaps(afterPaymentBilled, afterBillingBilled);
			compareMaps(afterPaymentUnbilled, afterBillingUnbilled);
			compareMaps(afterPaymentOutstanding, afterBillingOutstanding);
		}
		if (payment.equalsIgnoreCase("after MAD payment")) {
			Map<String, String> afterBillingBilled = context.get("afterbillingBilled");
			Map<String, String> afterBillingUnbilled = context.get("afterbillingUnbilled");
			Map<String, String> afterBillingOutstanding = context.get("afterbillingOutstanding");
			beforePaymentUnbilled.replace("UnbilledPayment", String.format("%.2f", Double.valueOf(context.get(ContextConstants.MINIMUM_PAYMENT_DUE))));
			logger.info("UnbilledPayment after MAD->"+beforePaymentUnbilled.get("UnbilledPayment"));
			double rem=Double.valueOf(context.get(ContextConstants.TOTAL_PAYMENT_DUE))-Double.valueOf(context.get(ContextConstants.MINIMUM_PAYMENT_DUE));
			beforePaymentOutstanding.replace("OutstandingPurchase", String.format("%.2f",Double.valueOf(rem)));
			logger.info("OutstandingPurchase after MAD->"+beforePaymentOutstanding.get("OutstandingPurchase"));
			context.put(ContextConstants.TOTAL_PAYMENT_DUE,String.format("%.2f",Double.valueOf(rem)));
			compareMaps(afterPaymentBilled, afterBillingBilled);
			compareMaps(afterPaymentUnbilled, afterBillingUnbilled);
			compareMaps(afterPaymentOutstanding, afterBillingOutstanding);
		}

	}

	private void compareMaps(Map<String, String> expectedMap, Map<String, String> actualMap) {
		for (Map.Entry<String, String> m : actualMap.entrySet()) {
			String keyFromFirstMap = (String) m.getKey();
			String valueFromFirstMap = (String) m.getValue();
			String valueFromSecondMap = expectedMap.get(keyFromFirstMap);
			logger.info("Comparing values-> " + keyFromFirstMap + ": Expected:" + valueFromFirstMap + ": Actual:"
					+ valueFromSecondMap);
			if (!valueFromSecondMap.equals(valueFromFirstMap)) {
				Assert.assertEquals("Failed in Comparing at ", keyFromFirstMap + ": Expected:" + valueFromFirstMap,
						": Actual:" + valueFromSecondMap);
			}
		}
	}

	public String verifyUnpaidAndAuthFlag(Device device, String label) {
		List<String> lst = new ArrayList<String>();
		SimulatorUtilities.wait(5000);
		editDeviceLink.click();
		SimulatorUtilities.wait(1000);
		clickWhenClickable(currentStatusAndLimitTab);
		SimulatorUtilities.wait(2000);
		lst.add(Element("//span[contains(text(),'"+label+" :')]//ancestor::tr//td["+resolve(device.getCategory())+"]/span/span").getText());
		clickEndCall();
		return lst.get(0);
	}

	public HashMap<String,BigDecimal> activateCreditLimitChangeRequest(HelpdeskGeneral helpdeskGeneral){
		logger.info("credit limit change request: {}",helpdeskGeneral.getCardPackId());
		selectServiceCode(helpdeskGeneral.getServiceCode());
		HashMap<String,BigDecimal> crediLimit = new HashMap<>();
		clickGoButton();
		if(ProductType.INDIVIDUAL.contains(helpdeskGeneral.getCustomerType()))
			return creditLimitChangeRequestIndividual(helpdeskGeneral,crediLimit);
		else if(ProductType.CORPORATE.contains(helpdeskGeneral.getCustomerType()))
			return creditLimitChangeRequestCorporate(helpdeskGeneral,crediLimit);
		
		return new HashMap<String,BigDecimal>();
	}
	
	
	public HashMap<String,BigDecimal> creditLimitChangeRequestCorporate(HelpdeskGeneral helpdeskGeneral,HashMap<String,BigDecimal> creditLimit){
		runWithinPopup(ConstantData.CREDIT_LIMIT_CHANGE_COMMERCIAL_CARDS, ()->{
			selectLimitType(helpdeskGeneral.getLimitType());
			enterNewCreditLimit(new BigDecimal(helpdeskGeneral.getNewCreditLimit()).stripTrailingZeros().toPlainString());		
			creditLimit.put(ConstantData.CARD_LIMIT,new BigDecimal(helpdeskGeneral.getNewCreditLimit()));	
			creditLimit.put(ConstantData.AVAIL_CARD_LIMIT,new BigDecimal(helpdeskGeneral.getNewCreditLimit()));		
			enterNotes(helpdeskGeneral.getNotes());
			clickSaveButton();
			verifyOperationStatus();
			clickOKButtonPopup();
		});			
		SimulatorUtilities.wait(5000);
		clickCurrentStatusAndLimitsTab();
		clickEndCall();
		return creditLimit;
	}
	
	public HashMap<String,BigDecimal> creditLimitChangeRequestIndividual(HelpdeskGeneral helpdeskGeneral,HashMap<String,BigDecimal> creditLimit){
		runWithinPopup(ConstantData.CREDIT_LIMIT_CHANGE_REQUEST, ()->{
			selectLimitType(helpdeskGeneral.getLimitType());			
			enterClientCreditLimit(new BigDecimal(helpdeskGeneral.getClientCreditLimit()).stripTrailingZeros().toPlainString());
			enterAccountCreditLimit(new BigDecimal(helpdeskGeneral.getAccountCreditLimit()).stripTrailingZeros().toPlainString());			
			enterNewCreditLimit(new BigDecimal(helpdeskGeneral.getNewCreditLimit()).stripTrailingZeros().toPlainString());	
			
			if(helpdeskGeneral.getLimitType().equalsIgnoreCase(ConstantData.TEMPORARY_LIMIT))
			{
				WebElementUtils.pickDate(effectiveDateTxt, LocalDate.now());
				WebElementUtils.pickDate(endDateTxt, LocalDate.now());
				creditLimit.put(ConstantData.AVAIL_CLIENT_LIMIT,new BigDecimal(helpdeskGeneral.getClientCreditLimit()));
				creditLimit.put(ConstantData.AVAIL_ACCOUNT_LIMIT,new BigDecimal(helpdeskGeneral.getAccountCreditLimit()));
				creditLimit.put(ConstantData.AVAIL_CARD_LIMIT,new BigDecimal(helpdeskGeneral.getNewCreditLimit()));		
			}
			else if(helpdeskGeneral.getLimitType().equalsIgnoreCase(ConstantData.PERMANENT_LIMIT))
			{					
				creditLimit.put(ConstantData.CLIENT_LIMIT,new BigDecimal(helpdeskGeneral.getClientCreditLimit()));
				creditLimit.put(ConstantData.AVAIL_CLIENT_LIMIT,new BigDecimal(helpdeskGeneral.getClientCreditLimit()));
				creditLimit.put(ConstantData.ACCOUNT_LIMIT,new BigDecimal(helpdeskGeneral.getAccountCreditLimit()));
				creditLimit.put(ConstantData.AVAIL_ACCOUNT_LIMIT,new BigDecimal(helpdeskGeneral.getAccountCreditLimit()));
				creditLimit.put(ConstantData.CARD_LIMIT,new BigDecimal(helpdeskGeneral.getNewCreditLimit()));	
				creditLimit.put(ConstantData.AVAIL_CARD_LIMIT,new BigDecimal(helpdeskGeneral.getNewCreditLimit()));			
			}
			enterNotes(helpdeskGeneral.getNotes());
			clickSaveButton();
			verifyOperationStatus();
			clickOKButtonPopup();
		});		
		SimulatorUtilities.wait(5000);
		clickCurrentStatusAndLimitsTab();
		clickEndCall();
		return creditLimit;
	}
	
	public void blockDevice(HelpdeskGeneral helpdeskGeneral) {
		selectServiceCode(helpdeskGeneral.getServiceCode());
		clickGoButton();
		runWithinPopup(BLOCK_DEVICE_TITLE, () -> {
			enterNotes(helpdeskGeneral.getNotes());
			clickSaveButton();
			verifyOperationStatus();
			clickOKButtonPopup();
		});
		SimulatorUtilities.wait(3000);
		clickEndCall();
	}
	
	public List<LoanDetails>  retailTransactionToLoan(HelpdeskGeneral helpdeskGeneral,LoanPlan loanPlan,TransactionSearchDetails transactionDetails){
		List<LoanDetails> loanDetails = new ArrayList<>();		
		selectServiceCode(helpdeskGeneral.getServiceCode());
		clickGoButton();
		runWithinPopup(ConstantData.RETAIL_TO_LOAN, ()->{			
			selectLoanPlan(loanPlan.getLoanPlanDescription() + " " + "[" + loanPlan.getLoanPlanCode() + "]");
			ClickButton(bookLoanBtn);
			SimulatorUtilities.wait(200);
			loanDetails.add(sanctionLoan(transactionDetails));			
			clickWhenClickable(cancelBtn);
		});			

		clickEndCall();
		
		return loanDetails;
	}
	
	public LoanDetails sanctionLoan(TransactionSearchDetails transactionDetails) {		
		LoanDetails loanDetails= new LoanDetails();
		runWithinPopup("Add Retail To Loan Sanction", ()->{	
			String checkBox = String.format("//td//span[text()='%s']/../../following-sibling::td[7]",transactionDetails.getARN());
			String tranAmountLbl = String.format("//td//span[text()='%s']/../../following-sibling::td[6]/span/span",transactionDetails.getARN());
			Element(checkBox).click();
			loanDetails.setTransactionAmount(Element(tranAmountLbl).getText());
			ClickButton(calculateEMIBtn);	
			SimulatorUtilities.wait(1000);		
			elementToBeClickable(sanctionBtn);
			enterNote("Automation");
			noteTxt.click();
			loanDetails.setLoanEMI(emiLbl.getAttribute("value"));
			loanDetails.setProcessingFee(processingFeeLbl.getAttribute("value"));
			loanDetails.setMoratoriumLoan(moratoriumLoanLbl.getAttribute("value"));			
			clickWhenClickable(sanctionBtn);			
			SimulatorUtilities.wait(10000);	
			waitForElementVisible(okBtn);
			elementToBeClickable(okBtn);
			clickWhenClickable(okBtn);			
		});			
		
		return loanDetails;
	}

	
	public String raiseLoanCancellationRequest(HelpdeskGeneral helpdeskGeneral, LoanPlan loanPlan, Device device) {
		selectServiceCode(helpdeskGeneral.getServiceCode());
		clickGoButton();
		runWithinPopup("243 - Loan Cancellation", ()->{	
			selectLoanPlan(loanPlan.getLoanPlanDescription() + " " + "[" + loanPlan.getLoanPlanCode() + "]");
			selectLoanAccountNumber(device.getLoanAccountNumber());
			clickCancelLoanButton();
			cancellationFee=processLoanCancel();
			clickWhenClickable(cancelBtn);
		});			

		clickEndCall();	
		return cancellationFee;
	}

	private String processLoanCancel() {
		SimulatorUtilities.wait(500);
		runWithinPopup("Process Loan Cancel", ()->{	
			SimulatorUtilities.wait(500);
			logger.info("Loan Cancellation fee:{}",txtCancellationFee.getAttribute("value"));
			cancellationFee=txtCancellationFee.getAttribute("value");
			enterNote(MiscUtils.randomAlphabet(10));
			SimulatorUtilities.wait(3000);	
			clickWhenClickable(processBtn);	
			SimulatorUtilities.wait(1000);
			if (getErrorMessage() != null) {
				cancellationFee = getErrorMessage() ;
				clickCancelButton();
			} else {
				waitForElementVisible(okBtn);
				elementToBeClickable(okBtn);
				clickWhenClickable(okBtn);
			}
		
		});	
		return cancellationFee;
	}

	private void clickCancelLoanButton() {
		clickWhenClickable(cancelLoanBtn);
	}

	private void selectLoanAccountNumber(String loanAccountNumber) {
		WebElementUtils.selectDropDownByVisibleText(selectLoanAccountNumberDdwn, loanAccountNumber);
	}

	public String getDeclineCodeForTransaction(Device device, String rrnNumber){
		logger.info("Fetching information for : {}", device.getDeviceNumber());
		searchByDeviceNumber(device);
		SimulatorUtilities.wait(5000);
		clickWhenClickable(editDeviceLink);
		clickWhenClickable(btnAuthorization);
		serachAuthorizationRecord(rrnNumber);
		runWithinPopup(AUTHORIZATION, () -> {
			Element("//span[contains(text(),'"+rrnNumber+"')]/..").click();
		});
		String getDeclineCode = getTransactionStatus();
		runWithinPopup(AUTHORIZATION, () -> {
			clickCloseButton();
		});
		SimulatorUtilities.wait(2000);
		clickEndCall();
		SimulatorUtilities.wait(2000);
		return getDeclineCode;
	}

	private String getTransactionStatus() {
		List<String> lst = new ArrayList<String>();
		runWithinPopup(VIEW_AUTHORIZATION, () -> {
			lst.add(getTextFromPage(labelDeclineReason));
			clickCloseButton();
		});
		return lst.get(0);
	}

	/***
	 * This method is used to search authorization record without closing view authorization frame
	 * @param rrnNumber : RRN for  transaction
	 * */
	private void serachAuthorizationRecord(String rrnNumber) {
		runWithinPopup(AUTHORIZATION, () -> {
			WebElementUtils.pickDate(txtAuthorizationDateFrom, LocalDate.now());
			WebElementUtils.pickDate(txtAuthorizationDateTo, LocalDate.now());
			clickSearchButton();
			SimulatorUtilities.wait(3000);
		});
	}

	public String raiseLoanPreclosureRequest(HelpdeskGeneral helpdeskGeneral, LoanPlan loanPlan, Device device) {
		selectServiceCode(helpdeskGeneral.getServiceCode());
		clickGoButton();
		runWithinPopup("242 - Loan Preclosure", ()->{	
			selectLoanPlan(loanPlan.getLoanPlanDescription() + " " + "[" + loanPlan.getLoanPlanCode() + "]");
			selectLoanAccountNumber(device.getLoanAccountNumber());
			clickWhenClickable(preCloseLoanBtn);	
			preclosureFee=processLoanPreClosure();
			clickWhenClickable(cancelBtn);
		});			

		clickEndCall();	
		return preclosureFee;
	}


	private String processLoanPreClosure() {
		SimulatorUtilities.wait(500);
		runWithinPopup("Process Loan Pre-Closure", ()->{	
			SimulatorUtilities.wait(500);
			preclosureFee=preclosureFeeTxt.getAttribute("value");
			enterNote(MiscUtils.randomAlphabet(10));
			SimulatorUtilities.wait(3000);	
			clickWhenClickable(processBtn);	
			waitForElementVisible(okBtn);
			elementToBeClickable(okBtn);
			clickWhenClickable(okBtn);	
		});	
		return preclosureFee;
	}
	
	public void clickLoyaltyBtn() {
		WebElementUtils.scrollDown(driver(), 0, 250);
		new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.elementToBeClickable(loyaltyBtn)).click();
	}
	
	public void clickEditDeviceLink() {
		editDeviceLink.click();
	}
	
	public void cancelDevice(HelpdeskGeneral helpdeskGeneral) {
		selectServiceCode(helpdeskGeneral.getServiceCode());
		clickGoButton();
		runWithinPopup(DEVICE_CLOSURE_TITLE, () -> {
			enterNotes(helpdeskGeneral.getNotes());
			clickSaveButton();
			runWithinPopup("Confirmation Message", this::clickYesButton);
			verifyOperationStatus();
			clickOKButtonPopup();
		});
		SimulatorUtilities.wait(3000);
		clickEndCall();
	}
	
	public Map<String, String> getLoyaltyDetails() {
		points = new HashMap<String, String>();
		runWithinPopup(LOYALTY_DETAILS, () -> {
			points.put(Constants.POINTS_EARNED, pointsEarned.getText());
			points.put(Constants.AVAILABLE_LOYALTY_POINTS, availableLoyaltyPoints.getText());
			points.put(Constants.ACCUMULATED_REVERSED_POINTS, accumulatedReversedPoints.getText());
			clickCloseButton();
		});
		SimulatorUtilities.wait(3000);
		clickEndCall();
		return points;
	}

	public String raiseLoanCancellationRequestToVerifyErroMessage(HelpdeskGeneral helpdeskGeneral, LoanPlan loanPlan,
		Device device) {
		selectServiceCode(helpdeskGeneral.getServiceCode());
		clickGoButton();
		runWithinPopup("243 - Loan Cancellation", () -> {
			selectLoanPlan(loanPlan.getLoanPlanDescription() + " " + "[" + loanPlan.getLoanPlanCode() + "]");
			selectLoanAccountNumber(device.getLoanAccountNumber());
			clickCancelLoanButton();
			errorMsgOfloanCancellation = processLoanCancel();
			clickWhenClickable(cancelBtn);
		});

		clickEndCall();
		SimulatorUtilities.wait(1000);
		return errorMsgOfloanCancellation;
	}

	public void addServiceRequest(HelpdeskGeneral helpdeskGeneral,
			MCWebElement element, String frame, boolean isNewDevice) {
		editFirstRecord();
		SimulatorUtilities.wait(2000);
		selectServiceCode(helpdeskGeneral.getServiceCode());
		SimulatorUtilities.wait(500);
		clickGoButton();
		SimulatorUtilities.wait(2000);
		runWithinPopup(
				frame,
				() -> {
					if (isNewDevice) {
						selectNewDeviceCheckBox(isNewDevice);
						SimulatorUtilities.wait(2000);
						selectReasonForRequest(element,
								helpdeskGeneral.getReason());
					} else {
						selectReasonForRequest(element,
								helpdeskGeneral.getReason());
						if (helpdeskGeneral.getServiceCode().equals(
								Constants.INSTANT_REPLACE_DEVICE)) {
							DeviceDetails deviceDetails = context
									.get(ContextConstants.DEVICE_DETAILS);
							enterNewPackID(deviceDetails.getCardPackID());
						}
					}
					enterNotes(helpdeskGeneral.getNotes());
					clickSaveButton();
					verifyOperationStatus();
					clickOKButtonPopup();
				});
		SimulatorUtilities.wait(5000);
		clickEndCall();
	}

	public MCWebElement getReplaceDeviceRequestReasonDdwn() {
		return replaceDeviceRequestReasonDDwn;
	}

	public MCWebElement getstoplistReasonDDwn() {
		return stoplistReasonDDwn;
	}

	public void selectNewDeviceCheckBox(boolean value) {
		ClickCheckBox(chkBxNewDeviceNumber, value);
	}

	public void selectReasonForRequest(MCWebElement webelement, String reason) {
		WebElementUtils.selectDropDownByVisibleText(webelement, reason);
	}

	public void enterNewPackID(String newPackID) {
		WebElementUtils.enterText(txtnewPackID, newPackID);
	}

	public void withdrawDeviceFromStoplist(HelpdeskGeneral helpdeskGeneral) {
		editFirstRecord();
		SimulatorUtilities.wait(5000);
		selectServiceCode(Constants.DEVICE_WITHDRAW_STOPLIST_REQ);
		clickGoButton();
		runWithinPopup("221 - Withdraw Device from Stop-list", () -> {
			selectWithdrawalReason(helpdeskGeneral.getReason());
			selectApplyFeesChkBx(helpdeskGeneral.isFeesApplied());
			enterNotes(helpdeskGeneral.getNotes());
			clickSaveButton();
			verifyOperationStatus();
			clickOKButtonPopup();
		});
		SimulatorUtilities.wait(3000);
		clickEndCall();
	}

	public void selectWithdrawalReason(String reason) {
		WebElementUtils.selectDropDownByVisibleText(withdrawStoplistReasonDDwn,
				reason);
	}

	public void selectApplyFeesChkBx(boolean value) {
		ClickCheckBox(chkBxApplyFees, value);
	}
	
	private String getServiceRequestPopupTitle(String serviceCode){
		return serviceCode.replaceAll("[^0-9]","") + " - " + serviceCode.replaceAll("[^a-zA-Z\\s]","").trim();
	}
	
	public void printResponseMessageLog(){
		logger.info("service request response message : {}", verifyServiceRequestStatus());
	}
}
