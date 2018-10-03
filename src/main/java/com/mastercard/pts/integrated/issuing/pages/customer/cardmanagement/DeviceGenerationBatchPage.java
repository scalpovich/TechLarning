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

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
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
		CardManagementNav.L4_DEVICE_GENERATION })
public class DeviceGenerationBatchPage extends AbstractBasePage {

	@Autowired
	TestContext context;
	
	protected  static final Logger logger = LoggerFactory.getLogger(DeviceGenerationBatchPage.class);
	@PageElement(findBy = FindBy.CSS, valueToFind = ".dataview-div")
	private MCWebElement batchNoColumn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement processSelected;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "saveAll")
	private MCWebElement processAll;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//tbody/tr[@class='even' or @class='odd']/td[1]")
	private MCWebElements allBatchNumberTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElements allRowsTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[text()='Device Generation']")
	private MCWebElement deviceGenerationLink;	
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//tbody/tr[1]/td[1]/td[10]/span/input")
	public MCWebElement firstBatchNumberTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value='Process All']")
	public MCWebElement processAllBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "table.dataview")
	private MCWebElement searchTable;


	public List<String> allBatchNumberRetrieval(){
		List<String>batchNumbers = new ArrayList<>();
		allBatchNumberTxt.getElements().stream().forEach((element)->{
			batchNumbers.add(element.getText());
		});
		return batchNumbers;	
	}	
	

	public int identifyBatchNumberToProcess(){
		Device device = context.get(ContextConstants.DEVICE);
		int index = 0;
		for(int i=0;i < allBatchNumberRetrieval().size(); i++){
			if(allBatchNumberRetrieval().get(i).equals(device.getBatchNumber())){
				logger.info("Batch Number: {}",allBatchNumberRetrieval().get(i));
				index = i;
			}
		}
		return index;
	}	
	
	public void processAppropriateBatchForApplication(){  
		checkWhetherRecordPersists();
		String checkBox = "//table[@class='dataview']//tbody/tr[@class='even' or @class='odd']["+identifyBatchNumberToProcess()+1+"]/td[8]/span/input";
		clickWhenClickable(getFinder().getWebDriver().findElement(By.xpath(checkBox)));
		processSelected.click();
		verifyOperationStatus();		
	}	
	
	public void checkWhetherRecordPersists() {
		if (isNoRecordsFoundInTable()) {
			clickWhenClickable(deviceGenerationLink);
			checkWhetherRecordPersists();
		}
	}
	
	public void processFirstBatch() {
		processAll.click();
		verifyOperationStatus();
	}
	
	public void processAllClick() {
		SimulatorUtilities.wait(8000);
		if (!waitForRow()) {
			clickWhenClickable(deviceGenerationLink);
		}
		clickWhenClickable(processAll);
	}
	
	public void processAllBatch() {
		deviceGenerationBatch();
		clickWhenClickable(processAllBtn);
	}
	
	private void deviceGenerationBatch() {
		if (!WebElementUtils.isTextAvailableinTable(searchTable, context.get(CreditConstants.PRIMARY_BATCH_NUMBER))) {
			clickWhenClickable(deviceGenerationLink);
			deviceGenerationBatch();
		}
	}
	
	public int identifyBatchNumberToProcessForFileUpload() {
		int i = 0;
		String batchNumber = context.get(CreditConstants.BATCH_NUMBER_FILEUPLOAD);
		logger.info("BatchNumber_Application:{}", batchNumber);
		for (i = 0; i < allBatchNumberRetrieval().size(); i++) {
			if (allBatchNumberRetrieval().get(i).equals(batchNumber)) {
				logger.info("batchNumber: {}", allBatchNumberRetrieval().get(i));
			}
		}
		return i;
	}
	
	public void processAppropriateBatchForApplicationForFileUpload() {
		checkWhetherRecordPersists();
		String checkBox = "//table[@class='dataview']//tbody/tr[@class='even' or @class='odd'][" + identifyBatchNumberToProcessForFileUpload() + 1 + "]/td[8]/span/input";
		clickWhenClickable(getFinder().getWebDriver().findElement(By.xpath(checkBox)));
		processSelected.click();
		verifyOperationStatus();

	}
	
    @Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(batchNoColumn));
	}
}