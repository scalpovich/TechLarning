package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

@Component
public class HSMDeviceKeys {

	public String binStart;
	public String binEnd;
	public String generationMethodDDwn;
	public String decimalizationTable;
	public String pinLength;
	public String pVVOffset;
	public String pVKOffset;
	public String pINValidationData;
	public String confirmValidationData;
	public String pinVerificationKey;
	public String confirmPINVerificationKey;
	public String pinVerificationKeyCheck;
	public String cvvOffsetOnTrack;
	public String cvkACryptogram;
	public String confirmACryptogram;
	public String cvkAKeyCheck;
	public String confirmAKeyCheck;
	public String cvkBCryptogram;
	public String confirmBCryptogram;
	public String cvkBKeyCheck;
	public String confirmBKeyCheck;
	public String cvv3Cryptogram;
	public String confirmCVV3Cryptogram;
	public String cvv3KeyCheckvalue;
	public String confirmCVV3KeyCheckValue;
	public String atcOffsetOnTrack;
	public String unOffsetOnTrack;
	public String cvc3OffsetOnTrack;
	public String componentType;
	
	public String getcomponentType() {
		return componentType;
	}

	public void setComponentType(String component) {
		componentType = component;
	}

	public String getBinStart() {
		return binStart;
	}

	public void setBinStart(String binStart) {
		this.binStart = binStart;
	}

	public String getBinEnd() {
		return binEnd;
	}

	public void setBinEnd(String binEnd) {
		this.binEnd = binEnd;
	}

	public String getGenerationMethodDDwn() {
		return generationMethodDDwn;
	}

	public void setGenerationMethodDDwn(String generationMethodDDwn) {
		this.generationMethodDDwn = generationMethodDDwn;
	}

	public String getDecimalizationTable() {
		return decimalizationTable;
	}

	public void setDecimalizationTable(String decimalizationTable) {
		this.decimalizationTable = decimalizationTable;
	}

	public String getPINlength() {
		return pinLength;
	}

	public void setPINlength(String pINlength) {
		this.pinLength = pINlength;
	}

	public String getPVVOffset() {
		return pVVOffset;
	}

	public void setPVVOffset(String pVVOffset) {
		this.pVVOffset = pVVOffset;
	}

	public String getPVKOffset() {
		return pVKOffset;
	}

	public void setPVKOffset(String pVKOffset) {
		this.pVKOffset = pVKOffset;
	}

	public String getPINValidationData() {
		return pINValidationData;
	}

	public void setPINValidationData(String pINValidationData) {
		this.pINValidationData = pINValidationData;
	}

	public String getConfirmValidationData() {
		return confirmValidationData;
	}

	public void setConfirmValidationData(String confirmValidationData) {
		this.confirmValidationData = confirmValidationData;
	}

	public String getPINVerificationKey() {
		return pinVerificationKey;
	}

	public void setPINVerificationKey(String pin) {
		this.pinVerificationKey = pin;
	}

	public String getConfirmPINVerificationKey() {
		return confirmPINVerificationKey;
	}

	public void setConfirmPINVerificationKey(String confirmPINVerificationKey) {
		this.confirmPINVerificationKey = confirmPINVerificationKey;
	}

	public String getPINVerificationKeyCheck() {
		return pinVerificationKeyCheck;
	}

	public void setPINVerificationKeyCheck(String pINVerificationKeyCheck) {
		this.pinVerificationKeyCheck = pINVerificationKeyCheck;
	}

	public String getCVVOffsetOnTrack() {
		return cvvOffsetOnTrack;
	}

	public void setCVVOffsetOnTrack(String cVVOffsetOnTrack) {
		this.cvvOffsetOnTrack = cVVOffsetOnTrack;
	}

	public String getCVKACryptogram() {
		return cvkACryptogram;
	}

	public void setCVKACryptogram(String cVKACryptogram) {
		this.cvkACryptogram = cVKACryptogram;
	}

	public String getConfirmACryptogram() {
		return confirmACryptogram;
	}

	public void setConfirmACryptogram(String confirmACrypto) {
		this.confirmACryptogram = confirmACrypto;
	}

	public String getCVKAKeyCheck() {
		return cvkAKeyCheck;
	}

	public void setCVKAKeyCheck(String cvkAKeyCheck) {
		this.cvkAKeyCheck = cvkAKeyCheck;
	}

	public String getConfirmAKeyCheck() {
		return confirmAKeyCheck;
	}

	public void setConfirmAKeyCheck(String keyAConfCheck) {
		this.confirmAKeyCheck = keyAConfCheck;
	}

	public String getCVKBCryptogram() {
		return cvkBCryptogram;
	}

	public void setCVKBCryptogram(String cVKBCryptogram) {
		this.cvkBCryptogram = cVKBCryptogram;
	}

	public String getConfirmBCryptogram() {
		return confirmBCryptogram;
	}

	public void setConfirmBCryptogram(String confirmBCryptogram) {
		this.confirmBCryptogram = confirmBCryptogram;
	}

	public String getCVKBKeyCheck() {
		return cvkBKeyCheck;
	}

	public void setCVKBKeyCheck(String keyCheckCVKB) {
		this.cvkBKeyCheck = keyCheckCVKB;
	}

	public String getConfirmBKeyCheck() {
		return confirmBKeyCheck;
	}

	public void setConfirmBKeyCheck(String confirmBKeyCheck) {
		this.confirmBKeyCheck = confirmBKeyCheck;
	}

	public String getCVV3Cryptogram() {
		return cvv3Cryptogram;
	}

	public void setCVV3Cryptogram(String cVV3Cryptogram) {
		this.cvv3Cryptogram = cVV3Cryptogram;
	}

	public String getConfirmCVV3Cryptogram() {
		return confirmCVV3Cryptogram;
	}

	public void setConfirmCVV3Cryptogram(String confirmCVV3Cryptogram) {
		this.confirmCVV3Cryptogram = confirmCVV3Cryptogram;
	}

	public String getCVV3KeyCheckvalue() {
		return cvv3KeyCheckvalue;
	}

	public void setCVV3KeyCheckvalue(String cVV3KeyCheckvalue) {
		this.cvv3KeyCheckvalue = cVV3KeyCheckvalue;
	}

	public String getConfirmCVV3KeyCheckValue() {
		return confirmCVV3KeyCheckValue;
	}

	public void setConfirmCVV3KeyCheckValue(String conCVV3KeyCheckValue) {
		this.confirmCVV3KeyCheckValue = conCVV3KeyCheckValue;
	}

	public String getATCOffsetOnTrack() {
		return atcOffsetOnTrack;
	}

	public void setATCOffsetOnTrack(String aTCOffsetOnTrack) {
		this.atcOffsetOnTrack = aTCOffsetOnTrack;
	}

	public String getUNOffsetOnTrack() {
		return unOffsetOnTrack;
	}

	public void setUNOffsetOnTrack(String uNOffsetOnTrack) {
		this.unOffsetOnTrack = uNOffsetOnTrack;
	}

	public String getCVC3OffsetOnTrack() {
		return cvc3OffsetOnTrack;
	}

	public void setCVC3OffsetOnTrack(String cVC3OffsetOnTrack) {
		this.cvc3OffsetOnTrack = cVC3OffsetOnTrack;
	}

}
