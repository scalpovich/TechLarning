package com.mastercard.pts.integrated.issuing.utils.restapi;

import java.io.FileInputStream;
import java.security.KeyStore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.RestAssuredConfig;
import com.jayway.restassured.config.SSLConfig;
import com.mastercard.pts.integrated.issuing.steps.AbstractBaseSteps;

@Component
public class RestAssuredConfiguration extends AbstractBaseSteps {

	static final String STAGEENVIROMENT = "stage";
	static final String KEYSTOREFILEPATH = "src\\main\\resources\\certs\\104181-stage-pdt-api-mi-mastercard-com-desktop.p12";
	String baseUrl;
	final Logger logger = LoggerFactory
			.getLogger(RestAssuredConfiguration.class);

	public String getbaseUrl() {
		switch (System.getProperty("APIName")) {
		case "WalletLink":
			baseUrl = env.getProperty("api.base.uri_Wallet");
			break;
		case "WalletDeLink":
			baseUrl = env.getProperty("api.base.uri_Wallet");
			break;
		case "CardActivation":
			baseUrl = env.getProperty("api.base.uri_CardActivation");
			break;
		default:
			baseUrl = env.getProperty("api.base.uri_DeviceAPI");

		}
		return baseUrl;
	}

	public RestAssuredConfig getRestAssuredConfig() {

		if (System.getProperty("environment").equalsIgnoreCase(STAGEENVIROMENT)) {
			try {
				KeyStore keyStore = null;
				SSLConfig config = null;
				FileInputStream keyStoreFile = null;
				keyStore = KeyStore.getInstance("PKCS12");
				keyStoreFile = new FileInputStream(KEYSTOREFILEPATH);
				keyStore.load(keyStoreFile, "changeit".toCharArray());

				org.apache.http.conn.ssl.SSLSocketFactory clientAuthFactory = new org.apache.http.conn.ssl.SSLSocketFactory(
						keyStore,  env.getProperty("api.keyStorePassword"));

				// set the config in rest assured
				config = new SSLConfig().with()
						.sslSocketFactory(clientAuthFactory).and()
						.allowAllHostnames();

				RestAssured.config = RestAssured.config().sslConfig(config);

			} catch (Exception ex) {
				logger.error("Exception Message :", ex);
			} finally {
			}
		}
		return RestAssured.config;
	}

}
