package com.mastercard.pts.integrated.issuing.rest.api.domain;

import org.springframework.stereotype.Component;

@Component
public class DeviceDetails {
	
	private String transactionId;
	private	String timeStamp;
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	

}
