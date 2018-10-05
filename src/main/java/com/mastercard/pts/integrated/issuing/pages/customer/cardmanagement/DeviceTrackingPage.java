package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
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

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=batchNumber]")
	private MCWebElement batchNumberTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[text()= 'Pin Carrier Details']")
	private MCWebElement pinCarierDetailsTab;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id= 'statusDelvPin']//span[@class='labelselectf']")
	private MCWebElement carrierStatusTxt;
	
	private String carrierStatus;
	
	public void verifyUiOperationStatus() {
		logger.info("Device Tracking");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(cardNumberTxt), WebElementUtils.elementToBeClickable(clientCodeTxt),
				WebElementUtils.elementToBeClickable(cbsClientIdTxt), WebElementUtils.elementToBeClickable(batchNumberTxt));
	}
	

	public String searchInDeviceTrackingWithDeviceAndCarrierStatus(Device device)
	{
		
		WebElementUtils.enterText(cardNumberTxt, device.getDeviceNumber());
		clickSearchButton();
		SimulatorUtilities.wait(2000);
		viewFirstRecord();
		runWithinPopup("View Device Tracking", () -> {
			clickWhenClickable(pinCarierDetailsTab);
			SimulatorUtilities.wait(1000);
			carrierStatus = carrierStatusTxt.getText();
			clickCloseButton();
		});
		
		return carrierStatus;	

	}
}
