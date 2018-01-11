package com.mastercard.pts.integrated.issuing.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MdfsSimulator {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(MdfsSimulator.class);

	//ConnectionStringForMAS
	@Value("${simulator.mdfs.port}")
	private String port; 

	@Value("${simulator.mdfs.ipaddress}")
	private String ipAddress; 

	public String getPort() {
		return port;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	@Override
	public String toString() {
		return "MdfsSimulatorConfiguration [port=" + port + ", ipAddress=" + ipAddress + "]";
	}
}
