package com.mastercard.pts.integrated.issuing.pages.customer.administration;
import java.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.admin.AuditReport;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = AdministrationNav.TAB_ADMINISTRATION, treeMenuItems = {
		AdministrationNav.L1_REPORTS,
		AdministrationNav.L2_AUDIT_REPORT
		})
public class AuditReportPage extends AbstractBasePage{

	private static final Logger logger = LoggerFactory
			.getLogger(AuditReportPage.class);
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "componentPanel")
	private MCWebElement selectReportDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "goButton")
	private MCWebElement goBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='p_operation']//select")
	private MCWebElement operationDDwn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='p_user_id']//select")
	private MCWebElement userIdDDwn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='p_screen_id']//select")
	private MCWebElement screenNameDDwn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='p_file_type']//select")
	private MCWebElement fileTypeDDwn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='p_report_generation_mode']//select")
	private MCWebElement reportGenerationModeDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "generateReport")
	private MCWebElement submitBtn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='p_from_date']/../..")
	private MCWebElement fromDateDPkr;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='p_to_date']/../..")
	private MCWebElement toDateDPkr;

	public void selectReport(AuditReport auditreport)
	{
		selectByVisibleText(selectReportDDwn, auditreport.getReportName());
	}
	public void clickGoButton()
	{
		ClickButton(goBtn);
	}
	public void selectOperation(AuditReport auditreport)
	{
		selectByVisibleText(operationDDwn, auditreport.getOperation());
	}
	public void selectUserId(AuditReport auditreport)
	{
		selectByVisibleText(userIdDDwn, auditreport.getUserId());
	}
	public void selectScreenName(AuditReport auditreport)
	{
		selectByVisibleText(screenNameDDwn, auditreport.getScreenName());
	}
	public void selectFileType(AuditReport auditreport)
	{
		selectByVisibleText(fileTypeDDwn, auditreport.getFileType());
	}
	public void selectReportGenerationMode(AuditReport auditreport)
	{
		selectByVisibleText(reportGenerationModeDDwn, auditreport.getReportGenerationMode());
	}
	@Override
	public void clickSubmitButton()
	{
		ClickButton(submitBtn);
	}
	
	public void enterFromAndTODate()
	{
		WebElementUtils.pickDate(fromDateDPkr, LocalDate.now());
		WebElementUtils.pickDate(toDateDPkr, LocalDate.now());
	}
}
