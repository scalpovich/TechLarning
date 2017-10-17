package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_HSM_KEY,
		CardManagementNav.L3_DEVICE_KEYS
		})
public class DeviceKeysPage extends AbstractBasePage {
	
	private static final Logger logger = LoggerFactory.getLogger(DeviceKeysPage.class);
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=bincrBinInf]")
	private MCWebElement bincrBinInf;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=bincrBinSup]")
	private MCWebElement bincrBinSup;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=bincrCardtyp]")
	private MCWebElement bincrCardtyp;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement generationMethod;
	
	public void verifyUiOperationStatus() {
		logger.info("Device Keys");
		verifyUiOperation("Add Device Keys");
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(bincrBinInf),
				WebElementUtils.elementToBeClickable(bincrBinSup),
				WebElementUtils.elementToBeClickable(bincrCardtyp),
				WebElementUtils.elementToBeClickable(generationMethod)
				);
	}
}
