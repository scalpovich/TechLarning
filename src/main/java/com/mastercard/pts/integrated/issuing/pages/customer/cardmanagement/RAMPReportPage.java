package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.GenericReport;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_REPORTS, CardManagementNav.L2_RAMP_REPORT})

public class RAMPReportPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(RAMPReportPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "componentPanel")
	private MCWebElement selectReportDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "p_report_type:input:dropdowncomponent")
	private MCWebElement selectReportTypeDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "p_product_type:input:dropdowncomponent")
	private MCWebElement selectProductTypeDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "p_processing_type:input:dropdowncomponent")
	private MCWebElement selectTransactionTypeDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "p_from_date:input:dateTextField")
	private MCWebElement fromDatePkr;

	@PageElement(findBy = FindBy.NAME, valueToFind = "p_to_date:input:dateTextField")
	private MCWebElement toDateDPkr;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "p_file_type:input:dropdowncomponent")
	private MCWebElement selectFileTypeDDwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input#generateReport")
	private MCWebElement generateReportBtn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "p_record_type:input:dropdowncomponent")
	private MCWebElement selectRecordTypeDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "p_high_risk_mcc_code:input:dropdowncomponent")
	private MCWebElement selectHighRiskMccDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "p_high_risk_mcc_group:input:dropdowncomponent")
	private MCWebElement selectHighRiskMccGroupDDwn;

	public void verifyUiOperationStatus() {
		logger.info("RAMP Report");
		verifySearchButton("Go");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(selectReportDDwn)
				);
	}
	
	public void generateReport(){
		selectDropDownByIndex(selectReportDDwn,1);
	    clicksearchButtonElement();
	    selectByVisibleText(selectReportTypeDDwn, "REP05");
	    selectByVisibleText(selectProductTypeDDwn, "ALL");
	    selectByVisibleText(selectRecordTypeDDwn, "A-Authorised transactions");
	    selectByVisibleText(selectTransactionTypeDDwn, "ALL");
	    selectByVisibleText(selectHighRiskMccDDwn, "ALL");
	    selectByVisibleText(selectHighRiskMccGroupDDwn, "ALL");
		WebElementUtils.pickDate(fromDatePkr, LocalDate.now());
		WebElementUtils.pickDate(toDateDPkr, LocalDate.now());
		selectByVisibleText(selectFileTypeDDwn, "PDF");
		clickWhenClickable(generateReportBtn);
	}
}