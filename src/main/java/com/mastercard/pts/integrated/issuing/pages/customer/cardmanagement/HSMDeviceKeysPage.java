package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.HSMDeviceKeys;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
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
	private MCWebElement BinStartTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrBinSup:input:inputTextField")
	private MCWebElement BinEndTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrCvkA:input:inputTextField")
	private MCWebElement CVKACryptogram;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cnfbincrCvkA:input:inputTextField")
	private MCWebElement ConfirmACryptogram;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrKchkValueA:input:inputTextField")
	private MCWebElement CVKAKeyCheckValue;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cnfbincrKchkValueA:input:inputTextField")
	private MCWebElement ConfirmAKeyCheckValue;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrCvkB:input:inputTextField")
	private MCWebElement CVKBCryptogram;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cnfbincrCvkB:input:inputTextField")
	private MCWebElement ConfirmBCryptogram;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrKchkValueB:input:inputTextField")
	private MCWebElement CVKBKeyCheckValue;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cnfbincrKchkValueB:input:inputTextField")
	private MCWebElement ConfirmBKeyCheckValue;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrIsPinData:checkBoxComponent")
	private MCWebElement PINDataExistsChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrPingenmode:input:dropdowncomponent")
	private MCWebElement GenerationMethodDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "compType:input:dropdowncomponent")
	private MCWebElement componentType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrHexdecimibm:input:inputTextField")
	private MCWebElement DecimalizationTabletxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrMinPinlg:input:inputTextField")
	private MCWebElement PINlengthtxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrIsPvki:checkBoxComponent")
	private MCWebElement PVKiExistsChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrOffsetpvv:input:inputTextField")
	private MCWebElement PVVOffsetOnTrackTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrOffsetpvki:input:inputTextField")
	private MCWebElement PVKiOffsetOnTrackTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrIsPvkData:checkBoxComponent")
	private MCWebElement PVKDataExistsChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrPinvaldata:input:inputTextField")
	private MCWebElement PINValidationDataTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cnfbincrPinvaldata:input:inputTextField")
	private MCWebElement ConfirmValidationDataTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "pvk:input:inputTextField")
	private MCWebElement PINVerificationKeyTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cnfpvk:input:inputTextField")
	private MCWebElement ConfirmPINVerificationKeyTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "pvkKchkValue:input:inputTextField")
	private MCWebElement PINVerificationKeyCheckTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cnfpvkKchkValue:input:inputTextField")
	private MCWebElement ConfirmPINVerificationKeyCheckTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrIsCv:checkBoxComponent")
	private MCWebElement CVVExistsChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrCvCtl:checkBoxComponent")
	private MCWebElement ControlFlagChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrOffsetcvv:input:inputTextField")
	private MCWebElement CVVOffsetOnTrackTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrCvkA:input:inputTextField")
	private MCWebElement CVKACryptogramTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cnfbincrCvkA:input:inputTextField")
	private MCWebElement ConfirmACryptogramTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrKchkValueA:input:inputTextField")
	private MCWebElement CVKAKeyCheckTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cnfbincrKchkValueA:input:inputTextField")
	private MCWebElement ConfirmAKeyCheckTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrCvkB:input:inputTextField")
	private MCWebElement CVKBCryptogramTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cnfbincrCvkB:input:inputTextField")
	private MCWebElement ConfirmBCryptogramTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrKchkValueB:input:inputTextField")
	private MCWebElement CVKBKeyCheckTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cnfbincrKchkValueB:input:inputTextField")
	private MCWebElement ConfirmBKeyCheckTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrIsCvv3:checkBoxComponent")
	private MCWebElement CVV3ExistsChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "payPassWaveKey:input:inputTextField")
	private MCWebElement CVV3CryptogramTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cnfPayPassWaveKey:input:inputTextField")
	private MCWebElement ConfirmCVV3CryptogramTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "payPassWaveKchk:input:inputTextField")
	private MCWebElement CVV3KeyCheckvalueTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cnfPayPassWaveKchk:input:inputTextField")
	private MCWebElement ConfirmCVV3KeyCheckValueTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "atcOffsetTrack2:input:inputTextField")
	private MCWebElement ATCOffsetOnTrackTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "unOffsetTrack2:input:inputTextField")
	private MCWebElement UNOffsetOnTrackTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cvc3OffsetTrack2:input:inputTextField")
	private MCWebElement CVC3OffsetOnTrackTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

	public void addHSMKeys() {
		waitForElementVisible(addHSMDeviceKeys);
		ClickButton(addHSMDeviceKeys);
	}

	public void fillBinStart(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(BinStartTxt);
		enterText(BinStartTxt, hsmKeys.getBinStart());
	}

	public void fillBinEnd(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(BinEndTxt);
		enterText(BinEndTxt, hsmKeys.getBinEnd());
	}

	public void selectPINDataCheckBox() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickCheckBox(PINDataExistsChkBx, true);
	}

	public void selectGenerationMethod(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(GenerationMethodDDwn);
		SelectDropDownByText(GenerationMethodDDwn, hsmKeys.getGenerationMethodDDwn());
	}

	public void fillDecimalization(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(DecimalizationTabletxt);
		enterText(DecimalizationTabletxt, hsmKeys.getDecimalizationTable());
	}

	public void fillPINlength(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(PINlengthtxt);
		enterText(PINlengthtxt, hsmKeys.getPINlength());
	}

	public void selectPVKiExistsCheckBox() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickCheckBox(PVKiExistsChkBx, true);
	}

	public void fillPVVOffset(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(PVVOffsetOnTrackTxt, hsmKeys.getPVVOffset());
	}

	public void fillPVKOffset(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(PVKiOffsetOnTrackTxt, hsmKeys.getPVKOffset());
	}

	public void selectPVKDataExistsCheckBox() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickCheckBox(PVKDataExistsChkBx, true);
	}

	public void fillPINValidationData(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(PINValidationDataTxt, hsmKeys.getPINValidationData());
	}

	public void fillConfirmValidationData(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(ConfirmValidationDataTxt, hsmKeys.getPINValidationData());
	}

	public void fillPINVerificationKey(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(PINVerificationKeyTxt, hsmKeys.getPINVerificationKey());
	}

	public void fillConfirmPINVerificationKey(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(ConfirmPINVerificationKeyTxt, hsmKeys.getPINVerificationKey());
	}

	public void fillPINVerificationKeyCheck(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(PINVerificationKeyCheckTxt, hsmKeys.getPINVerificationKeyCheck());
	}

	public void fillConfirmPINVerificationKeyCheck(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(ConfirmPINVerificationKeyCheckTxt, hsmKeys.getPINVerificationKeyCheck());
	}

	public void selectCVVExistsCheckBox() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickCheckBox(CVVExistsChkBx, true);
	}

	public void selectControlFlagCheckBox() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickCheckBox(ControlFlagChkBx, true);
	}

	public void fillCVVOffsetOnTrack(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(CVVOffsetOnTrackTxt, hsmKeys.getCVVOffsetOnTrack());
	}
	public void selectComponentType(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(componentType);
		SelectDropDownByText(componentType, hsmKeys.getComponentType());
	}
	
	public void fillCVKACryptogram(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(CVKACryptogramTxt, hsmKeys.getCVKACryptogram());
	}

	public void fillConfirmACryptogram(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(ConfirmACryptogramTxt, hsmKeys.getConfirmACryptogram());
	}

	public void fillCVKAKeyCheck(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(CVKAKeyCheckTxt, hsmKeys.getCVKAKeyCheck());
	}

	public void fillConfirmAKeyCheck(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(ConfirmAKeyCheckTxt, hsmKeys.getConfirmAKeyCheck());
	}

	public void fillCVKBCryptogram(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(CVKBCryptogramTxt, hsmKeys.getCVKBCryptogram());
	}

	public void fillConfirmBCryptogram(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(ConfirmBCryptogramTxt, hsmKeys.getConfirmBCryptogram());
	}

	public void fillCVKBKeyCheck(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(CVKBKeyCheckTxt, hsmKeys.getCVKBKeyCheck());
	}

	public void fillConfirmBKeyCheck(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(ConfirmBKeyCheckTxt, hsmKeys.getConfirmBKeyCheck());
	}

	public void selectCVV3ExistsCheckBox() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickCheckBox(CVV3ExistsChkBx, true);
	}

	public void fillCVV3Cryptogram(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(CVV3CryptogramTxt, hsmKeys.getCVV3Cryptogram());
	}

	public void fillConfirmCVV3Cryptogram(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(ConfirmCVV3CryptogramTxt, hsmKeys.getConfirmCVV3Cryptogram());
	}

	public void fillCVV3KeyCheckvalue(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(CVV3KeyCheckvalueTxt, hsmKeys.getCVV3KeyCheckvalue());
	}

	public void fillConfirmCVV3KeyCheckValue(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(ConfirmCVV3KeyCheckValueTxt, hsmKeys.getConfirmCVV3KeyCheckValue());
	}

	public void fillATCOffsetOnTrack(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(ATCOffsetOnTrackTxt, hsmKeys.getATCOffsetOnTrack());
	}

	public void fillUNOffsetOnTrack(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(UNOffsetOnTrackTxt, hsmKeys.getUNOffsetOnTrack());
	}

	public void fillCVC3OffsetOnTrack(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(CVC3OffsetOnTrackTxt, hsmKeys.getCVVOffsetOnTrack());
	}

	public void clickSaveButton() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(save);
	}

	public void switchToAddDeviceKeysFrame() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_DEVICE_KEYS_FRAME);
	}
}
