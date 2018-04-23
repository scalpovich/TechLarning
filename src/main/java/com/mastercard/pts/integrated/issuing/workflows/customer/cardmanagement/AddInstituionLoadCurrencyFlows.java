package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.InstitutionLoadCurrencyPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;


@Component
public class AddInstituionLoadCurrencyFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	public void addInstituteLoadCurrency(String currency) {
		InstitutionLoadCurrencyPage page = navigator.navigateToPage(InstitutionLoadCurrencyPage.class);
		page.clickAddcurrency();
		page.addCurrencyDetails(currency);



	}


}