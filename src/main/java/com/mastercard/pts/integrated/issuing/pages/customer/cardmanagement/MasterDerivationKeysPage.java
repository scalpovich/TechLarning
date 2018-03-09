package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MasterDerivationKeys;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2EMV,
		CardManagementNav.L3_MASTER_DERIVATION_KEYS_MDK})
public class MasterDerivationKeysPage extends AbstractBasePage {
	
	private static final Logger logger = LoggerFactory
			.getLogger(MasterDerivationKeysPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement interchangeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement statusDDwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=binLow]")
	private MCWebElement binLow;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=binHigh]")
	private MCWebElement binHigh;
	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addMasterDerivationKeys;

	@PageElement(findBy = FindBy.NAME, valueToFind = "networkCode:input:dropdowncomponent")
	private MCWebElement interchangeNetworkDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "status:input:dropdowncomponent")
	private MCWebElement statusInputDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "keyType:input:dropdowncomponent")
	private MCWebElement keyTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "binLow:input:inputTextField")
	private MCWebElement binLowTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "binHigh:input:inputTextField")
	private MCWebElement binHighTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mdkEncrypLmk:input:inputTextField")
	private MCWebElement mdkEncryptedUnderLMKTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "confirmMdkEncrypLmk:input:inputTextField")
	private MCWebElement confirmMDKTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mdkKeycheckVal:input:inputTextField")
	private MCWebElement mdkKeyCheckValueTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "confirmMdkKeycheckVal:input:inputTextField")
	private MCWebElement confirmMDKKeyCheckValueTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "isSmi:checkBoxComponent")
	private MCWebElement smiExistsChkBxTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "smiEncrypLmk:input:inputTextField")
	private MCWebElement smiEncryptedUnderLMKTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cnfSmiEncrypLmk:input:inputTextField")
	private MCWebElement confirmSMITxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "smiKeycheckVal:input:inputTextField")
	private MCWebElement sMIKeyCheckvalueTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cnfSmiKeycheckVal:input:inputTextField")
	private MCWebElement confirmSMIKeyCheckvalueTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "isSmc:checkBoxComponent")
	private MCWebElement smcExistsChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "smcEncrytLmk:input:inputTextField")
	private MCWebElement smcEncryptedUnderLMKTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cnfSmcEncrytLmk:input:inputTextField")
	private MCWebElement confirmSMCTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "smcKeycheckVal:input:inputTextField")
	private MCWebElement smcKeyCheckvalueTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cnfSmcKeycheckVal:input:inputTextField")
	private MCWebElement confirmSMCKeyCheckvalue;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	public void addMDK() {
		waitForElementVisible(addMasterDerivationKeys);
		ClickButton(addMasterDerivationKeys);
	}

	public void switchToAddMDKKey() {
		addWicketAjaxListeners(driver());
		switchToIframe(Constants.ADD_MDK_KEY_FRAME);
	}

	public void selectInterchange(MasterDerivationKeys mdkKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectByVisibleText(interchangeNetworkDDwn, mdkKeys.getInterchange());
	}

	public void fillBinLow(MasterDerivationKeys mdkKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(binLowTxt, mdkKeys.getBinLow());
	}

	public void fillBinHigh(MasterDerivationKeys mdkKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(binHighTxt, mdkKeys.getBinHigh());
	}

	public void selectStatus(MasterDerivationKeys mdkKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(statusInputDDwn, mdkKeys.getStatus());
	}

	public void selectKeyType(MasterDerivationKeys mdkKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(keyTypeDDwn, mdkKeys.getKeyType());
	}

	public void fillMDKEncryptedUnderLMK(MasterDerivationKeys mdkKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(mdkEncryptedUnderLMKTxt, mdkKeys.getMDKEncryptedUnderLMK());
	}

	public void fillConfirmMDKEncryptedUnderLMK(MasterDerivationKeys mdkKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(confirmMDKTxt, mdkKeys.getConfirmMDK());
	}

	public void fillMDKKeyCheckvalue(MasterDerivationKeys mdkKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(mdkKeyCheckValueTxt, mdkKeys.getMDKKeyCheckValue());
	}

	public void fillConfirmMDKKeyCheckvalue(MasterDerivationKeys mdkKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(confirmMDKKeyCheckValueTxt, mdkKeys.getConfirmMDKKeyCheckValue());
	}

	public void selectSMIExists() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickCheckBox(smiExistsChkBxTxt, true);
	}

	public void fillSMIEncryptedUnderLMK(MasterDerivationKeys mdkKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(smiEncryptedUnderLMKTxt, mdkKeys.getSMIEncryptedUnderLMKTxt());
	}

	public void fillConfirmSMI(MasterDerivationKeys mdkKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(confirmSMITxt, mdkKeys.getConfirmSMI());
	}

	public void fillSMIkeyCheckvalue(MasterDerivationKeys mdkKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(sMIKeyCheckvalueTxt, mdkKeys.getSMIKeyCheckvalue());
	}

	public void fillConfirmSMIkeyCheckvalue(MasterDerivationKeys mdkKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(confirmSMIKeyCheckvalueTxt, mdkKeys.getConfirmSMIKeyCheckvalue());
	}

	public void selectSMCExists() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickCheckBox(smcExistsChkBx, true);
	}

	public void fillSMCEncryptedUnderLMK(MasterDerivationKeys mdkKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(smcEncryptedUnderLMKTxt, mdkKeys.getSMCEncryptedUnderLMKTxt());
	}

	public void fillConfirmSMC(MasterDerivationKeys mdkKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(confirmSMCTxt, mdkKeys.getConfirmSMC());
	}

	public void fillSMCkeyCheckvalue(MasterDerivationKeys mdkKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(smcKeyCheckvalueTxt, mdkKeys.getSMCKeyCheckvalue());
	}

	public void fillConfirmSMCkeyCheckvalue(MasterDerivationKeys mdkKeys) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(confirmSMCKeyCheckvalue, mdkKeys.getConfirmSMCKeyCheckvalue());
	}

	public void clickSaveBtn() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(saveBtn);
	}

	public void enterMDKDetails(MasterDerivationKeys mdkKeys) {
		fillMDKEncryptedUnderLMK(mdkKeys);
		fillConfirmMDKEncryptedUnderLMK(mdkKeys);
		fillMDKKeyCheckvalue(mdkKeys);
		fillConfirmMDKKeyCheckvalue(mdkKeys);
	}

	public void enterSMIDetails(MasterDerivationKeys mdkKey) {
		selectSMIExists();
		fillSMIEncryptedUnderLMK(mdkKey);
		fillConfirmSMI(mdkKey);
		fillSMIkeyCheckvalue(mdkKey);
		fillConfirmSMIkeyCheckvalue(mdkKey);
	}

	public void enterSMCDetails(MasterDerivationKeys mdkKey) {
		selectSMCExists();
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
				WebElementUtils.elementToBeClickable(interchangeDDwn),
				WebElementUtils.elementToBeClickable(statusDDwn),
				WebElementUtils.elementToBeClickable(binLow),
				WebElementUtils.elementToBeClickable(binHigh)
				);
	}
}
