package com.mastercard.pts.integrated.issuing.utils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.common.base.Throwables;
import com.mastercard.pts.integrated.issuing.configuration.LinuxBox;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;

@Component
public class UploadFile extends SimulatorUtilities{

	private static final Logger logger = LoggerFactory.getLogger(UploadFile.class);

	@Autowired
	private Path tempDirectory;

	@Autowired
	private LinuxBox linuxBox;

	@Value("${linux.folder.path}")
	private String folderPath;
	
	@Value("${linux.ipm_upload.path}")
	private String ipmUploadPath;
	
	@Value("${linux.pinoffset_upload.path}")
	private String pinOffsetFileUploadPath;
	
public void createTransactionUploadFileMC(FileCreation fileCreation,String remoteDir) {

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

	public void createTransactionUploadFile(FileCreation fileCreation){
		
		File file = tempDirectory.resolve(fileCreation.getFilename()).toFile();
		String remoteDir = ConstantData.TRANSACTION_UPLOAD_FILE_PATH;

		try(PrintWriter writer = new PrintWriter(file)){
			writer.println(fileCreation.getHeader());
			writer.println(fileCreation.getTransactionLine());
			writer.print(fileCreation.getFooter());
		} catch (IOException e){
			logger.error("Fail to create page object: {}", e);
			throw Throwables.propagate(e);
		}
		
		linuxBox.upload(file.getPath(), remoteDir);
	}
	
	public void uploadIpmFile(File fileName){
		String remoteDir = folderPath+ipmUploadPath;
		linuxBox.upload(getTempDirectoryLocationForSimulatorResults() + "\\" + fileName, remoteDir);		
	}
	
	public void uploadPinOffsetFile(File fileName){
		String remoteDir = folderPath+pinOffsetFileUploadPath;
		linuxBox.upload(fileName.toString(), remoteDir);	
	}
	
}
