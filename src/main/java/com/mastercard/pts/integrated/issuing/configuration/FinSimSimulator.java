package com.mastercard.pts.integrated.issuing.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.testing.utils.encryption.EncryptUtils;

@Component
public class FinSimSimulator {
	private static final Logger logger = LoggerFactory.getLogger(FinSimSimulator.class);

	//ConnectionStringForMAS
	@Value("${simulator.finsim.port}")
	private String port; 

	@Value("${simulator.finsim.ipaddress}")
	private String ipAddress; 
	
	@Value("${simulator.finsim.password}")
	private String password; 
	
	@Value("${simulator.finsim.pinkey}")
	public  String pinKey; 
	
	@Value("${simulator.finsim.decimalization.value}")
	private String decimalizationValue; 
	
	@Value("${simulator.finsim.password}")
	public void decryptAndSetPassword(String password) {
		try {
			setPassword(EncryptUtils.decrypt(password));
		} catch (Exception e) {
			MiscUtils.propagate(e);
		}
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}

	public String getPort() {
		return port;
	}

	public String getIpAddress() {
		return ipAddress;
	}

//	@Value("${simulator.finsim.pinkey}")
//	public void setPinKey(String pinKey) {
//		this.pinKey = pinKey;
//	}
//
//	@Value("${simulator.finsim.decimalization.value}")
//	public void setDecimalizationValue(String decimalizationValue) {
//		this.decimalizationValue = decimalizationValue;
//	}

	public String getPinKey() {
		return pinKey;
	}

	public String getDecimalizationValue() {
		return decimalizationValue;
	}
	
	public static Logger getLogger() {
		return logger;
	}

	@Override
	public String toString() {
		return "FinSimSimulatorConfiguration [port=" + port + ", ipAddress=" + ipAddress + "]";
	}
}
