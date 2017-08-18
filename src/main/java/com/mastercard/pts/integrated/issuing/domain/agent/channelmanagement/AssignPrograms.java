package com.mastercard.pts.integrated.issuing.domain.agent.channelmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

public class AssignPrograms {
	private static final String AGENCY_NAME = "AGENCY";
	private static final String AGENCY_ID = "AGENCY_ID";
	private static final String BRANCH_ID = "BRANCH_ID";
	private static final String AGENT_ID = "AGENT_ID";
	private static final String DEVICE_TYPE = "DEVICE_TYPE";

	private String agencyName;
	private String agencyId;
	private String branchId;
	private String agentId;
	private String programCode;
	private String deviceType;
	
	public static AssignPrograms createWithProvider(KeyValueProvider provider) {
		AssignPrograms plan = new AssignPrograms();
		plan.setAgency(provider.getString(AGENCY_NAME));
		plan.setAgencyId(provider.getString(AGENCY_ID));
		plan.setBranchId(provider.getString(BRANCH_ID));
		plan.setAgentId(provider.getString(AGENT_ID));
		plan.setDeviceType(provider.getString(DEVICE_TYPE));
		return plan;
	}

	public String getAgency() {
		return agencyName;
	}

	public void setAgency(String agency) {
		this.agencyName = agency;
	}

	public String getAgencyId() {
		return agencyId;
	}
	
	public void setAgencyId(String agencyId) {
		this.agencyId = agencyId;
	}
	
	public String getBranchId() {
		return branchId;
	}
	
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	
	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getProgramCode() {
		return programCode;
	}
	
	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}
	
	public String getDeviceType() {
		return deviceType;
	}
	
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	@Override
	public String toString() {
		return "AssignPrograms [agencyId=" + agencyId + ", branchId="
				+ branchId + ", agentId=" + agentId + ", programCode="
				+ programCode + ", deviceType=" + deviceType + "]";
	}
}
