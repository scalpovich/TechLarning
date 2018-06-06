package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.time.LocalDate;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
 
public class TransactionFeeWaiverPlan {
	
	private static final String TFWP_FEE_TYPE = "TFWP_FEE_TYPE";
	private static final String TFWP_TRANSACTION_TYPE = "TFWP_TRANSACTION_TYPE";
	private static final String TFWP_TRANSACTION_SOURCE = "TFWP_TRANSACTION_SOURCE";
	private static final String TFWP_TRANSACTION_ORIGIN = "TFWP_TRANSACTION_ORIGIN";
	private static final String TFWP_WAIVER_FREQUENCY = "TFWP_WAIVER_FREQUENCY";
	private static final String TFWP_APPLICABLE_FOR_CYCLES = "TFWP_APPLICABLE_FOR_CYCLES";
	private static final String TFWP_TRANSACTIONS_WAIVED_PER_CYCLE  = "TFWP_TRANSACTIONS_WAIVED_PER_CYCLE";
	private static final String TFWP_CLUB_TRANSACTION_OF_ADD_ON_CARDS = "TFWP_CLUB_TRANSACTION_OF_ADD_ON_CARDS";
	
	private String transactionFeeWaiverPlanCode;  
	
	private String description;
	
	public String getTransactionFeeWaiverPlanCode() {
		return transactionFeeWaiverPlanCode;
	}

	public void setTransactionFeeWaiverPlanCode(String transactionFeeWaiverPlanCode) {
		this.transactionFeeWaiverPlanCode = transactionFeeWaiverPlanCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private LocalDate effectiveDate;

	private LocalDate endDate;
	
	private String feeType;
	
	private String transactionType;
	
	private String transactionSource;
	
	private String transactionOrigin;
	
	private String waiverFrequency;
	
	private String applicableForCycles;
	
	private String transactionsWaivedPerCycle;
	
	private String clubTransactionOfAddOnCards;

	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getTransactionSource() {
		return transactionSource;
	}

	public void setTransactionSource(String transactionSource) {
		this.transactionSource = transactionSource;
	}

	public String getTransactionOrigin() {
		return transactionOrigin;
	}

	public void setTransactionOrigin(String transactionOrigin) {
		this.transactionOrigin = transactionOrigin;
	}

	public String getWaiverFrequency() {
		return waiverFrequency;
	}

	public void setWaiverFrequency(String waiverFrequency) {
		this.waiverFrequency = waiverFrequency;
	}

	public String getApplicableForCycles() {
		return applicableForCycles;
	}

	public void setApplicableForCycles(String applicableForCycles) {
		this.applicableForCycles = applicableForCycles;
	}

	public String getTransactionsWaivedPerCycle() {
		return transactionsWaivedPerCycle;
	}

	public void setTransactionsWaivedPerCycle(String transactionsWaivedPerCycle) {
		this.transactionsWaivedPerCycle = transactionsWaivedPerCycle;
	}

	public String getClubTransactionOfAddOnCards() {
		return clubTransactionOfAddOnCards;
	}

	public void setClubTransactionOfAddOnCards(String clubTransactionOfAddOnCards) {
		this.clubTransactionOfAddOnCards = clubTransactionOfAddOnCards;
	}
	
	public static TransactionFeeWaiverPlan createWithProvider(KeyValueProvider provider) {
		TransactionFeeWaiverPlan plan = new TransactionFeeWaiverPlan();
		plan.setTransactionFeeWaiverPlanCode(CustomUtils.randomNumbers(4));
		plan.setDescription(Constants.GENERIC_DESCRIPTION);
		plan.setEffectiveDate(LocalDate.now().plusDays(1));
		plan.setEndDate(plan.getEffectiveDate().plusDays(60));
		plan.setFeeType(provider.getString(TFWP_FEE_TYPE));
		plan.setTransactionType(provider.getString(TFWP_TRANSACTION_TYPE));
		plan.setTransactionSource(provider.getString(TFWP_TRANSACTION_SOURCE));
		plan.setTransactionOrigin(provider.getString(TFWP_TRANSACTION_ORIGIN));
		plan.setWaiverFrequency(provider.getString(TFWP_WAIVER_FREQUENCY));
		plan.setApplicableForCycles(provider.getString(TFWP_APPLICABLE_FOR_CYCLES));
		plan.setTransactionsWaivedPerCycle(provider.getString(TFWP_TRANSACTIONS_WAIVED_PER_CYCLE));
		plan.setClubTransactionOfAddOnCards(provider.getString(TFWP_CLUB_TRANSACTION_OF_ADD_ON_CARDS));
		return plan;
	}
}
