package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

public class ApplicationBusinessMandatoryFields {

	private static final String CUSTOMER_TYPE = "CUSTOMER_TYPE";		
	private static final String BMF_SELECT_ALL = "BMF_SELECT_ALL";
	public static final String MANDATORY_FIELDS = "MANDATORY_FIELDS";

	private String productType;
	private String programCode;
	private String customerType;
	private String selectAll;
	private String mandatoryFields;
	
	public  static ApplicationBusinessMandatoryFields createWithProvider(KeyValueProvider provider) {
		ApplicationBusinessMandatoryFields details = new ApplicationBusinessMandatoryFields();
		details.setCustomerType(provider.getString(CUSTOMER_TYPE));
		details.setMandatoryFields(provider.getString(MANDATORY_FIELDS));
		details.setSelectAll(provider.getString(BMF_SELECT_ALL));
		return details;
	}

	public static ApplicationBusinessMandatoryFields createWithProvider(DataProvider provider, KeyValueProvider excelProvider) {
		ApplicationBusinessMandatoryFields details = provider.getDataBySimpleClassName(ApplicationBusinessMandatoryFields.class);
		//Customer type is already defined in JSON file. Until the fix is in place for "Ravi" to work, let this line be commented		
		details.setCustomerType(excelProvider.getString(CUSTOMER_TYPE));
		return details;
	}

	public String getMandatoryFields() {
			return mandatoryFields;
	}
	
	public void setMandatoryFields(String mandatoryFields) {
		this.mandatoryFields = mandatoryFields;
	}

	public String getSelectAll() {
		return selectAll;
	}

	public void setSelectAll(String selectAll) {
		this.selectAll = selectAll;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProgramCode() {
		return programCode;
	}

	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}

	@Override
	public String toString() {
		return "ApplicationBusinessMandatoryFields [productType=" + productType
				+ ", programCode=" + programCode + ", customerType="
				+ customerType + ", selectAll=" + selectAll
				+ ", mandatoryFields=" + mandatoryFields + "]";
	}

}
