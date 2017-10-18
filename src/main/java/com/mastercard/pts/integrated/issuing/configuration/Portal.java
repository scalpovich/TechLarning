package com.mastercard.pts.integrated.issuing.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import com.google.common.base.Throwables;

public class Portal {

	final Logger logger = LoggerFactory.getLogger(Portal.class);

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
	private String user;

	private String url;
	private String userName;
	private String adminUserName;
	private String password;
	private String branchUserName;
	private String adminPassword;

	public static final String TYPE_CUSTOMER = "customer";
	public static final String TYPE_AGENT = "agent";
	public static final String TYPE_COLLECT = "collect";
	public static final String TYPE_CARDHOLDER = "cardholder";

	@Autowired
	private Environment env;
	
	@Bean
	@Qualifier(Portal.TYPE_CUSTOMER)
	public Portal customerPortal() {
		return getPortal(Portal.TYPE_CUSTOMER);
	}

	@Bean
	@Qualifier(Portal.TYPE_AGENT)
	public Portal agentPortal() {
		return getPortal(Portal.TYPE_AGENT);
	}

	@Bean
	@Qualifier(Portal.TYPE_CARDHOLDER)
	public Portal cardholderPortal() {
		return getPortal(Portal.TYPE_CARDHOLDER);
	}

	@Bean
	@Qualifier(Portal.TYPE_COLLECT)
	public Portal collectionPortal() {
		return getPortal(Portal.TYPE_COLLECT);
	}

	
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

	@Value("${portal.agent.user.admin.password}")
	private String agentPortalAdminPass;

	@Value("${portal.agent.user.agency.name}")
	private String agentPortalAgencyUser;

	@Value("${portal.agent.user.agency.password}")
	private String agentPortalAgencyPass;

	@Value("${portal.agent.user.agent.name}")
	private String agentPortalAgent;

	@Value("${portal.agent.user.agent.password}")
	private String agentPortalAgentPass;

	@Value("${Customer.portal.user.name2}")
	private String customerPortalUser2;

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


	/*
	 * public String getUrl() { return customerPortalUrl; }
	 * 
	 * public void setUrl(String url) { this.customerPortalUrl = url; }
	 */
	public String getCustomerUserName() {
		return customerUserName;
	}

	public void setCustomerUserName(String customerUserName) {
		this.customerUserName = customerUserName;
	}

	public void setAgencyUserName(String agencyUserName) {
		this.agencyUserName = agencyUserName;
	}

	public String getAgentUserName() {
		return agentUserName;
	}

	public void setAgentUserName(String agentUserName) {
		this.agentUserName = agentUserName;
	}

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

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getAgencyUserName() {
		return agencyUserName;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
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
public static String getTypeCustomer() {
		return TYPE_CUSTOMER;
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
	private Portal getPortal(String portalType) {
		Portal portal = new Portal();
		try {
			if (portalType.equalsIgnoreCase(Portal.TYPE_AGENT)) {
				portal.setUrl(agentPortalUrl);
				portal.setAgentAdminUser(agentPortalAdminUser);
				portal.setAgencyUserName(agentPortalAgencyUser);
				portal.setAgentUserName(agentPortalAgent);
				portal.setAgentAdminPassword(agentPortalAdminPass);
				portal.setAgencyUserPassword(agentPortalAgencyPass);
				portal.setAgentUserPassword(agentPortalAgentPass);

			} else if (portalType.equalsIgnoreCase(Portal.TYPE_CUSTOMER)) {
				portal.setUrl(customerPortalUrl);
				portal.setCustomerAdminUser(customerPortalAdmin);
				portal.setCustomerUserName(customerPortalUser);
				portal.setCustomerAdminPassword(customerPortalAdminPass);
				portal.setCustomerUserPassword(customerUserPass);

			}
		} catch (Exception e) {
			logger.error("Fail to decrypt password for user {}");
			throw Throwables.propagate(e);
		}
		return portal;
	}


	public static String getTypeAgent() {
		return TYPE_AGENT;
	}

	public static String getTypeCollect() {
		return TYPE_COLLECT;
	}

	public static String getTypeCardholder() {
		return TYPE_CARDHOLDER;
	}

	public Portal userDataProvider() {
		Portal portal = new Portal();
		portal.setUser(customerPortalUser2);
		return portal;

	}
}
