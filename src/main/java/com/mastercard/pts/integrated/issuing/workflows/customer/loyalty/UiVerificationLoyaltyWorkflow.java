package com.mastercard.pts.integrated.issuing.workflows.customer.loyalty;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
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
public class  UiVerificationLoyaltyWorkflow{

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
   @When("user adds loyaltyPlan")
	public void verifyLoyaltyPlanPage() {
		LoyaltyPlanPage page = navigator.navigateToPage(LoyaltyPlanPage.class);
		page.verifyUiOperationStatus();
	}
    
   @When("user maps promotionPlan with loyaltyPlan")
	public void verifyLoyaltyPlanPromotionMappingPage() {
		LoyaltyPlanPromotionMappingPage page = navigator.navigateToPage(LoyaltyPlanPromotionMappingPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyLoyaltyPointsPage() {
		LoyaltyPointsPage page = navigator.navigateToPage(LoyaltyPointsPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyLoyaltyTransactionPlanPage() {
		LoyaltyTransactionPlanPage page = navigator.navigateToPage(LoyaltyTransactionPlanPage.class);
		page.verifyUiOperationStatus();
	}
    @When("user adds promotionPlan")
	public void verifyPromotionPlanPage() {
		PromotionPlanPage page = navigator.navigateToPage(PromotionPlanPage.class);
		page.verifyUiOperationStatus();
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
