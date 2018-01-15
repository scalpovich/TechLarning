package com.mastercard.pts.integrated.issuing.workflows;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.FileUtils;
import com.mastercard.pts.integrated.issuing.utils.LinuxUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

/**
 * @author E060549
 * 
 *
 */

@Component
public class PrepaidDeviceFileEmbossingFlows extends MenuFlows {

	@Autowired
	private Navigator navigator;

	public String embossTemplateDesc, plasticCode, pictureCode, vendorName, DeviceEventBasedFeePlanCode,
			transactionLimitPlan, walletPlan, devicePlanCode;

	// One time setup for device creation
	public void createNewprepaidDevice() throws InterruptedException {
		// createCutOverProfile();
		// addNetworkMembership();
		// addtransactionRegistration();
		// addInstitutionCurrency();
		// createOffice();
		// createPlasticCode();
		// addPictureCode();
		// addDeviceBINPrepaid();
		// addMCG();
		// addDedupePlan();
		// createAccountType();
		// createIPKCertificateInformation();
		// addStmntMessagePlan();
		// addMktMessagePlan();
		// addPrepaidStmntPlan();
		// addTransactionPlan();
		// createTransactionLimitPlan();
		// createDocChkList();
		// addBusinessmandFields();
		// addDeviceTemplate();
		// addDeviceJoining();
		// addDeviceBasedFeePlan();
		// addDevicePlanPrepaid();
		// createWalletFeePLan();
		// createWalletPLan();
		// createEmbossPriorityPass();
		// createEmbossTemplate();
		// addVendor();
		// createProgram();
		// addDeviceRange();
		// createBulkDeviceReq();

	}

	public void createEmbossPriorityPass() {
		// When user creates EmbossingPriorityPass
		waitForElementVisible(menusubmenuPage.getCardManagement());
		menuSubMenuPage.clickMenuSubOption(menuSubMenuPage.getInstitutionParameterSetup(),
				menuSubMenuPage.getEmbossingParameters());
		embossingPriorityPassPage.addembossingprioritypass(MapUtils.fnGetInputDataFromMap("embossPriorityPassDesc"),
				MapUtils.fnGetInputDataFromMap("ProductType"),
				MapUtils.fnGetInputDataFromMap("embossPriorityInterchange"),
				MapUtils.fnGetInputDataFromMap("embossPriority"));
	}

	public void createBulkDeviceReq() {
		// When user creates BulkDeviceRequest
		waitForElementVisible(menusubmenuPage.getCardManagement());
		menuSubMenuPage.clickMenuSubOption(menuSubMenuPage.getActivity(), menuSubMenuPage.getDeviceMenu());
		bulkdevReq.createBulkDeviceRequest(MapUtils.fnGetInputDataFromMap("ProductType"),
				MapUtils.fnGetInputDataFromMap("Program"), MapUtils.fnGetInputDataFromMap("QuantityType"));

	}

	public void editEmbossingTemplate(String excelName) throws InterruptedException {
		clickMenuSubOption(menuSubMenuPage.getInstitutionParameterSetup(), menuSubMenuPage.getEmbossingParameters());
		embossingTemplatePage.editEmbossTemplate(MapUtils.fnGetInputDataFromMap("LegalType"), excelName);
	}

	public void RunBulkDeviceGenBatch() {
		menuSubMenuPage.clickMenuSubOption(menuSubMenuPage.getOperation(), menuSubMenuPage.getProcessingBatches());
		menuSubMenuPage.getBulkDeviceGeneration().click();
		bulkDeviceGenerationBatchPage.addbulkdevicegenerationbatch(MapUtils.fnGetInputDataFromMap("ProductType"),
				MapUtils.fnGetInputDataFromMap("BatchNumber"));

	}

	public void RunPreProductionBatch() {
		menuSubMenuPage.clickMenuSubOption(menuSubMenuPage.getOperation(), menuSubMenuPage.getProcessingBatches());
		preProductionBatchPage.preproduction(MapUtils.fnGetInputDataFromMap("ProductType"),
				MapUtils.fnGetInputDataFromMap("BatchNumber"));
	}

	public void RunDeviceProductionBatch() {
		menuSubMenuPage.clickMenuSubOption(menuSubMenuPage.getOperation(), menuSubMenuPage.getProcessingBatches());
		deviceProductionPage.deviceproduction(MapUtils.fnGetInputDataFromMap("ProductType"),
				MapUtils.fnGetInputDataFromMap("BatchNumber"), MapUtils.fnGetInputDataFromMap("DeviceNumber"));
	}

	public void readGPGEncryptedEmbossedFile() throws JSchException, IOException {
		String fileName;
		Session session = LinuxUtils.connectSession(env.getProperty("virgostellar.server.username"),
				env.getProperty("virgostellar.server.ip"), env.getProperty("virgostellar.server.password"), 2222);
		fileName = LinuxUtils.listFilesInDirectory(session, env.getProperty("virgostellar.server.embossingOutput.dir"),
				"output.txt");
		LinuxUtils.copyFilesfromServer(session, env.getProperty("devcloud.server.copycommand"), fileName,
				System.getProperty("user.dir") + "\\TempFiles\\fileNames.csv");
		fileName = CustomUtils.readTextFromFile(System.getProperty("user.dir") + "\\TempFiles\\fileNames.csv");
		LinuxUtils.navigateAndGetGPGFile(session, env.getProperty("virgostellar.server.decryptcommand"), fileName);
		LinuxUtils.copyFilesfromServer(session, env.getProperty("virgostellar.server.copycommand"), fileName,
				System.getProperty("user.dir") + "\\TempFiles\\" + fileName);

		CustomUtils.verifyHeaderTrailerPattern(System.getProperty("user.dir") + "\\TempFiles\\" + fileName);
		CustomUtils.verifyEmbossedFileRecord(System.getProperty("user.dir") + "\\TempFiles\\" + fileName);
	}

	public void copyFileFromRemoteToLocal() throws JSchException, IOException {
		String fileName;
		Session session = LinuxUtils.connectSession(env.getProperty("virgostellar.server.username"),
				env.getProperty("virgostellar.server.ip"), env.getProperty("virgostellar.server.password"), 2222);
		fileName = LinuxUtils.listFilesInDirectory(session, env.getProperty("virgostellar.server.embossingOutput.dir"),
				"output.txt");
		LinuxUtils.copyFilesfromServer(session, env.getProperty("devcloud.server.copycommand"), fileName,
				System.getProperty("user.dir") + "\\TempFiles\\fileNames.csv");
		fileName = CustomUtils.readTextFromFile(System.getProperty("user.dir") + "\\TempFiles\\fileNames.csv");
		LinuxUtils.copyFilesfromServer(session, env.getProperty("virgostellar.server.copycommand"), fileName,
				System.getProperty("user.dir") + "\\TempFiles\\" + fileName);
		CustomUtils.verifyHeaderTrailerPattern(System.getProperty("user.dir") + "\\TempFiles\\" + fileName);
		FileUtils.validatebatchFile(System.getProperty("user.dir") + "\\TempFiles\\" + fileName);

		// CustomUtils.verifyEmbossedFileRecord(System.getProperty("user.dir") +
		// "\\TempFiles\\" + fileName);
	}

}
