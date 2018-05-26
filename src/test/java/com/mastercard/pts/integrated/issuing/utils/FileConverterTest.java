package com.mastercard.pts.integrated.issuing.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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
		String[] listOfEnvs = { "demo", "automation2", "stageSA", /* automation */ };
		String[] dataFiles = { "TestData/TestData.xlsx", /* "Data/TestData.xls" */ };
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

	@Test
	public void addNewColumnToAllCSV() {
		final String COLUMN_TO_ADD = "INTERCHANGE";
		final String DELIMITER = ",";
		final String VISA = "VISA [01]";
		final String MC = "MASTERCARD [02]";
		final String[] VISA_PART_FILENAMES = { "_v_", "vts", "visa" };
		String[] listOfEnvs = { "demo", "automation2", "stageSA", "automation" };

		for (String env : listOfEnvs) {

			File[] csvFiles = new File(FileConverter.CONFIG_PATH + env + File.separatorChar + "Data")
					.listFiles((dir, name) -> {
						return name.toLowerCase().endsWith(".csv");
					});

			Stream.of(csvFiles).forEach(csvFile -> {
				try {
					List<String> lines = Files.readAllLines(Paths.get(csvFile.getAbsolutePath()));
					String header = lines.get(0);
					if (!header.contains(COLUMN_TO_ADD)) {
						List<String> data = new ArrayList<>();
						header = header + DELIMITER + COLUMN_TO_ADD;
						data.add(header);

						String val = MC;
						if (fileNameMatches(VISA_PART_FILENAMES, csvFile.getName())) {
							val = VISA;
						}
						for (int i = 1; i < lines.size(); i++) {
							String row = lines.get(i);
							row = row + DELIMITER + val;
							data.add(row);
						}
						writeToFile(data, csvFile);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		}
	}

	private void writeToFile(List<String> data, File csvFile) {
		try (FileWriter writer = new FileWriter(csvFile)) {
			for (String row : data) {
				writer.write(row + System.lineSeparator());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean fileNameMatches(String[] array, String item) {
		for (String search : array) {
			if (item.contains(search)) {
				return true;
			}
		}
		return false;
	}

}
