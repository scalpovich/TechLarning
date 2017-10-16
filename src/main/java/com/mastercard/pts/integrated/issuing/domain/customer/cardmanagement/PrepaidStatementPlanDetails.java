package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

public class PrepaidStatementPlanDetails {

	private static final String PSPD_GENERATION_STATUS = "PSPD_GENERATION_STATUS";

	private static final String PSPD_PRINT_DAY = "PSPD_PRINT_DAY";

	private static final String PSPD_BILLING_DAY = "PSPD_BILLING_DAY";

	private static final String PSPD_TO_LOT = "PSPD_TO_LOT";

	private int toLot;
	
	private int billingDay;
	
	private int printDay;
	
	private String generationStatus;
	
	public static PrepaidStatementPlanDetails createWithProvider(KeyValueProvider provider) {
		PrepaidStatementPlanDetails details = new PrepaidStatementPlanDetails();
		details.setToLot(provider.getInt(PSPD_TO_LOT));
		details.setBillingDay(provider.getInt(PSPD_BILLING_DAY));
		details.setPrintDay(provider.getInt(PSPD_PRINT_DAY));
		details.setGenerationStatus(provider.getString(PSPD_GENERATION_STATUS));
		return details;
	}

	public int getToLot() {
		return toLot;
	}

	public void setToLot(int toLot) {
		this.toLot = toLot;
	}

	public int getBillingDay() {
		return billingDay;
	}

	public void setBillingDay(int billingDay) {
		this.billingDay = billingDay;
	}

	public int getPrintDay() {
		return printDay;
	}

	public void setPrintDay(int printDay) {
		this.printDay = printDay;
	}

	public String getGenerationStatus() {
		return generationStatus;
	}

	public void setGenerationStatus(String generationStatus) {
		this.generationStatus = generationStatus;
	}

	@Override
	public String toString() {
		return "PrepaidStatementPlanDetails [toLot=" + toLot + ", billingDay=" + billingDay
				+ ", printDay=" + printDay + ", generationStatus=" + generationStatus + "]";
	}
}
