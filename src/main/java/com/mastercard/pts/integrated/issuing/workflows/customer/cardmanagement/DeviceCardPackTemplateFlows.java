package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCardPackTemplate;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceCardPackTemplatePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class DeviceCardPackTemplateFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	public void createDeviceTemplateCardPack(DeviceCreation deviceCreation, DeviceCardPackTemplate deviceTemplate) {
		waitForElementVisible(menuSubMenuPage.getCardManagement());
		DeviceCardPackTemplatePage devicecardpacktemplatepage = navigator
				.navigateToPage(DeviceCardPackTemplatePage.class);
		devicecardpacktemplatepage.clickAddDeviceCardPackTemplate();
		devicecardpacktemplatepage.addTemplateFields(deviceCreation);
		devicecardpacktemplatepage.selectCardTemplateFields(deviceCreation, deviceTemplate);
		devicecardpacktemplatepage.clickSubmit();
		devicecardpacktemplatepage.clickSaveButton();
		devicecardpacktemplatepage.verifyNewVendorSuccess();
	}

	public void createCardPackTemplate(DeviceCreation deviceCreation, DeviceCardPackTemplate deviceTemplate) {
		waitForElementVisible(menuSubMenuPage.getCardManagement());
		DeviceCardPackTemplatePage devicecardpacktemplatepage = navigator
				.navigateToPage(DeviceCardPackTemplatePage.class);
		devicecardpacktemplatepage.clickAddDeviceCardPackTemplate();
		devicecardpacktemplatepage.addTemplateFields(deviceCreation);
		devicecardpacktemplatepage.selectDeviceTemplateFields(deviceCreation, deviceTemplate);
		devicecardpacktemplatepage.clickSubmit();
		devicecardpacktemplatepage.clickSaveButton();
		devicecardpacktemplatepage.verifyNewVendorSuccess();
	}

}
