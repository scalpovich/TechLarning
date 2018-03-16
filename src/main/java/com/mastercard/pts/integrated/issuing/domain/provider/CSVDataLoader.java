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

	@Value("./src/main/resources/config/${env}/TestData/")
	private String csvPath;

	@Override
	public Optional<Map<String, String>> loadData(String storyName) {
		try (InputStream is = new FileInputStream(csvPath + storyName + FILE_EXTN)) {
			return readData(new InputStreamReader(is));
		} catch (IOException e) {
			LOGGER.error("Fail to load data from CSV", e);
			MiscUtils.propagate(e);
		}

		return Optional.empty();
	}

	public Optional<Map<String, String>> readData(Reader reader) throws IOException {
		Iterable<CSVRecord> records = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(reader);

		for (CSVRecord record : records) {
			return Optional.of(record.toMap());
		}

		return Optional.empty();
	}

}
