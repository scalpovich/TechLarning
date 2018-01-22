package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.ErrorMessages;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePlan;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DevicePlanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DevicePlanPageErrVal.MandatoryFeildValdiation;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class DevicePlanFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	@Autowired
	ErrorMessages errorValidator;

	public String createDevicePlan(DevicePlan deviceplan) {
		String devicePlanName;
		DevicePlanPage deviceplanpage = navigator.navigateToPage(DevicePlanPage.class);
		deviceplanpage.AddDevicePlan();
		devicePlanName = deviceplanpage.provideGeneralDetails(deviceplan);
		deviceplanpage.deviceNumberGeneration(deviceplan);
		deviceplanpage.personalization(deviceplan);
		waitForPageToLoad(getFinder().getWebDriver());
		deviceplanpage.next();
		deviceplanpage.transactionFeeAndLimitPlans();
		deviceplanpage.next();
		deviceplanpage.provideAuthorizationDetails(deviceplan);
		deviceplanpage.next();
		deviceplanpage.next();
		deviceplanpage.Finish();
		return devicePlanName;
	}

	public String createDevicePlanforPairedDevices(DevicePlan deviceplan) {
		String devicePlanName;
		DevicePlanPage deviceplanpage = navigator.navigateToPage(DevicePlanPage.class);
		deviceplanpage.AddDevicePlan();
		devicePlanName = deviceplanpage.provideGeneralDetails(deviceplan);
		deviceplanpage.deviceNumberGeneration(deviceplan);
		deviceplanpage.clickissuePairDevices();
		deviceplanpage.personalization(deviceplan);
		waitForPageToLoad(getFinder().getWebDriver());
		deviceplanpage.transactionFeeAndLimitPlans();
		deviceplanpage.next();
		deviceplanpage.provideAuthorizationDetails(deviceplan);
		deviceplanpage.next();
		deviceplanpage.fillVirtualDeviceDetails(deviceplan);
		deviceplanpage.next();
		deviceplanpage.Finish();
		return devicePlanName;
	}

	public void validateErrormsg(DevicePlan deviceplan) {
		String errorPanelXpath = "//div[@class='ketchup-error-container-alt']";
		DevicePlanPage deviceplanpage = navigator.navigateToPage(DevicePlanPage.class);
		deviceplanpage.AddDevicePlan();
		deviceplanpage.clickNextButton();
		errorValidator.doManDatoryErrorValidation(pageErrorValidator(errorPanelXpath), MandatoryFeildValdiation.class);
		errorValidator.doFieldValidation(MandatoryFeildValdiation.class, deviceplanpage.nextBtn);
	}

	/*
	 * public String createDevicePlan(DeviceCreation deviceCreation) {
	 * waitForElementVisible(menuSubMenuPage.getCardManagement());
	 * DevicePlanPage deviceplanpage =
	 * navigator.navigateToPage(DevicePlanPage.class);
	 * deviceplanpage.clickAddDevicePlan();
	 * deviceplanpage.switchToAddDevicePlanFrame(); String deviceplancode =
	 * deviceplanpage.enterDevicePlanCode(); String Description =
	 * deviceplanpage.enterDescription();
	 * deviceplanpage.selectAssociation(deviceCreation);
	 * deviceplanpage.selectproduct(deviceCreation);
	 * deviceplanpage.selectDeviceType(deviceCreation);
	 * deviceplanpage.enterServiceCode();
	 * deviceplanpage.selectDeviceIDGenerationTemplate();
	 * deviceplanpage.selectCardPackGenerationTemplate();
	 * deviceplanpage.selectActivationMode(); deviceplanpage.selectExpiryDate();
	 * deviceplanpage.selectDeliveryMode(); deviceplanpage.selectPlasticId();
	 * deviceplanpage.selectPictureCode();
	 * deviceplanpage.selectEmbossingVendor(); deviceplanpage.enterCustomCode();
	 * deviceplanpage.clickNextButton();
	 * deviceplanpage.selectEventBasedFeePlan();
	 * deviceplanpage.selectMembershipFeePlan();
	 * deviceplanpage.selectTransactionLimitPlan();
	 * deviceplanpage.clickNext2Button(); deviceplanpage.selectAfterKYC();
	 * deviceplanpage.clickNext3Button(); deviceplanpage.clickNext4Button();
	 * deviceplanpage.clickFinishButton(); return Description + " " + "[" +
	 * deviceplancode + "]"; }
	 * 
	 * public String createDevicePlanEmvType(DeviceCreation deviceCreation) {
	 * waitForElementVisible(menuSubMenuPage.getCardManagement());
	 * DevicePlanPage deviceplanpage =
	 * navigator.navigateToPage(DevicePlanPage.class);
	 * deviceplanpage.clickAddDevicePlan();
	 * deviceplanpage.switchToAddDevicePlanFrame(); String deviceplancode =
	 * deviceplanpage.enterDevicePlanCode(); String Description =
	 * deviceplanpage.enterDescription();
	 * deviceplanpage.selectAssociation(deviceCreation);
	 * deviceplanpage.selectproduct(deviceCreation);
	 * deviceplanpage.selectDeviceType(deviceCreation);
	 * deviceplanpage.enterServiceCode();
	 * deviceplanpage.selectDeviceIDGenerationTemplate();
	 * deviceplanpage.selectCardPackGenerationTemplate();
	 * deviceplanpage.selectActivationMode(); deviceplanpage.selectExpiryDate();
	 * deviceplanpage.selectDeliveryMode(); deviceplanpage.selectPlasticId();
	 * deviceplanpage.selectPictureCode();
	 * deviceplanpage.selectEmbossingVendor(); deviceplanpage.enterCustomCode();
	 * deviceplanpage.clickNextButton();
	 * deviceplanpage.selectEventBasedFeePlan();
	 * deviceplanpage.selectMembershipFeePlan();
	 * deviceplanpage.selectTransactionLimitPlan();
	 * deviceplanpage.clickNext2Button(); deviceplanpage.selectAfterKYC();
	 * deviceplanpage.clickNext3Button(); deviceplanpage.clickNext4Button();
	 * deviceplanpage.selectChipType(); deviceplanpage.clickFinishButton();
	 * return Description + " " + "[" + deviceplancode + "]"; }
	 * 
	 * public String createDevicePlanStaticVirtual(DeviceCreation
	 * deviceCreation) {
	 * waitForElementVisible(menuSubMenuPage.getCardManagement());
	 * DevicePlanPage deviceplanpage =
	 * navigator.navigateToPage(DevicePlanPage.class);
	 * deviceplanpage.clickAddDevicePlan();
	 * deviceplanpage.switchToAddDevicePlanFrame(); String deviceplancode =
	 * deviceplanpage.enterDevicePlanCode(); String Description =
	 * deviceplanpage.enterDescription();
	 * deviceplanpage.selectAssociation(deviceCreation);
	 * deviceplanpage.selectproduct(deviceCreation);
	 * deviceplanpage.selectDeviceType(deviceCreation);
	 * deviceplanpage.enterServiceCode();
	 * deviceplanpage.selectDeviceIDGenerationTemplate();
	 * deviceplanpage.selectCardPackGenerationTemplate();
	 * deviceplanpage.selectActivationMode(); deviceplanpage.selectExpiryDate();
	 * deviceplanpage.clickNextButton();
	 * deviceplanpage.selectEventBasedFeePlan();
	 * deviceplanpage.selectMembershipFeePlan();
	 * deviceplanpage.selectTransactionLimitPlan();
	 * deviceplanpage.clickNext2Button(); deviceplanpage.selectAfterKYC();
	 * deviceplanpage.clickEcomCheckBox(); deviceplanpage.clickNext3Button();
	 * deviceplanpage.clickNext4Button(); deviceplanpage.clickFinishButton();
	 * return Description + " " + "[" + deviceplancode + "]"; }
	 * 
	 * public String createDevicePlanLimitedValidity(DeviceCreation
	 * deviceCreation) {
	 * waitForElementVisible(menuSubMenuPage.getCardManagement());
	 * DevicePlanPage deviceplanpage =
	 * navigator.navigateToPage(DevicePlanPage.class);
	 * deviceplanpage.clickAddDevicePlan();
	 * deviceplanpage.switchToAddDevicePlanFrame(); String deviceplancode =
	 * deviceplanpage.enterDevicePlanCode(); String Description =
	 * deviceplanpage.enterDescription();
	 * deviceplanpage.selectAssociation(deviceCreation);
	 * deviceplanpage.selectproduct(deviceCreation);
	 * deviceplanpage.selectDeviceType(deviceCreation);
	 * deviceplanpage.enterServiceCode();
	 * deviceplanpage.selectDeviceIDGenerationTemplate();
	 * deviceplanpage.selectCardPackGenerationTemplate();
	 * deviceplanpage.clickNextButton();
	 * deviceplanpage.selectEventBasedFeePlan();
	 * deviceplanpage.selectMembershipFeePlan();
	 * deviceplanpage.selectTransactionLimitPlan();
	 * deviceplanpage.clickNext2Button(); deviceplanpage.selectAfterKYC();
	 * deviceplanpage.clickEcomCheckBox(); deviceplanpage.clickNext3Button();
	 * deviceplanpage.enterPerTransactionLimit(deviceCreation);
	 * deviceplanpage.enterTotalTransactionLimit();
	 * deviceplanpage.enterValidity(deviceCreation);
	 * deviceplanpage.enterVelocity(deviceCreation);
	 * deviceplanpage.clickNext4Button(); deviceplanpage.clickFinishButton();
	 * return Description + " " + "[" + deviceplancode + "]"; }
	 * 
	 * public String createDevicePlanMobile(DeviceCreation deviceCreation) {
	 * waitForElementVisible(menuSubMenuPage.getCardManagement());
	 * DevicePlanPage deviceplanpage =
	 * navigator.navigateToPage(DevicePlanPage.class);
	 * deviceplanpage.clickAddDevicePlan();
	 * deviceplanpage.switchToAddDevicePlanFrame(); String deviceplancode =
	 * deviceplanpage.enterDevicePlanCode(); String Description =
	 * deviceplanpage.enterDescription();
	 * deviceplanpage.selectAssociation(deviceCreation);
	 * deviceplanpage.selectproduct(deviceCreation);
	 * deviceplanpage.selectDeviceType(deviceCreation);
	 * deviceplanpage.selectDeviceIDGenerationTemplate();
	 * deviceplanpage.selectCardPackGenerationTemplate();
	 * deviceplanpage.selectActivationMode(); deviceplanpage.clickNextButton();
	 * deviceplanpage.selectEventBasedFeePlan();
	 * deviceplanpage.selectMembershipFeePlan();
	 * deviceplanpage.selectTransactionLimitPlan();
	 * deviceplanpage.clickNext2Button(); deviceplanpage.selectAfterKYC();
	 * deviceplanpage.clickNext3Button(); deviceplanpage.clickNext4Button();
	 * deviceplanpage.clickFinishButton(); return Description + " " + "[" +
	 * deviceplancode + "]";
	 * 
	 * }
	 * 
	 * public String createDevicePlanATMAdmin(DeviceCreation deviceCreation) {
	 * waitForElementVisible(menuSubMenuPage.getCardManagement());
	 * DevicePlanPage deviceplanpage =
	 * navigator.navigateToPage(DevicePlanPage.class);
	 * deviceplanpage.clickAddDevicePlan();
	 * deviceplanpage.switchToAddDevicePlanFrame(); String deviceplancode =
	 * deviceplanpage.enterDevicePlanCode(); String Description =
	 * deviceplanpage.enterDescription();
	 * deviceplanpage.selectAssociation(deviceCreation);
	 * deviceplanpage.selectproduct(deviceCreation);
	 * deviceplanpage.selectDeviceType(deviceCreation);
	 * deviceplanpage.enterServiceCode();
	 * deviceplanpage.selectDeviceIDGenerationTemplate();
	 * deviceplanpage.selectCardPackGenerationTemplate();
	 * deviceplanpage.selectActivationMode(); deviceplanpage.selectExpiryDate();
	 * deviceplanpage.selectDeliveryMode(); deviceplanpage.selectPlasticId();
	 * deviceplanpage.selectPictureCode();
	 * deviceplanpage.selectEmbossingVendor(); deviceplanpage.enterCustomCode();
	 * deviceplanpage.clickNextButton(); deviceplanpage.clickNext2Button();
	 * deviceplanpage.clickNext3Button(); deviceplanpage.clickNext4Button();
	 * deviceplanpage.clickFinishButton(); return Description + " " + "[" +
	 * deviceplancode + "]"; }
	 */
}
