package com.mastercard.pts.integrated.issuing.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.common.base.Throwables;
import com.mastercard.pts.integrated.issuing.configuration.LinuxBox;
import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.CustomerType;
import com.mastercard.pts.integrated.issuing.domain.DeviceType;
import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.customer.admin.InstitutionCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceRange;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.NewDevice;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Vendor;
import com.mastercard.pts.integrated.issuing.domain.customer.processingcenter.Institution;
import com.mastercard.pts.integrated.issuing.domain.helpdesk.HelpDeskGeneral;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.CurrencyExchangeRatesPage;

@Component
public class FileCreation {
	private static final Logger logger = LoggerFactory.getLogger(FileCreation.class);

	@Autowired
	private CurrencyExchangeRatesPage currencyExchangeRatesPage;

	@Autowired
	public LinuxBox linuxBox;

	@Autowired
	ReadTestDataFromExcel dataReader;
	@Autowired
	DevicePlan deviceplan;
	@Autowired
	NewDevice newDevice;
	@Autowired
	Program program;
	@Autowired
	Vendor vendor;
	@Autowired
	HelpDeskGeneral helpDeskGeneral;
	
	@Value("${linux.application.upload.path}")
	private String applicationUpload;
	
	@Value("${linux.folder.path}")
	private String linuxFolderPath;
	

	@Autowired
	private DataProvider provider;
	

	@Autowired
	private TestContext context;

	private static final String INSTITUTION_CODE = "INSTITUTION_CODE";
	private static final String BILLING_AMOUNT = "BILLING_AMOUNT";
	private static final String BILLING_CURRENCY = "BILLING_CURRENCY";
	private static final String TRANSACTION_AMOUNT = "TRANSACTION_AMOUNT";
	private static final String TRANSACTION_CURRENCY = "TRANSACTION_CURRENCY";
	private static final String TRANSACTION_CODE = "TRANSACTION_CODE";
	private static final String CER_SEQUENCE = "CER_SEQUENCE";
	private static final String RATE_ORIGIN = "RATE_ORIGIN";
	private static final String SOURCE_CURRENCY = "SOURCE_CURRENCY";
	private static final String DEST_CURRENCY = "DEST_CURRENCY";
	private static final String BUY_RATE = "BUY_RATE";
	private static final String MID_RATE = "SOURCE_CURRENCY";
	private static final String SELL_RATE = "DEST_CURRENCY";
	private static final String UPLOAD_FILENAME = "UploadFile";	
	private static final String CORPORATE_CLIENT_CODE = "12121217222000002";

	private String filename;
	private String header;
	private String footer;
	private String transactionLine;
	public static String filenameStatic;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getFooter() {
		return footer;
	}

	public void setFooter(String footer) {
		this.footer = footer;
	}

	public String getTransactionLine() {
		return transactionLine;
	}

	public static String createTransactionLine(String deviceNumber, String walletNumber, KeyValueProvider provider) {
		return deviceNumber + "|" + walletNumber + "|0|" + DateUtils.getDateddMMyyyy() + "|" + provider.getString(TRANSACTION_CODE) + "|" + provider.getString(TRANSACTION_AMOUNT) + "|"
				+ provider.getString(TRANSACTION_CURRENCY) + "||" + DateUtils.getDateddMMyyyy() + "|" + provider.getString(BILLING_AMOUNT) + "|" + provider.getString(BILLING_CURRENCY) + "|"
				+ ConstantData.GENERIC_DESCRIPTION + "|||" + "00000000";
	}

	public static String getFileContents(String file) throws IOException {
		String content = null;
		FileInputStream inputStream = new FileInputStream(file);
		try {
			content = IOUtils.toString(inputStream);
		} catch (IOException e) {
			logger.error(ConstantData.EXCEPTION, e);
			// NO SONAR. We are propagating exception to another class where it
			// is thrown
			MiscUtils.propagate(e);
		} finally {
			inputStream.close();
		}
		return content;
	}

	public void setTransactionLine(String transactionLine) {
		this.transactionLine = transactionLine;
	}

	public static FileCreation createFile(KeyValueProvider provider) {
		FileCreation file = new FileCreation();
		file.setFilename("TXU" + provider.getString(INSTITUTION_CODE) + DateUtils.getDate() + DateUtils.getTime() + ".DAT");
		file.setHeader("HD" + provider.getString(INSTITUTION_CODE) + DateUtils.getDateTimeDDMMYYYYHHMMSS() + "2.0");
		file.setFooter("FT" + "000000001");
		return file;
	}

	public String createCERFileMC() {
		FileCreation fileCreation = new FileCreation();
		String date = nextDay(DateUtils.getDateddMMyyyy(), "Mastercard");
		String time = DateUtils.getTime();

		filenameStatic = "TT057T0." + date + "-" + time.substring(0, 2) + "-" + time.substring(2, 4) + "-" + time.substring(4) + ".001";
		fileCreation.setFilename(filenameStatic);
		File file = new File(filenameStatic);

		dataReader.fnReadEntireTestData(UPLOAD_FILENAME, "CERFileUploadMC", "Records");

		try (PrintWriter writer = new PrintWriter(file)) {
			writer.println(createCERMCHeader(date, time));
			for (int i = 0; i <= 1; i++) {
				if (dataReader.iterateUploadDataFromExcelMap("Test Record " + (i + 1))) {
					writer.println(createCERMCRecord());
				}
			}
			writer.print("T00016600001359263799930                                                                                                     ");
		} catch (IOException e) {
			logger.error("Fail to create page object: {}", e);
			throw Throwables.propagate(e);
		}
		logger.info("File Path" + file.getPath());
		linuxBox.upload(file.getPath(), Constants.UPLOAD_FILE_PATH_EXCHANGE_RATE_MC);
		return filename;
	}

	public static String createRateString(String rate) {
		String finalBuyRate = "";
		String zeros = "";
		int location = 0;
		int zerosToBeAdded = 0;
		if (rate.contains(".")) {
			for (int i = 0; i < rate.length(); i++) {
				if (rate.charAt(i) == '.') {
					location = i;
					break;
				}
			}
			StringBuilder sb = new StringBuilder(rate);
			sb.deleteCharAt(location);
			finalBuyRate = sb.toString();
		} else {
			finalBuyRate = rate;
		}
		if (finalBuyRate.length() < 10)
			zerosToBeAdded = 10 - finalBuyRate.length();
		for (int i = 0; i < zerosToBeAdded; i++) {
			zeros += "0";
		}
		return zeros + finalBuyRate + "00000";
	}

	public String createRecordNumber(int size, int numberOfRecords) {
		StringBuilder sb = new StringBuilder("0");
		for (int i = 1; i <= size - String.valueOf(numberOfRecords).length() - 1; i++) {
			sb.append("0");
		}
		return sb + String.valueOf(numberOfRecords);
	}

	public static String getUploadFileFromDatamap(String strKey) {
		Map<String, String> storyTestData = ThreadLocalWorker.getTestContext().getApplicationUploadData();
		if (!storyTestData.containsKey(strKey)) {
			logger.info("Unable to read test data for the Key : {}", strKey);
			return null;
		} else {
			return storyTestData.get(strKey);
		}
	}

	public String appendZeros(int number) {
		String str = "";
		if (number > 0 && number < 10)
			str = "0" + number;
		else
			str = String.valueOf(number);
		return str;
	}

	public String nextDay(String date, String format) {
		int day = Integer.parseInt(date.substring(0, 2));
		int month = Integer.parseInt(date.substring(2, 4));
		int year = Integer.parseInt(date.substring(4));

		if (month == 2) {
			if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
				// Leap Year
				if (day > 0 && day < 29)
					day += 1;
				else if (day == 29) {
					day = 1;
					month += 1;
				}
			} else {
				if (day > 0 && day < 28)
					day += 1;
				else if (day == 28) {
					day = 1;
					month += 1;
				}
			}
		} else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			if (day > 0 && day < 31)
				day += 1;
			else if (day == 31) {
				day = 1;
				if (month == 12)
					month = 1;
				else if (month < 12)
					month += 1;
			}
		} else if (month == 4 || month == 6 || month == 9) {
			if (day > 0 && day < 30)
				day += 1;
			else if (day == 30) {
				day = 1;
				month += 1;
			}
		}
		if (format.equals("Mastercard"))
			return appendZeros(year) + "-" + appendZeros(month) + "-" + appendZeros(day);
		else
			return appendZeros(day) + appendZeros(month) + appendZeros(year);
	}

	public String getSequenceNumber() {
		String sequenceNumber = "";
		int number = Integer.parseInt(MapUtils.fnGetInputDataFromMap("CER_SEQUENCE"));
		if (number == 99)
			number = 1;
		else if (number < 99)
			number += 1;
		if (number >= 1 && number < 10)
			sequenceNumber = "0" + number;
		else if (number >= 10)
			sequenceNumber = String.valueOf(number);
		MapUtils.fnSetInputDataToInputMap("CER_SEQUENCE", sequenceNumber);
		return sequenceNumber;
	}

	public String createCERBankRecord(String date) {
		String programCode = getUploadFileFromDatamap("Program");
		String toleranceLoad = getUploadFileFromDatamap("Tolerance Load");
		String toleranceRefund = getUploadFileFromDatamap("Tolerance Refund");
		String record = "DR" + "|1|" + currencyExchangeRatesPage.getCode(getUploadFileFromDatamap("Rate Origin")) + "|"
				+ currencyExchangeRatesPage.getCode(getUploadFileFromDatamap("Source Currency")) + "|" + currencyExchangeRatesPage.getCode(getUploadFileFromDatamap("Destination Currency")) + "|"
				+ date + "|" + createRateString(getUploadFileFromDatamap("BUY_RATE")) + "|" + createRateString(getUploadFileFromDatamap("MID_RATE")) + "|"
				+ createRateString(getUploadFileFromDatamap("SELL_RATE")) + "|";
		if (programCode != null)
			record = record + currencyExchangeRatesPage.getCode(getUploadFileFromDatamap("Program")) + "|";
		else
			record = record + "|";

		if (toleranceLoad != null)
			record = record + getUploadFileFromDatamap("Tolerance Load") + "|";
		else
			record = record + "|";

		if (toleranceRefund != null)
			record = record + getUploadFileFromDatamap("Tolerance Refund") + "|";
		else
			record = record + "|";
		return record;
	}

	public String createCERBankHeader(String date) {
		InstitutionCreation institute;
		if (context.get(ContextConstants.INSTITUTION) != null) {
			institute = context.get(ContextConstants.INSTITUTION);
			return "HD" + "|" + institute.getInstitutionCode() + "|" + date
					+ "|" + "2.0";
		} else
			return "HD" + "|"
					+ MapUtils.fnGetInputDataFromMap("INSTITUTION_CODE") + "|"
					+ date + "|" + "2.0";
	}

	public String createCERMCRecord() {
		return "D" + currencyExchangeRatesPage.getCode(getUploadFileFromDatamap("Source Currency")) + currencyExchangeRatesPage.getCode(getUploadFileFromDatamap("Destination Currency")) + "3MD"
				+ createRateString(getUploadFileFromDatamap("BUY_RATE")) + createRateString(getUploadFileFromDatamap("MID_RATE")) + createRateString(getUploadFileFromDatamap("SELL_RATE"))
				+ "999999999999999" + "                                                       ";
	}

	public String createCERMCHeader(String date, String time) {
		return "H" + date.replace("-", "") + time + "1" + "                                                                                                             ";
	}

	// Currency Exchange Rates File Upload: Bank
	public String createCERUploadFileBank(String isInvalid, String filePath) {
		int totalRecords = 0;
		String date = "";
		FileCreation fileCreation = new FileCreation();
		HashMap<String, HashMap<String, String>> applicationUploadMap;
		InstitutionCreation instituteCreation;

		if ("back dated transactions".equalsIgnoreCase(isInvalid))
			date = DateUtils.getDateddMMyyyy() + DateUtils.getTime();
		else
			date = nextDay(DateUtils.getDateddMMyyyy(), "Bank") + DateUtils.getTime();

		if (context.get(ContextConstants.INSTITUTION) != null) {
			instituteCreation = context.get(ContextConstants.INSTITUTION);
			filenameStatic = "CER" + instituteCreation.getInstitutionCode()
					+ DateUtils.getDate() + DateUtils.getTime()
					+ getSequenceNumber() + ".DAT";
		} else {
			filenameStatic = "CER"
					+ MapUtils.fnGetInputDataFromMap("INSTITUTION_CODE")
					+ DateUtils.getDate() + DateUtils.getTime()
					+ getSequenceNumber() + ".DAT";
		}
		fileCreation.setFilename(filenameStatic);
		File file = new File(filenameStatic);

		if ("bank".equalsIgnoreCase(isInvalid))
			applicationUploadMap = dataReader.fnReadEntireTestData(UPLOAD_FILENAME, "CERFileUpload", "Records");
		else
			applicationUploadMap = dataReader.fnReadEntireTestData(UPLOAD_FILENAME, "CERFileUploadInvalid", "Records");

		try (PrintWriter writer = new PrintWriter(file)) {
			writer.println(createCERBankHeader(date));
			if ("bank".equalsIgnoreCase(isInvalid)) {
				for (int i = 0; i < applicationUploadMap.size(); i++) {
					if (dataReader.iterateUploadDataFromExcelMap("Test Record " + (i + 1))) {
						writer.println(createCERBankRecord(date));
						totalRecords++;
					}
				}
			} else {
				if (dataReader.iterateUploadDataFromExcelMap(isInvalid)) {
					writer.println(createCERBankRecord(date));
					totalRecords++;
				} else {
					dataReader.iterateUploadDataFromExcelMap("invalid scenario");
					writer.println(createCERBankRecord(date));
					totalRecords++;
				}
			}

			if ("invalid footer".equalsIgnoreCase(isInvalid))
				writer.print("FT|000000008");
			else
				writer.print("FT|" + createRecordNumber(9, totalRecords));
		} catch (IOException e) {
			logger.error("Fail to create page object: {}", e);
			throw Throwables.propagate(e);
		}
		logger.info("File Path: " + file.getPath());
		linuxBox.upload(file.getPath(), filePath);
		return filename;
	}

	private List<String> getUploadedValues;

	public List<String> getGetUploadedValues() {
		return getUploadedValues;
	}

	public void setGetUploadedValues(List<String> uploadedValues) {
		this.getUploadedValues = uploadedValues;
	}

	public String createApplicationUploadForFile(String institutionCode, String customerType) throws FileNotFoundException {
		int totalRecords = 0;
		String fileName = "APPPR" + institutionCode + DateUtils.getDateTimeDDMMYYHHMMSS() + MiscUtils.generateRandomNumberAsString(6) + ".DAT";
		HashMap<String, HashMap<String, String>> applicationUploadMap;
		File file = new File(fileName);
		String remoteDir = linuxFolderPath+applicationUpload;

		applicationUploadMap = dataReader.dataProviderFileUpload("AllUploadTestData", "Prepaid Card File");
		logger.info("applicationUploadMap = {} ", applicationUploadMap);
		try (PrintWriter writer = new PrintWriter(file)) {
			writer.println("HD|" + institutionCode + "|" + DateUtils.getDateTimeDDMMYYYYHHMMSS() + "|" + "2.0");

			for (int i = 0; i < applicationUploadMap.size(); i++) {
				if (dataReader.iterateUploadDataFromExcelMap("Test Record " + (i + 1))) {
					String name = CustomUtils.randomString(9).toUpperCase();
					helpDeskGeneral.setFirstName(name);
					if (customerType.equals("Individual")) {
						writer.println(getUploadFileFromDatamap("Concatenated Application Record").replace("%B%", institutionCode).replace("%t%", "0").replace("%P%", program.getProgramCode())
								.replace("%D%", deviceplan.getDevicePlanCode()).replace("%b%", vendor.getBranchCode()).replace("%Z%", "").replace("%N%", name)
								.replace("%K%", CustomUtils.RandomNumbers(10)).replace("%X%", CustomUtils.randomAlphaNumeric(5) + "@" + CustomUtils.randomAlphaNumeric(4) + ".com"));
					} else if (customerType.equals("Corporate")) {
						writer.println(getUploadFileFromDatamap("Concatenated Application Record").replace("%B%", institutionCode).replace("%t%", "1").replace("%P%", program.getProgramCode())
								.replace("%D%", deviceplan.getDevicePlanCode()).replace("%b%", vendor.getBranchCode()).replace("%Z%", CORPORATE_CLIENT_CODE).replace("%N%", name));
					} else if (customerType.equals("Bank Staff")) {
						writer.println(getUploadFileFromDatamap("Concatenated Application Record").replace("%B%", institutionCode).replace("%t%", "2").replace("%P%", program.getProgramCode())
								.replace("%D%", deviceplan.getDevicePlanCode()).replace("%b%", vendor.getBranchCode()).replace("%Z%", "").replace("%N%", name));
					}

					totalRecords++;

				}

			}
			writer.print("FT|" + createRecordNumber(9, totalRecords));
		} catch (IOException e) {
			logger.error("Fail to create page object: {}", e);
			throw MiscUtils.propagate(e);
		}

		linuxBox.upload(file.getPath(), remoteDir);
		logger.info("File Path = {} --> Name = {}", file.getPath(), file.getAbsolutePath());
		return fileName;
	}

	public String createApplicationUploadForFileStaticVirtualCard(String institutionCode, String customerType) throws FileNotFoundException {
		int totalRecords = 0;
		String fileName = "APPPR" + institutionCode + DateUtils.getDateTimeDDMMYYHHMMSS() + MiscUtils.generateRandomNumberAsString(6) + ".DAT";
		HashMap<String, HashMap<String, String>> applicationUploadMap;
		File file = new File(fileName);
		String remoteDir = Constants.APPLICATION_UPLOAD_PREPAID_FILE_PATH;

		applicationUploadMap = dataReader.dataProviderFileUpload("AllUploadTestData", "Static Card File");
		logger.info("applicationUploadMap = {} ", applicationUploadMap);
		try (PrintWriter writer = new PrintWriter(file)) {
			writer.println("HD|" + institutionCode + "|" + DateUtils.getDateTimeDDMMYYYYHHMMSS() + "|" + "2.0");

			for (int i = 0; i < applicationUploadMap.size(); i++) {
				if (dataReader.iterateUploadDataFromExcelMap("Test Record " + (i + 1))) {
					String name = CustomUtils.randomString(9).toUpperCase();
					helpDeskGeneral.setFirstName(name);
					if (customerType.equals("Individual")) {
						writer.println(getUploadFileFromDatamap("Concatenated Application Record").replace("%B%", institutionCode).replace("%t%", "0").replace("%P%", program.getProgramCode())
								.replace("%D%", deviceplan.getDevicePlanCode()).replace("%b%", vendor.getBranchCode()).replace("%Z%", "").replace("%N%", name)
								.replace("%K%", CustomUtils.RandomNumbers(10)).replace("%X%", CustomUtils.randomAlphaNumeric(5) + "@" + CustomUtils.randomAlphaNumeric(4) + ".com"));
					} else if (customerType.equals("Corporate")) {
						writer.println(getUploadFileFromDatamap("Concatenated Application Record").replace("%B%", institutionCode).replace("%t%", "1").replace("%P%", program.getProgramCode())
								.replace("%D%", deviceplan.getDevicePlanCode()).replace("%b%", vendor.getBranchCode()).replace("%Z%", CORPORATE_CLIENT_CODE).replace("%N%", name));
					} else if (customerType.equals("Bank Staff")) {
						writer.println(getUploadFileFromDatamap("Concatenated Application Record").replace("%B%", institutionCode).replace("%t%", "2").replace("%P%", program.getProgramCode())
								.replace("%D%", deviceplan.getDevicePlanCode()).replace("%b%", vendor.getBranchCode()).replace("%Z%", "").replace("%N%", name));
					}

					totalRecords++;

				}

			}
			writer.print("FT|" + createRecordNumber(9, totalRecords));
		} catch (IOException e) {
			logger.error("Fail to create page object: {}", e);
			throw MiscUtils.propagate(e);
		}

		linuxBox.upload(file.getPath(), remoteDir);
		logger.info("File Path = {} --> Name = {}", file.getPath(), file.getAbsolutePath());
		logger.info(customerType);
		return fileName;
	}
	
	public String createApplicationUploadFile(String INSTITUTION_CODE, String customerType, String cardType) throws Exception {
		DeviceRange deviceRange = context.get(ContextConstants.DEVICE_RANGE);
		DevicePlan devicePlan = context.get(ContextConstants.DEVICE_PLAN);
		Program program = context.get(ContextConstants.PROGRAM);
		String branch = deviceRange.getBranch();
		String branchCode = "";
		if (branch.contains("[")) {
			branchCode = branch.substring(branch.indexOf("[") + 1, branch.length() - 1);
		} else {
			branchCode = branch;
		}
		int totalRecords = 0;
		String fileName = "";
		String remoteDir = "";
		String deviceType = "";
		if (cardType.equalsIgnoreCase("prepaid")) {
			remoteDir = Institution.createWithProvider(provider).getPrepaidLinuxUploadPath();
		}

		else if (cardType.equalsIgnoreCase("credit")) {
			remoteDir = Institution.createWithProvider(provider).getCreditLinuxUploadPath();
		}
		File folder = new File(System.getProperty("user.dir"));
		File[] listOfFiles = folder.listFiles();
		logger.info("Length Of all Files:{}", listOfFiles.length);

			if (cardType.equalsIgnoreCase("prepaid")) {
				fileName = "APPPR" + INSTITUTION_CODE + DateUtils.getDateTimeDDMMYYHHMMSS() + MiscUtils.generateRandomNumberAsString(6) + ".DAT";
			} else if (cardType.equalsIgnoreCase("credit")) {
				fileName = "APPCR" + INSTITUTION_CODE + DateUtils.getDateTimeDDMMYYHHMMSS() + MiscUtils.generateRandomNumberAsString(6) + ".DAT";
			}
			HashMap<String, HashMap<String, String>> applicationUploadMap = new HashMap<>();
			File file = new File(fileName);
			if (cardType.equalsIgnoreCase("prepaid")) {
				applicationUploadMap = dataReader.dataProviderFileUpload("AllUploadTestData", "Prepaid Card File");
			} else if (cardType.equalsIgnoreCase("credit")) {
				applicationUploadMap = dataReader.dataProviderFileUpload("AllUploadTestData", "Credit Card File");
			}

			try (PrintWriter writer = new PrintWriter(file)) {
				writer.println("HD|" + INSTITUTION_CODE + "|" + DateUtils.getDateTimeDDMMYYYYHHMMSS() + "|" + "2.0");
				String name = CustomUtils.randomString(9).toUpperCase();
				String lastName = CustomUtils.randomString(11).toUpperCase();
				helpDeskGeneral.setFirstName(name);
				helpDeskGeneral.setLastName(lastName);

				for (int i = 0; i < applicationUploadMap.size(); i++) {
					if (true == dataReader.iterateUploadDataFromExcelMap("Test Record " + (i + 1))) {

						if (DeviceType.MAGNETIC_STRIPE_CARD.toUpperCase().contains(devicePlan.getDeviceType().toUpperCase())) {
							deviceType = "1";
						} else if (DeviceType.EMV_CARD.toUpperCase().contains(devicePlan.getDeviceType().toUpperCase())) {
							deviceType = "2";
						} else if (DeviceType.PHYSICAL_NFC_DEVICE_MAG_STRIPE_PAYPASS.toUpperCase().contains(devicePlan.getDeviceType().toUpperCase())) {
							deviceType = "3";
						} else if (DeviceType.PHYSICAL_NFC_DEVICE_EMV_PAYPASS.toUpperCase().contains(devicePlan.getDeviceType().toUpperCase())) {
							deviceType = "4";
						} else if (DeviceType.PHYSICAL_NFC_DEVICE_PAYPASS.toUpperCase().contains(devicePlan.getDeviceType().toUpperCase())) {
							deviceType = "5";
						} else if (DeviceType.STATIC_VIRTUAL_CARD.toUpperCase().contains(devicePlan.getDeviceType().toUpperCase())) {
							deviceType = "7";
						} else if (DeviceType.LIMITED_VALIDITY_VIRTUAL_CARD.toUpperCase().contains(devicePlan.getDeviceType().toUpperCase())) {
							deviceType = "8";
						}
						if (customerType.equals(CustomerType.INDIVIDUAL)) {
							writer.println(getUploadFileFromDatamap("Concatenated Application Record").replace("%B%", INSTITUTION_CODE).replace("%F%", "FORM" + CustomUtils.randomAlphaNumeric(6)).replace("%t%", "0").replace("%P%", program.getProgramCode()).replace("%q%", deviceType).replace("%D%", devicePlan.getDevicePlanCode()).replace("%b%", branchCode).replace("%Z%", "").replace("%N%", CustomUtils.randomString(9).toUpperCase()).replace("%I%", CustomUtils.randomString(11).toUpperCase()).replace("%K%", CustomUtils.RandomNumbers(10)).replace("%X%", CustomUtils.randomAlphaNumeric(5) + "@" + CustomUtils.randomAlphaNumeric(4) + ".com"));
						} else if (customerType.equals(CustomerType.CORPORATE) && cardType.equalsIgnoreCase(ProductType.Prepaid)) {
							writer.println(getUploadFileFromDatamap("Concatenated Application Record").replace("%B%", INSTITUTION_CODE).replace("%F%", "FORM" + CustomUtils.randomAlphaNumeric(6)).replace("%t%", "1").replace("%P%", program.getProgramCode()).replace("%q%", deviceType).replace("%D%", devicePlan.getDevicePlanCode()).replace("%b%", branchCode).replace("%Z%", Institution.createWithProvider(provider).getCorporateClientCodePrepaid()).replace("%N%", CustomUtils.randomString(9).toUpperCase()).replace("%I%", CustomUtils.randomString(11).toUpperCase()).replace("%K%", CustomUtils.RandomNumbers(10)).replace("%X%", CustomUtils.randomAlphaNumeric(5) + "@" + CustomUtils.randomAlphaNumeric(4) + ".com"));
						} else if (customerType.equals(CustomerType.CORPORATE) && cardType.equalsIgnoreCase(ProductType.Credit)) {
							writer.println(getUploadFileFromDatamap("Concatenated Application Record").replace("%B%", INSTITUTION_CODE).replace("%F%", "FORM" + CustomUtils.randomAlphaNumeric(6)).replace("%t%", "1").replace("%q%", deviceType).replace("%P%", program.getProgramCode()).replace("%D%", devicePlan.getDevicePlanCode()).replace("%b%", branchCode).replace("%Z%", Institution.createWithProvider(provider).getCorporateClientCodeCredit()).replace("%N%", CustomUtils.randomString(9).toUpperCase()).replace("%I%", CustomUtils.randomString(11).toUpperCase()).replace("%K%", CustomUtils.RandomNumbers(10)).replace("%X%", CustomUtils.randomAlphaNumeric(5) + "@" + CustomUtils.randomAlphaNumeric(4) + ".com"));
						} else if (customerType.equals(CustomerType.BANKSTAFF)) {
							writer.println(getUploadFileFromDatamap("Concatenated Application Record").replace("%B%", INSTITUTION_CODE).replace("%F%", "FORM" + CustomUtils.randomAlphaNumeric(6)).replace("%t%", "2").replace("%P%", program.getProgramCode()).replace("%q%", deviceType).replace("%D%", devicePlan.getDevicePlanCode()).replace("%b%", branchCode).replace("%Z%", "").replace("%N%", CustomUtils.randomString(9).toUpperCase()).replace("%I%", CustomUtils.randomString(11).toUpperCase()).replace("%K%", CustomUtils.RandomNumbers(10)).replace("%X%", CustomUtils.randomAlphaNumeric(5) + "@" + CustomUtils.randomAlphaNumeric(4) + ".com"));
						}

						totalRecords++;

					}

				}
				writer.print("FT|" + createRecordNumber(9, totalRecords));
			} catch (IOException e) {
				logger.error("Fail to create page object: {}", e);
				throw Throwables.propagate(e);
			}
			logger.info(file.getPath());

			if (cardType.equalsIgnoreCase("credit")) {
				readingAllLinesOfDatFileToRetrieveAttributesForHelpDesk(fileName, cardType);
				context.put(CreditConstants.FILEUPLOAD_IN_BULK, readingAllLinesOfDatFileToRetrieveAttributesForHelpDesk(fileName, cardType));
			}
			linuxBox.upload(file.getPath(), remoteDir);

		//}

		return fileName;
	}

	public String retrieveFieldUploadFile(String FieldName) {
		return filename;
	}

	public Map<String, Object> readingAllLinesOfDatFileToRetrieveAttributesForHelpDesk(String fileName, String cardType) throws IOException {
		List<Integer> indexRequiredToSeachDeviceOnHelpdesk = new LinkedList<Integer>();
		Map<String, Object> mapFileUpload = new HashMap<>();
		if (cardType.equalsIgnoreCase("credit")) {
			indexRequiredToSeachDeviceOnHelpdesk = dataReader.dataProviderFileUploadHelpDesk("AllUploadTestData", "Credit Card File");
			logger.info("Values :{}", indexRequiredToSeachDeviceOnHelpdesk);
		} else if (cardType.equalsIgnoreCase("prepaid")) {
			indexRequiredToSeachDeviceOnHelpdesk = dataReader.dataProviderFileUploadHelpDesk("AllUploadTestData", "Prepaid Card File");
		}
		String formNumber = "";
		String name = "";
		String lastName = "";
		String email = "";
		String mobileNumber = "";
		BufferedReader br = null;
		int counter = 0;
		try {
			br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\" + fileName));
			String contentLine;
			while ((contentLine = br.readLine()) != null) {
				counter++;
				if (counter >= 2 && counter < countLines(fileName)) {
					String lineRead = contentLine;
					String[] lineExcludingDelimiters = lineRead.split("\\|");

					formNumber = lineExcludingDelimiters[indexRequiredToSeachDeviceOnHelpdesk.get(0)];

					name = lineExcludingDelimiters[indexRequiredToSeachDeviceOnHelpdesk.get(1)];

					lastName = lineExcludingDelimiters[indexRequiredToSeachDeviceOnHelpdesk.get(2)];

					mobileNumber = lineExcludingDelimiters[indexRequiredToSeachDeviceOnHelpdesk.get(3)];

					email = lineExcludingDelimiters[indexRequiredToSeachDeviceOnHelpdesk.get(4)];
					HelpDeskGeneral helpDeskGeneral = new HelpDeskGeneral();
					helpDeskGeneral.setFormNumber(formNumber);
					helpDeskGeneral.setFirstName(name);
					helpDeskGeneral.setLastName(lastName);
					helpDeskGeneral.setEmail(email);
					helpDeskGeneral.setMobileNumber(mobileNumber);
					context.put(CreditConstants.HELPDESK_FILEUPLOAD, helpDeskGeneral);
					mapFileUpload.put(CustomUtils.randomAlphaNumeric(8), context.get(CreditConstants.HELPDESK_FILEUPLOAD));
				}

			}
		} catch (IOException e) {
			br.close();
			e.printStackTrace();
		}
		return mapFileUpload;

	}
	
	public int countLines(String fileName) throws IOException {
		LineNumberReader reader = new LineNumberReader(new FileReader(System.getProperty("user.dir") + "\\" + fileName));
		int countNumberOfLinesInDatFile = 0;
		String lineRead = "";
		while ((lineRead = reader.readLine()) != null) {
		}

		countNumberOfLinesInDatFile = reader.getLineNumber();
		reader.close();
		return countNumberOfLinesInDatFile;
	}
}
