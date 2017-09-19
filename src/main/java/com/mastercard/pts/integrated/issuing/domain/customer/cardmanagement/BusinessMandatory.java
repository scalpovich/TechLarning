package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;

public class BusinessMandatory extends AbstractBasePage {

	public String CustomerType;

	public String getCustomerType() {
		return CustomerType;
	}

	public void setCustomerType(String customerType) {
		CustomerType = customerType;
	}

	// public BusinessMandatory businessmandatoryDataprovider() {
	// BusinessMandatory businessmandat = new BusinessMandatory();
	// businessmandat.setCustomerType(MapUtils.fnGetInputDataFromMap("CustomerType"));
	// return businessmandat;
	// }

}
