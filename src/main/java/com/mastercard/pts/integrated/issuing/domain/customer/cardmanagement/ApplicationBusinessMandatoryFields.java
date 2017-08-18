package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class ApplicationBusinessMandatoryFields {

	private String productType;
	private String customerType;
	private String fieldName;
	private String programCode;

	public static ApplicationBusinessMandatoryFields createWithProvider(DataProvider provider) {
		ApplicationBusinessMandatoryFields details = provider.getDataBySimpleClassName(ApplicationBusinessMandatoryFields.class);
		return details;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	@Override
	public String toString() {
		return MiscUtils.toString(this);
	}

	public String getProgramCode() {
		return programCode;
	}

	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}
}
