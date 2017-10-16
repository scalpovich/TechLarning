package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ProcessBatches;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.FileCreation;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.MCWebElements;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

/**
 * @author e074127 Process Batches Page class
 */

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1OPERATION, CardManagementNav.L2PROCESSING_BATCHES,
		CardManagementNav.L3PROCESS_BATCHES })
public class ProcessBatchesPage extends AbstractBasePage {
	/** The logger. */
	final Logger logger = LoggerFactory.getLogger(this.getClass());

	@PageElement(findBy = FindBy.NAME, valueToFind = "batchType:input:dropdowncomponent")
	private MCWebElement batchTypeDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "batchId:input:dropdowncomponent")
	private MCWebElement batchNameDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "selectAll")
	private MCWebElement selectAllChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "childPanel:inputPanel:inputFiles:0:fileChecked:checkBoxComponent")
	private MCWebElement selectFirstChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "buttonPanel:submitButton")
	private MCWebElement submitBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "buttonPanel:Cancel")
	private MCWebElement cancelBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement closeBtn;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "feedbackPanelINFO")
	private MCWebElement feedbackInfoPanel;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[contains(text(),'Status :')]//following::span[position()=1]/span")
	private MCWebElement processBatchStatusTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='jobId']//span[@class='labeltextf']")
	private MCWebElement processBatchjobIDTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='dispTraceLink']/a")
	private MCWebElement tracesLink;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='recRejectCnt']/span/span")
	private MCWebElements rejectedCountTxt;

	private By tracesDescription = By
			.xpath("//table[@class='modelFormClass']//table[@class='dataview']//tr//child::td[position()=4]");

	private List<String> errorDescription = new ArrayList<String>();

	public void processBatch(String uploadedFileName,
			ProcessBatches processBatchesDomain) {
		String elementXpath = String.format("//span[contains(text(),'%s')]",
				uploadedFileName);
		String selectXpath = elementXpath
				+ "//parent::td//following-sibling::td/input";
		selectByVisibleText(batchTypeDdwn, processBatchesDomain.getBatchType());
		CustomUtils.ThreadDotSleep(500);
		selectByVisibleText(batchNameDdwn, processBatchesDomain.getBatchName());
		CustomUtils.ThreadDotSleep(2000);
		WebElement uploadedFilename = getFinder().getWebDriver().findElement(
				By.xpath(elementXpath));
		WebElement checkbox = getFinder().getWebDriver().findElement(
				By.xpath(selectXpath));

		waitForElementVisible(selectFirstChkBx);
		if (uploadedFileName.equalsIgnoreCase(uploadedFilename.getText())) {
			if (!checkbox.isSelected())
				checkbox.click();
			ClickButton(submitBtn);
		} else {
			logger.error("Uploaded file is not seen on the Process Batches page");
		}
	}

	public boolean verifyFileProcess(ProcessBatches processBatchesDomain) {
		String elementXpath = String.format("//span[contains(text(),'%s')]",
				FileCreation.filenameStatic);
		Boolean isProcessed = false;
		String statusXpath = elementXpath
				+ "//parent::td//following-sibling::td/a";
		CustomUtils.ThreadDotSleep(500);
		getFinder().getWebDriver().findElement(By.xpath(statusXpath)).click();
		switchToIframe(Constants.VIEW_BATCH_DETAILS);

		// unless it is completed, refresh it - No of attempts: 5
		for (int i = 0; i < 5; i++) {
			if (processBatchStatusTxt.getText().equalsIgnoreCase("PENDING [0]")
					|| processBatchStatusTxt.getText().equalsIgnoreCase(
							"IN PROCESS [1]")) {
				ClickButton(closeBtn);
				getFinder().getWebDriver().switchTo().defaultContent();
				getFinder().getWebDriver().findElement(By.xpath(statusXpath))
						.click();
				switchToIframe(Constants.VIEW_BATCH_DETAILS);
				waitForElementVisible(processBatchStatusTxt);
			} else if (processBatchStatusTxt.getText().equalsIgnoreCase(
					"SUCCESS [2]")) {
				if (rejectedCountTxt.getText().contains("0")
						|| rejectedCountTxt.getText().contains("-")) {
					isProcessed = true;
					break;
				} else {
					ClickButton(tracesLink);
					getBatchTraces();
					break;
				}
			} else if (processBatchStatusTxt.getText().equalsIgnoreCase(
					"FAILED [3]")) {
				ClickButton(tracesLink);
				getBatchTraces();
				break;
			}
		}
		processBatchesDomain.setJoBID(processBatchjobIDTxt.getText());
		ClickButton(closeBtn);
		getFinder().getWebDriver().switchTo().defaultContent();
		CustomUtils.ThreadDotSleep(200);
		return isProcessed;
	}

	public void getBatchTraces() {
		getFinder().getWebDriver().switchTo().defaultContent();
		switchToIframe(Constants.TROUBLESHOOTING_TRACES);
		List<WebElement> tracesList = getFinder().getWebDriver().findElements(
				tracesDescription);

		for (WebElement element : tracesList) {
			errorDescription.add(element.getText());
		}

		ClickButton(closeBtn);
		getFinder().getWebDriver().switchTo().defaultContent();
		CustomUtils.ThreadDotSleep(200);
		switchToIframe(Constants.VIEW_BATCH_DETAILS);
	}

	public boolean verifyErrorMessage(String errorType) {
		boolean isSimilar = false;
		String propertyFileKey = "";
		String[] errorMessageArray = errorType.split(" ");
		String key = "";
		for (int i = 0; i < errorMessageArray.length; i++)
			key += errorMessageArray[i].trim();
		propertyFileKey = "cer.errormessage." + key;

		for (int j = 0; j < errorDescription.size(); j++) {
			if (env.getProperty(propertyFileKey).equalsIgnoreCase(
					errorDescription.get(j))) {
				isSimilar = true;
				break;
			}
		}
		return isSimilar;
	}
}
