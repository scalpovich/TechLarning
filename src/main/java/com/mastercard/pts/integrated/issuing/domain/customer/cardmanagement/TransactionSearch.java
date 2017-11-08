package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

public class TransactionSearch {
	private String dateType;
	
	public String getDateType() {
		return dateType;
	}

	public void setDateType(String dateType) {
		this.dateType = dateType;
	}

	public static TransactionSearch getProviderData(KeyValueProvider provider)
	{
		TransactionSearch ts=new TransactionSearch();
		ts.setDateType(provider.getString("DATE_TYPE"));
		return ts;
	}
}
