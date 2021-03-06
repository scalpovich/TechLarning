package com.mastercard.pts.integrated.issuing.configuration;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.FileUtils;
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

	@Value("${linux.folder.path}")
	private String folderPath;

	private String password;
	
	@Autowired
	TestContext context;

	public File download(String remoteSource, String localDestination) {
		logger.info("Download {} -> {}", remoteSource, localDestination);
		try {
			LinuxUtils.download(this, remoteSource, localDestination);
		} catch (Exception e) {
			MiscUtils.propagate(e);
		}
		return Paths.get(localDestination).resolve(Paths.get(remoteSource).getFileName()).toFile();
	}

	public void downloadFileViaScp(String remoteSource, String localDestination) {
		logger.info("Download {} -> {}", remoteSource, localDestination);
		try {
			LinuxUtils.downloadFileViaScp(this, remoteSource, localDestination);
		} catch (Exception e) {
			MiscUtils.propagate(e);
		}
	}

	public File downloadByLookUpForPartialFileName(String lokupForFile, String localDestination, String whatAreWeLookingFile) {
		logger.info("Download {} -> {} at folder", lokupForFile, localDestination);
		String fileName = null;
		String[] temp = null;
		try {
			fileName = LinuxUtils.getFileAbsolutePath(this, lokupForFile);
			MiscUtils.reportToConsole("fileName : " + fileName);
			temp = fileName.split("\n");
			for (int i = 0; i < temp.length; i++) {
				if (temp[i].contains(whatAreWeLookingFile)) {
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

	public String ListFileOffSetAndEmbossing(String path, String lookupForFile) {
		// File folder = new File(path);
		File[] listOfFiles = FileUtils.getLastFileName(path);
		ArrayList<File> numberOfFileSameName = new ArrayList<>();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				if (listOfFiles[i].getName().contains(lookupForFile) && !(listOfFiles[i].getName().contains("Pin")))
					numberOfFileSameName.add(listOfFiles[i]);
			} else if (listOfFiles[i].isDirectory()) {
				logger.info("Directory " + listOfFiles[i].getName());
			}
		}
		return numberOfFileSameName.get(0).getName();
	}
	
	public File downloadFileThroughSCPByPartialFileName(String lookupForFile, String localDestination, String whatAreWeLookingFile,String childFolder) {
		logger.info("Download {} -> {} at folder", lookupForFile, localDestination);
		downloadFileViaScp(folderPath + "*" + whatAreWeLookingFile + "*//"+ childFolder +"//*" + lookupForFile + "*", localDestination);
		logger.info(Paths.get(localDestination).resolve(Paths.get(localDestination + "\\" + ListFileOffSetAndEmbossing(localDestination, lookupForFile)).getFileName()).toFile().getAbsolutePath());
		context.put(CreditConstants.CSV_FILE_NAME, Paths.get(localDestination).resolve(Paths.get(localDestination + "\\" + ListFileOffSetAndEmbossing(localDestination, lookupForFile)).getFileName()).toFile().getAbsolutePath());
		return Paths.get(localDestination).resolve(Paths.get(localDestination + "\\" + ListFileOffSetAndEmbossing(localDestination, lookupForFile)).getFileName()).toFile();
	}

	public void upload(String localSource, String remoteDir) {
		logger.info("Upload {} -> {}", localSource);
		try {
			LinuxUtils.upload(this, localSource, remoteDir);
		} catch (Exception e) {
			MiscUtils.reportToConsole("upload Exception :  " + e.toString());
			logger.info(ConstantData.EXCEPTION + " {} ", e.getMessage());
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

	@Override
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