package com.mastercard.pts.integrated.issuing.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Ignore;
import org.junit.Test;

public class FileConverterTest {

	private FileConverter fileConverter = new FileConverter();

	@Ignore
	@Test
	public void convertExcelToCsv() throws IOException, InvalidFormatException {
		String[] listOfEnvs = { "demo", "automation2", "stageSA", /*automation*/ };
		String[] dataFiles = { "TestData/TestData.xlsx", /*"Data/TestData.xls"*/ };
		for (String env : listOfEnvs) {
			for (String dataFile : dataFiles) {
				try (InputStream in = new FileInputStream(
						String.format("%s%s/%s", FileConverter.CONFIG_PATH, env, dataFile));
						Workbook wb = WorkbookFactory.create(in)) {
					if (dataFile.endsWith(".xls")) {
						fileConverter.convertXlsToCsv(wb, env);
					} else {
						fileConverter.convertXlsxToCsv(wb, env);
					}
				}
			}
		}
	}

}
