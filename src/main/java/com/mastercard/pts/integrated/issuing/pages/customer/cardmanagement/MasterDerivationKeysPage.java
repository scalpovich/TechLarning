package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MasterDerivationKeys;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_EMV,
		CardManagementNav.L3_MASTER_DERIVATION_KEYS_MDK})
public class MasterDerivationKeysPage extends AbstractModelPage {
	
	private static final Logger logger = LoggerFactory
			.getLogger(MasterDerivationKeysPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement interchange;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addMasterDerivationKeys;

	@PageElement(findBy = FindBy.NAME, valueToFind = "networkCode:input:dropdowncomponent")
	private MCWebElement Interchange;

	@PageElement(findBy = FindBy.NAME, valueToFind = "status:input:dropdowncomponent")
	private MCWebElement Status;
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement status;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=binLow]")
	private MCWebElement binLow;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=binHigh]")
	private MCWebElement binHigh;
	

	@PageElement(findBy = FindBy.NAME, valueToFind = "keyType:input:dropdowncomponent")
	private MCWebElement KeyType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "binLow:input:inputTextField")
	private MCWebElement BinLow;

	@PageElement(findBy = FindBy.NAME, valueToFind = "binHigh:input:inputTextField")
	private MCWebElement BinHigh;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mdkEncrypLmk:input:inputTextField")
	private MCWebElement MDKEncryptedUnderLMK;

	@PageElement(findBy = FindBy.NAME, valueToFind = "confirmMdkEncrypLmk:input:inputTextField")
	private MCWebElement ConfirmMDK;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mdkKeycheckVal:input:inputTextField")
	private MCWebElement MDKKeyCheckValue;

	@PageElement(findBy = FindBy.NAME, valueToFind = "confirmMdkKeycheckVal:input:inputTextField")
	private MCWebElement ConfirmMDKKeyCheckValue;

	@PageElement(findBy = FindBy.NAME, valueToFind = "isSmi:checkBoxComponent")
	private MCWebElement SMIExistsChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "smiEncrypLmk:input:inputTextField")
	private MCWebElement SMIEncryptedUnderLMKTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cnfSmiEncrypLmk:input:inputTextField")
	private MCWebElement ConfirmSMI;

	@PageElement(findBy = FindBy.NAME, valueToFind = "smiKeycheckVal:input:inputTextField")
	private MCWebElement SMIKeyCheckvalue;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cnfSmiKeycheckVal:input:inputTextField")
	private MCWebElement ConfirmSMIKeyCheckvalue;

	@PageElement(findBy = FindBy.NAME, valueToFind = "isSmc:checkBoxComponent")
	private MCWebElement SMCExistsChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "smcEncrytLmk:input:inputTextField")
	private MCWebElement SMCEncryptedUnderLMKTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cnfSmcEncrytLmk:input:inputTextField")
	private MCWebElement ConfirmSMC;

	@PageElement(findBy = FindBy.NAME, valueToFind = "smcKeycheckVal:input:inputTextField")
	private MCWebElement SMCKeyCheckvalue;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cnfSmcKeycheckVal:input:inputTextField")
	private MCWebElement ConfirmSMCKeyCheckvalue;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

	public void addMDK() {
		waitForElementVisible(addMasterDerivationKeys);
		ClickButton(addMasterDerivationKeys);
	}

	public void switchToAddMDKKey() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_MDK_KEY_FRAME);
	}

	public void SelectInterchange(MasterDerivationKeys mdkKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(Interchange, mdkKeys.getInterchange());
	}

	public void fillBinLow(MasterDerivationKeys mdkKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(BinLow, mdkKeys.getBinLow());
	}

	public void fillBinHigh(MasterDerivationKeys mdkKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(BinHigh, mdkKeys.getBinHigh());
	}

	public void SelectStatus(MasterDerivationKeys mdkKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(Status, mdkKeys.getStatus());
	}

	public void SelectKeyType(MasterDerivationKeys mdkKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(KeyType, mdkKeys.getKeyType());
	}

	public void fillMDKEncryptedUnderLMK(MasterDerivationKeys mdkKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(MDKEncryptedUnderLMK, mdkKeys.getMDKEncryptedUnderLMK());
	}

	public void fillConfirmMDKEncryptedUnderLMK(MasterDerivationKeys mdkKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(ConfirmMDK, mdkKeys.getConfirmMDK());
	}

	public void fillMDKKeyCheckvalue(MasterDerivationKeys mdkKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(MDKKeyCheckValue, mdkKeys.getMDKKeyCheckValue());
	}

	public void fillConfirmMDKKeyCheckvalue(MasterDerivationKeys mdkKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(ConfirmMDKKeyCheckValue, mdkKeys.getConfirmMDKKeyCheckValue());
	}

	public void SelectSMIExists() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickCheckBox(SMIExistsChkBx, true);
	}

	public void fillSMIEncryptedUnderLMK(MasterDerivationKeys mdkKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(SMIEncryptedUnderLMKTxt, mdkKeys.getSMIEncryptedUnderLMKTxt());
	}

	public void fillConfirmSMI(MasterDerivationKeys mdkKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(ConfirmSMI, mdkKeys.getConfirmSMI());
	}

	public void fillSMIkeyCheckvalue(MasterDerivationKeys mdkKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(SMIKeyCheckvalue, mdkKeys.getSMIKeyCheckvalue());
	}

	public void fillConfirmSMIkeyCheckvalue(MasterDerivationKeys mdkKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(ConfirmSMIKeyCheckvalue, mdkKeys.getConfirmSMIKeyCheckvalue());
	}

	public void SelectSMCExists() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickCheckBox(SMCExistsChkBx, true);
	}

	public void fillSMCEncryptedUnderLMK(MasterDerivationKeys mdkKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(SMCEncryptedUnderLMKTxt, mdkKeys.getSMCEncryptedUnderLMKTxt());
	}

	public void fillConfirmSMC(MasterDerivationKeys mdkKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(ConfirmSMC, mdkKeys.getConfirmSMC());
	}

	public void fillSMCkeyCheckvalue(MasterDerivationKeys mdkKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(SMCKeyCheckvalue, mdkKeys.getSMCKeyCheckvalue());
	}

	public void fillConfirmSMCkeyCheckvalue(MasterDerivationKeys mdkKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(ConfirmSMCKeyCheckvalue, mdkKeys.getConfirmSMCKeyCheckvalue());
	}

	public void clickSaveBtn() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(save);
	}

	public void enterMDKDetails(MasterDerivationKeys mdkKeys) {
		fillMDKEncryptedUnderLMK(mdkKeys);
		fillConfirmMDKEncryptedUnderLMK(mdkKeys);
		fillMDKKeyCheckvalue(mdkKeys);
		fillConfirmMDKKeyCheckvalue(mdkKeys);
	}

	public void enterSMIDetails(MasterDerivationKeys mdkKey) {
		SelectSMIExists();
		fillSMIEncryptedUnderLMK(mdkKey);
		fillConfirmSMI(mdkKey);
		fillSMIkeyCheckvalue(mdkKey);
		fillConfirmSMIkeyCheckvalue(mdkKey);
	}

	public void enterSMCDetails(MasterDerivationKeys mdkKey) {
		SelectSMCExists();
		fillSMCEncryptedUnderLMK(mdkKey);
		fillConfirmSMC(mdkKey);
		fillSMCkeyCheckvalue(mdkKey);
		fillConfirmSMCkeyCheckvalue(mdkKey);
	}
	public void verifyUiOperationStatus() {
		logger.info("MDK Key");
		verifyUiOperation("Add MDK Key");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(interchange),
				WebElementUtils.elementToBeClickable(status),
				WebElementUtils.elementToBeClickable(binLow),
				WebElementUtils.elementToBeClickable(binHigh)
				);
	}

}
