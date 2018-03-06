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
	private MCWebElement addHSMNetworkKeysBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "netcrField:input:dropdowncomponent")
	private MCWebElement networkInterfaceDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "netcrSecNet:input:inputTextField")
	private MCWebElement subNetworkIDTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "netcrKeyIndex:input:inputTextField")
	private MCWebElement keyIndexTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "netcrKeytyp:input:dropdowncomponent")
	private MCWebElement keyTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "netcrCrypto:input:inputTextField")
	private MCWebElement networkCryptogramTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "netcrTempCrypto:input:inputTextField")
	private MCWebElement confirmNetworkCryptogramTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "netcrKchkValue:input:inputTextField")
	private MCWebElement networkCryptogramCheckValueTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "netcrTempKchkValue:input:inputTextField")
	private MCWebElement confirmNetworkCryptogramCheckValueTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;
		
	public void addHSMKeys() {
		waitForElementVisible(addHSMNetworkKeysBtn);
		ClickButton(addHSMNetworkKeysBtn);
	}

	public void switchToAddNetworkKeys() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_NETWORK_KEYS_FRAME);
	}

	public void selectNetworkInterface(HSMNetworkKeys hsmnetwork) {

		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(networkInterfaceDDwn); 
		selectByVisibleText(networkInterfaceDDwn, hsmnetwork.getNetworkInterface());
		
	}

	public void fillSubNetworkID(HSMNetworkKeys hsmnetwork) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(subNetworkIDTxt);
		enterText(subNetworkIDTxt, hsmnetwork.getSubNetworkID());
	}

	public void fillKeyIndex(HSMNetworkKeys hsmnetwork) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(keyIndexTxt);
		enterText(keyIndexTxt, hsmnetwork.getKeyIndex());
	}

	public void selectKeyType(HSMNetworkKeys hsmnetwork) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(keyTypeDDwn);
		selectByVisibleText(keyTypeDDwn, hsmnetwork.getKeyType());
	}

	public void fillNetworkCryptogram(HSMNetworkKeys hsmnetwork) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(networkCryptogramTxt);
		enterText(networkCryptogramTxt, hsmnetwork.getNetworkCryptogram());
	}

	public void fillConfirmNetworkCryptogram(HSMNetworkKeys hsmnetwork) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(confirmNetworkCryptogramTxt);
		enterText(confirmNetworkCryptogramTxt, hsmnetwork.getConfirmNetworkCryptogram());
	}

	public void fillNetworkCryptogramCheckValue(HSMNetworkKeys hsmnetwork) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(networkCryptogramCheckValueTxt);
		enterText(networkCryptogramCheckValueTxt, hsmnetwork.getNetworkCryptogramCheckValue());
	}

	public void fillConfirmNetworkCryptogramCheckValue(HSMNetworkKeys hsmnetwork) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(confirmNetworkCryptogramCheckValueTxt);
		enterText(confirmNetworkCryptogramCheckValueTxt, hsmnetwork.getConfirmNetworkCryptogramCheckValue());

	}

	public void clickSaveBtn() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(saveBtn);
		ClickButton(saveBtn);
	}
}
