package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ApplicationDocumentChecklist;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT,
treeMenuItems = { CardManagementNav.L1_PROGRAM_SETUP, CardManagementNav.L2_APPLICATION, CardManagementNav.L3_DOCUMENT_CHECKLIST })
public class ApplicationDocumentChecklistPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(StatementMessagePlanPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=documentPlanCode]")
	private MCWebElement documentChecklistPlanCodeTxtOnMainScreen;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement productTypeDDwnOnMainScreen;	

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=description]")
	private MCWebElement descriptionOnMainScreen;	

	@PageElement(findBy = FindBy.CSS, valueToFind = "select[name^=productType]")
	private MCWebElement productTypeDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=documentPlanCode]")
	private MCWebElement documentChecklistPlanCodeTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=description]")
	private MCWebElement descriptionTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "documentName:input:dropdowncomponent")
	private MCWebElement documentNameDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "documentMandatory:checkBoxComponent")
	private MCWebElement documentMandatoryChkBx;

	public void verifyUiOperationStatus() {
	logger.info("Document Checklist");
	verifySearchButton("Search");
}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.visibilityOf(documentChecklistPlanCodeTxtOnMainScreen),
				WebElementUtils.visibilityOf(productTypeDDwnOnMainScreen),
				WebElementUtils.visibilityOf(descriptionOnMainScreen));
	}	

	public void addDocumentsInDocumentsChecklist( ApplicationDocumentChecklist applicationDocumentChecklist)
	{
		logger.info("Add Documents In Documents Checklist: {}", applicationDocumentChecklist);

		performSearchOperationOnMainScreen(applicationDocumentChecklist);

		//When record already exists
		if(!isNoRecordsFoundInTable())
		{
			applicationDocumentChecklist.setDocumentChecklistPlanCode(MiscUtils.generate10CharAlphaNumeric());
		}	

		clickAddNewButton();		
		//Add Document Checklist section
		runWithinPopup("Add Document Checklist", () -> {
			WebElementUtils.selectDropDownByVisibleText(productTypeDDwn, applicationDocumentChecklist.getProductType());
			WebElementUtils.enterText(documentChecklistPlanCodeTxt, applicationDocumentChecklist.getDocumentChecklistPlanCode());
			WebElementUtils.enterText(descriptionTxt, applicationDocumentChecklist.getDescription());			
			clickAddDetailsButton();			

			addDcoumentChecklistDetails();

			clickSaveButton();

			verifyNoErrors();			
		});
		verifyOperationStatus();		
	}

	private void addDcoumentChecklistDetails()
	{		
		//Adding Document Checklist Details section
		clickAddNewButton();
		runWithinPopup("Add Document Checklist Details ", () -> {
			//here we are selecting the first document in the list as there is no dependency of this field
			WebElementUtils.selectDropDownByIndex(documentNameDDwn, 1);
			documentMandatoryChkBx.click();
			clickSaveButton();

			verifyNoErrors();
		});

		verifyOperationStatus();
	}

	private void performSearchOperationOnMainScreen(ApplicationDocumentChecklist applicationDocumentChecklist)
	{
		WebElementUtils.enterText(documentChecklistPlanCodeTxtOnMainScreen, applicationDocumentChecklist.getDocumentChecklistPlanCode());
		clickSearchButton();
	}

	@SuppressWarnings("unused")
	private void verifyTheAddedDocumentsInDocumentsChecklistSectionIsAdded( ApplicationDocumentChecklist applicationDocumentChecklist)
	{
		logger.info("Verify the Added Documents In Documents Checklist Section are Present: {}", applicationDocumentChecklist);

		WebElementUtils.enterText(documentChecklistPlanCodeTxtOnMainScreen, applicationDocumentChecklist.getDocumentChecklistPlanCode());
		WebElementUtils.enterText(descriptionOnMainScreen, applicationDocumentChecklist.getDescription());
		WebElementUtils.selectDropDownByVisibleText(productTypeDDwnOnMainScreen, applicationDocumentChecklist.getProductType());
		//searching 
		clickSearchButton();		
		//Read value from row which should populate 1 row
		viewFirstRecord();
		//Clicking Cancel button to close the pop-up window
		clickCancelButton();
	}
}
