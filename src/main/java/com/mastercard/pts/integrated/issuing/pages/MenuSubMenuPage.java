package com.mastercard.pts.integrated.issuing.pages;

import java.util.Collection;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class MenuSubMenuPage extends AbstractBasePage {

	@Autowired
	protected Environment env;

	final Logger homePageLogger = LoggerFactory.getLogger(this.getClass());

	// -------------
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div[1]/div[3]/span[2]/a[2]")
	private MCWebElement logout;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div/div[3]/div[1]/div[2]/form/div[2]/a")
	private MCWebElement login;

	// ------------- For 'Processing Center' Login
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[3]/div[2]/ul/div[2]/li/a/span[contains(text(),'Processing Center')]")
	private MCWebElement processingCenter;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[3]/div[3]/ul/li[1]")
	private MCWebElement setup;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@id='issuingLinkContainer']/li/a")
	private MCWebElement CardManagementMenu;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[3]/div[3]/ul/li[1]/ul/li[2]")
	private MCWebElement masterParameters;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@id='CESM02']/a")
	private MCWebElement Network;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[3]/div[3]/ul/li/ul/li[2]/ul/li[1]/a")
	private MCWebElement institution;

	// ------------- For 'Card Management' Login

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[contains(text(),'Card Management')]")
	private MCWebElement CardManagement;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//span[.='Administration']")
	private MCWebElement Administration;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//li[contains(.,'Setup')]")
	private MCWebElement AdministrationSetup;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[contains(.,'Enable Maker Checker')]/a")
	private MCWebElement EnableMakerChecker;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ADS002']/a")
	private MCWebElement User;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//ul/li[contains(.,'Institution Parameter Setup')]")
	private MCWebElement institutionParameterSetup;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[contains(.,'RuPay Settlement BIN')]/a")
	private MCWebElement RupaySettlementBin;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@id='ISS000']")
	private MCWebElement programSetup;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@id='ISA000']")
	private MCWebElement Activity;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@id='ISO000']")
	private MCWebElement Operation;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[3]/div[3]/ul/li[3]")
	private MCWebElement ActivityMenu;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[3]/div[3]/ul/li[3]/ul/li[3]")
	private MCWebElement DeviceMenu;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[3]/div[3]/ul/li[1]/ul/li[3]/a")
	private MCWebElement cutoverProfile;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISSC00']")
	private MCWebElement ProgramSetupApplication;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISAP00']")
	private MCWebElement ActivityApplication;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISAP0N']")
	private MCWebElement NewApplication;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISSAP0C']")
	private MCWebElement CreditSubMenu;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISSAP0V']/a")
	private MCWebElement VerifyorReject;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISSAP0A']/a")
	private MCWebElement ApproveorReject;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISOC01']")
	private MCWebElement OperationApplication;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISOCRD']")
	private MCWebElement CreditSubMenuOperation;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISOACC']/a")
	private MCWebElement CloseBatch;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISOCPG']/a")
	private MCWebElement DeviceGeneration;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISOPB0']")
	private MCWebElement ProcessingBatches;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='PREPRD01']/a")
	private MCWebElement PreProductionBatch;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='DEVPRD01']/a")
	private MCWebElement DeviceProduction;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='BLKDRQ01']/a")
	private MCWebElement BulkDeviceRequest;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='BLKDGN01']/a")
	private MCWebElement BulkDeviceGeneration;

	// ------------- Card Management > Institution Parameter Setup > Business
	// Calendar [ISSS01]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISSS01']/a")
	private MCWebElement businessCalendar;

	// ------------- Card Management > Institution Parameter Setup > Holiday
	// Configuration [ISSS02]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISSS02']/a")
	private MCWebElement HolidayConfiguration;

	// ------------- Card Management > Institution Parameter Setup > Cutover
	// Profile [ISSS03]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISSS03']/a")
	private MCWebElement CutoverProfile;

	// ------------- Card Management > Institution Parameter Setup > Network
	// Membership [ISSS04]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISSS04']/a")
	private MCWebElement NetworkMembership;

	// ------------- Card Management > Institution Parameter Setup > Network
	// Membership [ISSS04]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISSS25']/a")
	private MCWebElement TransactionRegistration;

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISSS05']/a")
	private MCWebElement InstitutionCurrency;

	// ------------- Card Management > Institution Parameter Setup > Office
	// [ISSS06]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISSS06']/a")
	private MCWebElement Office;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISSS07']/a")
	private MCWebElement Plasticcode;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISSS08']/a")
	private MCWebElement Picturecode;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISSS09']/a")
	private MCWebElement DeviceBin;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISSS10']/a")
	private MCWebElement DeviceStatus;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISSS11']/a")
	private MCWebElement StoplistReason;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISSS12']/a")
	private MCWebElement AccountType;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISSE01']/a")
	private MCWebElement MasterDerivationKeys;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISSE02']/a")
	private MCWebElement IssuerPublicKey;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISSH01']/a")
	private MCWebElement HSMDeviceKeys;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISSH02']/a")
	private MCWebElement HSMNetworkKeys;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISS022']/a")
	private MCWebElement MCG;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISS020']/a")
	private MCWebElement SurchargePlan;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISSM00']")
	private MCWebElement EmbossingParameters;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[contains(text(), 'Vendor')]")
	private MCWebElement Vendor;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='DDPLN001']/a")
	private MCWebElement DedupePlan;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='MRKFP001']/a")
	private MCWebElement MarkupFeePlan;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='STMSG001']/a")
	private MCWebElement StatementMessagePlan;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='MKMSG001']/a")
	private MCWebElement MarketingMessagePlan;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='STPLN001']/a")
	private MCWebElement PrepaidMessagePlan;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='TXP001']/a")
	private MCWebElement TransactionPlan;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='TXLP001']/a")
	private MCWebElement TransactionLimitPlan;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISAP00']")
	private MCWebElement Application;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[contains(text(), 'Document Checklist')]")
	private MCWebElement DocumentChecklist;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[contains(text(), 'Business Mandatory Fields')]")
	private MCWebElement BusinessMandatoryFields;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISSD00']")
	private MCWebElement DeviceConfiguration;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[contains(text(), 'Device Joining')]")
	private MCWebElement DeviceJoining;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='IS0005']/a")
	private MCWebElement DeviceEventBasedFeePlan;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISSD01']/a")
	private MCWebElement MCCRules;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISS001']/a")
	private MCWebElement DeviceCardPackTemplate;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISW003']/a")
	private MCWebElement TransactionFeePlan;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISW009']/a")
	private MCWebElement DevicePlan;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISW013']/a")
	private MCWebElement EmbossingTemplate;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISSW00']")
	private MCWebElement WalletConfiguration;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='WLFEP001']/a")
	private MCWebElement WalletFeePlan;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='WALLP001']/a")
	private MCWebElement WalletPlan;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISSB00']")
	private MCWebElement CreditCardBilling;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISSBB0']/a")
	private MCWebElement BillingCycle;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISSBPP']/a")
	private MCWebElement PaymentPriority;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISSBPB']/a")
	private MCWebElement PaymentBounceReason;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISSBTR']/a")
	private MCWebElement TransactionRulePlan;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISSBCP']/a")
	private MCWebElement CreditPlan;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='PRMG001']/a")
	private MCWebElement Program;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='DVRNG001']/a")
	private MCWebElement DeviceRange;

	// ------------- Card Management > Institution Parameter Setup > Plastic
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISS024']/a")
	private MCWebElement EmbossingPriorityPass;

	// ------------- Card Management > Activity > Device
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISAD0N']/a")
	private MCWebElement NewDevice;

	// ------------- Card Management > Institution Parameter Setup > Host
	// Accounting [ISSHA2]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISSHA01']")
	private MCWebElement hostAccounting;

	// ------------- Card Management > Institution Parameter Setup
	// Account Head [ISSHA1]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISSHA1']/a")
	private MCWebElement accountHead;

	// Account Master
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISSHA2']/a")
	private MCWebElement accountMaster;

	// ------------- Card Management > Institution Parameter Setup
	// Account Head Mapping [ISSHA3]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISSHA3']/a")
	private MCWebElement accountHeadMapping;

	// ------------- Card Management > Operation > process
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='BATPRO01']/a")
	private MCWebElement processBatch;

	// ------------- Card Management > Reports >
	// Code [ISSS07]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISRE00']")
	private MCWebElement cardMngmntReport;

	// ------------- Card Management > Reports > Compliance report
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISRCO1']/a")
	private MCWebElement complianceReport;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//li/a[contains(.,'Batch Definition')]")
	private MCWebElement BatchDefinations;

	// ------------- Card Management > Institution Parameter Setup >
	// EMV
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISSE00']")
	private MCWebElement EMV;

	// ------------- Loyalty tab
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[contains(text(),'Loyalty')]")
	private MCWebElement Loyalty;

	// ------------- Card Management > Reports > Compliance report
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='LOS000']/a")
	private MCWebElement loyaltySetup;

	// ------------- Card Management > Activity
	// Rupay Member fund collection [CARPMFCD]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='CARPMFCD']/a")
	private MCWebElement rupayMemberFundCollection;

	// ------------- Card Management > Activity
	// Rupay Member fund collection [CARPMFCD]
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISAR00']")
	private MCWebElement activityRupay;

	public MCWebElement getCardMngmntReport() {
		return cardMngmntReport;
	}

	public void setCardMngmntReport(MCWebElement cardMngmntReport) {
		this.cardMngmntReport = cardMngmntReport;
	}

	public MCWebElement getComplianceReport() {
		return complianceReport;
	}

	public void setComplianceReport(MCWebElement complianceReport) {
		this.complianceReport = complianceReport;
	}

	public void setCardManagementMenu(MCWebElement cardManagementMenu) {
		CardManagementMenu = cardManagementMenu;
	}

	public void setInstitutionLoadCurrency(MCWebElement institutionLoadCurrency) {
		this.institutionLoadCurrency = institutionLoadCurrency;
	}

	public MCWebElement getRupayMemberFudCollection() {
		return rupayMemberFundCollection;
	}

	public MCWebElement getActivityRupay() {
		return activityRupay;
	}

	public MCWebElement getAccountHead() {
		return accountHead;
	}

	public MCWebElement getAccountHeadMapping() {
		return accountHeadMapping;
	}

	public MCWebElement getHostAccounting() {
		return hostAccounting;
	}

	public MCWebElement getAccountMaster() {
		return accountMaster;
	}

	public void logoutFromApplication() {
		logout.click();
		login.click();
	}

	public Environment getEnv() {
		return env;
	}

	public void setEnv(Environment env) {
		this.env = env;
	}

	public MCWebElement getProcessingCenter() {
		return processingCenter;
	}

	public void setProcessingCenter(MCWebElement processingCenter) {
		this.processingCenter = processingCenter;
	}

	public MCWebElement getSetup() {
		return setup;
	}

	public void setSetup(MCWebElement setup) {
		this.setup = setup;
	}

	public MCWebElement getMasterParameters() {
		return masterParameters;
	}

	public void setMasterParameters(MCWebElement masterParameters) {
		this.masterParameters = masterParameters;
	}

	public MCWebElement getInstitution() {
		return institution;
	}

	public void setInstitution(MCWebElement institution) {
		this.institution = institution;
	}

	public MCWebElement getCardManagement() {
		return CardManagement;
	}

	public void setCardManagement(MCWebElement cardManagement) {
		CardManagement = cardManagement;
	}

	public MCWebElement getAdministration() {
		return Administration;
	}

	public void setAdministration(MCWebElement administration) {
		Administration = administration;
	}

	public MCWebElement getUser() {
		return User;
	}

	public void setUser(MCWebElement user) {
		User = user;
	}

	public MCWebElement getInstitutionParameterSetup() {
		return institutionParameterSetup;
	}

	public void setInstitutionParameterSetup(
			MCWebElement institutionParameterSetup) {
		this.institutionParameterSetup = institutionParameterSetup;
	}

	public MCWebElement getAdministrationSetup() {
		return AdministrationSetup;
	}

	public void setAdministrationSetup(MCWebElement administrationSetup) {
		AdministrationSetup = administrationSetup;
	}

	public MCWebElement getProgramSetup() {
		return programSetup;
	}

	public void setProgramSetup(MCWebElement programSetup) {
		this.programSetup = programSetup;
	}

	public MCWebElement getActivity() {
		return Activity;
	}

	public void setActivity(MCWebElement activity) {
		Activity = activity;
	}

	public MCWebElement getDeviceMenu() {
		return DeviceMenu;
	}

	public void setDeviceMenu(MCWebElement deviceMenu) {
		DeviceMenu = deviceMenu;
	}

	public MCWebElement getBusinessCalendar() {
		return businessCalendar;
	}

	public void setBusinessCalendar(MCWebElement businessCalendar) {
		this.businessCalendar = businessCalendar;
	}

	public MCWebElement getHolidayConfiguration() {
		return HolidayConfiguration;
	}

	public void setHolidayConfiguration(MCWebElement holidayConfiguration) {
		HolidayConfiguration = holidayConfiguration;
	}

	public MCWebElement getCutoverProfile() {
		return CutoverProfile;
	}

	public void setCutoverProfile(MCWebElement cutoverProfile) {
		CutoverProfile = cutoverProfile;
	}

	public MCWebElement getNetworkMembership() {
		return NetworkMembership;
	}

	public MCWebElement getRupaySettlementBin() {
		return RupaySettlementBin;
	}

	public void setNetworkMembership(MCWebElement networkMembership) {
		NetworkMembership = networkMembership;
	}

	public MCWebElement getTransactionRegistration() {
		return TransactionRegistration;
	}

	public void setTransactionRegistration(MCWebElement transactionRegistration) {
		TransactionRegistration = transactionRegistration;
	}

	public MCWebElement getInstitutionCurrency() {
		return InstitutionCurrency;
	}

	public void setInstitutionCurrency(MCWebElement institutionCurrency) {
		InstitutionCurrency = institutionCurrency;
	}

	public MCWebElement getOffice() {
		return Office;
	}

	public void setOffice(MCWebElement office) {
		Office = office;
	}

	public MCWebElement getPlasticcode() {
		return Plasticcode;
	}

	public void setPlasticcode(MCWebElement plasticcode) {
		Plasticcode = plasticcode;
	}

	public MCWebElement getPicturecode() {
		return Picturecode;
	}

	public void setPicturecode(MCWebElement picturecode) {
		Picturecode = picturecode;
	}

	public MCWebElement getDeviceBin() {
		return DeviceBin;
	}

	public void setDeviceBin(MCWebElement deviceBin) {
		DeviceBin = deviceBin;
	}

	public MCWebElement getDeviceStatus() {
		return DeviceStatus;
	}

	public void setDeviceStatus(MCWebElement deviceStatus) {
		DeviceStatus = deviceStatus;
	}

	public MCWebElement getStoplistReason() {
		return StoplistReason;
	}

	public void setStoplistReason(MCWebElement stoplistReason) {
		StoplistReason = stoplistReason;
	}

	public MCWebElement getAccountType() {
		return AccountType;
	}

	public MCWebElement getCardManagementMenu() {
		return CardManagementMenu;
	}

	public void setAccountType(MCWebElement accountType) {
		AccountType = accountType;
	}

	public MCWebElement getMasterDerivationKeys() {
		return MasterDerivationKeys;
	}

	public void setMasterDerivationKeys(MCWebElement masterDerivationKeys) {
		MasterDerivationKeys = masterDerivationKeys;
	}

	public MCWebElement getEnableMakerChecker() {
		return EnableMakerChecker;
	}

	public MCWebElement getIssuerPublicKey() {
		return IssuerPublicKey;
	}

	public void setIssuerPublicKey(MCWebElement issuerPublicKey) {
		IssuerPublicKey = issuerPublicKey;
	}

	public MCWebElement getHSMDeviceKeys() {
		return HSMDeviceKeys;
	}

	public void setHSMDeviceKeys(MCWebElement hSMDeviceKeys) {
		HSMDeviceKeys = hSMDeviceKeys;
	}

	public MCWebElement getHSMNetworkKeys() {
		return HSMNetworkKeys;
	}

	public void setHSMNetworkKeys(MCWebElement hSMNetworkKeys) {
		HSMNetworkKeys = hSMNetworkKeys;
	}

	public MCWebElement getMCG() {
		return MCG;
	}

	public void setMCG(MCWebElement mCG) {
		MCG = mCG;
	}

	public MCWebElement getSurchargePlan() {
		return SurchargePlan;
	}

	public void setSurchargePlan(MCWebElement surchargePlan) {
		SurchargePlan = surchargePlan;
	}

	public MCWebElement getLogout() {
		return logout;
	}

	public void setLogout(MCWebElement logout) {
		this.logout = logout;
	}

	public MCWebElement getLogin() {
		return login;
	}

	public void setLogin(MCWebElement login) {
		this.login = login;
	}

	public MCWebElement getVendor() {
		return Vendor;
	}

	public void setVendor(MCWebElement vendor) {
		Vendor = vendor;
	}

	public MCWebElement getDedupePlan() {
		return DedupePlan;
	}

	public void setDedupePlan(MCWebElement dedupePlan) {
		DedupePlan = dedupePlan;
	}

	public MCWebElement getMarkupFeePlan() {
		return MarkupFeePlan;
	}

	public void setMarkupFeePlan(MCWebElement markupFeePlan) {
		MarkupFeePlan = markupFeePlan;
	}

	public MCWebElement getStatementMessagePlan() {
		return StatementMessagePlan;
	}

	public void setStatementMessagePlan(MCWebElement statementMessagePlan) {
		StatementMessagePlan = statementMessagePlan;
	}

	public MCWebElement getMarketingMessagePlan() {
		return MarketingMessagePlan;
	}

	public void setMarketingMessagePlan(MCWebElement marketingMessagePlan) {
		MarketingMessagePlan = marketingMessagePlan;
	}

	public MCWebElement getPrepaidMessagePlan() {
		return PrepaidMessagePlan;
	}

	public void setPrepaidMessagePlan(MCWebElement prepaidMessagePlan) {
		PrepaidMessagePlan = prepaidMessagePlan;
	}

	public MCWebElement getTransactionPlan() {
		return TransactionPlan;
	}

	public void setTransactionPlan(MCWebElement transactionPlan) {
		TransactionPlan = transactionPlan;
	}

	public MCWebElement getTransactionLimitPlan() {
		return TransactionLimitPlan;
	}

	public void setTransactionLimitPlan(MCWebElement transactionLimitPlan) {
		TransactionLimitPlan = transactionLimitPlan;
	}

	public MCWebElement getApplication() {
		return Application;
	}

	public void setApplication(MCWebElement application) {
		Application = application;
	}

	public MCWebElement getDocumentChecklist() {
		return DocumentChecklist;
	}

	public void setDocumentChecklist(MCWebElement documentChecklist) {
		DocumentChecklist = documentChecklist;
	}

	public MCWebElement getBusinessMandatoryFields() {
		return BusinessMandatoryFields;
	}

	public void setBusinessMandatoryFields(MCWebElement businessMandatoryFields) {
		BusinessMandatoryFields = businessMandatoryFields;
	}

	public MCWebElement getDeviceJoining() {
		return DeviceJoining;
	}

	public void setDeviceJoining(MCWebElement deviceJoining) {
		DeviceJoining = deviceJoining;
	}

	public MCWebElement getDeviceConfiguration() {
		return DeviceConfiguration;
	}

	public void setDeviceConfiguration(MCWebElement deviceConfiguration) {
		DeviceConfiguration = deviceConfiguration;
	}

	public MCWebElement getDeviceEventBasedFeePlan() {
		return DeviceEventBasedFeePlan;
	}

	public void setDeviceEventBasedFeePlan(MCWebElement deviceEventBasedFeePlan) {
		DeviceEventBasedFeePlan = deviceEventBasedFeePlan;
	}

	public MCWebElement getMCCRules() {
		return MCCRules;
	}

	public void setMCCRules(MCWebElement mCCRules) {
		MCCRules = mCCRules;
	}

	public MCWebElement getDeviceCardPackTemplate() {
		return DeviceCardPackTemplate;
	}

	public void setDeviceCardPackTemplate(MCWebElement deviceCardPackTemplate) {
		DeviceCardPackTemplate = deviceCardPackTemplate;
	}

	public MCWebElement getTransactionFeePlan() {
		return TransactionFeePlan;
	}

	public void setTransactionFeePlan(MCWebElement transactionFeePlan) {
		TransactionFeePlan = transactionFeePlan;
	}

	public MCWebElement getDevicePlan() {
		return DevicePlan;
	}

	public void setDevicePlan(MCWebElement devicePlan) {
		DevicePlan = devicePlan;
	}

	public MCWebElement getEmbossingParameters() {
		return EmbossingParameters;
	}

	public void setEmbossingParameters(MCWebElement embossingParameters) {
		EmbossingParameters = embossingParameters;
	}

	public MCWebElement getEmbossingTemplate() {
		return EmbossingTemplate;
	}

	public void setEmbossingTemplate(MCWebElement embossingTemplate) {
		EmbossingTemplate = embossingTemplate;
	}

	public MCWebElement getWalletConfiguration() {
		return WalletConfiguration;
	}

	public void setWalletConfiguration(MCWebElement walletConfiguration) {
		WalletConfiguration = walletConfiguration;
	}

	public MCWebElement getWalletFeePlan() {
		return WalletFeePlan;
	}

	public void setWalletFeePlan(MCWebElement walletFeePlan) {
		WalletFeePlan = walletFeePlan;
	}

	public MCWebElement getWalletPlan() {
		return WalletPlan;
	}

	public void setWalletPlan(MCWebElement walletPlan) {
		WalletPlan = walletPlan;
	}

	public MCWebElement getCreditCardBilling() {
		return CreditCardBilling;
	}

	public void setCreditCardBilling(MCWebElement creditCardBilling) {
		CreditCardBilling = creditCardBilling;
	}

	public MCWebElement getBillingCycle() {
		return BillingCycle;
	}

	public void setBillingCycle(MCWebElement billingCycle) {
		BillingCycle = billingCycle;
	}

	public MCWebElement getPaymentPriority() {
		return PaymentPriority;
	}

	public void setPaymentPriority(MCWebElement paymentPriority) {
		PaymentPriority = paymentPriority;
	}

	public MCWebElement getPaymentBounceReason() {
		return PaymentBounceReason;
	}

	public void setPaymentBounceReason(MCWebElement paymentBounceReason) {
		PaymentBounceReason = paymentBounceReason;
	}

	public MCWebElement getTransactionRulePlan() {
		return TransactionRulePlan;
	}

	public void setTransactionRulePlan(MCWebElement transactionRulePlan) {
		TransactionRulePlan = transactionRulePlan;
	}

	public MCWebElement getCreditPlan() {
		return CreditPlan;
	}

	public void setCreditPlan(MCWebElement creditPlan) {
		CreditPlan = creditPlan;
	}

	public MCWebElement getProgram() {
		return Program;
	}

	public void setProgram(MCWebElement program) {
		Program = program;
	}

	public MCWebElement getDeviceRange() {
		return DeviceRange;
	}

	public void setDeviceRange(MCWebElement deviceRange) {
		DeviceRange = deviceRange;
	}

	public MCWebElement getEmbossingPriorityPass() {
		return EmbossingPriorityPass;
	}

	public void setEmbossingPriorityPass(MCWebElement embossingPriorityPass) {
		EmbossingPriorityPass = embossingPriorityPass;
	}

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISSS27']/a")
	private MCWebElement institutionLoadCurrency;

	public MCWebElement getProgramSetupApplication() {
		return ProgramSetupApplication;
	}

	public void setProgramSetupApplication(MCWebElement programSetupApplication) {
		ProgramSetupApplication = programSetupApplication;
	}

	public MCWebElement getActivityApplication() {
		return ActivityApplication;
	}

	public void setActivityApplication(MCWebElement activityApplication) {
		ActivityApplication = activityApplication;
	}

	public MCWebElement getNewApplication() {
		return NewApplication;
	}

	public void setNewApplication(MCWebElement newApplication) {
		NewApplication = newApplication;
	}

	public MCWebElement getCreditSubMenu() {
		return CreditSubMenu;
	}

	public void setCreditSubMenu(MCWebElement creditSubMenu) {
		CreditSubMenu = creditSubMenu;
	}

	public MCWebElement getVerifyorReject() {
		return VerifyorReject;
	}

	public void setVerifyorReject(MCWebElement verifyorReject) {
		VerifyorReject = verifyorReject;
	}

	public MCWebElement getApproveorReject() {
		return ApproveorReject;
	}

	public void setApproveorReject(MCWebElement approveorReject) {
		ApproveorReject = approveorReject;
	}

	public MCWebElement getOperation() {
		return Operation;
	}

	public void setOperation(MCWebElement operation) {
		Operation = operation;
	}

	public MCWebElement getOperationApplication() {
		return OperationApplication;
	}

	public void setOperationApplication(MCWebElement operationApplication) {
		OperationApplication = operationApplication;
	}

	public MCWebElement getCreditSubMenuOperation() {
		return CreditSubMenuOperation;
	}

	public void setCreditSubMenuOperation(MCWebElement creditSubMenuOperation) {
		CreditSubMenuOperation = creditSubMenuOperation;
	}

	public MCWebElement getCloseBatch() {
		return CloseBatch;
	}

	public void setCloseBatch(MCWebElement closeBatch) {
		CloseBatch = closeBatch;
	}

	public MCWebElement getDeviceGeneration() {
		return DeviceGeneration;
	}

	public void setDeviceGeneration(MCWebElement deviceGeneration) {
		DeviceGeneration = deviceGeneration;
	}

	public MCWebElement getProcessingBatches() {
		return ProcessingBatches;
	}

	public void setProcessingBatches(MCWebElement processingBatches) {
		ProcessingBatches = processingBatches;
	}

	public MCWebElement getPreProductionBatch() {
		return PreProductionBatch;
	}

	public void setPreProductionBatch(MCWebElement preProductionBatch) {
		PreProductionBatch = preProductionBatch;
	}

	public MCWebElement getDeviceProduction() {
		return DeviceProduction;
	}

	public void setDeviceProduction(MCWebElement deviceProduction) {
		DeviceProduction = deviceProduction;
	}

	public MCWebElement getBulkDeviceRequest() {
		return BulkDeviceRequest;
	}

	public void setBulkDeviceRequest(MCWebElement bulkDeviceRequest) {
		BulkDeviceRequest = bulkDeviceRequest;
	}

	public MCWebElement getBulkDeviceGeneration() {
		return BulkDeviceGeneration;
	}

	public void setBulkDeviceGeneration(MCWebElement bulkDeviceGeneration) {
		BulkDeviceGeneration = bulkDeviceGeneration;
	}

	public MCWebElement getNewDevice() {
		return NewDevice;
	}

	public MCWebElement getNetwork() {
		return Network;
	}

	public org.slf4j.Logger getHomePageLogger() {
		return homePageLogger;
	}

	public MCWebElement getBatchDefination() {
		return BatchDefinations;
	}

	public void clickMenuSubOption(MCWebElement option, MCWebElement suboption) {
		getCardManagement().click();
		CustomUtils.ThreadDotSleep(3000);
		option.click();
		CustomUtils.ThreadDotSleep(3000);
		suboption.click();
		CustomUtils.ThreadDotSleep(3000);

	}

	public void clickSubOptionProcessingCenter(MCWebElement option,
			MCWebElement suboption) {
		getProcessingCenter().click();
		CustomUtils.ThreadDotSleep(3000);
		option.click();
		CustomUtils.ThreadDotSleep(3000);
		suboption.click();
		CustomUtils.ThreadDotSleep(3000);

	}

	public MCWebElement getInstitutionLoadCurrency() {
		return institutionLoadCurrency;
	}

	public MCWebElement getProcessBatch() {
		return processBatch;
	}

	public void setProcessBatch(MCWebElement processBatch) {
		this.processBatch = processBatch;
	}

	public MCWebElement getEMV() {
		return EMV;
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}
