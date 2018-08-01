package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;

public class WithdrawDevice {
     
	private final static String WITHDRAW_REASON="Withdraw_Reason";
	private String withdrawReason;
	private String withdrawDescription;

	public String getWithdrawReason() {
		return withdrawReason;
	}
	
	public void setWithdrawReason(String withdrawReason) {
		this.withdrawReason = withdrawReason;
	}

	public String getWithdrawDescription() {
		return withdrawDescription;
	}

	public void setWithdrawDescription(String withdrawDescription) {
		this.withdrawDescription = withdrawDescription;
	}
	
	public static WithdrawDevice createWithProvider(KeyValueProvider provider) {
		WithdrawDevice withdrawDevice=new WithdrawDevice();
		withdrawDevice.setWithdrawReason(provider.getString(WITHDRAW_REASON));
		withdrawDevice.setWithdrawDescription(CustomUtils.randomString(8));
		return withdrawDevice;
	}

}