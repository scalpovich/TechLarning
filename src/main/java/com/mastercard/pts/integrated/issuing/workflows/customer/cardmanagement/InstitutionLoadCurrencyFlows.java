package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.AddInstitutionLoadCurrency;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.InstitutionLoadCurrencyPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;


@Component
public class InstitutionLoadCurrencyFlows {

	@Autowired
	Navigator navigator;
	String currencyValue =null;
	public void addInstituteLoadCurrency(AddInstitutionLoadCurrency addLoadCurrency) {
		InstitutionLoadCurrencyPage page = navigator.navigateToPage(InstitutionLoadCurrencyPage.class);
		page.clickAddCurrency();
		page.addCurrencyDetails(addLoadCurrency);

	}
	public void addMultipleCurrencies(AddInstitutionLoadCurrency addLoadCurrency){
		String value= addLoadCurrency.getCurrency();
		String[] currency = value.split(":");
		for (int i = 0; i < currency.length; i++)
		{
			currencyValue = currency[i].trim();
			addLoadCurrency.setCurrency(currencyValue);
			addInstituteLoadCurrency(addLoadCurrency);

		}
	}


}