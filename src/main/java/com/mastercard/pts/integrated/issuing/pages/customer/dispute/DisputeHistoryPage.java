package com.mastercard.pts.integrated.issuing.pages.customer.dispute;
import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.dispute.DisputeHistory;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = DisputeNav.TAB_DISPUTE, treeMenuItems = {
		DisputeNav.L1_DISPUTE_ACTIVITY, DisputeNav.L2_DISPUTE_HISTORY })

public class DisputeHistoryPage extends AbstractDisputePage {
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement interchangeDrpDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=microfilmRefNumber]")
	private MCWebElement arnTxtBx;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@id='searchForm']/table/tbody/tr[4]/td[3]")
	private MCWebElement fromDate;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@id='searchForm']/table/tbody/tr[3]/td[7]")
	private MCWebElement toDate;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[type='submit']")
	private MCWebElement searchBtn;

	@PageElement( findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']")
	private MCWebElement tableHandle;
	
	private boolean flagTest=false;
	
	public void searchDisputeHistoryRecord(DisputeHistory dispute)
	{
		WebElementUtils.enterText(arnTxtBx, dispute.getArn());
		WebElementUtils.pickDate(toDate,dispute.getToDate());
		WebElementUtils.pickDate(fromDate,dispute.getFromDate());
		clickSearchButton();
	}

	public boolean validateHistory(String text)
	{
		viewFirstRecord();
		runWithinPopup(
				"View Dispute History",
				() -> {
					flagTest=WebElementUtils.isTextAvailableinTable(tableHandle,text);
					clickCloseButton();
				});
		return flagTest;
	}

	public void verifyUiOperationStatus() {
		verifyOperationStatus("dispute history page operation status");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(arnTxtBx),
				WebElementUtils.elementToBeClickable(interchangeDrpDwn),
				WebElementUtils.elementToBeClickable(fromDate),
				WebElementUtils.elementToBeClickable(toDate));
	}

}
