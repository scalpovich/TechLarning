package com.mastercard.pts.integrated.issuing.domain.customer.transaction;

import java.util.LinkedHashMap;
import java.util.Map;

import com.mastercard.pts.integrated.issuing.configuration.FinSimSimulator;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

public class Transaction {

	private static final String TRANSACTION_AMOUNT = "TRANSACTION_AMOUNT";

	private static final String CURRENCY_USED = "CURRENCY";

	private static final String FINSIM_VALIDATION_DATA_START = "FINSIM_VALIDATION_DATA_START";

	private static final String FINSIM_CARD_LENGTH = "FINSIM_CARD_LENGTH";

	private static final String FINSIM_PAD = "FINSIM_PAD";

	private static final String FINSIM_PIN_LENGHT = "FINSIM_PIN_LENGHT";

	private Map<String, String> deKeyValuePair = new LinkedHashMap<>();

	private Map<String, String> expectedDataElements = new LinkedHashMap<>();

	//CardProfileDetails 
	private String cardNumber; 

	private String transactionAmount; 

	private String expirationYear; 

	private String cardSequenceNumber;

	private String pinForTransaction;

	private String cvvData;
	
	private String cvvData2;

	private Map<String, String> cardDataElements = new LinkedHashMap<>();
	
	private Map <String, String> cardDataElementsUpdatedATC = new LinkedHashMap<>();

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

	private String testCase;

	private String cardProfile;

	private String issuerCountryCode;

	private String issuerCurrencyCode;

	private String cardHolderBillingCurrency;
	
	private String serviceCode;

	public String getIssuerCurrencyCode() {
		return issuerCurrencyCode;
	}

	public void setIssuerCurrencyCode(String issuerCurrencyCode) {
		this.issuerCurrencyCode = issuerCurrencyCode;
	}

	public String getCardHolderBillingCurrency() {
		return cardHolderBillingCurrency;
	}

	public void setCardHolderBillingCurrency(String cardHolderBillingCurrency) {
		this.cardHolderBillingCurrency = cardHolderBillingCurrency;
	}

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

	public static Transaction generateFinSimPinTestData(Device device, FinSimSimulator finSimConfig, KeyValueProvider provider) {
		Transaction transactionData  = new Transaction();
		transactionData.setCardNumber(device.getDeviceNumber());
		transactionData.setPinKey(finSimConfig.getPinKey());
		transactionData.setDecimalisationTable(finSimConfig.getDecimalizationValue());
		transactionData.setValidationDataStart(provider.getString(FINSIM_VALIDATION_DATA_START));
		transactionData.setCardLength(provider.getString(FINSIM_CARD_LENGTH));
		transactionData.setPad(provider.getString(FINSIM_PAD));
		transactionData.setOffSetForCard((device.getPinOffset().substring(1, 5)));
		transactionData.setPinLength(provider.getString(FINSIM_PIN_LENGHT));

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
	public void setDeKeyValuePairDynamic(String s1, String s2) {
		deKeyValuePair.put(s1, s2);
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
	
	public Map<String, String> getCardDataElemetsUpdatedATC(){
		return cardDataElementsUpdatedATC;
	}
	
	public void setCardDataElementsUpdatedATC(Map<String, String> cardDataElementsUpdatedATC) {
		this.cardDataElementsUpdatedATC = cardDataElementsUpdatedATC;
	}

	public void setCardDataElementsDynamic(String s1, String s2) {
		cardDataElements.put(s1, s2);
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

	public String getTestCase() {
		return testCase;
	}

	public void setTestCase(String testCase) {
		this.testCase = testCase;
	}

	public String getCardProfile() {
		return cardProfile;
	}

	public void setCardProfile(String cardProfile) {
		this.cardProfile = cardProfile;
	}

	public String getIssuerCountryCode() {
		return issuerCountryCode;
	}

	public void setIssuerCountryCode(String issuerCountryCode) {
		this.issuerCountryCode = issuerCountryCode;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getCvvData2() {
		return cvvData2;
	}

	public void setCvvData2(String cvvData2) {
		this.cvvData2 = cvvData2;
	}
}
