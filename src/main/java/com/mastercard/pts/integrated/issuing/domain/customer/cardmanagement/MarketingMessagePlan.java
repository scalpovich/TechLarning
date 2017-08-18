package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.util.ArrayList;
import java.util.List;

import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class MarketingMessagePlan implements HasCodeAndDescription {

	private String marketingMessagePlanCode;
	
	private String productType;
	
	private String description;
	
	private List<MarketingMessageDetails> marketingMessageDetails = new ArrayList<>();

	@Override
	public String getCode() {
		return getMarketingMessagePlanCode();
	}
	
	public String getMarketingMessagePlanCode() {
		return marketingMessagePlanCode;
	}

	public void setMarketingMessagePlanCode(String marketingMessagePlanCode) {
		this.marketingMessagePlanCode = marketingMessagePlanCode;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	@Override
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<MarketingMessageDetails> getMarketingMessageDetails() {
		return marketingMessageDetails;
	}

	public void setMarketingMessageDetails(
			List<MarketingMessageDetails> marketingMessageDetails) {
		this.marketingMessageDetails = marketingMessageDetails;
	}
	
	public static MarketingMessagePlan generateDynamicTestData(){
		MarketingMessagePlan plan = new MarketingMessagePlan();
		plan.setMarketingMessagePlanCode(MiscUtils.generate10CharAlphaNumeric());
		plan.setDescription(ConstantData.GENERIC_DESCRIPTION);
		return plan;
	}
}
