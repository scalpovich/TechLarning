package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

public class TransactionSearch {
	private String dateType;
	private String productTyp;
	
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

	public static TransactionSearch getProviderData(KeyValueProvider provider)
	{
		TransactionSearch ts=new TransactionSearch();
		ts.setDateType(provider.getString("DATE_TYPE"));
		ts.setProductType(provider.getString("PRODUCT_TYP"));
//		ts.setDateType(provider.getString("ACCOUNT_TYPE"));
		
		return ts;
	}
}
