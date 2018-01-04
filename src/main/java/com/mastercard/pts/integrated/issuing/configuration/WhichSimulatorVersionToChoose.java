package com.mastercard.pts.integrated.issuing.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WhichSimulatorVersionToChoose {

	//ConnectionStringForVTS
	@Value("${simulator.mas.version}")
	private String masVersion; 

	@Value("${simulator.mdfs.version}")
	private String mdfsVersion; 
	
	@Value("${simulator.mcps.version}")
	private String mcpsVersion; 
	
	public String getMasVersion() {
		return masVersion;
	}

	public void setMasVersion(String masVersion) {
		this.masVersion = masVersion;
	}

	public String getMdfsVersion() {
		return mdfsVersion;
	}

	public void setMdfsVersion(String mdfsVersion) {
		this.mdfsVersion = mdfsVersion;
	}

	public String getMcpsVersion() {
		return mcpsVersion;
	}

	public void setMcpsVersion(String mcpsVersion) {
		this.mcpsVersion = mcpsVersion;
	}

	@Override
	public String toString() {
		return "WhichSimulatorVersionToChoose [masVersion=" + masVersion + ", mdfsVersion=" + mdfsVersion + ", mcpsVersion=" + mcpsVersion + "]";
	}
}
