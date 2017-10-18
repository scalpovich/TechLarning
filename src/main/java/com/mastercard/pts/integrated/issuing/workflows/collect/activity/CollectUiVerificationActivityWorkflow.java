package com.mastercard.pts.integrated.issuing.workflows.collect.activity;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.collect.activity.ActivityHomePage;
import com.mastercard.pts.integrated.issuing.pages.collect.activity.AllocateManualPage;
import com.mastercard.pts.integrated.issuing.pages.collect.activity.AllocateToCollectorPage;
import com.mastercard.pts.integrated.issuing.pages.collect.activity.BookAllocateDeAllocatePage;
import com.mastercard.pts.integrated.issuing.pages.collect.activity.BookConfirmationReturnPage;
import com.mastercard.pts.integrated.issuing.pages.collect.activity.BookRequestToPrintPage;
import com.mastercard.pts.integrated.issuing.pages.collect.activity.CMSTrailsDownloadPage;
import com.mastercard.pts.integrated.issuing.pages.collect.activity.ContactRecordingPage;
import com.mastercard.pts.integrated.issuing.pages.collect.activity.DepositSchedulerPage;
import com.mastercard.pts.integrated.issuing.pages.collect.activity.ManualClassificationPage;
import com.mastercard.pts.integrated.issuing.pages.collect.activity.PIHMaintainPage;
import com.mastercard.pts.integrated.issuing.pages.collect.activity.ReceiptReconciliationPage;
import com.mastercard.pts.integrated.issuing.pages.collect.activity.SettlementApprovalPage;
import com.mastercard.pts.integrated.issuing.pages.collect.activity.SettlementHistoryPage;
import com.mastercard.pts.integrated.issuing.pages.collect.activity.WorkListPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class CollectUiVerificationActivityWorkflow {
	@Autowired
	private Navigator navigator;

	public void verifyActivityHomePage() {
		ActivityHomePage page = navigator.navigateToPage(ActivityHomePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyAllocateManualPage() {
		AllocateManualPage page = navigator.navigateToPage(AllocateManualPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyAllocateToCollectorPage() {
		AllocateToCollectorPage page = navigator.navigateToPage(AllocateToCollectorPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyBookAllocateDeAllocatePage() {
		BookAllocateDeAllocatePage page = navigator.navigateToPage(BookAllocateDeAllocatePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyBookConfirmationReturnPage() {
		BookConfirmationReturnPage page = navigator.navigateToPage(BookConfirmationReturnPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyBookRequestToPrintPage() {
		BookRequestToPrintPage page = navigator.navigateToPage(BookRequestToPrintPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyCMSTrailsDownloadPage() {
		CMSTrailsDownloadPage page = navigator.navigateToPage(CMSTrailsDownloadPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyContactRecordingPage() {
		ContactRecordingPage page = navigator.navigateToPage(ContactRecordingPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyDepositSchedulerPage() {
		DepositSchedulerPage page = navigator.navigateToPage(DepositSchedulerPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyManualClassificationPage() {
		ManualClassificationPage page = navigator.navigateToPage(ManualClassificationPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyPIHMaintainPage() {
		PIHMaintainPage page = navigator.navigateToPage(PIHMaintainPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyReceiptReconciliationPage() {
		ReceiptReconciliationPage page = navigator.navigateToPage(ReceiptReconciliationPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifySettlementApprovalPage() {
		SettlementApprovalPage page = navigator.navigateToPage(SettlementApprovalPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifySettlementHistoryPage() {
		SettlementHistoryPage page = navigator.navigateToPage(SettlementHistoryPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyWorkListPage() {
		WorkListPage page = navigator.navigateToPage(WorkListPage.class);
		page.verifyUiOperationStatus();
	}

}
