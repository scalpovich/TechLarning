package com.mastercard.pts.integrated.issuing.domain.customer.distribution;

import java.time.LocalDate;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;

public class Dispatch {
	
	private static final String AGENCY_XL = "AGENCY";
	private static final String BRANCH_ID = "BRANCH_ID";
	private static final String COURIER_AGENCY = "COURIER_AGENCY";
	private static final String QUANTITY_TO_DISPATCH = "QUANTITY_TO_DISPATCH";

	private String agency;
	private String branchId;
	private String orderNumber;
	private String courierAgency;
	private String quantityToDispatch;
	private String memo;
	private LocalDate effectiveDate;
	private LocalDate endDate;
	private String lastCardPackId;
	private String productType;
	
	public static Dispatch createWithProvider(KeyValueProvider provider) {
		Dispatch plan = new Dispatch();
		plan.setEffectiveDate(LocalDate.now().minusDays(1));
	//	plan.setEffectiveDate(LocalDate.now().plusDays(0));
		plan.setEndDate(plan.getEffectiveDate().plusDays(5));
		plan.setAgency(provider.getString(AGENCY_XL));
		plan.setBranchId(provider.getString(BRANCH_ID));
		plan.setCourierAgency(provider.getString(COURIER_AGENCY));
		plan.setQuantityToDispatch(provider.getString(QUANTITY_TO_DISPATCH));
		plan.setMemo(ConstantData.GENERIC_DESCRIPTION);
		return plan;
	}
	
	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getLastCardPackId() {
		return lastCardPackId;
	}

	public void setLastCardPackId(String lastCardPackId) {
		this.lastCardPackId = lastCardPackId;
	}

	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branch) {
		this.branchId = branch;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getCourierAgency() {
		return courierAgency;
	}
	public void setCourierAgency(String courierAgency) {
		this.courierAgency = courierAgency;
	}
	public String getQuantityToDispatch() {
		return quantityToDispatch;
	}
	public void setQuantityToDispatch(String quantityToDispatch) {
		this.quantityToDispatch = quantityToDispatch;
	}
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

	@Override
	public String toString() {
		return "Dispatch [agency=" + agency + ", branch=" + branchId
				+ ", orderNumber=" + orderNumber + ", courierAgency="
				+ courierAgency + ", quantityToDispatch=" + quantityToDispatch
				+ ", memo=" + memo + ", effectiveDate=" + effectiveDate
				+ ", endDate=" + endDate + "]";
	}
	
}
