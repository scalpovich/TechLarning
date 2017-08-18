package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;

public class DeviceBin {

	private String interchange;
	private String productType;
	private String issuerBin;
	private String binType;
	private String remarks;
	
	public DeviceBin(String interchange, String productType, String issuerBin,
			String binType, String remarks) {
		super();
		this.interchange = interchange;
		this.productType = productType;
		this.issuerBin = issuerBin;
		this.binType = binType;
		this.remarks = remarks;
	}
	public DeviceBin() {
		super();
	}
	
	public String getInterchange() {
		return interchange;
	}
	public void setInterchange(String interchange) {
		this.interchange = interchange;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getIssuerBin() {
		return issuerBin;
	}
	public void setIssuerBin(String issuerBin) {
		this.issuerBin = issuerBin;
	}
	public String getBinType() {
		return binType;
	}
	public void setBinType(String binType) {
		this.binType = binType;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public static List<DeviceBin> createWithProvider(DataProvider provider)
	{
		return provider.getData(new TypeReference<List<DeviceBin>>() {}, "DeviceBin");
	}
	
}
