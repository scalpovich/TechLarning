package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

@Component
public class HighRiskMerchantLocation {

	private String merchantLocationId;
    
	public static HighRiskMerchantLocation getSurchargePlanData() {
		HighRiskMerchantLocation plan = new HighRiskMerchantLocation();		
		return plan;
	}
	
	public String getMerchantLocationId() {
		return merchantLocationId;
	}

	public void setMerchantLocationId(String merchantLocationId) {
		this.merchantLocationId = merchantLocationId;
	}	

}
