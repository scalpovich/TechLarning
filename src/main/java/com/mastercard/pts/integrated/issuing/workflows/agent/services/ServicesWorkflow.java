package com.mastercard.pts.integrated.issuing.workflows.agent.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.agent.services.Checker;
import com.mastercard.pts.integrated.issuing.domain.agent.services.DeviceSale;
import com.mastercard.pts.integrated.issuing.pages.PageObjectFactory;
import com.mastercard.pts.integrated.issuing.pages.agent.services.ActivateDeactivateSubAccountPage;
import com.mastercard.pts.integrated.issuing.pages.agent.services.ApplicationCorrectionPage;
import com.mastercard.pts.integrated.issuing.pages.agent.services.ChangeCurrencyPriorityPage;
import com.mastercard.pts.integrated.issuing.pages.agent.services.CheckerPage;
import com.mastercard.pts.integrated.issuing.pages.agent.services.CurrencySetupPage;
import com.mastercard.pts.integrated.issuing.pages.agent.services.DedupeReverificationApprovalPage;
import com.mastercard.pts.integrated.issuing.pages.agent.services.DeviceSalePage;
import com.mastercard.pts.integrated.issuing.pages.agent.services.InstantDeviceReplacementPage;
import com.mastercard.pts.integrated.issuing.pages.agent.services.KYCUpdatePage;
import com.mastercard.pts.integrated.issuing.pages.agent.services.LimitedValidityVirtualCardCancellationPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class ServicesWorkflow {
	private DeviceSalePage dpage;
	private CheckerPage cpage;
	private ActivateDeactivateSubAccountPage adsapage;
	private ApplicationCorrectionPage acpage;
	private ChangeCurrencyPriorityPage ccppage;
	private CurrencySetupPage cspage;
	private DedupeReverificationApprovalPage drapage;
	private InstantDeviceReplacementPage idrpage;
	private KYCUpdatePage kycupage;
	private LimitedValidityVirtualCardCancellationPage lvvccpage;

	@Autowired
	private PageObjectFactory pageFactory;
	
	@Autowired
	private Navigator navigator;
	
	public void navigateToActivateDeactivateSubAccountPage() {
		adsapage = navigator.navigateToPage(ActivateDeactivateSubAccountPage.class);
	}

	public String getActivateDeactivateSubAccountMasterDetailContentTitleText() {
		return adsapage.getMasterDetailContentTitleText();
	}
	
	public void navigateToApplicationCorrectionPage() {
		acpage = navigator.navigateToPage(ApplicationCorrectionPage.class);
	}

	public String getApplicationCorrectionMasterDetailContentTitleText() {
		return acpage.getMasterDetailContentTitleText();
	}
	
	public void navigateToChangeCurrencyPriorityPage() {
		ccppage = navigator.navigateToPage(ChangeCurrencyPriorityPage.class);
	}

	public String getChangeCurrencyPriorityMasterDetailContentTitleText() {
		return ccppage.getMasterDetailContentTitleText();
	}
	
	public void navigateToCheckerPage() {
		cpage = navigator.navigateToPage(CheckerPage.class);
	}

	public String getCheckerMasterDetailContentTitleText() {
		return cpage.getMasterDetailContentTitleText();
	}
	
	public void navigateToCurrencySetupPage() {
		cspage = navigator.navigateToPage(CurrencySetupPage.class);
	}

	public String getCurrencySetupMasterDetailContentTitleText() {
		return cspage.getMasterDetailContentTitleText();
	}
	
	public void navigateToDedupeReverificationApprovalPage() {
		drapage = navigator.navigateToPage(DedupeReverificationApprovalPage.class);
	}

	public String getDedupeReverificationApprovalMasterDetailContentTitleText() {
		return drapage.getMasterDetailContentTitleText();
	}
	
	public void navigateToDeviceSalePage() {
		dpage = navigator.navigateToPage(DeviceSalePage.class);
	}

	public String getDeviceSaleMasterDetailContentTitleText() {
		return dpage.getMasterDetailContentTitleText();
	}
	
	public void navigateToInstantDeviceReplacementPage() {
		idrpage = navigator.navigateToPage(InstantDeviceReplacementPage.class);
	}

	public String getInstantDeviceReplacementMasterDetailContentTitleText() {
		return idrpage.getMasterDetailContentTitleText();
	}
	
	public void navigateToKYCUpdatePage() {
		kycupage = navigator.navigateToPage(KYCUpdatePage.class);
	}

	public String getKYCUpdateMasterDetailContentTitleText() {
		return kycupage.getMasterDetailContentTitleText();
	}
	
	public void navigateToLimitedValidityVirtualCardCancellationPage() {
		lvvccpage = navigator.navigateToPage(LimitedValidityVirtualCardCancellationPage.class);
	}

	public String getLimitedValidityVirtualCardCancellationMasterDetailContentTitleText() {
		return lvvccpage.getMasterDetailContentTitleText();
	}

	public void deviceSaleWithRegistration(DeviceSale deviceSale) {
		dpage = navigator.navigateToPage(DeviceSalePage.class);
		dpage.deviceSaleWithRegistration(deviceSale);
	}
	
	public void deviceSaleWithoutRegistration(DeviceSale deviceSale) {
		dpage = navigator.navigateToPage(DeviceSalePage.class);
		dpage.deviceSaleWithoutRegistration(deviceSale);
	}
	
	public void deviceSaleThroughCustomerRegistration(DeviceSale deviceSale) {
		dpage = navigator.navigateToPage(DeviceSalePage.class);
		dpage.deviceSaleThroughCustomerRegistration(deviceSale);
	}
	
	public void deviceSaleThroughNewProgram(DeviceSale deviceSale) {
		dpage = navigator.navigateToPage(DeviceSalePage.class);
		dpage.deviceSaleThroughNewProgram(deviceSale);
	}
	
	public String getActiveDeviceNumberFromDb(String productType, String deviceType) {
		dpage = pageFactory.getPage(DeviceSalePage.class);
		return dpage.getActiveDeviceNumberFromDb(productType,deviceType);
	}
	
	public String getApplicationCreatedMessage() {
		return dpage.getApplicationCreatedMessage();
	}
	
	public String getApplicationCreatedSuccessMessage() {
		return dpage.getApplicationCreatedSuccessMessage();
	}
	
	public void cardSaleChecker(Checker checker) {
		cpage = navigator.navigateToPage(CheckerPage.class);
		cpage.cardSaleChecker(checker);
	}
	
	public String getApprovalMessage() {
		return cpage.getApprovalMessage();
	}
}

