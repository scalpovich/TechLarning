package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.NewDevicePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class NewDeviceFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	public String createNewDevicePrepaid() {
		waitForElementVisible(menuSubMenuPage.getCardManagement());
		NewDevicePage newDevicepage = navigator.navigateToPage(NewDevicePage.class);
		newDevicepage.clickAddnewDevice();
		newDevicepage.switchToAddNewDeviceFrame();
		newDevicepage.selectAppliedForProduct();
		newDevicepage.selectAppliedType();
		newDevicepage.selectApplicationSubType();
		newDevicepage.clickNextButton();
		newDevicepage.GenerateBatchFrame();
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
		String DeviceNumber = newDevicepage.getDeviceNumber();
		return DeviceNumber;
	}

}
