package com.mastercard.pts.integrated.issuing.steps;

import org.jbehave.core.annotations.Given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.configuration.AppEnvironment;
import com.mastercard.pts.integrated.issuing.configuration.Portal;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BatchLevelPriviledge;
import com.mastercard.pts.integrated.issuing.utils.FileCreation;
import com.mastercard.pts.integrated.issuing.workflows.BatchLevelPreviledgeFlows;
import com.mastercard.pts.integrated.issuing.workflows.LoginFlows;

@Component
public class BatchLevelPreviledgeSteps {
	
	@Autowired
	AppEnvironment appEnvironment;
	
	@Autowired
	public LoginFlows login;
	
	@Autowired
	private BatchLevelPriviledge batchlevelprevidge;
	
	@Autowired
	private BatchLevelPreviledgeFlows batchlevelprevFlow;
	
	@Autowired
	private FileCreation fileCreation;

	
	@Given("$adminUser provides privilege to $applicationuser to process batches")
	/*@Composite(steps ={
			"When login to bank as a $adminUser",
			"When the batch level privileges are assigned to the $applicationuser for this screen",
			"Then the user should be able to access the new screen"})*/
	public void setBatchProcessPrelivedge(String adminUser,String applicationUser){
		Portal userPortal = appEnvironment
				.getPortalByType(Portal.TYPE_CUSTOMER);
			login.Login(userPortal, adminUser);		
			batchlevelprevidge.setEntityType("User");
			batchlevelprevFlow.setAllBatchLevelTabPriviledgesForUsers(applicationUser);		
	}
	
	@Given("abc")
	public void abc(){
		fileCreation.createApplicationUploadFile("100000");
	}
	
}
