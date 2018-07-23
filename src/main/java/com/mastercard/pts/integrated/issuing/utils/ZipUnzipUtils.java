package com.mastercard.pts.integrated.issuing.utils;

import java.io.File;
import java.util.zip.ZipException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceBinPage;

import net.lingala.zip4j.core.ZipFile;

@Component
public class ZipUnzipUtils {

	@Autowired
	Environment env;

	@Autowired
	DateUtils dateUtils;

	final static Logger logger = LoggerFactory.getLogger(DeviceBinPage.class);

	public static void unZip(File filename, String destination, String Password)
			throws ZipException, net.lingala.zip4j.exception.ZipException {
		ZipFile zipFile = new ZipFile(filename);
		if (zipFile.isEncrypted()) {
			zipFile.setPassword(Password);
		}
		zipFile.extractAll(destination);
	}

	/**
	 * Implement this function to un-zip the encrypted.
	 * 
	 */
	public void unZipTheFile(String filename, String password, String destination) {

		try {
			ZipFile zipFile = new ZipFile(filename);

			if (zipFile.isEncrypted()) {
				zipFile.setPassword(password);
				zipFile.extractAll(destination);
			}
		} catch (net.lingala.zip4j.exception.ZipException e) {
			logger.info(": Exception in Unziping the file", e);
		}
	}

	/**
	 * Implement this function to get password for download report.
	 * 
	 */
	public String getReportPassword() {
		return org.apache.commons.lang.StringUtils.substring(MapUtils.fnGetInputDataFromMap("UserId"), 0, 4)
				+ org.apache.commons.lang.StringUtils.substring(DateUtils.getDateDDMMYYFormat(), 0, 4);

	}

}
