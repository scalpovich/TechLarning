package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.EmbossingPinPriorityPassFileTemplate;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.EmbossingPinPriorityPassFileTemplate.OrderByFormat;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.EmbossingPinPriorityPassFileTemplate.RecordFieldFormat;
import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_EMBOSSING_PARAMETERS,
		CardManagementNav.L3_EMBOSSING_PIN_AND_PRIORITY_PASS_FILE_TEMPLATE })
public class EmbossingPINAndPriorityPassFileTemplatePage extends
		AbstractModelPage {

	private static final Logger logger = LoggerFactory
			.getLogger(EmbossingPINAndPriorityPassFileTemplatePage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=templateId]")
	private MCWebElement templateId;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=templateDesc]")
	private MCWebElement templateDesc;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement fileType;

	// Main pop up page elements start here

	@PageElement(findBy = FindBy.NAME, valueToFind = "fileType:input:dropdowncomponent")
	private MCWebElement fileTypeAddEmbossingPinPassTemplatePopup;

	@PageElement(findBy = FindBy.NAME, valueToFind = "param:input:dropdowncomponent")
	private MCWebElement fieldDrpDwnPopup;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=paramLength]")
	private MCWebElement paramLengthPopup;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=paramValue]")
	private MCWebElement valuePopup;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=paramPriority]")
	private MCWebElement priorityPopup;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@id='EmbossingFileParamDetails']/div[4]/table")
	private MCWebElement recordByDetailTable;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@id='EmbossingFileParamDetailsOrderBy']/div[4]/table")
	private MCWebElement orderByFormatTable;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=checksumRequired]")
	private MCWebElement checksumChkBx;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=trailer]")
	private MCWebElement trailerChkBx;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=header1]")
	private MCWebElement headerChkBx;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@id='EmbossingFileParamDetails']/div[3]/table/tbody/tr[1]/td[1]/div/a")
	private MCWebElement recordDetailsAddBtnPopup;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@id='EmbossingFileParamDetailsOrderBy']/div[3]/table/tbody/tr[1]/td/div/a")
	private MCWebElement orderByFormatAddBtnPopup;

	public void verifyUiOperationStatus() {
		logger.info("Embossing, PIN and Priority Pass File Template");
		verifyUiOperation("Add Embossing, PIN and Priority Pass File Template");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(templateId),
				WebElementUtils.elementToBeClickable(templateDesc),
				WebElementUtils.elementToBeClickable(fileType));
	}

	public void addEmbossingPinPriorityPassFileTemplates(
			EmbossingPinPriorityPassFileTemplate page) {
		logger.info("Embossing,PIN and Priority Pass File Template");

		clickAddNewButton();

		runWithinPopup("Add Embossing, PIN and Priority Pass File Template",
				() -> {
					WebElementUtils.visibilityOf(templateId);
					WebElementUtils.enterText(templateId,
							page.getTemplateCode());
					WebElementUtils.enterText(templateDesc,
							page.getDescription());
					WebElementUtils.selectDropDownByVisibleText(
							fileTypeAddEmbossingPinPassTemplatePopup,
							page.getFileType());
					enableHeaderTrailerChecksum(page);
					clickAddDetailsButton();
					addRecordFieldFormats(page.getRecordField());
					addOrderByFormats(page.getOrderByFormat());
					clickSaveButton();
				});

	}

	public void addRecordFieldFormats(List<RecordFieldFormat> data) {
		logger.info("Adding field records starts");
		for (RecordFieldFormat record : data) {
			// used when there are more than 2 add buttons
			clickAddButtonVariant(recordDetailsAddBtnPopup);
			runWithinPopup("Add Record Field Format", () -> {

				WebElementUtils.selectDropDownByVisibleText(fieldDrpDwnPopup,
						record.getField());
				WebElementUtils.enterTextIfControlIsEnabled(paramLengthPopup,
						record.getLength());
				WebElementUtils.enterTextIfControlIsEnabled(valuePopup,
						record.getValue());
				clickSaveButton();

			});

			waitForRecordToAdd();
			verifyOperationStatus();

		}
	}

	public void addOrderByFormats(List<OrderByFormat> data) {
		logger.info("Adding orders by format starts");
		for (OrderByFormat record : data) {
			clickAddButtonVariant(orderByFormatAddBtnPopup);
			runWithinPopup("Add Order Field Format", () -> {

				WebElementUtils.selectDropDownByVisibleText(fieldDrpDwnPopup,
						record.getField());
				WebElementUtils.enterTextIfControlIsEnabled(priorityPopup,
						record.getPriority());
				clickSaveButton();

			});
			waitForRecordToAdd();
			verifyOperationStatus();

		}

	}

	public void waitForRecordToAdd() {

		WebElementUtils.visibilityOf(recordByDetailTable);
		WebElementUtils.visibilityOf(orderByFormatTable);
		WebElementUtils.waitForWicket(driver());

	}

	public void enableHeaderTrailerChecksum(
			EmbossingPinPriorityPassFileTemplate page) {

		if ("Priority Pass Template [P]".equalsIgnoreCase(page.getFileType())) {
			WebElementUtils.checkCheckbox(trailerChkBx, true);
			WebElementUtils.checkCheckbox(headerChkBx, true);
		} else if ("Embossing File Template [E]".equalsIgnoreCase(page
				.getFileType())) {
			WebElementUtils.checkCheckbox(trailerChkBx, true);
			WebElementUtils.checkCheckbox(headerChkBx, true);
			WebElementUtils.checkCheckbox(checksumChkBx, true);

		}
	}
}