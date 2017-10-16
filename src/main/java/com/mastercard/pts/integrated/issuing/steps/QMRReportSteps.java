package com.mastercard.pts.integrated.issuing.steps;

import java.util.Collection;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.configuration.AppEnvironment;
import com.mastercard.pts.integrated.issuing.utils.ReadTestDataFromExcel;
import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;
import com.mastercard.pts.integrated.issuing.workflows.QMRReportFlows;

/**
 * @author E070234 This class contain all QMR report steps from running of batch
 *         to downloading the report
 * 
 */

@Component
public class QMRReportSteps extends AbstractBaseFlows {
	final Logger logger = LoggerFactory
			.getLogger(PrepaidDeviceEmbossingFileSteps.class);

	@Autowired
	public QMRReportFlows qmrReportFlows;

	@Autowired
	private ReadTestDataFromExcel excelTestData;

	@Autowired
	AppEnvironment appEnvironment;

	/**
	 * Implement this Step for executing process batch
	 */
	@When("User executes the compliance reports  batch")
	public void executecomplianceBatch() {

		qmrReportFlows.runProcessBatch();
	}

	/**
	 * Implement this Step for downloading the QMR report
	 */
	@Then("User download the QMR report")
	@When("User download the QMR report")
	public void downloadQMRReport() {
		qmrReportFlows.downloadQMRReport();
	}

	/**
	 * Implement this Step for opening the QMR report
	 */
	@Given("User opens the downloaded QMR_Report")
	@Then("User opens the downloaded QMR_Report")
	public void verifyUserOpensDownloadedQMRReport() {

		qmrReportFlows.verifyUserOpensDownloadedReport();

	}

	/**
	 * Implement this Step for Reading the QMR report
	 */
	@When("QMR_Report read successfully")
	public void verifyQMRReportReadSuccessfully() {

		qmrReportFlows.verifyQMRReportReadSuccessfully();

	}

	/**
	 * Implement this Step to validate all header content in the PDF QMR Report
	 */
	@Then("Validates the header contents")
	public void verifyHeaderContents() {

		qmrReportFlows.verifyHeaderContents();

	}

	/**
	 * Implement this Step to validate all heading in the PDF QMR Report
	 */
	@Then("User validate all given heading in report")
	@When("User validate all given heading in report")
	public void validateQMRReportHeading() {
		verifyUserOpensDownloadedQMRReport();
		verifyQMRReportReadSuccessfully();
		verifyHeaderContents();
		verifyIfValidationIsSuccessful();
	}

	/**
	 * Implement this Step to validate all header and footer in the PDF QMR
	 * Report
	 */
	@Then("User validate all header and footer in report")
	@When("User validate all header and footer in report")
	public void validateQMRReportHeaderFooter() {
		verifyUserOpensDownloadedQMRReport();
		verifyQMRReportReadSuccessfully();
		verifyTheFilterSearchCriteria();
		verifyTheFooterContents();
		verifyIfValidationIsSuccessful();
	}

	/**
	 * Implement this Step for to validate QMR Report
	 */
	@Then("User validate the QMR report")
	@When("User validate the QMR report")
	@Given("User validate the QMR report")
	public void validateQMRReport() {
		verifyUserOpensDownloadedQMRReport();
		verifyQMRReportReadSuccessfully();
		verifyHeaderContents();
		verifyTheFilterSearchCriteria();
		verifyTheFooterContents();
		verifyIfValidationIsSuccessful();
	}

	/**
	 * Implement this Step to validate all search criteria in the PDF QMR Report
	 */
	@When("Validates the filter search criteria")
	@Then("Validates the filter search criteria")
	public void verifyTheFilterSearchCriteria() {

		qmrReportFlows.verifyFilterSearchCriteria();

	}

	/**
	 * Implement this Step to validate all footer in PDF QMR Report
	 */
	@When("Validates the footer contents")
	@Then("Validates the footer contents")
	public void verifyTheFooterContents() {

		qmrReportFlows.verifyFooterContents();

	}

	/**
	 * Implement this Step to validate successful validation in PDF QMR Report
	 */
	@Then("The validation is successful")
	public void verifyIfValidationIsSuccessful() {

		qmrReportFlows.verifyValidationIsSuccessful();
		qmrReportFlows.clearStatusFlag();

	}

	/**
	 * Implement this Step to validate all Bin Present in PDF QMR Report
	 */
	@Then("User validate all BIN present in report")
	public void verifyAllBinPresentFromDB() {

		qmrReportFlows.verifyReportBinAndDatabaseBin();
	}

	/**
	 * Implement this Step to validate all Bin start from new page in PDF QMR
	 * Report
	 */
	@Then("User valildate BIN starting from next Page")
	public void verifyBINStartingFromNewPAge() {
		qmrReportFlows.verifyQMRPages();

	}

	/**
	 * Implement this Step to validate PDF QMR Report
	 */
	@Given("QMR_Report Read successfully")
	public void verifyQMRReportIsReadSuccessfully() {

		qmrReportFlows.verifyQMRPages();

	}

	/**
	 * Implement this Step for bin validation
	 */
	@When("User extracts bin from QMR_Report content per page")
	public void verifyUserExtractsBinFromQMRReportContentPerPage() {

		qmrReportFlows.verifyBinExtractionFromQMRReports();

	}

	/**
	 * Implement this Step for validation on new card generated
	 */
	@Then("User validate the new cards genereted")
	public void validateNewCardsGenerated() {

		qmrReportFlows.verifNewCards();

	}

	/**
	 * Implement this Step for validation on summation of card disbursement
	 */
	@Then("User valildate the summation of card disbursement")
	public void validateCardSumation() {
		qmrReportFlows.verifyCardSumation();

	}

	/**
	 * Implement this Step for validation of Transaction amount heading
	 */
	@Then("User validates Transaction Amount heading")
	public void validateTransactionHeading() {
		qmrReportFlows.verifyTransactionHeading();
	}

	/**
	 * Implement this Step for validation of Account terminated heading
	 */
	@Then("User valildate Account terminated heading")
	public void validateAccountTerminatedHeading() {
		qmrReportFlows.verifyAccountTerminatedHeading();
	}

	/**
	 * Implement this Step for validation of null report
	 */
	@Then("User validate the null report for diffrent currency")
	public void validateNullReportForDiffrentCurrency() {
		qmrReportFlows.verifyNullReport();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}
