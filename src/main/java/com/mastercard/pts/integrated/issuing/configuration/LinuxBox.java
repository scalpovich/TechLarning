package com.mastercard.pts.integrated.issuing.configuration;

import java.io.File;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.common.base.Throwables;
import com.mastercard.pts.integrated.issuing.utils.LinuxUtils;
import com.mastercard.pts.integrated.issuing.utils.LinuxUtils.RemoteConnectionDetails;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.testing.utils.encryption.EncryptUtils;

@Component
public class LinuxBox implements RemoteConnectionDetails {


	@Value("${devcloud.server.ip}")
	private String hostName;

	@Value("${devcloud.server.port}")
	private int port;

	@Value("${devcloud.server.username}")
	private String userName;

	private String password;

	public File download(String remoteSource, String localDestination) {
		logger.info("Download {} -> {}", remoteSource, localDestination);
		try {
			LinuxUtils.download(this, remoteSource, localDestination);
		} catch (Exception e) {
			MiscUtils.propagate(e);
		}
		return Paths.get(localDestination).resolve(Paths.get(remoteSource).getFileName()).toFile();
	}
	
	public File downloadByLookUpForPartialFileName(String lokupForFile, String localDestination, String whatAreWeLookingFile) {
		logger.info("Download {} -> {}", lokupForFile, localDestination);
		String fileName = null;
		String[] temp = null;
		try {
			fileName = LinuxUtils.getFileAbsolutePath(this, lokupForFile);
			temp = fileName.split("\n");
			for(int i = 0; i < temp.length; i ++)
			{
				if(temp[i].toUpperCase().contains(whatAreWeLookingFile))
				{
					LinuxUtils.download(this, temp[i], localDestination);
					return Paths.get(localDestination).resolve(Paths.get(temp[i]).getFileName()).toFile();
				}
			}
		} catch (Exception e) {
			throw MiscUtils.propagate(e);
		}
		return null;
	}
	
	public void upload(String localSource, String remoteDir){
		logger.info("Upload {} -> {}", localSource);
		try{
		LinuxUtils.upload(this, localSource, remoteDir);
		} catch (Exception e){
			MiscUtils.propagate(e);
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
		return "LinuxBoxConfiguration [hostName=" + hostName + ", port=" + port + ", userName=" + userName + "]";
	}
}
