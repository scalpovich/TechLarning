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
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mastercard.pts.integrated.issuing.domain.CSVData;

public class FileConverter {
	private static final Logger LOGGER = LoggerFactory.getLogger(FileConverter.class);
	private static final String CSV_EXTN = ".csv";
	private static final String CONFIG_PATH = "./src/main/resources/config/";
	
	private String getCellValAsString(Cell cell) {
		DataFormatter dataFormatter = new DataFormatter();
		return dataFormatter.formatCellValue(cell);
	}

	private String createDirs(Sheet sheet, String env) {
		File dir = new File(CONFIG_PATH + env + "/Data");
		dir.mkdirs();

		return (dir.getAbsolutePath() + File.separatorChar + sheet.getSheetName() + CSV_EXTN);
	}

	private void convertXlsToCsv(Workbook wb, String env) {
		for (int i = 0; i < wb.getNumberOfSheets(); i++) {
			LOGGER.info("sheetNo -> {} sheetName -> {}", i + 1, wb.getSheetAt(i).getSheetName());
			Sheet sheet = wb.getSheetAt(i);
			String fileAbsPath = createDirs(sheet, env);
			CSVData csv = convertColumnDataInXls(sheet);
			writeToCSV(csv, fileAbsPath);
		}
		LOGGER.info("*** Total {} sheets converted for '{}' environment ***", wb.getNumberOfSheets(), env);
	}

	private void convertXlsxToCsv(Workbook wb, String env) {
		for (int i = 0; i < wb.getNumberOfSheets(); i++) {
			LOGGER.info("sheetNo -> {} sheetName -> {}", i + 1, wb.getSheetAt(i).getSheetName());
			Sheet sheet = wb.getSheetAt(i);
			String fileAbsPath = createDirs(sheet, env);
			CSVData csv = convertRowDataInXlsx(sheet);
			writeToCSV(csv, fileAbsPath);
		}
		LOGGER.info("*** Total {} sheets converted for '{}' environment ***", wb.getNumberOfSheets(), env);
	}

	private CSVData convertRowDataInXlsx(Sheet sheet) {
		int startOfDataRow = 1;
		int headerRowNo = 0;
		List<String> headers = new ArrayList<>();
		List<List<String>> dataRows = new ArrayList<>();

		Row headerRow = sheet.getRow(headerRowNo);
		if (headerRow != null) {
			int colEnd = headerRow.getLastCellNum();
			for (int i = 0; i < colEnd; i++) {
				headers.add(getCellValAsString(headerRow.getCell(i)));
			}

			for (int i = startOfDataRow; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				List<String> dataRow = new ArrayList<>();
				for (int j = 0; j < colEnd; j++) {
					if (row != null) {
						dataRow.add(getCellValAsString(row.getCell(j)));
					}
				}
				dataRows.add(dataRow);
			}
		}

		return new CSVData(headers, dataRows);
	}

	private CSVData convertColumnDataInXls(Sheet sheet) {
		int startOfDataRow = 1;
		List<String> headers = new ArrayList<>();
		List<String> dataRow = new ArrayList<>();
		List<List<String>> dataRows = new ArrayList<>();
		
		for (int i = startOfDataRow; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			if (row != null) {
				String headerCellVal = getCellValAsString(row.getCell(0));
				String dataCellVal = getCellValAsString(row.getCell(1));
				if (!headerCellVal.trim().isEmpty()) {
					headers.add(headerCellVal);
					dataRow.add(dataCellVal);
				}
			}
		}
		dataRows.add(dataRow);

		return new CSVData(headers, dataRows);
	}

	private void writeToCSV(CSVData csv, String filePath) {
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath));
				CSVPrinter printer = CSVFormat.EXCEL.withIgnoreHeaderCase().withHeader(csv.getHeaderRow().toArray(new String[0]))
						.print(writer);) {
			printRowsInCSV(csv.getDataRows(), printer);
			LOGGER.info("CSV file created at -> {}", filePath);
		} catch (IOException e) {
			LOGGER.error("IOException occurred while creating CSV file at -> {}", filePath, e);
		}
	}

	private void printRowsInCSV(List<List<String>> dataRows, CSVPrinter printer) {
		dataRows.forEach(row -> {
			try {
				printer.printRecord(row);
				printer.flush();
			} catch (IOException e) {
				LOGGER.error("IOException occurred while printing row in CSV file -> {}", row);
			}
		});
	}

	@Test
	public void convertExcelToCsv() throws IOException, InvalidFormatException {
		String[] listOfEnvs = { "demo", "automation", "automation2", "stageSA" };
		String[] dataFiles = { "Data/TestData.xls", /*"TestData/TestData.xlsx"*/ };		
		for (String env : listOfEnvs) {
			for (String dataFile : dataFiles) {
				try (InputStream in = new FileInputStream(
						String.format("%s%s/%s", CONFIG_PATH, env, dataFile));
						Workbook wb = WorkbookFactory.create(in)) {
					if (dataFile.endsWith(".xls")) {
						convertXlsToCsv(wb, env);
					} else {
						convertXlsxToCsv(wb, env);
					}
				}
			}
		}
	}

}
