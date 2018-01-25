package com.mastercard.pts.integrated.issuing.utils;

import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Throwables;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

@Component
public class PDFUtils {
	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(PDFUtils.class);

	private PDFUtils() {

	}

	public static String getContent(String pdfPath, String key) {
		String value = "";
		String pageContent = "";
		try {
			PdfReader pdfReader = new PdfReader(pdfPath);
			int pages = pdfReader.getNumberOfPages();

			for (int i = 1; i <= pages; i++) {
				pageContent = pageContent.concat(PdfTextExtractor.getTextFromPage(pdfReader, i));
			}
			pdfReader.close();
		} catch (Exception e) {
			logger.info("Failed to read pdf file ", e);
			throw Throwables.propagate(e);
		}

		pageContent = pageContent.replace("\n", " ");
		String reqContent = pageContent.split(key)[1];
		String[] reqArray = reqContent.split(" +");

		for (int i = 0; i < reqArray.length; i++) {
			String val = reqArray[i];
			if (!(val.isEmpty() || val.contains(":") || val.contains(" ") || val.contains("="))) {
				value = reqArray[i];
				break;
			}
		}
		return value;
	}

	public static List<String> getContentRow(String pdfPath, String code) {
		String pageContent = "";
		List<String> programWiseContent = new ArrayList<String>();
		String[] fullRow = { "" };
		int pages = 0;
		try {
			File file = new File(pdfPath);
			file.getParentFile().mkdirs();
			PdfReader pdfReader = manipulatePdf(pdfPath);
			if (pdfReader != null)
				pages = pdfReader.getNumberOfPages();
			for (int i = 1; i <= pages; i++) {
				pageContent = PdfTextExtractor.getTextFromPage(pdfReader, i);
				if (pageContent.contains(code)) {
					fullRow = pageContent.split("\n");
					break;
				}
			}
			for (int j = 0; j < fullRow.length; j++) {
				if (fullRow[j].contains(code)) {
					programWiseContent.add(Arrays.toString(fullRow[j-1].split(" ")).trim());
					programWiseContent.add(Arrays.toString(fullRow[j+1].split(" ")).trim());
					programWiseContent.add(Arrays.toString(fullRow[j].split(" ")).trim());
					break;
				}
			}
			if (pdfReader != null)
				pdfReader.close();
		} catch (Exception e) {
			logger.info("Failed to read pdf file ", e);
			throw Throwables.propagate(e);
		}
		return programWiseContent;
	}

	public static PdfReader manipulatePdf(String src) {
		PdfReader.unethicalreading = true;
		PdfReader reader = null;
		try {
			reader = new PdfReader(src, (ConstantData.AUTHORIZATION_REPORT_FILE_KEY+DateUtils.getDateDDMMFormat()).getBytes());
		} catch (IOException e) {
			logger.info("IO Exception {}", e);
		} catch (Exception e) {
			logger.info("Document Exception {}", e);
		}
		return reader;
	}

	public static String getuserDownloadPath() {
		return System.getProperty("user.home") + "\\Downloads";
	}

	public static String getTheNewestFilePath() {
		try {
			String filePath = getuserDownloadPath();
			File theNewestFile;
			String absolutePath = "";
			File dir = new File(filePath);
			FileFilter fileFilter = new WildcardFileFilter("*." + "pdf");
			File[] files = dir.listFiles(fileFilter);

			if (files.length > 0) {
				Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
				theNewestFile = files[0];
				absolutePath = theNewestFile.getAbsolutePath();
			}
			return absolutePath;
		} catch (Exception e) {
			logger.info("failed to get file path of downloaded file", e);
			throw Throwables.propagate(e);
		}
	}

	public static Integer getCountOfString(String content, String word) {
		String[] contentArray = content.split(" +");
		ArrayList<String> contentList = new ArrayList<>(Arrays.asList(contentArray));

		return Collections.frequency(contentList, word);
	}
}
