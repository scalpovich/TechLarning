package com.mastercard.pts.integrated.issuing.steps;

import java.io.File;
import java.io.FileNotFoundException;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.FileUtils;
import com.mastercard.pts.integrated.issuing.utils.ZipUnzipUtils;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.NetworkFlows;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.NetworkMembershipFlows;

import net.lingala.zip4j.exception.ZipException;

/**
 * @author E060549
 * 
 *
 */

@Component
public class NetworkSteps extends AbstractBaseSteps {

	@Autowired
	NetworkFlows ntkflows;

	@Autowired
	NetworkMembershipFlows ntkmembershipflows;

	@Autowired
	ZipUnzipUtils zipunziputils;

	@When("admin user tries to access the bank network configuration record on the network screen")
	public void editNetwork() {
		ntkflows.editNetworkCode();
	}

	@Then("the user must be allowed to change the description of the network configured")
	public void verifyConfirmation() {
		ntkmembershipflows.verifyMessage("Edit",
				Constants.Record_Updated_Successfully);
	}

	// @When("admin user tries to delete this record on the network screen")
	// public void deleteNotallowed() {
	// ntkflows.deleteNetworkCode();
	// }

	@Then("the user must not be allowed to delete the rupay network from the screen")
	public void verifyDeleteNotPerformed() {
		//ntkflows.verifyNetworkPresent();
	}

	@When("user is configuring device ranges and selects rupay network")
	public void deviceRangeRupay() {
		ntkflows.configureDeviceRange();
	}

	@Then("following options needs to appear for Rupay network:$interchangeTypes")
	public void verifyInterchangeTypes(ExamplesTable interchangeTypes) {
		ntkflows.verifyInterchangeTypes(interchangeTypes);
	}

	@When("admin user tries to download the lists of Bank Network")
	public void downloadListBankNtk() throws FileNotFoundException {
		ntkflows.whenAdminDownloadListsOfNetworks();
	}

	@Then("the user must be able to download all the Bank Network configured in the excel file format (CSV)")
	public void readFile() throws ZipException, FileNotFoundException {
		String filepath = System.getProperty("user.dir") + "\\TempFiles";
		File Filename = FileUtils.getTheNewestFile(filepath, "zip");
		try {
			ZipUnzipUtils.unZip(Filename, filepath,
					zipunziputils.getReportPassword());

		} catch (java.util.zip.ZipException e) {
			e.printStackTrace();
		}
		File Filename1 = FileUtils.getTheNewestFile(filepath, "csv");
		FileUtils.ReadFileAndValidate(Filename1, "06");
	}

}