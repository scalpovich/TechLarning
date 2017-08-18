package com.mastercard.pts.integrated.issuing.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MasSimulator {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(MasSimulator.class);

	//ConnectionStringForMAS
	@Value("${simulator.mas.port}")
	private String port; 

	@Value("${simulator.mas.ipaddress}")
	private String ipAddress; 

	public String getPort() {
		return port;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	@Override
	public String toString() {
		return "MasSimulatorConfiguration [port=" + port + ", ipAddress=" + ipAddress + "]";
	}
}
