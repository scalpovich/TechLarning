package com.mastercard.pts.integrated.issuing.pages;

import org.springframework.stereotype.Component;

import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class HSMDeviceKeysPage {

//	------------- Card Management > Institution Parameter Setup > Institution Currency [ISSS05]
	
	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addHSMDeviceKeys;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrBinInf:input:inputTextField")
	private MCWebElement BinStart;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "bincrBinSup:input:inputTextField")
	private MCWebElement BinEnd;
	
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
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;
	
}
