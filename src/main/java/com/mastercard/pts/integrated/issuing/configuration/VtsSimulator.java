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
	@Value("${simulator.vts.host.port}")
	private String hostPort; 

	@Value("${simulator.vts.host.ipaddress}")
	private String hostIpAddress; 
	
	@Value("${simulator.vts.vts.ipaddress}")
	private String vtsIpAddress; 

	public String getHostPort() {
		return hostPort;
	}

	public void setHostPort(String hostPort) {
		this.hostPort = hostPort;
	}

	public String getHostIpAddress() {
		return hostIpAddress;
	}

	public void setHostIpAddress(String hostIpAddress) {
		this.hostIpAddress = hostIpAddress;
	}

	public String getVtsIpAddress() {
		return vtsIpAddress;
	}

	public void setVtsIpAddress(String vtsIpAddress) {
		this.vtsIpAddress = vtsIpAddress;
	}

	@Override
	public String toString() {
		return "VtsSimulatorConfiguration [hostPort=" + hostPort + ", hostIpAddress=" + hostIpAddress + " vtsIpAddress=" + vtsIpAddress + "]";
	}
}
