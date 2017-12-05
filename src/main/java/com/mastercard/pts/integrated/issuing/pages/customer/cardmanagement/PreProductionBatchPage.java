package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PreProductionBatch;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT,
	treeMenuItems = { CardManagementNav.L1_OPERATION, CardManagementNav.L2_PROCESSING_BATCHES, CardManagementNav.L3_PRE_PRODUCTION_BATCH})

	public class PreProductionBatchPage extends AbstractBasePage{
	
	private static final Logger logger = LoggerFactory.getLogger(PreProductionBatchPage.class);
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement ProductTypeDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value = 'Search'][@type = 'submit']")
	private MCWebElement SearchBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "productionPanel:BasicDataTable:datatable:body:rows:1:cells:8:cell:columnCheckBox")
	private MCWebElement PreProductionBatchRecordChkBx;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value ='Process Selected'][@type= 'submit']")
	private MCWebElement ProcessSelectedBtn;

	  @PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	  private MCWebElement productTypeDDwn;
	  
	  @PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:inputTextField")
	  private MCWebElement batchNumberTxt;

	  @PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	  private MCWebElement batchTypeDDwn;
	  
	  @PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:1:componentPanel:input:inputTextField")
	  private MCWebElement sourceJobIdTxt;
	  
	  public void processPreProductionBatch(PreProductionBatch batch){
		  logger.info("Pre-Production Batch: {}", batch.getBatchNumber());
		  WebElementUtils.selectDropDownByVisibleText(productTypeDDwn, batch.getProductType());
		  WebElementUtils.enterText(batchNumberTxt, batch.getBatchNumber());
		
		  waitAndSearchForRecordToExist();
		  
		  verifyOperationStatus();
	  }

	  public void processPreProductionBatch1(PreProductionBatch batch) {

			waitForLoaderToDisappear();
            SelectDropDownByText(ProductTypeDDwn, batch.getProductType());
			waitUntilIsLoaded();
			logger.info(batch.getJobID());
			enterText(sourceJobIdTxt, batch.getJobID());
			ClickButton(SearchBtn);
			String batchNumberWebElement = "//table[@class='dataview']//tbody/tr/td[3]/span";
			String batchNumber = getFinder().getWebDriver().findElement(By.xpath(batchNumberWebElement)).getText().trim();
			logger.info("BatchNumber:" + batchNumber);
			batch.setBatchNumber(batchNumber);
			ClickButton(SearchBtn);
			ClickCheckBox(PreProductionBatchRecordChkBx, true);
			ClickButton(ProcessSelectedBtn);
			verifyOperationStatus();
			SwitchToDefaultFrame();

		}
	public void verifyUiOperationStatus() {
		logger.info("Pre-Prodcution Batch");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(batchNumberTxt));
	}

}
