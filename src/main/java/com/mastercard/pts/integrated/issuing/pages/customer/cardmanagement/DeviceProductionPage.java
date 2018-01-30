package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceProductionBatch;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.MenuSubMenuPage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.MCWebElements;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {CardManagementNav.L1_OPERATION,CardManagementNav.L2_PROCESSING_BATCHES,CardManagementNav.L3_DEVICE_PRODUCTION_BATCH })
public class DeviceProductionPage extends AbstractBasePage {
	private static final Logger logger = LoggerFactory.getLogger(DeviceProductionPage.class);
	@Autowired
	MenuSubMenuPage menuSubMenuPage;

	@Autowired
	TestContext context;
	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement ProductTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:inputTextField")
	private MCWebElement BatchNumberTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:inputTextField")
	private MCWebElement DeviceNumberTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:searchButtonPanel:buttonCol:searchButton")
	private MCWebElement SearchBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "dataPanel:BasicDataTable:datatable:body:rows:1:cells:7:cell:columnCheckBox")
	private MCWebElement DeviceProductionBatchRecordChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "processSelected")
	private MCWebElement ProcessSelectedBtn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//tbody/tr")
	private MCWebElements rowSize;
	
	public void deviceproduction(String prodType, String batchNum, String DeviceNumber) {
		menuSubMenuPage.getDeviceProduction().click();
		SelectDropDownByText(ProductTypeDDwn, prodType);
		if (batchNum != null) {
			enterText(BatchNumberTxt, batchNum);
		}

		if (DeviceNumber != null) {
			enterText(DeviceNumberTxt, DeviceNumber);
		}
		ClickButton(SearchBtn);

		if (DeviceProductionBatchRecordChkBx.isVisible()) {
			ClickCheckBox(DeviceProductionBatchRecordChkBx, true);
		} else {
			ClickButton(SearchBtn);
			CustomUtils.ThreadDotSleep(10000);
		}
		ClickButton(ProcessSelectedBtn);

	}
	public void processDeviceProductionBatch(DeviceProductionBatch batch) {
		WebElementUtils.enterText(BatchNumberTxt, batch.getBatchNumber());
		waitAndSearchForRecordToExist();
		verifyOperationStatus();

	}
	
	public void processDeviceProductionBatchNewDevice(DeviceProductionBatch batch) {
		Device device=context.get(ContextConstants.DEVICE);
		WebElementUtils.enterText(BatchNumberTxt, device.getBatchNumber());
		waitAndSearchForRecordToExist();
		verifyOperationStatus();

	}
	
	public void processDeviceProductionBatchNewApplication(DeviceProductionBatch batch) {
		String batchNumber=context.get(ContextConstants.NEW_APPLICATION_BATCH);
		WebElementUtils.enterText(BatchNumberTxt, batchNumber);
		waitAndSearchForRecordToExist();
		verifyOperationStatus();

	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}