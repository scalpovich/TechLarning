package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

@Component
public class CorporateClient {

	private static final String CREDIT_LIMIT = "CREDIT_LIMIT";
	private static final String CASH_LIMIT = "PGM_CASH_LIMITS_CASH_LIMIT_AMOUNT";
	private static final String BILLING_CURRENCY = "BILLING_CURRENCY";
	private static final String CASH_LIMIT_RESET = "CASH_LIMIT_RESET";
	private static final String COMPANY_NAME = "COMPANY_NAME";	
	public String productType;	
	public String applicationRefNumber;
	public String branch;
	public String companyName;
	public String embossedLine;
	public String program;
	public String liabilityType;
	public String tanNumber;
	public String creditLimit;
	public String cashLimit;
	public String billingCurrency;
	
	public static CorporateClient createDataWithProvider( KeyValueProvider provider) {
		CorporateClient programObject =new	CorporateClient();
		programObject.setApplicationRefNumber(MiscUtils.generate8CharAlphaNumeric());
		programObject.setTanNumber(MiscUtils.generate6CharAlphaNumeric());
		programObject.setCreditLimit(provider.getString(CREDIT_LIMIT));
		programObject.setCashLimit(provider.getString(CASH_LIMIT));
		programObject.setBillingCurrency(provider.getString(BILLING_CURRENCY));
		programObject.setBillingCurrency(provider.getString(BILLING_CURRENCY));
		return programObject;
	}
	
	public String getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(String creditLimit) {
		this.creditLimit = creditLimit;
	}

	public String getCashLimit() {
		return cashLimit;
	}

	public void setCashLimit(String cashLimit) {
		this.cashLimit = cashLimit;
	}

	public String getBillingCurrency() {
		return billingCurrency;
	}

	public void setBillingCurrency(String billingCurrency) {
		this.billingCurrency = billingCurrency;
	}
	
	public String getTanNumber() {
		return tanNumber;
	}

	public void setTanNumber(String tanNumber) {
		this.tanNumber = tanNumber;
	}

	public String getProductType() {		
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getApplicationRefNumber() {
		return applicationRefNumber;
	}

	public void setApplicationRefNumber(String applicationRefNumber) {
		this.applicationRefNumber = applicationRefNumber;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getEmbossedLine() {
		return embossedLine;
	}

	public void setEmbossedLine(String embossedLine) {
		this.embossedLine = embossedLine;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getLiabilityType() {
		return liabilityType;
	}

	public void setLiabilityType(String liabilityType) {
		this.liabilityType = liabilityType;
	}
}
