package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CurrencyExchangeRate;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.CurrencyExchangeRatesPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.ProcessBatchesPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;

@Component
public class CurrencyExchangeRatesFlows {
	final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	Navigator navigator;

	@Autowired
	CurrencyExchangeRatesPage currencyExchangeRatesPage;

	public void navigateToCurrencyExchangeRatesScreen() {
		navigator.navigateToPage(CurrencyExchangeRatesPage.class);
	}

	public void addCurrencyExchangeRateFlows(
			CurrencyExchangeRate currencyExchangeRateDomainPage) {
		currencyExchangeRatesPage
				.addCurrencyExchangeRate(currencyExchangeRateDomainPage);
	}

	public boolean verifyCurrencyExchangeRateFlows(
			CurrencyExchangeRate currencyExchangeRateDomainPage) {
		return currencyExchangeRatesPage
				.verifyAddedCurrencyExchangeRate(currencyExchangeRateDomainPage);
	}

	public void uploadCurrencyExchangeFileFlows(String type, String filePath) {
		currencyExchangeRatesPage
				.uploadCurrencyExchangeRateFile(type, filePath);
	}

	public void navigateProcessBatchesScreenFlows() {
		navigator.navigateToPage(ProcessBatchesPage.class);
	}

	public boolean verifyFileUploadFlows() {
		navigator.navigateToPage(CurrencyExchangeRatesPage.class);
		CustomUtils.ThreadDotSleep(500);
		return currencyExchangeRatesPage.verifyCERFileUpload();
	}

	public void uploadFileBankInvalidFileFlows(String isInvalid, String filePath) {
		currencyExchangeRatesPage
.uploadInvalidCurrencyExchangeRateFile(
				isInvalid, filePath);
	}

}