package com.mastercard.pts.integrated.issuing.domain.agent.inventory;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;

public class Order{
	private static final String BRANCH_ID = "BRANCH_ID";
	private static final String DEVICE_TYPE = "DEVICE_TYPE";
	private static final String QUANTITY_ORDERED = "QUANTITY_ORDERED";
	
	private String branchId;
	private String program;
	private String deviceType;
	private String quantityOrdered;
	private String memo;
	private String orderNumber;
	
	public static Order createWithProvider(KeyValueProvider provider) {
		Order plan = new Order();
		plan.setBranchId(provider.getString(BRANCH_ID));
		plan.setDeviceType(provider.getString(DEVICE_TYPE));
		plan.setQuantityOrdered(provider.getString(QUANTITY_ORDERED));
		plan.setMemo(ConstantData.GENERIC_DESCRIPTION);
		return plan;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	
	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(String quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "Order [branchId=" + branchId + ", program=" + program
				+ ", deviceType=" + deviceType + ", quantityOrdered="
				+ quantityOrdered + ", memo=" + memo + "]";
	}
}
