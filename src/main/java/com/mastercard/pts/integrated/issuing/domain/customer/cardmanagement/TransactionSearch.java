package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

public class TransactionSearch {
	private static final String PRODUCT_TYPE = "PRODUCT_TYPE";
	private static final String PREPAID_PRODUCT_TYPE = "PREPAID_PRODUCT_TYPE";
	private static final String DATE_TYPE = "DATE_TYPE";
	private String dateType;

	public String getDateType() {
		return dateType;
	}

	private String productType;

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public void setDateType(String dateType) {
		this.dateType = dateType;
	}

	public static TransactionSearch getProviderData(KeyValueProvider provider) {
		TransactionSearch ts = new TransactionSearch();
		ts.setDateType(provider.getString(DATE_TYPE));
		ts.setProductType(provider.getString(PREPAID_PRODUCT_TYPE));
		ts.setProductType(provider.getString(PRODUCT_TYPE));
		return ts;
	}
}
