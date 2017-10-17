package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.EmbossingPinAndPriorityPassFileNameParameter;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_EMBOSSING_PARAMETERS,
		CardManagementNav.L3_EMBOSSING_PIN_AND_PRIORITY_PASS_FILE_NAME_PARAMETER
		})

public class EmbossingPINAndPriorityPassFileNameParameterPage extends AbstractBasePage {
	
	private static final Logger logger = LoggerFactory.getLogger(EmbossingPINAndPriorityPassFileNameParameterPage.class);
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=planCode]")
	private MCWebElement planCode;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=planDesc]")
	private MCWebElement planDesc;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement fileTypeDrpDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement productTypeDrpDwn;
	
	@PageElement(findBy = FindBy.NAME,valueToFind = "fileType:input:dropdowncomponent")
	private MCWebElement fileTypeDrpDwnPopUp;
	
	@PageElement(findBy = FindBy.NAME,valueToFind  = "productType:input:dropdowncomponent")
	private MCWebElement productTypeDrpDwnPopUp;
	
	@PageElement(findBy = FindBy.CSS, valueToFind  = "[fld_fqn=priority]")
	private MCWebElement priorityTxtBxPopUp;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=filenameExpression1]")
	private MCWebElement fileNameExpTxtBxPopUp;
	
	public void verifyUiOperationStatus() {
		logger.info("Embossing ,PIN & Priority Pass File Name Parameter");
		verifyUiOperation("Add Embossing ,PIN & Priority Pass File Name Parameter");
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(planCode),
				WebElementUtils.elementToBeClickable(planDesc),
				WebElementUtils.elementToBeClickable(fileTypeDrpDwn),
				WebElementUtils.elementToBeClickable(productTypeDrpDwn)
				);
	}
	
	public void  embossingPINAndPriorityPassFileNameParameter(EmbossingPinAndPriorityPassFileNameParameter data)
	{
		logger.info("Embossing,PIN and Priority Pass File Name Parameter ");
		performSearchOperationOnMainScreen(data);
		if(isNoRecordsFoundInTable())
		{
			clickAddNewButton();
			
			runWithinPopup("Add Embossing ,PIN & Priority Pass File Name Parameter", () -> {
				
				WebElementUtils.enterText(planDesc, data.getDescription());
				WebElementUtils.selectDropDownByVisibleText(fileTypeDrpDwnPopUp, data.getFileType());
				
				WebElementUtils.selectDropDownByVisibleText(productTypeDrpDwnPopUp, data.getProductType());
				WebElementUtils.enterText(priorityTxtBxPopUp, data.getPriority());
				WebElementUtils.enterText(fileNameExpTxtBxPopUp,data.getFileNameExpression());
				
				clickSaveButton();
				
			});
			
			verifyOperationStatus();		
		}
	}
	
	private void performSearchOperationOnMainScreen(EmbossingPinAndPriorityPassFileNameParameter data)
	{
		WebElementUtils.enterText(planDesc, data.getDescription());
		clickSearchButton();
	}

}
