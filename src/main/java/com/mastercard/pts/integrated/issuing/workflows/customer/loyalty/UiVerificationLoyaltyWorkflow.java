package com.mastercard.pts.integrated.issuing.workflows.customer.loyalty;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.LoyaltyPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.loyalty.EventBasedLoyaltyPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.loyalty.EventBasedLoyaltyPointsPosting;
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
import com.mastercard.pts.integrated.issuing.utils.Constants;

@Workflow
public class UiVerificationLoyaltyWorkflow {

	@Autowired
	private Navigator navigator;
	

	@Autowired
	private TestContext context;
	

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
		String instCode= context.get(Constants.USER_INSTITUTION_SELECTED);
		page.verifyUiOperationStatus(instCode);
	}
	
	
	public void addLoyaltyPlanWithAutoRedemption(LoyaltyPlan loyaltyplan) {
		LoyaltyPlanPage page = navigator.navigateToPage(LoyaltyPlanPage.class);
		String instCode= context.get(Constants.USER_INSTITUTION_SELECTED);
		page.addLoyaltyPlanforAutoRedemption(loyaltyplan,instCode);
	}


	public void editLoyaltyPlanPage(LoyaltyPlan loyaltyplan) {
		LoyaltyPlanPage page = navigator.navigateToPage(LoyaltyPlanPage.class);
		page.editLoyaltyPlan(loyaltyplan);
	}


	public void verifyLoyaltyPlanPromotionMappingPage(LoyaltyPromotionMapping loyaltyPromotionMapping) {
		LoyaltyPlanPromotionMappingPage page = navigator.navigateToPage(LoyaltyPlanPromotionMappingPage.class);
		page.verifyUiOperationStatus(loyaltyPromotionMapping);

	}

	public void deleteLoyaltyPlanPromotionMappingPage(LoyaltyPromotionMapping loyaltyPromotionMapping) {
		LoyaltyPlanPromotionMappingPage page = navigator.navigateToPage(LoyaltyPlanPromotionMappingPage.class);
		page.deleteLoyaltyPromotionMapping(loyaltyPromotionMapping);

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
		String instCode = context.get(Constants.USER_INSTITUTION_SELECTED);
		page.verifyUiOperationStatus(plan,instCode);
	}

	public void verifyPromotionPlanwithMCG(PromotionPlan plan) {
		PromotionPlanPage page = navigator.navigateToPage(PromotionPlanPage.class);
		String instCode = context.get(Constants.USER_INSTITUTION_SELECTED);
		page.verifyUiOperationStatuswithMCG(plan,instCode);

	}

	public void addPromotionPlanwithCumulative(PromotionPlan plan) {
		PromotionPlanPage page = navigator.navigateToPage(PromotionPlanPage.class);
		String instCode = context.get(Constants.USER_INSTITUTION_SELECTED);
		page.addPromotionPlanwithCumulativeTxn(plan,instCode);
	}

	public void addPromotionPlanwithIssuance(PromotionPlan plan) {
		PromotionPlanPage page = navigator.navigateToPage(PromotionPlanPage.class);
		String instCode = context.get(Constants.USER_INSTITUTION_SELECTED);
		page.addPromotionPlanwithIssuance(plan,instCode);
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

	public String getMaxLoyaltyPointsPerCycle(String plan) {
		LoyaltyPlanPage page = navigator.navigateToPage(LoyaltyPlanPage.class);
		page.searchByPlanCode(plan.substring(plan.indexOf("[") + 1, plan.indexOf("]")));
		return page.getMaxPtsPerCycle();
	}

	public void addEventBasedLoyaltyPlan(EventBasedLoyaltyPlan plan){
		EventBasedLoyaltyPointsPage page = navigator.navigateToPage(EventBasedLoyaltyPointsPage.class);
		page.addEventBasedLoyaltyPoints(plan);
	}
	
	public void addEventBasedLoyaltyPointsposting(EventBasedLoyaltyPointsPosting plan){
		EventBasedLoyaltyPointsPostingPage page = navigator.navigateToPage(EventBasedLoyaltyPointsPostingPage.class);
		page.addEventBasedLoyaltyPointsPosting(plan);
	}
	
	
	public void disableLoyaltyPlan(String plan) {
		LoyaltyPlanPage page = navigator.navigateToPage(LoyaltyPlanPage.class);
		page.searchByPlanCode(plan.substring(plan.indexOf("[")+1, plan.indexOf("]")));
		page.disableLoyaltyPlan();
	}
	
	public void selectPeriodUnitByIndex(String plan, String value) {
		LoyaltyPlanPage page = navigator.navigateToPage(LoyaltyPlanPage.class);
		page.searchByPlanCode(plan.substring(plan.indexOf("[")+1, plan.indexOf("]")));
		page.selectPeriodUnitByIndex(value);
	}
	
	public String getPointsEarnedOnPromotionPlan(String plan) {
		PromotionPlanPage page = navigator.navigateToPage(PromotionPlanPage.class);
		page.searchByPlanCode(plan);
		return page.getPointsEarned();
	}
	
	public String getAmtSpentOnPromotionPlan(String plan) {
		PromotionPlanPage page = navigator.navigateToPage(PromotionPlanPage.class);
		page.searchByPlanCode(plan);
		return page.getAmountSpent();
	}

	public void selectBlockedMCG(String plan, String value) {
		LoyaltyPlanPage page = navigator.navigateToPage(LoyaltyPlanPage.class);
		page.searchByPlanCode(plan.substring(plan.indexOf("[")+1, plan.indexOf("]")));
		page.selectBlockedMCG(value);
	}

	public void selectPromoRulesMCG(String plan, String mcg) {
		PromotionPlanPage page = navigator.navigateToPage(PromotionPlanPage.class);
		page.searchByPlanCode(plan);
		page.selectPromoRulesMCG(mcg);
	}

}
