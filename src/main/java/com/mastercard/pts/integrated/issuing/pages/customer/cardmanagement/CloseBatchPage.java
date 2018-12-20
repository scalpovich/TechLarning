package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.MCWebElements;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_OPERATION,
		CardManagementNav.L2_OPERATION_APPLICATION,
		CardManagementNav.L3_OPERATION_APPLICATION_CREDIT,
		CardManagementNav.L4_CLOSE_BATCH })
public class CloseBatchPage extends AbstractBasePage {

	@Autowired
	TestContext context;
	
	@Autowired
	private KeyValueProvider provider;
	
	protected  static final Logger logger = LoggerFactory.getLogger(CloseBatchPage.class);
	
	@PageElement(findBy = FindBy.CSS, valueToFind = ".dataview-div")
	private MCWebElement batchNoColumn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div[4]/div[2]/div[2]/form[1]/div[2]/div[4]/table/tbody/tr/td[10]/span/input")
	private MCWebElement closeBatchRecord;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement processSelected;

	@PageElement(findBy = FindBy.NAME, valueToFind = "saveAll")
	private MCWebElement processAll;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value='Process Selected']")
	private MCWebElement btnProcessSelected;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//tbody/tr[@class='even' or @class='odd']/td[1]")
	public MCWebElements txtAllBatchNumber;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//tbody/tr[1]/td[1]/td[10]/span/input")
	public MCWebElement txtFirstBatchNumber;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value='Yes']")
	private MCWebElement btnYes;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value='No']")
	private MCWebElement noBtn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//h3[text()= 'Confirmation Message']/ancestor::div//iframe")
	private MCWebElement btnConfirmMsg;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value='Process All']")
	private MCWebElement btnProcessAll;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "table.dataview")
	private MCWebElement searchTable;

	public void closebatch() {
		waitForLoaderToDisappear();
		closeBatchRecord.click();
		CustomUtils.ThreadDotSleep(1000);
		processSelected.click();
		CustomUtils.ThreadDotSleep(1000);
	}
	
	public List<String> allBatchNumberRetrieval() {
		List<String> batchNumbers = new ArrayList<>();
		txtAllBatchNumber.getElements().stream().forEach((element) -> {
			batchNumbers.add(element.getText());
		});
		return batchNumbers;
	}
	
	public int identifyBatchNumberToProcess()
	{
		String batchNumber=context.get(CreditConstants.PRIMARY_BATCH_NUMBER);
		int index;
		for(index=0;index<allBatchNumberRetrieval().size();index++){
			if(allBatchNumberRetrieval().get(index).equals(batchNumber)){
				logger.info("Batch Number: {}",allBatchNumberRetrieval().get(index));
				break;
			}
		}
		return index;
	}
	
	public void processAppropriateBatchForApplication() {
		String checkBox = "//table[@class='dataview']//tbody/tr[@class='even' or @class='odd'][" + identifyBatchNumberToProcess() + 1 + "]/td[10]/span/input";
		clickWhenClickable(driver().findElement(By.xpath(checkBox)));
		SimulatorUtilities.wait(2000);
		clickWhenClickable(btnProcessSelected);
		try {
			clickNoBtnIfConfirmBoxAppeared();
			verifyOperationStatus();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void processFirstBatch() {
		clickWhenClickable(txtFirstBatchNumber);
		clickWhenClickable(btnProcessSelected);
		verifyOperationStatus();
	}
	
	public void processAllBatch() {
		clickOncheckBoxIfBatchAvailableinTable(searchTable, context.get(CreditConstants.PRIMARY_BATCH_NUMBER));
		clickProcessSelectedButton();
		try {
			if (btnConfirmMsg.isEnabled() && btnConfirmMsg.isVisible()) {
				switchToIframe("Confirmation Message");
				clickWhenClickable(btnYes);
				verifyOperationStatus();
			} else {
				verifyOperationStatus();
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void processAllClick() {
		clickWhenClickable(processAll);
		try {
			if (btnConfirmMsg.isEnabled() && btnConfirmMsg.isVisible()) {
				switchToIframe("Confirmation Message");
				clickWhenClickable(btnYes);
				verifyOperationStatus();
			} else {
				verifyOperationStatus();
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public int identifyBatchNumberToProcessForFileUpload() {
		int i;
		String batchNumber = context.get(CreditConstants.BATCH_NUMBER_FILEUPLOAD);
		logger.info("BatchNumber_Application:{}", batchNumber);
		for (i = 0; i < allBatchNumberRetrieval().size(); i++) {
			if (allBatchNumberRetrieval().get(i).equals(batchNumber.trim())) {
				logger.info("Batch Number: {}", allBatchNumberRetrieval().get(i));
				break;
			}
		}
		return i;
	}
	
	public void processAppropriateBatchForApplicationForFileUpload() {
		String checkBox = "//table[@class='dataview']//tbody/tr[@class='even' or @class='odd'][" + identifyBatchNumberToProcessForFileUpload() + 1 + "]/td[10]/span/input";
		clickWhenClickable(driver().findElement(By.xpath(checkBox)));
		clickWhenClickable(btnProcessSelected);
		try {
			if (asWebElement(btnConfirmMsg).isDisplayed()) {
				switchToIframe("Confirmation Message");
				clickWhenClickable(btnYes);
				verifyOperationStatus();
			} else {
				verifyOperationStatus();
			}

		} catch (Exception e) {
			e.getMessage();
		}

	}
	
    @Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(batchNoColumn));
	}
}