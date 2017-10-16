package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.HSMDeviceKeysPage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class HSMDeviceKeysFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	public void addHSMDeviceKeys(com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.HSMDeviceKeys hsmKeys) {
		waitForElementVisible(menuSubMenuPage.getCardManagement());
		HSMDeviceKeysPage hsmdevicepage = navigator.navigateToPage(HSMDeviceKeysPage.class);
		hsmdevicepage.addHSMKeys();
		hsmdevicepage.switchToAddDeviceKeysFrame();
		hsmdevicepage.fillBinStart(hsmKeys);
		hsmdevicepage.fillBinEnd(hsmKeys);
		hsmdevicepage.selectPINDataCheckBox();
		hsmdevicepage.selectGenerationMethod(hsmKeys);
		hsmdevicepage.fillDecimalization(hsmKeys);
		hsmdevicepage.fillPINlength(hsmKeys);
		hsmdevicepage.selectPVKiExistsCheckBox();
		hsmdevicepage.fillPVVOffset(hsmKeys);
		hsmdevicepage.fillPVKOffset(hsmKeys);
		hsmdevicepage.selectPVKDataExistsCheckBox();
		hsmdevicepage.fillPINValidationData(hsmKeys);
		hsmdevicepage.fillConfirmValidationData(hsmKeys);
		hsmdevicepage.fillPINVerificationKey(hsmKeys);
		hsmdevicepage.fillConfirmPINVerificationKey(hsmKeys);
		hsmdevicepage.fillPINVerificationKeyCheck(hsmKeys);
		hsmdevicepage.fillConfirmPINVerificationKeyCheck(hsmKeys);
		hsmdevicepage.selectCVVExistsCheckBox();
		hsmdevicepage.selectControlFlagCheckBox();
		hsmdevicepage.fillCVVOffsetOnTrack(hsmKeys);
		hsmdevicepage.fillCVKACryptogram(hsmKeys);
		hsmdevicepage.fillConfirmACryptogram(hsmKeys);
		hsmdevicepage.fillCVKAKeyCheck(hsmKeys);
		hsmdevicepage.fillConfirmAKeyCheck(hsmKeys);
		hsmdevicepage.fillCVKBCryptogram(hsmKeys);
		hsmdevicepage.fillConfirmBCryptogram(hsmKeys);
		hsmdevicepage.fillCVKBKeyCheck(hsmKeys);
		hsmdevicepage.fillConfirmBKeyCheck(hsmKeys);
		hsmdevicepage.selectCVV3ExistsCheckBox();
		hsmdevicepage.fillCVV3Cryptogram(hsmKeys);
		hsmdevicepage.fillConfirmCVV3Cryptogram(hsmKeys);
		hsmdevicepage.fillCVV3KeyCheckvalue(hsmKeys);
		hsmdevicepage.fillConfirmCVV3KeyCheckValue(hsmKeys);
		hsmdevicepage.fillATCOffsetOnTrack(hsmKeys);
		hsmdevicepage.fillUNOffsetOnTrack(hsmKeys);
		hsmdevicepage.fillCVC3OffsetOnTrack(hsmKeys);
		hsmdevicepage.clickSaveButton();
	}
}
