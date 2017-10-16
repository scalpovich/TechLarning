package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

public class AdjustmentTransaction {

	private static final String ADJUSTMENT_TYPE = "ADJUSTMENT_TYPE";
	
	private String adjustmentType;
	
	private String voucherNumber;

	private List<AdjustmentTransactionDetails> adjustmentTransactionDetails = new ArrayList<>();

	public static AdjustmentTransaction createWithProvider(KeyValueProvider provider){
		AdjustmentTransaction transaction = new AdjustmentTransaction();
		transaction.setAdjustmentType(provider.getString(ADJUSTMENT_TYPE));
		transaction.setVoucherNumber(RandomStringUtils.randomNumeric(8));
		return transaction;
	}
	
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

	public List<AdjustmentTransactionDetails> getAdjustmentTransactionDetails() {
		return adjustmentTransactionDetails;
	}

	public void setAdjustmentTransactionDetails(
			List<AdjustmentTransactionDetails> adjustmentTransactionDetails) {
		this.adjustmentTransactionDetails = adjustmentTransactionDetails;
	}

}
