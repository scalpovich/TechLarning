package com.mastercard.pts.integrated.issuing.domain;

import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class DeviceStatus {

	public static final String NORMAL = "NORMAL [0]";
	public static final String READY_FOR_SALE = "READY FOR SALE [16]";
	public static final String LOST = "LOST [5]";
	public static final String EXPIRED = "EXPIRED [12]";
	private DeviceStatus() {}
	
	public static String fromShortName(String name) {
		return MiscUtils.getConstantStringFromClassByPefixMatch(DeviceStatus.class, name);
	}
} 
