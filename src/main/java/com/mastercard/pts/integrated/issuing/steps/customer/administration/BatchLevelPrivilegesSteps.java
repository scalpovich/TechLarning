package com.mastercard.pts.integrated.issuing.steps.customer.administration;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.configuration.AppEnvironment;
import com.mastercard.pts.integrated.issuing.configuration.Portal;
import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.admin.UserCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BatchLevelPriviledge;
import com.mastercard.pts.integrated.issuing.workflows.LoginFlows;
import com.mastercard.pts.integrated.issuing.workflows.customer.administration.BatchLevelPrivilegesWorkflow;

@Component
public class BatchLevelPrivilegesSteps {

	@Autowired
	AppEnvironment appEnvironment;

	@Autowired
	public LoginFlows login;

	@Autowired
	private BatchLevelPriviledge batchlevelprevidge;

	@Autowired
	private BatchLevelPrivilegesWorkflow batchLevelPrevFlow;

	@Autowired
	TestContext context;

	@Given("$adminUser provides privilege to $applicationuser to process batches")
	public void setBatchProcessPrelivedge(String adminUser,
			String applicationUser) {
		Portal userPortal = appEnvironment
				.getPortalByType(Portal.TYPE_CUSTOMER);
		login.Login(userPortal, adminUser);
		batchlevelprevidge.setEntityType("User");
		batchLevelPrevFlow
				.setAllBatchLevelTabPriviledgesForUsers(applicationUser);
	}

	@When("admin provides batch level privileges for the the newly created $user")
	@Then("admin provides batch level privileges for the the newly created $user")
	public void assignBatchLevelPrivileges(String entityType) {
		UserCreation userCreation = context.get(ContextConstants.USER);
		batchlevelprevidge.setEntityType(entityType);
		batchLevelPrevFlow.setAllBatchLevelTabPriviledgesForUsers(userCreation
				.buildDescriptionAndCode());
	}

	@When("client photo/flat file download batch is present under download in batch level privilege page")
	@Then("client photo/flat file download batch is present under download in batch level privilege page")
	public void thenPhotoFileDownloadBatchPresentInBatchLevelPriviledgeScreen(){
		Assert.assertTrue("batch is not present", batchLevelPrevFlow.verifyPhotoFileDownloadBatchPresent());
	}
	
	@Then("admin provides access to download photo/flat file download batch")
	@When("admin provides access to download photo/flat file download batch")	
	public void whenAdminProvidesAccessToDownloadPhotoFile(){
		batchLevelPrevFlow.provideAccessToDownloadPhotoFileDownloadBatch();
	}
}
