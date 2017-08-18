package com.mastercard.pts.integrated.issuing.utils;

import java.util.HashMap;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;

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
}
