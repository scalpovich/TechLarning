package com.mastercard.pts.integrated.issuing.domain.customer.loyalty;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

@Component
public class PromotionPlan implements HasCodeAndDescription {

	private String promotionPlanCode;
	private String promotionDescription;

	private String promotionCurrency;
	private String promotionamountSpent;
	private String promotionpointsEarned;
	private String promotionloyaltyBatchDate;
	private String floortransactionAmount;
	private String mccCode;
	private String mcgCode;
	private String thresholdAmount;
	private String numberOfTransactions;

	public String getNumberOfTransactions() {
		return numberOfTransactions;
	}

	public void setNumberOfTransactions(String numberOfTransactions) {
		this.numberOfTransactions = numberOfTransactions;
	}

	public String getMcgCode() {
		return mcgCode;
	}

	public void setMcgCode(String mcgCode) {
		this.mcgCode = mcgCode;
	}

	public String getThresholdAmount() {
		return thresholdAmount;
	}

	public void setThresholdAmount(String thresholdAmount) {
		this.thresholdAmount = thresholdAmount;
	}

	private String promotionloyaltyPlan;

	public String getPromotionloyaltyPlan() {
		return promotionloyaltyPlan;
	}

	public void setPromotionloyaltyPlan(String promotionloyaltyPlan) {
		this.promotionloyaltyPlan = promotionloyaltyPlan;
	}

	public String getMccCode() {
		return mccCode;
	}

	public void setMccCode(String mccCode) {
		this.mccCode = mccCode;
	}

	public String getFloortransactionAmount() {
		return floortransactionAmount;
	}

	public void setFloortransactionAmount(String floortransactionAmount) {
		this.floortransactionAmount = floortransactionAmount;
	}

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
		setPromotionPlanCode(
				MapUtils.fnGetInputDataFromMap("PromotionPlanCode") + CustomUtils.randomAlphaNumeric(5).toUpperCase());
		setPromotionDescription(MapUtils.fnGetInputDataFromMap("PromotionPlanDesc"));
		setPromotionCurrency(MapUtils.fnGetInputDataFromMap("promotionCurrency"));
		setPromotionamountSpent(MapUtils.fnGetInputDataFromMap("AmountSpent"));
		setPromotionpointsEarned(MapUtils.fnGetInputDataFromMap("pointsEarned"));
		setPromotionloyaltyBatchDate(MapUtils.fnGetInputDataFromMap("LoyaltyBatchSettlementDays"));
		setPromotionNoOfTransactions(MapUtils.fnGetInputDataFromMap("noOfTransactions"));

	}

	public static PromotionPlan createWithProvider(KeyValueProvider provider) {
		PromotionPlan plan = new PromotionPlan();
		plan.setPromotionPlanCode(MiscUtils.generate6CharAlphaNumeric());
		plan.setPromotionDescription(ConstantData.GENERIC_DESCRIPTION);
		plan.setPromotionCurrency(provider.getString("PROMOTION_CURRENCY"));
		plan.setPromotionamountSpent(provider.getString("PROMOTION_AMOUNT_SPENT"));
		plan.setPromotionpointsEarned(provider.getString("PROMOTION_POINTS_EARNED"));
		plan.setFloortransactionAmount(provider.getString("FLOOR_TRANSACTION_AMOUNT"));
		plan.setThresholdAmount(provider.getString("THRESHOLD_AMOUNT"));
		plan.setNumberOfTransactions(provider.getString("NO._OF_TRANSACTIONS"));
		plan.setMccCode(provider.getString("MCC_CODE_INVALID"));
		plan.setMcgCode(provider.getString("MCG_CODE"));
		return plan;
	}

	@Override
	public String getCode() {
		return getPromotionPlanCode();
	}

	@Override
	public String getDescription() {
		return getPromotionDescription();
	}
}
