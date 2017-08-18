package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_SEARCH, CardManagementNav.L2_SEARCH_DEVICE,
		CardManagementNav.L3_DEVICE_DETAILS})

public class DeviceDetailsPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory
			.getLogger(DeviceDetailsPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=deviceNumber]")
	private MCWebElement deviceNumberTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=applicationNumber]")
	private MCWebElement applicationNumberTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=batchCreateNum]")
	private MCWebElement batchCreateNumTxt;

	public void verifyUiOperationStatus() {
		logger.info("Device Details");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(deviceNumberTxt),
				WebElementUtils.elementToBeClickable(applicationNumberTxt),
				WebElementUtils.elementToBeClickable(batchCreateNumTxt)
				);
	}
}