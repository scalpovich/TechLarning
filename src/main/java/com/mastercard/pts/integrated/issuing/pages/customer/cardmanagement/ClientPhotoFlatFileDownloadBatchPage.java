package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ClientPhotoFlatFileDownloadBatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_OPERATION, CardManagementNav.L2_PROCESSING_BATCHES,
		CardManagementNav.L3_CLIENT_PHOTO_FLAT_FILE_DOWNLOAD_BATCH})
public class ClientPhotoFlatFileDownloadBatchPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(ClientPhotoFlatFileDownloadBatchPage.class);
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='cardNumber']")
	private MCWebElement txtDeviceNumber;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='batchNumber']")
	private MCWebElement txtBatchNumber;
	
	@PageElement(findBy = FindBy.CSS, valueToFind =  "input[fld_fqn='batchDate']" )
	private MCWebElement batchDate;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[contains(text(),'Product Type')]//following-sibling::td[2]//select")
	private MCWebElement productTypeDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[contains(text(),'Action Code')]//following-sibling::td[2]//select")
	private MCWebElement actionCodeDDwn;

	public String processClientPhotoFlatFileDownloadBatch(ClientPhotoFlatFileDownloadBatch batch, Device device) {
		WebElementUtils.selectDropDownByVisibleText(productTypeDDwn, batch.getProductType());
		WebElementUtils.enterText(txtDeviceNumber, device.getDeviceNumber());

		waitAndSearchForRecordToExist();
		verifyOperationStatus();
		String successMessage[] = getSuccessMessage().split(" ");
		return successMessage[successMessage.length-1];		        
	}
	
	public boolean isBatchDatePresent(){
		return isElementPresent(batchDate);
	}

	public void verifyUiOperationStatus() {
		logger.info("Client Photo/Flat file download Batch");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(txtBatchNumber));
	}

}
