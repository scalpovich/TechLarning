package com.mastercard.pts.integrated.issuing.steps;

import java.util.Collection;
import java.util.Collections;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceBin;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.RuPaySettlementBIN;
import com.mastercard.pts.integrated.issuing.domain.provider.DataLoader;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;
import com.mastercard.pts.integrated.issuing.workflows.RupayBinSettlementFlows;

/**
 * @author E060549
 * 
 *
 */

@Component
public class RupayBinSettlementSteps extends AbstractBaseFlows {

	@Autowired
	@Qualifier("defaultDataLoader")
	private DataLoader dataLoader;

	@Autowired
	private RupayBinSettlementFlows rupaybinsettlementflow;

	@Autowired
	private KeyValueProvider provider;

	private RuPaySettlementBIN ruPaySettlementBIN;

	@Autowired
	DeviceBin devicebin;

	@Given("new menu option is available at institution level-rupay rettlement bin")
	public void newMenuOptionIsAvailableAtInstitutionLevelRupaySettlementBin(
			@Named("TCName") String tcName,
			@Named("sheetName") String sheetName) {
		dataLoader.updateTestContextWithTestData(sheetName, tcName);


	}

	@When("user tries to configure the settlement bin")
	public void whenUserTriesToConfigureTheSettlementBin() {
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
	public void s(@Named("TCName") String tcName,
			@Named("sheetName") String sheetName) {
		dataLoader.updateTestContextWithTestData(sheetName, tcName);

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
	public void whenTheUserTriesToConfigureTheSettlementBin() {
		rupaybinsettlementflow.setPrivileges();
		rupaybinsettlementflow.getIntoPrivileges();
		rupaybinsettlementflow.configureSettlementBin();

	}

	@Given("that a new menu option is available at Institution level-Rupay Settlement Bin")
	public void givenThatANewMenuOptionIsAvailableAtInstitutionLevelRupaySettlementBin(
			@Named("TCName") String tcName,
			@Named("sheetName") String sheetName) {

		dataLoader.updateTestContextWithTestData(sheetName, tcName);

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
		return Collections.emptyList();
	}

}