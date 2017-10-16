package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class BusinessCalenderPage {

	// ------------- Card Management > Institution Parameter Setup > Business
	// Calendar [ISSS01]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addBusinessCalendar;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "/html/body/div[2]/div/div/form/table[1]/tbody/tr[1]/td[2]/span/span/span/img")
	private MCWebElement EffectiveDate;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "/html/body/div[2]/div/div/form/table[1]/tbody/tr[1]/td[2]/span/span/span/span/table/tbody/tr[1]/td[3]/a")
	private MCWebElement selectDate;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

}
