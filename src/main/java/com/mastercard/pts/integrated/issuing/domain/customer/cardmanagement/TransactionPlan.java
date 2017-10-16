package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
@Component
public class TransactionPlan implements HasCodeAndDescription {

	private static final String ALL_TRANSACTIONS = "*";

	private String transactionPlanCode;
	
	private String description;
	
	private String productType;
	
	private List<String> assignedTransactions = new ArrayList<>();
	
	public String TransactionType;

	public String getTransactionType() {
		return TransactionType;
	}

	public void setTransactionType(String transactionType) {
		TransactionType = transactionType;
	}
	public static TransactionPlan createWithProvider(DataProvider provider) {
		TransactionPlan plan = provider.getDataBySimpleClassName(TransactionPlan.class);
		plan.setTransactionPlanCode(MiscUtils.generate6CharAlphaNumeric());
		plan.setDescription(ConstantData.GENERIC_DESCRIPTION);
		return plan;
	}
	
	public boolean isAllTransactionsAssigned() {
		return assignedTransactions.size() == 1 && assignedTransactions.contains(ALL_TRANSACTIONS);
	}

	@Override
	public String getCode() {
		return getTransactionPlanCode();
	}
	
	public String getTransactionPlanCode() {
		return transactionPlanCode;
	}

	public void setTransactionPlanCode(String transactionPlanCode) {
		this.transactionPlanCode = transactionPlanCode;
	}

	@Override
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public List<String> getAssignedTransactions() {
		return assignedTransactions;
	}

	public void setAssignedTransactions(List<String> transactions) {
		this.assignedTransactions = transactions;
	}

	@Override
	public String toString() {
		return MiscUtils.toString(this);
	}
}
