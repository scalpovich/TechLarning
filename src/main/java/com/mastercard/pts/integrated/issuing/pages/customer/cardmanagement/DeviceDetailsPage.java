package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_SEARCH,
		CardManagementNav.L2_SEARCH_DEVICE, CardManagementNav.L3_DEVICE_DETAILS })

public class DeviceDetailsPage extends AbstractCardManagementPage {

	private static final Logger logger = LoggerFactory.getLogger(DeviceDetailsPage.class);

	private String statusText = "";
	
	private String txtClientCode = "Client Code";

	@Autowired
	private TestContext context;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//ul/li/a[contains(text(),'EMV-Scripting Details')]")
	private MCWebElement emvScriptingDetailsTab;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//ul/li/a[contains(text(),'Client & Wallet Information')]")
	private MCWebElement clientAndWalletInfoTab;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='applicationNumber']")
	private MCWebElement applicationNumberTxt;

	@PageElement(findBy = FindBy.ID, valueToFind = "lastExecutedScriptStatus")
	private MCWebElement lastExecutedScriptStatus;
	
	private static final String APPLICATION_NUMBER_COLUMN_NAME = "Application Number";

	@Override
	public void verifyUiOperationStatus() {
		logger.info("Device Details");
		verifySearchButton("Search");
	}

	public String verifyLastExecutedScriptStatusFromDeviceDetails() {
		Device device = context.get(ContextConstants.DEVICE);
		enterText(deviceNumber, device.getDeviceNumber());
		clickSearchButton();
		viewFirstRecord();
		runWithinPopup("View Device Details", () -> {
			clickWhenClickable(emvScriptingDetailsTab);
			statusText = lastExecutedScriptStatus.getText();
			if (statusText.contains("-"))
			{
			 statusText="Empty";
			}
			clickCloseButton();
		});
		return statusText;
	}
	
	public void retriveDeviceApplicationNumber(Device device) {
		enterText(deviceNumber, device.getDeviceNumber());
		clickSearchButton();
		viewFirstRecord();
		runWithinPopup("View Device Details", () -> {
			clickWhenClickable(clientAndWalletInfoTab);
			device.setApplicationNumber(getFirstRecordCellTextByColumnName(APPLICATION_NUMBER_COLUMN_NAME));
			clickCloseButton();
		});
		logger.info("device application number :{}",device.getApplicationNumber());
	}
	
	public String getClientCode() {
		Device device = context.get(CreditConstants.APPLICATION);
		WebElementUtils.enterText(applicationNumberTxt, device.getApplicationNumber());
		clickSearchButton();
		waitForRow();
		device.setClientCode(getCellTextByColumnName(1, txtClientCode));
		return device.getClientCode();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(deviceNumber),
				WebElementUtils.elementToBeClickable(applicationNumber),
				WebElementUtils.elementToBeClickable(batchCreateNum));
	}
}