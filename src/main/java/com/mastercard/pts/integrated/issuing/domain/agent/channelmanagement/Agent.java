package com.mastercard.pts.integrated.issuing.domain.agent.channelmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;

public class Agent extends Branch {

	private String agentId;
	private String agentName;
	
	public String getAgentId() {
		return agentId;
	}
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	
	public static Agent createWithProvider(DataProvider provider) {
		return provider.getDataBySimpleClassName(Agent.class);
	}
}
