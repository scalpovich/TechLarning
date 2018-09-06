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
public class RAMPReportPage extends AbstractBasePage implements ReportVerificationPage {

	private static final Logger logger = LoggerFactory
			.getLogger(RAMPReportPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "select[name='componentPanel']")
	private MCWebElement selectReportDDwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "span[class=btn_or_span]")
	protected MCWebElement searchButtonElement;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "p_report_type:input:dropdowncomponent")
	private MCWebElement selectReportTypeDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "p_product_type:input:dropdowncomponent")
	private MCWebElement selectProductTypeDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "p_processing_type:input:dropdowncomponent")
	private MCWebElement selectTransactionTypeDDwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "span#p_from_date")
	private MCWebElement fromDatePkr;

	@PageElement(findBy = FindBy.CSS, valueToFind = "span#p_to_date")
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
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "p_high_risk_country_code:input:dropdowncomponent")
	private MCWebElement selectHighRiskCountryDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "p_merchant_loc_code:input:dropdowncomponent")
	private MCWebElement selectHighRiskMerchantLocationDDwn;
	
	private String reportName = "RAMP Report";
	private String type = "ALL";
	private String fileType = "PDF";
	private String recordType = "A-Authorised transactions";

	public void verifyUiOperationStatus() {
		logger.info(reportName);
		verifySearchButton("Go");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(searchButtonElement)
				);
	}

	@Override
	public String generateReport(GenericReport report) {
		// TODO Auto-generated method stub
		selectByVisibleText(selectReportDDwn,reportName);
	    clicksearchButtonElement();
	    selectReportType(report);
	    selectProductType();
	    selectRecordtType();
	    selectTransactionType();
	    selectHighRiskMCCType();
	    selectHighRiskMCCGroupType();
	    selectHighRiskCountryType();
	    selectHighRiskMerchantLocationType();
		WebElementUtils.pickDate(fromDatePkr, LocalDate.now());
		WebElementUtils.pickDate(toDateDPkr, LocalDate.now());
		selectByVisibleText(selectFileTypeDDwn, fileType);
		clickWhenClickable(generateReportBtn);
		verifyNoErrors();
		return verifyReportDownloaded(report.getReportName());
	}
	
	private void selectReportType(GenericReport report){
		selectByVisibleText(selectReportTypeDDwn, report.getReportType());
	}
	
	private void selectProductType(){
		selectByVisibleText(selectProductTypeDDwn, type);
	}
	
	private void selectRecordtType(){
		selectByVisibleText(selectRecordTypeDDwn, recordType);
	}
	
	private void selectTransactionType(){
		SimulatorUtilities.wait(2000);
		if(selectTransactionTypeDDwn.isEnabled())
		selectByVisibleText(selectTransactionTypeDDwn, type);
	}
	
	private void selectHighRiskMCCType(){
		if(selectHighRiskMccDDwn.isEnabled())
			selectByVisibleText(selectHighRiskMccDDwn, type);
	}
	
	private void selectHighRiskMCCGroupType(){
		if(selectHighRiskMccGroupDDwn.isEnabled())
			selectByVisibleText(selectHighRiskMccGroupDDwn, type);
	}
	
	private void selectHighRiskCountryType(){
		if(selectHighRiskCountryDDwn.isEnabled())
			selectByVisibleText(selectHighRiskCountryDDwn, type);
	}
	
	private void selectHighRiskMerchantLocationType(){
		if(selectHighRiskMerchantLocationDDwn.isEnabled())
			selectByVisibleText(selectHighRiskMerchantLocationDDwn, type);
	}
}