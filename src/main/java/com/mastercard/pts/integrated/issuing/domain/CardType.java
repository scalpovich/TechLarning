package com.mastercard.pts.integrated.issuing.domain;

public class CardType {

	public static final String EMV="EMV Card";
	public static final String MSR="Magnetic Stripe Card";
	public static final String STATIC_VIRTUAL="Static Virtual Card";
	public static final String NFC_MSR="Physical NFC Device - Mag Stripe Paypass";
	public static final String NFC_EMV="Physical NFC Device - EMV Paypass";
	public static final String LIMITED_VALIDITY="Limited Validity Virtual Card";
	public static final String ATM_ADMIN="ATM Admin Card";
	public static final String MOBILE="Mobile";
	public static final String NFC_PAYPASS="Physical NFC Device - Paypass";
	
	private CardType() {}
}
