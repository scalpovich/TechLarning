package com.mastercard.pts.integrated.issuing.steps;

import java.io.IOException;
import java.util.Collection;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.mastercard.pts.integrated.issuing.pages.customer.administration.LoginPage;
import com.mastercard.pts.integrated.issuing.utils.ReadTestDataFromExcel;
import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;
import com.mastercard.pts.integrated.issuing.workflows.DeviceCreationFlows;
import com.mastercard.pts.integrated.issuing.workflows.PrepaidDeviceFileEmbossingFlows;

@Component
public class EmbossingFileGenerationSteps extends AbstractBaseFlows {

	@Autowired
	LoginPage loginpage;

	@Autowired
	private ReadTestDataFromExcel excelTestData;

	@Autowired
	PrepaidDeviceFileEmbossingFlows prepaidDeviceFlows;

	@Autowired
	DeviceCreationFlows devicecreationFlows;

	@Given("Customer portal user has access to generate and execute embossing files")
	public void givenCustomerPortalUserHasAccessToGenerateAndExecuteEmbossingFiles(
			@Named("TCName") String strStoryName,
			@Named("sheetName") String strSheetName) {
		String f = null;
		excelTestData.fnReadEntireTestData(f, strSheetName, "TCName");

		if (excelTestData == null) {
			Assert.fail("Unable to read entire test data");
		} else {
			excelTestData.fnSetCurrentStoryTestData(strStoryName);
		}
		System.out.println("In the given");
	}

	@Then("embossing file generated for must be as per the configuration done defined in the embossing file template and must be encrypted")
	public void thenEmbosingFileGeneratedForMustBeAsPerTheConfigurationDoneDefinedInTheEmbossingFileTemplateAndMustBeEncrypted()
			throws JSchException, IOException, SftpException {
		prepaidDeviceFlows.readGPGEncryptedEmbossedFile();
	}

	@When("the customer portal user executes the batch for producing magnetic stripe device and encryption flag is enabled")
	public void whenTheCustomerPortalUserExecutesTheBatchForProducingMagneticStripeDeviceAndEncryptionFlagIsEnabled() {
	}

	@Given("Customer portal user has access to generate and execute embossing files  ")
	public void givenCstomerPortalUserHasAccessToGenerateAndExecuteEmbossingFiles() {

	}

	@When(" the customer portal user executes the batch for producing EMV device and encryption flag is enabled  ")
	public void whenTheCustomerPortalUserExecutesTheBatchForProducingEMVDeviceAndEncryptionFlagIsEnabled() {

	}

	@When("the encrytion flag is enabled")
	public void enableEncryption() {
		devicecreationFlows.enableEncryptionFlag();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return null;
	}
}