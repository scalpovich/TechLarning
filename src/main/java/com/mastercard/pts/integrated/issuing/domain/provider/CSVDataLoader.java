package com.mastercard.pts.integrated.issuing.domain.provider;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

@Component("defaultDataLoader")
public class CSVDataLoader implements DataLoader {

	private static final Logger LOGGER = LoggerFactory.getLogger(CSVDataLoader.class);
	private static final String FILE_EXTN = ".csv";

	@Value("./src/main/resources/config/${env}/Data/")
	private String csvPath;

	@Override
	public Optional<Map<String, String>> loadData(String storyName) {
		if (!storyName.isEmpty()) {
			String filePath = csvPath + storyName + FILE_EXTN;
			try (InputStream is = new FileInputStream(filePath)) {
				LOGGER.info("Starting to read test data from csv file...");
				return readData(new InputStreamReader(is));
			} catch (IOException e) {
				LOGGER.error("Fail to load data from CSV", e);
				MiscUtils.propagate(e);
			}
		} else {
			LOGGER.warn("`StoryName` meta info was not found, possibly `sheetName` meta info is being used here.");
		}
		return Optional.empty();
	}

	@Override
	public Optional<Map<String, String>> loadDataByKey(String storyName, String keyName, String keyValue) {
		if (!storyName.isEmpty()) {
			String filePath = csvPath + storyName + FILE_EXTN;
			try (InputStream is = new FileInputStream(filePath)) {
				LOGGER.info("Starting to read test data from csv file...");
				return readDataByKey(new InputStreamReader(is), keyName, keyValue);
			} catch (IOException e) {
				LOGGER.error("Fail to load data from CSV", e);
				MiscUtils.propagate(e);
			}
		} else {
			LOGGER.info("`StoryName` meta info was not found, possibly `sheetName` meta info is being used here.");
		}
		return Optional.empty();
	}

	private Optional<Map<String, String>> readData(Reader reader) throws IOException {
		Iterable<CSVRecord> records = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(reader);
		// at present we are considering only the first data row
		// i.e. 2nd row in test data csv (as 1st row will be for headers),
		// in future we will consider n-rows for executing a test n-times
		return Optional.of(records.iterator().next().toMap());
	}

	private Optional<Map<String, String>> readDataByKey(Reader reader, String keyName, String keyVal)
			throws IOException {
		Iterable<CSVRecord> records = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(reader);
		LOGGER.info("Searching for test data by key {}", keyVal);
		for (CSVRecord record : records) {
			if (record.get(keyName).equals(keyVal)) {
				return Optional.of(record.toMap());
			}
		}

		return Optional.empty();
	}

}
