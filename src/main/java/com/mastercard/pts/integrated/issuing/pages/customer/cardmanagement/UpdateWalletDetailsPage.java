package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WalletDetails;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_ACTIVITY, CardManagementNav.L2_WALLET,
		CardManagementNav.L3_UPDATE_WALLET_DETAILS })
public class UpdateWalletDetailsPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(UpdateWalletDetailsPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=walletNumber]")
	private MCWebElement walletNumberTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=deviceNumber]")
	private MCWebElement deviceNumberTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=clientCode]")
	private MCWebElement clientCodeTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=registeredMobileNumber]")
	private MCWebElement registeredMobileNumberTxt;
	
	@PageElement(findBy = FindBy.ID, valueToFind = "limitStatus")
	private MCWebElement limitAndStatusTab;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "accAdmStatus:input:dropdowncomponent")
	private MCWebElement administrativeDDwn;

	public void verifyUiOperationStatus() {
		logger.info("Update Wallet Details");
		verifySearchButton("Search");
	}
	
	public void enterWalletNumber(String walletNumber) {
		WebElementUtils.enterText(walletNumberTxt, walletNumber);
	}
	
	public void searchWalletUsingWalletNumber(WalletDetails updateWalletDetails) {
		enterWalletNumber(updateWalletDetails.getWalletNumber());
		clickSearchButton();
	}
	
	public void changeWalletAdminStatus(WalletDetails updateWalletDetails) {
		WebElementUtils.selectDropDownByVisibleText(administrativeDDwn, updateWalletDetails.getAdminStatus());
	}
	
	public void updateWalletAdminStatus(WalletDetails updateWalletDetails) {
		editFirstRecord();
		SimulatorUtilities.wait(1000);
		runWithinPopup("Edit Wallet", () -> {			
			WebElementUtils.elementToBeClickable(limitAndStatusTab);
			clickWhenClickable(limitAndStatusTab);
			SimulatorUtilities.wait(700);
			changeWalletAdminStatus(updateWalletDetails);
			SimulatorUtilities.wait(700);
			clickSaveButton();
		});
		verifyOperationStatus();
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(walletNumberTxt), WebElementUtils.elementToBeClickable(deviceNumberTxt),
				WebElementUtils.elementToBeClickable(clientCodeTxt), WebElementUtils.elementToBeClickable(registeredMobileNumberTxt));
	}
}
