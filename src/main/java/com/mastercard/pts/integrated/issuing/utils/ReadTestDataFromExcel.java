package com.mastercard.pts.integrated.issuing.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.util.Assert;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ReadTestDataFromExcel {

	final Logger logger = LoggerFactory.getLogger(ReadTestDataFromExcel.class);

	public HashMap<String, HashMap<String, String>> entireTestData;

	@Value("${test.data.file}")
	private String file;

	public File testDataFile(String testDataFileName) {
		File testDataFile = null;
		try {
			testDataFile = new File(System.getProperty("user.dir")
					+ String.format(file, System.getProperty("env"), testDataFileName));
			logger.info("Test Data file:"+testDataFile);
		} catch (Exception e) {
			logger.error("Test Data file not find", e);
		}
		return testDataFile;
	}



	public HashMap<String, HashMap<String, String>> fnReadEntireTestData(String filepath, String strSheetName,
			String key) {
		entireTestData = new HashMap<String, HashMap<String, String>>();
		HashMap<String, String> singleStoryTestData;
		List<String> strHeaders = new ArrayList<String>();
		int columnIndex = 0;
		FileInputStream inputStream;
		XSSFWorkbook excelWB = null;
		Sheet excelSheet;
		try {
			inputStream = new FileInputStream(testDataFile(filepath));
			excelWB = new XSSFWorkbook(inputStream);
			excelSheet = excelWB.getSheet(strSheetName);
			int rowCount = excelSheet.getLastRowNum();
			Row headerRow = excelSheet.getRow(0);
			for (int j = 0; j < headerRow.getLastCellNum(); j++) {
				strHeaders.add(j, headerRow.getCell(j).getStringCellValue());
				if (headerRow.getCell(j).getStringCellValue().contains(key)) {
					columnIndex = j;
				}
			}

			for (int i = 1; i <= rowCount; i++) {
				singleStoryTestData = new HashMap<String, String>();
				Row row = excelSheet.getRow(i);
				if(row!=null){
				for (int j = 0; j < row.getLastCellNum(); j++) {
					row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
					if (!(row.getCell(j) == null && row.getCell(j).getStringCellValue().equals("")&& row.getCell(j).getStringCellValue().isEmpty()))
						singleStoryTestData.put(strHeaders.get(j), row.getCell(j).getStringCellValue());
				}
			}
				MapUtils.fnAddValueToMap(entireTestData, row.getCell(columnIndex).getStringCellValue(),
						singleStoryTestData);
			}

		} catch (FileNotFoundException e) {
			logger.error("File not found");	
			return null;
		} catch (IOException e) {
			logger.error("IOException:"+e.getMessage());
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			logger.error("Exception:"+e.getMessage());	
			e.printStackTrace();
			return null;
		} finally {
			try {

				if (excelWB != null) {
					excelWB.close();
				}
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		return entireTestData;
	}
	public HashMap<String, HashMap<String, String>> dataProviderFileUpload(
			String testDataFileName, String strSheetName) {

		entireTestData = new HashMap<String, HashMap<String, String>>();
		HashMap<String, String> rowData = null;
		List<String> strHeaders = new ArrayList<String>();
		FileInputStream inputStream;
		XSSFWorkbook excelWB = null;
		Sheet excelSheet;

		try {

			inputStream = new FileInputStream(testDataFile(testDataFileName));
			excelWB = new XSSFWorkbook(inputStream);
			excelSheet = excelWB.getSheet(strSheetName);
			int rowCount = excelSheet.getLastRowNum();
			Row headerRow = excelSheet.getRow(0);

			for (int j = 0; j < headerRow.getLastCellNum(); j++) {
				strHeaders.add(j, headerRow.getCell(j).getStringCellValue());
			}

			for (int i = 1; i <= rowCount; i++) {
				rowData = new HashMap<String, String>();
				if (i >= 8) {
					Row row = excelSheet.getRow(i);
					for (int j = 0; j < row.getLastCellNum(); j++) {
						row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
						if (row.getCell(j) != null
								&& row.getCell(j).getStringCellValue() != null
								&& !(row.getCell(j).getStringCellValue()
										.isEmpty())) {

							rowData.put(strHeaders.get(j), row.getCell(j)
									.getStringCellValue());
						}
					}
					MapUtils.fnAddValueToMap(entireTestData, row.getCell(0)
							.getStringCellValue(), rowData);
				}
			}

		} catch (FileNotFoundException e) {
			logger.error("Test Data file not find", e);
		} catch (IOException e) {

			return null;
		} catch (Exception e) {
			return null;
		} finally {
			try {
				if (excelWB != null) {
					excelWB.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return entireTestData;
	}


	public HashMap<String, HashMap<String, String>> dataProvider(String testDataFileName, String strSheetName) {

		entireTestData = new HashMap<String, HashMap<String, String>>();
		HashMap<String, String> rowData = null;
		List<String> strHeaders = new ArrayList<String>();
		FileInputStream inputStream;
		XSSFWorkbook excelWB = null;
		Sheet excelSheet;

		try {

			inputStream = new FileInputStream(testDataFile(testDataFileName));
			excelWB = new XSSFWorkbook(inputStream);
			excelSheet = excelWB.getSheet(strSheetName);
			int rowCount = excelSheet.getLastRowNum();
			Row headerRow = excelSheet.getRow(0);

			for (int j = 0; j < headerRow.getLastCellNum(); j++) {
				strHeaders.add(j, headerRow.getCell(j).getStringCellValue());
			}

			for (int i = 1; i <= rowCount; i++) {
				rowData = new HashMap<String, String>();
				Row row = excelSheet.getRow(i);
				for (int j = 0; j < row.getLastCellNum(); j++) {
					row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
					if (!(row.getCell(j) == null || row.getCell(j).getStringCellValue().equals(""))&& row.getCell(j).getStringCellValue() != null&& !(row.getCell(j).getStringCellValue().isEmpty()))
						rowData.put(strHeaders.get(j), row.getCell(j).getStringCellValue());
				}
				MapUtils.fnAddValueToMap(entireTestData, row.getCell(0).getStringCellValue(), rowData);
			}

		} catch (FileNotFoundException e) {
			logger.error("Test Data file not find", e);
		} catch (IOException e) {

			return null;
		} catch (Exception e) {
			return null;
		} finally {
			try {
				if (excelWB != null) {
					excelWB.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return entireTestData;
	}

	public void fnSetCurrentStoryTestData(String strStoryName) {

		HashMap<String, String> currentStoryTestData = this.entireTestData.get(strStoryName);
		if (currentStoryTestData == null) {
			Assert.fail("Unable to read entire test data");
		}
		ThreadLocalWorker.getTestContext().fnSetCurrentStoryTestData(currentStoryTestData);
	}

	public void iterateDataFromExcelMap(String recordKey) {
		HashMap<String, String> iteratedTestData = this.entireTestData.get(recordKey);
		if (iteratedTestData == null) {
			logger.info("Unable to read current story test data ");
			Assert.fail("Unable to read entire test data");
		}
		ThreadLocalWorker.getTestContext().setIteratedTestData(iteratedTestData);
	}

	public static void dataProviderIterator(HashMap<String, HashMap<String, String>> entireTestData, String seq) {

		HashMap<String, String> currentStoryTestData = entireTestData.get(seq);
		if (currentStoryTestData == null) {
			Assert.fail("Unable to read entire test data");
		}
		ThreadLocalWorker.getTestContext().setIteratedTestData(currentStoryTestData);
	}

	public static void csvToXLSX() {
		try {
			String csvFileAddress = "C:\\GIT\\VirgoStellar\\EmbossingPINandPriorityPassFileTemplate1807201713330666.csv"; // csv
			// file
			// address
			String xlsxFileAddress = "C:\\GIT\\VirgoStellar\\test.xlsx"; // xlsx
																			// file
																			// address
			XSSFWorkbook workBook = new XSSFWorkbook();
			XSSFSheet sheet = workBook.createSheet("sheet1");
			String currentLine = null;
			int RowNum = 0;
			BufferedReader br = new BufferedReader(new FileReader(csvFileAddress));
			while ((currentLine = br.readLine()) != null) {
				String str[] = currentLine.split(",");
				XSSFRow currentRow = sheet.createRow(RowNum);
				RowNum++;
				for (int i = 0; i < str.length; i++) {
					currentRow.createCell(i).setCellValue(str[i]);
				}
			}
			FileOutputStream fileOutputStream = new FileOutputStream(xlsxFileAddress);
			workBook.write(fileOutputStream);
			fileOutputStream.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage() + "Exception in try");
		}
	}

	public boolean iterateUploadDataFromExcelMap(String recordKey) {

		boolean flag = false;
		if (this.entireTestData.containsKey(recordKey)) {

			HashMap<String, String> UploadTestData = this.entireTestData.get(recordKey);
			if (UploadTestData == null) {
				logger.info("Unable to read current story test data ");
				Assert.fail("Unable to read entire test data");
			}
			ThreadLocalWorker.getTestContext().setApplicationUploadData(UploadTestData);
			flag = true;
		}
		return flag;
	}
	
	public List<Integer> dataProviderFileUploadHelpDesk(
			String testDataFileName, String strSheetName) {
		List<String> strHeaders = new LinkedList<String>();
		FileInputStream inputStream;
		XSSFWorkbook excelWB = null;
		Sheet excelSheet;
		List<Integer> helpdeskSearchParametersForFileUpload = new LinkedList<Integer>();

		try {

			inputStream = new FileInputStream(testDataFile(testDataFileName));
			excelWB = new XSSFWorkbook(inputStream);
			excelSheet = excelWB.getSheet(strSheetName);
			Row headerRow = excelSheet.getRow(0);
			for (int j = 1; j < headerRow.getLastCellNum()-1; j++) {
				if (!headerRow.getCell(j).getStringCellValue().contains("Seperator")) {
					strHeaders.add(headerRow.getCell(j).getStringCellValue());
					
				}
           }
			for (int i = 0; i < strHeaders.size(); i++) {
				if (strHeaders.get(i).equals("FORM_NUMBER")||strHeaders.get(i).equals("FIRST_NAME")
						|| strHeaders.get(i).equals("LAST_NAME")
						|| strHeaders.get(i).equals("REGISTERED_MAIL_ID")
						|| strHeaders.get(i).equals(
								"REGISTERED_MOBILE_NUMBER")) {
					helpdeskSearchParametersForFileUpload.add(i);
				}
			}

		} catch (FileNotFoundException e) {
			logger.error("Test Data file not find", e);
		} catch (IOException e) {

			return null;
		} catch (Exception e) {
			return null;
		} finally {
			try {
				if (excelWB != null) {
					excelWB.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return helpdeskSearchParametersForFileUpload;
	}

}
