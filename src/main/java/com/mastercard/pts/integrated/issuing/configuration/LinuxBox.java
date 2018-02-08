package com.mastercard.pts.integrated.issuing.configuration;

import java.io.File;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.LinuxUtils;
import com.mastercard.pts.integrated.issuing.utils.LinuxUtils.RemoteConnectionDetails;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.testing.utils.encryption.EncryptUtils;

@Component
public class LinuxBox implements RemoteConnectionDetails {

	private static final Logger logger = LoggerFactory.getLogger(LinuxBox.class);

	@Value("${linux.host.name}")
	private String hostName;

	@Value("${linux.port.number}")
	private int port;

	@Value("${linux.user.name}")
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
		logger.info("Download {} -> {} at folder", lokupForFile, localDestination);
		String fileName = null;
		String[] temp = null;
		try {
			fileName = LinuxUtils.getFileAbsolutePath(this, lokupForFile);
			MiscUtils.reportToConsole("49 @ fileName " + fileName);
			temp = fileName.split("\n");
			MiscUtils.reportToConsole("51");
			for (int i = 0; i < temp.length; i++) {
				MiscUtils.reportToConsole("53");
				if (temp[i].contains(whatAreWeLookingFile)) {
					MiscUtils.reportToConsole("55");
					LinuxUtils.download(this, temp[i], localDestination);
					logger.info("return path in downloadByLookUpForPartialFileName {} -->", Paths.get(localDestination).resolve(Paths.get(temp[i]).getFileName()).toFile());
					MiscUtils.reportToConsole("return path in downloadByLookUpForPartialFileName {} -->", Paths.get(localDestination).resolve(Paths.get(temp[i]).getFileName()).toFile().toString());
					return Paths.get(localDestination).resolve(Paths.get(temp[i]).getFileName()).toFile();
				}
			}
		} catch (Exception e) {
			throw MiscUtils.propagate(e);
		}
		return null;
	}

	public void upload(String localSource, String remoteDir) {
		logger.info("Upload {} -> {}", localSource);
		try {
			LinuxUtils.upload(this, localSource, remoteDir);
		} catch (Exception e) {
			MiscUtils.reportToConsole("upload Exception :  " + e.toString());
			logger.info(ConstantData.EXCEPTION +" {} " +  e.getMessage());
			throw MiscUtils.propagate(e);
		}
	}

	@Value("${linux.user.password}")
	public void decryptAndSetPassword(String password) {
		try {
			setPassword(EncryptUtils.decrypt(password));
		} catch (Exception e) {
			MiscUtils.propagate(e);
		}
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getHostName() {
		logger.info("Linux hostName {} -> {}", hostName);
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	@Override
	public int getPort() {
		logger.info("Linux port {} -> {}", port);
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public String getUserName() {
		logger.info("Linux userName {} -> {}", userName);
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
