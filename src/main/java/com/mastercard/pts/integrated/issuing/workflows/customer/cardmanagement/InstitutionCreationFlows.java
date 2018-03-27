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

	InstitutionCreationPageNew institute;

	@Autowired
	LoginPage lgnPage;

	@Autowired
	private TestContext context;

	public void institutionCreation(InstitutionCreation institutionCreation) {

		institute = navigator.navigateToPage(InstitutionCreationPageNew.class);
		institute.clickAddBtn();
		institute.provideInstitutionDetails(institutionCreation);
		institute.provideInstitutionType(institutionCreation);
		institute.provideGeneralDetails(institutionCreation);
		institute.provideAdaptiveAuthentication();
		institute.provideCustomCareDetails(institutionCreation);
		institute.navigateToTab("Address");
		institute.providePersonalDetailsAdressTab(institutionCreation);
		institute.provideAddressDetails(institutionCreation);
		institute.save();
		waitForLoaderToDisappear();
	}

	public void checkSuccessfullInstitutionCreation(InstitutionCreation institutionCreation) {
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

}
