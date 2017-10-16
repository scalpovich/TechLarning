package com.mastercard.pts.integrated.issuing.domain.helpdesk;

import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class ServiceCode {
	public static final String ACTIVATE_DEVICE = "Activate Device [108]";
	public static final String ACTIVATE_PAIRED_DEVICE = "Activate Paired Device [314]";
	public static final String ADD_CALL_NOTES = "Add Call Notes [456]";
	public static final String ADD_ON_CARD = "Add-on Card Request [102]";
	public static final String ANNUAL_FEE_WAIVER = "Annual Fee Waiver Request [205]";
	public static final String BLOCK_DEVICE = "Block Device [111]";
	public static final String CANCEL_PIN = "Cancel Pin Request [224]";
	public static final String CARD_DISPATCH_QUERY = "Card Dispatch Query [202]";
	public static final String CHANGE_ADDRESS_REQUEST = "Change Address Request [104]";
	public static final String CLIENT_PROFILE_UPDATE = "Client Profile Update [457]";
	public static final String CLIENT_REGISTRATION = "Client Registration [458]";
	public static final String DELINK_WALLET = "De-Link Wallet [222]";
	public static final String DEVICE_CLOSURE = "Device Closure [402]";
	public static final String DO_NOT_CALL_REG = "Do Not Call Register Request [106]";
	public static final String E_COMMERCE_ACTIVATION = "E-commerce Activation/Deactivation [304]";
	public static final String EMAIL_CHANGE_REQUEST = "Email/SMS Alert Change Request [477]";
	public static final String INSTANT_REPLACEMENT_DEVICE = "Instant Replacement Device [150]";
	public static final String INTERNATIONAL_USE_ALLOW = "International Use Allow/Disallow [400]";
	public static final String ISSUE_AND_REISSUE_TPIN = "Issue and Reissue TPIN [216]";
	public static final String LINK_CARD_QUERY = "Link Card Query [203]";
	public static final String LINK_WALLECT_TO_DEVICE = "Link Wallet to Device [411]";
	public static final String MAILING_ADDRESS_PREFERENCE = "Mailing Address Preference Request [107]";
	public static final String MASTERCARD_MONEYSEND = "MasterCard MoneySend Initiation [301]";
	public static final String PIN_REQUEST = "Pin Request [305]";
	public static final String REDEMPTION_INQUIRY = "Redemption Inquiry [208]";
	public static final String REPLACE_UPGRADE_DEVICE = "Replace / Upgrade Device Request [303]";
	public static final String RESET_PIN_RETRY_COUNTER = "Reset Pin Retry Counter [109]";
	public static final String REWARD_RECONFIGURATION_REQUEST = "Reward Reconfiguration Request [209]";
	public static final String STOP_RENEWAL = "Stop Renewal [405]";
	public static final String STOP_REPLACEMENT = "Stop Replacement [403]";
	public static final String STOP_LIST_DEVICE = "Stop list Device [220]";
	public static final String LIMITED_VALIDATION_VIRTUAL_DEVICE = "Supplementary/Limited validity virtual Device [307]";
	public static final String UNBLOCK_DEVICE = "Unblock Device [116]";
	public static final String VIRTUAL_DEVICE_REQUEST = "Virtual Device Request [306]";
	public static final String WITHDRAW_DEVICE_FROM_STOP_LIST = "Withdraw Device from Stop-list [221]";
	public static final String CURRENCY_SETUP = "Currency Setup [312]";

	private ServiceCode() {
	}

	/**
	 * @param Service
	 *            Code, e.g. "Activate Paired Device"
	 * @return Service Code as in the dropdown e.g. "Activate Paired Device
	 *         [314]"
	 */
	public static String fromShortName(String name) {
		return MiscUtils.getConstantStringFromClassByPefixMatch(ServiceCode.class, name);
	}

}
