package com.mastercard.pts.integrated.issuing.domain.customer.transaction;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import com.mastercard.pts.integrated.issuing.configuration.FinSimSimulator;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class Transaction {

	private static final String TRANSACTION_AMOUNT = "TRANSACTION_AMOUNT";

	private static final String CURRENCY_USED = "CURRENCY";

	private Map<String, String> deKeyValuePair = new LinkedHashMap<>();
	
	private Map<String, String> expectedDataElements = new LinkedHashMap<>();

	//CardProfileDetails 
	private String cardNumber; 

	private String transactionAmount; 

	private String expirationYear; 

	private String cardSequenceNumber;

	private String pinForTransaction;

	private String cvvData;
	
	private Map<String, String> cardDataElements = new LinkedHashMap<>();

	//TestCasesAndCardAndDataElementsData
	private String testCaseToSelect; 

	private String cardForTransaction; 

	private String pinKey;

	private String decimalisationTable;

	private String validationDataStart;

	private String cardLength;

	private String pad;

	private String pinLength;

	private String currency;

	private String offSetForCard;
	
	private String merchantProfile;
	
	private String transactionProfile;

	public String getOffSetForCard() {
		return offSetForCard;
	}

	public void setOffSetForCard(String offSetForCard) {
		this.offSetForCard = offSetForCard;
	}

	public static Transaction createWithProviderAndGenerateTestData(Device device, KeyValueProvider provider) {
		Transaction transactionData  = new Transaction();
		transactionData.setTransactionAmount(provider.getString(TRANSACTION_AMOUNT));
		transactionData.setCurrency(provider.getString(CURRENCY_USED).replaceAll("\\D+","")); // getting numbers only
		if(device.getPinNumberForTransaction() == null)
		{
			device.setPinNumberForTransaction("BLANK");
		}
		transactionData.setPinForTransaction(device.getPinNumberForTransaction()); // PIN is coming from FINSIM
		transactionData.setCardNumber(device.getDeviceNumber());
		transactionData.setCardSequenceNumber(device.getSequenceNumber());
		transactionData.setCvvData(device.getCvvData());
		transactionData.setExpirationYear(device.getExpirationDate());
		return transactionData;
	}

	public static Transaction generateFinSimPinTestData(Device device, FinSimSimulator finSimConfig) {
		Transaction transactionData  = new Transaction();
		//data come from PIN Offset file generated
		transactionData.setCardNumber(device.getDeviceNumber());
		transactionData.setPinKey(finSimConfig.getPinKey());
		transactionData.setDecimalisationTable(finSimConfig.getDecimalizationValue());
		transactionData.setValidationDataStart("4");
		transactionData.setCardLength("12");
		transactionData.setPad("F");
		transactionData.setOffSetForCard(MiscUtils.convertToYYMM(device.getPinOffset().substring(1, 4)));
		transactionData.setPinLength("4");
		return transactionData;
	}

	public static Transaction fetchDataForFinSim(FinSimSimulator finSimConfig) {
		Transaction transactionData  = new Transaction();
		//data come from PIN Offset file generated
		transactionData.setCardNumber("5877657327160814");
		transactionData.setPinKey(finSimConfig.getPinKey());
		transactionData.setDecimalisationTable(finSimConfig.getDecimalizationValue());
		transactionData.setValidationDataStart("4");
		transactionData.setCardLength("12");
		transactionData.setPad("F");
		transactionData.setOffSetForCard("2162");
		transactionData.setPinLength("4");
		return transactionData;
	}

	public static Transaction createWithProviderAndGenerateTestData() {
		Transaction transactionData  = new Transaction();
		transactionData.setTransactionAmount("1000");
		transactionData.setCurrency("356"); // getting numbers only
		transactionData.setPinForTransaction("7224"); // PIN is coming from FINSIM //7224 // MSR CARD
//		transactionData.setPinForTransaction(""); // PIN is coming from FINSIM //7224 // EMV CARD
		transactionData.setCardNumber("5877657327160814"); // MSR CARD
//		transactionData.setCardNumber("2222550010000018"); // EMV CARD
		transactionData.setCardSequenceNumber("456");
		transactionData.setCvvData("");
//		transactionData.setExpirationYear("1117"); // EMV 
		transactionData.setExpirationYear("1217"); // MSR
		return transactionData;
	}

	public String getPinKey() {
		return pinKey;
	}

	public void setPinKey(String pinKey) {
		this.pinKey = pinKey;
	}

	public String getDecimalisationTable() {
		return decimalisationTable;
	}

	public void setDecimalisationTable(String decimalisationTable) {
		this.decimalisationTable = decimalisationTable;
	}

	public String getValidationDataStart() {
		return validationDataStart;
	}

	public void setValidationDataStart(String validationDataStart) {
		this.validationDataStart = validationDataStart;
	}

	public String getCardLength() {
		return cardLength;
	}

	public void setCardLength(String cardLength) {
		this.cardLength = cardLength;
	}

	public String getPad() {
		return pad;
	}

	public void setPad(String pad) {
		this.pad = pad;
	}

	public String getPinLength() {
		return pinLength;
	}

	public void setPinLength(String pinLength) {
		this.pinLength = pinLength;
	}

	public Map<String, String> setDataElementValues(String [] deElements) {
		LinkedHashMap<String, String> dataElementData = new LinkedHashMap<>();

		for(int i = 0; i < deElements.length; i++)
		{
			String [] temp = null;
			try
			{
				 temp = deElements[i].split("=");
			}
			catch(NullPointerException e)
			{
				temp[1] = "BLANK";
			}
			
			dataElementData.put(temp[0], getValues(temp[0], temp[1]));
		}
		return dataElementData;
	}

	private String getValues(String temp0, String temp1) {
		String output = null;
		switch (temp0) {
		case "DE4":
			output= StringUtils.leftPad(temp1, 12, "0"); 
			break;
		case "DE37":
			output = getDataElement37Value(temp1);
			break;
		default:
			output = temp1;
			break;
		}
		return output;
	}

	private String  getDataElement37Value(String temp) {
		if( temp.contains("generateRandomNumber"))
		{
			return RandomStringUtils.randomNumeric(12);
		}
		else
		{
			return StringUtils.leftPad(temp, 12, "0"); 
		}
	}

	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getExpirationYear() {
		return expirationYear;
	}
	public void setExpirationYear(String expirationYear) {
		this.expirationYear = expirationYear;
	}
	public String getCardSequenceNumber() {
		return cardSequenceNumber;
	}
	public void setCardSequenceNumber(String cardSequenceNumber) {
		this.cardSequenceNumber = cardSequenceNumber;
	}
	public String getPinForTransaction() {
		return pinForTransaction;
	}
	public void setPinForTransaction(String pinData) {
		this.pinForTransaction = pinData;
	}
	public String getCvvData() {
		return cvvData;
	}
	public void setCvvData(String cvvData) {
		this.cvvData = cvvData;
	}

	public String getTestCaseToSelect() {
		return testCaseToSelect;
	}
	public void setTestCaseToSelect(String testCaseToSelect) {
		this.testCaseToSelect = testCaseToSelect;
	}
	public String getCardForTransaction() {
		return cardForTransaction;
	}
	public void setCardForTransaction(String cardForTransaction) {
		this.cardForTransaction = cardForTransaction;
	}
	public Map<String, String> getDeKeyValuePair() {
		return deKeyValuePair;
	}
	public void setDeKeyValuePair(Map<String, String> deKeyValuePair) {
		this.deKeyValuePair = deKeyValuePair;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Map<String, String> getExpectedDataElements() {
		return expectedDataElements;
	}

	public void setExpectedDataElements(Map<String, String> expectedDataElements) {
		this.expectedDataElements = expectedDataElements;
	}

	public Map<String, String> getCardDataElements() {
		return cardDataElements;
	}

	public void setCardDataElements(Map<String, String> cardDataElements) {
		this.cardDataElements = cardDataElements;
	}

	public String getMerchantProfile() {
		return merchantProfile;
	}

	public void setMerchantProfile(String merchantProfile) {
		this.merchantProfile = merchantProfile;
	}

	public String getTransactionProfile() {
		return transactionProfile;
	}

	public void setTransactionProfile(String transactionProfile) {
		this.transactionProfile = transactionProfile;
	}

}
