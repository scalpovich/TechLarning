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
import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_REPORTS, CardManagementNav.L2_TRANSACTION_REPORTS})

public class TransactionReportsPage extends AbstractModelPage {
	
	@Autowired
	private KeyValueProvider provider;

	private static final Logger logger = LoggerFactory
			.getLogger(TransactionReportsPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "componentPanel")
	private MCWebElement selectReportDDwn;
	
	@PageElement(findBy=FindBy.NAME, valueToFind = "generateReport")
	private MCWebElement generateReportBtn;
	
	@PageElement(findBy=FindBy.NAME, valueToFind = "p_file_type:input:dropdowncomponent")
	private MCWebElement fileTypeDrpDwn;
	
	public void verifyUiOperationStatus() {
		logger.info("Transaction Reports");
		verifySearchButton("Go");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(selectReportDDwn)
				);
	}
	
	public void generateProgramWiseBalanceSummaryReport() 
	{
		WebElementUtils.selectDropDownByVisibleText(selectReportDDwn, provider.getString("PROGRAM_WISE_BALANCE_SUMMARY"));
		clicksearchButtonElement();
		WebElementUtils.selectDropDownByVisibleText(fileTypeDrpDwn, provider.getString("FILE_TYPE_REPORT"));
		generateReportBtn.click();
	}
}