package com.mastercard.pts.integrated.issuing.workflows.customer.loyalty;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.LoyaltyPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.loyalty.LoyaltyPromotionMapping;
import com.mastercard.pts.integrated.issuing.domain.customer.loyalty.PromotionPlan;
import com.mastercard.pts.integrated.issuing.pages.customer.loyalty.EventBasedLoyaltyPointsPage;
import com.mastercard.pts.integrated.issuing.pages.customer.loyalty.EventBasedLoyaltyPointsPostingPage;
import com.mastercard.pts.integrated.issuing.pages.customer.loyalty.GiftRewardCataloguePage;
import com.mastercard.pts.integrated.issuing.pages.customer.loyalty.LoyaltyPlanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.loyalty.LoyaltyPlanPromotionMappingPage;
import com.mastercard.pts.integrated.issuing.pages.customer.loyalty.LoyaltyPointsPage;
import com.mastercard.pts.integrated.issuing.pages.customer.loyalty.LoyaltyTransactionPlanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.loyalty.PromotionPlanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.loyalty.RedemptionPage;
import com.mastercard.pts.integrated.issuing.pages.customer.loyalty.RewardRedemptionPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class UiVerificationLoyaltyWorkflow {

	@Autowired
	private Navigator navigator;

	public void verifyEventBasedLoyaltyPointsPage() {
		EventBasedLoyaltyPointsPage page = navigator.navigateToPage(EventBasedLoyaltyPointsPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyEventBasedLoyaltyPointsPostingPage() {
		EventBasedLoyaltyPointsPostingPage page = navigator.navigateToPage(EventBasedLoyaltyPointsPostingPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyGiftRewardCataloguePage() {
		GiftRewardCataloguePage page = navigator.navigateToPage(GiftRewardCataloguePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyLoyaltyPlanPage() {
		LoyaltyPlanPage page = navigator.navigateToPage(LoyaltyPlanPage.class);
		page.verifyUiOperationStatus();
	}

	public void EditLoyaltyPlanPage(LoyaltyPlan loyaltyplan) {
		LoyaltyPlanPage page = navigator.navigateToPage(LoyaltyPlanPage.class);
		page.editLoyaltyPlan(loyaltyplan);
	}

	public void verifyLoyaltyPlanPromotionMappingPage(LoyaltyPromotionMapping loyaltyPromotionMapping) {
		LoyaltyPlanPromotionMappingPage page = navigator.navigateToPage(LoyaltyPlanPromotionMappingPage.class);
		page.verifyUiOperationStatus(loyaltyPromotionMapping);
	}

	public void verifyLoyaltyPointsPage() {
		LoyaltyPointsPage page = navigator.navigateToPage(LoyaltyPointsPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyLoyaltyTransactionPlanPage() {
		LoyaltyTransactionPlanPage page = navigator.navigateToPage(LoyaltyTransactionPlanPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyPromotionPlanPage(PromotionPlan plan) {
		PromotionPlanPage page = navigator.navigateToPage(PromotionPlanPage.class);
		page.verifyUiOperationStatus(plan);
	}

	public void verifyPromotionPlanwithMCG(PromotionPlan plan) {
		PromotionPlanPage page = navigator.navigateToPage(PromotionPlanPage.class);
		page.verifyUiOperationStatuswithMCG(plan);
	}

	public void addPromotionPlanwithCumulative(PromotionPlan plan) {
		PromotionPlanPage page = navigator.navigateToPage(PromotionPlanPage.class);
		page.addPromotionPlanwithCumulativeTxn(plan);
	}

	public void editPromotionPlanDate(PromotionPlan plan) {
		PromotionPlanPage page = navigator.navigateToPage(PromotionPlanPage.class);
		page.editpromotionPlanStartDate(plan);
	}

	public void verifyRedemptionPage() {
		RedemptionPage page = navigator.navigateToPage(RedemptionPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyRewardRedemptionPage() {
		RewardRedemptionPage page = navigator.navigateToPage(RewardRedemptionPage.class);
		page.verifyUiOperationStatus();
	}
}
