package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CurrencyExchangeRateMapping;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.CurrencyExchangeRatesMappingPage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.Navigator;

@Component
public class CurrencyExchangeRatesMappingFlows {
	final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	Navigator navigator;

	@Autowired
	CurrencyExchangeRatesMappingPage currencyExchangeRateMappingPage;

	public void navigateToCurrencyExchangeRatesMappingScreen() {
		navigator.navigateToPage(CurrencyExchangeRatesMappingPage.class);
	}

	public void addCurrencyExchangeRatesMappingFlows(
			CurrencyExchangeRateMapping currencyExchangeRateMappingDomain) {
		currencyExchangeRateMappingPage
				.addNewCurrencyExRatesMapping(currencyExchangeRateMappingDomain);
	}

	public boolean verifyCurrencyExchangeRatesMappingFlows() {
		return currencyExchangeRateMappingPage.verifyNewAddedCERMapping();

	}

}