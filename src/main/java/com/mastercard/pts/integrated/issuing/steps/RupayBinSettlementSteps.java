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

	@Then("Product code-Mandatory Field-Drop Down")
	public void thenProductCodeMandatoryFieldDropDown() {
		rupaybinsettlementflow.rupayProductCodeMandatory();
		rupaybinsettlementflow.participantIdMandatory();
	}

	@Then("the user should be able to configure device bin Field and Length of the field is 6 digit")
	public void thenTheUserShouldBeAbleToConfigureDeviceBinFieldAndLengthOfTheFieldIs6Digit() {
		rupaybinsettlementflow.enterIntoRupaySettlementBin();
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