package com.mastercard.pts.integrated.issuing.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.PaymentUpload;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.opencsv.CSVWriter;

@Component
public class PaymentUploadFeature {
	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentUploadFeature.class);

	@Autowired
	private TestContext context;
	@Autowired
	private DataProvider dataProvider;

	private PaymentUpload upload;

	@Value("./src/main/resources/")
	private String csvPath;

	@Given("create Payment Upload CSV for $transactionCode")
	@When("create Payment Upload CSV for $transactionCode")
	public void DD_Payment(String transactionCode) throws IOException {

		String paymentUploadFileName = "PAY" + getDateForFileName() + CustomUtils.randomNumbers(3) + ".csv";
		context.put(ConstantData.PAYMENT_UPLOAD_FILE_NAME, paymentUploadFileName);

		File file = new File(csvPath + paymentUploadFileName);

		FileWriter outputfile = new FileWriter(file);
		CSVWriter writer = new CSVWriter(outputfile);
		String transactionCodes = transactionCode;
		String[] transactionCodesSplit = transactionCodes.split("\\|");
		int tranactionAmount = 0;
		int chequeNumber = Integer.parseInt(CustomUtils.randomNumbers(6));

		Map<Integer, List<String>> mapForCSV = new HashMap<>();
		for (int i = 0; i < transactionCodesSplit.length; i++) {
			List<String> valuesForMap = new LinkedList<>();
			upload = PaymentUpload.createWithProviderForPayment(dataProvider, transactionCodesSplit[i]);
			valuesForMap.add(upload.getTransactionCurrency());
			valuesForMap.add(upload.getTransactionCode());
			valuesForMap.add(upload.getTransactionCurrencyAmount());
			mapForCSV.put(i, valuesForMap);
			tranactionAmount += Integer.parseInt(upload.getTransactionCurrencyAmount());
		}

		context.put(ConstantData.TRANSACTION_AMOUNT, tranactionAmount);
		String[] header = { getDateForFile(), String.valueOf(transactionCodesSplit.length),
				String.valueOf(tranactionAmount) };
		writer.writeNext(header);
		for (Map.Entry<Integer, List<String>> map : mapForCSV.entrySet()) {
			String[] data = { "MUM3", String.valueOf(map.getKey() + 1), map.getValue().get(1), "5177000000001400", "", map.getValue().get(2), getDateForFile(), getDateForFile(), getDateForFile(), getDateForFile(), String.valueOf(chequeNumber), "", "", "", "", "", "", "", "", map.getValue().get(0) };
			writer.writeNext(data);
			chequeNumber += 1;
		}
		writer.close();
	}

	public String getDateForFileName() {
		Date date = Calendar.getInstance().getTime();
		DateFormat formatter = new SimpleDateFormat("ddMMyyyy");
		String today = formatter.format(date);
		return today;
	}

	public String getDateForFile() {
		Date date = Calendar.getInstance().getTime();
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String today = formatter.format(date);
		return today;
	}
}
