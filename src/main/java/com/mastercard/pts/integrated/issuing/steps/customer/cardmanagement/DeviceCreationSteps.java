package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.HSMDeviceKeys;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.HSMNetworkKeys;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MasterDerivationKeys;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.workflows.EMVMDKKeyFlows;
import com.mastercard.pts.integrated.issuing.workflows.PrepaidDeviceFileEmbossingFlows;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DeviceCreationFlows;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.HSMDeviceKeysFlows;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.HSMNetworkKeysFlows;

/**
 * @author E060549
 * 
 *
 */

@Component
public class DeviceCreationSteps {

	@Autowired
	DeviceCreationFlows deviceCreationFlows;

	@Autowired
	PrepaidDeviceFileEmbossingFlows prepaiddeviceFileEmbossingFlows;

	@Autowired
	HSMDeviceKeys hsmKeys;

	@Autowired
	HSMDeviceKeysFlows hsmdeviceflows;

	@Autowired
	HSMNetworkKeys hsmNtkKeys;

	@Autowired
	HSMNetworkKeysFlows hsmnetworkflows;

	@Autowired
	MasterDerivationKeys mdkKeys;

	@Autowired
	EMVMDKKeyFlows mdkflows;

	@When("user creates a new $device with the required configuration")
	public void createNewDevice(@Named("device") String deviceType)
			throws InterruptedException {

		if (deviceType.equalsIgnoreCase("Debitdevice")) {
			deviceCreationFlows.createNewDevice();

		}
		if (deviceType.equalsIgnoreCase("Prepaiddevice")) {
			prepaiddeviceFileEmbossingFlows.createNewprepaidDevice();
		}

	}

	@When("Create HSM Device Keys")
	public void createHSMDeviceKeys() {
		hsmKeys.setBinStart(MapUtils.fnGetInputDataFromMap("IssuerBIN")
				+ "0000");
		hsmKeys.setBinEnd(MapUtils.fnGetInputDataFromMap("IssuerBIN") + "9999");
		hsmKeys.setGenerationMethodDDwn(MapUtils
				.fnGetInputDataFromMap("GeneralisationMethod"));
		hsmKeys.setDecimalizationTable(CustomUtils.RandomNumbers(16));
		hsmKeys.setPINlength(MapUtils.fnGetInputDataFromMap("PINlength"));
		hsmKeys.setPVVOffset(MapUtils.fnGetInputDataFromMap("PVVOffset"));
		hsmKeys.setPVKOffset(MapUtils.fnGetInputDataFromMap("PVKOffset"));
		hsmKeys.setPINValidationData(MapUtils
				.fnGetInputDataFromMap("PINValidationData"));
		hsmKeys.setConfirmValidationData(MapUtils
				.fnGetInputDataFromMap("PINValidationData"));
		hsmKeys.setPINVerificationKey(MapUtils
				.fnGetInputDataFromMap("PINVerificationKey"));
		hsmKeys.setConfirmPINVerificationKey(MapUtils
				.fnGetInputDataFromMap("PINVerificationKey"));
		hsmKeys.setPINVerificationKeyCheck(MapUtils
				.fnGetInputDataFromMap("PINVerificationKeyCheck"));
		hsmKeys.setConfirmPINVerificationKey(MapUtils
				.fnGetInputDataFromMap("PINVerificationKeyCheck"));
		hsmKeys.setCVVOffsetOnTrack(MapUtils
				.fnGetInputDataFromMap("CVVOffsetOnTrack"));
		hsmKeys.setCVKACryptogram(MapUtils
				.fnGetInputDataFromMap("CVKACryptogram"));
		hsmKeys.setConfirmACryptogram(MapUtils
				.fnGetInputDataFromMap("CVKACryptogram"));
		hsmKeys.setCVKAKeyCheck(MapUtils.fnGetInputDataFromMap("CVKAKeyCheck"));
		hsmKeys.setConfirmAKeyCheck(MapUtils
				.fnGetInputDataFromMap("CVKAKeyCheck"));
		hsmKeys.setCVKBCryptogram(MapUtils
				.fnGetInputDataFromMap("CVKBCryptogram"));
		hsmKeys.setConfirmBCryptogram(MapUtils
				.fnGetInputDataFromMap("CVKBCryptogram"));
		hsmKeys.setCVKBKeyCheck(MapUtils.fnGetInputDataFromMap("CVKBKeyCheck"));
		hsmKeys.setConfirmBKeyCheck(MapUtils
				.fnGetInputDataFromMap("CVKBKeyCheck"));
		hsmKeys.setCVV3Cryptogram(MapUtils
				.fnGetInputDataFromMap("CVV3Cryptogram"));
		hsmKeys.setConfirmCVV3Cryptogram(MapUtils
				.fnGetInputDataFromMap("CVV3Cryptogram"));
		hsmKeys.setCVV3KeyCheckvalue(MapUtils
				.fnGetInputDataFromMap("CVV3KeyCheckvalue"));
		hsmKeys.setConfirmCVV3KeyCheckValue(MapUtils
				.fnGetInputDataFromMap("CVV3KeyCheckvalue"));
		hsmKeys.setATCOffsetOnTrack(MapUtils
				.fnGetInputDataFromMap("ATCOffsetOnTrack"));
		hsmKeys.setUNOffsetOnTrack(MapUtils
				.fnGetInputDataFromMap("UNOffsetOnTrack"));
		hsmKeys.setCVC3OffsetOnTrack(MapUtils
				.fnGetInputDataFromMap("CVC3OffsetOnTrack"));
		hsmdeviceflows.addHSMDeviceKeys(hsmKeys);
	}

	@When("Create HSM Network Keys")
	public void createHSMNetworkKeys() {
		hsmNtkKeys.setNetworkInterface(MapUtils
				.fnGetInputDataFromMap("NetworkInterface"));
		hsmNtkKeys.setSubNetworkID(CustomUtils.RandomNumbers(2));
		hsmNtkKeys.setKeyIndex(CustomUtils.RandomNumbers(2));
		hsmNtkKeys.setKeyType(MapUtils.fnGetInputDataFromMap("KeyType"));
		hsmNtkKeys.setNetworkCryptogram(MapUtils
				.fnGetInputDataFromMap("NetworkCryptogram"));
		hsmNtkKeys.setConfirmNetworkCryptogram(MapUtils
				.fnGetInputDataFromMap("NetworkCryptogram"));
		hsmNtkKeys.setNetworkCryptogramCheckValue(MapUtils
				.fnGetInputDataFromMap("NetworkCryptogramCheckValue"));
		hsmNtkKeys.setConfirmNetworkCryptogramCheckValue(MapUtils
				.fnGetInputDataFromMap("NetworkCryptogramCheckValue"));
		hsmnetworkflows.addHSMNetworkKeys(hsmNtkKeys);

	}

	@When("Create MDK keys")
	public void addMDKKeys() {
		mdkKeys.setInterchange(MapUtils
				.fnGetInputDataFromMap("InterchangeType"));
		mdkKeys.setBinLow(MapUtils.fnGetInputDataFromMap("IssuerBIN") + "0000");
		mdkKeys.setBinHigh(MapUtils.fnGetInputDataFromMap("IssuerBIN") + "9999");
		mdkKeys.setStatus(MapUtils.fnGetInputDataFromMap("Status"));
		mdkKeys.setKeyType(MapUtils.fnGetInputDataFromMap("KeyType"));
		mdkKeys.setMDKEncryptedUnderLMK(MapUtils
				.fnGetInputDataFromMap("MDKEncryptedUnderLMK"));
		mdkKeys.setConfirmMDK(MapUtils
				.fnGetInputDataFromMap("MDKEncryptedUnderLMK"));
		mdkKeys.setMDKKeyCheckValue(MapUtils
				.fnGetInputDataFromMap("MDKKeyCheckValue"));
		mdkKeys.setConfirmMDKKeyCheckValue(MapUtils
				.fnGetInputDataFromMap("MDKKeyCheckValue"));
		mdkKeys.setSMIEncryptedUnderLMKTxt(MapUtils
				.fnGetInputDataFromMap("SMIEncryptedUnderLMKTxt"));
		mdkKeys.setConfirmSMI(MapUtils
				.fnGetInputDataFromMap("SMIEncryptedUnderLMKTxt"));
		mdkKeys.setSMIKeyCheckvalue(MapUtils
				.fnGetInputDataFromMap("SMIKeyCheckvalues"));
		mdkKeys.setConfirmSMIKeyCheckvalue(MapUtils
				.fnGetInputDataFromMap("SMIKeyCheckvalues"));
		mdkKeys.setSMCEncryptedUnderLMKTxt(MapUtils
				.fnGetInputDataFromMap("SMCEncryptedUnderLMKTxt"));
		mdkKeys.setConfirmSMC(MapUtils
				.fnGetInputDataFromMap("SMCEncryptedUnderLMKTxt"));
		mdkKeys.setSMCKeyCheckvalue(MapUtils
				.fnGetInputDataFromMap("SMCKeyCheckvalue"));
		mdkKeys.setConfirmSMCKeyCheckvalue(MapUtils
				.fnGetInputDataFromMap("SMCKeyCheckvalue"));
		mdkflows.addMDKKey(mdkKeys);

	}

	@Then("device should get generated with the device number")
	public void generateDeviceNumber() {

	}

	@Then("device should get generated with the $device number")
	public void generateDeviceNumber(@Named("device number") String deviceType) {

	}

	@When("user creates creates a $WhitelistedMCG wallet plan")
	public void generateDeviceNur() {

	}

}
