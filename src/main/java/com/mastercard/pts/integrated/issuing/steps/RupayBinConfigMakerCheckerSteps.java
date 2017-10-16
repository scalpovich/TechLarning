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

import com.mastercard.pts.integrated.issuing.pages.customer.administration.LoginPage;
import com.mastercard.pts.integrated.issuing.utils.ReadTestDataFromExcel;
import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;
import com.mastercard.pts.integrated.issuing.workflows.RupayBinSettlementFlows;

/**
 * @author E060549
 * 
 *
 */

@Component
public class RupayBinConfigMakerCheckerSteps extends AbstractBaseFlows {
	final Logger logger = LoggerFactory
			.getLogger(RupayBinConfigMakerCheckerSteps.class);
	@Autowired
	LoginPage loginpage;

	@Autowired
	private ReadTestDataFromExcel excelTestData;

	@Autowired
	private RupayBinSettlementFlows rupaybinsettlementflow;

	@Given(" customer portal user has access and privilege to configure")
	public void givenCustomerPortalUserHasAccessAndPrivilegeToConfigure(
			@Named("TCName") String strStoryName,
			@Named("sheetName") String strSheetName) {
		String f = null;
		excelTestData.fnReadEntireTestData(f, strSheetName, "TCName");

		if (excelTestData == null) {
			Assert.fail("Unable to read entire test data");
		} else {
			excelTestData.fnSetCurrentStoryTestData(strStoryName);
		}
		rupaybinsettlementflow.makerRupayBinSettlement();
	}

	@When("the customer portal user adds the record")
	public void whenTheCustomerPortalUserAddsTheRecord() {

	}

	@Then("audit for all the records added, amended or deleted should be maintained and also Maker Checker feature needs to be enabled for the screen.					 ")
	public void thenAuditForAllTheRecordsAddedAmendedOrDeletedShouldBeMaintainedAndAlsoMakerCheckerFeatureNeedsToBeEnabledForTheScreen() {

	}

	@Then("Audit for all the records edited should be maintained and also Maker Checker feature needs to be enabled for the screen.					 					 ")
	public void thenAuditForAllTheRecordsEditedShouldBeMaintainedAndAlsoMakerCheckerFeatureNeedsToBeEnabledForTheScreen() {
		// TODO
	}

	@When("the customer portal user edited the record")
	public void whenTheCustomerPortalUserEditedTheRecord() {
		rupaybinsettlementflow.editAtEndRupayBinSettlement();
		rupaybinsettlementflow.userWithBothPrivilege();
	}

	@Given(" a customer portal user has access and privilege to configure")
	public void givenCstomerPortalUserHasAccessAndPrivilegeToConfigure(
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

	@Then("Audit for all the records deleted should be maintained and also Maker Checker feature needs to be enabled for the screen")
	public void thenAuditForAllTheRecordsDeletedShouldBeMaintainedAndAlsoMakerCheckerFeatureNeedsToBeEnabledForTheScreen() {

	}

	@When("the customer portal user deletes the record")
	public void whenTheCustomerPortalUserDeletesTheRecord() {

	}

	@Given("Customer portal user has access and privilege to do configurations")
	public void givenCustomerPortalUserHasAccessAndPrivilegeToDoConfigurations(
			@Named("TCName") String strStoryName,
			@Named("sheetName") String strSheetName) {
		String f = null;
		excelTestData.fnReadEntireTestData(f, strSheetName, "TCName");
		if (excelTestData == null) {
			Assert.fail("Unable to read entire test data");
		} else {
			excelTestData.fnSetCurrentStoryTestData(strStoryName);
		}
		rupaybinsettlementflow.deleteRecordOnProduction();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return null;
	}
}