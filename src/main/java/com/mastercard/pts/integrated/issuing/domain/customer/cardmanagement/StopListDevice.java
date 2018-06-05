package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;

public class StopListDevice {
     
	
	String stopListReason;
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



	String stopListReasonDescription;
	
	

	public static StopListDevice createWithProvider(KeyValueProvider provider) {
		StopListDevice stopListDevice=new StopListDevice();
		stopListDevice.setStopListReason(provider.getString("Stop_List_Reason"));
		stopListDevice.setStopListReasonDescription(CustomUtils.randomString(8));
		return stopListDevice;
	}

}
