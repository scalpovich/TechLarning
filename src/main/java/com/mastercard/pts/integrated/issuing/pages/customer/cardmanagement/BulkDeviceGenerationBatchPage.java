package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BulkDeviceGenerationBatch;
import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT,
	treeMenuItems = { CardManagementNav.L1_OPERATION, CardManagementNav.L2_PROCESSING_BATCHES, CardManagementNav.L3_BULK_DEVICE_GENERATION_BATCH})
public class BulkDeviceGenerationBatchPage extends AbstractModelPage{

	private static final Logger logger = LoggerFactory.getLogger(BulkDeviceGenerationBatchPage.class);

	  @PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	  private MCWebElement productTypeDDwn;
	  
	  @PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:inputTextField")
	  private MCWebElement batchNumberTxt;

	  public void processBulkDeviceGenerationBatch(BulkDeviceGenerationBatch batch){
		  logger.info("Bulk Device Generation Batch: {}", batch.getBatchNumber());
		  WebElementUtils.selectDropDownByVisibleText(productTypeDDwn, batch.getProductType());
		  WebElementUtils.enterText(batchNumberTxt, batch.getBatchNumber());
		  clickSearchButton();
		  selectFirstRecord();
		  clickProcessSelectedButton();
		  verifyOperationStatus();
	  }
	  
		public void verifyUiOperationStatus() {
		logger.info("Bulk Device Generation Batch");
		verifySearchButton("Search");
	}
	  
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.visibilityOf(batchNumberTxt));
	}

}
