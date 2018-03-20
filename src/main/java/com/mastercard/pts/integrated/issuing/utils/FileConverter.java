package com.mastercard.pts.integrated.issuing.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileConverter {
	private static final Logger LOGGER = LoggerFactory.getLogger(FileConverter.class);

	private void echoAsCSV(Sheet sheet) {
		// for vertical data
		int startOfDataRow = 1;
		List<String> headerValues = new ArrayList<>();
		List<String> dataValues = new ArrayList<>();
		DataFormatter dataFormatter = new DataFormatter();
		for (int i = startOfDataRow; i < sheet.getLastRowNum(); i++) {
			headerValues.add(dataFormatter.formatCellValue(sheet.getRow(i).getCell(0)));
			dataValues.add(dataFormatter.formatCellValue(sheet.getRow(i).getCell(1)));
		}

		LOGGER.info(headerValues.size() + " >> " + headerValues.toString());
		LOGGER.info(dataValues.size() + " >> " + dataValues.toString());
	}

	public void convertExcelToCSV() throws IOException, InvalidFormatException {
		try (InputStream in = new FileInputStream("./src/main/resources/config/demo/Data/TestData.xls");
				Workbook wb = WorkbookFactory.create(in)) {
			for (int i = 0; i < 1 /* wb.getNumberOfSheets() */; i++) {
				LOGGER.info(wb.getSheetAt(i).getSheetName());
				echoAsCSV(wb.getSheetAt(i));
			}
		}
	}

	@Test
	public void test() throws InvalidFormatException, IOException {
		convertExcelToCSV();
	}

}
