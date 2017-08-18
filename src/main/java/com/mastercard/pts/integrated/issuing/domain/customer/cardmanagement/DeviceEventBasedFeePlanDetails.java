package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.time.LocalDate;

public class DeviceEventBasedFeePlanDetails {
	
	private LocalDate effectiveDate;
	private LocalDate endDate;
	
	public static DeviceEventBasedFeePlanDetails generateDynamicTestData(){
		DeviceEventBasedFeePlanDetails plan = new DeviceEventBasedFeePlanDetails();
		plan.setEffectiveDate(LocalDate.now().plusDays(1));
		plan.setEndDate(plan.getEffectiveDate().plusDays(5));
		return plan;
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
	

	}