package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class AggregateLoadLimit {

	private  String monthlyLimit;
	private String monthlyVelocity;
	private String yearlyLimit;
	private String yearlyVelocity;
	private String currencyCode;
	   

	public String getMonthlyLimit() {
		return monthlyLimit;
	}


	public void setMonthlyLimit(String monthlyLimit) {
		this.monthlyLimit = monthlyLimit;
	}


	public String getMonthlyVelocity() {
		return monthlyVelocity;
	}


	public void setMonthlyVelocity(String monthlyVelocity) {
		this.monthlyVelocity = monthlyVelocity;
	}


	public String getYearlyLimit() {
		return yearlyLimit;
	}


	public void setYearlyLimit(String yearlyLimit) {
		this.yearlyLimit = yearlyLimit;
	}


	public String getYearlyVelocity() {
		return yearlyVelocity;
	}


	public void setYearlyVelocity(String yearlyVelocity) {
		this.yearlyVelocity = yearlyVelocity;
	}


	public String getCurrencyCode() {
		return currencyCode;
	}


	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}


	public static AggregateLoadLimit createDataProvider() {
		AggregateLoadLimit aggregateLoadLimit= new AggregateLoadLimit();
		aggregateLoadLimit.setCurrencyCode(MapUtils.fnGetInputDataFromMap("currencyCodeTxt"));
		aggregateLoadLimit.setMonthlyLimit(MapUtils.fnGetInputDataFromMap("monthlyLimitTxt"));
		aggregateLoadLimit.setMonthlyVelocity(MapUtils.fnGetInputDataFromMap("monthlyVelocityTxt"));
		aggregateLoadLimit.setYearlyLimit(MapUtils.fnGetInputDataFromMap("yearlyLimitTxt"));	
		aggregateLoadLimit.setYearlyVelocity(MapUtils.fnGetInputDataFromMap("yearlyVelocityTxt"));
		return  aggregateLoadLimit;
	}
}


