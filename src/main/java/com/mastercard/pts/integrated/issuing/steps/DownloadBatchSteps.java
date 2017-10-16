//@author : E052391

package com.mastercard.pts.integrated.issuing.steps;

import java.io.IOException;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.BatchProcessFlows;

@Component
public class DownloadBatchSteps {

	@Autowired
	private BatchProcessFlows batchProcessingFlows;
	
	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	
	@When("user generates $file batch file for $prodtype product type and $exttype extract type")
	public void createFileForApplicationUpload(@Named("file") String batchName,
			@Named("prodtype") String productType,
			@Named("exttype") String extType){	
		 batchProcessingFlows.processCustomerMasterDownloadBatch(batchName, productType, extType);
	}
	
	@When("user downloads $file batch file for transactiontype for $prodtype product type")
	public void downloadTxnType(@Named("file") String batchName,
			@Named("prodtype") String productType){
		batchProcessingFlows.processTxnTypeMasterBatch(batchName, productType);
	}
	
	@When("user downloads $file batch file for employeemaster for $entitytype entity type and $exttype extract type")
	public void downloadEmpMaster(@Named("file") String batchName,
			@Named("entitytype") String entityType, 
			@Named("exttype") String extType)
	{
		batchProcessingFlows.processEmpMasterUserBatch(batchName, entityType, extType);
	}
	
	@Then("the filename will be validated in $batchname batch for each record in file")
	public void readFilenameFromCsv(@Named("txn_type_master_download") String batchName) throws IOException
	{
		batchProcessingFlows.readAndValidateFilename(batchName);
	}
	
}
