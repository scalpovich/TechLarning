package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BusinessCalendar;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CutoverProfile;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceBin;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.EmbossingPinAndPriorityPassFileNameParameter;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.EmbossingPinPriorityPassFileTemplate;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.HolidayConfiguration;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.InstitutionCurrency;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.IssuerPublicKey;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.NetworkMembership;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Office;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PictureCode;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PlasticCode;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Vendor;
import com.mastercard.pts.integrated.issuing.domain.customer.processingcenter.Institution;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.BusinessCalendarPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.CutoverProfilePage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceBinPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.EmbossingPINAndPriorityPassFileNameParameterPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.EmbossingPINAndPriorityPassFileTemplatePage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.HolidayConfigurationPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.InstitutionCurrencyPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.IssuerPublicKeyIPKCertificateInformationPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.NetworkMembershipPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.OfficePage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.PictureCodePage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.PlasticCodePage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.TransactionRegistrationPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.VendorsPage;
import com.mastercard.pts.integrated.issuing.pages.customer.processingcenter.InstitutionPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class InstitutionCreationWorkflow {

	@Autowired
	private Navigator navigator;

	public void createBusinessCalendar(BusinessCalendar bc) {
		BusinessCalendarPage page = navigator.navigateToPage(BusinessCalendarPage.class);
		page.addBusinessCalendar(bc);
	}

	public void createFutureBusinessCalendar(BusinessCalendar bc) {
		BusinessCalendarPage page = navigator.navigateToPage(BusinessCalendarPage.class);
		page.addBusinessCalendarFutureDate(bc);
	}
	
	public void createHolidayConfiguration(HolidayConfiguration hc) {
		HolidayConfigurationPage page = navigator.navigateToPage(HolidayConfigurationPage.class);
		page.addHolidayConfiguration(hc);
	}
	
	public void createCutOverProfile(CutoverProfile cp) {
		CutoverProfilePage page = navigator.navigateToPage(CutoverProfilePage.class);
		page.addCutoverProfile(cp);
	}
	
	public void createNetworkMembership(List<NetworkMembership> nmList) {
		NetworkMembershipPage page = navigator.navigateToPage(NetworkMembershipPage.class);
		page.addNewNetworkMembership(nmList);
	}
	
	public void createInstitutionCurrency(InstitutionCurrency currency) {
		InstitutionCurrencyPage page = navigator.navigateToPage(InstitutionCurrencyPage.class);
		page.addInstitutionCurrency(currency);
	}
	
	public void createOffice(List<Office> officeList) {
		OfficePage page = navigator.navigateToPage(OfficePage.class);
		page.addOffice(officeList);
	}
	
	public void createPlasticCode(PlasticCode plasticCode) {
		PlasticCodePage page = navigator.navigateToPage(PlasticCodePage.class);
		page.addPictureCode(plasticCode);
	}
	
	public void createPictureCode(PictureCode pictureCode) {
		PictureCodePage page = navigator.navigateToPage(PictureCodePage.class);
		page.addPictureCode(pictureCode);
	}
	
	public void createDeviceBin(List<DeviceBin> deviceBinList) {
		DeviceBinPage page = navigator.navigateToPage(DeviceBinPage.class);
		page.addDeviceBin(deviceBinList);
	}
	
	public void createIpk(List<IssuerPublicKey> ipkList) {
		IssuerPublicKeyIPKCertificateInformationPage page = navigator.navigateToPage(IssuerPublicKeyIPKCertificateInformationPage.class);
		page.addIPKCertificate(ipkList);
	}
	
	public void  addEmbossingPinPriorityPassFileNames(List<EmbossingPinAndPriorityPassFileNameParameter> data){
		EmbossingPINAndPriorityPassFileNameParameterPage page = navigator.navigateToPage(EmbossingPINAndPriorityPassFileNameParameterPage.class);
		for(EmbossingPinAndPriorityPassFileNameParameter emb :data )
		{
		page. embossingPINAndPriorityPassFileNameParameter(emb);
		}
	}
	
	
	public void  addVendorMasters(List<Vendor> data){
		VendorsPage page = navigator.navigateToPage(VendorsPage.class);
		for(Vendor vendor :data )
		{
			page.addVendorMaster(vendor);
		}
	}
	
	public void registerTransactions()
	{
		TransactionRegistrationPage page = navigator.navigateToPage(TransactionRegistrationPage.class);
		page.enableTransactionRegistrations();
	}
	
	public void embossingPinPriorityPassFileTemplate(List<EmbossingPinPriorityPassFileTemplate> dataProvider)
	{
		EmbossingPINAndPriorityPassFileTemplatePage page = navigator.navigateToPage(EmbossingPINAndPriorityPassFileTemplatePage.class);
		for(EmbossingPinPriorityPassFileTemplate   fileTemplate : dataProvider)
		{
			
			page.addEmbossingPinPriorityPassFileTemplates(fileTemplate);
		}
	}
	
	public void createNewInstitute(Institution inst)
	{
		InstitutionPage page = navigator.navigateToPage(InstitutionPage.class);
		page.createInstitute(inst);
	}
	
	public boolean isInstituteNotPresent(Institution inst)
	{
		InstitutionPage page = navigator.navigateToPage(InstitutionPage.class);
		return page.isInstitutionNotPresent(inst);
	}
	
}
