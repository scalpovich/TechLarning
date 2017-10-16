package com.mastercard.pts.integrated.issuing.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import com.mastercard.testing.mtaf.ui.configuration.MTAFWebToolsConfiguration;

@Configuration
@ComponentScan(basePackages = { "com.mastercard.pts.integrated.issuing" })
@PropertySources({
		@PropertySource(value = "/config/${environment}/environment.properties", ignoreResourceNotFound = false),
		@PropertySource(value = "/config/${environment}/user.properties", ignoreResourceNotFound = false),
		@PropertySource(value = "/config/${environment}/test.properties", ignoreResourceNotFound = false),
		@PropertySource(value = "/config/${environment}/apitest.properties", ignoreResourceNotFound = false),
		@PropertySource(value = "/log4j.properties", ignoreResourceNotFound = false) })
@Import({MTAFWebToolsConfiguration.class,Portal.class})
@EnableAspectJAutoProxy
public class TestAnnotationConfigurationContext {
//
//	@Autowired
//	private Environment env;
//	private static final Logger logger = LoggerFactory
//			.getLogger(TestAnnotationConfigurationContext.class);
//
//	/**
//	 * Created instance of Oracle DataBase and has passed this in MdesUtils For
//	 * more See JDBCTemplate of Spring based framework
//	 * 
//	 * @return
//	 * @throws MPTSException
//	 */
//	@Bean(name = "oracleInstance")
//	public JDBCTemplateImpl oracleInstance() throws MPTSException {
//
//		try {
//			return new JDBCTemplateImpl(
//					env.getProperty("bdd.jdbc.tools.db.driverClassName"),
//					// dbURL,
//					env.getProperty("bdd.jdbc.tools.db.connection.url"),
//					(env.getProperty("bdd.jdbc.tools.db.user")),
//					(env.getProperty("bdd.jdbc.tools.db.password")));
//		} catch (Exception e) {
//			logger.debug("DB connection error", e);
//
//			throw new MPTSException("Error while creating Db Objects");
//		}
//	}
//
//	/**
//	 * created object of mDESUtils where we having common function related to
//	 * oracle database
//	 * 
//	 * @return
//	 * @throws MPTSException
//	 */
//	@Bean(name = "mDESUtils")
//	@DependsOn("oracleInstance")
//	public DatabaseUtils mDESUtils() throws MPTSException {
//		return new DatabaseUtils(oracleInstance());
//	}
//
//	@Bean
//	public Path tempDirectory() {
//		Path temp;
//		try {
//			temp = Files.createTempDirectory("issuingTests");
//		} catch (Exception e) {
//			throw Throwables.propagate(e);
//		}
//		logger.info("Temp directory path: {}", temp);
//		return temp;
//	}
//
//	@Bean
//	@Qualifier(Portal.TYPE_CUSTOMER)
//	public Portal customerPortal() {
//		return getPortal(Portal.TYPE_CUSTOMER);
//	}
//
//	@Bean
//	@Qualifier(Portal.TYPE_AGENT)
//	public Portal agentPortal() {
//		return getPortal(Portal.TYPE_AGENT);
//	}
//
//	@Bean
//	@Qualifier(Portal.TYPE_CARDHOLDER)
//	public Portal cardholderPortal() {
//		return getPortal(Portal.TYPE_CARDHOLDER);
//	}
//
//	@Bean
//	@Qualifier(Portal.TYPE_COLLECT)
//	public Portal collectionPortal() {
//		return getPortal(Portal.TYPE_COLLECT);
//	}
//
//	private Portal getPortal(String portalType) {
//		Portal portal = new Portal();
//		portal.setUrl(getPortalProperty(portalType, "url"));
//		if (portalType.equalsIgnoreCase(Portal.TYPE_AGENT)) {
//			portal.setAdminUserName(getPortalProperty(portalType,
//					"user.admin.name"));
//			portal.setAgencyUserName(getPortalProperty(portalType,
//					"user.agency.name"));
//			portal.setAgentUserName(getPortalProperty(portalType,
//					"user.agent.name"));
//		} else if (portalType.equalsIgnoreCase(Portal.TYPE_CUSTOMER)) {
//			portal.setAdminUserName(getPortalProperty(portalType,
//					"user.admin.name"));
//			portal.setUserName(getPortalProperty(portalType, "user.name"));
//		} else
//			portal.setUserName(getPortalProperty(portalType, "user.name"));
//		String password;
//		try {
//			password = EncryptUtils.decrypt(getPortalProperty(portalType,
//					"user.password"));
//		} catch (Exception e) {
//			logger.error("Fail to decrypt password for user {}",
//					portal.getUserName());
//			throw Throwables.propagate(e);
//		}
//		portal.setPassword(password);
//		return portal;
//	}
//
//	private String getPortalProperty(String portalType, String propertyName) {
//		String fullProperty = String.format("portal.%s.%s", portalType,
//				propertyName);
//		return env.getProperty(fullProperty);
//	}
}
