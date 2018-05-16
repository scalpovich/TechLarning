package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

public class RuPaySettlementBIN implements HasCodeAndDescription {

	private static final String DEVICE_BIN = "DEVICE_BIN";
	private static final String RUPAY_PRODUCT_CODE = "RUPAY_PRODUCT_CODE";
	private static final String SETTLEMENT_BIN = "SETTLEMENT_BIN";
	private static final String PARTICIPANT_ID = "PARTICIPANT_ID";

	private String deviceBIN;
	private String description;
	private String ruPayProductCode;
	private String settlementBIN;
	private String participantID;

	public String getRuPayProductCode() {
		return ruPayProductCode;
	}

	public void setRuPayProductCode(String ruPayProductCode) {
		this.ruPayProductCode = ruPayProductCode;
	}

	public String getSettlementBIN() {
		return settlementBIN;
	}

	public void setSettlementBIN(String settlementBIN) {
		this.settlementBIN = settlementBIN;
	}

	public String getParticipantID() {
		return participantID;
	}

	public void setParticipantID(String participantID) {
		this.participantID = participantID;
	}

	public void setDeviceBIN(String deviceBIN) {
		this.deviceBIN = deviceBIN;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDeviceBIN() {
		return deviceBIN;
	}

	@Override
	public String getCode() {
		return getDeviceBIN();
	}

	@Override
	public String getDescription() {
		return description;
	}

	public static RuPaySettlementBIN createWithProvider(
			KeyValueProvider provider) {
		RuPaySettlementBIN ruPayBIN = new RuPaySettlementBIN();
		ruPayBIN.setDeviceBIN(provider.getString(DEVICE_BIN));
		ruPayBIN.setParticipantID(provider.getString(PARTICIPANT_ID));
		ruPayBIN.setRuPayProductCode(provider.getString(RUPAY_PRODUCT_CODE));
		ruPayBIN.setSettlementBIN(provider.getString(SETTLEMENT_BIN));
		return ruPayBIN;
	}

}
