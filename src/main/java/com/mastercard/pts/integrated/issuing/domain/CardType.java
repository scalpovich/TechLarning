package com.mastercard.pts.integrated.issuing.domain;

import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class CardType {

	public static final String EMV = "EMV Card [2]";
	public static final String MSR = "Magnetic Stripe Card [1]";
	public static final String STATIC_VIRTUAL = "Static Virtual Card [7]";
	public static final String NFC_MSR = "Physical NFC Device - Mag Stripe Paypass [3]";
	public static final String NFC_EMV = "Physical NFC Device - EMV Paypass [4]";
	public static final String LIMITED_VALIDITY = "Limited Validity Virtual Card [8]";
	public static final String ATM_ADMIN = "ATM Admin Card [9]";
	public static final String MOBILE = "Mobile [6]";
	public static final String NFC_PAYPASS = "Physical NFC Device - Paypass [5]";

	private CardType() {
	}

	public static String fromShortName(String name) {
		return MiscUtils.getConstantStringFromClassByPefixMatch(CardType.class, name);
	}

}
