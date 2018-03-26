package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceProductionBatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PinGenerationBatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PreProductionBatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ProcessBatches;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.BatchProcessingPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceProductionPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.PinGenerationBatchPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.PreProductionBatchPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.FileUtils;
import com.mastercard.pts.integrated.issuing.utils.LinuxUtils;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class BatchProcessFlows extends MenuFlows {

	@Autowired
	private Navigator navigator;

	@Autowired
	private ProcessBatches processBatches;

	final Logger loggers = LoggerFactory.getLogger(this.getClass());

	public String processUploadBatches(String batchName, String fileName) {
		processBatch = navigator.navigateToPage(BatchProcessingPage.class);
		processBatch.processUploadBatch(batchName);
		processBatch.checkAndSumbitFile(fileName);
		return processBatch.retrieveJobID(fileName);
	}

	public void processDownloadloadBatches(String batchName) {
		processBatch = navigator.navigateToPage(BatchProcessingPage.class);
		processBatch.processDownloadBatch(batchName);
	}

	public void processCustomerMasterDownloadBatch(String batchName, String productType, String extType) {
		processBatch = navigator.navigateToPage(BatchProcessingPage.class);
		processBatch.processCustomerMasterDownload(batchName, productType, extType);
		processBatches.setGeneratedFilename(processBatch.verifyFileProcessGetFilename());
	}

	public void processTxnTypeMasterBatch(String batchName, String productType) {
		processBatch = navigator.navigateToPage(BatchProcessingPage.class);
		processBatch.processTransactionTypeMaster(batchName, productType);
		processBatches.setGeneratedFilename(processBatch.verifyFileProcessGetFilename());
	}

	public void processEmpMasterUserBatch(String batchName, String entityType, String extType) {
		processBatch = navigator.navigateToPage(BatchProcessingPage.class);
		processBatch.processEmpMasterUser(batchName, entityType, extType);
		processBatches.setGeneratedFilename(processBatch.verifyFileProcessGetFilename());
	}

	public String copyAmlockFileFromRemoteToLocal() {

		String absoluteDestPath = null;

		try {
			Session session = LinuxUtils.connectSession(env.getProperty("unix.server.username"), env.getProperty("unix.server.ip"), env.getProperty("unix.server.password"), 2222);

			absoluteDestPath = System.getProperty("user.dir") + env.getProperty("unix.server.relativepath") + processBatches.getGeneratedFilename();

			LinuxUtils.copyFilesfromServer(session, env.getProperty("unix.server.copycommand"), env.getProperty("unix.localmachine.relativepath") + processBatches.getGeneratedFilename(),
					absoluteDestPath);
			Assert.assertTrue(true);
		} catch (IOException | JSchException e) {
			loggers.error("File not Found", e);
			Assert.fail();
		}

		return absoluteDestPath;
	}

	public void readAndValidateFilename(String batchName) throws IOException {
		try {
			File fileName;
			String absoluteDestPath;

			absoluteDestPath = copyAmlockFileFromRemoteToLocal();

			String firstcolumn = null;
			loggers.info("absolute Destination Path received");

			firstcolumn = FileUtils.returnFirstColumn(batchName);

			fileName = new File(absoluteDestPath);
			if (firstcolumn != null)
				FileUtils.csvReadFileAndValidate(fileName, firstcolumn);
			loggers.info("Filename and firstcolumn to verified successfully");
		} catch (Exception e) {
			loggers.error("Error in copying file");
		}
	}

	public void processSystemInternalBatches(String batchName) {
		processBatch = navigator.navigateToPage(BatchProcessingPage.class);
		processBatch.processSystemInternalBatch(batchName);
	}

	public void processPreProductionBatch(PreProductionBatch batch) {
		PreProductionBatchPage page = navigator.navigateToPage(PreProductionBatchPage.class);
		page.processPreProductionBatch1(batch);
	}

	public void processPreProductionBatchNewDevice(PreProductionBatch batch) {
		PreProductionBatchPage page = navigator.navigateToPage(PreProductionBatchPage.class);
		page.processPreProductionBatchNewDevice(batch);
	}

	public void processPreProductionBatchNewApplication(PreProductionBatch batch) {
		PreProductionBatchPage page = navigator.navigateToPage(PreProductionBatchPage.class);
		page.processPreProductionBatchNewApplication(batch);
	}
	public void processPreProductionBatchNewApplicationFileUpload(PreProductionBatch batch) {
		PreProductionBatchPage page = navigator.navigateToPage(PreProductionBatchPage.class);
		page.processPreProductionBatchNewApplicationForFileUpload(batch);
	}
	
	public void processDeviceProductionBatch(DeviceProductionBatch batch) {
		deviceProductionPage = navigator.navigateToPage(DeviceProductionPage.class);
		deviceProductionPage.processDeviceProductionBatch(batch);
	}

	public void processDeviceProductionBatchAll(DeviceProductionBatch batch) {
		deviceProductionPage = navigator.navigateToPage(DeviceProductionPage.class);
		deviceProductionPage.processDeviceProductionBatchForAll(batch);
	}
	
	public void processDeviceProductionBatchAllForFileUpload(DeviceProductionBatch batch) {
		deviceProductionPage = navigator.navigateToPage(DeviceProductionPage.class);
		deviceProductionPage.processDeviceProductionBatchForAllForFileUpload(batch);
	}

	public void processDeviceProductionBatchNewDevice(DeviceProductionBatch batch) {
		deviceProductionPage = navigator.navigateToPage(DeviceProductionPage.class);
		deviceProductionPage.processDeviceProductionBatchNewDevice(batch);
	}

	public void processDeviceProductionBatchNewApplication(DeviceProductionBatch batch) {
		deviceProductionPage = navigator.navigateToPage(DeviceProductionPage.class);
		deviceProductionPage.processDeviceProductionBatchNewApplication(batch);
	}

	public void processPinProductionBatchNewDevice(PinGenerationBatch batch) {
		PinGenerationBatchPage page = navigator.navigateToPage(PinGenerationBatchPage.class);
		page.processPinProductionBatchNewDevice(batch);
	}

	public void processPinProductionBatchNewApplication(PinGenerationBatch batch) {
		PinGenerationBatchPage page = navigator.navigateToPage(PinGenerationBatchPage.class);
		page.processPinProductionBatchNewApplication(batch);
	}

}