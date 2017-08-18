package com.mastercard.pts.integrated.issuing.domain.agent.channelmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;

public class AgentUser  extends User{

	public static AgentUser createWithProvider(DataProvider provider) {
		return provider.getDataBySimpleClassName(AgentUser.class);
	}
}
