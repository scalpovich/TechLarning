package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.DecimalFormat;
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

import com.mastercard.pts.integrated.issuing.configuration.LinuxBox;
import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.PaymentUpload;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.opencsv.CSVWriter;

@Component
public class PaymentUploadFeatureSteps {
	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentUploadFeatureSteps.class);

	@Autowired
	private TestContext context;
	@Autowired
	private DataProvider dataProvider;

	@Autowired
	public LinuxBox linuxBox;
	
	@Autowired
	private Path tempDirectory;

	private PaymentUpload upload;

	@Value("./src/main/resources/")
	private String csvPath;
	
	@Value("${linux.folder.path}")
	private String folderPath;
	
	@Value("${linux.payment_upload.path}")
	private String paymentFileUploadPath;

	@Given("create Payment Upload CSV for $transactionCode and upload it on server")
	@When("create Payment Upload CSV for $transactionCode and upload it on server")
	public void uploadPaymentFileToServer(String transactionCode) throws IOException {

	
		String paymentUploadFileName = "PAY" + getDateForFileName() + CustomUtils.randomNumbers(3) + ".csv";
		context.put(ConstantData.PAYMENT_UPLOAD_FILE_NAME, paymentUploadFileName);

		Device device = context.get(ContextConstants.DEVICE);
		
		File file = new File(tempDirectory.toString() + "/" + paymentUploadFileName);

		FileWriter outputfile = new FileWriter(file);
		CSVWriter writer = new CSVWriter(outputfile, ',', CSVWriter.NO_QUOTE_CHARACTER);
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
			valuesForMap.add(upload.getChequeNumber());
			valuesForMap.add(upload.getReturnedReason());
			mapForCSV.put(i, valuesForMap);
			tranactionAmount += Integer.parseInt(upload.getTransactionCurrencyAmount());
		}

		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		context.put(ConstantData.TRANSACTION_AMOUNT, String.valueOf(decimalFormat.format(tranactionAmount)));
		
		String[] header = { getDateForFile(), String.valueOf(transactionCodesSplit.length),
				String.valueOf(tranactionAmount) };
		writer.writeNext(header);
		for (Map.Entry<Integer, List<String>> map : mapForCSV.entrySet()) {
			String[] data = { "MUM3", String.valueOf(map.getKey() + 1), map.getValue().get(1), device.getDeviceNumber(), "", map.getValue().get(2), getDateForFile(), getDateForFile(), getDateForFile(), getDateForFile(), map.getValue().get(3), map.getValue().get(4), "", "", "", "", "", "", "", map.getValue().get(0), "" };
			writer.writeNext(data);
			chequeNumber += 1;
		}

		writer.close();
		
		linuxBox.upload(file.getPath(), folderPath+paymentFileUploadPath);
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
