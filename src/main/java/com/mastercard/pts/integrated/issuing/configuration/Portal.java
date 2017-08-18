package com.mastercard.pts.integrated.issuing.configuration;

public class Portal {
	
	public static final String TYPE_CUSTOMER = "customer";
	public static final String TYPE_AGENT = "agent";
	public static final String TYPE_COLLECT = "collect";
	public static final String TYPE_CARDHOLDER = "cardholder";

	private String url;
	
	private String userName;
	
	private String agencyUserName;
	
	private String branchUserName;
	
	private String agentUserName;
	
	private String adminUserName;
	
	private String password;
	
	private String adminPassword;
	
	public String getBranchUserName() {
		return branchUserName;
	}

	public void setBranchUserName(String branchUserName) {
		this.branchUserName = branchUserName;
	}

	public String getAgencyUserName() {
		return agencyUserName;
	}

	public void setAgencyUserName(String agencyUserName) {
		this.agencyUserName = agencyUserName;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getAgentUserName() {
		return agentUserName;
	}

	public void setAgentUserName(String agentUserName) {
		this.agentUserName = agentUserName;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	@Override
	public String toString() {
		return "Portal [url=" + url + ", userName=" + userName + "]";
	}
}
