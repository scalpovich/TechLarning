/**
 * @author e076168
 */
package com.mastercard.pts.integrated.issuing.domain.cardholder;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class CardHolderTransactions {
	
	
	private static final String CARD_NUMBER = "CARD_NUMBER" ;
	private static final String TRANSFER_AMOUNT = "TRANSFER_AMOUNT";
	private static final String CURRENCY_NAME = "CURRANCY_NAME";
	private static final String CONTACT_NUMBER = "CONTACT_NUMBER";
	private static final String TRANSFER_NAME = "TRANSFER_NAME";
	private static final String TRANSFER_MEMO = "TRANSFER_MEMO";
	private static final String TRANSACTION_PASSWORD = "TRANSACTION_PASSWORD";
	private static final String TRANSACTION_REMARK = "TRANSACTION_REMARK";
	private static final String WALLET_TRANSFER_AMOUNT = "WALLET_TRANSFER_AMOUNNT";
	private static final String WALLET_TRANSFER_CURRENCY  = "WALEET_TRANSFER_CURRANCY";
	private static final String WALLET_NUM_FROM_AMOUNT_TRANSFER = "WALLET_NUM_FROM_AMOUNT_TRANSFER";
	private static final String TRANSACTION_STATUS_FAIL_MESSAGE = "TRANSACTION_STATUS_FAIL_MESSAGE";
	private static final String WALLET_TO_WALLET_TRANS_CUCCESS_MSG = "WALLET_TO_WALLET_TRANS_CUCESSMSG";
	
	//Cash Remittance booking
	private static final String BENEFICIARY_ID = "BENEFICIARY_ID";
	private static final String BENEFICIARY_FIRST_NAME = "BENEFICIARY_FIRSTNAME";
	private static final String BENEFICIARY_MIDDLE_NAME = "BENEFICIARY_MIDDLENAME";
	private static final String BENEFICIARY_LAST_NAME = "BENEFICIARY_LASTNAME";
	private static final String BENEFICIARY_ADDRESS_LINE1 = "BENEFICIARY_ADDRESSLINE1";
	private static final String BENEFICIARY_ADDRESS_LINE2 = "BENEFICIARY_ADDRESSLINE2";
	private static final String BENEFICIARY_ADDRESS_LINE3 = "BENEFICIARY_ADDRESSLINE3";
	private static final String BENEFICIARY_COUNTRY_NAME = "BENEFICIARY_COUNTRYNAME";	
	private static final String BENEFICIARY_STATE_NAME = "BENEFICIARY_STATENAME";
	private static final String BENEFICIARY_CITY_NAME = "BENEFICIARY_CITYNAME";
	private static final String BENEFICIARY_ZIP_CODE = "BENEFICIARY_ZIPCODE";
	private static final String BENEFICIARY_EMAIL_ADDRESS = "BENEFICIARY_EMAILADDRESS";
	private static final String BENEFICIARY_MOBILE_NUMBER = "BENEFICIARY_MOBILENUMBER";
	private static final String BENEFICIARY_REMITTANCE_AMOUNT = "BENEFICIARY_REMITTANCE_AMOUNT";
	private static final String BENEFICIARY_REMITTANCE_CURRENCY = "BENEFICIARY_REMITTANCE_CURRENCY";
	
	
	private String CardNumber;
	private String TransferAmount;
	private String CurrencyName;
	private String ContactNumber;
	private String TransferName;
	private String TransferMemo;
	private String TransctionPassword;
	private String transactionRemark;
	private String walletTransferAmount;
	private String walletTransferCurrency;
	private String walletNumFromAmountTransfer;
	private String transactionStatusFailMessage;
	private String walletToWalletTransSucessMsg;
	
	//Cash Remittance booking
	private String beneficiaryID;
	private String beneficiaryFirstName;
	private String beneficiaryMiddleName;
	private String beneficiaryLastName;
	private String beneficiaryAddressLine1;
	private String beneficiaryAddressLine2;
	private String beneficiaryAddressLine3;
	private String beneficiaryCountryName;
	private String beneficiaryStateName;
	private String beneficiaryCityName;
	private String beneficiaryZIPCode;
	private String beneficiaryEmailAddress;
	private String beneficiaryMobileNumber;
	private String beneficiaryRemittanceAmount;
	private String beneficiaryRemittanceCurrency;
	
		
	public String getBeneficiaryID() {
		return beneficiaryID;
	}
	public void setBeneficiaryID(String beneficiaryID) {
		this.beneficiaryID = beneficiaryID;
	}
	public String getBeneficiaryFirstName() {
		return beneficiaryFirstName;
	}
	public void setBeneficiaryFirstName(String beneficiaryFirstName) {
		this.beneficiaryFirstName = beneficiaryFirstName;
	}
	public String getBeneficiaryMiddleName() {
		return beneficiaryMiddleName;
	}
	public void setBeneficiaryMiddleName(String beneficiaryMiddleName) {
		this.beneficiaryMiddleName = beneficiaryMiddleName;
	}
	public String getBeneficiaryLastName() {
		return beneficiaryLastName;
	}
	public void setBeneficiaryLastName(String beneficiaryLastName) {
		this.beneficiaryLastName = beneficiaryLastName;
	}
	public String getBeneficiaryAddressLine1() {
		return beneficiaryAddressLine1;
	}
	public void setBeneficiaryAddressLine1(String beneficiaryAddressLine1) {
		this.beneficiaryAddressLine1 = beneficiaryAddressLine1;
	}
	public String getBeneficiaryAddressLine2() {
		return beneficiaryAddressLine2;
	}
	public void setBeneficiaryAddressLine2(String beneficiaryAddressLine2) {
		this.beneficiaryAddressLine2 = beneficiaryAddressLine2;
	}
	public String getBeneficiaryAddressLine3() {
		return beneficiaryAddressLine3;
	}
	public void setBeneficiaryAddressLine3(String beneficiaryAddressLine3) {
		this.beneficiaryAddressLine3 = beneficiaryAddressLine3;
	}
	public String getBeneficiaryCountryName() {
		return beneficiaryCountryName;
	}
	public void setBeneficiaryCountryName(String beneficiaryCountryName) {
		this.beneficiaryCountryName = beneficiaryCountryName;
	}
	public String getBeneficiaryStateName() {
		return beneficiaryStateName;
	}
	public void setBeneficiaryStateName(String beneficiaryStateName) {
		this.beneficiaryStateName = beneficiaryStateName;
	}
	public String getBeneficiaryCityName() {
		return beneficiaryCityName;
	}
	public void setBeneficiaryCityName(String beneficiaryCityName) {
		this.beneficiaryCityName = beneficiaryCityName;
	}
	public String getBeneficiaryZIPCode() {
		return beneficiaryZIPCode;
	}
	public void setBeneficiaryZIPCode(String beneficiaryZIPCode) {
		this.beneficiaryZIPCode = beneficiaryZIPCode;
	}
	public String getBeneficiaryEmailAddress() {
		return beneficiaryEmailAddress;
	}
	public void setBeneficiaryEmailAddress(String beneficiaryEmailAddress) {
		this.beneficiaryEmailAddress = beneficiaryEmailAddress;
	}
	public String getBeneficiaryMobileNumber() {
		return beneficiaryMobileNumber;
	}
	public void setBeneficiaryMobileNumber(String beneficiaryMobileNumber) {
		this.beneficiaryMobileNumber = beneficiaryMobileNumber;
	}
	public String getBeneficiaryRemittanceAmount() {
		return beneficiaryRemittanceAmount;
	}

	public void setBeneficiaryRemittanceAmount(String beneficiaryRemittanceAmount) {
		this.beneficiaryRemittanceAmount = beneficiaryRemittanceAmount;
	}
	public String getBeneficiaryRemittanceCurrency() {
		return beneficiaryRemittanceCurrency;
	}
	public void setBeneficiaryRemittanceCurrency(String beneficiaryRemittanceCurrency) {
		this.beneficiaryRemittanceCurrency = beneficiaryRemittanceCurrency;
	}	
	
	public String getTransactionStatusFailMessage() {
		return transactionStatusFailMessage;
	}
	public void setTransactionStatusFailMessage(String transactionStatusFailMessage) {
		this.transactionStatusFailMessage = transactionStatusFailMessage;
	}
		
	
	public String getWalletToWalletTransSucessMsg() {
		return walletToWalletTransSucessMsg;
	}
	public void setWalletToWalletTransSucessMsg(String walletToWalletTransSucessMsg) {
		this.walletToWalletTransSucessMsg = walletToWalletTransSucessMsg;
	}
	public String gettransactionStatusFailMessage() {
		return transactionStatusFailMessage;
	}
	public void settransactionStatusFailMessage(String transactionStatusMessage) {
		this.transactionStatusFailMessage = transactionStatusMessage;
	}
	public String getWalletNumFromAmountTransfer() {
		return walletNumFromAmountTransfer;
	}
	public void setWalletNumFromAmountTransfer(String walletNumFromAmountTransfer) {
		this.walletNumFromAmountTransfer = walletNumFromAmountTransfer;
	}	
	public String getWalletTransferAmount() {
		return walletTransferAmount;
	}	
	public void setWalletTransferAmount(String walletTransferAmount) {
		this.walletTransferAmount = walletTransferAmount;
	}
	public String getWalletTransferCurrency() {
		return walletTransferCurrency;
	}
	public void setWalletTransferCurrency(String walletTransferCurrency) {
		this.walletTransferCurrency = walletTransferCurrency;
	}
	
	public String getCardNumber() {
		return CardNumber;
	}
	public void setCardNumber(String cardNumber) {
		CardNumber = cardNumber;
	}
	public String getTransferAmount() {
		return TransferAmount;
	}
	public void setTransferAmount(String transferAmount) {
		TransferAmount = transferAmount;
	}
	
	public String getCurrencyName() {
		return CurrencyName;
	}
	public void setCurrencyName(String currencyName) {
		CurrencyName = currencyName;
	}
	
	public String getContactNumber() {
		return ContactNumber;
	}
	public void setContactNumber(String contactNumber) {
		ContactNumber = contactNumber;
	}
	
	public String getTransferName() {
		return TransferName;
	}
	public void setTransferName(String transferName) {
		TransferName = transferName;
	}
	
	public String getTransferMemo() {
		return TransferMemo;
	}
	public void setTransferMemo(String transferMemo) {
		TransferMemo = transferMemo;
	}
	
	public String getTransctionPassword() {
		return TransctionPassword;
	}
	public void setTransctionPassword(String transctionPassword) {
		TransctionPassword = transctionPassword;
	}
	public String getTransactionRemark() {
		return transactionRemark;
	}
	public void setTransactionRemark(String transactionRemark) {
		this.transactionRemark = transactionRemark;
	}
	
	
	
	
	public static CardHolderTransactions cardHolderTranscationDataProvider(){
		CardHolderTransactions cardTranHol = new CardHolderTransactions();
		cardTranHol.setCardNumber(MapUtils.fnGetInputDataFromMap("CardNumber"));
		cardTranHol.setContactNumber(MapUtils.fnGetInputDataFromMap("ContactNumber"));
		cardTranHol.setCurrencyName(MapUtils.fnGetInputDataFromMap("CurrencyName"));
		cardTranHol.setTransferAmount(MapUtils.fnGetInputDataFromMap("TransferAmount"));
		cardTranHol.setTransferName(MapUtils.fnGetInputDataFromMap("TransfererName"));		
		cardTranHol.setTransferMemo(MapUtils.fnGetInputDataFromMap("Memo"));
		cardTranHol.setTransctionPassword(MapUtils.fnGetInputDataFromMap("TransactionPassword"));
		cardTranHol.setTransactionRemark(MapUtils.fnGetInputDataFromMap("TransactionRemarks"));
		cardTranHol.setWalletTransferAmount(MapUtils.fnGetInputDataFromMap("AmountToTransferWalletToWallet"));
		cardTranHol.setWalletTransferCurrency(MapUtils.fnGetInputDataFromMap("WalletTransferCurrecny"));
		cardTranHol.setWalletNumFromAmountTransfer(MapUtils.fnGetInputDataFromMap("WalletNumberFromTransferMoney"));
		cardTranHol.setWalletToWalletTransSucessMsg(MapUtils.fnGetInputDataFromMap("WalletToWalletTransferSucessMsg"));
		return cardTranHol;
	}
	
	public static CardHolderTransactions cardHolderTransDataProvider(KeyValueProvider provider){
		CardHolderTransactions cardTranHol = new CardHolderTransactions();
		cardTranHol.setCardNumber(provider.getString(CARD_NUMBER));
		cardTranHol.setContactNumber(provider.getString(CONTACT_NUMBER));
		cardTranHol.setCurrencyName(provider.getString(CURRENCY_NAME));
		cardTranHol.setTransferAmount(provider.getString(TRANSFER_AMOUNT));
		cardTranHol.setTransferName(provider.getString(TRANSFER_NAME));		
		cardTranHol.setTransferMemo(provider.getString(TRANSFER_MEMO));
		cardTranHol.setTransctionPassword(provider.getString(TRANSACTION_PASSWORD));
		cardTranHol.setTransactionRemark(provider.getString(TRANSACTION_REMARK));
		cardTranHol.setWalletTransferAmount(provider.getString(WALLET_TRANSFER_AMOUNT));
		cardTranHol.setWalletTransferCurrency(provider.getString(WALLET_TRANSFER_CURRENCY));
		cardTranHol.setWalletNumFromAmountTransfer(provider.getString(WALLET_NUM_FROM_AMOUNT_TRANSFER));
		cardTranHol.setWalletToWalletTransSucessMsg(provider.getString(WALLET_TO_WALLET_TRANS_CUCCESS_MSG));
		return cardTranHol;
	}
	
	public static CardHolderTransactions cardholderCashRemittance(){
		CardHolderTransactions cardTranHol = new CardHolderTransactions();
		cardTranHol.setBeneficiaryID(MapUtils.fnGetInputDataFromMap("beneficiaryID"));
		cardTranHol.setBeneficiaryFirstName(MapUtils.fnGetInputDataFromMap("beneficiaryFirstName"));
		cardTranHol.setBeneficiaryMiddleName(MapUtils.fnGetInputDataFromMap("beneficiaryMiddleName"));
		cardTranHol.setBeneficiaryLastName(MapUtils.fnGetInputDataFromMap("beneficiaryLastName"));
		cardTranHol.setBeneficiaryAddressLine1(MapUtils.fnGetInputDataFromMap("beneficiaryAddressLine1"));
		cardTranHol.setBeneficiaryAddressLine2(MapUtils.fnGetInputDataFromMap("beneficiaryAddressLine2"));
		cardTranHol.setBeneficiaryAddressLine3(MapUtils.fnGetInputDataFromMap("beneficiaryAddressLine3"));
		cardTranHol.setBeneficiaryCountryName(MapUtils.fnGetInputDataFromMap("beneficiaryCountryName"));
		cardTranHol.setBeneficiaryStateName(MapUtils.fnGetInputDataFromMap("beneficiaryStateName"));
		cardTranHol.setBeneficiaryCityName(MapUtils.fnGetInputDataFromMap("beneficiaryCityName"));
		cardTranHol.setBeneficiaryZIPCode(MapUtils.fnGetInputDataFromMap("beneficiaryZIPCode"));
		cardTranHol.setBeneficiaryEmailAddress(MapUtils.fnGetInputDataFromMap("beneficiaryEmailAddress"));
		cardTranHol.setBeneficiaryMobileNumber(MapUtils.fnGetInputDataFromMap("beneficiaryMobileNumber"));
		cardTranHol.setBeneficiaryRemittanceAmount(MapUtils.fnGetInputDataFromMap("beneficiaryRemittanceAamount"));
		cardTranHol.setBeneficiaryRemittanceCurrency(MapUtils.fnGetInputDataFromMap("beneficiaryRemittanceCurrency"));		
		
		return cardTranHol;
	}
	
	public static CardHolderTransactions cardholderCashRemit(KeyValueProvider provider){
		CardHolderTransactions cardTranHol = new CardHolderTransactions();
		cardTranHol.setBeneficiaryID(provider.getString(BENEFICIARY_ID));
		cardTranHol.setBeneficiaryFirstName(provider.getString(BENEFICIARY_FIRST_NAME));
		cardTranHol.setBeneficiaryMiddleName(provider.getString(BENEFICIARY_MIDDLE_NAME));
		cardTranHol.setBeneficiaryLastName(provider.getString(BENEFICIARY_LAST_NAME));
		cardTranHol.setBeneficiaryAddressLine1(provider.getString(BENEFICIARY_ADDRESS_LINE1));
		cardTranHol.setBeneficiaryAddressLine2(provider.getString(BENEFICIARY_ADDRESS_LINE2));
		cardTranHol.setBeneficiaryCountryName(provider.getString(BENEFICIARY_COUNTRY_NAME));
		cardTranHol.setBeneficiaryAddressLine3(provider.getString(BENEFICIARY_ADDRESS_LINE3));
		cardTranHol.setBeneficiaryStateName(provider.getString(BENEFICIARY_STATE_NAME));
		cardTranHol.setBeneficiaryCityName(provider.getString(BENEFICIARY_CITY_NAME));
		cardTranHol.setBeneficiaryZIPCode(provider.getString(BENEFICIARY_ZIP_CODE));
		cardTranHol.setBeneficiaryEmailAddress(provider.getString(BENEFICIARY_EMAIL_ADDRESS));
		cardTranHol.setBeneficiaryRemittanceAmount(provider.getString(BENEFICIARY_REMITTANCE_AMOUNT));
		cardTranHol.setBeneficiaryMobileNumber(provider.getString(BENEFICIARY_MOBILE_NUMBER));
		cardTranHol.setBeneficiaryRemittanceCurrency(provider.getString(BENEFICIARY_REMITTANCE_CURRENCY));		
		
		return cardTranHol;
	}
}
