package com.mastercard.pts.integrated.issuing.workflows.agent.settlement;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.agent.settlement.AgencySettlementPage;
import com.mastercard.pts.integrated.issuing.pages.agent.settlement.BranchSettlementPage;
import com.mastercard.pts.integrated.issuing.pages.agent.settlement.InitiateSettlementPage;
import com.mastercard.pts.integrated.issuing.pages.agent.settlement.TransactionAndSettlementPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class SettlementWorkflow {
	private AgencySettlementPage aspage;
	private BranchSettlementPage bspage;
	private InitiateSettlementPage ispage;
	private TransactionAndSettlementPage tspage;
	
	@Autowired
	private Navigator navigator;
	
	public void navigateToAgencySettlementPage() {
		aspage = navigator.navigateToPage(AgencySettlementPage.class);
	}

	public String getAgencySettlementMasterDetailContentTitleText() {
		return aspage.getMasterDetailContentTitleText();
	}
	
	public void navigateToBranchSettlementPage() {
		bspage = navigator.navigateToPage(BranchSettlementPage.class);
	}

	public String getBranchSettlementMasterDetailContentTitleText() {
		return bspage.getMasterDetailContentTitleText();
	}
	
	public void navigateToInitiateSettlementPage() {
		ispage = navigator.navigateToPage(InitiateSettlementPage.class);
	}

	public String getInitiateSettlementMasterDetailContentTitleText() {
		return ispage.getMasterDetailContentTitleText();
	}
	
	public void navigateToTransactionAndSettlementPage() {
		tspage = navigator.navigateToPage(TransactionAndSettlementPage.class);
	}

	public String getTransactionAndSettlementMasterDetailContentTitleText() {
		return tspage.getMasterDetailContentTitleText();
	}
}
