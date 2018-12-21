package com.mastercard.pts.integrated.issuing.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelUtils {

	private ExcelUtils() {}

	//method that returns that map based on sheet name
	public static Map<String, String> readExcel(Sheet sh) {
		Map<String, String> map = new HashMap<>();

		for (int i = 1; i < sh.getRows(); i++) {
			String name = sh.getCell(0, i).getContents();
			
			if (name.isEmpty()) {
				break;
			}
			
			String value = sh.getCell(1, i).getContents();
			map.put(name, value);
		}
		return map;
	}
	//method that returns that map based on columnName and sheet name
	public static Map<String, String> readExcel(Sheet sh, String colunmName) {
		Map<String, String> map = new HashMap<>();

		int newColumnNumber = 0;
		for(int j = 0; j< sh.getColumns(); j++)
		{
			Cell objectName = sh.getCell(j,0);
			if (objectName.getContents().equalsIgnoreCase(colunmName))
			{
				newColumnNumber = j;
				break;
			}
			else
			{
				if(j==sh.getColumns()-1) 
					return null;
			}
		}
		for (int i = 1; i < sh.getRows(); i++) {
			Cell objectName = sh.getCell(0, i);
			Cell objectValue = sh.getCell(newColumnNumber, i);
			if (objectName.getContents() != "") {
				map.put(objectName.getContents(), objectValue.getContents());
			} else

				break;
		}
		return map;
	}
	
	public static Map<String, String> readDataBySheetAndColumn(String excelClasspath,
			String sheet, String columnName) {
		try(InputStream inputStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(excelClasspath)) {
			return readData(inputStream, Optional.of(sheet), columnName);
		} catch (Exception e) {
			throw MiscUtils.propagate(e);
		}
	}
	
	public static Map<String, String> readDataByColumn(String excelClasspath, String columnName) {
		try(InputStream inputStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(excelClasspath)) {
			return readData(inputStream, Optional.empty(), columnName);
		} catch (Exception e) {
			throw MiscUtils.propagate(e);
		}
	}
	
	private static Map<String, String> readData(InputStream inputStream, Optional<String> sheetName,
			String transactionName)
			throws BiffException, IOException {
		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(inputStream);
			Sheet sheet = sheetName.map(workbook::getSheet).orElse(workbook.getSheet(0));
			return readExcel(sheet, transactionName);
		} finally {
			if (workbook != null) {
				workbook.close();
			}
		}
	}
	
	public static String getFilePath() {
		String filePath = System.getProperty("user.dir") + "/src/main/resources/config/" + System.getProperty("env") + "/TestData/" + Constants.TESTDATA + ".xlsx";
		return filePath;
	}

	public static String getDataFromExcelThroughQuery(String inputStream, String strQuery, String getFieldvalue) throws FilloException {
		String getFieldValue = null;
		Fillo fillo = new Fillo();
		Connection connection = fillo.getConnection(inputStream);
		Recordset recordset = connection.executeQuery(strQuery);
		while (recordset.next()) {
			getFieldValue = recordset.getField(getFieldvalue);
		}
		recordset.close();
		connection.close();
		return getFieldValue;

	}

	@SuppressWarnings("deprecation")
	public static String getField(String strQuery, String getFieldValue) throws FilloException {
		return getDataFromExcelThroughQuery(getFilePath(), strQuery, getFieldValue);
	}

	public static void insertDataIntoExcelThroughQuery(String inputStream, String strQuery) throws FilloException {
		Fillo fillo = new Fillo();
		Connection connection = fillo.getConnection(inputStream);
		// connection.createTable("Cards", new String []
		// {"Product","ProgramType","ProgramCode","DevicePlan"});
		connection.executeUpdate(strQuery);
		connection.close();
	}

	@SuppressWarnings("deprecation")
	public static void insertDataIntoExcel(String strQuery) throws FilloException {
		insertDataIntoExcelThroughQuery(getFilePath(), strQuery);
	}

}
