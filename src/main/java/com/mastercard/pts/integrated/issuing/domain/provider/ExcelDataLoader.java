package com.mastercard.pts.integrated.issuing.domain.provider;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.ExcelUtils;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

@Component
public class ExcelDataLoader implements DataLoader {
	
	private static final Logger logger = LoggerFactory.getLogger(ExcelDataLoader.class);
	
	@Value("config/${env}/Data/TestData.xls")
	private String excelPath;

	@Override
	public Optional<Map<String, String>> loadData(String storyName) {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(excelPath);
		try {
			return readData(inputStream, storyName);
		} catch (Exception e) {
			logger.error("Fail to load data from excel", e);
			MiscUtils.propagate(e);
			return Optional.empty();
		}
	}
	
	private Optional<Map<String, String>> readData(InputStream inputStream, String sheetName) throws BiffException, IOException  {
		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(inputStream);
			if (!Arrays.asList(workbook.getSheetNames()).contains(sheetName)) {
				return Optional.empty();
			}
			Sheet sheet = workbook.getSheet(sheetName);
			Map<String, String> data = ExcelUtils.readExcel(sheet);
			return Optional.of(Collections.unmodifiableMap(data));
		} finally {
			if (workbook != null) {
				workbook.close();
			}
			
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}

}
