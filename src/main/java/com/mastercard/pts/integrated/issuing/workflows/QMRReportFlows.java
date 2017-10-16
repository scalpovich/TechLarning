package com.mastercard.pts.integrated.issuing.workflows;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.MenuSubMenuPage;
import com.mastercard.pts.integrated.issuing.pages.QMRPDFReaderPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.BatchProcessingPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceRangePage;
import com.mastercard.pts.integrated.issuing.utils.ConnectionUtils;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.DBQueryConstant;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.utils.QMRPDFUtility;

/**
 * @author E070234
 * 
 *
 */
@Component
public class QMRReportFlows extends AbstractBasePage {
	final Logger logger = LoggerFactory.getLogger(DeviceRangePage.class);

	@Autowired
	BatchProcessingPage batchProcessingPage;
	@Autowired
	QMRPDFReaderPage qmrPDFReaderPage;
	@Autowired
	public MenuSubMenuPage menuSubMenuPage;

	@Autowired
	QMRPDFUtility pdfUtil;
	@Autowired
	ConnectionUtils connectionutils;

	/**
	 * Implement this function to Run the process batch. Test data will be taken
	 * from Excel sheet
	 *
	 */
	public void runProcessBatch() {

		String[] batchesQuater = MapUtils.fnGetInputDataFromMap("BatchQuater").split(",");
		for (String quater : batchesQuater) {
			logger.debug("Running processing Batch");
			menuSubMenuPage.clickMenuSubOption(menuSubMenuPage.getOperation(), menuSubMenuPage.getProcessingBatches());
			menuSubMenuPage.getProcessBatch().click();
			CustomUtils.ThreadDotSleep(1000);
			batchProcessingPage.runProcessBatch(quater.trim());
		}
	}

	/**
	 * Implement this function to download the QMR report. Test data will be
	 * taken from Excel sheet
	 *
	 */

	public void downloadQMRReport() {
		waitForElementVisible(menuSubMenuPage.getCardMngmntReport());
		menuSubMenuPage.clickMenuSubOption(menuSubMenuPage.getCardMngmntReport(),
				menuSubMenuPage.getComplianceReport());
		batchProcessingPage.downloadComplianceReport();
	}

	/**
	 * Implement this function to valildate PDF file
	 *
	 */

	public void verifyUserOpensDownloadedReport() {
		qmrPDFReaderPage.userOpensDownloadedReport();
	}

	/**
	 * Implement this function to Read PDF file
	 *
	 */
	public void verifyQMRReportReadSuccessfully() {
		qmrPDFReaderPage.readPDFile();
	}

	/**
	 * Implement this function to verify Header of PDF file
	 *
	 */
	public void verifyHeaderContents() {
		qmrPDFReaderPage.userChecksHeaderContents();
	}

	/**
	 * Implement this function to verify Filter search criteria of PDF file
	 *
	 */
	public void verifyFilterSearchCriteria() {
		qmrPDFReaderPage.userChecksFilterSearchCriteria();
	}

	/**
	 * Implement this function to verify footer of PDF file
	 *
	 */
	public void verifyFooterContents() {
		qmrPDFReaderPage.userChecksFooterContents();
	}

	/**
	 * Implement this function to verify all validation on PDF file
	 *
	 */

	public void verifyValidationIsSuccessful() {

		qmrPDFReaderPage.userChecksForSuccessfulValidation();
	}

	/**
	 * Implement this function to verify header of PDF file
	 *
	 */
	public void verifyThatUserFetchesAllContentsAndExtractsHeaders() {

		qmrPDFReaderPage.userFetchesAllContentsAndExtractHeaders();

	}

	/**
	 * Implement this function to verify pages of PDF file
	 *
	 */
	public void verifyQMRPages() {

		qmrPDFReaderPage.userChecksForPresenceOfQMRPages();

	}

	/**
	 * Implement this function for extraction of bin from PDF file
	 *
	 */
	public void verifyBinExtractionFromQMRReports() {

		qmrPDFReaderPage.userChecksForBinExtraction();

	}

	/**
	 * Implement this function to clear status flag
	 *
	 */
	public void clearStatusFlag() {

		qmrPDFReaderPage.userClearsStatusFlag();
	}

	/**
	 * Implement this function to verify BIN count of PDF file
	 *
	 */
	public void verifyBinCountAcrossQMRPages(int size) {

		qmrPDFReaderPage.userChecksForBinCountAcrossPages(size);

	}

	/**
	 * Implement this function to get the List of BIN from database.
	 *
	 */

	public Set<String> getListOfBIN() {

		return connectionutils.getAllValuesOfAColumn(DBQueryConstant.BIN_QUERY, DBQueryConstant.BIN_COLUMN);
	}

	/**
	 * Implement this function to get the count of new card from database.
	 *
	 */

	public int getNewCardCount() {
		return 0;

	}

	/**
	 * Implement this function to Compare the report BIN and databaseBIN
	 *
	 */
	public boolean verifyReportBinAndDatabaseBin() {

		verifyQMRPages();
		verifyBinExtractionFromQMRReports();
		return getListOfBIN().containsAll(QMRPDFReaderPage.binSet);

	}

	/**
	 * Implement this function to verify BINs per Page
	 *
	 */
	public void verifyBinAsPerPages() {
		verifyQMRPages();
		verifyBinExtractionFromQMRReports();
		Set<String> databaseBin = getListOfBIN();
		verifyBinCountAcrossQMRPages(databaseBin.size());

	}

	/**
	 * Implement this function to compare NewCards of report from Database
	 *
	 */
	public void verifNewCards() {

		qmrPDFReaderPage.getQMRReportsNewCards("");
	}

	/**
	 * Implement this function to verify card summation
	 *
	 */
	public void verifyCardSumation() {

		qmrPDFReaderPage.getQMRReportsCardSummation();
	}

	/**
	 * Implement this function to verify transaction heading
	 *
	 */
	public void verifyTransactionHeading() {
		qmrPDFReaderPage.getTransactionAmountCountAndBTConvenienceChecksHeading();
	}

	/**
	 * Implement this function to verify Account terminated heading
	 *
	 */

	public void verifyAccountTerminatedHeading() {
		qmrPDFReaderPage.getAccountTerminatedHeading();
	}

	/**
	 * Implement this function to verify Null Report
	 *
	 */
	public void verifyNullReport() {
		qmrPDFReaderPage.verifyNullReport();
	}

}
