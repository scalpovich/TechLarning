
package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;

public class WithdrawBin {
     
	
	private String withdrawReason;
	private String withdrawDescription;
	
	private static String WITHDRAW_BIN_REASON="Withdraw_Bin_Reason";

	
	
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

	public static WithdrawBin createWithProvider(KeyValueProvider provider) {
		WithdrawBin withdrawBin=new WithdrawBin();
		withdrawBin.setWithdrawReason(provider.getString(WITHDRAW_BIN_REASON));
		withdrawBin.setWithdrawDescription(CustomUtils.randomString(8));
		return withdrawBin;
	}

}
