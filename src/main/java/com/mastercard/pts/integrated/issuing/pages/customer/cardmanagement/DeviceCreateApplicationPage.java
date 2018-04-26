package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Address;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ClientDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_ACTIVITY, CardManagementNav.L2_APPLICATION_DEVICE,
		CardManagementNav.L3_NEW_APPLCIATION })
public class DeviceCreateApplicationPage extends AbstractBasePage {
	@Autowired
	private TestContext context;
	
	
    private CreditLimitRulePage creditLimitRulePage;
    
	private static final Logger logger = LoggerFactory.getLogger(DeviceCreateApplicationPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:inputTextField")
	private MCWebElement deviceNumberSearchTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:productType:input:dropdowncomponent")
	private MCWebElement appliedForProdutDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:applicationType:input:dropdowncomponent")
	private MCWebElement applicationTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:applicationSubType:input:dropdowncomponent")
	private MCWebElement subApplicationTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:applicationBatch.displayStatusFlag:input:dropdowncomponent")
	private MCWebElement createOpenBatchDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Generate']")
	private MCWebElement generateDeviceBatchBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:customerType:input:dropdowncomponent")
	private MCWebElement customerTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:programCode:input:dropdowncomponent")
	private MCWebElement programCodeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:deviceType1:input:dropdowncomponent")
	private MCWebElement deviceType1DDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:devicePlanCode1:input:dropdowncomponent")
	private MCWebElement devicePlan1DDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:devicePhotoIndicator1:input:dropdowncomponent")
	private MCWebElement photoIndicatorDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:corporateClientCode:input:dropdowncomponent")
	private MCWebElement corporateClientCodeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:branchCode:input:dropdowncomponent")
	private MCWebElement branchCodeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:title:input:dropdowncomponent")
	private MCWebElement titleDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:firstName:input:inputCodeField")
	private MCWebElement firstNameTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:middleName1:input:inputCodeField")
	private MCWebElement middleName1Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:lastName:input:inputCodeField")
	private MCWebElement lastNameTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:gender:input:dropdowncomponent")
	private MCWebElement genderDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:nationality:input:dropdowncomponent")
	private MCWebElement nationalityDDwn;

	@PageElement(findBy = FindBy.ID, valueToFind = "birthDate")
	private MCWebElement birthDateDPkr;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:married:input:dropdowncomponent")
	private MCWebElement maritialStatusDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#crAccountNbr input")
	private MCWebElement accountNbrTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#accountType select")
	private MCWebElement accountTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:languagePreferences:input:dropdowncomponent")
	private MCWebElement languagePreferencesDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:registeredMailId:input:inputTextField")
	private MCWebElement registeredMailIdTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:currentAddressLine1:input:inputTextField")
	private MCWebElement currentAddressLine1Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:currentCountryCode:input:dropdowncomponent")
	private MCWebElement currentCountryCodeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:currentZipCode:input:inputTextField")
	private MCWebElement currentAddressPostalCode;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[.//*[text()='Batch Number:']]/following-sibling::td[1]//*[@class='labeltextf']")
	private MCWebElement batchNumberTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:vipFlag:input:dropdowncomponent")
	private MCWebElement vipDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "view:middleName2:input:inputCodeField")
	private MCWebElement middleName2Txt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "view:encodedName:input:inputCodeField")
	private MCWebElement encodedNameTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:faxNumber:input:inputTextField")
	private MCWebElement faxNumberTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "view:stmtHardCopyReq:input:dropdowncomponent")
	private MCWebElement statementPreferenceDDwn;
	@PageElement(findBy = FindBy.NAME, valueToFind = "view:creditLimit:input:inputAmountField")
	private MCWebElement creditLimitTxt;
	
	public void selectAppliedForProduct(String product) {
		WebElementUtils.selectDropDownByVisibleText(appliedForProdutDDwn, product);
	}

	public void verifyProgramAndDevicePlan(Device device) {
		clickAddNewButton();

		runWithinPopup("Add Device", () -> {
			fillDeviceInformation(device);
			fillBatchDetails(device);

			clickNextButton();
			WebElementUtils.selectDropDownByVisibleText(customerTypeDDwn, device.getCustomerType());

			List<String> programs = WebElementUtils.getOptionsTextFromSelect(programCodeDDwn);
			Assert.assertThat("Program is not available", programs, Matchers.hasItem(device.getProgramCode()));

			WebElementUtils.selectDropDownByVisibleText(programCodeDDwn, device.getProgramCode());

			clickNextButton();
			WebElementUtils.selectDropDownByVisibleText(deviceType1DDwn, device.getDeviceType1());

			List<String> devicePlans = WebElementUtils.getOptionsTextFromSelect(devicePlan1DDwn);
			Assert.assertThat("Device plan is not available", devicePlans, Matchers.hasItem(device.getDevicePlan1()));
		});
	}

	public void verifyUiOperationStatus() {
		logger.info("Device Create Device");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(deviceNumberSearchTxt));
	}

	public void createDevice(Device device) {
		logger.info("Add Device for program: {}", device.getProgramCode());
		clickAddNewButton();

		runWithinPopup("Add Application", () -> {
			fillDeviceInformation(device);
			fillBatchDetails(device);
			fillCustomerTypeProgramCodeAndDeviceDetails(device);

			clickNextButton();

			fillProfileAndAddressDetailsAndClickNext(device);
			// skip wallet extra fields
				clickFinishButton();

				verifyNoErrors();
			});

		verifyOperationStatus();

		//scolling "PageUp" is needed here as the Menu item is not visible
		SimulatorUtilities sm = new SimulatorUtilities();
		sm.pressPageUp();
		
		device.setClientCode(getCodeFromInfoMessage("client"));
		device.setWalletNumber(getCodeFromInfoMessage("wallet"));
		device.setDeviceNumber(getCodeFromInfoMessage("device(s)"));
	}
	public boolean createDeviceNewApplication(Device device) {
		logger.info("Add Device for program: {}", device.getProgramCode());
		Boolean applicationNumber=false;
		clickAddNewButton();

		runWithinPopup("Add Application", () -> {
			fillDeviceInformation(device);
			fillBatchDetails(device);
			fillCustomerTypeProgramCodeAndDeviceDetails(device);

			clickNextButton();

			fillProfileAndAddressDetailsAndClickNext(device);

			// skip wallet extra fields
				clickFinishButton();

				verifyNoErrors();
			});

		verifyOperationStatus();
		if (device.getAppliedForProduct().equalsIgnoreCase(ProductType.CREDIT)) {
			device.setApplicationNumber(getCodeFromInfoMessage("Application Number"));
			logger.info("Application: {}",device.getApplicationNumber());
		}
		else
		{
		device.setClientCode(getCodeFromInfoMessage("client"));
		device.setWalletNumber(getCodeFromInfoMessage("wallet"));
		device.setDeviceNumber(getCodeFromInfoMessage("device(s)"));
		device.setApplicationNumber(getCodeFromInfoMessage("Application Number"));
		logger.info("clientCode: {}",device.getClientCode());
		logger.info("WalletNumber: {}",device.getWalletNumber());
		logger.info("DeviceNumber: {}",device.getDeviceNumber());
		logger.info("Application: {}",device.getApplicationNumber());
		}
        if(device.getApplicationNumber()!=null && !device.getApplicationNumber().isEmpty())
        {
        	applicationNumber=true;
        }
		//scolling "PageUp" is needed here as the Menu item is not visible
        return applicationNumber;
		
	}

	private void fillBatchDetails(Device device) {
		WebElementUtils.selectDropDownByVisibleText(createOpenBatchDDwn, device.getCreateOpenBatch());
		clickWhenClickable(generateDeviceBatchBtn);
		waitForWicket();
		// fetching batch number and setting it for further use
		device.setBatchNumber(batchNumberTxt.getText());
		context.put(ContextConstants.DEVICE,device);
		logger.info(" *********** Batch number *********** " + device.getBatchNumber());
		clickNextButton();
	}

	private void fillDeviceInformation(Device device) {
		WebElementUtils.selectDropDownByVisibleText(appliedForProdutDDwn, device.getAppliedForProduct());
		WebElementUtils.selectDropDownByVisibleText(applicationTypeDDwn, device.getApplicationType());
		WebElementUtils.selectDropDownByVisibleText(subApplicationTypeDDwn, device.getSubApplicationType());
		clickNextButton();
	}

	private void fillCustomerTypeProgramCodeAndDeviceDetails(Device device) {
		WebElementUtils.selectDropDownByVisibleText(customerTypeDDwn, device.getCustomerType());
		WebElementUtils.selectDropDownByVisibleText(programCodeDDwn, device.getProgramCode());
		clickNextButton();

		WebElementUtils.selectDropDownByVisibleText(deviceType1DDwn, device.getDeviceType1());
		WebElementUtils.selectDropDownByVisibleText(devicePlan1DDwn, device.getDevicePlan1());
		WebElementUtils.selectDropDownByVisibleText(photoIndicatorDDwn, device.getPhotoIndicator());
	}

	private void fillProfileAndAddressDetailsAndClickNext(Device device) {

		fillProfile(device);
		
		clickNextButton();

		fillAddress(device);
		
			// skip employment details
			clickNextButton();
			// Bank Details applicable only for Credit type product
			clickNextButton();
			// Nomination Details applicable only for Credit type product
			clickNextButton();
			// skip client extra fields
			clickNextButton();
			// skip device extra fields
			clickNextButton();
			clickNextButton();
	}

	private void fillAddress(Device device) {
		Address currentAddress = device.getCurrentAddress();
		WebElementUtils.enterText(currentAddressLine1Txt, currentAddress.getAddressLine1());
		WebElementUtils.selectDropDownByVisibleText(currentCountryCodeDDwn, currentAddress.getCountry());
		WebElementUtils.enterText(currentAddressPostalCode, currentAddress.getPostalCode());

		try {
			Thread.sleep(5000); // added some sleep as the page does not repond after adding zip code
		} catch (InterruptedException e) {
			logger.error("Error" + e);
			Thread.currentThread().interrupt();
		}
		pageScrollDown();
		clickNextButton();
	}

	private void fillProfile(Device device) {
		Program program=context.get(ContextConstants.PROGRAM);
		if (corporateClientCodeDDwn.isEnabled())
			 WebElementUtils.selectDropDownByVisibleText(branchCodeDDwn, device.getBranchCode());
			WebElementUtils.selectDropDownByVisibleText(corporateClientCodeDDwn, device.getCorporateClientCode());
		ClientDetails client = device.getClientDetails();
		WebElementUtils.selectDropDownByVisibleText(titleDDwn, client.getTitle());
		WebElementUtils.enterText(firstNameTxt, client.getFirstName());
		if (client.getMiddleName1() != null) {
			WebElementUtils.enterText(middleName1Txt, client.getMiddleName1());
		}
		WebElementUtils.enterText(lastNameTxt, client.getLastName());
		WebElementUtils.enterText(middleName2Txt, device.getMiddleName2());
		WebElementUtils.enterText(encodedNameTxt, device.getEncodedName());
		WebElementUtils.selectDropDownByVisibleText(genderDDwn, client.getGender());
		WebElementUtils.selectDropDownByVisibleText(nationalityDDwn, client.getNationality());
		WebElementUtils.pickDate(birthDateDPkr, client.getBirthDate());
		WebElementUtils.selectDropDownByVisibleText(maritialStatusDDwn, client.getMaritialStatus());
		if (device.getAppliedForProduct().equalsIgnoreCase(ProductType.DEBIT)) {
			WebElementUtils.enterText(accountNbrTxt, device.getAccountNumber());
			WebElementUtils.selectDropDownByVisibleText(accountTypeDDwn, device.getAccountType());
		}
		WebElementUtils.enterText(registeredMailIdTxt, client.getEmailId());
		WebElementUtils.selectDropDownByVisibleText(languagePreferencesDDwn, client.getLanguagePreference());
		WebElementUtils.selectDropDownByVisibleText(vipDDwn, device.getVip());
		WebElementUtils.selectDropDownByIndex(statementPreferenceDDwn,1);
		if (device.getAppliedForProduct().equalsIgnoreCase(ProductType.CREDIT)) {
		WebElementUtils.enterText(creditLimitTxt,String.valueOf(Integer.parseInt(program.getCreditLimit())+1));
		//WebElementUtils.enterText(faxNumberTxt, device.getOtherInfoFaxNo());
		}
		clickNextButton();
	}
}
