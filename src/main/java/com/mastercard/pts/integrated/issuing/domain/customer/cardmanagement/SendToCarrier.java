package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

public class SendToCarrier {

	private String productType;
	private String fileType;
	private String fileName;
	private String courierVendorName;
	
	public String getCourierVendorName() {
		return courierVendorName;
	}
	public void setCourierVendorName(String courierVendorName) {
		this.courierVendorName = courierVendorName;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public static SendToCarrier createWithProvider(KeyValueProvider provider){
		SendToCarrier carrier = new SendToCarrier();
		carrier.setCourierVendorName(provider.getString("COURIER_VENDOR"));
		return carrier;
	}
	
}
