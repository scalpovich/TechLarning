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
		String branchUsrName = System.getProperty("branchUserName");
		if (branchUsrName != null && !branchUsrName.trim().isEmpty())
			this.branchUserName = branchUsrName;
		else
			this.branchUserName = branchUserName;
	}

	public String getAgencyUserName() {
		return agencyUserName;
	}

	public void setAgencyUserName(String agencyUserName) {
		String agencyUsrName = System.getProperty("agencyUserName");
		if (agencyUsrName != null && !agencyUsrName.trim().isEmpty())
			this.agencyUserName = agencyUsrName;
		else
			this.agencyUserName = agencyUserName;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		String adminUsrName = System.getProperty("adminUserName");
		if (adminUsrName != null && !adminUsrName.trim().isEmpty())
			this.adminUserName = adminUsrName;
		else
			this.adminUserName = adminUserName;
	}

	public String getAgentUserName() {
		return agentUserName;
	}

	public void setAgentUserName(String agentUserName) {
		String agentUsrName = System.getProperty("agentUserName");
		if (agentUsrName != null && !agentUsrName.trim().isEmpty())
			this.agentUserName = agentUsrName;
		else
			this.agentUserName = agentUserName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		String usrName = System.getProperty("userName");
		if (usrName != null && !usrName.trim().isEmpty())
			this.userName = usrName;
		else
			this.userName = userName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		String portalUrl = System.getProperty("url");
		if (portalUrl != null && !portalUrl.trim().isEmpty())
			this.url = portalUrl;
		else
			this.url = url;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		String pwd = System.getProperty("password");
		if (pwd != null && !pwd.trim().isEmpty())
			this.password = pwd;
		else
			this.password = password;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		String adminPwd = System.getProperty("adminPassword");
		if (adminPwd != null && !adminPwd.trim().isEmpty())
			this.adminPassword = adminPwd;
		else
			this.adminPassword = adminPassword;
	}

	@Override
	public String toString() {
		return "Portal [url=" + url + ", userName=" + userName + "]";
	}

}
