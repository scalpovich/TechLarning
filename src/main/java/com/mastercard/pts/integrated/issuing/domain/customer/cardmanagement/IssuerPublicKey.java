package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class IssuerPublicKey {

	public String Interchange;

	public String IPKExpiryDate;

	public String Status;

	public String IssuerDate;

	public String DeviceBin;

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
