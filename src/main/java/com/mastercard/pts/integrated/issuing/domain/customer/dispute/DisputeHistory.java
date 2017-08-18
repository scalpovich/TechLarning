package com.mastercard.pts.integrated.issuing.domain.customer.dispute;

import java.time.LocalDate;

public class DisputeHistory {

	private String arn;
	private LocalDate fromDate;
	private LocalDate toDate;
	private String deviceNumber;
	private String authorizationId;
	private String processingDate;
	
	public String getArn() {
		return arn;
	}
	public void setArn(String arn) {
		this.arn = arn;
	}
	public String getDeviceNumber() {
		return deviceNumber;
	}
	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}
	public String getAuthorizationId() {
		return authorizationId;
	}
	public void setAuthorizationId(String authorizationId) {
		this.authorizationId = authorizationId;
	}
	public String getProcessingDate() {
		return processingDate;
	}
	public void setProcessingDate(String processingDate) {
		this.processingDate = processingDate;
	}
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
	
	public static DisputeHistory getDisputeHistory()
	{
		DisputeHistory dh=new DisputeHistory();
		dh.setFromDate(LocalDate.now().minusDays(30));
		dh.setToDate(LocalDate.now());
		return dh;
	}
	
}
