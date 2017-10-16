package com.mastercard.pts.integrated.issuing.pages;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.mastercard.pts.integrated.issuing.utils.QMRPDFUtility;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class QMRPDFReaderPage extends MenuFlows {
	@Autowired
	QMRPDFUtility pdfUtil;

	boolean statusFlag = false;
	public static LinkedHashMap<String, String> bin = new LinkedHashMap<>();
	public static LinkedHashSet<String> binSet = new LinkedHashSet<>();

	public void readPDFile() {

		try {

			for (int i = 1; i <= pdfUtil.getPDFReaderObject()
					.getNumberOfPages(); i++) {
				String textFromPage = PdfTextExtractor.getTextFromPage(
						pdfUtil.getPDFReaderObject(), i);

				String[] split = textFromPage
						.replaceAll("[\\\t|\\\n|\\\r]", "\\\n")
						.replaceFirst(" ", "").split("\\n");

				Assert.assertFalse("Split Array is of zero length:",
						split.length == 0);

				QMRPDFUtility.set.clear();
			}

		} catch (IOException e) {

			statusFlag = true;

			System.out
					.println("Encountered IOException in the function - 'readPDFile':"
							+ e.getMessage());
		}

	}

	public void userOpensDownloadedReport() {

		try {
			System.out.println(pdfUtil.getPDFReaderObject().getNumberOfPages());

			Assert.assertTrue(pdfUtil.getPDFReaderObject().getNumberOfPages() != 0);

		} catch (IOException e) {

			statusFlag = true;
			System.out
					.println("Encountered IOException in the function - 'userOpensDownloadedReport':"
							+ e.getMessage());
		}

	}

	public void userChecksHeaderContents() {

		try {

			for (int i = 1; i <= pdfUtil.getPDFReaderObject()
					.getNumberOfPages(); i++) {

				String textFromPage;

				textFromPage = PdfTextExtractor.getTextFromPage(
						pdfUtil.getPDFReaderObject(), i);

				String[] split = textFromPage
						.replaceAll("[\\\t|\\\n|\\\r]", "\\\n")
						.replaceFirst(" ", "").split("\\n");

				pdfUtil.pdfUtility(split);

				if (i == 1) {

					Assert.assertFalse("Institution id is null:", env
							.getProperty("app.user.institutionselection")
							.contains(pdfUtil.getInstitutionId()));

					Assert.assertFalse("Institution name is null:", env
							.getProperty("app.user.institutionselection")
							.contains(pdfUtil.getInstitutionName(split)));
				}

				Assert.assertFalse("Report id is null:", pdfUtil.getReportId()
						.equals(null));

				Assert.assertFalse("Report name is null:", pdfUtil
						.getReportName(split).equals(null));

				Assert.assertFalse("Bin is null:", pdfUtil.getBin()
						.equals(null));

				QMRPDFUtility.set.clear();

			}

		} catch (IOException e) {

			statusFlag = true;

			System.out
					.println("Encountered IOException in the function - 'userVerifiesHeaderContents':"
							+ e.getMessage());
		}

	}

	public void userChecksFilterSearchCriteria() {

		try {

			for (int i = 1; i <= pdfUtil.getPDFReaderObject()
					.getNumberOfPages(); i++) {

				String textFromPage;

				textFromPage = PdfTextExtractor.getTextFromPage(
						pdfUtil.getPDFReaderObject(), i);

				String[] split = textFromPage
						.replaceAll("[\\\t|\\\n|\\\r]", "\\\n")
						.replaceFirst(" ", "").split("\\n");

				pdfUtil.pdfUtility(split);

				Assert.assertFalse("Year is null:",
						pdfUtil.getYear().equals(null));

				Assert.assertFalse("Quarter is null:", pdfUtil.getQuarterId()
						.equals(null));

				QMRPDFUtility.set.clear();
			}

		} catch (IOException e) {

			statusFlag = true;

			System.out
					.println("Encountered IOException in the function - 'userChecksFilterSearchCriteria':"
							+ e.getMessage());
		}

	}

	public void userChecksFooterContents() {

		try {

			for (int i = 1; i <= pdfUtil.getPDFReaderObject()
					.getNumberOfPages(); i++) {

				String textFromPage;

				textFromPage = PdfTextExtractor.getTextFromPage(
						pdfUtil.getPDFReaderObject(), i);

				String[] split = textFromPage
						.replaceAll("[\\\t|\\\n|\\\r]", "\\\n")
						.replaceFirst(" ", "").split("\\n");

				pdfUtil.pdfUtility(split);

				Assert.assertFalse("'Report Generated By' is null:", pdfUtil
						.getReportGeneratedBy(split).equals(null));

				Assert.assertFalse("Report generation date is null:", pdfUtil
						.getReportGenerationDate(split).equals(null));

				Assert.assertFalse("Report id is null:", pdfUtil.getReportId()
						.equals(null));

				Assert.assertFalse("Page Number is null:", pdfUtil
						.getPageNumber(split).equals(null));

				QMRPDFUtility.set.clear();
			}

		} catch (IOException e) {

			statusFlag = true;

			System.out
					.println("Encountered IOException in the function - 'userChecksFooterContents':"
							+ e.getMessage());
		}

	}

	public void userChecksForSuccessfulValidation() {

		Assert.assertTrue("Validation was successful:", statusFlag == false);

	}

	public void userFetchesAllContentsAndExtractHeaders() {

		try {

			Assert.assertTrue(pdfUtil.getPDFReaderObject().getNumberOfPages() != 0);

			for (int i = 1; i <= pdfUtil.getPDFReaderObject()
					.getNumberOfPages(); i++) {

				String textFromPage = PdfTextExtractor.getTextFromPage(
						pdfUtil.getPDFReaderObject(), i);

				String[] split = textFromPage
						.replaceAll("[\\\t|\\\n|\\\r]", "\\\n")
						.replaceFirst(" ", "").split("\\n");

				Assert.assertFalse("Split Array is of zero length:",
						split.length == 0);

				Assert.assertTrue(pdfUtil.readHeaders(pdfUtil.pdfUtility(split)));

				QMRPDFUtility.set.clear();
			}
		} catch (Exception e) {

			statusFlag = true;
			System.out
					.println("Encountered IOException in the function - 'userFetchesAllContentsAndExtractHeadersUser fetches all contents and extracts header labels':"
							+ e.getMessage());
		}
	}

	public void userChecksForPresenceOfQMRPages() {

		try {

			Assert.assertTrue(pdfUtil.getPDFReaderObject().getNumberOfPages() != 0);

		} catch (IOException e) {

			System.out
					.println("Encountered IOException in the function - 'userChecksForPresenceOfQMRPages':"
							+ e.getMessage());
		}

	}

	public void userChecksForBinExtraction() {

		try {

			for (int i = 1; i <= pdfUtil.getPDFReaderObject()
					.getNumberOfPages(); i++) {
				String textFromPage = PdfTextExtractor.getTextFromPage(
						pdfUtil.getPDFReaderObject(), i);

				String[] split = textFromPage
						.replaceAll("[\\\t|\\\n|\\\r]", "\\\n")
						.replaceFirst(" ", "").split("\\n");

				Assert.assertFalse("Split Array is of zero length:",
						split.length == 0);

				pdfUtil.pdfUtility(split);

				binSet.add(pdfUtil.getBin());

				bin.put(String.valueOf(i), pdfUtil.getBin());

				QMRPDFUtility.set.clear();
			}

		} catch (IOException e) {

			System.out
					.println("Encountered IOException in the function - 'userChecksForBinExtractedCount':"
							+ e.getMessage());
		}

	}

	public void userClearsStatusFlag() {

		statusFlag = false;
	}

	public void getQMRReportsNewCards(String databaseObj) {

		try {

			for (int i = 1; i <= pdfUtil.getPDFReaderObject()
					.getNumberOfPages(); i++) {
				String textFromPage = PdfTextExtractor.getTextFromPage(
						pdfUtil.getPDFReaderObject(), i);

				String[] split = textFromPage
						.replaceAll("[\\\t|\\\n|\\\r]", "\\\n")
						.replaceFirst(" ", "").split("\\n");

				Assert.assertFalse("Split Array is of zero length:",
						split.length == 0);

				pdfUtil.checkPDFPageCountAndBinPresence(split);

				pdfUtil.checkNewCardsOpenCount(split, databaseObj);

				QMRPDFUtility.set.clear();
			}

		} catch (IOException e) {

			System.out
					.println("Encountered IOException in - 'getStringArrayForQMRReportsNewCards' function:"
							+ e.getMessage());
		}

	}

	public void getQMRReportsCardSummation() {

		try {

			for (int i = 1; i <= pdfUtil.getPDFReaderObject()
					.getNumberOfPages(); i++) {
				String textFromPage = PdfTextExtractor.getTextFromPage(
						pdfUtil.getPDFReaderObject(), i);

				String[] split = textFromPage
						.replaceAll("[\\\t|\\\n|\\\r]", "\\\n")
						.replaceFirst(" ", "").split("\\n");

				Assert.assertFalse("Split Array is of zero length:",
						split.length == 0);

				pdfUtil.checkPDFPageCountAndBinPresence(split);

				pdfUtil.CheckTotalTransactionAmountDisbursements(split);

				pdfUtil.CheckTotalTransactionCountDisbursements(split);

				pdfUtil.CheckTotalTransactionAmountReturnAndRefunds(split);

				pdfUtil.CheckTotalTransactionCountReturnAndRefunds(split);

				QMRPDFUtility.set.clear();
			}

		} catch (IOException e) {

			System.out
					.println("Encountered IOException in - 'getStringArrayForQMRReportsCardSummation' function:"
							+ e.getMessage());
		}

	}

	public void getTransactionAmountCountAndBTConvenienceChecksHeading() {

		try {

			for (int i = 1; i <= pdfUtil.getPDFReaderObject()
					.getNumberOfPages(); i++) {
				String textFromPage = PdfTextExtractor.getTextFromPage(
						pdfUtil.getPDFReaderObject(), i);

				String[] split = textFromPage
						.replaceAll("[\\\t|\\\n|\\\r]", "\\\n")
						.replaceFirst(" ", "").split("\\n");

				Assert.assertFalse("Split Array is of zero length:",
						split.length == 0);

				pdfUtil.checkPDFPageCountAndBinPresence(split);

				pdfUtil.checkTransAmountCountLabels(split);

				pdfUtil.checkTransAmountCountForConvenienceChecks(split);

				QMRPDFUtility.set.clear();
			}

		} catch (IOException e) {

			System.out
					.println("Encountered IOException in - 'getTransactionAmountCountAndBTConvenienceChecksHeading' function:"
							+ e.getMessage());
		}

	}

	public void getAccountTerminatedHeading() {

		try {

			for (int i = 1; i <= pdfUtil.getPDFReaderObject()
					.getNumberOfPages(); i++) {
				String textFromPage = PdfTextExtractor.getTextFromPage(
						pdfUtil.getPDFReaderObject(), i);

				String[] split = textFromPage
						.replaceAll("[\\\t|\\\n|\\\r]", "\\\n")
						.replaceFirst(" ", "").split("\\n");

				Assert.assertFalse("Split Array is of zero length:",
						split.length == 0);

				pdfUtil.checkPDFPageCountAndBinPresence(split);

				pdfUtil.checkAccountTerminatedDuringQuarterHeaderLabel(split);

				QMRPDFUtility.set.clear();
			}

		} catch (IOException e) {

			System.out
					.println("Encountered IOException in - 'getAccountTerminatedHeading' function:"
							+ e.getMessage());
		}

	}

	public void verifyNullReport() {

		try {

			for (int i = 1; i <= pdfUtil.getPDFReaderObject()
					.getNumberOfPages(); i++) {
				String textFromPage = PdfTextExtractor.getTextFromPage(
						pdfUtil.getPDFReaderObject(), i);

				String[] split = textFromPage
						.replaceAll("[\\\t|\\\n|\\\r]", "\\\n")
						.replaceFirst(" ", "").split("\\n");

				Assert.assertFalse("Split Array is of zero length:",
						split.length == 0);

				pdfUtil.checkPDFPageCountAndBinPresence(split);

				QMRPDFUtility.set.clear();
			}

		} catch (IOException e) {

			System.out
					.println("Encountered IOException in - 'verifyNullReport' function:"
							+ e.getMessage());
		}

	}

	public void userChecksForBinCountAcrossPages(int size) {

		try {

			Assert.assertTrue(size == pdfUtil.getPDFReaderObject()
					.getNumberOfPages());

		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}