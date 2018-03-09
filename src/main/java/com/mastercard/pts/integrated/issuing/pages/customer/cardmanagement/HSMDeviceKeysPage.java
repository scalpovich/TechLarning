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
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(binStartTxt);
		enterText(binStartTxt, hsmKeys.getBinStart());
	}

	public void fillBinEnd(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(binEndTxt);
		enterText(binEndTxt, hsmKeys.getBinEnd());
	}

	public void selectPINDataCheckBox() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickCheckBox(pinDataExistsChkBx, true);
	}

	public void selectGenerationMethod(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(generationMethodDDwn);
		SelectDropDownByText(generationMethodDDwn, hsmKeys.getGenerationMethodDDwn());
	}

	public void fillDecimalization(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(decimalizationTabletxt);
		enterText(decimalizationTabletxt, hsmKeys.getDecimalizationTable());
	}

	public void fillPINlength(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(pinLengthtxt);
		enterText(pinLengthtxt, hsmKeys.getPINlength());
	}

	public void selectPVKiExistsCheckBox() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickCheckBox(pvkiExistsChkBx, true);
	}

	public void fillPVVOffset(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(pvvOffsetOnTrackTxt, hsmKeys.getPVVOffset());
	}

	public void fillPVKOffset(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(pvkiOffsetOnTrackTxt, hsmKeys.getPVKOffset());
	}

	public void selectPVKDataExistsCheckBox() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickCheckBox(pvkDataExistsChkBx, true);
	}

	public void fillPINValidationData(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(pinValidationDataTxt, hsmKeys.getPINValidationData());
	}

	public void fillConfirmValidationData(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(confirmValidationDataTxt, hsmKeys.getPINValidationData());
	}

	public void fillPINVerificationKey(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(pinVerificationKeyTxt, hsmKeys.getPINVerificationKey());
	}

	public void fillConfirmPINVerificationKey(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(confirmPINVerificationKeyTxt, hsmKeys.getPINVerificationKey());
	}

	public void fillPINVerificationKeyCheck(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(pinVerificationKeyCheckTxt, hsmKeys.getPINVerificationKeyCheck());
	}

	public void fillConfirmPINVerificationKeyCheck(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(confirmPINVerificationKeyCheckTxt, hsmKeys.getPINVerificationKeyCheck());
	}

	public void selectCVVExistsCheckBox() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickCheckBox(cvvExistsChkBx, true);
	}

	public void selectControlFlagCheckBox() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickCheckBox(controlFlagChkBx, true);
	}

	public void fillCVVOffsetOnTrack(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(cvvOffsetOnTrackTxt, hsmKeys.getCVVOffsetOnTrack());
	}
	public void selectComponentType(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(driver());
		waitForElementVisible(componentTypeDDwn);
		SelectDropDownByText(componentTypeDDwn, hsmKeys.getcomponentType());
	}
	
	public void fillCVKACryptogram(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(cvkACryptogramTxt, hsmKeys.getCVKACryptogram());
	}

	public void fillConfirmACryptogram(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(confirmACryptogramTxt, hsmKeys.getConfirmACryptogram());
	}

	public void fillCVKAKeyCheck(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(cvkAKeyCheckTxt, hsmKeys.getCVKAKeyCheck());
	}

	public void fillConfirmAKeyCheck(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(confirmAKeyCheckTxt, hsmKeys.getConfirmAKeyCheck());
	}

	public void fillCVKBCryptogram(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(cvkBCryptogramTxt, hsmKeys.getCVKBCryptogram());
	}

	public void fillConfirmBCryptogram(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(confirmBCryptogramTxt, hsmKeys.getConfirmBCryptogram());
	}

	public void fillCVKBKeyCheck(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(cvkBKeyCheckTxt, hsmKeys.getCVKBKeyCheck());
	}

	public void fillConfirmBKeyCheck(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(confirmBKeyCheckTxt, hsmKeys.getConfirmBKeyCheck());
	}

	public void selectCVV3ExistsCheckBox() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickCheckBox(cvv3ExistsChkBx, true);
	}

	public void fillCVV3Cryptogram(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(cvv3CryptogramTxt, hsmKeys.getCVV3Cryptogram());
	}

	public void fillConfirmCVV3Cryptogram(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(confirmCVV3CryptogramTxt, hsmKeys.getConfirmCVV3Cryptogram());
	}

	public void fillCVV3KeyCheckvalue(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(cvv3KeyCheckvalueTxt, hsmKeys.getCVV3KeyCheckvalue());
	}

	public void fillConfirmCVV3KeyCheckValue(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(confirmCVV3KeyCheckValueTxt, hsmKeys.getConfirmCVV3KeyCheckValue());
	}

	public void fillATCOffsetOnTrack(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(atcOffsetOnTrackTxt, hsmKeys.getATCOffsetOnTrack());
	}

	public void fillUNOffsetOnTrack(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(unOffsetOnTrackTxt, hsmKeys.getUNOffsetOnTrack());
	}

	public void fillCVC3OffsetOnTrack(HSMDeviceKeys hsmKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(cvc3OffsetOnTrackTxt, hsmKeys.getCVVOffsetOnTrack());
	}
	@Override
	public void clickSaveButton() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(saveBtn);
	}

	public void switchToAddDeviceKeysFrame() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_DEVICE_KEYS_FRAME);
	}
}
