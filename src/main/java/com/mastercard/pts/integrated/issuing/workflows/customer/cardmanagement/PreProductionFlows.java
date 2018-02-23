package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BulkDeviceRequestbatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.NewDevice;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.PreProductionBatchPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class PreProductionFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	public String createPreProductionBatch(DeviceCreation devicecreation, BulkDeviceRequestbatch bulkdevicerequestbatch,
			NewDevice newDevice) {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		PreProductionBatchPage preproductionpage = navigator.navigateToPage(PreProductionBatchPage.class);
		preproductionpage.searchBulkPreProductionBatch(devicecreation, bulkdevicerequestbatch, newDevice);
		preproductionpage.ProcessSelectedBatch(bulkdevicerequestbatch);
		preproductionpage.verifyPreProductionRequestSuccess();
		return preproductionpage.checkPreProductionJobID();
	}
}
