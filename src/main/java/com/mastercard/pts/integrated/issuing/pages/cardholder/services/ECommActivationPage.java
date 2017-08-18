package com.mastercard.pts.integrated.issuing.pages.cardholder.services;

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
@Navigation(tabTitle = ServicesNav.TAB_SERVICES, treeMenuItems = { ServicesNav.L1_E_COMM_ACTIVATION })
public class ECommActivationPage extends AbstractModelPage {
	private static final Logger logger = LoggerFactory.getLogger(ECommActivationPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.ID, valueToFind = "EcomInput1")
	private MCWebElement ecomInput1Rbtn;

	@PageElement(findBy = FindBy.ID, valueToFind = "EcomInput0")
	private MCWebElement ecomInput0Rbtn;

	@PageElement(findBy = FindBy.ID, valueToFind = "ActivateTypeActivation in Period")
	private MCWebElement activateTypeActivationInPeriodRbtn;

	@PageElement(findBy = FindBy.ID, valueToFind = "ActivateTypeImmediate Activation for n Hrs")
	private MCWebElement activateTypeImmediateActivationForNHrsRbtn;

	@PageElement(findBy = FindBy.ID, valueToFind = "ActivateTypeLife Long Activate")
	private MCWebElement activateTypeLifeLongActivateRbtn;

	public void verifyUiOperationStatus() {
		logger.info("E-Comm Activation");
		verifyTitleCardHolderPortal("E-Comm Activation");
		verifyWalletDetails();
		verifyDeviceDetails();
		verifyButton("Submit");
		verifyButton("Cancel");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(ecomInput1Rbtn),
				WebElementUtils.visibilityOf(ecomInput0Rbtn), WebElementUtils.visibilityOf(activateTypeActivationInPeriodRbtn),
				WebElementUtils.visibilityOf(activateTypeImmediateActivationForNHrsRbtn), WebElementUtils.visibilityOf(activateTypeLifeLongActivateRbtn));
	}
}
