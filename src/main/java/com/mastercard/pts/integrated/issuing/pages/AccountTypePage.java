package com.mastercard.pts.integrated.issuing.pages;

import org.springframework.stereotype.Component;

import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class AccountTypePage {

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addAccountType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:1:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement ISOAccountType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:2:cols:colspanMarkup:inputField:input:inputTextField")
	private MCWebElement HostAccountType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:3:cols:colspanMarkup:inputField:input:inputTextField")
	private MCWebElement AccountDescription;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

}
