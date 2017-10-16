package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

@Component
public class HSMNetworkKeys {

	public String NetworkInterface;
	public String SubNetworkID;
	public String KeyIndex;
	public String KeyType;
	public String NetworkCryptogram;
	public String ConfirmNetworkCryptogram;
	public String NetworkCryptogramCheckValue;
	public String ConfirmNetworkCryptogramCheckValue;

	public String getNetworkInterface() {
		return NetworkInterface;
	}

	public void setNetworkInterface(String networkInterface) {
		NetworkInterface = networkInterface;
	}

	public String getSubNetworkID() {
		return SubNetworkID;
	}

	public void setSubNetworkID(String subNetworkID) {
		SubNetworkID = subNetworkID;
	}

	public String getKeyIndex() {
		return KeyIndex;
	}

	public void setKeyIndex(String keyIndex) {
		KeyIndex = keyIndex;
	}

	public String getKeyType() {
		return KeyType;
	}

	public void setKeyType(String keyType) {
		KeyType = keyType;
	}

	public String getNetworkCryptogram() {
		return NetworkCryptogram;
	}

	public void setNetworkCryptogram(String networkCryptogram) {
		NetworkCryptogram = networkCryptogram;
	}

	public String getConfirmNetworkCryptogram() {
		return ConfirmNetworkCryptogram;
	}

	public void setConfirmNetworkCryptogram(String confirmNetworkCryptogram) {
		ConfirmNetworkCryptogram = confirmNetworkCryptogram;
	}

	public String getNetworkCryptogramCheckValue() {
		return NetworkCryptogramCheckValue;
	}

	public void setNetworkCryptogramCheckValue(
			String networkCryptogramCheckValue) {
		NetworkCryptogramCheckValue = networkCryptogramCheckValue;
	}

	public String getConfirmNetworkCryptogramCheckValue() {
		return ConfirmNetworkCryptogramCheckValue;
	}

	public void setConfirmNetworkCryptogramCheckValue(
			String confirmNetworkCryptogramCheckValue) {
		ConfirmNetworkCryptogramCheckValue = confirmNetworkCryptogramCheckValue;
	}

}
