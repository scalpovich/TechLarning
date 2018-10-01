package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
@Component
public class Device {

	private static final String BRANCH = "BRANCH";
	private static final String APPLICATION_TYPE = "APPLICATION_TYPE";
	private static final String SUB_APPLICATION_TYPE = "SUB_APPLICATION_TYPE";
	private static final String CREATE_OPEN_BATCH = "CREATE_OPEN_BATCH";
	private static final String DEVICE_CUSTOMER_TYPE = "DEVICE_CUSTOMER_TYPE";
	private static final String DEVICE_TYPE = "DEVICE_TYPE";
	private static final String ACCOUNT_TYPE = "ACCOUNT_TYPE";
	private static final String TRANSACTION_AMOUNT = "TRANSACTION_AMOUNT";
	private static final String CORPORATE_CLIENT_CODE = "CORPORATE_CLIENT_CODE";
	private static final String ND_OTHERINFO_PREFERRED_LANGUAGE	 = 	"ND_OTHERINFO_PREFERRED_LANGUAGE";
	private static final String ND_OTHERINFO_STATEMENT_PREFERENCE	 = 	"ND_OTHERINFO_STATEMENT_PREFERENCE";
	private static final String ND_OTHERINFO_EMAIL_ALERT_REQUIRED	 = 	"ND_OTHERINFO_EMAIL_ALERT_REQUIRED";
	private static final String ND_OTHERINFO_SMS_ALERT_REQUIRED	 = 	"ND_OTHERINFO_SMS_ALERT_REQUIRED";
	private static final String ND_OTHERINFO_REGISTERED_EMAIL_ADDRESS	 = 	"ND_OTHERINFO_REGISTERED_EMAIL_ADDRESS";
	private static final String ND_OTHERINFO_FAX_NO	 = 	"ND_OTHERINFO_FAX_NO";
	private static final String ND_OTHERINFO_REGISTERED_MOBILE_NUMBER	 = 	"ND_OTHERINFO_REGISTERED_MOBILE_NUMBER";
	private static final String ND_OTHERINFO_REGISTER_FOR_DCNR	 = 	"ND_OTHERINFO_REGISTER_FOR_DCNR";
	private static final String ND_OTHERINFO_DELIVERY_MODE	 = 	"ND_OTHERINFO_DELIVERY_MODE";
	private static final String ND_VIP	 = 	"ND_VIP";
	private static final String ND_MIDDLE_NAME_2 = "ND_MIDDLE_NAME_2";
	private static final String ND_ENCODED_NAME = "ND_ENCODED_NAME";
	private static final String CHP_NEW_PASSWORD = "CHP_NEW_PASSWORD";
	private static final String PRODUCT_TYPE = "PRODUCT_TYPE";
	private static final String DATE_TYPE = "DATE_TYPE";
	private static final String PROGRAM_CODE = "PROGRAM_CODE";
	private static final String DEVICE_PLAN= "DEVICE_PLAN"; 
	private static final String IS_TRANSACTION_PINLESS = "IS_TRANSACTION_PINLESS";
	private static final String SERVICE_CODE = "SERVICE_CODE";
	private static final String VALIDITY_ON_INITIAL_MONTHS = "VALIDITY_ON_INITIAL_MONTHS";
	private static final String EXPIRY_FLAG = "EXPIRY_FLAG";
	private static final String CREDIT_LIMIT = "CREDIT_LIMIT";
	private static final String TRANSACTION_PASSWORD = "TRANSACTION_PASSWORD";
	private static final String CURRENCY_OF_TRANSFER = "CURRENCY_OF_TRANSFER";
	
	private String currencyofTransfer;
	private String currentTransPassword;
	private String newTransPassword;
	private String confirmNewTransPassword;
	private String transactionPassword;
	private String corporateClientCode;
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
	private String walletNumber2;
	private String newWalletNumber;
	private String deviceNumber;
	private String existingDeviceNumber;
	private String photoIndicator;
	private String batchNumber;
	private String partnerMembershipNumber;
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
	private String otherInfoPreferredLanguage;
	private String otherInfoStatementPreference;
	private String otherInfoEmailAlertRequired;
	private String otherInfoSmsAlertRequired;
	private String otherInfoRegisteredEmailAddress;
	private String otherInfoFaxNo;
	private String otherInfoRegisteredMobileNumber;
	private String otherInfoRegisterForDncr;
	private String otherInfoDeliveryMode;
	private String vip;
	private String encodedName;
	private String middleName2;
	private String serviceCode;
	private String productType;
	private String transactionDateType;
	private String applicationNumber;
	private String isTransactionPinless;
	private String expiryFlag;	
	private String creditLimit;
  	private String legalID;
  	private String walletCurrency;


	public  static Device createWithProvider(KeyValueProvider provider) {
		Device device = new Device();
		device.setApplicationType(provider.getString(APPLICATION_TYPE));
		device.setCorporateClientCode(provider.getString(CORPORATE_CLIENT_CODE));
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
		device.setVip(provider.getString(ND_VIP));
		device.setMiddleName2(provider.getString(ND_MIDDLE_NAME_2));
		device.setEncodedName(provider.getString(ND_ENCODED_NAME));
		device.setOtherInfoStatementPreference(provider.getString(ND_OTHERINFO_STATEMENT_PREFERENCE));
		device.setOtherInfoFaxNo(provider.getString(ND_OTHERINFO_FAX_NO));
		device.setNewTransPassword(provider.getString(CHP_NEW_PASSWORD));
		device.setConfirmNewTransPassword(provider.getString(CHP_NEW_PASSWORD));	
		device.setProductType(provider.getString(PRODUCT_TYPE));
		device.setTransactionDateType(provider.getString(DATE_TYPE));
      	device.setLegalID(RandomStringUtils.randomAlphanumeric(9));	
		device.setProgramCode(provider.getString(PROGRAM_CODE));
		device.setDevicePlan1(provider.getString(DEVICE_PLAN));     
		device.setTransactionPassword(provider.getString(TRANSACTION_PASSWORD));		
		device.setCurrencyofTransfer(provider.getString(CURRENCY_OF_TRANSFER));
		return device;
	}
	
	public  static Device createWithProviderDataDriven(KeyValueProvider provider) {
		Device device = Device.createWithProvider(provider);		
		device.setProgramCode(provider.getString(PROGRAM_CODE));
		device.setDevicePlan1(provider.getString(DEVICE_PLAN));
		device.setIsPinRequired(provider.getString(IS_TRANSACTION_PINLESS));	
		device.setServiceCode(provider.getString(SERVICE_CODE));
		device.setExpirationDate(provider.getString(VALIDITY_ON_INITIAL_MONTHS));
		device.setExpiryFlag(provider.getString(EXPIRY_FLAG));
		device.setCreditLimit(provider.getString(CREDIT_LIMIT));
		return device;
	}
	
	public  static Device createWithProviderForOtherDetails(KeyValueProvider provider) {
		Device device = Device.createWithProvider(provider);
		device.setOtherInfoDeliveryMode(provider.getString(ND_OTHERINFO_DELIVERY_MODE));
		device.setOtherInfoEmailAlertRequired(provider.getString(ND_OTHERINFO_EMAIL_ALERT_REQUIRED));
		device.setOtherInfoPreferredLanguage(provider.getString(ND_OTHERINFO_PREFERRED_LANGUAGE));
		device.setOtherInfoRegisteredEmailAddress(provider.getString(ND_OTHERINFO_REGISTERED_EMAIL_ADDRESS));
		device.setOtherInfoRegisteredMobileNumber(provider.getString(ND_OTHERINFO_REGISTERED_MOBILE_NUMBER));
		device.setOtherInfoRegisterForDncr(provider.getString(ND_OTHERINFO_REGISTER_FOR_DCNR));
		device.setOtherInfoSmsAlertRequired(provider.getString(ND_OTHERINFO_SMS_ALERT_REQUIRED));
		device.setOtherInfoStatementPreference(provider.getString(ND_OTHERINFO_STATEMENT_PREFERENCE));
		return device;
	}

	public String getWalletCurrency() {
		return walletCurrency;
	}

	public void setWalletCurrency(String walletCurrency) {
		this.walletCurrency = walletCurrency;
	}
	
	public String getCurrencyofTransfer() {
		return currencyofTransfer;
	}

	public void setCurrencyofTransfer(String currencyofTransfer) {
		this.currencyofTransfer = currencyofTransfer;
	}

	public String getExistingDeviceNumber() {
		return existingDeviceNumber;
	}

	public void setExistingDeviceNumber(String existingDeviceNumber) {
		this.existingDeviceNumber = existingDeviceNumber;
	}

	public String getEncodedName() {
		return encodedName;
	}

	public void setEncodedName(String encodedName) {
		this.encodedName = encodedName;
	}
	
	public String getExpiryFlag() {
		return expiryFlag;
	}

	public void setExpiryFlag(String expiryFlag) {
		this.expiryFlag = expiryFlag;
	}

	public static String getNdOtherinfoStatementPreference() {
		return ND_OTHERINFO_STATEMENT_PREFERENCE;
	}
	
	public String getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(String creditLimit) {
		this.creditLimit = creditLimit;
	}
	
	public String getIsPinRequired() {
		return isTransactionPinless;
	}

	public void setIsPinRequired(String isTransactionPinless) {
		this.isTransactionPinless = isTransactionPinless;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	public String getCurrentTransPassword() {
		return currentTransPassword;
	}

	public void setCurrentTransPassword(String currentTransPassword) {
		this.currentTransPassword = currentTransPassword;
	}

	public String getNewTransPassword() {
		return newTransPassword;
	}

	public void setNewTransPassword(String newTransPassword) {
		this.newTransPassword = newTransPassword;
	}
	
	public String getConfirmNewTransPassword() {
		return confirmNewTransPassword;
	}

	public void setConfirmNewTransPassword(String confirmNewTransPassword) {
		this.confirmNewTransPassword = confirmNewTransPassword;
	}
	
	public static String getNdOtherinfoFaxNo() {
		return ND_OTHERINFO_FAX_NO;
	}

	public String getMiddleName2() {
		return middleName2;
	}

	public void setMiddleName2(String middleName2) {
		this.middleName2 = middleName2;
	}

	public String getOtherInfoPreferredLanguage() {
		return otherInfoPreferredLanguage;
	}

	public void setOtherInfoPreferredLanguage(String otherInfoPreferredLanguage) {
		this.otherInfoPreferredLanguage = otherInfoPreferredLanguage;
	}

	public String getOtherInfoStatementPreference() {
		return otherInfoStatementPreference;
	}

	public void setOtherInfoStatementPreference(String otherInfoStatementPreference) {
		this.otherInfoStatementPreference = otherInfoStatementPreference;
	}

	public String getOtherInfoEmailAlertRequired() {
		return otherInfoEmailAlertRequired;
	}

	public void setOtherInfoEmailAlertRequired(String otherInfoEmailAlertRequired) {
		this.otherInfoEmailAlertRequired = otherInfoEmailAlertRequired;
	}

	public String getOtherInfoSmsAlertRequired() {
		return otherInfoSmsAlertRequired;
	}

	public void setOtherInfoSmsAlertRequired(String otherInfoSmsAlertRequired) {
		this.otherInfoSmsAlertRequired = otherInfoSmsAlertRequired;
	}

	public String getOtherInfoRegisteredEmailAddress() {
		return otherInfoRegisteredEmailAddress;
	}

	public void setOtherInfoRegisteredEmailAddress(
			String otherInfoRegisteredEmailAddress) {
		this.otherInfoRegisteredEmailAddress = otherInfoRegisteredEmailAddress;
	}

	public String getOtherInfoFaxNo() {
		return otherInfoFaxNo;
	}

	public void setOtherInfoFaxNo(String otherInfoFaxNo) {
		this.otherInfoFaxNo = otherInfoFaxNo;
	}

	public String getOtherInfoRegisteredMobileNumber() {
		return otherInfoRegisteredMobileNumber;
	}

	public void setOtherInfoRegisteredMobileNumber(
			String otherInfoRegisteredMobileNumber) {
		this.otherInfoRegisteredMobileNumber = otherInfoRegisteredMobileNumber;
	}

	public String getOtherInfoRegisterForDncr() {
		return otherInfoRegisterForDncr;
	}

	public void setOtherInfoRegisterForDncr(String otherInfoRegisterForDncr) {
		this.otherInfoRegisterForDncr = otherInfoRegisterForDncr;
	}

	public String getOtherInfoDeliveryMode() {
		return otherInfoDeliveryMode;
	}

	public void setOtherInfoDeliveryMode(String otherInfoDeliveryMode) {
		this.otherInfoDeliveryMode = otherInfoDeliveryMode;
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
	
	public String getNewWalletNumber() {
		return newWalletNumber;
	}

	public void setNewWalletNumber(String newWalletNumber) {
		this.newWalletNumber = newWalletNumber;
	}
	
	public void setWalletNumber(String walletNumber) {
		this.walletNumber = walletNumber;
	}

	public String getWalletNumber2() {
		return walletNumber2;
	}

	public void setWalletNumber2(String walletNumber2) {
		this.walletNumber2 = walletNumber2;
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

	public String getPartnerMembershipNumber() {
		return partnerMembershipNumber;
	}

	public void setPartnerMembershipNumber(String partnerMembershipNumber) {
		this.partnerMembershipNumber = partnerMembershipNumber;
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
	public String getCorporateClientCode() {
		return corporateClientCode;
	}

	public void setCorporateClientCode(String corporateClientCode) {
		this.corporateClientCode = corporateClientCode;
	}

	public String getVip() {
		return vip;
	}
	
	public void setVip(String vip) {
		this.vip = vip;
	}
	
	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getTransactionDateType() {
		return transactionDateType;
	}

	public void setTransactionDateType(String transactionDateType) {
		this.transactionDateType = transactionDateType;
	}
	
    public String getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}
  	
  	public String getLegalID() {
		return legalID;
	}

	public void setLegalID(String legalID) {
		this.legalID = legalID;
	}
	
	public String getTransactionPassword() {
		return transactionPassword;
	}

	public void setTransactionPassword(String transactionPassword) {
		this.transactionPassword = transactionPassword;
	}
}