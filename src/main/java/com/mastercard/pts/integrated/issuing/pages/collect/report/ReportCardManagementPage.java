package com.mastercard.pts.integrated.issuing.pages.collect.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BatchProcessingReports;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.ReconciliationWorkFlow;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_REPORTS,CardManagementNav.L2_BATCH_PROCESSING })
public class ReportCardManagementPage extends AbstractBasePage{

	

	@Autowired
	private ReconciliationWorkFlow reconciliationWorkFlow;
	@PageElement(findBy = FindBy.NAME, valueToFind = "goButton")
	private MCWebElement goBtn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "componentPanel")
	private MCWebElement selectReportDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "p_product_type:input:dropdowncomponent")
	private MCWebElement productTypeDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "p_file_type:input:dropdowncomponent")
	private MCWebElement fileTypeDDwn;
	
	
	public boolean verifyPhotoReferenceNumberIsPresent(BatchProcessingReports batchProcessingReports,String reportFormatType,String productType){
		selectDropDownByText(selectReportDDwn, "Device Production Detail Report");
		clickWhenClickable(goBtn);
		SimulatorUtilities.wait(500);
		selectByVisibleText(productTypeDDwn,productType);
		selectByVisibleText(fileTypeDDwn, reportFormatType);
		clickSubmitButton();
		SimulatorUtilities.wait(1500);
		return checkPhotoReferenceNumberIsPresent(batchProcessingReports);
	
	}
	
	public boolean checkPhotoReferenceNumberIsPresent(BatchProcessingReports batchProcessingReports) {
		
		return reconciliationWorkFlow.isPhotoReferenceNumberPresentInReport(ConstantData.DEVICE_PRODUCTION_REPORT_PDF_FILE_NAME,batchProcessingReports);
		
	}
	
	
}
