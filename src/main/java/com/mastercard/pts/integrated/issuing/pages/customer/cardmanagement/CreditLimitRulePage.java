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
		CardManagementNav.L3_CREDIT, CardManagementNav.L4_CREDIT_LIMIT_RULE})
public class CreditLimitRulePage extends AbstractBasePage {
	@Autowired
	private TestContext context;
	
	private static final Logger logger = LoggerFactory.getLogger(CreditLimitRulePage.class);
    private static final String CREDIT_LIMIT_RULE_FRAME="Add Credit Limit Rule";
    private static final String AGE="75";
    
	@PageElement(findBy = FindBy.NAME, valueToFind = "productCode:input:dropdowncomponent")
	private MCWebElement programCodeDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "attributes:input:dropdowncomponent")
	private MCWebElement fieldNameDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "operator:input:dropdowncomponent")
	private MCWebElement operatorDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "value:input:dropdowncomponent")
	private MCWebElement valueDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "operator3:input:dropdowncomponent")
	private MCWebElement insertDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "creditLimitType:input:dropdowncomponent")
	private MCWebElement limitTypeDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "creditLimit:input:inputAmountField")
	private MCWebElement creditLimitTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "maxCreditLimit:input:inputAmountField")
	private MCWebElement maxCreditLimitTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "appendSectionContainer:appendButton")
	private MCWebElement appendBtn;
	
    @PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=ruleId]")
	private MCWebElement ruleIdTxt;
    
    @PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
   	private MCWebElement addRBtn;
    
    @PageElement(findBy = FindBy.NAME, valueToFind = "textValue1:input:inputTextField")
   	private MCWebElement valueTxt;
    
    @PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Record Added Successfully.']")
	private MCWebElement validateSuccessMsgDisplay;
	
    @PageElement(findBy = FindBy.CSS, valueToFind = "table.dataview")
	private MCWebElement searchTable;
	
	private static final String CREDIT_LIMIT_RULE_SCORE_PARAMETER="(AGE < 75 )";
	
	public boolean successMessageDisplay(){
		return validateSuccessMsgDisplay.isVisible();
	}

	public void addProgramCode() {
		ifTextAvailableinTableThenDelete(searchTable, CREDIT_LIMIT_RULE_SCORE_PARAMETER);
		SimulatorUtilities.wait(4000);
		clickAddNewButton();
		switchToIframe(CREDIT_LIMIT_RULE_FRAME);
	}
    
	public void selectProgramCode() {
		Program program = context.get(ContextConstants.PROGRAM);
		WebElementUtils.selectDropDownByVisibleText(programCodeDDwn, program.buildDescriptionAndCode());
		waitForLoaderToDisappear();
	}

	public void selectFieldName(String fieldName) {
		selectByVisibleText(fieldNameDDwn, fieldName);
	}

	public void selectOperator(int index) {
		WebElementUtils.selectDropDownByIndex(operatorDDwn, index);
	}

	public void selectValue(int index) {
		if (valueDDwn.isEnabled()) {
			WebElementUtils.selectDropDownByIndex(valueDDwn, index);
		}
	}
    
	public void enterValue() {
		waitForPageToLoad(driver());
		WebElementUtils.enterText(valueTxt, AGE);
		SimulatorUtilities.wait(4000);
		if(valueTxt.getAttribute("value").isEmpty()){
		WebElementUtils.enterText(valueTxt, AGE);
		}
	}

	public void selectInsert(int index) {
		WebElementUtils.selectDropDownByIndex(insertDDwn, index);
	}

	public void appendButtonClick() {
		waitForPageToLoad(driver());
		clickWhenClickable(appendBtn);
	}

	public void selectLimitType(int index) {
		WebElementUtils.selectDropDownByIndex(limitTypeDDwn, index);
	}

	public String enterCreditLimit() {
		Program program = context.get(ContextConstants.PROGRAM);
		WebElementUtils.enterText(creditLimitTxt, Integer.parseInt(program.getCreditLimit()) + 1);
		return creditLimitTxt.getAttribute("value");
	}

	public void enterMaxCreditLimit() {
		Program program = context.get(ContextConstants.PROGRAM);
		WebElementUtils.enterText(maxCreditLimitTxt, Integer.parseInt(program.getMaximumCreditLimit()) - 1);

	}

	public void save() {
		clickSaveButton();
	}
    
	public void verifyUiOperationStatus() {
		logger.info("Credit Limit Rule");
		verifyUiOperation("Add Credit Limit Rule");
	}
}
