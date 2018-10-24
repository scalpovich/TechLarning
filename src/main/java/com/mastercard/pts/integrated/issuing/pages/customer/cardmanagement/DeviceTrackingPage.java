package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


import com.google.common.base.Strings;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_ACTIVITY, CardManagementNav.L2_DEVICE,
		CardManagementNav.L3_DEVICE_TRACKING })
public class DeviceTrackingPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(DeviceTrackingPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=cardNumber]")
	private MCWebElement txtCardNumber;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=clientCode]")
	private MCWebElement txtClientCode;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=cbsClientId]")
	private MCWebElement txtCbsClientId;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[text()='Device Embossing and Carrier Details']")
	private MCWebElement tabDeviceEmbossAndCarrierDetails;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='photoCode']/span")
	private MCWebElement lablPhotoReferenceNumber;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='embossingFileName']/span")
	private MCWebElement lablEmbossingFileName;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=batchNumber]")
	private MCWebElement txtBatchNumber;

	public void verifyUiOperationStatus() {
		logger.info("Device Tracking");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(txtCardNumber), WebElementUtils.elementToBeClickable(txtClientCode), WebElementUtils.elementToBeClickable(txtCbsClientId), WebElementUtils.elementToBeClickable(txtBatchNumber));
	}

	public void checkForNewFieldsAdded(Device device) {
		enterText(txtBatchNumber, device.getBatchNumber());
		clickSearchButton();
		viewFirstRecord();
		runWithinPopup("View Device Tracking", () -> {
			clickWhenClickable(tabDeviceEmbossAndCarrierDetails);
			logger.info("Photo referenceNumber on page", lablPhotoReferenceNumber.getText());
			logger.info("Embossing file name", lablEmbossingFileName.getText());
			boolean areNewFieldsAdded = device.getApplicationNumber().equals(lablPhotoReferenceNumber.getText()) && !Strings.isNullOrEmpty(lablEmbossingFileName.getText());
			Assert.assertTrue("No new fields added", areNewFieldsAdded);
			clickCloseButton();
		});
	}
}
