package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP, CardManagementNav.L2_APPLICATION,
		CardManagementNav.L3_CREDIT, CardManagementNav.L4_VARIABLE_SCORE })
public class VariableScorePage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(VariableScorePage.class);

	@Autowired
	TestContext context;
	private static final String START_RANGE_VALUE="2";
	private static final String END_RANGE_VALUE="90";
	private static final String VARIABLE_SCORE="1000";
	private static final String VARIBALE_SCORE_IFRAME="Add Variable Score";
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#prodCode select")
	private MCWebElement programDdwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#columnCode select")
	private MCWebElement fieldNameDdwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "rangedStartValue:input:inputTextField")
	private MCWebElement rangeStartValueTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "rangedEndValue:input:inputTextField")
	private MCWebElement rangeEndValueTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "score:input:inputTextField")
	private MCWebElement scoreTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Record Added Successfully.']")
	private MCWebElement validateSuccessMsgDisplay;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "table.dataview")
	private MCWebElement searchTable;
	
	private static final String VARIABLE_SCORE_PARAMETER="AGE [AGE]";
	
	public boolean successMessageDisplay(){
		return validateSuccessMsgDisplay.isVisible();
	}
	
	public void selectProgram() {
		ifTextAvailableinTableThenDelete(searchTable, VARIABLE_SCORE_PARAMETER);
		clickAddNewButton();
		switchToIframe(VARIBALE_SCORE_IFRAME);
		Program program = context.get(ContextConstants.PROGRAM);
		WebElementUtils.selectDropDownByVisibleText(programDdwn, program.buildDescriptionAndCode());
	}
	
	public void selectFieldName(String fieldName){
		selectByVisibleText(fieldNameDdwn, fieldName);
	}
	
	public void enterRangeStartValue(){
		WebElementUtils.enterText(rangeStartValueTxt, START_RANGE_VALUE);
	}
	
	public void enterRangeEndValue(){
		WebElementUtils.enterText(rangeEndValueTxt, END_RANGE_VALUE);
	}
	
	public String enterScore(){
		WebElementUtils.enterText(scoreTxt, VARIABLE_SCORE);
		return VARIABLE_SCORE;
	}

	public void verifyUiOperationStatus() {
		logger.info("Variable Score");
		verifyUiOperation("Add Variable Score");
	}
	  
    public void saveButtonClick(){
    	clickSaveButton();
    }
}
