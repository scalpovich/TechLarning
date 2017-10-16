package com.mastercard.pts.integrated.issuing.domain.agent.channelmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;

public class BranchUser extends User {

	public static BranchUser createWithProvider(DataProvider provider) {
		return provider.getDataBySimpleClassName(BranchUser.class);
	}
}
