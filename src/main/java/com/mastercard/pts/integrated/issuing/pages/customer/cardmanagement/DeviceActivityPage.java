package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.GenericReport;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_REPORTS, CardManagementNav.L2_DEVICE_ACTIVITY})

public class DeviceActivityPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(DeviceActivityPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "componentPanel")
	private MCWebElement selectReportDDwn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[contains(text(), 'Product Type')]/../../td[2]//select")
	private MCWebElement productTypeDDwn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[contains(text(), 'Report Type')]/../../td[2]//select")
	private MCWebElement reportTypeDDwn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[contains(text(), 'Program')]/../../td[4]//select")
	private MCWebElement programDDwn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[contains(text(), 'File Type')]/../../td[2]//select")
	private MCWebElement fileTypeDDwn; 
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "generateReport")
	private MCWebElement generateReportBtn;  
	
	private static final String DEVICE_ACTIVITY_REPORT = "Device Activity Report";

	private static final String DELIVERED_KYC_NOT_DONE = "Delivered but KYC Not Done";

	public void verifyUiOperationStatus() {
		logger.info("Device Activity");
		verifySearchButton("Go");
	}
	
	public String generateDeviceActivityReport(Device device, GenericReport report, Program program) {
		WebElementUtils.selectDropDownByVisibleText(selectReportDDwn, DEVICE_ACTIVITY_REPORT);
		clicksearchButtonElement();
		String productType = device.getAppliedForProduct();
		String[] arrSplit = productType.split(" ");
		WebElementUtils.selectDropDownByVisibleText(productTypeDDwn, arrSplit[0]);
		WebElementUtils.selectDropDownByVisibleText(reportTypeDDwn, DELIVERED_KYC_NOT_DONE);
		selectByVisibleText(programDDwn, program.getCode());
		WebElementUtils.selectDropDownByVisibleText(fileTypeDDwn, "PDF Format [pdf]");
		generateReportBtn.click();
		return verifyReportDownloaded(report.getReportName());
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(selectReportDDwn)
				);
	}
}