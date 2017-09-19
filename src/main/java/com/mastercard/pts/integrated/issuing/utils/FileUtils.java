package com.mastercard.pts.integrated.issuing.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.NetworkFlows;

@Component
public class FileUtils {
	final static Logger logger = LoggerFactory.getLogger(FileUtils.class);
	@Autowired
	public Environment env;
	@Autowired
	NetworkFlows networkFlow;
	@Autowired
	DateUtils dateUtils;
	@Autowired
	ZipUnzipUtils unziputils;

	@Autowired
	public static ReadTestDataFromExcel iterateExcel;

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

	public static File getTheNewestFile(String filePath, String ext) {
		CustomUtils.ThreadDotSleep(1000);
		File theNewestFile = null;
		File dir = new File(filePath);
		FileFilter fileFilter = new WildcardFileFilter("*." + ext);
		File[] files = dir.listFiles(fileFilter);
		if (files.length > 0) {
			/** The newest file comes first **/
			Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
			theNewestFile = files[0];
		}
		return theNewestFile;
	}

	public static void ReadFileAndValidate(File filepath, String ntkCode)
			throws FileNotFoundException {
		Scanner sc = new Scanner(filepath);
		sc.useDelimiter(",");
		while (sc.hasNextLine()) {
			if ((sc.hasNextLine()) == true) {
				String line = sc.nextLine();
				line.toCharArray();
				if (line.contains(ntkCode)) {
					logger.info(ntkCode + "is present");
					break;
				} else {
					continue;
				}
			} else {
				Assert.fail(ntkCode + "is not present");
			}
		}
	}

	public static String execCmd(String command) throws IOException,
			InterruptedException {
		String currentUser = null;
		Process p = null;
		BufferedReader reader = null;
		String[] strArray;
		String user = null;
		String userreturn;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			reader = new BufferedReader(new InputStreamReader(
					p.getInputStream()));
			while ((currentUser = reader.readLine()) != null) {
				user = currentUser;
				System.out.println("current user:-" + user);
			}
			p.destroy();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		strArray = user.split("\\\\");
		userreturn = strArray[1];
		System.out.println("userreturn user:-" + userreturn);
		return userreturn;
	}

	/**
	 * Implement this function to get the path of latest downloaded file.
	 * 
	 */
	public File readFile() {
		File filename = null;
		File fileNameWIthFormat;
		String filepath = "C:\\Users\\" + networkFlow.currentUser("whoami")
				+ "\\Downloads";

		if (MapUtils.fnGetInputDataFromMap("ReportFormat").contains("PDF")) {
			fileNameWIthFormat = FileUtils.getTheNewestFile(filepath, "pdf");
			filename = fileNameWIthFormat;

		} else if (MapUtils.fnGetInputDataFromMap("ReportFormat").contains(
				"Excel")) {
			if (!env.getProperty("admin").equalsIgnoreCase("Admin")) {

				fileNameWIthFormat = FileUtils.getTheNewestFile(
						env.getProperty("app.report.folder.path"), "zip");

				unziputils.unZipTheFile(fileNameWIthFormat.toString(),
						unziputils.getReportPassword(),
						env.getProperty("app.report.folder.destination.path"));
			}
			filename = FileUtils.getTheNewestFile(
					env.getProperty("app.report.folder.destination.path"),
					"xlsx");
		}
		return filename;
	}

	public static void validatebatchFile(String filepath)
			throws FileNotFoundException {
		HashMap<String, HashMap<String, String>> map = iterateExcel
				.fnReadEntireTestData(System.getProperty("user.dir")
						+ "\\TempFiles\\EmbossingInputTemplate.xlsx", "Sheet1",
						"Sr No.");
		String[] lineArray;
		File filesrc = new File(filepath);
		Scanner sc = new Scanner(filesrc);
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			line.toCharArray();
			if (!line.startsWith("HR") && !line.startsWith("TR")
					&& !line.startsWith("HD") && !line.startsWith("TD")) {
				lineArray = line.split("\\|");
				for (int i = 1; i <= map.size(); i++) {
					ReadTestDataFromExcel.dataProviderIterator(map,
							String.valueOf(i));
					String FieldToBeAdded = MapUtils
							.getIterativeDataFromDatamap("Template Fields");
					int length = Integer.valueOf(MapUtils
							.getIterativeDataFromDatamap("Length"));
					length = length + 1;
					String field = "([A-Za-z0-9]{0," + length + "})";
					String fieldTobeMatched = lineArray[i - 1].replaceAll(" ",
							"");
					boolean ppattern = Pattern.matches(field, fieldTobeMatched);
					Assert.assertTrue("Field validated succesfully" + " "
							+ FieldToBeAdded, ppattern);
				}
			}

		}
		sc.close();
	}
}
