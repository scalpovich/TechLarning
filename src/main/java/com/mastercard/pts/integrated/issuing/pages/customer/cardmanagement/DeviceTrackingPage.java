package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;


import javax.validation.constraints.AssertTrue;

import org.junit.Assert;
import org.mockito.internal.verification.AtMost;
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
	private MCWebElement cardNumberTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=clientCode]")
	private MCWebElement clientCodeTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=cbsClientId]")
	private MCWebElement cbsClientIdTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[text()='Device Embossing and Carrier Details']")
	private MCWebElement deviceEmbossAndCarrierDetailsTab;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='photoCode']/span")
	private MCWebElement photoReferenceNumberLabel;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='embossingFileName']/span")
	private MCWebElement embossingFileNameLabel;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=batchNumber]")
	private MCWebElement batchNumberTxt;

	public void verifyUiOperationStatus() {
		logger.info("Device Tracking");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(cardNumberTxt), WebElementUtils.elementToBeClickable(clientCodeTxt),
				WebElementUtils.elementToBeClickable(cbsClientIdTxt), WebElementUtils.elementToBeClickable(batchNumberTxt));
	}
	
	public void checkForNewFieldsAdded(Device device){
		enterText(batchNumberTxt, device.getBatchNumber());
		clickSearchButton();
		viewFirstRecord();
		runWithinPopup("View Device Tracking", ()->{
			clickWhenClickable(deviceEmbossAndCarrierDetailsTab);
			logger.info("Photo referenceNumber on page", photoReferenceNumberLabel.getText());
			logger.info("Embossing file name", embossingFileNameLabel.getText());
			
			boolean areNewFieldsAdded = device.getApplicationNumber().equals(photoReferenceNumberLabel.getText()) 
					&& !Strings.isNullOrEmpty(embossingFileNameLabel.getText());
			
			Assert.assertTrue("No new fields added",areNewFieldsAdded);
			
			clickCloseButton();
		});
		
	}
}
