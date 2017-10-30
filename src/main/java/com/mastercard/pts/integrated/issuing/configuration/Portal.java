package com.mastercard.pts.integrated.issuing.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

public class Portal {

	public static final String TYPE_CUSTOMER = "customer";
	public static final String TYPE_AGENT = "agent";
	public static final String TYPE_COLLECT = "collect";
	public static final String TYPE_CARDHOLDER = "cardholder";
	

	private String customerUserName;
	private String agencyUserName;
	private String agentUserName;
	private String agentAdminUser;
	private String customerAdminUser;
	private String customerUserPassword;
	private String agencyUserPassword;
	private String agentUserPassword;
	private String agentAdminPassword;
	private String customerAdminPassword;

	private String url;

	private String userName;

	private String branchUserName;

	private String adminUserName;

	private String password;

	private String adminPassword;
	
	@Autowired
	private Environment env;
	
	@Value("${Customer.portal.url}")
	private String customerPortalUrl;

	@Value("${Agent.portal.url}")
	private String agentPortalUrl;

	@Value("${Customer.portal.user.admin.name}")
	private String customerPortalAdmin;

	@Value("${Customer.portal.user.admin.password}")
	private String customerPortalAdminPass;

	@Value("${Customer.portal.user.name}")
	private String customerPortalUser;

	@Value("${Customer.portal.user.password}")
	private String customerUserPass;

	@Value("${Agent.portal.user.admin.name}")
	private String agentPortalAdminUser;

	@Value("${Agent.portal.user.admin.password}")
	private String agentPortalAdminPass;

	@Value("${Customer.portal.user.name2}")
	private String customerPortalUser2;

	public String getCustomerUserName() {
		return customerUserName;
	}

	public void setCustomerUserName(String customerUserName) {
		this.customerUserName = customerUserName;
	}

/*	public void setAgencyUserName(String agencyUserName) {
		this.agencyUserName = agencyUserName;
	}*/



/*	public void setAgentUserName(String agentUserName) {
		this.agentUserName = agentUserName;
	}*/

	public String getAgentAdminUser() {
		return agentAdminUser;
	}

	public void setAgentAdminUser(String agentAdminUser) {
		this.agentAdminUser = agentAdminUser;
	}

	public String getCustomerAdminUser() {
		return customerAdminUser;
	}

	public void setCustomerAdminUser(String customerAdminUser) {
		this.customerAdminUser = customerAdminUser;
	}

	public String getCustomerUserPassword() {
		return customerUserPassword;
	}

	public void setCustomerUserPassword(String customerUserPassword) {
		this.customerUserPassword = customerUserPassword;
	}

	public String getAgencyUserPassword() {
		return agencyUserPassword;
	}

	public void setAgencyUserPassword(String agencyUserPassword) {
		this.agencyUserPassword = agencyUserPassword;
	}

	public String getAgentUserPassword() {
		return agentUserPassword;
	}

	public void setAgentUserPassword(String agentUserPassword) {
		this.agentUserPassword = agentUserPassword;
	}

	public String getAgentAdminPassword() {
		return agentAdminPassword;
	}

	public void setAgentAdminPassword(String agentAdminPassword) {
		this.agentAdminPassword = agentAdminPassword;
	}

	public String getCustomerAdminPassword() {
		return customerAdminPassword;
	}

	public void setCustomerAdminPassword(String customerAdminPassword) {
		this.customerAdminPassword = customerAdminPassword;
	}








/*	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}*/

	public String getUserName() {
		return userName;
	}

/*	public void setUserName(String userName) {
		this.userName = userName;
	}
*/


/*	public void setUrl(String url) {
		this.url = url;
	}*/



/*	public void setPassword(String password) {
		this.password = password;
	}*/

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
