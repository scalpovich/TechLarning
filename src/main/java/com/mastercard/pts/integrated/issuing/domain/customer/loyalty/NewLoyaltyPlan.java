package com.mastercard.pts.integrated.issuing.domain.customer.loyalty;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

/**
 * @author e076177
 *
 */
@Component
public class NewLoyaltyPlan {

	private String loyaltyPlancode;
	private String description;
	private String currency;
	private String planStartDate;
	private String maximumPointsEachPeriod;
	private String periodUnit;
	private String planValidityPeriod;
	private String roundOff;
	private String minimumPointsRequiredToRedeem;
	private String graceDaysForRedemption;
	private String pointsEarned;
	private String valueOfPoints;
	private String autoRedemption;
	private String minimumPointsRequiredToRedeemAutoRedemption;
	private String autoRedemptionDate;
	private String day;
	private String loyaltyPlan;

	public String getLoyaltyPlan() {
		return loyaltyPlan;
	}

	public String setLoyaltyPlan(String loyaltyPlan) {
		return this.loyaltyPlan = loyaltyPlan;
	}

	public String getLoyaltyPlancode() {
		return loyaltyPlancode;
	}

	public void setLoyaltyPlancode(String loyaltyPlancode) {
		this.loyaltyPlancode = loyaltyPlancode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getPlanStartDate() {
		return planStartDate;
	}

	public void setPlanStartDate(String planStartDate) {
		this.planStartDate = planStartDate;
	}

	public String getMaximumPointsEachPeriod() {
		return maximumPointsEachPeriod;
	}

	public void setMaximumPointsEachPeriod(String maximumPointsEachPeriod) {
		this.maximumPointsEachPeriod = maximumPointsEachPeriod;
	}

	public String getPeriodUnit() {
		return periodUnit;
	}

	public void setPeriodUnit(String periodUnit) {
		this.periodUnit = periodUnit;
	}

	public String getPlanValidityPeriod() {
		return planValidityPeriod;
	}

	public void setPlanValidityPeriod(String planValidityPeriod) {
		this.planValidityPeriod = planValidityPeriod;
	}

	public String getRoundOff() {
		return roundOff;
	}

	public void setRoundOff(String roundOff) {
		this.roundOff = roundOff;
	}

	public String getMinimumPointsRequiredToRedeem() {
		return minimumPointsRequiredToRedeem;
	}

	public void setMinimumPointsRequiredToRedeem(
			String minimumPointsRequiredToRedeem) {
		this.minimumPointsRequiredToRedeem = minimumPointsRequiredToRedeem;
	}

	public String getGraceDaysForRedemption() {
		return graceDaysForRedemption;
	}

	public void setGraceDaysForRedemption(String graceDaysForRedemption) {
		this.graceDaysForRedemption = graceDaysForRedemption;
	}

	public String getPointsEarned() {
		return pointsEarned;
	}

	public void setPointsEarned(String pointsEarned) {
		this.pointsEarned = pointsEarned;
	}

	public String getValueOfPoints() {
		return valueOfPoints;
	}

	public void setValueOfPoints(String valueOfPoints) {
		this.valueOfPoints = valueOfPoints;
	}

	public String getAutoRedemption() {
		return autoRedemption;
	}

	public void setAutoRedemption(String autoRedemption) {
		this.autoRedemption = autoRedemption;
	}

	public String getMinimumPointsRequiredToRedeemAutoRedemption() {
		return minimumPointsRequiredToRedeemAutoRedemption;
	}

	public void setMinimumPointsRequiredToRedeemAutoRedemption(
			String minimumPointsRequiredToRedeemAutoRedemption) {
		this.minimumPointsRequiredToRedeemAutoRedemption = minimumPointsRequiredToRedeemAutoRedemption;
	}

	public String getAutoRedemptionDate() {
		return autoRedemptionDate;
	}

	public void setAutoRedemptionDate(String autoRedemptionDate) {
		this.autoRedemptionDate = autoRedemptionDate;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public void loyaltyPlanDataProvider() {

		setLoyaltyPlancode(MapUtils.fnGetInputDataFromMap("LoyaltyPlanCode")
				+ CustomUtils.randomAlphaNumeric(5).toUpperCase());
		setDescription(MapUtils.fnGetInputDataFromMap("Description"));
		setCurrency(MapUtils.fnGetInputDataFromMap("Currency"));
		setMaximumPointsEachPeriod(MapUtils
				.fnGetInputDataFromMap("MaximumPointsEachPeriod"));
		setPeriodUnit(MapUtils.fnGetInputDataFromMap("PeriodUnit"));
		setPlanValidityPeriod(MapUtils
				.fnGetInputDataFromMap("PlanValidityPeriod"));
		setMinimumPointsRequiredToRedeem(MapUtils
				.fnGetInputDataFromMap("MinimumPointsRequiredToRedeem"));
		setGraceDaysForRedemption(MapUtils
				.fnGetInputDataFromMap("GraceDaysForRedemption"));
		setPointsEarned(MapUtils.fnGetInputDataFromMap("PointsEarned"));
		setValueOfPoints(MapUtils.fnGetInputDataFromMap("ValueOfPoints"));

		setMinimumPointsRequiredToRedeemAutoRedemption(MapUtils
				.fnGetInputDataFromMap("MinimumPointsRequiredToRedeemAutoRedemption"));
		setAutoRedemptionDate(MapUtils
				.fnGetInputDataFromMap("AutoRedemptionDate"));
		setDay(MapUtils.fnGetInputDataFromMap("Day"));

	}
}
