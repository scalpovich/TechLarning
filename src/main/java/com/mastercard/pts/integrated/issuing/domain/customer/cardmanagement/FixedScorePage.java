package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

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
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.CardManagementNav;


@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP, CardManagementNav.L2_APPLICATION,
		CardManagementNav.L3_CREDIT, CardManagementNav.L4_FIXED_SCORE})

public class FixedScorePage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(FixedScorePage.class);

	@Autowired
	TestContext context;
	private static final String FIXED_SCORE="500";
	private static final String FIXED_SCORE_FRAME="Add Fixed Score";
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#prodCode select")
	private MCWebElement programDdwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#columnCode select")
	private MCWebElement fieldNameDdwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#columnValue select")
	private MCWebElement fieldValueDdwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#score input")
	private MCWebElement scoreTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Record Added Successfully.']")
	private MCWebElement validateSuccessMsgDisplay;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "table.dataview")
	private MCWebElement searchTable;
	
	private static final String FIXED_SCORE_PARAMETER="MARITAL STATUS [MARRIED]";
	
	public boolean successMessageDisplay(){
		return validateSuccessMsgDisplay.isVisible();
	}
    
	public void selectProgram(){
		ifTextAvailableinTableThenDelete(searchTable, FIXED_SCORE_PARAMETER);
		clickAddNewButton();
		switchToIframe(FIXED_SCORE_FRAME);
		Program program = context.get(ContextConstants.PROGRAM);
		WebElementUtils.selectDropDownByVisibleText(programDdwn, program.buildDescriptionAndCode());
	}
	
	public void selectFieldName(String fieldName){
		selectByVisibleText(fieldNameDdwn,fieldName);
		waitForLoaderToDisappear();
	}
	
	public void selectFieldValue(String fieldValue){
		selectByVisibleText(fieldValueDdwn,fieldValue);
	}
	
	public String enterScore(){
		WebElementUtils.enterText(scoreTxt, FIXED_SCORE);
		clickSaveButton();
		waitForLoaderToDisappear();
		return FIXED_SCORE;
	}
	
	 public void saveButtonClick(){
	    	clickSaveButton();
	    }
	
	public void verifyUiOperationStatus() {
		logger.info("Fixed Score");
		verifyUiOperation("Add Fixed Score");
	}

}
