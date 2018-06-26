package com.mastercard.pts.integrated.issuing.domain;

import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class CreditInstitutionData {
	private String association;
	private String branch;
	private String cardPackIdGenerationTemplate;
	private String deviceIdGenerationTemplate;
	private String customerType;
	private String embossingVendor;
    private String interchange;
	private String plasticId;
	private String pictureCode;
	private String code;
	private String abbreviation;
	private String corporateClientCode;
	private String mastercardPrepaidIssuerBin;
	private String mastercardDebitIssuerBin;
	private String mastercardCreditIssuerBin;
	private String visaPrepaidIssuerBin;
	private String visaDebitIssuerBin;
	private String visaCreditIssuerBin;
	private String deDupePlanCode;
	private String prepaidStatementPlan;
	private String statementMessagePlan;
	private String marketingMessagePlan;
	private String documentCheckListPlan;
	private String mccRulePlan;
	private String deviceJoiningAndMemberShipFeePlan;
	private String deviceEventBasedFeePlan;
	private String transactionLimitPlan;
	private String transactionPlan;
	private String creditPlan;
	private String billingCycle;
	private String walletPlan;	
	
	public String getAssociation() {
		return association;
	}

	public void setAssociation(String association) {
		this.association = association;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getInterchange() {
		return interchange;
	}

	public void setInterchange(String interchange) {
		this.interchange = interchange;
	}
	
	public String getCardPackIdGenerationTemplate() {
		return cardPackIdGenerationTemplate;
	}

	public void setCardPackIdGenerationTemplate(String cardPackIdGenerationTemplate) {
		this.cardPackIdGenerationTemplate = cardPackIdGenerationTemplate;
	}

	public String getDeviceIdGenerationTemplate() {
		return deviceIdGenerationTemplate;
	}

	public void setDeviceIdGenerationTemplate(String deviceIdGenerationTemplate) {
		this.deviceIdGenerationTemplate = deviceIdGenerationTemplate;
	}

	public String getEmbossingVendor() {
		return embossingVendor;
	}

	public void setEmbossingVendor(String embossingVendor) {
		this.embossingVendor = embossingVendor;
	}

	public String getPlasticId() {
		return plasticId;
	}

	public void setPlasticId(String plasticId) {
		this.plasticId = plasticId;
	}

	public String getPictureCode() {
		return pictureCode;
	}

	public void setPictureCode(String pictureCode) {
		this.pictureCode = pictureCode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	
	public String getCorporateClientCode() {
		return corporateClientCode;
	}

	public void setCorporateClientCode(String corporateClientCode) {
		this.corporateClientCode = corporateClientCode;
	}

	public String getMastercardPrepaidIssuerBin() {
		return mastercardPrepaidIssuerBin;
	}

	public void setMastercardPrepaidIssuerBin(String mastercardPrepaidIssuerBin) {
		this.mastercardPrepaidIssuerBin = mastercardPrepaidIssuerBin;
	}

	public String getMastercardDebitIssuerBin() {
		return mastercardDebitIssuerBin;
	}

	public void setMastercardDebitIssuerBin(String mastercardDebitIssuerBin) {
		this.mastercardDebitIssuerBin = mastercardDebitIssuerBin;
	}

	public String getMastercardCreditIssuerBin() {
		return mastercardCreditIssuerBin;
	}

	public void setMastercardCreditIssuerBin(String mastercardCreditIssuerBin) {
		this.mastercardCreditIssuerBin = mastercardCreditIssuerBin;
	}

	public String getVisaPrepaidIssuerBin() {
		return visaPrepaidIssuerBin;
	}

	public void setVisaPrepaidIssuerBin(String visaPrepaidIssuerBin) {
		this.visaPrepaidIssuerBin = visaPrepaidIssuerBin;
	}

	public String getVisaDebitIssuerBin() {
		return visaDebitIssuerBin;
	}

	public void setVisaDebitIssuerBin(String visaDebitIssuerBin) {
		this.visaDebitIssuerBin = visaDebitIssuerBin;
	}

	public String getVisaCreditIssuerBin() {
		return visaCreditIssuerBin;
	}

	public void setVisaCreditIssuerBin(String visaCreditIssuerBin) {
		this.visaCreditIssuerBin = visaCreditIssuerBin;
	}
    
	

	public String getDeDupePlanCode() {
		return deDupePlanCode;
	}

	public void setDeDupePlanCode(String deDupePlanCode) {
		this.deDupePlanCode = deDupePlanCode;
	}
	
	public String getPrepaidStatementPlan() {
		return prepaidStatementPlan;
	}

	public void setPrepaidStatementPlan(String prepaidStatementPlan) {
		this.prepaidStatementPlan = prepaidStatementPlan;
	}

	public String getStatementMessagePlan() {
		return statementMessagePlan;
	}

	public void setStatementMessagePlan(String statementMessagePlan) {
		this.statementMessagePlan = statementMessagePlan;
	}

	public String getMarketingMessagePlan() {
		return marketingMessagePlan;
	}

	public void setMarketingMessagePlan(String marketingMessagePlan) {
		this.marketingMessagePlan = marketingMessagePlan;
	}
    
	public String getDocumentCheckListPlan() {
		return documentCheckListPlan;
	}

	public void setDocumentCheckListPlan(String documentCheckListPlan) {
		this.documentCheckListPlan = documentCheckListPlan;
	}

	public String getMccRulePlan() {
		return mccRulePlan;
	}

	public void setMccRulePlan(String mccRulePlan) {
		this.mccRulePlan = mccRulePlan;
	}
    
	public String getDeviceJoiningAndMemberShipFeePlan() {
		return deviceJoiningAndMemberShipFeePlan;
	}

	public void setDeviceJoiningAndMemberShipFeePlan(
			String deviceJoiningAndMemberShipFeePlan) {
		this.deviceJoiningAndMemberShipFeePlan = deviceJoiningAndMemberShipFeePlan;
	}

	public String getDeviceEventBasedFeePlan() {
		return deviceEventBasedFeePlan;
	}

	public void setDeviceEventBasedFeePlan(String deviceEventBasedFeePlan) {
		this.deviceEventBasedFeePlan = deviceEventBasedFeePlan;
	}

	public String getTransactionLimitPlan() {
		return transactionLimitPlan;
	}

	public void setTransactionLimitPlan(String transactionLimitPlan) {
		this.transactionLimitPlan = transactionLimitPlan;
	}

	public String getTransactionPlan() {
		return transactionPlan;
	}

	public void setTransactionPlan(String transactionPlan) {
		this.transactionPlan = transactionPlan;
	}
    
	public String getCreditPlan() {
		return creditPlan;
	}

	public void setCreditPlan(String creditPlan) {
		this.creditPlan = creditPlan;
	}

	public String getBillingCycle() {
		return billingCycle;
	}

	public void setBillingCycle(String billingCycle) {
		this.billingCycle = billingCycle;
	}
    
	public String getWalletPlan() {
		return walletPlan;
	}

	public void setWalletPlan(String walletPlan) {
		this.walletPlan = walletPlan;
	}

	public static CreditInstitutionData createWithProvider(DataProvider provider,String institutionCode) {
         return  provider.getDataBySimpleClassNameForInstitute(CreditInstitutionData.class, institutionCode);
	}
	
	
	@Override
	public String toString() {
		return MiscUtils.toString(this);
	}
}