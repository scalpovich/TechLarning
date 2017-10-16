package com.mastercard.pts.integrated.issuing.domain.agent.channelmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;

public class CorporateUser extends User{

	public static CorporateUser createWithProvider(DataProvider provider) {
		return provider.getDataBySimpleClassName(CorporateUser.class);
	}
	
}
