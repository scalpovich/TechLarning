package com.mastercard.pts.integrated.issuing.domain.agent.channelmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;

public class AgencyUser extends User{

	public static AgencyUser createWithProvider(DataProvider provider) {
		return provider.getDataBySimpleClassName(AgencyUser.class);
	}
	
}
