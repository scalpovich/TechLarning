package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;

@Component
public class HighRiskMerchantLocation {

	private String merchantLocationId;
	private String merchantLocationDescription;
	private String merchantId;
	private String acquireeId;
	
	public static HighRiskMerchantLocation getHighRiskMerchantLocation(KeyValueProvider provider){
		HighRiskMerchantLocation plan = new HighRiskMerchantLocation();
		String random =  CustomUtils.randomNumbers(5);
		plan.setMerchantLocationId(random);
		plan.setAcquireeId(random);
		plan.setMerchantId(random);
		plan.setMerchantLocationDescription(ConstantData.GENERIC_DESCRIPTION);
		return plan;
	}
		
	public String getMerchantLocationId() {
		return merchantLocationId;
	}

	public void setMerchantLocationId(String merchantLocationId) {
		this.merchantLocationId = merchantLocationId;
	}

	public String getMerchantLocationDescription() {
		return merchantLocationDescription;
	}

	public void setMerchantLocationDescription(String merchantLocationDescription) {
		this.merchantLocationDescription = merchantLocationDescription;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getAcquireeId() {
		return acquireeId;
	}

	public void setAcquireeId(String acquireeId) {
		this.acquireeId = acquireeId;
	}


}
