package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

@Component
public class HSMDeviceKeys {

	public String BinStart;
	public String BinEnd;
	public String GenerationMethodDDwn;
	public String DecimalizationTable;
	public String PINlength;
	public String PVVOffset;
	public String PVKOffset;
	public String PINValidationData;
	public String ConfirmValidationData;
	public String PINVerificationKey;
	public String ConfirmPINVerificationKey;
	public String PINVerificationKeyCheck;
	public String CVVOffsetOnTrack;
	public String CVKACryptogram;
	public String ConfirmACryptogram;
	public String CVKAKeyCheck;
	public String ConfirmAKeyCheck;
	public String CVKBCryptogram;
	public String ConfirmBCryptogram;
	public String CVKBKeyCheck;
	public String ConfirmBKeyCheck;
	public String CVV3Cryptogram;
	public String ConfirmCVV3Cryptogram;
	public String CVV3KeyCheckvalue;
	public String ConfirmCVV3KeyCheckValue;
	public String ATCOffsetOnTrack;
	public String UNOffsetOnTrack;
	public String CVC3OffsetOnTrack;
	public String ComponentType;
	
	public String getComponentType() {
		return ComponentType;
	}

	public void setComponentType(String componentType) {
		ComponentType = componentType;
	}

	public String getBinStart() {
		return BinStart;
	}

	public void setBinStart(String binStart) {
		BinStart = binStart;
	}

	public String getBinEnd() {
		return BinEnd;
	}

	public void setBinEnd(String binEnd) {
		BinEnd = binEnd;
	}

	public String getGenerationMethodDDwn() {
		return GenerationMethodDDwn;
	}

	public void setGenerationMethodDDwn(String generationMethodDDwn) {
		GenerationMethodDDwn = generationMethodDDwn;
	}

	public String getDecimalizationTable() {
		return DecimalizationTable;
	}

	public void setDecimalizationTable(String decimalizationTable) {
		DecimalizationTable = decimalizationTable;
	}

	public String getPINlength() {
		return PINlength;
	}

	public void setPINlength(String pINlength) {
		PINlength = pINlength;
	}

	public String getPVVOffset() {
		return PVVOffset;
	}

	public void setPVVOffset(String pVVOffset) {
		PVVOffset = pVVOffset;
	}

	public String getPVKOffset() {
		return PVKOffset;
	}

	public void setPVKOffset(String pVKOffset) {
		PVKOffset = pVKOffset;
	}

	public String getPINValidationData() {
		return PINValidationData;
	}

	public void setPINValidationData(String pINValidationData) {
		PINValidationData = pINValidationData;
	}

	public String getConfirmValidationData() {
		return ConfirmValidationData;
	}

	public void setConfirmValidationData(String confirmValidationData) {
		ConfirmValidationData = confirmValidationData;
	}

	public String getPINVerificationKey() {
		return PINVerificationKey;
	}

	public void setPINVerificationKey(String pINVerificationKey) {
		PINVerificationKey = pINVerificationKey;
	}

	public String getConfirmPINVerificationKey() {
		return ConfirmPINVerificationKey;
	}

	public void setConfirmPINVerificationKey(String confirmPINVerificationKey) {
		ConfirmPINVerificationKey = confirmPINVerificationKey;
	}

	public String getPINVerificationKeyCheck() {
		return PINVerificationKeyCheck;
	}

	public void setPINVerificationKeyCheck(String pINVerificationKeyCheck) {
		PINVerificationKeyCheck = pINVerificationKeyCheck;
	}

	public String getCVVOffsetOnTrack() {
		return CVVOffsetOnTrack;
	}

	public void setCVVOffsetOnTrack(String cVVOffsetOnTrack) {
		CVVOffsetOnTrack = cVVOffsetOnTrack;
	}

	public String getCVKACryptogram() {
		return CVKACryptogram;
	}

	public void setCVKACryptogram(String cVKACryptogram) {
		CVKACryptogram = cVKACryptogram;
	}

	public String getConfirmACryptogram() {
		return ConfirmACryptogram;
	}

	public void setConfirmACryptogram(String confirmACryptogram) {
		ConfirmACryptogram = confirmACryptogram;
	}

	public String getCVKAKeyCheck() {
		return CVKAKeyCheck;
	}

	public void setCVKAKeyCheck(String cVKAKeyCheck) {
		CVKAKeyCheck = cVKAKeyCheck;
	}

	public String getConfirmAKeyCheck() {
		return ConfirmAKeyCheck;
	}

	public void setConfirmAKeyCheck(String confirmAKeyCheck) {
		ConfirmAKeyCheck = confirmAKeyCheck;
	}

	public String getCVKBCryptogram() {
		return CVKBCryptogram;
	}

	public void setCVKBCryptogram(String cVKBCryptogram) {
		CVKBCryptogram = cVKBCryptogram;
	}

	public String getConfirmBCryptogram() {
		return ConfirmBCryptogram;
	}

	public void setConfirmBCryptogram(String confirmBCryptogram) {
		ConfirmBCryptogram = confirmBCryptogram;
	}

	public String getCVKBKeyCheck() {
		return CVKBKeyCheck;
	}

	public void setCVKBKeyCheck(String cVKBKeyCheck) {
		CVKBKeyCheck = cVKBKeyCheck;
	}

	public String getConfirmBKeyCheck() {
		return ConfirmBKeyCheck;
	}

	public void setConfirmBKeyCheck(String confirmBKeyCheck) {
		ConfirmBKeyCheck = confirmBKeyCheck;
	}

	public String getCVV3Cryptogram() {
		return CVV3Cryptogram;
	}

	public void setCVV3Cryptogram(String cVV3Cryptogram) {
		CVV3Cryptogram = cVV3Cryptogram;
	}

	public String getConfirmCVV3Cryptogram() {
		return ConfirmCVV3Cryptogram;
	}

	public void setConfirmCVV3Cryptogram(String confirmCVV3Cryptogram) {
		ConfirmCVV3Cryptogram = confirmCVV3Cryptogram;
	}

	public String getCVV3KeyCheckvalue() {
		return CVV3KeyCheckvalue;
	}

	public void setCVV3KeyCheckvalue(String cVV3KeyCheckvalue) {
		CVV3KeyCheckvalue = cVV3KeyCheckvalue;
	}

	public String getConfirmCVV3KeyCheckValue() {
		return ConfirmCVV3KeyCheckValue;
	}

	public void setConfirmCVV3KeyCheckValue(String confirmCVV3KeyCheckValue) {
		ConfirmCVV3KeyCheckValue = confirmCVV3KeyCheckValue;
	}

	public String getATCOffsetOnTrack() {
		return ATCOffsetOnTrack;
	}

	public void setATCOffsetOnTrack(String aTCOffsetOnTrack) {
		ATCOffsetOnTrack = aTCOffsetOnTrack;
	}

	public String getUNOffsetOnTrack() {
		return UNOffsetOnTrack;
	}

	public void setUNOffsetOnTrack(String uNOffsetOnTrack) {
		UNOffsetOnTrack = uNOffsetOnTrack;
	}

	public String getCVC3OffsetOnTrack() {
		return CVC3OffsetOnTrack;
	}

	public void setCVC3OffsetOnTrack(String cVC3OffsetOnTrack) {
		CVC3OffsetOnTrack = cVC3OffsetOnTrack;
	}

}
