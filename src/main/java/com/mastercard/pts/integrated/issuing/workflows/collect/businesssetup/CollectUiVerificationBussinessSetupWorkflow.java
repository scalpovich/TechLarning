package com.mastercard.pts.integrated.issuing.workflows.collect.businesssetup;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.collect.businesssetup.ActionPage;
import com.mastercard.pts.integrated.issuing.pages.collect.businesssetup.AllocationPage;
import com.mastercard.pts.integrated.issuing.pages.collect.businesssetup.BusinessSetupClassificationPage;
import com.mastercard.pts.integrated.issuing.pages.collect.businesssetup.BusinessSetupEventAlertsPage;
import com.mastercard.pts.integrated.issuing.pages.collect.businesssetup.BusinessSetupHomePage;
import com.mastercard.pts.integrated.issuing.pages.collect.businesssetup.BusinessSetupSystemCodesPage;
import com.mastercard.pts.integrated.issuing.pages.collect.businesssetup.ClassPage;
import com.mastercard.pts.integrated.issuing.pages.collect.businesssetup.CommissionPlanPage;
import com.mastercard.pts.integrated.issuing.pages.collect.businesssetup.CommissionPlanRatesPage;
import com.mastercard.pts.integrated.issuing.pages.collect.businesssetup.CreationPage;
import com.mastercard.pts.integrated.issuing.pages.collect.businesssetup.DunningPage;
import com.mastercard.pts.integrated.issuing.pages.collect.businesssetup.OutstandingGroupPage;
import com.mastercard.pts.integrated.issuing.pages.collect.businesssetup.ResultPage;
import com.mastercard.pts.integrated.issuing.pages.collect.businesssetup.RiskGroupPage;
import com.mastercard.pts.integrated.issuing.pages.collect.businesssetup.RulesAllocationPage;
import com.mastercard.pts.integrated.issuing.pages.collect.businesssetup.WaiverAuthorityPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class CollectUiVerificationBussinessSetupWorkflow {
	@Autowired
	private Navigator navigator;

	public void verifyActionPage() {
		ActionPage page = navigator.navigateToPage(ActionPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyAllocationPage() {
		AllocationPage page = navigator.navigateToPage(AllocationPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyBusinessSetupClassificationPage() {
		BusinessSetupClassificationPage page = navigator.navigateToPage(BusinessSetupClassificationPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyBusinessSetupEventAlertsPage() {
		BusinessSetupEventAlertsPage page = navigator.navigateToPage(BusinessSetupEventAlertsPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyBusinessSetupHomePage() {
		BusinessSetupHomePage page = navigator.navigateToPage(BusinessSetupHomePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyBusinessSetupSystemCodesPage() {
		BusinessSetupSystemCodesPage page = navigator.navigateToPage(BusinessSetupSystemCodesPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyClassPage() {
		ClassPage page = navigator.navigateToPage(ClassPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyCommissionPlanPage() {
		CommissionPlanPage page = navigator.navigateToPage(CommissionPlanPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyCommissionPlanRatesPage() {
		CommissionPlanRatesPage page = navigator.navigateToPage(CommissionPlanRatesPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyCreationPage() {
		CreationPage page = navigator.navigateToPage(CreationPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyDunningPage() {
		DunningPage page = navigator.navigateToPage(DunningPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyOutstandingGroupPage() {
		OutstandingGroupPage page = navigator.navigateToPage(OutstandingGroupPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyResultPage() {
		ResultPage page = navigator.navigateToPage(ResultPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyRiskGroupPage() {
		RiskGroupPage page = navigator.navigateToPage(RiskGroupPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyRulesAllocationPage() {
		RulesAllocationPage page = navigator.navigateToPage(RulesAllocationPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyWaiverAuthorityPage() {
		WaiverAuthorityPage page = navigator.navigateToPage(WaiverAuthorityPage.class);
		page.verifyUiOperationStatus();
	}

}
