package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;

@Component
public class CurrencyExchangeRateMapping extends AbstractBasePage{
	final Logger logger = LoggerFactory.getLogger(this.getClass());

	private String transactionSource;
	private String rateOrigin;
	private String transactionType;
	private String rateType;
	private String program;

	public String getTransactionSource() {
		return transactionSource;
	}

	public void setTransactionSource(String transactionSource) {
		this.transactionSource = transactionSource;
	}

	public String getRateOrigin() {
		return rateOrigin;
	}

	public void setRateOrigin(String rateOrigin) {
		this.rateOrigin = rateOrigin;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getRateType() {
		return rateType;
	}

	public void setRateType(String rateType) {
		this.rateType = rateType;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

}
