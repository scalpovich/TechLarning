package com.mastercard.pts.integrated.issuing.domain.provider;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.transaction.ClearingTestCase;
import com.mastercard.pts.integrated.issuing.utils.ExcelUtils;

@Component
public class ClearingTestCaseProvider {

	private static final String TRANSACTION_FEE_AMOUNT = "Transaction Fee Amount";
	private static final String PRODUCT_TYPE = "Product Type";
	private static final String CARD_NUMBER = "Card Number";
	private static final String AUTH_FILE_LOCATION = "Auth file Location";
	private static final String EXCEL_PATH = "config/Data/ClearingTransaction_DataDriven.xls";
	
	public ClearingTestCase loadTestCase(String testCaseName) {
		Map<String, String> data = ExcelUtils.readDataByColumn(EXCEL_PATH, testCaseName);
		
		ClearingTestCase testCase = new ClearingTestCase();
		testCase.setTestCaseName(testCaseName);
		testCase.setAuthFilePath(data.get(AUTH_FILE_LOCATION));
		testCase.setCardNumber(data.get(CARD_NUMBER));
		testCase.setProductType(data.get(PRODUCT_TYPE));
		testCase.setTransactionFeeAmount(data.get(TRANSACTION_FEE_AMOUNT));
		return testCase;
	}
}
