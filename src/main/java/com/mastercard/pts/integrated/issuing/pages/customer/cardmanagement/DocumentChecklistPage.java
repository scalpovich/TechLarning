package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DocumentChecklist;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1PROGRAM_SETUP, CardManagementNav.L2_APPLICATION,
		CardManagementNav.L3_DOCUMENT_CHECKLIST })
public class DocumentChecklistPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(DocumentChecklistPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=documentPlanCode]")
	private MCWebElement documentPlanCode;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=description]")
	private MCWebElement description;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement productType;
@PageElement(findBy = FindBy.NAME, valueToFind = "productType:input:dropdowncomponent")
	private MCWebElement ProductTypeDDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "documentPlanCode:input:inputTextField")
	private MCWebElement DocumentChecklistPlanCodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "description:input:inputTextField")
	private MCWebElement DescriptionTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addSubDetailsBtn;
	
	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addDocumentChecklistBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "documentName:input:dropdowncomponent")
	private MCWebElement DocumentNameTxtrbtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "documentMandatory:checkBoxComponent")
	private MCWebElement SelectedDocumentMandatoryrbtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement CancelBtn;

	public void ClickaddDocumentCheckList() {
		clickWhenClickable(addDocumentChecklistBtn);
		switchToAddDocChecklistFrame();
	}

	public void switchToAddDocChecklistFrame() {
		switchToIframe(Constants.ADD_DOCUMENT_CHECKLIST_FRAME);
	}

	public void selectProduct(DeviceCreation deviceCreation) {
		selectByVisibleText(ProductTypeDDDwn, deviceCreation.getProduct());
	}

	public String enterDocChecklistPlanCode() {
		enterValueinTextBox(DocumentChecklistPlanCodeTxt, CustomUtils.randomNumbers(5));
		return DocumentChecklistPlanCodeTxt.getAttribute("value");
	}

	public String enterDocChecklistDescription() {
		enterValueinTextBox(DescriptionTxt, "MandatoryDocs Description");
		return DescriptionTxt.getAttribute("value");
	}

	public void clickSaveButton() {
		clickWhenClickable(saveBtn);
		SwitchToDefaultFrame();
	}

	public boolean verifyErrorsOnDocListPage() {
		return publishErrorOnPage();
	}

	public void verifyDoclistSuccess() {
		if (!verifyErrorsOnDocListPage()) {
			logger.info("Doclist Added Successfully");
			SwitchToDefaultFrame();
		} else {
			logger.info("Error in Record Addition");
			clickWhenClickable(CancelBtn);
			SwitchToDefaultFrame();
		}
	}

	public void clickAddDocCheckListSubDetails() {
		switchToIframe(Constants.ADD_DOCUMENT_CHECKLIST_FRAME);
		clickWhenClickable(addSubDetailsBtn);
		SwitchToDefaultFrame();
		switchToIframe(Constants.ADD_DOCUMENT_CHECKLIST_DETAILS_FRAME);
	}

	public void switchToAddDocumentChecklistDetailsFrame() {
		SwitchToDefaultFrame();
		switchToIframe(Constants.ADD_DOCUMENT_CHECKLIST_DETAILS_FRAME);
	}

	public void selectDocument(DocumentChecklist docChecklist) {
		selectByVisibleText(DocumentNameTxtrbtn, docChecklist.getDocumentName());
	}

	public void selectDocumentMandatoryasTrueFalse() {
		ClickCheckBox(SelectedDocumentMandatoryrbtn, true);
	}

	public String adddocumentchecklist(DeviceCreation deviceCreation) {
		String doclistcode;
		String doclistDesc;
		selectProduct(deviceCreation);
		doclistcode = enterDocChecklistPlanCode();
		doclistDesc = enterDocChecklistDescription();
		return doclistDesc + " " + "[" + doclistcode + "]";

	}

	public void addDocChecklistDetails() {
		clickAddDocCheckListSubDetails();
		selectDropDownByIndex(DocumentNameTxtrbtn, 1);
		ClickCheckBox(SelectedDocumentMandatoryrbtn, true);
		clickSaveButton();
		SwitchToDefaultFrame();
	}

	public void verifyUiOperationStatus() {
		logger.info("Document Checklist");
		verifyUiOperation("Add Document Checklist");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(documentPlanCode),
				WebElementUtils.elementToBeClickable(description),
				WebElementUtils.elementToBeClickable(productType));
	}
}
