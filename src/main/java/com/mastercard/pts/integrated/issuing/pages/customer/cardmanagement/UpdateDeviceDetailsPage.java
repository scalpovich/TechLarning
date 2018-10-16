package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.page.PageElement;


@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_ACTIVITY, CardManagementNav.L2_DEVICE,
		CardManagementNav.L3_UPDATE_DEVICE_DETAILS })
public class UpdateDeviceDetailsPage extends AbstractCardManagementPage {

	private static final Logger logger = LoggerFactory.getLogger(UpdateDeviceDetailsPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = ".dataview tbody img[alt='Edit Record']")
	private MCWebElement firstRowEditLink;

	@PageElement(findBy = FindBy.NAME, valueToFind = "devicePromoPlanCode:input:dropdowncomponent")
	private MCWebElement devicePlanDDwn;

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(deviceNumber),
				WebElementUtils.elementToBeClickable(applicationNumber),
				WebElementUtils.elementToBeClickable(batchCreateNum));
	}

	public void updateDevicePlanForDevice(Device device){

		logger.info("Update device details for device number  {} ", device.getDeviceNumber());
		enterText(deviceNumber, device.getDeviceNumber());
		clickSearchButton();
		waitForRow();
		clickWhenClickable(firstRowEditLink);

		runWithinPopup("Edit Device Details", () -> {
			waitForElementVisible(devicePlanDDwn);
			selectByText(devicePlanDDwn, device.getDevicePromotionPlan());
			clickSaveButton();
		});
		verifyRecordMarkedForUpdationStatusSuccess();
	}

}
