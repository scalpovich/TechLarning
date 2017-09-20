package com.mastercard.pts.integrated.issuing.steps;

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
import com.mastercard.pts.integrated.issuing.workflows.CurrencyExchangeRatesMappingFlows;

@Component
public class CurrencyExchangeRatesMappingSteps {
	final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CurrencyExchangeRatesMappingFlows currencyExchangeRatesMappingFlows;

	
	public CurrencyExchangeRateMapping currencyExchangeRateMappingDomain= new CurrencyExchangeRateMapping();

	/**
	 * Step Definition for navigating to the Currency Exchange Rates Mapping
	 * page from Home page
	 * <p>
	 * StoryFile usage : When user navigates to Currency Exchange Rates Mapping
	 * screen
	 * <p>
	 */
	@When("user navigates to Currency Exchange Rates Mapping screen")
	public void user_navigates_to_Currency_Exchange_Rates_Mapping_screen() {
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
	public void add_Currency_Exchange_Rates_Mapping(
			@Named("transationSource") String transactionSource,
			@Named("rateOrigin") String rateOrigin) {
		currencyExchangeRateMappingDomain= new CurrencyExchangeRateMapping();
		logger.info("Adding a Currency Exchange Rate Mapping");
		switch (transactionSource) {
		case "System":
		case "system":
			currencyExchangeRateMappingDomain
					.setTransactionSource("System [S]");
			MapUtils.fnSetInputDataToInputMap("Transaction Source",
					"System [S]");
			break;
		case "Mastercard":
		case "mastercard":
			currencyExchangeRateMappingDomain
					.setTransactionSource("Mastercard [M]");
			MapUtils.fnSetInputDataToInputMap("Transaction Source",
					"Mastercard [M]");
			break;
		case "Visa":
		case "visa":
			currencyExchangeRateMappingDomain.setTransactionSource("Visa [V]");
			MapUtils.fnSetInputDataToInputMap("Transaction Source", "Visa [V]");
			break;
		default:
			currencyExchangeRateMappingDomain
					.setTransactionSource("System [S]");
			break;
		}
		switch (rateOrigin) {
		case "Bank":
		case "bank":
			currencyExchangeRateMappingDomain.setRateOrigin("Bank [B]");
			MapUtils.fnSetInputDataToInputMap("Rate Origin", "Bank [B]");
			break;
		case "Mastercard":
		case "mastercard":
			currencyExchangeRateMappingDomain.setRateOrigin("Mastercard [M]");
			MapUtils.fnSetInputDataToInputMap("Rate Origin", "Mastercard [M]");
			break;
		case "Visa":
		case "visa":
			currencyExchangeRateMappingDomain.setRateOrigin("Visa [V]");
			MapUtils.fnSetInputDataToInputMap("Rate Origin", "Visa [V]");
			break;
		default:
			currencyExchangeRateMappingDomain.setRateOrigin("Bank [B]");
			break;
		}

		if (MapUtils.fnGetInputDataFromMap("Program") != null) {
			currencyExchangeRateMappingDomain.setProgram(MapUtils
					.fnGetInputDataFromMap("Program"));
			currencyExchangeRateMappingDomain.setTransactionType(MapUtils
					.fnGetInputDataFromMap("Transaction Type"));
		}
		currencyExchangeRateMappingDomain.setRateType(MapUtils
				.fnGetInputDataFromMap("Rate Type"));
		currencyExchangeRatesMappingFlows
				.addCurrencyExchangeRatesMappingFlows();
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
	public void verify_Currency_Exchange_Rates_Mapping() {
		logger.info("Verifying the newly added Currency Exchange Rate Mapping");
		Assert.assertTrue(currencyExchangeRatesMappingFlows
				.verifyCurrencyExchangeRatesMappingFlows());
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
