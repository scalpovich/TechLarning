package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ClientPhotoFlatFileDownloadBatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceProductionBatch;
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

	@Autowired
	TestContext context;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='cardNumber']")
	private MCWebElement deviceNumberTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='batchNumber']")
	private MCWebElement batchNumberTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[contains(text(),'Product Type')]//following-sibling::td[2]//select")
	private MCWebElement productTypeDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[contains(text(),'Action Code')]//following-sibling::td[2]//select")
	private MCWebElement actionCodeDDwn;

	public void processClientPhotoFlatFileDownloadBatch(ClientPhotoFlatFileDownloadBatch batch) {
		Device device = context.get(ContextConstants.DEVICE);
		WebElementUtils.selectDropDownByVisibleText(productTypeDDwn, batch.getProductType());
		WebElementUtils.enterText(deviceNumberTxt, device.getDeviceNumber());

		waitAndSearchForRecordToExist();

		verifyOperationStatus();
	}

	public void verifyUiOperationStatus() {
		logger.info("Client Photo/Flat file download Batch");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(batchNumberTxt));
	}

}
