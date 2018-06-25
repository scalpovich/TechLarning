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
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceProductionBatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PinGenerationBatch;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.MCWebElements;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_OPERATION,
		CardManagementNav.L2_PROCESSING_BATCHES,
		CardManagementNav.L3_PIN_GENERATION_BATCH })
public class PinGenerationBatchPage extends AbstractBasePage {

	@Autowired
	TestContext context;
	private static final Logger logger = LoggerFactory
			.getLogger(PinGenerationBatchPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:inputTextField")
	private MCWebElement deviceNumberTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:inputTextField")
	private MCWebElement batchNumberTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement productTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement actionCodeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:3:componentList:0:componentPanel:input:inputTextField")
	private MCWebElement referenceNumberTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "processAll")
	private MCWebElement processAllBtn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//tr[@class='headers']//a/span")
	private MCWebElements deviceNumberHeaderTxt;

	public String processPinGenerationBatch(PinGenerationBatch batch) {
		logger.info("Pin Generation Batch: {}", batch.getBatchNumber());
		WebElementUtils.enterText(batchNumberTxt, batch.getBatchNumber());
		WebElementUtils.selectDropDownByVisibleText(productTypeDDwn,
				batch.getProductType());

		waitAndSearchForRecordToExist();

		return getBatchNumberFromFeedbackPanel();

	}
	
	public void processPinProductionBatchNewApplication(PinGenerationBatch batch) {
		String batchNumber=context.get(CreditConstants.NEW_APPLICATION_BATCH);
		WebElementUtils.enterText(batchNumberTxt, batchNumber);
		waitAndSearchForRecordToExist();
		clickWhenClickable(processAllBtn);
		verifyOperationStatus();
		}
		
		public void processPinProductionBatchNewDevice(PinGenerationBatch batch) {
		Device device=context.get(ContextConstants.DEVICE);
		WebElementUtils.enterText(batchNumberTxt, device.getBatchNumber());
		waitAndSearchForRecordToExist();
		clickWhenClickable(processAllBtn);
		verifyOperationStatus();
}
		
		public void processPinProductionBatchNewDeviceCredit(PinGenerationBatch batch) {
			String batchNumber=context.get(CreditConstants.PRIMARY_BATCH_NUMBER);
			WebElementUtils.enterText(batchNumberTxt, batchNumber);
			waitAndSearchForRecordToExist();
			clickWhenClickable(processAllBtn);
			verifyOperationStatus();
	}
		
		public void processPinProductionBatchForAllForFileUpload(
				PinGenerationBatch batch) {
			    List<String> batchNumbers = context.get(CreditConstants.ALL_BATCH_NUMBERS_PREPRODUCTION);
				waitForLoaderToDisappear();
				WebElementUtils.selectDropDownByVisibleText(productTypeDDwn,batch.getProductType());
				WebElementUtils.enterText(batchNumberTxt, batchNumbers.get(0));
				waitAndSearchForRecordToAppear();
				clickWhenClickable(processAllBtn);
				verifyOperationStatus();
	}
		
		public void processPinProductionBatch(PinGenerationBatch batch) {
			WebElementUtils.selectDropDownByVisibleText(productTypeDDwn, batch.getProductType());
			WebElementUtils.enterText(batchNumberTxt, batch.getBatchNumber());
			waitAndSearchForRecordToAppear();
			deviceNumbers();
			waitAndSearchForRecordToExist();
			clickWhenClickable(processAllBtn);
			verifyOperationStatus();

		}

		public List<String>deviceNumbers()
		{
			List<WebElement>allDeviceNumbers=new ArrayList<>();
			List<String>allDeviceNumberfText=new ArrayList<>();
			allDeviceNumbers=driver().findElements(By.xpath("//table[@class='dataview']//tr[@class='even' or 'odd']/td["+deviceNumberHeaderIndexFetch()+"]/span"));
			
			for(int i=0;i<allDeviceNumbers.size();i++)
			{
				allDeviceNumberfText.add(allDeviceNumbers.get(i).getText());
			}
			context.put(ContextConstants.ALL_DEVICE_NUMBERS, allDeviceNumberfText);
			return allDeviceNumberfText;
		}
		
		public int deviceNumberHeaderIndexFetch()
		{ 
			int index=0;
			for(int i=0;i<deviceNumberHeaderTxt.getElements().size();i++)
			{
				if(deviceNumberHeaderTxt.getElements().get(i).getText().equals("Device Number"))
				{
					index=i;
				}
			}
			return index+1;
		}
		
	public void verifyUiOperationStatus() {
		logger.info("Pin Generation Batch");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(batchNumberTxt));
	}

}
