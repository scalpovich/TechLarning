package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CurrencyExchangeRate {

	final Logger logger = LoggerFactory.getLogger(this.getClass());

	private String sourceCurrency;
	private String destinationCurrency;
	private String rateOrigin;
	private String buyRate;
	private String midRate;
	private String sellRate;
	private String program;
	private String effectiveDate;
	private String effectiveTimeHH24;
	private String effectiveTimeMI;
	private String toleranceLoadUnit;
	private String toleranceRefundUnit;

	public String getSourceCurrency() {
		return sourceCurrency;
	}

	public void setSourceCurrency(String sourceCurrency) {
		this.sourceCurrency = sourceCurrency;
	}

	public String getDestinationCurrency() {
		return destinationCurrency;
	}

	public void setDestinationCurrency(String destinationCurrency) {
		this.destinationCurrency = destinationCurrency;
	}

	public String getRateOrigin() {
		return rateOrigin;
	}

	public void setRateOrigin(String rateOrigin) {
		this.rateOrigin = rateOrigin;
	}

	public String getBuyRate() {
		return buyRate;
	}

	public void setBuyRate(String buyRate) {
		this.buyRate = buyRate;
	}

	public String getMidRate() {
		return midRate;
	}

	public void setMidRate(String midRate) {
		this.midRate = midRate;
	}

	public String getSellRate() {
		return sellRate;
	}

	public void setSellRate(String sellRate) {
		this.sellRate = sellRate;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getEffectiveTimeHH24() {
		return effectiveTimeHH24;
	}

	public void setEffectiveTimeHH24(String effectiveTimeHH24) {
		this.effectiveTimeHH24 = effectiveTimeHH24;
	}

	public String getEffectiveTimeMI() {
		return effectiveTimeMI;
	}

	public void setEffectiveTimeMI(String effectiveTimeMI) {
		this.effectiveTimeMI = effectiveTimeMI;
	}

	public String getToleranceLoadUnit() {
		return toleranceLoadUnit;
	}

	public void setToleranceLoadUnit(String toleranceLoadUnit) {
		this.toleranceLoadUnit = toleranceLoadUnit;
	}

	public String getToleranceRefundUnit() {
		return toleranceRefundUnit;
	}

	public void setToleranceRefundUnit(String toleranceRefundUnit) {
		this.toleranceRefundUnit = toleranceRefundUnit;
	}

}
