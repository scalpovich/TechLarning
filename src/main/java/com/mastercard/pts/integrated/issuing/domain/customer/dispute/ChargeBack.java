package com.mastercard.pts.integrated.issuing.domain.customer.dispute;

import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;

public class ChargeBack extends ChargeBackAbstractClass{

	public static ChargeBack createWithProvider(DataProvider provider) {
		return provider.getDataBySimpleClassName(ChargeBack.class);
	}
}
