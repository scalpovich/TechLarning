package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;

@Component
public class DeviceBin implements HasCodeAndDescription {

	private String interchange;
	private String productType;
	private String issuerBin;
	private String binType;
	private String program;
	private String deviceplan;
	private String issuerBinCode;
	private String description;

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getDeviceplan() {
		return deviceplan;
	}

	public void setDeviceplan(String deviceplan) {
		this.deviceplan = deviceplan;
	}

	public DeviceBin(String interchange, String productType, String issuerBin,
			String binType, String remarks) {
		super();
		this.interchange = interchange;
		this.productType = productType;
		this.issuerBin = issuerBin;
		this.binType = binType;
		this.description = remarks;
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

	public void devicebinDataProvider(String network, String productType) {
		setDescription(network + " " + productType);

	}

	public static List<DeviceBin> createWithProvider(DataProvider provider) {
		return provider.getData(new TypeReference<List<DeviceBin>>() {
		}, "DeviceBin");
	}

	@Override
	public String getCode() {
		return issuerBinCode;
	}

	public void setCode(String issuerBinCode) {
		this.issuerBinCode = issuerBinCode;
	}

	@Override
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
