package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_REPORTS, CardManagementNav.L2_TRANSACTION_REPORTS })
public class TransactionReportsPage extends AbstractBasePage {

	@Autowired
	private KeyValueProvider provider;

	private static final Logger logger = LoggerFactory.getLogger(TransactionReportsPage.class);

	private static final String ALL = "ALL";

	private static final String BOTH = "Both";

	@PageElement(findBy = FindBy.NAME, valueToFind = "componentPanel")
	private MCWebElement selectReportDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "generateReport")
	private MCWebElement generateReportBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "p_file_type:input:dropdowncomponent")
	private MCWebElement fileTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:3:rows:2:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement fileTypeAuthReportDDwn;
	
	
	
	@PageElement(findBy=FindBy.NAME, valueToFind = "p_product_type:input:dropdowncomponent")
	private MCWebElement productTypeDDwn;
	
	@PageElement(findBy=FindBy.NAME, valueToFind = "p_product_code:input:dropdowncomponent") 
	private MCWebElement programNameDDwn; 
	
	@PageElement(findBy=FindBy.NAME, valueToFind = "tables:1:rows:2:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement productTypeAuthReportDDwn;

	@PageElement(findBy=FindBy.NAME, valueToFind = "tables:1:rows:3:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement programNameAuthReportDDwn;
	
	@PageElement(findBy=FindBy.NAME, valueToFind = "tables:1:rows:2:cols:nextCol:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement authTypeDDwn;
	
	@PageElement(findBy=FindBy.NAME, valueToFind = "tables:1:rows:3:cols:nextCol:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement channelDDwn;
	
	@PageElement(findBy=FindBy.NAME, valueToFind = "tables:1:rows:4:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement transactionTypeDDwn;
	
	@PageElement(findBy=FindBy.NAME, valueToFind = "tables:1:rows:4:cols:nextCol:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement transactionStatusDDwn;
	
	@PageElement(findBy=FindBy.NAME, valueToFind = "tables:1:rows:5:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement transactionOriginDDwn;
	
	@PageElement(findBy=FindBy.NAME, valueToFind = "tables:1:rows:5:cols:nextCol:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement deviceTypeDDwn;
	
	
	public void verifyUiOperationStatus() {
		logger.info("Transaction Reports");
		verifySearchButton("Go");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(selectReportDDwn));
	}

	public void generateProgramWiseBalanceSummaryReport() {
		WebElementUtils.selectDropDownByVisibleText(selectReportDDwn, provider.getString("PROGRAM_WISE_BALANCE_SUMMARY"));
		clicksearchButtonElement();
		WebElementUtils.selectDropDownByVisibleText(fileTypeDDwn, provider.getString("FILE_TYPE_REPORT"));
		generateReportBtn.click();
	}

	public void generateTransactionAuthReport() {
		WebElementUtils.selectDropDownByVisibleText(selectReportDDwn, provider.getString("PROGRAM_TRANSACTION_SUMMARY"));
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


		WebElementUtils.selectDropDownByVisibleText(fileTypeAuthReportDDwn, provider.getString("FILE_TYPE_REPORT"));
		generateReportBtn.click();
	}
}