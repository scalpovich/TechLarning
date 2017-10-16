package com.mastercard.pts.integrated.issuing.pages;

import org.springframework.stereotype.Component;

import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class HolidayConfigurationPage {

	//	------------- Card Management > Institution Parameter Setup > Holiday Configuration [ISSS02]
	
	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addHolidayConfiguration;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "/html/body/div[2]/div/div/form/table[1]/tbody/tr[1]/td[2]/span/span/span/img")
	private MCWebElement CalendarDate;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "/html/body/div[2]/div/div/form/table[1]/tbody/tr[1]/td[2]/span/span/span/span/table/tbody/tr[1]/td[3]/a")
	private MCWebElement selectDate;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:2:cols:colspanMarkup:inputField:input:inputTextField")
	private MCWebElement Description;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:3:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement Type;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;
	
}
