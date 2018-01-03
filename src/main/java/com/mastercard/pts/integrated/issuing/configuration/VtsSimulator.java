package com.mastercard.pts.integrated.issuing.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class VtsSimulator {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(VtsSimulator.class);

	//ConnectionStringForVTS
	@Value("${simulator.vts.port}")
	private String port; 

	@Value("${simulator.vts.ipaddress}")
	private String ipAddress; 

	public String getPort() {
		return port;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	@Override
	public String toString() {
		return "VtsSimulatorConfiguration [port=" + port + ", ipAddress=" + ipAddress + "]";
	}
}
