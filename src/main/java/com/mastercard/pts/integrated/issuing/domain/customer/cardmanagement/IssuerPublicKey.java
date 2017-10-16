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
	private LocalDate issueDate;
	private LocalDate ipkExpiryDate;
	private String serialNumber;
	private String status;
	private String issueDataCurrentDatePlus;
	public String DeviceBin;
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
	public String getDeviceBin() {
		return DeviceBin;
	}

	public void setDeviceBin(String deviceBin) {
		DeviceBin = deviceBin;
	}

	public String getIssuerDate() {
		return IssuerDate;
	}

	public void setIssuerDate(String issuerDate) {
		IssuerDate = issuerDate;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getIPKExpiryDate() {
		return IPKExpiryDate;
	}

	public void setIPKExpiryDate(String iPKExpiryDate) {
		IPKExpiryDate = iPKExpiryDate;
	}

	public String getInterchange() {
		return Interchange;
	}

	public void setInterchange(String interchange) {
		Interchange = interchange;
	}

	public void ipkDatProvider() {
		// IssuerPublicKey ipk = new IssuerPublicKey();
		// if (MapUtils.fnGetInputDataFromMap("DMSIssuerBIN") != null) {
		// ipk.setIssuerBIN(MapUtils.fnGetInputDataFromMap("DMSIssuerBIN"));
		// } else if (MapUtils.fnGetInputDataFromMap("SMSIssuerBIN") != null) {
		// ipk.setIssuerBIN(MapUtils.fnGetInputDataFromMap("SMSIssuerBIN"));
		// }

		setIPKExpiryDate(MapUtils.fnGetInputDataFromMap("iPKExpiryDate"));
		setStatus(MapUtils.fnGetInputDataFromMap("StatusValue"));
		setIssuerDate(DateUtils.getDateinDDMMYYYY());

	}

}
