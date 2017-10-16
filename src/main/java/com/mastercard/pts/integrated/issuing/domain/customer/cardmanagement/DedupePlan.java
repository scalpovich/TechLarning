package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

@Component
public class DedupePlan {

	public String DedupePlanCode;

	public String getDedupePlanCode() {
		return DedupePlanCode;
	}

	public void setDedupePlanCode(String dedupePlanCode) {
		DedupePlanCode = dedupePlanCode;
	}

}
