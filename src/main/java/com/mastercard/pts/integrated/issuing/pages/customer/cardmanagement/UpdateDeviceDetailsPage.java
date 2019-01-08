package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePromotionPlan;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.page.PageElement;


@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_ACTIVITY, CardManagementNav.L2_DEVICE,
		CardManagementNav.L3_UPDATE_DEVICE_DETAILS })
public class UpdateDeviceDetailsPage extends AbstractCardManagementPage {

	private static final Logger logger = LoggerFactory.getLogger(UpdateDeviceDetailsPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "devicePromoPlanCode:input:dropdowncomponent")
	protected MCWebElement devicePromotionPlanDdwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	protected MCWebElement saveBtn;
	
	private String editLink = "Edit Record";

	public void updateDevicePlanForDevice(Device device){
		logger.info("Update device details for device number  {} ", device.getDeviceNumber());
		searchDevice(device);
		waitForRow();
		editFirstRecord();
		runWithinPopup("Edit Device Details", () -> {
			waitForElementVisible(devicePromotionPlanDdwn);
			selectByText(devicePromotionPlanDdwn, device.getDevicePromotionPlan());
			clickSaveButton();
		});
		verifyRecordMarkedForUpdationStatusSuccess();
	}
	
	
	public void enterDeviceNumber(String device){
		WebElementUtils.enterText(deviceNumber, device);
	}	
	
	public void searchDevice(Device device){
		enterDeviceNumber(device.getDeviceNumber());
		clickSearchButton();		
	}
	
	public void openEditDevice(){		
		Element(String.format("//img[@alt='%s']", editLink)).click();
	}
	
	public void updateDevieWithPromotionPlan(Device device,DevicePromotionPlan promotionPlan){
		searchDevice(device);
		openEditDevice();
		runWithinPopup("Edit Device Details",()->{			
			if(Objects.nonNull(promotionPlan.getPlanDescription())){
				selectByVisibleText(devicePromotionPlanDdwn, promotionPlan.buildDescriptionAndCode());
			}else{
				selectByVisibleText(devicePromotionPlanDdwn, device.getAccountNumber());
			}
			clickWhenClickable(saveBtn);
			verifyRecordMarkedForUpdationStatusSuccess();
		});
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(deviceNumber),
				WebElementUtils.elementToBeClickable(applicationNumber),
				WebElementUtils.elementToBeClickable(batchCreateNum));
	}

}