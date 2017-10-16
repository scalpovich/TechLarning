package com.mastercard.pts.integrated.issuing.steps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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

//import com.google.inject.name.Named;
import com.jcraft.jsch.JSchException;
import com.mastercard.pts.integrated.issuing.configuration.AppEnvironment;
import com.mastercard.pts.integrated.issuing.configuration.Portal;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.FileUtils;
import com.mastercard.pts.integrated.issuing.utils.ReadTestDataFromExcel;
import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;
import com.mastercard.pts.integrated.issuing.workflows.PrepaidDeviceFileEmbossingFlows;

/**
 * @author E060549
 * 
 *
 */

@Component
public class PrepaidDeviceEmbossingFileSteps extends AbstractBaseFlows {
	final Logger logger = LoggerFactory
			.getLogger(PrepaidDeviceEmbossingFileSteps.class);
	@Autowired
	PrepaidDeviceFileEmbossingFlows prepaidDeviceFileEmbossingFlows;

	@Autowired
	AppEnvironment appEnvironment;

	@Autowired
	private ReadTestDataFromExcel excelTestData;

	// @Given("user is logged in agent portal as $userType user")
	// public void givenUserIsLoggedInAgentPortal(String userType) {
	// Portal agentPortal =
	// appEnvironment.getPortalByType(Portal.TYPE_CUSTOMER);
	// login(agentPortal.getAdminUserName(), agentPortal.getPassword());
	// selectInstitute();
	// }

	@Given("login to existing bank as a $user")
	public void reloginforPrepaid(@Named("TCName") String strStoryName,
			@Named("sheetName") String strSheetName,
			@Named("user") String userType) {

		logger.info("Reading entire test data");
		String f = null;
		excelTestData.fnReadEntireTestData(f, strSheetName, "TCName");

		if (excelTestData == null) {
			Assert.fail("Unable to read entire test data");
		} else {
			excelTestData.fnSetCurrentStoryTestData(strStoryName);
		}
		Portal userPortal = appEnvironment
				.getPortalByType(Portal.TYPE_CUSTOMER);

		if ("admin".equalsIgnoreCase(userType)) {
			login(userPortal.getAdminUserName(), userPortal.getPassword());
		} else if ("user".equalsIgnoreCase(userType)) {
			login(userPortal.getUserName(), userPortal.getPassword());
		}

		selectInstitute();
	}

	@Given("login to existing bank as an existing user")
	public void login() {
		loginAsAdmin();
		selectInstitute();
	}

	@When("creates a new prepaid device")
	public void userCreatesNewPrepaidDevice() throws InterruptedException {
		prepaidDeviceFileEmbossingFlows.createNewprepaidDevice();
	}

	@When("user process the pre-production and device generation batch")
	public void processBatches() {
		prepaidDeviceFileEmbossingFlows.RunBulkDeviceGenBatch();
		prepaidDeviceFileEmbossingFlows.RunPreProductionBatch();
		prepaidDeviceFileEmbossingFlows.RunDeviceProductionBatch();
	}

	@Then("embossing file should be generated in specified location")
	public void checkEmbossedFileGenerated() {
		try {
			prepaidDeviceFileEmbossingFlows.copyFileFromRemoteToLocal();
		} catch (JSchException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Then("embossing file should be generated with the embossed parameters")
	public void verifyGeneratedEmbossedFile() throws FileNotFoundException {
		CustomUtils.ThreadDotSleep(50000);
		File fileName = FileUtils.getTheNewestFile(
				System.getProperty("user.dir") + "\\TempFiles", "DAT");
		// CustomUtils.verifyHeaderTrailerPattern(System.getProperty("user.dir")
		// + "\\TempFiles\\" + fileName);
		CustomUtils.verifyEmbossedFileRecord(System.getProperty("user.dir")
				+ "\\TempFiles\\" + fileName);
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {

		return null;
	}

}