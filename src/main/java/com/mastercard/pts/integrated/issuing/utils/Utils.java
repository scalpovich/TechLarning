package com.mastercard.pts.integrated.issuing.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.mastercard.pts.integrated.issuing.context.TestContext;

public class Utils {

	private Utils() {

	}

	public static final String JKS_STORE_FILE_PATH = "src/main/resources/keystores/48046-tcoe-mastercard-int-desktop.jks";
	public static final String JKS_STORE_PASSWORD = "zPZm6373";

	// public static final String CERT_FILE_PATH =
	// "src/main/resources/cert/49451-itf-caas-wsp.mastercard.com.crt";
	// #itf move e048264

	public static final String CERT_FILE_PATH = "src/main/resources/cert/84045-itf-caas-wsp-mastercard-com.crt";
	private static final int DEFAULT_KEY_LENGTH = 10;

	public static Object getobjectFromJsonFile(String jsonFilePath)
			throws org.json.simple.parser.ParseException, IOException {

		JSONParser parser = new JSONParser();
		Object obj = null;
		try {
			obj = parser.parse(new FileReader(jsonFilePath));
		} catch (ParseException e) {
			Utils.logged(e.getMessage(), false);
			throw e;
		} catch (FileNotFoundException e) {
			Utils.logged(e.getMessage(), false);
			throw e;

		} catch (IOException e) {
			Utils.logged(e.getMessage(), false);
			throw e;

		}

		return obj;

	}

	public static void logged(String log) {
		logged(log, true);
	}

	public static void logged(boolean log) {
		logged(Boolean.toString(log), true);
	}

	public static void logged(String log, boolean isNeedToWrite) {

		if (isNeedToWrite) {
			StringBuilder s = new StringBuilder(
					System.getProperty("line.separator") + log);
			TestContext.loggers.append(s);
		}
	}

	public static StringBuilder addLine() {
		return new StringBuilder(System.getProperty("line.separator"));
	}

	public static void displayMap(List<Map<String, Object>> results,
			boolean islog) {
		Utils.logged("No of records it fetched " + results.size(), false);
		for (Map<String, Object> map : results) {
			Utils.logged("Query Result : " + map.toString() + addLine(), islog);
		}

	}

	public static String generateStringWithUniqueKey(String text) {
		return generateStringWithUniqueKey(text, DEFAULT_KEY_LENGTH);
	}

	public static String generateStringWithUniqueKey(String text, int keyLength) {
		return text + generateUniqueKey(keyLength);
	}

	public static String generateUniqueKey() {
		return generateUniqueKey(DEFAULT_KEY_LENGTH);
	}

	public static String generateUniqueKey(int keyLength) {
		long ts = new Date().getTime();
		return StringUtils.right(Long.toString(ts), keyLength);
	}

}
