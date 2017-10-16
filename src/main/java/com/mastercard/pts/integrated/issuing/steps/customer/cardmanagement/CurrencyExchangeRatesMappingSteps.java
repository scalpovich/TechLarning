package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Composite;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CurrencyExchangeRateMapping;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.CurrencyExchangeRatesMappingFlows;

@Component
public class CurrencyExchangeRatesMappingSteps extends AbstractBaseFlows {
	final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CurrencyExchangeRatesMappingFlows currencyExchangeRatesMappingFlows;

	private CurrencyExchangeRateMapping currencyExchangeRateMappingDomain;

	private static final String SYSTEM_INTERCHANGE = "System [S]";
	private static final String MC_INTERCHANGE = "Mastercard [M]";
	private static final String VISA_INTERCHANGE = "Visa [V]";
	private static final String BANK_INTERCHANGE = "Bank [B]";

	private static final String RATE_ORIGIN = "Rate Origin";
	private static final String TRANSACTION_SOURCE = "Transaction Source";
	private static final String PROGRAM = "Program";

	/**
	 * Step Definition for navigating to the Currency Exchange Rates Mapping
	 * page from Home page
	 * <p>
	 * StoryFile usage : When user navigates to Currency Exchange Rates Mapping
	 * screen
	 * <p>
	 */
	@When("user navigates to Currency Exchange Rates Mapping screen")
	public void navigateCERMappingScreen() {
		logger.info("Navigating to the Currency Exchange Rate Mapping page");
		currencyExchangeRatesMappingFlows
				.navigateToCurrencyExchangeRatesMappingScreen();
	}

	/**
	 * Step Definition for adding new currency Exchange Rate Mapping
	 * <p>
	 * StoryFile usage : When user adds the Currency Exchange Rate Mapping for
	 * the institution
	 * <p>
	 */
	@When("user adds the Currency Exchange Rate Mapping for the $transationSource and $rateOrigin")
	public void addCERMapping(
			@Named("transationSource") String transactionSource,
			@Named("rateOrigin") String rateOrigin) {
		currencyExchangeRateMappingDomain = new CurrencyExchangeRateMapping();
		logger.info("Adding a Currency Exchange Rate Mapping");
		switch (transactionSource) {
		case "System":
		case "system":
			currencyExchangeRateMappingDomain
					.setTransactionSource(SYSTEM_INTERCHANGE);
			MapUtils.fnSetInputDataToInputMap(TRANSACTION_SOURCE,
					SYSTEM_INTERCHANGE);
			break;
		case "Mastercard":
		case "mastercard":
			currencyExchangeRateMappingDomain
					.setTransactionSource(MC_INTERCHANGE);
			MapUtils.fnSetInputDataToInputMap(TRANSACTION_SOURCE,
					MC_INTERCHANGE);
			break;
		case "Visa":
		case "visa":
			currencyExchangeRateMappingDomain
					.setTransactionSource(VISA_INTERCHANGE);
			MapUtils.fnSetInputDataToInputMap(TRANSACTION_SOURCE,
					VISA_INTERCHANGE);
			break;
		default:
			currencyExchangeRateMappingDomain
					.setTransactionSource(SYSTEM_INTERCHANGE);
			break;
		}
		switch (rateOrigin) {
		case "Bank":
		case "bank":
			currencyExchangeRateMappingDomain.setRateOrigin(BANK_INTERCHANGE);
			MapUtils.fnSetInputDataToInputMap(RATE_ORIGIN, BANK_INTERCHANGE);
			break;
		case "Mastercard":
		case "mastercard":
			currencyExchangeRateMappingDomain.setRateOrigin(MC_INTERCHANGE);
			MapUtils.fnSetInputDataToInputMap(RATE_ORIGIN, MC_INTERCHANGE);
			break;
		case "Visa":
		case "visa":
			currencyExchangeRateMappingDomain.setRateOrigin(VISA_INTERCHANGE);
			MapUtils.fnSetInputDataToInputMap(RATE_ORIGIN, VISA_INTERCHANGE);
			break;
		default:
			currencyExchangeRateMappingDomain.setRateOrigin(BANK_INTERCHANGE);
			break;
		}

		if (MapUtils.fnGetInputDataFromMap(PROGRAM) != null) {
			currencyExchangeRateMappingDomain.setProgram(MapUtils
					.fnGetInputDataFromMap(PROGRAM));
			currencyExchangeRateMappingDomain.setTransactionType(MapUtils
					.fnGetInputDataFromMap("Transaction Type"));
		}
		currencyExchangeRateMappingDomain.setRateType(MapUtils
				.fnGetInputDataFromMap("Rate Type"));
		currencyExchangeRatesMappingFlows
				.addCurrencyExchangeRatesMappingFlows(currencyExchangeRateMappingDomain);
	}

	/**
	 * Step Definition for verification for the added currency Exchange Rate
	 * Mapping
	 * <p>
	 * StoryFile usage : Then verify that the currency exchange rate Mapping is
	 * added into the system
	 * <p>
	 */
	@Then("verify that the CER Mapping is added into the system")
	public void verifyCERMapping() {
		logger.info("Verifying the newly added Currency Exchange Rate Mapping");
		Assert.assertTrue(currencyExchangeRatesMappingFlows
				.verifyCurrencyExchangeRatesMappingFlows());
		sessionExpiryloginInAgain();
	}

	// Currency Exchange Rate Mapping
	@When("user creates CER mapping for $transactionSource and $rateOrigin through screen")
	@Alias("user creates CER mapping for <transactionSource> and <rateOrigin> through screen")
	@Composite(steps = {
			"When user navigates to Currency Exchange Rates Mapping screen",
			"When user adds the Currency Exchange Rate Mapping for the <transactionSource> and <rateOrigin>" })
	public void createCurrencyExchangeRateMC(
			@Named("transactionSource") String transactionSource,
			@Named("rateOrigin") String rateOrigin) {
		StringBuilder sb = new StringBuilder(
				"User creates Currency Exchange Rates Mapping for ");
		sb.append(transactionSource).append(" and Rate Origin as ")
				.append(rateOrigin);
		logger.info(sb.toString());
	}


}
