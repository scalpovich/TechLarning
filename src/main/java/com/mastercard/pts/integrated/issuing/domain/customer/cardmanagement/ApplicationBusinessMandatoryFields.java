package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class ApplicationBusinessMandatoryFields {

	public static final String CUSTOMER_TYPE = "CUSTOMER_TYPE";		

	private String productType;
	private String fieldName;
	private String programCode;
	private String customerType;

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public static ApplicationBusinessMandatoryFields createWithProvider(DataProvider provider) {
		ApplicationBusinessMandatoryFields details = provider.getDataBySimpleClassName(ApplicationBusinessMandatoryFields.class);
		return details;
	}
	public static ApplicationBusinessMandatoryFields createWithProvider(DataProvider provider, KeyValueProvider excelProvider) {
		ApplicationBusinessMandatoryFields details = provider.getDataBySimpleClassName(ApplicationBusinessMandatoryFields.class);
		//Customer type is already defined in JSON file. Until the fix is in place for "Ravi" to work, let this line be commented		
		details.setCustomerType(excelProvider.getString(CUSTOMER_TYPE));
		return details;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
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
