package com.mastercard.pts.integrated.issuing.domain.agent.inventory;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

public class Status {
	private static final String BRANCH_ID = "BRANCH_ID";
	
	private String branchId;
	private String orderNumber;
	
	public static Status createWithProvider(KeyValueProvider provider) {
		Status plan = new Status();
		plan.setBranchId(provider.getString(BRANCH_ID));
		return plan;
	}
	
	public String getBranchId() {
		return branchId;
	}
	
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	
	public String getOrderNumber() {
		return orderNumber;
	}
	
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	@Override
	public String toString() {
		return "Status [branchId=" + branchId + ", orderNumber=" + orderNumber
				+ "]";
	}
}
