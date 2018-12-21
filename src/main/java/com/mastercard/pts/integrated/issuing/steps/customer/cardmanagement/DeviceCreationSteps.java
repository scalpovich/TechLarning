package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceBin;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.HSMDeviceKeys;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.HSMNetworkKeys;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MasterDerivationKeys;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
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

	@Autowired
	DeviceBin deviceBin;

	@When("user creates a new $device with the required configuration")
	public void createNewDevice(@Named("device") String deviceType)
			throws InterruptedException {
		if (deviceType.equalsIgnoreCase(ConstantData.DEBIT_DEVICE)) {
			deviceCreationFlows.createNewDevice();
		}
		if (deviceType.equalsIgnoreCase(ConstantData.PREPAID_DEVICE)) {
			prepaiddeviceFileEmbossingFlows.createNewprepaidDevice();
		}
	}

	@When("user creates HSM Device Keys for $interchange")
	public void createHSMDeviceKeys(@Named("Interchange") String interchange) {
		hsmKeys.setBinStart(deviceBin.getIssuerBin()
				+ "0000");
		hsmKeys.setBinEnd(deviceBin.getIssuerBin() + "9999");
		hsmKeys.hsmDeviceKeysDataProvider();
		hsmdeviceflows.addHSMDeviceKeys(hsmKeys);
	}

	@When("user creates HSM $KeyType Network Keys for $interchange")
	public void createHSMNetworkKeys(@Named("KeyType") String keyType, @Named("Interchange") String interchange) {
		hsmNtkKeys.setNetworkInterface(interchange);
		hsmNtkKeys.setSubNetworkID(CustomUtils.RandomNumbers(2));
		hsmNtkKeys.setKeyIndex(CustomUtils.RandomNumbers(2));
		hsmNtkKeys.setKeyType(keyType);	
		hsmNtkKeys.hsmNetworkKeysCurrencyDataProvider();
		hsmnetworkflows.addHSMNetworkKeys(hsmNtkKeys);
	}

	@When("user creates MDK keys for $interchange")
	public void addMDKKeys(@Named("Interchange") String interchange) {
		mdkKeys.setInterchange(interchange);
		mdkKeys.setBinLow(deviceBin.getIssuerBin() + "0000");
		mdkKeys.setBinHigh(deviceBin.getIssuerBin() + "9999");
		mdkKeys.masterDerivationKeysCurrencyDataProvider();	
		mdkflows.addMDKKey(mdkKeys);
	}

	@Then("device should get generated with the device number")
	public void generateDeviceNumber() {
		//TODO
	}

	@Then("device should get generated with the $device number")
	public void generateDeviceNumber(@Named("device number") String deviceType) {
		//TODO
	}

	@When("user creates creates a $WhitelistedMCG wallet plan")
	public void generateDeviceNur() {
		//TODO
	}

}
