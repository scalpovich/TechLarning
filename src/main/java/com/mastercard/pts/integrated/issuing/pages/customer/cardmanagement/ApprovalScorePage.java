package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.MCWebElements;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP, CardManagementNav.L2_APPLICATION,
		CardManagementNav.L3_CREDIT, CardManagementNav.L4_APPROVAL_SCORE })

public class ApprovalScorePage extends AbstractBasePage {
    private static final String ADDAPPROVERSCORE_FRAME="Add Approval Score";
	private static final Logger logger = LoggerFactory
			.getLogger(RiskAnalysisRulePage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "prodCode:input:dropdowncomponent")
	private MCWebElement programDDwn;
	@PageElement(findBy = FindBy.NAME, valueToFind = "actionCode:input:dropdowncomponent")
	private MCWebElement actionDDwn;
    @PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=ruleId]")
	private MCWebElement ruleId;
	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addBtn;
	@PageElement(findBy = FindBy.NAME, valueToFind = "startScoreValue:input:inputTextField")
	private MCWebElement startRangeValueTxt;
	@PageElement(findBy = FindBy.NAME, valueToFind = "endScoreValue:input:inputTextField")
	private MCWebElement endRangeValueTxt;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//tbody//tr[@class!='headers'][1]/td//span/text()[last()]")
	private MCWebElements valuesAdded;
	
	@PageElement(findBy = FindBy.CLASS, valueToFind = "dataview")
	private MCWebElement table;
	
	public LinkedList<String>addApprovalScore() {
		clickWhenClickable(addBtn);
		switchToIframe(ADDAPPROVERSCORE_FRAME);
		WebElementUtils.selectDropDownByIndex(programDDwn,18);
		WebElementUtils.selectDropDownByIndex(actionDDwn,1);
		WebElementUtils.enterText(startRangeValueTxt,CustomUtils.RandomNumbers(5));
		WebElementUtils.enterText(endRangeValueTxt,CustomUtils.RandomNumbers(6));
		LinkedList<String>allValuesAdded = new LinkedList<>();
		allValuesAdded.add(programDDwn.getAttribute("title"));
		allValuesAdded.add(actionDDwn.getAttribute("title"));
		allValuesAdded.add(startRangeValueTxt.getAttribute("value"));
		allValuesAdded.add(endRangeValueTxt.getAttribute("value"));
		clickSaveButton();
		CustomUtils.ThreadDotSleep(5000);
		return allValuesAdded;
		}
	public LinkedList<String> valuesAddedInTable()
	{
		LinkedList<String>values=new LinkedList<>();
		for(int i=0;i<valuesAdded.getElements().size();i++)
		{   if(valuesAdded.getElements().get(i).getText().equals(" ")||valuesAdded.getElements().get(i).getText().equals(""))
		{
			valuesAdded.getElements().remove(i);
		}
		else
		{
			values.add(valuesAdded.getElements().get(i).getText());
		}
		}
		
		return values;
	}
	public void verifyUiOperationStatus() {
		logger.info("Add Approval Score");
		verifyUiOperation("Add Approval Score");
	}
   
   
	/*@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(program),
				WebElementUtils.elementToBeClickable(ruleId));
	}*/
}
