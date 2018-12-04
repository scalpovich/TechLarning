package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.nio.file.Path;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.configuration.LinuxBox;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ProcessBatches;
import com.mastercard.pts.integrated.issuing.domain.provider.CSVDataLoader;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DumpWorkflow;

@Component
public class DumpSteps {

	@Autowired
	private TestContext context;

	@Autowired
	private Navigator navigator;

	@Autowired
	private DumpWorkflow dumpWorkflow;

	@Autowired
	private KeyValueProvider provider;

	@Autowired
	private LinuxBox linuxBox;

	@Autowired
	private Path tempDirectory;
	
	@Autowired
	private CSVDataLoader csvDataLoader;

	@When("$batchType download batch is executed for  $cardType user")
	public void whenbatchtypeDownloadBatchIsExecutedForcardtypeUser(String batchType, String cardType) {

		ProcessBatches batch = new ProcessBatches();
		batch.setBatchName(batchType);
		batch.setProductType(ProductType.fromShortName(cardType));
		batch.setInterchangeType(provider.getString("INTERCHANGE_TYPE"));
		batch.setExtractType(provider.getString("EXTRACT_TYPE"));
		context.put("type", cardType);
		context.put("batch", batch);
		dumpWorkflow.executeDownLoadProcessBatch(batch);
	}

	@Then("$fileType file is successfully downloaded $folder")
	public void thenfileTypeFileIsSuccessfullyDownloadedfolder(String fileType, String folderName) {
		String partialFileName = dumpWorkflow.createFilePathToLinuxBox(fileType, provider.getString("INSTITUTION_CODE"), context.get("batch"));
		File batchFile = linuxBox.downloadFileThroughSCPByPartialFileName(partialFileName, tempDirectory.toString(), folderName,"proc");
		assertNotNull(partialFileName + " : Batch file is successfully downloaded", batchFile);
	}
	
	@When("using application position number $applicationNumberPosition user compares mandatory field with a position $mandatoryFieldPositionNumber in downloaded file")
	@Then("using application position number $applicationNumberPosition user compares mandatory field with a position $mandatoryFieldPositionNumber in downloaded file")
	public void userComparesMandatoryValue(int applicationNumberPosition, int mandatoryFieldPositionNumber) {
		Assert.assertTrue("Field Value is not Present in Downloaded CSV File ", csvDataLoader.compareValueFromCSV(applicationNumberPosition, mandatoryFieldPositionNumber));
	}

}