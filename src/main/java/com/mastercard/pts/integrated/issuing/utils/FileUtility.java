package com.mastercard.pts.integrated.issuing.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;

@Component
public class FileUtility {

	public static HashMap<String, String> getLanguageStringsFromExcelToHashMap(
			String filePath) {
		HashMap<String, String> languageStrings = new HashMap<String, String>();

		String[] tmpString = new String[2];

		try {

			FileInputStream file = new FileInputStream(new File(filePath));

			// Get the workbook instance for XLS file
			HSSFWorkbook workbook = new HSSFWorkbook(file);

			// Get first sheet from the workbook
			HSSFSheet sheet = workbook.getSheetAt(0);

			// Iterate through each rows from first sheet
			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				int i = 0;
				// For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = row.getCell(i);
					tmpString[i] = cell.getStringCellValue();

					cell = cellIterator.next();

					i++;

					if (i >= 2)
						break;

				}
				languageStrings.put(tmpString[0], tmpString[1]);
			}
			file.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return languageStrings;
	}

	// public static String[][] getTableArray(String xlFilePath, String
	// sheetName, String tableName) {
	// String[][] tabArray = null;
	// try {
	// Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
	// Sheet sheet = workbook.getSheet(sheetName);
	// int startRow, startCol, endRow, endCol, ci, cj;
	// Cell tableStart = sheet.findCell(tableName);
	// startRow = tableStart.getRow();
	// startCol = tableStart.getColumn();
	//
	// Cell tableEnd = sheet.findCell(tableName, startCol + 1, startRow + 1,
	// 100, 64000, false);
	//
	// endRow = tableEnd.getRow();
	// endCol = tableEnd.getColumn();
	// // System.out.println("startRow=" + startRow + ", endRow=" + endRow
	// // + ", " + "startCol=" + startCol + ", endCol=" + endCol);
	// tabArray = new String[endRow - startRow - 1][endCol - startCol - 1];
	// ci = 0;
	//
	// for (int i = startRow + 1; i < endRow; i++, ci++) {
	// cj = 0;
	// for (int j = startCol + 1; j < endCol; j++, cj++) {
	// tabArray[ci][cj] = sheet.getCell(j, i).getContents();
	// }
	// }
	// } catch (Exception e) {
	// MyReporter.log("error in getTableArray()");
	// e.printStackTrace();
	// }
	//
	// return (tabArray);
	// }

}
