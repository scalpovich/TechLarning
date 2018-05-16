package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.admin.InstitutionCreation;
import com.mastercard.pts.integrated.issuing.pages.customer.administration.InstitutionCreationPageNew;
import com.mastercard.pts.integrated.issuing.pages.customer.administration.LoginPage;
import com.mastercard.pts.integrated.issuing.pages.customer.processingcenter.InstitutionPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;

@Component
public class InstitutionCreationFlows extends AbstractBaseFlows {

	@Autowired
	public Navigator navigator;

	@Autowired
	InstitutionCreationPageNew institute;

	@Autowired
	LoginPage lgnPage;

	@Autowired
	private TestContext context;

	private static final String TAB_ADDRESS = "Address";

	public void institutionCreation(InstitutionCreation institutionCreation) {

		institute = navigator.navigateToPage(InstitutionCreationPageNew.class);
		institute.clickAddBtn();
		institute.provideInstitutionDetails(institutionCreation);
		institute.provideInstitutionType(institutionCreation);
		institute.provideGeneralDetails(institutionCreation);
		institute.provideAdaptiveAuthentication(institutionCreation);
		institute.provideCustomCareDetails(institutionCreation);
		institute.navigateToTab(TAB_ADDRESS);
		institute.providePersonalDetailsAdressTab(institutionCreation);
		institute.provideAddressDetails(institutionCreation);
		institute.save();
		waitForLoaderToDisappear();
		institute.checkErrorOnPage();		
	}

	public void checkSuccessfulInstitutionCreation(InstitutionCreation institutionCreation) {
		institute.verifyNewInstituteCreationSuccess(institutionCreation);
	}

	public void selectNewlyCreatedInstitutionFlows() {
		lgnPage.loginTo(MapUtils.fnGetInputDataFromMap("UserId"), MapUtils.fnGetInputDataFromMap("Password"));
		selectInstitute();
	}

	public boolean isAdaptiveAuthenticationEnabledAndUserAbleToSelectACSVendor() {
		InstitutionPage page = navigator.navigateToPage(InstitutionPage.class);
		InstitutionCreation institutioncreation = context.get("institutionData");
		page.enterInstitutionCode(institutioncreation);
		clickSearchButton();
		editFirstRecord();
		return page.checkASCVendorEnabledAndSelectASCVendor();
	}

	public void addCustomerCareIntlVIP(InstitutionCreation institutionCreation) {
		institute = navigator.navigateToPage(InstitutionCreationPageNew.class);
		institute.clickAddBtn();
		institute.provideInstitutionDetails(institutionCreation);
		institute.provideInstitutionType(institutionCreation);
		institute.provideGeneralDetails(institutionCreation);
		institute.provideCustomCareDetails(institutionCreation);
		institute.provideCustomerCareIntVIPno(institutionCreation);
		institute.navigateToTab(TAB_ADDRESS);
		institute.providePersonalDetailsAdressTab(institutionCreation);
		institute.provideAddressDetails(institutionCreation);
		institute.save();
	}

	public void updateCustomerCareIntlVIP(InstitutionCreation institutionCreation) {
		institute = navigator.navigateToPage(InstitutionCreationPageNew.class);
		institute.enterNewInstitution(institutionCreation);
		institute.updateCustomerCareIntlVIP(institutionCreation);
		institute.save();
	}

	public boolean validateCustomerCareIntlVIP(InstitutionCreation institutionCreation) {
		institute = navigator.navigateToPage(InstitutionCreationPageNew.class);
		institute.enterNewInstitution(institutionCreation);
		boolean status = institute.validateCustomerCareIntlVIP(institutionCreation);
		institute.cancel();
		return status;
	}

	public String verifyInstitiueUpdate() {
		return institute.getInstUpdateMessage();
	}

}
