package com.mastercard.pts.integrated.issuing.steps;

import java.util.Collection;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceBin;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.RuPaySettlementBIN;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.pages.customer.administration.LoginPage;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.ReadTestDataFromExcel;
import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;
import com.mastercard.pts.integrated.issuing.workflows.RupayBinSettlementFlows;

/**
 * @author E060549
 * 
 *
 */

@Component
public class RupayBinSettlementSteps extends AbstractBaseFlows {
	final Logger logger = LoggerFactory
			.getLogger(RupayBinSettlementSteps.class);
	@Autowired
	LoginPage loginpage;

	@Autowired
	private ReadTestDataFromExcel excelTestData;

	@Autowired
	private RupayBinSettlementFlows rupaybinsettlementflow;

	@Autowired
	private KeyValueProvider provider;

	private RuPaySettlementBIN ruPaySettlementBIN;

	@Autowired
	DeviceBin devicebin;

	@Then("user should be able to assign multiple settlement bin for a participant id")
	public void thenUserShouldBeAbleToAssignMultipleSettlementBinForAParticipantId() {

	}

	@Given("new menu option is available at institution level-rupay rettlement bin")
	public void newMenuOptionIsAvailableAtInstitutionLevelRupaySettlementBin(
			@Named("TCName") String strStoryName,
			@Named("sheetName") String strSheetName) {
		String f = null;
		excelTestData.fnReadEntireTestData(f, strSheetName, "TCName");

		if (excelTestData == null) {
			Assert.fail("Unable to read entire test data");
		} else {
			excelTestData.fnSetCurrentStoryTestData(strStoryName);
		}

	}

	@When("user tries to configure the settlement bin")
	public void whenUserTriesToConfigureTheSettlementBin() throws Throwable {
		rupaybinsettlementflow.setPrivileges();
		rupaybinsettlementflow.getIntoPrivileges();
		rupaybinsettlementflow.binConfigureWithSameParticipantId();

	}

	@Then("the user should be able to access the new screen")
	public void thenTheUserShouldBeAbleToAccessTheNewScreen() {

	}

	@When("the privileges are assigned to the user for this screen")
	public void whenThePrivilegesAreAssignedToTheUserForThisScreen() {
		rupaybinsettlementflow.setPrivileges();
		rupaybinsettlementflow.getIntoPrivileges();

	}

	@Given("that a new menu option should be available at Institution level-Rupay Settlement Bin")
	public void s(@Named("TCName") String strStoryName,
			@Named("sheetName") String strSheetName) {
		String f = null;
		excelTestData.fnReadEntireTestData(f, strSheetName, "TCName");

		if (excelTestData == null) {
			Assert.fail("Unable to read entire test data");
		} else {
			excelTestData.fnSetCurrentStoryTestData(strStoryName);
		}
		CustomUtils.ThreadDotSleep(1000);

	}

	@Then("the user should be able to access the new screen 			 ")
	public void theUserShouldBeAbleToAccessTheNewScreen() {
		rupaybinsettlementflow.binConfigurationWithUser();
	}

	@Then("the user should not be able to access the new screen")
	public void thenTheUserShouldNotBeAbleToAccessTheNewScreen() {
		rupaybinsettlementflow.binConfigurationWithUser();

	}

	@When("the privileges are not assigned to the user for this screen")
	public void whenThePrivilegesAreNotAssignedToTheUserForThisScreen() {
		rupaybinsettlementflow.removePrivileges();
	}

	@Then("user should be able to assign multiple settlement bin for a participant id					 ")
	public void userShouldBeAbleToAssignMultipleSettlementBinForAParticipantId()
			throws Throwable {

	}

	@Then("delete will be allowed without any constraint")
	public void thenDeleteWillBeAllowedWithoutAnyConstraint() {
		rupaybinsettlementflow.deleteSettlementBin();

	}

	@When("the user tries to configure the settlement bin")
	public void whenTheUserTriesToConfigureTheSettlementBin() throws Throwable {
		rupaybinsettlementflow.setPrivileges();
		rupaybinsettlementflow.getIntoPrivileges();
		rupaybinsettlementflow.configureSettlementBin();

	}

	@Given("that a new menu option is available at Institution level-Rupay Settlement Bin")
	public void givenThatANewMenuOptionIsAvailableAtInstitutionLevelRupaySettlementBin(
			@Named("TCName") String strStoryName,
			@Named("sheetName") String strSheetName) {

		String f = null;
		excelTestData.fnReadEntireTestData(f, strSheetName, "TCName");

		if (excelTestData == null) {
			Assert.fail("Unable to read entire test data");
		} else {
			excelTestData.fnSetCurrentStoryTestData(strStoryName);
		}
		CustomUtils.ThreadDotSleep(1000);
	}

	@Then("The values of product code should be configurable at system level")
	public void thenTheValuesOfProductCodeShouldBeConfigurableAtSystemLevel() {

	}

	@Then("Product code-Mandatory Field-Drop Down")
	public void thenProductCodeMandatoryFieldDropDown() {
		rupaybinsettlementflow.rupayProductCodeMandatory();
		rupaybinsettlementflow.participantIdMandatory();
	}

	@Then("user can assign one device bin to multiple product code")
	public void thenUserCanAssignOneDeviceBinToMultipleProductCode() {
		// TODO
	}

	@Then("the product pair of device vin can only be linked to one settlement bin it cannot be mapped to any other settlement bill")
	public void thenTheProductPairOfDeviceVinCanOnlyBeLinkedToOneSettlementBinItCannotBeMappedToAnyOtherSettlementBill() {
		// TODO
	}

	@Then("Participant Id-Mandatory Field-Length of the field is 11. It will be used for generating outgoing files to be staged to NPCI ")
	public void thenParticipantIdMandatoryFieldLengthOfTheFieldIs11ItWillBeUsedForGeneratingOutgoingFilesToBeStagedToNPCI() {

	}

	@Then("the user should be able to configure device bin Field and Length of the field is 6 digit")
	public void thenTheUserShouldBeAbleToConfigureDeviceBinFieldAndLengthOfTheFieldIs6Digit() {
		rupaybinsettlementflow.enterIntoRupaySettlementBin();
	}

	@Then("Product code-Mandatory Field-Drop Down with values of ProductCode as:|ProductCode||ATM01 Transaction originated from ATM||AEP01 Transaction originated from microATM||POS01 Transaction originated from POS/E-Commerce||IMP01 Transaction originated from Mobile/Internet Banking| And The values of product code should be configurable at system level")
	public void thenProductCodeMandatoryFieldDropDownWithValuesOfProductCodeAsProductCodeATM01TransactionOriginatedFromATMAEP01TransactionOriginatedFromMicroATMPOS01TransactionOriginatedFromPOSECommerceIMP01TransactionOriginatedFromMobileInternetBankingAndTheValuesOfProductCodeShouldBeConfigurableAtSystemLevel() {
		// TODO
	}

	@Then("Settlement bin is mandatory field for all Products and Length of the field will be 6 digit alphanumeric with no special characters allowed")
	public void thenSettlementBinIsMandatoryFieldForAllProductsAndLengthOfTheFieldWillBe6DigitAlphanumericWithNoSpecialCharactersAllowed() {
		rupaybinsettlementflow.settlementIdMandatory();
	}

	@When("user adds the RuPay Settlement BIN")
	public void addRuPaySettlementBIN() {
		ruPaySettlementBIN = RuPaySettlementBIN.createWithProvider(provider);
		rupaybinsettlementflow.addRuPaySettlementBINFlows(ruPaySettlementBIN,
				devicebin);
	}

	@Then("verify that the RuPay Settlement BIN is added into the system")
	public void verifyRuPaySettlementBINAdded() {
		rupaybinsettlementflow.verifyRuPayBINAdded(ruPaySettlementBIN);
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return null;
	}

}