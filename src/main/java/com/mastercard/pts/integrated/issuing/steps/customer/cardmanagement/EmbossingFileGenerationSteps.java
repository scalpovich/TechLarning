package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import java.io.IOException;
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

import com.jcraft.jsch.JSchException;
import com.mastercard.pts.integrated.issuing.domain.provider.DataLoader;
import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;
import com.mastercard.pts.integrated.issuing.workflows.PrepaidDeviceFileEmbossingFlows;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DeviceCreationFlows;

@Component
public class EmbossingFileGenerationSteps extends AbstractBaseFlows {

	@Autowired
	@Qualifier("defaultDataLoader")
	public DataLoader dataLoader;

	@Autowired
	PrepaidDeviceFileEmbossingFlows prepaidDeviceFlows;

	@Autowired
	DeviceCreationFlows devicecreationFlows;

	@Given("Customer portal user has access to generate and execute embossing files")
	public void givenCustomerPortalUserHasAccessToGenerateAndExecuteEmbossingFiles(
			@Named("TCName") String tcName,
			@Named("sheetName") String sheetName) {
		dataLoader.updateTestContextWithTestData(sheetName, tcName);
	}

	@Then("embossing file generated for must be as per the configuration done defined in the embossing file template and must be encrypted")
	public void thenEmbosingFileGeneratedForMustBeAsPerTheConfigurationDoneDefinedInTheEmbossingFileTemplateAndMustBeEncrypted()
			throws JSchException, IOException {
		prepaidDeviceFlows.readGPGEncryptedEmbossedFile();
	}

	@When("the encrytion flag is enabled")
	public void enableEncryption() {
		devicecreationFlows.enableEncryptionFlag();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Collections.emptyList();
	}
}