package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.NewApplicationPage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;

// TODO: Auto-generated Javadoc
/**
 * @author E070234 The Class .
 */
@Component
public class NewApplicationFlows {

	@Autowired
	private Navigator navigator;

	NewApplicationPage newApplication;

	/**
	 * Navigate to Activity option.
	 */
	public void navigateToNewDeviceTab() {
		CustomUtils.ThreadDotSleep(5000);
		newApplication = navigator.navigateToPage(NewApplicationPage.class);
	}

	public void createNewApplication() {
		newApplication.addNewApplicationBtnClick();
	}

	public void addDetailsOnAddApplicationAcreen() {
		newApplication.selectMandatoryFields("BusinessMandatoryFields.xlsx");
		newApplication.addNewApplicationBtnClick();
		newApplication.setNewApplicationParametersValue();
		newApplication.SwitchToWindow(Constants.ADD_APPLICATION_SCREEN);
		newApplication.selectProductType();
		newApplication.selectApplicationType();
		newApplication.selectSubApplicationType();
		newApplication.clickNextBtn();
	}

	public void addDetailsOnBatchAcreen() {
		newApplication.selectCreateOpenBatch();
		newApplication.clickGenerateBtn();
		newApplication.clickNextBtn();
	}

	public void addGeneralDetails() {
		newApplication.selectCustomerType();
		newApplication.selectProgramCode();
		newApplication.clickNextBtn();
	}

	public void addDeviceInformation() {
		newApplication.selectDeviceType();
		newApplication.selectDevicePlan();
		newApplication.selectDevicePhotoIndicator();
		newApplication.clickNextBtn();
	}

	public void addProfileInformation() {
		newApplication.addProfileAndGeneralInformation();
	}

	public void addAddressInformation() {
		newApplication.enetrPreferredAddress();
		newApplication.enterAddressLine1();
		newApplication.selectCountry();
		newApplication.enterZipCode();
		newApplication.clickNextBtn();
	}

	public void submitTheForm() {
		newApplication.clickNextBtn();
		newApplication.clickNextBtn();
		newApplication.clickNextBtn();
		newApplication.clickNextBtn();
		newApplication.clickNextBtn();
		newApplication.clickNextBtn();
		newApplication.submitNewApplicationForm();
	}

	public void getGeneratedCardDetails() {
		newApplication.checkSuccessMsg();
		newApplication.getApplicationnumber();
		newApplication.getCreatedDeviceNumber();
	}

}
