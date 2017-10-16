package com.mastercard.pts.integrated.issuing.utils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Throwables;
import com.mastercard.pts.integrated.issuing.configuration.LinuxBox;

@Component
public class UploadFile {

	private static final Logger logger = LoggerFactory
			.getLogger(UploadFile.class);

	@Autowired
	public LinuxBox linuxBox;

	public void createTransactionUploadFileMC(FileCreation fileCreation,
			String remoteDir) {

		File file = new File(fileCreation.getFilename());
		try (PrintWriter writer = new PrintWriter(file)) {
			writer.println(fileCreation.getHeader());
			writer.println(fileCreation.getTransactionLine());
			writer.print(fileCreation.getFooter());

		} catch (IOException e) {
			logger.error("Fail to create page object: {}", e);
			throw Throwables.propagate(e);
		}
		linuxBox.upload(file.getPath(), remoteDir);
	}

	public void createTransactionUploadFile(FileCreation fileCreation) {

		File file = new File(fileCreation.getFilename());
		String remoteDir = Constants.UPLOAD_FILE_PATH;

		try (PrintWriter writer = new PrintWriter(file)) {
			writer.println(fileCreation.getHeader());
			writer.println(fileCreation.getTransactionLine());
			writer.print(fileCreation.getFooter());
		} catch (IOException e) {
			logger.error("Fail to create page object: {}", e);
			throw Throwables.propagate(e);
		}
		linuxBox.upload(file.getPath(), remoteDir);
	}

}
