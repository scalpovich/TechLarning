package com.mastercard.pts.integrated.issuing.utils;

import static org.hamcrest.text.MatchesPattern.matchesPattern;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class BatchFileValidator {
	
	private final File batch;
	
	private String headerPattern;
	
	private String linePattern;
	
	private String trailerPattern;
	
	private BatchFileValidator(File batch) {
		this.batch = batch;
	}
	
	public static BatchFileValidator forBatch(File batch) {
		return new BatchFileValidator(batch);
	}
	
	public BatchFileValidator expectHeader(String headerPattern) {
		this.headerPattern = headerPattern;
		return this;
	}
	
	public BatchFileValidator expectLine(String linePattern) {
		this.linePattern = linePattern;
		return this;
	}
	
	public BatchFileValidator expectTrailer(String trailerPattern) {
		this.trailerPattern = trailerPattern;
		return this;
	}

	public BatchFileValidator validate() {
		ArrayList<String> lines = readBatchLines();
		
		int startDataLinesIndex = 0;
		int endDataLinesIndex = lines.size() - 1;
		
		SoftAssert softAssert = new SoftAssert();
		
		// verify Header if specified
		if (headerPattern != null) {
			softAssert.andThat("Header is incorrect", lines.get(startDataLinesIndex),
					matchesPattern(headerPattern));
			startDataLinesIndex++;
		}
		
		// verify Trailer if specified
		if (trailerPattern != null) {
			softAssert.andThat("Trailer is incorrect", lines.get(endDataLinesIndex),
					matchesPattern(trailerPattern));
			endDataLinesIndex--;
		}
		
		for (int i = startDataLinesIndex; i <= endDataLinesIndex; i++) {
			softAssert.andThat("Line is incorrect at index: " + i, lines.get(i),
					matchesPattern(linePattern));
		}
		
		softAssert.assertAll();
		return this;
	}
	
	private ArrayList<String> readBatchLines() {
		List<String> rawlines;
		try {
			rawlines = Files.readLines(batch, Charsets.UTF_8);
		} catch (IOException e) {
			throw MiscUtils.propagate(e);
		}
		
		ArrayList<String> lines = new ArrayList<>(rawlines);
		
		// remove last empty line if exists
		int lastLineIndex = lines.size() - 1;
		if (lines.get(lastLineIndex).isEmpty()) {
			lines.remove(lastLineIndex);
		}
		
		return lines;
	}
	
	public List<Map<String, String>> extractData() {
		ArrayList<String> lines = readBatchLines();
		
		int startDataLinesIndex = headerPattern != null ? 1 : 0;
		int endDataLinesIndex = trailerPattern != null ? lines.size() - 1 : lines.size();
		
		Pattern pattern = Pattern.compile(linePattern);
		
		return lines.stream().skip(startDataLinesIndex).limit(endDataLinesIndex - startDataLinesIndex)
			.map(patternExtractor(pattern)).collect(Collectors.toList());
	}
	
	private Function<String, Map<String, String>> patternExtractor(Pattern pattern) {
		return line -> {
			Matcher matcher = pattern.matcher(line);
			if (!matcher.find()) {
				throw new IllegalStateException("Batch file has invalid format");
			}
			Map<String, String> lineData = MiscUtils.namedGroups(matcher);
			return lineData.entrySet().stream().collect(Collectors.toMap(Entry::getKey,
					e -> e.getValue().trim()));
		};
	}
}
