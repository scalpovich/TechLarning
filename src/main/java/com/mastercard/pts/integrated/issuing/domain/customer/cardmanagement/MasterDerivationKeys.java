package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class MasterDerivationKeys {
	public String Interchange;
	public String Status;
	public String KeyType;
	public String BinLow;
	public String BinHigh;
	public String MDKEncryptedUnderLMK;
	public String ConfirmMDK;
	public String MDKKeyCheckValue;
	public String ConfirmMDKKeyCheckValue;
	public String SMIEncryptedUnderLMKTxt;
	public String ConfirmSMI;
	public String SMIKeyCheckvalue;
	public String ConfirmSMIKeyCheckvalue;
	public String SMCEncryptedUnderLMKTxt;
	public String ConfirmSMC;
	public String SMCKeyCheckvalue;
	public String ConfirmSMCKeyCheckvalue;

	public String getInterchange() {
		return Interchange;
	}

	public void setInterchange(String interchange) {
		Interchange = interchange;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getKeyType() {
		return KeyType;
	}

	public void setKeyType(String keyType) {
		KeyType = keyType;
	}

	public String getBinLow() {
		return BinLow;
	}

	public void setBinLow(String binLow) {
		BinLow = binLow;
	}

	public String getBinHigh() {
		return BinHigh;
	}

	public void setBinHigh(String binHigh) {
		BinHigh = binHigh;
	}

	public String getMDKEncryptedUnderLMK() {
		return MDKEncryptedUnderLMK;
	}

	public void setMDKEncryptedUnderLMK(String mDKEncryptedUnderLMK) {
		MDKEncryptedUnderLMK = mDKEncryptedUnderLMK;
	}

	public String getConfirmMDK() {
		return ConfirmMDK;
	}

	public void setConfirmMDK(String confirmMDK) {
		ConfirmMDK = confirmMDK;
	}

	public String getMDKKeyCheckValue() {
		return MDKKeyCheckValue;
	}

	public void setMDKKeyCheckValue(String mDKKeyCheckValue) {
		MDKKeyCheckValue = mDKKeyCheckValue;
	}

	public String getConfirmMDKKeyCheckValue() {
		return ConfirmMDKKeyCheckValue;
	}

	public void setConfirmMDKKeyCheckValue(String confirmMDKKeyCheckValue) {
		ConfirmMDKKeyCheckValue = confirmMDKKeyCheckValue;
	}

	public String getSMIEncryptedUnderLMKTxt() {
		return SMIEncryptedUnderLMKTxt;
	}

	public boolean setSMIEncryptedUnderLMKTxt(String sMIEncryptedUnderLMKTxt) {
		SMIEncryptedUnderLMKTxt = sMIEncryptedUnderLMKTxt;
		if (SMIEncryptedUnderLMKTxt != null) {
			return true;
		} else {
			return false;
		}
	}

	public String getConfirmSMI() {
		return ConfirmSMI;
	}

	public void setConfirmSMI(String confirmSMI) {
		ConfirmSMI = confirmSMI;
	}

	public String getSMIKeyCheckvalue() {
		return SMIKeyCheckvalue;
	}

	public boolean setSMIKeyCheckvalue(String sMIKeyCheckvalue) {
		SMIKeyCheckvalue = sMIKeyCheckvalue;
		if (SMIKeyCheckvalue != null) {
			return true;
		} else {
			return false;
		}
	}

	public String getConfirmSMIKeyCheckvalue() {
		return ConfirmSMIKeyCheckvalue;
	}

	public void setConfirmSMIKeyCheckvalue(String confirmSMIKeyCheckvalue) {
		ConfirmSMIKeyCheckvalue = confirmSMIKeyCheckvalue;
	}

	public String getSMCEncryptedUnderLMKTxt() {
		return SMCEncryptedUnderLMKTxt;
	}

	public boolean setSMCEncryptedUnderLMKTxt(String sMCEncryptedUnderLMKTxt) {
		SMCEncryptedUnderLMKTxt = sMCEncryptedUnderLMKTxt;
		if (SMCEncryptedUnderLMKTxt != null) {
			return true;
		} else {
			return false;
		}
	}

	public String getConfirmSMC() {
		return ConfirmSMC;
	}

	public void setConfirmSMC(String confirmSMC) {
		ConfirmSMC = confirmSMC;
	}

	public String getSMCKeyCheckvalue() {
		return SMCKeyCheckvalue;
	}

	public boolean setSMCKeyCheckvalue(String sMCKeyCheckvalue) {
		SMCKeyCheckvalue = sMCKeyCheckvalue;
		if (SMCKeyCheckvalue != null) {
			return true;
		} else {
			return false;
		}
	}

	public String getConfirmSMCKeyCheckvalue() {
		return ConfirmSMCKeyCheckvalue;
	}

	public void setConfirmSMCKeyCheckvalue(String confirmSMCKeyCheckvalue) {
		ConfirmSMCKeyCheckvalue = confirmSMCKeyCheckvalue;
	}
	
	public static MasterDerivationKeys createWithProvider(DataProvider provider) {
		return provider.getDataBySimpleClassName(MasterDerivationKeys.class);
	}
	public void masterDerivationKeysCurrencyDataProvider() {
		 setMDKEncryptedUnderLMK(MapUtils
				.fnGetInputDataFromMap("MDKEncryptedUnderLMK"));
		setConfirmMDK(MapUtils
				.fnGetInputDataFromMap("MDKEncryptedUnderLMK"));
		setMDKKeyCheckValue(MapUtils
				.fnGetInputDataFromMap("MDKKeyCheckValue"));
		setConfirmMDKKeyCheckValue(MapUtils
				.fnGetInputDataFromMap("MDKKeyCheckValue"));
		setSMIEncryptedUnderLMKTxt(MapUtils
				.fnGetInputDataFromMap("SMIEncryptedUnderLMKTxt"));
		setConfirmSMI(MapUtils
				.fnGetInputDataFromMap("SMIEncryptedUnderLMKTxt"));
		setSMIKeyCheckvalue(MapUtils
				.fnGetInputDataFromMap("SMIKeyCheckvalues"));
		setConfirmSMIKeyCheckvalue(MapUtils
				.fnGetInputDataFromMap("SMIKeyCheckvalues"));
		setSMCEncryptedUnderLMKTxt(MapUtils
				.fnGetInputDataFromMap("SMCEncryptedUnderLMKTxt"));
		setConfirmSMC(MapUtils
				.fnGetInputDataFromMap("SMCEncryptedUnderLMKTxt"));
		setSMCKeyCheckvalue(MapUtils
				.fnGetInputDataFromMap("SMCKeyCheckvalue"));
		setConfirmSMCKeyCheckvalue(MapUtils
				.fnGetInputDataFromMap("SMCKeyCheckvalue"));
		setStatus(MapUtils.fnGetInputDataFromMap("MDKStatus"));
	setKeyType(MapUtils.fnGetInputDataFromMap("MDKKeyType"));	
	}

}
