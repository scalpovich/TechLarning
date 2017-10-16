package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class MarkupFeePlanPage {

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addMarkupFeePlan;

	@PageElement(findBy = FindBy.NAME, valueToFind = "markupFeeCode:input:inputTextField")
	private MCWebElement MarkupFeePlanCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "markupDescription:input:inputTextField")
	private MCWebElement Description;

	@PageElement(findBy = FindBy.NAME, valueToFind = "status:input:dropdowncomponent")
	private MCWebElement Status;

	@PageElement(findBy = FindBy.NAME, valueToFind = "defaultRate:input:inputAmountField")
	private MCWebElement DefaultRate;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

}
