package com.mastercard.pts.integrated.issuing.workflows;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class DeviceCreationFlows extends MenuFlows {

	public void createNewPrepaidDevice() throws InterruptedException {
		// createCutOverProfile();
		// addNetworkMembership();
		// addtransactionRegistration();
		// ();
		// createOffice();
		// createPlasticCode();
		// addPictureCode();
		// addDeviceBIN();
		// addMCG();
		// addDedupePlan();
		// addStmntMessagePlan();// to be used only in case
		// of prepaid
		// addMktMessagePlan();// to be used only in case
		// of prepaid
		// addPrepaidStmntPlan();// to be used only in case
		// of prepaid
		// addTransactionPLan();
		// addTransactionLimitPLan();
		// addDocumentCheckList();
		// addBusinessManFields();
		// addDeviceTemplate();
		// createEmbossTemplate();
		// addVendor();
		// addDeviceJoining();
		// addDeviceBasedFeePlan();
		addDevicePlan();
		addWalletPlan();
		addProgram();
		addDeviceRange();

	}

	public void addWalletPlan() {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		CustomUtils.ThreadDotSleep(1000);
		clickMenuSubOption(menuSubMenuPage.getProgramSetup(), menuSubMenuPage.getWalletConfiguration());
		CustomUtils.ThreadDotSleep(1000);
		menuSubMenuPage.getWalletPlan().click();
		CustomUtils.ThreadDotSleep(2000);
		walletPlanPage.addwalletplan(MapUtils.fnGetInputDataFromMap("BaseCurrency"),
				MapUtils.fnGetInputDataFromMap("ProductType"), MapUtils.fnGetInputDataFromMap("ProgramType"),
				MapUtils.fnGetInputDataFromMap("WalletplanUsage"), MapUtils.fnGetInputDataFromMap("AccountNumber"));
	}

	public void addDeviceTemplate() {
		// When user creates DeviceCardPackTemplate
		clickMenuSubOption(menuSubMenuPage.getProgramSetup(), menuSubMenuPage.getDeviceConfiguration());
		CustomUtils.ThreadDotSleep(2000);
		menuSubMenuPage.getDeviceCardPackTemplate().click();
		CustomUtils.ThreadDotSleep(2000);
		deviceCardPackTemplatePage.addcardpackidtemplate();
		CustomUtils.ThreadDotSleep(2000);
		menuSubMenuPage.getDeviceCardPackTemplate().click();
		CustomUtils.ThreadDotSleep(2000);
		deviceCardPackTemplatePage.adddevicetemplate();

	}

	public void createEmbossTemplate() {
		// When user creates EmbossingTemplate
		clickMenuSubOption(menuSubMenuPage.getInstitutionParameterSetup(), menuSubMenuPage.getEmbossingParameters());
		embossingTemplatePage.addembossingtemplate(MapUtils.fnGetInputDataFromMap("Embosscode"),
				MapUtils.fnGetInputDataFromMap("EmbossDesc"), MapUtils.fnGetInputDataFromMap("EmbossFileType"),
				MapUtils.fnGetInputDataFromMap("sequenceNo"), MapUtils.fnGetInputDataFromMap("EmbossingField"),
				MapUtils.fnGetInputDataFromMap("EmbossTempField"), MapUtils.fnGetInputDataFromMap("Priority"));

	}

	public void addVendor() {
		// When user creates Vendor
		clickMenuSubOption(menuSubMenuPage.getInstitutionParameterSetup(), menuSubMenuPage.getVendor());
		vendorPage.addvendor(MapUtils.fnGetInputDataFromMap("VendorCode"), MapUtils.fnGetInputDataFromMap("VendorName"),
				MapUtils.fnGetInputDataFromMap("VendorCategory"),
				MapUtils.fnGetInputDataFromMap("embossingFileTempName"), MapUtils.fnGetInputDataFromMap("addressLine1"),
				MapUtils.fnGetInputDataFromMap("addressLine2"), MapUtils.fnGetInputDataFromMap("country"),
				MapUtils.fnGetInputDataFromMap("postalCode"), MapUtils.fnGetInputDataFromMap("contactPrsn"),
				MapUtils.fnGetInputDataFromMap("phnNumber"), MapUtils.fnGetInputDataFromMap("vendorMobileNo1"),
				MapUtils.fnGetInputDataFromMap("vendorMobileNo2"), MapUtils.fnGetInputDataFromMap("email"));

	}

	public void addDedupePlan() {
		// When user creates DedupePlan
		waitForElementVisible(menusubmenuPage.getCardManagement());
		clickMenuSubOption(menuSubMenuPage.getProgramSetup(), menuSubMenuPage.getDedupePlan());
		dedupePlanPage.adddedupeplan();

	}

	public void createOffice() {
		// When user creates Office
		clickMenuSubOption(menuSubMenuPage.getInstitutionParameterSetup(), menuSubMenuPage.getOffice());
		CustomUtils.ThreadDotSleep(4000);
		officePage.addofficezone();
		CustomUtils.ThreadDotSleep(6000);
		menuSubMenuPage.getOffice().click();
		CustomUtils.ThreadDotSleep(2000);
		officePage.addofficeregion();
		CustomUtils.ThreadDotSleep(5000);
		menuSubMenuPage.getOffice().click();
		CustomUtils.ThreadDotSleep(2000);
		officePage.addofficebranch();
		CustomUtils.ThreadDotSleep(2000);
	}

	public void createPlasticCode() {
		// When user creates PlasticCode
		clickMenuSubOption(menuSubMenuPage.getInstitutionParameterSetup(), menuSubMenuPage.getPlasticcode());
		CustomUtils.ThreadDotSleep(1000);
		plasticCodePage.addplasticcode();

	}

	public void addPictureCode() {
		// When user creates PictureCode
		CustomUtils.ThreadDotSleep(1000);
		clickMenuSubOption(menuSubMenuPage.getInstitutionParameterSetup(), menuSubMenuPage.getPicturecode());
		CustomUtils.ThreadDotSleep(1000);
		pictureCodePage.addpicturecode();

	}

	public String addDeviceBINPrepaid() {
		// When user creates DeviceBINForPrepaid
		waitForElementVisible(menusubmenuPage.getCardManagement());
		CustomUtils.ThreadDotSleep(2000);
		clickMenuSubOption(menuSubMenuPage.getInstitutionParameterSetup(), menuSubMenuPage.getDeviceBin());
		String deviceBIN = deviceBinPage.adddevicebinprepaid();
		CustomUtils.ThreadDotSleep(1000);
		return deviceBIN;
	}

	public void addMCG() {
		// When user creates MCG
		waitForElementVisible(menusubmenuPage.getCardManagement());
		CustomUtils.ThreadDotSleep(4000);
		clickMenuSubOption(menuSubMenuPage.getInstitutionParameterSetup(), menuSubMenuPage.getMCG());
		CustomUtils.ThreadDotSleep(1000);
		mCGPage.addmcg();
	}

	public void createCutOverProfile() throws InterruptedException {
		// creating a new cutover profile
		clickMenuSubOption(menuSubMenuPage.getInstitutionParameterSetup(), menuSubMenuPage.getCutoverProfile());
		cutoverProfilePage.addcutoverprofile();
	}

	public void addNetworkMembership() {
		// Adding network membership details
		clickMenuSubOption(menuSubMenuPage.getInstitutionParameterSetup(), menuSubMenuPage.getNetworkMembership());
		networkMembershipPage.addnetworkmembership(MapUtils.fnGetInputDataFromMap("InterchangeType"),
				MapUtils.fnGetInputDataFromMap("PresentTimeLimit"), MapUtils.fnGetInputDataFromMap("BaseCurrency"));

	}

	public void addtransactionRegistration() {
		// Adding transaction registration details
		clickMenuSubOption(menuSubMenuPage.getInstitutionParameterSetup(),
				menuSubMenuPage.getTransactionRegistration());
		transactionRegistrationPage.addtransactionregistration();
	}

	public void addInstitutionCurrency() {
		// Adding institution currency
		clickMenuSubOption(menuSubMenuPage.getInstitutionParameterSetup(), menuSubMenuPage.getInstitutionCurrency());
		institutionCurrencyPage.addInstitutionCurrency();

	}

	public void addNewDevice() {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		clickMenuSubOption(menuSubMenuPage.getActivity(), menuSubMenuPage.getDeviceMenu());
		menuSubMenuPage.getNewDevice().click();
		newDevicePage.createNewDevice(MapUtils.fnGetInputDataFromMap("ProductType"),
				MapUtils.fnGetInputDataFromMap("ApplicationType"), MapUtils.fnGetInputDataFromMap("ApplicationSubType"),
				MapUtils.fnGetInputDataFromMap("BatchType"), MapUtils.fnGetInputDataFromMap("CustomerType"),
				MapUtils.fnGetInputDataFromMap("Program"), MapUtils.fnGetInputDataFromMap("DeviceType"),
				MapUtils.fnGetInputDataFromMap("DevicePlan"), MapUtils.fnGetInputDataFromMap("Title"),
				MapUtils.fnGetInputDataFromMap("FirstName"), MapUtils.fnGetInputDataFromMap("LastName"),
				MapUtils.fnGetInputDataFromMap("Gender"), MapUtils.fnGetInputDataFromMap("Nationality"),
				MapUtils.fnGetInputDataFromMap("YearBirth"), MapUtils.fnGetInputDataFromMap("MaritalStatus"),
				MapUtils.fnGetInputDataFromMap("AccountNumber"), MapUtils.fnGetInputDataFromMap("AccountType"),
				MapUtils.fnGetInputDataFromMap("PreferredLang"), MapUtils.fnGetInputDataFromMap("AddressLine1"),
				MapUtils.fnGetInputDataFromMap("AddressLine2"), MapUtils.fnGetInputDataFromMap("AddressLine3"),
				MapUtils.fnGetInputDataFromMap("AddressLine4"), MapUtils.fnGetInputDataFromMap("Country"),
				MapUtils.fnGetInputDataFromMap("postalCode"));

	}

	public void addDeviceRange() {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		clickMenuSubOption(menuSubMenuPage.getProgramSetup(), menuSubMenuPage.getDeviceRange());
		deviceRangePage.adddevicerange(MapUtils.fnGetInputDataFromMap("ProductType"),
				MapUtils.fnGetInputDataFromMap("Program"), MapUtils.fnGetInputDataFromMap("FromDeviceNo"),
				MapUtils.fnGetInputDataFromMap("ToDeviceNo"), MapUtils.fnGetInputDataFromMap("StatusValue"),
				MapUtils.fnGetInputDataFromMap("DeviceType"), MapUtils.fnGetInputDataFromMap("Endpoint"));
	}

	public void addProgram() {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		clickMenuSubOption(menuSubMenuPage.getProgramSetup(), menuSubMenuPage.getProgram());
		programPage.addprogram(MapUtils.fnGetInputDataFromMap("ProgramCode"),
				MapUtils.fnGetInputDataFromMap("ProgramDesc"), MapUtils.fnGetInputDataFromMap("InterchangeType"),
				MapUtils.fnGetInputDataFromMap("ProductType"), MapUtils.fnGetInputDataFromMap("ProgramTypeProgram"),
				MapUtils.fnGetInputDataFromMap("BaseCurrency"), MapUtils.fnGetInputDataFromMap("CurrencyConversionBy"),
				MapUtils.fnGetInputDataFromMap("CalendarStartMonth"),
				MapUtils.fnGetInputDataFromMap("MaximumBalancewithoutKYC"),
				MapUtils.fnGetInputDataFromMap("LoadsWithoutKYC"),
				MapUtils.fnGetInputDataFromMap("DevicePlanForProgram"));
	}

	public void addWalletFeePlan() {
		clickMenuSubOption(menuSubMenuPage.getProgramSetup(), menuSubMenuPage.getWalletConfiguration());
		menuSubMenuPage.getWalletFeePlan().click();
		walletFeePlanPage.addwalletfeeplan(MapUtils.fnGetInputDataFromMap("ProductType"),
				MapUtils.fnGetInputDataFromMap("BaseCurrency"), MapUtils.fnGetInputDataFromMap("Fee"),
				MapUtils.fnGetInputDataFromMap("WaiveCycle"));
	}

	public void addDevicePlan() {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		clickMenuSubOption(menuSubMenuPage.getProgramSetup(), menuSubMenuPage.getDeviceConfiguration());
		devicePlanPage.adddeviceplan(MapUtils.fnGetInputDataFromMap("DevicePlanCodeText"),
				MapUtils.fnGetInputDataFromMap("DevicePlanDesc"), MapUtils.fnGetInputDataFromMap("CustomCode"),
				MapUtils.fnGetInputDataFromMap("DevicePlanAssociation"), MapUtils.fnGetInputDataFromMap("ProductType"),
				MapUtils.fnGetInputDataFromMap("DeviceType"), MapUtils.fnGetInputDataFromMap("ServiceCode"),
				MapUtils.fnGetInputDataFromMap("DeliveryMode"),
				MapUtils.fnGetInputDataFromMap("DeviceIdGenerationTemplate"),
				MapUtils.fnGetInputDataFromMap("EmbossingVendor"), MapUtils.fnGetInputDataFromMap("ExpiryFlag"),
				MapUtils.fnGetInputDataFromMap("ExpiryDate"), MapUtils.fnGetInputDataFromMap("PerTransactionLimit"),
				MapUtils.fnGetInputDataFromMap("TotalTransactionLimit"), MapUtils.fnGetInputDataFromMap("Velocity"),
				MapUtils.fnGetInputDataFromMap("Validity"));

	}

	public void addDeviceBasedFeePlan() {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		clickMenuSubOption(menuSubMenuPage.getProgramSetup(), menuSubMenuPage.getDeviceConfiguration());
		menuSubMenuPage.getDeviceEventBasedFeePlan().click();
		deviceEventBasedFeePlanPage.adddeviceeventbasedfeeplan(MapUtils.fnGetInputDataFromMap("ProductType"),
				MapUtils.fnGetInputDataFromMap("BaseCurrency"));
	}

	public void addDeviceJoining() {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		clickMenuSubOption(menuSubMenuPage.getProgramSetup(), menuSubMenuPage.getDeviceConfiguration());
		menuSubMenuPage.getDeviceJoining().click();
		deviceJoiningPage.adddevicejoining(MapUtils.fnGetInputDataFromMap("ProductType"),
				MapUtils.fnGetInputDataFromMap("BaseCurrency"));

	}

	public void addBusinessManFields() {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		clickMenuSubOption(menuSubMenuPage.getProgramSetup(), menuSubMenuPage.getProgramSetupApplication());
		menuSubMenuPage.getBusinessMandatoryFields().click();
		businessMandatoryFieldsPage.addbusinessmandatoryfields(MapUtils.fnGetInputDataFromMap("ProductType"));

	}

	public String addDeviceBIN() {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		clickMenuSubOption(menuSubMenuPage.getInstitutionParameterSetup(), menuSubMenuPage.getDeviceBin());
		String deviceBIN = deviceBinPage.adddevicebin(MapUtils.fnGetInputDataFromMap("InterchangeType"),
				MapUtils.fnGetInputDataFromMap("ProductType"), MapUtils.fnGetInputDataFromMap("BINType"),
				MapUtils.fnGetInputDataFromMap("Remark"));
		return deviceBIN;

	}

	public void addStmntMessagePlan() {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		clickMenuSubOption(menuSubMenuPage.getProgramSetup(), menuSubMenuPage.getStatementMessagePlan());
		statementMessagePlanPage.addstatementmessageplan(MapUtils.fnGetInputDataFromMap("ProductType"));
	}

	public void addMktMessagePlan() {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		clickMenuSubOption(menuSubMenuPage.getProgramSetup(), menuSubMenuPage.getMarketingMessagePlan());
		marketingMessagePlanPage.addmarketingplan(MapUtils.fnGetInputDataFromMap("ProductType"));
	}

	public void addTransactionPLan() {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		clickMenuSubOption(menuSubMenuPage.getProgramSetup(), menuSubMenuPage.getTransactionPlan());
		transactionPlanPage.addtransactionplan(MapUtils.fnGetInputDataFromMap("ProductType"));

	}

	public void addTransactionLimitPLan() {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		clickMenuSubOption(menuSubMenuPage.getProgramSetup(), menuSubMenuPage.getTransactionLimitPlan());
		transactionLimitPlanPage.addtransactionlimitplan(MapUtils.fnGetInputDataFromMap("ProductType"),
				MapUtils.fnGetInputDataFromMap("PlanType"), MapUtils.fnGetInputDataFromMap("FloorAmount"),
				MapUtils.fnGetInputDataFromMap("CeilingAmount"), MapUtils.fnGetInputDataFromMap("CalendarStartMonth"));

	}

	public void addDocumentCheckList() {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		clickMenuSubOption(menuSubMenuPage.getProgramSetup(), menuSubMenuPage.getProgramSetupApplication());
		menuSubMenuPage.getDocumentChecklist().click();
		documentChecklistPage.adddocumentchecklist(MapUtils.fnGetInputDataFromMap("ProductType"));

	}

}
