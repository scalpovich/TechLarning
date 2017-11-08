package com.mastercard.pts.integrated.issuing.pages.customer.dispute;

import java.util.Arrays;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.dispute.DisputeHistory;
import com.mastercard.pts.integrated.issuing.pages.PageObjectFactory;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = DisputeNav.TAB_DISPUTE, treeMenuItems = { DisputeNav.L1_DISPUTE_ACTIVITY, DisputeNav.L2_DISPUTE_HISTORY })
public class DisputeHistoryPage extends AbstractDisputePage {

	private static final Logger logger = Logger.getLogger(PageObjectFactory.class);
	
	@Autowired
	private TestContext context;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement interchangeDrpDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@id='searchForm']/table/tbody/tr[4]/td[3]")
	private MCWebElement fromDate;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@id='searchForm']/table/tbody/tr[3]/td[7]")
	private MCWebElement toDate;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[type='submit']")
	private MCWebElement searchBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']")
	private MCWebElement tableHandle;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']/tbody/tr[1]/td[2]/span")
	private MCWebElement disputeTypeLbl;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']/tbody/tr[1]/td[3]/span")
	private MCWebElement transactionTypeLbl;

	private boolean flagTest = false;

	public void searchDisputeHistoryRecord(DisputeHistory dispute) {
		String text = context.get(ConstantData.ARN_NUMBER);
		WebElementUtils.enterText(arnTxt, text);//DisputeHistory 
		clickSearchButton();
	}

	public boolean validateHistory(String text) {
		viewFirstRecord();
		runWithinPopup("View Dispute History", () -> {
			flagTest = WebElementUtils.isTextAvailableinTable(tableHandle, text);
			logger.info("Actual Dispute Type Label ==> " + disputeTypeLbl.getText());
			logger.info("Actual Transaction Type Label ==> " + transactionTypeLbl.getText());
			clickCloseButton();
		});
		return flagTest;
	}

	public void verifyUiOperationStatus() {
		verifyOperationStatus("dispute history page operation status");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(arnTxt), WebElementUtils.elementToBeClickable(interchangeDrpDwn),
				WebElementUtils.elementToBeClickable(fromDate), WebElementUtils.elementToBeClickable(toDate));
	}

}
