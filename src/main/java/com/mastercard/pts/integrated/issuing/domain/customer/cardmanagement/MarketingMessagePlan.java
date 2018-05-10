package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

@Component
public class MarketingMessagePlan implements HasCodeAndDescription {

	private String marketingMessagePlanCode;
	
	private String productType;
	
	private String description;
	
	private List<MarketingMessageDetails> marketingMessageDetails = new ArrayList<>();

	public String MarketingMsgEffectiveDate;
	public String MarketingMsgEndDate;
	

	public String getMarketingMessagePlan() {
		return marketingMessagePlanCode;
	}

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
	

	public String getMarketingMsgEffectiveDate() {
		return MarketingMsgEffectiveDate;
	}

	public void setMarketingMsgEffectiveDate(String marketingMsgEffectiveDate) {
		MarketingMsgEffectiveDate = marketingMsgEffectiveDate;
	}

	public String getMarketingMsgEndDate() {
		System.out.println(MarketingMsgEndDate);
		return MarketingMsgEndDate;
	}

	public void setMarketingMsgEndDate(String marketingMsgEndDate) {
		System.out.println(marketingMsgEndDate);
		MarketingMsgEndDate = marketingMsgEndDate;
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
	public void setMarketingMessagePlan(String marketingMessagePlan) {
		this.marketingMessagePlanCode = marketingMessagePlan;
	}

	public static MarketingMessagePlan marketingmessageprovider() {
		MarketingMessagePlan marketmsg = new MarketingMessagePlan();
		marketmsg.setMarketingMsgEffectiveDate(DateUtils.getDateinDDMMYYYY());
		marketmsg.setMarketingMsgEndDate(MapUtils.fnGetInputDataFromMap("EndDate"));
		return marketmsg;

	}
}
