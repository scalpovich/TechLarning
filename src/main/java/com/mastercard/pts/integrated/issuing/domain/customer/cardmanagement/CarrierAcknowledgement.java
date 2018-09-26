package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

public class CarrierAcknowledgement {

	private String productType;
	private String fileType;
	private String fileName;
	private String courierVendorName;
	private String AWBNumber;
	private String receivedBy;
	private String status;
	private String relationship;
	
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
	public String getCourierVendorName() {
		return courierVendorName;
	}
	public void setCourierVendorName(String courierVendorName) {
		this.courierVendorName = courierVendorName;
	}
	public String getAWBNumber() {
		return AWBNumber;
	}
	public void setAWBNumber(String aWBNumber) {
		AWBNumber = aWBNumber;
	}
	public String getReceivedBy() {
		return receivedBy;
	}
	public void setReceivedBy(String receivedBy) {
		this.receivedBy = receivedBy;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	
	public static CarrierAcknowledgement createWithProvider(KeyValueProvider provider){
		CarrierAcknowledgement carrierAcknowledgement = new CarrierAcknowledgement();
		carrierAcknowledgement.setCourierVendorName(provider.getString("COURIER_VENDOR"));
		carrierAcknowledgement.setAWBNumber(provider.getString("AWB_NUMBER"));
		carrierAcknowledgement.setReceivedBy(provider.getString("RECEIVED_BY"));
		carrierAcknowledgement.setStatus(provider.getString("CARRIER_STATUS"));
		carrierAcknowledgement.setRelationship(provider.getString("RELATIONSHIP"));
		return carrierAcknowledgement;
	}
	
}
