package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.HSMDeviceKeys;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP, CardManagementNav.L2HSM_KEYS,
		CardManagementNav.L3DEVICE_KEYS })
public class HSMDeviceKeysPage extends AbstractBasePage {

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addHSMDeviceKeys;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrBinInf:input:inputTextField")
	private MCWebElement binStartTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrBinSup:input:inputTextField")
	private MCWebElement binEndTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrCvkA:input:inputTextField")
	private MCWebElement cvkACryptogram;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cnfbincrCvkA:input:inputTextField")
	private MCWebElement confirmACryptogram;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrKchkValueA:input:inputTextField")
	private MCWebElement cvkAKeyCheckValue;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cnfbincrKchkValueA:input:inputTextField")
	private MCWebElement confirmAKeyCheckValue;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrCvkB:input:inputTextField")
	private MCWebElement cvkBCryptogram;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cnfbincrCvkB:input:inputTextField")
	private MCWebElement confirmBCryptogram;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrKchkValueB:input:inputTextField")
	private MCWebElement cvkBKeyCheckValue;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cnfbincrKchkValueB:input:inputTextField")
	private MCWebElement confirmBKeyCheckValue;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrIsPinData:checkBoxComponent")
	private MCWebElement pinDataExistsChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrPingenmode:input:dropdowncomponent")
	private MCWebElement generationMethodDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "compType:input:dropdowncomponent")
	private MCWebElement componentTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrHexdecimibm:input:inputTextField")
	private MCWebElement decimalizationTabletxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrMinPinlg:input:inputTextField")
	private MCWebElement pinLengthtxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrIsPvki:checkBoxComponent")
	private MCWebElement pvkiExistsChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrOffsetpvv:input:inputTextField")
	private MCWebElement pvvOffsetOnTrackTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrOffsetpvki:input:inputTextField")
	private MCWebElement pvkiOffsetOnTrackTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrIsPvkData:checkBoxComponent")
	private MCWebElement pvkDataExistsChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrPinvaldata:input:inputTextField")
	private MCWebElement pinValidationDataTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cnfbincrPinvaldata:input:inputTextField")
	private MCWebElement confirmValidationDataTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "pvk:input:inputTextField")
	private MCWebElement pinVerificationKeyTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cnfpvk:input:inputTextField")
	private MCWebElement confirmPINVerificationKeyTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "pvkKchkValue:input:inputTextField")
	private MCWebElement pinVerificationKeyCheckTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cnfpvkKchkValue:input:inputTextField")
	private MCWebElement confirmPINVerificationKeyCheckTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrIsCv:checkBoxComponent")
	private MCWebElement cvvExistsChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrCvCtl:checkBoxComponent")
	private MCWebElement controlFlagChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrOffsetcvv:input:inputTextField")
	private MCWebElement cvvOffsetOnTrackTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrCvkA:input:inputTextField")
	private MCWebElement cvkACryptogramTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cnfbincrCvkA:input:inputTextField")
	private MCWebElement confirmACryptogramTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrKchkValueA:input:inputTextField")
	private MCWebElement cvkAKeyCheckTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cnfbincrKchkValueA:input:inputTextField")
	private MCWebElement confirmAKeyCheckTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrCvkB:input:inputTextField")
	private MCWebElement cvkBCryptogramTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cnfbincrCvkB:input:inputTextField")
	private MCWebElement confirmBCryptogramTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrKchkValueB:input:inputTextField")
	private MCWebElement cvkBKeyCheckTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cnfbincrKchkValueB:input:inputTextField")
	private MCWebElement confirmBKeyCheckTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrIsCvv3:checkBoxComponent")
	private MCWebElement cvv3ExistsChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "payPassWaveKey:input:inputTextField")
	private MCWebElement cvv3CryptogramTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cnfPayPassWaveKey:input:inputTextField")
	private MCWebElement confirmCVV3CryptogramTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "payPassWaveKchk:input:inputTextField")
	private MCWebElement cvv3KeyCheckvalueTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cnfPayPassWaveKchk:input:inputTextField")
	private MCWebElement confirmCVV3KeyCheckValueTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "atcOffsetTrack2:input:inputTextField")
	private MCWebElement atcOffsetOnTrackTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "unOffsetTrack2:input:inputTextField")
	private MCWebElement unOffsetOnTrackTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cvc3OffsetTrack2:input:inputTextField")
	private MCWebElement cvc3OffsetOnTrackTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	public void addHSMKeys() {
		waitForElementVisible(addHSMDeviceKeys);
		ClickButton(addHSMDeviceKeys);
	}

	public void fillBinStart(HSMDeviceKeys hsmKeys) {
		waitForElementVisible(binStartTxt);
		enterText(binStartTxt, hsmKeys.getBinStart());
	}

	public void fillBinEnd(HSMDeviceKeys hsmKeys) {
		waitForElementVisible(binEndTxt);
		enterText(binEndTxt, hsmKeys.getBinEnd());
	}

	public void selectPINDataCheckBox() {
		waitforElement(cvv3ExistsChkBx);
		waitForElementVisible(pinDataExistsChkBx);
		ClickCheckBox(pinDataExistsChkBx, true);
	}

	public void selectGenerationMethod(HSMDeviceKeys hsmKeys) {
		waitforElement(cvv3ExistsChkBx);
		waitForElementVisible(generationMethodDDwn);
		selectDropDownByText(generationMethodDDwn, hsmKeys.getGenerationMethodDDwn());
	}

	public void fillDecimalization(HSMDeviceKeys hsmKeys) { 
		waitForElementVisible(decimalizationTabletxt);
		enterText(decimalizationTabletxt, hsmKeys.getDecimalizationTable());
	}

	public void fillPINlength(HSMDeviceKeys hsmKeys) { 
		waitForElementVisible(pinLengthtxt);
		enterText(pinLengthtxt, hsmKeys.getPINlength());
	}

	public void selectPVKiExistsCheckBox() {
		waitforElement(pvkiExistsChkBx);
		ClickCheckBox(pvkiExistsChkBx, true);
	}

	public void fillPVVOffset(HSMDeviceKeys hsmKeys) {
		waitforElement(pvvOffsetOnTrackTxt);
		enterText(pvvOffsetOnTrackTxt, hsmKeys.getPVVOffset());
	}

	public void fillPVKOffset(HSMDeviceKeys hsmKeys) {
		waitforElement(pvkiOffsetOnTrackTxt);
		enterText(pvkiOffsetOnTrackTxt, hsmKeys.getPVKOffset());
	}

	public void selectPVKDataExistsCheckBox() {
		waitforElement(pvkDataExistsChkBx);
		ClickCheckBox(pvkDataExistsChkBx, true);
	}

	public void fillPINValidationData(HSMDeviceKeys hsmKeys) {
		waitforElement(pinValidationDataTxt);
		enterText(pinValidationDataTxt, hsmKeys.getPINValidationData());
	}

	public void fillConfirmValidationData(HSMDeviceKeys hsmKeys) {
		waitforElement(confirmValidationDataTxt);
		enterText(confirmValidationDataTxt, hsmKeys.getPINValidationData());
	}

	public void fillPINVerificationKey(HSMDeviceKeys hsmKeys) {
		waitforElement(pinVerificationKeyTxt);
		enterText(pinVerificationKeyTxt, hsmKeys.getPINVerificationKey());
	}

	public void fillConfirmPINVerificationKey(HSMDeviceKeys hsmKeys) {
		waitforElement(confirmPINVerificationKeyTxt);
		enterText(confirmPINVerificationKeyTxt, hsmKeys.getPINVerificationKey());
	}

	public void fillPINVerificationKeyCheck(HSMDeviceKeys hsmKeys) {
		waitforElement(pinVerificationKeyCheckTxt);
		enterText(pinVerificationKeyCheckTxt, hsmKeys.getPINVerificationKeyCheck());
	}

	public void fillConfirmPINVerificationKeyCheck(HSMDeviceKeys hsmKeys) {
		waitforElement(confirmPINVerificationKeyCheckTxt);
		enterText(confirmPINVerificationKeyCheckTxt, hsmKeys.getPINVerificationKeyCheck());
	}

	public void selectCVVExistsCheckBox() {
		waitforElement(cvvExistsChkBx);
		ClickCheckBox(cvvExistsChkBx, true);
	}

	public void selectControlFlagCheckBox() {
		waitforElement(controlFlagChkBx);
		ClickCheckBox(controlFlagChkBx, true);
	}

	public void fillCVVOffsetOnTrack(HSMDeviceKeys hsmKeys) {
		waitforElement(cvvOffsetOnTrackTxt);
		enterText(cvvOffsetOnTrackTxt, hsmKeys.getCVVOffsetOnTrack());
	}
	public void selectComponentType(HSMDeviceKeys hsmKeys) { 
		waitForElementVisible(componentTypeDDwn);
		selectDropDownByText(componentTypeDDwn, hsmKeys.getcomponentType());
	}
	
	public void fillCVKACryptogram(HSMDeviceKeys hsmKeys) {
		waitforElement(cvkACryptogramTxt);
		enterText(cvkACryptogramTxt, hsmKeys.getCVKACryptogram());
	}

	public void fillConfirmACryptogram(HSMDeviceKeys hsmKeys) {
		waitforElement(confirmACryptogramTxt);
		enterText(confirmACryptogramTxt, hsmKeys.getConfirmACryptogram());
	}

	public void fillCVKAKeyCheck(HSMDeviceKeys hsmKeys) {
		waitforElement(cvkAKeyCheckTxt);
		enterText(cvkAKeyCheckTxt, hsmKeys.getCVKAKeyCheck());
	}

	public void fillConfirmAKeyCheck(HSMDeviceKeys hsmKeys) {
		waitforElement(confirmAKeyCheckTxt);
		enterText(confirmAKeyCheckTxt, hsmKeys.getConfirmAKeyCheck());
	}

	public void fillCVKBCryptogram(HSMDeviceKeys hsmKeys) {
		waitforElement(cvkBCryptogramTxt);
		enterText(cvkBCryptogramTxt, hsmKeys.getCVKBCryptogram());
	}

	public void fillConfirmBCryptogram(HSMDeviceKeys hsmKeys) {
		waitforElement(confirmBCryptogramTxt);		
		enterText(confirmBCryptogramTxt, hsmKeys.getConfirmBCryptogram());
	}

	public void fillCVKBKeyCheck(HSMDeviceKeys hsmKeys) {
		waitforElement(cvkBKeyCheckTxt);
		enterText(cvkBKeyCheckTxt, hsmKeys.getCVKBKeyCheck());
	}

	public void fillConfirmBKeyCheck(HSMDeviceKeys hsmKeys) {
		waitforElement(confirmBKeyCheckTxt);
		enterText(confirmBKeyCheckTxt, hsmKeys.getConfirmBKeyCheck());
	}

	public void selectCVV3ExistsCheckBox() {
		waitforElement(cvv3ExistsChkBx);
		ClickCheckBox(cvv3ExistsChkBx, true);
	}

	public void fillCVV3Cryptogram(HSMDeviceKeys hsmKeys) {
		waitforElement(cvv3CryptogramTxt);
		new SimulatorUtilities();
		SimulatorUtilities.wait(200);
		enterText(cvv3CryptogramTxt, hsmKeys.getCVV3Cryptogram());
	}

	public void fillConfirmCVV3Cryptogram(HSMDeviceKeys hsmKeys) {
		waitforElement(confirmCVV3CryptogramTxt);
		new SimulatorUtilities();
		SimulatorUtilities.wait(200);
		enterText(confirmCVV3CryptogramTxt, hsmKeys.getConfirmCVV3Cryptogram());
	}

	public void fillCVV3KeyCheckvalue(HSMDeviceKeys hsmKeys) { 
		waitforElement(cvv3KeyCheckvalueTxt);
		new SimulatorUtilities();
		SimulatorUtilities.wait(200);
		enterText(cvv3KeyCheckvalueTxt, hsmKeys.getCVV3KeyCheckvalue());
	}

	public void fillConfirmCVV3KeyCheckValue(HSMDeviceKeys hsmKeys) {
		waitforElement(confirmCVV3KeyCheckValueTxt);
		enterText(confirmCVV3KeyCheckValueTxt, hsmKeys.getConfirmCVV3KeyCheckValue());
	}

	public void fillATCOffsetOnTrack(HSMDeviceKeys hsmKeys) {
		waitforElement(atcOffsetOnTrackTxt);
		enterText(atcOffsetOnTrackTxt, hsmKeys.getATCOffsetOnTrack());
	}

	public void fillUNOffsetOnTrack(HSMDeviceKeys hsmKeys) {
		waitforElement(unOffsetOnTrackTxt);
		enterText(unOffsetOnTrackTxt, hsmKeys.getUNOffsetOnTrack());
	}

	public void fillCVC3OffsetOnTrack(HSMDeviceKeys hsmKeys) {
		waitforElement(cvc3OffsetOnTrackTxt);
		enterText(cvc3OffsetOnTrackTxt, hsmKeys.getCVVOffsetOnTrack());
	}
	@Override
	public void clickSaveButton() {
		waitforElement(cvv3ExistsChkBx);
		ClickButton(saveBtn);
	}

	public void switchToAddDeviceKeysFrame() {
		waitforElement(cvv3ExistsChkBx);
		switchToIframe(Constants.ADD_DEVICE_KEYS_FRAME);
	}
}
