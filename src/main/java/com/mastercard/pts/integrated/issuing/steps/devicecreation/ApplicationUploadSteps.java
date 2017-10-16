package com.mastercard.pts.integrated.issuing.steps.devicecreation;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ProcessBatches;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.SearchApplicationDetails;
import com.mastercard.pts.integrated.issuing.utils.FileCreation;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.BatchProcessFlows;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.SearchApplicationDetailsFlows;

@Component
public class ApplicationUploadSteps {
	
	@Autowired
	private FileCreation fileCreation;
	
	@Autowired
	private ProcessBatches processBatch;
	
	@Autowired
	private SearchApplicationDetailsFlows search;
	
	@Autowired
	private BatchProcessFlows batchProcessingFlows;
	
	public SearchApplicationDetails searchDomain;
	
	@When("user creates $application_upload_file batch file and uploads it on server")
	public void createFileForApplicationUpload(@Named("application_upload_file") String batchName){	
		 String fileName=fileCreation.createApplicationUploadFile("100000");
		 processBatch.setJoBID(batchProcessingFlows.processUploadBatches(batchName, fileName));
	}
	
	@Then("The file will process the records successfully if all the all the business mandatory field are configured in file")
	public void verifyApplicationFileUpload(){
		searchDomain = searchDomain.getSearchApplicationData();
		search.verifyApplicationUploadSuccess(searchDomain);
	}
	
}
