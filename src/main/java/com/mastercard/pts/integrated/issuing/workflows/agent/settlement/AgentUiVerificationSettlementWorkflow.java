package com.mastercard.pts.integrated.issuing.workflows.agent.settlement;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.agent.settlement.*;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class AgentUiVerificationSettlementWorkflow {
	@Autowired
	private Navigator navigator;

	public void verifyAgencySettlementPage() {
		AgencySettlementPage page = navigator.navigateToPage(AgencySettlementPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyBranchSettlementPage() {
		BranchSettlementPage page = navigator.navigateToPage(BranchSettlementPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyInitiateSettlementPage() {
		InitiateSettlementPage page = navigator.navigateToPage(InitiateSettlementPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyTransactionAndSettlementPage() {
		TransactionAndSettlementPage page = navigator.navigateToPage(TransactionAndSettlementPage.class);
		page.verifyUiOperationStatus();
	}

}