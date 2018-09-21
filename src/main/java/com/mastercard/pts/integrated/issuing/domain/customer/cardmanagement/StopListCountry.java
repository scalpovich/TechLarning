
package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;

public class StopListCountry {
     
	
	String stopListReason;
	String stopListReasonDescription;
	String stoplistCountry;
	
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
		stopListCountry.setStoplistCountry(provider.getString("Stoplist_Withdraw_Country"));
		stopListCountry.setStopListReason(provider.getString("Stop_List_Country_Reason"));
		stopListCountry.setStopListReasonDescription(CustomUtils.randomString(8));
		return stopListCountry;
	}

}
