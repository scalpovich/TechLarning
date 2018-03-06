package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.List;

import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;

@Component
public class IssuerPublicKey {

	private String ipkId;
	private String interchange;
	private String issuerBin;
	private String issuerDate;
	private String ipkExpiryDate;
	private String serialNumber;
	private String status;
	private String issueDataCurrentDatePlus;
	public String deviceBin;
	public LocalDate expiryDate;
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
	public String getIssuerDate() {
		return issuerDate;
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
	public String getDeviceBin() {
		return deviceBin;
	}

	public void setDeviceBin(String device_Bin) {
		this.deviceBin = device_Bin;
	}

	public void setIssuerDate(String issuerDate) {
		this.issuerDate = issuerDate;
	}


	public String getIPKExpiryDate() {
		return ipkExpiryDate;
	}

	public void setIPKExpiryDate(String iPKExpiryDate) {
		this.ipkExpiryDate = iPKExpiryDate;
	}



	public void ipkDatProvider() {
		setIPKExpiryDate(MapUtils.fnGetInputDataFromMap("iPKExpiryDate"));
		setStatus(MapUtils.fnGetInputDataFromMap("StatusValue"));
		setIssuerDate(DateUtils.getNextDateInDDMMYYYY());

	}

}
