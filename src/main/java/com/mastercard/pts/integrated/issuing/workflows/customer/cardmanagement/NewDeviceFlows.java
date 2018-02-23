package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.NewDevice;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.NewDevicePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class NewDeviceFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	public String createNewDevicePrepaid(NewDevice newDevice, Program program) {
		waitForElementVisible(menuSubMenuPage.getCardManagement());
		NewDevicePage newDevicepage = navigator.navigateToPage(NewDevicePage.class);

		newDevicepage.clickAddnewDevice();
		newDevicepage.switchToAddNewDeviceFrame();
		newDevicepage.selectAppliedForProduct(program);
		newDevicepage.selectAppliedType();
		newDevicepage.selectApplicationSubType();
		newDevicepage.clickNextButton();
		newDevicepage.GenerateBatchFrame(newDevice);
		newDevicepage.GeneralInformationFrame();
		newDevicepage.DeviceInformationScreen();
		newDevicepage.ProfileScreen();
		newDevicepage.AddressScreen();
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
