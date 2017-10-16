package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.InstitutionCurrency;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.InstitutionCurrencyPage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class InstitutionCurrencyFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	public void addInstitutionCurrency(InstitutionCurrency institutioncurrency) {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		InstitutionCurrencyPage institutioncurrencyPage = navigator.navigateToPage(InstitutionCurrencyPage.class);
		institutioncurrencyPage.clickAddInstitutionCurrency();
		institutioncurrencyPage.selectInstitutionCurrency(institutioncurrency);
		institutioncurrencyPage.selectStatus(institutioncurrency);
		institutioncurrencyPage.clickSaveBtn();
		waitForPageToLoad(getFinder().getWebDriver());
		institutioncurrencyPage.verifyNewInstutionCurrencySuccess();
	}
}
