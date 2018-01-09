package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.CreditCardPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
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
	@Autowired
	private TestContext context;
	@Autowired
	CreditCardPlan creditCardPlans;
    private static final String ADD_APPROVER_SCORE_FRAME="Add Approval Score";
	private static final Logger logger = LoggerFactory.getLogger(ApprovalScorePage.class);
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
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Record Added Successfully.']")
	private MCWebElement validateSuccessMsgDisplay;
	
	public boolean successMessageDiplay()
	{
		if(validateSuccessMsgDisplay.isVisible())
		{
			logger.info("successMsg is displayed");
			return true;
		}
		return false;
	}
	
	   public void addApproverScorePlan() {
	    	clickWhenClickable(addBtn);
			switchToIframe(ADD_APPROVER_SCORE_FRAME);
			}
	    public void addMandatoryLabelsAndFields()
	    {
	    	clickSaveButton();
			mandatoryLabels();
			mandatoryFields();
	    }
	    
	    public void selectProgram()
	    {
	    	Program program=context.get(ContextConstants.PROGRAM);
	    	WebElementUtils.selectDropDownByVisibleText(programDDwn,program.buildDescriptionAndCode());
	    }
	    
	    public void selectAction()
	    {
	    	WebElementUtils.selectDropDownByIndex(actionDDwn,1);
	    }
	    
	    public void enterStartRangeValue()
	    {
	    	WebElementUtils.enterText(startRangeValueTxt,CustomUtils.RandomNumbers(5));
	    }
	    
	    public void enterEndRangeValue()
	    {
	    	WebElementUtils.enterText(endRangeValueTxt,CustomUtils.RandomNumbers(6));
	    }
	    
	    public void settingMandatoryValuesWithLabels()
	    {
	    	creditCardPlans.setMandatoryValuesWithLabels(mandatoryValuesWithLabels(mandatoryFields(),mandatoryLabels()));
			logger.info("MandatoryLabelswithValues: {}", creditCardPlans.getMandatoryValuesWithLabels());
	    }
	    
	    public void saveButtonClick()
	    {
	    	clickSaveButton();
			waitForLoaderToDisappear();
	    }
	public void verifyUiOperationStatus() {
		logger.info("Add Approval Score");
		verifyUiOperation("Add Approval Score");
	}
   
}
