package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.utils.MapUtils;

public class TransactionLimitPlan {

	public String StartMonthForYearlyLimits;

	public String TransactionType;

	public String FloorAmount;

	public String CeilingAmount;

	public String getStartMonthForYearlyLimits() {
		return StartMonthForYearlyLimits;
	}

	public void setStartMonthForYearlyLimits(String startMonthForYearlyLimits) {
		StartMonthForYearlyLimits = startMonthForYearlyLimits;
	}

	public String getTransactionType() {
		return TransactionType;
	}

	public void setTransactionType(String transactionType) {
		TransactionType = transactionType;
	}

	public String getFloorAmount() {
		return FloorAmount;
	}

	public void setFloorAmount(String floorAmount) {
		FloorAmount = floorAmount;
	}

	public String getCeilingAmount() {
		return CeilingAmount;
	}

	public void setCeilingAmount(String ceilingAmount) {
		CeilingAmount = ceilingAmount;
	}

	public static TransactionLimitPlan transactionlimitDataProvider() {
		TransactionLimitPlan transactionlimitplan = new TransactionLimitPlan();
		transactionlimitplan.setStartMonthForYearlyLimits(MapUtils.fnGetInputDataFromMap("StartMonthForYearlyLimits"));
		transactionlimitplan.setTransactionType(MapUtils.fnGetInputDataFromMap("TransactionType"));
		transactionlimitplan.setFloorAmount(MapUtils.fnGetInputDataFromMap("FloorAmount"));
		transactionlimitplan.setCeilingAmount(MapUtils.fnGetInputDataFromMap("CeilingAmount"));
		return transactionlimitplan;
	}
}
