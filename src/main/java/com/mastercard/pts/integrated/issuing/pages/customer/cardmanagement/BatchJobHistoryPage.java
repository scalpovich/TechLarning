package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_SEARCH, CardManagementNav.L2_BATCH_JOB_HISTORY })
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

	public void verifyUiOperationStatus() {
		logger.info("Batch Job History");
		verifySearchButton("Search");
	}

	public String[] findRecord() {
		WebElementUtils.pickDate(fromJobStartDttmDPkr, LocalDate.now());
		WebElementUtils.pickDate(toJobStartDttmDPkr, LocalDate.now());
		clickSearchButton();
		return new String[] {getDate(), getFirstRecordCellTextByColumnName("Batch")};
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(batchTypeDDwn), WebElementUtils.elementToBeClickable(batchDDwn),
				WebElementUtils.elementToBeClickable(fromJobStartDttmDPkr), WebElementUtils.elementToBeClickable(toJobStartDttmDPkr),
				WebElementUtils.elementToBeClickable(jobIdTxt), WebElementUtils.elementToBeClickable(statusDDwn),
				WebElementUtils.elementToBeClickable(executionModeDDwn));
	}
	
	public boolean searchJob(String jobId) {
		boolean found = false;
		int i;
		logger.info("Searching for jobId: {}", jobId);
		WebElementUtils.enterText(jobIdTxt, jobId);
		clickSearchButton();
		for (int k = 0; k < 11; k++) {
			if (!waitForRow())
				clickSearchButton();
			else {
				break;
			}
		}

		for(i=1;i<4;i++){
			if(getCellTextByColumnName(i, "Status").contains("SUCCESS [2]")){
				found = true;
				break;
			}
		}
		return found;
	}
}