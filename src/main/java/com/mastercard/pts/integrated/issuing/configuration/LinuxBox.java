package com.mastercard.pts.integrated.issuing.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.common.base.Throwables;
import com.mastercard.pts.integrated.issuing.utils.LinuxUtils;
import com.mastercard.pts.integrated.issuing.utils.LinuxUtils.RemoteConnectionDetails;

@Component
public class LinuxBox implements RemoteConnectionDetails {

	private static final Logger logger = LoggerFactory
			.getLogger(LinuxBox.class);

	@Value("${devcloud.server.ip}")
	private String hostName;

	@Value("${devcloud.server.port}")
	private int port;

	@Value("${devcloud.server.username}")
	private String userName;

	private String password;

	public void upload(String localSource, String remoteDir) {
		logger.info("Upload {} -> {}", localSource);
		try {
			LinuxUtils.upload(this, localSource, remoteDir);
		} catch (Exception e) {
			throw Throwables.propagate(e);
		}
	}

	@Value("${devcloud.server.password}")
	public void decryptAndSetPassword(String password) {
		try {
			setPassword(password);
		} catch (Exception e) {
			throw Throwables.propagate(e);
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	@Override
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "LinuxBoxConfiguration [hostName=" + hostName + ", port=" + port
				+ ", userName=" + userName + "]";
	}
}
