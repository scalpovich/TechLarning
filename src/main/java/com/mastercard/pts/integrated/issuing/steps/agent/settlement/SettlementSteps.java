package com.mastercard.pts.integrated.issuing.steps.agent.settlement;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.agent.settlement.SettlementWorkflow;


@Component
public class SettlementSteps {
	private static final String FAILED_MESSAGE_INFO = "Page Load Failed";
	
	@Autowired
	private SettlementWorkflow settlementWorkflow;
	
	@When("user navigates to agency settlement page")
	public void whenUserNavigatesToAgencySettlementPage(){
		settlementWorkflow.navigateToAgencySettlementPage();
	}
	
	@Then("agency settlement page is loaded and master detail content title is $expectedTitleText")
	public void thenAgencySettlementPageLoaded(String expectedTitleText){
		assertThat(FAILED_MESSAGE_INFO, settlementWorkflow.getAgencySettlementMasterDetailContentTitleText(), containsString(expectedTitleText));
	}
	
	@When("user navigates to branch settlement page")
	public void whenUserNavigatesToBranchSettlementPage(){
		settlementWorkflow.navigateToBranchSettlementPage();
	}
	
	@Then("branch settlement page is loaded and master detail content title is $expectedTitleText")
	public void thenBranchSettlementPageLoaded(String expectedTitleText){
		assertThat(FAILED_MESSAGE_INFO, settlementWorkflow.getBranchSettlementMasterDetailContentTitleText(), containsString(expectedTitleText));
	}
	
	@When("user navigates to initiate settlement page")
	public void whenUserNavigatesToInitiateSettlementPage(){
		settlementWorkflow.navigateToInitiateSettlementPage();
	}
	
	@Then("initiate settlement page is loaded and master detail content title is $expectedTitleText")
	public void thenInitiateSettlementPageLoaded(String expectedTitleText){
		assertThat(FAILED_MESSAGE_INFO, settlementWorkflow.getInitiateSettlementMasterDetailContentTitleText(), containsString(expectedTitleText));
	}
	
	@When("user navigates to transaction and settlement page")
	public void whenUserNavigatesToTransactionAndSettlementPage(){
		settlementWorkflow.navigateToTransactionAndSettlementPage();
	}
	
	@Then("transaction and settlement page is loaded and master detail content title is $expectedTitleText")
	public void thenTransactionAndSettlementPageLoaded(String expectedTitleText){
		assertThat(FAILED_MESSAGE_INFO, settlementWorkflow.getTransactionAndSettlementMasterDetailContentTitleText(), containsString(expectedTitleText));
	}
}