package com.mastercard.pts.integrated.issuing.configuration;

import java.nio.file.Files;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.testing.mtaf.ui.configuration.MTAFWebToolsConfiguration;
import com.mastercard.testing.utils.encryption.EncryptUtils;

@Configuration
@ComponentScan(basePackages = { "com.mastercard.pts.integrated.issuing" })
@PropertySource({ "config/test.properties", "config/${env}/environment.properties" })
@Import(MTAFWebToolsConfiguration.class)
@EnableAspectJAutoProxy
public class TestConfiguration {
	
	private static final Logger logger = LoggerFactory.getLogger(TestConfiguration.class);

	@Autowired
	private Environment environment;
	
	@Bean
	public Path tempDirectory() {
		Path temp = null;
		try {
			temp = Files.createTempDirectory(new DateUtils().getDateyyyyMMdd()+ "_IssuingTests_");
		} catch (Exception e) {
			MiscUtils.propagate(e);
		}
		logger.info("Temp directory path: {}", temp);
		return temp;
	}
	
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
	
	private Portal getPortal(String portalType) {
		Portal portal = new Portal();
		portal.setUrl(getPortalProperty(portalType, "url"));
		if (portalType.equalsIgnoreCase(Portal.TYPE_AGENT)){
			portal.setAdminUserName(getPortalProperty(portalType, "user.admin.name"));
			portal.setAgencyUserName(getPortalProperty(portalType, "user.agency.name"));
			portal.setBranchUserName(getPortalProperty(portalType, "user.branch.name"));
			portal.setAgentUserName(getPortalProperty(portalType, "user.agent.name"));
		}
		else{
			portal.setUserName(getPortalProperty(portalType, "user.name"));
			portal.setAdminUserName(getPortalProperty(portalType, "user.admin.name"));
		}
		String password;
		String adminPassword;
		try {
			password = EncryptUtils.decrypt(getPortalProperty(portalType, "user.password"));
			adminPassword= EncryptUtils.decrypt(getPortalProperty(portalType, "user.admin.password"));
		} catch (Exception e) {
			logger.error("Fail to decrypt password for user {}", portal.getUserName());
			MiscUtils.propagate(e);
			return null;
		}
		portal.setPassword(password);
		portal.setAdminPassword(adminPassword);
		return portal;
	}
	
	private String getPortalProperty(String portalType, String propertyName) {
		String fullProperty = String.format("portal.%s.%s", portalType, propertyName);
		return environment.getProperty(fullProperty);
	}
}
