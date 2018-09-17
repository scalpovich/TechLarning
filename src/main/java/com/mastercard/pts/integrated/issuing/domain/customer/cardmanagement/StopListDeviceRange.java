
package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;

public class StopListDeviceRange {
     
	
	private String stopListReason;
	private String stopListReasonDescription;
	
	private static final String STOPLIST_REASON="Device_Range_Stop_List_Reason";
	
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

	public static StopListDeviceRange createWithProvider(KeyValueProvider provider) {
		StopListDeviceRange stopListDevice=new StopListDeviceRange();
		stopListDevice.setStopListReason(provider.getString(STOPLIST_REASON));
		stopListDevice.setStopListReasonDescription(CustomUtils.randomString(8));
		return stopListDevice;
	}

}
