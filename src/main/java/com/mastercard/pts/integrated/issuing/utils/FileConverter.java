package com.mastercard.pts.integrated.issuing.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileConverter {
	private static final Logger LOGGER = LoggerFactory.getLogger(FileConverter.class);
	private String[] listOfEnvs = { "demo" };
	private static final String CSV_EXTN = ".csv";

	private void echoAsCSV(Sheet sheet, String env) {
		// for vertical data
		int startOfDataRow = 1;
		List<String> headers = new ArrayList<>();
		List<String> data = new ArrayList<>();
		DataFormatter dataFormatter = new DataFormatter();
		for (int i = startOfDataRow; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			if (row != null) {
				String headerCellVal = dataFormatter.formatCellValue(row.getCell(0));
				String dataCellVal = dataFormatter.formatCellValue(row.getCell(1));
				if (!headerCellVal.trim().isEmpty()) {
					headers.add(headerCellVal);
					data.add(dataCellVal);
				}
			}
		}

		LOGGER.info("{} {}", headers.size(), headers.toString());
		LOGGER.info("{} {}", data.size(), data.toString());

		File dir = new File("C" + ":" + File.separatorChar + "Temp" + File.separatorChar + env);
		dir.mkdirs();
		String fileAbsPath = dir.getAbsolutePath() + File.separatorChar + sheet.getSheetName() + CSV_EXTN;
		writeToCSV(headers, data, fileAbsPath);
	}

	private void writeToCSV(List<String> headers, List<String> data, String filePath) {
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath));
				CSVPrinter printer = CSVFormat.EXCEL.withHeader(headers.toArray(new String[0])).print(writer);) {
			printer.printRecord(data);
			printer.flush();
			LOGGER.info("CSV file created at: {}", filePath);
		} catch (IOException e) {
			LOGGER.error("IOException while creating CSV file at: {}", filePath, e);
		}
	}

	public void convertExcelToCSV() throws IOException, InvalidFormatException {
		for (String env : listOfEnvs) {
			try (InputStream in = new FileInputStream(
					String.format("./src/main/resources/config/%s/Data/TestData.xls", env));
					Workbook wb = WorkbookFactory.create(in)) {
				for (int i = 0; i < wb.getNumberOfSheets(); i++) {
					LOGGER.info("sheetNo> {} sheetName> {}", i + 1, wb.getSheetAt(i).getSheetName());
					echoAsCSV(wb.getSheetAt(i), env);
				}
			}
		}
	}

	@Test
	public void test() throws InvalidFormatException, IOException {
		convertExcelToCSV();
	}

}
