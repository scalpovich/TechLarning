package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionSearch;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_SEARCH, CardManagementNav.L2_TRANSACTION,
		CardManagementNav.L3_TRANSACTION_SEARCH })
public class TransactionSearchPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(TransactionSearchPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=microfilmRefNumber]")
	private MCWebElement searchARNTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[.//*[text()='Authorization Status :']]/following-sibling::td[1]")
	private MCWebElement authorizationStatusTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='fromDate']/..")
	private MCWebElement fromDateTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='toDate']/..")
	private MCWebElement toDateTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[text()='Date']/following-sibling::td[2]")
	private MCWebElement dateDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[text()='Product Type']/following-sibling::td[2]")
	private MCWebElement productTypeDDwn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//div[@class='tab_container_privileges']/div/table/tbody/tr[2]/td[4]/span/span")
	private MCWebElement transactionAmout;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:6:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement tranDateDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind="searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement productTypeSelect;

	private String authorizationStatus;
	
	private String transactionAmount = null;
	
	public String searchTransactionWithARN(String arnNumber, TransactionSearch ts) {
		WebElementUtils.selectDDByVisibleText(productTypeDDwn, ts.getProductType());
		WebElementUtils.enterText(searchARNTxt, arnNumber);
		WebElementUtils.selectDropDownByVisibleText(dateDDwn, ts.getDateType());
		WebElementUtils.pickDate(fromDateTxt, LocalDate.now());
		WebElementUtils.pickDate(toDateTxt, LocalDate.now());
		clickSearchButton();
		viewFirstRecord();
		runWithinPopup("View Transactions", () -> {
			logger.info("Retrieving authorization status");
			authorizationStatus = authorizationStatusTxt.getText();
			clickCloseButton();
		});

		return authorizationStatus;
	}
	
	public String searchTransactionWithDeviceNumber(String deviceNumber,TransactionSearch ts){
		WebElementUtils.selectDropDownByVisibleText(productTypeSelect,ts.getProductType());
		WebElementUtils.enterText(searchARNTxt, deviceNumber);
		WebElementUtils.pickDate(fromDateTxt, LocalDate.now());
		WebElementUtils.pickDate(toDateTxt, LocalDate.now());
		WebElementUtils.selectDDByVisibleText(tranDateDDwn,ts.getDateType());		
		clickSearchButton();
		viewFirstRecord();
		runWithinPopup("View Transactions", () -> {
			logger.info("Retrieving transaction Amount");
			transactionAmount = transactionAmout.getText();
			clickCloseButton();
		});

		return transactionAmount;
	}
	
	public String searchTransactionWithArnAndGetFee(String arnNumber, TransactionSearch ts){
		int i;
		WebElementUtils.selectDDByVisibleText(productTypeDDwn, ts.getProductType());
		WebElementUtils.enterText(searchARNTxt, arnNumber);
		WebElementUtils.selectDropDownByVisibleText(dateDDwn,ts.getDateType());
		WebElementUtils.pickDate(fromDateTxt, LocalDate.now());
		WebElementUtils.pickDate(toDateTxt, LocalDate.now());
		clickSearchButton();
		for(i=1;i<4;i++){
			if("2".equals(getCellTextByColumnName(i,"Sequence Number")))
				break;
		}
		return getCellTextByColumnName(i,"Transaction");
	}
	
	public String searchTransactionWithArnAndGetStatus(String arnNumber, TransactionSearch ts){
        int i;
		WebElementUtils.selectDDByVisibleText(productTypeDDwn, ts.getProductType());
        WebElementUtils.enterText(searchARNTxt, arnNumber);
        WebElementUtils.selectDropDownByVisibleText(dateDDwn, ts.getDateType());
        WebElementUtils.pickDate(fromDateTxt, LocalDate.now());
        WebElementUtils.pickDate(toDateTxt, LocalDate.now());
        clickSearchButton();
        for(i=1;i<4;i++){
               if("2".equals(getCellTextByColumnName(i,"Sequence Number")))
                     break;
        }
        return getCellTextByColumnName(i,"Reversal");
	}
	
	public String searchTransactionWithDeviceAndGetStatus(String deviceNumber, TransactionSearch ts){
        int i;
		WebElementUtils.selectDDByVisibleText(productTypeDDwn, ts.getProductType());
        WebElementUtils.enterText(searchARNTxt, deviceNumber);
        WebElementUtils.selectDropDownByVisibleText(dateDDwn, ts.getDateType());
        WebElementUtils.pickDate(fromDateTxt, LocalDate.now());
        WebElementUtils.pickDate(toDateTxt, LocalDate.now());
        clickSearchButton();
        for(i=1;i<4;i++){
               if("2".equals(getCellTextByColumnName(i,"Sequence Number")))
                     break;
        }
        return getCellTextByColumnName(i,"Description");
	}

	
	public void verifyUiOperationStatus() {
		logger.info("Transaction Search");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(searchARNTxt));
	}

}
