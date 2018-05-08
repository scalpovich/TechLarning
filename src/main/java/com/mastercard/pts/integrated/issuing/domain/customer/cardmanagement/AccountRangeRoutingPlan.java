package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class AccountRangeRoutingPlan {

	public String fromAccount;
	public String toAccount;
	public String channelRoutingPlan;
	
	public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	public String getToAccount() {
		return toAccount;
	}

	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}

	public String getChannelRoutingPlan() {
		return channelRoutingPlan;
	}

	public void setChannelRoutingPlan(String channelRoutingPlan) {
		this.channelRoutingPlan = channelRoutingPlan;
	}

	public static AccountRangeRoutingPlan channelRoutingPlanDataProvider() {
		AccountRangeRoutingPlan accountRange= new AccountRangeRoutingPlan();
		accountRange.setFromAccount(MapUtils.fnGetInputDataFromMap("AccountRangeFrom"));
		accountRange.setToAccount(MapUtils.fnGetInputDataFromMap("AccountRangeTo"));		
		return  accountRange;
	}
}


