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
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ClientDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_ACTIVITY,
		CardManagementNav.L2_CLIENT, CardManagementNav.L3_UPDATE_CLIENT_DETAILS })
public class UpdateClientDetailsPage extends AbstractBasePage {

	@Autowired
	TestContext testContext;

	private static final Logger logger = LoggerFactory.getLogger(UpdateClientDetailsPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=clientCode]")
	private MCWebElement clientCodeTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=cbsClientId]")
	private MCWebElement cbsClientIdTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=firstName]")
	private MCWebElement firstNameTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=lastName]")
	private MCWebElement lastNameTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[text()='Branch Code']/following-sibling::td/select")
	private MCWebElement branchCodeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "vipFlag:input:dropdowncomponent")
	private MCWebElement vipFlagDdwn;

	public void verifyUiOperationStatus() {
		logger.info("Update Client Details");
		verifySearchButton("Search");
	}

	public void searchByClientCode(String clientCode) {
		WebElementUtils.enterText(clientCodeTxt, clientCode);
		clickSearchButton();
	}

	public void editClient(ClientDetails clientDetails) {
		Device device = testContext.get(ContextConstants.DEVICE);
		searchByClientCode(device.getClientCode());
		editFirstRecord();
		runWithinPopup("Edit Client", () -> updateClient(clientDetails));		
	}

	private void updateClient(ClientDetails clientDetails) {
		selectByVisibleText(vipFlagDdwn, clientDetails.getClientType());
		clickSaveButton();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(clientCodeTxt),
				WebElementUtils.elementToBeClickable(cbsClientIdTxt),
				WebElementUtils.elementToBeClickable(firstNameTxt), WebElementUtils.elementToBeClickable(lastNameTxt),
				WebElementUtils.elementToBeClickable(branchCodeDDwn));
	}
}
