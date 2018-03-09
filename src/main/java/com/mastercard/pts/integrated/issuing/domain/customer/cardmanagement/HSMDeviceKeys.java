package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class HSMDeviceKeys {

	public String binStart;
	public String binEnd;
	public String generationMethodDDwn;
	public String decimalizationTable;
	public String pinLength;
	public String pvvOffset;
	public String pvkOffset;
	public String pinValidationData;
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
		return pvvOffset;
	}

	public void setPVVOffset(String pVVOffset) {
		this.pvvOffset = pVVOffset;
	}

	public String getPVKOffset() {
		return pvkOffset;
	}

	public void setPVKOffset(String pVKOffset) {
		this.pvkOffset = pVKOffset;
	}

	public String getPINValidationData() {
		return pinValidationData;
	}

	public void setPINValidationData(String pINValidationData) {
		this.pinValidationData = pINValidationData;
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
	public static HSMNetworkKeys createWithProvider(DataProvider provider) {
		return provider.getDataBySimpleClassName(HSMNetworkKeys.class);
	}
	public void hsmDeviceKeysDataProvider() {
		 setGenerationMethodDDwn(MapUtils
				.fnGetInputDataFromMap("GeneralisationMethod"));		
		setDecimalizationTable(CustomUtils.RandomNumbers(16));
		setPINlength(MapUtils.fnGetInputDataFromMap("PINlength"));
		setPVVOffset(MapUtils.fnGetInputDataFromMap("PVVOffset"));
		setPVKOffset(MapUtils.fnGetInputDataFromMap("PVKOffset"));
		setPINValidationData(MapUtils
				.fnGetInputDataFromMap("PINValidationData"));
		setConfirmValidationData(MapUtils
				.fnGetInputDataFromMap("PINValidationData"));
		setPINVerificationKey(MapUtils
				.fnGetInputDataFromMap("PINVerificationKey"));
		setConfirmPINVerificationKey(MapUtils
				.fnGetInputDataFromMap("PINVerificationKey"));
		
		setPINVerificationKeyCheck(MapUtils
				.fnGetInputDataFromMap("PINVerificationKeyCheck"));
		setConfirmPINVerificationKey(MapUtils
				.fnGetInputDataFromMap("PINVerificationKeyCheck"));
		setCVVOffsetOnTrack(MapUtils
				.fnGetInputDataFromMap("CVVOffsetOnTrack"));
		setCVKACryptogram(MapUtils
				.fnGetInputDataFromMap("CVKACryptogram"));
		setComponentType(MapUtils
				.fnGetInputDataFromMap("ComponentType"));
		setConfirmACryptogram(MapUtils
				.fnGetInputDataFromMap("CVKACryptogram"));
		setCVKAKeyCheck(MapUtils.fnGetInputDataFromMap("CVKAKeyCheck"));
		setConfirmAKeyCheck(MapUtils
				.fnGetInputDataFromMap("CVKAKeyCheck"));
		setCVKBCryptogram(MapUtils
				.fnGetInputDataFromMap("CVKBCryptogram"));
		setConfirmBCryptogram(MapUtils
				.fnGetInputDataFromMap("CVKBCryptogram"));
		setCVKBKeyCheck(MapUtils.fnGetInputDataFromMap("CVKBKeyCheck"));
		setConfirmBKeyCheck(MapUtils
				.fnGetInputDataFromMap("CVKBKeyCheck"));
		setCVV3Cryptogram(MapUtils
				.fnGetInputDataFromMap("CVV3Cryptogram"));
		setConfirmCVV3Cryptogram(MapUtils
				.fnGetInputDataFromMap("CVV3Cryptogram"));
		setCVV3KeyCheckvalue(MapUtils
				.fnGetInputDataFromMap("CVV3KeyCheckvalue"));
		setConfirmCVV3KeyCheckValue(MapUtils
				.fnGetInputDataFromMap("CVV3KeyCheckvalue"));
		setATCOffsetOnTrack(MapUtils
				.fnGetInputDataFromMap("ATCOffsetOnTrack"));
		setUNOffsetOnTrack(MapUtils
				.fnGetInputDataFromMap("UNOffsetOnTrack"));
		setCVC3OffsetOnTrack(MapUtils
				.fnGetInputDataFromMap("CVC3OffsetOnTrack"));
	}

}
