package com.mastercard.pts.integrated.issuing.pages;

import org.springframework.stereotype.Component;

import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class MasterDerivationKeysPage {
	
//	------------- Card Management > Institution Parameter Setup > Institution Currency [ISSS05]
	
	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addMasterDerivationKeys;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "networkCode:input:dropdowncomponent")
	private MCWebElement Interchange;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "status:input:dropdowncomponent")
	private MCWebElement Status;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "keyType:input:dropdowncomponent")
	private MCWebElement KeyType;
	
	@PageElement(findBy = FindBy.CLASS, valueToFind = "binLow:input:inputTextField")
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

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

}
