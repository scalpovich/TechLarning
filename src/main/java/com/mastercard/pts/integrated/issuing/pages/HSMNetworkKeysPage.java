package com.mastercard.pts.integrated.issuing.pages;

import org.springframework.stereotype.Component;

import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class HSMNetworkKeysPage {
	
//	------------- Card Management > Institution Parameter Setup > Institution Currency [ISSS05]
	
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

}
