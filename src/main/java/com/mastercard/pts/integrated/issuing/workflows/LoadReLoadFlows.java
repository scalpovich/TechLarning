package com.mastercard.pts.integrated.issuing.workflows;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.InstitutionCurrencyPage;

/**
 * @author E070234
 * 
 *
 */
@Component
public class LoadReLoadFlows {

	@Autowired
	InstitutionCurrencyPage institutionCurrencyPage;

	/**
	 * Implement this method to perform addition of "institution load currency "
	 * 
	 * @param currency
	 *            which needs to be added
	 * 
	 */
	public void createLoadInstitutionCurrency(String currency) {
		institutionCurrencyPage.addLoadInstitutionCurrency(currency);

	}

	/**
	 * * Implement this method to perform deletion of "institution load currency
	 * "
	 * 
	 * @param currenyName
	 *            which needs to be deleted
	 */

	public void deleteLoadInstitutionCurrency(String currenyName) {
		institutionCurrencyPage.deleteLoadInstitutionCurrency(currenyName);

	}

	/**
	 * Implement this function to perform deletion of all present Load currency
	 */
	public void deleteAllLoadInstitutionCurrency() {
		institutionCurrencyPage.deleteallLoadInstitutionCurrency();

	}

}
