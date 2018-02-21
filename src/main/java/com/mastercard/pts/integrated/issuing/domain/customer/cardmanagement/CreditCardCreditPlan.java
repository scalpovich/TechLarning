package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
@Component
public class CreditCardCreditPlan implements HasCodeAndDescription {
	
	private String creditPlanCode;
	private String description;	
	private String abbreviation;	
	private String paymentDate;	
	private String paymentDueDateDays;
	private String unpaidDate;	
	private String unpaidDateDays;
	private String transactionRulePlan;	
	private String curreny;	
	private String minimumDue;	
	private String totalDue;	
	private String paymentPriorityPlan;	
	private String allowedPercentage;
	
	private static final String PAYMENT_DATE = "PAYMENT_DATE";

	private static final String UNPAID_DATE = "UNPAID_DATE";
	
	private static final String CURRENCY = "CURRENCY";
	
	public static CreditCardCreditPlan createWithProvider(KeyValueProvider provider)
	{
		CreditCardCreditPlan testdata = new CreditCardCreditPlan();	
		testdata.setCreditPlanCode(MiscUtils.generateRandomNumberBetween2Number(100, 999));
		testdata.setDescription(ConstantData.GENERIC_DESCRIPTION);
		testdata.setAbbreviation(MiscUtils.generate10CharAlphaNumeric());
		testdata.setPaymentDate(provider.getString(PAYMENT_DATE));
		testdata.setPaymentDueDateDays(MiscUtils.generateRandomNumberBetween2Number(1, 20));
		testdata.setUnpaidDate(provider.getString(UNPAID_DATE));
		testdata.setUnpaidDateDays(MiscUtils.generateRandomNumberBetween2Number(1, 20));
		testdata.setCurreny(provider.getString(CURRENCY));
		testdata.setMinimumDue(MiscUtils.generateRandomNumberBetween2Number(1000, 5000));
		testdata.setTotalDue(MiscUtils.generateRandomNumberBetween2Number(10000, 50000));
		testdata.setAllowedPercentage(MiscUtils.generateRandomNumberBetween2Number(10, 100));
		return testdata;	
	}
	
	public String buildAbbreviationAndCode() {
		return String.format("%s [%s]", getAbbreviation(), getCode());
	}

	public String getTransactionRulePlan() {
		return transactionRulePlan;
	}
	public void setTransactionRulePlan(String transactionRulePlan) {
		this.transactionRulePlan = transactionRulePlan;
	}
	
	public String getPaymentDueDateDays() {
		return paymentDueDateDays;
	}

	public void setPaymentDueDateDays(String paymentDueDateDays) {
		this.paymentDueDateDays = paymentDueDateDays;
	}

	public String getUnpaidDateDays() {
		return unpaidDateDays;
	}

	public void setUnpaidDateDays(String unpaidDateDays) {
		this.unpaidDateDays = unpaidDateDays;
	}	
	
	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getUnpaidDate() {
		return unpaidDate;
	}

	public void setUnpaidDate(String unpaidDate) {
		this.unpaidDate = unpaidDate;
	}

	public String getCurreny() {
		return curreny;
	}

	public void setCurreny(String curreny) {
		this.curreny = curreny;
	}

	public String getMinimumDue() {
		return minimumDue;
	}

	public void setMinimumDue(String minimumDue) {
		this.minimumDue = minimumDue;
	}

	public String getTotalDue() {
		return totalDue;
	}

	public void setTotalDue(String totalDue) {
		this.totalDue = totalDue;
	}

	public String getPaymentPriorityPlan() {
		return paymentPriorityPlan;
	}

	public void setPaymentPriorityPlan(String paymentPriorityPlan) {
		this.paymentPriorityPlan = paymentPriorityPlan;
	}

	public String getAllowedPercentage() {
		return allowedPercentage;
	}

	public void setAllowedPercentage(String allowedPercentage) {
		this.allowedPercentage = allowedPercentage;
	}

	@Override
	public String getCode() {
		return getCreditPlanCode();
	}
	
	public String getCreditPlanCode() {
		return creditPlanCode;
	}

	public void setCreditPlanCode(String creditPlanCode) {
		this.creditPlanCode = creditPlanCode;
	}

	@Override
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
    
	@Override
	public String toString() {
		return "CreditCardCreditPlan [creditPlanCode;=" + creditPlanCode + ", abbreviation="+ abbreviation +  ", description="+ description 
				+ ", paymentDate;=" + paymentDate + ", unpaidDate="+ unpaidDate +  ", transactionRulePlan="+ transactionRulePlan + 
				", curreny="+ description + ", minimumDue;=" + minimumDue + ", totalDue="+ totalDue +  ", paymentPriorityPlan="+ paymentPriorityPlan 
				+ ", allowedPercentage="+ allowedPercentage +"]";
	}
}
