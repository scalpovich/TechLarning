package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BulkDeviceRequestbatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.BulkDeviceGenerationBatchPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class BulkDeviceGenerationFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	public String createBulkdeviceGeneration(DeviceCreation devicecreation,
			BulkDeviceRequestbatch bulkdevicerequestbatch) {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		BulkDeviceGenerationBatchPage bulkdevicegenerationpage = navigator
				.navigateToPage(BulkDeviceGenerationBatchPage.class);
		bulkdevicegenerationpage.searchBulkDeviceGenBatch(devicecreation, bulkdevicerequestbatch);
		bulkdevicegenerationpage.ProcessSelectedBatch(bulkdevicerequestbatch);
		bulkdevicegenerationpage.verifyBulkDeviceRequestSuccess();
		return bulkdevicegenerationpage.checkJobID();

	}

}
