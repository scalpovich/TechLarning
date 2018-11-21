
package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;

public class WithdrawCountry {
     
	
	private String withdrawReason;
	private String withdrawDescription;
	private String withdrawCountry;
	
	private static final String STOPLIST_WITHDRAW_COUNTRY="STOPLIST_WITHDRAW_COUNTRY";
	private static final String WITHDRAW_COUNTRY_REASON="WITHDRAW_COUNTRY_REASON";

	
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
		withdrawCountry.setWithdrawCountry(provider.getString(STOPLIST_WITHDRAW_COUNTRY));
		withdrawCountry.setWithdrawReason(provider.getString(WITHDRAW_COUNTRY_REASON));
		withdrawCountry.setWithdrawDescription(CustomUtils.randomString(8));
		return withdrawCountry;
	}

}
