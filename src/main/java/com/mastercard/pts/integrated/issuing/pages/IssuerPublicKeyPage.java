package com.mastercard.pts.integrated.issuing.pages;

import org.springframework.stereotype.Component;

import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class IssuerPublicKeyPage {
	
//	------------- Card Management > Institution Parameter Setup > Institution Currency [ISSS05]
	
	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addIssuerPublicKey;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:1:cols:colspanMarkup:inputField:input:inputTextField")
	private MCWebElement IPKID;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:1:cols:nextCol:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement Interchange;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:2:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement IssuerBIN;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:2:cols:nextCol:colspanMarkup:inputField:input:inputTextField")
	private MCWebElement SerialNumber;
	
	@PageElement(findBy = FindBy.CLASS, valueToFind = "tables:1:rows:3:cols:colspanMarkup:inputField:input:dateTextField")
	private MCWebElement IssueDate;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:3:cols:nextCol:colspanMarkup:inputField:input:dateTextField")
	private MCWebElement ExpiryDate;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:4:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement Status;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

}
