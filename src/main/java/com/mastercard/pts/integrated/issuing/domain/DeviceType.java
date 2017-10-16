package com.mastercard.pts.integrated.issuing.domain;

import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class DeviceType {

	public static final String MAGNETIC_STRIPE_CARD = "Magnetic Stripe Card [1]";
	
	public static final String EMV_CARD = "EMV Card [2]";
	
	public static final String STATIC_VIRTUAL_CARD = "Static Virtual Card [7]";
	
	public static final String VIRTUAL_CARD = "Static Virtual Card [7]";
	
	public static final String PHYSICAL_NFC_DEVICE_MAG_STRIPE_PAYPASS = "Physical NFC Device - Mag Stripe Paypass [3]";
	
	public static final String LIMITED_VALIDITY_VIRTUAL_CARD = "Limited Validity Virtual Card [8]";
	
	public static final String PHYSICAL_NFC_DEVICE_EMV_PAYPASS = "Physical NFC Device - EMV Paypass [4]";
	
	public static final String MOBILE = "Mobile [6]";
	
	public static final String PHYSICAL_NFC_DEVICE_PAYPASS = "Physical NFC Device - Paypass [5]";
	
	public static final String ATM_ADMIN_CARD = "ATM Admin Card [9]";
	
	private DeviceType() {}
	
	/**
	 * Returns device type in application format by its short name.
	 * @param prefix of full device type name, e.g. "Magnetic Stripe" or "EMV card"
	 * @return device type in application format, e.g. "Magnetic Stripe Card [1]"
	 */
	public static String fromShortName(String name) {
		return MiscUtils.getConstantStringFromClassByPefixMatch(DeviceType.class, name);
	}
}
