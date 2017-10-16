package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class CreditCardPaymentPriority implements HasCodeAndDescription {

	private String paymentPriorityPlanCode;
	private String description;
	private String cash;
	private String purchase;	
	private String unique;
	private String tAndE;
	private String fee;
	private String transfer;
	private String installement;
	private String interest;
	
	public static CreditCardPaymentPriority generateDynamicTestData() {
		CreditCardPaymentPriority testdata = new CreditCardPaymentPriority();
		testdata.setPaymentPriorityPlanCode(MiscUtils.generateRandomNumberBetween2Number(100, 999));
		testdata.setDescription(ConstantData.GENERIC_DESCRIPTION);
		testdata.setCash(MiscUtils.generateRandomNumberBetween2Number(1, 8));
		testdata.setPurchase(MiscUtils.generateRandomNumberBetween2Number(1, 8));
		testdata.setUnique(MiscUtils.generateRandomNumberBetween2Number(1, 8));
		testdata.settAndE(MiscUtils.generateRandomNumberBetween2Number(1, 8));
		testdata.setFee(MiscUtils.generateRandomNumberBetween2Number(1, 8));
		testdata.setTransfer(MiscUtils.generateRandomNumberBetween2Number(1, 8));
		testdata.setInstallement(MiscUtils.generateRandomNumberBetween2Number(1, 8));
		testdata.setInterest(MiscUtils.generateRandomNumberBetween2Number(1, 8));
		return testdata;
	}
	
	@Override
	public String getCode() {
		return getPaymentPriorityPlanCode();
	}
	
	public String getPaymentPriorityPlanCode() {
		return paymentPriorityPlanCode;
	}

	public void setPaymentPriorityPlanCode(String paymentPriorityPlanCode) {
		this.paymentPriorityPlanCode = paymentPriorityPlanCode;
	}

	@Override
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public String getCash() {
		return cash;
	}

	public void setCash(String cash) {
		this.cash = cash;
	}

	public String getPurchase() {
		return purchase;
	}

	public void setPurchase(String purchase) {
		this.purchase = purchase;
	}

	public String getUnique() {
		return unique;
	}

	public void setUnique(String unique) {
		this.unique = unique;
	}

	public String gettAndE() {
		return tAndE;
	}

	public void settAndE(String tAndE) {
		this.tAndE = tAndE;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getTransfer() {
		return transfer;
	}

	public void setTransfer(String transfer) {
		this.transfer = transfer;
	}

	public String getInstallement() {
		return installement;
	}

	public void setInstallement(String installement) {
		this.installement = installement;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	@Override
	public String toString() {
		return "CreditCardPaymentPriority [paymentPriorityPlanCode;=" + paymentPriorityPlanCode + ", description="
				+ description + ", cash=" + cash + ", purchase=" + purchase + ", unique="
						+ unique + ", T&E=" + tAndE + ", fee=" + fee +", transfer="
								+ transfer + ", installement=" + installement + ", interest=" + interest + "]";
	}
}
