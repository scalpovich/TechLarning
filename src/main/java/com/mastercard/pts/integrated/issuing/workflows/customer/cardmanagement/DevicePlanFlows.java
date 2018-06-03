package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.ErrorMessages;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePlan;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DevicePlanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DevicePlanPageErrVal.MandatoryFeildValdiation;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
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
		deviceplanpage.transactionFeeAndLimitPlans();
		deviceplanpage.next();
		deviceplanpage.provideAuthorizationDetails(deviceplan);
		deviceplanpage.next();
		deviceplanpage.next();
		deviceplanpage.selectChipType();
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
		deviceplanpage.next();
		deviceplanpage.selectChipType();
		deviceplanpage.Finish();
		return devicePlanName;
	}

	public void validateErrormsg() {
		String errorPanelXpath = "//div[@class='ketchup-error-container-alt']";
		DevicePlanPage deviceplanpage = navigator.navigateToPage(DevicePlanPage.class);
		deviceplanpage.AddDevicePlan();
		deviceplanpage.clickNextButton();
		errorValidator.doManDatoryErrorValidation(pageErrorValidator(errorPanelXpath), MandatoryFeildValdiation.class);
		errorValidator.doFieldValidation(MandatoryFeildValdiation.class, deviceplanpage.nextBtn);
	}

}
