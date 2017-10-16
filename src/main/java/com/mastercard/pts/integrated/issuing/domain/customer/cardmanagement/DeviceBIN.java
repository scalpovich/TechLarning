package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class DeviceBIN {

	public static DeviceBIN devicebin = new DeviceBIN();

	public String Remark;

	public String BinType;

	public String IssuerBin;

	public String Interchange;

	public String getInterchange() {
		return Interchange;
	}

	public void setInterchange(String interchange) {
		Interchange = interchange;
	}

	public String getIssuerBin() {
		return IssuerBin;
	}

	public void setIssuerBin(String issuerBin) {
		IssuerBin = issuerBin;
	}

	public String getBinType() {
		return BinType;
	}

	public void setBinType(String binType) {
		BinType = binType;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String remark) {
		Remark = remark;
	}

	public void devicebinDataProvider() {
		setRemark(MapUtils.fnGetInputDataFromMap("Remark"));

	}

}
