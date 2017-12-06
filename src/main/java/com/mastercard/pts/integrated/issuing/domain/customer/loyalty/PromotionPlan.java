package com.mastercard.pts.integrated.issuing.domain.customer.loyalty;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class PromotionPlan {

	private String promotionPlanCode;
	private String promotionDescription;

	private String promotionCurrency;
	private String promotionamountSpent;
	private String promotionpointsEarned;
	private String promotionloyaltyBatchDate;
	private String promotionthresholdAmount;
	private String promotionNoOfTransactions;
	private String promotion;

	public String getPromotionPlanCode() {
		return promotionPlanCode;
	}

	public void setPromotionPlanCode(String promotionPlanCode) {
		this.promotionPlanCode = promotionPlanCode;
	}

	public String getPromotionDescription() {
		return promotionDescription;
	}

	public void setPromotionDescription(String promotionDescription) {
		this.promotionDescription = promotionDescription;
	}

	public String getPromotionCurrency() {
		return promotionCurrency;
	}

	public void setPromotionCurrency(String promotionCurrency) {
		this.promotionCurrency = promotionCurrency;
	}

	public String getPromotionamountSpent() {
		return promotionamountSpent;
	}

	public void setPromotionamountSpent(String promotionamountSpent) {
		this.promotionamountSpent = promotionamountSpent;
	}

	public String getPromotionpointsEarned() {
		return promotionpointsEarned;
	}

	public void setPromotionpointsEarned(String promotionpointsEarned) {
		this.promotionpointsEarned = promotionpointsEarned;
	}

	public String getPromotionloyaltyBatchDate() {
		return promotionloyaltyBatchDate;
	}

	public void setPromotionloyaltyBatchDate(String promotionloyaltyBatchDate) {
		this.promotionloyaltyBatchDate = promotionloyaltyBatchDate;
	}

	public String getPromotionthresholdAmount() {
		return promotionthresholdAmount;
	}

	public void setPromotionthresholdAmount(String promotionthresholdAmount) {
		this.promotionthresholdAmount = promotionthresholdAmount;
	}

	public String getPromotionNoOfTransactions() {
		return promotionNoOfTransactions;
	}

	public void setPromotionNoOfTransactions(String promotionNoOfTransactions) {
		this.promotionNoOfTransactions = promotionNoOfTransactions;
	}

	public String getPromotion() {
		return promotion;
	}

	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}

	public void promotionDataProvider() {
		setPromotionPlanCode(MapUtils
				.fnGetInputDataFromMap("PromotionPlanCode")
				+ CustomUtils.randomAlphaNumeric(5).toUpperCase());
		setPromotionDescription(MapUtils
				.fnGetInputDataFromMap("PromotionPlanDesc"));
		setPromotionCurrency(MapUtils
				.fnGetInputDataFromMap("promotionCurrency"));
		setPromotionamountSpent(MapUtils.fnGetInputDataFromMap("AmountSpent"));
		setPromotionpointsEarned(MapUtils.fnGetInputDataFromMap("pointsEarned"));
		setPromotionloyaltyBatchDate(MapUtils
				.fnGetInputDataFromMap("LoyaltyBatchSettlementDays"));
		setPromotionthresholdAmount(MapUtils
				.fnGetInputDataFromMap("thresholdAmount"));
		setPromotionNoOfTransactions(MapUtils
				.fnGetInputDataFromMap("noOfTransactions"));

	}
}
