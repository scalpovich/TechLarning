package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WebAPIReports;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.DatePicker;
import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_REPORTS,
		CardManagementNav.L2_TRANSACTION_REPORTS })
public class TransactionReportsPage extends AbstractBasePage {

	@Autowired
	private KeyValueProvider provider;

	private static final Logger logger = LoggerFactory.getLogger(TransactionReportsPage.class);

	private static final String ALL = "ALL";

	private static final String BOTH = "Both";

	private static final String FILE_TYPE_REPORT = "FILE_TYPE_REPORT";

	@PageElement(findBy = FindBy.NAME, valueToFind = "componentPanel")
	private MCWebElement selectReportDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "generateReport")
	private MCWebElement generateReportBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "p_file_type:input:dropdowncomponent")
	private MCWebElement fileTypeDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[contains(text(), 'File Type')]/../../td[2]//select")
	private MCWebElement fileTypeAuthReportDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "p_product_type:input:dropdowncomponent")
	private MCWebElement productTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "p_product_code:input:dropdowncomponent")
	private MCWebElement programNameDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[contains(text(), 'Product Type')]/../../td[2]//select")
	private MCWebElement productTypeAuthReportDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[contains(text(), 'Program Name')]/../../td[2]//select")
	private MCWebElement programNameAuthReportDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[contains(text(), 'Authorization Type')]/../../td[4]//select")
	private MCWebElement authTypeDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[contains(text(), 'Channel')]/../../td[4]//select")
	private MCWebElement channelDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[contains(text(), 'Transaction Type')]/../../td[2]//select")
	private MCWebElement transactionTypeDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[contains(text(), 'Transaction Status')]/../../td[4]//select")
	private MCWebElement transactionStatusDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[contains(text(), 'Transaction Origin')]/../../td[2]//select")
	private MCWebElement transactionOriginDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:2:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement transactionCodeDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[contains(text(), 'Device Type')]/../../td[4]//select")
	private MCWebElement deviceTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:2:rows:2:cols:nextCol:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement productTypeClearingReportDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:5:cols:nextCol:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement dateTypeDDwn;

	public String calelement = "//td[2]";

	private final String transactionDetailReport = "Transaction Detail Report";

	@Autowired
	DatePicker date;

	public void verifyUiOperationStatus() {
		logger.info("Transaction Reports");
		verifySearchButton("Go");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(selectReportDDwn));
	}

	public void generateProgramWiseBalanceSummaryReport() {
		WebElementUtils.selectDropDownByVisibleText(selectReportDDwn,
				provider.getString("PROGRAM_WISE_BALANCE_SUMMARY"));
		clicksearchButtonElement();
		WebElementUtils.selectDropDownByVisibleText(fileTypeDDwn, provider.getString(FILE_TYPE_REPORT));
		SimulatorUtilities.wait(10000);
		generateReportBtn.click();
	}

	public void generateTransactionAuthReport() {
		WebElementUtils.selectDropDownByVisibleText(selectReportDDwn,
				provider.getString("PROGRAM_TRANSACTION_SUMMARY"));
		clicksearchButtonElement();
		WebElementUtils.selectDropDownByVisibleText(productTypeAuthReportDDwn, ALL);
		WebElementUtils.selectDropDownByVisibleText(programNameAuthReportDDwn, ALL);
		WebElementUtils.selectDropDownByVisibleText(authTypeDDwn, ALL);
		WebElementUtils.selectDropDownByVisibleText(channelDDwn, ALL);
		WebElementUtils.selectDropDownByVisibleText(transactionTypeDDwn, ALL);
		WebElementUtils.selectDropDownByVisibleText(transactionStatusDDwn, BOTH);
		WebElementUtils.selectDropDownByVisibleText(transactionOriginDDwn, BOTH);
		WebElementUtils.selectDropDownByVisibleText(deviceTypeDDwn, ALL);
		WebElementUtils.selectDropDownByVisibleText(programNameAuthReportDDwn, ALL);
		WebElementUtils.selectDropDownByVisibleText(fileTypeAuthReportDDwn, provider.getString(FILE_TYPE_REPORT));
		generateReportBtn.click();
		CustomUtils.ThreadDotSleep(20000);
	}

	public void generateTransactionClearingReport() {
		WebElementUtils.selectDropDownByVisibleText(selectReportDDwn, provider.getString("ALL_TRANSACTIONS_REPORT"));
		clicksearchButtonElement();
		WebElementUtils.selectDropDownByVisibleText(productTypeClearingReportDDwn, ALL);
		WebElementUtils.selectDropDownByVisibleText(fileTypeAuthReportDDwn, provider.getString(FILE_TYPE_REPORT));
		generateReportBtn.click();
	}

	public void generateWebAPIServiceDetailReport(WebAPIReports webapiReport) {
		selectByVisibleText(selectReportDDwn, "WEB API Services Details Report");
		clicksearchButtonElement();
		WebElementUtils.selectDropDownByVisibleText(productTypeAuthReportDDwn, webapiReport.getReportType());
		selectCalender();
		selectByVisibleText(fileTypeAuthReportDDwn, webapiReport.getReportFormat());
		generateReportBtn.click();
	}

	public void selectCalender() {
		String[] dateTransReportCal1 = DateUtils.getDateinDDMMYYYY().split("/");
		int newdate = Integer.parseInt(dateTransReportCal1[1]);
		int i = newdate - 1;
		dateTransReportCal1[1] = String.valueOf(i);
		String date11 = dateTransReportCal1[0] + "/" + dateTransReportCal1[1] + "/" + dateTransReportCal1[2];
		date.setDate(date11);
		waitForPageToLoad(getFinder().getWebDriver());
		date.setDateCalendar2(DateUtils.getDateinDDMMYYYY(), calelement);
		waitForPageToLoad(getFinder().getWebDriver());
	}

	public void generateReport(String reportType){
		WebElementUtils.selectDropDownByVisibleText(selectReportDDwn, reportType);
		clicksearchButtonElement();
		if(reportType.equalsIgnoreCase(transactionDetailReport)){
			WebElementUtils.selectDropDownByVisibleText(productTypeAuthReportDDwn, ALL);
			WebElementUtils.selectDropDownByVisibleText(dateTypeDDwn, ALL);
			WebElementUtils.selectDropDownByVisibleText(fileTypeAuthReportDDwn, provider.getString(FILE_TYPE_REPORT));
		}
		generateReportBtn.click();
		SimulatorUtilities.wait(10000);
	}


}