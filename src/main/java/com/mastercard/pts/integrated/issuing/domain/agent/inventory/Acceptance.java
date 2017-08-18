package com.mastercard.pts.integrated.issuing.domain.agent.inventory;

import java.time.LocalDate;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;

public class Acceptance{
	private static final String BRANCH_ID = "BRANCH_ID";
	private static final String QUANTITY_ORDERED = "QUANTITY_ORDERED";
	
	private LocalDate effectiveDate;
	private LocalDate endDate;
	private String branchId;
	private String quantityOrdered;
	private String memo;
	private String orderNumber;
	
	public static Acceptance createWithProvider(KeyValueProvider provider) {
		Acceptance plan = new Acceptance();
		plan.setEffectiveDate(LocalDate.now().plusDays(0));
		plan.setEndDate(plan.getEffectiveDate().plusDays(5));
		plan.setBranchId(provider.getString(BRANCH_ID));
		plan.setQuantityOrdered(provider.getString(QUANTITY_ORDERED));
		plan.setMemo(ConstantData.GENERIC_DESCRIPTION);
		return plan;
	}
	
	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(String quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}
	
	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
}
