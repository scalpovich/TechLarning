package com.mastercard.pts.integrated.issuing.steps;

import java.io.File;
import java.io.FileNotFoundException;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.FileUtils;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DeviceCreationFlows;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.NetworkFlows;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.NetworkMembershipFlows;

//import junit.

/**
 * @author E060549
 * 
 *
 */

@Component
public class RupayBankNetworkConfigSteps extends AbstractBaseSteps {

	@Autowired
	NetworkMembershipFlows networkflows;

	@Autowired
	DeviceCreationFlows deviceflows;

	@Autowired
	Environment env;

	@Autowired
	NetworkFlows ntkflows;

	@When("necessary network is added")
	public void verifyNetworkPresent() {
		networkflows.verfifyNtkMembership();
	}

	@When("user tries to access this record on the network membership configuration screen")
	public void addRupayNetwork() {
		// deviceflows.addNetworkMembership();
	}

	@When("user tries to edit this record on the network membership configuration screen")
	public void editRupayNetwork() {
		networkflows.editNtkMembership();
	}

	@Then("he must be allowed to add the rupay network from the screen")
	public void verifyAddSuccessMessage() {
		networkflows.verifyMessage("Add", Constants.Record_Added_Successfully);
	}

	@Then("he must be allowed to edit the rupay network from the screen")
	public void verifyEditSuccessMessage() {
		networkflows.verifyMessage("Edit", Constants.Record_Updated_Successfully);
	}

	@When("user tries to delete this record on the network membership configuration screen")
	public void deleteNtkMemebership() {
		networkflows.deleteNtkMembership();
	}

	@Then("he must be allowed to delete the already added  rupay network from the screen in case there are no programs and transactions configured for that network")
	public void verifyErrorMessage() {
		networkflows.verifyErrorMessage();
	}

	@When("user tries to download the lists of Bank Network")
	public void whenUserDownloadListsofNetworks() {
		try {
			networkflows.downloadList();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Then("the user must be able to download all the network configured in the excel file format (CSV)")
	public void readNtkCodeFromCsv() throws FileNotFoundException {
		String filepath = System.getProperty("user.dir") + "\\TempFiles";
		File Filename = FileUtils.getTheNewestFile(filepath, "csv");
		FileUtils.ReadFileAndValidate(Filename, "06");
	}
}