package com.mastercard.pts.integrated.issuing.domain.provider;

import static java.util.stream.Collectors.toMap;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.google.common.base.Strings;
import com.mastercard.pts.integrated.issuing.domain.customer.transaction.Transaction;
import com.mastercard.pts.integrated.issuing.utils.ExcelUtils;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

@Component
public class TransactionProvider {
	
	private static final String TRANSACTION_PROFILE = "Transaction profile";
	private static final String CARD_DE = "Card DE";
	private static final String EXPECTED_DE = "Expected DE";
	private static final String DE = "DE";
	private static final String SEQUENCE_NUMBER = "Sequence number";
	private static final String EXPIRATION_DATE = "Expiration date";
	private static final String PAN = "PAN";
	private static final String MERCHANT_PROFILE = "Merchant profile";
	private static final String TRANSACTION = "Transaction";
	private static final String EXCEL_PATH = "config/Data/AuthorizationTransaction_DataDriven.xls";
	
	public Transaction loadTransaction(String transactionName) {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(EXCEL_PATH);
		Map<String, String> data;
		try {
			data = readData(inputStream, transactionName);
		} catch (Exception e) {
			throw MiscUtils.propagate(e);
		}
		
		Transaction transaction = new Transaction();
		transaction.setTestCaseToSelect(transactionName);
		transaction.setMerchantProfile(data.get(MERCHANT_PROFILE));
		transaction.setCardNumber(data.get(PAN));
		transaction.setExpirationYear(data.get(EXPIRATION_DATE));
		transaction.setCardSequenceNumber(data.get(SEQUENCE_NUMBER));
		transaction.setDeKeyValuePair(parseDataElements(data.get(DE)));
		transaction.setExpectedDataElements(parseDataElements(data.get(EXPECTED_DE)));
		transaction.setCardDataElements(parseDataElements(data.get(CARD_DE)));
		transaction.setTransactionProfile(data.get(TRANSACTION_PROFILE));
		return transaction;
	}
	
	private Map<String, String> parseDataElements(String elementLines) {
		if (Strings.isNullOrEmpty(elementLines)) {
			return Collections.emptyMap();
		}
		return Arrays.stream(elementLines.split("\r?\n")).map(line -> line.split("="))
			.collect(toMap(pair -> pair[0], pair -> pair[1]));
	}
	
	private Map<String, String> readData(InputStream inputStream, String transactionName)
			throws BiffException, IOException {
		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(inputStream);
			Sheet sheet = workbook.getSheet(0);
			return ExcelUtils.readExcel(sheet, transactionName);
		} finally {
			if (workbook != null) {
				workbook.close();
			}
			
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}
}
