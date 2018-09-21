
package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;

public class StopListBin {
     
	
	private String stopListReason;
	private String stopListReasonDescription;
	
	private static final String BIN_STOPLIST_REASON="BIN_STOPLIST_REASON";
	
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

	public static StopListBin createWithProvider(KeyValueProvider provider) {
		StopListBin stopListDevice=new StopListBin();
		stopListDevice.setStopListReason(provider.getString(BIN_STOPLIST_REASON));
		stopListDevice.setStopListReasonDescription(CustomUtils.randomString(8));
		return stopListDevice;
	}

}
