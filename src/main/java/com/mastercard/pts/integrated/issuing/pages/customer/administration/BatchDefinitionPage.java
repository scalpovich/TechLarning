package com.mastercard.pts.integrated.issuing.pages.customer.administration;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BatchDefinition;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = AdministrationNav.TAB_ADMINISTRATION, treeMenuItems = {
		AdministrationNav.L1_SETUP,
		AdministrationNav.L2_BATCH_DEFINITION
		})
public class BatchDefinitionPage extends AbstractBasePage{

	private static final Logger logger = LoggerFactory
			.getLogger(BatchDefinitionPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement batchTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement batchIDDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "inputDir:input:inputTextField")
	private MCWebElement txtInputFilePath;

	@PageElement(findBy = FindBy.NAME, valueToFind = "outputDir:input:inputTextField")
	private MCWebElement txtRejectedFilePath;

	@PageElement(findBy = FindBy.NAME, valueToFind = "procDir:input:inputTextField")
	private MCWebElement txtProcessedFilePath;

	@PageElement(findBy = FindBy.NAME, valueToFind = "chksumFlg:checkBoxComponent")
	private MCWebElement chkBxChecksumSupported;

	@PageElement(findBy = FindBy.NAME, valueToFind = "genRejectReport:checkBoxComponent")
	private MCWebElement chkBxGenerateAckReport;

	public void selectBatchType(String batchType) {
		selectByVisibleText(batchTypeDDwn, batchType);
	}

	public void selectBatchID(String batchID) {
		selectByVisibleText(batchIDDDwn, batchID);
	}

	public void enterInputFilePath(String inputFilePath) {
		enterText(txtInputFilePath, inputFilePath);
	}

	public void enterRejectedFilePath(String rejectedFilePath) {
		enterText(txtRejectedFilePath, rejectedFilePath);
	}

	public void enterProcessedFilePath(String processedFilePath) {
		enterText(txtProcessedFilePath, processedFilePath);
	}

	public void selectChecksum() {
		selectCheckBox(chkBxChecksumSupported, "ChecksumSupport");
	}

	public void selectGenerateAckReport() {
		selectCheckBox(chkBxGenerateAckReport, "GenerateAckReport");
	}

	public void searchForBatchDefinition(String batchType, String batchID) {
		selectBatchType(batchType);
		selectBatchID(batchID);
		clickSearchButton();
	}

	public void editBatchDefinition(BatchDefinition batchDefinition) {
		editFirstRecord();
		runWithinPopup("Edit Batch Definition", () -> {
			selectChecksum();
			selectGenerateAckReport();
			enterInputFilePath(batchDefinition.getInputFilePath());
			enterRejectedFilePath(batchDefinition.getRejectedFilePath());
			enterProcessedFilePath(batchDefinition.getProcessedFilePath());
			clickSaveButton();
		});
	}

	public void verifyUiOperationStatus() {
		logger.info("Batch Definition");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(batchTypeDDwn));
	}
}
