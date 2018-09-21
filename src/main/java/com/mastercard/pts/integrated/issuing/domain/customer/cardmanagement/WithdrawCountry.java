
package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;

public class WithdrawCountry {
     
	
	String withdrawReason;
	String withdrawDescription;
	String withdrawCountry;
	
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
    
	public String getWithdrawCountry() {
		return withdrawCountry;
	}

	public void setWithdrawCountry(String withdrawCountry) {
		this.withdrawCountry = withdrawCountry;
	}

	public static WithdrawCountry createWithProvider(KeyValueProvider provider) {
		WithdrawCountry withdrawCountry=new WithdrawCountry();
		withdrawCountry.setWithdrawCountry(provider.getString("Stoplist_Withdraw_Country"));
		withdrawCountry.setWithdrawReason(provider.getString("Withdraw_Country_Reason"));
		withdrawCountry.setWithdrawDescription(CustomUtils.randomString(8));
		return withdrawCountry;
	}

}
