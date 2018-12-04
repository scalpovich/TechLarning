package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collection;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BatchJobHistory;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ProcessBatches;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.DatePicker;
import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_SEARCH,
		CardManagementNav.L2_BATCH_JOB_HISTORY })
public class BatchJobHistoryPage extends AbstractBasePage {

	@Autowired
	TestContext context;
	private static final Logger logger = LoggerFactory.getLogger(BatchJobHistoryPage.class);
	
	private static final String FILE_NAME ="File Name";
	
	private static final String STATUS ="Status";

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement batchTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement batchDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name='searchDiv:rows:2:componentList:0:componentPanel:input:dateTextField']/../..")
	private MCWebElement fromJobStartDttmDPkr;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name='searchDiv:rows:2:componentList:1:componentPanel:input:dateTextField']/../..")
	private MCWebElement toJobStartDttmDPkr;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=jobId]")
	private MCWebElement jobIdTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:3:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement statusDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:4:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement executionModeDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id = 'jobStatusCd']//span")
	private MCWebElement statusTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@type = 'reset'][@value ='Close']")
	private MCWebElement closeBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@class = 'searchButton']//input[@type= 'submit'][@value ='Search']")
	private MCWebElement searchBtn;
	
	public String calElement = "//td[7]";
	
	@Autowired
	DatePicker date;


	public void switchToViewBatchDetailsFrame() {
		switchToIframe(Constants.VIEW_BATCH_DETAILS_FRAME);
	}

	public void selectbatchType(BatchJobHistory batchjobhist) {
		selectByVisibleText(batchTypeDDwn, batchjobhist.getBatchType());
	}

	public void enterJobId(BatchJobHistory batchjobhist) {
		enterValueinTextBox(jobIdTxt, batchjobhist.getJobIdBatchJobHistory());
	}

	public void selectCalender() {
		String[] date22 = DateUtils.getDateinDDMMYYYY().split("/");
		int newdate = Integer.parseInt(date22[1]);
		int i = newdate - 1;
		date22[1] = String.valueOf(i);
		String date11 = date22[0] + "/" + date22[1] + "/" + date22[2];
		date.setDate(date11);
		waitForPageToLoad(getFinder().getWebDriver());
		SimulatorUtilities.wait(2000);
		date.setDateCalendar2(DateUtils.getDateinDDMMYYYY(), calElement);
		waitForPageToLoad(getFinder().getWebDriver());
	}

	public void Search() {
		clickWhenClickable(searchBtn);
	}

	public void searchBatchJob(BatchJobHistory batchjobhist) {
		selectbatchType(batchjobhist);
		enterJobId(batchjobhist);
		selectCalender();
		Search();
	}

	public void verifyUiOperationStatus() {
		logger.info("Batch Job History");
		verifySearchButton("Search");
	}
	
	public ProcessBatches searchRecord(ProcessBatches batches) {
		WebElementUtils.pickDate(fromJobStartDttmDPkr, LocalDate.parse(getTextFromPage(institutionDateTxt), DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss")));
		WebElementUtils.pickDate(toJobStartDttmDPkr, LocalDate.parse(getTextFromPage(institutionDateTxt), DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss")));
		WebElementUtils.enterText(jobIdTxt, batches.getJoBID());
		clickSearchButton();
		viewFirstRecord();		
		runWithinPopup("View Batch Details", () -> {
			logger.info("Retrieving batch status");
			waitForBatchStatus();
			batches.setStatus(batchStatus.getText());
			try{
				clickCloseButton();
			}
				catch(StaleElementReferenceException ex)
			{
					clickCloseButton();
			}
		});		
		
		return batches;	
	}

	public String[] findRecord() {
		WebElementUtils.pickDate(fromJobStartDttmDPkr, LocalDate.now());
		WebElementUtils.pickDate(toJobStartDttmDPkr, LocalDate.now());
		clickSearchButton();
		return new String[] { getDate(), getFirstRecordCellTextByColumnName("Batch") };
	}

	public void clickBatchjob(BatchJobHistory batchjobhist) {
		try {
			WebElement SelectJobNoRecords = getFinder().getWebDriver()
					.findElement(By.xpath("//td[contains(.,'No Records Found')]"));
			if (SelectJobNoRecords.isDisplayed()) {
				logger.info("No Records displayed or batch processed succesfully");
			}
		} catch (Exception e) {
			WebElement SelectJob = getFinder().getWebDriver()
					.findElement(By.xpath("//td[contains(.,'" + batchjobhist.getJobIdBatchJobHistory() + "')]"));
			clickWhenClickable(SelectJob);
			waitForSucces();
		}

	}

	public void waitForSucces() {
		String statusString = "SUCCESS [2]";
		String statuslabelTxt;
		Integer i = 0;
		switchToViewBatchDetailsFrame();
		do {
			statuslabelTxt = statusTxt.getText();
			CustomUtils.ThreadDotSleep(2000);
		} while (!(statuslabelTxt.trim().contains(statusString.trim())) && i++ < 100);

		logger.info("Status  -", statuslabelTxt);
		Assert.assertEquals(statusString, statuslabelTxt);
		clickWhenClickable(closeBtn);
		switchToDefaultFrame();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(batchTypeDDwn),
				WebElementUtils.elementToBeClickable(batchDDwn),
				WebElementUtils.elementToBeClickable(fromJobStartDttmDPkr),
				WebElementUtils.elementToBeClickable(toJobStartDttmDPkr),
				WebElementUtils.elementToBeClickable(jobIdTxt), WebElementUtils.elementToBeClickable(statusDDwn),
				WebElementUtils.elementToBeClickable(executionModeDDwn));
	}

	public boolean searchJob(String jobId) {
		boolean found = false;
		int i;
		logger.info("Searching for jobId: {}", jobId);
		WebElementUtils.enterText(jobIdTxt, jobId);
		WebElementUtils.pickDate(fromJobStartDttmDPkr, LocalDate.now());
		WebElementUtils.pickDate(toJobStartDttmDPkr, LocalDate.now());
		clickSearchButton();
		for (int k = 0; k < 11; k++) {
			if (!waitForRow())
				clickSearchButton();
			else {
				break;
			}
		}

		for (i = 1; i < 4; i++) {
			if (getCellTextByColumnName(i, "Status").contains("SUCCESS [2]")) {
				found = true;
				break;
			}
		}
		return found;
	}
	
	
	public boolean checkBatchStatus(BatchJobHistory batchJobHistory) {
		
		selectByVisibleText(batchTypeDDwn, batchJobHistory.getBatchType());
		SimulatorUtilities.wait(1000);
		WebElementUtils.pickDate(fromJobStartDttmDPkr, LocalDate.now().minusDays(1));
		WebElementUtils.pickDate(toJobStartDttmDPkr, LocalDate.now());
		enterValueinTextBox(jobIdTxt, batchJobHistory.getJobIdBatchJobHistory());
		selectByVisibleText(batchDDwn,batchJobHistory.getBatch());
		clickSearchButton();
		context.put(ContextConstants.CSV_NO,getFirstRecordCellTextByColumnName(FILE_NAME));
		SimulatorUtilities.wait(20000);
		if(getFirstRecordCellTextByColumnName(STATUS).equals("SUCCESS [2]"))
		{	
			String timeStamp = LocalDateTime.now(ZoneId.of("GMT-6")).format(DateTimeFormatter.ofPattern("ddMMyyyyHHmm")); //CDT time when batch download is done. 
            context.put(ContextConstants.CLIENT_PHOTO_BATCH_SUCCESS_TIME,timeStamp);
            logger.info("timestamp of processing",timeStamp);
			return true;
		}
		else
		{
			return false;
		}
	}
}