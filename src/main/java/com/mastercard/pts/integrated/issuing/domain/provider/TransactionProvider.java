package com.mastercard.pts.integrated.issuing.domain.provider;

import static java.util.stream.Collectors.toMap;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.google.common.base.Strings;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.transaction.Transaction;
import com.mastercard.pts.integrated.issuing.utils.ExcelUtils;

@Component
public class TransactionProvider {

	private static final String 	 = "Transaction template";
	private static final String SHEET_DATA_DRIVEN = "Data Driven";
	private static final String SHEET_TRANSACTION_TEMPLATES = "Transaction Templates";
	private static final String TRANSACTION_PROFILE = "Transaction profile";
	private static final String CARD_DE = "Card DE";
	private static final String EXPECTED_DE = "Expected DE";
	private static final String DE = "DE";
	private static final String SEQUENCE_NUMBER = "SEQUENCE_NUMBER";
	private static final String EXPIRATION_DATE = "EXPIRATION_DATE";
	private static final String SERVICE_CODE = "SERVICE_CODE";
	private static final String PAN = "PAN";
	private static final String PIN = "PIN";
	private static final String MERCHANT_PROFILE = "Merchant profile";
	private static final String EXCEL_PATH = "config/Data/AuthorizationTransaction_DataDriven.xls";
	private static final String CURRENCY = "CURRENCY";
	private static final String CVV2 = "CVV2";

	private final Map<String, Function<Transaction, String>> valueProviders;

	public TransactionProvider() {
		valueProviders = new HashMap<>();
		valueProviders.put(PAN, Transaction::getCardNumber);
		valueProviders.put(PIN, Transaction::getPinForTransaction);
		valueProviders.put(SERVICE_CODE, Transaction::getServiceCode);
		valueProviders.put(EXPIRATION_DATE, Transaction::getExpirationYear);
		valueProviders.put(SEQUENCE_NUMBER, Transaction::getCardSequenceNumber);
		valueProviders.put(CVV2, Transaction::getCvvData2);
	}

	public Transaction loadTransaction(String transactionName, Device device) {
		Map<String, String> templateData = ExcelUtils.readDataBySheetAndColumn(EXCEL_PATH, SHEET_TRANSACTION_TEMPLATES, transactionName);

		Transaction transaction = new Transaction();
		transaction.setTestCaseToSelect(transactionName);
		transaction.setMerchantProfile(templateData.get(MERCHANT_PROFILE));
		transaction.setTransactionProfile(templateData.get(TRANSACTION_PROFILE));

		loadDeviceDataFromDevice(transaction, device);

		transaction.setDeKeyValuePair(parseDataElements(templateData.get(DE), transaction));
		transaction.setExpectedDataElements(parseDataElements(templateData.get(EXPECTED_DE), transaction));
		transaction.setCardDataElements(parseDataElements(templateData.get(CARD_DE), transaction));
		return transaction;
	}

	public Transaction loadTransaction(String testCaseName) {
		Map<String, String> deviceData = ExcelUtils.readDataBySheetAndColumn(EXCEL_PATH, SHEET_DATA_DRIVEN, testCaseName);

		String templateName = deviceData.get(TRANSACTION_TEMPLATE);

		Map<String, String> templateData = ExcelUtils.readDataBySheetAndColumn(EXCEL_PATH, SHEET_TRANSACTION_TEMPLATES, templateName);

		Transaction transaction = new Transaction();
		transaction.setTestCaseToSelect(templateName);
		transaction.setMerchantProfile(templateData.get(MERCHANT_PROFILE));
		transaction.setTransactionProfile(templateData.get(TRANSACTION_PROFILE));

		Function<String, String> dataProvider = key -> {
			String value = deviceData.get(key);
			if (Strings.isNullOrEmpty(value)) {
				value = templateData.get(key);
			}
			return value;
		};

		loadDeviceDataFromExcel(transaction, deviceData);

		transaction.setDeKeyValuePair(parseDataElements(dataProvider.apply(DE), transaction));
		transaction.setExpectedDataElements(parseDataElements(dataProvider.apply(EXPECTED_DE), transaction));
		transaction.setCardDataElements(parseDataElements(dataProvider.apply(CARD_DE), transaction));
		return transaction;
	}

	public Transaction createWithProvider(KeyValueProvider provider) {
		Transaction transactionData  = new Transaction();
		transactionData.setCurrency(provider.getString(CURRENCY).replaceAll("\\D+","")); // getting numbers only
		return transactionData;
	}

	private void loadDeviceDataFromDevice(Transaction transaction, Device device) {
		transaction.setCardNumber(device.getDeviceNumber());
		transaction.setExpirationYear(device.getExpirationDate());
		transaction.setCardSequenceNumber(device.getSequenceNumber());
		transaction.setPinForTransaction(device.getPinNumberForTransaction());
		transaction.setCvvData2(device.getCvv2Data());
	}

	private void loadDeviceDataFromExcel(Transaction transaction, Map<String, String> data) {
		transaction.setCardNumber(data.get(PAN));
		transaction.setExpirationYear(data.get(EXPIRATION_DATE));
		transaction.setServiceCode(data.get(SERVICE_CODE));
		transaction.setCardSequenceNumber(data.get(SEQUENCE_NUMBER));
		transaction.setPinForTransaction(data.get(PIN));
		transaction.setCvvData2(data.get(CVV2));
	}

	private Map<String, String> parseDataElements(String elementLines, Transaction transaction) {
		if (Strings.isNullOrEmpty(elementLines)) {
			return Collections.emptyMap();
		}
		return Arrays.stream(elementLines.split("\r?\n")).map(line -> line.split("="))
				.collect(toMap(pair -> pair[0], pair -> transformValue(pair[1], transaction)));
	}

	private String transformValue(String value, Transaction transaction) {
		if (!value.startsWith("$")) {
			return value;
		}
		Function<Transaction, String> provider = valueProviders.get(value.substring(1));
		return provider != null
				? provider.apply(transaction)
						: value;
	}
}
