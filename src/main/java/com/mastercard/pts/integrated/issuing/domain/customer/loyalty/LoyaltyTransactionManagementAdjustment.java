package com.mastercard.pts.integrated.issuing.domain.customer.loyalty;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.MapUtils;

/**
 * @author e076177
 *
 */
@Component
public class LoyaltyTransactionManagementAdjustment {

	private String adjustmentType;
	private String voucherNumber;
	private String adjustmentAmount;
	private String transactionDate;
	private String memo;
	private String hours;
	private String minutes;

	public String getAdjustmentType() {
		return adjustmentType;
	}

	public void setAdjustmentType(String adjustmentType) {
		this.adjustmentType = adjustmentType;
	}

	public String getVoucherNumber() {
		return voucherNumber;
	}

	public void setVoucherNumber(String voucherNumber) {
		this.voucherNumber = voucherNumber;
	}

	public String getAdjustmentAmount() {
		return adjustmentAmount;
	}

	public void setAdjustmentAmount(String adjustmentAmount) {
		this.adjustmentAmount = adjustmentAmount;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public String getMinutes() {
		return minutes;
	}

	public void setMinutes(String minutes) {
		this.minutes = minutes;
	}

	public void loyaltyTransactionManagementAdjustmentDataProvider() {

		setAdjustmentType(MapUtils.fnGetInputDataFromMap("AdjustmentType"));
		setAdjustmentAmount(MapUtils.fnGetInputDataFromMap("AdjustmentAmount"));
		setTransactionDate(MapUtils.fnGetInputDataFromMap("transactionDate"));
		setHours(MapUtils.fnGetInputDataFromMap("hours"));
		setMinutes(MapUtils.fnGetInputDataFromMap("minutes"));
		setMemo(MapUtils.fnGetInputDataFromMap("memo"));

	}
}
