package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class MarketingMessagePlan {

	public String MarketingMessagePlan;

	public String MarketingMsgEffectiveDate;

	public String MarketingMsgEndDate;

	public String getMarketingMessagePlan() {
		return MarketingMessagePlan;
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

	public void setMarketingMessagePlan(String marketingMessagePlan) {
		MarketingMessagePlan = marketingMessagePlan;
	}

	public static MarketingMessagePlan marketingmessageprovider() {
		MarketingMessagePlan marketmsg = new MarketingMessagePlan();
		marketmsg.setMarketingMsgEffectiveDate(DateUtils.getDateinDDMMYYYY());
		marketmsg.setMarketingMsgEndDate(MapUtils.fnGetInputDataFromMap("EndDate"));
		return marketmsg;

	}
}
