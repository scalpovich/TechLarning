package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class AccountRangeRoutingPlan {

	private String fromAccount;
	private String toAccount;
	private String channelRoutingPlan;
	
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
	
	public static AccountRangeRoutingPlan channelRoutingPlanDataProvider(Device device){
		AccountRangeRoutingPlan accountRange= new AccountRangeRoutingPlan();
		accountRange.setFromAccount(device.getWalletNumber().substring(0, 9)+ ConstantData.ZERO_ZERO);
		accountRange.setToAccount(device.getWalletNumber().substring(0, 9)  + ConstantData.NINE_NINE);
		return  accountRange;
	}
}


