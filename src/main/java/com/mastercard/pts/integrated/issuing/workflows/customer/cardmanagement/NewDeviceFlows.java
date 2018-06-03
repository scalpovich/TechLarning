package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.NewDevice;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.NewDevicePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class NewDeviceFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	public String createNewDevicePrepaid(NewDevice newDevice) {
		waitForElementVisible(menuSubMenuPage.getCardManagement());
		NewDevicePage newDevicepage = navigator.navigateToPage(NewDevicePage.class);

		newDevicepage.clickAddnewDevice();
		newDevicepage.switchToAddNewDeviceFrame();
		newDevicepage.selectAppliedForProduct(newDevice);
		newDevicepage.selectAppliedType(newDevice);
		newDevicepage.selectApplicationSubType(newDevice);
		newDevicepage.clickNextButton();
		newDevicepage.GenerateBatchFrame(newDevice);
		newDevicepage.GeneralInformationFrame(newDevice);
		newDevicepage.DeviceInformationScreen(newDevice);
		newDevicepage.ProfileScreen(newDevice);
		newDevicepage.clickNextButton();
		newDevicepage.AddressScreen(newDevice);
		newDevicepage.OccupationDetailsScreen();
		newDevicepage.clickNextButton();
		newDevicepage.clickNextButton();
		newDevicepage.clickNextButton();
		newDevicepage.clickNextButton();
		newDevicepage.clickFinishButton();
		String DeviceNumber = newDevice.getDeviceNumber();
		return DeviceNumber;
	}

}
