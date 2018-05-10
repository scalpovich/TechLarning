package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BulkDeviceRequestbatch;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceProductionPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class DeviceProductionFlows extends MenuFlows {
	@Autowired
	Navigator navigator;

	public String createDeviceProductionBatch(BulkDeviceRequestbatch bulkdevicerequestbatch) {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		DeviceProductionPage deviceproductionpage = navigator.navigateToPage(DeviceProductionPage.class);
		deviceproductionpage.searchDeviceProductionBatch(bulkdevicerequestbatch);
		deviceproductionpage.ProcessSelectedBatch(bulkdevicerequestbatch);
		deviceproductionpage.verifyDeviceProductionRequestSuccess();
		return deviceproductionpage.checkDeviceProductionJobID();
	}

	public String createDeviceProductionBatchProcessAll(BulkDeviceRequestbatch bulkdevicerequestbatch) {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		DeviceProductionPage deviceproductionpage = navigator.navigateToPage(DeviceProductionPage.class);
		deviceproductionpage.searchDeviceProductionBatch(bulkdevicerequestbatch);
		bulkdevicerequestbatch
				.setDeviceNumberFromBulkDevice(deviceproductionpage.getDeviceNumber(bulkdevicerequestbatch));
		deviceproductionpage.ProcessAllBatch(bulkdevicerequestbatch);
		deviceproductionpage.verifyDeviceProductionRequestSuccess();
		return deviceproductionpage.checkDeviceProductionJobID();
	}

}
