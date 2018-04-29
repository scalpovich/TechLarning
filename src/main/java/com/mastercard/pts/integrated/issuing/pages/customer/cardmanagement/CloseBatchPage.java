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
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.CloseBatchFlows;
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
	
	protected  static final Logger logger = LoggerFactory.getLogger(CloseBatchPage.class);
	@PageElement(findBy = FindBy.CSS, valueToFind = ".dataview-div")
	private MCWebElement batchNoColumn;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div[4]/div[2]/div[2]/form[1]/div[2]/div[4]/table/tbody/tr/td[10]/span/input")
	private MCWebElement CloseBatchRecord;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement ProcessSelected;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "saveAll")
	private MCWebElement processAll;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//tbody/tr[@class='even' or @class='odd']/td[1]")
	public MCWebElements allBatchNumberTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//tbody/tr[1]/td[1]/td[10]/span/input")
	public MCWebElement firstBatchNumberTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElements allRowsTxt;

	public void closebatch() {
		waitForLoaderToDisappear();
		CloseBatchRecord.click();
		CustomUtils.ThreadDotSleep(1000);
		ProcessSelected.click();
		CustomUtils.ThreadDotSleep(1000);
	}

	public List<String> allBatchNumberRetrieval()
	{
		List<String>batchNumbers=new ArrayList<>();
		for(int i=0;i<allBatchNumberTxt.getElements().size();i++)
		{
			batchNumbers.add(allBatchNumberTxt.getElements().get(i).getText());
		}
		return batchNumbers;
	}
	
	public int identifyBatchNumberToProcess()
	{
		Device device=context.get(ContextConstants.DEVICE);
		int i;
		for(i=0;i<allBatchNumberRetrieval().size();i++)
		{
			if(allBatchNumberRetrieval().get(i).equals(device.getBatchNumber()))
			{
				logger.info("batchNumber: {}",allBatchNumberRetrieval().get(i));
				break;
			}
		}
		return i;
	}
	
	public void processAppropriateBatchForApplication()
	{
		String checkBox="//table[@class='dataview']//tbody/tr[@class='even' or @class='odd']["+identifyBatchNumberToProcess()+1+"]/td[10]/span/input";
		clickWhenClickable(driver().findElement(By.xpath(checkBox)));
		ProcessSelected.click();
		verifyOperationStatus();
		
	}
	
	public void processFirstBatch() {
		//clickWhenClickable(firstBatchNumberTxt);
		processAll.click();
		verifyOperationStatus();
	}
	
    @Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(batchNoColumn));
	}
}