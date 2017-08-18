package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;

public class IssuerPublicKey {

	private String ipkId;
	private String interchange;
	private String issuerBin;
	private LocalDate issueDate;
	private LocalDate expiryDate;
	private String serialNumber;
	private String status;
	private String issueDataCurrentDatePlus;
	
	public String getIpkId() {
		return ipkId;
	}
	public void setIpkId(String ipkId) {
		this.ipkId = ipkId;
	}
	public String getInterchange() {
		return interchange;
	}
	public void setInterchange(String interchange) {
		this.interchange = interchange;
	}
	public String getIssuerBin() {
		return issuerBin;
	}
	public void setIssuerBin(String issuerBin) {
		this.issuerBin = issuerBin;
	}
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public static List<IssuerPublicKey> createWithProvider(DataProvider provider)
	{
		return provider.getData(new TypeReference<List<IssuerPublicKey>>() {}, "IssuerPublicKey");
	}
	public String getIssueDataCurrentDatePlus() {
		return issueDataCurrentDatePlus;
	}
	public void setIssueDataCurrentDatePlus(String issueDataCurrentDatePlus) {
		this.issueDataCurrentDatePlus = issueDataCurrentDatePlus;
	}	
}
