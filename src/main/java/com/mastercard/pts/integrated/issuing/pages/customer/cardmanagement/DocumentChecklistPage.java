package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DocumentChecklist;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP, CardManagementNav.L2_APPLICATION,
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

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addDocumentChecklist;

	@PageElement(findBy = FindBy.NAME, valueToFind = "productType:input:dropdowncomponent")
	private MCWebElement ProductType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "documentPlanCode:input:inputTextField")
	private MCWebElement DocumentChecklistPlanCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "description:input:inputTextField")
	private MCWebElement Description;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addSubDetails;

	@PageElement(findBy = FindBy.NAME, valueToFind = "documentName:input:dropdowncomponent")
	private MCWebElement DocumentName;

	@PageElement(findBy = FindBy.NAME, valueToFind = "documentMandatory:checkBoxComponent")
	private MCWebElement SelectedDocumentMandatory;

	public void ClickaddDocumentCheckList() {
		waitForElementVisible(addDocumentChecklist);
		addDocumentChecklist.click();
	}

	public void switchToAddDocChecklistFrame() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_DOCUMENT_CHECKLIST_FRAME);
	}

	public void selectProduct(DeviceCreation deviceCreation) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectByVisibleText(ProductType, deviceCreation.getProduct());
	}

	public void enterDocChecklistPlanCode() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(DocumentChecklistPlanCode, CustomUtils.randomNumbers(5));
	}

	public void enterDocChecklistDescription() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(Description, "MandatoryDocs Description");
	}

	public void clickSaveButton() {
		waitForElementVisible(save);
		ClickButton(save);
		SwitchToDefaultFrame();
	}

	public void clickAddDocCheckListSubDetails() {
		switchToIframe(Constants.ADD_DOCUMENT_CHECKLIST_FRAME);
		waitForElementVisible(addSubDetails);
		addSubDetails.click();
	}

	public void switchToAddDocumentChecklistDetailsFrame() {
		SwitchToDefaultFrame();
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_DOCUMENT_CHECKLIST_DETAILS_FRAME);
	}

	public void selectDocument() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectByVisibleText(DocumentName, getDocumentName());
	}

	public void selectDocumentMandatoryasTrueFalse() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickCheckBox(SelectedDocumentMandatory, true);
	}

	public void adddocumentchecklist(String product) {
		addDocumentChecklist.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_DOCUMENT_CHECKLIST_FRAME);
		SelectDropDownByText(ProductType, product);
		enterText(DocumentChecklistPlanCode, CustomUtils.randomNumbers(5));
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(Description, "MandatoryDocs Description");
		ClickButton(save);
		addWicketAjaxListeners(getFinder().getWebDriver());
		addDocChecklistDetails();
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_DOCUMENT_CHECKLIST_FRAME);
		ClickButton(save);
		// addWicketAjaxListeners(getFinder().getWebDriver());
		SwitchToDefaultFrame();
	}

	public void addDocChecklistDetails() {
		addSubDetails.click();
		SwitchToDefaultFrame();
		switchToIframe(Constants.ADD_DOCUMENT_CHECKLIST_DETAILS_FRAME);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(DocumentName, 1);
		ClickCheckBox(SelectedDocumentMandatory, true);
		ClickButton(save);
		SwitchToDefaultFrame();
	}

	public void adddocumentchecklistprepaid() {
		addDocumentChecklist.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");

		ProductType.getSelect().selectByVisibleText(env.getProperty("is.dinners.documentchecklistpr.ProductType"));
		CustomUtils.ThreadDotSleep(1000);
		DocumentChecklistPlanCode.sendKeys(CustomUtils.randomNumbers(5));
		CustomUtils.ThreadDotSleep(1000);
		Description.sendKeys(env.getProperty("is.dinners.documentchecklistpr.Description"));

		save.click();
		CustomUtils.ThreadDotSleep(2000);

		addSubDetails.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().defaultContent();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_16");
		CustomUtils.ThreadDotSleep(2000);

		DocumentName.getSelect().selectByVisibleText(env.getProperty("is.dinners.documentchecklistpr.DocumentName"));
		CustomUtils.ThreadDotSleep(1000);
		SelectedDocumentMandatory.click();

		save.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().defaultContent();

		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");
		CustomUtils.ThreadDotSleep(2000);
		save.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().defaultContent();

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
