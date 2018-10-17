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
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP, CardManagementNav.L2_STATUS,
		CardManagementNav.L3_ADMINISTRATIVE })
public class AdministartivePage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(AdministartivePage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=status]")
	private MCWebElement status;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=wording]")
	private MCWebElement wording;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement authorizationResponse;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:2:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement editAuthorizationResponseDDwn;

	public void verifyUiOperationStatus() {
		logger.info("Audit Configuration");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(status),
				WebElementUtils.elementToBeClickable(wording),
				WebElementUtils.elementToBeClickable(authorizationResponse));
	}

	public void updateAdministrativeSetting(String status, String response) {
		enterText(wording, status);
		clickSearchButton();
		SimulatorUtilities.wait(2000);
		runWithinPopup("Edit Administrative Status", () -> {
			selectByVisibleText(editAuthorizationResponseDDwn, response);
			clickSaveButton();
		});
		verifyOperationStatus();
	}
}
