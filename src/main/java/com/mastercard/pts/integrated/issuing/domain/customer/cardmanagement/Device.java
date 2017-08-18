package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

public class Device {

	private static final String BRANCH = "BRANCH";

	private static final String APPLICATION_TYPE = "APPLICATION_TYPE";

	private static final String SUB_APPLICATION_TYPE = "SUB_APPLICATION_TYPE";

	private static final String CREATE_OPEN_BATCH = "CREATE_OPEN_BATCH";

	private static final String DEVICE_CUSTOMER_TYPE = "DEVICE_CUSTOMER_TYPE";

	private static final String DEVICE_TYPE = "DEVICE_TYPE";
	
	private static final String ACCOUNT_TYPE = "ACCOUNT_TYPE";
	
	private static final String TRANSACTION_AMOUNT = "TRANSACTION_AMOUNT";
	
	private String appliedForProduct;
	
	private String applicationType;
	
	private String subApplicationType;
	
	private String createOpenBatch;
	
	private String customerType;
	
	private String programCode;
	
	private String deviceType1;
	
	private String devicePlan1;
	
	private String branchCode;
	
	private String accountNumber;
	
	private String accountType;
	
	private ClientDetails clientDetails;
	
	private Address currentAddress;
	
	private String clientCode;
	
	private String walletNumber;
	
	private String deviceNumber;
	
	private String photoIndicator;
	
	private String batchNumber;
	
	private String sequenceNumber;
	
	private String cvvData;
	
	private String expirationYear;
	
	private String transactionAmount;
	
	private String expirationDate;
	
	private String pvvData;
	
	private String cvv2Data;
	
	private String icvvData;

	private String pvkiData;
	
	private String pinOffset;
	
	private String pinNumberForTransaction;
	
	private String currency;

	public  static Device createWithProvider(KeyValueProvider provider) {
		Device device = new Device();
		device.setApplicationType(provider.getString(APPLICATION_TYPE));
		device.setSubApplicationType(provider.getString(SUB_APPLICATION_TYPE));
		device.setCreateOpenBatch(provider.getString(CREATE_OPEN_BATCH));
		device.setCustomerType(provider.getString(DEVICE_CUSTOMER_TYPE));
		device.setDeviceType1(provider.getString(DEVICE_TYPE));
		device.setClientDetails(ClientDetails.generateClient());
		device.setCurrentAddress(Address.generateAddress());
		device.setBranchCode(provider.getString(BRANCH));
		device.setAccountNumber(RandomStringUtils.randomNumeric(16));
		device.setAccountType(provider.getString(ACCOUNT_TYPE));
		device.setPhotoIndicator("Normal [0]");
		device.setTransactionAmount(provider.getString(TRANSACTION_AMOUNT));
		return device;
	}


	public String getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getPinOffset() {
		return pinOffset;
	}

	public void setPinOffset(String pinOffset) {
		this.pinOffset = pinOffset;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getPvvData() {
		return pvvData;
	}

	public void setPvvData(String pvvData) {
		this.pvvData = pvvData;
	}

	public String getCvv2Data() {
		return cvv2Data;
	}

	public void setCvv2Data(String cvv2Data) {
		this.cvv2Data = cvv2Data;
	}

	public String getIcvvData() {
		return icvvData;
	}

	public void setIcvvData(String icvvData) {
		this.icvvData = icvvData;
	}

	public String getPvkiData() {
		return pvkiData;
	}

	public void setPvkiData(String pvkiData) {
		this.pvkiData = pvkiData;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getWalletNumber() {
		return walletNumber;
	}

	public void setWalletNumber(String walletNumber) {
		this.walletNumber = walletNumber;
	}

	public String getDeviceNumber() {
		return deviceNumber;
	}

	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public ClientDetails getClientDetails() {
		return clientDetails;
	}

	public void setClientDetails(ClientDetails clientDetails) {
		this.clientDetails = clientDetails;
	}

	public Address getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(Address currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getAppliedForProduct() {
		return appliedForProduct;
	}

	public void setAppliedForProduct(String appliedForProduct) {
		this.appliedForProduct = appliedForProduct;
	}

	public String getApplicationType() {
		return applicationType;
	}

	public void setApplicationType(String applicationType) {
		this.applicationType = applicationType;
	}

	public String getSubApplicationType() {
		return subApplicationType;
	}

	public void setSubApplicationType(String subApplicationType) {
		this.subApplicationType = subApplicationType;
	}

	public String getCreateOpenBatch() {
		return createOpenBatch;
	}

	public void setCreateOpenBatch(String createOpenBatch) {
		this.createOpenBatch = createOpenBatch;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getProgramCode() {
		return programCode;
	}

	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}

	public String getDeviceType1() {
		return deviceType1;
	}

	public void setDeviceType1(String deviceType1) {
		this.deviceType1 = deviceType1;
	}

	public String getDevicePlan1() {
		return devicePlan1;
	}

	public void setDevicePlan1(String devicePlan1) {
		this.devicePlan1 = devicePlan1;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	public String getPhotoIndicator() {
		return photoIndicator;
	}

	public void setPhotoIndicator(String photoIndicator) {
		this.photoIndicator = photoIndicator;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public String getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getCvvData() {
		return cvvData;
	}

	public void setCvvData(String cvvData) {
		this.cvvData = cvvData;
	}

	public String getExpirationYear() {
		return expirationYear;
	}

	public void setExpirationYear(String expirationYear) {
		this.expirationYear = expirationYear;
	}


	public String getPinNumberForTransaction() {
		return pinNumberForTransaction;
	}


	public void setPinNumberForTransaction(String pinNumberForTransaction) {
		this.pinNumberForTransaction = pinNumberForTransaction;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
