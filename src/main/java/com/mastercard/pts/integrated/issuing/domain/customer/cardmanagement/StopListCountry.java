
package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;

public class StopListCountry {
     
	
	private String stopListReason;
	private String stopListReasonDescription;
	private String stoplistCountry;
	
	private static final String STOPLIST_WITHDRAW_COUNTRY="STOPLIST_WITHDRAW_COUNTRY";
	
	private static final String STOPLIST_COUNTRY_REASON="STOPLIST_COUNTRY_REASON";
		
	public String getStoplistCountry() {
		return stoplistCountry;
	}

	public void setStoplistCountry(String stoplistCountry) {
		this.stoplistCountry = stoplistCountry;
	}

	public String getStopListReason() {
		return stopListReason;
	}

	public void setStopListReason(String stopListReason) {
		this.stopListReason = stopListReason;
	}

	public String getStopListReasonDescription() {
		return stopListReasonDescription;
	}

	public void setStopListReasonDescription(String stopListReasonDescription) {
		this.stopListReasonDescription = stopListReasonDescription;
	}

	public static StopListCountry createWithProvider(KeyValueProvider provider) {
		StopListCountry stopListCountry=new StopListCountry();
		stopListCountry.setStoplistCountry(provider.getString(STOPLIST_WITHDRAW_COUNTRY));
		stopListCountry.setStopListReason(provider.getString(STOPLIST_COUNTRY_REASON));
		stopListCountry.setStopListReasonDescription(CustomUtils.randomString(8));
		return stopListCountry;
	}

}
