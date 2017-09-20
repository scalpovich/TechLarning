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

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CurrencyExchangeRate;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ProcessBatches;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.CurrencyExchangeRatesPage;
import com.mastercard.pts.integrated.issuing.utils.FileCreation;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.workflows.BatchProcessFlows;
import com.mastercard.pts.integrated.issuing.workflows.CurrencyExchangeRatesFlows;
import com.mastercard.pts.integrated.issuing.workflows.ProcessBatchesFlows;

@Component
public class CurrencyExchangeRatesSteps {
	final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CurrencyExchangeRatesFlows currencyExchangeFlows;

	
	CurrencyExchangeRate currencyExchangeRateDomainPage = new CurrencyExchangeRate();

	@Autowired
	ProcessBatches processBatchesDomainPage;

	@Autowired
	ProcessBatchesFlows processBatchesFlows;

	@Autowired
	CurrencyExchangeRatesPage currencyExchangeRatesPage;

	@Autowired
	private FileCreation fileCreation;

	@Autowired
	private com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ProcessBatches processBatch;

	@Autowired
	private BatchProcessFlows batchProcessingFlows;

	/**
	 * Step Definition for navigating to the Currency Exchange Rates page from
	 * Home page
	 * <p>
	 * StoryFile usage : When user navigates to Currency Exchange Rates screen
	 * <p>
	 */
	@When("user navigates to Currency Exchange Rates screen")
	public void user_navigates_to_Currency_Exchange_Rates_screen() {
		logger.info("Navigating to the Currency Exchange Rate page");
		currencyExchangeFlows.navigateToCurrencyExchangeRatesScreen();
	}

	/**
	 * Step Definition for adding a new currency exchange rate for the
	 * institution
	 * <p>
	 * StoryFile usage : When user adds the Currency Exchange Rate for the
	 * institution
	 * <p>
	 */
	@When("user adds the Currency Exchange Rate for $Mastercard")
	public void add_currency_exchange_rate(String rateOrigin) {
		logger.info("Add a new Currency Exchange Rate for the system");
		currencyExchangeRateDomainPage.setSourceCurrency(MapUtils
				.fnGetInputDataFromMap("Source Currency"));
		currencyExchangeRateDomainPage.setDestinationCurrency(MapUtils
				.fnGetInputDataFromMap("Destination Currency"));
		currencyExchangeRateDomainPage.setBuyRate(MapUtils
				.fnGetInputDataFromMap("BuyRate"));
		currencyExchangeRateDomainPage.setMidRate(MapUtils
				.fnGetInputDataFromMap("MidRate"));
		currencyExchangeRateDomainPage.setSellRate(MapUtils
				.fnGetInputDataFromMap("SellRate"));
		if (MapUtils.fnGetInputDataFromMap("Program") != null)
			currencyExchangeRateDomainPage.setProgram(MapUtils
					.fnGetInputDataFromMap("Program"));
		switch (rateOrigin) {
		case "Bank":
		case "bank":
			currencyExchangeRateDomainPage.setRateOrigin("Bank [B]");
			MapUtils.fnSetInputDataToInputMap("Rate Origin", "Bank [B]");
			break;
		case "Mastercard":
		case "mastercard":
			currencyExchangeRateDomainPage.setRateOrigin("Mastercard [M]");
			MapUtils.fnSetInputDataToInputMap("Rate Origin", "Mastercard [M]");
			break;
		case "Visa":
		case "visa":
			currencyExchangeRateDomainPage.setRateOrigin("Visa [V]");
			MapUtils.fnSetInputDataToInputMap("Rate Origin", "Visa [V]");
			break;
		default:
			currencyExchangeRateDomainPage.setRateOrigin("Bank [B]");
			break;
		}
		currencyExchangeFlows.addCurrencyExchangeRateFlows();
	}

	/**
	 * Step Definition for verifying the currency exchange rate is successfully
	 * added int the institution
	 * <p>
	 * StoryFile usage : Then verify that the currency exchange rate is added
	 * into the system
	 * <p>
	 */
	@Then("verify that the currency exchange rate is added into the system")
	public void verify_that_the_currency_exchange_rate_is_added() {
		logger.info("Verifying that Currency Exchange Rate is added into the system");
		Assert.assertTrue(currencyExchangeFlows
				.verifyCurrencyExchangeRateFlows());
	}

	/**
	 * Step Definition for uploading the Currency Exchange Rate file
	 * <p>
	 * StoryFile usage : When user uploads the currency exchange rates file
	 * <p>
	 */
	@When("user uploads the currency exchange rates file for $bank")
	public void user_uploads_the_currency_exchange_rates_file(String rateOrigin) {
		logger.info("Uploading the Currency Exchange Rate file");
		if (rateOrigin.equals("bank")) {
			currencyExchangeRateDomainPage
					.setSourceCurrency(currencyExchangeRatesPage
							.getCode(MapUtils
									.fnGetInputDataFromMap("Source Currency")));
			currencyExchangeRateDomainPage
					.setDestinationCurrency(currencyExchangeRatesPage.getCode(MapUtils
							.fnGetInputDataFromMap("Destination Currency")));
			currencyExchangeRateDomainPage
					.setRateOrigin(currencyExchangeRatesPage.getCode(MapUtils
							.fnGetInputDataFromMap("Rate Origin")));
			currencyExchangeRateDomainPage.setBuyRate(MapUtils
					.fnGetInputDataFromMap("BUY_RATE"));
			currencyExchangeRateDomainPage.setMidRate(MapUtils
					.fnGetInputDataFromMap("MID_RATE"));
			currencyExchangeRateDomainPage.setSellRate(MapUtils
					.fnGetInputDataFromMap("SELL_RATE"));
			if (MapUtils.fnGetInputDataFromMap("Program") != null)
				currencyExchangeRateDomainPage
						.setProgram(currencyExchangeRatesPage.getCode(MapUtils
								.fnGetInputDataFromMap("Program")));
		} else if (rateOrigin.equals("Mastercard")) {
			currencyExchangeRateDomainPage
					.setSourceCurrency(currencyExchangeRatesPage
							.getCode(MapUtils
									.fnGetInputDataFromMap("Source Currency")));
			currencyExchangeRateDomainPage
					.setDestinationCurrency(currencyExchangeRatesPage.getCode(MapUtils
							.fnGetInputDataFromMap("Destination Currency")));
			currencyExchangeRateDomainPage.setBuyRate(MapUtils
					.fnGetInputDataFromMap("BUY_RATE"));
			currencyExchangeRateDomainPage.setMidRate(MapUtils
					.fnGetInputDataFromMap("MID_RATE"));
			currencyExchangeRateDomainPage.setSellRate(MapUtils
					.fnGetInputDataFromMap("SELL_RATE"));
		}
		currencyExchangeFlows.uploadCurrencyExchangeFileFlows(rateOrigin);
	}

	/**
	 * Step Definition for navigating to the Process Batches screen
	 * <p>
	 * StoryFile usage : When user navigates to the Process Batches screen
	 * <p>
	 */
	@When("user navigates to the Process Batches screen")
	public void user_navigates_to_the_Process_Batches_screen() {
		logger.info("Navigating to the Process Batches page");
		currencyExchangeFlows.navigateProcessBatchesScreenFlows();
	}

	/**
	 * Step Definition for Processing batches
	 * <p>
	 * StoryFile usage : When user runs Process Batches for $batchType for
	 * $batchName file
	 * <p>
	 */
	@When("user runs Process Batches for $upload for $CurrencyExchangeRate file")
	public void user_runs_Process_Batches_for_upload_for_CurrencyExchangeRate_file(
			String batchType, String batchName) {
		logger.info("Running the Process Batches for " + batchType
				+ " and for file type " + batchName);
		processBatchesDomainPage.setBatchName(batchName);
		processBatchesDomainPage.setBatchType(batchType);
		processBatchesFlows.runProcessBatchFlows();
	}

	/**
	 * Step Definition for verifying if upload is successful
	 * <p>
	 * StoryFile usage : Then verify that the $CurrencyExchangeRate file is
	 * uploaded successfully
	 * <p>
	 */
	@Then("verify that the $CurrencyExchangeRate file is uploaded sucessfully")
	public void verifyFileUpload(String fileType) {
		logger.info("Verification for the " + fileType + " file upload");
		Assert.assertTrue(processBatchesFlows.verifyFileProcessFlows());
		Assert.assertTrue(currencyExchangeFlows.verifyFileUploadFlows());
	}

	/**
	 * Step Definition for verifying if upload is successful
	 * <p>
	 * StoryFile usage : Then verify that the $CurrencyExchangeRate file is
	 * uploaded sucessfully
	 * <p>
	 */
	@When("user creates $Currency_Exchange_Rate file $Bank and uploads it on server")
	public void createAndUploadFile(
			@Named("Currency_Exchange_Rate") String fileType,
			@Named("Bank") String uploadType) {
		logger.info("Creating the " + fileType
				+ " file and uploading it to the server");
		String fileName = "";
		if (uploadType.equalsIgnoreCase("Bank"))
			fileCreation.createCERUploadFileBank();
		else if (uploadType.equalsIgnoreCase("Mastercard"))
			fileCreation.createCERFileMC();
		processBatch.setJoBID(batchProcessingFlows.processUploadBatches(
				fileType, fileName));
	}

	// Currency Exchange Rate: Screen
	@When("user creates currency exchange rates for $interchange through screen")
	@Alias("user creates currency exchange rates for <interchange> through screen")
	@Composite(steps = {
			"When user navigates to Currency Exchange Rates screen",
			"When user adds the Currency Exchange Rate for <interchange>" })
	public void createCurrencyExchangeRateMC(
			@Named("interchange") String interchange) {
		logger.info("User creates Currency Exchange Rates through screen for "
				+ interchange);
	}

	// Currency Exchange Rate: File Upload
	@When("user uploads the CER file for $interchange")
	@Composite(steps = {
			"When user navigates to the Process Batches screen",
			"When user uploads the currency exchange rates file for <interchange>",
			"When user runs Process Batches for upload for Currency Exchange Rate file" })
	public void uploadCurrencyExchangeRateBank(
			@Named("interchange") String interchange) {
		logger.info("User uploads the Currency Exchange Rates file for "
				+ interchange);
	}

}
