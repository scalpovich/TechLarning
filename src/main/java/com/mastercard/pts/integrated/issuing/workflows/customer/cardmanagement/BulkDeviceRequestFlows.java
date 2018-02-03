package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BulkDeviceRequestbatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.BulkDeviceRequestPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class BulkDeviceRequestFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	public String createBulkdeviceRequest(DeviceCreation devicecreation, BulkDeviceRequestbatch bulkdevicerequest) {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		BulkDeviceRequestPage bulkdevicerequestpage = navigator.navigateToPage(BulkDeviceRequestPage.class);
		bulkdevicerequestpage.clickAddBulkDeviceRequestBtn();
		bulkdevicerequestpage.addBulkDeviceRequestGeneral(devicecreation, bulkdevicerequest);
		bulkdevicerequestpage.selectDevice(bulkdevicerequest);
		bulkdevicerequestpage.Save();
		bulkdevicerequestpage.verifyBulkDeviceRequestSuccess();
		return bulkdevicerequestpage.checkBatchNumber();
	}

}
