package com.mastercard.pts.integrated.issuing.domain;

import com.mastercard.pts.integrated.issuing.utils.MiscUtils;


public class DeviceEventBasedFee {
  	
	public static final String STOLEN = "STOLEN FEE(Stolen Device)";
	public static final String LOST = "LOST FEE(Lost Device )";
	public static final String DAMAGED = "DAMAGED FEE(Device Damaged)";
	public static final String COUNTERFEIT = "COUNTERFEIT FEE(Counterfeit Device )";
	public static final String EMERGENCY = "EMERGENCY FEE(Emergency Replacement)";
	public static final String ERRONEOUS  = "ERRONEOUS FEE(Erroneous Device)";
	public static final String DEVICE_TECHNOLOGY_UPGRADE = "DEVICE TECHNOLOGY UPGRADE FEE(Device Technology Upgrade)";
	public static final String EARLY_RENEWAL = "EARLY RENEWAL FEE(Early Renew Device)";
	public static final String OTHERS = "OTHERS FEE(Others)";
	public static final String FIRST_RENEWAL = "FIRST RENEWAL FEE(Renew Device)";
	public static final String STOPLIST_WITHDRAWAL = "STOPLIST WITHDRAWAL FEE(Stoplist Withdrawal)";
	
	private DeviceEventBasedFee() {}
	
	public static String fromShortName(String name) {
		return MiscUtils.getConstantStringFromClassByPefixMatch(DeviceEventBasedFee.class, name);
	}
} 
