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

	// private static final String THREE_D_SECURE_INFO_REPORT = "328-3-D Secure
	// Information Report";

	private static final String PDF_REPORT = "PDF Format [pdf]";

	@PageElement(findBy = FindBy.NAME, valueToFind = "componentPanel")
	private MCWebElement selectReportDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "generateReport")
	private MCWebElement generateReportBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "p_file_type:input:dropdowncomponent")
	private MCWebElement fileTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:3:rows:2:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement fileTypeAuthReportDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "p_product_type:input:dropdowncomponent")
	private MCWebElement productTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "p_product_code:input:dropdowncomponent")
	private MCWebElement programNameDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:2:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement productTypeAuthReportDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:3:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement programNameAuthReportDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:2:cols:nextCol:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement authTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:3:cols:nextCol:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement channelDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:4:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement transactionTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:4:cols:nextCol:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement transactionStatusDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:5:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement transactionOriginDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:2:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement transactionCodeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:5:cols:nextCol:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement deviceTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:2:rows:2:cols:nextCol:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement productTypeClearingReportDDwn;

	public String calelement = "//td[2]";

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
		CustomUtils.ThreadDotSleep(10000);
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
		String[] date22 = DateUtils.getDateinDDMMYYYY().split("/");
		int newdate = Integer.parseInt(date22[1]);
		int i = newdate - 1;
		date22[1] = String.valueOf(i);
		String date11 = date22[0] + "/" + date22[1] + "/" + date22[2];
		date.setDate(date11);
		// date.setDate(date11);
		waitForPageToLoad(getFinder().getWebDriver());
		date.setDateCalendar2(DateUtils.getDateinDDMMYYYY(), calelement);
		waitForPageToLoad(getFinder().getWebDriver());
	}

}