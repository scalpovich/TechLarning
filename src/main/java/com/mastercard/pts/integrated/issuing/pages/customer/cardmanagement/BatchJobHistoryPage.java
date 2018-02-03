package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BatchJobHistory;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.DatePicker;
import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_SEARCH,
		CardManagementNav.L2_BATCH_JOB_HISTORY })
public class BatchJobHistoryPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(BatchJobHistoryPage.class);

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

	public String calelement = "//td[7]";

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
		// date.setDate(date11);
		waitForPageToLoad(getFinder().getWebDriver());
		date.setDateCalendar2(DateUtils.getDateinDDMMYYYY(), calelement);
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
		} while (!(statuslabelTxt.trim().contains(statusString.trim())) && i++ < 20);

		CustomUtils.ThreadDotSleep(2000);
		logger.info("Status  -", statuslabelTxt);
		clickWhenClickable(closeBtn);
		SwitchToDefaultFrame();

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
}