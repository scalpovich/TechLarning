
package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;

public class WithdrawDeviceRange {
     
	
	String withdrawReason;
	String withdrawDescription;
	
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

	public static WithdrawDeviceRange createWithProvider(KeyValueProvider provider) {
		WithdrawDeviceRange withdrawDeviceRange=new WithdrawDeviceRange();
		withdrawDeviceRange.setWithdrawReason(provider.getString("Device_Range_Withdraw_Reason"));
		withdrawDeviceRange.setWithdrawDescription(CustomUtils.randomString(8));
		return withdrawDeviceRange;
	}

}
