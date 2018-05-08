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

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CurrencyExchangeRate;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ProcessBatches;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.CurrencyExchangeRatesPage;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.CurrencyExchangeRatesFlows;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.ProcessBatchesFlows;

@Component
public class CurrencyExchangeRatesSteps {
	final Logger logger = LoggerFactory.getLogger(this.getClass());

	CurrencyExchangeRate currencyExchangeRateDomainPage = new CurrencyExchangeRate();

	private ProcessBatches processBatchesDomainPage;

	@Autowired
	private ProcessBatchesFlows processBatchesFlows;

	@Autowired
	private CurrencyExchangeRatesPage currencyExchangeRatesPage;

	private AbstractBaseFlows abstractBaseFlows;

	@Autowired
	private CurrencyExchangeRatesFlows currencyExchangeRatesFlows;

	private static String sourceCurrency = "Source Currency";
	private static String destinationCurrency = "Destination Currency";
	private static String program = "Program";
	private static String rateOrigin = "Rate Origin";
	private static String bankInterchange = "Bank [B]";

	/**
	 * Step Definition for navigating to the Currency Exchange Rates page from
	 * Home page
	 * <p>
	 * StoryFile usage : When user navigates to Currency Exchange Rates screen
	 * <p>
	 */
	@When("user navigates to Currency Exchange Rates screen")
	public void navigateToCER() {
		logger.info("Navigating to the Currency Exchange Rate page");
		currencyExchangeRatesFlows.navigateToCurrencyExchangeRatesScreen();
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
	public void addCurrencyExchangeRate(String rateOrigin) {
		logger.info("Add a new Currency Exchange Rate for the system");
		currencyExchangeRateDomainPage.setSourceCurrency(MapUtils
				.fnGetInputDataFromMap(sourceCurrency));
		currencyExchangeRateDomainPage.setDestinationCurrency(MapUtils
				.fnGetInputDataFromMap(destinationCurrency));
		currencyExchangeRateDomainPage.setBuyRate(MapUtils
				.fnGetInputDataFromMap("BuyRate"));
		currencyExchangeRateDomainPage.setMidRate(MapUtils
				.fnGetInputDataFromMap("MidRate"));
		currencyExchangeRateDomainPage.setSellRate(MapUtils
				.fnGetInputDataFromMap("SellRate"));
		if (MapUtils.fnGetInputDataFromMap(program) != null)
			currencyExchangeRateDomainPage.setProgram(MapUtils
					.fnGetInputDataFromMap(program));
		switch (rateOrigin) {
		case "Bank":
		case "bank":
			currencyExchangeRateDomainPage.setRateOrigin(bankInterchange);
			MapUtils.fnSetInputDataToInputMap(rateOrigin, bankInterchange);
			break;
		case "Mastercard":
		case "mastercard":
			currencyExchangeRateDomainPage.setRateOrigin("Mastercard [M]");
			MapUtils.fnSetInputDataToInputMap(rateOrigin, "Mastercard [M]");
			break;
		case "Visa":
		case "visa":
			currencyExchangeRateDomainPage.setRateOrigin("Visa [V]");
			MapUtils.fnSetInputDataToInputMap(rateOrigin, "Visa [V]");
			break;
		default:
			currencyExchangeRateDomainPage.setRateOrigin(bankInterchange);
			break;
		}
		currencyExchangeRatesFlows
				.addCurrencyExchangeRateFlows(currencyExchangeRateDomainPage);
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
	public void verifyNewCERAdded() {
		logger.info("Verifying that Currency Exchange Rate is added into the system");
		Assert.assertTrue(currencyExchangeRatesFlows
				.verifyCurrencyExchangeRateFlows(currencyExchangeRateDomainPage));
		abstractBaseFlows.sessionExpiryloginInAgain();
	}

	/**
	 * Step Definition for uploading the Currency Exchange Rate file
	 * <p>
	 * StoryFile usage : When user uploads the currency exchange rates file
	 * <p>
	 */
	@When("user uploads the currency exchange rates file for $bank")
	public void uploadCERFile(String type) {
		logger.info("Uploading the Currency Exchange Rate file");
		currencyExchangeRateDomainPage
				.setSourceCurrency(currencyExchangeRatesPage.getCode(MapUtils
						.fnGetInputDataFromMap(sourceCurrency)));
		currencyExchangeRateDomainPage
				.setDestinationCurrency(currencyExchangeRatesPage
						.getCode(MapUtils
								.fnGetInputDataFromMap(destinationCurrency)));
		currencyExchangeRateDomainPage.setBuyRate(MapUtils
				.fnGetInputDataFromMap("BUY_RATE"));
		currencyExchangeRateDomainPage.setMidRate(MapUtils
				.fnGetInputDataFromMap("MID_RATE"));
		currencyExchangeRateDomainPage.setSellRate(MapUtils
				.fnGetInputDataFromMap("SELL_RATE"));
		currencyExchangeRateDomainPage.setRateOrigin(currencyExchangeRatesPage
				.getCode(MapUtils.fnGetInputDataFromMap(rateOrigin)));
		currencyExchangeRateDomainPage.setUploadPathCER(MapUtils
				.fnGetInputDataFromMap("UPLOAD_PATH_CER"));
		if (!MapUtils.fnGetInputDataFromMap("Program").equalsIgnoreCase("-"))
		currencyExchangeRateDomainPage.setProgram(MapUtils
				.fnGetInputDataFromMap(program));
		currencyExchangeRatesFlows.uploadCurrencyExchangeFileFlows(type,
				currencyExchangeRateDomainPage.getUploadPathCER());
	}

	/**
	 * Step Definition for navigating to the Process Batches screen
	 * <p>
	 * StoryFile usage : When user navigates to the Process Batches screen
	 * <p>
	 */
	@When("user navigates to the Process Batches screen")
	public void navigateProcessBatchesPage() {
		logger.info("Navigating to the Process Batches page");
		currencyExchangeRatesFlows.navigateProcessBatchesScreenFlows();
	}

	/**
	 * Step Definition for Processing batches
	 * <p>
	 * StoryFile usage : When user runs Process Batches for $batchType for
	 * $batchName file
	 * <p>
	 */
	@When("user runs Process Batches for $upload for $CurrencyExchangeRate file")
	public void runProcessBatches(@Named("upload") String batchType,
			@Named("CurrencyExchangeRate") String batchName) {
		processBatchesDomainPage = new ProcessBatches();
		processBatchesDomainPage.setBatchName(batchName);
		processBatchesDomainPage.setBatchType(batchType);
		processBatchesFlows.runProcessBatchFlows(processBatchesDomainPage);
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
		Assert.assertTrue(processBatchesFlows
				.verifyFileProcessFlows(processBatchesDomainPage));
		Assert.assertTrue(currencyExchangeRatesFlows.verifyFileUploadFlows());
	}

	/**
	 * Composite Step Definition for navigating and adding a CER through screen
	 * <p>
	 * StoryFile usage : When user creates currency exchange rates for
	 * $interchange through screen
	 * <p>
	 */
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

	/**
	 * Composite Step Definition for creating and uploading the CER file and
	 * process it
	 * <p>
	 * StoryFile usage : When user uploads the CER file for $interchange
	 * <p>
	 */
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

	/**
	 * Step Definition for creation of invalid Currency Exchange Rate file for
	 * bank and upload it to the server
	 * <p>
	 * StoryFile usage : When user uploads bank file with invalid header
	 * <p>
	 */
	@Then("verify that the batch uploads fails with an appropriate error message for $Invalid_Header")
	public void verifyFileUploadInvalidHeader(
			@Named("Invalid_Header") String errorType) {
		logger.info("Verification for the error message file upload");
		Assert.assertFalse(processBatchesFlows
				.verifyFileProcessFlows(processBatchesDomainPage));
		Assert.assertTrue(processBatchesFlows
				.verifyErrorMessageFlows(errorType));
	}

	/**
	 * Step Definition for uploading the CER file with invalid currency
	 * <p>
	 * StoryFile usage : When user uploads the invalid currency in CER file for
	 * bank
	 * <p>
	 */
	@When("user uploads the $invalid_currency in CER file for bank")
	public void uploadsInvalidCERFile(
			@Named("invalid_currency") String isInvalid) {
		currencyExchangeRatesFlows.uploadFileBankInvalidFileFlows(isInvalid,
				currencyExchangeRateDomainPage.getUploadPathCER());
	}

}