package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.HSMNetworkKeys;
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
		CardManagementNav.L3NETWORK_KEYS })
public class HSMNetworkKeysPage extends AbstractBasePage {

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addHSMNetworkKeys;

	@PageElement(findBy = FindBy.NAME, valueToFind = "netcrField:input:dropdowncomponent")
	private MCWebElement NetworkInterface;

	@PageElement(findBy = FindBy.NAME, valueToFind = "netcrSecNet:input:inputTextField")
	private MCWebElement SubNetworkID;

	@PageElement(findBy = FindBy.NAME, valueToFind = "netcrKeyIndex:input:inputTextField")
	private MCWebElement KeyIndex;

	@PageElement(findBy = FindBy.NAME, valueToFind = "netcrKeytyp:input:dropdowncomponent")
	private MCWebElement KeyType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "netcrCrypto:input:inputTextField")
	private MCWebElement NetworkCryptogram;

	@PageElement(findBy = FindBy.NAME, valueToFind = "netcrTempCrypto:input:inputTextField")
	private MCWebElement ConfirmNetworkCryptogram;

	@PageElement(findBy = FindBy.NAME, valueToFind = "netcrKchkValue:input:inputTextField")
	private MCWebElement NetworkCryptogramCheckValue;

	@PageElement(findBy = FindBy.NAME, valueToFind = "netcrTempKchkValue:input:inputTextField")
	private MCWebElement ConfirmNetworkCryptogramCheckValue;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

	public void addHSMKeys() {
		waitForElementVisible(addHSMNetworkKeys);
		ClickButton(addHSMNetworkKeys);
	}

	public void switchToAddNetworkKeys() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_NETWORK_KEYS_FRAME);
	}

	public void SelectNetworkInterface(HSMNetworkKeys hsmnetwork) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(NetworkInterface);
		SelectDropDownByText(NetworkInterface, hsmnetwork.getNetworkInterface());
	}

	public void fillSubNetworkID(HSMNetworkKeys hsmnetwork) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(SubNetworkID);
		enterText(SubNetworkID, hsmnetwork.getSubNetworkID());
	}

	public void fillKeyIndex(HSMNetworkKeys hsmnetwork) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(KeyIndex);
		enterText(KeyIndex, hsmnetwork.getKeyIndex());
	}

	public void SelectKeyType(HSMNetworkKeys hsmnetwork) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(KeyType);
		SelectDropDownByText(KeyType, hsmnetwork.getKeyType());
	}

	public void fillNetworkCryptogram(HSMNetworkKeys hsmnetwork) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(NetworkCryptogram);
		SelectDropDownByText(NetworkCryptogram, hsmnetwork.getNetworkCryptogram());
	}

	public void fillConfirmNetworkCryptogram(HSMNetworkKeys hsmnetwork) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(ConfirmNetworkCryptogram);
		SelectDropDownByText(ConfirmNetworkCryptogram, hsmnetwork.getConfirmNetworkCryptogram());
	}

	public void fillNetworkCryptogramCheckValue(HSMNetworkKeys hsmnetwork) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(NetworkCryptogramCheckValue);
		SelectDropDownByText(NetworkCryptogramCheckValue, hsmnetwork.getNetworkCryptogramCheckValue());
	}

	public void fillConfirmNetworkCryptogramCheckValue(HSMNetworkKeys hsmnetwork) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(ConfirmNetworkCryptogramCheckValue);
		SelectDropDownByText(ConfirmNetworkCryptogramCheckValue, hsmnetwork.getConfirmNetworkCryptogramCheckValue());
	}

	public void clickSaveBtn() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(save);
		ClickButton(save);
	}
}
