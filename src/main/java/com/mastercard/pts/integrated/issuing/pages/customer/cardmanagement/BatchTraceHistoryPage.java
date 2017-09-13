package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_SEARCH, CardManagementNav.L2_BATCH_TRACE_HISTORY })
public class BatchTraceHistoryPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory
			.getLogger(BatchTraceHistoryPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:1:componentPanel:input:inputTextField")
	private MCWebElement searchJobIdTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='fromDttm']/..")
	private MCWebElement effectiveDateTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='toDttm']/..")
	private MCWebElement endDateTxt;

	public boolean searchJob(String jobId) {
		boolean found = false;
		int i;
		logger.info("Searching for jobId: {}", jobId);
		WebElementUtils.enterText(searchJobIdTxt, jobId);
		clickSearchButton();
		for (int k = 0; k < 11; k++) {
			if (!waitForRow())
				clickSearchButton();
			else {
				break;
			}
		}

		for(i=1;i<4;i++){
			if(getCellTextByColumnName(i, "Message Label").contains("Batch executed sucessfully")){
				found = true;
				break;
			}
		}
		return found;
	}

	public boolean searchJob() {
		int i;
		boolean found = false;
		logger.info("Searching for job performed today");
		WebElementUtils.pickDate(effectiveDateTxt, LocalDate.now());
		WebElementUtils.pickDate(endDateTxt, LocalDate.now());
		clickSearchButton();
		for(i=1;i<4;i++){
			if(getCellTextByColumnName(i, "Message Label").contains("Batch completed successfully")){
				found = true;
				break;
			}
		}
		return found;
	}
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=jobId]")
	private MCWebElement jobId;

	public void verifyUiOperationStatus() {
		logger.info("Batch Trace History");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(jobId));
	}

}
