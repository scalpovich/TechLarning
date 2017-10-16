package com.mastercard.pts.integrated.issuing.pages;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MPTSBasePage;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class DocumentChecklistPage extends MPTSBasePage {

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

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
		addWicketAjaxListeners(getFinder().getWebDriver());
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

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}
