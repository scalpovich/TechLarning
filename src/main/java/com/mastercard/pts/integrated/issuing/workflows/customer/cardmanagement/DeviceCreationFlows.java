package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AdminstrationPage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

/**
 * @author E060549
 * 
 *
 */

@Component
public class DeviceCreationFlows extends MenuFlows {

	@Autowired
	AdminstrationPage administrationPage;

	@Autowired
	Navigator navigator;

	public void createNewDevice() throws InterruptedException {
		// createCutOverProfile();
		// addNetworkMembership();
		// addtransactionRegistration();
		// createOffice();
		// createPlasticCode();
		// addPictureCode();
		// addDeviceBIN();
		// addMCG();
		// addDedupePlan();
		// addAccountType();
		// addIPKCertificateInformation();
		// addStmntMessagePlan();
		// addMktMessagePlan();
		// addTransactionPLan();
		// addTransactionLimitPLan();
		// addDocumentCheckList();
		// addBusinessManFields();
		// addDeviceTemplate();
		// addEmbossPriorityPass();
		// addDeviceJoining();
		// addDeviceBasedFeePlan();
		// createEmbossTemplate();
		// addVendor();
		// addDevicePlan();
		// // addWalletPlan();
		// addProgram();
		// addDeviceRange();

	}

	public void enableEncryptionFlag() {
		waitForElementVisible(menuSubMenuPage.getAdministration());
		menuSubMenuPage.getAdministration().click();
		waitForElementVisible(menuSubMenuPage.getAdministrationSetup());
		waitForElementVisible(menuSubMenuPage.getAdministrationSetup());
		menuSubMenuPage.getAdministrationSetup().click();
		waitForElementVisible(menuSubMenuPage.getBatchDefination());
		menuSubMenuPage.getBatchDefination().click();
		waitForElementVisible(administrationPage.getBatchType());
		administrationPage.selectBatchType_Id(MapUtils.fnGetInputDataFromMap("Batch_Type"),
				MapUtils.fnGetInputDataFromMap("Batch_Id"));
		CustomUtils.ThreadDotSleep(2000);
		administrationPage.getSearchButton().click();
		List<WebElement> mcws = getFinder().getWebDriver().findElements(By.xpath("//table[@class='dataview']//tr"));
		waitForElementsVisible(mcws);
		getFinder().getWebDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		editBatchDefination(Constants.BATCH_NAME);
	}

	public void editBatchDefination(String BatchName) {
		WebElement edit = getFinder().getWebDriver().findElement(
				By.xpath("//td[contains(.,'" + BatchName + "')]/following::a[1]/img[@alt='Edit Record'] "));
		waitForElementVisible(edit);
		edit.click();
		administrationPage.swithToFrame(Constants.EDIT_BATCH_DEFINITION);
		administrationPage.checkEncryptionRequired();
		administrationPage.getPublicKey().sendKeys("mastercard");
		administrationPage.getConfirmPublicKey().sendKeys("mastercard");
		administrationPage.getSaveButtonPopup().click();
		getFinder().getWebDriver().switchTo().defaultContent();
		CustomUtils.ThreadDotSleep(2000);
	}

	public void addEmbossPriorityPass() {
		// When user creates EmbossingPriorityPass
		waitForElementVisible(menusubmenuPage.getCardManagement());
		menuSubMenuPage.clickMenuSubOption(menuSubMenuPage.getInstitutionParameterSetup(),
				menuSubMenuPage.getEmbossingParameters());
		embossingPriorityPassPage.addembossingprioritypass(MapUtils.fnGetInputDataFromMap("embossPriorityPassDesc"),
				MapUtils.fnGetInputDataFromMap("ProductType"),
				MapUtils.fnGetInputDataFromMap("embossPriorityInterchange"),
				MapUtils.fnGetInputDataFromMap("embossPriority"));
	}

	public void createEmbossTemplate() {
		// When user creates EmbossingTemplate
		clickMenuSubOption(menuSubMenuPage.getInstitutionParameterSetup(), menuSubMenuPage.getEmbossingParameters());
		embossingTemplatePage.addembossingtemplate(MapUtils.fnGetInputDataFromMap("Embosscode"),
				MapUtils.fnGetInputDataFromMap("EmbossDesc"), MapUtils.fnGetInputDataFromMap("EmbossFileType"),
				MapUtils.fnGetInputDataFromMap("sequenceNo"), MapUtils.fnGetInputDataFromMap("EmbossingField"),
				MapUtils.fnGetInputDataFromMap("EmbossTempField"), MapUtils.fnGetInputDataFromMap("Priority"));

	}

	public void addNewDevice() {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		clickMenuSubOption(menuSubMenuPage.getActivity(), menuSubMenuPage.getDeviceMenu());
		menuSubMenuPage.getNewDevice().click();
		newDevicePage.createNewDevice();

	}

}