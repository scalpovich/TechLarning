
package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;

public class StopListDevice {
     
	private final static String STOP_LIST_REASON="Stop_List_Reason";
	private String stopListReason;
	private String stopListReasonDescription;
	
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

	public static StopListDevice createWithProvider(KeyValueProvider provider) {
		StopListDevice stopListDevice=new StopListDevice();
		stopListDevice.setStopListReason(provider.getString(STOP_LIST_REASON));
		stopListDevice.setStopListReasonDescription(CustomUtils.randomString(8));
		return stopListDevice;
	}

}