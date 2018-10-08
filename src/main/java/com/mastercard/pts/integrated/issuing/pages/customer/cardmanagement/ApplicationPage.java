package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
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
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_REPORTS, CardManagementNav.L2_REPORTS_APPLICATION })
public class ApplicationPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(ApplicationPage.class);
	
	@Autowired
	private KeyValueProvider provider;
    
	@Autowired
	TestContext context;
	
	@Autowired
	DatePicker date;
	
	public String calelement = "//td[2]";
	
	private static final String FILE_TYPE_REPORT = "FILE_TYPE_REPORT";
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "componentPanel")
	private MCWebElement selectReportDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "generateReport")
	private MCWebElement generateReportBtn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='p_product_type']/select")
	private MCWebElement productTypeAuthReportDDwn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='P_Program_Code']/select")
	private MCWebElement programNameAuthReportDDwn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='p_file_type']/select")
	private MCWebElement fileTypeAuthReportDDwn;
	
	private static String applicationRejectReport = "Application Reject Report";
	
	private static String txtFileType = "PDF Format [pdf]";

	public String generateApplicationRejectReport(String reportFileName) {
		WebElementUtils.selectDropDownByVisibleText(selectReportDDwn, applicationRejectReport);
		clicksearchButtonElement();
		Device device = context.get(ContextConstants.DEVICE);
		Program program = context.get(ContextConstants.PROGRAM);
		selectByVisibleText(productTypeAuthReportDDwn, device.getProductType().split(" ")[0]);
		selectByVisibleText(programNameAuthReportDDwn, program.getProgramCode());
		WebElementUtils.selectDropDownByVisibleText(fileTypeAuthReportDDwn, txtFileType);
		SimulatorUtilities.wait(5000);
		generateReportBtn.click();
		return verifyReportDownloaded(reportFileName);
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
	
	public void verifyUiOperationStatus() {
		logger.info("Application");
		verifySearchButton("Go");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(selectReportDDwn));
	}
}